package Website_pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import basepackage.Base_Class;

public class Roles_page extends Base_Class {

	public Roles_page() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/app-root/app-sidebar/div/nav/ul/li[3]/a/span")
	WebElement roles;

	@FindBy(css = ".btn.btn-success.btn-sm.ml-2.btn-icon")
	WebElement btnAdd;

	@FindBy(id = "RoleId")
	WebElement txtRoleId;

	@FindBy(xpath = "//*[@class='User group exists']")
	WebElement UserGroupExists;

	@FindBy(xpath = "//input[@id='search']")
	WebElement UserGroupSearch;

	@FindBy(id = "RoleDesc")
	WebElement txtRoleDescription;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-roles/div/div[2]/div/div[1]/form/div/div/div/div[3]/input")
	WebElement txtTenant;

	@FindBy(css = "button.btn.btn-primary.btn-sm.mr-2.btn-icon")
	WebElement btnSearch;

	@FindBy(xpath = "k-widget.k-window.k-dialog ng-trigger.ng-trigger-dialogSlideInAppear")
	WebElement productframe;

	@FindBy(xpath = "//div[@class='ng-star-inserted']//label[@class='custom-checkbox mb-0 mr-2 filter-checkbox']/span[@class='checkbox']")
	WebElement chkEnableFilter;

	@FindBy(xpath = "//*[@id='content-area']/div/app-user-roles/kendo-dialog/div[2]/div/div/kendo-grid/div/div/div/table/thead/tr[2]/td[1]/kendo-grid-string-filter-cell/kendo-grid-filter-wrapper-cell/input")
	WebElement txtProductId;

	@FindBy(xpath = "(//td[@class='ng-star-inserted'])[3]")
	WebElement ClickProductId;

	@FindBy(css = "button.btn.btn-success.btn-sm.d-flex.align-items-center.mr-2")
	WebElement btnSave;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-roles[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement Search_input;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-roles[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]/*[name()='use'][1]")
	WebElement Search_button;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-roles/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody")
	WebElement valGrid;

	@FindBy(tagName = "td")
	List<WebElement> tdcount;

	@FindBy(css = "button.btn.btn-danger.btn-sm.d-flex.align-items-center.mr-2")
	WebElement btnDelete;

	@FindBy(xpath = "//*[@id='content-area']/div/app-user-group/kendo-dialog/div[2]/kendo-dialog-actions/button[1]")
	WebElement btnYes;

	///// *[@id="content-area"]/div/app-user-roles/kendo-dialog/div[2]/kendo-dialog-actions/button[1]

	@FindBy(xpath = "html/body/app-root/div/div/app-user-roles/kendo-dialog/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr/td[1]")
	WebElement selectProduct;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-roles/div/div[2]/div/div[1]/form/div/div/div/div[4]/div/div/button[2]")
	WebElement add_product_in_list;

	@FindBy(xpath = "//tbody/tr[1]/td[2]/label[1]/span[1]")
	WebElement Permission_checkbox;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-roles/div/div[2]/div/div[2]/button[1]")
	WebElement Update_button;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-roles/div/div[2]/div/div[2]/button[2]")
	WebElement Delete_button;

	@FindBy(xpath = "/html/body/app-root/div/div/app-user-roles/div/div[2]/div/div[2]/button[3]")
	WebElement cancel_button;
	
	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-roles[1]/kendo-dialog[1]/div[2]/kendo-dialog-actions[1]/button[1]")
	WebElement btn_Delete_Yes;
	
	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-roles[1]/kendo-dialog[1]/div[2]/kendo-dialog-actions[1]/button[2]")
	WebElement btn_Delete_No;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-user-roles/div/div[1]/h4")
	WebElement page_title;
	
	@FindBy(xpath="//*[@id=\"content-area\"]/div/app-user-group/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr/td")
	WebElement No_Record_available;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-group[1]/div[1]/div[2]/div[1]/div[1]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/label[1]/span[1]")
	WebElement checkbox_enable_Filter;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-user-group[1]/div[1]/div[2]/div[1]/div[1]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/label[2]/span[1]")
	WebElement checkbox_enable_grouping;
	
	public String verify_page_title()
	{
		roles.click();
		String pagetitle = page_title.getText();
		return pagetitle;
	}
	
	public void verify_search(String group_code)
	{
		roles.click();
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
		roles.click();
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
		roles.click();
		
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
		roles.click();
		sleep();
	}

	public void Verify_addRole(XSSFRow row) throws InterruptedException {

		roles.click();
		btnAdd.click();
		sleep();
		txtRoleId.sendKeys(row.getCell(0).toString());
		txtRoleDescription.sendKeys(row.getCell(1).toString());
		txtTenant.sendKeys(row.getCell(2).toString());
		sleep();
		btnSearch.click();
		sleep();
		chkEnableFilter.click();
		sleep();
		txtProductId.click();
		txtProductId.sendKeys("CNF");
		sleep();
		selectProduct.click();
		sleep();
		add_product_in_list.click();
		sleep();
		Permission_checkbox.click();
		sleep();
		btnSave.click();
	}

	public void SearchRole(String user) throws InterruptedException {

		roles.click();
		sleep();
		Search_input.click();
		Search_input.clear();
		sleep();
		Search_input.click();
		Search_input.sendKeys(user);
		sleep();
		// Search_button.click();
		sleep();
	}

	public void Verify_updateRole(XSSFRow row) throws InterruptedException {

		roles.click();

		String Role = row.getCell(0).toString();
		SearchRole(Role);
		sleep();
		valGrid.findElement(By.xpath(
				"/html/body/app-root/div/div/app-user-roles/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr"))
				.click();
		/*
		 * txtRoleId.sendKeys(user);
		 * 
		 * // txtRoleDescription.sendKeys("user6"); // // //
		 * txtTenant.sendKeys("Batch@123");
		 * 
		 * btnSearch.click();
		 * 
		 * chkEnableFilter.click(); // BaseTest b=new BaseTest();
		 * //b.wait.until(ExpectedConditions.elementToBeClickable(txtProductId));
		 * txtProductId.click(); txtProductId.sendKeys("CVP"); Thread.sleep(1000);
		 * ClickProductId.click(); btnSave.click();
		 */
		Update_button.click();
		
		roles.click();

	}

	public void Verify_DeleteRoles(XSSFRow row) throws InterruptedException {

		roles.click();
		String Role = row.getCell(0).toString();
		SearchRole(Role);
		sleep();
		valGrid.findElement(By.xpath(
				"/html/body/app-root/div/div/app-user-roles/div/div[2]/div/div/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr"))
				.click();
		Delete_button.click();
		btn_Delete_Yes.click();
		
		roles.click();

	}

}
