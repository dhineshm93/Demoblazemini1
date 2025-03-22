package Miniproject2.Miniproject2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectclasses.ContactAddition;
import pageobjectclasses.ContactDetailsPage;
import pageobjectclasses.ContactDisplaypage;
import pageobjectclasses.LoginPage;
import pageobjectclasses.SignupPage;
import pageobjectclasses.commonpage;

public class contactListApp {

	WebDriver driver = new FirefoxDriver();
	commonpage common = new commonpage(driver);
	LoginPage loginPage = new LoginPage(driver);
	 SignupPage signupPage = new SignupPage(driver);
	 ContactAddition contactPage = new ContactAddition(driver);
	 ContactDisplaypage contactListPage = new ContactDisplaypage(driver);
	 ContactDetailsPage contactDetailsPage = new ContactDetailsPage(driver);
    
 
	 @Test (priority = 18)
 
    public void testValidSignup() {  
        common.launchApp();
        common.clicksignup1();
        signupPage.enterFirstName("John");
        signupPage.enterLastName("Doe");
        signupPage.enterEmail("newusera31@example.com");
        signupPage.enterPassword("password123");
        signupPage.clickonSignupbutton();
        loginPage.clickLogout();
        
        // Validate successful signup
         //Assert.assertTrue(driver.getCurrentUrl().contains("/contacts"), "Signup failed with valid details");
    }
    
      
    @Test(priority = 17)
    public void testInvalidLoginRestriction() {
        common.launchApp();
        loginPage.enterEmail("invaliduser@example.com");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();
        loginPage.clickLogout();
        //Assert.assertTrue(loginPage.getErrorMessage().contains("Incorrect username or password"), "App did not restrict invalid login");
    }
    
