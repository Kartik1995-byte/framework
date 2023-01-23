package tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.AccountPage;
import pom.LandingPage;
import pom.LoginPage;
import resource.Base;

public class LoginTest extends Base{
	public WebDriver driver;
	Properties prop;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		driver = initializeDriver();
		String url = getBrowserData("Url");
		driver.get(url);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		
	}
	
	@Test
	public void login() throws IOException
	{		
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccount();
		landingPage.clickOnLogin();
		
		loginPage = new LoginPage(driver);
		String email = getBrowserData("Email");
		loginPage.enterEmailAddress(email);
		String password = getBrowserData("Password"); 
		loginPage.enterPassword(password);
		Assert.assertTrue(false);
		loginPage.clickOnLogin();
		
		
		
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}
	
	@AfterClass
	public void afterClass()
	{
		
	}

}
