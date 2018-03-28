package com.chiselon.colourclassifieds.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.chiselon.colourclassifieds.utilites.BaseUtil;

public class RegistrationPage 
{
	static WebDriver driver;
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how= How.XPATH,using="//a[text()='Register']")
	private static WebElement Registerlink;
	
	@FindBy(how= How.XPATH,using="//u[contains(text(),'ColourClassifieds.com')]")
	private static WebElement CClassifiedslink;
	
	@FindBy(how=How.ID,using="email")
	private static WebElement txtEmailAddress;
	
	@FindBy(how=How.NAME,using="name")
	private static WebElement txtFullname;
	
	@FindBy(how=How.NAME,using="passwd")
	private static WebElement txtPassword;
	
	@FindBy(how=How.NAME,using="passwd2")
	private static WebElement txtConfirmPassword;
	
	@FindBy(how=How.NAME,using="emelding")
	private static WebElement CheckboxNewsletter;
	
	@FindBy(how=How.NAME,using="hide_email")
	private static WebElement CheckboxHidemail;
	
	@FindBy(how=How.NAME,using="agree_cond")
	private static WebElement Checkboxagreeconditions;

	@FindBy(how=How.NAME,using="submit")
	private static WebElement btnRegister;
	
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Registration successful')]")
	private static WebElement msgRgstnSuccessful;
	

	public void navigateToRegisterPage() throws Exception
	{
	
		driver.get(BaseUtil.excel("sheet1",1, 1));
		Registerlink.click();
		
	}
	
	public void enterRegisterationFields() throws Exception
	{
		txtEmailAddress.sendKeys(BaseUtil.excel("sheet1",5, 1));
		txtFullname.sendKeys(BaseUtil.excel("sheet1",7, 1));
		txtPassword.sendKeys(BaseUtil.excel("sheet1",9, 1));
		txtConfirmPassword.sendKeys(BaseUtil.excel("sheet1",11, 1));
	}
	
	public void setHideEmailbox()
	{
		Checkboxagreeconditions.click();
		btnRegister.click();
		
	}
	
	public String RgstnSuccessfulValidationmsg()
	{
		return msgRgstnSuccessful.getText();
		
	}
}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
