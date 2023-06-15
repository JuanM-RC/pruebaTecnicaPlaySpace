package automaticTest;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.MainPage;
import testData.EmailAndPassword;
import testData.TestDataReader;
import testData.UsernameAndPassword;


public class Login extends BaseTest{
	
    
	private String credentialsFixturePath = "src\\test\\resources\\fixtures\\credentialsFixture.json";
	private TestDataReader reader;
	private MainPage page;
	private List<EmailAndPassword> validEmailsAndPasswords;
	private List<EmailAndPassword> invalidEmailsAndPasswords;
	private List<UsernameAndPassword> invalidUsernamesAndPasswords;
	private List<UsernameAndPassword> validUsernameAndPassword;

	@BeforeClass
	public void loginSetup() throws IOException {
	    // Access the page object
	    page = new MainPage(driver);

	    // Create a reader and access the Fixture's content
	    reader = new TestDataReader(credentialsFixturePath);
	    validEmailsAndPasswords = reader.getEmailsAndPasswordsCorrect();
	    invalidEmailsAndPasswords = reader.getEmailsAndPasswordsIncorrect();
	    invalidUsernamesAndPasswords = reader.getUsernamesAndPasswordsIncorrect();
	    validUsernameAndPassword = reader.getUsernamesAndPasswordsCorrect();
	}
    

    @BeforeMethod
    public void setup() {
       
    	//visits baseUrl
		driver.get(baseURL);
		
		// Maximize browser window
		driver.manage().window().maximize();
		
		//accept cookies
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
        
        
    }
	
    
	@Test
	public void loginWithValidMail() {
		
		//Knowing that we will only need one set of valid email-password, accessing directly the first instance of the json
		//should be OK.
		
		EmailAndPassword emailAndPassword = validEmailsAndPasswords.get(0);
		
		String validEmail = emailAndPassword.getEmail();
		String validPassword = emailAndPassword.getPassword();
		
		
		//Write set of valid email and password, then click on LoginButton.
		page.getUserOrEmailBox().sendKeys(validEmail);
		page.getPasswordBox().sendKeys(validPassword);
		page.getJoinButton().click();
		
		
		waitForElementToBeVisible(page.getCreditsValue());
		Assert.assertNotEquals(getBaseUrl(), driver.getCurrentUrl());

	}
	
	@Test
	public void loginWithValidUsername(){
		
		//Knowing that we will only need one set of valid username-password, accessing directly the first instance of the json
		//should be OK.
		
		UsernameAndPassword emailAndPassword = validUsernameAndPassword.get(0);
		
		String validUsername = emailAndPassword.getUsername();
		String validPassword = emailAndPassword.getPassword();
		
		
		//Write set of valid email and password, then click on LoginButton.
		page.getUserOrEmailBox().sendKeys(validUsername);
		page.getPasswordBox().sendKeys(validPassword);
		page.getJoinButton().click();
		
		
		waitForElementToBeVisible(page.getCreditsValue());
		Assert.assertNotEquals(getBaseUrl(), driver.getCurrentUrl());

	}
	
	@Test
	public void loginWithInvalidCredentials(){
		

		for (EmailAndPassword emailAndPassword : invalidEmailsAndPasswords) {
	        String email = emailAndPassword.getEmail();
	        String password = emailAndPassword.getPassword();

			page.getUserOrEmailBox().sendKeys(email);
			page.getPasswordBox().sendKeys(password);
			page.getJoinButton().click();

	        // Assert the error message
			waitForElementToBeVisible(page.getLoginUsernameError());
	        Assert.assertTrue(page.getLoginUsernameError().isDisplayed(), "Error message is not displayed");

	        
	        // Clear the text boxes
			page.getUserOrEmailBox().clear();
			page.getPasswordBox().clear();
	    }
		
		for (UsernameAndPassword usernameAndPassword : invalidUsernamesAndPasswords) {
	        String username = usernameAndPassword.getUsername();
	        String password = usernameAndPassword.getPassword();

			page.getUserOrEmailBox().sendKeys(username);
			page.getPasswordBox().sendKeys(password);
			page.getJoinButton().click();

	        // Assert the error message
			waitForElementToBeVisible(page.getLoginUsernameError());
	        Assert.assertTrue(page.getLoginUsernameError().isDisplayed(), "Error message is not displayed");

	        
	        // Clear the text boxes
			page.getUserOrEmailBox().clear();
			page.getPasswordBox().clear();
	    }
		

	}
	

	

}
