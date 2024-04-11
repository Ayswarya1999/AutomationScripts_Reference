package com.Well.testcases.Community;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;


public class Community_TC_02_RegisterTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.login.TC_01_LoginTest.TC_01_Login" })
	@Parameters({ "SheetName","rowNum","Country" })
	public void Community_TC_02_Register(String SheetName,int rowNum, String Country) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register Well Community Functionality");
		try {
			
			community.RegisterCommunity(SheetName, rowNum, Country);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
