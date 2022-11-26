package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	MyAccountPage myaccObject;
	LoginPage loginObject;
	String fname = "abdo";
	String lname = "nasser";
	String email = "a14@yahoo.com";
	String opass = "123456789";
	String npass = "123456";
	
	@Test(priority = 1)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(fname, lname, email, opass);
		Assert.assertTrue(registerObject.successmsg.getText().contains("Your registration completed"));
	}
	@Test(priority = 2)
	public void registerdUserCanChangePass() {
		myaccObject = new MyAccountPage(driver);
		registerObject.openMyAcc();
		myaccObject.changepassword();
		myaccObject.ChangePassword(opass, npass);
		Assert.assertTrue(myaccObject.successMsg.getText().contains("Password was changed"));
		myaccObject.closeSuccessMsg();
	}
	
	@Test(priority = 3)
	public void userCanLogout() {
		registerObject.userLogout();
	}
	
	@Test(priority = 4)
	public void RegisterduserCanLoginSuccessfully() {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, npass);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
}
