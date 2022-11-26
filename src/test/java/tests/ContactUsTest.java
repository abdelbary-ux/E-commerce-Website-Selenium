package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage homeObject;
	ContactUsPage contactObject;
	
	String name="asfd";
	String email = "asvasv@fdgdfb";
	String msg = "sdgsdggfbfbdds";
	
	@Test
	public void UserCanUseContactUs() {
		homeObject = new HomePage(driver);
		homeObject.openContactUsPage();
		contactObject = new ContactUsPage(driver);
		contactObject.ContactUs(name, email, msg);
		Assert.assertTrue(contactObject.successMsg.getText().contains("Your enquiry has been successfully sent to the store owner."));
		
	}
}
