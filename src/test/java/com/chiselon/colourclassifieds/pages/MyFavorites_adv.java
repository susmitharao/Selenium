package com.chiselon.colourclassifieds.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.chiselon.colourclassifieds.uiTest.Login_Excel;
import com.chiselon.colourclassifieds.utilites.BaseUtil;

public class MyFavorites_adv extends BaseUtil
{
	@Test
	public static void myFavorites_adv()
	{
		String fav_list_text = null;
	
		Login_Excel.login();
		BaseUtil.click(driver,"//a[@title='Front page']");
		int size = driver.findElements(By.xpath("((//table)[9]//tr/td/a)")).size();
		System.out.println(size);
		for(int i=1 ; i <= size ; i++)
		{
			String title_text = driver.findElement(By.xpath("((//table)[9]//tr/td/a)["+i+"]")).getText();
			System.out.println(title_text);
		
			if(title_text.equalsIgnoreCase("Project Training Classes on live..."))
			{
				driver.findElement(By.xpath(("((//table)[9]//tr/td/a)["+i+"]"))).click();
				BaseUtil.click(driver,"//u[text()='Grade']");
				
			break;
			}
		}

		String mainwindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		int size1 = handles.size();
		System.out.println(size1);
		for (String handle : handles) 
		{
			driver.switchTo().window(handle);
			//System.out.println(handle);
			String title = driver.getTitle();
			System.out.println(title);
			if(title.trim().contains("Rate this"))
			{
				driver.switchTo().window(handle);
				BaseUtil.ByVisibleText(driver, "//select[@name='grade']", "7");
				BaseUtil.click(driver,"//input[@value='Rate this']"); 
				BaseUtil.click(driver,"//a[text()='Close window']");
				driver.switchTo().window(mainwindow);
				driver.manage().window().maximize();
				BaseUtil.click(driver,"//a[contains(text(),'Add to your Favorites')]");
				Set<String> window = driver.getWindowHandles();
				//System.out.println( window.size());
				for (String fav_handling : window) 
				{
					driver.switchTo().window(fav_handling);
					String fav_title = driver.getTitle();
					System.out.println(fav_title);
					if(fav_title.contains("Favorite"))
					{
						BaseUtil.click(driver,"//a[text()='Close window']");
						driver.switchTo().window(mainwindow);
						driver.navigate().refresh();
					}
						BaseUtil.click(driver,"//img[@alt='My Favorites']");
						int fav_list_size = driver.findElements(By.xpath("((//table)[8]//tr/td/a)")).size();
						for(int j=1 ; j<=fav_list_size ; j++ )
						{
						 fav_list_text = driver.findElement(By.xpath("((//table)[8]//tr/td/a)["+j+"]")).getText();
						System.out.println("fav_list--->"+fav_list_text);

						
							if(fav_list_text.contains("Project Training Classes on live..."))
							{
								System.out.println("Favorites adv is Test passed sucessfully");
								break;
							}
							else
							{
								System.out.println("favorites adv Test Failed ");	
							}
				
							
						}
				}
				
				
				
				
			}
			
			
		}

		
	}
}
