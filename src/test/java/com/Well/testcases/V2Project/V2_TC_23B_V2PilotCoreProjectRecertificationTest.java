package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_23B_V2PilotCoreProjectRecertificationTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_23_ValidateAdminAlternativeV2ProjectTest.V2_TC_23_01_ValidateAdminAlternativeAAPV2Project" })
	@Parameters({ "SheetName","rowNum"})
	public void V2_TC_23B_00_V2PilotCoreProjectExpiredRecertification(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate V2 Pilot Core Project Expired Recertification Functionality");
		try {
			login.AdminLogin();
			//Remove
			
			
			v2project.AdminSearchById(SheetName, rowNum);
			v2project.editAndValidateAdminCertification(SheetName, rowNum, "Expired Recertification");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_23B_V2PilotCoreProjectRecertificationTest.V2_TC_23B_00_V2PilotCoreProjectExpiredRecertification" })
	@Parameters({"SheetName","rowNum"})
	public void V2_TC_23B_01_V2PilotCoreProjectRecertification(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate V2 Pilot Core Project Recertification Functionality");
		try {
			v2project.V2PilotCoreProjectEditAndValidateRecertification(SheetName, rowNum);
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_23B_V2PilotCoreProjectRecertificationTest.V2_TC_23B_01_V2PilotCoreProjectRecertification" })
	@Parameters({"SheetName","rowNum"})
	public void V2_TC_23B_02_V2PilotCoreProjectValidateUpdatedProjectArea(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate V2 Pilot Core Project Recertification Functionality");
		try {
			v2project.ValidateUpdatedProjectArea();
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
