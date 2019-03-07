package signupPC.signupPC;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.codeborne.selenide.commands.TakeScreenshot;
import static com.codeborne.selenide.Selenide.screenshot;

/**
 * Unit test for simple App.
 */
public class AppTest extends setting {
	public static WebDriver driver;

	@Test
	public void pcsignup() throws Exception {
		test.signup();
	}

	@AfterMethod
	public void end() {
		screenshot("account");
		System.out.println(id);
	}
}
