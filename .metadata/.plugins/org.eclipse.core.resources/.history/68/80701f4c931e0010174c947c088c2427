package login;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Signup.signupflowmakenewaccount;
import basetest.Abstract;
import io.appium.java_client.android.AndroidDriver;

public class Popuplogin extends Abstract {
	AndroidDriver driver;

	public Popuplogin(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locator 

	// change number 
	@FindBy(xpath = "//android.widget.TextView[@text='मोबाइल नंबर बदलें']")
	WebElement ChangeNumberloginAndSignup;

	// enter opt container
	@FindBy(xpath = "(//android.widget.TextView[@text='-'])[1]")
	WebElement EnterotploginAndSignup;

	// otp submit btn
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"ओटीपी सत्यापित करें\"]")
	WebElement SubmitOtploginAndSignup;

	// enter mobile number 
	@FindBy(xpath = "//android.widget.EditText")
	WebElement EnterMobileNumberLoginAndSignup;

	// submit the number 	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"सबमिट\"]")
	WebElement SubmitloginAndSignup;

	// msg if invalid number is field 
	@FindBy(xpath = "//android.widget.TextView[@text=\"कृपया एक वैध नंबर डालें\"]")
	WebElement ValidationNumberMsgPopupSignuploginAndSignup;

	// validation msg when we have filled otp less then 6 digit 
	@FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message' and @text='Please enter valid OTP']")
	WebElement ValidationOtpMsgpPopuploginAndSignup;

	// when otp is six digit but it is invalid
	@FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message' and @text='Invalid OTP']")
	WebElement ValidationErrorPopuploginAndSignup;

	// ok btn
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	WebElement OKBtnPopuploginAndSignup;

	// block otp error in msg
	@FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/message' and @text='Account blocked, Please try after few minutes']")
	WebElement BlockErrorMsgloginAndSignup;

	public void PopupBasedLoginAndSignup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// blank
		click(SubmitloginAndSignup, "Submit Button (Blank Number)");
		assertDisplayed(ValidationNumberMsgPopupSignuploginAndSignup, "Validation Msg - Blank Mobile");

		// invalid number less than 10 digit
		Thread.sleep(2000);
		sendKeys(EnterMobileNumberLoginAndSignup, "123456784", "Mobile Number Field");
		click(SubmitloginAndSignup, "Submit Button (Short Number)");
		assertDisplayed(ValidationNumberMsgPopupSignuploginAndSignup, "Validation Msg - Short Mobile Number");
		clear(EnterMobileNumberLoginAndSignup, "Mobile Number Field");

		// Correct number 
		sendKeys(EnterMobileNumberLoginAndSignup, "1234567899", "Mobile Number Field");
		click(SubmitloginAndSignup, "Submit Button (Correct Number)");

		// otp validation 
		otpcheckinpopwindow();

		// change number
		click(ChangeNumberloginAndSignup, "Change Number Button");

		// CHECK WITH SAME NUMBER ...To Fix
		// EnterMobileNumberLoginAndSignup.sendKeys("1234567899");
		// SubmitloginAndSignup.click();

		clear(EnterMobileNumberLoginAndSignup, "Mobile Number Field");
		sendKeys(EnterMobileNumberLoginAndSignup, "1234567888", "Mobile Number Field");
		click(SubmitloginAndSignup, "Submit Button (Second Number)");
		click(EnterotploginAndSignup, "OTP Container");
		enterOtpUsingKeyboard("123456");
		driver.hideKeyboard();
		click(SubmitOtploginAndSignup, "Submit OTP Button");
	}

	public void otpcheckinpopwindow() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		for (int i = 0; i < 5; i++) {

			// first keeping blank
			if (i == 0) {
				Thread.sleep(2000);
				driver.hideKeyboard();
				click(SubmitOtploginAndSignup, "Submit OTP Button (Blank)");
				Thread.sleep(2000);
				assertDisplayed(ValidationOtpMsgpPopuploginAndSignup, "Validation Msg - Blank OTP");
				click(OKBtnPopuploginAndSignup, "OK Button (Blank OTP)");
			}

			// otp less than 6 digit
			if (i == 1) {
				Thread.sleep(2000);
				click(EnterotploginAndSignup, "OTP Container");
				enterOtpUsingKeyboard("1234");
				driver.hideKeyboard();
				click(SubmitOtploginAndSignup, "Submit OTP Button (Short OTP)");
				assertDisplayed(ValidationOtpMsgpPopuploginAndSignup, "Validation Msg - OTP < 6 digit");
				click(OKBtnPopuploginAndSignup, "OK Button (Short OTP)");
				clearotp();
			}

			// invalid 6 digit otp
			if (i == 2) {
				click(EnterotploginAndSignup, "OTP Container");
				enterOtpUsingKeyboard("123444");
				driver.hideKeyboard();
				click(SubmitOtploginAndSignup, "Submit OTP Button (Invalid OTP)");
				assertDisplayed(ValidationErrorPopuploginAndSignup, "Validation Msg - Invalid OTP");
				click(OKBtnPopuploginAndSignup, "OK Button (Invalid OTP)");
				clearotp();
			}

			// after 3 wrong OTP Account block error pop up
			if (i == 3) {
				clear(EnterotploginAndSignup, "OTP Container");
				enterOtpUsingKeyboard("123444");
				driver.hideKeyboard();
				click(SubmitOtploginAndSignup, "Submit OTP Button - Attempt 1");
				assertDisplayed(ValidationErrorPopuploginAndSignup, "Validation Msg - Wrong OTP 1");
				click(OKBtnPopuploginAndSignup, "OK Button - Attempt 1");

				click(SubmitOtploginAndSignup, "Submit OTP Button - Attempt 2");
				assertDisplayed(ValidationErrorPopuploginAndSignup, "Validation Msg - Wrong OTP 2");
				click(OKBtnPopuploginAndSignup, "OK Button - Attempt 2");

				click(SubmitOtploginAndSignup, "Submit OTP Button - Attempt 3");
				assertDisplayed(BlockErrorMsgloginAndSignup, "Block Error Msg - 3 Attempts Failed");
				click(OKBtnPopuploginAndSignup, "OK Button - Block Message");
			}
		}
	}
}


