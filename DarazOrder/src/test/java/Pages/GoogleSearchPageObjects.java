package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver = null;
    By textbox_search = By.name("_nkw");
	By button_search = By.id("gh-btn");

	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
		
	}

	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
		
	}

	
}
