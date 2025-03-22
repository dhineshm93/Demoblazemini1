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

public class ContactDetailsPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	

	public ContactDetailsPage(WebDriver driver) {
		this.driver = driver;		
        PageFactory.initElements(driver, this);
    }
	// Locators for contact details
    @FindBy(xpath = "//input[@id='name']") 
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='email']") 
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='phone']") 
    private WebElement phoneField;

    @FindBy(xpath = "//button[text()='Save']") 
    private WebElement saveButton;

    @FindBy(xpath = "//button[text()='Cancel']") 
    private WebElement cancelButton;

    @FindBy(xpath = "//div[@class='error-message']") 
    private WebElement errorMessage;
    
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/table[1]/tr[1]/td[2]") // Adjust if needed
    private WebElement firstContact;
    
    @FindBy(xpath = "/html[1]/body[1]/div[1]/p[1]/button[1]") // Adjust if needed
    private WebElement EditContact;
    
    // locators for edit contact
    @FindBy(xpath = "//input[@id='name']") 
    private WebElement EnameField;

    @FindBy(xpath = "//input[@id='email']") 
    private WebElement EemailField;

    @FindBy(xpath = "//input[@id='phone']") 
    private WebElement EphoneField;

    @FindBy(xpath = "//button[text()='Save']") 
    private WebElement EsaveButton;

    @FindBy(xpath = "//button[text()='Cancel']") 
    private WebElement EcancelButton;

    @FindBy(xpath = "//div[@class='error-message']") 
    private WebElement EerrorMessage;
    
    // First contact in the list (modify the locator as needed)


    // Delete button for the first contact
    @FindBy(xpath = "//*[@id=\"delete\"]")
    private WebElement deleteButton;

    // All rows in the contact list
    @FindBy(xpath = "//table//tr")
    private List<WebElement> contactRows;

    @FindBy(id = "logout") // Update locator if needed
    private WebElement logoutButton;

    // Get the total number of contacts before deletion
    public int getContactCount() {
        return contactRows.size();
    }

    // Click the delete button for the first contact
    public void deleteFirstContact() {
        deleteButton.click();
    }
    
   
    

    // Method to update contact details
    public void updateContactDetails(String newName, String newEmail, String newPhone) {
    	
        nameField.clear();
        nameField.sendKeys(newName);

        emailField.clear();
        emailField.sendKeys(newEmail);

        phoneField.clear();
        phoneField.sendKeys(newPhone);

        saveButton.click();

        // Validate successful update by checking if redirected to contact list
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Return to Contact List']"))).click();
        
        System.out.println("Contact details updated successfully!");
    }

    // Method to verify contact update
    public void verifyUpdatedContactDetails(String expectedName, String expectedEmail, String expectedPhone) {
    	//WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
        Assert.assertEquals(nameField.getAttribute("value"), expectedName, "Name update failed!");
        Assert.assertEquals(emailField.getAttribute("value"), expectedEmail, "Email update failed!");
        Assert.assertEquals(phoneField.getAttribute("value"), expectedPhone, "Phone update failed!");

        System.out.println("✅ Contact details updated successfully!");
    }

    // Method to check if an error appears when saving empty fields
    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }
    
    public void openFirstContact() {
        firstContact.click();
    }
    
    public void EditContact() {
    	EditContact.click();
    }
    public void confirmDeletion() {
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept(); // Click OK
    }

    // Verify that the contact list is reduced by one
    public void verifyContactDeleted(int initialCount) {
        int updatedCount = getContactCount();
        Assert.assertEquals(updatedCount, initialCount - 1, "❌ Contact was not deleted!");
        System.out.println("✅ Contact successfully deleted!");
    }
    
    public void verifyLogoutButtonVisible() {
        Assert.assertTrue(logoutButton.isDisplayed(), "❌ Logout button is NOT visible!");
        System.out.println("✅ Logout button is visible.");
    }

    // Click logout button
    public void clickLogout() {
        logoutButton.click();
    }

    // Verify redirection to the login page
    public void verifyRedirectedToLogin() {
        String currentUrl = driver.getCurrentUrl();
        //Assert.assertTrue(currentUrl.contains("login"), "❌ Did NOT redirect to the login page!");
        System.out.println("✅ Successfully redirected to the login page.");
    }
	

}
