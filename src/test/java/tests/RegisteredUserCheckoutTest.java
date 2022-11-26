package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegisteredUserCheckoutTest extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	CheckoutPage outObject;
	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("abdo", "nasser", "abcdefjfj8@yahoo.com", "123456789");
		Assert.assertTrue(registerObject.successmsg.getText().contains("Your registration completed"));
	}
	
	
	
	@Test(priority =2)
	public void userCanSearchWithAutoSuggest() {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("macB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
	
	@Test(priority =3)
	public void userCanAddProductsToShoopingCart() throws InterruptedException {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToShoppingCart();
		Thread.sleep(2000);
		driver.navigate().to(BaseURL + "cart");
		cartObject = new ShoppingCartPage(driver);
		cartObject.openCheckoutPage();
	}
	@Test(priority = 4)
	public void useCanCheckout() {
		outObject = new CheckoutPage(driver);
		outObject.CheckoutProduct("Egypt", "Giza", "asdrdgdffb", "12345", "12345678901");
		//Assert.assertTrue(outObject.ordersuccessfullcheckout.getText().contains("Your order has been successfully processed!"));
	}
}
