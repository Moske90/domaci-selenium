package d08_02_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Select select;

	public FormPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getNameInput() {
		return this.driver.findElement(By.id("first-name"));
	}

	public WebElement getRadio(String radioValue) {
		return this.driver.findElement(By.xpath("//*[@name='gender'][@value='" + radioValue + "']"));
	}

	public WebElement getDobInput() {
		return this.driver.findElement(By.id("dob"));
	}

	public WebElement getEmailInput() {
		return this.driver.findElement(By.id("email"));
	}

	public WebElement getRoleSelector() {
		return this.driver.findElement(By.id("role"));
	}

	public WebElement getCheckboxInput(String checkboxValue) {
		return this.driver.findElement(By.xpath("//*[@type='checkbox'][@value='" + checkboxValue + "']"));
	}

	public WebElement getCommentInput() {
		return this.driver.findElement(By.id("comment"));
	}

	public WebElement getSubmitButton() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
		return this.driver.findElement(By.id("submit"));
	}

	public boolean isDataSaved() {
		try {
			wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[contains(@class, 'poruka')]"), "style",
					"visibility: visible"));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void fillInTheForm(String name, String radioValue, String string, String email, String role, String value,
			String comment) {
		this.getNameInput().sendKeys(name);
		this.getRadio(radioValue);
		this.getDobInput().sendKeys(string);
		this.getEmailInput().sendKeys(email);
		this.select = new Select(this.getRoleSelector());
		select.selectByVisibleText(role);
		this.getCheckboxInput(value).click();
		this.getCommentInput().sendKeys(comment);
	}

}
