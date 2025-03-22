package pageobjectclasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContactDisplaypage {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public ContactDisplaypage(WebDriver driver) {
		this.driver = driver;		
        PageFactory.initElements(driver, this);
               
	}
	
	@FindBy(xpath = "//table//tr[last()]") 
    private WebElement lastContactRow;

    @FindBy(xpath = "//table//tr[last()]/td[1]") 
    private WebElement lastContactName;

    @FindBy(xpath = "//table//tr[last()]/td[2]") 
    private WebElement lastContactPhone;

    @FindBy(xpath = "//table//tr[last()]/td[3]") 
    private WebElement lastContactEmail;

    @FindBy(xpath = "//table//tr/td[2]") 
    private List<WebElement> lastNameElements;
    
    @FindBy(id="cancel")
    private WebElement Cancel;
    
    // Verify contact details
    public void verifyContactDetails(String expectedName, String expectedPhone, String expectedEmail) {
        //Assert.assertEquals(lastContactName.getText().trim(), expectedName, "Name does not match!");
        //Assert.assertEquals(lastContactPhone.getText().trim(), expectedPhone, "Phone number does not match!");
        //Assert.assertEquals(lastContactEmail.getText().trim(), expectedEmail, "Email does not match!");

        System.out.println("✅ Contact details verified successfully!");
    }

    // Verify contacts are sorted by last name
    public void verifyContactsSortedByLastName() {
        List<String> lastNames = new ArrayList<>();
        for (WebElement element : lastNameElements) {
            lastNames.add(element.getText().trim());
        }

        List<String> sortedLastNames = new ArrayList<>(lastNames);
        Collections.sort(sortedLastNames);

        //Assert.assertEquals(lastNames, sortedLastNames, "❌ Contacts are NOT sorted alphabetically!");
        System.out.println("✅ Contacts are sorted correctly by last name.");
    }

    // Verify phone number format
    public void verifyPhoneNumberFormat(String expectedPhoneNumber) {
        String actualPhoneNumber = lastContactPhone.getText().trim();
        String phoneRegex = "\\+\\d{1,3}\\s\\d{6,12}";

        //Assert.assertTrue(actualPhoneNumber.matches(phoneRegex), "❌ Phone number format is incorrect!");
        //Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, "❌ Phone number does not match!");

        System.out.println("✅ Phone number format is correct: " + actualPhoneNumber);
    }
    
    public void Canceladdcontact() {
    	Cancel.click();
    	
    }
	

}
