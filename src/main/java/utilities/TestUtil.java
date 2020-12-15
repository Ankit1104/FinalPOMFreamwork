package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import data.Xls_Reader;
import testbase.TestBase;

public class TestUtil extends TestBase {

	public TestUtil() throws IOException {
		super();
	}

	public static long Page_load_timeout = 20;
	public static long implicit_wait = 10;
	
	public static Object[][] gettestdata() {
		   
		  Xls_Reader excel = new Xls_Reader("D:\\test.xlsx");
		
		  Object[][] data = new Object[excel.getRowCount("friend")-1][excel.getColumnCount("friend")];
		  
		  for(int i=0; i<excel.getRowCount("friend")-1; i++) {
			  for(int j=0; j<excel.getColumnCount("friend"); j++) {
				  
				  data[i][j]= excel.getCellData("friend", j, (i+2));
				  
				  System.out.println(data[i][j]);
				  
			  }
		  }
		  
		  return data;
		    	
		     
		    }

	public static void takeScreenshotAtEndOfTest() throws IOException {
		
		 File scrnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       FileUtils.copyFile(scrnshot, new File("D:/testing/"+System.currentTimeMillis()+".png"));
	       
	     //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  // This line is for WebDriver
	      // File scrnshot = driver.getScreenshotAs(OutputType.FILE); this is for FirefoxDriver  driver = new FirefoxDriver 
	}

	  }
	
	
	
	
	
	

