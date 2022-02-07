package com.Vtiger.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_CreateOrganization {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8888/");

		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("admin");

		driver.findElement(By.id("submitButton")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("VASANTH3");

		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("VASANTH3");

		Select sel= new Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']")));

		sel.selectByVisibleText("Organization Name");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();

		String value=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		if(value.equals("VASANTH3"))

		{

			System.out.println("Tc pass");

		}

		else {

			System.out.println("Tc fail");
		}

		Actions aa = new Actions(driver);

		WebElement ss=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		aa.moveToElement(ss).build().perform();

		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		driver.close();






























	}
}
