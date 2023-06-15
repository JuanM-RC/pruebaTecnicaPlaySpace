package automaticTest;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import testData.EmailAndPassword;
import testData.TestDataReader;


public class ResetPassword extends BaseTest{
	
    
	private String credentialsFixturePath = "src\\test\\resources\\fixtures\\credentialsFixture.json";
	private TestDataReader reader;
	private MainPage page;
	private List<EmailAndPassword> validEmailsAndPasswords;
	private List<String> validFormattedEmails;
	private List<String> invalidFormattedEmails;

	//this, like the emails and passwords, could be in a fixture with all the other texts, separated by language
	private String passwordRecoveryMessage = "We have sent you an email so you can reset your password, check your inbox.";

	@BeforeClass
	public void loginSetup() throws IOException {
	    // Access the page object
	    page = new MainPage(driver);

	    // Create a reader and access the Fixture's content
	    reader = new TestDataReader(credentialsFixturePath);
	    validEmailsAndPasswords = reader.getEmailsAndPasswordsCorrect();
	    validFormattedEmails = reader.getValidEmails();
	    invalidFormattedEmails = reader.getInvalidEmails();
	}
    

    @BeforeMethod
    public void setup() {
    	//visits baseUrl
		driver.get(baseURL);
    			
		// Maximize browser window
		driver.manage().window().maximize();
        
        page.getCookieAccept().click();

        //Preconditions --> Start at: https://www.slot.com/en → "LET'S PLAY" → "PLAY WITH EMAIL" → “Already have an account”
        
        //Click on the "LETS PLAY" button
        page.getLetsplayButton().click();
        
        //Assert login option selection modal opens
        assertElementVisible(page.getLetsPlayModal());
        
        //click on "PLAY WITH EMAIL" button
        page.getPlayWithEmailButton().click();
        
        //assert register modal opens
        assertElementVisible(page.getRegisterModal());
        
        //click on Already have an account to access login modal
        page.getAlreadyHaveAnAccount().click();
        
        //assert login modal opens
        assertElementVisible(page.getUserAccessModal());
        
        page.getForgotPassword().click();
        
        //assert login modal opens
        assertElementVisible(page.getForgotPasswordModal());
        
        
        
    }
    
    
	@Test
	public void resetPasswordWithValidEmail() {
		
		EmailAndPassword emailAndPassword = validEmailsAndPasswords.get(0);
		
		String validEmail = emailAndPassword.getEmail();
		
		page.getEmailBox().sendKeys(validEmail);
		
		page.getSendButton().click();
		
		assertTextEquals(waitForElementToBeVisible(page.getPasswordRecoveryMessage()), passwordRecoveryMessage);
		
	}
	
	@Test
	public void resetPasswordWithInvalidEmail() throws InterruptedException {
		
		
		//Check the required email message
		page.getSendButton().click();
		assertElementVisible(page.getEmailIsRequiredMessage());

		
		//With incorrectly formatted emails, check the invalid email address message
		for (String email : invalidFormattedEmails) {
			
			page.getEmailBox().sendKeys(email);
			page.getSendButton().click();

	        // Assert the error message
			assertElementVisible(waitForElementToBeVisible(page.getInvalidEmailAddressMessage()));
			
	       
	        // Clear the textbox
			page.getEmailBox().clear();
		
	    }
		
		
		//With correctly formatted emails, check the Email is invalid message
		//(Should there be a different message? would that imply privacy issues?)
		
		for (String email : validFormattedEmails) {
			
			page.getEmailBox().sendKeys(email);
			page.getSendButton().click();

	        // Assert the error message
			assertElementVisible(waitForElementToBeVisible(page.getEmailIsInvalidMessage()));

	       
	        // Clear the textbox
			page.getEmailBox().clear();
		}	
	}
}