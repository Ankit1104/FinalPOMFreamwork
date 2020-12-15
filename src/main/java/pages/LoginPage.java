package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import testbase.TestBase;
import utilities.TestUtil;

public class LoginPage extends TestBase {
	
	TestUtil Tu = new TestUtil();

	//Page Factory : OR (object repo)
	@FindBy (xpath= "//input[@type='text']")
	WebElement email;
	@FindBy (xpath= "//input[@type='password']")
	WebElement password;
	@FindBy (xpath ="//div[@class='ui fluid large blue submit button']")
	WebElement login;

	public LoginPage() throws IOException {

		PageFactory.initElements(driver, this);
	}
   
	
	public String checktitle() {
		
		return driver.getTitle();
	}
	
	public HomePage login(String a, String b) throws IOException {
		
		email.sendKeys(a);
		password.sendKeys(b);
		login.click();
		
		return new HomePage();
		
	}
	@DataProvider
	public Object[][] testingdata() {
		
		Object data[][]= Tu.gettestdata();
		return data;
		
	}
	
	
	
	
	
	
	

	
	
	
	
	
	

	

}
