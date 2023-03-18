package steps;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import page.LoginPage;
import page.NewAccountPage;
import page.SideNavigation;
import util.BrowserFactory;

public class LoginSteps {
	WebDriver driver;
	LoginPage loginPage;
	SideNavigation sideNavigation;
	NewAccountPage newAccountPage;
	
	@Before
	public void startFirst() {
		driver = BrowserFactory.startBrowser();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		sideNavigation = PageFactory.initElements(driver, SideNavigation.class);
		newAccountPage = PageFactory.initElements(driver, NewAccountPage.class);
	}
	
	@Given("^a user with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void a_user_with_username_and_password(String userName, String password) {
		loginPage.login(userName, password);
	}
	
	@When("^user navigates to New Account Page$")
	public void user_navigates_to_New_Account_Page() throws InterruptedException {
	   sideNavigation.goToNewAccountPage();
	}
	
	@Then("^New Account page should display$")
	public void new_Account_page_should_display() {
		Assert.assertTrue("Page not found", newAccountPage.isPanelHeaderDisplayed());
	}
	
	@When("^user creates a new account using title \"([^\"]*)\" Description \"([^\"]*)\" Amount \"([^\"]*)\"$")
	public void user_creates_a_new_account_using_title_Description_Amount(String title, String description, String amount) throws InterruptedException {
		Thread.sleep(1000);
		newAccountPage.inputAccountTitle(title + new Random().nextInt(999));
		newAccountPage.inputDescription(description);
		newAccountPage.inputAmount(amount);
		newAccountPage.clickOnSubmitButton();
		Thread.sleep(3000);
	}
	
	@After
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
}

