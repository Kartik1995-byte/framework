package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	@FindBy (xpath = "//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy (xpath = "//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy (xpath = "//input[@id='input-email']")
	private WebElement email;
	
	@FindBy (xpath = "//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy (xpath = "//input[@id='input-password']")
	private WebElement inputPassword;
	
	@FindBy (xpath = "//input[@id='input-confirm']")
	private WebElement passwordConfirm;
	
	@FindBy (xpath = "//input[@name='agree']")
	private WebElement agree;
	
	@FindBy (xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	public RegistrationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String FirstName){
		firstName.sendKeys(FirstName);
	}
	
	public void enterLastName(String LastName){
		lastName.sendKeys(LastName);
	}

	public void enterEmail(String Email){
		email.sendKeys(Email);
	}
	
	public void enterTelephone(String Telephone){
		telephone.sendKeys(Telephone);
	}
	
	public void enterPassword(String Password){
		inputPassword.sendKeys(Password);
	}
	
	public void enterConfirmPassword(String Password){
		passwordConfirm.sendKeys(Password);
	}
	
	public void clickOnAgree(){
		agree.click();
	}
	
	public void clickOnContinue(){
		continueButton.click();
	}
	
	public void clearData() {
	
		firstName.clear();
		lastName.clear();
		email.clear();
		telephone.clear();
		inputPassword.clear();
		passwordConfirm.clear();
	}	
	
	
}
