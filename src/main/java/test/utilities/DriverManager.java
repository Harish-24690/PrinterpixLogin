package test.utilities;


import java.util.Date;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
	
public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver(){
		
		return dr.get();
	}
	
	public static void setWebDriver(WebDriver driver){
		
		dr.set(driver);
	}
	
	
}
