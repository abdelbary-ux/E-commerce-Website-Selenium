package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddReviewPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddReviewPage reviewObject;
	
	
	//1- user registration
	
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("abdo", "nasser", "abcde8jh565@yahoo.com", "123456789");
		Assert.assertTrue(registerObject.successmsg.getText().contains("Your registration completed"));
	}
	
	//2- search for a product
	
	@Test(priority = 2)
	public void userCanSearchWithAutoSuggest() {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("macB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
	
	//3- access details page to add review
	
	@Test(priority = 3)
	public void userCanOpenProductDetails() {
		detailsObject.openAddReviewPage();
	}
	
	//4- add review
	
	@Test(priority = 4)
	public void userCanAddReview() {
		reviewObject = new AddReviewPage(driver);
		reviewObject.addProductReview("tilte of review", "hello from message review");
		Assert.assertTrue(reviewObject.asserttxt.getText().contains("hello from message review"));
	}
	
	@Test(priority = 5)
	public void userCanLogout() {
		registerObject.userLogout();
	}
}
