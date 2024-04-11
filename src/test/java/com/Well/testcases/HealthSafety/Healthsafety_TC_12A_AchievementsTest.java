package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafety_TC_12A_AchievementsTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_12_EditTest.Healthsafety_TC_12_03_PrivateToPublicLocationValidation" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_12A_00_validateAchievementDocument(String SheetName,int rowNum) {

	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		StartTest(TestCaseName,"Validate Achievement Document");

		try {
			if (!TestNGTestName.contains("NonEnhanced")) {
			login.AdminLogin();
			hsr.AdminHsrSearch(SheetName,rowNum);
			rc.editAdminAchieveDate();
			rc.SignOut();
			login.Login();
			hsr.SearchHealthSafetyByID(SheetName,rowNum);
			hsr.validateAchievementDocument("HsrValidateDownloadedDocs");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_12A_AchievementsTest.Healthsafety_TC_12A_00_validateAchievementDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_12A_01_validateAchievementDocument(String SheetName,int rowNum) throws IOException {

	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Achievement Document");
		try {

			if (!TestNGTestName.contains("NonEnhanced")) {
			hsr.validateDownloadedAchievementDocument("HsrDownloadAchievmentDocsWELLHealthSafetySeal", "NA");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_12A_AchievementsTest.Healthsafety_TC_12A_01_validateAchievementDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_12A_02_validateAchievementDocument() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Achievement Document");
		try {

			if (!TestNGTestName.contains("NonEnhanced")) {
			//hsr.validateDownloadedAchievementDocument("HsrDownloadAchievmentDocsAllLetter"); 
			}

			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_12A_AchievementsTest.Healthsafety_TC_12A_02_validateAchievementDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_12A_03_validateAchievementDocument() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Achievement Document");
		try {
			if (!TestNGTestName.contains("NonEnhanced")) {
			hsr.validateDownloadedAchievementDocument("HsrDownloadAchievmentDocsRatingLetter", "Letter_of_Achievement.pdf");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafety_TC_12A_AchievementsTest.Healthsafety_TC_12A_03_validateAchievementDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafety_TC_12A_04_validateAchievementDocument() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate Achievement Document");
		try {
			if (!TestNGTestName.contains("NonEnhanced")) {
			hsr.validateDownloadedAchievementDocument("HsrDownloadAchievmentDocsRatingCertificate", "Health-Safety_Rating_Certificate.pdf");
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
