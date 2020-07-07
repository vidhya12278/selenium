package org.test2;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day4 {

static WebDriver d;
Date p;
@BeforeClass
private static  WebDriver launch() {
System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver.exe");
d = new ChromeDriver();
d.manage().window().maximize();
//d.get("https://www.facebook.com/");
//d.get("https://www.flipkart.com/account/login");
//d.get("https://mail.google.com/");
return d;
}

@BeforeMethod
private void execution() {
p = new Date();
System.out.println("facebook execution time: " + p);
}

@Test(dataProvider="sampledata")
private void tc1(String s1,String s2) {
d.get("https://www.facebook.com/");
d.findElement(By.id("email")).sendKeys(s1);
d.findElement(By.id("pass")).sendKeys(s2);
//d.findElement(By.id("loginbutton")).click();
}
@DataProvider(name="sampledata")
public static Object[][] data() {
	return new Object[][]
			{
		{"aws","devepos"},
		{"java","selenium"},
		{"python","selenium"},
		{"hadoop","spark"}
		};
		}

@AfterMethod
private void endtime() {
p = new Date();
System.out.println("facebook execution end time: "+ p);
}
@AfterClass
private void close() {
//d.close();
}
}
