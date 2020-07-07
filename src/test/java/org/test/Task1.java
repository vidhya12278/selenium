package org.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task1 {
	static WebDriver d;
	Date p;
	Flippojo i;
@BeforeClass
private static  WebDriver launch() {
	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver.exe");
	 d = new ChromeDriver();
   d.manage().window().maximize();
  // d.get("https://www.facebook.com/");
   d.get("https://www.flipkart.com/account/login");
return d;
}
@BeforeMethod
private void execution() {
 p = new Date();
 System.out.println("flipkart execution time: " + p);
}

@Test(priority=2)
private void flipkart() {
i=new Flippojo();
i.getEmail().sendKeys("greens@gmail.com");
Assert.assertTrue(true,"verify emailid correct");
String e = i.getEmail().getAttribute("value");
System.out.println(e);
Assert.assertEquals("greens@gmail",e, "verify emailid correct");
i.getPassword().sendKeys("greens");
}
@Test(invocationCount=1)
private void filp()
{
 i=new Flippojo();
 i.getPassword().sendKeys("9870123456");
}
@Test
private void password() {
SoftAssert q = new SoftAssert();
i.getPassword().sendKeys("9870123456");
q.assertEquals(true,"password failed");
String w = i.getPassword().getAttribute("value");
q.assertEquals("verify password incorrect", "greens", w);
}
@AfterMethod
private void endtime() {
	p = new Date();
	System.out.println("flipkart execution end time: "+ p);
}
@AfterClass
private void close() {
	d.close();

}
}
