package selenium.test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import common.SeleniumUtils;

public class ContactSalesTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		SeleniumUtils.screenShotFolderForTest = (new Date()).toString().replace(":", "_").replace(" ", "_");

		/* setting up browser path */
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\drivers\\chromedriver.exe");

		/* creating browser object */
		driver = new ChromeDriver();// ChromeDriver ==> Class, WebDriver ==> Interface

		driver.manage().window().maximize();

		/* navigating to given url - google.com */
		driver.get("https://www.orangehrm.com/");

		/* extracting, captuing the actual title of the browser */
		String actualBrowser = driver.getTitle();

		/* printing the actual title on the browser */
		System.out.println("The google page actual title is: " + actualBrowser);

		/* verify search bar exist */
		driver.findElement(By.xpath("//*[@id=\"header-navbar\"]/ul[3]/li[2]/a")).click();

		WebElement userFullName = driver.findElement(By.id("Form_submitForm_FullName"));

		userFullName.isDisplayed();

		captureScreenShot("test1", driver);

		userFullName.sendKeys("Sqa user");

		driver.findElement(By.id("Form_submitForm_CompanyName")).sendKeys("Sqaguru");

		captureScreenShot("test2", driver);

		driver.findElement(By.id("Form_submitForm_CompanyName")).sendKeys("SDET");

		Select numberOfEmployees = new Select(driver.findElement(By.id("Form_submitForm_NoOfEmployees")));

		captureScreenShot("test3", driver);

		numberOfEmployees.selectByVisibleText("151 - 200");

		Thread.sleep(1000);

		numberOfEmployees.selectByIndex(5);

		driver.findElement(By.id("Form_submitForm_Contact")).sendKeys("12345678");

		driver.findElement(By.id("Form_submitForm_Email")).sendKeys("guru@sqaguru.co.in");

		driver.findElement(By.id("Form_submitForm_Comment")).sendKeys("Trial check for automation");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-borderAnimation']")).isDisplayed();

		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-borderAnimation']")).click();

		driver.findElement(By.id("Form_submitForm_action_request")).click();

	}

	static void captureScreenShot(String fileName, WebDriver driver) {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			Files.copy(screenshotFile, new File(
					"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\ScreenShots\\"
							+ fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
