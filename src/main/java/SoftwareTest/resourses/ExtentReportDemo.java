package SoftwareTest.resourses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	static ExtentReports extent;

	@BeforeTest
	public static ExtentReports config() {
		String path = System.getProperty("user.dir") + "\\Reports\\index.html";
		System.out.println(path);
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pratiksha G");
		return extent;

	}

	//@Test
	public void initializeBrowser() {
		extent.createTest("Browser Initialize");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		driver.close();
		extent.flush();
	}
}
