package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsHealthSafety extends BaseClass {

	public void RegisterHealthSafety(String SheetName, int rowNum, String DataValidate, String ProjectName)
			throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified account");
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLHealthSafetyNavBar");
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrWellhealthstartprojectbtn");
		testlog.info("When User clicks on WELL HealthSafety from top menu under Projects");
		CommonMethod.RobustclickElementVisible("HsrWellhealthstartprojectbtn", "HsrEnrollnowbtn");
		testlog.info("And User clicks on Start project button");
		CommonMethod.RobustclickElementVisible("HsrEnrollnowbtn", "HsrEnrollbtn");
		testlog.info("And User clicks on EnrollNow button");
		CommonMethod.RobustclickElementVisible("HsrEnrollbtn", "Hsrenrollcontinuebtn");
		testlog.info("And User clicks on Enroll button");
		CommonMethod.WaitUntilPresence("Hsrenrollcontinuebtn", 180);
		CommonMethod.RobustclickElementVisible("Hsrenrollcontinuebtn", "HsrenrollName");
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner name is required.", "Owner Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Industry is required.",
				"Organization Industry Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Consultant is required.",
				"Consultant Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		testlog.info(
				"And User clicks on continue button without entering the mandatory fields and verifies error meassage");
		String erollName = ProjectName + "_"+CommonMethod.randomNumber(8000000);
		CommonMethod.sendKeys("HsrenrollName", erollName);
		data.setCellData(SheetName, "projectName", rowNum, CommonMethod.getattributeValue("HsrenrollName"));
		testlog.info("And User enter data to EnrollName");
		testlog.info("HsrName: " + data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.ClickCheckbox("Hsrenrollcheckbox");
		testlog.info("And User checks the enroll checkbox");
		String Ownername = USfaker.address().firstName();
		CommonMethod.WaitUntilPresence("WPROwnerName", 30);
		CommonMethod.sendKeys("WPROwnerName", Ownername);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("WPROwnerName"));
		rc.SelectOwnerOrg(SheetName, rowNum);
		data.setCellData(SheetName, "OrgName", rowNum, CommonMethod.getText("OrgName"));
		CommonMethod.selectdropdownrandom("OrgIndustry");
		testlog.info("And User select OrgIndustry");
		rc.SelectEnterpriseProviders(SheetName, rowNum);
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.selectdropdownValue("Hsrenrollcountry", "US");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownAttribute("Hsrenrollcountry"));
		CommonMethod.selectdropdownrandom("Hsrenrollstate");
		testlog.info("And User enter data to Owner Country, State, Street address, City and Postal Code fields");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("Hsrenrollcountry"));
		testlog.info("OwnerName: " + data.getCellData(SheetName, "OwnerName", rowNum));
		testlog.info("OrganizationName: " + data.getCellData(SheetName, "OrgName", rowNum));
		testlog.info("State: " + CommonMethod.getSelectedDropdownAttribute("Hsrenrollstate"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("Hsrenrollstate"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("Hsrenrollstreet", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("Hsrenrollstreet"));
		testlog.info("Hsrenrollstreet: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("Hsrenrollcity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("Hsrenrollcity"));
		testlog.info("City: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("Hsrenrollpostalcode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("Hsrenrollpostalcode"));
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.ClickCheckbox("Hsrbilladdcheckbox");
		testlog.info("And User checks the Billing checkbox");
		CommonMethod.RobustclickElementVisible("Hsrenrollcontinuebtn", "HsrRegcontinuebtn");
		testlog.info("And User clicks on continue button");
		if (DataValidate.equalsIgnoreCase("true")) {
			CommonMethod.RobustclickElementVisible("HsrBehalfOfOwnerBackbtn", "Hsrenrollcontinuebtn");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("HsrenrollName"), erollName,
					"HSR Enroll Name Error Mismatch");
			CommonMethod.VerifyRadioOrCheckboxSelcted("Hsrenrollcheckbox");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("OrgName"),
					data.getCellData(SheetName, "OrgName", rowNum), "Org Name Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("OrgIndustry"),
					data.getCellData(SheetName, "OrgIndustry", rowNum), "Org Industry Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownAttribute("Hsrenrollcountry"),
					data.getCellData(SheetName, "Country", rowNum), "Country Name Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("Hsrenrollstate"),
					data.getCellData(SheetName, "State", rowNum), "State Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("Hsrenrollstreet"),
					data.getCellData(SheetName, "Street", rowNum), "Street Name Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("Hsrenrollcity"),
					data.getCellData(SheetName, "City", rowNum), "City Name Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("Hsrenrollpostalcode"),
					data.getCellData(SheetName, "PostalCode", rowNum), "Postal code Error Mismatch");
			CommonMethod.VerifyRadioOrCheckboxSelcted("Hsrbilladdcheckbox");
			testlog.info("And User verifies the added details about you by clicking on back button");
			CommonMethod.RobustclickElementVisible("Hsrenrollcontinuebtn", "HsrRegcontinuebtn");
		}
		CommonMethod.RobustclickElementVisible("HsrRegcontinuebtn", "Hsrregcheckbox");
		CommonMethod.negativesoftassertPageSource("On behalf of owner is required.", "Owner CheckBox Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Is the Owner organization an IWBI member?* is required.",
				"Owner Organization Name Error Mismatch");
		testlog.info(
				"And User clicks on continue button without entering the mandatory fields and verifies error meassage");
		CommonMethod.ClickCheckbox("Hsrregcheckbox");
		testlog.info("And User checks the terms and conditions checkbox");
		CommonMethod.selectdropdownVisibletext("HsrIwbimemberdropdown", "No");
		testlog.info("And User select Iwbi member");
		CommonMethod.RobustclickElementVisible("HsrRegcontinuebtn", "HsrEnrollButton");
		testlog.info("And User clicks on continue button");
		if (DataValidate.equalsIgnoreCase("true")) {
			CommonMethod.RobustclickElementVisible("HSRLocationBackButton", "HsrRegcontinuebtn");
			CommonMethod.VerifyRadioOrCheckboxSelcted("Hsrregcheckbox");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("HsrIwbimemberdropdown"),
					"No", "Member Value Error Mismatch");
			CommonMethod.RobustclickElementVisible("HsrRegcontinuebtn", "HsrLocContinuebutton");
		}
		CommonMethod.WaitUntilPresence("HsrEnrollButton", 180);
		CommonMethod.RobustclickElementVisible("HsrEnrollButton", "Hsrlocations");
		CommonMethod.scrollUp();
		CommonMethod.sendKeys("Hsrlocations", "10");
		data.setCellData(SheetName, "Location", rowNum, CommonMethod.getattributeValue("Hsrlocations"));
		testlog.info("And User enter data to location");
		testlog.info("Hsrlocations: " + data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpacetype", "HsrWPRlocationsSpaceOption");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpaceOption", "Hsrlocationsize");
		data.setCellData(SheetName, "SpaceTypes", rowNum, CommonMethod.getText("HsrWPRlocationsSpacetype"));
		testlog.info("And User select the space type");
		testlog.info("Location SpaceType: " + data.getCellData(SheetName, "SpaceTypes", rowNum));
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		CommonMethod.clearAndSendKey("Hsrlocationsize", Area);
		data.setCellData(SheetName, "Area", rowNum, CommonMethod.getattributeValue("Hsrlocationsize"));
		testlog.info("Hsrlocations: " + data.getCellData(SheetName, "Area", rowNum));
		testlog.info("And User enter the Location Size");
		CommonMethod.WaitUntilVisibility("HsrLocContinuebutton", 120);
		CommonMethod.RobustclickElementVisible("HsrLocContinuebutton", "HsrDiscountBackButton");
		testlog.info("And User clicks on continue button");
		if (DataValidate.equalsIgnoreCase("true")) {
			CommonMethod.RobustclickElementVisible("HsrDiscountBackButton", "Hsrlocations");
			CommonMethod.WaitUntilClickble("Hsrlocations", 60);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("Hsrlocations"),
					data.getCellData(SheetName, "Location", rowNum), "Location Count Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("HsrWPRlocationsSpacetype"),
					data.getCellData(SheetName, "SpaceTypes", rowNum), "SpaceType Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("Hsrlocationsize"),
					data.getCellData(SheetName, "Area", rowNum), "Area Size Error Mismatch");
			testlog.info("And User verifies the added details about you by clicking on back button");
			CommonMethod.RobustclickElementVisible("HsrLocContinuebutton", "HsrDiscountBackButton");
			testlog.info("And User clicks on continue button");
		}
		if (CommonMethod.isElementsExist("HsrWPRYesMyOrganizationCbx", 10)) {
			CommonMethod.RobustclickElementVisible("HsrProgramFeeContinuebtn", "HsrWPRYesMyOrganizationCbx");
			CommonMethod.negativesoftassertPageSource(
					"Yes, my organization meets the criteria of the listed discount category.* is required.",
					"My Organization CheckBox Error Name");
			CommonMethod.WaitUntilClickble("HsrWPRYesMyOrganizationCbx", 60);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
			testlog.info("And User checks the MyOrganization checkbox");
		}
		CommonMethod.RobustclickElementVisible("HsrProgramFeeContinuebtn", "HsrProgramFeePublicrbtn");
		CommonMethod.WaitUntilPresence("HsrProgramFeePublicrbtn", 120);
		;
		CommonMethod.scrolldowntoElement("HsrProgramFeePublicrbtn");
		if (SheetName.equalsIgnoreCase("Hsr")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrProgramFeePrivatecrbtn", 0);
			CommonMethod.ClickCheckbox("HsrProgramFeePrivatecrbtn");
			testlog.info("And User check on Program Fee Private checkboxes");
		}
		CommonMethod.WaitUntilPresence("HsrAcknowledecbx", 60);
		CommonMethod.ClickCheckbox("HsrAcknowledecbx");
		testlog.info("And User check on Acknowlede checkboxes");
		CommonMethod.RobustclickElementVisible("HsrReviewbtn", "BillingLanding");
		testlog.info("And User clicks on Review button");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.info("Then User will be redirected to Billing invoice page");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void StoreIdHealthSafety(String SheetName, int rowNum) throws IOException, InterruptedException {
		if (CommonMethod.isElementsExist("HsrIframe", 5)) {
			CommonMethod.WaitUntilPresence("HsrIframe", 180);
			CommonMethod.switchToFrame("HsrIframe");
			CommonMethod.WaitUntilPresence("HsrCloseCard", 60);
			CommonMethod.Robustclick("HsrCloseCard");
			CommonMethod.switchToParentFrame();
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("StoreId", 300);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getHsrId = stringArray[1].trim();
		data.setCellData(SheetName, "ProjectID", rowNum, getHsrId);
		testlog.info("HealthSafety Id:" + getHsrId);
		testlog.info("When User storing HsrId in excel");
		testlog.pass("**Stored the Registered id  in excel successfully**");
	}

	public void SearchHealthSafetyByID(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WELLHealthSafetyNavBar", 0);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		testlog.info("When User clicks on WELL Healthsafety from top menu under Projects");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrIdSearch", 0);
		CommonMethod.RobustclickElementVisible("HsrIdSearch", "HsrIdSearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enter data to HsrId");
		CommonMethod.RobustclickElementVisible("HsrapplySearch", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount), "1", "HealthSafety Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "projectName", rowNum));
		testlog.info("And User enter data to HsrName");
		CommonMethod.RobustclickElementVisible("HsrapplySearch", "V2ProjectSearchResultIDVerify");
		int ProjectCount1 = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount1), "1", "HealthSafety Search failed");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("HSRIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("HSRIdClick", "WellV2DashboardTab");
		testlog.info("And User clicks on HsrAdminId");
		testlog.info("Then User verifies HsrId in search filter");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 60);
		testlog.info("And User will be redirected to Dashboard page");
		testlog.pass("**Verifies the Search HealthSafety ByID successfully**");
	}

	public void SearchFilterRegisteredStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		testlog.info("When User clicks on WELL Healthsafety from top menu under Projects");
		CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrIdSearch", "HsrIdSearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enter data to HsrId");
		CommonMethod.RobustclickElementVisible("HsrapplySearch", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount), "1", "HealthSafety Search failed");
		CommonMethod.sendKeys("HsrNameList", data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.RobustclickElementVisible("HsrapplySearch", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		int ProjectCount1 = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount1), "1", "HealthSafety Search failed");
		CommonMethod.assertcontainsmessage("HSRIdClick", data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " + status);
		CommonMethod.negativesoftassertFieldValid(status, "REGISTERED", "HealthSafety Search failed");
		testlog.info("Then User verifies HsrStatus in search filter");
		CommonMethod.RobustclickElementVisible("HSRIdClick", "WellV2DashboardTab");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 60);
		testlog.info("And User will be redirected to Dashboard page");
		testlog.pass("**Verifies the Search filter status successfully**");
	}
	
	

	public void ScorecardfillHSRWPR(int YesEnd, int NoStart, int NoEnd, int DifferencePlusOne, String purseYes,
			String purseNo) throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		Boolean flag = false;

		NoButton = CommonMethod.findElements(purseNo);
		int j = DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			long startTime = System.currentTimeMillis();
			int RemainingNo = NoButton.size();
			do {
				if (!((System.currentTimeMillis() - startTime) < 60000)) {
					flag = true;
					System.out.println("Build Stuck");
					break;
				}
				CommonMethod.WaitUntilClickble(NoButton.get(RemainingNo - j), 30);
				CommonMethod.JavascriptClickElement(NoButton.get(RemainingNo - j));
				if (CommonMethod.isElementsExist("WPRCloseIcon", 5)) {
					CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRCloseIcon", 1);
				}
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements(purseNo);
			} while ((NoButton.size() == RemainingNo));
			RemainingNo--;
			j--;
			if (flag) {
				System.out.println("Build Exit");
				break;
			}
		}

		YesButton = CommonMethod.findElements(purseYes);
		for (int i = 1; i <= YesEnd; i++) {
			long startTime = System.currentTimeMillis();
			int RemainingYes = YesButton.size();
			do {
				if (!((System.currentTimeMillis() - startTime) < 60000)) {
					flag = true;
					System.out.println("Build Stuck");
					break;
				}
				CommonMethod.WaitUntilClickble(purseYes, 60);
				CommonMethod.JavascriptClickElement(purseYes);
				if (CommonMethod.isElementsExist("WPRCloseIcon", 5)) {
					CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRCloseIcon", 1);
				}
				Thread.sleep(2000);
				YesButton = CommonMethod.findElements(purseYes);
			} while ((YesButton.size() == RemainingYes));
			RemainingYes--;
			if (flag) {
				System.out.println("Build Exit");
				break;
			}
		}
	}

	
	public void NavigateScorecard() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("ScorecardTab", 300);
		CommonMethod.RobustclickElementVisible("ScorecardTab", "WPRPortfolioScorecardLanding");
		testlog.info("And User clicks on ScorecardTab");
		rc.ScorecardLoading();
	}

	public void CompleteScorecardHsrById(String SheetName, int rowNum) throws IOException, InterruptedException {
		
		if (!TestNGTestName.contains("NonEnhanced")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommonScorecardPurseMaybe", 0);
			CommonMethod.RobustclickElementVisible("CommonScorecardPurseMaybe", "PortfolioScorecardPurseYesToNoConfirm");
			rc.confirmPursing();
			CommonMethod.RobustclickElementVisible("CommonScorecardPurseMaybe", "PortfolioScorecardPurseYesToNoConfirm");
			rc.confirmPursing();
			ScorecardfillHSRWPR(15, 1, 27, 27, "CommonScorecardPurseYes", "CommonScorecardPurseNo");
		}
		else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("NonEnhancedHsrScorecardPurseMaybe", 0);
			CommonMethod.JavascriptClickElement("NonEnhancedHsrScorecardPurseMaybe");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrEhancePurseNo", 0);
			CommonMethod.Robustclick("HsrEhancePurseNo");
			ScorecardfillHSRWPR(15, 1, 31, 31, "NonEnhancedHsrScorecardPurseYes", "NonEnhancedHsrScorecardPurseNo");
		}
		testlog.info("And User clicks on 15 Yes button");
		testlog.info("And User clicks on 12 No button");
		testlog.info("Then User verifies Upload Document toast message");
		testlog.pass("**Verifies the 15 Purse Yes Scorecard HealthSafety in V2Project successfully**");
	}
	
	
	public void CommonBulkUploadScorecardDocument(int LastFeatureNumber, String SheetName, int rowNum, String Commodity,String FileName,Boolean PartNameRequired, Boolean VerificationMethodValidationRequired, Boolean NoteRequired,  Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("HsrScorecardAplicableVersion");
		for (WebElement f : Feature) {
			CommonMethod.WaitUntilClickble(f, 120);
			CommonMethod.JavascriptClickElement(f);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRVerficationTab", 0);
			CommonMethod.RobustclickElementVisible("WPRVerficationTab", "WPRAddOption");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOption", 0);
			CommonMethod.JavascriptClickElement("WPRAddOption");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOptionbtn", 0);
			CommonMethod.Robustclick("WPRAddOptionbtn");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardAddedOption", 0);
			CommonMethod.Robustclick("WPRAddOptionCloseIcon");
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRAddOptionCloseIcon", 1);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocbtn", 0);
			generic.assignLocationGeneric(Commodity, false, false, true, false, false);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UploadTaskDocument", 0);
			boolean flag = true;
		     	int i= 1;
				int RemainingNo = CommonMethod.ElementSize("UploadTaskDocument");
				long startTime = System.currentTimeMillis();
				do {
						if ((System.currentTimeMillis() - startTime) > 800000) {
							flag = false;
							break;
						}
						CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WprUploadTaskDocument", 0);
						CommonMethod.JavascriptClickElement("WprUploadTaskDocument");
						generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired, VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				     	rc.ScorecardConfirmLocBulkUploadSaveButton();
				    	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTable", 0);
						testlog.info("And User will be redirected to Document Upload Table page");
						CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableTr", 0);
				     	Thread.sleep(2000);
				     	RemainingNo = CommonMethod.ElementSize("UploadTaskDocument");
				} while (i <= RemainingNo);
			CommonMethod.assertTruebooleanCondition(flag,"Uploading exceeds the timeout");
			CommonMethod.scrolldowntoElement("HsrScorecardAplicableVersion");
			CommonMethod.JavascriptClickElement(f);
		}
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
		testlog.pass("**Upload " +LastFeatureNumber+ "Scorecard Documents successfully**");
	}

	public void CommonSingleUploadScorecardDocument(int LastFeatureNumber, String SheetName, int rowNum, String Commodity,String FileName,Boolean PartNameRequired, Boolean VerificationMethodValidationRequired, Boolean NoteRequired,  Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		rc.ScorecardLoading();
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("HsrScorecardAplicableVersion");
		for (WebElement f : Feature) {
			CommonMethod.WaitUntilClickble(f, 120);
			CommonMethod.JavascriptClickElement(f);
			CommonMethod.WaitUntilVisibility("WPRVerficationTab", 60);
			CommonMethod.JavascriptClickElement("WPRVerficationTab");
			
			if (FileName.contains("Audit") || FileName.contains("Feature")) {
				 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOption", 0);
				CommonMethod.JavascriptClickElement("WPRAddOption");
				 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOptionbtn", 0);
				CommonMethod.Robustclick("WPRAddOptionbtn");
				testlog.info("And User clicks on save button");  
			} 	
			
			if (FileName.contains("Alternative")) {
            	  CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecrdAlterntives", 0);
					CommonMethod.JavascriptClickElement("ScorecrdAlterntives");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardAlternativeAddBtn", 0);
					CommonMethod.JavascriptClickElement("ScorecardAlternativeAddBtn");
					testlog.info("And User clicks on save button");  
					}
			
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOptionCloseIcon", 0);
			CommonMethod.Robustclick("WPRAddOptionCloseIcon");
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRAddOptionCloseIcon", 1);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocbtn", 0);
			generic.assignLocationGeneric(Commodity, false, false, true, false, false);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditLocationButton", 0);
			testlog.info("Then User verifies Edit location button");
			testlog.info("And User clicks on Assign button");
			testlog.info("And User checks the Assign Location checkbox");
			testlog.info("And User clicks on Save button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRUploadDocTaskbtn", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRScorecardUploadTaskDocument", 0);
			List<WebElement> UploadButton;
			UploadButton = CommonMethod.findElements("WPRScorecardUploadTaskDocument");
			for (WebElement uploadButton : UploadButton) {
				CommonMethod.JavascriptClickElement(uploadButton);
				generic.uploadModalCompleteGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired, VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
			}
			CommonMethod.scrolldowntoElement("HsrScorecardAplicableVersion");
			CommonMethod.JavascriptClickElement(f);
		}
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
		testlog.pass("**Upload " +LastFeatureNumber+ "Scorecard Documents successfully**");
	}


	public void SubmitHsrReview(String SheetName, int rowNum, String ReviewName)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		testlog.info("When User clicks on Review tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Reviewlanding", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrSubmitReview", 0);
		CommonMethod.RobustclickElementVisible("HsrSubmitReview", "ReviewModelSubmitButton");
		testlog.info("And User clicks on HsrSubmit DocReview button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewModelSubmitButton", 0);
		CommonMethod.RobustclickElementVisible("ReviewModelSubmitButton", "HsrCommentReview");
		CommonMethod.negativesoftassertPageSource(
				"Please provide your comments below to notify the IWBI team is required.",
				"Comment Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Doc-submit-phase is required.", "Phase Name Error Mismatch");
		testlog.info(
				"And User clicks on SubmitDocReview button without entering the mandatory fields and verifies error meassage");
		CommonMethod.WaitUntilVisibility("HsrCommentReview", 60).sendKeys(ReviewName);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrSelectedProjectPhaseReview", 0);
		CommonMethod.selectdropdownVisibletext("HsrSelectedProjectPhaseReview", ReviewName);
		testlog.info("And User select phase review");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewModelSubmitButton", 0);
		CommonMethod.RobustclickElementVisible("ReviewModelSubmitButton", "ReviewViewButton");
		testlog.info("And User clicks on HsrSubmit DocReview button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Reviewlanding", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewViewButton", 0);
		testlog.info("Then User will be redirected to Review list page");
		testlog.pass("**Submitted Health-Safety Review successfully**");
	}

	public void CompleteHsrReview(String SheetName, int rowNum, String ReviewName)
			throws IOException, InterruptedException {
		/*
		 * Admin Review
		 */
			if (TestCaseName.equalsIgnoreCase("Performance_TC_22_09_RenewalCompleteReview")) {
				performance.AdminWprSearch(SheetName, rowNum);
			}
			else {
				AdminHsrSearch(SheetName, rowNum);
			}
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "ReviewViewButton");
		testlog.info("And User clicks on Review tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewViewButton", 0);
		CommonMethod.RobustclickElementVisible("ReviewViewButton", "ReviewReturnButton");
		testlog.info("And User clicks on view button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewReturnButton", 0);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton", "ReviewReturnSubmit");
		testlog.info("And User clicks on Return button");
		testlog.info("And User Upload Review Document");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys(ReviewName);
		CommonMethod.RobustclickElementVisible("DatePickerButton", "DatePickerOkButton");
		CommonMethod.Robustclick("DatePickerOkButton");
		testlog.info("And User select Review Date");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		testlog.info("And User check Paymentstatus checkboxes");
		CommonMethod.uploadMultipleFile("DocumentsUpload", SampleJpgfile, SampleJpgfile, "MultipeUploadDeleteicon", 2,
				"MultipeUploadEnableButtonDeleteLink");
		CommonMethod.Robustclick("ReviewReturnSubmit");
		testlog.info("And User clicks on Submit button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewedStatus", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("ReviewedStatus"), "REVIEWED", "Verified Review status");
		testlog.info("Then User verifies Reviewed Status");
		testlog.pass("**Completed Reviewed Health-Safety Review successfully**");
	}

	public void HsrProjectFieldValidationTest(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "HsrWprOrganizationInformation");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrWprOrganizationInformation", 0);
		CommonMethod.RobustclickElementVisible("HsrWprOrganizationInformation", "HsrWprEditProjectName");
		testlog.info("And User clicks on OrganizationInformation tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrWprEditProjectName", 0);
		testlog.info("HsrName: " + data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("HsrWprEditProjectName"),
				data.getCellData(SheetName, "projectName", rowNum), "Project Name doesn't match");
		testlog.info("Area: " + data.getCellData(SheetName, "Area", rowNum));
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValue("HsrWprEditArea").replace("sq ft", "").replace(",", "").trim(),
				data.getCellData(SheetName, "Area", rowNum), "Area doesn't match");
		testlog.info("Location: " + data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("HsrWprEditLocation"),
				data.getCellData(SheetName, "Location", rowNum), "Location count doesn't match");
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
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("HsrWprEditState"),
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
		testlog.pass("**Verifies the Hsr Field Validation successfully**");
	}

	public void validateTeamsHSR(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrIdSearch", "HsrapplySearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("HsrapplySearch", "V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "1", "HealthSafety Search failed");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("HSRIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		testlog.info("And User verifies able to access the invited project");
		testlog.pass("**Verifies user able to access the invited project**");
	}

	public void clikOnDocumentLibrary() throws InterruptedException, IOException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DocumentLibraryTab", 0);
		CommonMethod.RobustclickElementVisible("DocumentLibraryTab", "HsrAddDoc");
		testlog.info("When User clicks on DocumentLibraryTab");
	}


	public void verifyScoreCardFilter(String filterName, String expectedResult, String FilterValidXpath)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardFilterButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
		testlog.info("When User clicks on Filter button");
		if (filterName.equalsIgnoreCase("Response")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardResponseFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardResponseFilter", "V2ProjectScorecardYesFilter");
			testlog.info("And User clicks on Response Filter option");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardYesFilter", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardYesFilter", "V2ProjectScorecardApplybutton");
			testlog.info("And User check the Yes checkbox");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardApplybutton", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "RatingScorecardFilterCloseValid");
			testlog.info("And User clicks on Apply button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RatingScorecardFilterCloseValid", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
			int YesFeature = CommonMethod.ElementSize("CommonSelectedPurseYes");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info(filterName + ": " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Response filter doesn't match");
			testlog.info("Then User verifies Scorecard Feature Count");
			CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "PortfolioFliterOptionClear");
			testlog.info("And User clicks on Filter button");
			CommonMethod.WaitUntilPresence("PortfolioFliterOptionClear", 180);
			CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear", "V2ProjectScoreCardFilterButton");
			testlog.info("And User clicks on Clear Filter button");
		}
		if (filterName.equalsIgnoreCase("Verification")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardResponseFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardResponseFilter",
					"V2ProjectScoreCardFilterButton");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardVerificationFilter", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
					"V2ProjectScorecardOnsitePhotographsFilter");
			testlog.info("And User clicks on Verification Option");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardOnsitePhotographsFilter", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardOnsitePhotographsFilter",
					"V2ProjectScorecardApplybutton");
			testlog.info("And User check the Photographs checkbox");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardApplybutton", 180);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "RatingScorecardFilterCloseValid");
			testlog.info("And User clicks on Apply Filter button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RatingScorecardFilterCloseValid", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
			int FeatureCount = CommonMethod.ElementSize("V2ProjectWPRPFeature");
			String actualYesFeatureCount = Integer.toString(FeatureCount);
			testlog.info(filterName + ": " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Verification filter doesn't match");
			testlog.info("Then User verifies Scorecard Feature Count");
			CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "PortfolioFliterOptionClear");
			testlog.info("And User clicks on Filter button");
			CommonMethod.WaitUntilPresence("PortfolioFliterOptionClear", 180);
			CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear", "V2ProjectScoreCardFilterButton");
			testlog.info("And User clicks on Clear Filter button");
		}
		if (filterName.equalsIgnoreCase("Document Scale")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardVerificationFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
					"V2ProjectScorecardOnsitePhotographsFilter");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardDocumentScaleFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentScaleFilter",
					"V2ProjectScorecardOnsitePhotographsFilter");
			testlog.info("And User clicks on DocumentScale Option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioIndividualFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioIndividualFilter", "V2ProjectScorecardApplybutton");
			testlog.info("And User check the Individual checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "RatingScorecardFilterCloseValid");
			testlog.info("And User clicks on Apply Filter button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RatingScorecardFilterCloseValid", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
			int FeatureCount = CommonMethod.ElementSize("V2ProjectWPRPFeature");
			String actualYesFeatureCount = Integer.toString(FeatureCount);
			testlog.info(filterName + ": " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Document Scale filter doesn't match");
		}
		testlog.info("Then User verifies Scorecard Feature Count");
		testlog.pass("**Verifies filter " + filterName + " options successfully**");
	}

	public void SearchHealthSafetyByStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on HealthSafety Project List");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLHealthSafetyNavBar");
		testlog.info("When User clicks on ProjectNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WELLHealthSafetyNavBar", 0);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		testlog.info("And User clicks on WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrIdSearch", 0);
		CommonMethod.RobustclickElementVisible("HsrIdSearch", "HsrIdSearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrIdSearch", 0);
		CommonMethod.clearAndSendKey("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enters to HsrIdSearch field");
		CommonMethod.RobustclickElementVisible("HsrapplySearch", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on apply button");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " + status);
		CommonMethod.negativesoftassertFieldValid(status, "ACHIEVED", "HealthSafety Search failed");
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount), "1", "HealthSafety Search failed");
		rc.ValidateDateInList();
		testlog.info("Then User verifies Project Status");
		testlog.pass("**Verifies search filter status successfully**");
	}

	public void searchFilterDocumentHSR(String documentName, String filterOption, String fileCount)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		if (filterOption.equalsIgnoreCase("Audit")) {
			CommonMethod.RobustclickElementVisible("HsrAuditLinkTab", "V2ProjectDecumentSearchBox");
			testlog.info("And User clicks on AuditLinkTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDecumentSearchBox", 0);
		}
		if (filterOption.equalsIgnoreCase("General")) {
			CommonMethod.RobustclickElementVisible("HsrGeneralLink", "V2ProjectDecumentSearchBox");
			testlog.info("And User clicks on GeneralLinkTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDecumentSearchBox", 0);
		}
		CommonMethod.WaitUntilVisibility("V2ProjectDecumentSearchBox", 60);
		CommonMethod.clearAndSendKey("V2ProjectDecumentSearchBox", documentName);
		testlog.info("And User enter data to SearchBox field");
		CommonMethod.RobustclickElementVisible("HSRDocumentSearchButton", "V2ProjectDecumentSearchBox");
		testlog.info("And User clicks on Search Button");
		if (filterOption.equalsIgnoreCase("General")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRDocumentGeneralFileCount", 0);
			int V2ProjectScoreDocCount = CommonMethod.ElementSize("HSRDocumentGeneralFileCount");
			String V2ProjectDocCounts = Integer.toString(V2ProjectScoreDocCount);
			CommonMethod.negativesoftassertFieldValid(V2ProjectDocCounts, fileCount,"Document General FileCount doesn't match");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDocumentGeneralFileCount", 0);
			int V2ProjectScoreDocCount = CommonMethod.ElementSize("V2ProjectDocumentGeneralFileCount");
			String V2ProjectDocCounts = Integer.toString(V2ProjectScoreDocCount);
			CommonMethod.negativesoftassertFieldValid(V2ProjectDocCounts, fileCount,"Document General FileCount doesn't match");
		}
		testlog.info("Then User verifies Document List");
		testlog.pass("**Verifies search filter successfully **");
	}

	public void ValidDashboardHsrField() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		testlog.info("Then User verifies SideBar Navigation tab");
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
		testlog.pass("**Verifies Dashboard fields and SideBar Navigation tab successfully **");
	}

	public void UpdateReviewHSR(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL Admin certified account");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLHealthsafetyNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminWELLHealthsafetyNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminWELLHealthsafetyNavBar", "HsrAdminIdSearch");
		CommonMethod.WaitUntilClickble("HsrAdminIdSearch", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("HsrAdminApplybtn", "HsrAdminIdClick");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("HsrAdminIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("HsrAdminIdClick", "WellV2DashboardTab");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 300);
		CommonMethod.RobustclickElementVisible("ReviewTab", "ReviewViewButton");
		CommonMethod.RobustclickElementVisible("V2ProjectReviewViewLink", "V2ProjectReviewEditButton");
		CommonMethod.RobustclickElementVisible("V2ProjectReviewEditButton",
				"V2ProjectReviewNeedClarificationRadioButton");
		CommonMethod.ClickCheckbox("V2ProjectReviewNeedClarificationRadioButton");
		CommonMethod.sendKeys("V2ProjectReviewMidReviewClarificationNote", "Test");
		CommonMethod.RobustclickElementVisible("V2ProjectReviewUpdate", "V2ProjectReviewRequiredClarification");
	}

	public void ReSubmitReviewHSR(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.RobustclickElementVisible("ReviewTab", "V2ProjectReviewViewLink");
		CommonMethod.RobustclickElementVisible("V2ProjectReviewViewLink", "V2ProjectReviewReSubmitButton");
		CommonMethod.RobustclickElementVisible("V2ProjectReviewReSubmitButton", "V2ProjectReviewCommentTextArea");
		CommonMethod.sendKeys("V2ProjectReviewCommentTextArea", "Test");
		CommonMethod.Robustclick("SubmitButton");
	}

	public void AdminHsrSearch(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * Admin Review
		 */
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLHealthsafetyNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminWELLHealthsafetyNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminWELLHealthsafetyNavBar", "HsrAdminIdSearch");
		testlog.info("When User clicks on WELL HealthSafety from top menu under Projects");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrAdminIdSearch", 0);
		CommonMethod.RobustclickElementVisible("HsrAdminIdSearch", "HsrAdminApplybtn");
		CommonMethod.sendKeys("HsrAdminIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enter data to HsrId");
		CommonMethod.RobustclickElementVisible("HsrAdminApplybtn", "HsrAdminIdClick");
		testlog.info("And User clicks on Apply button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TableTrSize", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("HsrAdminIdClick"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("HsrAdminIdClick", "ReviewTab");
		testlog.info("And User clicks on HsrAdminId");
	}

	public void VerifyReviewErrorMessageByMinScorecardPurseYes() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardTab", 0);
		CommonMethod.RobustclickElementVisible("ScorecardTab", "WPRPortfolioScorecardLanding");
		testlog.info("And User clicks on ScorecardTab");
		rc.ScorecardLoading();
		if (!TestNGTestName.contains("NonEnhanced")) {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommonScorecardPurseYes", 0);
		CommonMethod.click("CommonScorecardPurseYes1");
		if (CommonMethod.isElementsExist("WPRCloseIcon", 10)) {
			CommonMethod.WaitUntilVisibility("WPRCloseIcon", 120);
			CommonMethod.WaitUntilInVisibility("WPRCloseIcon", 60);
		}
		CommonMethod.click("CommonScorecardPurseYes1");
		if (CommonMethod.isElementsExist("WPRCloseIcon", 20)) {
			CommonMethod.WaitUntilVisibility("WPRCloseIcon", 120);
			CommonMethod.WaitUntilInVisibility("WPRCloseIcon", 60);
		}
		}
		else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("NonEnhancedHsrScorecardPurseYes", 0);
			CommonMethod.click("NonEnhancedHsrScorecardPurseYes");
		}
		// Verify Review ErrorMessage ByMinScorecardPurseYes
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "HsrSubmitReview");
		testlog.info("When User clicks on Review button");
		CommonMethod.WaitUntilPresence("HsrSubmitReview", 180);
		CommonMethod.RobustclickElementVisible("HsrSubmitReview", "ValidReviewErrorMessage1");
		testlog.info("And User clicks on HsrSubmit DocReview button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ValidReviewErrorMessage1", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("ValidReviewErrorMessage1"),
				"Oops! It looks like your scorecard is incomplete.", "Review Mark Error message doesn't match");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrSubmitReview", 0);
		testlog.info("And User verifies Review ErrorMessage By Minimum selecting ScorecardPurseYes");
	}

	public void RegisterHealthSafetySF(String SheetName, int rowNum, String Country, String ProjectName) throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified account");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLHealthSafetyNavBar");
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrWellhealthstartprojectbtn");
		testlog.info("When User clicks on WELL HealthSafety from top menu under Projects");
		CommonMethod.RobustclickElementVisible("HsrWellhealthstartprojectbtn", "HsrEnrollnowbtn");
		testlog.info("And User clicks on Start project button");
		CommonMethod.RobustclickElementVisible("HsrEnrollnowbtn", "HsrEnrollbtn");
		testlog.info("And User clicks on EnrollNow button");
		CommonMethod.RobustclickElementVisible("HsrEnrollbtn", "Hsrenrollcontinuebtn");
		testlog.info("And User clicks on Enroll button");
		String erollName = ProjectName + "_"+CommonMethod.randomNumber(8000000);
		CommonMethod.sendKeys("HsrenrollName", erollName);
		data.setCellData(SheetName, "projectName", rowNum, CommonMethod.getattributeValue("HsrenrollName"));
		testlog.info("And User enter data to EnrollName");
		testlog.info("HsrName: " + data.getCellData(SheetName, "projectName", rowNum));
		CommonMethod.ClickCheckbox("Hsrenrollcheckbox");
		testlog.info("And User checks the enroll checkbox");
		String Ownername = USfaker.address().firstName();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPROwnerName", 0);
		CommonMethod.sendKeys("WPROwnerName", Ownername);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("WPROwnerName"));
		rc.SelectOwnerOrg(SheetName, rowNum);
		data.setCellData(SheetName, "OrgName", rowNum, CommonMethod.getText("OrgName"));
		CommonMethod.selectdropdownrandom("OrgIndustry");
		testlog.info("And User select OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.selectdropdownValue("Hsrenrollcountry", Country);
		rc.SelectEnterpriseProviders(SheetName, rowNum);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownAttribute("Hsrenrollcountry"));
		CommonMethod.selectdropdownrandom("Hsrenrollstate");
		testlog.info("And User enter data to Owner Country, State, Street address, City and Postal Code fields");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("Hsrenrollcountry"));
		testlog.info("OwnerName: " + data.getCellData(SheetName, "OwnerName", rowNum));
		testlog.info("OrganizationName: " + data.getCellData(SheetName, "OrgName", rowNum));
		testlog.info("State: " + CommonMethod.getSelectedDropdownAttribute("Hsrenrollstate"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("Hsrenrollstate"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("Hsrenrollstreet", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("Hsrenrollstreet"));
		testlog.info("Hsrenrollstreet: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("Hsrenrollcity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("Hsrenrollcity"));
		testlog.info("City: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("Hsrenrollpostalcode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("Hsrenrollpostalcode"));
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.ClickCheckbox("Hsrbilladdcheckbox");
		testlog.info("And User checks the Billing checkbox");
		CommonMethod.RobustclickElementVisible("Hsrenrollcontinuebtn", "HsrRegcontinuebtn");
		testlog.info("And User clicks on continue button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Hsrregcheckbox", 0);
		CommonMethod.ClickCheckbox("Hsrregcheckbox");
		testlog.info("And User checks the terms and conditions checkbox");
		CommonMethod.selectdropdownVisibletext("HsrIwbimemberdropdown", "No");
		testlog.info("And User select Iwbi member");
		CommonMethod.RobustclickElementVisible("HsrRegcontinuebtn", "HsrEnrollButton");
		testlog.info("And User clicks on continue button");
		Thread.sleep(3000);
		String projectId = CommonMethod.getCurrentUrl();
		System.out.println("projectId: " + projectId);
		String[] getHsrId = projectId.split("/");
		System.out.println("Id: " + getHsrId[6]);
		data.setCellData(SheetName, "ProjectID", rowNum, getHsrId[6]);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void EnrollHealthSafetySF(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified account");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Hsrlocations", 0);
		CommonMethod.sendKeys("Hsrlocations", "10");
		data.setCellData(SheetName, "Location", rowNum, CommonMethod.getattributeValue("Hsrlocations"));
		testlog.info("And User enter data to location");
		testlog.info("Hsrlocations: " + data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpacetype", "HsrWPRlocationsSpaceOption");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpaceOption", "Hsrlocationsize");
		data.setCellData(SheetName, "SpaceTypes", rowNum, CommonMethod.getText("HsrWPRlocationsSpacetype"));
		testlog.info("And User select the space type");
		testlog.info("Location SpaceType: " + data.getCellData(SheetName, "SpaceTypes", rowNum));
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		CommonMethod.clearAndSendKey("Hsrlocationsize", Area);
		data.setCellData(SheetName, "Area", rowNum, CommonMethod.getattributeValue("Hsrlocationsize"));
		testlog.info("Hsrlocations: " + data.getCellData(SheetName, "Area", rowNum));
		testlog.info("And User enter the Location Size");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrLocContinuebutton", 0);
		CommonMethod.RobustclickElementVisible("HsrLocContinuebutton", "HsrDiscountBackButton");
		testlog.info("And User clicks on continue button");
		testlog.pass("**Verifies the Enroll successful**");
	}

	public void AgreementHealthSafetySF(String SheetName, int rowNum) throws IOException, InterruptedException {

		if (CommonMethod.isElementsExist("HsrWPRYesMyOrganizationCbx", 10)) {
			CommonMethod.RobustclickElementVisible("HsrProgramFeeContinuebtn", "HsrWPRYesMyOrganizationCbx");
			CommonMethod.negativesoftassertPageSource(
					"Yes, my organization meets the criteria of the listed discount category.* is required.",
					"My Organization CheckBox Error Name");
			CommonMethod.WaitUntilClickble("HsrWPRYesMyOrganizationCbx", 60);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
			testlog.info("And User checks the MyOrganization checkbox");
		}
		CommonMethod.RobustclickElementVisible("HsrProgramFeeContinuebtn", "HsrProgramFeePublicrbtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrProgramFeePublicrbtn", 0);
		CommonMethod.scrolldowntoElement("HsrProgramFeePublicrbtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrProgramFeePublicrbtn", 0);
		CommonMethod.ClickCheckbox("HsrProgramFeePublicrbtn");
		testlog.info("And User check on Program Fee Public checkboxes");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrAcknowledecbx", 0);
		CommonMethod.ClickCheckbox("HsrAcknowledecbx");
		testlog.info("And User check on Acknowlede checkboxes");
		CommonMethod.RobustclickElementVisible("HsrReviewbtn", "BillingLanding");
		testlog.info("And User clicks on Review button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("BillingLanding", 0);
		testlog.info("Then User will be redirected to Billing invoice page");
		testlog.pass("**Verifies the Agreement successful**");
	}

	public void hsrSearchFilterRegisteredStatus(String SheetName, int rowNum, String Status)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WELLHealthSafetyNavBar", 0);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		testlog.info("When User clicks on WELL Healthsafety from top menu under Projects");
		CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrIdSearch", "HsrIdSearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enter data to HsrId");
		CommonMethod.RobustclickElementVisible("HsrapplySearch", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRIdClick", 0);
		int ProjectCount = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectCount), "1", "HealthSafety Search failed");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("HSRIdClick"),
				data.getCellData(SheetName, "ProjectID", rowNum), "Project Id doesn't matches in search");
		String status = CommonMethod.getText("HsrWprStatusResultList");
		testlog.info("Status: " + status);
		CommonMethod.negativesoftassertFieldValid(status, Status, "HealthSafety Search failed");
		testlog.info("Then User verifies HsrStatus in search filter");
		CommonMethod.Robustclick("HSRIdClick", "HsrapplySearch");
		testlog.info("And User will be redirected to Dashboard page");
		testlog.pass("**Verifies the Search filter status successfully**");
	}
	
	public void OrganizationInformationPrivateToPublic() throws Exception {
		testlog.info("Given User is on Dashboard page");
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "HSROrgInfoButton");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSROrgInfoButton", 0);
		CommonMethod.RobustclickElementVisible("HSROrgInfoButton", "HsrProgramFeePublicrbtn");
			testlog.info("And User clicks on Organization Information Button");
			 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrProgramFeePublicrbtn", 0);
				CommonMethod.ClickCheckbox("HsrProgramFeePublicrbtn");
				 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSaveChangesButton", 0);
				CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "WellV2DashboardTab");
				 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		}
	
	@SuppressWarnings("static-access")
	public void LocationProjectStatusValidation(String Status)throws IOException, InterruptedException {
		testlog.info("Given User is on Location page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
	List<String> val = CommonMethod.fetchTableData("table");
	if(Status.equalsIgnoreCase("NO")) {
	 pfu.ValidTableDataUpdateLocation(val, "WELL at scale Test location 1", 4, Status);
		pfu.ValidTableDataUpdateLocation(val, "WELL at scale Test location 2", 16, Status);
		pfu.ValidTableDataUpdateLocation(val, "WELL at scale Test location 3", 28, Status);
		pfu.ValidTableDataUpdateLocation(val, "WELL at scale Test location 4", 40, Status);
		pfu.ValidTableDataUpdateLocation(val, "WELL at scale Test location 5", 52, Status);
		testlog.info("Then User verifies Public Project Status");
		testlog.pass("**Verifies the Public Project Status successful**");
		}
	else {
		    pfu.ValidTableDataUpdateLocation(val, "WELL at scale Test location 1", 4, Status);
			pfu.ValidTableDataUpdateLocation(val, "WELL at scale Test location 2", 17, Status);
			pfu.ValidTableDataUpdateLocation(val, "WELL at scale Test location 3", 30, Status);
			pfu.ValidTableDataUpdateLocation(val, "WELL at scale Test location 4", 43, Status);
			pfu.ValidTableDataUpdateLocation(val, "WELL at scale Test location 5", 56, Status);
			testlog.info("Then User verifies Converted Public Project Status");
			testlog.pass("**Verifies the Converted Public Project Status successful**");
	}
}
	
	public void UpdateLocationPrivateToPublic()throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationsTab", 0);
		CommonMethod.RobustclickElementVisible("LocationsTab", "PortfolioLocationLanding");
		testlog.info("When User clicks on LocationsTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditLocation", 0);
		List<WebElement> EditLoc;
		EditLoc = CommonMethod.findElements("EditLocation");
		for (WebElement f : EditLoc) {
			CommonMethod.JavascriptClickElement(f);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditLocationPublic", 0);
			CommonMethod.ClickCheckbox("EditLocationPublic");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubmitButton", 0);
			CommonMethod.RobustclickElementVisible("SubmitButton", "LocationResultCount");
	}
	}
	public void ValidationSealAndDate()throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
	CommonMethod.RobustclickElementVisible("WellV2DashboardTab", "SealImgValidate");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SealImgValidate", 0);
	CommonMethod.assertisElementPresentTrue("SealImgValidate", "Seal Image is not visble");
	testlog.info("Then User verifies seal from and to date");
	String SealDate =CommonMethod.getText("SealDateValidate");
	String[] Date = SealDate.split("to");
	String fromDate = Date[0].split("from")[1].trim();
	String toDate =Date[1].trim();
	CommonMethod.negativesoftassertFieldValid(fromDate,CommonMethod.ValidateDate(),"Seal Current Year Date Mismatch");
	CommonMethod.negativesoftassertFieldValid(toDate,CommonMethod.ValidateDateYear(),"Seal Next Year Date Mismatch");
	testlog.pass("**Verifies the Seal Date successful**");
	}
	
	public void uploadDocumentInFeatureNonEnhance(int LastFeatureNumber) throws IOException, InterruptedException {
		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrScorecardAplicableVersion", 0);
		CommonMethod.scrolldowntoElement("HsrScorecardAplicableVersion");
		for (WebElement f : Feature) {
			CommonMethod.JavascriptClickElement(f);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPDocIcon", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectWPRPDocIcon", "HsrSelectTypeDoc");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrSelectTypeDoc", 0);
			CommonMethod.selectdropdownIndex("HsrSelectTypeDoc", 1);
			if (CommonMethod.isElementsExist("HsrLocationrtn", 3)) {
				CommonMethod.WaitUntilClickble("HsrLocationrtn", 10);
				CommonMethod.ClickCheckbox("HsrLocationrtn");
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRVerificationMethod", 0);
			CommonMethod.selectdropdownIndex("V2ProjectWPRVerificationMethod", 1);
			CommonMethod.scrolldowntoElement("V2ProjectWPRVerificationMethod");
			if (CommonMethod.isElementsExist("HsrSelectLoc", 3)) {
				CommonMethod.WaitUntilClickble("HsrSelectLoc", 10);
				CommonMethod.selectdropdownIndex("HsrSelectLoc", 1);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDocUpload", 0);
			CommonMethod.uploadFile("V2ProjectDocUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
			Thread.sleep(2000);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrUploadDocFeature", 0);
			CommonMethod.Robustclick("HsrUploadDocFeature");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecrdEhanceDeleteIcon", 0);
			CommonMethod.scrolldowntoElement("HsrScorecardAplicableVersion");
			CommonMethod.JavascriptClickElement(f);
		}
	}
	
	public void validateGeneralUploadDocumentNonEnhance() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrNonEhAddDoc", 0);
		CommonMethod.Robustclick("HsrNonEhAddDoc");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrDocType", 0);
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn", "ErrorMessage");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ErrorMessage", 0);
		CommonMethod.negativesoftassertPageSource("DocumentType is required.", "Acount Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Attach Document(s): is required.", "Attach Document Error Mismatch");
		CommonMethod.selectdropdownValue("HsrDocType", "general");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrType", 0);
		CommonMethod.selectdropdownValue("HsrType", "Project overview");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocUpload", 0);
		CommonMethod.uploadFile("WPRDocUpload", GeneralfileUpload,"UploadFileVerifyScorecard");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrReasonnarration", 0);
		CommonMethod.sendKeys("HsrReasonnarration", "Submitting Document");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrDocumentUploadbtn", 0);
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn", "PortfolioV2ProjectGeneralDoc");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioV2ProjectGeneralDoc", 0);
		CommonMethod.RobustclickElementVisible("PortfolioV2ProjectGeneralDoc", "Table");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Table", 0);
		CommonMethod.scrolldowntoElement("HsrGeneralTable");
		List<String> val = CommonMethod.fetchTableData("HsrGeneralTable");
		CommonMethod.negativesoftassertFieldValid(val.get(0), "PROJECT OVERVIEW", "Document table data mismatch");
		testlog.pass("**Upload General Document successfully**");
	}

	public void validateLegalUploadDocumentNonEnhance() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrNonEhAddDoc", 0);
		CommonMethod.Robustclick("HsrNonEhAddDoc");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrDocType", 0);
		CommonMethod.selectdropdownValue("HsrDocType", "legal");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrType", 0);
		CommonMethod.selectdropdownValue("HsrType", "Signed certification agreement");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocUpload", 0);
		CommonMethod.uploadFile("WPRDocUpload", LegalfileUpload,"UploadFileVerifyScorecard");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrReasonnarration", 0);
		CommonMethod.sendKeys("HsrReasonnarration", "Submitting Document");
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn", "PortfolioV2ProjectGeneralDoc");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioV2ProjectGeneralDoc", 0);
		CommonMethod.RobustclickElementVisible("PortfolioV2ProjectGeneralDoc", "Table");
		CommonMethod.scrolldowntoElement("HsrGeneralTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Table", 0);
		List<String> val = CommonMethod.fetchTableData("HsrGeneralTable");
		CommonMethod.negativesoftassertFieldValid(val.get(0), "SIGNED CERTIFICATION AGREEMENT",
				"Document table data mismatch");
		testlog.pass("**Upload Legal Document successfully**");
	}

	public void validateAuditUploadDocumentNonEnhance() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrNonEhAddDoc", 0);
		CommonMethod.Robustclick("HsrNonEhAddDoc");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrDocType", 0);
		CommonMethod.selectdropdownValue("HsrDocType", "audit");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrLocationRadiobutton", 0);
		CommonMethod.ClickCheckbox("HsrLocationRadiobutton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrVerificationMethod", 0);
		CommonMethod.selectdropdownVisibletext("HsrVerificationMethod", "Technical Document (Audited)");
		CommonMethod.scrolldowntoElement("HsrVerificationMethod");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrContainedDocument", 0);
		CommonMethod.RobustclickElementVisible("HsrContainedDocument", "HsrContainedDocumentOption");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", "OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "I");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 2).click();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrLocationVerificationDoc", 0);
		CommonMethod.selectdropdownrandom("HsrLocationVerificationDoc");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocUpload", 0);
		CommonMethod.uploadFile("WPRDocUpload", AuditfileUpload, "UploadFileVerifyScorecard");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrDocumentUploadbtn", 0);
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn", "HsrAuditLinkTab");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrAuditLinkTab", 0);
		CommonMethod.RobustclickElementVisible("HsrAuditLinkTab", "HsrAuditTable");
		CommonMethod.scrolldowntoElement("HsrAuditLinkTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrAuditTable", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrAuditTableTr", 10);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrAuditSI1Valid", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("HsrAuditSI1Valid"), "Audit Document", "Document table data mismatch");
		testlog.pass("**Upload Audit Document successfully**");
	}

	public void validateFeatureUploadDocumentNonEnhance() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrNonEhAddDoc", 0);
		CommonMethod.Robustclick("HsrNonEhAddDoc");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrDocType", 0);
		CommonMethod.selectdropdownValue("HsrDocType", "feature");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrLocationRadiobutton", 0);
		CommonMethod.ClickCheckbox("HsrLocationRadiobutton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrVerificationMethod", 0);
		CommonMethod.selectdropdownVisibletext("HsrVerificationMethod", "Policy and/or Operations Schedule");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrContainedDocument", 0);
		CommonMethod.RobustclickElementVisible("HsrContainedDocument", "HsrContainedDocumentOption");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", "OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 2).click();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrLocationVerificationDoc", 0);
		CommonMethod.selectdropdownrandom("HsrLocationVerificationDoc");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocUpload", 0);
		CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrDocumentUploadbtn", 0);
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn", "HsrLibraryLinkTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrLibraryLinkTab", 0);
		CommonMethod.RobustclickElementVisible("HsrLibraryLinkTab", "HsrAuditTable");
		CommonMethod.scrolldowntoElement("HsrLibraryLinkTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrAuditTable", 0);
		List<String> val = CommonMethod.fetchTableData("HsrAuditTable");
		CommonMethod.negativesoftassertFieldValid(val.get(3), "Policy and/or Operations Schedule", "Document table data mismatch");
		testlog.pass("**Upload Feature Document successfully**");
	}
	
	public void clikOnDocumentLibraryEh() throws InterruptedException, IOException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilPresence("DocumentLibraryTab", 300);
		CommonMethod.RobustclickElementVisible("DocumentLibraryTab", "HsrNonEhAddDoc");
		testlog.info("When User clicks on DocumentLibraryTab");
	}
	
	public void validateAchievementDocument(String documentObjectLocator)throws IOException, InterruptedException {
	    testlog.info("Given User is on Achievements Tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AchievementsTab", 0);
		CommonMethod.RobustclickElementVisible("AchievementsTab", "HsrDownloadDocsLink");
		testlog.info("When User clicks on Download Document Link");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrDownloadDocsLink", 0);
		CommonMethod.RobustclickElementVisible("HsrDownloadDocsLink", documentObjectLocator);
		testlog.info("Then User Downloaded The Documents and Validated the Text");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrValidateDownloadedDocs", 0);
		String HsrValidateDownloadedDocs = CommonMethod.getattributeValueByTextContent("HsrValidateDownloadedDocs").trim();
		CommonMethod.negativesoftassertFieldValid(HsrValidateDownloadedDocs, "You will receive an email with a download link shortly", "Downloaded Text Message Does not Matched");
	}
	
	public void validateDownloadedAchievementDocument(String documentObjectLocator, String expectedURL)throws IOException, InterruptedException {
		
		CommonMethod.ClearDownloadFile();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(documentObjectLocator, 0);
		if(documentObjectLocator.equalsIgnoreCase("HsrDownloadAchievmentDocsRatingLetter") 
		|| documentObjectLocator.equalsIgnoreCase("HsrDownloadAchievmentDocsRatingCertificate")
	    || documentObjectLocator.equalsIgnoreCase("LocationDownloadPromotionWellTookKit")
	    || documentObjectLocator.equalsIgnoreCase("LocationDownloadPromotionWellBrandingGuidelines")
	    || documentObjectLocator.equalsIgnoreCase("LocationDownloadPromotionWellCollateral") 
		|| documentObjectLocator.equalsIgnoreCase("PortfolioDownloadAchievmentDocsRatingCertificate")) {
			CommonMethod.click(documentObjectLocator);
			testlog.info("When User Clicks on Download Document Icon");
			Thread.sleep(3000);	
			CommonMethod.switchToChildTab();
			Thread.sleep(3000);
			String childUrl = CommonMethod.getCurrentUrl();
			CommonMethod.negativesoftassertFieldValid(childUrl, expectedURL, "URL does not matched");		
		}
		if(documentObjectLocator.equalsIgnoreCase("HsrDownloadAchievmentDocsWELLHealthSafetySeal")
		|| (documentObjectLocator.equalsIgnoreCase("PortfolioDownloadAchievmentDocsWELLHealthSafetySeal")
		|| (documentObjectLocator.equalsIgnoreCase("LocationsAchievmentDownloadDigitalSeal")
		|| (documentObjectLocator.equalsIgnoreCase("LocationsAchievmentDownloadLetterOfAchievement")
		|| (documentObjectLocator.equalsIgnoreCase("LocationsAchievmentDownloadCertificate")))))){
		CommonMethod.click(documentObjectLocator);
		testlog.info("When User Clicks on Download Document Icon");
		Thread.sleep(3000);
		boolean fileExistsReturnValue = CommonMethod.isFileDownloaded();
		testlog.info("Then User verifies Downloaded file");
		String fileExists = Boolean.toString(fileExistsReturnValue);
		CommonMethod.negativesoftassertFieldValid(fileExists, "true", "Downloaded Billing Receipt file doesn't Exist");
		testlog.pass("**Verifies Download Billing Receipt And Validate successfully**");
		}
		CommonMethod.switchToParentTab();	
	}
	
	public void HsrMarkAsYes(String SheetName, int rowNum, String FeatureName) throws Exception {
		
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 10);
		List<WebElement> Feature;
		boolean flag = false;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				System.out.println("FeatureName: " + FeatureName);
				CommonMethod.WaitUntilClickble(ele, 120);
				CommonMethod.JavascriptClickElement(ele);
				flag = true;
				testlog.info("When User clicks on Feature");
				CommonMethod.scrolldowntoElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardlocAccountValidMessage1", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardlocAccountValidMessage1"); 
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("PortfolioAccLocScoreCardSelectUploadButton");
				CommonMethod.assertisElementPresentFalse("PortfolioAccLocScoreCardSelectUploadButton", "Upload button element present");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardlocAccountValidMessage1", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardlocAccountValidMessage1"); 
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectHsrOptnRenewalYesTick",1);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectHsrOptnRenewalScorecardDocumentStillCurrentMsg", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectHsrOptnRenewalScorecardDocumentStillCurrentMsg"), "Are these documents still current",
						"Renewal Scorecard Current document doesn't match");
				CommonMethod.assertisElementPresentTrue("V2ProjectHsrOptnRenewalYesTick", "Renewal YesTick element doesn't present");
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectHsrOptnRenewalNoTick", 1);
				CommonMethod.assertisElementPresentTrue("V2ProjectHsrOptnRenewalNoTick", "Renewal NoTick element doesn't present");
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectHsrOptnUploadDocDeleteIconRenewal", 1);
				CommonMethod.assertisElementPresentTrue("V2ProjectHsrOptnUploadDocDeleteIconRenewal", "Renewal DeleteDisableIcon element doesn't present");
				CommonMethod.Robustclick("V2ProjectHsrOptnRenewalYesTick");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrRenewalScorecardDocumentWarningmessage", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("HsrRenewalScorecardDocumentWarningmessage"), "Thank you for the confirmation!",
						"Renewal Warningmessage doesn't match");
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("V2ProjectHsrOptnRenewalYesTick");
				CommonMethod.assertisElementPresentFalse("V2ProjectHsrOptnRenewalYesTick", "YesTick icon element present");
				CommonMethod.assertisElementPresentFalse("V2ProjectHsrOptnRenewalNoTick", "NoTick icon element present");
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("HsrRenewalScorecardDocumentSC3WarningIcon");
				CommonMethod.assertisElementPresentFalse("HsrRenewalScorecardDocumentSC3WarningIcon", "Renewal Warning Paper icon element present");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +FeatureName +" doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
}
	
