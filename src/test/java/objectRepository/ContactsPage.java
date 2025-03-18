package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericUtilities;

public class ContactsPage {

	// declaration

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactIcon;

	@FindBy(name = "salutationtype")
	private WebElement salutationDropdown;

	@FindBy(name = "firstname")
	private WebElement firstNameTextField;

	@FindBy(name = "lastname")
	private WebElement lastNameTextField;

	@FindBy(name = "leadsource")
	private WebElement leadSrcDropdown;

	@FindBy(id = "title")
	private WebElement titleTextField;

	@FindBy(id = "department")
	private WebElement departmentTextField;

	@FindBy(id = "email")
	private WebElement emailTextField;

	@FindBy(id = "mobile")
	private WebElement mobileTextField;

	@FindBy(xpath = "(//input[@type='submit'])[1]")
	private WebElement saveButton;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement cancelButton;

	// intialization

	public ContactsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// utilization

	public void clickCreateContact() {
		createContactIcon.click();
	}

	public void selectSalutation(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleText(salutationDropdown, text);
	}

	public void enterFirstName(String text) {
		firstNameTextField.sendKeys(text);
	}

	public void enterLastName(String text) {
		lastNameTextField.sendKeys(text);
	}

	public void selectLeadSrc(String text) {
		GenericUtilities gu = new GenericUtilities();
		gu.selectOptionByVisibleText(leadSrcDropdown, text);
	}

	public void enterTitle(String text) {
		titleTextField.sendKeys(text);
	}

	public void enterDepartment(String text) {
		departmentTextField.sendKeys(text);
	}

	public void enterEmail(String email) {
		emailTextField.sendKeys(email);
	}

	public void enterMobileNumber(String number) {
		mobileTextField.sendKeys(number);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickCancelButton() {
		cancelButton.click();
	}

}
