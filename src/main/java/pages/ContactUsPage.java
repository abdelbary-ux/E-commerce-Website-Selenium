package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
	WebElement nametxt;
	
	@FindBy(id = "Email")
	WebElement emailtxt;
	
	@FindBy(id = "Enquiry")
	WebElement enquirytxt;
	
	@FindBy(name = "send-email")
	WebElement submit;
	
	@FindBy(className = "result")
	public WebElement successMsg;
	
	public void ContactUs(String fullname, String email, String message) {
		setText(nametxt, fullname);
		setText(emailtxt, email);
		setText(enquirytxt, message);
		clickButton(submit);
	}

}
