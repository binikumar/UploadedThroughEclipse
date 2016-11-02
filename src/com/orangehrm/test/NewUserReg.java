package com.orangehrm.test;

import org.testng.annotations.Test;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.libraries.OrangeHRMLibrary;

public class NewUserReg {
	OrangeHRMLibrary hrm=new OrangeHRMLibrary();
	@BeforeMethod
	public void user_init()
	{
		hrm.launchapp(hrm.url);
		hrm.adminlogin(hrm.uid,hrm.pwd);
	}
	
	@Test
	public void userRes()
	{
		hrm.NewUser(hrm.empName, hrm.userName, hrm.pswd, hrm.pswd1);
		Sleeper.sleepTightInSeconds(20);
	}
	
	@AfterMethod
	public void user_end()
	{
		hrm.logout();
		hrm.closeapp();
	}
	

}