public void HsrMarkAsNo(String SheetName, int rowNum, String FeatureName) throws IOException, InterruptedException {
		
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 10);
		List<WebElement> Feature;
		boolean flag = false;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				System.out.println("FeatureName: " + FeatureName);
				CommonMethod.WaitUntilClickble(ele, 120);
				CommonMethod.JavascriptClickElement(ele);
				flag = true;
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardlocAccountValidMessage1", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardlocAccountValidMessage1"); 
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectHsrOptnRenewalYesTick", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectHsrOptnRenewalNoTick", 0);
				CommonMethod.Robustclick("V2ProjectHsrOptnRenewalNoTick");
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("V2ProjectHsrOptnRenewalYesTick");
				CommonMethod.assertisElementPresentFalse("V2ProjectHsrOptnRenewalYesTick", "YesTick icon element present");
				CommonMethod.assertisElementPresentFalse("V2ProjectHsrOptnRenewalNoTick", "NoTick icon element present");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrRenewalScorecardDocumentWarningmessage", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("HsrRenewalScorecardDocumentWarningmessage"), "Thank you for the confirmation!",
						"Renewal Warningmessage doesn't match");
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectHsrOptnUploadDocDeleteIconRenewal", 1);
				CommonMethod.assertisElementPresentTrue("V2ProjectHsrOptnUploadDocDeleteIconRenewal", "Renewal DeleteDisableIcon element doesn't present");
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("HsrRenewalScorecardDocumentSC4WarningIcon", 1);
				CommonMethod.assertisElementPresentTrue("HsrRenewalScorecardDocumentSC4WarningIcon", "Renewal Warning Paper icon element present");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +FeatureName +" doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
    }

       public void purseYesValidFromScorecard() throws IOException, InterruptedException {
    	 
	    testlog.info("Given User on Scorecard page");
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardPurseYesSelect", 0);
	    CommonMethod.click("HSRScorecardPurseYesSelect");
	    testlog.info("And User click on Purse Yes");
	    CommonMethod.WaitUntilNumberOfElementToBePresentWithException("HSRScorecardPurseYesSelected", 1);
	    CommonMethod.assertisElementPresentTrue("HSRScorecardPurseYesSelected", "PurseYes is not selected");
	    testlog.info("And User verifies the Selected Purse Yes");
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
	    String pursueToastText = CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast");
	    CommonMethod.negativesoftassertFieldValid(pursueToastText,
			"Pursue status changed!", "Purse Status message Doesn't match");
	    testlog.info("Then User verifies the Pursue status message");
	    testlog.pass("**Verifies the Pursue Yes status successful**");
      }
       
   	public void purseNoValidFromScorecard() throws IOException, InterruptedException {
   		
   		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardPurseNoSelect", 0);
		CommonMethod.click("HSRScorecardPurseNoSelect");
		testlog.info("And User click on Purse No");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("HSRScorecardPurseNoSelected", 1);
		CommonMethod.assertisElementPresentTrue("HSRScorecardPurseNoSelected", "PurseNo is not selected");
		testlog.info("And User verifies the Selected Purse No");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"),
				"Pursue status changed!", "Purse Status message Doesn't match");
		testlog.info("Then User verifies the Pursue status message");
		testlog.pass("**Verifies the Pursue No status successful**");

	}
   	
	public void purseMaybeValidFromScorecard() throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardPurseMayBeSelect", 0);
		CommonMethod.click("HSRScorecardPurseMayBeSelect");
		testlog.info("And User click on Purse Maybe");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("HSRScorecardPurseMayBeSelected", 1);
		CommonMethod.assertisElementPresentTrue("HSRScorecardPurseMayBeSelected", "PurseMaybe is not selected");
		testlog.info("And User verifies the Selected Purse Maybe");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"),
				"Pursue status changed!", "Purse Status message Doesn't match");
		testlog.info("Then User verifies the Pursue status message");
		testlog.pass("**Verifies the Pursue Maybe status successful**");

	}
	
	public void purseYesToNoValidFromScorecard() throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardPurseYesToNoSelect", 0);
		CommonMethod.Robustclick("HSRScorecardPurseYesToNoSelect");
		testlog.info("And User click on Purse No");
        CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoCancel", 0);
		testlog.info("And User verifies confirm button");
		testlog.info("And User verifies cancel button");
		// cancel
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoCancel");
		// Confirm
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardPurseYesToNoSelect", 0);
		CommonMethod.Robustclick("HSRScorecardPurseYesToNoSelect");
		rc.confirmPursing();
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("HSRScorecardPurseYesToNoSelected", 1);
		CommonMethod.assertisElementPresentTrue("HSRScorecardPurseYesToNoSelected", "PurseNo is not selected");
		testlog.pass("**Verifies the Pursue No status successful**");
	}
	
	public void purseMaybeToNoValidFromScorecard() throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardPurseMaybeToNoSelect", 0);
		CommonMethod.click("HSRScorecardPurseMaybeToNoSelect");
		testlog.info("And User click on Purse No");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("HSRScorecardPurseMaybeToNoSelected", 1);
		CommonMethod.assertisElementPresentTrue("HSRScorecardPurseMaybeToNoSelected", "PurseNo is not selected");
		testlog.info("And User verifies the Selected Purse No");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"),
				"Pursue status changed!", "Purse Status message Doesn't match");
		testlog.info("Then User verifies the Pursue status message");
		testlog.pass("**Verifies the Pursue No status successful**");
	}
	
	public void purseYesToMaybeValidFromScorecard() throws IOException, InterruptedException {
		
	    testlog.info("Given User on Scorecard page");
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardPurseYesSelectForFeaturePHR", 0);
	    CommonMethod.JavascriptClickElement("HSRScorecardPurseYesSelectForFeaturePHR");
	    testlog.info("And User click on Purse Yes");
	    CommonMethod.WaitUntilNumberOfElementToBePresentWithException("HSRScorecardPurseYesSelectedForFeaturePHR", 1);
	    CommonMethod.assertisElementPresentTrue("HSRScorecardPurseYesSelectedForFeaturePHR", "PurseYes is not selected");
	    testlog.info("And User verifies the Selected Purse Yes");
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
	    String pursueToastText = CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast");
	    CommonMethod.negativesoftassertFieldValid(pursueToastText,
			"Pursue status changed!", "Purse Status message Doesn't match");
	    testlog.info("Then User verifies the Pursue status message");
	    testlog.pass("**Verifies the Pursue Yes status successful**");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardPurseYesToMaybeSelect", 0);
		CommonMethod.JavascriptClickElement("HSRScorecardPurseYesToMaybeSelect");
		testlog.info("And User click on Purse Maybe");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoConfirm");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("HSRScorecardPurseYesToMaybeSelected", 1);
		CommonMethod.assertisElementPresentTrue("HSRScorecardPurseYesToMaybeSelected", "PurseMaybe is not selected");
		testlog.info("And User verifies the Selected Purse Maybe");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"),
				"Pursue status changed!", "Purse Status message Doesn't match");
		testlog.info("Then User verifies the Pursue status message");
		testlog.pass("**Verifies the Pursue Maybe status successful**");
	}

