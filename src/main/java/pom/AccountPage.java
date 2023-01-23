package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	@FindBy(xpath = "//a[text()='Edit your account information']")
	private WebElement editYourAccountInfo;
	
	public AccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void editYourAccountInfo()
	{
		editYourAccountInfo.isDisplayed();
		
	}

}
