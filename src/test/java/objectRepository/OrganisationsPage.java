package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class OrganisationsPage {

	// declaration

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationIcon;

	@FindBy(name = "accountname")
	private WebElement organizationNameTextField;

	@FindBy(id = "employees")
	private WebElement employeesTextField;

	@FindBy(name = "industry")
	private WebElement industryDropdown;

	@FindBy(name = "accounttype")
	private WebElement industrytypeDropdown;

	@FindBy(id = "phone")
	private WebElement phoneNumberTextField;

	@FindBy(id = "email1")
	private WebElement emailTextField;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement saveButton;

	@FindBy(xpath = "(//input[@type='button'])[2]")
	private WebElement cancelButton;

	// intialization

	public OrganisationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public void createOrganization() {
		createOrganizationIcon.click();
	}

	public void enterOrganizationName(String text) {
		organizationNameTextField.sendKeys(text);
	}

	public void enterEmployees(String employee) {
		employeesTextField.sendKeys(employee);
	}

	public void selectIndustry(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleText(industryDropdown, text);
	}

	public void selectIndustryType(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleText(industrytypeDropdown, text);
	}

	public void enterPhoneNumber(String number) {
		phoneNumberTextField.sendKeys(number);
	}

	public void enterEmail(String email) {
		emailTextField.sendKeys(email);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickCancelButton() {
		cancelButton.click();
	}

}
