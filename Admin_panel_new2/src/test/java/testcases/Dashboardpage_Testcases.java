package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Website_pages.Authorization_page;
import Website_pages.Configuration_page;
import Website_pages.Connected_Users_page;
import Website_pages.Dashboard_page;
import Website_pages.Login_page;
import Website_pages.Roles_page;
import Website_pages.Tenant_page;
import Website_pages.User_Group_page;
import Website_pages.User_Management_page;
import basepackage.Base_Class;

public class Dashboardpage_Testcases extends Base_Class {
	
	public Login_page logpage;
	public Dashboard_page dash;
	public User_Group_page Usrgrp;
	public User_Management_page usrmang;
	public Roles_page role;
	public Authorization_page auth;
	public Tenant_page ten;
	public Connected_Users_page conusr;
	public Configuration_page config;
	public ExtentTest test;
	
	
	
	String username = prop.getProperty("Username");
	String password = prop.getProperty("Password");
	
	public Dashboardpage_Testcases () throws IOException
	{
		super();
		Usrgrp = new User_Group_page();
		usrmang = new User_Management_page();
		role = new Roles_page();
		auth = new Authorization_page();
		ten = new Tenant_page();
		conusr = new Connected_Users_page();
		config = new Configuration_page();	
	}
	
	
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
		dash = new Dashboard_page();
		dash = PageFactory.initElements(driver, Dashboard_page.class);
	}
	
	@Test (priority=1)
	public void Verify_menus() throws IOException, InterruptedException
	{	
		test = extent.createTest("TC1_Verify Menus");
		logpage.login(username, password);
		sleep();
		dash.checkMenus(driver);
		test.log(Status.PASS, "Menus are working fine");
	}
	
	@Test (priority=2)
	public void Verify_UsergroupTest() throws IOException, InterruptedException
	{
		test = extent.createTest("TC2_Verify Usergroup");
		logpage.login(username, password);
		sleep();
		Usrgrp = dash.verify_Usergroup(driver);
		test.log(Status.PASS, "Usergroup Menus clicked successfully");
	}
	
	@Test (priority=3)
	public void Verify_UserManagementTest() throws IOException, InterruptedException
	{
		test = extent.createTest("TC3_Verify UserManagement");
		logpage.login(username, password);
		sleep();
		usrmang = dash.verify_UserManagement(driver);
		test.log(Status.PASS, "UserManagement Menus clicked successfully");
	}
	
	@Test (priority=4)
	public void Verify_RolesTest() throws IOException, InterruptedException
	{
		test = extent.createTest("TC4_Verify Roles");
		logpage.login(username, password);
		sleep();
		role = dash.verify_Roles(driver);
		test.log(Status.PASS, "Roles Menus clicked successfully");
	}
	
	
	@Test (priority=5)
	public void Verify_AuthorizationTest() throws IOException, InterruptedException
	{
		test = extent.createTest("TC5_Verify Authorization");
		logpage.login(username, password);
		sleep();
		auth = dash.verify_Authorization(driver);
		test.log(Status.PASS, "Authorization Menus clicked successfully");
	}
	
	@Test (priority=6)
	public void Verify_TenantTest() throws IOException, InterruptedException
	{
		test = extent.createTest("TC6_Verify Tenant");
		logpage.login(username, password);
		sleep();
		ten = dash.verify_Tenant(driver);
		test.log(Status.PASS, "Tenant Menus clicked successfully");
	}
	
	@Test (priority=7)
	public void Verify_ConnectedUsersTest() throws IOException, InterruptedException
	{
		test = extent.createTest("TC7_Verify ConnectedUsers");
		logpage.login(username, password);
		sleep();
		conusr = dash.verify_connectedUsers(driver);
		test.log(Status.PASS, "ConnectedUsers Menus clicked successfully");
	}
	
	@Test (priority=8)
	public void Verify_ConfigurationTest() throws IOException, InterruptedException
	{
		test = extent.createTest("TC8_Verify Configuration");
		logpage.login(username, password);
		sleep();
		config = dash.verify_Configuration(driver);
		test.log(Status.PASS, "Configuration Menus clicked successfully");
	}
	
	@Test (priority=9)
	public void Verify_logout() throws IOException, InterruptedException
	{
		test = extent.createTest("TC9_Verify Log-out");
		logpage.login(username, password);
		sleep();
		dash.Logout();
		test.log(Status.PASS, "Admin Logged out successfully");
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