public void uploadDocumentInFeatureNonEnhance(String  FeatureName) throws IOException, InterruptedException {
	List<WebElement> Feature;
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
	Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrScorecardAplicableVersion", 0);
	CommonMethod.scrolldowntoElement("HsrScorecardAplicableVersion");
	testlog.info("Fetching total no. of credits on page");
	boolean flag = false;
	for (WebElement ele : Feature) {
		String Creditname = ele.getText();
		Creditname = Creditname.replaceAll("\\.", "");
		if (Creditname.equalsIgnoreCase(FeatureName)) {
			flag = true;
		CommonMethod.JavascriptClickElement(ele);
		if (TestCaseName.equalsIgnoreCase("Healthsafety_TC_20_10_HsrOngoingDataReport")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectHsrOptnRenewalScorecardDocumentSA4WarningIcon",1);
			CommonMethod.assertisElementPresentTrue("V2ProjectHsrOptnRenewalScorecardDocumentSA4WarningIcon", "Renewal OngoingDataReport Warning Paper icon element present");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrRenewalScorecardPOngoingWarningMessage", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("HsrRenewalScorecardPOngoingWarningMessage"), "Updated ongoing data report is required for renewal",
				"Renewal Scorecard Current document doesn't match");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPDocIcon", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectWPRPDocIcon", "HsrSelectTypeDoc");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrSelectTypeDoc", 0);
		CommonMethod.selectdropdownIndex("HsrSelectTypeDoc", 1);
		if (CommonMethod.isElementsExist("HsrLocationrtn", 3)) {
			CommonMethod.WaitUntilClickble("HsrLocationrtn", 10);
			CommonMethod.ClickCheckbox("HsrLocationrtn");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRVerificationMethod", 0);
		CommonMethod.selectdropdownIndex("V2ProjectWPRVerificationMethod", 1);
		CommonMethod.scrolldowntoElement("V2ProjectWPRVerificationMethod");
		if (CommonMethod.isElementsExist("HsrSelectLoc", 3)) {
			CommonMethod.WaitUntilClickble("HsrSelectLoc", 10);
			CommonMethod.selectdropdownIndex("HsrSelectLoc", 1);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDocUpload", 0);
		CommonMethod.uploadFile("V2ProjectDocUpload", FeaturefileUpload,"UploadFileVerifyScorecard");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrUploadDocFeature", 0);
		CommonMethod.Robustclick("HsrUploadDocFeature");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecrdEhanceDeleteIcon", 0);
		CommonMethod.scrolldowntoElement("HsrScorecardAplicableVersion");
		CommonMethod.JavascriptClickElement(ele);
		break;
		}
	}
	CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +FeatureName +" doesn't match");
	testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
}

