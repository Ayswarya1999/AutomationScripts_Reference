package com.Well.testcases.Performance;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Performance_TC_07A_PromotionTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07_ScorecardTest.Performance_TC_07_04_ScoreCardOptionFilter" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_07A_00_Promotion(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Verifying Card link details");
		try {
			rc.promotionCardValidation();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_07A_PromotionTest.Performance_TC_07A_00_Promotion" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_07A_01_ValidateCardCountBeforeAchieved(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate card container before achieved");
		try {
			performance.promotionCardCountBeforeAchieved(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
