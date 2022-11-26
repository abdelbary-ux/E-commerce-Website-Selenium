package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("abdo", "nasser", "abcde8@yahoo.com", "123456789");
		Assert.assertTrue(registerObject.successmsg.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = {"userCanRegisterSuccessfully"})
	public void userCanLogout() {
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods = {"userCanLogout"})
	public void RegisterduserCanLoginSuccessfully() {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin("abcde8@yahoo.com", "123456789");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
