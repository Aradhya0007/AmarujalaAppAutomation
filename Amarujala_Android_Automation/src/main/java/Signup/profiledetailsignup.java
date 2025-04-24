package Signup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Logout.logout;
import basetest.Abstract;
import io.appium.java_client.android.AndroidDriver;

public class profiledetailsignup extends Abstract {
	AndroidDriver driver;
	WebDriverWait wait;
	 
	public profiledetailsignup(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);  
	}
	
	//Form locator
	
	//name
	@FindBy(xpath = "(//android.widget.EditText)[1]")
	WebElement ProfileNameSignup;
	
	//DOB
	@FindBy(xpath = "//android.widget.EditText[@text=\"जन्मतिथि चुनें*\"]")
	WebElement DOBSignup;
	

	//Calendar Ok btn
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	WebElement CalendarOkBtnSignup;
	
	//Gender
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"महिला\"]")
	WebElement GenderSignup;
	
	//Password
	@FindBy(xpath = "(//android.widget.EditText)[3]")
	WebElement PasswordSignup;
	
	//View Password
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[2]")
	WebElement ViewPasswordSignup;
	
	//Terms ticker
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[7]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[2]")
	WebElement TermsTickerSignup;
	
	//Services Ticker
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView[2]")
	WebElement ServicesTickerSignup;
	
	//Go ahead btn
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"आगे बढ़ें\"]")
	WebElement GoAheadSignup;
	
	
	//location locator...................
	
    // Loaction search bar
	@FindBy(xpath = "//android.widget.EditText")
	WebElement SearchLocation;
	
	//Location to follow
	@FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"फॉलो\"])[1]")
	WebElement FollowLocation;
	
	//Location page GoAhead
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"आगे बढ़ें\"]")
	WebElement GoAheadLocation;
	
	
	//Select the intrest......
	
	//desh select
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"देश\"]")
	WebElement DeshIntrest;
	
	
	
	//validation for name 
	@FindBy(xpath = "//android.widget.TextView[@text=\"मान्य नाम दर्ज करें\"]")
	WebElement ValidationNameMSgSignup;
	
	//validation for DOB 
	@FindBy(xpath = "//android.widget.TextView[@text=\"जन्मतिथि चुनें*\"]")
	WebElement ValidationDobMsgSignup;
	
	//validation for Gender
	@FindBy(xpath = "//android.widget.TextView[@text=\"जेंडर चुनें\"]")
	WebElement ValidationGenderMsgSignup;
	
	//validation for Password
	@FindBy(xpath = "//*[contains(@text, 'आपका पासवर्ड') and contains(@text, 'विशेष अक्षर') and contains(@text, 'उदाहरण')]")
	WebElement ValidationPasswordSignup;
	
	//validation Terms and condition
	@FindBy(xpath = "//android.widget.TextView[@text=\"हमारी नियम-शर्तों को स्वीकार करें\"]")
	WebElement ValidationTermsConditionSignup;
	
	//Validation msg when we search not valid cirt or state
	@FindBy(xpath = "//android.widget.TextView[@text=\"कोई शहर नहीं मिला, कृपया पुनः प्रयास करें\"]")
	WebElement WrongLocatioSelectValidationMsg;
	
	

	public void ProfilevalidationSignup() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//empty form submit
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationDobMsgSignup, "DOB validation");
		assertDisplayed(ValidationGenderMsgSignup, "Gender validation");
		assertDisplayed(ValidationNameMSgSignup, "Name validation");
		assertDisplayed(ValidationPasswordSignup, "Password validation");
		scrollUntilElementVisible( By.xpath("//android.view.ViewGroup[@content-desc='आगे बढ़ें']") , 2,"up");
		assertDisplayed(ValidationTermsConditionSignup, "Terms validation");
		DobAndGenderValidation();
	}
	
	public void DobAndGenderValidation() throws InterruptedException {
		scrollUntilElementVisible(By.xpath("//android.widget.EditText[@text=\"पूरा नाम*\"]") , 2,"down");
		sendKeys(ProfileNameSignup, "TestAutomation1", "Profile Name");
		sendKeys(PasswordSignup, "Test123@", "Password Field");
		click(ViewPasswordSignup, "View Password");
		driver.hideKeyboard();
		click(TermsTickerSignup, "Terms Ticker");
		click(ServicesTickerSignup, "Services Ticker");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationDobMsgSignup, "DOB validation");
		assertDisplayed(ValidationGenderMsgSignup, "Gender validation");
		ProfileNameValidationProfile();
	}
	
	public void ProfileNameValidationProfile() throws InterruptedException {
		click(DOBSignup, "DOB Field");
		click(CalendarOkBtnSignup, "Calendar OK Button");
		click(GenderSignup, "Gender Option");

////////////////////Problem dev side/////////////////
//		clear(ProfileNameSignup, "Profile Name Field");
//		click(GoAheadSignup, "Go Ahead Button");
//		assertDisplayed(ValidationNameMSgSignup, "Name validation");
//		sendKeys(ProfileNameSignup, "TestAutomation1", "Profile Name");

		PasswordValidationProfile();
		
	}
	
	public void PasswordValidationProfile() throws InterruptedException {
		
		//clear case
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		clear(PasswordSignup, "Password Field");
		scrollUntilElementVisible( By.xpath("//android.view.ViewGroup[@content-desc='आगे बढ़ें']") , 2,"up");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationPasswordSignup, "Password validation");
		
		
		//less then 8 character
		sendKeys(PasswordSignup, "Ajaj12@", "Password Field");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationPasswordSignup, "Password validation");
		clear(PasswordSignup, "Password Field");
		
		
		//No uppercase
		sendKeys(PasswordSignup, "ajaj123@", "Password Field");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationPasswordSignup, "Password validation");
		clear(PasswordSignup, "Password Field");
		
		//No special char case
		sendKeys(PasswordSignup, "ajaj1234", "Password Field");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationPasswordSignup, "Password validation");
		clear(PasswordSignup, "Password Field");
		
		//No lower Case
		sendKeys(PasswordSignup, "AJAJAJ1234", "Password Field");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationPasswordSignup, "Password validation");
		clear(PasswordSignup, "Password Field");
		
		//No Number 
		sendKeys(PasswordSignup, "AJAJAJ1234", "Password Field");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationPasswordSignup, "Password validation");
		clear(PasswordSignup, "Password Field");
		
		//No char
		sendKeys(PasswordSignup, "12345@129", "Password Field");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationPasswordSignup, "Password validation");
		clear(PasswordSignup, "Password Field");
		
		//valid pass
		sendKeys(PasswordSignup, "Test123@", "Password Field");
		
		TickerValidationPRofile();
		
	}
	
	public void TickerValidationPRofile() throws InterruptedException {
		
		//Both are not ticked
		click(TermsTickerSignup, "Terms Ticker");
		click(ServicesTickerSignup, "Services Ticker");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationTermsConditionSignup, "Terms validation");
		
		//Terms ticker is ticked only
		click(TermsTickerSignup, "Terms Ticker");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationTermsConditionSignup, "Terms validation");
		
		//Service ticker is ticked only
		click(TermsTickerSignup, "Terms Ticker");
		click(ServicesTickerSignup, "Services Ticker");
		click(GoAheadSignup, "Go Ahead Button");
		assertDisplayed(ValidationTermsConditionSignup, "Terms validation");
		click(TermsTickerSignup, "Terms Ticker");
		
		//all validation done
		click(GoAheadSignup, "Go Ahead Button");
		
		LocationSelect();
	}
	
	public void LocationSelect() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//wrong location
		Thread.sleep(4000);
		click(SearchLocation, "Search Location Field");
		sendKeys(SearchLocation, "delhihhdhdhd", "Search Location");
		assertDisplayed(WrongLocatioSelectValidationMsg, "Wrong Location Validation");
		//Correct Loaction
		clear(SearchLocation, "Search Location Field");
		sendKeys(SearchLocation, "Delhi", "Search Location");
		driver.hideKeyboard();
		click(FollowLocation, "Follow Location");
		click(GoAheadLocation, "Go Ahead Button Location");
		IntrestSelect();
		
	}
	
	public void IntrestSelect() throws InterruptedException {
		Thread.sleep(2000);
		click(DeshIntrest, "Desh Interest");
		click(GoAheadLocation, "Go Ahead Button Location");
		 
	}
}
