package org.test3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Newpara{
	
	public static  WebDriver driver  ;
	 static JavascriptExecutor j;
	
	public  void thread(String s1) {
		long t = Thread.currentThread().getId();
		System.out.println(t + s1);

	}
	@Parameters({"brow"})
	@Test(priority=1,groups="bonding")
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
	   
	}
    else
	if(s1.equals("op"))
	{
		String operaDriver="C:\\Testng\\newie3.4.0\\operadriver.exe";
	    System.setProperty("webdriver.opera.driver",operaDriver);
		driver = new OperaDriver();
		
	}
	else
	{
	}
	driver.get("https://www.snapdeal.com/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	}	
	
	@Test(groups="bonding",priority=3)
	public void signin() throws InterruptedException, InvalidFormatException, IOException
	{
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		 driver.findElement(By.xpath("//a[text()='login']")).click();
		
	}
	@Test(groups="bonding",priority=4)
	public void regpage1() throws InterruptedException, InvalidFormatException, IOException
	{
			driver.switchTo().frame("loginIframe");
			Thread.sleep(6000);
            driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("greens@gmail.com");
            driver.findElement(By.xpath("(//button[text()='continue'])[1]")).click();
		    Thread.sleep(2000);
          }
	
	@Test(groups="bonding",priority=5)
	public void regpage2() throws InterruptedException, InvalidFormatException, IOException 
	{
		    Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("loginIframe");
			//driver.navigate().refresh();
			Thread.sleep(2000);
		    WebElement number1 = driver.findElement(By.xpath("//input[@id='j_number']"));
		    number1.sendKeys("7401298240");
		    System.out.println("print number: " + number1.getAttribute("value"));
		    
			WebElement name1= driver.findElement(By.id("j_name"));
			name1.sendKeys("latha");
			System.out.println("print name: " + name1.getAttribute("value"));
			
		    WebElement date1= driver.findElement(By.id("j_dob"));
			date1.clear();
			date1.sendKeys("01/05/1998");
			System.out.println("print date: " +date1.getAttribute("value"));
			
			WebElement pass1 = driver.findElement(By.id("j_password"));
			pass1.sendKeys("esv@98");
			System.out.println("print pass: " + pass1.getAttribute("value"));
			driver.findElement(By.xpath("//i[@data-pass='j_password']")).click();
			driver.findElement(By.xpath("//button[@id='userSignup']")).click();
		
			}
			

		
     @Test(groups="bonding",priority=6)
		public void javascript() throws InterruptedException {
    	 Thread.sleep(2000);
			driver.navigate().refresh();
			WebElement pro1 = driver.findElement(By.xpath("//h2[text()='TRENDING PRODUCTS']"));
			j=(JavascriptExecutor)driver;
			j.executeScript("arguments[0].setAttribute('style','background:red');", pro1);
			}
     
     @Test(groups="bonding",priority=7,invocationCount=3,dataProvider="search")
     public void search(String s) throws InterruptedException {
    	 Thread.sleep(1000);
		 WebElement search1 = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
		 search1.sendKeys(s);
		 System.out.println("print search line:" + search1.getAttribute("value"));
		
	}
     
     @DataProvider(name="search")
     public Object[][]data() {
		return new Object[][]
		{
		
			{"sunglasses"},
			{"sling bag"}
			};
		

	}
}


