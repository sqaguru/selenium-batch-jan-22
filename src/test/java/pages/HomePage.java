package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By btnContactSales = By.xpath("//*[@id=\"header-navbar\"]/ul[3]/li[1]/a");

	private By btnBookADemo = By.xpath("//*[@id=\"header-navbar\"]/ul[3]/li[2]/a");

	public void clickButtonContactSales() {

		driver.findElement(btnContactSales).isDisplayed();

		driver.findElement(btnContactSales).click();

	}

	public void clickButtonBookADemo() {
		driver.findElement(btnBookADemo).isDisplayed();

		driver.findElement(btnBookADemo).click();
	}

	public void navigateToCotactSalesPage() {
		
		clickButtonContactSales();
	}

}
