package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.LandingPage;
import pom.RegistrationPage;
import resource.Base;
import util.Xls_Reader;

public class RegistrationTest extends Base {
	
	public WebDriver driver;
	RegistrationPage register;
	LandingPage landing;
	Xls_Reader xlData;
	
	@BeforeClass
	public void beforeClass() throws IOException{
		
		driver = initializeDriver();
		String url = getBrowserData("Url");
		driver.get(url);
	}

	@BeforeMethod
	public void beforeMethod(){
		
		
	}
	
	@Test
	public void registrationWithValidCrediential() throws InterruptedException{
		
		landing = new LandingPage(driver);
		landing.clickOnMyAccount();
		landing.clickOnRegistration();
		register = new RegistrationPage(driver);
		
		String xlPath = System.getProperty("user.dir")+"\\src\\main\\java\\util\\for sel.xlsx";
		xlData = new Xls_Reader(xlPath);
		int rowCount = xlData.getRowCount("RegistrationDetails");
		for(int rowNum = 2;rowNum <= rowCount;rowNum++){
			
			String firstName = xlData.getCellData("RegistrationDetails", "First Name", rowNum);
			register.enterFirstName(firstName);
			String lastName = xlData.getCellData("RegistrationDetails", "Last Name", rowNum);
			register.enterLastName(lastName);
			String email = xlData.getCellData("RegistrationDetails", "Email", rowNum);
			register.enterEmail(email);
			String telephone = xlData.getCellData("RegistrationDetails", "Telephone", rowNum);
			register.enterTelephone(telephone);
			String passsword = xlData.getCellData("RegistrationDetails", "Password", rowNum);
			register.enterPassword(passsword);
			register.enterConfirmPassword(passsword);
			register.clickOnAgree();
			register.clickOnContinue();
			register.clearData();
			
			}
			
		}
		
		@AfterMethod
		public void afterMethod() {
		
		
		}
		
		@AfterClass
		public void afterClass() {
			
			driver.close();
		}
		
	
	
}
