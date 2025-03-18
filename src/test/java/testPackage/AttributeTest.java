package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class AttributeTest extends BaseClass {
	// first it will give preference to dependency

	@Test(groups = "smoke")
	public void moveToCalendarPage() {
		hp.clickCalendarLink();
		System.out.println("smoke1");
	}

	@Test(groups = "integration"/* , dependsOnGroups = "smoke" */)
	public void moveToLeadsPage() {
		hp.clickLeadsLink();
		System.out.println("integration1");

	}

	@Test(groups = "integration" /* dependsOnGroups = "smoke" */)
	public void moveToOrganisationPage() {
		hp.clickOrganizationsLink();
		System.out.println("integration2");

	}

	@Test(groups = "adhoc")
	public void moveToContactsPage() {
		hp.clickContactsLink();
		System.out.println("adhoc1");

	}
	@Test(groups = "adhoc")
	public void moveToContactsPage1() {
		hp.clickContactsLink();
		System.out.println("adhoc3");
		
	}

}
