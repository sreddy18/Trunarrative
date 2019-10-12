package pages;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import corePages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruNarrativePage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "iUh30")
    private WebElement homepageLink;

    @FindBy(how = How.CLASS_NAME, using = "TruNarrative Logo")
    private WebElement logoText;

    @FindBy(how = How.CLASS_NAME, using = "bigger")
    private WebElement strapLineText;

    @FindBy(how = How.LINK_TEXT, using = "More")
    private WebElement moreMenu;

    @FindBy(how = How.LINK_TEXT, using = "TruNarrative Team")
    private WebElement teamMainLink;

    @FindBy(how = How.CLASS_NAME, using = "stack-img-content")
    private List<WebElement> teamList;


    /**
     * Method to navigate to trunarrative home page
     **/

    public void navigateToHomePage() {

        BasePage.waitForElementClick(homepageLink);

    }

    /**
     * Method to verify  trunarrative strap line
     */
    public String verifyHeaderLine() {

        return strapLineText.getText();

    }

    /**
     * Method to verify  trunarrative strap line
     */

    public String verifyLogoText() {
        return logoText.getText();

    }

    public void getTeamMembersDisplayed()
    {
        waitForElementClick(moreMenu);
        waitForElementClick(teamMainLink);
    }

    public Map veriyTeamMembers(Map<String, String> expectedMap) {
        Map<String, String> actualMap = new HashMap<String, String>();
        for (int i = 0; i < teamList.size(); i++) {
            String fullText = teamList.get(i).getText();
            String keyValue[] = fullText.split("\n");
            actualMap.put(keyValue[0], keyValue[1]);
        }
        MapDifference<String, String> diff = Maps.difference(actualMap, expectedMap);
        Map<String, String> entriesInCommon = diff.entriesInCommon();
        return entriesInCommon;
    }

}