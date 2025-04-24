package user;

import java.time.Duration;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Signup.TypesOfSignup;
import basetest.Basecode;
import basetest.ExtentLogger;
import epaper.Navigation_of_epaper;
import login.TypesOfLogin;
import pagevalidation.ArticleStatus;
import pagevalidation.NavigateToListingPages;

@Listeners(basetest.Listeners.class)
public class AutomationAos extends Basecode {
//	@Test(priority = 1)
//	public void signup() throws InterruptedException {
//	    ExtentLogger.logInfo("Signup test started");
//
//	    TypesOfSignup Signup = new TypesOfSignup(driver);
//
//	    try {
//	        ExtentLogger.logInfo("Starting Number Signup");
//	        Signup.NumberSignup();
//
//	        ExtentLogger.logInfo("Starting Forgot Password Signup");
//	        Signup.ForgotPassSignup();
//
//	        ExtentLogger.logPass("✅ Signup test completed successfully");
//
//	    } catch (Exception e) {
//	        ExtentLogger.logFail("❌ Signup test failed: " + e.getMessage());
//	        throw e;
//	    }
//	}
//
//	@Test(priority = 2, dependsOnMethods = "signup")
//	public void login() throws InterruptedException {
//	    ExtentLogger.logInfo("Login test started");
//
//	    TypesOfLogin Login = new TypesOfLogin(driver);
//
//	    try {
//	        ExtentLogger.logInfo("Starting Password Login");
//	        Login.PasswordLogin();
//
//	        ExtentLogger.logInfo("Starting Number Login");
//	        Login.NumberLogin();
//
//	        ExtentLogger.logInfo("Starting Popup Login");
//	        Login.PopupLogin();
//
//	        ExtentLogger.logPass("✅ Login test completed successfully");
//
//	    } catch (Exception e) {
//	        ExtentLogger.logFail("❌ Login test failed: " + e.getMessage());
//	        throw e;
//	    }
//	    
//	    
//	}
	@Test  
	public void Epaper() throws Exception { 
		
		Navigation_of_epaper navigate=new Navigation_of_epaper(driver);
		navigate.navigate_epaper();
	}
	
	
//	@Test
//	public void epaper() throws InterruptedException {
//		Navigation_of_epaper Epaper=new Navigation_of_epaper(driver);
//		Epaper.navigate_epaper();
//	}
}