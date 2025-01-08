package Selenium.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Selenium.resources.ExtentReporterNG;
import Selenium.TestComponents.BaseTest;


public class Listners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	public  WebDriver driver;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
    public void onTestStart(ITestResult result) {
        // Code to execute when a test starts
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); // unique test id errorValidationTest --> test
		
		System.out.println( " Starting test :" +result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
        System.out.println("Test Passed: "+ result.getMethod().getMethodName());
        
        try {
    		
			 driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			 
			 System.out.println(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace(); 
		}
   	
   	//Screenshot,attach to report
   	String FilePath = null;
   	try {
   		
			 FilePath = getScreenshot(result.getMethod().getMethodName(),driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	extentTest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());

    	
    }

    @Override
    public void onTestFailure(ITestResult result) {
         System.out.println("Test failed: "+ result.getMethod().getMethodName());
    	extentTest.get().fail(result.getThrowable());
    	
    	try {
    		
			 driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			 
			 System.out.println(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("falls in exception: ");
			e.printStackTrace(); 
		}
    	
    	//Screenshot,attach to report
    	String FilePath = null;
    	try {
    		
			 FilePath = getScreenshot(result.getMethod().getMethodName(),driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	extentTest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());
    	
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to execute when a test is skipped
    	System.out.println("Test skipped: "+ result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code to execute when a test fails but is within the success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to execute before any test in this context starts
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code to execute after all tests in this context have run
    	 extent.flush();
    }
}
