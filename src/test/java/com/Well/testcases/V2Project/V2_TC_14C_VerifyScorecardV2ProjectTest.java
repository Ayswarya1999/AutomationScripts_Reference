package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_14C_VerifyScorecardV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = {"com.Well.testcases.V2Project.V2_TC_30_ScorecardPurseV2ProjectTest.V2_TC_30_02_verifyScoreCardFilter" })
	@Parameters({ "SheetName", "rowNum" })
	public void V2_TC_14C_00_VerifyScorecardV2Project(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Validating Team Member Scorecard for V2Project");
		try {
			rc.clickOnTeamTab();
			rc.team(SheetName, rowNum);
			rc.SignOut();
			rc.teamMemberLogin(SheetName, rowNum);
			v2project.SearchV2ProjectById(SheetName, rowNum);			
			v2project.verifyScorecardAsMember(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
