package managers;

import pages.DriveAwayInsurancePage;
import pages.HomePage;


public class PageObjectManager {

    private DriveAwayInsurancePage driveAwayInsurancePage;

    private HomePage homePage;

    public PageObjectManager() {
    }

    /**
     * To check if object exists and return an existing object if exists using single ton
     **/

    public DriveAwayInsurancePage getDriveAwayInsurancePage() {

        return (driveAwayInsurancePage == null) ? driveAwayInsurancePage = new DriveAwayInsurancePage() : driveAwayInsurancePage;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage() : homePage;
    }
}
