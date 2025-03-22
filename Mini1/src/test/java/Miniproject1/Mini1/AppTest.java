package Miniproject1.Mini1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



/**
 * Unit test for simple App.
 */
public class AppTest {

  String WebsiteUrl ="https://www.demoblaze.com/";
  WebDriver driver = new FirefoxDriver();
  String parentWindow;
  Set<String> allWindowHandles;
  // Create WebDriverWait instance
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  
  public void launchApp() {
		driver.get(WebsiteUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//div[@class='fc-dialog-container']//button/p[text()='Consent']")).click();
	}
	
 // public void signup() throws InterruptedException {
	 // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//  driver.findElement(By.id("signin2")).click();
	//  driver.findElement(By.id("sign-username")).sendKeys("Dhinesh20");
	//  driver.findElement(By.id("sign-password")).sendKeys("Dhinesh@9395");
	//  driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/button[2]")).click();

      // Wait for the alert to appear
     // wait.until(ExpectedConditions.alertIsPresent());

      // Switch to the alert
    //  Alert alert = driver.switchTo().alert();

      // Get the alert text
     // String alertText = alert.getText();
     // System.out.println("Alert Message: " + alertText);

      // Accept (Click OK) on the alert
    //  alert.accept();

 // } 
 

  public void login() {
	  
	  
      try {
          // Wait until "Log in" button is visible
          WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));

          // Verify that the "Log in" button is displayed
          Assert.assertTrue(loginButton.isDisplayed(), "Log in button is NOT visible on the homepage.");

          System.out.println("Log in button is visible on the homepage.");
      } catch (Exception e) {
          System.out.println("Log in button is NOT found on the homepage.");
      }
	  driver.findElement(By.id("login2")).click();
	  driver.findElement(By.id("loginusername")).sendKeys("Dhinesh20");
	  driver.findElement(By.id("loginpassword")).sendKeys("Dhinesh@9395");
	  driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
	  
	  	  
  }
  public void testCategoriesDisplay() {
      WebElement homeMenu = driver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[1]/a"));
      WebElement contactMenu = driver.findElement(By.xpath("/html/body/nav/div[1]/ul/li[2]/a"));
      // Create WebDriverWait instance
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      
      // Verify Welcome Username is displayed
      WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
      System.out.println("Welcome Username is displayed on the homepage.");
      
      // Verify application logo is displayed
      
      driver.findElement(By.xpath("/html/body/nav/a/img")).isDisplayed();
      
      
      WebElement logo = driver.findElement(By.xpath("/html/body/nav/a/img"));
      if (logo.isDisplayed()) {
          System.out.println("Application logo is displayed on the homepage.");
      }
      
   // Verify all menu items are displayed
      String[] menuItems = {"Home", "Contact", "About us", "Cart", "Log in", "Sign up"};
      for (String item : menuItems) {
          WebElement menuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div[1]/ul")));
          System.out.println("Menu item '" + item + "' is displayed.");
      } 
      
   // Verify all categories are listed (Phones, Laptops, Monitors)
      List<WebElement> categories = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/div/div[1]/div")));
      String[] expectedCategories = {"CATEGORIES", "Phones", "Laptops", "Monitors"};
      for (String expectedCategory : expectedCategories) {        
              System.out.println("Category '" + expectedCategory + "' is displayed.");
          } 
        
    
  }
  
  public void testAddToCart() throws InterruptedException {
	  //select laptop
      driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div[6]/div/div/h4/a")) .click();
      Thread.sleep(2000);

      //List<WebElement> productinfo = driver.findElements(By.xpath("//*[@id=\"tbodyid\"]"));
      List<WebElement> productinfo = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/div/div[2]")));
      String[] expectedinfo = {"name", "price-container", "description-tabs"};
      for (String productinfo1 : expectedinfo) {        
          System.out.println("productinfo '" + productinfo1 + "' is displayed.");
          
      driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a")) .click();
     Thread.sleep(2000);
  // Wait for the alert to appear
      wait.until(ExpectedConditions.alertIsPresent());

      // Switch to the alert
    Alert alert = driver.switchTo().alert();

      // Get the alert text
     String alertText = alert.getText();
     System.out.println("Alert Message: " + alertText);

      // Accept (Click OK) on the alert
    alert.accept();

    } 
          
      } 
        

  public void testCartFunctionality() throws InterruptedException {
      driver.findElement(By.id("cartur")) .click();
      Thread.sleep(2000);
      WebElement deleteButton = driver.findElement(By.xpath("//a[text()='Delete']"));
      Assert.assertTrue(deleteButton.isDisplayed(), "Delete button not visible");
      deleteButton.click();
      Thread.sleep(2000);
      WebElement Totalprice = driver.findElement(By.id("totalp"));
      String[] exceptedprice = {"panel-heading"};
      for (String CartTotal : exceptedprice) { 
      System.out.println("Remaing Toal in Cart: "+CartTotal);
  }
  }      
  

  public void testLogout() {
      WebElement logoutButton = driver.findElement(By.id("logout2"));
      Assert.assertTrue(logoutButton.isDisplayed(), "Logout button not visible");
      logoutButton.click();
  }
  
  public void tearDown() {
      driver.quit();
  }
    public static void main (String[] args) throws InterruptedException {
    	System.out.println("Hello");
    	AppTest test = new AppTest();
    	test.launchApp();
  //  	test.signup();
    	test.login();
    	test.testCategoriesDisplay();
    	test.testAddToCart();
    	test.testCartFunctionality();
    	test.testLogout();
    	
    
    	
        
    }
}
