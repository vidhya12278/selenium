package org.test4;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.server.Authentication.Failed;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Rerun {
	public WebDriver driver;
	Date d;

	@BeforeClass
	private void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.get("https://demoqa.com/html-contact-form");
	}

	@BeforeMethod
	private void start() {
		d = new Date();
		System.out.println("start time:" + d);
	}

	@Test
	private void check() {
		Assert.assertTrue(false);
		System.out.println("checking");
	}

	@Test
	private void table() {
		driver.get("https://www.google.com/");
		WebElement e = driver.findElement(By.xpath("//input[@title='Search']"));
		e.sendKeys("painting for kids online");
		driver.findElement(By.xpath("(//input[@value='Google Search'])[1]")).click();

		driver.findElement(By.xpath("//h3[text()='Coloring online, painting games']")).click();
		driver.findElement(By.xpath("//a[text()='Christmas']")).click();
	}
	
	@AfterMethod
	private void ending() {
		d = new Date();
		System.out.println("end time:" + d);
	}

	@AfterClass
	private void end() {
		System.out.println("close");

	}

}
