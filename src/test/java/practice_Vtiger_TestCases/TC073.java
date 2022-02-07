package practice_Vtiger_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC073 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8888/");

		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("admin");

		driver.findElement(By.id("submitButton")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();

	}
}
