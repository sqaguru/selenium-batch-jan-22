package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.SeleniumUtils;
import framework.Base;

public class FirstTest extends Base {
	@Parameters("pageTitle")
	@Test(groups = { "SMOKE", "REGRESSION" }, priority = 2, description = "Google search with Selenium Dev key")
	public void myFirstTest(String pageTitle) throws InterruptedException {
		/* navigating to given url - google.com */
		driver.get("https://www.google.com/");

		/* extracting, captuing the actual title of the browser */
		String actualBrowser = driver.getTitle();

		/* printing the actual title on the browser */
		System.out.println("The google page actual title is: " + actualBrowser);

		if (actualBrowser.equals("Google")) {
			System.out.println("verify google title: Passed: Expected: Google \nActual: " + actualBrowser);
		} else {
			System.out.println("verify google title: Failed: Expected: Google \nActual: " + actualBrowser);
		}

		Assert.assertEquals(actualBrowser, pageTitle, "Verify Google Page Title ");

		/* verify search bar exist */
		driver.findElement(By.name("q")).isDisplayed();
		System.out.println("verified search button on google page exist");

		/* verifying button search is dipslayed */
		driver.findElement(By.name("btnK")).isDisplayed();

		WebElement btnKElement = driver.findElement(By.name("btnK"));

		// File screenshotFile = btnKElement.getScreenshotAs(OutputType.FILE);

		System.out.println("verified I am lucky button exist on google page exist");

		/* verifying button I am lucky is dipslayed */
		driver.findElement(By.name("btnI")).isDisplayed();

		ContactSalesTest.captureScreenShot("test1", driver);

		/* enters selenium dev text on search bar */
		WebElement searchBarWebElement = driver.findElement(By.name("q"));
		searchBarWebElement.sendKeys("Selenium Dev");

		SeleniumUtils.captureScreenShotByLocator(driver, "SearchBar", By.name("q"));

		SeleniumUtils.captureScreenShotOnElement("SearchBar2", searchBarWebElement);

		WebElement searchBarElement = driver.findElement(By.name("q"));
		System.out.println("typed search text Selenium Dev");

		// SeleniumUtils.captureScreenShotOnElement("btnK", searchBarElement);

		/* submits the google search */
		driver.findElement(By.name("q")).submit();

		ContactSalesTest.captureScreenShot("test2", driver);

		/* verify selenium dev link is displayed */
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/div/cite")).isDisplayed();

		System.out.println("verified seleniumdev link appeared");

		driver.navigate().back();

		ContactSalesTest.captureScreenShot("test3", driver);

		Thread.sleep(1000);/* wait script for a second */

		driver.navigate().forward();

	}

	@Test(priority = 3, description = "Google searchwith TestNG key")

	public void myTestNGTest() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		/* navigating to given url - google.com */
		driver.get("https://www.google.com/");

		/* extracting, captuing the actual title of the browser */
		String actualBrowser = driver.getTitle();

		/* printing the actual title on the browser */
		System.out.println("The google page actual title is: " + actualBrowser);

		softAssert.assertEquals(actualBrowser, "Google1", "Verify Google Page Title ");

		/* verify search bar exist */
		driver.findElement(By.name("q")).isDisplayed();
		System.out.println("verified search button on google page exist");

		/* verifying button search is dipslayed */
		driver.findElement(By.name("btnK")).isDisplayed();

		WebElement btnKElement = driver.findElement(By.name("btnK"));

		// File screenshotFile = btnKElement.getScreenshotAs(OutputType.FILE);

		System.out.println("verified I am lucky button exist on google page exist");

		/* verifying button I am lucky is dipslayed */
		driver.findElement(By.name("btnI")).isDisplayed();

		ContactSalesTest.captureScreenShot("test1", driver);

		/* enters selenium dev text on search bar */
		WebElement searchBarWebElement = driver.findElement(By.name("q"));
		searchBarWebElement.sendKeys("TestNG Framework");

		SeleniumUtils.captureScreenShotByLocator(driver, "SearchBar", By.name("q"));

		SeleniumUtils.captureScreenShotOnElement("SearchBar2", searchBarWebElement);

		WebElement searchBarElement = driver.findElement(By.name("q"));
		System.out.println("typed search text Selenium Dev");

		// SeleniumUtils.captureScreenShotOnElement("btnK", searchBarElement);

		/* submits the google search */
		driver.findElement(By.name("q")).submit();

		ContactSalesTest.captureScreenShot("test2", driver);

		/* verify selenium dev link is displayed */
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/div/cite")).isDisplayed();

		System.out.println("verified seleniumdev link appeared");

		driver.navigate().back();

		ContactSalesTest.captureScreenShot("test3", driver);

		Thread.sleep(1000);/* wait script for a second */

		driver.navigate().forward();

		softAssert.assertAll();

	}

	@Test(priority = 1, description = "Facebook Title check")
	public void FacebookTest() throws InterruptedException {

		/* navigating to given url - google.com */
		driver.get("https://www.facebook.com/");

		/* extracting, captuing the actual title of the browser */
		String actualBrowser = driver.getTitle();

		/* printing the actual title on the browser */
		System.out.println("The google page actual title is: " + actualBrowser);

		Assert.assertEquals(actualBrowser, "Facebook – log in or sign up", "Verify Facebook Page Title ");
	}

}
