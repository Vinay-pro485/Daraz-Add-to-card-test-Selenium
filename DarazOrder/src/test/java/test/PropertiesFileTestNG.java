package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesFileTestNG {

	//creating driver object
	private static WebDriver driver = null;

	//setting expected title from the ebay.com/Daraz.lk
	static String expectedTitleebay ="Electronics, Cars, Fashion, Collectibles & More | eBay";
	static String expectedTitledaraz ="Online Shopping Sri Lanka: Clothes, Electronics & Phones | Daraz.lk";

	//create the htmlReporter object 
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1;
	
	public static String browserName = null;
	
	@BeforeSuite
	public void setup() {
		
		PropertiesFile.getProperties();		

		if(browserName.equalsIgnoreCase("chrome")) {
			//initializing and starting the chrome browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
				
		}else if(browserName.equalsIgnoreCase("firefox")) {
			//initializing and starting the firefox browser
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}		

		htmlReporter = new ExtentSparkReporter("extentReport.html");
		//create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	
	}

	@Test  
	public void test1() throws InterruptedException {
			
		//creates a toggle for the given test, add all log events under it
		test1 = extent.createTest("ebay Search Test", "test to validate search box ");

		test1.log(Status.INFO, "Starting test case");
		
		if (browserName.equals("firefox")) {
			System.out.println("Starting test on Firefox");
			test1.pass("Starting test on Firefox");
		}else if(browserName.equals("chrome")) {
			System.out.println("Starting test on chrome");
			test1.pass("Starting test on chrome");
		}
		
		//maximize the window 
		driver.manage().window().maximize();
		test1.pass("maximize has done");

		//Navigate to Ebay.com
		driver.get("https://www.ebay.com");
		Thread.sleep(1000);
		test1.pass("Navigate to Ebay.com");

		//compare whether the title id matching
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitleebay);
		test1.pass("title is correct");

		//enter in the TextBox
		driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Mobile");
		test1.pass("Entered text in the text box");
		Thread.sleep(1000);
		//hit enter
		driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).sendKeys(Keys.RETURN);	
		test1.pass("Press keybopard enter key");
		Thread.sleep(1000);
	
	}
	
	@AfterSuite
	public void tearDown() {

		driver.quit();
		test1.pass("closed the browser");

		test1.info("test completed");	
		
		//write results into the file
		extent.flush();

		PropertiesFile.setProperties();
	}
}
