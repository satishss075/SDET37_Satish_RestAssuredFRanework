package com.crm.genericUtilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseApiClass {
	
	public DataBaseUtility dLib=new DataBaseUtility();
	public JavaUtility jLib=new JavaUtility();
	
	
	@BeforeSuite
	public void dbConnect()
	{
		dLib.connectToDB("projects");
		
		
	}
	
	@AfterSuite
	public void CloseDb()
	{
		dLib.closeDB();
	}
	
	
	

}
