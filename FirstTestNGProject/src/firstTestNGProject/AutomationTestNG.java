package firstTestNGProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationTestNG {

	@Test
	public void verifyHomepageTitle() throws InterruptedException {
		String baseUrl = "https://anhtester.com";

		String driverPath = "C:\\SELENIUM\\AnhTester\\Setup\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver;

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.navigate().to(baseUrl);
		Thread.sleep(2000);

		String expectedTitle = "Anh Tester - Automation Testing";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);

		Thread.sleep(2000);
		driver.quit();
	}
}
