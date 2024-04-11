package com.Well.ReusableMethods;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ReusableMethodsFaculty extends BaseClass {
	static String commonauthenticatedusername;
	static String v2authenticatedusername;
	static String adminusername;
	static String adminfacultyusername;
	static String cornerstoneusername;
	static String keystoneusername;
	static String wellusername;
	static String password;
	static String Header;
	static Response res;
	static String[] user;

	public void RegisterFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified account");
		CommonMethod.WaitUntilVisibility("TrainingNavBar", 60);
		CommonMethod.RobustclickElementVisible("TrainingNavBar", "WELLFacultyNavBar");
		testlog.info("When User clicks on WELL Faculty from top menu under Training");
		CommonMethod.RobustclickElementVisible("WELLFacultyNavBar", "WFExamContinuebtn");
		CommonMethod.WaitUntilVisibility("WFExamContinuebtn", 30);
		CommonMethod.RobustclickElementVisible("WFExamContinuebtn", "WPRExamOwnerCountry");
		testlog.info("Then User will be redirected to the Personal Details page successfully");
		CommonMethod.RobustclickElementVisible("WFAddrContinuebtn", "WPRExamOwnerCountry");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Employer is required.", "Employer Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Position is required.", "Position Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Language Selection is required.", "Language Error Mismatch");
		CommonMethod.negativesoftassertPageSource(
				"Please upload a CV/Resume with the file type of doc, docx, pdf, txt.",
				"Upload CV/Resume with the file type Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select if you are a current USGBC Faculty member.",
				"USGBC Faculty member Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select a Credential or Certification.",
				"Credential or Certification Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select if you are migrated from USGBC.",
				"Migrated from USGBC Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select if you are an advisor.",
				"Select Advisor Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select if you are a part of a Member organization.",
				"Select Member Organization Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please select if you are LEED Faculty.",
				"Select LEED Faculty Error Mismatch");
		testlog.info(
				"And User clicks on continue button without entering the mandatory fields and verifies error meassage");
		CommonMethod.WaitUntilVisibility("WPRExamOwnerCountry", 60);
		CommonMethod.selectdropdownValue("WPRExamOwnerCountry", "US");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getattributeValue("WPRExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("WPRExamOwnerState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getattributeValue("WPRExamOwnerState"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("WPRExamOrgAddress", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("WPRExamOrgAddress"));
		CommonMethod.sendKeys("WPRExamOrgCity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("WPRExamOrgCity"));
		CommonMethod.sendKeys("WPRExamOrgPostalcode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("WPRExamOrgPostalcode"));
		CommonMethod.sendKeys("WFEmp", "FullTime");
		data.setCellData(SheetName, "WFEmp", rowNum, CommonMethod.getattributeValue("WFEmp"));
		CommonMethod.sendKeys("WFPostion", "Testing");
		data.setCellData(SheetName, "WFPostion", rowNum, CommonMethod.getattributeValue("WFPostion"));
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", "OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 5).click();
		data.setCellData(SheetName, "Language", rowNum, CommonMethod.getText("OwnerOrgClick"));
		testlog.info(
				"And User enter data to First name, Last name, Country, State, Street address, City and Postal Code, Phone number fields");
		testlog.info("ProjectAddress" + ProjectAddress);
		testlog.info("ProjectCity" + ProjectCity);
		testlog.info("PostalCode" + PostalCode);
		testlog.info("Language : English");
		CommonMethod.uploadFile("WFCvUpload", SamplePdffile, "UploadFileVerifyScorecard");
		testlog.info("And User upload CV document");
		CommonMethod.ClickCheckbox("WFUsgbcFacultyrbtn");
		CommonMethod.ClickCheckbox("WFCredentialsrbtn");
		CommonMethod.ClickCheckbox("WFMigration");
		CommonMethod.ClickCheckbox("WFAdvisor");
		CommonMethod.ClickCheckbox("WFPartmemberOrg");
		CommonMethod.ClickCheckbox("WFLeedFaculty");
		testlog.info("And User checks the Advisor, Usgbc, Migration, Credentials checkboxes");
		CommonMethod.scrolldowntoElement("WFLeedFaculty");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAddrContinuebtn", 0);
		CommonMethod.Robustclick("WFAddrContinuebtn");
		testlog.info("And User clicks on the continue button");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WFAddrContinuebtn", 1);
		testlog.info("And User clicks on the continue button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAcknowlegeContinuebtn", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PreviousButton", 0);
		testlog.info(
				"And User clicks on Back button without entering the mandatory fields and verifies error meassage");
		CommonMethod.RobustclickElementVisible("PreviousButton", "WFAddrContinuebtn");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPRExamOwnerCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Country Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("WPRExamOwnerState"),
				data.getCellData(SheetName, "State", rowNum), "State Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPRExamOrgAddress"),
				data.getCellData(SheetName, "Street", rowNum), "Street Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPRExamOrgCity"),
				data.getCellData(SheetName, "City", rowNum), "City Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPRExamOrgPostalcode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Postal code Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WFEmp"),
				data.getCellData(SheetName, "WFEmp", rowNum), "Employee Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WFPostion"),
				data.getCellData(SheetName, "WFPostion", rowNum), "Position code Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("OwnerOrgClick"),
				data.getCellData(SheetName, "Language", rowNum), "Language Error Mismatch");
		CommonMethod.VerifyRadioOrCheckboxSelcted("WFUsgbcFacultyrbtn");
		CommonMethod.VerifyRadioOrCheckboxSelcted("WFCredentialsrbtn");
		CommonMethod.VerifyRadioOrCheckboxSelcted("WFMigration");
		CommonMethod.VerifyRadioOrCheckboxSelcted("WFAdvisor");
		CommonMethod.VerifyRadioOrCheckboxSelcted("WFPartmemberOrg");
		CommonMethod.VerifyRadioOrCheckboxSelcted("WFLeedFaculty");
		testlog.info("And User verifies the added details about you by clicking on back button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAddrContinuebtn", 0);
		CommonMethod.Robustclick("WFAddrContinuebtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WFAddrContinuebtn", 1);
		testlog.info("And User clicks on the continue button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAcknowlegeContinuebtn", 0);
		testlog.info("Then User will be redirected to Presentation and Facilitation Skills page");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void AgreementFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User have to be Presentation and Facilitation Skills page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFFacultyApplication", 0);
		CommonMethod.scrolldowntoElement("WFFacultyApplication");
		String sampleText = "WELL Faculty Application";
		CommonMethod.RobustclickElementVisible("WFAcknowlegeContinuebtn", "WFFacilitation");
		CommonMethod.negativesoftassertPageSource("Please fill out the required fields.",
				"Qualification Required Fields Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Fileupload is required.", "Fileupload Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Please confirm the terms and conditions.",
				"Terms And Conditions Error Mismatch");
		testlog.info(
				"When User clicks on continue button without entering the mandatory fields and verifies error meassage");
		CommonMethod.sendKeys("WFFacilitation", sampleText);
		testlog.info("And User enters data to Teaching Experience Notes");
		data.setCellData(SheetName, "WFFacilitation", rowNum, CommonMethod.getattributeValue("WFFacilitation"));
		CommonMethod.uploadMultipleFile("WFProvideUpload", SamplePdffile, SamplePdffile, "MultipeUploadDeleteicon", 2,
				"MultipeUploadEnableButtonDeleteLink");
		CommonMethod.uploadFile("WFClientUpload", SamplePdffile, "UploadFileVerifyScorecard");
		Thread.sleep(1000);
		CommonMethod.uploadFile("WFClientUpload", SamplePdffile1, "UploadFileVerifyScorecard");
		testlog.info("And User upload educational offerings document");
		CommonMethod.uploadMultipleFile("WFSurveyUpload", SamplePdffile, SamplePdffile, "MultipeUploadDeleteicon", 6,
				"MultipeUploadEnableButtonDeleteLink");
		testlog.info("And User upload Letter(s) of recommendation document");
		Thread.sleep(2000);
		CommonMethod.sendKeys("WFExp", sampleText);
		testlog.info("And User enters data to qualifications Experience Notes");
		data.setCellData(SheetName, "WFExp", rowNum, CommonMethod.getattributeValue("WFExp"));
		CommonMethod.sendKeys("WFTravel", sampleText);
		data.setCellData(SheetName, "WFTravel", rowNum, CommonMethod.getattributeValue("WFTravel"));
		CommonMethod.ClickCheckbox("WFTermcbx");
		testlog.info("And User checks the terms and conditions checkbox");
		CommonMethod.scrolldowntoElement("WFTermcbx");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAcknowlegeContinuebtn", 0);
		Thread.sleep(1000);
		CommonMethod.Robustclick("WFAcknowlegeContinuebtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WFAcknowlegeContinuebtn", 1);
		testlog.info("And User clicks on continue button");
		CommonMethod.scrolldowntoElement("PvsButton");
		CommonMethod.WaitUntilPresence("PvsButton", 120);
		CommonMethod.RobustclickElementVisible("PvsButton", "WFFacilitation");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFFacilitation", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WFFacilitation"),
				data.getCellData(SheetName, "WFFacilitation", rowNum), "WFFacilitation Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WFExp"),
				data.getCellData(SheetName, "WFExp", rowNum), "WFExp Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WFTravel"),
				data.getCellData(SheetName, "WFTravel", rowNum), "Country Name Error Mismatch");
		testlog.info(
				"And User clicks on Back button without entering the mandatory fields and verifies error meassage");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFTermcbx", 0);
		CommonMethod.ClickCheckbox("WFTermcbx");
		testlog.info("And User checks the terms and conditions checkbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAcknowlegeContinuebtn", 0);
		CommonMethod.Robustclick("WFAcknowlegeContinuebtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WFAcknowlegeContinuebtn", 1);
		testlog.info("And User clicks on continue button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFFacultyApplication", 0);
		testlog.pass("**Verifies the Agreement Faculty successfully**");
	}

	public void SubmitReview(String SheetName, int rowNum, String assertion) throws IOException, InterruptedException {
		testlog.info("Given User have to be Submit Review page");
		if (assertion.equalsIgnoreCase("assertion")) {
			CommonMethod.RobustclickElementVisible("WFExamContinuebtn", "WFSubmitApplicationbtn");
			CommonMethod.negativesoftassertPageSource("Please select application status.",
					"Application Status Error Mismatch");
			CommonMethod.ClickCheckbox("WFStatus");
			CommonMethod.RobustclickElementVisible("WFExamContinuebtn", "WFSubmitApplicationbtn");
			CommonMethod.negativesoftassertPageSource("Approved By is required.", "Approved By Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Region is required.", "Region Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Teaching Experience is required.",
					"Teaching Experience Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Please upload Scorecard Documents.",
					"Scorecard Documents Error Mismatch");
			testlog.info(
					"When User clicks on continue button without entering the mandatory fields and verifies error meassage");
		}
		CommonMethod.WaitUntilVisibility("WFFacultyApplication", 60);
		CommonMethod.scrolldowntoElement("WFFacultyApplication");
		CommonMethod.WaitUntilVisibility("WFStatus", 60);
		if (!CommonMethod.isSelected("WFStatus")) {
			System.out.println("Status checkbox is not checked");
			CommonMethod.ClickCheckbox("WFStatus");
			testlog.info("And User check the Status Checkbox");
		}
		CommonMethod.RobustclickElementVisible("WFApprovedDate", "DatePickerOkButton");
		CommonMethod.WaitUntilVisibility("DatePickerOkButton", 10);
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "WFApproved");
		testlog.info("And User select the Approved Date");
		Thread.sleep(1000);
		String FirstName = USfaker.address().firstName();
		testlog.info("firstName" + FirstName);
		CommonMethod.sendKeys("WFApproved", FirstName);
		data.setCellData(SheetName, "WFApproved", rowNum, CommonMethod.getattributeValue("WFApproved"));
		String sampleText = "WELL Faculty Application";
		CommonMethod.sendKeys("WFRegion", sampleText);
		testlog.info("And User enter data to firstName and Region");
		CommonMethod.ClickCheckbox("WFTeachingcbx");
		testlog.info("And User check the Teaching Checkbox");
		Thread.sleep(1000);
		CommonMethod.uploadFile("WFProvideUpload", SamplePdffile, "UploadFileVerifyScorecard");
		testlog.info("And User Upload Scorecard Document");
		CommonMethod.RobustclickElementVisible("WFExamContinuebtn", "WFSubmitApplicationbtn");
		testlog.info("And User clicks on continue button");
	}

	public void SubmitReviewFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		SubmitReview(SheetName, rowNum, "assertion");
		CommonMethod.WaitUntilPresence("WFSubmitApplicationbtn", Scorecardtimeout);
		CommonMethod.RobustclickElementVisible("WFSubmitApplicationbtn", "WFReturnbtn");
		testlog.info("And User clicks on Submit Application button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilVisibility("WFReturnbtn", Scorecardtimeout);
		CommonMethod.RobustclickElementVisible("WFReturnbtn", "AdminNavBar");
		testlog.info("And User clicks on Return button");
		testlog.pass("**Verifies Submitted Review successfully**");
	}

	public void ReviewSubmitResultFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified Admin account");
		CommonMethod.WaitUntilVisibility("AdminNavBar", Scorecardtimeout);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLFacultyNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLFacultyNavBar", Scorecardtimeout);
		CommonMethod.RobustclickElementVisible("AdminWELLFacultyNavBar", "WFAdminEmail");
		CommonMethod.WaitUntilClickble("WFAdminEmail", Scorecardtimeout)
				.sendKeys(data.getCellData("Login", "AdminUserName", 5));
		testlog.info("When User enter data to Email field");
		CommonMethod.RobustclickElementVisible("ApplyButton", "WFViewButton");
		testlog.info("And User clicks on Apply Button");
		CommonMethod.RobustclickElementVisible("WFViewButton", "WFReviewApplicationButton");
		testlog.info("And User clicks on View Button");
		CommonMethod.RobustclickElementVisible("WFReviewApplicationButton", "WFAddrContinuebtn");
		testlog.info("And User clicks on Review Application Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAddrContinuebtn", 0);
		CommonMethod.Robustclick("WFAddrContinuebtn");
		testlog.info("And User clicks on Continue Button");
		CommonMethod.ClickCheckbox("WFTermcbx");
		testlog.info("And User checks the terms and conditions checkbox");
		CommonMethod.scrolldowntoElement("WFTermcbx");
		Thread.sleep(1000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAcknowlegeContinuebtn", 0);
		CommonMethod.Robustclick("WFAcknowlegeContinuebtn");
		testlog.info("And User clicks on Continue Button");
		SubmitReview(SheetName, rowNum, "No Assertion");
		CommonMethod.RobustclickElementVisible("WFReturnSubmitButton", "WFAdminReviewApprovedStatus");
		testlog.info("And User clicks on Return Submit Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ApplyButton", 0);
		CommonMethod.click("ApplyButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAdminListTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAdminEmail", 0);
		CommonMethod.sendKeys("WFAdminEmail", data.getCellData("Login", "AdminUserName", 5));
		testlog.info("When User enter data to Email field");
		CommonMethod.RobustclickElementVisible("ApplyButton", "WFViewButton");
		testlog.info("And User clicks on Apply Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAdminListTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFAdminReviewApprovedStatus", 0);
		CommonMethod.WaitUntilVisibility("WFAdminReviewApprovedStatus", Scorecardtimeout);
		CommonMethod.assertcontainsmessage("WFAdminReviewApprovedStatus", "APPROVED", "Verified Review status");
		testlog.info("And User verifies Application Status as Approved");
		testlog.pass("**Verifies Review Result successfully**");
	}

	public void ReviewBillingFaculty(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified account");
		CommonMethod.WaitUntilVisibility("TrainingNavBar", 60);
		CommonMethod.RobustclickElementVisible("TrainingNavBar", "WELLFacultyNavBar");
		CommonMethod.RobustclickElementVisible("WELLFacultyNavBar", "WFExamContinuebtn");
		testlog.info("When User clicks on WELL Faculty from top menu under Training");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFExamContinuebtn", 0);
		CommonMethod.RobustclickElementVisible("WFExamContinuebtn", "BillingLanding");
		testlog.info("And User clicks on continue button");
		rc.Billing(SheetName, rowNum);
		testlog.info("Then User will be redirected to Dashboard page");
	}

	public static void orientationCardValdationFaculty() throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TrainingNavBar", 0);
		CommonMethod.RobustclickElementVisible("TrainingNavBar", "WELLFacultyNavBar");
		CommonMethod.RobustclickElementVisible("WELLFacultyNavBar", "WFOrientationTab");
		testlog.info("When User clicks on WELL Faculty from top menu under Training");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WFOrientationTab", 0);
		CommonMethod.WaitUntilVisibility("WFOrientationTab", 60);
		CommonMethod.RobustclickElementVisible("WFOrientationTab", "FacultyRenew");
		testlog.info("And User clicks on OrientationTab");
		CommonMethod.WaitUntilVisibility("FacultyRenew", 60);
		testlog.info("Then User will be redirected to OrientationTab page");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyRenew"), "WELL Faculty Orientation",
				"WELL Faculty Orientation doesn't match");
		CommonMethod.WaitUntilVisibility("FacultyDownloadCertificate", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyDownloadCertificate"), "Download certificate",
				"Download Ceritificate doesn't match");
		testlog.info("And User verifies cards on the Orientation Dashboard page");
		rc.ValidCardCount("PromotionCardContainer");
		softAssert.assertAll();
		testlog.pass("**Verify card count successfully**");
	}

	public static void keepLearingCardValdationFaculty() throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("WFKeepLearningTab", 60);
		CommonMethod.RobustclickElementVisible("WFKeepLearningTab", "FacultyKeepLearing");
		testlog.info("When User clicks on Keep Learning Tab");
		CommonMethod.WaitUntilVisibility("FacultyKeepLearing", 60);
		testlog.info("Then User will be redirected to Keep Learning page");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyKeepLearing"), "Keep Learning",
				"Keep Learning doesn't match");
		rc.ValidCardCount("PromotionCardContainer");
		softAssert.assertAll();
		testlog.info("And User verifies cards on the keepLearing Dashboard page");
		testlog.pass("**Verify card count successfully**");
	}

	public static void resourcesCardValdationFaculty() throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("WFResourceTab", 60);
		CommonMethod.RobustclickElementVisible("WFResourceTab", "FacultyInstructionalResources");
		testlog.info("When User clicks on Resource Tab");
		CommonMethod.WaitUntilVisibility("FacultyInstructionalResources", 60);
		testlog.info("Then User will be redirected to resources page");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyInstructionalResources"),
				"Instructional Resources", "Instructional Resources doesn't match");
		rc.ValidCardCount("PromotionCardContainer");
		testlog.info("And User verifies cards on the resources Dashboard page");
		testlog.pass("**Verify card count successfully**");
	}

	public static void marketingToolKitCardValdationFaculty() throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("WFMarketingToolkitTab", 60);
		CommonMethod.RobustclickElementVisible("WFMarketingToolkitTab", "FacultyMarketingToolKit");
		testlog.info("When User clicks on Resource Tab");
		CommonMethod.WaitUntilVisibility("FacultyMarketingToolKit", 60);
		testlog.info("Then User will be redirected to marketing ToolKit page");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyMarketingToolKit"), "Social Media Toolkit",
				"Social Media Toolkit doesn't match");
		rc.ValidCardCount("PromotionCardContainer");
		softAssert.assertAll();
		testlog.info("And User verifies cards on the marketingToolKit Dashboard page");
		testlog.pass("**Verify card count successfully**");
	}

	public static void reportingCardValdationFaculty() throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("WFReportingTab", 60);
		CommonMethod.RobustclickElementVisible("WFReportingTab", "FacultyReporting");
		testlog.info("When User clicks on Reporting Tab");
		CommonMethod.WaitUntilVisibility("FacultyReporting", 60);
		testlog.info("Then User will be redirected to reporting page");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("FacultyReporting"), "Reporting",
				"Reporting doesn't match");
		rc.ValidCardCount("PromotionCardContainer");
		softAssert.assertAll();
		testlog.info("And User verifies cards on the reporting Dashboard page");
		testlog.pass("**Verify card count successfully**");
	}

	@SuppressWarnings("unchecked")
	public static Response DeleteFacultyOrMembership(String SheetName, int rowNum) {
		/* * Get Token by authentication */
		testlog.info("Given User set POST service api endpoint");
		commonauthenticatedusername = data.getCellData("Login", "UserName", 3);
		adminusername = data.getCellData("Login", "AdminUserName", 3);
		adminfacultyusername = data.getCellData("Login", "AdminUserName", 5);
		v2authenticatedusername = data.getCellData("Login", "UserName", 6);
		keystoneusername = data.getCellData("Login", "UserName", 7);
		cornerstoneusername = data.getCellData("Login", "UserName", 8);
		wellusername = data.getCellData("Login", "UserName", 9);
		if (SheetName.equalsIgnoreCase("Faculty")) {
			commonauthenticatedusername = data.getCellData("Login", "UserName", 5);
		}
		testlog.info("When User set Request header and Payload");
		JSONObject param = new JSONObject();
		param.put("email", adminusername);
		password = data.getCellData("Login", "AdminPassword", 3);
		param.put("password", password);
		testlog.info("Request Payload: " + param.toString());
		Response res = given().log().all().accept("application/json").contentType("application/json").body(param).when()
				.post("authenticate");
		testlog.info("And User Send a POST HTTP request");
		System.out.println(res.asString());
		int StatusCode = res.getStatusCode();
		Assert.assertEquals(StatusCode, 200, "Verifying status code");
		Header = (res.path("token")).toString();
		Header = "Bearer " + Header;
		testlog.info("Header Token: " + Header);
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.info("And User store token from response body");
		testlog.info("Given User set Delete service api endpoint");
		switch (ModuleName) {
		case "V2":
			user = new String[] { v2authenticatedusername };
			break;
			
		case "Faculty":
			user = new String[] { adminfacultyusername };
			break;	
			
		case "Common":
			user = new String[] { commonauthenticatedusername, v2authenticatedusername };
			break;

		case "Cornerstone":
			user = new String[] { adminusername, cornerstoneusername };
			break;

		case "Keystone":
			user = new String[] { keystoneusername };
			break;

		case "WELLMembership":
			user = new String[] { wellusername };
			break;
		}

		testlog.info("When User set Request header and Payload");
		for (String s : user) {
			res = given().log().all().contentType("application/json").header("Authorization", Header).when()
					.delete("admin/qa/automation/bulk-delete/" + s);
			System.out.println(res.asString());
		}
		testlog.info("And User Send a Delete HTTP request");
		int StatusCode1 = res.getStatusCode();
		Assert.assertEquals(StatusCode1, 200, "Verifying status code");
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.pass("**Verifies Bulk Membership Deleted successfully**");
		return res;
	}
}