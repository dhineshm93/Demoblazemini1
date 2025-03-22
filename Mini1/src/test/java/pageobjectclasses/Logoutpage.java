package pageobjectclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Logoutpage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public Logoutpage(WebDriver driver) {
		this.driver = driver;
		
        PageFactory.initElements(driver, this);
		
	}
	    @FindBy(id = "logout2")  // Log out button
	    private WebElement logoutButton;
	  
	    public void isLogoutButtonVisible() {
	        wait.until(ExpectedConditions.visibilityOf(logoutButton));
	        System.out.println("✅ Log in button is visible on the homepage.");
	    }
	    
	    public void clickLogout() {
	        logoutButton.click();
	    }
}
