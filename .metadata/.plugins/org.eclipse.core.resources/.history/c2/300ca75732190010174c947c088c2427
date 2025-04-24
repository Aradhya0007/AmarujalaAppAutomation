package pagevalidation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import basetest.Abstract;
import io.appium.java_client.android.AndroidDriver;

public class ArticleStatus extends Abstract {
    AndroidDriver driver;
    Set<String> openedKeys = new HashSet<>();
    Set<String> processedUrls = new HashSet<>();

    public ArticleStatus(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void validateArticlesUntilTodayEnds() throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        int maxScrolls = 25;
        int scrollCount = 0;
        String todayDate = getTodayFormattedInHindi();

        while (scrollCount < maxScrolls) {
            boolean foundNewArticle = false;
            boolean reachedOldDate = false;

            // Get all article containers
            List<WebElement> articleContainers = driver.findElements(By.xpath(
                "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup" +
                "[.//android.widget.TextView[1] and .//android.widget.TextView[2]]"
            ));

            for (WebElement container : articleContainers) {
                try {
                    // Get title and date elements
                    WebElement titleElement = container.findElement(By.xpath(".//android.widget.TextView[1]"));
                    WebElement dateElement = container.findElement(By.xpath(".//android.widget.TextView[2]"));

                    String title = titleElement.getText().trim();
                    String date = dateElement.getText().replace("•", "").trim();

                    // Skip if not today's article
                    if (!date.contains(todayDate)) {
                        System.out.println("🚨 Reached older article: " + date);
                        reachedOldDate = true;
                        break;
                    }

                    // Skip if title is empty or already processed
                    String key = title + "|" + date;
                    if (title.isEmpty() || openedKeys.contains(key)) {
                        continue;
                    }

                    // Skip video/shorts cards
                    if (isVideoCard(container)) {
                        System.out.println("🎥 Skipping video/shorts card: " + title);
                        continue;
                    }

                    // Ensure title is visible and clickable
                    if (!titleElement.isDisplayed()) {
                        System.out.println("👻 Skipping invisible title: " + title);
                        continue;
                    }

                    openedKeys.add(key);
                    foundNewArticle = true;
                    System.out.println("🔍 Processing: " + title + " (" + date + ")");

                    // Click the title element to open the article
                    titleElement.click();
                    Thread.sleep(3000);

                    // Handle consent popup if appears
                    handleConsentPopup();

                    // Process the article URL
                    processArticleUrl();

                    // Go back to article list
                    driver.navigate().back();
                    Thread.sleep(2000);
                    break;

                } catch (Exception e) {
                    System.out.println("❌ Error processing card: " + e.getMessage());
                    continue;
                }
            }

            if (reachedOldDate) break;

            if (!foundNewArticle) {
                System.out.println("🔄 Scrolling for more articles...");
                swipeUp();
                Thread.sleep(3000);
                scrollCount++;
            }
        }
        System.out.println("✅ Finished processing articles");
    }

    private boolean isVideoCard(WebElement container) {
        try {
            // Check for video indicators
            boolean hasVideoText = container.findElements(By.xpath(
                ".//*[contains(@text, 'शॉर्ट') or contains(@text, 'वीडियो') or contains(@text, 'Shorts') or contains(@text, 'Video')]"
            )).size() > 0;

            // Check for video duration indicators
            boolean hasDuration = container.findElements(By.xpath(
                ".//*[contains(@text, ':') and string-length(@text) <= 5]"
            )).size() > 0;

            return hasVideoText || hasDuration;
        } catch (Exception e) {
            return false;
        }
    }

    private void handleConsentPopup() {
        try {
            WebElement consentButton = driver.findElement(By.xpath("//*[@text='Consent']"));
            if (consentButton.isDisplayed()) {
                consentButton.click();
                System.out.println("✅ Clicked consent button");
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            // No consent popup found
        }
    }

    private void processArticleUrl() {
        try {
            // Switch to WebView context
            String targetContext = driver.getContextHandles().stream()
                .filter(c -> c.toLowerCase().contains("webview"))
                .findFirst()
                .orElse(null);

            if (targetContext == null) {
                System.out.println("⚠️ No WebView context found");
                return;
            }

            driver.context(targetContext);
            System.out.println("🔄 Switched to: " + targetContext);

            Thread.sleep(2000); // Wait for WebView to load

            String url = driver.getCurrentUrl();
            if (url == null || url.isEmpty()) {
                System.out.println("❌ Empty URL");
                return;
            }

            // Check for duplicate URLs
            if (processedUrls.contains(url)) {
                System.out.println("♻️ Duplicate URL: " + url);
                return;
            }

            processedUrls.add(url);
            System.out.println("🔗 Unique URL: " + url);

            // Check URL status
            int status = getUrlStatus(url);
            System.out.println("⚡ Status: " + status);

        } catch (Exception e) {
            System.out.println("❌ URL processing failed: " + e.getMessage());
        } finally {
            // Always switch back to native context
            driver.context("NATIVE_APP");
        }
    }

    private String getTodayFormattedInHindi() {
        Locale hindi = new Locale("hi", "IN");
        return new SimpleDateFormat("dd MMMM", hindi).format(new Date());
    }

    private int getUrlStatus(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000);
            return connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("❌ URL check failed: " + e.getMessage());
            return -1;
        }
    }
}
