package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAddress;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void enterEmailAddress(String Email){
		emailAddress.sendKeys(Email);
	}
	
	public void enterPassword(String Password){
		password.sendKeys(Password);
	}
	
	public void clickOnLogin(){
		loginButton.click();
	}
}
