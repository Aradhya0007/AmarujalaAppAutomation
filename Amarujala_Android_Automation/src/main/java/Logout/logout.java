package Logout;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basetest.Abstract;
import io.appium.java_client.android.AndroidDriver;

public class logout extends Abstract {
    AndroidDriver driver;

    public logout(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);  
    }

    // Locator

    // settingbtn
    @FindBy(xpath = "//android.widget.TextView[@text='सेटिंग']")
    WebElement Settingbtn;

    // logoutbtn
    @FindBy(xpath = "//android.widget.TextView[@text='लॉगआउट']")
    WebElement Logoutbtn;

    // Logoutkaremsgbtn
    @FindBy(xpath = "(//android.widget.TextView[@text='लॉगआउट'])[1]")
    WebElement Logoutkaremsgbtn;

    // Close signup page
    @FindBy(xpath = "//android.widget.TextView[@text='अभी नहीं']")
    WebElement CloseSignupPage;

    public void logoutflow() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
        menu();
        scrollUntilElementVisible(By.xpath("//android.widget.TextView[@text='सेटिंग']"), 2, "up");
        click(Settingbtn, "Settings Button");
        scrollUntilElementVisible(By.xpath("//android.widget.TextView[@text='लॉगआउट']"), 2, "up");
        click(Logoutbtn, "Logout Button");
        click(Logoutkaremsgbtn, "Logout Confirm Button");
        click(CloseSignupPage, "Close Signup Page Button");
    }
}
