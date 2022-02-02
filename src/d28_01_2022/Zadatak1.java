package d28_01_2022;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		
//		Maksimizirati prozor
//		Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
//		Od korisnika ucitati broj na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
//		I izvrsite akciju klik na odgovarajuci element
//		Na kraju programa ugasite pretrazivac.

		Scanner s = new Scanner(System.in);
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://s.bootsnipp.com/iframe/WaXlr");
		System.out.println("Izaberite zvezdicu (unesite broj od 1 do 5): ");
		driver.findElement(By.id("rating-star-" + s.nextInt())).click();
		Thread.sleep(5000);
		driver.close();
	}

}
