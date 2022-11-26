package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddToCompareTest extends TestBase
{
	String fProductName = "Apple MacBook Pro 13-inch";
	String sProductName = "Asus N551JK-XO076H Laptop";
	
	//1- search for product n1
	//2- search for product n2
	//3- Add to compare
	//4- clear list
	
	
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	ComparePage compareObject;
	SearchPage searchObject;
	
	
	@Test
	public void userCanCompareProducts() {
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new ComparePage(driver);
		searchObject = new SearchPage(driver);
		
		searchObject.ProductSearchUsingAutoSuggest("macB");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(fProductName));
		detailsObject.addProductToCompare();
		
		searchObject.ProductSearchUsingAutoSuggest("asus");
		Assert.assertTrue(detailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(sProductName));
		detailsObject.addProductToCompare();
		
		driver.navigate().to(BaseURL + "compareproducts");
		compareObject.compareProducts();
		
		compareObject.clearCompareList();
	}
}
