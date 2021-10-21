package testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
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

import Website_pages.Login_page;
import Website_pages.Roles_page;
import Website_pages.User_Management_page;
import basepackage.Base_Class;
import utility.ExcelUtil;

public class RolePage_Testcases extends Base_Class{

	
	public Login_page logpage;
	public Roles_page rpage;
	public ExtentTest test;
	
	public RolePage_Testcases() throws IOException {
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
		rpage = new Roles_page();
		rpage = PageFactory.initElements(driver, Roles_page.class);
	}
	
	@Test(priority=1)
	public void Verify_title() throws IOException, InterruptedException {
		test = extent.createTest("TC1_Verify Title");
		logpage.login(username, password);
		sleep();
		String Title = rpage.verify_page_title();
		Assert.assertEquals(Title, "Roles", "title is correct");
		test.log(Status.PASS, "Title are correct");
	}
	
	@Test(priority = 2)
	public void Verify_search() throws IOException, InterruptedException {
		test = extent.createTest("TC2_Verify Search");
		logpage.login(username, password);
		sleep();
		rpage.verify_search("xyx");
		sleep();
	}
	
	@Test(priority = 3)
	public void Verify_Enable_filter() throws IOException, InterruptedException {
		test = extent.createTest("TC3_Verify Enable_filter");
		logpage.login(username, password);
		sleep();
		rpage.verify_enable_filter();
		sleep();
	}

	@Test(priority = 4)
	public void Verify_Enable_grouping() throws IOException, InterruptedException {
		test = extent.createTest("TC4_Verify Enable_grouping");
		logpage.login(username, password);
		sleep();
		rpage.verify_enable_grouping();
		sleep();
	}
	
	@Test(priority = 5)
	public void verify_Export_Excel() throws AWTException, IOException, InterruptedException {
		test = extent.createTest("TC5_Verify Export_Excel");
		logpage.login(username, password);
		sleep();
		rpage.verify_export_Excel();
		sleep();
	}
	
	@Test(priority=6)
	public void Verify_AddRole() throws Exception
	{
		test = extent.createTest("TC6_Verify Add User Management");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("RoleAdd");
		
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			rpage.Verify_addRole(ExcelUtil.getRowData(i));
			sleep();
		}
	
	}
	
	@Test(priority=7)
	public void Verify_Update_Roles() throws InterruptedException, Exception
	{
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("RoleUpdate");
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			rpage.Verify_updateRole(ExcelUtil.getRowData(i));
			sleep();
		}
	}
	
	@Test(priority=8)
	public void Verify_Delete_Roles() throws InterruptedException, Exception
	{
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("RoleDelete");
		for (int i = 1; i < sheet.getLastRowNum()- 1; i++) {
			rpage.Verify_DeleteRoles(ExcelUtil.getRowData(i));
			sleep();
		}
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
