package pageobjectclasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class ProductDetailsPage {
	     WebDriver driver;	     
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));    
	public ProductDetailsPage(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
    // Locate product title
    @FindBy(xpath = "//h2[@class='name']")
    private WebElement productTitle;

    // Locate product price
    @FindBy(xpath = "//h3[@class='price-container']")
    private WebElement productPrice;

    // Locate product description
    @FindBy(id = "more-information")
    private WebElement productDescription;
    
    // Locate Add to Cart button
    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;
    
    
 // Method to verify product details
    public void verifyProductDetails(String expectedTitle, String expectedPrice) {
        Assert.assertEquals(productTitle.getText(), expectedTitle, "❌ Incorrect product title displayed.");
        Assert.assertTrue(productPrice.getText().contains(expectedPrice), "❌ Incorrect product price displayed.");
        
        System.out.println("✅ Product title is correct: " + productTitle.getText());
        System.out.println("✅ Product price is correct: " + productPrice.getText());
    }

    // Method to add the product to the cart
    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();

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
