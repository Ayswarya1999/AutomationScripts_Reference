package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_CTC_01_FeatureTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_TC_06_PortfolioLocationImportTest.Portfolio_TC_06_PortfolioLocationImport" })
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_CTC_01_00_PortfolioBuildScorecard() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			portfolio.PortfolioBuildScorecard();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_00_PortfolioBuildScorecard" })
	 @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_CTC_01_01_MeetThresholdsforParticulateMatter(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			/* Air A01.1 */ 
			pf.MeetThresholdsforParticulateMatter("Meet Thresholds for Particulate Matter", SheetName, rowNum, Commodity,FeaturefileUpload ,true,false,false,true);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_01_MeetThresholdsforParticulateMatter" })
	 @Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_CTC_01_02_MeetThresholdsforOrganicGasesFeature(String SheetName, int rowNum,String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			/* Air A01.2 */ 
			pf.MeetThresholdsforOrganicGases("Meet Thresholds for Organic Gases", SheetName, rowNum, Commodity,FeaturefileUpload ,false,true,false,false);
				
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_02_MeetThresholdsforOrganicGasesFeature" })
	public void Portfolio_CTC_01_03_MitigateConstructionPollutionFeature() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			/*Air A04.1*/
		pf.MitigateConstructionPollution("Mitigate Construction Pollution");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_03_MitigateConstructionPollutionFeature" })
	 @Parameters({ "SheetName", "rowNum","Commodity" })
	public void Portfolio_CTC_01_04_MeetEnhancedThresholdsforOrganicGases(String SheetName, int rowNum, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			/*Air A05.2*/
			pf.MeetEnhancedThresholdsforOrganicGases("Meet Enhanced Thresholds for Organic Gases", SheetName, rowNum, Commodity);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_04_MeetEnhancedThresholdsforOrganicGases" })
	public void Portfolio_CTC_01_05_ManageWindowUse() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			/*Air A07.2*/
			pf.ManageWindowUse("Manage Window Use");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_05_ManageWindowUse" })
	public void Portfolio_CTC_01_06_InstallIndoorAirMonitors() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			/*Air A08.1*/
			pf.InstallIndoorAirMonitors("Install Indoor Air Monitors");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_06_InstallIndoorAirMonitors" })
	@Parameters({ "SheetName", "rowNum","ProjectType","Commodity" })
	public void Portfolio_CTC_01_07_ConductDaylightSimulation(String SheetName,int rowNum, String ProjectType, String Commodity) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			/* Light L06.1 */
			
			pf.ConductDaylightSimulation("Conduct Daylight Simulation", SheetName, rowNum, Commodity,FeaturefileUpload ,false,false ,false,false);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_07_ConductDaylightSimulation" })
	public void Portfolio_CTC_01_08_EnhanceOccupantControllability() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			/* Light L09.1 */
			pf.EnhanceOccupantControllability("Enhance Occupant Controllability");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_08_EnhanceOccupantControllability" })
	public void Portfolio_CTC_01_09_OfferPhysicalActivityIncentives() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			/* V09.1 */
			pf.OfferPhysicalActivityIncentives("Offer Physical Activity Incentives");

			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_09_OfferPhysicalActivityIncentives" })
	public void Portfolio_CTC_01_10_RestrictVOCEmissionsfromFurnitureArchitecturalandInteriorProducts() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Portfolio Scorecard custom scenarios");
		try {
			/* X06.2 */
			pf.RestrictVOCEmissionsfromFurnitureArchitecturalandInteriorProducts(
			 "Restrict VOC Emissions from Furniture, Architectural and Interior Products");
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}


@Test(dependsOnMethods = {"com.Well.testcases.Portfolio.Portfolio_CTC_01_FeatureTest.Portfolio_CTC_01_10_RestrictVOCEmissionsfromFurnitureArchitecturalandInteriorProducts" })
@Parameters({ "SheetName", "rowNum","Commodity" })
public void Portfolio_CTC_01_11_NotApplicableAlternative(String SheetName, int rowNum, String Commodity) throws IOException {

	TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
	StartTest(TestCaseName, "Portfolio Scorecard Upload Document for Not Applicable Alternative");
	try {
		pf.NotApplicableAlternative("Prohibit Outdoor Smoking", SheetName, rowNum, Commodity);
		
	} catch (Throwable t) {
		System.out.println(t.getLocalizedMessage());
		Error e1 = new Error(t.getMessage());
		e1.setStackTrace(t.getStackTrace());
		throw e1;
	}
}
}
