package org.test3;

import java.awt.SystemColor;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Parallel
{
   public   WebDriver driver;
	@BeforeClass
	@Parameters({"browser"})
	public void tc2(String s1) throws InterruptedException {
	if(s1.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\Testng\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}
	else
	if(s1.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver","C:\\Selenium\\driver\\IEDriverServer.exe");
	    driver = new InternetExplorerDriver();
	    Thread.sleep(3000);
	}
    else
	if(s1.equals("ff"))
	{
	    System.setProperty("webdriver.gecko.driver","C:\\Testng\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		Thread.sleep(3000);
	}
	else
	{
	}
	driver.get("http://filpkart.in/");
	driver.manage().window().maximize();
	}	

	@AfterClass
	public void last()
	{
		System.out.println("last");
	}
	
}

