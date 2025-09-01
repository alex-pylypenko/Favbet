package favbet.testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import favbet.testBase.Base;
import pageObjects.HeaderPage;
import pageObjects.ResultsPage;
import pageObjects.SportsPage;

public class ResultsSearchTest extends Base {

	@Test(groups = {"Regression"})
	public void SearchResults() {
		
		HeaderPage header = new HeaderPage(driver.get());
		header.navigateToSports();
		
		SportsPage sports = new SportsPage(driver.get());
		sports.navigateToResults();
		
		ResultsPage results = new ResultsPage(driver.get());
		results.setDate();
		
		do {
			
			if(results.actualMonthDisplay().equalsIgnoreCase(prop.getProperty("resultsDate"))) {
				break;
			}
			
			results.clickPreviousDate();
			
		} while (true);
		
		results.selectDay(prop.getProperty("resultsDay"));
		results.clickOkButton();
		results.setSport();
		results.selectSport(prop.getProperty("sportName"));
		boolean listResult = results.checkListSportName(prop.getProperty("sportName"));
		Assert.assertTrue(listResult);
	}

}
