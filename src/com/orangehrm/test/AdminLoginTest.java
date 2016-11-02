package com.orangehrm.test;



import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.libraries.OrangeHRMLibrary;


public class AdminLoginTest {
	OrangeHRMLibrary hrm=new OrangeHRMLibrary();

	@BeforeMethod	
	public void adminLogin_init()
	{
	
	hrm.launchapp(hrm.url);
	
	}
	
	@Test
	public void admin_login()
	{
    hrm.adminlogin(hrm.uid, hrm.pwd);
	
	}
	@AfterMethod
	public void adminLogout_end()
	{
	
	hrm.logout();
	hrm.closeapp();
		}
	
}
