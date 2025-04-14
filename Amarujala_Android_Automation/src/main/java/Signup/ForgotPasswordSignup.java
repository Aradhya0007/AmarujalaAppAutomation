package Signup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basetest.Abstract;
import io.appium.java_client.android.AndroidDriver;

public class ForgotPasswordSignup extends Abstract {
    AndroidDriver driver;

    // Locator.............................................
    // Forgot Password Btn
    @FindBy(xpath = "//android.widget.TextView[@text='पासवर्ड भूल गए हैं?']")
    WebElement ForgotPassSignup;

    // validation msg if we write invalid number 
    @FindBy(xpath = "//android.widget.TextView[@text='कृपया एक वैध ईमेल/फोन नंबर दर्ज करें']")
    WebElement ValidationMsgForgotSignup;

    // submit btn 
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='सबमिट']")
    WebElement SubmitBtnForgotBtnSignup;

    // enter otp    
    @FindBy(xpath="(//android.widget.TextView[@text='-'])[1]")
    WebElement EnterotpSignup;    

    // otp submit btn
    @FindBy(xpath="//android.view.ViewGroup[@content-desc=\"ओटीपी सत्यापित करें\"]")
    WebElement SubmitOtpSignup;    

    public ForgotPasswordSignup(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ForgotPassflow(String numoremail) throws InterruptedException {

        // Click forgot password
        click(ForgotPassSignup, "Forgot Password Button");

        Thread.sleep(2000);

        WebElement EnterNumberSignup = driver.findElement(By.xpath("//android.widget.EditText"));

        // Invalid input - short number
        sendKeys(EnterNumberSignup, "123458", "Forgot Password Input Field");
        click(SubmitBtnForgotBtnSignup, "Submit Button");
        assertDisplayed(ValidationMsgForgotSignup, "Validation Message for Invalid Number");
        clear(EnterNumberSignup, "Forgot Password Input Field");

        // Invalid input - long number
        sendKeys(EnterNumberSignup, "1232323323458", "Forgot Password Input Field");
        click(SubmitBtnForgotBtnSignup, "Submit Button");
        assertDisplayed(ValidationMsgForgotSignup, "Validation Message for Invalid Number");
        clear(EnterNumberSignup, "Forgot Password Input Field");

        // Valid input
        sendKeys(EnterNumberSignup, numoremail, "Forgot Password Input Field");
        click(SubmitBtnForgotBtnSignup, "Submit Button");

        // Enter OTP
        click(EnterotpSignup, "Enter OTP Field");
        enterOtpUsingKeyboard("123456");
        driver.hideKeyboard();
        click(SubmitOtpSignup, "Submit OTP Button");

        // Profile screen
        profiledetailsignup ProfileDetails = new profiledetailsignup(driver);
        ProfileDetails.ProfilevalidationSignup();
    }
}
