package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportsPage extends BaseComponents {
	
	public SportsPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	
	@FindBy(xpath = "//div[@data-role='categories-list-1']/div[1]/a")
	WebElement firstChamp;
	
	@FindBy(xpath = "//div[@data-role='categories-list-1']/div[1]/div/a")
	WebElement firstLeague;
	
	@FindBy(css = "[data-role = 'market-outcome']")
	WebElement firstOdds;
	
	@FindBy(css = ".BuJhQ.I9Moz.R9DyM.ZqR98.yR5Xu")
	WebElement firstLeagueExpand;
	
	@FindBy(css = ".BuJhQ.aDAG4.gSB0y.XzY68.L3VU5.NXGs9")
	WebElement firstOddsExpand;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Enter Stake')]")
	WebElement enterStake;
	
	@FindBy(xpath = "//button[@data-role='betslip-button-additional-info']")
	WebElement depositBetslipBtn;
	
	@FindBy(xpath = "//button[@data-role='betslip-button-additional-info']//span[@data-role='betslip-possible-win-numbers']//span//span[1]")
	WebElement possibleWinnings;
	
	@FindBy(xpath = "//div[@data-role = 'market-outcome']//div//span")
	WebElement firstOddsValue;
	
	@FindBy(xpath = "//a[@href='/en/results/']")
	WebElement resultsPage;
	
	@FindBy(xpath = ("//input[@placeholder='Search...']"))
	WebElement search;
	
	@FindBy(xpath = "//div[@data-role='search-results-container']//div[2]//span")
	WebElement searchedEvent;
	
	
	// methods
	
	public void selectAnyOdd() {
		waitForElementClickable(firstChamp);
		firstChamp.click();
		waitForElementClickable(firstLeague);
		firstLeague.click();
		
		try {
		    waitForElementClickable(firstOdds);
		    firstOdds = driver.findElement(By.cssSelector("[data-role='market-outcome']")); // firstOdds is stale
		    firstOdds.click();
		} catch (Exception e) {
		    waitForElementClickable(firstLeagueExpand);
		    firstLeagueExpand.click();
		    waitForElementClickable(firstOddsExpand);
		    firstOddsExpand.click();
		}

	}
	
	public void setStake(double stake) {
	    enterStake.sendKeys(String.valueOf(stake));
	}
	
	public void clickDepBetslipBtn() {
		depositBetslipBtn.click();
	}
	
	public boolean checkPossibleWinnings() {
		
		Double possibleWinningsNum = Double.parseDouble(possibleWinnings.getText());	
		Double firstOddsValueNum = Double.parseDouble(firstOddsValue.getText());	
		Double actualStakeNum = Double.parseDouble(enterStake.getAttribute("value"));
		
		double expected = firstOddsValueNum * actualStakeNum;
        double epsilon = 0.01;

        return Math.abs(possibleWinningsNum - expected) < epsilon;
		
	}
	
	public void navigateToResults() {
		resultsPage.click();
	}
	
	public void setSearch(String searchedWord) {
		search.sendKeys(searchedWord);
	}
	
	
	String firstPartic;
	String secondPartic;
	public void saveParticipantsNames() {
		String[] participants = searchedEvent.getText().split("-", 2);
		firstPartic = participants[0].trim();
		secondPartic = participants[1].trim();
	}
	
	
	public void clickSearchedEvent() {
		waitForElementClickable(searchedEvent);
		searchedEvent.click();
	}

	public boolean checkSearchedResult() {
		boolean firstDisplayed = driver.findElement(By.xpath("//*[contains(text(),'" + firstPartic + "')]")).isDisplayed();
		boolean secondDisplayed = driver.findElement(By.xpath("//*[contains(text(),'" + secondPartic + "')]")).isDisplayed();
		
		if(firstDisplayed && secondDisplayed) {
			return true;
		} else {
			return false;
		}
		
	}
}
