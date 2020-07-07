package practice;

import java.util.*;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

public class Yatrabus 
{
	public static  WebDriver driver  ;
	 @Test(priority=1)
	 public void browserlaunch() throws InterruptedException 
	 {
	 String operaDriver="C:\\Testng\\newie3.4.0\\operadriver.exe";
	 System.setProperty("webdriver.opera.driver",operaDriver);
	 driver = new OperaDriver();
	 driver.get("https://www.google.com/");
	 driver.manage().window().maximize();
	 }
	  @Test(priority=3)
	 public void search() throws InterruptedException 
	 {
		 WebElement yatra = driver.findElement(By.xpath("//input[@title='Search']"));
		 Thread.sleep(2000);
		 JavascriptExecutor j=(JavascriptExecutor)driver;
		 j.executeScript("arguments[0].setAttribute('value','yatra bus')", yatra);
		 System.out.println("print send value : " + yatra.getTagName());
		 WebElement bus = driver.findElement(By.xpath("(//input[@type='submit'])[3]"));
		 JavascriptExecutor sj=(JavascriptExecutor)driver;
		 sj.executeScript("arguments[0].click()",bus);
		 Thread.sleep(3000);
		 WebElement click = driver.findElement(By.xpath("(//h3[@class='LC20lb DKV0Md'])[1]"));
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()",click);
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//input[@id='BE_bus_search_btn']")).click();
}
	  @Test(priority=5)
	 public void nameslist() 
	 {
		 List<WebElement> yatrabus = driver.findElements(By.xpath("//div[@class='op-name']"));
		 int f=yatrabus.size();
		 System.out.println("no of buses in list : " +   f);
		 Set<String> m=new TreeSet<String>();
		 for (int i = 0; i < f; i++) 
		 {
			String r = yatrabus.get(i).getText();
			m.add(r);
		 }
		int w = m.size();
		System.out.println("unique names : " + w);
		System.out.println("----------------------unique name in list---------------------");
		for (String full : m) 
		{
		System.out.println(full);	
		}
		
		 driver.quit();
		 }
	 
	 
	
	 
	
	
	/* Set<String> s=new  HashSet<String>();
	 Thread.sleep(3000);
	 int f = yatrabus.size();
	 System.out.println("no of buses in list : " + f);
	 for (WebElement w : yatrabus) 
	 {
		s.add(w.getText());
	}
	 int e = s.size();
	 System.out.println("after remove duplicate : " + e);
	 for (String full : s)
	 {
		System.out.println(full);
	}
	 */
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
