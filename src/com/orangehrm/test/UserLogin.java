package com.orangehrm.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.libraries.OrangeHRMLibrary;

public class UserLogin {
	OrangeHRMLibrary hrm=new OrangeHRMLibrary();
	@BeforeMethod
	public void user_init()
	{
		hrm.launchapp(hrm.url);
	}
	@Test
	public void userlogin() 
	{
	hrm.user_login(hrm.user1Name, hrm.userPswd);
	}
	@AfterMethod
	public void user_logEnd()
	{
		hrm.logout();
		hrm.closeapp();
	}
	}








