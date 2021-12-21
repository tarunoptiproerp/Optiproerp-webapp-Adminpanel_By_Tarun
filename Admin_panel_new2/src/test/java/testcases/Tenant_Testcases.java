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
import com.aventstack.extentreports.Status;

import Website_pages.Dashboard_page;
import Website_pages.Login_page;
import Website_pages.Tenant_page;
import basepackage.Base_Class;
import utility.ExcelUtil;

public class Tenant_Testcases extends Base_Class {
	
	public Tenant_page ten;
	public Login_page logpage;
	public ExtentTest test;
	
	
	public Tenant_Testcases() throws IOException {
		super();
		
	}
	String username = prop.getProperty("Username");
	String password = prop.getProperty("Password");
	
	@BeforeTest
	public void initExtentreport() throws IOException
	{
		ExtentReports();
		
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialzation();
		logpage = new Login_page();
		ten = new Tenant_page();
		ten = PageFactory.initElements(driver, Tenant_page.class);
	}
	
	
	@Test(priority=1)
	public void Verify_Add_Tenant() throws Exception
	{
		
		test = extent.createTest("TC1_Verify Add Tenant");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("AddTenant");
		
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			ten.Add_Tenant(ExcelUtil.getRowData(i));
			sleep();
			refresh();
		}
		test.log(Status.PASS, "New Tenant Added successfully");
	}
	
	@Test(priority=2)
	public void Verify_UpdateTenant() throws InterruptedException, Exception 
	{
		test = extent.createTest("TC2_Verify Update Tenant");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("UpdateTenant");

		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
			ten.Verify_Update_Tenant(ExcelUtil.getRowData(i));
			sleep();
			refresh();
		}
		test.log(Status.PASS, "User is Updated successfully");
	
	}
	
	@Test(priority=3)
	public void Verify_DeleteTenant() throws InterruptedException, Exception 
	{
		test = extent.createTest("TC3_Verify DeleteTenant");
		logpage.login(username, password);
		sleep();
		XSSFSheet sheet = ExcelUtil.setExcelFileSheet("DeleteTenant");

		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
			ten.Verify_Delete_Tenant(ExcelUtil.getRowData(i));
			sleep();
		}
		test.log(Status.PASS, "Tenant is Deleted successfully");	
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
