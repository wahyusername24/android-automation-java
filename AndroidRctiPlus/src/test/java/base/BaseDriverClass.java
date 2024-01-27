package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BaseDriverClass {
	public static AndroidDriver<MobileElement> driver;
	
	public BaseDriverClass() {
	        // Private constructor to prevent external instantiation
    }
	
	public static AndroidDriver<MobileElement> initializeDriver() throws MalformedURLException {
		if(driver==null) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appium:platformName", "Android");
		    dc.setCapability("appium:deviceName", "TVERK19124001808"); //0624f23a
		    dc.setCapability("appium:appPackage", "com.fta.rctitv");
		    dc.setCapability("appium:noReset", true);
		    dc.setCapability("appium:appActivity", "com.fta.rctitv.ui.splashscreen.SplashScreenActivity");
		
		    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		
		    driver = new AndroidDriver<>(remoteUrl, dc);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
	    return driver;
	}
	
	public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}