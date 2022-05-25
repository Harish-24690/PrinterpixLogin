package steps;

import java.util.Iterator;
import java.util.Set;


import io.cucumber.java.en.And;
import test.PageObjects.LoginToFacebookPage;
import test.utilities.DriverFactory;
import test.utilities.DriverManager;
import test.utilities.TestContextSetup;

public class LoginPageSteps extends BaseSteps {
	
private TestContextSetup testContextSetup;

public LoginPageSteps(TestContextSetup testContextSetup){
		
		this.testContextSetup = testContextSetup;
	}
	
	
	@And("^User enters the username has \"([^\"]*)\"$")
	public void user_enters_the_username_has(String username) {
		
		testContextSetup.page.usernameText(username);
	    
	}
	@And("^User enters the password has \"([^\"]*)\"$")
	public void user_enters_the_password_has(String password) {
		
		testContextSetup.page.passwordText(password);  
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		testContextSetup.page.loginButton();
	}
	
	@And("User clicks on Login to facebook button")
	public void user_clicks_on_login_to_facebook_button() {
	    
		LoginToFacebookPage fpage = testContextSetup.page.logintofacebookButton();
		testContextSetup.fpage = fpage;
		
	}

}
