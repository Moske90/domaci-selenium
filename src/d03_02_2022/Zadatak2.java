package d03_02_2022;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		
//		Napisati program koji:
//			Ucitava stanicu https://www.wikipedia.org/
//			Sa stranice sakuplja sve linkove (jezike) i svaki link otvara u novom prozoru pretrazivaca
//			Svaki link potrebno je otvoriti u novom tabu.
//			Skripta: window.open(arguments[0]);

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.navigate().to("https://www.wikipedia.org/");

		for (int i = 1; i <= 10; i++) {
			WebElement e = driver.findElement(By.xpath("//*[contains(@class,'lang" + i + "')]/a"));
			js.executeScript("window.open(arguments[0]);", e);
			Thread.sleep(1000);
		}

	}

}
