package testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Website_pages.Dashboard_page;
import Website_pages.Login_page;
import basepackage.Base_Class;

public class Loginpage_Testcases extends Base_Class{
	
	public Dashboard_page dash;
	public Login_page logpage;
	public ExtentTest test;
	
	public Loginpage_Testcases() throws IOException {
		super();
		
	}
	
	@BeforeTest
	public void initExtentreport()
	{
		ExtentReports();
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialzation();
		logpage = new Login_page();
	}
	
	
	@Test(priority=1)
	public void Verify_login() throws IOException, InterruptedException
	{
		test = extent.createTest("TC1_Verify Admin login");
		dash = logpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		test.log(Status.PASS, "Admin login Successfully");
	}
	
	@Test(priority=2)
	public void Verify_title()
	{
		test = extent.createTest("TC2_Verify title");
		String Title = logpage.VerifyTitle();
		Assert.assertEquals(Title, "OptiPro-ERP-Admin Portal");
		test.log(Status.PASS, "login page Title are correct");
	}
	
	@Test(priority=3)
	public void Verify_validation()
	{
		test = extent.createTest("TC3_Verify validation");
		logpage.verify_validation();
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
		test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
	}
	
	@Test(priority=4)
	public void verify_logo()
	{
		test = extent.createTest("TC4_Verify logo");
		WebElement ImageFile = logpage.Admin_logo;
		
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!ImagePresent)
        {
             System.out.println("Logo not displayed.");
             test.log(Status.FAIL, "Admin_logo is not displaying");
        }
        else
        {
            System.out.println("logo displayed.");
            test.log(Status.PASS, "Admin_logo is displaying");
        }
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	@AfterTest
	public void flushextent()
	{
		extentflush();
	}

}
