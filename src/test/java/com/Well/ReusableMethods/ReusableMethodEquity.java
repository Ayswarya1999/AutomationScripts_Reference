package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodEquity extends BaseClass {
	String PortfolioAndRatingLocAccDocumentTable ="PortfolioAndRatingLocAccDocumentTable";
	String toolTipMessage ="You do not have permission to delete this document";
	
	public void RegisterEquity(String SheetName, int rowNum, String DataValidate, String ProjectName) throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified account");
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 120);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERstartNewProject");
		testlog.info("When User clicks on WELL Equity from top menu under Projects");
		CommonMethod.WaitUntilVisibility("WERstartNewProject", 60);
		CommonMethod.RobustclickElementVisible("WERstartNewProject","WEREnrollOption");
		testlog.info("And User clicks on Start project button");
		CommonMethod.RobustclickElementVisible("WEREnrollOption", "WERenrollbtn");
		testlog.info("And User clicks on EnrollNow button");
		CommonMethod.RobustclickElementVisible("WERenrollbtn", "WEROrgContinebtn");
		testlog.info("And User clicks on Enroll button");
		String AccountName = ProjectName + "_"+ CommonMethod.randomNumber(8000000);
		testlog.info("ProjectName: " + AccountName);
		data.setCellData(SheetName, "projectName", rowNum, AccountName);
		CommonMethod.RobustclickElementVisible("WEROrgContinebtn", "WEREnrollName");
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Industry is required.", "Organization Industry Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Consultant is required.", "Consultant Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		testlog.info("And User clicks on continue button without entering the mandatory fields and verifies error meassage");
		CommonMethod.WaitUntilPresence("WEREnrollName",60);
		CommonMethod.sendKeys("WEREnrollName", AccountName);
		testlog.info("And User enter data to EnrollName");
		CommonMethod.ClickCheckbox("WEROwnerInfocbx");
		testlog.info("And User checks the enroll checkbox");
		String OwnerName = USfaker.address().firstName();
		CommonMethod.sendKeys("WEROrgName", OwnerName);
		rc.SelectOwnerOrg(SheetName, rowNum);
		data.setCellData(SheetName, "OrgName", rowNum, CommonMethod.getText("OrgName"));
		testlog.info("OrganizationName: " + data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		rc.SelectEnterpriseProviders(SheetName,rowNum);
		CommonMethod.selectdropdownValue("WEROwnerCountry", "US");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("WEROwnerCountry"));
		CommonMethod.selectdropdownrandom("WEROwnerState");
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("WEROrgAddress", ProjectAddress);
		CommonMethod.sendKeys("WEROrgCity", ProjectCity);
		CommonMethod.sendKeys("WEROrgPostalcode", PostalCode);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownAttribute("WEROwnerCountry"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getattributeValue("WEROwnerState"));
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("WEROrgAddress"));
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("WEROrgCity"));
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("WEROrgPostalcode"));
		testlog.info("And User enter data to Owner Country, State, Street address, City and Postal Code fields");
		testlog.info("Organization Address: " + ProjectAddress);
		testlog.info("Organization City: " + ProjectCity);
		testlog.info("Organization Postalcode: " + PostalCode);
		CommonMethod.ClickCheckbox("WEROwnercbx");
		testlog.info("And User checks the Billing checkbox");
		CommonMethod.scrolldowntoElement("WEROwnercbx");
		CommonMethod.WaitUntilPresence("WEROrgContinebtn",60);
		testlog.info("And User clicks on continue button");
		CommonMethod.RobustclickElementVisible("WEROrgContinebtn", "WEROwnerRegContinuebtn");
		if (DataValidate.equalsIgnoreCase("true")) {
		CommonMethod.RobustclickElementVisible("WPRBackToHomepagebutton", "WPROrgContinebtn");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WEREnrollName"),ProjectName, "Enroll Name Error Mismatch");
		CommonMethod.VerifyRadioOrCheckboxSelcted("WEROwnerInfocbx");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WEROrgName"),OwnerName, "Owner Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("OrgName"),data.getCellData(SheetName, "OrgName", rowNum), "Org Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("OrgIndustry"),data.getCellData(SheetName, "OrgIndustry", rowNum), "Org Industry Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownAttribute("WEROwnerCountry"),data.getCellData(SheetName, "Country", rowNum), "Country Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WEROwnerState"),data.getCellData(SheetName, "State", rowNum), "State Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WEROrgAddress"),data.getCellData(SheetName, "Street", rowNum), "Street Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WEROrgCity"),data.getCellData(SheetName, "City", rowNum), "City Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WEROrgPostalcode"),data.getCellData(SheetName, "PostalCode", rowNum), "Postal code Error Mismatch");
		CommonMethod.VerifyRadioOrCheckboxSelcted("WEROwnercbx");
		CommonMethod.RobustclickElementVisible("WEROrgContinebtn", "WEROwnerRegContinuebtn");
		testlog.info("And User verifies the added details about you by clicking on back button");
		}
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.RobustclickElementVisible("WEROwnerRegContinuebtn","WERBehalfCbx");
		CommonMethod.negativesoftassertPageSource("On behalf of owner is required.", "Owner CheckBox Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Is the Owner organization an IWBI member?* is required.", "Owner Organization Name Error Mismatch");
		testlog.info("And User clicks on continue button without entering the mandatory fields and verifies error meassage");
		CommonMethod.ClickCheckbox("WERBehalfCbx");
		testlog.info("And User checks the Behalf checkbox");
		CommonMethod.selectdropdownVisibletext("WERSelectMember", "No");
		testlog.info("And User select Iwbi member");
		data.setCellData(SheetName, "WERSelectMember", rowNum,
	    CommonMethod.getSelectedDropdownValue("WERSelectMember"));
		CommonMethod.RobustclickElementVisible("WEROwnerRegContinuebtn","WERlocations");
		if (DataValidate.equalsIgnoreCase("true")) {
		CommonMethod.RobustclickElementVisible("BackButton","WEROwnerRegContinuebtn");
		CommonMethod.VerifyRadioOrCheckboxSelcted("WERBehalfCbx");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("WPRSelectMember"),data.getCellData(SheetName, "WPRSelectMember", rowNum), "Member Value Error Mismatch");
		CommonMethod.RobustclickElementVisible("WEROwnerRegContinuebtn","WERlocations");
		testlog.info("And User verifies the added details about you by clicking on back button");
		}
			Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.sendKeys("WERlocations", "10");
		testlog.info("And User enter data to location");
		data.setCellData(SheetName, "WERlocations", rowNum, CommonMethod.getattributeValue("WERlocations"));
		CommonMethod.RobustclickElementVisible("WERlocationsSpacetype","WERlocationsSpaceOption");
		CommonMethod.RobustclickElementVisible("WERlocationsSpaceOption","WERlocationsize");
		testlog.info("And User select the space type");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		testlog.info("Locationsize: " + Area);
		CommonMethod.clearAndSendKey("WERlocationsize", Area);
		testlog.info("And User enter the Location Size");
		data.setCellData(SheetName, "WERlocationsize", rowNum, CommonMethod.getattributeValue("WERlocationsize"));
		CommonMethod.WaitUntilClickble("WEROwnerRegContinuebtn", 60);
		CommonMethod.RobustclickElementVisible("WEROwnerRegContinuebtn", "WERReviewContinuebutton");
		testlog.info("And User clicks on continue button");
		if (DataValidate.equalsIgnoreCase("true")) {
		CommonMethod.RobustclickElementVisible("BackButton", "WEROwnerRegContinuebtn");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WERlocations"),data.getCellData(SheetName, "WERlocations", rowNum), "Location Value Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WERlocationsSpacetype"),data.getCellData(SheetName, "WPRSelectMember", rowNum), "Location Value Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WERlocationsize"),data.getCellData(SheetName, "WERlocationsize", rowNum), "Area Size Error Mismatch");
		CommonMethod.RobustclickElementVisible("WEROwnerRegContinuebtn", "WERReviewContinuebutton");
		testlog.info("And User verifies the added details about you by clicking on back button");
		}
		if (CommonMethod.isElementsExist("WERYesMyOrganizationCbx", 2)) {
			CommonMethod.WaitUntilClickble("WERYesMyOrganizationCbx", 30);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
			testlog.info("And User checks the MyOrganization checkbox");
		}
		CommonMethod.RobustclickElementVisible("WERReviewContinuebutton", "WERtermContinuebutton");
		testlog.info("And User clicks on continue button");
		if (CommonMethod.isElementsExist("WERProgramFeePublicrbtn", 20)) {
			CommonMethod.WaitUntilClickble("WERProgramFeePublicrbtn", 60);
			CommonMethod.ClickCheckbox("WERProgramFeePublicrbtn");
			testlog.info("And User checks the ProgramFee checkbox");
		}
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilClickble("WERAcknowledecbx", 60);
		CommonMethod.ClickCheckbox("WERAcknowledecbx");
		testlog.info("And User checks the Acknowledge checkbox");
		CommonMethod.RobustclickElementVisible("WERtermContinuebutton", "BillingLanding");
		testlog.info("And User clicks on continue button");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.info("Then User will be redirected to BillingLanding page");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void StoreIdEquity(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("StoreId", 0);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getWprId = stringArray[1].trim();
		testlog.info("Equity Id: " + getWprId);
		data.setCellData(SheetName, "ProjectID", rowNum, getWprId);
		testlog.info("Equity ID: " + getWprId);
		testlog.info("When User storing Equity ID in excel");
		testlog.pass("**Stored the Registered id  into excel successfully**");
	}
	
	public void SearchEquityByID(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERIdClick");
		testlog.info("When User clicks on WELL PerformanceRating from top menu under Projects");
		String werId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Equity ID: " + werId);
		CommonMethod.WaitUntilClickble("WERId", 60).sendKeys(werId);
		testlog.info("And User enter data to WerId");
		CommonMethod.RobustclickElementVisible("WERApplybtn","V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectSearchResultIDVerify", 1);
		int var = CommonMethod.ElementSize("V2ProjectSearchResultIDVerify");
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(var), "1", "Equity Search failed");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WERIdClick"), werId,
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("WERIdClick","WellV2DashboardTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		testlog.info("And User clicks on WerAdminId");
		testlog.info("Then User verifies WerId in search filter");
		testlog.pass("**Verifies the Search Equity ByID successfully**");
	}
	
	public void ValidDashboardWerField(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.WaitUntilPresence("DocumentLibraryTab", 30);
		CommonMethod.WaitUntilPresence("ScorecardTab", 30);
		CommonMethod.WaitUntilPresence("ReviewTab", 30);
		CommonMethod.WaitUntilPresence("V2ProjectSupportButton", 30);
		CommonMethod.WaitUntilPresence("AlternativesTab", 30);
		CommonMethod.WaitUntilPresence("LocationTab", 30);
		CommonMethod.WaitUntilPresence("ProfileTab", 30);
		CommonMethod.WaitUntilPresence("BiilingTab", 30);
		CommonMethod.WaitUntilPresence("TeamTab", 30);
		CommonMethod.WaitUntilPresence("PromotionTab", 30);
		CommonMethod.WaitUntilPresence("EditTab", 30);
		testlog.info("Then User verifies the Side Navigation Tab");
		testlog.pass("**Verifies Dashboard fields and SideBar Navigation tab successfully **");
}
	
	public void SearchEquityByRegisterStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERIdClick");
		testlog.info("When User clicks on WELL Equity from top menu under Projects");
		String werId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Equity ID: " + werId);
		CommonMethod.WaitUntilClickble("WERId", 60).sendKeys(werId);
		testlog.info("And User enter data to WprId");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERApplybtn", 0);
		CommonMethod.RobustclickElementVisible("WERApplybtn","V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var),"1","Equity Search failed");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WERIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " +status);
		CommonMethod.negativesoftassertFieldValid(status,"REGISTERED","Performance Search failed");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERIdClick", 0);
		CommonMethod.RobustclickElementVisible("WERIdClick","WellV2DashboardTab");
		testlog.info("And User clicks on WERId button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		testlog.info("Then User verifies WERStatus in search filter");
		testlog.pass("**Verifies the Search Equity ByID successfully**");
	}
	
	public void WerProjectFieldValidationTest(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab","HsrWprOrganizationInformation");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrWprOrganizationInformation", 0);
		CommonMethod.RobustclickElementVisible("HsrWprOrganizationInformation","HsrWprEditProjectName");
		testlog.info("And User clicks on OrganizationInformation tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrWprEditProjectName", 0);
		testlog.info("projectName: " + data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getattributeValue("HsrWprEditProjectName"),
				data.getCellData(SheetName, "projectName", rowNum), "Project Name doesn't match");
		testlog.info("WPRlocationsize: " + data.getCellData(SheetName, "WPRlocationsize", rowNum));
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getattributeValue("HsrWprEditArea").replace("sq ft", "").replace(",", "").trim(),
				data.getCellData(SheetName, "WERlocationsize", rowNum), "Area doesn't match");
		testlog.info("WPRlocations: " + data.getCellData(SheetName, "WPRlocations", rowNum));
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getattributeValue("HsrWprEditLocation"),
				data.getCellData(SheetName, "WERlocations", rowNum), "Location count doesn't match");
		testlog.info("OrgName: " + data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("OrgName"),
				data.getCellData(SheetName, "OrgName", rowNum), "OrgName doesn't match");
		testlog.info("OrgIndustry: " + data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getSelectedDropdownValue("HsrWprEditOrgIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "OrgIndustry doesn't match");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("HsrWprEditCountry"));
		  CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getSelectedDropdownAttribute(
		  "HsrWprEditCountry"), data.getCellData(SheetName, "Country", rowNum),
		  "Country doesn't match");
		 testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getSelectedDropdownValue("HsrWprEditState"),
				data.getCellData(SheetName, "State", rowNum), "State Name doesn't match");
		testlog.info("Street: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getattributeValue("HsrWprEditStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Street Name doesn't match");
		testlog.info("City: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getattributeValue("HsrWprEditCity"),
				data.getCellData(SheetName, "City", rowNum), "City doesn't match");
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getattributeValue("HsrWprPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "PostalCode doesn't match");
        testlog.info("Then User verifies the added details from excel");
        testlog.pass("**Verifies the WELL Equity Field Validation successfully**");
	}
	
	public void CompleteScorecardWerById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardTab", 0);
		CommonMethod.JavascriptClickElement("ScorecardTab");
		testlog.info("And User clicks on ScorecardTab");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommonScorecardPurseMaybe", 0);
		CommonMethod.RobustclickElementVisible("CommonScorecardPurseMaybe", "PortfolioScorecardPurseYesToNoConfirm");
		rc.confirmPursing();
		CommonMethod.RobustclickElementVisible("CommonScorecardPurseMaybe", "PortfolioScorecardPurseYesToNoConfirm");
		rc.confirmPursing();
		CommonMethod.WaitUntilInVisibility("WPRCloseIcon", 60);
		performance.ScorecardfillHSRWPR(21, 22, 49, 28, "CommonScorecardPurseYes", "CommonScorecardPurseNo");	
		testlog.info("And User clicks on 15 Yes button");
		testlog.info("And User clicks on 12 No button");
		testlog.info("Then User verifies Upload Document toast message");
		testlog.pass("**Verifies the 21 Purse Yes Scorecard Equity successfully**");
	}

	
	public void WERSubmitReview(String SheetName, int rowNum, String ReviewName) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab","WPRReviewSubmitbtn");
		testlog.info("When User clicks on Review button");
		CommonMethod.RobustclickElementVisible("WPRReviewSubmitbtn","WPRReviewProjectPhase");
		testlog.info("And User clicks on Submit DocReview button");
		CommonMethod.selectdropdownVisibletext("WPRReviewProjectPhase", ReviewName);
		testlog.info("And User select phase review");
		CommonMethod.WaitUntilClickble("WPRReviewComment", 60).sendKeys(ReviewName);
		testlog.info("And User enter data to Comment field");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewSubmitDocbtn", 0);
		CommonMethod.RobustclickElementVisible("WPRReviewSubmitDocbtn","ReviewViewButton");
		testlog.info("And User clicks on  Submit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Reviewlanding", 0);
		testlog.info("Then User will be redirected to Review list page");
		testlog.pass("**Submitted Preliminary Precertification Review successfully**");
	}
	public void WERCompleteReview(String SheetName, int rowNum, String ReviewName) throws IOException, InterruptedException {
		/*
		 * Admin Review
		 */
		AdminSearchWer(SheetName, rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab","ReviewViewButton");
		testlog.info("And User clicks on Review button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewViewButton", 0);
		CommonMethod.RobustclickElementVisible("ReviewViewButton","ReviewReturnButton");
		testlog.info("And User clicks on view button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewReturnButton", 0);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton","ReturnComment");
		testlog.info("And User clicks on Return button");
		testlog.info("And User Upload Review Document");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReturnComment", 0);
		CommonMethod.sendKeys("ReturnComment", ReviewName);
		testlog.info("And User enter data to Comment field");
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("DatePickerButton","DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton","ReviewPaymentstatusRadio");
		testlog.info("And User select Review Date");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("ReviewPaymentstatusRadio","ReviewReturnSubmit");
		testlog.info("And User check Paymentstatus checkboxes");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AwardedDate", 0);
		CommonMethod.RobustclickElementVisible("AwardedDate","DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton","ReviewReturnSubmit");
		testlog.info("And User select Awarded Date");
		CommonMethod.uploadMultipleFile("DocumentsUpload", SampleJpgfile,SampleJpgfile, "MultipeUploadDeleteicon",2,"MultipeUploadEnableButtonDeleteLink");
		CommonMethod.RobustclickElementVisible("ReviewReturnSubmit", "ReviewedStatus");
		testlog.info("And User clicks on Submit button");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ReviewedStatus"), "Reviewed", "Verified Review status successfully");
		testlog.info("Then User verifies Reviewed Status");
		testlog.pass("**Completed Reviewing Preliminary Precertification Review successfully**");
		
	}
	
	public void validateTeamsWER(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 120);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERIdClick");
		String werId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Equity ID: " + werId);
		CommonMethod.WaitUntilClickble("WERId", 60).sendKeys(werId);
		CommonMethod.RobustclickElementVisible("WERApplybtn","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var),"1","Equity Search failed");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WERIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		testlog.pass("**Verifies the Search Equity ByID can access the Project successfully**");
	}
	
	public void SearchEquityByAchievedStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard Page");
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLEquityNavBar");
		testlog.info("When User clicks on ProjectNavBar");
		CommonMethod.RobustclickElementVisible("WELLEquityNavBar","WERIdClick");
		testlog.info("And User clicks on WELLPerformanceRatingNavBar");
		String werId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Equity ID: " + werId);
		CommonMethod.WaitUntilPresence("WPRId", 60);
		CommonMethod.clearAndSendKey("WPRId", werId);
		testlog.info("And User enters to WERId field");
		CommonMethod.RobustclickElementVisible("WERApplybtn","V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on apply button");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var),"1","Equity Search failed");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount),"1","Performance Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.RobustclickElementVisible("WPRApplybtn","V2ProjectSearchResultIDVerify");
		int ProjectCount1 = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount1),"1","Performance Search Count failed");
		CommonMethod.assertcontainsmessage("WERIdClick", data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " +status);
		CommonMethod.negativesoftassertFieldValid(status,"ACHIEVED","Performance Search failed");
		rc.ValidateDateInList();
		testlog.info("Then User verifies Project Acheieved Status");
		testlog.pass("**Verifies the Search Equity Achieved Status successfully**");
	}
	
	public void AdminSearchWer(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * Admin Review
		 */
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminNavBar","AdminWELLEquityNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminWELLEquityNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminWELLEquityNavBar", "WPRAdminIdSearch");
		testlog.info("When User clicks on WELL Equity from top menu under Projects");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAdminIdSearch", 0);
		CommonMethod.WaitUntilClickble("WPRAdminIdSearch", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enter data to WerId");
		CommonMethod.RobustclickElementVisible("WPRAdminApplybtn","WPRAdminIdClick");
		testlog.info("And User clicks on Apply button");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRAdminIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("WPRAdminIdClick","WellV2DashboardTab");
		testlog.info("And User clicks on WprAdminId");
		
		}
	
	public void ValidateDocumentInDocumentLibrary(String SheetName, int rowNum, String Access)
			throws Exception {
		/*
		 * For Document tab
		 */

		if (Access.equalsIgnoreCase("true")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
				CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink",
						PortfolioAndRatingLocAccDocumentTable);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
				rc.deleteButtonTooltipMessage();
				Thread.sleep(2000);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RatingDocRestrictDeleteAccesspopup", 0);
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getattributeValueByTextContent("RatingDocRestrictDeleteAccesspopup"),
						toolTipMessage, "Delete Restriction Error Mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CancelTooltipPopUpInDocument", 0);
			CommonMethod.RobustclickElementVisible("CancelTooltipPopUpInDocument", PortfolioAndRatingLocAccDocumentTable);
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
			CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink",
					PortfolioAndRatingLocAccDocumentTable);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
			CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
			rc.documentTableDeleteButton();

		}
	}
	
	public void ValidatePTAInsideScorecard(String SheetName, int rowNum, String FeatureName, String Access)
			throws Exception {
		CommonMethod.WaitUntilVisibility("ScorecardTab", 300);
		CommonMethod.JavascriptClickElement("ScorecardTab");
		testlog.info("And User clicks on ScorecardTab");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRPortfolioScorecardLanding", 0);
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		List<WebElement> Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		testlog.info("Fetching total no. of credits on page");
		System.out.println("FeatureName: " + FeatureName);
		testlog.info("TaskName : " + FeatureName);
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						PortfolioAndRatingLocAccDocumentTable);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				Thread.sleep(2000);
				if (Access.equalsIgnoreCase("true")) {
					rc.documentTableDeleteButton();

				} else {
				rc.deleteButtonTooltipMessage();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RatingDocRestrictDeleteAccesspopup", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("RatingDocRestrictDeleteAccesspopup"),toolTipMessage,
								"Delete Restriction Error Mismatch");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CancelTooltipPopUpInScorecard", 0);
				CommonMethod.RobustclickElementVisible("CancelTooltipPopUpInScorecard", "PtDeleteIcon");
				}
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilPresence("WPRPortfolioScorecardLanding", Scorecardtimeout);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +FeatureName +" doesn't match");
	}
	
	public void WERPurseScorecard(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("ScorecardTab", 300);
		CommonMethod.RobustclickElementVisible("ScorecardTab", "WPRPortfolioScorecardLanding");
		testlog.info("And User clicks on ScorecardTab");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilVisibility("WPRPortfolioScorecardLanding", Scorecardtimeout);
		// MayBe
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERPurseSelectMaybebtn", 0);
		CommonMethod.JavascriptClickElement("WERPurseSelectMaybebtn");
		rc.confirmPursing();
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 30)) {
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERPurseSelectMaybebtn1", 0);
		CommonMethod.JavascriptClickElement("WERPurseSelectMaybebtn1");
		rc.confirmPursing();
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 20)) {
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		}
		// No
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERPurseSelectNobtn", 0);
		CommonMethod.JavascriptClickElement("WERPurseSelectNobtn");
		if (CommonMethod.isElementsExist("PortFolioScoreCardConfirmbtn", 10)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioScoreCardConfirmbtn", 0);
			CommonMethod.RobustclickElementVisible("PortFolioScoreCardConfirmbtn", "PortfolioScorecardPursueToast");
		}
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 20)) {
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERPurseSelectNo1btn", 0);
		CommonMethod.JavascriptClickElement("WERPurseSelectNo1btn");
		if (CommonMethod.isElementsExist("WERScoreCardConfirmbtn", 15)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERScoreCardConfirmbtn", 0);
			CommonMethod.RobustclickElementVisible("WERScoreCardConfirmbtn", "PortfolioScorecardPursueToast");
		}
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 20)) {
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		}
		testlog.pass("**Verifies the 15 Purse Yes Scorecard Performance successfully**");
	}
	
	public void ValidatePostReviewInScorecardFeature(String SheetName, int rowNum, String FeatureName, String Commodity) throws Exception {
		
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("PortfolioHSRScorecardPartFeature");
		boolean flag = false;
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRVerficationTab", 0);
				CommonMethod.RobustclickElementVisible("WPRVerficationTab", "PortfolioScorecardPurseLocCount");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseLocCount", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardPurseLocCount"),
						"6 Achieved", "Feature Achieved location Count doesn't match");
				
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation", "WERAssignLocationsModalStatus");
				List<WebElement> getStatus = CommonMethod.findElements("WERAssignLocationsModalStatus");
				testlog.info("Fetching Data from Upload Table");
                for(int i=0; i<getStatus.size(); i++) {
					String getEachStatus = getStatus.get(i).getText();
					CommonMethod.negativesoftassertFieldValid(getEachStatus, "Achieved", "Status Achieved doesn't matched");
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");	
				CommonMethod.scrollDown();
				ValidatePostReview(SheetName, rowNum, FeatureName, Commodity);
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Validate Post Review successfully**");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +FeatureName +" doesn't match");
	}
	
	public void ValidatePostReviewInScorecardAudit(String SheetName, int rowNum, String FeatureName, String Commodity) throws Exception {
		
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("PortfolioHSRScorecardPartFeature");
		boolean flag = false;
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRVerficationTab", 0);
				CommonMethod.RobustclickElementVisible("WPRVerficationTab", "PortfolioScorecardAuditAcheiveLocCount");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAuditAcheiveLocCount", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardAuditAcheiveLocCount"),
						"2 Achieved", "Audit Achieved location Count doesn't match");			
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation", "WERAssignLocationsModalStatus");
				List<WebElement> getStatus = CommonMethod.findElements("WERAssignLocationsModalStatus");
				testlog.info("Fetching Data from Upload Table");
				for(int i=0; i<getStatus.size(); i++) {
					
					String getEachStatus = getStatus.get(i).getText();
					CommonMethod.negativesoftassertFieldValid(getEachStatus, "Achieved", "Status Achieved doesn't matched");
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");	
				CommonMethod.scrollDown();
				ValidatePostReview(SheetName, rowNum, FeatureName, Commodity);
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Validate Post Review successfully**");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +FeatureName +" doesn't match");
	}
	

    public void ValidatePostReview(String SheetName, int rowNum, String FeatureName, String Commodity) throws Exception {	 
	pathprms.put("Status", "Reviewed");
	generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity,false, false, false, false, false, true, true, false);
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERScorecardTableOptions", 0);
	List<String> OptionsText = new ArrayList<>();
	OptionsText.add("Fulfills Part");
	OptionsText.add("Approved");
	CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WERScorecardTableOptions"), 
	OptionsText, "Feature OR Audit Table Options Text doesn't match");
	testlog.info("And User verifies Options Text In Document Table List");
	rc.documentTableEditButton();
	CommonMethod.assertisElementPresentTrue("ScorecardUploadEditDocumentLink", "Remove button is invisible");
	testlog.info("And User verifies Document link");
	List<String> Featurestatus = new ArrayList<>();
	Featurestatus.add("Fulfills Part");
	Featurestatus.add("Approved");
	CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardReviewStatusInAddPartLink"), 
	Featurestatus, "Feature Review Status In AddPart Link list doesn't match");
	testlog.info("And User verifies Review Status In AddPart Link");
  }
    
    public void ValidatePostReviewArchiveDocumentFunctionality(String SheetName, int rowNum, String featureName, String Commodity) throws Exception { 
    	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHSRScorecardPartFeature", 0);
    	testlog.info("Given User is on Scorecard page");
		boolean flag = false;
		List<WebElement> Feature = CommonMethod.findElements("PortfolioHSRScorecardPartFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScorecardEditLocation");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				testlog.info("And User will be redirected to Document Upload Table page");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableTr", 0);
				ValidateArchiveDocuments(SheetName, rowNum, Commodity);
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Validate Post Review successfully**");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +featureName +" doesn't match");
  }

	public void ValidateArchiveDocuments(String SheetName, int rowNum, String Commodity) throws Exception {
		if (TestCaseName.equalsIgnoreCase("Equity_TC_10_11_MoveOnArchiveAndValidateArchiveInDocumentList")) {

			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentFilterOption", 0);
			CommonMethod.Robustclick("WPRDocumentFilterOption");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
		CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardArchiveMenuBtn", 0);
		CommonMethod.Robustclick("PortfolioScorecardArchiveMenuBtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardArchiveBtn", 0);
		CommonMethod.Robustclick("PortfolioScorecardArchiveBtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardArchivedText", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
		CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardShowArchivedDocumentsToggle", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardShowArchivedDocumentsToggle");
		if(TestCaseName.equalsIgnoreCase("Equity_TC_10_11_MoveOnArchiveAndValidateArchiveInDocumentList")) {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERDocumentTablePageSevenNav", 0);
		CommonMethod.scrolldowntoElement("WERDocumentTablePageSevenNav");
		CommonMethod.JavascriptClickElement("WERDocumentTablePageSevenNav");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardArchivedText", 0);
		CommonMethod.ScrollUpToElement("PortfolioScorecardArchivedText");
		String ArchivedText = CommonMethod.getattributeValueByTextContent("PortfolioScorecardArchivedText");
		CommonMethod.negativesoftassertFieldValid("Archived", ArchivedText,
				"Archived Document Status does not matched");
	}
	
	public void purseYesToMaybeValidFromScorecard(String SheetName, int rowNum, String Commodity) throws Exception {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERScorecardPurseYesToMaybeSelectedForCDAAP", 0);
		CommonMethod.JavascriptClickElement("WERScorecardPurseYesToMaybeSelectedForCDAAP");
		testlog.info("And User click on Purse Maybe");
		rc.confirmPursing();
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("WERScorecardPurseYesToMaybeSelectedForCDAAP", 1);
		CommonMethod.assertisElementPresentTrue("WERScorecardPurseYesToMaybeSelectedForCDAAP", "PurseMaybe is not selected");
		testlog.info("And User verifies the Selected Purse Maybe");
		testlog.info("Then User verifies the Pursue status message");
		testlog.pass("**Verifies the Pursue Maybe status successful**");
	}
	
	public void purseYesToNoValidFromScorecard(String SheetName, int rowNum, String Commodity) throws Exception {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERScorecardPurseYesToNoSelectedForIID", 0);
		CommonMethod.JavascriptClickElement("WERScorecardPurseYesToNoSelectedForIID");
		testlog.info("And User click on Purse No");
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoCancel", 0);
		testlog.info("And User verifies confirm button");
		testlog.info("And User verifies cancel button");
		// cancel
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoCancel");
		// Confirm
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERScorecardPurseYesToNoSelectedForIID", 0);
		CommonMethod.Robustclick("WERScorecardPurseYesToNoSelectedForIID");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoConfirm");
		
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("WERScorecardPurseYesToNoSelectedForIID", 1);
		CommonMethod.assertisElementPresentTrue("WERScorecardPurseYesToNoSelectedForIID", "PurseMaybe is not selected");
		testlog.info("And User verifies the Selected Purse Maybe");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"),
				"Pursue status changed!", "Purse Status message Doesn't match");
		testlog.info("Then User verifies the Pursue status message");
		testlog.pass("**Verifies the Pursue Maybe status successful**");
	}
}
