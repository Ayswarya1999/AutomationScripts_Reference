package com.Well.testcases.Portfolio;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class Portfolio_USTC_04_UpsellV2PilotProjectToPortfolioAccountTest extends BaseClass {

	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = {  "com.Well.testcases.Portfolio.Portfolio_USTC_03_UpsellV2projectToLocationAccountTest.Portfolio_USTC_03_03_NavigateLocationAccountAndValidDashboardBanner"  })
	@Parameters({ "SheetName","rowNum","Country", "ProjectType","Engagement_level","Upload","API", "Commodity","ImportLocation","ProjectName","Type" })
	public void Portfolio_USTC_04_00_RegisterV2Project(String SheetName, int rowNum, String Country, String ProjectType, String Engagement_level,String Upload, String API, String Commodity, String ImportLocation, String ProjectName, String Type) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Register V2Pilot Project Functionality");

		try {
			Boolean ProType;
			if(Type.equalsIgnoreCase("WELLCore")) {
				ProType =true;
			}
			else {
				ProType =false;
			}
			SheetName = "V2Project";
			rc.SignOut();
			String Username = data.getCellData("Login", "UserName", 6);
			String Password = data.getCellData("Login", "Password", 6);
			login.commonLogin(Username,Password);
			commonAPI.StoreAnyProject(SheetName, rowNum, Country, "v2-pilot", Upload, API, "SingleAsset",ImportLocation, "Automation V2Project Pilot Upsell V2project", ProType);
			commonAPI.SignAgreementProject(SheetName, rowNum,  "SingleAsset");
			commonAPI.RegisterProject(SheetName, rowNum, Country, "v2-pilot", "SingleAsset");
			commonAPI.BillingProject(SheetName, rowNum, Country, "v2-pilot", "SingleAsset");
			CommonMethod.refreshBrowser();
			v2project.SearchV2ProjectById(SheetName, rowNum);	
			commonAPI.DatePickerAPI(SheetName, rowNum);
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = {  "com.Well.testcases.Portfolio.Portfolio_USTC_04_00_RegisterV2Project.Portfolio_USTC_04_00_RegisterV2Project"  })
	@Parameters({ "SheetName","rowNum","Country", "ProjectType","Engagement_level","Upload","API", "Commodity","ImportLocation","ProjectName" })
	public void Portfolio_USTC_04_01_RegisterPortfolioAccount(String SheetName, int rowNum, String Country, String ProjectType, String Engagement_level,String Upload, String API, String Commodity, String ImportLocation, String ProjectName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");

		try {
			rc.SignOut();
			login.Login();
			commonAPI.StoreAnyProject(SheetName, rowNum, Country, ProjectType, Upload, API, "Portfolio",ImportLocation, "Automation V2Pilot Portfolio-UpsellV2projectToLocationAccount", false);
			commonAPI.SignAgreementProject(SheetName, rowNum, Commodity);
			CommonMethod.refreshBrowser();
			portfolio.SearchPortfolioById(SheetName,rowNum);
			commonAPI.RegisterProject(SheetName, rowNum, Country, ProjectType, "Portfolio");
			commonAPI.BillingProject(SheetName, rowNum, Country, ProjectType, "Portfolio");
			CommonMethod.refreshBrowser();
			generic.importLocationGeneric(Commodity, ImportfilePortfolioLocation);
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = {  "com.Well.testcases.Portfolio.Portfolio_USTC_04_00_RegisterV2Project.Portfolio_USTC_04_01_RegisterPortfolioAccount"  })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_USTC_04_02_UpsellV2PilotProjectToPortfolioAccount(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");

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
	
	
	@Test(dependsOnMethods = {  "com.Well.testcases.Portfolio.Portfolio_USTC_04_00_RegisterV2Project.Portfolio_USTC_04_02_UpsellV2PilotProjectToPortfolioAccount"  })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_USTC_04_03_ValidateAddedLocationInLocationList(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");

		try {
			portfolio.ValidateAddedInLocationList(SheetName, rowNum);
			portfolio.getLocationVersionId();
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	
	@Test(dependsOnMethods = {  "com.Well.testcases.Portfolio.Portfolio_USTC_04_00_RegisterV2Project.Portfolio_USTC_04_03_ValidateAddedLocationInLocationList"  })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_USTC_04_04_HSROptnLocationAccount() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Scorecard page in HSR Optn LocationAccount Functionality");

		try {
			portfolio.upsellHSROptnLocationAccount();
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {  "com.Well.testcases.Portfolio.Portfolio_USTC_04_00_RegisterV2Project.Portfolio_USTC_04_04_HSROptnLocationAccount"  })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_USTC_04_05_V2AssignedTask(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Scorecard page in HSR Optn LocationAccount Functionality");

		try {
			SheetName = "V2Project";
			rc.SignOut(); 	
			String Username = data.getCellData("Login", "UserName", 6);
			String Password = data.getCellData("Login", "Password", 6);
			login.commonLogin(Username,Password);
			v2project.SearchV2ProjectById(SheetName, rowNum);
			portfolio.assignedTaskNavigate(true);
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {  "com.Well.testcases.Portfolio.Portfolio_USTC_04_00_RegisterV2Project.Portfolio_USTC_04_05_V2AssignedTask"  })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_USTC_04_06_HsrAssignedTask() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Scorecard page in HSR Optn LocationAccount Functionality");

		try {
			portfolio.assignedTaskNavigate(false);
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
