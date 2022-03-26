package selenium.test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import framework.Base;

public class TestNGDataProviders extends Base {

	@Test(dataProvider = "DP_UrlTitle", description = "Facebook Title check")
	public void FacebookTest(String url, String title) throws InterruptedException {

		/* navigating to given url - google.com */
		driver.get(url);

		/* extracting, captuing the actual title of the browser */
		String actualBrowser = driver.getTitle();

		/* printing the actual title on the browser */
		System.out.println("The google page actual title is: " + actualBrowser);

		Assert.assertEquals(actualBrowser, title, "Verify Page Title ");
	}

	@Test(dataProvider = "DP_UrlTitle2", description = "Facebook Title check")
	public void FacebookTest(HashMap<String, String> testData) throws InterruptedException {

		/* navigating to given url - google.com */
		driver.get(testData.get("url"));

		/* extracting, captuing the actual title of the browser */
		String actualBrowser = driver.getTitle();

		/* printing the actual title on the browser */
		System.out.println("The google page actual title is: " + actualBrowser);

		Assert.assertEquals(actualBrowser, testData.get("title"), "Verify Page Title ");
	}

	@DataProvider(name = "DP_UrlTitle")
	public Object[][] dpUrlTitle() {
		return new Object[][] { { "https://www.google.com/", "Google" }, { "https://www.facebook.com/", "Facebook" } };
	}

	@DataProvider(name = "DP_UrlTitle2")
	public Object[] dpUrlTitle2() {
		Object object[] = new Object[2];
		HashMap map = new HashMap<String, String>();
		map.put("url", "https://www.google.com");
		map.put("title", "Google");
		object[0] = map;
		
		map = new HashMap<String, String>();
		map.put("url", "https://www.facebook.com");
		map.put("title", "Facebook");
		object[1] = map;

		return object;
	}
}
