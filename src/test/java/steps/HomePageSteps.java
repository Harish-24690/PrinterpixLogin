package steps;

import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import test.Listeners.CustomListeners;
import test.PageObjects.HomePage;
import test.PageObjects.LoginPage;
import test.utilities.TestContextSetup;



public class HomePageSteps extends BaseSteps {
	
	protected Scenario scenario;
	static String scenarioName;
	static int x = 0;
	
	public HomePage home;
	public TestContextSetup testContextSetup;
	
	@Before
	public  void before(Scenario scenario) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		x = x + 1;
		this.scenario = scenario;
		scenarioName = scenario.getName();
		CustomListeners.startTest("Scenario Name   " + scenario.getName());
		CustomListeners.getTest().log(Status.INFO, "Scenario started : - " + scenario.getName());
		setUpFrameWork();
	}
	
	@After()
	public void after(Scenario scenario) {

		if (scenario.isFailed()) {

			//CustomListeners.logFail("Scenario Failed");
			CustomListeners.addScreenShotsOnFailure();
		} else {

			//CustomListeners.scenarioPass();
		}

		

		tearDown();

	}
	
	public HomePageSteps(TestContextSetup testContextSetup){
		
		this.testContextSetup = testContextSetup;
	}
	
	
	@Given("^User  launch the  browser \"([^\"]*)\"$")
	public void user_launch_the_browser(String browser) {
		openBrowser(browser);
		
	    
	}

	@When("^User navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String URL) {
		home= new HomePage().open(URL);
	   
	}

	@And("User clicks on Account button")
	public void user_clicks_on_account_button() {
		
		LoginPage lpage=home.accountsTab();
		testContextSetup.page=lpage;
	    
	}

	


}
