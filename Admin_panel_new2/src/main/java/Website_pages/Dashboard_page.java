package Website_pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base_Class;

public class Dashboard_page extends Base_Class {
	
	public static WebDriver driver;
	public User_Group_page Usrgrp;
	public User_Management_page usrmang;
	public Roles_page role;
	public Authorization_page auth;
	public Tenant_page ten;
	public Connected_Users_page conusr;
	public Configuration_page config;
	
	public Dashboard_page() throws IOException {
		super();
		PageFactory.initElements(driver, this);	
	}

	@FindBy(xpath = "/html/body/app-root/div/div/app-main/div/div/div[2]/p")
	WebElement Welcome_message;

	@FindBy(xpath = "//div[@class='app-detail text-center']/p")
	WebElement msgWelcome;

	@FindBy(xpath = "	//*[@id='content-area']/app-header/nav/div/kendo-menu/ul/li/span/a/span[1]")
	WebElement profileIcon;

	@FindBy(xpath = "//button[text()='Logout']")
	WebElement btnLogout;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement btnYes;
	
	@FindBy(xpath="/html/body/app-root/app-sidebar/div/nav/ul/li[1]/a/span")
	WebElement User_group;
	
	@FindBy(xpath="/html/body/app-root/app-sidebar/div/nav/ul/li[2]/a/span")
	WebElement User_manage;
	
	@FindBy(xpath="/html/body/app-root/app-sidebar/div/nav/ul/li[3]/a/span")
	WebElement roles;
	
	@FindBy(xpath="/html/body/app-root/app-sidebar/div/nav/ul/li[4]/a/span")
	WebElement Authorization;
	
	@FindBy(xpath="/html/body/app-root/app-sidebar/div/nav/ul/li[5]/a/span")
	WebElement Tanant;
	
	@FindBy(xpath="/html/body/app-root/app-sidebar/div/nav/ul/li[6]/a/span")
	WebElement connectedusers;
	
	@FindBy(xpath="/html/body/app-root/app-sidebar/div/nav/ul/li[7]/a/span")
	WebElement configuration;

	
	
	public WebElement welcomeMsg() {
		return msgWelcome;

	}
	

	//--------------------For Logout------------------------
	public void Logout() throws IOException, InterruptedException {
		
		profileIcon.click();
		btnLogout.click();
		btnYes.click();

	}

	//--------------------For Check Menus------------------------
	public void checkMenus(WebDriver driver) throws IOException, InterruptedException {
		
		int linkscount = driver.findElements(By.tagName("a")).size();
		System.out.println(linkscount);

		for (int i = 0; i < linkscount - 1; i++) {
			String clicklinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
			driver.findElements(By.tagName("a")).get(i).sendKeys(clicklinks);
			// Thread.sleep(2000);
		}
		
		  Set<String> tabs = driver.getWindowHandles(); Iterator<String> it =
		  tabs.iterator();
		  
		  while (it.hasNext()) {
		  
		  driver.switchTo().window(it.next());
		  driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		  System.out.println(driver.getTitle());
		  
		  }
		  
		  driver.switchTo().window(driver.getWindowHandle());
		 
		// Above is for use 
	}
	
		
	public User_Group_page verify_Usergroup(WebDriver driver) throws IOException, InterruptedException
	{
		
		User_group.click();
		System.out.println(driver.getTitle());
		
		return new User_Group_page();
	}
	
	public User_Management_page verify_UserManagement(WebDriver driver) throws IOException, InterruptedException
	{
		
		User_manage.click();
		System.out.println(driver.getTitle());
		return new User_Management_page();
	}
	
	public Roles_page verify_Roles(WebDriver driver) throws IOException, InterruptedException
	{
		
		roles.click();
		System.out.println(driver.getTitle());
		return new Roles_page();
	}
	public Authorization_page verify_Authorization(WebDriver driver) throws IOException, InterruptedException
	{
		
		Authorization.click();
		System.out.println(driver.getTitle());
		return new Authorization_page();
	}
	public Tenant_page verify_Tenant(WebDriver driver) throws IOException, InterruptedException
	{
	
		Tanant.click();
		System.out.println(driver.getTitle());
		return new Tenant_page();
	}
	public Connected_Users_page verify_connectedUsers(WebDriver driver) throws IOException, InterruptedException
	{
		
		connectedusers.click();
		System.out.println(driver.getTitle());
		return new Connected_Users_page();
	}
	public Configuration_page verify_Configuration(WebDriver driver) throws IOException, InterruptedException
	{
		
		configuration.click();
		System.out.println(driver.getTitle());
		return new Configuration_page();
	}
	
	
	

}
