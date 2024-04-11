package com.Well.testcases.Community;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Community_TC_03_SearchListByIdTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Community.Community_TC_02_RegisterTest.Community_TC_02_Register" })
	@Parameters({"SheetName","rowNum"})
	public void Community_TC_03_SearchListById(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Search List Well Community Functionality");
		try {
			community.SearchCommunityListById(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
