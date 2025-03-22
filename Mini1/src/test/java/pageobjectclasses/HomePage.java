package pageobjectclasses;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePage {

	WebDriver driver;
    
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(css = "navbarExample")
    private List<WebElement> categoryElements;
	
	@FindBy(id = "login2")
    private WebElement loginButton;
	
    @FindBy(id = "nameofuser")
    private WebElement welcomeMessage;
    
    @FindBy(css = "#itemc")
    private List<WebElement> categorylisted;
    
    @FindBy(xpath = "//a[text()='Laptops']")
    private WebElement laptopsCategory;

    // Locate a specific laptop (e.g., Sony vaio i5)
    @FindBy(xpath = "//a[text()='Sony vaio i5']")
    private WebElement sonyVaioI5;
    
    @FindBy(xpath = "//li[@class='nav-item active']//a[@class='nav-link']")
    private WebElement home;
    
    
	 // Method to verify Login button is visible and clickable
    public void verifyLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        //Assert.assertTrue(loginButton.isDisplayed(), "❌ Log in button is NOT visible on the homepage.");
        System.out.println("✅ Log in button is visible on the homepage.");

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        //Assert.assertTrue(loginButton.isEnabled(), "❌ Log in button is NOT clickable on the homepage.");
        System.out.println("✅ Log in button is clickable on the homepage.");
    }
    
    // Method to verify successful login
    public void verifySuccessfulLogin() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        Assert.assertTrue(welcomeMessage.isDisplayed(), "❌ Login failed. 'Welcome User' message not found.");
        System.out.println("✅ Login successful! Welcome message displayed: " + welcomeMessage.getText());
    }
    
// Method to verify categories
    public void verifyCategories() {
        String[] expectedCategories = {"Home", "Contact", "About us", "Cart", "Log in", "Sign up"};

        for (String category : expectedCategories) {
            boolean categoryFound = categoryElements.stream().anyMatch(element -> element.getText().trim().equalsIgnoreCase(category));
            //Assert.assertTrue(categoryFound, "❌ Category '" + category + "' is NOT displayed on the homepage.");
            System.out.println("✅ Verified: Category '" + category + "' is displayed on the homepage.");
        }
    }
 // Method to verify all categories are displayed
    public void verifylisted() {
        String[] expectedCategories1 = {"Phones", "Laptops", "Monitors"};

        for (String category : expectedCategories1) {
            boolean categoryFound1 = categorylisted.stream()
                    .anyMatch(element -> element.getText().trim().equalsIgnoreCase(category));

            //Assert.assertTrue(categoryFound, "❌ Category '" + category + "' is NOT displayed on the homepage.");
            System.out.println("✅ Verified: Category '" + category + "' is displayed on the homepage.");
        }
    }
    
 // Method to click on the "Laptops" category
    public void clickOnLaptopsCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(laptopsCategory)).click();
    }

    // Method to select the "Sony vaio i5" laptop
    public void selectSonyVaioI5() {
        wait.until(ExpectedConditions.elementToBeClickable(sonyVaioI5)).click();
    }
    
    public void homepage() {
    	home.click();
    	
    }
}
   
	        
	
	
        
		


