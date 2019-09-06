package pages;

import corePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage {

    /**Defining the page elements of home page  **/

    @FindBy(how = How.XPATH, using = "//section[1]/div[1]/h3[1]")
    private WebElement txt_seatIbiza;

    @FindBy(how = How.XPATH, using = "//div[@id='mainnav']//ul//li")
    private List<WebElement> allElementsInList;

    @FindBy(how = How.XPATH, using = ".//h2")
    private WebElement txt_header;

    @FindBy(how = How.TAG_NAME, using = "a")
    private List<WebElement> links;

    //Array list varaiable
    List urlList= new ArrayList();


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


    public void getLinks()
    {
            //used for loop to
            for(int i=0; i<links.size(); i++) {
                WebElement element = links.get(i);
                //By using "href" attribute, we could get the url of the requried link
                String url=element.getAttribute("href");
                //calling verifyLink() method here. Passing the parameter as url which we collected in the above link
                //See the detailed functionality of the verifyLink(url) method below
                urlList.add(url);

            }
    }

    public  void verifyLinkActive()
    {
        for(int i=0; i<urlList.size(); i++) {

            try {
                URL url = new URL(urlList.get(i).toString());

                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

                httpURLConnect.setConnectTimeout(3000);

                httpURLConnect.connect();

                if (httpURLConnect.getResponseCode() == 200) {
                    System.out.println(urlList.get(i).toString() + " - " + httpURLConnect.getResponseMessage());
                }
                if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                    System.out.println(urlList.get(i).toString() + " - " + httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
                }
            } catch (Exception e) {

            }
        }
    }


}








