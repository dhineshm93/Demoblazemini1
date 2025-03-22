package pageobjectclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCategories {
	
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void ProductDetails(WebDriver driver) throws InterruptedException {
	this.driver = driver;
    	PageFactory.initElements(driver, this);
    	
    }
    
    @FindBy(className = "navbar-brand")
    WebElement linkLogo;

    @FindBy(xpath = "//a[text()='Home ']")
    WebElement linkHome;

    @FindBy(linkText = "Contact")
    WebElement linkContact;

    @FindBy(linkText = "About us")
    WebElement linkAboutUs;

    @FindBy(linkText = "Cart")
    WebElement linkCart;

    @FindBy(linkText = "Log in")
    WebElement linkLogin;

    @FindBy(linkText = "Sign up")
    WebElement linkSignUp;

    @FindBy(linkText = "Log out")
    WebElement linkLogout;

    @FindBy(id = "nameofuser")
    WebElement linkWelcomeUser;
    
    @FindBy(xpath="/html/body/nav/a/img")
    WebElement logo;
    

 

    public boolean isWelcomeUserDisplayed() {
        //visibilityWait(linkWelcomeUser);
        return linkWelcomeUser.isDisplayed();
    }

    public boolean isLoginDisplayed() {
        //visibilityWait(linkLogin);
        return linkLogin.isDisplayed();
    }

    public boolean isSignUpDisplayed() {
       // visibilityWait(linkSignUp);
        return linkSignUp.isDisplayed();
    }

    public boolean isLogoutDisplayed() {
       // visibilityWait(linkLogout);
        return linkLogout.isDisplayed();
    }
    
    public boolean islogoDisplayed() {
    	return logo.isDisplayed();
    	
    }	
		

}
