package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToWishListPage extends PageBase{

	public AddToWishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "addtocart")
	WebElement addToCartToDelete;
	
	@FindBy(name = "updatecart")
	WebElement updateCart;
	
	@FindBy(className = "no-data")
	public WebElement empty;
	
	public void removeProductFromCart() {
		clickButton(addToCartToDelete);
		clickButton(updateCart);
	}

}
