package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandProperitiesFileTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String fn = LoadProperties.userData.getProperty("firstname");
	String ln = LoadProperties.userData.getProperty("lastname");
	String email = LoadProperties.userData.getProperty("email");
	String pass = LoadProperties.userData.getProperty("password");
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(fn, ln, email, pass);
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
		loginObject.userLogin(email, pass);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
