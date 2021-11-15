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

import Website_pages.Login_page;
import Website_pages.User_Management_page;
import basepackage.Base_Class;
import utility.ExcelUtil;


public class UserManagePage_Testcases extends Base_Class {
	
	public Login_page logpage;
	public User_Management_page usrmang;
	public ExtentTest test;

	public UserManagePage_Testcases() throws IOException {
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
		usrmang = new User_Management_page();
		usrmang = PageFactory.initElements(driver, User_Management_page.class);
	}
	
	@Test(priority = 1)
	public void Verify_title() throws IOException, InterruptedException {
		test = extent.createTest("TC1_Verify Title");
		logpage.login(username, password);
		sleep();
		String Title = usrmang.verify_page_title();
		Assert.assertEquals(Title, "User Management", "Title is correct");
		test.log(Status.PASS, "Title is correct");
	}
	
	@Test(priority = 2)
	public void Verify_search() throws IOException, InterruptedException {
		test = extent.createTest("TC2_Verify Search");
		logpage.login(username, password);
		sleep();
		usrmang.verify_search("xyx");
		test.log(Status.PASS, "search is displaying result");
		sleep();
	}

	@Test(priority = 3)
	public void Verify_Enable_filter() throws IOException, InterruptedException {
		test = extent.createTest("TC3_Verify Enable_filter");
		logpage.login(username, password);
		sleep();
		usrmang.verify_enable_filter();
		sleep();
		test.log(Status.PASS, "Filter is now enabled");
	}

	@Test(priority = 4)
	public void Verify_Enable_grouping() throws IOException, InterruptedException {
		test = extent.createTest("TC4_Verify Enable_grouping");
		logpage.login(username, password);
		sleep();
		usrmang.verify_enable_grouping();
		sleep();
		test.log(Status.PASS, "grouping is now enabled");
	}

	@Test(priority = 5)
	public void verify_Export_Excel() throws AWTException, IOException, InterruptedException {
		test = extent.createTest("TC5_Verify Export_Excel");
		logpage.login(username, password);
		sleep();
		usrmang.verify_export_Excel();
		test.log(Status.PASS, "Excel is now exported");
	}

	@Test(priority=6)
	public void Verify_AddUserManagement() throws Exception
	{
		
		test = extent.createTest("TC6_Verify Add UserManagement");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserManagAdd");
		
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			usrmang.Verify_addUserManagement(ExcelUtil.getRowData(i));
			refresh();
			sleep();
		}
		test.log(Status.PASS, "User is added successfully");
		
	}
	
	//(dependsOnMethods="Verify_AddUserGroup", priority= 7)
	@Test(priority= 7)
	public void Verify_UpdateUserManagement() throws Exception {

		test = extent.createTest("TC7_Verify Update UserManagement");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserManagUpdate");

		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
			usrmang.Verify_updateUsermanagement(ExcelUtil.getRowData(i));
			sleep();
			refresh();
		}
		test.log(Status.PASS, "User is Updated successfully");

	}
	
	//(dependsOnMethods={"Verify_AddUserGroup","Verify_UpdateUserGroup"},priority = 8)
	@Test(dependsOnMethods={"Verify_AddUserManagement","Verify_UpdateUserManagement"},priority = 8)
	public void Verify_DeleteUserManagement() throws InterruptedException, Exception {
		test = extent.createTest("TC8_Verify DeleteUserManagement");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserManagDelete");

		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
			usrmang.Verify_searchAndDeleteUsermanage(ExcelUtil.getRowData(i));
			sleep();
		}
		test.log(Status.PASS, "User is Deleted successfully");
		
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
