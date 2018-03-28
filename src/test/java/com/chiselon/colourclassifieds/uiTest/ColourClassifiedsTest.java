package com.chiselon.colourclassifieds.uiTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.chiselon.colourclassifieds.pages.RegistrationPage;
import com.chiselon.colourclassifieds.pages.latestadpage;
import com.chiselon.colourclassifieds.utilites.Base;

public class ColourClassifiedsTest
	{
	public List<WebElement> col1;
	
	WebDriver driver=Base.OpenBroswers("chrome");
	RegistrationPage register=new RegistrationPage(driver);
	latestadpage ladpage=new latestadpage(driver);
	
	@Test(priority=1)
	public void colourClassifiedsRegistration() throws Exception
	{
		register.navigateToRegisterPage();
		register.enterRegisterationFields();
		register.setHideEmailbox();
		Assert.assertEquals(register.RgstnSuccessfulValidationmsg(),"Registration successful");
	}
	
	/*
	@Test(priority=2)
	public void colourClassifiedsLogin(){
		
	}*/
	
	@Test(priority=2)
	public void latestadssize()
	{
		int size1=ladpage.latadssize();
		col1 = ladpage.adddatecolumn();
		for(int i=0;i<size1;i++)
		{
			
			System.out.println(col1.get(i).getText());
		}
	}
	
	
	

	}
