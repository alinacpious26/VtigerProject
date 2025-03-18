package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import objectRepository.CalendarPage;
import objectRepository.ContactsPage;
import objectRepository.HomePage;
import objectRepository.LeadsPage;
import objectRepository.LoginPage;
import objectRepository.OrganisationsPage;

@Listeners(ListenersClass.class)
public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	public WebDriverUtilities wu;
	public LoginPage lp;
	public HomePage hp;
	public ContactsPage cp;
	public OrganisationsPage op;
	public LeadsPage lsp;
	public CalendarPage cap;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void login(String browser) {

		wu = new WebDriverUtilities();

		// launch the browser
		driver = wu.launchBrowser(browser);
		sdriver=driver;

		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		cp = new ContactsPage(driver);
		op = new OrganisationsPage(driver);
		lsp = new LeadsPage(driver);
		cap = new CalendarPage();

		wu.maximizeBrowser(driver);
		wu.impicitWait(driver, 10);
		wu.pageLoadingWait(driver, 30);

		// pass the url
		wu.passURL(driver);

		// login
		lp.enterUsername();
		lp.enterPassword();
		lp.clickLoginButton();

	}

	@AfterMethod(alwaysRun = true)
	public void logout() {

		// logout
		hp.signOutLink(driver);

		// close the browser
		wu.closeBrowser(driver);

	}

}
