package Tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Utilities.TestSuiteBase;

public class SearchTest extends TestSuiteBase {

	private String OsBrowser = "";

	@Test(priority = 1)
	public void blankresultPage() throws InterruptedException {
		OsBrowser = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		homepage.clickwikiSearchButton();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Search - Wikipedia");
	}

	@Test(priority = 2)
	public void firstSearchTest() throws InterruptedException {
		OsBrowser = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		searchresultpage.fillUpSearchBox("albor");
		searchresultpage.clickSearchButton();
		Thread.sleep(5000);
		Assert.assertEquals(searchresultpage.firstHeading(), "Albor");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {

			try {
				String error = "Reason of Failure :\n" + result.getThrowable();
				System.out.println(error);

			} catch (Exception e) {
				String exep = e.toString();
				System.out.println("i dont know");
			}
		}
		
		if (result.getStatus() == ITestResult.SUCCESS) {

			try {
				String success = "Test ran Successfully :\n" + result.getName();
				System.out.println(success);

			} catch (Exception e) {
				String exep = e.toString();
				System.out.println("i dont know");
			}
		}

	}
}