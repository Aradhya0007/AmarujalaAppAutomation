package user;

import java.time.Duration;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Signup.TypesOfSignup;
import basetest.Basecode;
import login.TypesOfLogin;

@Listeners(basetest.Listeners.class)
public class AutomationAos extends Basecode {
	  @Test(priority = 1)
	    public void signup() throws InterruptedException {
		  TypesOfSignup Signup=new TypesOfSignup(driver);
		  Signup.NumberSignup();
		  Signup.ForgotPassSignup();
		 }
	  
	   
	  @Test(priority = 2)
	  public void login() throws InterruptedException {
		  TypesOfLogin Login=new TypesOfLogin(driver);
		  Login.PasswordLogin();
		  Login.NumberLogin();
		  Login.PopupLogin();
	  }
    
} 
 