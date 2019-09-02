package corePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import managers.FileReaderManager;


public class BasePage {

    public static WebDriver driver;
    public static WebDriverWait wait;


    /**
     * Defining page constructor to initialise the page elements
     **/
    public BasePage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());

    }

    /**
     * Method to create one instance of browser
     **/
    public static WebDriver initBrowser(String browser) {

        if (driver == null) {

            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "/Users/susmitha.vinta/IdeaProjects/java-cucumber-acceptance-test-framework_1/src/main/java/utils/drivers/mac/chromedriver");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "IE":
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    System.out.println("no match");
            }

        }
        return driver;
    }

    /**
     * Method to verify page title
     **/
    public static Boolean currentPageTitle(String pageTitle) {
        return (driver.getTitle().equalsIgnoreCase(pageTitle));
    }

    /**
     * Method that will close down the browser
     **/
    public static void closeBrowser() {
        //driver.quit();
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;

    }

    /**
     * Method to load url of the page
     **/
    public static void getUrl() {
        //driver.manage().window().maximize();
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

    }

    /**
     * Method that will wait for an element to be clickable then click
     **/
    public static void waitForElementClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Method that will wait for an element to be clickable then enter text
     **/
    public static void waitForElementType(String input, WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(input);
    }

    /**
     * Method that will wait for an element to be visable
     **/
    public String waitforElementVisable(WebElement element) {
        //return  wait.until(ExpectedConditions.elementToBeClickable((WebElement)this.GetType().GetField(element, System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance).GetValue(this))).Text;
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    /**
     * Method that will wait for an element by locator
     **/
    public void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Method that will wait until page title be displyed
     **/
    public void waitForPageTitle(String pageTitle) {
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }

    /**
     * Method that will wait for page to load
     **/
    public void waitforPageLoad() {

        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Method for Page scroll down
     **/
    public void pageScrollDown() {
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,1000)");

    }

    /**
     * Method for Page scroll up
     **/
    public void pageScrollUp() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.UP).build().perform();
    }

}