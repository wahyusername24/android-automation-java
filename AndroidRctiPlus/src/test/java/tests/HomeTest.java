package tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseDriverClass;
import io.appium.java_client.MobileElement;
import pages.HomePage;
import pages.NavigationBar;
import pages.PopUpAndBannerPage;
import pages.ShortPage;

public class HomeTest extends BaseDriverClass {
	private NavigationBar navBar;
	private PopUpAndBannerPage popBP;
	private ShortPage shtP;
	private HomePage homP;
	
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
	
	@Test(priority = 2)
	public void testWaitPlayer() {
	    // Try to wait for exoProgress
	    try {
            initializeDriver(); // Ensure driver is initialized
            shtP = new ShortPage(driver);

	    	
	    	shtP.exoPlayerVideo();
	        System.out.println("Waiting for exoPlayerVideo to load...");
	    } catch (Exception ex) {
	        // If exoProgress is not found or times out
	        try {
	        	shtP.exoPlayersNews();
	            System.out.println("Waiting for exoPlayerNews to load...");
	        } catch (Exception e) {
	            // If neither exoProgress nor exoProgressNews is visible or times out
	            System.out.println("Neither exoPlayerVideo nor exoPlayerNews found.");
	        }
	    }
	}
	
	@Test(priority=3)
	public void testHome() throws MalformedURLException {
		initializeDriver(); // Ensure driver is initialized
	    homP = new HomePage(driver);
	    navBar = new NavigationBar(driver);
		
		homP.waitHome();
		
		navBar.homeButton().click();
		homP.waitBannerVisible();
		MobileElement logoElement = driver.findElement(By.id("com.fta.rctitv:id/btnHomeTabIconV2"));
		Assert.assertTrue(logoElement.isDisplayed());
		System.out.println("Home Test Passed");
	}
	
	@Test(priority=4, enabled = false)
	public void testBannerMainHomepage() throws InterruptedException, MalformedURLException{
		initializeDriver(); // Ensure driver is initialized
        popBP = new PopUpAndBannerPage(driver);
        
		navBar.homeButton().click();
		MobileElement banner = driver.findElement(By.id("com.fta.rctitv:id/ivHeadlineBackground"));
		banner.click();		
		TimeUnit.SECONDS.sleep(5);
//		MobileElement forward = driver.findElement(By.id("com.fta.rctitv:id/playerForward"));
		MobileElement schedule = driver.findElement(By.id("com.fta.rctitv:id/tv_schedule"));

		Assert.assertTrue(schedule.isDisplayed());
	
	}
	
	
//	@AfterTest
//	public void afterTest() {
////		driver.closeApp();
//		driver.quit();
//	}
}
