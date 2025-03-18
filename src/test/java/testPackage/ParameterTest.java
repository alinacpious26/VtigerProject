package testPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	// case sensitive

	@Parameters({ "browser", "username", "password" })
	@Test
	public void scenario3(String browser, String un, String pwd) {///same order should be written which is written in parameters
		System.out.println(browser);
		System.out.println(un);
		System.out.println(pwd);
	}
	

}
