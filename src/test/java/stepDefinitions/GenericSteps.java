package stepDefinitions;

import corePages.BasePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import pages.DriveAwayInsurancePage;

import static org.junit.Assert.assertTrue;

public class GenericSteps {
    DriveAwayInsurancePage driveAwayInsurancePage;
    PageObjectManager pageObjectManager;


    public GenericSteps() {
        pageObjectManager = new PageObjectManager();
        driveAwayInsurancePage = pageObjectManager.getDriveAwayInsurancePage();

    }

    /**
     * To verify page title
     **/
    @Given("^I am on the insurance \"([^\"]*)\" page$")
    public void iAmOnTheInsurancePage(String title) {
        assertTrue("Page title is incorrect", BasePage.currentPageTitle(title));

    }
/** To navigate to home page from drive away insurance **/
    @When("^I click on the volkswagen financial services link$")
    public void iClickOnTheVolkswagenFinancialServicesLink() {
        driveAwayInsurancePage.navigateToHomePage();

    }

    /**
     * To verify page title
     **/
    @Then("^the \"([^\"]*)\" page should be displayed$")
    public void thePageShouldBeDisplayed(String title) {
        assertTrue("Title not found", BasePage.currentPageTitle(title));
    }
}
