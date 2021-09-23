package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = setupDriver("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();

		oneCheck(driver);
		multipleCheck(driver);
		uncheck(driver);
		allCheck(driver);
		driver.close();

	}

	public static WebDriver setupDriver(String url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\AnhTester\\Setup\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url);
		Thread.sleep(2000);
		return driver;
	}

	public static void oneCheck(WebDriver driver) throws InterruptedException {

		boolean iSelected = driver.findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected();
		System.out.println("isAgeSelected checked: " + iSelected);
		System.out.println("txtAge displayed: " + driver.findElement(By.xpath("//div[@id='txtAge']")).isDisplayed());
		if (!iSelected) {
			driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
			System.out.println("isAgeSelected checked: "
					+ driver.findElement(By.xpath("//input[@id='isAgeSelected']")).isSelected());
			System.out
					.println("txtAge displayed: " + driver.findElement(By.xpath("//div[@id='txtAge']")).isDisplayed());
		}
		Thread.sleep(2000);
	}

	public static void multipleCheck(WebDriver driver) throws InterruptedException {
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox' and @class='cb1-element']"));
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if (i % 2 != 0) {
				list.get(i).click();
			}
		}
		Thread.sleep(2000);
	}

	public static void uncheck(WebDriver driver) throws InterruptedException {
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='checkbox' and @class='cb1-element']"));
		for (WebElement webElement : list) {
			if (webElement.isSelected()) {
				webElement.click();
			}
		}
		Thread.sleep(2000);
	}

	public static void allCheck(WebDriver driver) throws InterruptedException {
		int i = 0;
		do {
			String value = driver.findElement(By.xpath("//input[@type='button']")).getAttribute("value");
			if ("Check All".equalsIgnoreCase(value)) {
				driver.findElement(By.xpath("//input[@type='button']")).click();
			} else {
				driver.findElement(By.xpath("//input[@type='button']")).click();
			}
			Thread.sleep(2000);
			System.out.println(i);
			i++;
		} while (i <= 3);

	}

}
