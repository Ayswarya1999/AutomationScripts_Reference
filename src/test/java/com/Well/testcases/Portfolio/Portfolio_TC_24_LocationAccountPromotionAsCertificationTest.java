package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class  Portfolio_TC_24_LocationAccountPromotionAsCertificationTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_23_LocationAccountPromotionAsAchievedTest.Portfolio_TC_23_06_ValidateAchievementTabInPortfolioAccount" })
	@Parameters({"SheetName","rowNum","Country", "ProjectType","Engagement_level","Upload","API", "Commodity","ImportLocation","ProjectName"  })
	public void Portfolio_TC_24_00_ValidateAcheivementTabAndNavigateToLocationAccount(String SheetName, int rowNum, String Country, String ProjectType, String Engagement_level,String Upload, String API, String Commodity, String ImportLocation, String ProjectName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate AcheivementTab And Navigate To Location Account");
		try {
			commonAPI.StoreAnyProject(SheetName, rowNum, Country, ProjectType, Upload, API, "Portfolio", ImportLocation, ProjectName, false);
			CommonMethod.refreshBrowser();
			portfolio.SearchPortfolioById(SheetName,rowNum);
			commonAPI.SignAgreementProject(SheetName, rowNum, Commodity);
			commonAPI.RegisterProject(SheetName, rowNum, Country, ProjectType, "Portfolio");
			commonAPI.BillingProject(SheetName, rowNum, Country, ProjectType, "Portfolio");
			CommonMethod.refreshBrowser();
			generic.importLocationGeneric(Commodity, ImportfilePortfolioLocation);
			portfolio.ValidateAcheivementTabAndNavigateToLocationAccount(SheetName, rowNum);
			
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_24_LocationAccountPromotionAsCertificationTest.Portfolio_TC_24_00_ValidateAcheivementTabAndNavigateToLocationAccount" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_24_01_BeforeValidatingPromotionInLocationAccount(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Before Validating Promotion In Location Account");
		try {
			portfolio.BeforeValidatingPromotionInLocationAccount();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_24_LocationAccountPromotionAsCertificationTest.Portfolio_TC_24_01_BeforeValidatingPromotionInLocationAccount" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_24_02_MarkAsCertificationInAdminEdit(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Mark As Acheived In AdminEdit");
		try {
			portfolio.editAdminAsCertification();
			
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_24_LocationAccountPromotionAsCertificationTest.Portfolio_TC_24_02_MarkAsCertificationInAdminEdit" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_24_03_AfterValidatingPromotionInLocationAccount(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"After Validating Promotion In LocationAccount");
		try {
			portfolio.AfterValidatingPromotion("4");
//         	hsr.validateDownloadedAchievementDocument("LocationDownloadPromotionWellTookKit", "welcome-to-well-toolkit"); 
//			hsr.validateDownloadedAchievementDocument("LocationDownloadPromotionWellBrandingGuidelines", "well-branding-guidelines");
//			hsr.validateDownloadedAchievementDocument("LocationDownloadPromotionWellStyleGuidelines", "well-branding-guidelines");
			
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_24_LocationAccountPromotionAsCertificationTest.Portfolio_TC_24_03_AfterValidatingPromotionInLocationAccount" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_24_04_AfterValidatingAchievementTabInLocationAccount(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"After Validating Promotion In LocationAccount");
		try {			
			portfolio.ValidateAcheivementTabAndCard("4");
//			hsr.validateDownloadedAchievementDocument("LocationsAchievmentDownloadLetterOfAchievement", "NA");
//			hsr.validateDownloadedAchievementDocument("LocationsAchievmentDownloadCertificate", "NA");
//			hsr.validateDownloadedAchievementDocument("LocationsAchievmentDownloadDigitalSeal", "NA");
		
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_24_LocationAccountPromotionAsCertificationTest.Portfolio_TC_24_04_AfterValidatingAchievementTabInLocationAccount" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_24_05_ValidateAchievementTabInPortfolioAccount(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate AchievementTab In Portfolio Account");
		try {
			rc.SignOut();
			login.Login();
			portfolio.SearchPortfolioById(SheetName, rowNum);	
			portfolio.ValidateAcheivementTabAndCard("3");
//			portfolio.validatePortfolioAchievementDocument("PortfolioDownloadAchievmentDocsWELLCertifiedLocations", "PortfolioDownloadedFileText", "A download link will be sent to your inbox shortly!");
//			Thread.sleep(5000);
//			portfolio.validatePortfolioAchievementDocument("PortfolioDownloadAchievmentDocsAllLettersWELLCertifiedLocations", "PortfolioDownloadedFileText", "A download link will be sent to your inbox shortly!");
			                                                                                                                                                   
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
