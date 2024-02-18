package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LiveTVPage {
	private AndroidDriver<MobileElement> driver;
	
	public LiveTVPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public MobileElement watchNowBtn() {
		return driver.findElement(By.id("com.rctiplus.atv:id/btn_watch_now"));
	}
	
	public MobileElement poster() {
		return driver.findElement(By.id("com.rctiplus.atv:id/poster"));
	}
	
	public MobileElement channelTitle() {
		return driver.findElement(By.id("com.rctiplus.atv:id/title"));
	}
	
	public MobileElement schedule() {
		return driver.findElement(By.id("com.rctiplus.atv:id/schedule"));
	}
	
	public MobileElement waitExoAdsOverlay(){
		  WebDriverWait wait = new WebDriverWait(driver, 20); // Initializing WebDriverWait with a timeout of 20 seconds

	        // Wait for the presence of the loading element
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.rctiplus.atv:id/exo_ad_overlay")));
	        // Wait for the loading element to disappear
//	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.rctiplus.atv:id/exo_ad_overlay")));
			return null;
	}
	
	public MobileElement waitExoAdsTextView(){
		  WebDriverWait wait = new WebDriverWait(driver, 40); // Initializing WebDriverWait with a timeout of 20 seconds

	        // Wait for the presence of the loading element
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.TextView")));
	        // Wait for the loading element to disappear
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[1]/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.TextView")));
			return null;
	}

	
//	public MobileElement poster() {
//		return driver.findElement(By.id("com.rctiplus.atv:id/poster"));
//	}
//	public MobileElement waitLogout() {
//		WebDriverWait wait = new WebDriverWait(driver, 20); // Initializing WebDriverWait with a timeout of 20 seconds
//
//        // Wait for the presence of the loading element
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fta.rctitv:id/tvLoginText")));
//		return null;
//	}
//	
}