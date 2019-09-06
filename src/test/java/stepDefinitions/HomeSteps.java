package stepDefinitions;
import context.TestContext;
import corePages.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import org.junit.Assert;
import pages.HomePage;

public class HomeSteps {

    HomePage homePage ;
    PageObjectManager pageObjectManager;

    /**
     * Constructor to initialise page objects using page object manager and also intialising scenario context
     **/
    public HomeSteps() {
        pageObjectManager = new PageObjectManager();
        homePage = pageObjectManager.getHomePage();
    }

/** To validate page title **/
    @Given("^I am on the \"([^\"]*)\" page$")
    public void iAmOnThePage(String title){
        BasePage.currentPageTitle(title);

    }
    /** To display link information from home page **/

    @When("^I click on the \"([^\"]*)\" under home$")
    public void iClickOnTheUnderHome(String sublink){
        homePage.getSubLinkInformation(sublink);

    }


    @Then("^the sub link detail \"([^\"]*)\"  should be displayed$")
    public void theSubLinkDetailShouldBeDisplayed(String information) {

        Assert.assertEquals("Header text is not matched ",information,homePage.getHeaderText());
    }

    @When("^I search for broken link$")
    public void iSearchForBrokenLink() {

        homePage.getLinks();
    }

    @Then("^the  broken link information should be displayed should be displayed$")
    public void theBrokenLinkInformationShouldBeDisplayedShouldBeDisplayed() {
     homePage.verifyLinkActive();
    }
}
