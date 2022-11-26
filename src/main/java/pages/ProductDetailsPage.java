package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	public WebElement emailAfriendBtn;
	
	@FindBy(id = "price-value-4")
	public WebElement productPricelbl;
	
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addtowishlistbtn;
	
	@FindBy(id= "add-to-cart-button-4")
	WebElement addtocartbtn;
	
	@FindBy(css= "button.button-2.add-to-compare-list-button")
	WebElement addtocomparebtn;
	
	@FindBy(linkText = "Add your review")
	WebElement addreviewbtn;
	
	public void AddToShoppingCart() {
		clickButton(addtocartbtn);
	}
	
	public void openSendEmail() {
		clickButton(emailAfriendBtn);
	}
	
	public void addProducttoWishlist() {
		clickButton(addtowishlistbtn);
	}
	
	public void addProductToCompare() {
		clickButton(addtocomparebtn);
	}
	
	public void openAddReviewPage() {
		clickButton(addreviewbtn);
	}
}
