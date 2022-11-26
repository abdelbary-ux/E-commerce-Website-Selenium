package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
	    homeObject = new HomePage(driver);
	    homeObject.openRegistrationPage();
	}
	@When("I click on register link")
	public void i_click_on_register_link() {
	   Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("I entered user credintials")
	public void i_entered_user_credintials() {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("saso", "hoby", "saso@myloovee.com", "123456");
	}
	@Then("The registration completed successfully")
	public void the_registration_completed_successfully() {
	    registerObject.userLogout();
	}
}
