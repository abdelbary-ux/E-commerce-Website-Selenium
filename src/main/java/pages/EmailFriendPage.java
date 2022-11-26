package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase
{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement friendemailtxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement msgtxt;
	
	@FindBy(name = "send-email")
	WebElement submitBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMSG;
	
	public void sendEmailtoFriend(String femail, String msg) {
		setText(friendemailtxt, femail);
		setText(msgtxt, msg);
		clickButton(submitBtn);
	}
	
	
}
