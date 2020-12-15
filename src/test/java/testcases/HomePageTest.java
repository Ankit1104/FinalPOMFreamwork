package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage Hp;
	LoginPage Lp;
	TestUtil Tu ;

	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		intilizaion();
		 Lp = new LoginPage();
		 Tu = new TestUtil();
		 Hp = new HomePage();
		 Lp.login(prop.getProperty("username"), prop.getProperty("password"));
		 
	}
	@DataProvider
	public Object[][] getdata() {
		Object[][] data= TestUtil.gettestdata();
		return data;
	}
	
	@Test( dataProvider= "getdata")
	public void newcontacttest(String FirstName, String LastName, String Company ) {
		//Hp.createnewcontact("Ankit1", "Gajera1", "Amazon");
		
		Hp.createnewcontact(FirstName, LastName, Company);
	}
	
	
	@AfterMethod
	public void quit() {
		driver.quit();
}
}