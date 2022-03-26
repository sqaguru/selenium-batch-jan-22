package selenium.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SwitchToTest_Alerts {

	public static void main(String[] args) throws InterruptedException {

		/* setting up browser path */
		System.setProperty("webdriver.chrome.driver",
				"D:\\sqa-guru\\bat-2022-jan-6-7pm-ist\\bat-jan-2022-java\\bat-jan-22-java\\resources\\drivers\\chromedriver.exe");

		/* creating browser object */
		WebDriver driver = new ChromeDriver();// ChromeDriver ==> Class, WebDriver ==> Interface

		driver.manage().window().maximize();

		driver.get(
				"https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/edge/package-summary.html");

		int totalFrames = driver.findElements(By.tagName("iframe")).size();

		System.out.println("totalFrames: " + totalFrames);

		driver.switchTo().frame("packageListFrame");// switching to first frame

		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));

		for (WebElement element : totalLinks) {
			System.out.println("element.text: " + element.getText());
		}

		driver.findElement(By.linkText("org.openqa.selenium.cli")).click();

		driver.switchTo().defaultContent();// get out of first frame and then only can get into other frame

		driver.switchTo().frame("packageFrame");// switching to second frame

		driver.findElement(By.xpath("//span[text()='CliCommand']/parent::a")).isDisplayed();
		
		System.out.println("CliCommand element displayed");
		
		driver.switchTo().defaultContent();
		
		

	}

}
