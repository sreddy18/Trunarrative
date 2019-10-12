package stepDefinitions;

import corePages.BasePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import org.junit.Assert;
import pages.TruNarrativePage;

import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;


public class TrunarrativeSteps {

    PageObjectManager pageObjectManager;
    TruNarrativePage truNarrativePage;

    public TrunarrativeSteps() {
        pageObjectManager = new PageObjectManager();
        truNarrativePage = pageObjectManager.getTruNarrativePage();
    }

    @When("^I click on TruNarrative web link$")
    public void iClickOnTruNarrativeWebLink() {
        truNarrativePage.navigateToHomePage();
    }

    @And("^the strap line \"([^\"]*)\" below text should be displayed on the home page$")
    public void theStrapLineBelowTextShouldBeDisplayedOnTheHomePage(String strapText) {
        assertEquals("Strap lines are not equal", strapText, truNarrativePage.verifyHeaderLine());
    }

    @Then("^TruNarrative website with title \"([^\"]*)\" should be displayed$")
    public void trunarrativeWebsiteWithTitleShouldBeDisplayed(String title) {
        assertTrue(BasePage.currentPageTitle(title));

    }

    @And("^TruNarrative team should include the following team members$")
    public void trunarrativeTeamShouldIncludeTheFollowingTeamMembers(Map<String, String> dataMap) {
        truNarrativePage.getTeamMembersDisplayed();
        assertEquals("Common entries size is not equal to 3", 3, truNarrativePage.veriyTeamMembers(dataMap).size());
        assertThat(truNarrativePage.veriyTeamMembers(dataMap).toString(), containsString(dataMap.get(dataMap.keySet().toArray()[0])));
        assertTrue(truNarrativePage.veriyTeamMembers(dataMap).values().toArray()[0].equals(dataMap.get(dataMap.keySet().toArray()[0])));
        assertThat(truNarrativePage.veriyTeamMembers(dataMap).toString(), containsString(dataMap.get(dataMap.keySet().toArray()[1])));
        assertThat(truNarrativePage.veriyTeamMembers(dataMap).toString(), containsString(dataMap.get(dataMap.keySet().toArray()[2])));
        assertTrue(truNarrativePage.veriyTeamMembers(dataMap).values().toArray()[2].equals(dataMap.get(dataMap.keySet().toArray()[2])));
    }
}