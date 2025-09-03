package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		try {
			close.click();
		} catch(NoSuchElementException e) {
			System.out.println("No close varify email element is found");
		}
	}

}
