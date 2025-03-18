package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class LeadsPage {

	GenericUtilities gu;

	// declaration

	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadIcon;

	@FindBy(name = "salutationtype")
	private WebElement salutationDropdown;

	@FindBy(name = "firstname")
	private WebElement firstNameTextField;

	@FindBy(name = "lastname")
	private WebElement lastNameTextField;

	@FindBy(name = "company")
	private WebElement companyNameTextField;

	@FindBy(id = "designation")
	private WebElement titleTextField;

	@FindBy(name = "leadsource")
	private WebElement leadSrcDropdown;

	@FindBy(name = "industry")
	private WebElement industryDropdown;

	@FindBy(id = "mobile")
	private WebElement mobileNumberTextField;

	@FindBy(id = "email")
	private WebElement emailTextField;

	@FindBy(name = "leadstatus")
	private WebElement leadStatusDropdown;

	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement saveButton;

	@FindBy(xpath = "(//input[@name='button'])[2]")
	private WebElement cancelButton;

	// Initialization

	public LeadsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	// Utilization

	public void createLead() {
		createLeadIcon.click();
	}

	public void selectSalutation(String text) {
		gu = new GenericUtilities();
		gu.selectOptionByVisibleText(salutationDropdown, text);
	}

	public void enterFirstname(String text) {
		firstNameTextField.sendKeys(text);
	}

	public void enterLastname(String text) {
		lastNameTextField.sendKeys(text);
	}

	public void enterCompanyName(String text) {
		companyNameTextField.sendKeys(text);
	}

	public void enterTitle(String text) {
		titleTextField.sendKeys(text);
	}

	public void selectLeadSrc(String text) {
		gu.selectOptionByVisibleText(leadSrcDropdown, text);
	}

	public void selectIndustry(String text) {
		gu.selectOptionByVisibleText(industryDropdown, text);
	}

	public void enterMobileNumber(String number) {
		mobileNumberTextField.sendKeys(number);
	}

	public void enterEmail(String email) {
		emailTextField.sendKeys(email);
	}

	public void selectLeadStatus(String text) {
		gu.selectOptionByVisibleText(leadStatusDropdown, text);

	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickCancelButton() {
		cancelButton.click();
	}

}
