package signupPC.signupPC;

import org.openqa.selenium.By;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import com.codeborne.selenide.SelenideElement;

import java.awt.AWTException;

import static com.codeborne.selenide.Selenide.*;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class test extends setting {

	@Test
	public static void signup() throws AWTException {
		open("http://wemakeprice.com");

		$(By.id("joinTypeBtn")).click(); // 회원가입 버튼 선택
		$(By.xpath("//div[@id='_contents']/div/div/div/a/div/span/span")).click();

		$(By.id("_personalEmailId")).sendKeys("autosignup" + time());
		$(By.id("_personalEmailAddr")).sendKeys("yopmail.com");

		$(By.id("_password")).sendKeys("qwer1234");
		$(By.id("_pwConfirm")).sendKeys("qwer1234");

		$(By.id("_name")).sendKeys("테스트");
		$(By.id("_phone")).sendKeys("01084695633");

		$(By.id("_contentsMember")).click(); // 외부영역 클릭

		List<SelenideElement> checkphone = $$(By.xpath("//div[@id='_phoneConfirm']/p[4]/a/span"));

		if (checkphone.isEmpty() == false) {
			$(By.xpath("//div[@id='_phoneConfirm']/p[4]/a/span")).click();
			confirm("인증번호가 입력하신 번호로 발송되었습니다.");

			opentab(); // 신규 탭 생성
			sleep(2000);

			switchTo().window(1); // 탭 이동
			open("https://www.pushbullet.com/#sms/ujEUBotXlYqsjAcQMJtx24/19"); // pushbullet.com 이동

			$(By.id("sign-in-btn")).click();
			$(By.xpath("//div[@id='onecup']/div[2]/div[2]/button")).click();

			$(By.id("identifierId")).sendKeys("wmpstore");
			sleep(2000);
//			enter();
			$(By.xpath("//div[@id='identifierNext']/content")).click();

			$(By.name("password")).sendKeys("msync1q2w3e");
			$(By.xpath("//div[@id='passwordNext']/content/span")).click();

			sleep(10000);
			$(By.xpath("//div[@id='sink']/div[2]/div/div/div[5]/div")).click(); // Texting 메뉴 선택

			SelenideElement sms = $(By.xpath("//div[@id='sidebar']/div[6]"));
			String smstext = sms.getText(); // SMS문자 추출
			String smsnumber = getNumber(smstext); // 받아온 문자에서 숫자만 추출
			String snumber = smsnumber.substring(8, 14); // 뒷 6자리만 추출
//			System.out.println(snumber); //받아온 텍스트 출력

			closetab();
			switchTo().window(0); // 첫번째 탭으로 전환
			$(By.id("_certifyNo")).sendKeys(snumber);
			$(By.xpath("//div[@id='_phoneConfirmArea']/a/span")).click();
			confirm("인증되었습니다.");

			$(By.id("_birth")).sendKeys("19880505");
			$(By.xpath("//div[@id='_memberJoin']/ul/li[7]/div/div/label/span")).click(); // 라디오 버튼 선택
			$(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='전체동의'])[1]/span[1]")).click();
			$(By.xpath("//div[@id='_joinConfirm']/a/span")).click();
		} else {
			$(By.id("_birth")).sendKeys("19880505");
			$(By.xpath("//div[@id='_memberJoin']/ul/li[7]/div/div/label/span")).click(); // 라디오 버튼 선택
			$(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='전체동의'])[1]/span[1]")).click();
			$(By.xpath("//div[@id='_joinConfirm']/a/span")).click();
		}
	}

	@AfterMethod
	public void end() {
	}
}