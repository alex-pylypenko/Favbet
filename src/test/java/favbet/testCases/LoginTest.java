package favbet.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import favbet.utilities.DataProviders;
import favbet.testBase.Base;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LoginSuccessPage;

public class LoginTest extends Base {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = { "Regression" })
	public void loginTest(String userName, String password, String result) throws InterruptedException {
		HomePage hm = new HomePage(driver.get());

		hm.clickLogin();

		LoginPage login = new LoginPage(driver.get());
		login.setEmail(userName);
		login.setPassword(password);
		login.clickLoginBtn();

		LoginSuccessPage logSuccess = new LoginSuccessPage(driver.get());
		String actLog = logSuccess.verifiedLogin();

		if (result.equalsIgnoreCase("Invalid") && actLog.equalsIgnoreCase("Deposit")) {
			Assert.assertTrue(false);
		}

		if (result.equalsIgnoreCase("Invalid") && !actLog.equalsIgnoreCase("Deposit")) {
			Assert.assertTrue(true);
		}

		if (result.equalsIgnoreCase("Valid") && actLog.equalsIgnoreCase("Deposit")) {
			Assert.assertTrue(true);
		}

		if (result.equalsIgnoreCase("Valid") && !actLog.equalsIgnoreCase("Deposit")) {
			Assert.assertTrue(false);
		}

	}

}
