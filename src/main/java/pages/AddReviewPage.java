package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase{

	public AddReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewtitletxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewtext;
	
	@FindBy(id= "addproductrating_3")
	WebElement rate;
	
	@FindBy(name = "add-review")
	WebElement submitbtn;
	
	@FindBy(css= "div.text-body")
	public WebElement asserttxt;
	
	
	public void addProductReview(String title, String review_text) {
		setText(reviewtitletxt, title);
		setText(reviewtext, review_text);
		clickButton(rate);
		clickButton(submitbtn);
	}
	

}
