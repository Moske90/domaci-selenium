package d07_02_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewCartPage {

	private WebDriver driver;

	public ViewCartPage(WebDriver driver) {
		this.driver = driver;
	}

	private WebElement getQuantity() {
		return this.driver.findElement(By.xpath("//td[@class='product-quantity']/div/input"));
	}

	public boolean isQuantity() {
		String value = getQuantity().getAttribute("value");
		if (value.equals("2")) {
			return true;
		} else {
			return false;
		}
	}

	public WebElement getRemoveButton() {
		return this.driver.findElement(By.xpath("//*[@id='post-8']/div/div/form/table/tbody/tr[1]/td[1]/a"));
	}

	public String getCartEmptyMessage() {
		return this.driver.findElement(By.xpath("//*[contains(@class,'cart-empty')]")).getText();
	}

}
