package com.chiselon.colourclassifieds.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.chiselon.colourclassifieds.uiTest.Login_Excel;
import com.chiselon.colourclassifieds.utilites.BaseUtil;

public class Delete_adv extends BaseUtil 
{
	@Test
	public void deleteAdv() throws Exception
	{
		String filepath="E:\\chiselon\\workspace_24-jan-2018\\colourclassifieds\\TestData.xlsx";
		BaseUtil.excel(filepath, "sheet1");
		String Delete_Adv_xpath = sheet.getRow(38).getCell(1).toString();	
		String yesIdo_xpath = sheet.getRow(40).getCell(1).toString();
		
		
		
		Login_Excel.login();
		BaseUtil.click(driver, Delete_Adv_xpath);
		
		
		 List<WebElement> x = driver.findElements(By.xpath("(//table[@class='special']//td)"));
		 int size = x.size();
		 for(int i=1 ; i<=size ; i++)
		 {
			 String text = driver.findElement(By.xpath("(//table[@class='special']//td)["+i+"]")).getText();
			// System.out.println(text);
			 if(text.trim().equalsIgnoreCase("Indian Road Master"))
			 {
				 BaseUtil.click(driver, "(((//table[@class='special']//td)["+i+"]))/following::td[1]/a[6]");
				 BaseUtil.click(driver, yesIdo_xpath);
				 String delete_msg = driver.findElement(By.xpath("(//p)[3]")).getText();
				 System.out.println(delete_msg);
				 System.out.println("adv is deleted sucessfully");
				 break;
			 }
			 
			 else
			 {
				 
				 System.out.println("Adv not found");
			 
			 }
		 }
		 
		
	}
}





