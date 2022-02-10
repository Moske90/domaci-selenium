package d07_02_2022_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d07_02_2022_pages.FlyingNinjaPage;
import d07_02_2022_pages.KatalonPage;
import d07_02_2022_pages.ViewCartPage;

public class KatalonTest {

	private WebDriver driver;
	private KatalonPage katalonPage;
	private FlyingNinjaPage fnPage;
	private ViewCartPage vcPage;
	private JavascriptExecutor js;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get("https://cms.demo.katalon.com/");
		katalonPage = new KatalonPage(driver);
		fnPage = new FlyingNinjaPage(driver);
		vcPage = new ViewCartPage(driver);
	}

	@Test
	public void KatalonTest() throws InterruptedException {
		katalonPage.getShopLink().click();
		katalonPage.getFirstProduct().click();
		fnPage.getQuantityInput().clear();
		fnPage.getQuantityInput().sendKeys("2");
		fnPage.getAddToCartButton().click();
		Assert.assertTrue(fnPage.doesMessageExist(), "Message doesn't exist!");
		Thread.sleep(1000);
		fnPage.getViewCartButton().click();
		Thread.sleep(1000);
		Assert.assertTrue(vcPage.isQuantity(), "Quantity doesn't match!");
		vcPage.getRemoveButton().click();
		Assert.assertEquals(vcPage.getCartEmptyMessage(), "Your cart is currently empty.");
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}
}
