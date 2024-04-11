package com.Well.testcases.Portfolio;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Portfolio_TC_15C_AddLocationMilestoneTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_20B_ReviewEquityPortfolioTest.Portfolio_TC_20B_12_ValidateWERSectionInAdminFields" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15C_00_FutureReviewCycle_Milestone_Validation(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verify Future review cycle Milestone tab Successfully");
		try {
			portfolio.NavigateLocation();
			portfolio.VerifyMilestonetab(SheetName, rowNum,"TargetAchievementEditIconRow5","WELL at scale Test location 5");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_00_FutureReviewCycle_Milestone_Validation" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15C_01_ReviewCycle_Milestone_Validation(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verify review cycle and Milestone tab Successfully");
		try {
			portfolio.VerifyMilestonetab(SheetName, rowNum,"TargetAchievementEditIconRow4","WELL at scale Test location 4");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
		
	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_01_ReviewCycle_Milestone_Validation" })
	@Parameters({ "SheetName", "rowNum"})
	public void Portfolio_TC_15C_02_ReviewCycle_MilestoneFilter_Validation() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Verify Filter review cycle Milestone tab Successfully");
		try {
			portfolio.VerifyMilestoneLocationFilters("This review cycle");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
}
	
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_02_ReviewCycle_MilestoneFilter_Validation" })
		@Parameters({ "SheetName", "rowNum"})
		public void Portfolio_TC_15C_03_FutureReviewCycle_MilestoneFilter_Validation() throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Verify Filter Future review cycle Milestone tab Successfully");
			try {
				portfolio.VerifyMilestoneLocationFilters("Future review cycle");
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
	}
	
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_03_FutureReviewCycle_MilestoneFilter_Validation" })
		@Parameters({ "SheetName", "rowNum"})
		public void Portfolio_TC_15C_04_FutureReviewCycle_Milestone_SummaryValidation(String SheetName, int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Verify Summary Future review cycle Milestone tab Successfully");
			try {
				portfolio.VerifyMilestoneReviewCycle("Future review cycle");
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_04_FutureReviewCycle_Milestone_SummaryValidation" })
		@Parameters({ "SheetName", "rowNum"})
		public void Portfolio_TC_15C_05_ReviewCycle_Milestone_SummaryValidation(String SheetName, int rowNum) throws IOException {

			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Verify Summary Review cycle Milestone tab Successfully");
			try {
				portfolio.VerifyMilestoneReviewCycle("This review cycle");
				} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
			}
		}
		
//		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_05_ReviewCycle_Milestone_SummaryValidation" })
//		@Parameters({ "SheetName", "rowNum"})
//		public void Portfolio_TC_15C_06_DownloadAndUpdateMilestonelocationFile(String SheetName, int rowNum) throws IOException {
//
//			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
//			StartTest(TestCaseName,"Download And Upload Milestone location File Successfully");
//			try {
//				
//				portfolio.SearchPortfolioById(SheetName,rowNum);
//				Thread.sleep(10000);			
//				portfolio.DownloadAndUpdateMilestonelocationFile(SheetName, rowNum);
//			} catch (Throwable t) {
//				System.out.println(t.getLocalizedMessage());
//				Error e1 = new Error(t.getMessage());
//				e1.setStackTrace(t.getStackTrace());
//				throw e1;
//			}
//		}
		
//		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_05_ReviewCycle_Milestone_SummaryValidation" })
//		@Parameters({ "SheetName", "rowNum"})
//		public void Portfolio_TC_15C_07_ValidateMilestonelocationFile(String SheetName, int rowNum) throws IOException {
//
//			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
//			StartTest(TestCaseName,"Verify Uploaded Milestone location File Successfully");
//			try {
//				portfolio.ValidateMilestonelocationFile(SheetName, rowNum);
//				} catch (Throwable t) {
//				System.out.println(t.getLocalizedMessage());
//				Error e1 = new Error(t.getMessage());
//				e1.setStackTrace(t.getStackTrace());
//				throw e1;
//			}
//		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_05_ReviewCycle_Milestone_SummaryValidation" })
		@Parameters({ "SheetName", "rowNum"})
		public void Portfolio_TC_15C_08_ValidateMilestonelocationSearchFilter(String SheetName, int rowNum) throws IOException {
			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Verify Search filter Milestone location File Successfully");
			try {
				portfolio.ValidateMilestoneSearchLocation(SheetName, rowNum);
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_08_ValidateMilestonelocationSearchFilter" })
		@Parameters({ "SheetName", "rowNum"})
		public void Portfolio_TC_15C_09_UnderConstructionAsYes(String SheetName, int rowNum) throws IOException {
			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Verify checks Under Construction As Yes Successfully");
			try {
				portfolio.SearchPortfolioById(SheetName,rowNum);
				portfolio.UnderConstructionAsYes();
			
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_09_UnderConstructionAsYes" })
		public void Portfolio_TC_15C_10_ValidateUnderConstructionInLocationTable() throws IOException {
			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"verifies TickMark In UnderContruction column Successfully");
			try {
				portfolio.validUnderConstructionInLocationTable();
			
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_10_ValidateUnderConstructionInLocationTable" })
		public void Portfolio_TC_15C_11_ValidateUnderContructionInOverviewLocation() throws IOException {
			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Verify Disabled checkboxes for Target ReviewCycle Successfully");
			try {
				portfolio.overviewtabTargetReviewCycle();
				portfolio.UnderConstructionDisableTargetReviewCycle();
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
}
		}
		
		@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_15C_AddLocationMilestoneTest.Portfolio_TC_15C_11_ValidateUnderContructionInOverviewLocation" })
		public void Portfolio_TC_15C_12_ValidateUnderContructionInTargetMilestoneLocation() throws IOException {
			TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			StartTest(TestCaseName,"Verify Disabled checkboxes for Target ReviewCycle Successfully");
			try {
				portfolio.MilestonetabTargetReviewCycle();
				portfolio.UnderConstructionDisableTargetReviewCycle();
			} catch (Throwable t) {
				System.out.println(t.getLocalizedMessage());
				Error e1 = new Error(t.getMessage());
				e1.setStackTrace(t.getStackTrace());
				throw e1;
}
		}
}