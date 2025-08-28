package favbet.testCases;

import org.testng.annotations.Test;

import favbet.testBase.Base;
import pageObjects.HomePage;

public class LoginTest extends Base {
	
	@Test
	public void homeLogin() {
		HomePage login = new HomePage(driver.get());
		
		login.clickLogin();
	}

}
