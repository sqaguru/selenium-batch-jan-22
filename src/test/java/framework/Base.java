package framework;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import common.SeleniumUtils;

public class Base {
	protected WebDriver driver;
	String browser = "edge";

	@BeforeGroups(groups = "SMOKE")
	public void beforeGroups() {
		System.out.println("######################## Group Started ########################");
	}

	@AfterGroups(groups = "SMOKE")
	public void afterGroups() {
		System.out.println("######################## Group Completed ########################");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("######################## Suite Started ########################");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("######################## Suite Completed ########################");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("==================== Test Execution Started ====================");
	}

	@BeforeClass(groups = "SMOKE")
	public void launchBrowser() {

		WebDriver originalDriver;

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\drivers\\chromedriver.exe");
			originalDriver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\drivers\\msedgedriver.exe");
			originalDriver = new EdgeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver",
					"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\drivers\\geckodriver.exe");
			originalDriver = new FirefoxDriver();
		}

		TestListener listeners = new TestListener();

		driver = new EventFiringDecorator(listeners).decorate(originalDriver);

	}

	@BeforeMethod(groups = "SMOKE")
	public void launchAndNavigateToURL() {

		SeleniumUtils.screenShotFolderForTest = (new Date()).toString().replace(":", "_").replace(" ", "_");

		System.out.println("SeleniumUtils.screenShotFolderForTest : " + SeleniumUtils.screenShotFolderForTest);

		driver.manage().window().maximize();

		driver.get("https://www.orangehrm.com/");
	}

	@AfterMethod(groups = "SMOKE")
	public void afterMethod() {
		System.out.println("====================  Test method execution completed    ====================");
	}

	@AfterClass(groups = "SMOKE")
	public void quitBrowser() {
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("==================== Test Execution Completed ====================");
	}

}
