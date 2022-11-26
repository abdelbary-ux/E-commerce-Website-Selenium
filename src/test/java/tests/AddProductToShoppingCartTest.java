package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase
{
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartObject;
	
	@Test(priority = 1)
	public void userCanSearchWithAutoSuggest() {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("macB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
	@Test(priority = 2)
	public void userCanAddProductsToShoopingCart() throws InterruptedException {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.AddToShoppingCart();
		Thread.sleep(2000);
		driver.navigate().to(BaseURL + "cart");
	}
	
	@Test(priority = 3)
	public void userCanUpdateShoppingCart() throws InterruptedException{
		cartObject = new ShoppingCartPage(driver);
		cartObject.updateShoppingCartQuantity("5");
		Assert.assertTrue(cartObject.totalprice.getText().contains("9,000.00"));
		Thread.sleep(3000);
	}
	
	@Test(priority = 4)
	public void userCanDelteCart() {
		cartObject.emptyShoppingcart();
	}
}
