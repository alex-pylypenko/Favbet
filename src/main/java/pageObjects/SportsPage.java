package pageObjects;

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
	// comment
}
