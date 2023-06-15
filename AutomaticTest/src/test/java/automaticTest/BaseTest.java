package automaticTest;

import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;



public class BaseTest {
	
	protected WebDriver driver;
    protected WebDriverWait wait;
    private String chromeDriverKey = "webdriver.chrome.driver";
    private String chromeDriverPath = "src/test/resources/drivers/chromedriver.exe";
    protected String baseURL = "https://www.slot.com/en"; 
    
    
    @BeforeClass
    public void configureSelenium() throws MalformedURLException {
    	
        System.setProperty(chromeDriverKey, chromeDriverPath);

 
        // Create a Chrome driver instance
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        

        // Initialize WebDriverWait with a default timeout of 6seconds
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        driver.get(baseURL);
        
        //driver.manage().window().maximize();
    }

    


    
    @AfterMethod
    public void cleanup() {
        // Clean cookies
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void teardown() {
        // Quit the WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
    
    public void assertTextEquals(WebElement element, String expectedText) {
        String actualText = element.getText().trim();
        actualText = actualText.replaceAll("\\s+", " ");
        expectedText = expectedText.replaceAll("\\s+", " ");
        Assert.assertEquals(actualText, expectedText, "Texts do not match");    
        }
    
    public void assertTextContains(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains(expectedText), "Text does not contain the expected value");
    }

    
    public void assertTextDoesNotContain(WebElement element, String unexpectedText) {
        String actualText = element.getText();
        Assert.assertFalse(actualText.contains(unexpectedText), "Text contains the unexpected value");
    }

    
    public void assertElementVisible(WebElement element) {
        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed, "Element is not visible");
    }
    
    public void assertElementNotVisible(WebElement element) {
        boolean isDisplayed = element.isDisplayed();
        Assert.assertFalse(isDisplayed, "Element is visible");
    }
    
    public WebElement waitForElementToExist(By locator) {
    	return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    

    public WebElement waitForElementToNotExist(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)) ? null : driver.findElement(locator);
    }
    
    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean waitForElementToBeInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
    
    public WebElement waitForElementToBeInteractable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    
    
    
    
    
    
    //GETTERS
    
    public String getBaseUrl() {
    	return baseURL;
    }
    

    
    

}
