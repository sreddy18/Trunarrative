package stepDefinitions;

import context.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import org.junit.Assert;
import pages.DriveAwayInsurancePage;
import static org.junit.Assert.assertEquals;


public class DriveAwayInsuranceSteps {
    DriveAwayInsurancePage driveAwayInsurancePage;
    PageObjectManager pageObjectManager;
    TestContext testContext;

    /**
     * Constructor to initialise page objects using page object manager and also intialising scenario context
     **/
    public DriveAwayInsuranceSteps() {
        pageObjectManager = new PageObjectManager();
        this.testContext = new TestContext();
        driveAwayInsurancePage = pageObjectManager.getDriveAwayInsurancePage();
    }

    @And("^I click on the find vehicle button$")
    public void iClickOnTheFindVehicleButton() {
        driveAwayInsurancePage.findVehicle();
    }

    /**
     * Assertion for error message
     **/
    @Then("^the valid error message \"([^\"]*)\" should be displayed$")
    public void theValidErrorMessageShouldBeDisplayed(String message) {
        if (testContext.getRegistrationNo().equalsIgnoreCase("")) {
            assertEquals(message, driveAwayInsurancePage.blankErrorMessage());
        } else {
            assertEquals(message, driveAwayInsurancePage.invalidErrorMessage());
        }

    }

    /**
     * Method to send regsitration no from the feature file to the page and storing registration no in the
     * test context for future use
     **/
    @When("^I enter valid vehicle registration no \"([^\"]*)\"$")
    public void iEnterValidVehicleRegistrationNo(String registrationNo) {
        driveAwayInsurancePage.enterRegistrationNo(registrationNo);
        testContext.setRegistrationNo(registrationNo);
    }


    /**
     * Assertions cover start date and end date
     **/
    @Then("^the vehicle \"([^\"]*)\" and \"([^\"]*)\" dates should be displayed$")
    public void theVehicleAndShouldBeDisplayed(String startDate, String endDate) {
        Assert.assertEquals("Expected and Actual cover start date are not equal", startDate, driveAwayInsurancePage.verifyCoverStartDate());
        Assert.assertEquals("Expected and Actual cover end date are not equal", endDate, driveAwayInsurancePage.verifyCoverEndDate());

    }

}
