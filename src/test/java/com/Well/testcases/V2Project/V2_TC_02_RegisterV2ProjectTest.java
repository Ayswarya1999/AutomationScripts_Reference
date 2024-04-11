package com.Well.testcases.V2Project;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class V2_TC_02_RegisterV2ProjectTest extends BaseClass {

	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.login.TC_01_LoginTest.TC_01_Login" })
	@Parameters({ "SheetName","rowNum", "Type", "Country" ,"Upload", "API","Commodity","ProjectType","ImportLocation","ProjectName" })
	public void V2_TC_02_RegisterV2Project(String SheetName, int rowNum, String Type, String Country, String Upload, String API,
			String Commodity, String ProjectType, String ImportLocation, String ProjectName) throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register WELL V2 Certification Project Functionality");
		try {
			Boolean ProType;
			if(Type.equalsIgnoreCase("WELLCore")) {
				ProType =true;
			}
			else {
				ProType =false;
			}
		if (API.equalsIgnoreCase("true")) {
			commonAPI.StoreAnyProject(SheetName, rowNum, Country, ProjectType, Upload, API, Commodity, ImportLocation,ProjectName, ProType);
	} 
		else {
			v2project.RegisterV2Project(SheetName, rowNum, Type, Country, ProjectName);
		}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
