package pageobjectclasses;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
	
	WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement creditCardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement successMessage;
    
    @FindBy(xpath = "/html/body/div[10]/div[7]/div/button")
    private WebElement confirm;
    
    public void enterOrderDetails(String name, String country, String city, String card, String month, String year) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        creditCardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    public void clickPurchase() {
        purchaseButton.click();
    }
    public void orderconfirm() {
    	     confirm.click();
    }
    public boolean isPurchaseSuccessful() {
        return successMessage.isDisplayed();
    }
    
    public String getConfirmationAlertText() {
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
		return null;
    }
	

}
