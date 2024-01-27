package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseDriverClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BaseDriverClass{
	private final AndroidDriver<MobileElement> driver;
	public LoginPage(AndroidDriver<MobileElement> drivers) {
		this.driver = drivers;
	}
	
	public MobileElement loginBtn() {
		return driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.Button"));
	}
	
	public MobileElement loginIcon() {
		return driver.findElement(By.id("com.fta.rctitv:id/ivIconProfile"));
	}
	
	public MobileElement loginText() {
		return driver.findElement(By.id("com.fta.rctitv:id/tvLoginText"));
	}
	
	public MobileElement email() {
		return driver.findElement(By.id("com.fta.rctitv:id/edtEmailOrPhoneNumber"));
	}
	
	public MobileElement password() {
		return driver.findElement(By.id("com.fta.rctitv:id/edtPassword"));
	}
	
	public MobileElement loginBtn2() {
		return driver.findElement(By.id("com.fta.rctitv:id/btnLogin"));
	}
	
	public MobileElement fullname() {
		return driver.findElement(By.id("com.fta.rctitv:id/tvFullName"));
	}
	
	public MobileElement settingBtn() {
		return driver.findElement(By.id("com.fta.rctitv:id/btnSetting"));
	}
	
	public MobileElement settingsTitle() {
		return driver.findElement(By.id("com.fta.rctitv:id/tvToolbarTitle"));
	}
	public MobileElement scrollSettings() {
		return driver.findElement(By.xpath("com.fta.rctitv:id/tvVersions"));	
	}
	
	public MobileElement logout() {
		return driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Image Description\"])[17]"));
	}
	        
	public MobileElement waitLogout() {
		WebDriverWait wait = new WebDriverWait(driver, 20); // Initializing WebDriverWait with a timeout of 20 seconds

        // Wait for the presence of the loading element
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.fta.rctitv:id/tvLoginText")));
		return null;
	}
	
	public MobileElement waitSettings() {
		WebDriverWait wait = new WebDriverWait(driver, 20); // Initializing WebDriverWait with a timeout of 20 seconds

        // Wait for the presence of the loading element
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//android.widget.ImageView[@content-desc=\"Image Description\"])[13]")));
		return null;

	}
	
	
}
