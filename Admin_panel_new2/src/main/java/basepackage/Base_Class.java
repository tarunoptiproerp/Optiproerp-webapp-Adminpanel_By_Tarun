package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Class {
	
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	
	
	public Base_Class() throws IOException
	{
		try {
			
			prop = new Properties();
			
			String File = System.getProperty("user.dir")+"\\src\\main\\java\\configuration\\configuration.properties";
			FileInputStream fp = new FileInputStream(File);
			prop.load(fp);
			
			
		}catch(NullPointerException e)
		{
			e.printStackTrace();
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialzation()
	{
		String browser = prop.getProperty("Browser_Name");
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Others\\Workspace\\Admin_Panel\\Admin_panel_new2\\browser_driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browser.equals("FF"))
			{
				System.setProperty("webdriver.gecko.driver", "");
				
			}else if(browser.equals("Edge"))
			{
				System.setProperty(browser, browser);
				
				
			}else
			{
				System.out.println("browser is not defind on configuration.properties file ");
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
			
	}
	
	public void websiteload()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	public void pageload()
	{
		driver.manage().timeouts().pageLoadTimeout(300000, TimeUnit.MILLISECONDS);
	//	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void sleep() throws InterruptedException
	{
		Thread.sleep(5000);
	}
	
	public static void ExtentReports()
	{
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Extenetreport.html");
		extent.attachReporter(spark);
	}
	
	public static void extentflush()
	{
		extent.flush();
	}

}
