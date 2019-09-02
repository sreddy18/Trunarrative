package pages;
import corePages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class DriveAwayInsurancePage extends BasePage {

    /**Defining the page elements of the vehicle cover check page  **/

    @FindBy(how = How.ID, using = "header")
    private WebElement img_pageHeader;

    @FindBy(how = How.ID, using = "vehicleReg")
    private WebElement txtbx_vehicleReg;

    @FindBy(how = How.NAME, using = "btnfind")
    private WebElement btn_findVehicle;

    @FindBy(how = How.ID, using = "dlg-dealersearch-title")
    private WebElement txt_searchTitle;

    @FindBy(how = How.XPATH, using = "//div[@id='dlg-dealersearch-subtitle']")
    private WebElement txt_searchSubTitle;

    @FindBy(how = How.CLASS_NAME, using = "error-required")
    private WebElement txt_blankErrMsg;

    @FindBy(how = How.CLASS_NAME, using = "result")
    private WebElement txt_invalidErrMsg;

    @FindBy(how = How.CSS, using = "div[class*=resultDate-bold]:nth-of-type(2)")
    private WebElement txt_coverStartDate;

    @FindBy(how = How.CSS, using = "div[class*=resultDate-bold]:nth-of-type(3)")
    private WebElement txt_coverEndDate;

    /** methods that  are used to interact web elements  of the page **/
    public void enterRegistrationNo(String vehicleNo) { txtbx_vehicleReg.sendKeys(vehicleNo); }

    public void findVehicle() { btn_findVehicle.click(); }

    public void navigateToHomePage() {img_pageHeader.click();}

    /**Method to return error message when vehicle registration no is blank **/
    public String blankErrorMessage() { return waitforElementVisable(txt_blankErrMsg);}

    /**Method to return valid message when vehicle registration no is invalid **/
    public String invalidErrorMessage() { return waitforElementVisable(txt_invalidErrMsg); }

    /**Method to return cover start date **/
    public String verifyCoverStartDate() { return waitforElementVisable(txt_coverStartDate); }

    /**Method to return cover end date **/
    public String verifyCoverEndDate() { return waitforElementVisable(txt_coverEndDate); }

}
