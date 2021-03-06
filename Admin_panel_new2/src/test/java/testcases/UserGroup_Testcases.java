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
		Assert.assertEquals(Title, "User Group", "title is correct");
		test.log(Status.PASS, "Menus are working fine");
	}

	@Test(priority = 2)
	public void Verify_search() throws IOException, InterruptedException {
		test = extent.createTest("TC2_Verify Search");
		logpage.login(username, password);
		sleep();
		usrgrup.verify_search("xyx");
		sleep();
		test.log(Status.PASS, "Search are working Fine");
	}

	@Test(priority = 3)
	public void Verify_Enable_filter() throws IOException, InterruptedException {
		test = extent.createTest("TC3_Verify Enable_filter");
		logpage.login(username, password);
		sleep();
		usrgrup.verify_enable_filter();
		sleep();
		test.log(Status.PASS, "Filter are enabled");
	}

	@Test(priority = 4)
	public void Verify_Enable_grouping() throws IOException, InterruptedException {
		test = extent.createTest("TC4_Verify Enable_grouping");
		logpage.login(username, password);
		sleep();
		usrgrup.verify_enable_grouping();
		sleep();
		test.log(Status.PASS, "Group Filter are enabled");
	}

	@Test(priority = 5)
	public void verify_Export_Excel() throws AWTException, IOException, InterruptedException {
		test = extent.createTest("TC5_Verify Export_Excel");
		logpage.login(username, password);
		sleep();
		usrgrup.verify_export_Excel();
		sleep();
		test.log(Status.PASS, "File Exported successfully");
	}

	@Test(priority = 6)
	public void Verify_AddUserGroup() throws Exception {
		test = extent.createTest("TC6_Verify Add UserGroup");
		logpage.login(username, password);
		sleep();

		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserGroupAdd");

		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			usrgrup.Verify_addUserGroup(ExcelUtil.getRowData(i));
			sleep();
		}
		test.log(Status.PASS, "User group added successfully");
	}

	// (dependsOnMethods="Verify_AddUserGroup()", priority= 6)
	
	@Test(dependsOnMethods="Verify_AddUserGroup", priority= 7)
	public void Verify_UpdateUserGroup() throws Exception {

		test = extent.createTest("TC7_Verify UpdateUserGroup");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserGroupUpdate");

		for (int i = 1; i < sheet.getLastRowNum(); i++) {
			usrgrup.Verify_updateUserGroup(ExcelUtil.getRowData(i));
			sleep();
		}
		test.log(Status.PASS, "User group Updated successfully");

	}

	@Test(priority = 8)
	//dependsOnMethods={"Verify_AddUserGroup","Verify_UpdateUserGroup"},
	public void Verify_DeleteUserGroup() throws InterruptedException, Exception {
		test = extent.createTest("TC8_Verify DeleteUserGroup");
		logpage.login(username, password);
		sleep();

		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserGroupDelete");

		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
			usrgrup.Verify_searchAndDeleteUserGroup(ExcelUtil.getRowData(i));
			sleep();
		}
		test.log(Status.PASS, "User group Deleted successfully");
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
