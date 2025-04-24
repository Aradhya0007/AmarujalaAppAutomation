package login;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basetest.Abstract;
import io.appium.java_client.android.AndroidDriver;

public class NumberPassLogin extends Abstract {
	AndroidDriver driver;
	public NumberPassLogin(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locator......
	
		//enter email and number conatiner 
			@FindBy(xpath="(//android.widget.EditText)[1]")
			WebElement EmailLogin;
			
			//enter password
			@FindBy(xpath="(//android.widget.EditText)[2]")
			WebElement PasswordLogin;

	        //validation msg when invalid/blank email/num
			@FindBy(xpath="//android.widget.TextView[@text=\"कृपया एक वैध ईमेल/फोन नंबर दर्ज करें\"]")
			WebElement InvalidEmailValidationMsgLogin;
			
			//validation msg when invalid/blank Password
			@FindBy(xpath="//android.widget.TextView[@text=\"कृपया पासवर्ड दर्ज करें\"]")
			WebElement InvalidPasswordValidationMsfLogin;
			
			//watch the pass
			@FindBy(xpath="//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[2]")
			WebElement WatchPassLogin;
			
			//login kare
			@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"लॉगइन करें\"]")
			WebElement SubmitLoginLogin;
			
			//when incorrect email or pass is filled msg popup
			@FindBy(xpath="//android.widget.TextView[@text=\"Please enter a valid email & password. Or click on Forgot Password to reset the password.\"]")
			WebElement IncorrectPopupMsgLogin;
			
			//ok btn
			@FindBy(xpath="//android.widget.TextView[@text=\"OK\"]")
			WebElement OKbtnOfPopupLogin;
			
			//Blocked validation msg 
			@FindBy(xpath="//android.widget.TextView[@text=\"Account blocked, Please try after few minutes\"]")
			WebElement BlockedValidationMsgLogin;
			
			
			
			public void loginwithNumberPassflow() throws InterruptedException {
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			    // Blank fields
			    Thread.sleep(2000);
			    click(SubmitLoginLogin, "Submit Login (Blank Fields)");
			    assertDisplayed(InvalidEmailValidationMsgLogin, "Validation Message for Blank Email/Phone");
			    assertDisplayed(InvalidPasswordValidationMsfLogin, "Validation Message for Blank Password");

			    // Invalid email, valid password
			    sendKeys(EmailLogin, "9999999", "Email/Phone Field (Invalid)");
			    sendKeys(PasswordLogin, "Test22@", "Password Field (Valid)");
			    click(WatchPassLogin, "Eye Icon (Watch Password)");
			    click(SubmitLoginLogin, "Submit Login (Invalid Email)");
			    assertDisplayed(InvalidEmailValidationMsgLogin, "Validation Message for Invalid Email");
			    clear(EmailLogin, "Email/Phone Field");
			    clear(PasswordLogin, "Password Field");

			    // Valid email, invalid password
			    sendKeys(EmailLogin, "932409239", "Email/Phone Field (Valid)");
			    sendKeys(PasswordLogin, "Test", "Password Field (Invalid)");
			    click(SubmitLoginLogin, "Submit Login (Invalid Password)");
			    assertDisplayed(InvalidPasswordValidationMsfLogin, "Validation Message for Invalid Password");
			    clear(EmailLogin, "Email/Phone Field");
			    clear(PasswordLogin, "Password Field");

			    // Wrong email & wrong password
			    sendKeys(EmailLogin, "94939430", "Email/Phone Field (Wrong)");
			    sendKeys(PasswordLogin, "Test221@", "Password Field (Wrong)");
			    click(SubmitLoginLogin, "Submit Login (Wrong Email/Password)");
			    assertDisplayed(IncorrectPopupMsgLogin, "Popup: Invalid Credentials");
			    click(OKbtnOfPopupLogin, "Popup OK Button");
			    clear(EmailLogin, "Email/Phone Field");
			    clear(PasswordLogin, "Password Field");

			    // Wrong number, correct password
			    sendKeys(EmailLogin, "9027827275", "Email/Phone Field (Wrong)");
			    sendKeys(PasswordLogin, "Amresh@123", "Password Field (Correct)");
			    click(SubmitLoginLogin, "Submit Login (Wrong Number)");
			    assertDisplayed(IncorrectPopupMsgLogin, "Popup: Invalid Credentials");
			    click(OKbtnOfPopupLogin, "Popup OK Button");
			    clear(EmailLogin, "Email/Phone Field");
			    clear(PasswordLogin, "Password Field");

			    // Correct number, wrong password
			    sendKeys(EmailLogin, "9027827274", "Email/Phone Field (Correct)");
			    sendKeys(PasswordLogin, "Amresh@12", "Password Field (Wrong)");
			    click(SubmitLoginLogin, "Submit Login (Wrong Password)");
			    assertDisplayed(IncorrectPopupMsgLogin, "Popup: Invalid Credentials");
			    click(OKbtnOfPopupLogin, "Popup OK Button");

			    // Simulate repeated failures → Blocked message
			    click(SubmitLoginLogin, "Submit Login (Fail 1)");
			    assertDisplayed(IncorrectPopupMsgLogin, "Popup: Invalid Credentials");
			    click(OKbtnOfPopupLogin, "Popup OK Button");

			    click(SubmitLoginLogin, "Submit Login (Fail 2)");
			    assertDisplayed(IncorrectPopupMsgLogin, "Popup: Invalid Credentials");
			    click(OKbtnOfPopupLogin, "Popup OK Button");

			    click(SubmitLoginLogin, "Submit Login (Fail 3)");
			    assertDisplayed(BlockedValidationMsgLogin, "Popup: Account Blocked Message");
			    click(OKbtnOfPopupLogin, "Popup OK Button");

			    // Final correct flow
			    sendKeys(EmailLogin, "902782724", "Email/Phone Field (Correct Final)");
			    sendKeys(PasswordLogin, "Test@123", "Password Field (Correct Final)");
			    click(SubmitLoginLogin, "Submit Login (Success Case)");
			}

			

}
