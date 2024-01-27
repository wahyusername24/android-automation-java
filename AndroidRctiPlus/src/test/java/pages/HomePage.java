package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	private final AndroidDriver<MobileElement> driver;
	public HomePage(AndroidDriver<MobileElement> drivers) {
		this.driver = drivers;
	}
	
	public MobileElement waitBannerVisible(){
		  WebDriverWait wait = new WebDriverWait(driver, 20); // Initializing WebDriverWait with a timeout of 20 seconds

	        // Wait for the presence of the loading element
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fta.rctitv:id/ivHeadlineBackground")));
	        // Wait for the loading element to disappear
//	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.fta.rctitv:id/exo_buffering")));
			return null;
	}
	public MobileElement waitHome(){
		  WebDriverWait wait = new WebDriverWait(driver, 20); // Initializing WebDriverWait with a timeout of 20 seconds

	        // Wait for the presence of the loading element
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fta.rctitv:id/menuHome")));
	        // Wait for the loading element to disappear
//			        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.fta.rctitv:id/exo_buffering")));
			return null;
	}
}
