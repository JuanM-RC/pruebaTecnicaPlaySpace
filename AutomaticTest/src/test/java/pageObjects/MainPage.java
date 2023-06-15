package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MainPage {
	
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

  
    @FindBy(xpath="//button[contains(@class, 'cc-nb-okagree') and contains(text(), 'I ACCEPT')]")
    public WebElement cookieAccept;

    @FindBy(id = "letsplay-button")
    private WebElement letsplayButton;
    
    @FindBy(xpath = "//div[@class='modal-background letsplay']")
    private WebElement letsPlayModal;
    
    @FindBy(xpath = "//div[@class='modal-background register']")
    private WebElement registerModal;
    
    @FindBy(xpath = "//div[@class='modal-background user-access']")
    private WebElement userAccessModal;
    
    @FindBy(xpath = "//div[@class='modal-background forgot-password']")
    private WebElement forgotPasswordModal;

    @FindBy(xpath = "//div[contains(text(),'Play with email')]")
    private WebElement playWithEmailButton;
    
    @FindBy(id = "alreadyHaveAccount")
    private WebElement alreadyHaveAnAccount;
    
    @FindBy(id = "userNameLogin")
    private WebElement userOrEmailBox;
    
    @FindBy(xpath = "//div[@id='userAccessModal']//input[@id = 'input-pwd']")
    private WebElement passwordBox;
    
    @FindBy(id = "modalLoginSubmitButton")
    private WebElement joinButton;
    
    @FindBy(xpath = "//div[@class='modal-background user-access']//img[@id='headerCloseIcon']")
    private WebElement closeButtonUserLogin;
    
    @FindBy(xpath = "//div[@class='modal-background user-access']//img[@id='headerCloseIcon']")
    private WebElement backButtonUserLogin;
    
    @FindBy(id = "forgotPasswordLogin")
    private WebElement forgotPassword;
    
    @FindBy(id = "notUserLogin")
    private WebElement iDontHaveAnAccount;
    
    @FindBy(xpath = "//div[@id='recovery-password-form']//input[@id='Email']")
    private WebElement emailBox;
    
    @FindBy(id = "btnSendFP")
    private WebElement sendButton;
    
    @FindBy(id="checkEmail")
    private WebElement passwordRecoveryMessage;
    
    @FindBy(xpath = "//img[@onclick='ReturnForgotPasswordFormView()']")
    private WebElement backArrowPasswordReset;
    
    @FindBy(xpath = "//div[@class='modal-background forgot-password']//img[@id='headerCloseIcon']")
    private WebElement closeButtonPasswordReset;
    
    @FindBy(id ="creditsValue")
    private WebElement creditsValue;
    
    @FindBy(id = "login-username-error")
    private WebElement loginUsernameError;
    
    @FindBy(xpath = "//span[contains(text(),'invalid e-mail address')]")
    private WebElement invalidEmailAddressMessage;
    
    @FindBy(xpath="//span[@id='resetPwd-validation-info']")
    private WebElement emailIsInvalidMessage;
    
    @FindBy(xpath="//span[contains(text(),'The email is requiered')]")
    private WebElement emailIsRequiredMessage;

 
    
    public WebElement getCookieAccept() {
    	return cookieAccept;
    }
    
    public WebElement getLetsplayButton() {
        return letsplayButton;
    }
    
    public WebElement getLetsPlayModal() {
    	return letsPlayModal;
    }
    
    public WebElement getRegisterModal() {
        return registerModal;
    }

    public WebElement getUserAccessModal() {
        return userAccessModal;
    }

    public WebElement getForgotPasswordModal() {
        return forgotPasswordModal;
    }

    public WebElement getPlayWithEmailButton() {
        return playWithEmailButton;
    }

    public WebElement getAlreadyHaveAnAccount() {
        return alreadyHaveAnAccount;
    }

    public WebElement getUserOrEmailBox() {
        return userOrEmailBox;
    }

    public WebElement getPasswordBox() {
        return passwordBox;
    }

    public WebElement getJoinButton() {
        return joinButton;
    }

    public WebElement getCloseButtonUserLogin() {
        return closeButtonUserLogin;
    }

    public WebElement getBackButtonUserLogin() {
        return backButtonUserLogin;
    }

    public WebElement getForgotPassword() {
        return forgotPassword;
    }

    public WebElement getIDontHaveAnAccount() {
        return iDontHaveAnAccount;
    }

    public WebElement getEmailBox() {
        return emailBox;
    }

    public WebElement getSendButton() {
        return sendButton;
    }
    
    public WebElement getPasswordRecoveryMessage() {
    	return passwordRecoveryMessage;
    }

    public WebElement getBackArrowPasswordReset() {
        return backArrowPasswordReset;
    }

    public WebElement getCloseButtonPasswordReset() {
        return closeButtonPasswordReset;
    }
    
    public WebElement getCreditsValue() {
    	return creditsValue;
    }
    
    public WebElement getLoginUsernameError() {
    	return loginUsernameError;
    }
    
    public WebElement getInvalidEmailAddressMessage() {
        return invalidEmailAddressMessage;
    }

    public WebElement getEmailIsInvalidMessage() {
        return emailIsInvalidMessage;
    }

    public WebElement getEmailIsRequiredMessage() {
        return emailIsRequiredMessage;
    }
    
    
    
    
    
    
    

    public void enterUsernameOrMail(String username) {
    	userOrEmailBox.sendKeys(username);
    }
    
    public void enterPassword(String pwd) {
    	passwordBox.sendKeys(pwd);
    }
    
    public void enterMail(String mail) {
    	emailBox.sendKeys(mail);
    }
    

    
    

    // Other methods and actions specific to the login page
}
