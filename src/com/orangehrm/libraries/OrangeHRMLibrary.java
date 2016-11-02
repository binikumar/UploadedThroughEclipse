package com.orangehrm.libraries;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class OrangeHRMLibrary {
	
	public static WebDriver driver;
	public static String url="http://orangehrm.qedgetech.com";
    public static String uid="Admin";
    public static String pwd="admin";
    public static String fname="BINIT";
    public static String lname="KUMAR";
    public static String empName="BINIT KUMAR";
    public static String userName="JIMMY";
    public static String pswd="12345";
    public static String pswd1="12345";
    public static String user1Name="JIMMY";
    public static String userPswd="12345";
    public static String Expval,Actval;
  	public void launchapp(String url)
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Assert.assertTrue(driver.findElement(By.id("btnLogin")).isDisplayed(),"Browser not launched successfully");
		
	}
	public void adminlogin(String uid,String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uid);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	    driver.findElement(By.id("btnLogin")).click();
	
	    Assert.assertTrue(driver.findElement(By.partialLinkText("Welcome Admin")).isDisplayed(),"Login not successful");
	
	}
	public void logout()
	{
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.partialLinkText("Logout")).click();	
    }
	public void closeapp()
	{
		driver.close();
	}
	public void empres(String fnmae,String lname)
	{
	driver.findElement(By.linkText("PIM")).click();
	driver.findElement(By.id("menu_pim_addEmployee")).click();
	driver.findElement(By.id("firstName")).sendKeys(fnmae);
	driver.findElement(By.id("lastName")).sendKeys(lname);
	driver.findElement(By.id("btnSave")).click();
	Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='profile-pic']/h1")).isDisplayed(),"Employee didnt added");
	}
	public void NewUser(String empName,String userName,String pswd,String pswd1)
	
	{
		
		boolean flag=false;
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.linkText("Users")).click();
		//driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empName);
		driver.findElement(By.id("systemUser_userName")).sendKeys(userName);
		driver.findElement(By.id("systemUser_password")).sendKeys(pswd);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pswd1);
		driver.findElement(By.id("btnSave")).click();
	java.util.List<WebElement>	rows=driver.findElements(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr"));
		for (int i = 0; i < rows.size(); i++) 
		{
			java.util.List<WebElement> cells=rows.get(i).findElements(By.tagName("td"));
			Actval=cells.get(1).getText();
			if(Expval.equalsIgnoreCase(Actval))
			{
				flag=true;
				break;
			}
			
		}
			Assert.assertEquals(Actval, Expval, "User Registration Failed");
		}

		
	
	
	public void user_login(String user1Name,String userPswd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(user1Name);
		driver.findElement(By.id("txtPassword")).sendKeys(userPswd);
		//driver.findElement(By.linkText("LOGIN")).click();
		driver.findElement(By.id("btnLogin")).click();
	}




}
	
	

