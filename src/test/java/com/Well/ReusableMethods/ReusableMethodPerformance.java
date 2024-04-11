package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodPerformance extends BaseClass {
	String PortfolioAndRatingLocAccDocumentTable ="PortfolioAndRatingLocAccDocumentTable";
	
	public void RegisterPerformance(String SheetName, int rowNum, String DataValidate, String ProjectName)
			throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified account");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLPerformanceRatingNavBar");
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRstartNewProject");
		testlog.info("When User clicks on WELL PerformanceRating from top menu under Projects");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRstartNewProject", 0);
		CommonMethod.RobustclickElementVisible("WPRstartNewProject", "WPREnrollOption");
		testlog.info("And User clicks on Start project button");
		CommonMethod.RobustclickElementVisible("WPREnrollOption", "WPRenrollbtn");
		testlog.info("And User clicks on EnrollNow button");
		CommonMethod.RobustclickElementVisible("WPRenrollbtn", "WPROrgContinebtn");
		testlog.info("And User clicks on Enroll button");
		String AccountName = ProjectName + "_"+ CommonMethod.randomNumber(8000000);
		testlog.info("ProjectName: " + AccountName);
		data.setCellData(SheetName, "projectName", rowNum, AccountName);
		CommonMethod.RobustclickElementVisible("WPROrgContinebtn", "WPROrgName");
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner name is required.", "Owner Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Industry is required.",
				"Organization Industry Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Consultant is required.", "Consultant Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		testlog.info(
				"And User clicks on continue button without entering the mandatory fields and verifies error meassage");
		CommonMethod.sendKeys("WPROrgName", AccountName);
		testlog.info("And User enter data to EnrollName");
		CommonMethod.ClickCheckbox("WPROwnerInfocbx");
		testlog.info("And User checks the enroll checkbox");
		rc.SelectOwnerOrg(SheetName, rowNum);
		data.setCellData(SheetName, "OrgName", rowNum, CommonMethod.getText("OrgName"));
		testlog.info("OrganizationName: " + data.getCellData(SheetName, "OrgName", rowNum));
		String Ownername = USfaker.address().firstName();
		CommonMethod.WaitUntilPresence("WPROwnerName", 30);
		CommonMethod.sendKeys("WPROwnerName", Ownername);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("WPROwnerName"));
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		 rc.SelectEnterpriseProviders(SheetName,rowNum);
		CommonMethod.selectdropdownValue("WPRExamOwnerCountry", "US");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("WPRExamOwnerCountry"));
		CommonMethod.selectdropdownrandom("WPRExamOwnerState");
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("WPRExamOrgAddress", ProjectAddress);
		CommonMethod.sendKeys("WPRExamOrgCity", ProjectCity);
		CommonMethod.sendKeys("WPRExamOrgPostalcode", PostalCode);
		data.setCellData(SheetName, "Country", rowNum,
				CommonMethod.getSelectedDropdownAttribute("WPRExamOwnerCountry"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getattributeValue("WPRExamOwnerState"));
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("WPRExamOrgAddress"));
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("WPRExamOrgCity"));
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("WPRExamOrgPostalcode"));
		testlog.info("And User enter data to Owner Country, State, Street address, City and Postal Code fields");
		testlog.info("Organization Address: " + ProjectAddress);
		testlog.info("Organization City: " + ProjectCity);
		testlog.info("Organization Postalcode: " + PostalCode);
		CommonMethod.ClickCheckbox("WPROwnercbx");
		testlog.info("And User checks the Billing checkbox");
		CommonMethod.scrollDown();
		CommonMethod.RobustclickElementVisible("WPROrgContinebtn", "WPROwnerRegContinuebtn");
		testlog.info("And User clicks on continue button");
		if (DataValidate.equalsIgnoreCase("true")) {
			CommonMethod.RobustclickElementVisible("WPRBackToHomepagebutton", "WPROrgContinebtn");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPROrgName"), ProjectName,
					"ProjectName Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("OrgName"),
					data.getCellData(SheetName, "OrgName", rowNum), "Org Name Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("OrgIndustry"),
					data.getCellData(SheetName, "OrgIndustry", rowNum), "Org Industry Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownAttribute("WPRExamOwnerCountry"),
					data.getCellData(SheetName, "Country", rowNum), "Country Name Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPRExamOwnerState"),
					data.getCellData(SheetName, "State", rowNum), "State Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPRExamOrgAddress"),
					data.getCellData(SheetName, "Street", rowNum), "Street Name Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPRExamOrgCity"),
					data.getCellData(SheetName, "City", rowNum), "City Name Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPRExamOrgPostalcode"),
					data.getCellData(SheetName, "PostalCode", rowNum), "Postal code Error Mismatch");
			testlog.info("And User verifies the added details about you by clicking on back button");
		}
		testlog.info("And User verifies the added details about you by clicking on back button");
		CommonMethod.RobustclickElementVisible("WPROrgContinebtn", "WPROwnerRegContinuebtn");
		testlog.info("And User clicks on continue button");
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.RobustclickElementVisible("WPROwnerRegContinuebtn", "WPRBehalfCbx");
		CommonMethod.negativesoftassertPageSource("On behalf of owner is required.", "Owner CheckBox Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Is the Owner organization an IWBI member?* is required.",
				"Owner Organization Name Error Mismatch");
		testlog.info(
				"And User clicks on continue button without entering the mandatory fields and verifies error meassage");
		CommonMethod.ClickCheckbox("WPRBehalfCbx");
		testlog.info("And User checks the Behalf checkbox");
		CommonMethod.selectdropdownVisibletext("WPRSelectMember", "No");
		testlog.info("And User select Iwbi member");
		data.setCellData(SheetName, "WPRSelectMember", rowNum,
				CommonMethod.getSelectedDropdownValue("WPRSelectMember"));
		CommonMethod.RobustclickElementVisible("WPROwnerRegContinuebtn", "WPRlocations");
		if (DataValidate.equalsIgnoreCase("true")) {
			CommonMethod.RobustclickElementVisible("BackButton", "WPROwnerRegContinuebtn");
			CommonMethod.VerifyRadioOrCheckboxSelcted("WPRBehalfCbx");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("WPRSelectMember"),
					data.getCellData(SheetName, "WPRSelectMember", rowNum), "Member Value Error Mismatch");
			CommonMethod.RobustclickElementVisible("WPROwnerRegContinuebtn", "WPRlocations");
			testlog.info("And User verifies the added details about you by clicking on back button");
		}
		Thread.sleep(2000);
		CommonMethod.scrollUp();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRlocations", 0);
		CommonMethod.sendKeys("WPRlocations", "10");
		testlog.info("And User enter data to location");
		data.setCellData(SheetName, "WPRlocations", rowNum, CommonMethod.getattributeValue("WPRlocations"));
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpacetype", "HsrWPRlocationsSpaceOption");
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpaceOption", "WPRlocationsize");
		testlog.info("And User select the space type");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		testlog.info("Locationsize: " + Area);
		CommonMethod.clearAndSendKey("WPRlocationsize", Area);
		testlog.info("And User enter the Location Size");
		data.setCellData(SheetName, "WPRlocationsize", rowNum, CommonMethod.getattributeValue("WPRlocationsize"));
		CommonMethod.WaitUntilClickble("WPROwnerRegContinuebtn", 60);
		CommonMethod.RobustclickElementVisible("WPROwnerRegContinuebtn", "WPRReviewContinuebutton");
		testlog.info("And User clicks on continue button");
		if (DataValidate.equalsIgnoreCase("true")) {
			CommonMethod.RobustclickElementVisible("BackButton", "WPROwnerRegContinuebtn");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPRlocations"),
					data.getCellData(SheetName, "WPRlocations", rowNum), "Location Value Error Mismatch");
			// CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("HsrWPRlocationsSpacetype"),data.getCellData(SheetName,
			// "WPRSelectMember", rowNum), "Location Value Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("WPRlocationsize"),
					data.getCellData(SheetName, "WPRlocationsize", rowNum), "Area Size Error Mismatch");
			CommonMethod.RobustclickElementVisible("WPROwnerRegContinuebtn", "WPRReviewContinuebutton");
			testlog.info("And User verifies the added details about you by clicking on back button");
		}
		if (CommonMethod.isElementsExist("HsrWPRYesMyOrganizationCbx", 2)) {
			CommonMethod.RobustclickElementVisible("WPRReviewContinuebutton", "HsrWPRYesMyOrganizationCbx");
			testlog.info("And User clicks on continue button");
			CommonMethod.negativesoftassertPageSource(
					"Yes, my organization meets the criteria of the listed discount category.* is required.",
					"My Organization CheckBox Error Name");
			CommonMethod.WaitUntilClickble("HsrWPRYesMyOrganizationCbx", 30);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
			testlog.info("And User checks the MyOrganization checkbox");
		}
		CommonMethod.RobustclickElementVisible("WPRReviewContinuebutton", "WPRtermContinuebutton");
		if (CommonMethod.isElementsExist("WPRProgramFeePublicrbtn", 20)) {
			CommonMethod.WaitUntilClickble("WPRProgramFeePublicrbtn", 60);
			CommonMethod.ClickCheckbox("WPRProgramFeePublicrbtn");
			testlog.info("And User checks the Program Fee Public checkbox");
		}
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilClickble("WPRAcknowledecbx", 60);
		CommonMethod.ClickCheckbox("WPRAcknowledecbx");
		testlog.info("And User checks the Acknowledge checkbox");
		CommonMethod.RobustclickElementVisible("WPRtermContinuebutton", "BillingLanding");
		testlog.info("And User clicks on continue button");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.info("Then User will be redirected to BillingLanding page");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void StoreIdPerformance(String SheetName, int rowNum) throws IOException, InterruptedException {
		if (CommonMethod.isElementsExist("HsrIframe", 5)) {
			CommonMethod.WaitUntilPresence("HsrIframe", 180);
			CommonMethod.switchToFrame("HsrIframe");
			CommonMethod.WaitUntilPresence("HsrCloseCard", 60);
			CommonMethod.Robustclick("HsrCloseCard");
			CommonMethod.switchToParentFrame();
		}
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 300);
		CommonMethod.WaitUntilVisibility("StoreId", 30);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getWprId = stringArray[1].trim();
		testlog.info("Performance Id: " + getWprId);
		data.setCellData(SheetName, "ProjectID", rowNum, getWprId);
		testlog.info("Performance ID: " + getWprId);
		testlog.info("When User storing Performance ID in excel");
		testlog.pass("**Stored the Registered id  into excel successfully**");
	}

	public void SearchPerformanceByID(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLPerformanceRatingNavBar");
		CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRIdClick");
		testlog.info("When User clicks on WELL PerformanceRating from top menu under Projects");
		String wprId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Performance ID: " + wprId);
		CommonMethod.WaitUntilClickble("WPRId", 60).sendKeys(wprId);
		testlog.info("And User enter data to WprId");
		CommonMethod.RobustclickElementVisible("WPRApplybtn", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectSearchResultIDVerify", 1);
		int ProjectCount = CommonMethod.ElementSize("V2ProjectSearchResultIDVerify");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount), "1", "HealthSafety Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "projectName", rowNum));
		testlog.info("And User enter data to WprName");
		CommonMethod.RobustclickElementVisible("WPRApplybtn", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectSearchResultIDVerify", 1);
		int ProjectNameCount = CommonMethod.ElementSize("V2ProjectSearchResultIDVerify");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectNameCount), "1", "Portfolio Search failed");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project Id doesn't matches in search");
		CommonMethod.RobustclickElementVisible("WPRIdClick", "WellV2DashboardTab");
		testlog.info("And User clicks on WprAdminId");
		testlog.info("Then User verifies WprId in search filter");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 300);
		testlog.pass("**Verifies the Search Performance ByID successfully**");
	}

	public void SearchPerformanceFilterStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLPerformanceRatingNavBar");
		CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRIdClick");
		testlog.info("When User clicks on WELL PerformanceRating from top menu under Projects");
		String wprId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Performance ID: " + wprId);
		CommonMethod.WaitUntilClickble("WPRId", 60).sendKeys(wprId);
		testlog.info("And User enter data to WprId");
		CommonMethod.RobustclickElementVisible("WPRApplybtn", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectSearchResultIDVerify", 1);
		int ProjectNameCount = CommonMethod.ElementSize("V2ProjectSearchResultIDVerify");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectNameCount), "1", "HealthSafety Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "HsrName", rowNum));
		testlog.info("And User enter data to WprName");
		CommonMethod.RobustclickElementVisible("WPRApplybtn", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectSearchResultIDVerify", 1);
		int ProjectCount = CommonMethod.ElementSize("V2ProjectSearchResultIDVerify");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount), "1", "Portfolio Search failed");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project Id doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " + status);
		CommonMethod.negativesoftassertFieldValid(status, "REGISTERED", "Performance Search failed");
		CommonMethod.RobustclickElementVisible("WPRIdClick", "WellV2DashboardTab");
		testlog.info("And User clicks on WPRId button");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 300);
		testlog.info("Then User verifies WPRStatus in search filter");
		testlog.pass("**Verifies the Search Performance ByID successfully**");
	}

	public void ValidDashboardWprField(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DocumentLibraryTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSupportButton", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AlternativesTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProfileTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("BiilingTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TeamTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PromotionTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		testlog.info("Then User verifies the Side Navigation Tab");
		testlog.pass("**Verifies Dashboard fields and SideBar Navigation tab successfully **");
	}

	public void ScorecardfillHSRWPR(int YesEnd, int NoStart, int NoEnd, int DifferencePlusOne, String purseYes,
			String purseNo) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(purseYes, 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(purseNo, 0);
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		Boolean flag = false;
		YesButton = CommonMethod.findElements(purseYes);
		for (int i = 1; i <= YesEnd; i++) {
			long startTime = System.currentTimeMillis();
			int RemainingYes = YesButton.size();
			do {
				if(!((System.currentTimeMillis() - startTime) < 60000)) {
					flag = true;
					System.out.println("Build Stuck");
					break;
				}
				CommonMethod.WaitUntilClickble(purseYes, 60);
				CommonMethod.JavascriptClickElement(purseYes);
				if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 10)) {
					CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
					}
				Thread.sleep(2000);
				YesButton = CommonMethod.findElements(purseYes);
			} while ((YesButton.size() == RemainingYes));
			RemainingYes--;
			if(flag) {
				System.out.println("Build Exit");
				break;
			}
		}
		NoButton = CommonMethod.findElements(purseNo);
		int j = DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			long startTime = System.currentTimeMillis();
			int RemainingNo = NoButton.size();
			do {
				if(!((System.currentTimeMillis() - startTime) < 60000)) {
					flag = true;
					System.out.println("Build Stuck");
					break;
				}
				CommonMethod.WaitUntilClickble(NoButton.get(RemainingNo - j), 30);
				CommonMethod.JavascriptClickElement(NoButton.get(RemainingNo - j));
				if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 10)) {
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
				}
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements(purseNo);
			} while ((NoButton.size() == RemainingNo));
			RemainingNo--;
			j--;
			if(flag) {
				System.out.println("Build Exit");
				break;
			}
		}
	}

	public void VerifyReviewErrorMessageByMinScorecardPurseYes() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardTab", 0);
		CommonMethod.JavascriptClickElement("ScorecardTab");
		testlog.info("And User clicks on ScorecardTab");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRPortfolioScorecardLanding", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommonScorecardPurseYes", 0);
		CommonMethod.RobustclickElementVisible("CommonScorecardPurseYes", "PortfolioScorecardPursueToast");
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 10)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
			}
		CommonMethod.RobustclickElementVisible("CommonScorecardPurseYes", "PortfolioScorecardPursueToast");
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 10)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
			}
		// Verify Review ErrorMessage ByMinScorecardPurseYes
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "WPRReviewSubmitbtn");
		testlog.info("When User clicks on Review button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewSubmitbtn", 0);
		CommonMethod.RobustclickElementVisible("WPRReviewSubmitbtn", "WPRReviewProjectPhase");
		testlog.info("And User clicks on Submit DocReview button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ValidReviewErrorMessage1", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("ValidReviewErrorMessage1"),
				"Oops! It looks like your scorecard is incomplete.",
				"Review Mark Error message doesn't match");
		testlog.info("And User verifies Review ErrorMessage By Minimum selecting ScorecardPurseYes");

	}

	public void CompleteScorecardWprById(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewSubmitbtn", 0);
		CommonMethod.WaitUntilVisibility("ScorecardTab", 300);
		CommonMethod.RobustclickElementVisible("ScorecardTab", "WPRPortfolioScorecardLanding");
		testlog.info("And User clicks on ScorecardTab");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommonScorecardPurseMaybe", 0);
		CommonMethod.RobustclickElementVisible("CommonScorecardPurseMaybe", "PortfolioScorecardPurseYesToNoConfirm");
		rc.confirmPursing();
		CommonMethod.RobustclickElementVisible("CommonScorecardPurseMaybe", "PortfolioScorecardPurseYesToNoConfirm");
		rc.confirmPursing();
		CommonMethod.WaitUntilInVisibility("WPRCloseIcon", 60);
		ScorecardfillHSRWPR(21, 22, 38, 17, "CommonScorecardPurseYes", "CommonScorecardPurseNo");
		testlog.info("And User clicks on 21 Yes button");
		testlog.info("And User clicks on 17 No button");
		testlog.info("Then User verifies Upload Document toast message");
		testlog.pass("**Verifies the 15 Purse Yes Scorecard Performance successfully**");
	}

	public void uploadDocumentInFeature(int LastFeatureNumber, String Commodity) throws Exception {
		List<WebElement> Feature;
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
		for (WebElement f : Feature) {
			CommonMethod.WaitUntilClickble(f, 120);
			CommonMethod.JavascriptClickElement(f);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRVerficationTab", 0);
			CommonMethod.RobustclickElementVisible("WPRVerficationTab", "WPRAddOption");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOption", 0);
			CommonMethod.JavascriptClickElement("WPRAddOption");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOptionbtn", 0);
			CommonMethod.Robustclick("WPRAddOptionbtn");
			Thread.sleep(2000);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOptionCloseIcon", 0);
			CommonMethod.Robustclick("WPRAddOptionCloseIcon");
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRAddOptionCloseIcon", 1);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocbtn", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignbtn", 0);
			generic.assignLocationGeneric(Commodity, false, false, true, false, false);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRUploadDocTaskbtn", 0);
			List<WebElement> UploadButton;
			Thread.sleep(2000);
			UploadButton = CommonMethod.findElements("WPRScorecardUploadTaskDocument");
			for (WebElement uploadButton : UploadButton) {
				CommonMethod.JavascriptClickElement(uploadButton);
				CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
						rc.ScorecardUploadSaveButton();
						rc.ScorecardConfirmLocUploadSaveButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("UploadDocumentModalCommon", 1);
				if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 5)) {
					CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 120);
				}
				CommonMethod.WaitUntilPresence(PortfolioAndRatingLocAccDocumentTable, 120);
			}
			CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
			CommonMethod.JavascriptClickElement(f);
		}
	}

	public void UploadWPRDocForFeature(String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRPortfolioScorecardLanding", 0);
		uploadDocumentInFeature(21, Commodity);
		testlog.info("When User clicks on Feature");
		testlog.info("And User clicks on Verification tab");
		testlog.info("And User clicks on Add Option button");
		testlog.info("And User clicks on Add button");
		testlog.info("And User clicks on Close icon");
		testlog.info("And User clicks on Assign button");
		testlog.info("And User checks on Assign location");
		testlog.info("And User clicks on Save button");
		testlog.info("And User clicks on Upload button");
		testlog.info("And User upload Scorecard Document");
		testlog.info("And User clicks on Save button");
		testlog.info("Then User verifies popup message");
		testlog.info("And User verifies Upload Document Table");
		testlog.info("And User verifies green colour for Completed task");
		testlog.pass("**Upload 21 Scorecard Documents successfully**");
	}

	public void SubmitWPRReview(String SheetName, int rowNum, String ReviewName)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "WPRReviewSubmitbtn");
		testlog.info("When User clicks on Review button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewSubmitbtn", 0);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewSubmitbtn", 0);
		CommonMethod.RobustclickElementVisible("WPRReviewSubmitbtn", "WPRReviewProjectPhase");
		testlog.info("And User clicks on Submit DocReview button");
		CommonMethod.WaitUntilInVisibility("ReviewSubmitDocValid", 120);
		testlog.info("Vaildated scorecard is incomplete message");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewModelSubmitButton", 0);
		CommonMethod.RobustclickElementVisible("ReviewModelSubmitButton", "ErrorMessage");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ErrorMessage", 0);
		CommonMethod.negativesoftassertPageSource("Doc-submit-phase is required.", "Phase Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource(
				"Please provide your comments below to notify the IWBI team is required.",
				"Comment Name Error Mismatch");
		testlog.info(
				"And User clicks on SubmitDocReview button without entering the mandatory fields and verifies error meassage");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewProjectPhase", 0);
		testlog.info("ReviewName: " + ReviewName);
		CommonMethod.selectdropdownValue("WPRReviewProjectPhase", ReviewName);
		testlog.info("And User select phase review");
		CommonMethod.WaitUntilClickble("WPRReviewComment", 60).sendKeys(ReviewName);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewModelSubmitButton", 0);
		CommonMethod.RobustclickElementVisible("ReviewModelSubmitButton", "Table");
		testlog.info("And User clicks on  Submit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Reviewlanding", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Table", 0);
		testlog.info("Then User will be redirected to Review list page");
		testlog.pass("**Submitted Performance Review successfully**");
	}

	public void ClickBilling() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("BiilingTab", 0);
		CommonMethod.RobustclickElementVisible("BiilingTab", "BillingProjectInvoice");
		CommonMethod.WaitUntilPresence("BillingProjectInvoice", 120);
		CommonMethod.RobustclickElementVisible("BillingProjectInvoice", "BillingCurativeAction");
		CommonMethod.WaitUntilPresence("BillingCurativeAction", 120);
		CommonMethod.RobustclickElementVisible("BillingCurativeAction", "V2ProjectPreBillingPayNowButton");
		CommonMethod.WaitUntilPresence("V2ProjectPreBillingPayNowButton", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectPreBillingPayNowButton", "BillingLanding");
		CommonMethod.WaitUntilPresence("BillingLanding", 120);
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void CompleteWPRReview(String SheetName, int rowNum, String ReviewName)
			throws IOException, InterruptedException {
		AdminWprSearch(SheetName, rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "ReviewViewButton");
		testlog.info("And User clicks on Review button");
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		CommonMethod.RobustclickElementVisible("ReviewViewButton", "ReviewReturnButton");
		testlog.info("And User clicks on view button");
		CommonMethod.WaitUntilVisibility("ReviewReturnButton", 60);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton", "ReturnComment");
		testlog.info("And User clicks on Return button");
		testlog.info("And User Upload Review Document");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys(ReviewName);
		testlog.info("And User enter data to Comment field");
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("DatePickerButton", "DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "ReviewPaymentstatusRadio");
		testlog.info("And User select Review Date");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		testlog.info("And User check Paymentstatus checkboxes");
		CommonMethod.uploadMultipleFile("DocumentsUpload", PortfolioLocationImportfile,PortfolioLocationImportfile, "MultipeUploadDeleteicon",2,"MultipeUploadEnableButtonDeleteLink");
		CommonMethod.RobustclickElementVisible("ReviewReturnSubmit", "ReviewedStatus");
		testlog.info("And User clicks on Submit button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilPresence("ReviewedStatus", 300);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status successfully");
		testlog.info("Then User verifies Reviewed Status");
		testlog.pass("**Completed Performance Review successfully**");
	}

	public void WprProjectFieldValidationTest(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "HsrWprOrganizationInformation");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilVisibility("HsrWprOrganizationInformation", 60);
		CommonMethod.RobustclickElementVisible("HsrWprOrganizationInformation", "HsrWprEditProjectName");
		testlog.info("And User clicks on OrganizationInformation tab");
		CommonMethod.WaitUntilVisibility("HsrWprEditProjectName", 30);
		testlog.info("projectName: " + data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("HsrWprEditProjectName"),
				data.getCellData(SheetName, "projectName", rowNum), "Project Name doesn't match");
		testlog.info("WPRlocationsize: " + data.getCellData(SheetName, "WPRlocationsize", rowNum));
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValue("HsrWprEditArea").replace("sq ft", "").replace(",", "").trim(),
				data.getCellData(SheetName, "WPRlocationsize", rowNum), "Area doesn't match");
		testlog.info("WPRlocations: " + data.getCellData(SheetName, "WPRlocations", rowNum));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("HsrWprEditLocation"),
				data.getCellData(SheetName, "WPRlocations", rowNum), "Location count doesn't match");
		testlog.info("OrgName: " + data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("OrgName"),
				data.getCellData(SheetName, "OrgName", rowNum), "OrgName doesn't match");
		testlog.info("OrgIndustry: " + data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("HsrWprEditOrgIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "OrgIndustry doesn't match");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("HsrWprEditCountry"));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownAttribute("HsrWprEditCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Country doesn't match");
		testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("HsrWprEditState"),
				data.getCellData(SheetName, "State", rowNum), "State Name doesn't match");
		testlog.info("Street: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("HsrWprEditStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Street Name doesn't match");
		testlog.info("City: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("HsrWprEditCity"),
				data.getCellData(SheetName, "City", rowNum), "City doesn't match");
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("HsrWprPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "PostalCode doesn't match");
		testlog.info("Then User verifies the added details from excel");
		testlog.pass("**Verifies the Wpr Field Validation successfully**");
	}

	public void validateTeamsWPR(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLPerformanceRatingNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WELLPerformanceRatingNavBar", 0);
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRIdClick");
		String wprId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Performance ID: " + wprId);
		CommonMethod.WaitUntilClickble("WPRId", 60).sendKeys(wprId);
		CommonMethod.RobustclickElementVisible("WPRApplybtn", "WELLPerformanceRatingNavBar");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("WELLPerformanceRatingNavBar", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "1", "Portfolio Search failed");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		testlog.info("And User verifies able to access the invited project");
		testlog.pass("**Verifies user able to access the invited project**");
	}

	public void clikOnDocumentLibrary() throws InterruptedException, IOException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DocumentLibraryTab", 0);
		CommonMethod.RobustclickElementVisible("DocumentLibraryTab", "PortfolioDocumentUploadbutton");
		testlog.info("When User clicks on DocumentLibraryTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
	}

	public void searchFilterScoreCard(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard Page");
		CommonMethod.refreshBrowser();
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardSearchBox", 0);
		CommonMethod.sendKeys("V2ProjectScoreCardSearchBox", FeatureName);
		Thread.sleep(2000);
		CommonMethod.sendKeyEnter("V2ProjectScoreCardSearchBox");
		testlog.info("Given User enters is on SearchBox filter field");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectWPRPFeature", 1);
		testlog.info(FeatureName + ": " + FeatureName);
		testlog.info("Then User will be redirected to Scorecard list page");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectWPRPFeature"), FeatureName, "SearchFilter Feature name doesn't match");
		CommonMethod.negativesoftassertFieldValid(Integer.toString(CommonMethod.ElementSize("V2ProjectWPRPFeature")), "1",
				"searchFilter doesn't match");
		testlog.info("And User verifies Scorecard list Count");
		CommonMethod.refreshBrowser();
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardSearchBox", 0);
		testlog.pass("**Verifies Search filter successfully**");
	}

	public void verifyScoreCardFilter(String SheetName, String filterName, String expectedResult, int filterIndex,
			int checkboxIndex) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard Page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardFilterButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
		testlog.info("When User clicks on Filter button");
		CommonMethod.clickOnListWebelementFromIndex("V2ProjectScoreCardFilterOption", filterIndex);
		CommonMethod.clickListWebelementFromIndex("V2ProjectScoreCardFilterOptionCheckBox", checkboxIndex);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "V2ProjectScoreCardFilterButton");
		if (filterName.equalsIgnoreCase("Response")) {
			CommonMethod.WaitUntilPresence("WPRValidPurseYes", 60);
			int YesFeature = CommonMethod.ElementSize("WPRValidPurseYes");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info(filterName + ": " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValidEquals(actualYesFeatureCount, expectedResult, "YesPurseCount doesn't match");
		}
		if (filterName.equalsIgnoreCase("Verification") || filterName.equalsIgnoreCase("Document Scale")) {
			CommonMethod.WaitUntilInVisibility("WPRValidTotalFeature", 120);
			CommonMethod.WaitUntilPresence("WPRValidVerification", 60);
			int FeatureCount = CommonMethod.ElementSize("V2ProjectWPRPFeature");
			String actualYesFeatureCount = Integer.toString(FeatureCount);
			testlog.info(filterName + ": " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValidEquals(actualYesFeatureCount, expectedResult, "Feature Count doesn't match");
		}
		CommonMethod.refreshBrowser();
		rc.ScorecardLoading();
		testlog.pass("**Verifies filter " + filterName + " options successfully**");
	}

	public void SearchPerformanceByStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard Page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLPerformanceRatingNavBar");
		testlog.info("When User clicks on ProjectNavBar");
		CommonMethod.WaitUntilVisibility("WELLPerformanceRatingNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLPerformanceRatingNavBar", "WPRIdClick");
		testlog.info("And User clicks on WELLPerformanceRatingNavBar");
		String wprId = data.getCellData(SheetName, "ProjectID", rowNum);
		testlog.info("Performance ID: " + wprId);
		CommonMethod.WaitUntilPresence("WPRId", 60);
		CommonMethod.clearAndSendKey("WPRId", wprId);
		testlog.info("And User enters to WPRId field");
		CommonMethod.RobustclickElementVisible("WPRApplybtn", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on apply button");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1)
				.size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(ProjectCount), "1", "Performance Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.RobustclickElementVisible("WPRApplybtn", "V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		 CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "1", "Performance Search Count failed");
		CommonMethod.RobustclickElementVisible("WPRApplybtn", "V2ProjectSearchResultIDVerify");
		int ProjectCount1 = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1)
				.size();
		 CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount1), "1",
				"Performance Search Count failed");
		 CommonMethod.assertcontainsmessage("WERIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " + status);
		 CommonMethod.negativesoftassertFieldValid(status, "ACHIEVED", "Performance Search status failed");
		 rc.ValidateDateInList();
		CommonMethod.RobustclickElementVisible("WPRIdClick", "WellV2DashboardTab");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 300);
		testlog.info("Then User verifies Project Acheieved Status");
		testlog.info("Then User verifies Project Date");
		testlog.pass("**Verifies the Search Performance Status successfully**");
	}

	public void UpdateReview(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLPerformanceNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLPerformanceNavBar", 120);
		CommonMethod.RobustclickElementVisible("AdminWELLPerformanceNavBar", "WPRAdminIdSearch");
		CommonMethod.WaitUntilClickble("WPRAdminIdSearch", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("WPRAdminApplybtn", "WPRAdminIdClick");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRAdminIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("WPRAdminIdClick", "WellV2DashboardTab");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 300);
		CommonMethod.RobustclickElementVisible("ReviewTab", "ReviewViewButton");
		CommonMethod.RobustclickElementVisible("V2ProjectReviewViewLink", "V2ProjectReviewEditButton");
		CommonMethod.RobustclickElementVisible("V2ProjectReviewEditButton",
				"V2ProjectReviewNeedClarificationRadioButton");
		CommonMethod.ClickCheckbox("V2ProjectReviewNeedClarificationRadioButton");
		CommonMethod.sendKeys("V2ProjectReviewMidReviewClarificationNote", "Test");
		CommonMethod.RobustclickElementVisible("V2ProjectReviewUpdate", "V2ProjectReviewRequiredClarification");
	}

	public void ReSubmitReview(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.RobustclickElementVisible("ReviewTab", "V2ProjectReviewViewLink");
		CommonMethod.RobustclickElementVisible("V2ProjectReviewViewLink", "V2ProjectReviewReSubmitButton");
		CommonMethod.RobustclickElementVisible("V2ProjectReviewReSubmitButton", "V2ProjectReviewCommentTextArea");
		CommonMethod.sendKeys("V2ProjectReviewCommentTextArea", "Test");
		CommonMethod.Robustclick("SubmitButton");
	}

	public void AdminWprSearch(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLPerformanceNavBar");
		// CommonMethod.WaitUntilVisibility("AdminWELLPerformanceNavBar", 120);
		CommonMethod.RobustclickElementVisible("AdminWELLPerformanceNavBar", "WPRAdminIdSearch");
		testlog.info("When User clicks on WELL Performance from top menu under Projects");
		CommonMethod.WaitUntilClickble("WPRAdminIdSearch", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enter data to WprId");
		CommonMethod.RobustclickElementVisible("WPRAdminApplybtn", "WPRAdminIdClick");
		testlog.info("And User clicks on Apply button");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRAdminIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("WPRAdminIdClick", "WellV2DashboardTab");
		testlog.info("And User clicks on WprAdminId"); 

	}

	public void Editlocation(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on location tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Overviewtab", 0);
		CommonMethod.RobustclickElementVisible("Overviewtab", "table");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 3);
		testlog.info("And User clicks on overview tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ClickOnAddedSingleProjectId", 0);
		CommonMethod.RobustclickElementVisible("ClickOnAddedSingleProjectId", "VerifyEditlocationslider");
		testlog.info("And User clicks on edit location button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationOwnershipDisable", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioLocationOwnershipDisable", "Ownership is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioLocationCountryDisable", "Country is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioLocationStateDisable", "State is enabled");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationSpaceType", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioLocationSpaceType", "Office Spaces");
		testlog.info("when User update space type as Office spaces");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationOwnershipDisable", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2Projectscorecarddocuploadsubmit", 0);
		CommonMethod.Robustclick("V2Projectscorecarddocuploadsubmit", "PortfolioLocationSpaceType");
		testlog.info("then User clicks on update button");
		if (CommonMethod.isElementsExist("Toastermessage", 15)) {
			CommonMethod.WaitUntilInVisibility("Toastermessage", 60);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ClickOnAddedSingleProjectId", 0);
		CommonMethod.RobustclickElementVisible("ClickOnAddedSingleProjectId", "VerifyEditlocationslider");
		testlog.info("then User again clicks on edit location");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationSpaceType", 0);
		String actualvalue = CommonMethod.getSelectedDropdownValue("PortfolioLocationSpaceType");
		CommonMethod.negativesoftassertFieldValid(actualvalue, "Office Spaces","Update Spacetype doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2Projectscorecarddocuploadsubmit", 0);
		CommonMethod.Robustclick("V2Projectscorecarddocuploadsubmit", "PortfolioLocationSpaceType");
		testlog.info("And User verify updated space type");
		testlog.pass("And User verify single location edit successfully**");
	}

	public void locationFilters(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationLanding", 0);
		testlog.info("Given User is on LocationsTab");
		/*
		 * space type filter
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardFilterButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "Applybutton");
		testlog.info("when User click on Filter button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Warehousecheckbox", 0);
		CommonMethod.ClickCheckbox("Warehousecheckbox");
		testlog.info("And User select Warehouse checkbox ");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Applybutton", 0);
		CommonMethod.Robustclick("Applybutton");
		testlog.info("And User clicks on  Apply button ");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr", 5);
		int rowCount = CommonMethod.ElementSize("PortfolioLocListTr");
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(rowCount), "5", "space type filter");
		testlog.info("And User verify space type filter ");
		resetFilter();
		testlog.info("And User verify Reset filter");

		/*
		 * Ownership type filter
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardFilterButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "OwnershipWellCore");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OwnershipWellCore", 0);
		CommonMethod.ClickCheckbox("OwnershipWellCore");
		testlog.info("And User select OwnershipSpaceLease checkbox ");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Applybutton", 0);
		CommonMethod.Robustclick("Applybutton");
		testlog.info("And User clicks on  Apply button ");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTable", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr", 1);
		int rowCountOwnership = CommonMethod.ElementSize("PortfolioLocListTr");
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(rowCountOwnership), "1","Ownership type filter");
		testlog.info("And User verify Ownership type filter ");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardFilterButton", 0);
		testlog.pass("And User verify locations filter successfully**");	
	}
	
	public void resetFilter() throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardFilterButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "OwnershipWellCore");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ResetButton", 0);
		CommonMethod.Robustclick("ResetButton");
	}

	public void updateProfile(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRLocationViewlink", 0);
		CommonMethod.RobustclickElementVisible("WPRLocationViewlink", "V2ProjectProjectBio");
		testlog.info("And User clicks on View link");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectBio", 60);
		CommonMethod.clearAndSendKey("V2ProjectProjectBio", "Project bio testing");
		testlog.info("And User enter data to ProjectBio field");
		CommonMethod.WaitUntilVisibility("V2ProjectSave", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectProfileUpdatedToastMessage");
		testlog.info("And User clicks on Save button");
		CommonMethod.WaitUntilVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Updated Profile!", "Verified profile updated toast message");
		testlog.info("Then User verifies Profile updated successfully toast message");
		CommonMethod.WaitUntilVisibility("WPRLocationViewlink", 180);
		CommonMethod.RobustclickElementVisible("WPRLocationViewlink", "V2ProjectProjectBio");
		CommonMethod.WaitUntilVisibility("WPRLocationwellcertification", 60);
		CommonMethod.RobustclickElementVisible("WPRLocationwellcertification", "WPRProjectDecideInputfield");
		CommonMethod.WaitUntilVisibility("WPRProjectDecideInputfield", 60);
		CommonMethod.clearAndSendKey("WPRProjectDecideInputfield", "project decide testing");
		testlog.info("And User enter data to project decide field");
		CommonMethod.WaitUntilVisibility("WPRWELLAlignInputfield", 60);
		CommonMethod.clearAndSendKey("WPRWELLAlignInputfield", "well align testing");
		testlog.info("And User enter data to well align testing field");
		CommonMethod.RobustclickElementVisible("WPRSaveprofilebutton", "V2ProjectProfileUpdatedToastMessage");
		testlog.info("And User clicks on Save profile button");
		CommonMethod.WaitUntilVisibility("V2ProjectProfileUpdatedToastMessage", 60);
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Updated Profile!", "Verified profile updated toast message");
		testlog.info("user click on close panel");
		CommonMethod.WaitUntilVisibility("WPRLocationViewlink", 60);
		CommonMethod.RobustclickElementVisible("WPRLocationViewlink", "V2ProjectProjectBio");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("V2ProjectProjectBio"), "Project bio testing",
				"Verified project bio message");
		CommonMethod.WaitUntilVisibility("WPRLocationwellcertification", 60);
		CommonMethod.RobustclickElementVisible("WPRLocationwellcertification", "WPRProjectDecideInputfield");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("WPRProjectDecideInputfield"),
				"project decide testing", "Verified project decide message");
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("WPRWELLAlignInputfield"), "well align testing",
				"Verified enter well align message");
		CommonMethod.WaitUntilVisibility("WPRSaveprofilebutton", 120);
		CommonMethod.RobustclickElementVisible("WPRSaveprofilebutton", "V2ProjectProfileUpdatedToastMessage");
		softAssert.assertAll();
	}

	public void EditTeamMemberRole(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTeamEditButton", 0);
		CommonMethod.RobustclickElementVisible("WPRTeamEditButton", "WPRTeamRoleDropdown");
		testlog.info("When user click on edit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTeamRoleDropdown", 0);
		CommonMethod.selectdropdownVisibletext("WPRTeamRoleDropdown", "Architect");
		testlog.info("And User select the Role");
		CommonMethod.WaitUntilVisibility("WPRTeamUpdateButton", 30);
		CommonMethod.RobustclickElementVisible("WPRTeamUpdateButton", "V2ProjectDeleteIcon");
		testlog.info("And User clicks on Invite button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTeamProjectRole", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRTeamProjectRole"), "Architect",
				"Project role does not matched");
	}

	public void promotionCardCountBeforeAchieved(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		boolean flag = true;
		if (countCard != 1) {
			flag = false;
		}
		CommonMethod.assertTruebooleanCondition(flag, "Before achieved card count doesn't match");
		CommonMethod.assertExpectedContainsActual(CommonMethod.getText("WPRIWBIBranding"), "IWBI branding guidelines",
				"IWBI card does not matched");
	}

	public void UpdateWPREditAdminStatus(String SheetName, int rowNum) throws IOException, InterruptedException {

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("And User clicks on Edit tab button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "AdminFieldsText");
		testlog.info("And User clicks on Edit tab button");
		CommonMethod.WaitUntilVisibility("EditTab", 60);
		CommonMethod.ClickCheckbox("EditAchievedStatus");
		testlog.info("And User clicks on Apply button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSaveChangesButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "WPRDashboardButton");
		testlog.info("And User clicks on Apply button");

	}

	public void promotionCardCountAfterAchieved(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PromotionTab", 0);
		CommonMethod.RobustclickElementVisible("PromotionTab", "PromotionCardContainer");
		rc.ValidCardCount("PromotionCardContainer");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRPromotionCursorPointer", 0);
		CommonMethod.RobustclickElementVisible("WPRPromotionCursorPointer", "WPRPromotionVerifyPopup");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPromotionVerifyPopup"),
				"Brand guidelines & seal usage requirements", "IWBI card does not matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRPromotionPopupcloseicon", 0);
		CommonMethod.RobustclickElementVisible("WPRPromotionPopupcloseicon", "WPRPromotionLooksealCard");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPromotionLooksealCard"), "Look for the seal",
				"IWBI card does not matched");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPromotionDownloadmarksCard"),
				"Download digital marks", "IWBI card does not matched");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPromotionmarketingteamCard"),
				"Digital mark guidelines for marketing teams", "IWBI card does not matched");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPromotionPerformanceStoryCard"),
				"Tell your WELL Performance Story", "IWBI card does not matched");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPromotionPromoteOnsiteCard"),
				"Promote Onsite", "IWBI card does not matched");
	}

	public void promotionCardCount(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PromotionTab", 0);
		CommonMethod.RobustclickElementVisible("PromotionTab", "WPRPromotionWellScoreCards");
		int countCard = CommonMethod.ElementSize("WPRPromotionWellScoreCards");
		boolean flag = true;
		if (countCard != 12) {
			flag = false;
		}
		CommonMethod.assertTruebooleanCondition(flag, "Card count  doesn't match");
	}

	public void taskFilter(String documentName, String fileCount) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTaskTab", 0);
		CommonMethod.RobustclickElementVisible("WPRTaskTab", "V2ProjectScoreCardFilterButton");
		performance.verifyTaskFilter("Verification");
		performance.verifyTaskFilter("Action area");

	}

	public void verifyTaskFilter(String filterName) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardFilterButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
		testlog.info("When User clicks on Filter button");
		if (filterName.equalsIgnoreCase("Verification")) {
			verifyVerificationFilter();
		}
		if (filterName.equalsIgnoreCase("Action area")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardVerificationFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
					"V2ProjectScorecardOnsitePhotographsFilter");
			testlog.info("And User clicks on verification Option to close the option");
			CommonMethod.WaitUntilPresence("WPRTaskActionArea", 180);
			CommonMethod.RobustclickElementVisible("WPRTaskActionArea", "WPRTaskIndoorAirQualityCbx");
			testlog.info("And User clicks on Response Filter option");
			CommonMethod.WaitUntilPresence("WPRTaskIndoorAirQualityCbx", 180);
			CommonMethod.RobustclickElementVisible("WPRTaskIndoorAirQualityCbx", "V2ProjectScorecardApplybutton");
			testlog.info("And User check the Yes checkbox");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardApplybutton", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "WPRTaskVerifyIndoorAirQuality");
			testlog.info("And User clicks on Apply button");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRTaskVerifyIndoorAirQuality"),
					"Indoor Air Quality", "Indoor Air Quality doesn't match");
			testlog.info("Then User verifies verification filter");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentClearButton", 0);
		CommonMethod.Robustclick("WPRDocumentClearButton", "WPRDocumentClearButton");
		testlog.info("And User click on the clear button");
		softAssert.assertAll();
		testlog.pass("**Verifies filter " + filterName + " options successfully**");
	}

	public void verifyVerificationFilter() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardVerificationFilter", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
				"V2ProjectScorecardOnsitePhotographsFilter");
		testlog.info("And User clicks on Verification Option");
		CommonMethod.WaitUntilPresence("V2ProjectScorecardOnsitePhotographsFilter", 180);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardOnsitePhotographsFilter",
				"V2ProjectScorecardApplybutton");
		testlog.info("And User check the Photographs checkbox");
		CommonMethod.WaitUntilPresence("V2ProjectScorecardApplybutton", 180);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "WPRDocumentVerifyPhotographs");
		testlog.info("And User clicks on Apply Filter button");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRDocumentVerifyPhotographs"),
				"On-site Photographs", "On-site Photographs doesn't match");
		testlog.info("Then User verifies verification filter");
	}

	public void documentFilter(String documentName, String fileCount) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentFilterOption", 0);
		CommonMethod.RobustclickElementVisible("WPRDocumentFilterOption", "V2ProjectScoreCardFilterButton");
		performance.verifyDocumentFilter("Verification");
		performance.verifyDocumentFilter("Type");
		performance.verifyDocumentFilter("Review Status");
	}

	public void verifyDocumentFilter(String filterName) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardFilterButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
		testlog.info("When User clicks on Filter button");
		if (filterName.equalsIgnoreCase("Verification")) {
			CommonMethod.WaitUntilPresence("V2ProjectScorecardVerificationFilter", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
					"V2ProjectScorecardOnsitePhotographsFilter");
			testlog.info("And User clicks on Verification Option");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardOnsitePhotographsFilter", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardOnsitePhotographsFilter",
					"V2ProjectScorecardApplybutton");
			testlog.info("And User check the Photographs checkbox");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardApplybutton", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "WPRDocumentVerifyPhotographs");
			testlog.info("And User clicks on Apply Filter button");
			CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("WPRDocumentVerifyPhotographs"),
					"On-site Photographs", "On-site Photographs doesn't match");
			testlog.info("Then User verifies verification filter");
		}
		if (filterName.equalsIgnoreCase("Type")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardVerificationFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
					"V2ProjectScorecardOnsitePhotographsFilter");
			testlog.info("And User clicks on verification Option to close the option");
			CommonMethod.WaitUntilPresence("WPRDocumentTypeButton", 180);
			CommonMethod.RobustclickElementVisible("WPRDocumentTypeButton", "WPRDocumentFeatureCbx");
			testlog.info("And User clicks on Response Filter option");
			CommonMethod.WaitUntilPresence("WPRDocumentFeatureCbx", 180);
			CommonMethod.RobustclickElementVisible("WPRDocumentFeatureCbx", "V2ProjectScorecardApplybutton");
			testlog.info("And User check the Yes checkbox");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardApplybutton", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "WPRDocumentVerifyFeature");
			testlog.info("And User clicks on Apply button");
			CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("WPRDocumentVerifyFeature"), "Feature",
					"Feature doesn't match");
			testlog.info("Then User verifies verification filter");
		}
		if (filterName.equalsIgnoreCase("Review Status")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentTypeButton", 0);
			CommonMethod.RobustclickElementVisible("WPRDocumentTypeButton", "WPRDocumentFeatureCbx");
			testlog.info("And User clicks on type Option to close the option");
			CommonMethod.WaitUntilPresence("WPRDocumentReviewStatusButton", 180);
			CommonMethod.RobustclickElementVisible("WPRDocumentReviewStatusButton", "WPRDocumentReviewedCbx");
			testlog.info("And User clicks on Response Filter option");
			CommonMethod.WaitUntilPresence("WPRDocumentReviewedCbx", 180);
			CommonMethod.RobustclickElementVisible("WPRDocumentReviewedCbx", "V2ProjectScorecardApplybutton");
			testlog.info("And User check the Yes checkbox");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardApplybutton", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "WPRDocumentVerifyReviewed");
			testlog.info("And User clicks on Apply button");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRDocumentVerifyReviewed"), "Reviewed",
					"Reviewed doesn't match");
			testlog.info("Then User verifies verification filter");
		}
		CommonMethod.WaitUntilPresence("WPRDocumentClearButton", 180);
		CommonMethod.Robustclick("WPRDocumentClearButton", "WPRDocumentClearButton");
		testlog.info("And User click on the clear button");
		testlog.pass("**Verifies filter " + filterName + " options successfully**");
	}

	public void verifySearchLocationFilter(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRLocationSearchBox", 0);
		CommonMethod.click("WPRLocationSearchBox");
		testlog.info("Given user click in search filter box");
		CommonMethod.WaitUntilPresence("WPRLocationWellLocation1", 120);
		CommonMethod.click("WPRLocationWellLocation1");
		testlog.info("When user click location name in seach filter box");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTaskFullfilledTab", 0);
		CommonMethod.JavascriptClickElement("WPRTaskFullfilledTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTaskFeatureCount", 0);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(CommonMethod.ElementSize("WPRTaskFeatureCount")), 
				"40", "Location 3 doesn't match");
		testlog.info("Then User verifies location filter");
		testlog.pass("**Verifies Document Library task location Count successfully**");
	}

	public void uploadLocationSingleFeature(String featureNameLocator, String Commodity) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(featureNameLocator, 0);
		CommonMethod.JavascriptClickElement(featureNameLocator);
		CommonMethod.WaitUntilVisibility("WPRVerficationTab", 60);
		CommonMethod.RobustclickElementVisible("WPRVerficationTab", "WPRAddOption");
		CommonMethod.WaitUntilVisibility("WPRAddOption", 60);
		CommonMethod.JavascriptClickElement("WPRAddOption");
		CommonMethod.WaitUntilVisibility("WPRAddOptionbtn", 60);
		CommonMethod.Robustclick("WPRAddOptionbtn");
		CommonMethod.WaitUntilPresence("WPRAddOptionCloseIcon", 120);
		CommonMethod.Robustclick("WPRAddOptionCloseIcon");
		CommonMethod.WaitUntilVisibility("WPRAssignLocbtn", 60);
		Thread.sleep(1000);
		generic.assignLocationGeneric(Commodity, false, false, true, false, false);
	}
	public void uploadDocumentSingleFeature(String UploadsLocator) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRLocationUploadButton", 0);
		CommonMethod.WaitUntilClickble("WPRLocationUploadButton", 120);
		List<WebElement> UploadButton;
		UploadButton = CommonMethod.findElements(UploadsLocator);
		for (WebElement uploadButton : UploadButton) {
			CommonMethod.JavascriptClickElement(uploadButton);
			CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
			rc.ScorecardUploadSaveButton();
			rc.ScorecardConfirmLocUploadSaveButton();
		rc.uploadDocumentToastMessage();
		}
	}
	public void verifyUploadDocumentInTask(String SheetName, int rowNum, String Commodity, String TaskUploadXpath, String LocationCount, String PortfolioDocumentTaskUploadLocationCount) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTaskTab", 0);
		CommonMethod.RobustclickElementVisible("WPRTaskTab", "PortfolioDocListTaskFullFilledTab");
		CommonMethod.scrolldowntoElement("WPRTaskTab");
		uploadDocumentSingleFeature(TaskUploadXpath);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTaskTab", 0);
		CommonMethod.RobustclickElementVisible("WPRTaskTab", "PortfolioDocListTaskFullFilledTab");
		CommonMethod.scrolldowntoElement("WPRTaskTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.click("PortfolioDocListTaskFullFilledTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioDocumentTaskUploadLocationCount, 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText(PortfolioDocumentTaskUploadLocationCount),LocationCount , "Task Assign Location Count doesn't match");
	}
	
	public void DocumentPagination() throws IOException, InterruptedException {
		testlog.info("Given User is on Document Library Page");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "WPRDocumentPaginationsecond");
		testlog.info("When User click on Document button");
		CommonMethod.scrolldowntoElement("PortfolioAndRatingLocAccDocumentTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioAndRatingLocAccDocumentTableTr", 10);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentPaginationsecond", 0);
		CommonMethod.Robustclick("WPRDocumentPaginationsecond");
		testlog.info("And User clicks on pagination number");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRPaginationNumberText", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioAndRatingLocAccDocumentTableTr", 10);
		testlog.info("pagination number: "+CommonMethod.getText("WPRPaginationNumberText"));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPaginationNumberText"), "11","Document Library Pagition count Doesn't match");
		testlog.info("Then User verifies the pagition Count");
	}
	
	public void clickOnReviewTab(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "ReviewViewButton");
		testlog.info("And User clicks on Review button");
	}
	public void verifyEditMRCReview(String SheetName, int rowNum)throws IOException, InterruptedException {
		testlog.info("And User clicks on view button");
		if (TestCaseName.equalsIgnoreCase("V2_TC_13A_01_EditMRCReviewPreliminary")) {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectMrcReviewviewButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectMrcReviewviewButton", "WPRReviewEditButton");
		}
		else {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewViewButton", 0);
		CommonMethod.RobustclickElementVisible("ReviewViewButton", "WPRReviewEditButton");
		}
		testlog.info("And User clicks on edit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewEditButton", 0);
		CommonMethod.RobustclickElementVisible("WPRReviewEditButton", "WPRReviewNeedClarificationRadioBtn");
		testlog.info("And User clicks on need clarification radio button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewNeedClarificationRadioBtn", 0);
		CommonMethod.ClickCheckbox("WPRReviewNeedClarificationRadioBtn");
		testlog.info("And User enter comment in mid review textbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewMidReviewTextArea", 0);
		CommonMethod.sendKeys("WPRReviewMidReviewTextArea", "MRC Test");
		testlog.info("And User clicks on update button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UpdateButton", 0);
		CommonMethod.RobustclickElementVisible("UpdateButton", "WPRReviewStatus");
		testlog.info("Then user verify the review status and resubmit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectReviewReSubmitButton", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRReviewStatus"), "REQUIRE CLARIFICATION","REQUIRE CLARIFICATION doesn't match");
		testlog.info("Then user verify the review status");
		testlog.pass("**Verifies edit mrc review for preliminary successfully **");
	}
	
	public void verifyAddMRCCommentReview(String SheetName, int rowNum)throws IOException, InterruptedException {
		testlog.info("Then user verify the status in review table");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewTableStatus", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRReviewTableStatus"), "REQUIRE CLARIFICATION","REQUIRE CLARIFICATION doesn't match");
		testlog.info("And User clicks on view button");
		if (TestCaseName.equalsIgnoreCase("V2_TC_13A_02_AddMRCCommentReviewPreliminary")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectMrcReviewviewButton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectMrcReviewviewButton", "WPRReviewEditButton");
			}
			else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewViewButton", 0);
			CommonMethod.RobustclickElementVisible("ReviewViewButton", "WPRReviewEditButton");
			}
		testlog.info("Then user verify the review status and resubmit review button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectReviewReSubmitButton", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRReviewStatus"), "REQUIRE CLARIFICATION","REQUIRE CLARIFICATION doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewAuthReviewComment", 0);
		CommonMethod.sendKeys("WPRReviewAuthReviewComment", "Resubmit Test");
		testlog.info("And User enter comment in the comment box");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocUpload", 0);
		CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
		testlog.info("And User upload the documents");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewAddCommentButton", 0);
		CommonMethod.RobustclickElementVisible("WPRReviewAddCommentButton", "WPRReviewVerifyComment");
		testlog.info("And User clicks on add comment button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MRCReviewVerifyComment", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRReviewVerifyUploadDocument"), "Feature","Feature document doesn't match");
		testlog.info("Then user verify comment and upload document name");
		testlog.pass("**Verifies add mrc comment review for preliminary successfully **");
	}
	
	public void clickViewButtonInReview()throws IOException, InterruptedException {
		testlog.info("And User clicks on view button");
		if (TestCaseName.equalsIgnoreCase("V2_TC_13A_02_AddMRCCommentReviewPreliminary") || TestCaseName.equalsIgnoreCase("V2_TC_13A_04_CompletePreliminaryReview")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectMrcReviewviewButton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectMrcReviewviewButton", "V2ProjectReviewReSubmitButton");
			}
			else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewViewButton", 0);
			CommonMethod.RobustclickElementVisible("ReviewViewButton", "V2ProjectReviewReSubmitButton");
			}
	}
	
	public void verifyReSubmitReview(String SheetName, int rowNum)throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectReviewReSubmitButton", 0);
		CommonMethod.JavascriptClickElement("V2ProjectReviewReSubmitButton");
		testlog.info("And User click on resubmit review button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewReSubmitCommentBox", 0);
		CommonMethod.sendKeys("WPRReviewReSubmitCommentBox", "Resubmit Review Test");
		testlog.info("And User enter comment in the comment box on the resubmit popup");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2Projectscorecarddocuploadsubmit", 0);
		CommonMethod.RobustclickElementVisible("V2Projectscorecarddocuploadsubmit", "WPRReviewInProgressStatus");
		testlog.info("And User clicks on the submit button on the resubmit popup");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRReviewInProgressStatus"), "IN PROGRESS","ReSubmit Review doesn't resubmit");
		CommonMethod.WaitUntilInVisibility("V2ProjectReviewReSubmitButton", 60);
		testlog.info("Then User verify status and resubmit button on the review page after resubmit process");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewBackButton", 0);
		CommonMethod.JavascriptClickElement("WPRReviewBackButton");
		testlog.info("And User clicks on the back button ");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRReviewInProgressTableStatus", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRReviewInProgressTableStatus"), "IN PROGRESS"," status doesn't match");
		testlog.info("Then User verify the review table status after resubmit process");
		testlog.pass("**Verifies resubmit review for preliminary successfully **");
	}
	
	public void deleteAddedTeamMember(String SheetName, int rowNum) throws IOException, InterruptedException {
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();
		testlog.info("Given User is on Team model page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTeamDeleteButton", 0);
		CommonMethod.RobustclickElementVisible("WPRTeamDeleteButton", "V2ProjectAddMemberbtn");
		testlog.info("When User clicks on Delete Icon");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRTeamDeleteButton", 1);
		testlog.info("Then User will be redirected to Team list page");
		testlog.pass("**Created Team member successfully**");
	}
	
	public void importReviewUpload() throws IOException, InterruptedException {
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewUploadButton", 0);
	CommonMethod.RobustclickElementVisible("PortfolioAdminReviewUploadButton","DocumentsUpload");
	testlog.info("When User clicks on Upload button");
	CommonMethod.uploadFile("DocumentsUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
	testlog.info("And User Upload Feature Document");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewModelUploadButton", 0);
	CommonMethod.RobustclickElementVisible("PortfolioAdminReviewModelUploadButton",
			"PortfolioAdminReviewValidDocumentType");
    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRImportDocLog", 0);
    CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("WPRImportDocLog"), "FeatureFile",
		"DocumentType Upload doesn't Match");
	}
}