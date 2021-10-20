package testcases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Website_pages.Login_page;
import Website_pages.User_Group_page;
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
	
	@Test(priority=1)
	public void Verify_AddUserManagement() throws Exception
	{
		test = extent.createTest("TC6_Verify Add User Management");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserManagAdd");
		
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			usrmang.Verify_addUserManagement(ExcelUtil.getRowData(i));
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
