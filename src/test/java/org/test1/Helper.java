package org.test1;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Helper {
	public static WebDriver d;
	Date p;

public static  WebDriver launch() {
System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver.exe");
d = new ChromeDriver();
d.manage().window().maximize();
d.get("https://www.facebook.com/");
//d.get("https://www.flipkart.com/account/login");
//d.get("https://mail.google.com/");
return d;
}
	
}
