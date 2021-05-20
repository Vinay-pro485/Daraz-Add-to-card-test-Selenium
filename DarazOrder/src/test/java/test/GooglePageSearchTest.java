package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GoogleSearchPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GooglePageSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		googleSearchTest();
	}
	
	public static void googleSearchTest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    
	    GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
	    
	    driver.get("https://www.ebay.com");
	    Thread.sleep(2000);
	    
	    searchPageObj.setTextInSearchBox("mobile");
	    Thread.sleep(2000);

	    searchPageObj.clickSearchButton();
	    Thread.sleep(2000);

	    driver.close();
	    
	}
}
