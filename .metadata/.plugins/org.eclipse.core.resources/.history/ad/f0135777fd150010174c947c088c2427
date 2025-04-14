package login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Signup.signupflowmakenewaccount;
import basetest.Abstract;
import io.appium.java_client.android.AndroidDriver;

public class LoginOtpFlow extends Abstract {
	AndroidDriver driver;
	public LoginOtpFlow(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//enter mobile number 
	@FindBy(xpath="//android.widget.EditText")
	WebElement EnterMobileNumberLogin;
	
	//click on otp genrate btn
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='ओटीपी जनरेट करें']")
	WebElement GenrateOtpLogin;
	
	//validation msg btn
	@FindBy(xpath="//android.widget.TextView[@text=\"कृपया अपना 10 अंकों का मोबाइल नंबर दर्ज करें\"]")
	WebElement MsgBtnLogin;
	
	//change number 
		@FindBy(xpath="//android.widget.TextView[@text='मोबाइल नंबर बदलें']")
		WebElement ChangeNumberLogin;
	
		
		//enter opt container
		@FindBy(xpath="(//android.widget.TextView[@text='-'])[1]")
		WebElement EnterotpLogin;
		
		//otp submit btn
		@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"ओटीपी सत्यापित करें\"]")
		WebElement SubmitOtpLogin;
	
	
	public void otploginflow() throws InterruptedException {
		//blank number
		GenrateOtpLogin.click();
		Assert.assertTrue(MsgBtnLogin.isDisplayed(),"validation msg is not coming in case of invalid otp");
		//invalid number less then 10 digit
		Thread.sleep(2000);
		EnterMobileNumberLogin.sendKeys("123456789");
		GenrateOtpLogin.click();
		Assert.assertTrue(MsgBtnLogin.isDisplayed(),"validation msg is not coming in case of invalid otp");
		EnterMobileNumberLogin.clear();
		//Correct number 
		EnterMobileNumberLogin.sendKeys("1234567899");
		GenrateOtpLogin.click(); 
		//otp validation 
		signupflowmakenewaccount otpcheck=new signupflowmakenewaccount(driver);
		otpcheck.OtpValidationField("login");
		//number change button click
		ChangeNumberLogin.click();
		
		//need to work error................the number is blocked and we click again to genrate otp it is is giving 505
		//GenrateOtpLogin.click();
		
		
		//valid flow 
		
		EnterMobileNumberLogin.clear();
		EnterMobileNumberLogin.sendKeys("1234567888");
		GenrateOtpLogin.click();
		EnterotpLogin.click();
		enterOtpUsingKeyboard("123456");
		driver.hideKeyboard();
		SubmitOtpLogin.click();
		
		//validate after word
		
	}

}
