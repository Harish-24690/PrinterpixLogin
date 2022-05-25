package steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import test.Listeners.CustomListeners;
import test.utilities.DriverFactory;
import test.utilities.DriverManager;

public class BaseSteps {
	
	private WebDriver driver;
	private Properties config = new Properties();
	private FileInputStream fis;
	private Boolean grid =true;
	private String DefaultUsername;
	private String DefaultPassword;
	
	
	public String getDefaultUsername() {
		return DefaultUsername;
	}



	public void setDefaultUsername(String defaultUsername) {
		DefaultUsername = defaultUsername;
	}



	public String getDefaultPassword() {
		return DefaultPassword;
	}



	public void setDefaultPassword(String defaultPassword) {
		DefaultPassword = defaultPassword;
	}



	
	   public void setUpFrameWork(){
		
		
		DriverFactory.setGridPath("http://localhost:4444/wd/hub");
		DriverFactory.setConfigPropertyFile(
				System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");
		
		if (System.getProperty("os.name").contains("mac")) {

			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables.chromedriver");
			DriverFactory.setGeckoDriverExepath(
					System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver");
		} else {
			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables.chromedriver.exe");
			DriverFactory.setGeckoDriverExepath(
					System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver.exe");
		}
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			// log.info("Configuration file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	
	public void openBrowser(String browser){
		
		/*if(System.getenv("ExceutionType")!=null && System.getenv("ExceutionType").equals("Grid")){
			
			grid=true;
		}
		*/
		DriverFactory.setRemote(grid);
		
		if(DriverFactory.isRemote()){
			
			DesiredCapabilities cap = null;
			
			if(browser.equals("chrome")){
				
				cap= DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			}else if(browser.equals("firefox")){
				
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			}
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				
			
		}else {
			
			if(browser.equals("chrome")){
			
			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			}else if(browser.equals("firefox")){
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			
		}
		DriverManager.setWebDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		setDefaultUsername(config.getProperty("DefaultUsername"));
		setDefaultPassword(config.getProperty("DefaultPassword"));
		
			
		}
		
	
		public  void logInfo(String message) {
			
			CustomListeners.testReport.get().info(message);
		}
	
	
	
	public void tearDown(){
		
		DriverManager.getDriver().quit();
	}
	

}
