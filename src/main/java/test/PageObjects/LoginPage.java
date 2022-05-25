package test.PageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import test.utilities.DriverManager;

public class LoginPage extends BasePage{
	
	
	@FindBy(how=How.XPATH,using="//input[@id='login_email']")
    public WebElement usernameTextBox;
	
	@FindBy(how=How.XPATH,using="//input[@id='login_password']")
	public WebElement passwordTextBox;
	
	@FindBy(how=How.CSS,using="button[onclick='Login();']")
	public WebElement signINButton;
	
	@FindBy(how=How.XPATH,using="(//button[normalize-space()='Sign in with Facebook'])[1]")
	public WebElement signIntoFacebookButton;
	
	
	public LoginPage usernameText(String username){
		//usernameTextBox.sendKeys(username);
		type(usernameTextBox,username,"username");
		return this;
		
	}
	
	public LoginPage passwordText(String password){
		
		//passwordTextBox.sendKeys(password);
		type(passwordTextBox,password,"password");
		return this;
	}
	
	public LoginPage loginButton(){
		//signINButton.click();
		click(signINButton,"signinButton");
		return this;
	}
	
	public LoginToFacebookPage logintofacebookButton(){
		
		click(signIntoFacebookButton,"signintofacebook");
		String parent =DriverManager.getDriver().getWindowHandle();
		System.out.println("The Parent window is" +parent);
		
		Set<String>s=DriverManager.getDriver().getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext()){
        String child_window=I1.next();
        
       if(!parent.equals(child_window))
		{
    	   DriverManager.getDriver().switchTo().window(child_window);
		System.out.println(DriverManager.getDriver().switchTo().window(child_window).getTitle());
		
		}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (LoginToFacebookPage) openPage(LoginToFacebookPage.class);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(usernameTextBox);
	}
}