    @Test(priority = 1)
    public void testValidLogin() { 
        common.launchApp();
        loginPage.enterEmail("newusera1@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickonloginbutton();
        loginPage.clickLogin();   
    }
        
    @Test(priority = 2)
    public void testAddContactWithMandatoryFields() {    	
        contactPage.AddNewcontact();
        contactPage.enterFirstName("John");
        contactPage.enterLastName("Doe");
        contactPage.enterEmail("johndoe1742586036669@example.com");
        contactPage.enterPhone("+919876543210");
        contactPage.enterBirthdate("1990-01-01");
        contactPage.clickSubmit();
        System.out.println("add contact with mandatory fields");
        //Assert.assertTrue(driver.getCurrentUrl().contains("/contacts"), "Failed to add contact with mandatory fields");
    }
    
    @Test(priority = 6)
    public void testAddContactWithoutOptionalFields() {
        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/contactList");
        contactPage.AddNewcontact();
        contactPage.enterEmail("dhinesh@example.com");
        contactPage.enterPhone("9876543210");
        contactPage.enterBirthdate("2000-05-05");
        contactPage.clickSubmit();
        System.out.println("add contact without optional fields");
        //Assert.assertTrue(driver.getCurrentUrl().contains("/contacts"), "Failed to add contact without optional fields");
    }
    
    @Test(priority = 7)
    public void testAddDuplicateContact() {
        contactPage.AddNewcontact();
        contactPage.enterFirstName("John");
        contactPage.enterLastName("Doe");
        contactPage.enterEmail("johndoe1742586036669@example.com");
        contactPage.enterPhone("+919876543210");
        contactPage.enterBirthdate("1990-01-01");
        contactPage.clickSubmit();
        System.out.println("App did not restrict duplicate contact");
        contactListPage.Canceladdcontact();
        //Assert.assertTrue(contactPage.getErrorMessage().contains("already exists"), "App did not restrict duplicate contact");
    }
    
    @Test(priority = 8)
    public void testInvalidBirthdateFormat() {
    	

        contactPage.AddNewcontact();
        contactPage.enterFirstName("Alice");
        contactPage.enterLastName("Smith");
        contactPage.enterEmail("alice@example.com");
        contactPage.enterPhone("1231231234");
        contactPage.enterBirthdate("32-13-2025");
        contactPage.clickSubmit();
        System.out.println("App did not restrict invalid birthdate");
        contactListPage.Canceladdcontact();
        //Assert.assertTrue(contactPage.getErrorMessage().contains("Invalid birthdate"), "App did not restrict invalid birthdate");
    } 
        
        @Test(priority = 3)
	    public void testVerifyContactDetails() {
        	
        	
        	
	        contactListPage.verifyContactDetails("John Doe", "+919876543210", "johndoe1742586036669@example.com");
	    }

	    @Test(priority = 4)
	    public void testVerifyContactsSortedByLastName() {
	    	
	        contactListPage.verifyContactsSortedByLastName();
	    }

	    @Test(priority = 5)
	    public void testVerifyPhoneNumberFormat() {
	    	
	        contactListPage.verifyPhoneNumberFormat("+919876543210");
	    
    }
	    
	    @Test(priority = 9)
	    public void testEditContactDetails() {
	    	driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/contactList");
	    	contactDetailsPage.openFirstContact();
	    	contactDetailsPage.EditContact();
	        contactDetailsPage.updateContactDetails("Jane Doe", "jane.doe@example.com", "+44 123456789");
	        contactDetailsPage.verifyUpdatedContactDetails("Jane Doe", "jane.doe@example.com", "+44 123456789");
	    }

	    @Test(priority = 10)
	    public void testUnrelatedFieldsRemainUnchanged() {
	        // Assume initially saved data
	        contactDetailsPage.updateContactDetails("Updated Name", "original.email@example.com", "original-phone");
	        contactDetailsPage.verifyUpdatedContactDetails("Updated Name", "original.email@example.com", "original-phone");
	    }

	    @Test(priority = 11)
	    public void testEmptyFieldsRestriction() {
	        contactDetailsPage.updateContactDetails("", "", "");
	        assert contactDetailsPage.isErrorDisplayed() : "❌ Empty fields should not be allowed!";
	    }	
	    
	    @Test(priority = 12)
	    public void testDeleteContactConfirmationAlert() {
	    	driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/contactList");
	    	contactDetailsPage.openFirstContact();
	    	contactDetailsPage.deleteFirstContact();
	        System.out.println("✅ Delete button clicked.");

	        // Confirm that an alert appears
	        contactDetailsPage.confirmDeletion();
	        System.out.println("✅ Confirmation alert appeared and was accepted.");
	    }

	    @Test(priority = 13)
	    public void testSingleContactDeletion() {
	    	driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/contactList");	
	        int initialCount = contactDetailsPage.getContactCount();
	        contactDetailsPage.openFirstContact();
	    	contactDetailsPage.deleteFirstContact();
	        // Delete and verify
	        contactDetailsPage.confirmDeletion();
	        contactDetailsPage.verifyContactDeleted(initialCount);
	    }

	    @Test(priority = 14)
	    public void testOtherContactsUnaffected() {
	    	driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/contactList");
	        int countBefore = contactDetailsPage.getContactCount();
	        contactDetailsPage.openFirstContact();
	    	contactDetailsPage.deleteFirstContact();
	        // Delete another contact
	        contactDetailsPage.confirmDeletion();

	        int countAfter = contactDetailsPage.getContactCount();
	        assert countAfter == countBefore - 1 : "❌ Deleting a contact affected more than one record!";
	        
	        System.out.println("✅ Other contacts remain unaffected.");
	    }
	    @Test(priority = 15)
	    public void testLogoutButtonVisible() {
	    	contactDetailsPage.verifyLogoutButtonVisible();
	    }

	    @Test(priority = 16)
	    public void testLogoutFunctionality() {
	    	contactDetailsPage.clickLogout();
	    	contactDetailsPage.verifyRedirectedToLogin();
   	
	}
	

}


