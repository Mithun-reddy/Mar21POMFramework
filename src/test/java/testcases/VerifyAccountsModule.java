package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import listeners.TestListeners;


public class VerifyAccountsModule extends BaseTest {
	
		SoftAssert sa = new SoftAssert();
	
		@Test
		public void SelectAccountTab() throws IOException, InterruptedException, AWTException {
			driver = getDriver("CHROME");
			driver.get(oDataUtils.ReadWebElementProperties("App.URL"));
//			CommonUtilities oCommonUtilities = new CommonUtilities();
			//VerifyLoginFunctionality login = new VerifyLoginFunctionality();
			//login.VerifyLoginErrorMessage02();
			oCommonUtilities.logintoSFDC();
			test.info("Login Success");
			Thread.sleep(1000);
			WebElement SelectTab = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("account.selectTab.xpath")));
			oCommonUtilities.waitForElementVisible(SelectTab);
			oCommonUtilities.clickonElement(SelectTab, "Accounts");
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
		
			}
		@Test(dataProvider = "AccountsData")
		public void CreateAccount_TC10(String name1) throws IOException, InterruptedException, AWTException
		{
			VerifyAccountsModule oVerifyAccounts = new VerifyAccountsModule();
			oVerifyAccounts.SelectAccountTab();
			WebElement newLable = driver.findElement(By.id(oDataUtils.ReadWebElementProperties("account.newLabel.id")));
			oCommonUtilities.waitForElementVisible(newLable);
			oCommonUtilities.clickonElement(newLable, "Create New");
			WebElement accounts = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("account.menuAccount.xpath")));
			oCommonUtilities.clickonElement(accounts, "Accounts");
//			String Name = sc.next();
			WebElement accountName = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("account.accountName.xpath")));
			//String name="HDFC Bank";
			String name = name1;
			oCommonUtilities.enterText(accountName, name, "AccountName");
			WebElement save = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("account.newAccount.save.xpath")));
			oCommonUtilities.clickonElement(save, "Save Button");
			WebElement accountLabel = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("account.newAccountLabel.xpath")));
			test.info("Accounts added successfully.");
			sa.assertEquals(accountLabel.getText(), name);
		}
		
		@Test
		public void CreateView_TC11() throws IOException, InterruptedException, AWTException
		{
			VerifyAccountsModule oVerifyAccounts = new VerifyAccountsModule();
			oVerifyAccounts.SelectAccountTab();
			WebElement newViewLink = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("account.viewLabel.xpath")));
			oCommonUtilities.clickonElement(newViewLink, "New View Link");
			
			String vName = "View 1";
			String vUName = "Unique view1";
			WebElement viewName = driver.findElement(By.id(oDataUtils.ReadWebElementProperties("account.viewName.id")));
			oCommonUtilities.enterText(viewName, vName, "View name");
			WebElement viewUName = driver.findElement(By.id(oDataUtils.ReadWebElementProperties("account.viewUname.id")));
			viewUName.clear();
			oCommonUtilities.enterText(viewUName, vUName, "View unique name");
			WebElement viewSave = driver.findElement(By.id(oDataUtils.ReadWebElementProperties("account.viewSave.xpath")));
			viewSave.click();
			Thread.sleep(1000);
			WebElement viewDrp = driver.findElement(By.xpath(oDataUtils.ReadWebElementProperties("account.viewDrp.xpath")));
			oCommonUtilities.waitForElementVisible(viewDrp);
			
			Select ViewDrp1 = new Select(viewDrp);
			System.out.println(vName);
			System.out.println(ViewDrp1.getFirstSelectedOption().getText());
			sa.assertEquals(ViewDrp1.getFirstSelectedOption().getText(),vName);
			test.info("View name added successfully.");
		}
		
		
		@DataProvider(name="AccountsData")
		public Object[][] UserAccountName()
		{
			return new Object[][] {{"Axis Bank"},{"ABC Bank"}};
		}
		

}
