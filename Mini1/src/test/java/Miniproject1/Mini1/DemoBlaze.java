package Miniproject1.Mini1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjectclasses.CartPage;
import pageobjectclasses.CommonPage;
import pageobjectclasses.HomePage;
import pageobjectclasses.LoginPage;
import pageobjectclasses.Logoutpage;
import pageobjectclasses.OrderPage;
import pageobjectclasses.ProductDetailsPage;
import pageobjectclasses.SignupPage;

public class DemoBlaze {
	
	WebDriver driver = new FirefoxDriver();
	CommonPage common = new CommonPage(driver);
	SignupPage signupPage = new SignupPage(driver);
	LoginPage loginPage = new LoginPage(driver);
	HomePage homepage = new HomePage(driver);
	CartPage cartPage = new CartPage(driver);
	OrderPage orderpage = new OrderPage(driver);
	Logoutpage logoutpage = new Logoutpage(driver);
	ProductDetailsPage productpage = new ProductDetailsPage(driver);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@Test(priority = 1)
	//Test-1 - do user signup
	public void runsignupTest() {
		common.launchApp();
		common.clickOnSignupLink();
		signupPage.doUserSigin("dhinesh24", "dhinesh9395");
		
	}
	
	@Test(priority = 2)
	//Test-2 do login for registered user
	public void runloginTest() {
		common.launchApp();
		//common.clickOnLogoutLink();
		// Verify that the "Log in" button is displayed and clickable
		homepage.verifyLoginButton();
		common.clickOnLoginLink();		
		loginPage.doUserLogin("dhinesh23", "dhinesh9395");
		homepage.verifySuccessfulLogin();	
		
	}
	@Test(priority = 3)
	//Test-3
	public void runVerifyCategories() throws InterruptedException {
		//common.clickOnLogoutLink();
        homepage.verifyCategories();
        homepage.verifylisted();
        //Thread.sleep(4000);
    
    }
	@Test(priority = 4)
	//Test-4
	
	public void runProductDetails() throws InterruptedException {
		homepage.clickOnLaptopsCategory();
		homepage.selectSonyVaioI5();
		// Verify correct product details are displayed
		productpage.verifyProductDetails("Sony vaio i5", "$790");
		// Add the product to the cart
		productpage.addToCart();
		// Open cart and verify product is displayed
        cartPage.OpenCart();
        cartPage.verifyProductInCart("Sony vaio i5", "790");
     		
	}
	@Test(priority = 5)
	//Test-5
//Test the ability to delete items from the cart.
	 public void testAddAndDeleteProductFromCart() {

		 cartPage.deleteProductFromCart();
		 
//Ensure accurate reflection of cart modifications in the UI
	        // Step 2: Verify Item is Added
	        int cartCountBefore = cartPage.getCartItemCount();
	        Assert.assertTrue(cartCountBefore > 0, "Cart is empty after adding product!");
	        // Step 3: Remove Item from Cart
	        cartPage.deleteProductFromCart();
	        try {
	            Thread.sleep(2000);  // Wait for UI update
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        int cartCountAfter = cartPage.getCartItemCount();
	        Assert.assertTrue(cartCountAfter < cartCountBefore, "Cart item was not removed properly!");
		 
	 }
	@Test(priority = 6)	 
	public void testPlaceOrderButtonAvailability() {
		       homepage.homepage();
		       homepage.clickOnLaptopsCategory();
		       homepage.selectSonyVaioI5();
		       productpage.addToCart();
		       cartPage.OpenCart();
		        Assert.assertTrue(cartPage.isPlaceOrderButtonDisplayed(), "'Place Order' button is NOT displayed!");
		        System.out.println("Test Passed: 'Place Order' button is available.");   
		        
		  
	 }
	@Test(priority = 7)
//Test if the order window is available for purchase
	
    public void testOrderWindowAvailability() {
        // Step 2: Click 'Place Order'
        cartPage.clickPlaceOrder();
        Assert.assertTrue(cartPage.isOrderModalDisplayed(), "Order window is NOT displayed!");
// Verify the presence of necessary order fields 
        orderpage.enterOrderDetails("John Doe", "USA", "New York", "1234567890123456", "12", "2025");
        orderpage.clickPurchase();
//Ensure successful order placement and verify the confirmation alert.
        Assert.assertTrue(orderpage.isPurchaseSuccessful(), "Purchase was NOT successful!");
  // Step 4: Capture and Verify Confirmation Alert Text
        String alertText = orderpage.getConfirmationAlertText();
        System.out.println("Confirmation Alert: " + alertText);
        orderpage.orderconfirm();
       logoutpage.isLogoutButtonVisible();

    } 
   	
}
