package com.chiselon.colourclassifieds.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseUtil
{
public static WebDriver driver;
public  static FileInputStream file;
public  static Properties pro;
public  static FileInputStream file1;
public  static XSSFWorkbook workbook;
public static XSSFSheet sheet;
public static Select select;
public static String filePath="D:\\Eclipse-1.1\\pageobject model\\ColourClassifieds\\TestData.xlsx";
private static String cellValue;

public BaseUtil(WebDriver driver){
	this.driver=driver;
}
		public static void getUrl(String UrlValue)
	{	
		try
		{
		driver.get(UrlValue);
		//return driver;
		}
		catch(Exception e)
		{
		System.out.println("getUrl method failed--->"+e.getMessage());
		}
		
	}
	public static void click(WebDriver driver,String xpathValue)
	{
		try
		{
		driver.findElement(By.xpath(xpathValue)).click();
		//return driver;
		}
		catch(Exception e)
		{
		System.out.println("click method failed---->"+e.getMessage());
		}
		//return driver;
	}
	public static  WebDriver sendKeys(WebDriver driver,String xpathValue,String sendskeysData)
	{
		try
		{
		driver.findElement(By.xpath(xpathValue)).clear();
		driver.findElement(By.xpath(xpathValue)).sendKeys(sendskeysData);
		}
		catch(Exception e)
		{
		System.out.println("sendKeys method failed---->"+e.getMessage());
		}
		return driver;
		
	}
	public static void closeBroswer(WebDriver driver)
	{	
		System.out.println("---close---");
		try
		{
		driver.close();
		}
		catch(Exception e)
		{
		System.out.println("close method failed---->"+e.getMessage());
		}
		//return driver;
		
	}
	public static Properties loadProperties(String Filepath)
	{	
		try
		{
		//pro.get("properties_filepath");
		file=new FileInputStream(Filepath);
		pro=new Properties();
		pro.load(file);
		}
		catch(Exception e)
		{
		System.out.println("properties method failed---->"+e.getMessage());
		}
		return pro; //Properties pro=new Properties(); and am returning properties values for further usage
		
	}
	public static String excel(String sheetname, int Row,int Col) throws FileNotFoundException
	{
	
		
			 file1 = new FileInputStream(filePath);
			 try {
				workbook = new XSSFWorkbook(file1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 sheet = workbook.getSheet(sheetname);
			 cellValue=sheet.getRow(Row).getCell(Col).getStringCellValue();
			 return cellValue;
		
		
		
		
	}
	public static Select ByValue(WebDriver driver ,String xpathValue ,String value )
	{
		try
		{
			select = new Select(driver.findElement(By.xpath(xpathValue)));
			select.selectByValue(value);
		}
		catch (Exception e) 
		{
			System.out.println("Select byValue method failed---->"+e.getMessage());
		}
		return select;
	}
	
	public static Select ByVisibleText(WebDriver driver ,String xpathValue ,String textvalue )
	{
		try
		{
			select = new Select(driver.findElement(By.xpath(xpathValue)));
			select.selectByVisibleText(textvalue);
		}
		catch (Exception e) 
		{
			System.out.println("Select byVisibleText method failed---->"+e.getMessage());
		}
		return select;
	}
	public static Select ByIndex(WebDriver driver ,String xpathValue ,int number )
	{
		try
		{
			select = new Select(driver.findElement(By.xpath(xpathValue)));
			select.selectByIndex(number);
		}
		catch (Exception e) 
		{
			System.out.println("Select byIndex method failed---->"+e.getMessage());
		}
		return select;
	}
	public static WebDriver webElement(WebDriver driver,String xpathValue)
	{
		try
		{
			driver.findElement(By.xpath(xpathValue));
		}
		catch (Exception e) 
		{
			System.out.println("webElement method failed---->"+e.getMessage());
		}
		return driver;
	}
	public static WebDriver webElements(WebDriver driver,String xpathValue)
	{
		try
		{
			driver.findElements(By.xpath(xpathValue));
		}
		catch (Exception e) 
		{
			System.out.println("webElements method failed---->"+e.getMessage());
		}
		return driver;
	}
	
	
}
