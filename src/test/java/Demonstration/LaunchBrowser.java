package Demonstration;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
//		System.setProperty("webdriver.chrome.driver", "M:\\chromedriver\\chromedriver.exe");
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		driver.get("https://google.com");
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
		driver.get("https://amazon.com");
		
//		List<WebElement> inputtags = driver.findElements(By.tagName("//a"));
		
//		WebElement ele = inputtags.get(10);
		
		
//		driver.findElement(By.linkText("Forgot Your Password?")).click();
//		
//		driver.findElement(By.partialLinkText("Forgot")).click();
//		
//		driver.findElement(By.className("button r4 wide primary")).click();
		
//		WebElement pass = driver.findElement(By.id("password_field"));
		
//		WebElement username = driver.findElement(By.id("email_field"));
//		username.sendKeys("mithun123");
//		WebElement pwd = driver.findElement(By.id("password_field"));
//		pwd.sendKeys("1234mihtun");
//		
//		driver.findElement(By.name("username")).sendKeys("ajdn");
//		driver.findElement(By.id("password")).sendKeys("djd");
		
//		WebElement button = driver.findElement(By.xpath("//*[@id='login_div']/button"));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
//		js.executeScript("arguments[0].click();", button); //Click operation
//		js.executeScript("arguments[0].value='1234Mihtun';", pass); //Sendkeys using JS
		js.executeScript("window.scrollBy(0,600)");  // to perform scrolling
		Thread.sleep(5000);
		js.executeScript("alert('This is a Test alert')");
		
		WebElement choosefile = driver.findElement(By.id(""));
		choosefile.sendKeys("4/26/2021");
		
		Set<String>  wind = driver.getWindowHandles();
		
//		String secondwindow = iterator.next();
		
//		driver.switchTo().window(secondwindow);
		driver.close();
		driver.switchTo().parentFrame();
		WebElement dd = driver.findElement(By.id("fcf"));
		Select sc = new Select(dd);
		
		
		
		
		
		
		
	}

}
