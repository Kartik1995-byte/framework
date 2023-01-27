package tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.AccountPage;
import pom.LandingPage;
import pom.LoginPage;
import resource.Base;
import util.Xls_Reader;

public class LoginXlTest2 extends Base{
	
	public WebDriver driver;
	Properties prop;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	Xls_Reader xl;
	
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
	public void loginWithValidEmailAndPassword() throws IOException, InterruptedException{
		
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccount();
		landingPage.clickOnLogin();
		
		loginPage = new LoginPage(driver);
		String xlPath = System.getProperty("user.dir")+"\\src\\main\\java\\util\\for sel.xlsx";
		xl = new Xls_Reader(xlPath);
		String email = xl.getCellData("LoginDetails", "Email", 2);
		loginPage.enterEmailAddress(email);
		Thread.sleep(2000);
		String password = xl.getCellData("LoginDetails", "Password", 2); 
		loginPage.enterPassword(password);
		Thread.sleep(2000);
		loginPage.clickOnLogin();	
		
	}
	
	@AfterMethod
	public void afterMethod(){
		
	}
	
	@AfterClass
	public void afterClass(){
		
		driver.close();
	}

}
