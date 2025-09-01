package favbet.testCases;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import favbet.testBase.Base;
import pageObjects.HeaderPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LoginSuccessPage;
import pageObjects.SportsPage;

public class PossibleWinningsTest extends Base {
	
	@Test(groups = {"Regression"})
	public void pissibleWinningsAmount() {
		
		logger.info("--- Calculation of possible winnings test started ---");
		
		HomePage hm = new HomePage(driver.get());	
		hm.clickLogin();
		
		LoginPage login = new LoginPage(driver.get());
		login.setEmail(prop.getProperty("email"));
		login.setPassword(prop.getProperty("password"));
		login.clickLoginBtn();
		
		LoginSuccessPage logSPage = new LoginSuccessPage(driver.get());
		logSPage.closeVerify();
		
		HeaderPage header = new HeaderPage(driver.get());
		header.navigateToSports();
		
		SportsPage sports = new SportsPage(driver.get());;
		sports.selectAnyOdd();
		
		String stakeValue = prop.getProperty("stake");
		sports.setStake(Double.parseDouble(stakeValue));
		
		boolean result = sports.checkPossibleWinnings();
        Assert.assertTrue(result, "❌ Possible winnings are not calculated correctly!");
		
	}

}
