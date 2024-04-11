package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ClientApiException;

import com.Well.Engine.BaseClass;

public class V2_TC_05_BillingV2ProjectTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_21_PricingV2ProjectTest.V2_TC_21_PricingV2Project" })
	@Parameters({ "SheetName","rowNum","Country","ProjectType","Type","API","Commodity" })
	public void V2_TC_05_00_BillingV2Project(String SheetName,int rowNum, String Country, String ProjectType, String Type, String API, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"WELL v2 Project Card Payment Functionality");
		try {
			if (TestNGTestName.contains("WELL-V2-Main-CertificationProject-NoDiscount")) {
			v2project.VerifyDocumentPlusIconNotVisible(SheetName,rowNum, "Meet Thresholds for Particulate Matter");
			}
			if (API.equalsIgnoreCase("true")) {
				commonAPI.BillingProject(SheetName, rowNum, Country, ProjectType, Commodity);
				commonAPI.DatePickerAPI(SheetName, rowNum);
			}
		if (API.equalsIgnoreCase("false")) {
			if (Type.equalsIgnoreCase("WELLCertification")){
		login.AdminLogin();
		v2project.AdminSearchById(SheetName, rowNum);
		v2project.ClickBilling(SheetName, rowNum);
		rc.UpdateBilling(SheetName, rowNum);
		if (Country.equalsIgnoreCase("CN")) {
			rc.validateCOA();
			rc.validateCOAWithPercert();
		}
		}
		else {
			v2project.ClickBilling(SheetName, rowNum);
			rc.Billing(SheetName, rowNum);	
		}
		}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_05_BillingV2ProjectTest.V2_TC_05_00_BillingV2Project" })
	@Parameters({ "SheetName","rowNum","Country","Type","API" })
	public void V2_TC_05_01_DownloadBillingReceiptAndValidate(String SheetName,int rowNum, String Country, String Type , String API) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Download and Validate Billing Receipt");
		try {	
			if (API.equalsIgnoreCase("false")) {
			v2project.DownloadBillingReceiptAndValidate(SheetName, rowNum,Country);
			if (Type.equalsIgnoreCase("WELLCertification")) {
			rc.SignOut();
			login.Login();
			v2project.SearchV2ProjectById(SheetName, rowNum);
			}
			else {
				v2project.DownloadBillingReceiptAndValidate(SheetName, rowNum,Country);
			}
			}
				} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_05_BillingV2ProjectTest.V2_TC_05_00_BillingV2Project" })
	@Parameters({ "SheetName","rowNum","Country","Type","API" })
	public void V2_TC_05_02_ValidateValidateRegistered(String SheetName,int rowNum, String Country, String Type , String API) throws IOException, InterruptedException, ClientApiException {
		if (TestNGTestName.contains("Main")) {
			v2project.SearchV2ById(SheetName, rowNum);	
			v2project.SearchV2ProjectFilterByStatus(SheetName, rowNum, "Registered");
			v2project.ClickSearchV2ProjectById(SheetName, rowNum);	
			rc.SignOut();
			login.AdminLogin();
			v2project.ValidateFilterStatusByAdmin(SheetName, rowNum, "Registered");
			v2project.ClickSearchV2ProjectById(SheetName, rowNum);
			rc.SignOut();
			login.Login();
			v2project.SearchV2ById(SheetName, rowNum);	
	}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_SF_04_BillingV2ProjectTest.V2_TC_05_02_ValidateValidateRegistered" })
	@Parameters({ "SheetName","rowNum","API"})
	public void V2_TC_05_03_SearchV2ProjectFilters(String SheetName,int rowNum, String API) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Documents Tab Type Dropdown");
		try {
			if (TestNGTestName.contains("Main")) {
			v2project.SearchV2ProjectFilters(SheetName, rowNum);
			v2project.ClickSearchV2ProjectById(SheetName, rowNum);
			}
			} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
