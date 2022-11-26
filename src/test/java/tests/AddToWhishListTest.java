package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToWishListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToWhishListTest extends TestBase
{
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	AddToWishListPage whishlistObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test
	public void userCanSearchWithAutoSuggest() {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("macB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
	
	@Test
	public void userCanAddProductToWhislist() {
		detailsObject = new ProductDetailsPage(driver);
		detailsObject.addProducttoWishlist();
		driver.navigate().to(BaseURL + "wishlist");
		whishlistObject = new AddToWishListPage(driver);
		whishlistObject.removeProductFromCart();
		Assert.assertTrue(whishlistObject.empty.getText().contains("empty"));
	}
}
