package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactusLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencydropdownlist;
	
	@FindBy(linkText = "Computers")
	WebElement computerMenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement NotebookMenu;
	
	public void openRegistrationPage() {
		clickButton(registerLink);
	}
	
	public void openLoginPage() {
		clickButton(loginLink);
	}
	
	public void openContactUsPage() {
		scrollToBottom();
		clickButton(contactusLink);
	}
	
	public void changeCurrency() {
		select = new Select(currencydropdownlist);
		select.selectByVisibleText("Euro");
	}
	
	public void hovermenu() {
		action.moveToElement(computerMenu).moveToElement(NotebookMenu).click().build().perform();
	}

}
