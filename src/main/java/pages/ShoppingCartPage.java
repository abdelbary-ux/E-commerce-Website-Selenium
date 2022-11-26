package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "updatecart")
	WebElement removeitem;
	
	@FindBy(className = "qty-input")
	WebElement quantitytxt;
	
	@FindBy(css= "span.product-subtotal")
	public WebElement totalprice;
	
	@FindBy(id ="updatecart")
	WebElement updateShoppingCartbtn;
	
	@FindBy(id ="termsofservice")
	WebElement termsBtn;
	
	@FindBy(id= "checkout")
	WebElement checkoutBtn;
	
	@FindBy(css ="div.no-data")
	WebElement noDatalbl;
	
	public void emptyShoppingcart() {
		clickButton(removeitem);
	}
	
	public void updateShoppingCartQuantity(String quantity) {
		quantitytxt.clear();
		setText(quantitytxt, quantity);
		clickButton(updateShoppingCartbtn);
	}
	
	public void openCheckoutPage() {
		clickButton(termsBtn);
		clickButton(checkoutBtn);
	}

}
