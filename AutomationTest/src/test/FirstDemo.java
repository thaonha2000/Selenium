package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstDemo {

	public static void main(String[] args) throws InterruptedException {
//		 TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\AnhTester\\Setup\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		
		driver.navigate().to("https://demo.anhtester.com/");
		System.out.println("Title: " + driver.getTitle());// show title

		boolean checkEmail = driver.findElement(By.xpath("//form//div//span[@class='help-block small']")).isDisplayed();
		System.out.println(checkEmail);

		String cssValue = driver.findElement(By.xpath("//button[@class='btn btn-success']"))
				.getCssValue("background-color");
		System.out.println(cssValue);

		String attribute = driver.findElement(By.xpath("//form//div//label")).getAttribute("for");
		System.out.println("Attribute: " + attribute);

		Dimension dimension = driver.findElement(By.xpath("//a//img")).getSize();
		System.out.println("Width: " + dimension.getWidth() + " Height: " + dimension.getHeight());

		Point point = driver.findElement(By.xpath("//div[@class='panel-body']//form//span//a//b[@class='text-right']"))
				.getLocation();
		System.out.println("X-Cordinate: " + point.getX() + " Y-Cordinate: " + point.getY());

		String username = driver.findElement(By.xpath("//tbody//tr[1]//td")).getText();
		String password = driver.findElement(By.xpath("//tbody//tr[1]//td[2]")).getText();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));

//		element.sendKeys("user01@anhtester.com");
		element.sendKeys(username);
		Thread.sleep(2000);

//		element.clear();
//		Thread.sleep(2000);

//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='btn btn-success']")).submit();
		System.out.println(driver.getWindowHandle());
		Thread.sleep(5000);

		driver.navigate().back();
		System.out.println(driver.getWindowHandle());
		Thread.sleep(1000);

		driver.navigate().refresh();
		System.out.println(driver.getWindowHandle());
		Thread.sleep(1000);

		driver.navigate().forward();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());

		Thread.sleep(3000);
		driver.quit();
	}

}
