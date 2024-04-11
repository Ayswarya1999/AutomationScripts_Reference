package com.Well.testcases.Membership;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;
import com.Well.Engine.ScreenRecorderUtil;

public class Membership_TC_09_ProductLicensingTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Membership.Membership_TC_08_ProfileTest.Membership_TC_08_Profile" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_01_NavigationToProductLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Navigating to Product Licensing Functionality");
		try {

			ScreenRecorderUtil.startRecord("Membership_TC_09_01_NavigationToProductLicensing");
			if (MembershipName.equalsIgnoreCase("WELL")) {
				login.AdminLogin();
				membership.AdminMembershipNavigation(SheetName, rowNum, MembershipName);
			} else {
				membership.NavigateInPL(SheetName, rowNum, MembershipName);
				login.AdminLogin();
				membership.AdminMembershipNavigation(SheetName, rowNum, MembershipName);
			}

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_01_NavigationToProductLicensing" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_02_CreateProductLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Create Product Licensing Functionality");
		try {
			membership.CreateLicensing(SheetName, rowNum, MembershipName);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_02_CreateProductLicensing" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_03_UpdateProductLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Update Product Licensing Functionality");
		try {
		//	membership.UpdateLicensing(SheetName, rowNum, MembershipName);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_03_UpdateProductLicensing" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_04_DeleteProductLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Deleting Product Licensing Functionality");
		try {
			membership.DeleteLicensing(SheetName, rowNum, MembershipName);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_04_DeleteProductLicensing" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_05_SubmitProductLicensingReview(String SheetName, int rowNum, String MembershipName)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Submit for Product Licensing Review Functionality");
		try {
			membership.SubmitProductLicensingReview(SheetName, rowNum, MembershipName);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_05_SubmitProductLicensingReview" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_06_ValidateProductGroupSuccessMessage(String SheetName, int rowNum,
			String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Validate Product Group Success Message");
		try {
			membership.ValidateProductGroupSuccessMessage(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_06_ValidateProductGroupSuccessMessage" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_07_ValidateDownloadReviewFile(String SheetName, int rowNum, String MembershipName)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Download Review File Functionality");
		try {
			membership.DownloadReviewFile(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_07_ValidateDownloadReviewFile" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_08_UpdateReviewFile(String SheetName, int rowNum, String MembershipName)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Update Review File Data Succesfully");
		try {
			membership.UpdateReviewFile(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_08_UpdateReviewFile" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_09_ValidateImportReviewFile(String SheetName, int rowNum, String MembershipName)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Importing Review File Successfully");
		try {
			membership.ImportReviewFile(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {
			"com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_09_ValidateImportReviewFile" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_10_UpdateProductLicensingStatus(String SheetName, int rowNum, String MembershipName)
			throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Change Profile Status Mark As Achieved");
		try {
			membership.MarkAsAchieved(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}

	@Test(dependsOnMethods = {"com.Well.testcases.Membership.Membership_TC_09_ProductLicensingTest.Membership_TC_09_10_UpdateProductLicensingStatus" })
	@Parameters({ "SheetName", "rowNum", "MembershipName" })
	public void Membership_TC_09_11_ValidateUpdateImportFileData(String SheetName, int rowNum, String MembershipName)
			throws IOException {
		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName, "Vallidate Update Imported Data");
		try {
			membership.ValidateUpdatedImportData(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
