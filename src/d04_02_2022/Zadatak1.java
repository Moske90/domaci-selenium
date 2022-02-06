package d04_02_2022;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak1 {

//	Umesto prvog za Udemy imamo kupujem prodajem.
//	Ucitajte stranicu (ako treba gasite onaj dijalog sto iskace)
//	Ukucajte za pretragu iphone
//	postavice za valutu eure
//	Sortirajte prema ceni da bude najjefinije prvo
//	Onda izvrsite proveru sortiranja kao sto je bilo za udemy
	
WebDriver driver;
JavascriptExecutor js;	
WebDriverWait wait;

	@BeforeMethod
	public void before() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.navigate().to("https://www.kupujemprodajem.com/");
		driver.findElement(By.className("kpBoxCloseButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void inputsTest() throws InterruptedException {
		
		driver.findElement(By.id("searchKeywordsInput")).sendKeys("iphone");
		driver.findElement(By.id("searchKeywordsInput")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);

//		Select select = new Select (driver.findElement(
//				By.xpath("//*[@id='orderSecondSelection']/div/div[1]/div[1]")));
//		select.selectByVisibleText("Jeftinije");

		driver.findElement(By.xpath("//*[@id=\"priceSecondSelection\"]/div/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//*[@action-name='currency-eur']")).click();
		driver.findElement(By.xpath("//*[@id=\"priceSelection\"]/input[5]")).click();
		
		driver.findElement(By.xpath("//*[@id='orderSecondSelection']//span[@class='choiceLabelText']")).click();
		driver.findElement(By.xpath("//*[@id='menuGroup0']//div[contains(text(),'Jeftinije')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("secondarySearchButton")).click();
		
		List<WebElement> sveCene = driver.findElements(By.id("adPrice "));
		
		for (int i = 0; i < sveCene.size(); i++) {
			boolean jesteSortirano;
			String najmanji = sveCene.get(0).getText();
			double najmanjaCena = Double.parseDouble(najmanji);
			if(Double.parseDouble(sveCene.get(i).getText())>=najmanjaCena) {
				jesteSortirano = true;
			}else {
				jesteSortirano = false;
			}
//		trebace mi malo vremena da skontam kako ovo da resim do kraja		
			Assert.assertEquals(jesteSortirano, true, "Pretraga ne radi dobro.");
		}
		
	}
	
	

//	@AfterMethod
//	public void after() {
//		driver.quit();
//	}
}
