package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseComponents {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	
	@FindBy(xpath = "//input[@id = 'email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id = 'email']")
	WebElement pass;
	
	// methods
	
	public void setEmail(String myEmail) {
		email.sendKeys(myEmail);
	}

}
