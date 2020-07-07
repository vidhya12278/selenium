package practice;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Diff {

	WebDriver driver;
	Date d;
	
	  @BeforeMethod
		 public void start8() {
		 d=new Date();
		 System.out.println("start execution time: " +d);

		}
	  
	 @Test(groups="bonding",priority=29)
	 public void sentence() throws InterruptedException {
		 Thread.sleep(4000);
		 driver.navigate().to("https://www.snapdeal.com/");
		 driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 Thread.sleep(3000);
		 WebElement down = driver.findElement(By.xpath("//div[text()='Copyright © 2020, Snapdeal Private Limited (formerly Jasper Infotech Private Limited). All Rights Reserved']"));
		 js.executeScript("arguments[0].scrollIntoView(true)",down );
		 
		 WebElement made = driver.findElement(By.xpath("//div[@class='rfloat heartLine']"));
		//js.executeScript("arguments[0].scrollIntoView(true)", made);
		//js.executeScript("arguments[0].scrollIntoView(true)",copy );
		
		System.out.println("print line : " + made.getText());
	}
	@AfterMethod(groups="bonding")
	public void end() {
		d=new Date();
		System.out.println("end time : "  + d);

	}
}
