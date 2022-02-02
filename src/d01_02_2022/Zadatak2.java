package d01_02_2022;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		
//		Napisti program koji:
//			Ucitava stranicu https://videojs.com/city
//			Pusta video klikom na play dugme
//			Cekamo da se video ucita
//			Tako sto proveravamo da li vise to play dugme nije vidljivo

		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://videojs.com/city");
		driver.findElement(By.className("vjs-big-play-button")).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(By.id("vjs_video_3"), "class", "vjs-user-inactive"));
		System.out.println("Kraj");

	}

}
