package com.Well.testcases.Portfolio;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Portfolio_TC_07_PortfolioScorecardTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_06_PortfolioLocationImportTest.Portfolio_TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName", "rowNum","ProjectType"  })
	public void Portfolio_TC_07_00_PortfolioBuildScorecardAndValidFeatureDuplication(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Build WELL At Scale Scorecard Functionality");
        try {
          portfolio.PortfolioBuildScorecard();
	      rc.ValidFeatureDuplication();
	      if (ProjectType.contains("pilot")) {
				rc.ScorecardVersionValid("WELL v2 pilot");	  
		} 
			else {
				rc.ScorecardVersionValid("WELL v2");
			}
         } catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_00_PortfolioBuildScorecardAndValidFeatureDuplication" })
    @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_TC_07_01_UploadFileInFeatureScorecard(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document In Feature Scorecard Functionality");
		try {
			rc.CommonSingleUploadScorecardDocument("Meet Thresholds for Organic Gases", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
			rc.paperIconWithoutRefresh("PortfolioScorecardA01.2Papericon");
			if(ProjectType.equalsIgnoreCase("v2")) {
				rc.CommonSingleUploadScorecardDocument("Meet Thresholds for Inorganic Gases", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
				rc.CommonSingleUploadScorecardDocument("Measure Air Parameters", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false,false,false);
			}
	     } catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_01_UploadFileInFeatureScorecard" })
    @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_TC_07_02_UploadFileInAudit(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document In Audit Functionality");
		try {
			rc.CommonSingleUploadScorecardDocument("Prohibit Outdoor Smoking", SheetName, rowNum, Commodity,AuditfileUpload ,false,false,false,true);
			rc.paperIconWithoutRefresh("PortfolioScorecardN08.1Papericon");
			if(ProjectType.equalsIgnoreCase("v2")) {
				portfolio.PurseStatus();
			}
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_02_UploadFileInAudit" })
    @Parameters({ "SheetName", "rowNum","ProjectType" })
	public void Portfolio_TC_07_03_ScorecardCount(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate scorecard count");
		try {
			
			  if (ProjectType.contains("pilot")) {
			  rc.VerifyScorecardPurseStatusCount(SheetName,rowNum, "256");
			  rc.VerifyPaperIconCount(SheetName,rowNum,"2");
			  rc.VerifyWeightIconCount(SheetName,rowNum,"2");
			  } 
			  else {
			  rc.VerifyScorecardPurseStatusCount(SheetName,rowNum, "227");
			  rc.VerifyPaperIconCount(SheetName,rowNum,"4");
			  rc.VerifyWeightIconCount(SheetName,rowNum,"5");
			  }
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_03_ScorecardCount" })
    @Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_07_04_ScorecardSearchFilter() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Verify Scorecard Search filter Functionality");
		try {
			portfolio.searchFilterScoreCard();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_04_ScorecardSearchFilter" })
    @Parameters({ "SheetName", "rowNum","ProjectType" })
	public void Portfolio_TC_07_05_ScorecardOptionFilter(String SheetName, int rowNum, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Verify Scorecard Search filter Options Functionality");
		try {
			if(ProjectType.equalsIgnoreCase("v2")) {
				portfolio.scorecardOptionFilterPortfolio();
			}
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_05_ScorecardOptionFilter" })
	  @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_TC_07_06_UploadFileInAlternative(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Verify Scorecard Search filter Options Functionality");
		try {
			v2project.RefreshScorecard();
			rc.CommonSingleUploadScorecardDocument("Prohibit Indoor Smoking", SheetName, rowNum, Commodity,AlternativeFileUpload ,false,false,false,true);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_07_PortfolioScorecardTest.Portfolio_TC_07_06_UploadFileInAlternative" })
	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_TC_07_07_ValidateTaskCompletionOnAddingOptionFromDocEdit(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate Task Completion On Adding Option From Doc Edit");
		try {
			portfolio.ValidateTaskCompletionOnAddingOptionFromDocEdit(SheetName,rowNum,"WELL v2",ProjectType, Commodity,FeaturefileUpload ,false,false,false,false,"Meet Thresholds for Particulate Matter");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}