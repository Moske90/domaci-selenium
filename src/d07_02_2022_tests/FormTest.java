package d07_02_2022_tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d07_02_2022_pages.FormPage;


public class FormTest {

	private WebDriver driver;
	private FormPage formPage;
	private WebDriverWait wait;
	private JavascriptExecutor js;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get("file:///C:/Users/Ana%20i%20Moske/Downloads/form.html");
		formPage = new FormPage(driver, wait);
	}

	@Test
	public void formTest() throws InterruptedException {
		formPage.fillInTheForm("Marko", "male", "04.1990.", "marko@gmail.com", "QA", "online_courses", "Hey!");
		Thread.sleep(2000);
		formPage.getSubmitButton().click();
		Thread.sleep(1000);
		Assert.assertTrue(formPage.isDataSaved(), "Data not saved!");
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}
}
