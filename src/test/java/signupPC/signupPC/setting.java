package signupPC.signupPC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.codeborne.selenide.WebDriverRunner;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class setting {
	public static WebDriver driver;
	public static String id;

	@BeforeMethod
	public void chromedriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverRunner.setWebDriver(driver);

		id = "autosignup" + time(); // id 생성

	}

	public static String time() {
		// creates a date time stamp that is Windows OS filename compatible
		return new SimpleDateFormat("DDss").format(Calendar.getInstance().getTime());
	}

	public static void opentab() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_T);
	}

	public static void tabfocus() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_TAB);
	}

	public static void closetab() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_W);
	}

	public static void enter() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	public static String getNumber(String code) {
		return code.replaceAll("[^0-9]", "");
	}
}
