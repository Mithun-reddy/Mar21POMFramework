package base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.loginpage;
import utilities.AppConstants;
import utilities.CommonUtilities;
import utilities.DataUtilities;

public class BaseTest {

	public static String sReportTime;
	public static WebDriver driver = null;
	public static ExtentReports extent = null;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentTest test = null;
	public static Properties sProperties;
	private String sBrowserName;
	
	public CommonUtilities oCommonUtilities = new CommonUtilities();
	public DataUtilities oDataUtils = new DataUtilities();
	public loginpage lp = new loginpage(BaseTest.driver);
	public SoftAssert sa = new SoftAssert();
	
	@BeforeTest
	public void setup() {
		Initializereports();
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
	}

	public void Initializereports() {
		sReportTime = new SimpleDateFormat("yyyymmddhhmm").format(new Date());
		extent = new ExtentReports();
		htmlreporter = new ExtentHtmlReporter(AppConstants.EXTENT_HTML_REPORT_PATH + "\\" + sReportTime + ".html");
		extent.attachReporter(htmlreporter);
	}

	public WebDriver getDriver(String BrowserName) {

		sBrowserName = BrowserName.toLowerCase();
		switch (sBrowserName) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "ie":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			driver = null;

		}
		return driver;

	}

}
