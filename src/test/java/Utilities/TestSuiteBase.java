package Utilities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import PageObjects.*;

public class TestSuiteBase {

	public WebDriver driver;
	protected PageObjects.HomePage homepage;
	protected PageObjects.SearchResultPage searchresultpage;
	
	@Parameters({ "url" })
	@BeforeClass(alwaysRun = true)
	public void setup(String url) throws MalformedURLException {
		driver = getDriverInstance(url);
		homepage = PageFactory.initElements(driver, HomePage.class);
		searchresultpage = PageFactory.initElements(driver, SearchResultPage.class);
	}

	public static WebDriver getDriverInstance(String url)
			throws MalformedURLException {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();


		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Open the Application
		driver.get(url);
		return driver;
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}