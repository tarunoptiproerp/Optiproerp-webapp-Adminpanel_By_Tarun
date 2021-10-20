package Website_pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base_Class;

public class User_Management_page extends Base_Class {

	WebDriver driver;
	Robot robot;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-sidebar[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/span[1]")
	WebElement User_management;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-management/div/div[1]/h4")
	WebElement page_title;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div/div/div/div/input")
	WebElement Search_input;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div/div/div/div/div/button")
	WebElement Search_button;

	@FindBy(xpath = "//*[@id=\"content-area\"]/div/app-user-group/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr/td")
	WebElement No_Record_available;

	@FindBy(css = ".btn.btn-success.btn-sm.ml-2.btn-icon")
	WebElement btnAdd;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-group[1]/div[1]/div[2]/div[1]/div[1]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/label[1]/span[1]")
	WebElement checkbox_enable_Filter;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-group[1]/div[1]/div[2]/div[1]/div[1]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/label[2]/span[1]")
	WebElement checkbox_enable_grouping;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/div/div[2]/div/div/kendo-grid/kendo-grid-toolbar/div/button")
	WebElement export_button;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/form[1]/div[1]/div[1]/kendo-splitter[1]/kendo-splitter-pane[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement user_id;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/form[1]/div[1]/div[1]/kendo-splitter[1]/kendo-splitter-pane[1]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]")
	WebElement user_name;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/form[1]/div[1]/div[1]/kendo-splitter[1]/kendo-splitter-pane[1]/div[1]/div[2]/div[1]/div[1]/div[3]/input[1]")
	WebElement password;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/form[1]/div[1]/div[1]/kendo-splitter[1]/kendo-splitter-pane[1]/div[1]/div[2]/div[1]/div[1]/div[4]/input[1]")
	WebElement reenter_password;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-pane[1]/div/div[2]/div[2]/div/div[1]/kendo-dropdownlist/span")
	WebElement user_group;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-pane[1]/div/div[2]/div[2]/div/div[2]/kendo-dropdownlist/span")
	WebElement mapped_SAP_B1_user;

	@FindBy(id = "mapped_user_password")
	WebElement mapped_SAP_B1_password;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-pane[1]/div/div[2]/div[2]/div/div[4]/input")
	WebElement Tenant;

	@FindBy(css = "input[ng-reflect-model=\"true\"]")
	WebElement Status;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/form[1]/div[1]/div[1]/kendo-splitter[1]/kendo-splitter-pane[2]/div[1]/div[1]/div[1]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/label[1]/span[1]")
	WebElement select_DB_Checkbox;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-pane[2]/div/div/div[1]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr/td[1]/a")
	WebElement expand;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-pane[2]/div/div/div[1]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[2]/td[2]")
	WebElement product_table;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-pane[2]/div/div/div[1]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[2]/td[2]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[1]/label/input")
	WebElement product1;
	
	@FindBy(css ="span.k-dropdown-wrap.k-state-default")
	WebElement usertype;
	
	@FindBy(xpath="//kendo-dropdownlist[@class='form-control-sm form-control w-100 k-widget k-dropdown k-header ng-touched ng-valid ng-dirty']/span[@class='k-dropdown-wrap k-state-default']")
	WebElement employee;
	
	public User_Management_page() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public String verify_page_title() {
		User_management.click();
		String pagetitle = page_title.getText();
		return pagetitle;
	}

	public void verify_search(String user_name) {
		User_management.click();
		Search_input.clear();
		Search_input.sendKeys(user_name);
		Search_button.click();
		String message = No_Record_available.getText();
		if (!message.matches("No records available.")) {
			System.out.println("Record displaying in screen");

		} else {
			System.out.println("No record available with this string");
		}

	}

	public void verify_enable_filter() {
		User_management.click();
		if (!checkbox_enable_Filter.isSelected()) {
			checkbox_enable_Filter.click();
			System.out.println("Filter is now enabled");
		} else {
			System.out.println("Filter is already enabled");
		}
	}

	public void verify_enable_grouping() {
		User_management.click();

		/*
		 * WebElement checkbox = driver.findElement(By.tagName("checkbox")); Dimension
		 * size = checkbox.getSize(); System.out.println(size);
		 */

		if (!checkbox_enable_grouping.isSelected()) {
			checkbox_enable_grouping.click();
			System.out.println("grouping is now enabled");
		} else {
			System.out.println("Filter is already enabled");
		}
	}

	public void verify_export_Excel() throws AWTException, InterruptedException {
		User_management.click();
		sleep();
		/*
		 * robot = new Robot(); robot.keyPress(KeyEvent.VK_CONTROL);
		 * robot.keyPress(KeyEvent.VK_J);
		 * 
		 * robot.keyPress(KeyEvent.VK_ALT); robot.keyPress(KeyEvent.VK_C);
		 * 
		 * robot.keyPress(KeyEvent.VK_CONTROL); // robot.keyPress(KeyEvent.VK_SHIFT);
		 * robot.keyPress(KeyEvent.VK_TAB); export_button.click();
		 * 
		 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_J);
		 */
	}

	public void Verify_addUserManagement(XSSFRow row) throws InterruptedException {

		User_management.click();
		sleep();
		btnAdd.click();
		
		user_id.sendKeys(row.getCell(0).toString());
		sleep();
		user_name.sendKeys(row.getCell(1).toString());
		sleep();
		password.sendKeys(row.getCell(2).toString());
		sleep();
		reenter_password.sendKeys(row.getCell(3).toString());
		sleep();
		user_group.sendKeys(row.getCell(4).toString());
		sleep();
		mapped_SAP_B1_user.sendKeys(row.getCell(5).toString());
		sleep();
		/*
		 * mapped_SAP_B1_password.clear();
		 * mapped_SAP_B1_password.sendKeys(row.getCell(6).toString());
		 */
		Tenant.sendKeys(row.getCell(6).toString());
		sleep();
	//	Status.click(); For status need to check 
		select_DB_Checkbox.click();
		expand.click();
		sleep();
		pageload();
		usertype.sendKeys(row.getCell(7).toString());
		websiteload();
		employee.click();
		employee.sendKeys(row.getCell(8).toString());
		sleep();
		product_table.findElement(By.xpath("/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-pane[2]/div/div/div[1]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[2]/td[2]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[1]/label/input")).click();
		//product1.click();

	}

}
