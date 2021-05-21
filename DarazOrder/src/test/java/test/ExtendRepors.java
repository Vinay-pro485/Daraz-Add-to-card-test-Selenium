package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pages.GoogleSearchPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendRepors {

	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		ExtentTest test1 = extent.createTest("Daraz Search Test", "test to validate search box test1");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		test1.log(Status.INFO, "Starting test case");
	
		driver.get("https://www.ebay.com");
		Thread.sleep(2000);
		test1.pass("Navigate to Ebay.com");

		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
		searchPageObj.setTextInSearchBox("mobile");
		Thread.sleep(1000);
		test1.pass("Enter text in search box");

		searchPageObj.clickSearchButton();
		Thread.sleep(1000);
		test1.pass("press keyboard enter key");

		driver.close();
		test1.pass("closed the browser");
		
		test1.pass("test completed");

		extent.flush();
	}
}
