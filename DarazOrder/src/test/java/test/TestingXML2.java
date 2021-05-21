package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.GoogleSearchPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingXML2 {
	
	private static WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
	}
	
	@Test
	public void googleSearchTest2() throws InterruptedException{
	    
	    GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
	    
	    driver.get("https://www.ebay.com/");
	    Thread.sleep(1000);
	    
	    searchPageObj.setTextInSearchBox("mobile");
	    Thread.sleep(1000);

	    searchPageObj.clickSearchButton();
	    Thread.sleep(1000);
	    
	}
	
	@Test
	public void googleSearchTest3() throws InterruptedException{
	    
	    GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
	    
	    driver.get("https://www.ebay.com/");
	    Thread.sleep(1000);
	    
	    searchPageObj.setTextInSearchBox("mobile");
	    Thread.sleep(1000);

	    searchPageObj.clickSearchButton();
	    Thread.sleep(1000);
	    
	}
	
	@AfterTest
	public void tearDownTest() {
		
		driver.close();
		
	}
	
}
