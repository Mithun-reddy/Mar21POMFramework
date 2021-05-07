package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	public loginpage(WebDriver driver) {
		PageFactory.initElements(driver,loginpage.class);
	}
	
	
	@FindBy(name = "username")
	public WebElement Username;
	
	@FindBy(id = "password")
	public WebElement Password;
	
	@FindBy(id = "login")
	public WebElement Login;
	
	@FindBy(id = "rem")
	public WebElement RememberMe;
	
	@FindBy(xpath = "//*[@id='error']")
	public WebElement Errormsg;
	

}
