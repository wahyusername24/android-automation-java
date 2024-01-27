package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseDriverClass;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import pages.LoginPage;
import pages.NavigationBar;
import pages.PopUpAndBannerPage;
import pages.ShortPage;
 
public class LoginTest extends BaseDriverClass{
	private NavigationBar navBar;
	private LoginPage logP;
	private ShortPage shtP;
	private PopUpAndBannerPage popBP;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		driver = initializeDriver();
		navBar = new NavigationBar(driver);
		logP = new LoginPage(driver);
		shtP = new ShortPage(driver);
		popBP = new PopUpAndBannerPage(driver);
	}
	
	@Test(priority=1)
	public void testPopUpHandling() {
	    try {
	        if (popBP.isPopupPresent()) {
	            System.out.println("Pop-up is present. Closing it...");
	            popBP.closePopup();
	        } else {
	            System.out.println("Pop-up is not present. Continuing with the next scenario...");
	        }
	        // If everything goes well up to this point, mark the test as passed
	        System.out.println("Test passed: Launch App test executed successfully.");
	    } catch (NoSuchElementException e) {
	        // Catch the exception if the element is not found and log the absence of the popup
	        System.out.println("Pop-up element not found. Test passed as there is no popup to close.");
	    }
	}
	
	@Test(priority = 2)
	public void testWaitPlayer() {
	    // Try to wait for exoProgress
	    try {
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
	
	@Test(priority = 3)
	public void testLoginValidEmail(){			
		navBar.profileButton().click();
		Assert.assertTrue(logP.loginIcon().isDisplayed());
		
		String textValue = logP.loginText().getText();
		Assert.assertEquals(textValue, "Login to RCTI+");
		
		logP.loginBtn().click();
		logP.email().sendKeys("wahyupanji240@gmail.com");
		logP.password().sendKeys("qwerty12345");
		logP.loginBtn2().click();
		
		Assert.assertTrue(logP.fullname().isDisplayed());
		
		logP.settingBtn().click();
		Assert.assertTrue(logP.settingsTitle().isDisplayed());
		logP.waitSettings();

		// Replace these coordinates with your desired start and end points
//        int startX = 370; // X-coordinate for starting point
//        int startY = 1365; // Y-coordinate for starting point
//        int endX = 370;   // X-coordinate for ending point
//        int endY = 156;   // Y-coordinate for ending point
    
		int startX = 360; // X-coordinate for starting point
        int startY = 1427; // Y-coordinate for starting point
        int endX = 360;   // X-coordinate for ending point
        int endY = 200;   // Y-coordinate for ending point
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                   .waitAction()
                   .moveTo(PointOption.point(endX, endY))
                   .release()
                   .perform();
		
		logP.logout().click();
		logP.waitLogout();
		
		String textValue2 = logP.loginText().getText();
		Assert.assertEquals(textValue2, "Login to RCTI+");
	}
	
	@Test(priority = 3, enabled = false)
	public void testLoginValidPhone(){	
		logP.loginBtn().click();
		logP.email().sendKeys("085894722546");
		logP.password().sendKeys("qwerty12345");
		logP.loginBtn2().click();
				
		logP.settingBtn().click();
		Assert.assertTrue(logP.settingsTitle().isDisplayed());

		// Replace these coordinates with your desired start and end points
//        int startX = 370; // X-coordinate for starting point
//        int startY = 1365; // Y-coordinate for starting point
//        int endX = 370;   // X-coordinate for ending point
//        int endY = 156;   // Y-coordinate for ending point
        int startX = 360; // X-coordinate for starting point
        int startY = 1427; // Y-coordinate for starting point
        int endX = 360;   // X-coordinate for ending point
        int endY = 200;   // Y-coordinate for ending point

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                   .waitAction()
                   .moveTo(PointOption.point(endX, endY))
                   .release()
                   .perform();

		logP.logout().click();
		logP.waitLogout();
		
	}
	
	@Test(enabled=false)
	public void logout() {
		navBar.profileButton().click();
		Assert.assertTrue(logP.fullname().isDisplayed());
		
		logP.settingBtn().click();
		Assert.assertTrue(logP.settingsTitle().isDisplayed());
		logP.waitSettings();

		int startX = 360; // X-coordinate for starting point
        int startY = 1427; // Y-coordinate for starting point
        int endX = 360;   // X-coordinate for ending point
        int endY = 200;   // Y-coordinate for ending point
        
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                   .waitAction()
                   .moveTo(PointOption.point(endX, endY))
                   .release()
                   .perform();
		
		logP.logout().click();
		logP.waitLogout();
		
		String textValue2 = logP.loginText().getText();
		Assert.assertEquals(textValue2, "Login to RCTI+");
	}
	
	@AfterTest
	public void afterTest() {
//		driver.closeApp();
		driver.quit();
	}
}

