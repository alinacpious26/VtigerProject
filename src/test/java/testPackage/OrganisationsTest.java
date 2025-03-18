package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class OrganisationsTest extends BaseClass {

	@Test
	public void createOrganisation() {

		hp.clickOrganizationsLink();

		op.createOrganization();
		op.enterOrganizationName("Renai Medicity");
		op.enterEmployees("300");
		op.selectIndustry("Healthcare");
		op.selectIndustryType("Integrator");
		op.enterPhoneNumber("7894567897");
		op.enterEmail("renaimedicity@gmail.com");
		op.clickSaveButton();
	}

}
