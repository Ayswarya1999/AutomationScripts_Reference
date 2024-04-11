package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_02_RegisterPortfolioTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.login.TC_01_LoginTest.TC_01_Login" })
	@Parameters({ "SheetName","rowNum","Country", "ProjectType","Engagement_level","Upload","API", "Commodity","ImportLocation","ProjectName" })
	public void Portfolio_TC_02_RegisterPortfolio(String SheetName, int rowNum, String Country, String ProjectType, String Engagement_level,String Upload, String API, String Commodity, String ImportLocation, String ProjectName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			if (API.equalsIgnoreCase("true")) {
				commonAPI.StoreAnyProject(SheetName, rowNum, Country, ProjectType, Upload, API, Commodity, ImportLocation, ProjectName, false);		  
		} 
			else {
				portfolio.RegisterPortfolio(SheetName, rowNum, Engagement_level, Country, ProjectName);
			
			}
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
