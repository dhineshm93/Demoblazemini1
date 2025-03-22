package pageobjectclasses;

import java.time.Duration;

import org.openqa.selenium.Alert;
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
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="sign-username")
	WebElement username;
	@FindBy(id="sign-password")
	WebElement password;
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/button[2]")
	WebElement signUpButton;
	
	public void doUserSigin(String Username ,String Pass) {
		
		username.sendKeys(Username);
		password.sendKeys(Pass);
		signUpButton.click();
		
	}
	public void alert() {
	// Wait for the alert to appear
		wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();

		try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            alertWait.until(ExpectedConditions.alertIsPresent()); // Wait for alert
            
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("🛒 Alert Message: " + alertText); // Print alert message
            
            alert.accept(); // Click OK button
            System.out.println("✅ Alert accepted successfully.");
            
        } catch (Exception e) {
            System.out.println("❌ No alert found or handling failed: " + e.getMessage());
        }
		
	}
		
		
	

}
