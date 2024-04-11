package com.Well.ReusableMethods;

import java.io.IOException;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsCommunity extends BaseClass {

	public void RegisterCommunity(String SheetName, int rowNum, String Country)
			throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified account");
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WellCommunityNavBar");
		CommonMethod.RobustclickElementVisible("WellCommunityNavBar", "CommunityStartCommunityProject");
		testlog.info("When User clicks on WELL Community from top menu under Projects");
		CommonMethod.WaitUntilVisibility("CommunityStartCommunityProject", 300);
		CommonMethod.RobustclickElementVisible("CommunityStartCommunityProject", "CommunityCreateButton");
		testlog.info("When User clicks on StartCommunity button");
		CommonMethod.RobustclickElementVisible("CommunityCreateButton", "CommunityProjectName");
		CommonMethod.negativesoftassertPageSource("Project Name is required.", "Project Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Target Certification level is required.",
				"Target Certification level Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Gross area is required.", "Gross area Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Gross Area is required.", "Gross Area Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Project status is required.", "Project Status Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Estimated date of document submission * is required.",
				"Estimated date of document submission Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner name is required.", "Owner Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner email is required.", "Owner Email Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner phone is required.", "Owner Phone Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Industry is required.",
				"Organization Industry Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Consultant is required.", "Consultant Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Applicant's role on the project * is required.",
				"Applicant's role on the project Error Mismatch");
		testlog.info(
				"And User clicks on create button without entering the mandatory fields and verifies error meassage");
		CommonMethod.scrollUp();
		String ProjectName = "Automation Community" + CommonMethod.randomNumber(8000000);
		testlog.info("Community is: " + ProjectName);
		data.setCellData(SheetName, "ProjectName", rowNum, ProjectName);
		CommonMethod.sendKeys("CommunityProjectName", ProjectName);
		testlog.info(
				"And User enter data to ProjectName, Area, Country, State, Street address, City and Postal Code, Phone number fields");
		CommonMethod.selectdropdownValue("CommunityTargetCertificationLevel", "Silver");
		String Area = CommonMethod.randomNumberBetweenRanges(100, 85000);
		CommonMethod.clearAndSendKey("CommunityGrossArea", Area);
		data.setCellData(SheetName, "Area", rowNum, CommonMethod.getattributeValue("CommunityGrossArea"));
		testlog.info("Area: " + data.getCellData(SheetName, "Area", rowNum));
		rc.SelectCountryAndState(Country, SheetName, rowNum);
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		testlog.info("Street: " + ProjectAddress);
		testlog.info("City: " + ProjectCity);
		testlog.info("Postalcode: " + PostalCode);
		CommonMethod.sendKeys("V2ProjectlocationStreet", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("V2ProjectlocationStreet"));
		CommonMethod.sendKeys("V2ProjectlocationCity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("V2ProjectlocationCity"));
		CommonMethod.sendKeys("V2ProjectlocationPostalcode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum,
				CommonMethod.getattributeValue("V2ProjectlocationPostalcode"));
		CommonMethod.selectdropdownValue("CommunityCurrentStatusProject", "concept_design");
		testlog.info("And User select Current status");
		CommonMethod.RobustclickElementVisible("V2ProjectdocsubEstidate", "V2ProjectdocsubEstidateOkbtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectdocsubEstidateOkbtn", 0);
		CommonMethod.Robustclick("V2ProjectdocsubEstidateOkbtn");
		testlog.info("And User select the Esitmate Date");
		CommonMethod.RobustclickElementVisible("V2ProjectdocsubAnticdate", "V2ProjectdocsubEstidateOkbtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectdocsubEstidateOkbtn", 0);
		CommonMethod.Robustclick("V2ProjectdocsubEstidateOkbtn");
		testlog.info("And User select the Anticipate Date");
		rc.SelectOwnerOrg(SheetName, rowNum);
		data.setCellData(SheetName, "OrgName", rowNum, CommonMethod.getText("OrgName"));
		testlog.info("OrganizationName: " + data.getCellData(SheetName, "OrgName", rowNum));
		String Name = USfaker.address().firstName();
		String OwnerPhone = USfaker.number().digits(10);
		CommonMethod.sendKeys("CommunityOwnerName", Name);
		System.out.println("Email: " + data.getCellData("Login", "UserName", 3));
		CommonMethod.sendKeys("CommunityOwnerEmail", data.getCellData("Login", "UserName", 3));
		CommonMethod.sendKeys("CommunityOwnerphone", OwnerPhone);
		testlog.info("And User enter data to Owner Country, State, Street address, City and Postal Code fields");
		CommonMethod.selectdropdownVisibletext("V2Projectindustry", "Architecture");
		testlog.info("And User select the industry");
		rc.SelectEnterpriseProviders(SheetName, rowNum);
		CommonMethod.selectdropdownValue("CommunityRegisterOwnerAddCountry", Country);
		data.setCellData(SheetName, "Country", rowNum,
				CommonMethod.getSelectedDropdownValue("CommunityRegisterOwnerAddCountry"));
		CommonMethod.selectdropdownrandom("CommunityRegisterOwnerAddState");
		data.setCellData(SheetName, "State", rowNum,
				CommonMethod.getSelectedDropdownValue("CommunityRegisterOwnerAddState"));
		testlog.info("Country: " + data.getCellData(SheetName, "Country", rowNum));
		testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
		String OwnerAddress = USfaker.address().streetAddress();
		String OwnerCity = USfaker.address().cityName();
		String OwnerPostalCode = USfaker.address().zipCode();
		testlog.info("Street: " + OwnerAddress);
		testlog.info("City: " + OwnerCity);
		testlog.info("Postalcode: " + OwnerPostalCode);
		CommonMethod.sendKeys("CommunityRegisterOwnerAddStreet", OwnerAddress);
		data.setCellData(SheetName, "Street", rowNum,
				CommonMethod.getattributeValue("CommunityRegisterOwnerAddStreet"));
		CommonMethod.sendKeys("CommunityRegisterOwnerAddCity", OwnerCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("CommunityRegisterOwnerAddCity"));
		CommonMethod.sendKeys("CommunityRegisterOwnerAddPostalCode", OwnerPostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum,
				CommonMethod.getattributeValue("CommunityRegisterOwnerAddPostalCode"));
		CommonMethod.selectdropdownValue("CommunityApplicatioRole", "acoustician");
		testlog.info("And User select the Role");
		CommonMethod.RobustclickElementVisible("CommunityregisterCreateButton", "DatePickerButton");
		testlog.info("And User clicks on Create button");
		if (CommonMethod.isElementsExist("ScorecardBannerClose", 30)) {
			CommonMethod.Robustclick("ScorecardBannerClose");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DatePickerButton", 0);
		CommonMethod.RobustclickElementVisible("DatePickerButton", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectnextYearbtn", 0);
		CommonMethod.Robustclick("V2ProjectnextYearbtn", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DatePickerNextYear", 0);
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("DatePickerNextYear", "DatePickerOkButton");
		Thread.sleep(1000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DatePickerOkButton", 0);
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "V2ProjectDatePopupWeekday");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "DatePickerUpdateButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DatePickerUpdateButton", 0);
		CommonMethod.RobustclickElementVisible("DatePickerUpdateButton", "DatePickerContinueJourneyButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DatePickerContinueJourneyButton", 0);
		CommonMethod.RobustclickElementVisible("DatePickerContinueJourneyButton",
				"CommunityRegisterValidateProjectName");
		CommonMethod.refreshBrowser();
		if (CommonMethod.isElementsExist("ScorecardBannerClose", 60)) {
			CommonMethod.Robustclick("ScorecardBannerClose");
		}
		testlog.info("And User select the Date");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityRegisterValidateProjectName", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityRegisterValidateProjectName"),
				data.getCellData(SheetName, "ProjectName", rowNum),
				"Project Name doesn't matched with exceles in search");
		testlog.info("Then User will be redirected to Dashboard page");
		CommonMethod.WaitUntilVisibility("StoreId", 60);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getProjectId = stringArray[1].trim();
		data.setCellData(SheetName, "ProjectID", rowNum, getProjectId);
		testlog.info("And User store Community Id in excel");
		testlog.pass("**Stored the Registered id  in excel successfully**");
		testlog.pass("**Verifies the Registration successful**");

	}

	public void SearchCommunityListById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WellCommunityNavBar");
		CommonMethod.RobustclickElementVisible("WellCommunityNavBar", "CommunityStartCommunityProject");
		testlog.info("When User clicks on WELL Community from top menu under Projects");
		CommonMethod.WaitUntilClickble("V2ProjectId", 60);
		testlog.info("ProjectId:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("V2ProjectId", data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enter data to ProjectId");
		CommonMethod.RobustclickElementVisible("CommunityApplyButton", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks Apply button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectSearchResultIDVerify", 1);
		int var = CommonMethod.ElementSize("V2ProjectSearchResultIDVerify");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "1", "V2 Search failed");
		CommonMethod.RobustclickElementVisible("V2ProjectIdCompare", "CommunityRegisterValidateProjectName");
		testlog.info("Then User verifies ProjectId in search filter");
	}

	public void editAndValidateProjectInformation(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "CommunityProjectInformationButton");
		testlog.info("When User clicks on EditTab");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityProjectInformationButton", 0);
		CommonMethod.RobustclickElementVisible("CommunityProjectInformationButton", "V2ProjectProjectScope");
		testlog.info("And User clicks on ProjectInformation Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityProjectNameInput", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectProjectScope", 0);
		CommonMethod.sendKeys("V2ProjectProjectScope", data.getCellData(SheetName, "ProjectScope", rowNum));
		CommonMethod.WaitUntilVisibility("V2ProjectProjectGoals", 60);
		CommonMethod.sendKeys("V2ProjectProjectGoals", data.getCellData(SheetName, "ProjectGoals", rowNum));
		testlog.info("And User enter data to ProjectNameInput,ProjectScope and ProjectGoals");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectEditpublicprojectyes", 0);
		CommonMethod.scrolldowntoElement("V2ProjectEditpublicprojectyes");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectEnterpriseProviders", 0);
		CommonMethod.WaitUntilNumberOfElementToBeSelectedWithException("V2ProjectEnterpriseProviders");
		CommonMethod.selectdropdownVisibletext("V2ProjectEnterpriseProviders",
				data.getCellData(SheetName, "EnterpriseProvidersName", rowNum));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSaveChangesButton", 0);
		CommonMethod.Robustclick("V2ProjectSaveChangesButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("V2ProjectSaveChangesButton", 1);
		testlog.info("And User clicks on Save button");
		if (CommonMethod.isElementsExist("VerifyFieldsUpdateToaster", 15)) {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("VerifyFieldsUpdateToaster", 0);
		CommonMethod.WaitUntilInVisibility("VerifyFieldsUpdateToaster", 60);
		}
		testlog.info("**Project Information data updated successfully**");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityNextStep", 0);
		testlog.info("Then User will be redirected to Dashboard page");
		/*
		 * Validate updated project information fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectInformationButton");
		testlog.info("And User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectProjectInformationButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
		testlog.info("And User clicks on ProjectInformation Button");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectProjectScope"),
				data.getCellData(SheetName, "ProjectScope", rowNum), "Project scope data doesn't match");
		CommonMethod.WaitUntilVisibility("V2ProjectProjectGoals", 60);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectProjectGoals"),
				data.getCellData(SheetName, "ProjectGoals", rowNum), "Project goals data doesn't match");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("V2ProjectEnterpriseProviders"),
				data.getCellData(SheetName, "EnterpriseProvidersName", rowNum), "EnterpriseProvidersName Mismatch");
		testlog.info("Then User verifies the added details");
		testlog.info("**Project scope data updated successfully**");
		testlog.pass("**Project goals data updated successfully**");
	}

	public void editAndValidateOwnerInformation(String SheetName, int rowNum, String Country) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectOwnerInformationButton");
		testlog.info("And User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectOwnerInformationButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectOwnerInformationButton", "V2ProjectOrganizationIndustry");
		testlog.info("And User clicks on OwnerInformation Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectOrganizationIndustry", 0);
		Thread.sleep(3000);
		CommonMethod.selectdropdownrandom("V2ProjectOrganizationIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum,
				CommonMethod.getattributeValue("V2ProjectOrganizationIndustry"));
		testlog.info("And User select the OrgIndustry");
		CommonMethod.WaitUntilVisibility("V2ProjectCountry", 60);
		CommonMethod.selectdropdownValue("V2ProjectCountry", Country);
		CommonMethod.WaitUntilVisibility("V2ProjectState", 60);
		CommonMethod.selectdropdownVisibletext("V2ProjectState", data.getCellData(SheetName, "State", rowNum));
		testlog.info("And User select the Country and State");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSaveChangesButton", 0);
		CommonMethod.Robustclick("V2ProjectSaveChangesButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("V2ProjectSaveChangesButton", 1);
		testlog.info("And User clicks on Save button");
		if (CommonMethod.isElementsExist("VerifyFieldsUpdateToaster", 15)) {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("VerifyFieldsUpdateToaster", 0);
		CommonMethod.WaitUntilInVisibility("VerifyFieldsUpdateToaster", 60);
		}
		testlog.info("Then User will be redirected to Dashboard page");
		testlog.pass("**Owner Information data updated successfully**");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityNextStep", 0);
		/*
		 * Validate updated owner information fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectOwnerInformationButton");
		testlog.info("And User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectOwnerInformationButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectOwnerInformationButton", "V2ProjectOrganizationIndustry");
		testlog.info("And User clicks on OwnerInformation Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectCountry", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("V2ProjectCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Country name doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectState", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("V2ProjectState"),
				data.getCellData(SheetName, "State", rowNum), "State name doesn't match");
		testlog.info("Then User verifies the added details");
		testlog.pass("**Verifies Information data updated successfully**");
	}

	public void editAndValidateAdmin(String SheetName, int rowNum) throws Exception {
		AdminSearchById(SheetName, rowNum);
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "V2projectAdminBillingChallengeNote");
		testlog.info("And User clicks on AdminFields Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectAdminBillingChallengeNote", 0);
		CommonMethod.sendKeys("V2projectAdminBillingChallengeNote",
				data.getCellData(SheetName, "ChallengeNote", rowNum));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectAdminBillingCommunicationNote", 0);
		CommonMethod.sendKeys("V2projectAdminBillingCommunicationNote",
				data.getCellData(SheetName, "CommunicationNote", rowNum));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectAdminBillingNote", 0);
		CommonMethod.sendKeys("V2projectAdminBillingNote", data.getCellData(SheetName, "BillingNote", rowNum));
		testlog.info("And User enter data to ChallengeNote and BillingNote");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSaveChangesButton", 0);
		CommonMethod.Robustclick("V2ProjectSaveChangesButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("V2ProjectSaveChangesButton", 1);
		testlog.info("And User clicks on Save button");
		if (CommonMethod.isElementsExist("VerifyFieldsUpdateToaster", 15)) {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("VerifyFieldsUpdateToaster", 0);
		CommonMethod.WaitUntilInVisibility("VerifyFieldsUpdateToaster", 60);
		}
		testlog.pass("**Admin data updated successfully**");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityNextStep", 0);
		testlog.info("Then User will be redirected to Dashboard page");
		/*
		 * Validate updated admin fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("And User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "V2projectAdminBillingChallengeNote");
		testlog.info("And User clicks on AdminFields Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectAdminBillingChallengeNote", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2projectAdminBillingChallengeNote"),
				data.getCellData(SheetName, "ChallengeNote", rowNum), "Challenge note value doesn't match");
		testlog.info("**Challenge note updated successfully**");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectAdminBillingCommunicationNote", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValue("V2projectAdminBillingCommunicationNote"),
				data.getCellData(SheetName, "CommunicationNote", rowNum), "Communication note value doesn't match");
		testlog.info("**Communication updated successfully**");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectAdminBillingNote", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2projectAdminBillingNote"),
				data.getCellData(SheetName, "BillingNote", rowNum), "Billing note value doesn't match");
		testlog.info("Then User verifies the added details");
		testlog.pass("**Verifies Admin data updated successfully**");
	}

	public void AdminSearchById(String SheetName, int rowNum) throws IOException, InterruptedException {
		/** Admin Review */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("AdminWELLCertificationNavBar", "AdminV2ProjectId");
		testlog.info("And User clicks on Admin WELL Certification from top menu under Projects");
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enter on ProjectID in  AdminV2ProjectId field");
		CommonMethod.RobustclickElementVisible("AdminV2ProjectApplybtn", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("V2ProjectSearchResultIDVerify"),
				data.getCellData(SheetName, "ProjectID", rowNum), "ProjectID doesn't matches in search");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectIdCompare", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectIdCompare", "CommunityNextStep");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityNextStep", 0);
	}

	public void CommunityAlternativeChangeStatusAndValidate(String SheetName, int rowNum, String Module)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "V2ProjectAdminAlternativeNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminAlternativeNavBar", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminAlternativeNavBar",
				"V2ProjectAdminAlternativeStrategyTextBox");
		if (Module.equalsIgnoreCase("EP")) {
			String getCommunityAlternativeEPID = data.getCellData(SheetName, "CommunityAlternativeEPID", rowNum);
			CommonMethod.sendKeys("V2ProjectAdminAlternativeStrategyTextBox", getCommunityAlternativeEPID);
		} else {
			String getCommunityAlternativeID = data.getCellData(SheetName, "CommunityAlternativeID", rowNum);
			CommonMethod.sendKeys("V2ProjectAdminAlternativeStrategyTextBox", getCommunityAlternativeID);
		}
		CommonMethod.click("ApplyButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeIDLink", 0);
		CommonMethod.RobustclickElementVisible("CommunityAlternativeIDLink", "V2ProjectAdminAlternativeEditButton");
		validateCommunityAlternativeStatus(SheetName, rowNum, "Not Approved","WELL V1");
		validateCommunityAlternativeStatus(SheetName, rowNum, "Approved","WELL V1");
		validateCommunityAlternativeStatus(SheetName, rowNum, "Additional Information Requested","WELL V1");
	}

	public void validateCommunityAlternativeStatus(String SheetName, int rowNum, String status, String ModuleName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminAlternativeEditButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminAlternativeEditButton",
				"V2ProjectAdminAlternativeSubmit");
		if (status.equalsIgnoreCase("Not Approved")) {
			CommonMethod.scrolldowntoElement("V2ProjectAdminAlternativeNotApproved");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminAlternativeNotApproved", 0);
			CommonMethod.ClickCheckbox("V2ProjectAdminAlternativeNotApproved");
			CommonMethod.clearAndSendKey("V2ProjectYourWellGoals", data.getCellData(SheetName, "IWBIResponse", rowNum));
			CommonMethod.RobustclickElementVisible("CommunityAlternativeIWBIResponseDate",
					"CommunityAlternativeSelectDate");
			Thread.sleep(2000);
			CommonMethod.click("CommunityAlternativeSelectDate");
			CommonMethod.click("CommunityAlternativeDateOkBtn");
			CommonMethod.RobustclickElementVisible("CommunityAlternativeAAPDecisionDate",
					"CommunityAlternativeSelectDate");
			CommonMethod.click("CommunityAlternativeSelectDate");
			CommonMethod.click("CommunityAlternativeDateOkBtn");
			CommonMethod.clearAndSendKey("V2ProjectYourWellProject", data.getCellData(SheetName, "AdminNotes", rowNum));
			CommonMethod.clearAndSendKey("V2ProjectYourWellFeatures", data.getCellData(SheetName, "IWBINotes", rowNum));
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ValidEditAlternative", 0);
			CommonMethod.scrolldowntoElement("ValidEditAlternative");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminAlternativeSubmit", 0);
			CommonMethod.Robustclick("V2ProjectAdminAlternativeSubmit");
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("ValidEditAlternative", 1);
			CommonMethod.ScrollUpToElement("V2ProjectAdminAlternativeEditButton");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeAdminStatus", 0);
			Thread.sleep(2000);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeValidateWV1"),
					ModuleName, ModuleName +" WELL doesn't match");
			String V2ProjectAdminAlternativeStatus = CommonMethod.getText("CommunityAlternativeAdminStatus");
			CommonMethod.negativesoftassertFieldValid(status, V2ProjectAdminAlternativeStatus, "Status doesn't match");
		}
		if (status.equalsIgnoreCase("Additional Information Requested")) {
			CommonMethod.scrolldowntoElement("V2ProjectAdminAlternativeAdditionalInfo");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminAlternativeAdditionalInfo", 0);
			CommonMethod.ClickCheckbox("V2ProjectAdminAlternativeAdditionalInfo");
			CommonMethod.ScrollUpToElement("V2ProjectAdminAlternativeAdditionalInfo");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminAlternativeMidReview", 0);
			CommonMethod.clearAndSendKey("V2ProjectAdminAlternativeMidReview",data.getCellData(SheetName, "MidReview", rowNum));
			CommonMethod.uploadFile("DocumentsUploadMidReview", SampleJpgfile);
			CommonMethod.clearAndSendKey("V2ProjectYourWellGoals", data.getCellData(SheetName, "IWBIResponse", rowNum));
			CommonMethod.RobustclickElementVisible("CommunityAlternativeIWBIResponseDate",
					"CommunityAlternativeSelectDate");
			Thread.sleep(2000);
			CommonMethod.click("CommunityAlternativeSelectDate");
			CommonMethod.click("CommunityAlternativeDateOkBtn");
			CommonMethod.RobustclickElementVisible("CommunityAlternativeAAPDecisionDate",
					"CommunityAlternativeSelectDate");
			CommonMethod.click("CommunityAlternativeSelectDate");
			CommonMethod.click("CommunityAlternativeDateOkBtn");
			CommonMethod.clearAndSendKey("V2ProjectYourWellProject", data.getCellData(SheetName, "AdminNotes", rowNum));
			CommonMethod.clearAndSendKey("V2ProjectYourWellFeatures", data.getCellData(SheetName, "IWBINotes", rowNum));
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ValidEditAlternative", 0);
			CommonMethod.scrolldowntoElement("ValidEditAlternative");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminAlternativeSubmit", 0);
			CommonMethod.Robustclick("V2ProjectAdminAlternativeSubmit");
			CommonMethod.ScrollUpToElement("V2ProjectAdminAlternativeEditButton");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeAdminStatus", 0);
			Thread.sleep(2000);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeValidateWV1"),
					ModuleName, ModuleName +" WELL doesn't match");
			String V2ProjectAdminAlternativeStatus = CommonMethod.getText("CommunityAlternativeAdminStatus");
			CommonMethod.negativesoftassertFieldValid(status, V2ProjectAdminAlternativeStatus, "Status doesn't match");
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectAdminAlternativeComment", 1);
			CommonMethod.assertisElementPresentTrue("V2ProjectAdminAlternativeComment", "Comment Text Box is not visible");
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("DocumentsUploadMidReview", 1);
			CommonMethod.assertisElementPresentTrue("DocumentsUploadMidReview", "Upload Mid Review Section is not visible");
			CommonMethod.ScrollUpToElement("V2ProjectAdminAlternativeEditButton");
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectAdminAlternativeReSubmitReviewBtn", 1);
			CommonMethod.assertisElementPresentTrue("V2ProjectAdminAlternativeReSubmitReviewBtn", "Re-Submit button is not visible");
		}
		if (status.equalsIgnoreCase("Approved")) {
			CommonMethod.scrolldowntoElement("V2ProjectAdminAlternativeApproved");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminAlternativeApproved", 0);
			CommonMethod.ClickCheckbox("V2ProjectAdminAlternativeApproved");
			CommonMethod.clearAndSendKey("V2ProjectYourWellGoals", data.getCellData(SheetName, "IWBIResponse", rowNum));
			CommonMethod.RobustclickElementVisible("CommunityAlternativeIWBIResponseDate",
					"CommunityAlternativeSelectDate");
			Thread.sleep(2000);
			CommonMethod.click("CommunityAlternativeSelectDate");
			CommonMethod.click("CommunityAlternativeDateOkBtn");
			CommonMethod.RobustclickElementVisible("CommunityAlternativeAAPDecisionDate",
					"CommunityAlternativeSelectDate");
			CommonMethod.click("CommunityAlternativeSelectDate");
			CommonMethod.click("CommunityAlternativeDateOkBtn");
			CommonMethod.clearAndSendKey("V2ProjectYourWellProject", data.getCellData(SheetName, "AdminNotes", rowNum));
			CommonMethod.clearAndSendKey("V2ProjectYourWellFeatures", data.getCellData(SheetName, "IWBINotes", rowNum));
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ValidEditAlternative", 0);
			CommonMethod.scrolldowntoElement("ValidEditAlternative");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminAlternativeSubmit", 0);
			CommonMethod.Robustclick("V2ProjectAdminAlternativeSubmit");
			CommonMethod.ScrollUpToElement("CommunityAlternativeAdminStatus");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeAdminStatus", 0);
			Thread.sleep(2000);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeValidateWV1"),
					ModuleName, ModuleName +" WELL doesn't match");
			String V2ProjectAdminAlternativeStatus = CommonMethod.getText("CommunityAlternativeAdminStatus");
			CommonMethod.negativesoftassertFieldValid(status, V2ProjectAdminAlternativeStatus, "Status doesn't match");
		}
	}

	public void AAPProjectAdminChangeStatusAndValidate(String SheetName, int rowNum, String Module)
			throws IOException, InterruptedException {

		community.SearchCommunityListById(SheetName, rowNum);
		rc.clickOnAlternatives(SheetName, rowNum);
		if (Module.equalsIgnoreCase("EP")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeEPID", 0);
			CommonMethod.RobustclickElementVisible("CommunityAlternativeEPID",
					"V2ProjectAdminAlternativeReSubmitReviewBtn");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeAAPLink", 0);
			CommonMethod.RobustclickElementVisible("CommunityAlternativeAAPLink",
					"V2ProjectAdminAlternativeReSubmitReviewBtn");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectAdminAlternativeComment", 1);
		CommonMethod.assertisElementPresentTrue("V2ProjectAdminAlternativeComment", "AlternativeComment is not visible");
		CommonMethod.assertisElementPresentTrue("DocumentsUploadMidReview","MidReview is not visible");
		CommonMethod.ScrollUpToElement("V2ProjectAdminAlternativeEditButton");
		CommonMethod.assertisElementPresentTrue("V2ProjectAdminAlternativeReSubmitReviewBtn","ReSubmitReviewBtn is not visible");
		CommonMethod.click("V2ProjectAdminAlternativeReSubmitReviewBtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeStatusPendingDecision", 0);
		String CommunityAlternativeStatusPendingDecision = CommonMethod
				.getattributeValueByTextContent("CommunityAlternativeStatusPendingDecision");
		CommonMethod.negativesoftassertFieldValid("Pending decision", CommunityAlternativeStatusPendingDecision,
				"Status doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeBackToAlternatives", 0);
		CommonMethod.click("CommunityAlternativeBackToAlternatives");
	}

	public void validateAlternativesEP(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeEPID", 0);
		CommonMethod.scrollDown();
		String getId = CommonMethod.getattributeValueByTextContent("CommunityAlternativeEPID");
		String[] stringArray = getId.split("-");
		String getCommunityAlternativeEPID = stringArray[1].trim();
		data.setCellData(SheetName, "CommunityAlternativeEPID", rowNum, getCommunityAlternativeEPID);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeEPStatus"), "PENDING",
				"Table FEATURE STATUS doesn't match");
		ReusableMethodCommon rmc = new ReusableMethodCommon();
		rmc.ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWER");
		CommonMethod.negativesoftassertisElementPresentFalse("V2ProjectAdminAlternativeEditButton", "Edit Button",
				"Edit button is visible for non-admin user");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeInsideStatus"),
				"Pending decision", "STATUS Pending decision doesn't match");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAdminAlternativeMeansCompliance"),
				"Proposed Alternative Means of Compliance", "Means of Compliance Text doesn't match");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeValidateWV1"), "WELL V1",
				"WELL V1 doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeValidateImage1", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeValidateImage2", 0);
	}
}