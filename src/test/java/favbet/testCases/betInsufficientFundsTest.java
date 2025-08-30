package favbet.testCases;

import org.testng.annotations.Test;

import favbet.testBase.Base;
import pageObjects.HeaderPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LoginSuccessPage;
import pageObjects.SportsPage;

public class betInsufficientFundsTest extends Base {
	
	@Test
	public void betInsufficientFunds() {
		
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
		sports.setStake(100);
		//sports.clickDepBetslipBtn();
	}

}
