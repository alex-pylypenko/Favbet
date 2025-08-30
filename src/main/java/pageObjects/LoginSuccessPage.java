package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSuccessPage extends BaseComponents {
	
	public LoginSuccessPage(WebDriver driver) {
		super(driver);
	}

	// locators
	
	@FindBy(xpath = "//a/span[text()='Deposit']")
	WebElement deposit;
	
	@FindBy(css = "[data-role = 'icon-notification-close']")
	WebElement close;
	
	// methods
	
	public String verifiedLogin() {
	    try {
	        return deposit.getText();
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	public void closeVerify() {
		close.click();
	}

}
