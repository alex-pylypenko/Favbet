package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends BaseComponents {

	public ResultsPage(WebDriver driver) {
		super(driver);
	}

	// locators

	@FindBy(id = ":r1:")
	WebElement date;

	@FindBy(xpath = "//button[@data-role='calendar-left-arrow']")
	WebElement previousBtn;

	@FindBy(xpath = "//p[@data-role='calendar-selected-month-and-year-title']")
	WebElement actualMonth;

	@FindBy(xpath = "//button[@data-role='calendar-ok-btn']")
	WebElement okBtn;

	@FindBy(xpath = "//div[@data-role='results-filters-sports-select-trigger']")
	WebElement filterSports;

	// methods

	public void setDate() {
		date.click();
	}

	public void clickPreviousDate() {
		previousBtn.click();
	}

	public String actualMonthDisplay() {
		return actualMonth.getText();
	}

	public void selectDay(String dayStr) {
		WebElement day = driver.findElement(By.xpath("//button[normalize-space(text())='" + dayStr + "']"));
		day.click();
	}

	public void clickOkButton() {
		okBtn.click();
	}

	public void setSport() {
		filterSports.click();
	}

	public void selectSport(String sportName) {
		List<WebElement> sportsList = driver.findElements(By.xpath(
				"//div[@data-role='results-filters-sports']//div[@data-role='popover-content-open-results-filters-sports']//div/span"));

		for (WebElement sport : sportsList) {

			if (sport.getText().equalsIgnoreCase(sportName)) {

				sport.click();
				break;
			}
		}
	}

//	// same logic as selectSport() method, but different implementation
//	public void selectSport_2(String sportName) {
//		WebElement sport = driver.findElement(By.xpath(
//				"//div[@data-role='results-filters-sports']//div[@data-role='popover-content-open-results-filters-sports']//div/span[normalize-space(text())='"
//						+ sportName + "']"));
//		sport.click();
//	}

	public boolean checkListSportName(String sportName) {
		List<WebElement> resListSportName = driver.findElements(By.xpath(
				"//div[@data-role='results-event-list-of-results']//div[@data-role='results-event']//div[1]//div[2]//span"));

		for (WebElement sport : resListSportName) {
			if (!sport.getText().equalsIgnoreCase(sportName)) {
				return false;
			}
		}
		return true;
	}

}
