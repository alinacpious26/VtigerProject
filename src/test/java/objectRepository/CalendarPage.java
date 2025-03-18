package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.GenericUtilities;

public class CalendarPage {
	GenericUtilities gu;

	// Declaration

	@FindBy(className = "calAddButton")
	private WebElement addButton;

	@FindBy(linkText = "Call")
	private WebElement callLink;

	@FindBy(id = "activitytype")
	private WebElement eventTypeDropdown;

	@FindBy(name = "subject")
	private WebElement eventNameTextField;

	@FindBy(name = "description")
	private WebElement descriptionTextArea;

	@FindBy(name = "location")
	private WebElement locationTextField;

	@FindBy(id = "eventstatus")
	private WebElement eventStatusDropdown;

//	@FindBy(id="taskpriority")
//	private WebElement ;

	// Initialization

	// Utilization
	public void mouseHoverAddNewEvent(WebDriver driver) {
		gu = new GenericUtilities();
		gu.mouseHoverOn(driver, addButton);
	}

	public void selectCall(String text) {
		gu.selectOptionByVisibleText(callLink, text);

	}

	public void selectEventType(String text) {
		gu.selectOptionByVisibleText(eventTypeDropdown, text);
	}

	public void eventNameTextField(String text) {
		eventNameTextField.sendKeys(text);
	}

	public void enterDescription(String text) {
		
		descriptionTextArea.sendKeys(text);
	
}

}
