package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class changeCurrencyTest extends TestBase
{
	HomePage homeObject;
	ProductDetailsPage detailsObject;
	SearchPage searchObject;
	String productName = "Apple MacBook Pro 13-inch";
	
	@Test
	public void userCanChangeCurrency() {
		homeObject = new HomePage(driver);
		detailsObject = new ProductDetailsPage(driver);
		homeObject.changeCurrency();
	}
	
	@Test
	public void userCanSearchWithAutoSuggest() {
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("macB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(detailsObject.productPricelbl.getText().contains("€1548.00"));
	}
}
