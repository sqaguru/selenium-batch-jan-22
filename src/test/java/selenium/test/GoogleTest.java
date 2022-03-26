package selenium.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import framework.Base;

public class GoogleTest extends Base {

	@Test(groups="SMOKE")
	public void titleTest() throws InterruptedException, IOException {

		driver.manage().window().maximize();

		/* navigating to given url - google.com */
		driver.get("https://www.google.com/");

		/* extracting, captuing the actual title of the browser */
		String actualBrowser = driver.getTitle();

		/* printing the actual title on the browser */
		System.out.println("The google page actual title is: " + actualBrowser);

		driver.findElement(By.className("L3eUgb")).isDisplayed();

		File myFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(myFile, new File(
				"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\ScreenShots\\GoogleTest\\FirstTest.png"));

		System.out.println("tested by classname");

		int totalClassElement = driver.findElements(By.className("L3eUgb")).size();
		System.out.println("totalClassElement: " + totalClassElement);
	}

}
