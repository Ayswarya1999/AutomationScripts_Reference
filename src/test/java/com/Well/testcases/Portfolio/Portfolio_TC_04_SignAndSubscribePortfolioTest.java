package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_04_SignAndSubscribePortfolioTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_03_SearchPortfolioByIdTest.Portfolio_TC_03_SearchPortfolioById" })
	@Parameters({ "SheetName","rowNum", "ProjectType","API","Commodity"})
	public void Portfolio_TC_04_00_SignAgreementPortfolio(String SheetName,int rowNum, String ProjectType, String API, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Portfolio Agreement Sign Functionality");
			try {
				if (API.equalsIgnoreCase("true")) {
					commonAPI.SignAgreementProject(SheetName, rowNum, Commodity);
			} 
				else {
					portfolio.SignAgreementPortfolio(SheetName, rowNum);
				}
				
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_04_SignAndSubscribePortfolioTest.Portfolio_TC_04_00_SignAgreementPortfolio" })
	@Parameters({ "SheetName","rowNum","Country","ProjectType","API","Commodity"})
	public void Portfolio_TC_04_01_SubscribePortfolio(String SheetName,int rowNum,String Country,String ProjectType, String API, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"WELL At Scale Subscribe Functionality");

		try {
			if (API.equalsIgnoreCase("true")) {
				commonAPI.RegisterProject(SheetName, rowNum, Country, ProjectType, Commodity);	
		} 
			else {
				portfolio.SubscribePortfolio(SheetName, rowNum);
			}
			
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
