package test.Listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;




import test.utilities.ExtentManager;
//import test.utilities.MonitoringMail;
//import test.utilities.TestConfig;
//import test.utilities.MonitoringMail;
//import test.utilities.TestConfig;
import test.utilities.TestUtil;




public class CustomListeners  implements ITestListener,ISuiteListener {
	
	
	

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	static String messageBody;
	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir") + "\\reports\\" + fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		/*ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());
		
		
				
		testReport.set(test);
		*/

	}
	
	


	public void onTestSuccess(ITestResult result) {

		//String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Scenario :- " + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);

	}

	public void onTestFailure(ITestResult result) {

		String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see" + "</font>" + "</b >" + "</summary>" 
		+excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		
		
		/*try {

			TestUtil.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName)
							.build());
		} catch (IOException e) {

		}
		
		
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m); 
		
		*/
	}

	

	public void onTestSkipped(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onFinish(ITestContext arg0) {
		if (extent != null) {

			extent.flush();
		}

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ISuite arg0) {
		/*MonitoringMail mail = new MonitoringMail();
		 
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/8PageObjectModelExtended/HTML_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody );
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void logFail(String message) {

		testReport.get().fail(message);
	}
	public static synchronized boolean addScreenShotsOnFailure() {

		try {
			TestUtil.captureScreenshot();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName).build());
		} catch (IOException e) {

		}

		String failureLogg = "SCENARIO FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
		return true;
	}

	public static synchronized boolean addScreenShots() {

		try {
			TestUtil.captureScreenshot();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			testReport.get().info(("<b>" + "<font color=" + "green>" + "Screenshot" + "</font>" + "</b>"),
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotName).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public static void scenarioPass() {

		String passLogg = "SCENARIO PASSED";
		Markup m = MarkupHelper.createLabel(passLogg, ExtentColor.GREEN);
		testReport.get().log(Status.PASS, m);
	
	
	}
	
	public static synchronized ExtentTest startTest(String testName) {
		return startTest(testName, "");
	}

	public static synchronized ExtentTest startTest(String testName, String desc) {
		ExtentTest test = extent.createTest(testName, desc);
		testReport.set(test);
		return test;
	}

	public static synchronized ExtentTest getTest() {

		return testReport.get();
	}
}