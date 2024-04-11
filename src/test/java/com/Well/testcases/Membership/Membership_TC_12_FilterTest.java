package com.Well.testcases.Membership;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;

public class Membership_TC_12_FilterTest extends BaseClass {
	
	@SuppressWarnings("static-access")
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_11_ValidateUpdateImportFileData" })
	@Parameters({ "SheetName","rowNum"})
	public void Membership_TC_12_01_SubscribedFilter(String SheetName,int rowNum) throws IOException {

	    TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Subscribed Filter");
		try {
			commonAPI.getMembershipId(SheetName, rowNum);
			login.AdminLogin();
			membership.navigateAdminMembership();
			membership.getAndSetAdminMembershipFilterData(SheetName, rowNum);
			membership.clearFilter();
			membership.validateAdminMembershipStatus(SheetName, rowNum, "SUBSCRIBED");
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_12_FilterTest.Membership_TC_12_01_SubscribedFilter" })
	@Parameters({ "SheetName","rowNum" })
	public void Membership_TC_12_02_SubscriptionInProgressFilter(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Subscription in progress Filter");
		try {
			membership.clearFilter();
			membership.validateAdminMembershipStatus(SheetName, rowNum, "IN PROGRESS");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_12_FilterTest.Membership_TC_12_02_SubscriptionInProgressFilter" })
	@Parameters({ "SheetName","rowNum"  })
	public void Membership_TC_12_03_EngagementLevelMembershipFilter(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Membership Filter");
		try {
			membership.clearFilter();
			membership.validateAdminMembershipEngagementLevel(SheetName, rowNum, "Membership","MEMBERSHIP");
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_12_FilterTest.Membership_TC_12_03_EngagementLevelMembershipFilter" })
	@Parameters({ "SheetName","rowNum"  })
	public void Membership_TC_12_04_EngagementLevelWorksWithWELLFilter(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Works with WELL Filter");
		try {
			membership.clearFilter();
			membership.validateAdminMembershipEngagementLevel(SheetName, rowNum, "Works with WELL","WORKS WITH WELL");
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_12_FilterTest.Membership_TC_12_04_EngagementLevelWorksWithWELLFilter" })
	@Parameters({ "SheetName","rowNum"  })
	public void Membership_TC_12_05_AdminMembershipNameFilter(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Membership Name Filter");
		try {
			membership.clearFilter();
			membership.validateAdminMembershipFilterName(SheetName,rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_12_FilterTest.Membership_TC_12_05_AdminMembershipNameFilter" })
	@Parameters({ "SheetName","rowNum"  })
	public void Membership_TC_12_06_AdminMembershipUserEmailFilter(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Membership UserEmail Filter");
		try {
			membership.clearFilter();
			membership.validateAdminMembershipFilterEmail(SheetName,rowNum);
			membership.clearFilter();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_12_FilterTest.Membership_TC_12_06_AdminMembershipUserEmailFilter" })
	@Parameters({ "SheetName","rowNum"  })
	public void Membership_TC_12_07_AdminMembershipIdFilter(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Membership Name Filter");
		try {
			membership.validateAdminMembershipFilterID(SheetName,rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}