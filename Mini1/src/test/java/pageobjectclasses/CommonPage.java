package pageobjectclasses;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonPage {
	/* Page Object Model 
	 * 1) Capture all the WebElements of this page 
	 * 2) Define the actions that has to be performed on these WebElements - corresponding to this page
	 * 
	 *  To Use Page Factory in Selenium - initiElements()  element initialization 
	 *  Why?  For Lazy initialization of WebElements
	 * */
	String baseUrl = "https://www.demoblaze.com/";
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}

@FindBy(id ="signin2")
WebElement siginuplink;

@FindBy(id="login2")
WebElement loginlink;

@FindBy(id="logout2")
WebElement logoutlink;

public void launchApp() {
	driver.get(baseUrl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
 public void clickOnSignupLink() {
	 siginuplink.click();
 }
 public void clickOnLoginLink() {
	 loginlink.click();
 }
 public void clickOnLogoutLink() {
	 logoutlink.click();
 }
 
 public void loginbuttonvisble() {
	 
	 
 }

 public void handleAlert()
	{
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println("Alert Message: " + alertText);
		alert.accept();
		
	}
 
}