package com.Well.testcases.Performance;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Performance_TC_13_PromotionTest extends BaseClass {


	@Test(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_12_EditTest.Performance_TC_12_editAndValidateAdmin" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_13_00_ValidateCardCountAfterAchieved(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Validate card container after achieved");
		try {
			performance.promotionCardCountAfterAchieved(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
