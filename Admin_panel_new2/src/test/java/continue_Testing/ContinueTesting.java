package continue_Testing;

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
import Website_pages.User_Group_page;
import Website_pages.User_Management_page;
import basepackage.Base_Class;
import utility.ExcelUtil;

public class ContinueTesting extends Base_Class {
	
	public Login_page logpage;
	public User_Group_page usrgrup;
	public ExtentTest test;
	public User_Management_page usrmang;
	public Roles_page rpage;
	public Authorization_page Auth;
	
	public ContinueTesting() throws IOException {
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

		usrmang = new User_Management_page();
		usrmang = PageFactory.initElements(driver, User_Management_page.class);
		
		rpage = new Roles_page();
		rpage = PageFactory.initElements(driver, Roles_page.class);
		
		Auth = new Authorization_page();
		Auth = PageFactory.initElements(driver, Authorization_page.class);	
	}
	
	
	@Test(priority=0)
	public void Verify_Usergroup() throws Exception
	{
		test = extent.createTest("User group somke testing");
		logpage.login(username, password);
		sleep();
		String Title = usrgrup.verify_page_title();
		Assert.assertEquals(Title, "User Group", "title is correct");
		test.log(Status.PASS, "Menus are working fine");
		sleep();
		usrgrup.verify_search("xyx");
		test.log(Status.PASS, "Search are working fine");
		sleep();
		usrgrup.verify_enable_filter();
		test.log(Status.PASS, "Filter are now enabled");
		sleep();
		usrgrup.verify_enable_grouping();
		test.log(Status.PASS, "Group Filter are now enabled");
		sleep();
		usrgrup.verify_export_Excel();
		test.log(Status.PASS, "User group exported successfully");
		sleep();
		
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserGroupAdd");

		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			usrgrup.Verify_addUserGroup(ExcelUtil.getRowData(i));
			sleep();
			refresh();
			Takescreenshot("Addusergroup"+i);
		}
		test.log(Status.PASS, "User group added successfully");
		
		
		XSSFSheet sheet1 = ExcelUtil.setExcelFileSheet("UserGroupUpdate");

		for (int i = 1; i < sheet1.getLastRowNum(); i++) {
			usrgrup.Verify_updateUserGroup(ExcelUtil.getRowData(i));
			sleep();
			refresh();
			Takescreenshot("Updateusergroup"+i);
		}
		test.log(Status.PASS, "User group Updated successfully");
		
		XSSFSheet sheet2 = ExcelUtil.setExcelFileSheet("UserGroupDelete");

