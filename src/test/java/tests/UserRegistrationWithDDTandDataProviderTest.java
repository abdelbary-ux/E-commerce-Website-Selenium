package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandDataProviderTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	@DataProvider(name = "testData")
	public static Object[][] userData(){
		return new Object[][] {
			{"MySaso", "ashraf", "mysaso@yahoo.com", "123456789"},
			{"abdo", "nasser", "abdo1@yahoo.com", "123456"}
		};
	}
	
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "testData")
	public void userCanRegisterSuccessfully(String fname, String lname, String email, String password) {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(fname, lname, email, password);
		Assert.assertTrue(registerObject.successmsg.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}
}
