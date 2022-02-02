package d31_01_2022;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.javafx.print.Units;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		
//		Napisati program koji ucitava stranicu https://geodata.solutions/
//			Bira proizvoljan Country, State i City
//			Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//			I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//			Izabrerit Country, State i City tako da imate podatke da selektujete!

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.navigate().to("https://geodata.solutions/");
		Select country = new Select(driver.findElement(By.className("countries")));

		country.selectByIndex(15);
		Select state = new Select(driver.findElement(By.className("states")));
		state.selectByIndex(2);
		Thread.sleep(5000);
		Select city = new Select(driver.findElement(By.className("cities")));
		city.selectByIndex(3);
	}

}
