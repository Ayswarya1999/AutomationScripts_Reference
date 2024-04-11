package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class  Portfolio_TC_23_LocationAccountPromotionAsAchievedTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.login.TC_01_LoginTest.TC_01_Login"  })
	@Parameters({"SheetName","rowNum","Country", "ProjectType","Engagement_level","Upload","API", "Commodity", "ImportLocation","ProjectName" })
	public void Portfolio_TC_23_00_ValidateAcheivementTabAndNavigateToLocationAccount(String SheetName, int rowNum, String Country, String ProjectType, String Engagement_level,String Upload, String API, String Commodity, String ImportLocation, String ProjectName) throws IOException {

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
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_23_LocationAccountPromotionAsAchievedTest.Portfolio_TC_23_00_ValidateAcheivementTabAndNavigateToLocationAccount" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_23_01_BeforeValidatingPromotionInLocationAccount(String SheetName,int rowNum) throws IOException {

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
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_23_LocationAccountPromotionAsAchievedTest.Portfolio_TC_23_01_BeforeValidatingPromotionInLocationAccount" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_23_02_OptnHsrRating(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Optn Hsr Rating");
		try {
			portfolio.HSROptnLocationAccount();
			
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_23_LocationAccountPromotionAsAchievedTest.Portfolio_TC_23_02_OptnHsrRating" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_23_03_MarkAsAcheivedInAdminEdit(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Mark As Acheived In AdminEdit");
		try {
			portfolio.NavigateAddedLocation(SheetName, rowNum);
			rc.editAdminAchieveDate();
			v2project.ValidationSealAndDate();
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_23_LocationAccountPromotionAsAchievedTest.Portfolio_TC_23_03_MarkAsAcheivedInAdminEdit" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_23_04_AfterValidatingPromotionInLocationAccount(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"After Validating Promotion card count and download file In LocationAccount");
		try {
			portfolio.AfterValidatingPromotion("3");
//         	hsr.validateDownloadedAchievementDocument("LocationDownloadPromotionWellTookKit", "welcome-to-well-toolkit"); 
//			hsr.validateDownloadedAchievementDocument("LocationDownloadPromotionWellBrandingGuidelines", "well-branding-guidelines");
//			hsr.validateDownloadedAchievementDocument("LocationDownloadPromotionWellCollateral", "well-health-safety-rated-collateral");
			
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_23_LocationAccountPromotionAsAchievedTest.Portfolio_TC_23_04_AfterValidatingPromotionInLocationAccount" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_23_05_ValidateAchievementTabInLocationAccount(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"After Validating Achievement card count and download file In LocationAccount");
		try {

			portfolio.ValidateAcheivementTabAndCard("3");
//			hsr.validateDownloadedAchievementDocument("HsrDownloadAchievmentDocsRatingLetter", "Letter_of_Achievement.pdf");
//			hsr.validateDownloadedAchievementDocument("PortfolioDownloadAchievmentDocsRatingCertificate", "Health-Safety_Rating_Certificate.pdf");
//			hsr.validateDownloadedAchievementDocument("PortfolioDownloadAchievmentDocsWELLHealthSafetySeal", "NA");

			
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_23_LocationAccountPromotionAsAchievedTest.Portfolio_TC_23_05_ValidateAchievementTabInLocationAccount" })
	@Parameters({ "SheetName","rowNum" })
	public void Portfolio_TC_23_06_ValidateAchievementTabInPortfolioAccount(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"After Validating Achievement card count and download file In Portfolio Account");
		try {
			rc.SignOut(); 
			login.Login();
			portfolio.SearchPortfolioById(SheetName, rowNum);	
			portfolio.ValidateAcheivementTabAndCard("2");
//			portfolio.validatePortfolioAchievementDocument("PortfolioDownloadAllHSRLetterOfAchievements", "HsrValidateDownloadedDocs", "You will receive an email with a download link shortly");
//			portfolio.validatePortfolioAchievementDocument("PortfolioDownloadCertificatesForAllHSRLocations", "HsrValidateDownloadedDocs", "You will receive an email with a download link shortly");
			
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
