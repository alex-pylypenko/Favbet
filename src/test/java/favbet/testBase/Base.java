package favbet.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Base {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@Parameters({"Browser", "OS"})
	@BeforeMethod(alwaysRun = true)
	public void setUp(String browserName, String osName) {
		ChromeOptions optChrome = new ChromeOptions();
		optChrome.addArguments("--incognito");
		
		driver.set(new ChromeDriver(optChrome));
		getDriver().manage().window().maximize();
		getDriver().get("https://www.favbet.ua/en/");
		
	}
}
