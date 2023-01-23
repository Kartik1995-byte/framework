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

public class ExampleDataProvider extends Base{
	public WebDriver driver;
	Properties prop;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		driver = initializeDriver();
		String url = getBrowserData("Url");
		driver.get(url);
	}
	
	@Test(dataProvider="getLoginData")
	public void loginData(String email, String password, String expectedResult) throws IOException
	{		
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccount();
		landingPage.clickOnLogin();
		
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email); 
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();
		
		accountPage = new AccountPage(driver);
		String actualResult;
		try {
		accountPage.editYourAccountInfo();
		actualResult = "Successfull";
		}
		catch(Exception e)
		{
			actualResult = "Failure";
		}
		
		Assert.assertEquals(actualResult, expectedResult);
		
		
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

	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data = {{"kart@gmail.com","Kart@123", "Successfull"}, {"some@fmg.com","dummy", "Failure"}};
		return data;
	}
}
