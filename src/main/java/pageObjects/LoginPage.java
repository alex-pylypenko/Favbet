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
	
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(css = "[data-role = 'login-page-submit-btn']")
	WebElement loginBtn;
	
	// methods
	
	public void setEmail(String myEmail) {
		email.clear();
		email.sendKeys(myEmail);
	}
	
	public void setPassword(String myPass) {
		pass.clear();
		pass.sendKeys(myPass);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}

}
