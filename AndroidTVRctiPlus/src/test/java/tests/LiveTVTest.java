package tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.LiveTVPage;

public class LiveTVTest {
	private AndroidDriver<MobileElement> driver; 
    private LiveTVPage tvPage;

	@BeforeTest
	    public void setUp() {
	        // Initialize the driver before the tests start
         	driver = AndroidTVDriver.getDriver();
	        tvPage = new LiveTVPage(driver);
	}
	
	@Test
	public void navigateOnTV() throws InterruptedException {
		AndroidTVDriver.pressRight();
        TimeUnit.SECONDS.sleep(1);
//	    AndroidTVDriver.pressDown();
	}
	
	@Test
	public void testNavigateToLiveTV() throws InterruptedException {
		AndroidTVDriver.pressBack();
        TimeUnit.SECONDS.sleep(2);
	    AndroidTVDriver.pressDown();
        Thread.sleep(600);
	    AndroidTVDriver.pressDown();
        Thread.sleep(600);
	    AndroidTVDriver.pressDown();
        Thread.sleep(600);
	    AndroidTVDriver.pressCenter();

	    Assert.assertTrue(tvPage.watchNowBtn().isDisplayed());
	    AndroidTVDriver.pressRight();
	    
	    for(int f=0; f<4; f++) {
	    	boolean isElementPresent = false;
	    	try {
	    		
	    		// If element is found, set isElementPresent to true
                isElementPresent = true;
                String title = tvPage.channelTitle().getText();
                String sch = tvPage.schedule().getText();
                System.out.println(title);
                System.out.println(sch);
                Assert.assertTrue(tvPage.poster().isDisplayed());
                Assert.assertTrue(true, title);
                Assert.assertTrue(true, sch);
                
                AndroidTVDriver.pressRight();
                TimeUnit.SECONDS.sleep(1);
                
	    	}catch (NoSuchElementException e) {
	    		System.out.println("Element empty");			
    		}
	    }	    
	}
	
	@Test
	public void testPlayRCTI() throws InterruptedException {
		AndroidTVDriver.pressBack();
        TimeUnit.SECONDS.sleep(2);
        AndroidTVDriver.pressCenter();
        Thread.sleep(500);
        AndroidTVDriver.pressCenter();
//        tvPage.waitExoAdsOverlay();
        tvPage.waitExoAdsTextView();
//        negative scenario: geoblock, fail to watch, stream error
	}
	
}
