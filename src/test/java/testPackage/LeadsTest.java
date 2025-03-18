package testPackage;

import org.testng.annotations.Test;

import utilities.BaseClass;

public class LeadsTest extends BaseClass {

	@Test
	public void createLead() {

		hp.clickLeadsLink();

		lsp.createLead();
		lsp.selectSalutation("Mrs.");
		lsp.enterFirstname("Goutham");
		lsp.enterLastname("Vinod");
		lsp.enterCompanyName("IDBI");
		lsp.enterTitle("Assistant Manager");
		lsp.selectLeadSrc("Employee");
		lsp.selectIndustry("Banking");
		lsp.enterMobileNumber("7893456757");
		lsp.enterEmail("goutham@gmail.com");
		lsp.selectLeadStatus("Cold");
		lsp.clickSaveButton();
	}

}
