package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtil;

public class LoginTestcase extends TestBase{
	
	 // Object of login page class
	HomePage Hp;
	LoginPage Lp;
	TestUtil Tu ;
	
	public LoginTestcase() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		intilizaion();
		 Lp = new LoginPage();
		 Tu = new TestUtil();
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	 
	@Test (priority=1)
	public void checkpagetitletest() {
		String Title= Lp.checktitle();
		Assert.assertEquals(Title, "Cogmento CRM");
	}
	
	@Test (priority=2)
	public void logintest() throws InterruptedException, IOException {
		Hp= Lp.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
	//	String logout= driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).getText();
	//	System.out.println(logout);
	//	Assert.assertEquals(logout, "Log Out");
	}
	
	
		
	

}
