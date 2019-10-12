package pages;

import corePages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class GoogleSearchPage extends BasePage {

    @FindBy(how = How.NAME, using = "q")
    private WebElement googleSearchTextBx;

    @FindBy(how = How.NAME, using = "btnK")
    private WebElement googleSearchBtn;

    @FindBy(how = How.CLASS_NAME, using = "iUh30")
    private WebElement linkText;

    @FindBy(how = How.CLASS_NAME, using = "LC20lb")
    private List<WebElement> links;

    /** Method to send text to input field**/
    public void inputText(String text) {
        googleSearchTextBx.clear();
        googleSearchTextBx.sendKeys(text);
    }

    /** Method to send text to input field**/
    public void search() {
        BasePage.waitForElementClick(googleSearchBtn);
    }


    /** Method to get search result **/
    public boolean getSearchResult(String searchText) {
        boolean result = false;

        if (links.get(0).getText().contains(searchText)) {
            result = true;
        }
        return result;
    }

    /** Method to return text of the webelement**/
    public String verifyResult() {
        return waitforElementVisable(linkText);
    }


}

