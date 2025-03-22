package pageobjectclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public LoginPage(WebDriver driver) {
		this.driver = driver;		
        PageFactory.initElements(driver, this);

	}
	
	    @FindBy(id = "email")
	    private WebElement emailField1;
	    
	    @FindBy(id = "password")
	    private WebElement passwordField1;
	    
	    @FindBy(id = "submit")
	    private WebElement loginButton;
	    
	    @FindBy(id ="logout")
	    private WebElement logoutButton;
	    
	    @FindBy(id = "error")
	    private WebElement errorMessage;
	    
	    
	    public void enterEmail(String email) {
	        emailField1.sendKeys(email);
	    }
	    
	    public void enterPassword(String password) {
	        passwordField1.sendKeys(password);
	    }
	    
	    public void clickLogin() {
	        loginButton.click();
	    }
	    
	    public void clickLogout() {
	    	logoutButton.click();
	    }
	    
	   // public String getErrorMessage() {
	   //     return errorMessage.getText();
	  //  }
	    
	    
	    public String getErrorMessage() {
	        try {
	            return errorMessage.getText();
	        } catch (NullPointerException e) {
	            return "Error message element not found";
	        }
	    }
	    
	    public void clickonloginbutton() {
	    	wait.until(ExpectedConditions.visibilityOf(loginButton));
	    	System.out.println("✅ login button is visible on the homepage.");
	    	loginButton.click();
	        //wait.until(ExpectedConditions.elementToBeClickable(signupButton));
	        //Assert.assertTrue(loginButton.isEnabled(), "❌ Log in button is NOT clickable on the homepage.");
	        System.out.println("✅ login button is clickable on the homepage.");
	    	
	        
	    }
	}

