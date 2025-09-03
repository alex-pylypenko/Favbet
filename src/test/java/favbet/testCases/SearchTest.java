package favbet.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import favbet.testBase.Base;
import pageObjects.SportsPage;

public class SearchTest extends Base {
	
	@Test(groups = {"Regression"})
	public void Search() {
		
		driver.get().navigate().to("https://www.favbet.ua/en/sports/");
		
		SportsPage search = new SportsPage(driver.get());
		search.setSearch(prop.getProperty("searchedEvent"));
		search.saveParticipantsNames();	
		search.clickSearchedEvent();
		boolean searchResult = search.checkSearchedResult();
		Assert.assertTrue(searchResult);
	}

}
