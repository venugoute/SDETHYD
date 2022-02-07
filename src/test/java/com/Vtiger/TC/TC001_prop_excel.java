package com.Vtiger.TC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.IAutoConstants;

public class TC001_prop_excel {

	public static void main(String[] args) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream(IAutoConstants.propfilepath);

		Properties prop = new Properties();

		prop.load(fis);

		String value1 = prop.getProperty("url");
		
		String un = prop.getProperty("un");
		
		String pwd = prop.getProperty("pwd");


		System.out.println(value1);

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		String browser = prop.getProperty("browser");

		if(browser.equalsIgnoreCase("chrome"))

		{
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
			driver.get(value1);
		}
		else
		{
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys(un);

		driver.findElement(By.name("user_password")).sendKeys(pwd);

		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(3000);





	}

}
