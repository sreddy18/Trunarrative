package stepDefinitions;

import corePages.BasePage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import org.junit.Assert;
import pages.GoogleSearchPage;


public class GenericSteps {

    GoogleSearchPage googleSearchPage;
    PageObjectManager pageObjectManager;

    public GenericSteps() {
        pageObjectManager = new PageObjectManager();
        googleSearchPage = pageObjectManager.getGoogleSearchPage();
    }

    @Given("^I am on the google page$")
    public void iAmOnTheGooglePage() {
        BasePage.getUrl();
    }

    @When("^the user enters text \"([^\"]*)\" into the search bar$")
    public void theUserEntersIntoTheSearchBar(String searchText) {
        googleSearchPage.inputText(searchText);
    }

    @And("^I click on google search button$")
    public void iClickOnGoogleSearchButton() {
        googleSearchPage.search();
    }

    @Then("^\"([^\"]*)\" should be the first result on the search page$")
    public void shouldBeTheFirstResultOnTheSearchPage(String searchText) {
        Assert.assertTrue(googleSearchPage.getSearchResult(searchText));
    }

    @And("^website link should be displayed as \"([^\"]*)\"$")
    public void websiteLinkShouldBeDisplayedAs(String linkText) {
        Assert.assertEquals("links do not match", linkText,googleSearchPage.verifyResult());
    }
}
