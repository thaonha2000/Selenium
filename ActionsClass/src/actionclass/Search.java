package actionclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Search {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\AnhTester\\Setup\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		WebElement element=driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]"));
		Actions action=new Actions(driver);
		
		action.sendKeys(element, "Anh Tester").build().perform();
		
		action.sendKeys(Keys.ENTER).build().perform();
		
		WebElement elementTitlePage = driver
				.findElement(By.xpath("//h3[normalize-space()='Anh Tester - Automation Testing']"));

		System.out.println(elementTitlePage);
		
		action.click(elementTitlePage).build().perform();
		
//		action.doubleClick(driver.findElement(By.xpath("//a[@id='btn-login']"))).build().perform();
//		Thread.sleep(2000);
//		driver.navigate().back();
		WebElement elementClick = driver.findElement(
				By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester ')]"));
		action.doubleClick(elementClick).build().perform();
		action.contextClick(elementClick).build().perform();
		
		WebElement elementMove=driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));
		action.moveToElement(elementMove).build().perform();
	}

}
