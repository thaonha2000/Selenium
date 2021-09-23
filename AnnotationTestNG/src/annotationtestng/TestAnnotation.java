package annotationtestng;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestAnnotation {
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}

	@BeforeGroups(groups = { "testOne" })
	public void beforeGroupOne() {
		System.out.println("Before Group One");
	}

	@AfterGroups(groups = { "testOne" })
	public void afterGroupOne() {
		System.out.println("After Group One");
	}

	@BeforeGroups(groups = { "testTwo" })
	public void beforeGroupTwo() {
		System.out.println("Before Group Two");
	}

	@AfterGroups(groups = { "testTwo" })
	public void afterGroupTwo() {
		System.out.println("After Group Two");
	}

	@Test(groups = { "testOne" })
	public void testOneMethod() {
		System.out.println("Test Method One");
	}

	@Test(groups = { "testTwo" })
	public void testTwoMethod() {
		System.out.println("Test Method Two");
	}
}
