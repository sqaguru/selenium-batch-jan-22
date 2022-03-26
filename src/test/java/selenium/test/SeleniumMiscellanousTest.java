package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMiscellanousTest {

	public static void main(String[] args) throws InterruptedException {

		/* setting up browser path */
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\drivers\\chromedriver.exe");

		/* creating browser object */
		WebDriver driver = new ChromeDriver();// ChromeDriver ==> Class, WebDriver ==> Interface

		driver.manage().window().maximize();

		driver.get("https://www.orangehrm.com/");

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

		WebElement myElement = driver.findElement(By.xpath("//div[5]/div[3]/div[3]/div[1]/div[2]/div/div/a/button"));

		javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", myElement);

		System.out.println("scrolledIntoView(false)");
		Thread.sleep(3000);

	}

}
