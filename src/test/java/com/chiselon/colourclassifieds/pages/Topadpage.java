package com.chiselon.colourclassifieds.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Topadpage
{
	static WebDriver driver;
	public Topadpage(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how= How.XPATH,using="//a[contains(text(),'Top ads')")
	private static WebElement Topadlink;
	
	@FindBy(how= How.XPATH,using="//a[contains(@href,'detail.php')]")
	private static WebElement Firstlatestad;
	
	public void setHideEmailbox()
	{
		Topadlink.click();
		
		
	}
}
