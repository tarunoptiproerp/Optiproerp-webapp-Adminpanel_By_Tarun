package Website_pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base_Class;

public class Authorization_page extends Base_Class {

	Dashboard_page dash;
	Robot robot;
	
	public Authorization_page() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		dash = new Dashboard_page();
	}
	
	@FindBy(xpath="/html/body/app-root/app-sidebar/div/nav/ul/li[4]/a")
	WebElement authlink;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[1]/h4")
	WebElement title;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/form/div/div/div/div/input")
	WebElement Search_Field;

	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/form/div/div/div/div/div/button")
	WebElement Search_btn;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/form/div/div/div/button")
	WebElement Add_auth_btn;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div/kendo-grid/kendo-grid-toolbar/div/label[1]/span[1]")
	WebElement enable_filter;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div/kendo-grid/kendo-grid-toolbar/div/label[2]/span[1]")
	WebElement enable_grouping;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div/kendo-grid/kendo-grid-toolbar/div/button")
	WebElement Export_btn;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div/kendo-grid")
	WebElement grid;
	
	@FindBy(xpath ="//kendo-dropdownlist[@id='user_group']/span[@class='k-dropdown-wrap k-state-default']")
	WebElement user_group;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[1]/kendo-splitter/kendo-splitter-pane[1]/div[2]/div/div/input")
	WebElement Tenant;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[1]/kendo-splitter/kendo-splitter-pane[1]/div[3]/div/div/kendo-grid/kendo-grid-toolbar/div/label[1]/span[1]")
	WebElement role_enable_filter_checkbox;
	
   @FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[1]/kendo-splitter/kendo-splitter-pane[1]/div[3]/div/div/kendo-grid/div/div/div/table/thead/tr[2]/td[2]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input")
   WebElement role_inputforsearch;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[1]/kendo-splitter/kendo-splitter-pane[1]/div[3]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr/td[1]/div/label")
	WebElement Rolecheckbox;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[1]/kendo-splitter/kendo-splitter-pane[1]/div[4]/div/div[1]/div/div/div/button")
	WebElement Search_user_id;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/kendo-dialog/div[2]/div/div/kendo-grid/kendo-grid-toolbar/div/label[1]/span[1]")
	WebElement popup_enable_filter_checkbox;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/kendo-dialog/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr")
	WebElement useridRow;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/kendo-dialog/div[2]/div/div/kendo-grid/div/div/div/table/thead/tr[2]/td[1]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input")
	WebElement popup_userid_field;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[1]/kendo-splitter/kendo-splitter-pane[1]/div[4]/div/div[2]/div/button")
	WebElement user_id_add;
	
	@FindBy (xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[1]/kendo-splitter/kendo-splitter-bar/div[1]")
	WebElement spliter;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[1]/kendo-splitter/kendo-splitter-pane[2]/div/div[1]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr/td[2]/button")
	WebElement user_id_delete;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[2]/button[1]")
	WebElement Savebtn;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[2]/button[2]")
	WebElement Cancelbtn;
	// When update or delete 
	///html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[2]/button[3]
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[2]/button[1]")
	WebElement update_btn;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div[2]/button[2]")
	WebElement delete_btn;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/kendo-dialog/div[2]/kendo-dialog-actions/button[1]")
	WebElement btn_Delete_Yes;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-authorization/kendo-dialog/div[2]/kendo-dialog-actions/button[2]")
	WebElement btn_Delete_No;
	
	@FindBy(xpath = "//td[contains(.,'No records available.')]")
	WebElement No_Record_available;
	
	public void Add_auth(XSSFRow row) throws IOException, InterruptedException, AWTException
	{
		authlink.click();
		sleep();
		Add_auth_btn.click();
		sleep();
		user_group.click();
		robot(KeyEvent.VK_DOWN);
		robot(KeyEvent.VK_DOWN);
		robot(KeyEvent.VK_ENTER);
		
		sleep();
		Tenant.sendKeys(row.getCell(0).toString());
		
		role_enable_filter_checkbox.click();
		role_inputforsearch.sendKeys(row.getCell(1).toString());
		
		Rolecheckbox.click();
		sleep();
		Search_user_id.click();
		//Execute_java_script("window.scrollBy(0,1000)");
		sleep();
		popup_enable_filter_checkbox.click();
		sleep();
		popup_userid_field.sendKeys(row.getCell(2).toString());
		sleep();
		useridRow.click();
		sleep();
		user_id_add.click();
		sleep();
		spliter.click();
		sleep();
		Savebtn.click();
		Takescreenshot("Add Authorization");
	}
	
	public void Update_auth(XSSFRow row) throws IOException, InterruptedException, AWTException
	{
		authlink.click();
		sleep();
		String auth = row.getCell(0).toString();
		Search_Field.sendKeys(auth);
		sleep();
		Search_btn.click();
		sleep();
		grid.findElement(By.xpath("/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]")).click();
		sleep();
		update_btn.click();
		authlink.click();
	}
	
	public void Delete_auth(XSSFRow row) throws IOException, InterruptedException, AWTException
	{
		authlink.click();
		sleep();
		String auth = row.getCell(0).toString();
		Search_Field.sendKeys(auth);
		sleep();
		Search_btn.click();
		sleep();
		grid.findElement(By.xpath("/html/body/app-root/div/div/app-user-authorization/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]")).click();
		sleep();
		delete_btn.click();
		btn_Delete_Yes.click();
		authlink.click();
	}
	
	public void verify_export_Excel() throws AWTException, InterruptedException {
		authlink.click();
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
		 
		 Export_btn.click();
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
	}
	
	public String verify_page_title() {
		authlink.click();
		String pagetitle = title.getText();
		return pagetitle;
	}
	
	public void verify_search(String user_name) {
		authlink.click();
		Search_Field.clear();
		Search_Field.sendKeys(user_name);
		//Search_button.click();
		String message = No_Record_available.getText();
		if (!message.matches("No records available.")) {
			System.out.println("Record displaying in screen");

		} else {
			System.out.println("No record available with this string");
		}

	}

	public void verify_enable_filter() {
		authlink.click();
		if (!enable_filter.isSelected()) {
			enable_filter.click();
			System.out.println("Filter is now enabled");
		} else {
			System.out.println("Filter is already enabled");
		}
	}

	public void verify_enable_grouping() {
		authlink.click();
		if (!enable_grouping.isSelected()) {
			enable_grouping.click();
			System.out.println("grouping is now enabled");
		} else {
			System.out.println("Filter is already enabled");
		}
	}
	
	
}
