package Demonstration;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsDemo {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * Waits 1. Implicit wait -> Waits for all the elements(10), Once declared it will wait for all the elemnts
		 * 2. Explicit wait --> waits for certain condition before throwing the exception
		 * 3. Fluent wait --> Polling period (5 sec, 0, 5th, 10th)
		 * 
		 */

		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("mithun.r@tekarch.com");
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Forgot")));
		
		Thread.sleep(3000);
		WebElement passowrd = driver.findElement(By.id("password"));
		passowrd.sendKeys("1234jikok");
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("Login"))));
		Thread.sleep(3000);
		WebElement LoginButton = driver.findElement(By.id("Login"));
		LoginButton.click();
		Thread.sleep(10000);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement loginbutton = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.id("Login"));
			}
		});
		
		driver.close();
//		
	}

	public static void DemoMethod() {
		
//		throw new SkipException("Breakdown");
		// TODO Auto-generated method stub
		
	}

}
