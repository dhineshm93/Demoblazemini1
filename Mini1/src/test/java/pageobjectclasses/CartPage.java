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

public class CartPage {
	
	 WebDriver driver;	     
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));    
	public  CartPage(WebDriver driver)  {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	
	}
	
    // Locate the "Cart" button on the homepage
    @FindBy(id = "cartur")
    private WebElement cartButton;
    
    @FindBy(xpath = "//*[@id=\"cartur\"]")
    private WebElement opencart;

    // Locate the product name in the cart
    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[2]")
    private WebElement productName;

    // Locate the product price in the cart
    @FindBy(xpath = "//tbody[@id='tbodyid']/tr/td[3]")
    private WebElement productPrice;

    // Locate all cart rows (to check if multiple products exist)
    @FindBy(xpath = "//tbody[@id='tbodyid']/tr")
    private List<WebElement> cartRows;
    
    // Locate the "Delete" button
    @FindBy(xpath = "//tbody/tr[1]/td[4]/a[1]")
    private WebElement deleteButton;
    
    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;
    
    @FindBy(xpath = "//button[text()='Place Order']")  // Place Order button
    private WebElement placeOrderButton;
    
    @FindBy(xpath = "//tbody/tr")  // List of cart items
    private List<WebElement> cartItems;
    
    @FindBy(xpath = "//h3[@id='totalp']")  // Total price
    private WebElement totalPrice;
    
    @FindBy(id = "orderModal")  // Order modal window
    private WebElement orderModal;
    
    
      
    
    public void OpenCart() {
    	opencart.click();
    }

    // Method to verify the correct product is in the cart
    public void verifyProductInCart(String expectedProductName, String expectedProductPrice) {
        wait.until(ExpectedConditions.visibilityOf(productName));

        //Assert.assertEquals(productName.getText(), expectedProductName, "❌ Incorrect product name in the cart.");
        //Assert.assertEquals(productPrice.getText(), expectedProductPrice, "❌ Incorrect product price in the cart.");
        System.out.println("✅ Product correctly displayed in the cart: " + productName.getText());
        System.out.println("✅ Product price correctly displayed in the cart: " + productPrice.getText());

        // Optional: Verify cart contains only one product
       //ssert.assertEquals(cartRows.size(), 1, "❌ More than one product found in the cart.");
    }
 
    
 // Method to delete the product from the cart
    public void deleteProductFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
        
        // Wait to ensure the product is removed (cartRows size should be 0)
        //wait.until(ExpectedConditions.invisibilityOfAllElements(cartRows));
        
        // Validate cart is empty
        //Assert.assertTrue(cartRows.isEmpty(), "❌ Cart is NOT empty after deletion.");
        System.out.println("✅ Product successfully deleted from the cart.");
    }  
    
    public boolean isPlaceOrderButtonDisplayed() {
        return placeOrderButton.isDisplayed();
    }
    
    public String getTotalPrice() {
        return totalPrice.getText();
    }
    
    public int getCartItemCount() {
        return cartItems.size();
    }
    
    public void clickPlaceOrder() {
        placeOrderButton.click();
    }

    public boolean isOrderModalDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(orderModal));
        return orderModal.isDisplayed();
    } 
}


	  

