package d07_02_2022_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KatalonPage {

	private WebDriver driver;

	public KatalonPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getShopLink() {
		return this.driver.findElement(By.linkText("SHOP"));
	}

	public WebElement getFirstProduct() {
		return this.driver.findElement(By.xpath("//*[@id='main']/div[2]/ul/li[1]/div/a[1]"));
	}

}
