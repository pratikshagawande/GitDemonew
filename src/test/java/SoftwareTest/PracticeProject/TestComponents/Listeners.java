package SoftwareTest.PracticeProject.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SoftwareTest.resourses.ExtentReportDemo;

public class Listeners extends BaseTest implements ITestListener {
	String filepath = null;
	ExtentTest test;
	ExtentReports extent = ExtentReportDemo.config();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
	test.log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			
			e.printStackTrace();
		}
		try {
			String filepath=getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
	extent.flush();
	}
}
