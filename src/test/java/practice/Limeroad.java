package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Limeroad {
	public static  WebDriver driver  ;
	 static JavascriptExecutor j;
	 static Actions a;
	 Date d;
	 @Parameters({"brow"})	
	 @BeforeClass
	 @Test(priority=5,groups="regression")
	 public void launch(String s1) {
		 //parameter
		 //thread id
	 String operaDriver="C:\\Testng\\newie3.4.0\\operadriver.exe";
	 System.setProperty("webdriver.opera.driver",operaDriver);
	 driver = new OperaDriver();
	 driver.get("https://www.limeroad.com/");
	 driver.manage().window().maximize();
	 long t = Thread.currentThread().getId();
	 System.out.println(t + s1);
	}
	 @Test(priority=8,groups="regression")
	 public void pagetitleurl() 
	 {
		 //groups
		 //priority
		System.out.println("title: " + driver.getTitle());
		System.out.println("url : " + driver.getCurrentUrl());
    }
	 @Test(priority=8,groups="regression")
	 public void selectlanguage() 
	 {
		WebElement lang = driver.findElement(By.xpath("//div[text()='ENGLISH']"));
		lang.click();
		driver.findElement(By.xpath("//span[text()='SHOP WOMEN']")).click();
	}
	 @Test(priority=9,groups="regression")
	 public void selectwomen() 
	 {
		WebElement women = driver.findElement(By.xpath("//span[text()='SHOP WOMEN']"));
		women.click();
	}
	 @Test(priority=10,groups="sang")
	 public void selectmen() 
	 {
		driver.findElement(By.xpath("//span[text()='SHOP MEN']")).click();
	}
	 @Test(priority=10,groups="regression")
	 public void menupage() throws InterruptedException, IOException
	 {
		 //screenshot
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//a[@class='tdN pA t0 l12 w24 h24 m128 z8 navBtn dN an-menu']")).click();
		 TakesScreenshot t=(TakesScreenshot)driver;
		 File s = t.getScreenshotAs(OutputType.FILE);
		 File d = new File("C:\\Testng\\limeroadscreens\\menu.jpg");
		 FileUtils.copyFile(s,d);
     }
	 @Test(priority=10,groups="regression")
	 public void signin() throws InterruptedException, IOException 
	 {
		 //navigate
		Thread.sleep(2000);
		WebElement sign= driver.findElement(By.xpath("//a[text()='sign in']"));
		sign.click();
		Thread.sleep(2000);
		WebElement mob1 = driver.findElement(By.xpath("(//input[@name='user_id'])[2]"));
		mob1.sendKeys("7358408116");
		Thread.sleep(2000);
		System.out.println(mob1.getAttribute("value"));
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(2000);
		WebElement otp = driver.findElement(By.xpath("//input[@id='otp']"));
		otp.sendKeys("0805");
		System.out.println("otp : " + otp.getAttribute("value"));
		 TakesScreenshot t=(TakesScreenshot)driver;
		    File s = t.getScreenshotAs(OutputType.FILE);
		    File d = new File("C:\\Testng\\limeroadscreens\\signin.jpg");
		    FileUtils.copyFile(s,d);
		Thread.sleep(7000);
		driver.navigate().refresh();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@class='tdN pA t0 l12 w24 h24 m128 z8 navBtn dN an-menu']")).click();
		Thread.sleep(2000);
		String change = driver.findElement(By.xpath("//div[text()='change language']")).getText();
		System.out.println(change);
	 }
	 @Test(priority=12,groups="reg")
	 public void logout()
	 {
		driver.findElement(By.xpath("(//a[@class='dB p8 c3 tdN hcP'])[7]")).click();
		driver.findElement(By.xpath("//a[text()='logout']")).click();
     }
	 @Test(priority=12,groups="regression")
	 public void smartwatches() throws InterruptedException, AWTException, IOException 
	 {
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[@class='tdN pA t0 l12 w24 h24 m128 z8 navBtn dN an-menu']")).click();
      	 Thread.sleep(2000);
	     driver.findElement(By.xpath("(//div[@class='pR has-sub c0 pr36 p8 dB hcP pl12'])[27]")).click();
      	 driver.findElement(By.xpath("//a[text()='Smart Watches']")).click();
      	 Thread.sleep(3000);
      	   TakesScreenshot t=(TakesScreenshot)driver;
		    File s = t.getScreenshotAs(OutputType.FILE);
		    File d = new File("C:\\Testng\\limeroadscreens\\smartwatches.jpg");
		    FileUtils.copyFile(s,d);
		    driver.findElement(By.xpath("//a[@class='pA t0 r60 m128 w24 h24 srch z5 dN an-srch']")).click(); 	
	 }
@Test(groups="regression",priority=14,invocationCount=10,dataProvider="search",dataProviderClass=Maintaing.class)
	 private void searchproduct(String s1) throws InterruptedException
	 {
	 //driver.navigate().back();
	 Thread.sleep(1000);
	 WebElement send = driver.findElement(By.xpath("//input[@type='search']"));
	 send.clear();
	 send.sendKeys(s1);
	 System.out.println("i am searching the product with low price :" + s1);
	 	}
@Parameters({"search"})
@Test(groups="regression",priority=16)
      public void addtocart(String s) throws InterruptedException 
      {
	   Thread.sleep(1000);
	   WebElement send = driver.findElement(By.xpath("//input[@type='search']"));
	   send.clear();
       send.sendKeys(s);
       System.out.println(s);
	   WebElement sub = driver.findElement(By.xpath("//div[@class='srcInpuSub dTc vT w60 pR hcurP']"));
	    sub.click();
	   Thread.sleep(2000);
	  WebElement low = driver.findElement(By.xpath("//div[text()='Low Price']"));
	  low.click();
	  Thread.sleep(2000);
	  String delivery = driver.findElement(By.xpath("(//div[@class='bs fs14 p12 pR'])[1]")).getText();
	  System.out.println(delivery);
 }
	 
	 @Parameters({"str","web","dr"})
     @Test
	 public static void highlight(String s1, WebElement s2, WebDriver driver2)
	 {
		 j.executeScript("arguments[0].style.backgroundColor='"+s1+"'",s2);
		 try
		 {
		 Thread.sleep(8000);
		 }
		 catch(Exception e)
		 {
		 }
	}
	 @BeforeMethod
	 public void start() 
	 {
	 d=new Date();
	 System.out.println("start execution time: " +d);

	}
	 @AfterMethod
	 public void end()
	 {
		 d=new Date();
		 System.out.println("end execution time: " +d);
	}
	
}