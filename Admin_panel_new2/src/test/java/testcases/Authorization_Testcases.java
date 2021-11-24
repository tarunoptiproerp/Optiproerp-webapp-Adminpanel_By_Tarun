package testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Website_pages.Authorization_page;
import Website_pages.Login_page;
import Website_pages.Roles_page;
import basepackage.Base_Class;
import utility.ExcelUtil;

public class Authorization_Testcases extends Base_Class {
	
	public Login_page logpage;
	public Authorization_page Auth;
	public ExtentTest test;

	public Authorization_Testcases() throws IOException {
		super();
		
	}
	
	String username = prop.getProperty("Username");
	String password = prop.getProperty("Password");
	
	@BeforeTest
	public void initExtentreport() throws IOException {
		ExtentReports();

	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initialzation();
		logpage = new Login_page();
		Auth = new Authorization_page();
		Auth = PageFactory.initElements(driver, Authorization_page.class);	
	}
	
	@Test(priority=0)
	public void AddAuth() throws AWTException, Exception
	{
		test = extent.createTest("TC1_Verify Add Authorization ");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("AuthAdd");
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			Auth.Add_auth(ExcelUtil.getRowData(i));
			refresh();
			sleep();
		
		}
		test.log(Status.PASS, "New Role Added successfully");
		
	}
	
	@Test(priority=1)
	public void UpdateAuth() throws AWTException, Exception
	{
		test = extent.createTest("TC2_Verify Update Authorization ");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("AuthUpdate");
		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
			Auth.Update_auth(ExcelUtil.getRowData(i));
			sleep();
			refresh();
			Takescreenshot("UpdateAuth"+i);
		}
	}
	
	@Test(priority = 2)
	public void DeleteAuth()throws AWTException, Exception
	{
		test = extent.createTest("TC3_Verify Delete Authorization ");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("AuthDelete");
		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
			Auth.Delete_auth(ExcelUtil.getRowData(i));
			sleep();
			refresh();
			Takescreenshot("DeleteAuth"+i);
		}	
		
	}
	
	@Test(priority = 3)
	public void verify_Export_Excel() throws Exception
	{
		test = extent.createTest("TC5_Verify Export_Excel");
		logpage.login(username, password);
		sleep();
		Auth.verify_export_Excel();
		test.log(Status.PASS, "Excel is now exported");
		}
	
	@Test(priority = 4)
	public void Verify_title() throws IOException, InterruptedException {
		test = extent.createTest("TC1_Verify Title");
		logpage.login(username, password);
		sleep();
		String Title = Auth.verify_page_title();
		Assert.assertEquals(Title, "User Authorization", "Title is correct");
		test.log(Status.PASS, "Title is correct");
	}
	
	@Test(priority = 5)
	public void Verify_search() throws IOException, InterruptedException {
		test = extent.createTest("TC2_Verify Search");
		logpage.login(username, password);
		sleep();
		Auth.verify_search("xyx");
		test.log(Status.PASS, "search is displaying result");
		sleep();
	}
	
	@Test(priority = 6)
	public void Verify_Enable_filter() throws IOException, InterruptedException {
		test = extent.createTest("TC3_Verify Enable_filter");
		logpage.login(username, password);
		sleep();
		Auth.verify_enable_filter();
		sleep();
		test.log(Status.PASS, "Filter is now enabled");
	}

	@Test(priority = 7)
	public void Verify_Enable_grouping() throws IOException, InterruptedException {
		test = extent.createTest("TC4_Verify Enable_grouping");
		logpage.login(username, password);
		sleep();
		Auth.verify_enable_grouping();
		sleep();
		test.log(Status.PASS, "grouping is now enabled");
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@AfterTest
	public void flushextent() {
		extentflush();
	}


}
