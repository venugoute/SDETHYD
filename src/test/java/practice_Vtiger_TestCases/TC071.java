package practice_Vtiger_TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC071 {

	public static void main(String args[]) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8888/");

		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("admin");

		driver.findElement(By.id("submitButton")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();

		driver.findElement(By.xpath("//input[@style='width:120px']")).sendKeys("Ramesh");

		WebElement organizationdd = driver.findElement(By.xpath("//select[@style='width:150px']"));

		Thread.sleep(3000);

		Select venu = new Select(organizationdd);

		venu.selectByVisibleText("Assigned To");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();

		Actions aa = new Actions(driver);

		WebElement ss=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		aa.moveToElement(ss).build().perform();

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		driver.close();



	}
}
