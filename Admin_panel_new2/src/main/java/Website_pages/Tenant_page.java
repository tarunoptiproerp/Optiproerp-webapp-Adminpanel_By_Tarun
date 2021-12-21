package Website_pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basepackage.Base_Class;
import utility.ExcelUtil;

public class Tenant_page extends Base_Class{
	
	Robot robot;

	public Tenant_page() throws IOException {
		super();
		
	}
	
	@FindBy(xpath="/html/body/app-root/app-sidebar/div/nav/ul/li[5]/a")
	WebElement tenant_menu;
	
	
	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[1]/h4")
	WebElement title;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[2]/div/form/div/div/div/div/input")
	WebElement Search_Field;

	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[2]/div/form/div/div/div/div/div/button")
	WebElement Search_btn;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[2]/div/form/div/div/div/button")
	WebElement Add_tenant_btn;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[2]/div/form/div/div/div/button")
	WebElement Export_btn;
	
	/* Add Form Element
	@FindBy(xpath="")
	WebElement XYX;
	*/
	
	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[2]/form/div/div[1]/form/div/div/div/div/div/input")
	WebElement Tenant_name;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[2]/form/div/div[1]/div[2]/kendo-grid[1]")
	WebElement product_grid;
	
	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]/label[1]/label[1]")
	WebElement Enable_filter_Product_table;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/kendo-grid[1]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[2]/td[2]/kendo-grid-string-filter-cell[1]/kendo-grid-filter-wrapper-cell[1]/input[1]")
	WebElement Product_code_search_input;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/label[1]")
	WebElement select_result_product;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement product_not_available;
	
	/*
	 * @FindBy(xpath=
	 * "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]")
	 * int available_license;
	 */	
	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]")
	WebElement available_license;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[2]/form/div/div[1]/div[2]/kendo-grid[1]/div/kendo-grid-list/div/div[1]/table/tbody/tr/td[5]/input")
	WebElement Assigned_count;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[2]/form/div/div[1]/div[2]/kendo-grid[2]")
	WebElement user_grid;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/kendo-grid[2]/kendo-grid-toolbar[1]/div[1]/label[1]/label[1]")
	WebElement Enable_filter_User_table;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/kendo-grid[2]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[2]/td[2]/kendo-grid-string-filter-cell[1]/kendo-grid-filter-wrapper-cell[1]/input[1]")
	WebElement User_code_search_input;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/kendo-grid[2]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement user_not_available;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/kendo-grid[2]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/label[1]")
	WebElement select_result_user;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[2]/form/div/div[2]/button[1]")
	WebElement Save_btn;
	
	@FindBy(xpath="/html/body/app-root/div/div/app-tenant/div/div[2]/form/div/div[2]/button[2]")
	WebElement cancel_btn;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/kendo-grid[1]/kendo-grid-toolbar[1]/div[1]")
	WebElement tenant_list_grid;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[2]/button[1]")
	WebElement update;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/form[1]/div[1]/div[2]/button[2]")
	WebElement Delete;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/kendo-dialog[1]/div[2]/kendo-dialog-actions[1]/button[1]")
	WebElement yes;
	
	@FindBy(xpath="/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/kendo-dialog[1]/div[2]/kendo-dialog-actions[1]/button[2]")
	WebElement No;
	
	public void Add_Tenant(XSSFRow row) throws InterruptedException, AWTException
	{
		robot = new Robot(); 
		tenant_menu.click();
		Add_tenant_btn.click();
		sleep();
		Tenant_name.sendKeys(row.getCell(0).toString());
		sleep();
//		Enable_filter_Product_table.click();\
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_ENTER);  
		robot.keyRelease(KeyEvent.VK_ENTER);
	
		Enable_filter_Product_table.click();	
		sleep();
		Product_code_search_input.sendKeys(row.getCell(1).toString());
		sleep();
		
		select_result_product.click();
		/*
		 * if(product_not_available.isDisplayed()) {
		 * System.out.println("product is not available"); cancel_btn.click(); } else {
		 */
			String count = available_license.getText();
			System.out.println(count);	
			
			if(count.equals("0")) 
			{
				Assigned_count.clear();
				System.out.println("License is not available");
				sleep();
			}
			else
			{
				Assigned_count.clear();
				sleep();
				Assigned_count.sendKeys(row.getCell(2).toString());
				sleep();
			}	
	
		Enable_filter_User_table.click();
		sleep();
		User_code_search_input.sendKeys(row.getCell(3).toString());
		sleep();
		
		/*
		 * if(user_not_available.isDisplayed()) {
		 * System.out.println("user is not available"); cancel_btn.click(); } else {}
		 */
			select_result_user.click();
			sleep();
			Save_btn.click();	
		}
		
	
	public void Verify_Update_Tenant(XSSFRow row) throws InterruptedException, Exception
	{
		tenant_menu.click();
		ExcelUtil.setExcelFileSheet("UpdateTenant");
		ExcelUtil.setRowNumber(2);
		sleep();
		
		Search_Field.click();
		Search_Field.clear();
		Search_Field.sendKeys(row.getCell(0).toString());

		tenant_list_grid.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")).click();
		sleep();
		update.click();
	}
	
	public void Verify_Delete_Tenant(XSSFRow row) throws InterruptedException, Exception
	{
		tenant_menu.click();
		ExcelUtil.setExcelFileSheet("DeleteTenant");
		ExcelUtil.setRowNumber(2);
		sleep();
		
		Search_Field.click();
		Search_Field.clear();
		Search_Field.sendKeys(row.getCell(0).toString());

		tenant_list_grid.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenant[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/kendo-grid[1]/div[1]/kendo-grid-list[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")).click();
		sleep();
		Delete.click();
		yes.click();
		
	}
	
	
	

}
