package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class Portfolio_USTC_02_RegisterTest extends BaseClass {
	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = {  "com.Well.testcases.login.TC_01_LoginTest.TC_01_Login"  })
	@Parameters({ "SheetName","rowNum","Country", "ProjectType","Engagement_level","Upload","API", "Commodity","ImportLocation","ProjectName","Type" })
	public void Portfolio_USTC_02_00_RegisterV2Project(String SheetName, int rowNum, String Country, String ProjectType, String Engagement_level,String Upload, String API, String Commodity, String ImportLocation, String ProjectName, String Type) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");

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
			commonAPI.StoreAnyProject(SheetName, rowNum, Country, ProjectType, Upload, API, "SingleAsset",ImportLocation, "Automation V2 Upsell V2project", ProType);
			commonAPI.SignAgreementProject(SheetName, rowNum,  "SingleAsset");
			commonAPI.RegisterProject(SheetName, rowNum, Country, ProjectType, "SingleAsset");
			commonAPI.BillingProject(SheetName, rowNum, Country, ProjectType, "SingleAsset");
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
	

	@Test(dependsOnMethods = {  "com.Well.testcases.Portfolio.Portfolio_USTC_02_RegisterTest.Portfolio_USTC_02_00_RegisterV2Project"  })
	@Parameters({ "SheetName","rowNum","Country", "ProjectType","Engagement_level","Upload","API", "Commodity","ImportLocation" })
	public void Portfolio_USTC_02_01_UploadDocumentInV2ProjectScorecard(String SheetName, int rowNum, String Country, String ProjectType, String Engagement_level,String Upload, String API, String Commodity, String ImportLocation) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL V2Project Build and Upload Scorecard document Functionality");
		try {
			SheetName = "V2Project";
			v2project.BuildScorecardV2ProjectById(SheetName, rowNum);
			v2project.CommonUploadScorecardDocument("Meet Thresholds for Particulate Matter", SheetName, rowNum, "SingleAsset" ,FeaturefileUpload ,false,false,false,false);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = {  "com.Well.testcases.Portfolio.Portfolio_USTC_02_RegisterTest.Portfolio_USTC_02_01_UploadDocumentInV2ProjectScorecard"  })
	@Parameters({ "SheetName","rowNum","Country", "ProjectType","Engagement_level","Upload","API", "Commodity","ImportLocation","ProjectName" })
	public void Portfolio_USTC_02_02_RegisterPortfolioAccount(String SheetName, int rowNum, String Country, String ProjectType, String Engagement_level,String Upload, String API, String Commodity, String ImportLocation, String ProjectName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");

		try {
			rc.SignOut();
			login.Login();
			commonAPI.StoreAnyProject(SheetName, rowNum, Country, ProjectType, Upload, API, "Portfolio",ImportLocation, ProjectName, false);
			CommonMethod.refreshBrowser();
			portfolio.SearchPortfolioById(SheetName,rowNum);
			commonAPI.SignAgreementProject(SheetName, rowNum, Commodity);
			commonAPI.RegisterProject(SheetName, rowNum, Country, ProjectType, "Portfolio");
			commonAPI.BillingProject(SheetName, rowNum, Country, ProjectType, "Portfolio");
			CommonMethod.refreshBrowser();
			generic.importLocationGeneric(Commodity, ImportfilePortfolioLocation);
			rc.SignOut();
		}
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
