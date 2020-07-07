package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

public class Full {
	public static  WebDriver driver  ;
	 static JavascriptExecutor j;
	 Date d;
	 @BeforeClass(groups="bonding")
	 @Parameters({"brow"})
	 
	 @Test(priority=1)
	 public void launch(String s1) {
	 String operaDriver="C:\\Testng\\newie3.4.0\\operadriver.exe";
	 System.setProperty("webdriver.opera.driver",operaDriver);
 	 driver = new OperaDriver();
 	 driver.get("https://www.snapdeal.com/");
 	 driver.manage().window().maximize();
 	 long t = Thread.currentThread().getId();
	 System.out.println(t + s1);
	}
	 @BeforeMethod
	 public void start() {
	 d=new Date();
	 System.out.println("start execution time: " +d);

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
		Thread.sleep(8000);
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
		    TakesScreenshot t6=(TakesScreenshot)driver;
			File src6 = t6.getScreenshotAs(OutputType.FILE);
			File dec6 = new File("C:\\Testng\\screenshots\\RegistrationDetails.jpg");
			FileUtils.copyFile(src6,dec6);
			Thread.sleep(2000);
	}
     @Test(groups="bonding",priority=6)
	 public void javascript() throws InterruptedException
     {
	      Thread.sleep(2000);
	      driver.navigate().refresh();
		  WebElement pro1 = driver.findElement(By.xpath("//h2[text()='TRENDING PRODUCTS']"));
		  j=(JavascriptExecutor)driver;
		  j.executeScript("arguments[0].setAttribute('style','background:red');", pro1);
	 }
	  @Test(groups="bonding",priority=24)
	  public  void powerbank() throws IOException, InterruptedException 
	  {
	       Thread.sleep(8000);
	       WebElement search1 = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
	       Thread.sleep(1000);
	       search1.clear();
		   search1.sendKeys("power bank");
		   System.out.println("print send key passed: " + search1.getAttribute("value"));
		   driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-search-under-catagory lfloat']")).click();
		   WebElement power = driver.findElement(By.xpath("//p[@title='VEGER W1059 Slim Body 10000 -mAh Li-Polymer Power Bank Black']"));
	       System.out.println(" product title : " + power.getText());
		   power.click();
		   Thread.sleep(1000);
		   WebElement price = driver.findElement(By.xpath("//span[text()='Rs.  537']"));
		   System.out.println(" product  price : " + price.getText());
			  TakesScreenshot t=(TakesScreenshot)driver;
			  File src = t.getScreenshotAs(OutputType.FILE);
			  File dec = new File("C:\\Testng\\screenshots\\powerbank.jpg");
			  FileUtils.copyFile(src,dec);
	     }
       @Test(groups="bonding",priority=27)
	   public void windows() throws InterruptedException, IOException 
       {
			Thread.sleep(3000);
			String s1=driver.getWindowHandle();
			Set<String> s2 = driver.getWindowHandles();
			for (String s : s2) 
			{
				if(!s1.equals(s))
				{
					driver.switchTo().window(s);
				}
				
			}
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement click = driver.findElement(By.xpath("//span[text()='add to cart']"));
			js.executeScript("arguments[0].click()",click);
			Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='View Cart']")).click();
            Thread.sleep(2000);
            WebElement pin = driver.findElement(By.xpath("//input[@id='pincode-value']"));
            pin.sendKeys("600115");
            System.out.println("print pinc code that you given : " + pin.getAttribute("value"));
            driver.findElement(By.xpath("//span[text()='Show Details']")).click();
              TakesScreenshot t1=(TakesScreenshot)driver;
			  File src1= t1.getScreenshotAs(OutputType.FILE);
			  File dec1 = new File("C:\\Testng\\screenshots\\viewchart.jpg");
			  FileUtils.copyFile(src1,dec1);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@class='btn btn-xl rippleWhite cart-button']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("latha");
               TakesScreenshot t2=(TakesScreenshot)driver;
			   File src2= t2.getScreenshotAs(OutputType.FILE);
			   File dec2 = new File("C:\\Testng\\screenshots\\paymentcart.jpg");
			   FileUtils.copyFile(src2,dec2);
	     }
	   @Test(groups="bonding",priority=29)
	   public void aboutsnapdeal() throws InterruptedException, IOException 
	   {
		    Thread.sleep(8000);
		    driver.navigate().refresh();
		    driver.get("https://www.snapdeal.com/");
		    Thread.sleep(1000);
		    WebElement d = driver.findElement(By.xpath("//div[text()='Copyright © 2020, Snapdeal Private Limited (formerly Jasper Infotech Private Limited). All Rights Reserved']"));
		    j.executeScript("arguments[0].scrollIntoView(true)", d);
		    Thread.sleep(1000);
		    String about = driver.findElement(By.xpath("//p[text()='About Snapdeal']")).getText();
		    System.out.println("print line : " + about);
		    Thread.sleep(1000);
		    WebElement prol = driver.findElement(By.xpath("//div[contains(text(),'About Snapdeal – India’s Ultimate Online Shopping Site ')]"));
		    System.out.println(prol.getText());
		    Thread.sleep(2000);
		    change("green",prol,driver);
		       TakesScreenshot t2=(TakesScreenshot)driver;
		       File src2= t2.getScreenshotAs(OutputType.FILE);
		       File dec2 = new File("C:\\Testng\\screenshots\\about snapdeal.jpg");
		       FileUtils.copyFile(src2,dec2);
	 }
	 @Parameters({"str","web","dr"})
     @Test
	 public static void change(String s1, WebElement s2, WebDriver driver2)
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
	@Test(groups="bonding",priority=32)
	public void giftcard() throws InterruptedException 
	{
		 Thread.sleep(3000);
		 WebElement up = driver.findElement(By.xpath("//span[@class='topHooks fastestDel lfloat fastestDelivery']"));
	     j.executeScript("arguments[0].scrollIntoView(false)",up);
	     System.out.println("print line : " + up.getText());
		 Thread.sleep(1000);
		 WebElement click = driver.findElement(By.xpath("//a[text()='Gift Cards']"));
		 j=(JavascriptExecutor)driver;
		 j.executeScript("arguments[0].click()", click);
		 Thread.sleep(3000);
		 WebElement down = driver.findElement(By.xpath("//div[text()='Copyright © 2020, Snapdeal Private Limited (formerly Jasper Infotech Private Limited). All Rights Reserved']"));
		 j.executeScript("arguments[0].scrollIntoView(true)",down );
		 WebElement made = driver.findElement(By.xpath("//div[@class='rfloat heartLine']"));
		 System.out.println("print line : " + made.getText());
	 }
    @Test(groups="bonding",priority=17,invocationCount=3,dataProvider="search")
	public void search(String s) throws InterruptedException 
    {
	    Thread.sleep(1000);
		WebElement search1 = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
	    search1.clear();
		search1.sendKeys(s);
	    Thread.sleep(2000);
		System.out.println("print search line 3 times:" + search1.getAttribute("value"));
	 }
	 @DataProvider(name="search")
	 public Object[][]data()
	 {
       return new Object[][]
			{
			{"sunglasses"},
				{"sling bag"}
				};
	 }
	 @Parameters({"search"})
	 @Test(groups="bonding",priority=18)
	 public  void checkingoffers(String d) throws IOException
	 {
	    driver.findElement(By.xpath("//span[text()='Mobile & Tablets']")).click();
        driver.findElement(By.xpath("//span[text()='Mobile Phones']")).getAttribute("value");
        driver.findElement(By.xpath("//span[text()='Smartphones']")).click();
           TakesScreenshot t=(TakesScreenshot)driver;
		   File src = t.getScreenshotAs(OutputType.FILE);
		   File dec = new File("C:\\Testng\\screenshots\\smartphone.jpg");
		   FileUtils.copyFile(src,dec);
        WebElement search = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
        search.sendKeys(d);
        System.out.println("print send keys value :....... " + search.getAttribute("value"));
        driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-search-under-catagory lfloat']")).click();
        driver.navigate().to("https://www.snapdeal.com/");
	 }
	 @Test(groups="bonding",priority=34)
     public void sellonsnapdeal() throws IOException, InterruptedException 
	 {
	    driver.navigate().back();
	    driver.navigate().refresh();
	    //click sell on page
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//a[text()='Sell On Snapdeal']")).click();
	         //print how line
	    String how = driver.findElement(By.xpath("//h1[text()='How it is simple to sell on Snapdeal']")).getText();
	    Thread.sleep(200);
	    System.out.println(how);
	         //print rule 1
	    WebElement step1 = driver.findElement(By.xpath("(//div[@class='col-md-5 sellingText'])[1]"));
	    System.out.println("print rules to sell on snapdeal");
	    j.executeScript("arguments[0].scrollIntoView(true)",step1);
	    System.out.println(step1.getText());
	    //change1("pink",step1,driver);
	  		 //print rule 2
		WebElement step2 = driver.findElement(By.xpath("//div[@class='col-md-5 sellingText text-right bottomDiv pull-right'][1]"));
		System.out.println(step2.getText());
		j.executeScript("arguments[0].scrollIntoView(true)",step2);
		 change1("pink",step1,driver);
		change1("yellow",step2,driver);
		    TakesScreenshot t=(TakesScreenshot)driver;
			File src1 = t.getScreenshotAs(OutputType.FILE);
			File dec1 = new File("C:\\Testng\\screenshots\\step12.jpg");
			FileUtils.copyFile(src1,dec1);
			Thread.sleep(2000);
			 //print rule 3
		 WebElement step3 = driver.findElement(By.xpath("(//div[@class='col-md-5 sellingText'])[2]"));
		 System.out.println(step3.getText());
		 j.executeScript("arguments[0].scrollIntoView(true)",step3);
		 //change1("violet",step3,driver);
		     //print rule 4
		 WebElement step4 = driver.findElement(By.xpath("(//div[@class='col-md-5 sellingText text-right bottomDiv2 pull-right'])[1]"));
		 System.out.println(step4.getText());
		 j.executeScript("arguments[0].scrollIntoView(true)",step4);
		 change1("violet",step3,driver);
		 change1("black",step4,driver);
		    TakesScreenshot t3=(TakesScreenshot)driver;
			File src3 = t.getScreenshotAs(OutputType.FILE);
			File dec3= new File("C:\\Testng\\screenshots\\step34.jpg");
			FileUtils.copyFile(src3,dec3);
			Thread.sleep(2000);
			 //print starts line
		  WebElement starts = driver.findElement(By.xpath("//div[text()='Start your business with Snapdeal & reach customers across India']"));
		  System.out.println("print the line :" + starts.getText());
		  change1("blue",starts,driver);
		      TakesScreenshot t41=(TakesScreenshot)driver;
	          File src41 = t.getScreenshotAs(OutputType.FILE);
		      File dec41 = new File("C:\\Testng\\screenshots\\starts.jpg");
		      FileUtils.copyFile(src41,dec41);
		  Thread.sleep(2000);
	      driver.findElement(By.xpath("//a[text()='START SELLING NOW']")).click();
          driver.findElement(By.xpath("//div[@id='sntch_button']")).click();
		  Thread.sleep(2000);
		      TakesScreenshot t6=(TakesScreenshot)driver;
			  File src6 = t.getScreenshotAs(OutputType.FILE);
			  File dec6 = new File("C:\\Testng\\screenshots\\chat.jpg");
		      FileUtils.copyFile(src6,dec6);
		   Thread.sleep(2000);
		   driver.switchTo().frame("sntch_iframe");
		   String chat = driver.findElement(By.xpath("//p[contains(text(),'Hi. Welcome to')]")).getText();
		   String time = driver.findElement(By.xpath("//p[@class='ng-star-inserted']")).getText();
		   System.out.println("chat\n");
		   System.out.println("message " + chat +time);
		   WebElement clicks = driver.findElement(By.xpath("//div[@class='chat__form-btns']"));
		   j.executeScript("arguments[0].click()",clicks);
		        TakesScreenshot t5=(TakesScreenshot)driver;
				File src5 = t.getScreenshotAs(OutputType.FILE);
				File dec5 = new File("C:\\Testng\\screenshots\\menu.jpg");
				FileUtils.copyFile(src5,dec5);
		    Thread.sleep(2000);
		}
	  @Parameters({"str","web","dr"})
	  @Test
	  public static void change1(String s1, WebElement step1, WebDriver driver2) 
	  {
		j.executeScript("arguments[0].style.backgroundColor='"+s1+"'",step1);
	    try
		{
		Thread.sleep(8000);
		}
	    catch(Exception e)
		{
		}
		}
	  @Test(groups="bonding",priority=35)
	  public void helpcenter() throws IOException, InterruptedException 
	  {
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Help Center']")).click();
		Thread.sleep(2000);
		String helpcenter = driver.findElement(By.xpath("//span[text()='     Help Center ']")).getText();
		System.out.println(helpcenter);
		String how = driver.findElement(By.xpath("//div[@class='row banner_text']")).getText();
		System.out.println(how);
		WebElement top = driver.findElement(By.xpath("//div[@id='quearies']"));
		System.out.println(top.getText());
		change1("orange",top,driver);
		  TakesScreenshot t5=(TakesScreenshot)driver;
			File src5 = t5.getScreenshotAs(OutputType.FILE);
			File dec5 = new File("C:\\Testng\\screenshots\\queries.jpg");
			FileUtils.copyFile(src5,dec5);
	    driver.findElement(By.xpath("//a[contains(text(),'What are the different')]")).click();
		WebElement payment = driver.findElement(By.xpath("//div[@class='col-xs-offset-3 col-xs-18']"));
		change1("purple",payment,driver);
		System.out.println(payment.getText());
		WebElement query = driver.findElement(By.xpath("//div[@id='quearies']"));
		change1("gray",query,driver);
		System.out.println(query.getText());
		 TakesScreenshot t51=(TakesScreenshot)driver;
			File src51 = t51.getScreenshotAs(OutputType.FILE);
			File dec51 = new File("C:\\Testng\\screenshots\\query.jpg");
			FileUtils.copyFile(src51,dec51);
		WebElement still = driver.findElement(By.xpath("//div[contains(text(),'Still need help?')]"));
		System.out.println(still.getText());
		change1("black",still,driver);
 	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    driver.findElement(By.xpath("//div[@id='tabHeader_nonOrder']")).click();
	    WebElement issues = driver.findElement(By.xpath("//div[@class='row panal']"));
	    driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-expand-arrow'])[2]")).click();
	    change1("gold",issues,driver);
	    System.out.println(issues.getText());
     	    TakesScreenshot t52=(TakesScreenshot)driver;
	    	File src52 = t52.getScreenshotAs(OutputType.FILE);
		    File dec52 = new File("C:\\Testng\\screenshots\\issues.jpg");
		    FileUtils.copyFile(src52,dec52);
		WebElement num = driver.findElement(By.xpath("//h1[@class='col-xs-24 clearfix']"));
		System.out.println(num.getText());
		String mail = driver.findElement(By.xpath("//h1[@class='col-xs-24']")).getText();
		System.out.println(mail);
	    }
	  @Parameters({"sub"})
	  @Test(priority=37,groups="bonding")
	  public void subscribe(String f) throws InterruptedException, AWTException, IOException 
	  {
		driver.navigate().refresh();
		driver.navigate().to("https://www.snapdeal.com/");
		System.out.println("subscribe.............................");
		WebElement mail = driver.findElement(By.xpath("(//input[@name='keyword'])[3]"));
		mail.sendKeys(f);
		System.out.println(mail.getText());
		driver.findElement(By.xpath("//button[text()='Subscribe']")).click();
		Thread.sleep(1000);
		WebElement success = driver.findElement(By.xpath("//div[@class='sucessfulSubscribe']"));
		//System.out.println(success);
		
		Actions a=new Actions(driver);
		a.doubleClick(success).perform();
		a.contextClick(success).perform();
		
		Robot r=new Robot();
		for (int i = 0; i <3; i++) 
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		TakesScreenshot t52=(TakesScreenshot)driver;
    	File src52 = t52.getScreenshotAs(OutputType.FILE);
	    File dec52 = new File("C:\\Testng\\screenshots\\printpage.jpg");
	    FileUtils.copyFile(src52,dec52);
		
		
		
		
		
		
		
	}
	}
	     
	     
	

