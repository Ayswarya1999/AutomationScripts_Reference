package com.Well.testcases.Portfolio;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Portfolio_USTC_03_UpsellV2projectToLocationAccountTest extends BaseClass {

	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_USTC_02_RegisterTest.Portfolio_USTC_02_02_RegisterPortfolioAccount" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_USTC_03_00_AddingExternalProjectInPortfolioLocation(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding ExternalProject In Portfolio Location Functionality");

		try {
			login.AdminLogin();
			portfolio.AdminSearch(SheetName, rowNum);
			portfolio.AddingExternalProjectInPortfolioLocation(SheetName, rowNum);
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_USTC_03_UpsellV2projectToLocationAccountTest.Portfolio_USTC_03_00_AddingExternalProjectInPortfolioLocation" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_USTC_03_01_ValidateAddedProjectInPortfolioLocationList(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Added In LocationList Functionality");

		try {
			portfolio.ValidateAddedInLocationList(SheetName, rowNum);
			
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_USTC_03_UpsellV2projectToLocationAccountTest.Portfolio_USTC_03_01_ValidateAddedProjectInPortfolioLocationList" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_USTC_03_02_ValidateBannerLinkInDashboardPortfolioAccount(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Portfolio Account Banner Link In Dashboard Functionality");

		try {
			portfolio.ValidatePortfolioAccountBannerInDashboard(SheetName, rowNum);
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_USTC_03_UpsellV2projectToLocationAccountTest.Portfolio_USTC_03_02_ValidateBannerLinkInDashboardPortfolioAccount" })
	@Parameters({ "SheetName","rowNum"})
	public void Portfolio_USTC_03_03_NavigateLocationAccountAndValidDashboardBanner(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Navigate Location Account And Validate Dashboard Banner Functionality");

		try {
			portfolio.ValidateLocationAccountBannerInDashboard(SheetName, rowNum);
			
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
