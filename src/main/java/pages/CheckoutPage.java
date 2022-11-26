package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase
{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement selectCountry;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement citytxt;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address1txt;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement ziptxt;
	
	@FindBy(id ="BillingNewAddress_PhoneNumber")
	WebElement phonetxt;
	
	@FindBy(name = "save")
	WebElement continueBtn;
	
	@FindBy(css= "button.button-1.shipping-method-next-step-button")
	WebElement shipingContinueBtn;
	
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	WebElement paymentContinueBtn;
	
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	WebElement paymentinfoContinueBtn;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	WebElement confirmBtn;
	
	@FindBy(css = "div.title")
	public WebElement ordersuccessfullcheckout;//Your order has been successfully processed!
	
	@FindBy(css = "button.button-1.order-completed-continue-button")
	WebElement ordercompletedContinueBtn;
	
	public void CheckoutProduct(String country, String City, String address, String zipcode, String phone) {
		Select select = new Select(selectCountry);
		select.selectByVisibleText(country);
		
		setText(citytxt, City);
		setText(address1txt, address);
		setText(ziptxt, zipcode);
		setText(phonetxt, phone);
		
		clickButton(continueBtn);
		clickButton(shipingContinueBtn);
		clickButton(paymentContinueBtn);
		clickButton(paymentinfoContinueBtn);
		clickButton(confirmBtn);
		clickButton(ordercompletedContinueBtn);
	}

}
