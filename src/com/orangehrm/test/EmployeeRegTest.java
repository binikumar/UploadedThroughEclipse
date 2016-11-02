package com.orangehrm.test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.libraries.OrangeHRMLibrary;

public class EmployeeRegTest {

	OrangeHRMLibrary hrm=new OrangeHRMLibrary();
		@BeforeMethod
		public void res_init()
		{
			hrm.launchapp(hrm.url);
			hrm.adminlogin(hrm.uid,hrm.pwd);
		}
		@Test
		public void emp_res()
		{ 
			hrm.empres(hrm.fname,hrm.lname);
		}

		@AfterMethod
		public void emp_end()
		{   hrm.logout();
			hrm.closeapp();
		}




}
