package test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginToFacebookPage extends BasePage {
	
	// locators
	@FindBy(how=How.XPATH,using="//input[@id='email']")
	public WebElement emaidorPhonenumberTextBox;
	
	@FindBy(how=How.XPATH,using="//input[@id='pass']")
	public WebElement passwordTextBox;

	@FindBy(how=How.XPATH,using="(//input[@name='login'])[1]")
	public WebElement LogINButton;
	
	//methods
	  public LoginToFacebookPage emailIdbox(String emaild){
		  
		  type(emaidorPhonenumberTextBox,emaild,"emailid");
		  return this;
		  
	  }
	  
	  public LoginToFacebookPage passwordText(String pass){
		  
		  type(passwordTextBox,pass,"password");
		  return this;
	  }
	  
	  public LoginToFacebookPage LogintoFacebook(){
		  
		 click(LogINButton,"loginButton"); 
		 return this;
	  }

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(emaidorPhonenumberTextBox);
	}
}

