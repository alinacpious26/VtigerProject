package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VerificationClass {

	@Test
	public void verify() {

		Assert.assertEquals(true, true);
		Assert.assertEquals(5, 5);
		Assert.assertEquals("Sneha", "Sneha");

		Assert.assertNotEquals(7, 3);
		Assert.assertNotEquals(true, false);
		Assert.assertNull(null);
		Assert.assertNotNull("Hari");
		Assert.assertTrue(true);
		Assert.assertFalse(false);

//	Assert.fail();

	}

}
