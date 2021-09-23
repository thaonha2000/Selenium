package actionclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\AnhTester\\Setup\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/drag_drop.html");

		// Element which needs to drag.
		WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));
		// Element on which need to drop.
		WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));

		Actions action = new Actions(driver);

		action.dragAndDrop(From, To).build().perform();

		Thread.sleep(2000);

//		WebElement from_5000 = driver.findElement(By.xpath("//*[@id='fourth']/a"));
//		Point point = driver.findElement(By.xpath("//*[@id='amt7']")).getLocation();
//		System.out.println(point.getX()+" "+point.getY());
//		action.dragAndDropBy(from_5000, 360,367).build().perform();
		
		
		
	}

}
