package com.Vtiger.TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_CreateOrg_dd {

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

		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		String Orgname= "Kivi";

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Orgname);

		WebElement ratingdd = driver.findElement(By.xpath("//select[@name='rating']"));
		Select venu = new Select(ratingdd);
		venu.selectByValue("Active");
		Thread.sleep(2000);


		WebElement industrydd =driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel =new Select(industrydd);
		sel.selectByValue("Environmental");
		Thread.sleep(2000);

		WebElement typedd =driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select selinium =new Select(typedd);
		selinium.selectByValue("Integrator");
		Thread.sleep(2000);
      
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(Orgname);

		Select tel= new Select(driver.findElement(By.xpath("//select[@id='bas_searchfield']")));

		tel.selectByVisibleText("Organization Name");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();

		String value=driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		if(value.equals(Orgname))

		{

			System.out.println("Tc pass");

		}

		else {

			System.out.println("Tc fail");
		}

		Actions aa = new Actions(driver);

		WebElement ss=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		aa.moveToElement(ss).build().perform();

		




	}	
}
