package testPackage;

import org.testng.annotations.Test;

public class ParameterTestClass {

	@Test
	public void getDataFromMaven() {

		String un = System.getProperty("username");
		String pwd = System.getProperty("password");

		System.out.println(un);
		System.out.println(pwd);

	}

}
