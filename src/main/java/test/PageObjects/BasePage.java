package test.PageObjects;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import test.Listeners.CustomListeners;
import test.utilities.DriverManager;

public abstract class BasePage <T>{
	
	protected static WebDriver driver;
	private long LOAD_TIMEOUT = 30;
    private int AJAX_ELEMENT_TIMEOUT = 10;
	
	public BasePage(){
		
		this.driver = DriverManager.getDriver();
	}
	
	
	public T openPage(Class<T> clazz){
		T page = null;
		try{
		driver =DriverManager.getDriver();
		AjaxElementLocatorFactory ajaxElemFactory = new AjaxElementLocatorFactory(driver, AJAX_ELEMENT_TIMEOUT);
		page=PageFactory.initElements(driver, clazz);
		ExpectedCondition getPageLoadCondition= 	((BasePage) page).getPageLoadCondition();
		waitForPageToLoad(getPageLoadCondition);
		}catch(NoSuchElementException e) {
	        /*    String error_screenshot = System.getProperty("user.dir") + "\\target\\screenshots\\" + clazz.getSimpleName() + "_error.png";
            this.takeScreenShot(error_screenshot);
     */       throw new IllegalStateException(String.format("This is not the %s page", clazz.getSimpleName()));
        }
        return page;
		
	}
	
	
	 private void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
	    	WebDriverWait wait = new WebDriverWait(driver,LOAD_TIMEOUT);
	       // wait.until(pageLoadCondition);
	    	wait.until(pageLoadCondition);
	    }
	
	
	protected abstract ExpectedCondition getPageLoadCondition();
	
	
	
	 public static void click(WebElement element ,String elementName) {

			element.click();
			CustomListeners.testReport.get().log(Status.INFO, "Clicking on : " + elementName);
		}

		public void type(WebElement element, String value ,String elementName) {

			element.sendKeys(value);
			CustomListeners.testReport.get().log(Status.INFO, "Typing in : " + elementName + " entered value as " + value);

		}
		
		
		
		static WebElement dropdown;

		public void select(WebElement element, String value ) {

			dropdown=element;
			
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);

			CustomListeners.testReport.get().log(Status.INFO, "Selecting from dropdown : " + element + " value as " + value);

		}
		

}
