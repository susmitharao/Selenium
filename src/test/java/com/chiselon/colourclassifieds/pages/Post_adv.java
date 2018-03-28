package com.chiselon.colourclassifieds.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.chiselon.colourclassifieds.uiTest.Login_Excel;
import com.chiselon.colourclassifieds.utilites.BaseUtil;

public class Post_adv extends BaseUtil
{
	@Test
	public void post_adv() throws Exception
	{
		
	String filepath="E:\\chiselon\\workspace_24-jan-2018\\colourclassifieds\\TestData.xlsx";
	BaseUtil.excel(filepath, "sheet1");
	String New_Ad_xpath = sheet.getRow(22).getCell(1).toString();
	String dropdown_xpath = sheet.getRow(23).getCell(1).toString();
	String textValue = sheet.getRow(24).getCell(1).toString();
	String Title_xpath = sheet.getRow(25).getCell(1).toString();
	String Title_data = sheet.getRow(26).getCell(1).toString();
	String Description_xpath = sheet.getRow(27).getCell(1).toString();
	String Description_data = sheet.getRow(28).getCell(1).toString();
	String Register_xpath = sheet.getRow(29).getCell(1).toString();
	String Uploadpicture_xpath = sheet.getRow(30).getCell(1).toString();
	String choosefile_xpath = sheet.getRow(31).getCell(1).toString();
	String upload_xpath = sheet.getRow(34).getCell(1).toString();
	String finesh_adv_xpath = sheet.getRow(35).getCell(1).toString();
	//String image_path = sheet.getRow(32).getCell(1).toString();
	
	System.out.println(upload_xpath);
	
	
	String image_path = "E:\\chiselon\\classfields images\\abc.png";
	Login_Excel.login();
	BaseUtil.click(driver, New_Ad_xpath);
	BaseUtil.ByValue(driver, dropdown_xpath, "2");
	BaseUtil.sendKeys(driver, Title_xpath, Title_data);
	BaseUtil.sendKeys(driver, Description_xpath, Description_data);
	BaseUtil.click(driver, Register_xpath);
	BaseUtil.click(driver, Uploadpicture_xpath);
	System.out.println("upload picture is clicked after register");
	Thread.sleep(5000);
	BaseUtil.click(driver, choosefile_xpath);
	System.out.println("chose file is clicked");
	Robot r = new Robot();
	
	StringSelection stringSelection = new StringSelection(image_path);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, stringSelection);

    r.keyPress(KeyEvent.VK_CONTROL);
    r.keyPress(KeyEvent.VK_V);
    r.keyRelease(KeyEvent.VK_V);
    r.keyRelease(KeyEvent.VK_CONTROL);
    r.keyPress(KeyEvent.VK_ENTER);
    r.keyRelease(KeyEvent.VK_ENTER); 
	
    Thread.sleep(3000);
    BaseUtil.click(driver, upload_xpath);
    Thread.sleep(3000);
    BaseUtil.click(driver, finesh_adv_xpath);
    System.out.println("adv is posted sucessfully");
    //driver.close();
	
	
	
    
    
    
    
	}
}
