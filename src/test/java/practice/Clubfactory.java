package practice;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Clubfactory {
	public static  WebDriver driver  ;
	 static JavascriptExecutor j;
	 static Actions a;
	 Date d;
	 @Parameters({"brow"})	
	 @BeforeClass
	 @Test(priority=1,groups="regression")
	 public void launch(String s1) {
	 String operaDriver="C:\\Testng\\newie3.4.0\\operadriver.exe";
	 System.setProperty("webdriver.opera.driver",operaDriver);
 	 driver = new OperaDriver();
 	 driver.get("https://www.clubfactory.com/");
 	 driver.manage().window().maximize();
 	 long t = Thread.currentThread().getId();
	 System.out.println(t + s1);
	}
	 @Test(priority=3,groups="regression")
	 public void title() throws IOException, InterruptedException 
	 {  
		 Thread.sleep(1000);
		 System.out.println("title : " + driver.getTitle());
		 System.out.println("url : " + driver.getCurrentUrl());
         TakesScreenshot ts=(TakesScreenshot)driver;
	        File s = ts.getScreenshotAs(OutputType.FILE);
	        File d = new File("C:\\Testng\\clubscreenhots\\clubfactory.jpg");
	        FileUtils.copyFile(s, d);
	        Thread.sleep(2000);
	 }
	 @Test(priority=4,groups="regression")
	 public void genderselectforwomen() throws InterruptedException
	 { 
		 Thread.sleep(1000);
	      WebElement feamle= driver.findElement(By.xpath("//div[@class='cf_gender_bg cf_female']"));
	      feamle.click();
	    }
	
	 @Test(priority=6,groups="regression")
	 public void homenewreg() throws InterruptedException
	 {
	 driver.findElement(By.xpath("//i[@class='iconfont icon-Account-Socail menu_icon___2rzfi7k-']")).click();
	 driver.findElement(By.xpath("//li[text()='Log in/Sign up']")).click();
	 driver.findElement(By.xpath("//button[text()='New User? Sign Up']")).click();
	 WebElement phno = driver.findElement(By.xpath("//input[@class='cf_input_item_inner']"));
	 phno.sendKeys("7358408116");
	 System.out.println("phno : " + phno.getAttribute("value"));
	 WebElement con = driver.findElement(By.xpath("//button[text()='Continue']"));
     con.click();
     driver.navigate().refresh();
    /* //logout
     driver.findElement(By.xpath("//li[text()='Log out']")).click();
     Thread.sleep(2000);*/
	 }
	 @Test(priority=8,groups="regression")
	 public void homecategory() throws IOException, InterruptedException 
	 {
	 a=new Actions(driver);
	 Thread.sleep(1000);
     WebElement women = driver.findElement(By.xpath("(//li[@class='category_item___1XaxBWn_'])[1]"));
     a.moveToElement(women).perform();
     Thread.sleep(1000);
     WebElement socks = driver.findElement(By.xpath("(//div[@class='sub_title___3CSU9vc0'])[9]"));
     a.moveToElement(socks).perform();
     a.click(socks).perform();
     Thread.sleep(1000);
	 }
	 @Test(groups="regression",priority=9)
	 public void insideproduct() throws InterruptedException, IOException
	 {
	 driver.findElement(By.xpath("(//div[@class='p_img___tCEgKAVd larg_p_img___2pscUdrF'])[3]")).click();
    // Thread.sleep(6000);
    
     WebDriverWait wait = new WebDriverWait(driver,20);
     try {
     WebElement quantity= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='p_qty___-_hKzWTX']")));
     System.out.println(quantity.getText());
     highlight("yellow",quantity,driver);
     }
     catch(TimeoutException e)
     {
     WebElement clicks = driver.findElement(By.xpath("//button[@class='cfm_number_btn cfm_number_add']"));
     for (int i = 0; i < 5; i++) 
     {
		clicks.click();
		
     }
     String num1 = driver.findElement(By.xpath("//input[@step='1']")).getAttribute("value");    
     System.out.println(" quantity :  " + num1);
     WebElement clicks1 = driver.findElement(By.xpath("//button[@class='cfm_number_btn cfm_number_reduce']"));
     for (int i = 0; i < 2; i++) 
     {
		clicks1.click();
	 }
        TakesScreenshot ts=(TakesScreenshot)driver;
        File s = ts.getScreenshotAs(OutputType.FILE);
        File d = new File("C:\\Testng\\clubscreenhots\\quantitycheck.jpg");
        FileUtils.copyFile(s, d);
     System.out.println("over view....................");
     WebElement overview = driver.findElement(By.xpath("//div[@class='over_view___ANjlY1yp']"));
     System.out.println("over view process : " + overview.getText());
     highlight("blue",overview,driver);
     WebElement test = driver.findElement(By.xpath("//div[@class='cf-tabs-content-item cf-tabs-content-active']"));
     System.out.println("description : " + test.getText());
     WebElement review = driver.findElement(By.xpath("(//div[text()='No reviews yet.'])[2]"));
     System.out.println(review.getText());
     Thread.sleep(2000);
	 }
	 }
	 @Test(priority=11,groups="regression")
	 public void homecategoryaddress() throws InterruptedException 
	 {
	 driver.findElement(By.xpath("//button[text()='Buy Now']")).click();
     Thread.sleep(1000);
     //address
     String ship = driver.findElement(By.xpath("//div[@class='card_title___32HLjW3i title_flex___3TyF-Jw7 margin_b___adZqYnot']")).getText();
     System.out.println(ship);
     WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
     name.sendKeys("vidhya");
     System.out.println(name.getText());
     WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
     phone.sendKeys("8939262472");
     System.out.println(phone.getText());
     WebElement alternativeph = driver.findElement(By.xpath("//input[@name='alternatephone']"));
     alternativeph.sendKeys("7358196199");
     System.out.println("alternative phno: " +alternativeph.getText());
     WebElement pin = driver.findElement(By.xpath("//input[@name='pincode']"));
     pin.sendKeys("600115");
     System.out.println("pin code : " + pin.getText());
     WebElement flat = driver.findElement(By.xpath("//input[@name='flat']"));
     flat.sendKeys("adyar");
     System.out.println(flat.getText());
     WebElement colony = driver.findElement(By.xpath("//input[@name='colony']"));
     colony.sendKeys("1st street");
     System.out.println("colony : " + colony.getText());
     WebElement landmark = driver.findElement(By.xpath("//input[@name='landmark']"));
     landmark.sendKeys("vgp");
     System.out.println(landmark.getText());
     WebElement state = driver.findElement(By.xpath("//div[text()='State*']"));
     System.out.println(state.getText());
     WebElement st = driver.findElement(By.xpath("(//i[@class='iconfont icon-xiala '])[1]"));
     st.sendKeys("Bihar");
     st.click();
     System.out.println("state :  " + st);
     WebElement radio = driver.findElement(By.xpath(" (//input[@class='cf_radio_input___3K4Mk6FB'])[1]"));
     radio.click();
     System.out.println(radio.isSelected());
     String order = driver.findElement(By.xpath("//div[text()='3. Order Summary']")).getText();
     //order summary
     System.out.println(order);
     WebElement orderfull = driver.findElement(By.xpath("//div[@class='card___1D0vp_Bt sticky_card___1D51CnBf']"));
     String full = orderfull.getText();
     System.out.println(full);
     highlight("gray",orderfull,driver);
     /*driver.findElement(By.xpath(""));
    driver.findElement(By.xpath(""));
     driver.findElement(By.xpath(""));
     driver.findElement(By.xpath(""));
     driver.findElement(By.xpath(""));*/
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
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
