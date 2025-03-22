package pageobjectclasses;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonpage{
	
	
	String baseUrl = "https://thinking-tester-contact-list.herokuapp.com/";
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public commonpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	    @FindBy(id = "signup")
	    private WebElement Signup;
	
	    @FindBy(id = "email")
	    private WebElement emailField;
	    
	    @FindBy(id = "password")
	    private WebElement passwordField;
	    
	    @FindBy(id = "submit")
	    private WebElement loginButton;
	    
	    @FindBy(css = ".error")
	    private WebElement errorMessage;
	    
	    
	    public void launchApp() {
	    	driver.get(baseUrl);
	    	driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }
	    
	    public void clicksignup1() {
	    	Signup.click();
	    }
	    
	    
	    public void enterEmail(String email) {
	        emailField.sendKeys(email);
	    }
	    
	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }
	    
	    public void clickLogin() {
	        loginButton.click();
	    }
	    
	    public String getErrorMessage() {
	        return errorMessage.getText();
	    }
	}

