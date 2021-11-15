package Website_pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base_Class;
import utility.ExcelUtil;


public class User_Management_page extends Base_Class  {

	WebDriver driver;
	Robot robot;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-sidebar[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/span[1]")
	WebElement User_management;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-management/div/div[1]/h4")
	WebElement page_title;

	@FindBy(xpath = "//input[contains(@type,'text')]")
	WebElement Search_input;
	

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/div/div[2]/div/form/div/div/div/div/div/button")
	WebElement Search_button;

	@FindBy(xpath = "//td[contains(.,'No records available.')]")
	WebElement No_Record_available;

	@FindBy(css = ".btn.btn-success.btn-sm.ml-2.btn-icon")
	WebElement btnAdd;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/div[1]/div[1]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/label[1]/span[1]")
	WebElement checkbox_enable_Filter;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/div[1]/div[1]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/label[2]/span[1]")
	WebElement checkbox_enable_grouping;

	@FindBy(xpath="/html/body/app-root/div/div/app-user-management/div/div[2]/div/div/kendo-grid/kendo-grid-toolbar/div/button")
	WebElement export_button;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/form[1]/div[1]/div[1]/kendo-splitter[1]/kendo-splitter-pane[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement user_id;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/form[1]/div[1]/div[1]/kendo-splitter[1]/kendo-splitter-pane[1]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]")
	WebElement user_name;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/form[1]/div[1]/div[1]/kendo-splitter[1]/kendo-splitter-pane[1]/div[1]/div[2]/div[1]/div[1]/div[3]/input[1]")
	WebElement password;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-management[1]/div[1]/div[2]/form[1]/div[1]/div[1]/kendo-splitter[1]/kendo-splitter-pane[1]/div[1]/div[2]/div[1]/div[1]/div[4]/input[1]")
	WebElement reenter_password;

	@FindBy(xpath ="//kendo-dropdownlist[@id='user_group']/span[@class='k-dropdown-wrap k-state-default']")
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
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-pane[2]/div/div/div[1]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[2]/td[2]")
	WebElement product_table;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-pane[2]/div/div/div[1]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[2]/td[2]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[1]/label/input")
	WebElement product1;
	
	@FindBy(css ="span.k-dropdown-wrap.k-state-default")
	WebElement usertype;
	
	@FindBy(id="k-63d5d864-6726-4139-aceb-2bbd0699ade0")
	WebElement employee;
	
	@FindBy(xpath ="/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-pane[2]/div/div/div[1]/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr/td[7]/kendo-dropdownlist/span/span[1]")
	WebElement Business_partner;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-management/div/div[2]/div/div/kendo-grid/div/kendo-grid-list")
	WebElement UM_list_grid;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[2]/button[1]")
	WebElement Update_btn;
	
	@FindBy(xpath = "//button[contains(.,'Delete')]")
	WebElement btn_Delete;
	

	@FindBy(xpath = "//button[contains(.,'Yes')]")
	WebElement btn_Delete_Yes;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-group/kendo-dialog/div[2]/kendo-dialog-actions/button[2]")
	WebElement btn_Delete_No;
	
	@FindBy (xpath="/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[1]/kendo-splitter/kendo-splitter-bar/div[1]")
	WebElement spliter;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[2]/button[1]")
	WebElement Savebtn;
	
	@FindBy(xpath = "/html/body/app-root/div/div/app-user-management/div/div[2]/form/div/div[2]/button[2]")
	WebElement Cancelbtn;
	
	@FindBy(xpath = "//i[contains(@class,'k-icon k-i-copy')]")
	WebElement copy_record;
	
	
	public User_Management_page() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public void clicklink()
	{
		User_management.click();
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
		//Search_button.click();
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
		 
		 export_button.click();
		 sleep();
		 robot.keyPress(KeyEvent.VK_CONTROL); 
		 robot.keyPress(KeyEvent.VK_J);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_J);
		 
		 robot.keyPress(KeyEvent.VK_CONTROL); // robot.keyPress(KeyEvent.VK_SHIFT);
		 robot.keyPress(KeyEvent.VK_TAB); 
		 robot.keyRelease(KeyEvent.VK_CONTROL); // robot.keyPress(KeyEvent.VK_SHIFT);
		 robot.keyRelease(KeyEvent.VK_TAB); 
	}

	public void Verify_addUserManagement(XSSFRow row) throws InterruptedException, AWTException {

		User_management.click();
		sleep();
		btnAdd.click();
		pageload();
		user_id.sendKeys(row.getCell(0).toString());
		sleep();
		user_name.sendKeys(row.getCell(1).toString());
		sleep();
		password.sendKeys(row.getCell(2).toString());
		sleep();
		reenter_password.sendKeys(row.getCell(3).toString());
		/*
		 * sleep(); websiteload();
		 */
		
		/*
		 * user_group.sendKeys(row.getCell(4).toString()); sleep();
		 * mapped_SAP_B1_user.sendKeys(row.getCell(5).toString()); sleep();
		 */
		/*
		 * mapped_SAP_B1_password.clear();
		 * mapped_SAP_B1_password.sendKeys(row.getCell(6).toString());
		 */
		
		robot(KeyEvent.VK_TAB);
		robot(KeyEvent.VK_DOWN);
		robot(KeyEvent.VK_DOWN);
		sleep();
		Tenant.sendKeys(row.getCell(6).toString());
		sleep();
		spliter.click();
	//	Status.click(); For status need to check 
		sleep();
		select_DB_Checkbox.click();
		expand.click();
		sleep();
		usertype.sendKeys(row.getCell(7).toString());
		Business_partner.click();
		sleep();
		robot(KeyEvent.VK_DOWN);
		robot(KeyEvent.VK_ENTER);
		sleep();
		product_table.findElement(By.xpath("(//span[contains(@class,'checkbox')])[4]")).click();
		sleep();
		Savebtn.click();	
	}

	
	public void Verify_updateUsermanagement(XSSFRow row) throws Exception {
		User_management.click();
		ExcelUtil.setExcelFileSheet("UserManagUpdate");
		ExcelUtil.setRowNumber(2);
		sleep();
		Search_input.click();
		Search_input.clear();
		Search_input.sendKeys(row.getCell(0).toString());

		UM_list_grid.findElement(By.xpath("/html/body/app-root/div/div/app-user-management/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]")).click();
		sleep();
		Update_btn.click();
	}

	public void Verify_searchAndDeleteUsermanage(XSSFRow row) throws Exception {
		
		User_management.click();
		ExcelUtil.setExcelFileSheet("UserManagDelete");
		ExcelUtil.setRowNumber(2);
		sleep();
		Search_input.click();
		Search_input.clear();
		Search_input.sendKeys(row.getCell(0).toString());
		UM_list_grid.findElement(By.xpath("/html/body/app-root/div/div/app-user-management/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]")).click();
		btn_Delete.click();
		btn_Delete_Yes.click();
		
	}

}
