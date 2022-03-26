package selenium.test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.ExcelReader;
import framework.Base;
import pages.ContactSalesPage;
import pages.HomePage;

public class OrangeHRMTest extends Base {

	@Test(dataProvider = "OrangeHRMTestData")
	public void locatorTypeTest(HashMap<String, String> testData) throws InterruptedException {

		HomePage homePage = new HomePage(driver);

		homePage.navigateToCotactSalesPage();

		ContactSalesPage contactSalesPage = new ContactSalesPage(driver);

		contactSalesPage.enterContactSalesDetails(testData);

	}

	@DataProvider(name = "OrangeHRMTestData")
	public Object[] dpTitleValidationExcelMaps() {
		String tdFileName = "D:\\sqa-guru\\bat-2022-jan-6-7pm-ist-mvn\\orange-hrm-automation\\src\\test\\resources\\testdata\\OrangeHRMTestData.xls";
		String tdSheetName = "OrangeHRMTestData";
		Object[] object = ExcelReader.getExcelData(tdFileName, tdSheetName);
		return object;
	}

}
