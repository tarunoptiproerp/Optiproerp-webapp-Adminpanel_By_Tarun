package Website_pages;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base_Class;
import utility.ExcelUtil;

public class User_Group_page extends Base_Class {

	
	WebDriver driver;
	Robot robot;
	
	@FindBy(xpath="/html/body/app-root/app-sidebar/div/nav/ul/li[1]/a/span")
	WebElement User_group;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-group/div/div[1]/h4")
	WebElement page_title;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div/div/div/div/input")
	WebElement Search_input;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div/div/div/div/div/button")
	WebElement Search_button;
	
	@FindBy(xpath="//*[@id=\"content-area\"]/div/app-user-group/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr/td")
	WebElement No_Record_available;
	
	@FindBy(css = ".btn.btn-success.btn-sm.ml-2.btn-icon")
	WebElement btnAdd;

	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-group[1]/div[1]/div[2]/div[1]/div[1]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/label[1]/span[1]")
	WebElement checkbox_enable_Filter;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-group[1]/div[1]/div[2]/div[1]/div[1]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/label[2]/span[1]")
	WebElement checkbox_enable_grouping;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-group/div/div[2]/div/div/kendo-grid/kendo-grid-toolbar/div/button")
	WebElement export_button;
	
	/*Below Elements are for Add User group admin */
	
	@FindBy(id = "UserGroupId")
	WebElement group_admin_name;

	@FindBy(xpath = "//*[@class='User group exists']")
	WebElement UserGroupExists;
	
	@FindBy(id = "UserGroupDesc")
	WebElement group_admin_Description;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div[1]/div/div/div[3]/kendo-dropdownlist/span")
	WebElement mapped_SAP_B1_user;
	
	@FindBy(id = "mapped_Password")
	WebElement mapped_SAP_B1_password;
	
	@FindBy(id="tenant")
	WebElement Tenant;
	
	@FindBy(id="/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div[1]/div/div/div[6]/div/label/input")
	WebElement checkbox_for_managerORAdmin;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div[2]/button[1]")
	WebElement btnSave;
	
	@FindBy(xpath ="/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div[2]/button[2]")
	WebElement btn_cancle;
	
	/*Below Elements is for update or delete the record */
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div[2]/button[1]")
	WebElement btn_Update;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div[2]/button[2]")
	WebElement btn_Delete;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/kendo-dialog/div[2]/kendo-dialog-actions/button[1]")
	WebElement btn_Delete_Yes;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/kendo-dialog/div[2]/kendo-dialog-actions/button[2]")
	WebElement btn_Delete_No;
	
	@FindBy(xpath = "//td[@role='gridcell']")
	WebElement Grid;

	@FindBy(tagName = "td")
	List<WebElement> tdcount;
	
	public User_Group_page() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	public String verify_page_title()
	{
		User_group.click();
		String pagetitle = page_title.getText();
		return pagetitle;
	}
	
	public void verify_search(String group_code)
	{
		User_group.click();
		Search_input.clear();
		Search_input.sendKeys(group_code);
		Search_button.click();
		String message = No_Record_available.getText();
		if(!message.matches("No records available."))
		{
			System.out.println("Record displaying in screen");
			
		}else
		{
			System.out.println("No record available with this string");
		}
		
		
	}
	
	public void verify_enable_filter()
	{
		User_group.click();
		if(!checkbox_enable_Filter.isSelected())
		{
		checkbox_enable_Filter.click();
		System.out.println("Filter is now enabled");
		}
		else
		{
			System.out.println("Filter is already enabled");
		}
	}
	
	public void verify_enable_grouping()
	{
		User_group.click();
		
		/*
		 * WebElement checkbox = driver.findElement(By.tagName("checkbox")); Dimension
		 * size = checkbox.getSize(); System.out.println(size);
		 */
		
		
		if(!checkbox_enable_grouping.isSelected())
		{
			checkbox_enable_grouping.click();
			System.out.println("grouping is now enabled");
		}
		else
		{
			System.out.println("Filter is already enabled");
		}
	}
	
	public void verify_export_Excel() throws AWTException, InterruptedException
	{
		User_group.click();
		sleep();
		
		 robot = new Robot(); 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_J);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_J);
		 
		 robot.keyPress(KeyEvent.VK_ALT); 
		 robot.keyPress(KeyEvent.VK_C);
		 robot.keyRelease(KeyEvent.VK_ALT); 
		 robot.keyRelease(KeyEvent.VK_C);
		 sleep();
		 robot.keyPress(KeyEvent.VK_CONTROL); // robot.keyPress(KeyEvent.VK_SHIFT);
		 robot.keyPress(KeyEvent.VK_TAB); 
		 robot.keyRelease(KeyEvent.VK_CONTROL); // robot.keyPress(KeyEvent.VK_SHIFT);
		 robot.keyRelease(KeyEvent.VK_TAB); 
		 sleep();
		 export_button.click();
		 sleep();
			/*
			 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_J);
			 * robot.keyRelease(KeyEvent.VK_CONTROL); robot.keyRelease(KeyEvent.VK_J);
			 */
			/*
			 * robot.keyPress(KeyEvent.VK_CONTROL); // robot.keyPress(KeyEvent.VK_SHIFT);
			 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_CONTROL); //
			 * robot.keyPress(KeyEvent.VK_SHIFT); robot.keyRelease(KeyEvent.VK_TAB);
			 */
			/*
			 * robot.keyRelease(KeyEvent.VK_CONTROL); // robot.keyPress(KeyEvent.VK_SHIFT);
			 * robot.keyRelease(KeyEvent.VK_F5);
			 */
		 
	}
	
	public void Verify_addUserGroup(XSSFRow row) throws InterruptedException {
		
		User_group.click();
		btnAdd.click();
		
		group_admin_name.sendKeys(row.getCell(0).toString());
		group_admin_Description.sendKeys(row.getCell(1).toString());
		sleep();
		// drpRole.click();
		System.out.println(row.getCell(2).toString());
		mapped_SAP_B1_user.sendKeys(row.getCell(2).toString());
		// drpRole.click();
		sleep();
		mapped_SAP_B1_password.sendKeys(row.getCell(3).toString());
		sleep();
		// Tenant.sendKeys(row.getCell(4).toString());
		
		btnSave.click();

	}

	public void Verify_updateUserGroup(XSSFRow row) throws Exception {
		User_group.click();
		sleep();
		Search_input.clear();
		sleep();
		Search_input.sendKeys(row.getCell(0).toString());
		sleep();
		Grid.click();
		sleep();
		group_admin_Description.clear();
		sleep();
		group_admin_Description.sendKeys(row.getCell(1).toString());
		sleep();
		mapped_SAP_B1_user.click();
		sleep();
		mapped_SAP_B1_user.sendKeys(row.getCell(2).toString());
		sleep();
		mapped_SAP_B1_password.sendKeys(row.getCell(3).toString());
		sleep();
		btnSave.click();

	}

	
	public void Verify_searchAndDeleteUserGroup(XSSFRow row) throws InterruptedException
	{ 
		User_group.click(); 
		sleep();
		String UserGroup = row.getCell(0).toString(); 
		Search_input.sendKeys(UserGroup);
		sleep();
		Grid.click();
		sleep();
		btn_Delete.click();
	  	sleep();
		btn_Delete_Yes.click();
		sleep();
		User_group.click();
	  }
	  
	  



}
