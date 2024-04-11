package com.Well.testcases.Portfolio;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Portfolio_TC_06_PortfolioLocationImportTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Portfolio.Portfolio_TC_05A_PortfolioValidateBillingReceiptTest.Portfolio_TC_05A_PortfolioValidateBillingReceipt" })
	@Parameters({ "SheetName","rowNum", "Upload", "ProjectType","API","Commodity","ImportLocation" })
	public void Portfolio_TC_06_PortfolioLocationImport(String SheetName,int rowNum, String Upload, String ProjectType, String API, String Commodity, String ImportLocation) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Importing Locations to WELL At Scale Project");

		try {
			
			switch (ImportLocation) {
			case "Common":
				 generic.importLocationGeneric(Commodity, ImportfilePortfolioLocation);
				break;
				
			case "CommonV2Pilot":
				 generic.importLocationGeneric(Commodity, ImportfilePortfolioLocation);
				break;

			case "CustomUploadV2":
				generic.importLocationGeneric(Commodity, PortfolioLocationUploadV2Importfile);
				break;
				
			case "CustomUploadV2Pilot":
				generic.importLocationGeneric(Commodity, PortfolioLocationUploadV2PilotImportfile);
				break;
				
			case "CustomV2":
            	generic.importLocationGeneric(Commodity, ImportfilePortfolioLocation);
				break;
				
            case "ProductScorecard":
            	generic.importLocationGeneric(Commodity, PortfolioLocationUploadImportfile);
				break;
			}
			if (Upload.equalsIgnoreCase("true") && ProjectType.contains("pilot")) {
			portfolio.addLocation(SheetName, rowNum, ProjectType, Upload, API);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
