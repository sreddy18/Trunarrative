package pages;

import corePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;


public class HomePage extends BasePage {

    /**Defining the page elements of home page  **/

    @FindBy(how = How.XPATH, using = "//section[1]/div[1]/h3[1]")
    private WebElement txt_seatIbiza;

    @FindBy(how = How.XPATH, using = "//div[@id='mainnav']//ul//li")
    private List<WebElement> allElementsInList;

    @FindBy(how = How.XPATH, using = ".//h2")
    private WebElement txt_header;

    /** methods that  are used to interact web elements  of the page **/
    public void getSubLinkInformation(String sublink) {
        int iteration = 0;
        for (WebElement element : allElementsInList) {
            iteration++;
            if (element.getText().equalsIgnoreCase(sublink)) {
                String strMyXPath = "//div[@id='mainnav']//ul//li" + '[' + "" + iteration + "" + ']' + "";
                waitforElementVisable(element);
                element.findElement(By.xpath(strMyXPath)).click();
                break;
            }
        }
    }
/**method to return header text of sub links**/
    public String getHeaderText() {
        boolean element = isElementPresent(By.xpath(".//h2"));
        if (element) {
            return waitforElementVisable(txt_header);
        } else {
            return waitforElementVisable(txt_seatIbiza);
        }
    }

    /** method to verify if the element is present on the page **/
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}



