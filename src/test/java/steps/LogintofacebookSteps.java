package steps;

import java.util.Iterator;
import java.util.Set;

import io.cucumber.java.en.And;
import test.utilities.DriverManager;
import test.utilities.TestContextSetup;

public class LogintofacebookSteps extends BaseSteps {
	
	public  TestContextSetup testContextSetup;
	
	public LogintofacebookSteps(TestContextSetup testContextSetup){
		
		this.testContextSetup = testContextSetup;
	}
	
	
	@And("^User enters the emailaddress \"([^\"]*)\"$")
	public void user_enters_the_emailaddress(String emailaddress) {
	
		testContextSetup.fpage.emailIdbox(emailaddress);
	}
		
	@And("^User enters the password \"([^\"]*)\"$")
	public void user_enters_the_password(String password) {
		
		testContextSetup.fpage.passwordText(password);
	    
	}
	@And("User clicks on Login")
	public void user_clicks_on_login() {
		
		testContextSetup.fpage.LogintoFacebook();
	    
	}

}
