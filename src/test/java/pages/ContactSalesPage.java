package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactSalesPage {
	private WebDriver driver;

	public ContactSalesPage(WebDriver driver) {
		this.driver = driver;
	}

	By txtFullName = By.id("Form_submitForm_FullName");

	By txtCompanyName = By.id("Form_submitForm_CompanyName");

	By txtJobTitle = By.id("Form_submitForm_FullName");

	By txtPhoneNumber = By.id("Form_submitForm_FullName");

	By lstNoOfEmployees = By.id("Form_submitForm_NoOfEmployees");

	By txtEmail = By.id("Form_submitForm_FullName");

	By txtYourName = By.id("Form_submitForm_Comment");

	By btnSubmit = By.id("Form_submitForm_action_request");

	public void clickAndEnterFullName(String fullName) {

		WebElement weFullName = driver.findElement(txtFullName);

		weFullName.click();

		weFullName.sendKeys(fullName);
	}

	public void clickAndEnterCompanyName(String companyName) {

		WebElement weCompanyName = driver.findElement(txtCompanyName);

		weCompanyName.click();

		weCompanyName.sendKeys(companyName);
	}

	public void selectNumberOfEmployeesByVisibleText(String text) {
		Select selectNumberOfEmployees = new Select(driver.findElement(lstNoOfEmployees));

		selectNumberOfEmployees.selectByVisibleText(text);
	}

	public void selectNumberOfEmployeesByIndex(int index) {
		Select selectNumberOfEmployees = new Select(driver.findElement(lstNoOfEmployees));

		selectNumberOfEmployees.selectByIndex(index);
	}

	public void selectNumberOfEmployeesByValue(String value) {
		Select selectNumberOfEmployees = new Select(driver.findElement(lstNoOfEmployees));

		selectNumberOfEmployees.selectByValue(value);
	}

	public void clickButtonSubmit() {
		driver.findElement(btnSubmit).click();
	}

	public void enterContactSalesDetails(HashMap<String, String> testData) {
		
		clickAndEnterFullName(testData.get("FullName"));

		clickAndEnterCompanyName(testData.get("CompanyName"));

		selectNumberOfEmployeesByVisibleText(testData.get("NumberOfEmployees"));

		clickButtonSubmit();
	}
}
