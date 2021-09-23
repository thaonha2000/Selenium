package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = setupEnviroment("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		checkMale(driver, true);
		checkMuilteGroupRadio(driver);

	}

	public static WebDriver setupEnviroment(String url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\AnhTester\\Setup\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		return driver;
	}

	public static void checkMale(WebDriver driver, boolean isMale) throws InterruptedException {
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='radio' and @name='optradio']"));
		for (WebElement webElement : list) {
//			boolean selected = webElement.isSelected();
//			boolean enabled = webElement.isEnabled();
			if (isMale) {
				if (webElement.getAttribute("value").equalsIgnoreCase("Male")) {
					webElement.click();
				}
			} else {
				if (!webElement.getAttribute("value").equalsIgnoreCase("Male")) {
					webElement.click();
				}
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='buttoncheck']")).click();
	}

	public static void checkMuilteGroupRadio(WebDriver driver) throws InterruptedException {
		List<WebElement> genders = driver.findElements(By.xpath("//input[@type='radio' and @name='gender']"));
		List<WebElement> ages = driver.findElements(By.xpath("//input[@type='radio' and @name='ageGroup']"));

		for (WebElement webElement : genders) {
			if (webElement.getAttribute("value").equalsIgnoreCase("Female")) {
				webElement.click();
			}
		}
		Thread.sleep(2000);
		for (WebElement webElement : ages) {
			if (webElement.getAttribute("value").equalsIgnoreCase("5 - 15")) {
				webElement.click();
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Get values')]")).click();
	}
}
