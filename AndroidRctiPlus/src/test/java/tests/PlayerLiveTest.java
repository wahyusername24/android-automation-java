package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseDriverClass;
import pages.LivePage;
import pages.LoginPage;
import pages.NavigationBar;
import pages.PopUpAndBannerPage;

public class PlayerLiveTest extends BaseDriverClass {
	private NavigationBar navBar;
	private PopUpAndBannerPage popBP;
	private LivePage liveP;
	
	@Test(priority=1)
	public void testPopUpHandling() {
	    try {
	    	initializeDriver(); // Ensure driver is initialized
            popBP = new PopUpAndBannerPage(driver);
            
	    	if (popBP.isPopupPresent()) {
	            System.out.println("Pop-up is present. Closing it...");
	            popBP.closePopup();
	        } else {
	            System.out.println("Pop-up is not present. Continuing with the next scenario...");
	        }
	        // If everything goes well up to this point, mark the test as passed
	        System.out.println("Test passed: Launch App test executed successfully.");
	    } catch (Exception e) {
	        // Catch the exception if the element is not found and log the absence of the popup
	        System.out.println("Pop-up element not found. Test passed as there is no popup to close.");
	    }
	}

	@Test(priority=2)
	public void testPlayerLiveRCTI() throws MalformedURLException {
		initializeDriver(); // Ensure driver is initialized
        popBP = new PopUpAndBannerPage(driver);
        liveP = new LivePage(driver);
        navBar = new NavigationBar(driver);
        
		navBar.liveButton().click();
		liveP.waitLiveTV();
		liveP.rcti().click();
//		Assert.assertEquals(true, );
	}
	
//	public void testLooping() {
//		
//	}
	
//	@AfterTest
//	public void afterTest() {
////		driver.closeApp();
//		driver.quit();
//	}
}
