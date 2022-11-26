package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Change password")
	public WebElement changePass;
	
	@FindBy(id = "OldPassword")
	WebElement oldPass;
	
	@FindBy(id = "NewPassword")
	WebElement newPass;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNew;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button")
	WebElement changePassBtn;
	
	@FindBy (css = "p.content")
	public WebElement successMsg;
	
	@FindBy(className = "close")
	WebElement closeSuccess;
	
	public void changepassword() {
		clickButton(changePass);
	}
	
	public void ChangePassword(String old, String New) {
		setText(oldPass, old);
		setText(newPass, New);
		setText(confirmNew, New);
		clickButton(changePassBtn);
	}
	
	public void closeSuccessMsg() {
		clickButton(closeSuccess);
	}
	
	

}
