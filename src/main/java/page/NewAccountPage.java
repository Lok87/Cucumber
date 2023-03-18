package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountPage {
	WebDriver driver;

	// Every Page must have a constructor to invite the driver
	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
//	Account title     ID      account
//	Description      ID       description
//	Initial Balance    ID      balance
//	Submit Button      //label[text()='Initial Balance']/../following-sibling::button

	// Element Library
	@FindBy(how = How.XPATH, using = "//h5[contains(text(), 'Add Old Account')]")
	WebElement PanelHeaderElement;
	@FindBy(how = How.ID, using = "account")
	WebElement AccountTitleField;
	@FindBy(how = How.ID, using = "description")
	WebElement DescriptionField;
	@FindBy(how = How.ID, using = "balance")
	WebElement InitialBalanceField;
	@FindBy(how = How.XPATH, using = "//label[text()='Initial Balance']/../following-sibling::button")
	WebElement SubmitButton;
	
	public void fillInTheNewAccountForm(String accountTitle, String description, String balance) throws InterruptedException {
		Thread.sleep(2000);
		AccountTitleField.sendKeys(accountTitle);
		DescriptionField.sendKeys(description);
		InitialBalanceField.sendKeys(balance);
		Thread.sleep(1000);
		SubmitButton.click();
	}

	public boolean isPanelHeaderDisplayed() {
		try {
			return PanelHeaderElement.isDisplayed();
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}

	public void inputAccountTitle(String title) {
		AccountTitleField.sendKeys(title);
	}

	public void waitForFormToDisplay() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(AccountTitleField));
	}

	public void inputDescription(String description) {
		DescriptionField.sendKeys(description);		
	}

	public void inputAmount(String amount) {
		InitialBalanceField.sendKeys(amount);
	}

	public void clickOnSubmitButton() {
		SubmitButton.click();
	}
}


