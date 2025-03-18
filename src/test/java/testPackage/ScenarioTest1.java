package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class ScenarioTest1 extends BaseClass {

	@Test(groups = "adhoc")
	public void moveToContactsPage() {
		hp.clickContactsLink();
		System.out.println("adhoc2");
	}

	@Test(groups = "smoke")
	public void moveToLeadsPage() {
		hp.clickLeadsLink();
		System.out.println("smoke2");
	}
}
