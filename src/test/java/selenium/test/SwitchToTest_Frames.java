package selenium.test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.TestListener2;

public class SwitchToTest_Frames {

	public static final int STANDARD_WAIT_IN_SEC = 60;
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		/* setting up browser path */
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\drivers\\chromedriver.exe");

		/* creating browser object */
		WebDriver driverOriginal = new ChromeDriver();// ChromeDriver ==> Class, WebDriver ==> Interface

		TestListener2 listeners = new TestListener2();

		WebDriver driver = new EventFiringDecorator(listeners).decorate(driverOriginal);

		driver.manage().window().maximize();

		Duration duration = Duration.ofSeconds(STANDARD_WAIT_IN_SEC);
		driver.manage().timeouts().implicitlyWait(duration);// implicit wait, applicable across the project

		driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");

		driver.findElement(By.xpath("//input[@value='Click for Popup']")).isDisplayed();

		driver.findElement(By.xpath("//input[@value='Click for Popup']")).click();

		WebDriverWait wait = new WebDriverWait(driver, duration);

		wait.until(ExpectedConditions.alertIsPresent());// implicit for an alert to be present

		Alert myAlert = driver.switchTo().alert();

		String alertMessage = myAlert.getText();

		System.out.println("alertMessage: " + alertMessage);

		myAlert.accept();
	}

}
