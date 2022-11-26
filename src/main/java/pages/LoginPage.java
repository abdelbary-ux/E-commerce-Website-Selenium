package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "Email")
	WebElement Email;
	
	@FindBy(id = "Password")
	WebElement Password;
	
	/*
	 * @FindBy(id = "RememberMe") WebElement RememberMe;
	 */
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")
	WebElement Loginbtn;
	
	
	
	public void userLogin(String email, String pass) {
		setText(Email, email);
		setText(Password, pass);
		//clickButton(RememberMe);
		clickButton(Loginbtn);
	}

}
