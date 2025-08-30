package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseComponents {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	
	@FindBy(xpath = "//span[contains(text(),'Log in')]")
	WebElement loginBtn;
	
	// action methods
	
	public void clickLogin() {
		waitForElementClickable(loginBtn); // explicit wait for specific elements
		loginBtn.click();
	}
	
	
}