		for (int i = 1; i < sheet2.getLastRowNum()+1; i++) {
			usrgrup.Verify_searchAndDeleteUserGroup(ExcelUtil.getRowData(i));
			sleep();
			refresh();
			Takescreenshot("Deleteusergroup"+i);
		}
		test.log(Status.PASS, "User group Deleted successfully");
			
	}
	
	@Test(priority=1)
	public void Verify_UserManagement() throws Exception
	{
		test = extent.createTest("User Management somke testing");
		logpage.login(username, password);
		sleep();
		
		String Title = usrmang.verify_page_title();
		Assert.assertEquals(Title, "User Management", "Title is correct");
		test.log(Status.PASS, "Title is correct");
		
		usrmang.verify_search("xyx");
		test.log(Status.PASS, "search is displaying result");
		sleep();
		
		usrmang.verify_enable_filter();
		sleep();
		test.log(Status.PASS, "Filter is now enabled");
		
		usrmang.verify_enable_grouping();
		sleep();
		test.log(Status.PASS, "grouping is now enabled");
		
		usrmang.verify_export_Excel();
		sleep();
		test.log(Status.PASS, "Excel is now exported");
		
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UserManagAdd");
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			usrmang.Verify_addUserManagement(ExcelUtil.getRowData(i));
			sleep();
			refresh();
			Takescreenshot("Add_user_management"+i);
		}
		test.log(Status.PASS, "User Mang is added successfully");
		
		sleep();
		
		XSSFSheet sheet1 = ExcelUtil.setExcelFileSheet("UserManagUpdate");
		for (int i = 1; i < sheet1.getLastRowNum()+1; i++) {
			usrmang.Verify_updateUsermanagement(ExcelUtil.getRowData(i));
			sleep();
			refresh();
			Takescreenshot("Update_user_management"+i);
		}
		test.log(Status.PASS, "User Mang is Updated successfully");
		sleep();
		XSSFSheet sheet2 = ExcelUtil.setExcelFileSheet("UserManagDelete");

		for (int i = 1; i < sheet2.getLastRowNum()+1; i++) {
			usrmang.Verify_searchAndDeleteUsermanage(ExcelUtil.getRowData(i));
			sleep();
			Takescreenshot("Delete_user_management"+i);
		}
		test.log(Status.PASS, "User Mang is Deleted successfully");
		
	}
	
	@Test(priority=2)
	public void Verify_Roles() throws Exception
	{
		test = extent.createTest("Verify Role page");
		logpage.login(username, password);
		sleep();
		
		String Title = rpage.verify_page_title();
		Assert.assertEquals(Title, "Roles", "title is correct");
		test.log(Status.PASS, "Title are correct");
		
		rpage.verify_search("xyx");
		sleep();
		test.log(Status.PASS, "Search is working fine");
		
		rpage.verify_enable_filter();
		sleep();
		test.log(Status.PASS, "filter is now Enabled");
		
		rpage.verify_enable_grouping();
		sleep();
		test.log(Status.PASS, "Group filter is now Enabled");
		
		rpage.verify_export_Excel();
		sleep();
		test.log(Status.PASS, "File exported successfully");
		
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("RoleAdd");
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			rpage.Verify_addRole(ExcelUtil.getRowData(i));
			refresh();
			sleep();
			Takescreenshot("Add_Roles"+i);
		}
		test.log(Status.PASS, "New Role Added successfully");
		
		XSSFSheet sheet1 = ExcelUtil.setExcelFileSheet("RoleUpdate");
		for (int i = 1; i < sheet1.getLastRowNum() + 1; i++) {
			rpage.Verify_updateRole(ExcelUtil.getRowData(i));
			refresh();
			sleep();
			Takescreenshot("Update_Roles"+i);
		}
		test.log(Status.PASS, "Role Updated successfully");
		
		XSSFSheet sheet2 = ExcelUtil.setExcelFileSheet("RoleDelete");
		for (int i = 1; i < sheet2.getLastRowNum()+1; i++) {
			rpage.Verify_DeleteRoles(ExcelUtil.getRowData(i));
			sleep();
			refresh();
			Takescreenshot("Delete_Roles"+i);
		}
		test.log(Status.PASS, "Role Deleted successfully");
		
	}
	
	@Test(priority=3)
	public void Verify_Authorization() throws Exception
	{
		test = extent.createTest("Verify Role page");
		logpage.login(username, password);
		sleep();
		
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("AuthAdd");
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			Auth.Add_auth(ExcelUtil.getRowData(i));
			refresh();
			sleep();
		
		}
		test.log(Status.PASS, "New Role Added successfully");
		
		XSSFSheet sheet1 = ExcelUtil.setExcelFileSheet("AuthUpdate");
		for (int i = 1; i < sheet1.getLastRowNum()+1; i++) {
			Auth.Update_auth(ExcelUtil.getRowData(i));
			sleep();
			refresh();
			Takescreenshot("UpdateAuth"+i);
		}
		
		XSSFSheet sheet2 = ExcelUtil.setExcelFileSheet("AuthDelete");
		for (int i = 1; i < sheet2.getLastRowNum()+1; i++) {
			Auth.Delete_auth(ExcelUtil.getRowData(i));
			sleep();
			refresh();
			Takescreenshot("DeleteAuth"+i);
		}	
		
		sleep();
		Auth.verify_export_Excel();
		test.log(Status.PASS, "Excel is now exported");
		
		sleep();
		String Title = Auth.verify_page_title();
		Assert.assertEquals(Title, "User Authorization", "Title is correct");
		test.log(Status.PASS, "Title is correct");
		
		sleep();
		Auth.verify_search("xyx");
		test.log(Status.PASS, "search is displaying result");
		sleep();
		
		sleep();
		Auth.verify_enable_filter();
		test.log(Status.PASS, "Filter is now enabled");
		
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
