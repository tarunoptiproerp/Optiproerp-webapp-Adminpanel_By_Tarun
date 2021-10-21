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

import Website_pages.Dashboard_page;
import Website_pages.Login_page;
import Website_pages.User_Group_page;
import basepackage.Base_Class;
import utility.ExcelUtil;

public class UserGroup_Testcases extends Base_Class {

	public Login_page logpage;
	public User_Group_page usrgrup;
	public ExtentTest test;

	public UserGroup_Testcases() throws IOException {
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
		usrgrup = new User_Group_page();
		usrgrup = PageFactory.initElements(driver, User_Group_page.class);
	}

	@Test(priority = 1)
	public void Verify_menus() throws IOException, InterruptedException {
		test = extent.createTest("TC1_Verify Title");
		logpage.login(username, password);
		sleep();
		String Title = usrgrup.verify_page_title();
		Assert.assertEquals(Title, "User Group", "Title is correct");
		test.log(Status.PASS, "Title is correct");
	}

	@Test(priority = 2)
	public void Verify_search() throws IOException, InterruptedException {
		test = extent.createTest("TC2_Verify Search");
		logpage.login(username, password);
		sleep();
		usrgrup.verify_search("xyx");
		sleep();
	}

	@Test(priority = 3)
	public void Verify_Enable_filter() throws IOException, InterruptedException {
		test = extent.createTest("TC3_Verify Enable_filter");
		logpage.login(username, password);
		sleep();
		usrgrup.verify_enable_filter();
		sleep();
	}

	@Test(priority = 4)
	public void Verify_Enable_grouping() throws IOException, InterruptedException {
		test = extent.createTest("TC4_Verify Enable_grouping");
		logpage.login(username, password);
		sleep();
		usrgrup.verify_enable_grouping();
		sleep();
	}

	@Test(priority = 5)
	public void verify_Export_Excel() throws AWTException, IOException, InterruptedException {
		test = extent.createTest("TC5_Verify Export_Excel");
		logpage.login(username, password);
		sleep();
		usrgrup.verify_export_Excel();
		sleep();
	}

	@Test(priority = 6)
	public void Verify_AddUserGroup() throws Exception {
		test = extent.createTest("TC5_Verify Add UserGroup");
		logpage.login(username, password);
		sleep();

		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserGroupAdd");

		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			usrgrup.Verify_addUserGroup(ExcelUtil.getRowData(i));
			sleep();
		}
	}

	// (dependsOnMethods="Verify_AddUserGroup()", priority= 6)

	@Test(dependsOnMethods="Verify_AddUserGroup", priority= 7)
	public void Verify_UpdateUserGroup() throws Exception {

		test = extent.createTest("TC6_Verify UpdateUserGroup");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserGroupUpdate");

		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			usrgrup.Verify_updateUserGroup(ExcelUtil.getRowData(i));
			sleep();
		}

	}

	@Test(dependsOnMethods={"Verify_AddUserGroup","Verify_UpdateUserGroup"},priority = 8)
	public void Verify_DeleteUserGroup() throws InterruptedException, Exception {
		test = extent.createTest("TC5_Verify DeleteUserGroup");
		logpage.login(username, password);
		sleep();

		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserGroupDelete");

		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			usrgrup.Verify_searchAndDeleteUserGroup(ExcelUtil.getRowData(i));
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
