package Demonstration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGDemo {
	
	WebDriver driver;
	
	String HomePageURL = "https://ap8.salesforce.com/setup/forcecomHomepage.apexp?setupid=ForceCom";
	
	SoftAssert sa = new SoftAssert();
	
	/* Assertions 
	 * 
	 * 1. HardAssert --> 
	 * 2. Soft assert(Verify) -->
	 * */
	
	/* Annotations 
	 * 
	 * BeforeSuite
	 * BeforeTest
	 * Beforeclass
	 * BeforeMethod
	 * Test
	 * AfterMethod
	 * Afterclass
	 * AfterTest
	 * AfterSuite
	 * 
	 * */


//		No order o execution
//		No control
//	 -5 , -2, 0, 2 // A - Z, a-z  1-9
	
//	Login //Accounts1
//	Login // Accounts2
//	Login //Accounts3
	
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("Before suite file is called...");
	}
	
	@AfterSuite
	public void Aftersuite() {
		System.out.println("After suite file is executed....");
	}
	
	@BeforeTest
	public void Beforetest() {
		System.out.println("Before testttt start....");
	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("After testttt start....");
	}
	
//	@BeforeGroups(groups = {"Smoke","Login"}, alwaysRun = true)
	public void Demogroup() {
		System.out.println("This is called before smoke group");
	}
	
//	@AfterGroups(groups = "Smoke")
	public void Demogroup2() {
		System.out.println("This is called after smoke group");
	}
	
	@BeforeClass
	public void SetupBrowser() {
		
		System.out.println("Setting my chrome browser.....");
	}
	
	@AfterClass
	public void tearDown() {
	
		System.out.println("Closing all browser instances...");
	}
	
	
	@BeforeMethod
	public void Login() {
		System.out.println("Login is called..");
		
		String ExpectedURL = driver.getCurrentUrl();
		
		if(ExpectedURL.equals(HomePageURL)) {
			System.out.println("Passed");
		}
		
		Assert.assertEquals(HomePageURL, ExpectedURL);
//
//		sa.assertEquals(actual, expected);
//		sa.assertEquals(actual, expected);
//		sa.assertEquals(actual, expected);
		
		sa.assertAll();
		
		
		
		
		
	}
	
	@Test(groups = {"Smoke"}, invocationCount = 5, successPercentage = 20)
	public void Oppurtunities() {
		System.out.println("Oppurtunities method called..");
//		DemoMethod();
//		throw new ElementNotInteractableException("Element not found");
	}
	
	@Test(groups = "Smoke", description = "This will take me to Hamepage and Create xyz..")
	public void HomePage_1() {
		System.out.println("Home page launched..");
//		throw new ElementNotInteractableException("Element not found");
	}
	
	@Test(groups = "Smoke", successPercentage = 10)
	public void HomePage_2() {
		System.out.println("home page launched..");
		throw new ElementNotInteractableException("Element not found");
	}
	
	@Test(groups = "Accounts", dependsOnMethods = "HomePage_2", successPercentage = 15)
	public void Accounts() {
		System.out.println("Accounts page..");
	}
	
	@AfterMethod
	public void Close() {
		System.out.println("Closing the browser..");
	}
	

}
