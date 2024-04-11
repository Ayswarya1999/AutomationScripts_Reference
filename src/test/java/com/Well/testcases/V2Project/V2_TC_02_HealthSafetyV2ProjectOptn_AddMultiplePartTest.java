package com.Well.testcases.V2Project;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_06_AgreementV2ProjectTest.V2_TC_06_01_ValidateDocumentsTabTypeDropdown" })
	@Parameters({"SheetName","rowNum", "Type", "Country" ,"Upload", "API","Commodity","ProjectType"})
	public void V2Project_TC_Optn_02_00_CompleteRegistering(String SheetName, int rowNum, String Type, String Country, String Upload, String API,
			String Commodity, String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {	
			
			v2project.HealthSafetyV2ProjectOptn();
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest.V2Project_TC_Optn_02_00_CompleteRegistering" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void V2Project_TC_Optn_02_01_OptnHsrFeatureUploadDoc(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			v2project.uploadDocumentInOptnFeature("Support Handwashing", SheetName, rowNum, Commodity);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest.V2Project_TC_Optn_02_01_OptnHsrFeatureUploadDoc" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void V2Project_TC_Optn_02_02_OptnHsrFeatureValidMultipleDoc(String SheetName, int rowNum, String Commodity) throws IOException {

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
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest.V2Project_TC_Optn_02_02_OptnHsrFeatureValidMultipleDoc" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_02_03_OptnHsrFeatureDeleteDoc(String SheetName, int rowNum) throws IOException {

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
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest.V2Project_TC_Optn_02_03_OptnHsrFeatureDeleteDoc" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void V2Project_TC_Optn_02_04_OptnHsrFeatureValidDeletedDoc(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL At Scale Project Functionality");
		try {
			v2project.validDeletedUploadDocumentOptnInScorecardFeature("Improve Cleaning Practices", SheetName, rowNum, Commodity);
		
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest.V2Project_TC_Optn_02_04_OptnHsrFeatureValidDeletedDoc" })
	@Parameters({ "SheetName", "rowNum","ProjectType" })
	public void V2Project_TC_Optn_02_05_OptnHsrLocationAccountAuditUploadDoc(String SheetName, int rowNum, String ProjectType) throws IOException {

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
	
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest.V2Project_TC_Optn_02_05_OptnHsrLocationAccountAuditUploadDoc" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_02_06_OptnHsrAlternativeUploadDoc(String SheetName, int rowNum) throws IOException {

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
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest.V2Project_TC_Optn_02_06_OptnHsrAlternativeUploadDoc" })
	@Parameters({ "SheetName", "rowNum", "Commodity" })
	public void V2Project_TC_Optn_02_07_OptnHsrFeatureValidMultipleDoc(String SheetName, int rowNum, String Commodity) throws IOException {

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
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest.V2Project_TC_Optn_02_07_OptnHsrFeatureValidMultipleDoc" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2Project_TC_Optn_02_08_OptnHsrAlternativeValidMultipleDoc(String SheetName, int rowNum) throws IOException {

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
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_02_HealthSafetyV2ProjectOptn_AddMultiplePartTest.V2Project_TC_Optn_02_08_OptnHsrAlternativeValidMultipleDoc" })
	@Parameters({ "SheetName", "rowNum","Commodity" })
	public void V2Project_TC_Optn_02_09_OptnHsrAlternativeValidDeletedDoc(String SheetName, int rowNum, String Commodity) throws IOException {

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
}