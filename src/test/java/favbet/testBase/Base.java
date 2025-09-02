package favbet.testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Base {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public Logger logger = LogManager.getLogger(this.getClass());
	public static Properties prop;
	public FileInputStream fs;
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@Parameters({"Browser", "OS"})
	@BeforeMethod(alwaysRun = true)
	public void setUp(String browserName, String osName) throws IOException {
		
		if(getDriver() == null) {
			
			prop = new Properties();
			fs = new FileInputStream("./src/test/resources/data.properties");
			prop.load(fs);
			
			String testEnv = prop.getProperty("test_env");
			String platformName = osName.equalsIgnoreCase("windows") ? "Windows 11"
					: osName.equalsIgnoreCase("mac") ? "macOS" : osName.equalsIgnoreCase("linux") ? "Linux" : null;

			if (platformName == null) {
				System.out.println("OS is not matching");
				return;
			}

			// Remote or grid
			if (testEnv.equalsIgnoreCase("remote")) {
				MutableCapabilities options;

				switch (browserName.toLowerCase()) {
				case "chrome":
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--incognito");
					chromeOptions.setPlatformName(platformName);
					options = chromeOptions;
					break;

				case "chromeheadless":
					ChromeOptions chromeHeadless = new ChromeOptions();
					chromeHeadless.addArguments("--headless");
					chromeHeadless.setPlatformName(platformName);
					options = chromeHeadless;
					break;

				case "firefox":
					FirefoxOptions firefoxOptions = new FirefoxOptions();
					firefoxOptions.setPlatformName(platformName);
					options = firefoxOptions;
					break;

				case "firefoxheadless":
					FirefoxOptions firefoxHeadless = new FirefoxOptions();
					firefoxHeadless.addArguments("--headless");
					firefoxHeadless.setPlatformName(platformName);
					options = firefoxHeadless;
					break;

				default:
					System.out.println("Invalid browser: " + browserName);
					return;
				}

				driver.set(new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), options));

				// For headless browsers, manually set window size
				if (browserName.toLowerCase().contains("headless")) {
					getDriver().manage().window().setSize(new Dimension(1440, 900));
				}
			}

			// local test env option

			if (testEnv.equalsIgnoreCase("local")) {

				switch (browserName.toLowerCase()) {
				case "chrome":
					ChromeOptions chromeLocal = new ChromeOptions();
					chromeLocal.addArguments("--incognito");
					driver.set(new ChromeDriver(chromeLocal));
					break;

				case "chromeheadless":
					ChromeOptions chromeHeadlessLocal = new ChromeOptions();
					chromeHeadlessLocal.addArguments("--headless");
					driver.set(new ChromeDriver(chromeHeadlessLocal));
					getDriver().manage().window().setSize(new Dimension(1440, 900));
					break;

				case "firefox":
					FirefoxOptions firefoxLocal = new FirefoxOptions();
					driver.set(new FirefoxDriver(firefoxLocal));
					break;

				case "firefoxheadless":
					FirefoxOptions firefoxHeadlessLocal = new FirefoxOptions();
					firefoxHeadlessLocal.addArguments("--headless");
					driver.set(new FirefoxDriver(firefoxHeadlessLocal));
					getDriver().manage().window().setSize(new Dimension(1440, 900));
					break;
				}
			}

			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			getDriver().manage().window().maximize();
			getDriver().get(prop.getProperty("baseUrl"));
			getDriver().manage().deleteAllCookies();
			
		}
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove();
		}
	}
}
