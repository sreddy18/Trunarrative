package utilities;

import org.openqa.selenium.WebDriver;
import corePages.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;


public class Hooks {
	    
	    
	    @Before(order=1)
	   public void beforeScenario(){
	    	/*What all you can perform here
	    	 Starting a webdriver
	    	 Setting up DB connections
	    	 Setting up test data
	    	 Setting up browser cookies
	    	 Navigating to certain page
	    	 or anything before the test
	    	 /** Initialising the browser **/
	         BasePage.initBrowser(FileReaderManager.getInstance().getConfigReader().getBrowserType());
	  	     BasePage.getUrl();
	          }
	  
	    
	    @After(order=1)
	    public void afterScenario(){
	   	//To close the browser at the end of the scenario
		   BasePage.closeBrowser();
	    } 
	
  
	  }
	 
	
	  
	  
	   

	 


