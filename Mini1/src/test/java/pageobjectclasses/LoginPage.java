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
import org.testng.annotations.Factory;

public class LoginPage {
	
	WebDriver driver;	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		
	}
		
		@FindBy(id="loginusername")
		WebElement Lusername;
		@FindBy(id="loginpassword")
		WebElement Lpassword;
		@FindBy(xpath="/html/body/div[3]/div/div/div[3]/button[2]")
		WebElement LoginButton;
		
		
		
		public void doUserLogin(String Username ,String Pass ) {
			Lusername.sendKeys(Username);
			Lpassword.sendKeys(Pass);
			LoginButton.click();
		}
		public void Username(String Username) {
			Lusername.sendKeys(Username);
		}
		
		public void Password(String Pass) {
			Lpassword.sendKeys(Pass);
		}
		public void clickOnLoginButton() {
			LoginButton.click();
		}
			
		
}
