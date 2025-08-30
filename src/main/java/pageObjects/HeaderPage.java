package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BaseComponents {
	
	public HeaderPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	
	@FindBy(xpath = "//div[@data-role='header-center-menu']//span[normalize-space()='Sports']")
	WebElement sports;
	
	// methods
	
	public void navigateToSports() {
		sports.click();
	}

}
