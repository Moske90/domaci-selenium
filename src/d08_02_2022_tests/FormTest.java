package d08_02_2022_tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import d08_02_2022_pages.FormPage;

public class FormTest {
	private WebDriver driver;
	private FormPage formPage;
	private WebDriverWait wait;
	private SoftAssert sa;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		sa = new SoftAssert();
		formPage = new FormPage(driver, wait);

		driver.get("file:///C:/Users/Ana%20i%20Moske/Downloads/form.html");
	}

	@Test
	public void FormTest() throws InterruptedException, IOException {
		Thread.sleep(2000);
		File file = new File("data/FormData.xlsx");
		System.out.println(file.getAbsolutePath());
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet sheet = wb.getSheet("form");

		for (int i = 1; i <= 6; i++) {
			formPage.fillInTheForm(sheet.getRow(i).getCell(0).getStringCellValue(),
					sheet.getRow(i).getCell(1).getStringCellValue(), "sheet.getRow(i).getCell(2).getNumericCellValue()",
					sheet.getRow(i).getCell(3).getStringCellValue(), sheet.getRow(i).getCell(4).getStringCellValue(),
					sheet.getRow(i).getCell(5).getStringCellValue(), sheet.getRow(i).getCell(6).getStringCellValue());

			Thread.sleep(2000);
			sa.assertTrue(formPage.isDataSaved(), "Data not saved!");
		}

		sa.assertAll();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
