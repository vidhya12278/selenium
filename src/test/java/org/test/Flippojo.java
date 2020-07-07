package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flippojo extends Task1 {
	public Flippojo() {
		
PageFactory.initElements(d,this);
	}
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement   email;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement  password;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}
	
	
}
