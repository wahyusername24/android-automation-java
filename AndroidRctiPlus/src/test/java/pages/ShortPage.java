package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseDriverClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ShortPage extends BaseDriverClass{
	private final AndroidDriver<MobileElement> driver;
	public ShortPage(AndroidDriver<MobileElement> drivers) {
		this.driver = drivers;
	}
	
	public MobileElement exoBufferAds(){
		  WebDriverWait wait = new WebDriverWait(driver, 20); // Initializing WebDriverWait with a timeout of 20 seconds

	        // Wait for the presence of the loading element
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fta.rctitv:id/exo_buffering")));
	        // Wait for the loading element to disappear
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.fta.rctitv:id/exo_buffering")));
			return null;
	}       
	
	public MobileElement exoPlayerVideo() {
			WebDriverWait wait = new WebDriverWait(driver, 10); // Initializing WebDriverWait with a timeout of 20 seconds

			// Wait for the presence of the loading element
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fta.rctitv:id/exo_progress")));
			return null;
	}
	
	public MobileElement exoPlayersNews() {
			WebDriverWait wait = new WebDriverWait(driver, 5); // Initializing WebDriverWait with a timeout of 20 seconds

		      // Wait for the presence of the loading element
		      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fta.rctitv:id/tv_content")));
		      return null;
	}
	
}
