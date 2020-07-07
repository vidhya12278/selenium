package org.test1;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sample 
{
public	static WebDriver d;
	static Date p;
@BeforeClass(groups="smoke")
private static WebDriver browser() 
{
	System.setProperty("webdriver.chrome.driver","C:\\Testng\\drivers\\chromedriver.exe");
d = new ChromeDriver();
d.manage().window().maximize();
d.get("https://www.facebook.com/");
return d;
	
	}
@BeforeMethod(groups="smoke")
private void execution() {
p = new Date();
System.out.println("facebook execution time: " + p);
}
	
	
@Test(groups="smoke")
private void mail() throws InterruptedException 
{
	d.findElement(By.id("email")).sendKeys("riya");
    Thread.sleep(2000);
}
@Test
private void tc2() {
System.out.println("password");
}
	
@AfterMethod(groups="smoke")
private void endtime() {
p = new Date();
System.out.println("facebook execution end time: "+ p);
}
@AfterClass
private void close() {
//d.close();
}

}
