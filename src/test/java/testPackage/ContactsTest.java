package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class ContactsTest extends BaseClass {

	@Test(dataProvider = "databaseContactDetails", dataProviderClass = DataSupply.class)
	public void createcontact(String salutation, String firstname, String lastname, String leadsrc, String title,
			String email, String mobNo, String department) {

		hp.clickContactsLink();

		cp.clickCreateContact();
		cp.selectSalutation(salutation);
		cp.enterFirstName(firstname);
		cp.enterLastName(lastname);
		cp.selectLeadSrc(leadsrc);
		cp.enterTitle(title);
		cp.enterDepartment(department);
		cp.enterEmail(email);
		cp.enterMobileNumber(mobNo);
		cp.clickSaveButton();

	}

}
