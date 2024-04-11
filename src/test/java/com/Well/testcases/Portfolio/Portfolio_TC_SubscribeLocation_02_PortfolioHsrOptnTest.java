package com.Well.testcases.Portfolio;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest extends BaseClass {

	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.login.TC_01_LoginTest.TC_01_Login" })
	@Parameters({  "SheetName","rowNum","Country", "ProjectType","Engagement_level","Upload","API", "Commodity","ImportLocation","ProjectName"  })
	public void Portfolio_TC_Optn_02_00_NavigateToSubscribeLocationAccount(String SheetName, int rowNum, String Country, String ProjectType, String Engagement_level,String Upload, String API, String Commodity, String ImportLocation, String ProjectName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			commonAPI.StoreAnyProject(SheetName, rowNum, Country, ProjectType, Upload, API, "Portfolio",ImportLocation,ProjectName, false);
			portfolio.SearchPortfolioById(SheetName,rowNum);
			commonAPI.SignAgreementProject(SheetName, rowNum, Commodity);
			commonAPI.RegisterProject(SheetName, rowNum, Country, ProjectType, "Portfolio");
			commonAPI.BillingProject(SheetName, rowNum, Country, ProjectType, "Portfolio");
			 if (ProjectType.contains("pilot")) {
				 commonAPI.V2ToV2pilotPortfolio(SheetName, rowNum);	
		} 
			CommonMethod.refreshBrowser();
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_Optn_02_00_NavigateToSubscribeLocationAccount" })
	@Parameters({ "SheetName", "rowNum" ,"ProjectType","Upload","API"})
	public void Portfolio_TC_02_01_AddingSingleLocBySelectingV2VersionAndValidateScorecardInAddedLocation(String SheetName, int rowNum, String ProjectType, String Upload, String API) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verify Adding Portfolio Single Location Successfully and Validate Scorecard In Added Location");

		try {
			if(ProjectType.contains("pilot")) {
			portfolio.addLocation(SheetName, rowNum, ProjectType, Upload, API);
			portfolio.getLocationVersionId();
			pfu.NavigateAddedLocation(SheetName, rowNum);
			portfolio.HSROptnLocationAccount();
			rc.ScorecardLoading();
			portfolio.SearchPortfolioById(SheetName, rowNum);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_02_01_AddingSingleLocBySelectingV2VersionAndValidateScorecardInAddedLocation" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_TC_Optn_02_02_OptnHsrLocationAccountFeatureUploadDoc(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			generic.importLocationGeneric(Commodity, ImportfilePortfolioLocation);
			portfolio.storeLocationId(SheetName, rowNum);
			pfu.NavigateAddedLocation(SheetName, rowNum);
			portfolio.HSROptnLocationAccount();
			v2project.uploadDocumentInOptnFeature("Support Handwashing", SheetName, rowNum, Commodity);
			
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_Optn_02_02_OptnHsrLocationAccountFeatureUploadDoc" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_TC_Optn_02_03_OptnHsrLocationAccountFeatureValidMultipleDoc(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			v2project.ValiateScorecardUploadDocInHSROptnLocationAccount("Improve Cleaning Practices", SheetName, rowNum, Commodity);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_Optn_02_03_OptnHsrLocationAccountFeatureValidMultipleDoc" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_Optn_02_04_OptnHsrLocationAccountFeatureDeleteDoc(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			v2project.DeleteUploadDocumentOptnInScorecardFeature("Support Handwashing");
			
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_Optn_02_04_OptnHsrLocationAccountFeatureDeleteDoc" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_TC_Optn_02_05_OptnHsrLocationAccountFeatureValidDeletedDoc(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			v2project.validDeletedUploadDocumentOptnInScorecardFeature("Improve Cleaning Practices",SheetName, rowNum, Commodity);
			
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_Optn_02_05_OptnHsrLocationAccountFeatureValidDeletedDoc" })
	@Parameters({ "SheetName", "rowNum","ProjectType" })
	public void Portfolio_TC_Optn_02_06_OptnHsrLocationAccountAuditUploadDoc(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			v2project.UploadAuditDocLocationAccOptnInsideScorecard("Reduce Respiratory Particle Exposure", ProjectType);
		
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_Optn_02_06_OptnHsrLocationAccountAuditUploadDoc" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_Optn_02_07_OptnHsrLocationAccountAlternativeUploadDoc(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			v2project.UploadAlternativeDocLocationAccOptnInsideScorecard("Develop Emergency Preparedness Plan");
			
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_Optn_02_07_OptnHsrLocationAccountAlternativeUploadDoc" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_TC_Optn_02_08_OptnHsrLocationAccountFeatureValidMultipleDoc(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			v2project.ValiateScorecardUploadDocInHSROptnLocationAccount("Assess Ventilation", SheetName, rowNum, Commodity);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_Optn_02_08_OptnHsrLocationAccountFeatureValidMultipleDoc" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_Optn_02_09_OptnHsrLocationAccountAlternativeValidMultipleDoc(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			v2project.DeleteUploadDocumentOptnInScorecardFeature("Develop Emergency Preparedness Plan");
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_Optn_02_09_OptnHsrLocationAccountAlternativeValidMultipleDoc" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_TC_Optn_02_10_OptnHsrLocationAccountAlternativeValidDeletedDoc(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			v2project.validDeletedUploadDocumentOptnInScorecardFeature("Assess Ventilation", SheetName, rowNum, Commodity);
		
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_SubscribeLocation_02_PortfolioHsrOptnTest.Portfolio_TC_Optn_02_09_OptnHsrLocationAccountAlternativeValidMultipleDoc" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void Portfolio_TC_Optn_02_11_validateRecertificationButtonInAdminField(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			   rc.SignOut();
			    login.Login();
			    portfolio.SearchPortfolioById(SheetName,rowNum);
			portfolio.validateRecertificationButtonInAdminField(SheetName,rowNum);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}