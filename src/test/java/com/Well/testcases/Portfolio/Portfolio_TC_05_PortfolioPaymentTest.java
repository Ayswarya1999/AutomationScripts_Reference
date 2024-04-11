package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_05_PortfolioPaymentTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_04_SignAndSubscribePortfolioTest.Portfolio_TC_04_01_SubscribePortfolio" })
	@Parameters({ "SheetName","rowNum","Country","ProjectType","API","Commodity" })
	public void Portfolio_TC_05_PortfolioPayment(String SheetName,int rowNum,String Country, String ProjectType, String API, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"WELL At Scale Card Payment Functionality");

		try {
			if (API.equalsIgnoreCase("true")) {
				commonAPI.BillingProject(SheetName, rowNum, Country, ProjectType, Commodity);
		} 
			 if (ProjectType.contains("pilot")) {
				 commonAPI.V2ToV2pilotPortfolio(SheetName, rowNum);	
		} 
			 if (API.equalsIgnoreCase("false")) {
				 portfolio.PortfolioClickOnBilling();
					rc.Billing(SheetName, rowNum);	
			} 
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
}
