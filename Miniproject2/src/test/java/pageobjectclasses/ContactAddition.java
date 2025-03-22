package pageobjectclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactAddition {
	
 WebDriver driver;

    
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public ContactAddition(WebDriver driver) {
		this.driver = driver;		
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="add-contact")
	private WebElement Newcontact;
	
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    
    @FindBy(id="lastName")
    private WebElement lastNameField;
    
    @FindBy(id="email")
    private WebElement emailField;
    
    @FindBy(id="phone")
    private WebElement phoneField;
    
    @FindBy(id="birthdate")
    private WebElement birthdateField;
    
    @FindBy(id = "submit")
    private WebElement submitButton;
    
    @FindBy(css = ".error")
    private WebElement errorMessage;
    
    public void AddNewcontact() {
    	Newcontact.click();
    }
    
    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }
    
    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    
    public void enterEmail(String email) {

    	emailField.sendKeys(email);
    }
    
    public void enterPhone(String phone) {
        phoneField.sendKeys(phone);
    }
    
    public void enterBirthdate(String birthdate) {
        birthdateField.sendKeys(birthdate);
    }
    
    public void clickSubmit() {
        submitButton.click();
    }
    
    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
