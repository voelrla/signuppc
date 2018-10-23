package signupPC.signupPC;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	public static WebDriver driver;

	@Test
	public void pcsignup() throws AWTException {
		test.signup();
	}

}
