package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "gender-male")
	WebElement gender;
	
	@FindBy(id = "FirstName")
	WebElement firstName;
	
	@FindBy(id = "LastName")
	WebElement lastName;
	
	@FindBy(id = "Email")
	WebElement Email;
	
	@FindBy(id = "Password")
	WebElement Pass;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPass;
	
	@FindBy(id = "register-button")
	WebElement registerbtn;
	
	@FindBy(className = "result")
	public WebElement successmsg;
	
	@FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account")
	public WebElement myAcc;
	
	public void userRegistration(String firstname, String lastname, String email, String pass) {
		clickButton(gender);
		setText(firstName, firstname);
		setText(lastName,lastname);
		setText(Email, email);
		setText(Pass,pass);
		setText(confirmPass,pass);
		clickButton(registerbtn);
	}
	
	public void userLogout() {
		clickButton(logoutLink);
	}
	
	public void openMyAcc() {
		clickButton(myAcc);
	}

}
