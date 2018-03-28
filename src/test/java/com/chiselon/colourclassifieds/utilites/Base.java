package com.chiselon.colourclassifieds.utilites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

 static WebDriver driver;	
	public static WebDriver OpenBroswers(String broswer) 
	{
		System.out.println("------------------");
		try 
		{
			if (broswer.trim().equalsIgnoreCase("chrome")) 
			{
				System.setProperty("webdriver.chrome.driver","Driver\\chromedriver.exe");
				driver = new ChromeDriver();

			}
			else if (broswer.trim().equalsIgnoreCase("Firefox")) 
			{
				driver = new FirefoxDriver();
			}
			else 
			{
				System.setProperty("webdriver.ie.driver","Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		}
		catch (Exception e)
		{
			System.out.println("Error found boswer not valid---> " + e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}
	

}
