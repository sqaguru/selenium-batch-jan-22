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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsTest {
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {

		/* setting up browser path */
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\drivers\\chromedriver.exe");

		/* creating browser object */
		WebDriver driver = new ChromeDriver();// ChromeDriver ==> Class, WebDriver ==> Interface

		driver.manage().window().maximize();

		driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // compile time exceptions - something happens which is not desired
		Duration duration = Duration.ofSeconds(SwitchToTest_Frames.STANDARD_WAIT_IN_SEC);
		driver.manage().timeouts().implicitlyWait(duration);// implicit wait, applicable across the project

		Actions action = new Actions(driver);

		/*
		 * WebElement source = driver.findElement(By.id("drag1"));
		 * 
		 * WebElement target = driver.findElement(By.xpath("//div[@id='div1']"));
		 * 
		 * action.dragAndDrop(source, target).build().perform();
		 */

		Thread.sleep(2000);

		action.moveToElement(driver.findElement(By.xpath("//b[text()='STM']"))).build().perform();

		Thread.sleep(2000);

	}

}
