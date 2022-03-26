package common;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

public class SeleniumUtils {

	public static String screenShotFolderForTest = "";

	static void captureScreenShot(String fileName, WebDriver driver) {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			Files.createParentDirs(new File(
					"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\ScreenShots\\"
							+ screenShotFolderForTest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void captureScreenShotOnElement(String fileName, WebElement element) {
		File screenshotFile = element.getScreenshotAs(OutputType.FILE);

		try {
			File testResultDirectory = new File(
					"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\ScreenShots\\"
							+ screenShotFolderForTest);

			testResultDirectory.mkdir();

			Files.copy(screenshotFile, new File(
					"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\ScreenShots\\"
							+ screenShotFolderForTest + "\\" + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void captureScreenShotByLocator(WebDriver driver, String fileName, By by) {
		File screenshotFile = driver.findElement(by).getScreenshotAs(OutputType.FILE);

		try {
			File testResultDirectory = new File(
					"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\ScreenShots\\"
							+ screenShotFolderForTest);

			testResultDirectory.mkdir();

			Files.copy(screenshotFile, new File(
					"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\ScreenShots\\"
							+ screenShotFolderForTest + "\\" + fileName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
