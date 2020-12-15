package testbase;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilities.TestUtil;
import utilities.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public TestBase() throws IOException  {
		
		FileInputStream f = new FileInputStream("D:\\Selenium_Workspace\\Pomfreamwork2\\src\\main\\java\\config\\config.properties");
		prop = new Properties();
		prop.load(f);	
	}
 public static void intilizaion() throws IOException {
	 
	 //---------------------------------Browser initialization--------------------------
	 
	 String browsername= prop.getProperty("browser");
	 
		 if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver.exe");
			 driver = new FirefoxDriver();	
			
		} else if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJars\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		} else {
			System.setProperty("webdriver.safari.driver", "D:\\SeleniumJars\\safaridriver");
			 driver = new SafariDriver();
		}
		 
		 //-------------------This section is use for generate log -----------------------------
		 e_driver= new EventFiringWebDriver(driver);
		 eventlistener = new WebEventListener();
		 e_driver.register(eventlistener);
		 driver=e_driver;
		 //-----------------------------------------------------------------------------------------
		 
		 //----------------------------some important initialization ----------------------------------
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait , TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get(prop.getProperty("url"));
		
 }
} 
