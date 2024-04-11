package com.Well.testcases.Portfolio;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Portfolio_CTC_10_AssignedTaskInLocationAccountTest extends BaseClass {

	 
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_07_DocumentUploadForAddedLocationTest.Portfolio_CTC_07_11_ValidateScorecardConfirmationModalAfterUploadingMultipleDocs" })
	public void Portfolio_CTC_10_00_HsrOptnUploadDocument() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Upload Document for Optn Hsr rating");
		try {
			
			pfu.HsrOptnUploadDocument("Support Handwashing");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}	
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_10_DocumentUploadForAddedLocationTest.Portfolio_CTC_10_00_HsrOptnUploadDocument" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_10_01_storeLocationId(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Store LocationId");
		try {
			pfu.storeLocationId(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_10_DocumentUploadForAddedLocationTest.Portfolio_CTC_10_01_storeLocationId" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_10_02_NavigateAddedLocation(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Navigate to assignedTask");
		try {
			pfu.NavigateAddedLocation(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_10_DocumentUploadForAddedLocationTest.Portfolio_CTC_10_02_NavigateAddedLocation" })
	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_CTC_10_03_AssignedTasksV2UploadDocument(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "V2 Upload Document in Assigned Tasks");
		try {
			pfu.assignedTaskNavigate(SheetName, rowNum, Commodity,FeaturefileUpload,true,"PortfolioDocListA1.1");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_10_DocumentUploadForAddedLocationTest.Portfolio_CTC_10_03_AssignedTasksV2UploadDocument" })
	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_CTC_10_04_AssignedTasksHsrUploadDocument(String SheetName, int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Hsr Upload Assigned Tasks");
		try {
			pfu.assignedTaskNavigate(SheetName, rowNum, Commodity,FeaturefileUpload,false,"PortfolioHsrOptnSC1UploadButtonFeature");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_10_DocumentUploadForAddedLocationTest.Portfolio_CTC_10_04_AssignedTasksHsrUploadDocument" })
	@Parameters({ "ProjectType" })
	public void Portfolio_CTC_10_05_AssignedTasksV2Filter(String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "V2 filter Assigned Tasks");
		try {
			if (ProjectType.contains("pilot")) {
			pfu.assignedTaskV2Filter();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_10_DocumentUploadForAddedLocationTest.Portfolio_CTC_10_05_AssignedTasksV2Filter" })
	@Parameters({ "ProjectType" })
	public void Portfolio_CTC_10_06_AssignedTasksHsrFilter(String ProjectType) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Hsr filter Assigned Tasks");
		try {
			if (ProjectType.contains("pilot")) {
			pfu.assignedTaskHsrFilter();
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_10_DocumentUploadForAddedLocationTest.Portfolio_CTC_10_06_AssignedTasksHsrFilter" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_10_07_ValidateV2UploadedDocumentInPotfolio(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate V2 Uploaded Document In Potfolio");
		try {
			portfolio.SearchPortfolioById(SheetName,rowNum);
			portfolio.clickDocument();
			pfu.uploadedAssignedTaskDocumentInPortfolio();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_10_DocumentUploadForAddedLocationTest.Portfolio_CTC_10_07_ValidateV2UploadedDocumentInPotfolio" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_10_08_ValidateHsrUploadedDocumentInPotfolio(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate Hsr Uploaded Document In Potfolio");
		try {
			portfolio.clickHSRDocument();
			pfu.uploadedHsrAssignedTaskDocumentInPortfolio();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
