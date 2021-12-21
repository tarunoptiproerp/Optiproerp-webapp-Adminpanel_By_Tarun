package Website_pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base_Class;

public class Login_page extends Base_Class {
	
	public static final Logger logger = (Logger) LogManager.getLogger(Login_page.class);

	@FindBy(xpath="/html/body/app-root/div/div/app-login/section/div/div/div/div[1]/img")
	public
	WebElement Admin_logo;
	
	@FindBy(id="UserName")
	WebElement user_name;

	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-login/section/div/div/div/div[2]/div/form/div/div[3]/div/button")
	WebElement Submit;
	
	
	public Login_page() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public Dashboard_page login(String username, String pwd) throws IOException
	{
		
		user_name.sendKeys(username);
		Password.sendKeys(pwd);
		Submit.click();
		
		
		return new Dashboard_page();
	}
	
	public void verify_validation()
	{
		Submit.click();
	}
	
	public void verify_logo()
	{
		//Boolean logoPresent = Admin_logo.isDisplayed();
		WebElement ImageFile = Admin_logo;
		
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!ImagePresent)
        {
             System.out.println("Logo not displayed.");
        }
        else
        {
            System.out.println("logo displayed.");
        }
	}

	
}
