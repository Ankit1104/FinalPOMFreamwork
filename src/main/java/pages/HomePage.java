package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy (xpath = "//div[@id='main-nav']")
	WebElement Contacthover;
	
	@FindBy (xpath ="//span[contains(text(),'Contacts')]")
	WebElement ClickOnContact;
	
	@FindBy (xpath= "//button[contains(text(),'New')]")
	WebElement ClickOnNew;
	
	@FindBy (name= "first_name")
	WebElement Firstname;
	
	@FindBy (name= "last_name")
	WebElement Lastname;
	
	@FindBy (xpath= "//div[@name='company']/input")
	WebElement company;
	
	@FindBy (xpath= "//button[@class='ui linkedin button']")
	WebElement ClickOnSave;
	
	
	public HomePage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public void createnewcontact(String FN, String LN, String CN) {
		
		Actions builder = new Actions(driver);
		builder.moveToElement(Contacthover);
		ClickOnContact.click();
		ClickOnNew.click();
		Firstname.sendKeys(FN);
		Lastname.sendKeys(LN);
		company.sendKeys(CN);
		ClickOnSave.click();		
	}
	

}
