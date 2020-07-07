package org.test1;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.Flippojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task2 
{
	static WebDriver d;
	Date p;
@BeforeClass
private static  WebDriver launch() {
	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver.exe");
	d = new ChromeDriver();
    d.manage().window().maximize();
    //d.get("https://www.facebook.com/");
   //d.get("https://www.flipkart.com/account/login");
    d.get("https://mail.google.com/");
    return d;
}
@BeforeMethod
private void execution() {
 p = new Date();
 System.out.println("flipkart execution time: " + p);
}

@Parameters({"gmailid","password"})
@Test
private void verify(String s1,String s2) {
	d.findElement(By.id("identifierId")).sendKeys(s1);
	d.findElement(By.xpath("//span[text()='Next']")).click();
	d.findElement(By.name("password")).sendKeys(s2);
	//d.findElement(By.id("loginbutton")).click();
}
@AfterMethod
private void endtime() {
	p = new Date();
	System.out.println("flipkart execution end time: "+ p);
}
@AfterClass
private void close() {
	//d.close();

}
	

}
