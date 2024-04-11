package com.Well.testcases.Membership;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Membership_TC_02_RegisterMembershipTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.login.TC_01_LoginTest.TC_01_Login" })
	@Parameters({ "SheetName","rowNum","MembershipName" })
	public void Membership_TC_02_RegisterMembership(String SheetName,int rowNum, String MembershipName) throws Exception {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register Membership Functionality");
		try {
			
			if (MembershipName.equalsIgnoreCase("WELL")) {
			membership.RegisterMembership(SheetName, rowNum, MembershipName);
			}
			else {
				membership.RegisterNewMembership(SheetName, rowNum, MembershipName);
			}
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
