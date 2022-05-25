package test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import test.utilities.DriverManager;

public class HomePage extends BasePage {

	   public HomePage open(String url) {
		   
        DriverManager.getDriver().get(url);
		System.out.println("Navigated to :" + url);
		return (HomePage) openPage(HomePage.class);

	}

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Account']")
	public WebElement accountsTab;

	public LoginPage accountsTab() {

		//accountsTab.click();
		click(accountsTab ,"accountstab");
		return (LoginPage) openPage(LoginPage.class);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(accountsTab);
	}
}
