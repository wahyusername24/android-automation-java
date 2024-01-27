package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PopUpAndBannerPage {
	private final AndroidDriver<MobileElement> driver;
	public PopUpAndBannerPage(AndroidDriver<MobileElement> drivers) {
		this.driver = drivers;
	}
	
	public boolean isPopupPresent() {
        try {
            // Check for the presence of the popup using its unique identifier or properties
            // For instance, you can use expected conditions, find element by ID, xpath, etc.
            // Return true if the popup is found
            return driver.findElement(By.id("com.fta.rctitv:id/half_interstitial_image")).isDisplayed();
        } catch (NoSuchElementException e) {
            // If the element is not found, return false
            return false;
        }
    }
	
	public void closePopup() {
	    // Perform actions to close the popup, such as finding and clicking on the close button
	    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView")).click();
	    // Add necessary waiting or additional handling if required
    }
}
