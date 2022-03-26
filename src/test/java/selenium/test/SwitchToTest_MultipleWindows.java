package selenium.test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToTest_MultipleWindows {
	static WebDriverWait wait;

	public static void main(String[] args) {

		/* setting up browser path */
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\drivers\\chromedriver.exe");

		/* creating browser object */
		WebDriver driver = new ChromeDriver();// ChromeDriver ==> Class, WebDriver ==> Interface

		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // compile time exceptions - something happens which is not desired
		Duration duration = Duration.ofSeconds(SwitchToTest_Frames.STANDARD_WAIT_IN_SEC);
		driver.manage().timeouts().implicitlyWait(duration);// implicit wait, applicable across the project

		driver.findElement(By.linkText("Facebook Pay")).isDisplayed();// link facebook pay is present or not

		driver.findElement(By.linkText("Facebook Pay")).click();// click on 'Facebook Pay' link

		wait = new WebDriverWait(driver, duration);

		waitForTotalNumberOfWindowsToBe(2);// wait until 2 windows are present

		String currentWindowId = driver.getWindowHandle();

		reportMessage("currentWindowId: " + currentWindowId);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String windowhandle : windowHandles) {
			if (!windowhandle.equals(currentWindowId)) {
				driver.switchTo().window(windowhandle);

				reportMessage("window title: " + driver.getTitle());
				driver.findElement(By.linkText("Home")).isDisplayed();

				driver.close();// closes the run time active window

				waitForTotalNumberOfWindowsToBe(1);

			}
		}

		driver.switchTo().window(currentWindowId);

		try {
			wait.until(ExpectedConditions.titleIs("Facebook – log in or sign up"));// run time/dynamic exception
		} catch (TimeoutException timeoutException) {
			timeoutException.printStackTrace();
			reportMessage("Timeout Exception occured");
		} finally {// execute finally block irrespective of the exception occurance
			reportMessage("exception block completed");
		}

		reportMessage("window title: " + driver.getTitle());

		driver.quit();// if 2 or more windows exists opened by selenium will close them all

	}

	private static void reportMessage(String string) {
		System.out.println("Hey, there is a message for you - "+string);
	}

	private static void waitForTotalNumberOfWindowsToBe(int totalWindows) {

		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(totalWindows));
		} catch (TimeoutException timeoutException) {
			timeoutException.printStackTrace();
			reportMessage(timeoutException.getMessage());
		} finally {// execute finally block irrespective of the exception occurance
			reportMessage("'TimeoutException' exception block completed");
		}

	}

}
