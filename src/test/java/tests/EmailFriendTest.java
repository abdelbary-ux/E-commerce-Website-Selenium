package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase
{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailFriendPage emailObject;
	
	//1- user registration
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("abdo", "nasser", "abcde200@yahoo.com", "123456789");
		Assert.assertTrue(registerObject.successmsg.getText().contains("Your registration completed"));
	}
	
	// 2- user search for product
	
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest() {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("macB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		
	}
	
	// 3- email a friend
	
	@Test(priority = 3)
	public void RegistereduserCanSendProductToFriend() {
		detailsObject.openSendEmail();
		emailObject = new EmailFriendPage(driver);
		emailObject.sendEmailtoFriend("afas@casca", "zzvxvzvdbsvdsv");
		Assert.assertTrue(emailObject.successMSG.getText().contains("Your message has been sent."));
	}
	
	
	// 4- user logout
	@Test(priority = 4)
	public void userCanLogout() {
		registerObject.userLogout();
	}
}
