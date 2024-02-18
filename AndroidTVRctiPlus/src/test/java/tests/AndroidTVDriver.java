package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidTVDriver {
	
	private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "your_device_name");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appPackage", "com.rctiplus.atv");
            capabilities.setCapability("appActivity", "com.rctiplus.atv.presentation.splashscreen.SplashScreenActivity");
            // Set other capabilities as needed for your TV setup

            try {
                // Initialize driver
                URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
                driver = new AndroidDriver<>(serverUrl, capabilities);
                
                // Wait for 3 seconds
                System.out.println("Setting Config Driver | wait 3s");
                TimeUnit.SECONDS.sleep(3);
                
            } catch (MalformedURLException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
    public static void pressUp() {
    	executeADBCommand("adb shell input keyevent 19");
    }
    public static void pressDown() {
    	executeADBCommand("adb shell input keyevent 20");
    }
    public static void pressLeft() {
        executeADBCommand("adb shell input keyevent 21");
    }
    public static void pressRight() {
        executeADBCommand("adb shell input keyevent 22");
    }
    public static void pressCenter() {
        executeADBCommand("adb shell input keyevent 23");
    }
    public static void pressBack() {
        executeADBCommand("adb shell input keyevent 4");
    }
    
    private static void executeADBCommand(String cmd) {
    	try {
    		Runtime.getRuntime().exec(cmd);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}
