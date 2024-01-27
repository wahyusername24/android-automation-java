package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LivePage {
	private final AndroidDriver<MobileElement> driver;
	public LivePage(AndroidDriver<MobileElement> drivers) {
		this.driver = drivers;
	}
	
	public MobileElement rcti() {
		return driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Image Description\"])[2]"));
	}
	public MobileElement mnctv() {
		return driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Image Description\"])[3]"));
	}
	public MobileElement gtv() {
		return driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Image Description\"])[4]"));
	}
	public MobileElement inews() {
		return driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Image Description\"])[5]"));
	}
	public MobileElement waitLiveTV(){
		  WebDriverWait wait = new WebDriverWait(driver, 20); // Initializing WebDriverWait with a timeout of 20 seconds

	        // Wait for the presence of the loading element
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@content-desc=\"Image Description\"])[5]")));
	        // Wait for the loading element to disappear
//	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.fta.rctitv:id/exo_buffering")));
			return null;
	}
}
