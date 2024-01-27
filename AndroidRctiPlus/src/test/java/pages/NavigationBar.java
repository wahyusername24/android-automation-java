package pages;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NavigationBar {
	private final AndroidDriver<MobileElement> driver;
	
	public NavigationBar(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	public MobileElement homeButton() {
		return driver.findElement(By.id("com.fta.rctitv:id/menuHome"));
	}
	
	public MobileElement liveButton(){
		return driver.findElement(By.id("com.fta.rctitv:id/menuLiveEvent"));
	}
	
	public MobileElement uploadButton() {
		return driver.findElement(By.id("com.fta.rc.rctitv:id/menuTemp"));
	}
	
	public MobileElement shortsButton() {
		return driver.findElement(By.id("com.fta.rc.rctitv:id/menuShort"));
	}
	
	public MobileElement profileButton() {
		return driver.findElement(By.id("com.fta.rctitv:id/menuAccount"));
	}

}
