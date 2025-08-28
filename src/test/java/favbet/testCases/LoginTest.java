package favbet.testCases;

import org.testng.annotations.Test;

import favbet.utilities.DataProviders;
import favbet.testBase.Base;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends Base {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"Regression"})
	public void loginTest(String userName, String password, String result) {
		HomePage hm = new HomePage(driver.get());
		hm.clickLogin();
		
		LoginPage login = new LoginPage(driver.get());
		login.setEmail(userName);
		
	}

}
