package selenium.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import common.ExcelReader;
import framework.Base;

@Listeners(selenium.test.TestNGListener.class)
public class PageTitleTest extends Base {
	@Test(groups = "SMOKE", dataProvider = "PageTitlesExcelData")
	public void PageTitleTest(HashMap<String, String> testData) throws InterruptedException, IOException {

		driver.manage().window().maximize();

		/* navigating to given url - google.com */
		driver.get(testData.get("URL"));

		/* extracting, captuing the actual title of the browser */
		String actualBrowser = driver.getTitle();

		/* printing the actual title on the browser */
		Assert.assertEquals(actualBrowser, testData.get("Title"), "Page title validation");

	}

	// @Test(groups = "SMOKE", dataProvider = "GoogleExcelData")
	public void GoogleTest(HashMap<String, String> testData) throws InterruptedException, IOException {

		driver.manage().window().maximize();

		/* navigating to given url - google.com */
		driver.get(testData.get("URL"));

		/* extracting, captuing the actual title of the browser */
		String actualBrowser = driver.getTitle();

		/* printing the actual title on the browser */
		Assert.assertEquals(actualBrowser, testData.get("Title"), "Page title validation");

	}

	@DataProvider(name = "PageTitles")
	public Object[][] dpTitleValidation() {
		Object object[][] = new Object[][] { { "https://www.google.com/", "Google" },
				{ "https://www.facebook.com/", "Facebook – log in or sign up" },
				{ "https://www.testng.com/", "TestNG" } };
		return object;
	}

	@DataProvider(name = "PageTitlesExcelData")
	public Object[] dpTitleValidationExcelMaps() {
		String tdFileName = "D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\testdata\\GoogleTest_Data.xls";
		String tdSheetName = "PageTitleTest";
		Object[] object = ExcelReader.getExcelData(tdFileName, tdSheetName);
		return object;
	}

	@DataProvider(name = "GoogleExcelData")
	public Object[] dpGoogleSearchExcelMaps() {
		String tdFileName = "D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\testdata\\GoogleTest_Data.xls";
		String tdSheetName = "GoogleTest";
		Object[] object = ExcelReader.getExcelData(tdFileName, tdSheetName);
		return object;
	}

}
