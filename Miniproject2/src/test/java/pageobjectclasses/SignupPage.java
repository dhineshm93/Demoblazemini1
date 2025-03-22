package pageobjectclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public SignupPage(WebDriver driver) {
		this.driver = driver;		
        PageFactory.initElements(driver, this);
	}
	
	    @FindBy(id = "firstName")
	    private WebElement firstNameField;
	    
	    @FindBy(id = "lastName")
	    private WebElement lastNameField;
	    
	    @FindBy(id = "email")
	    private WebElement emailField;
	    
	    @FindBy(id = "password")
	    private WebElement passwordField;
	    
	    @FindBy(id = "submit")
	    private WebElement signupButton;
	    
	    @FindBy(css = ".error")
	    private WebElement errorMessage;
	    
	    
	    public void enterFirstName(String firstName) {
	        firstNameField.sendKeys(firstName);
	    }
	    
	    public void enterLastName(String lastName) {
	        lastNameField.sendKeys(lastName);
	    }
	    
	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }
	    
	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }
	    
	    public void clickonSignupbutton() {
	    	wait.until(ExpectedConditions.visibilityOf(signupButton));
	    	System.out.println("✅ signup button is visible on the homepage.");
	    	signupButton.click();
	        //wait.until(ExpectedConditions.elementToBeClickable(signupButton));
	        //Assert.assertTrue(loginButton.isEnabled(), "❌ Log in button is NOT clickable on the homepage.");
	        System.out.println("✅ signup button is clickable on the homepage.");
	    	
	        
	    }
	    
	    public String getErrorMessage() {
	        return errorMessage.getText();
	    }
	}


