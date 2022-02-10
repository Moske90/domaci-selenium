package d07_02_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlyingNinjaPage {

	private WebDriver driver;
	
	public FlyingNinjaPage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public WebElement getAddToCartButton() {
		return this.driver.findElement(By.name("add-to-cart"));
	}
	
	public WebElement getQuantityInput() {
		return this.driver.findElement(By.name("quantity"));
	}
	
	public WebElement getMessage() {
		return this.driver.findElement(By.xpath("//*[@id='main']/div[1]/div"));
	}
	
	public String getTextMessage() {
		return getMessage().getText();
	}
	
	public boolean doesMessageExist() {
		try {
			getTextMessage();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public WebElement getViewCartButton() {
		return this.driver.findElement(By.xpath("//*[contains(@class,'wc-forward')]"));
	}
	
	
}
