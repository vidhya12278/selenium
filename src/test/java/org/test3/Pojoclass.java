package org.test3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojoclass extends Newpara{

   public Pojoclass(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	
   @FindBy(xpath="//input[@id='inputValEnter']")
   private WebElement search;
   
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement sign;
	
	@FindBy(xpath="//a[text()='login']")
	private WebElement login;

	@FindBy(xpath="//input[@id='userName']")
	private WebElement name;
	
	@FindBy(xpath="(//button[text()='continue'])[1]")
    private WebElement con;	

	public  void sign() {
		search.sendKeys("girls watch");
		/*sign.click();
		login.click();*/

	}
	
	/*public void second() {
		driver.switchTo().frame("loginIframe");
		

	}*/
	
}
