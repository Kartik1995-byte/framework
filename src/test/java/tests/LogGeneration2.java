package tests;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class LogGeneration2 extends Base{
	public WebDriver driver;
	Properties prop;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	Logger log;
	
	@BeforeClass
	public void beforeClass() throws IOException{
		
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException{
		
		log = LogManager.getLogger(LogGeneration2.class.getName());
		driver = initializeDriver();
		log.debug("Browser got lounched");
		String url = getBrowserData("Url");
		driver.get(url);
		log.debug("Navigate to application Url");
	}
	
	@Test(dataProvider="getLoginData")
	public void loginGen2(String email, String password, String expectedResult) throws IOException{		
		
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccount();
		log.debug("Clicked on My account dropdown");
		landingPage.clickOnLogin();
		log.debug("Clicked on login option");
		
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email); 
		log.debug("Email addressed got entered");
		loginPage.enterPassword(password);
		log.debug("Password got entered");
		loginPage.clickOnLogin();
		log.debug("Click on login button");
		
		accountPage = new AccountPage(driver);
		String actualResult;
		try {
		accountPage.editYourAccountInfo();
		log.debug("User got logged in");
		actualResult = "Successfull";
		
		}
		catch(Exception e){
			
			log.debug("User didn't log in");
			actualResult = "Failure";
		}
		if(actualResult.equalsIgnoreCase(expectedResult)){
			
			log.info("Login Test got passed");
		}
		else{
			
			log.error("Login Test got failed");
		}
		
		
	}
	
	@AfterMethod
	public void afterMethod(){
		
		driver.close();
		log.debug("Browser got closed");
	}
	
	@AfterClass
	public void afterClass()
	{
		
	}

	@DataProvider
	public Object[][] getLoginData(){
		
		Object[][] data = {{"kart@gmail.com","Kart@123", "Successfull"}, {"some@fmg.com","dummy", "Failure"}};
		return data;
	}
}