public void warningHsrOngoingDataReport() throws IOException, InterruptedException {
	CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioAccLocScoreCardSelectUploadButton",1);
	CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("V2ProjectHsrOptnRenewalScorecardDocumentSA4WarningIcon");
	CommonMethod.assertisElementPresentFalse("V2ProjectHsrOptnRenewalScorecardDocumentSA4WarningIcon", "Renewal OngoingDataReport Warning Paper icon element present");
}

public void warningMessageHsrMarkNo() throws IOException, InterruptedException {
	CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioAccLocScoreCardSelectUploadButton",1);
	CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("HsrRenewalScorecardDocumentSC4WarningIcon");
	CommonMethod.assertisElementPresentFalse("HsrRenewalScorecardDocumentSC4WarningIcon", "Renewal Warning No Paper icon element present");
	
}

public void purseYes() throws IOException, InterruptedException {
CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrRenewalScorecardPurseYes", 0);
CommonMethod.Robustclick("HsrRenewalScorecardPurseYes");
}

public void ScorecardSaveAndExitFlow(String featureName, String SheetName, int rowNum, String Commodity)
		throws Exception {
	testlog.info("Given User is on Scorecard page");
	List<WebElement> Feature;
	Feature = CommonMethod.findElements("HSRScorecardFeature");
	boolean flag = false;
	testlog.info("Fetching total no. of credits on page");
	for (WebElement ele : Feature) {
		String Creditname = ele.getText();
		Creditname = Creditname.replaceAll("\\.", "");
		if (Creditname.equalsIgnoreCase(featureName)) {
			flag = true;
			CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
			CommonMethod.JavascriptClickElement(ele);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRVerficationTab", 0);
			CommonMethod.RobustclickElementVisible("WPRVerficationTab", "PortfolioScoreCardAddOptionbutton");
			testlog.info("And User clicks on VerificationTab");
			CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +featureName +" doesn't match");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
					"PortfolioScoreCardAddButton");
			testlog.info("And User clicks on AddOption button");
			CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardAddButton", 0);
			testlog.info("And User clicks on Add button");
			CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AddOptionValid");
			CommonMethod.assertisNotElementPresent("AddOptionValid", "Added option button is visible");
			testlog.info("User verifies Remove button");
			CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
			CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
			testlog.info("And User clicks on Closeicon");
			generic.assignLocationGeneric(Commodity, false, false, true, false, false);
			/** Upload Document for Tasks */
			CommonMethod.scrollDown();
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn",
					0);
			CommonMethod.JavascriptClickElement("PortfolioScoreCardVerificationUploadbtn");
			generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, SampleJpgfile, false, false, false, false);
			ValidateScorecardUploadButtonCountAndTable(SheetName, rowNum, Commodity);
			CommonMethod.JavascriptClickElement(ele);
		}
	   }
	 }
	
	public void ValidateScorecardUploadButtonCountAndTable(String SheetName, int rowNum, String Commodity) throws Exception {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCloseUploadDocumentModal", 0);
		CommonMethod.Robustclick("PortfolioCloseUploadDocumentModal");
		CommonMethod.assertisElementPresentTrue("HSRScorecardUploadedDocLocationCount", "5/5 Locations count does not matched");
		CommonMethod.scrolldowntoElement("PortfolioScorecardFeatureTableCount");	
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureTableCount", 0);
		String expectedFeatureTableCount = CommonMethod.getattributeValueByTextContent("PortfolioScorecardFeatureTableCount");
		CommonMethod.negativesoftassertFieldValid(expectedFeatureTableCount, "1", "Table count 1 does not matched");
		testlog.info("Validate Scorecard Upload Button Count And Table Cases has been Successfully Passed");
	}
	
	public void ValidateScorecardConfirmationModalFromPurseYesToNoAfterAddingOptions(String featureName, String SheetName, int rowNum, String Commodity) throws Exception {
		
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("HSRScorecardFeature");
		boolean flag = false;
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRVerficationTab", 0);
				CommonMethod.RobustclickElementVisible("WPRVerficationTab", "PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +featureName +" doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRSelectScorecardPurseYesToNoAfterAddedOptions", 0);
		CommonMethod.ScrollUpToElement("HSRSelectScorecardPurseYesToNoAfterAddedOptions");
		CommonMethod.JavascriptClickElement("HSRSelectScorecardPurseYesToNoAfterAddedOptions");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoCancel", 0);
		testlog.info("And User verifies confirm button");
		testlog.info("And User verifies cancel button");
		// cancel
		CommonMethod.JavascriptClickElement("PortfolioScorecardPurseYesToNoCancel");
		// Confirm
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRSelectScorecardPurseYesToNoAfterAddedOptions", 0);
		CommonMethod.JavascriptClickElement("HSRSelectScorecardPurseYesToNoAfterAddedOptions");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardPurseYesToNoConfirm");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"),
				"Pursue status changed!", "Purse Status message Doesn't match");
		testlog.info("And User verifies the Pursue status message");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioScoreCardAddOptionbutton", "Add options button is not visible");
		CommonMethod.JavascriptClickElement(ele);
			}
		}
	}
	
	public void ValidateTaskCompletionOnAddingOptionFromDocEdit(String SheetName, int rowNum, String ProjectTypeVerification, String ProjectType,
			String Commodity, String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired, String featureName) throws Exception {
		
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("HSRScorecardFeature");
		boolean flag = false;
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRVerficationTab", 0);
				CommonMethod.click("WPRVerficationTab");	
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +featureName +" doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
		CommonMethod.click("PortfolioScoreCardAddOptionbutton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddButtonOne", 0);
		CommonMethod.click("PortfolioScoreCardAddButtonOne");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
		AssignLocations();
		CommonMethod.scrollDown();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHsrOptnUploadButtonOptionOne", 0);
		CommonMethod.JavascriptClickElement("PortfolioHsrOptnUploadButtonOptionOne");
		generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
				VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndExitbtn", 0);
		CommonMethod.Robustclick("SaveAndExitbtn");  
		CommonMethod.scrolldowntoElement("PortfolioHsrOptnUploadButtonOptionOne");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
		CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableEditIcon", 0);
		CommonMethod.JavascriptClickElement("PortfolioAndRatingLocAccDocumentTableEditIcon");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadAddfeature", 0);
		CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
				"PortfolioScoreCardVerificationSelectFeature");
		testlog.info("And User clicks on Add feature"); 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardPartDropdown", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioScoreCardPartDropdown", "SA4");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardSelectSpaceTypeFromDropdown", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioScoreCardSelectSpaceTypeFromDropdown", "All Spaces");		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardSelectOptionFromDropdown", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioScoreCardSelectOptionFromDropdown", "Option 2 Assess Chemical and Biological Water Quality");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPart", 0);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
				"PortfolioScoreCardVerificationUploadAddfeature");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndExitbtnUploadPage", 0);
		CommonMethod.Robustclick("SaveAndExitbtnUploadPage"); 
		CommonMethod.scrolldowntoElement("PortfolioHsrOptnUploadButtonOptionOne");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTablePartIdOne", 0);
		String actualTablePartIdOne = CommonMethod.getattributeValueByTextContent("PortfolioTablePartIdOne").trim();
		CommonMethod.negativesoftassertFieldValid(actualTablePartIdOne, "SA4", "SA4 text does't matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTableOptionsOne", 0);
		String actualTableOptionsOne = CommonMethod.getattributeValueByTextContent("PortfolioTableOptionsOne").trim();
		CommonMethod.negativesoftassertFieldValid(actualTableOptionsOne, "Option 1", "Option 1 text does't matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTablePartIdTwo", 0);
		String actualTablePartIdTwo = CommonMethod.getattributeValueByTextContent("PortfolioTablePartIdTwo").trim();
		CommonMethod.negativesoftassertFieldValid(actualTablePartIdTwo, "SA4", "SA4 text does't matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTableOptionsTwo", 0);
		String actualTableOptionsTwo = CommonMethod.getattributeValueByTextContent("PortfolioTableOptionsTwo").trim();
		CommonMethod.negativesoftassertFieldValid(actualTableOptionsTwo, "Option 2", "Option 2 text does't matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardUploadedDocLocationCountOptionsOne", 0);
		String actualUploadedDocLocationCount = CommonMethod.getattributeValueByTextContent("HSRScorecardUploadedDocLocationCountOptionsOne").trim();
		CommonMethod.negativesoftassertFieldValidEquals(actualUploadedDocLocationCount, "2/2 Locations", "2/2 Locations count does't matched");	
		CommonMethod.JavascriptClickElement(ele);
			}
		}
	}
	
	public void AssignLocations() throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 120);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Assignbutton", 0);
		Thread.sleep(1000);
		CommonMethod.JavascriptClickElement("Assignbutton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocationTableTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationOne", 0);
		CommonMethod.ClickCheckbox("PortfolioCheckedLocationOne");	
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationTwo", 0);
		CommonMethod.ClickCheckbox("PortfolioCheckedLocationTwo");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveChangesButton", 0);
		CommonMethod.JavascriptClickElement("SaveChangesButton");  
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
		CommonMethod.Robustclick("AssignLocCloseIcon");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
	}
	
	public void MarkAndValidateHsrNaStatus(String SheetName, int rowNum) throws IOException, InterruptedException {
	
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "EditNAStatus");
		testlog.info("And User clicks on AdminFields Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditNAStatus", 0);
		CommonMethod.RobustclickElementVisible("EditNAStatus", "V2ProjectSaveChangesButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSaveChangesButton", 0);
		CommonMethod.Robustclick("V2ProjectSaveChangesButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ValidateNAConfirmationMsg", 0);
		String actualConfirmationMsg = CommonMethod.getattributeValueByTextContent("ValidateNAConfirmationMsg");
		CommonMethod.negativesoftassertFieldValid(actualConfirmationMsg, "Rating updated successfully!", "Confirmation message does not matched ");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("ValidateNAConfirmationMsg", 1);
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("SealImgValidate");
		CommonMethod.assertisElementPresentFalse("SealImgValidate", "Seal image is present");
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("SealDateValidate");
		CommonMethod.assertisElementPresentFalse("SealDateValidate", "Seal date is present");
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "SelectedNAStatus");
		testlog.info("And User clicks on AdminFields Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("SelectedNAStatus", 1);
		CommonMethod.assertisElementPresentTrue("SelectedNAStatus", "WELL Health-Safety Rating: Status: NA is not selected ");
	}
}