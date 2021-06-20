package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GoogleSearchPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DarazSearchTest {
	
	private static WebDriver driver = null;
		
	public static void main(String[] args) throws InterruptedException {
		googleSearchTest();
		tearDownTest();
		
	}
	
	public static void googleSearchTest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    
	    GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
	    
	    driver.get("https://www.ebay.com");
	    Thread.sleep(1000);
	    
	    searchPageObj.setTextInSearchBox("mobile");
	    Thread.sleep(1000);

	    searchPageObj.clickSearchButton();
	    Thread.sleep(1000);
	    
	}
	
	public static void tearDownTest() {
			driver.close();
		
	}
	
}
