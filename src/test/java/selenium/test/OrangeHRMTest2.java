package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import framework.Base;

public class OrangeHRMTest2 extends Base {

	@Test(dependsOnMethods = "myGoogleTest") // hard dependency
	public void locatorTypeTest() throws InterruptedException {

		driver.get("https://www.orangehrm.com/");

		driver.findElement(By.cssSelector("div[id=lightboxOverlay][class=lightboxOverlay]")).isDisplayed();

		System.out.println("css selector found with multiple attributes & values");

		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/form/a")).isDisplayed();

		String linkText = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/div/form/a/input"))
				.getAttribute("value");

		System.out.println("linkText: " + linkText);

	}

}
