package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath = "//a[text() = 'Login']")
	private WebElement login;
	
	public LandingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccount()
	{
		myAccount.click();
	}
	
	public void clickOnLogin()
	{
		login.click();
	}

}
