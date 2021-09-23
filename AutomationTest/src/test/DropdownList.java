package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownList {
	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver = setupEnviroment("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		WebDriver driver = setupEnviroment("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
//		oneSelected(driver);
		multipleSelected(driver);

	}

	public static WebDriver setupEnviroment(String url) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\AnhTester\\Setup\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		return driver;
	}

	public static void oneSelected(WebDriver driver) throws InterruptedException {
		Select select = new Select(driver.findElement(By.xpath("//select[@id='select-demo']")));
		boolean isMutiple = select.isMultiple();
		System.out.println(isMutiple);

		select.selectByVisibleText("Wednesday");
		System.out.println(select.getFirstSelectedOption().getText());
		Thread.sleep(2000);

		select.selectByValue("Monday");
		System.out.println(select.getFirstSelectedOption().getAttribute("value"));
		Thread.sleep(2000);

		select.selectByIndex(1);
		System.out.println(select.getFirstSelectedOption().getText());
		Thread.sleep(2000);

		System.out.println(select.getOptions().size());

	}

	public static void multipleSelected(WebDriver driver) throws InterruptedException {
		Select select = new Select(driver.findElement(By.xpath("//select[@id='multi-select']")));
		if (select.isMultiple()) {
			int size = select.getOptions().size();
			for (int i = 0; i < size; i++) {
				if (i % 2 == 0) {
					select.selectByIndex(i);
					Thread.sleep(2000);
				}
			}
		}
		driver.findElement(By.xpath("//button[@id='printAll']")).click();
		Thread.sleep(2000);
		select.selectByIndex(1);
		driver.findElement(By.xpath("//button[@id='printMe']")).click();
		Thread.sleep(2000);
	}
}
