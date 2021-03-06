package d03_02_2022;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		
//		Napisati program koji:
//			Ucitava stranicu https://www.google.com/
//			Hvata body element sa stranicu i njemu setuje atribut 
//			style na vrednost ?background: nekaBoja?
//			Skripta: arguments[0].style=?background: black?;
//			(Za vezbanje) Setuje prosledjenu boju:
//			Skripta: arguments[0].style=?background:? + arguments[1];
//			Boje za testiranje - red, green, blue, ?

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.google.com/");
		
		WebElement e = driver.findElement(By.tagName("body"));
		
		js.executeScript("arguments[0].style='background: black';", e);
		Thread.sleep(3000);

	}

}
