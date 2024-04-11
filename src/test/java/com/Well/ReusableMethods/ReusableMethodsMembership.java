package com.Well.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import com.Well.Engine.XlsReader;

public class ReusableMethodsMembership extends BaseClass {

	public void RegisterMembership(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified account for Membership");
		testlog.info("Given User logged in to the WELL certified account for Membership");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPUserMenu", 0);
		CommonMethod.RobustclickElementVisible("MPUserMenu", "MPMyMembership");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPMyMembership", 0);
		CommonMethod.RobustclickElementVisible("MPMyMembership", "MPGetStarted");
		CommonMethod.refreshBrowser();
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPGetStarted", 0);
		CommonMethod.RobustclickElementVisible("MPGetStarted", "MPIWBIMembership");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPWELLMembership", 0);
		testlog.info("MembershipName:" + MembershipName);
		CommonMethod.RobustclickElementVisible("MPWELLMembership", "MPSelectProgramContinuebtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPSelectProgramContinuebtn", 0);
		CommonMethod.Robustclick("MPSelectProgramContinuebtn");
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLCommunications", 0);
			CommonMethod.RobustclickElementVisible("MPPLCommunications", "MPPLCommunicationsContinueBtn");
			testlog.info("And User is select on Product Licensing Communications group");
	        CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLCommunicationsContinueBtn", 0);
			CommonMethod.Robustclick("MPPLCommunicationsContinueBtn");
			 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLGroupNo", 0);
			CommonMethod.sendKeys("MPPLGroupNo", "3");
			testlog.info("And User enters Group numer");
			 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLGroupNoContinueBtn", 0);
			CommonMethod.Robustclick("MPPLGroupNoContinueBtn");
			testlog.info("And User clicks on continue button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLPricingContinueBtn", 0);
		    CommonMethod.Robustclick("MPPLPricingContinueBtn");
		    testlog.info("And User clicks on continue button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPmembershipOwnerContinuebtn", 0);
			CommonMethod.RobustclickElementVisible("MPmembershipOwnerContinuebtn", "MandatoryFieldErrorMessage");
			CommonMethod.negativesoftassertPageSource("Owner name is required.", "Owner Name Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Owner email is required.","Owner Email Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Owner job title is required.", "Owner job title Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Owner phone is required.","Owner phone Error Mismatch");
			testlog.info("When User clicks on continue button without entering the mandatory fields and verifies error meassage");
			String firstName = USfaker.address().firstName();
			String PhoneNumber = USfaker.number().digits(10);
			CommonMethod.sendKeys("MPOwnerName", firstName);
			data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("MPOwnerName"));
			CommonMethod.sendKeys("MPOwnerEmail", data.getCellData("Login", "UserName", 9));
			data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("MPOwnerEmail"));
			CommonMethod.sendKeys("MPOwnerJob", "Testing");
			data.setCellData(SheetName, "OwnerJobTitle", rowNum, CommonMethod.getattributeValue("MPOwnerJob"));
			CommonMethod.sendKeys("MPOwnerPhone", PhoneNumber);
			data.setCellData(SheetName, "OwnerPhoneNumber", rowNum, CommonMethod.getattributeValue("MPOwnerPhone"));
			testlog.info("And User enters data to Owner Name, Email, JobTitle, Phone number fields");
			testlog.info("website:" + "https://test-nuxt.wellcertified.com/");
			testlog.info("firstName:" + firstName);
			testlog.info("phonenumber: " + PhoneNumber);
			testlog.info("Name: " + data.getCellData(SheetName, "Name", rowNum));
			testlog.info("Email: " + data.getCellData(SheetName, "Email", rowNum));
			testlog.info("JobTitle: " + data.getCellData(SheetName, "JobTitle", rowNum));
			testlog.info("And User check Agree to share point of contact");
			CommonMethod.sendKeys("MPmembershipadminName", firstName);
			data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("MPOwnerName"));
			CommonMethod.sendKeys("MPmembershipadminEmail", data.getCellData(SheetName, "Email", rowNum));
			data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("MPOwnerEmail"));
			CommonMethod.sendKeys("MPmembershipadminJob", "Testing");
			data.setCellData(SheetName, "OwnerJobTitle", rowNum, CommonMethod.getattributeValue("MPOwnerJob"));
			CommonMethod.sendKeys("MPmembershipadminPhone", PhoneNumber);
			 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPmembershipLicName", 0);
			CommonMethod.sendKeys("MPmembershipLicName", firstName);
			data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("MPOwnerName"));
			CommonMethod.sendKeys("MPmembershipLicEmail", data.getCellData(SheetName, "Email", rowNum));
			data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("MPOwnerEmail"));
			CommonMethod.sendKeys("MPmembershipLicJob", "Testing");
			data.setCellData(SheetName, "OwnerJobTitle", rowNum, CommonMethod.getattributeValue("MPOwnerJob"));
			CommonMethod.sendKeys("MPmembershipLicPhone", PhoneNumber);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPmembershipOwnerContinuebtn", 0);
			CommonMethod.RobustclickElementVisible("MPmembershipOwnerContinuebtn", "MPOrganizationContinuebtn");
			testlog.info("And User clicks on continue button");
		testlog.pass("**Verifies the Registration successful**");
	}

	public void BillingMembership(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		rc.Billing(SheetName, rowNum);
		testlog.info("MembershipName:" + MembershipName);
		if (MembershipName.equalsIgnoreCase("Cornerstone")) {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("MPValidMembershipeType"), "Cornerstone Membership",
					"Mismatch Cornerstone Membership Name");
			testlog.info("And User verifies Cornerstone Membership Name");
		} else if (MembershipName.equalsIgnoreCase("Keystone")) {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("MPValidMembershipeType"), "Keystone Membership",
					"Mismatch KEYSTONE Membership Name");
			testlog.info("And User verifies Keystone Membership Name");
		}
		testlog.pass("**Verified Membership Name successfully**");
	}

	public void AdminMembershipNavigation(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified Admin account");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminMembershipNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminMembershipNavBar", "MPViewButton");
		testlog.info("When User clicks on WELL Membership from top menu under Admin");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPViewButton", 0);
		CommonMethod.RobustclickElementVisible("MPViewButton", "ProfileTab");
		testlog.info("And User clicks on View Button");
		CommonMethod.RobustclickElementVisible("ProfileTab", "MPLicensingProgramCheckbox");
		testlog.info("And User clicks on ProfileTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicensingProgramCheckbox", 0);
		CommonMethod.ClickCheckbox("MPLicensingProgramCheckbox");
		testlog.info("And User checks Program Checkbox");
		CommonMethod.RobustclickElementVisible("MPProfileUpdateButton", "MPLicensingTab");
		testlog.info("And User clicks on Update Button");
		CommonMethod.RobustclickElementVisible("MPLicensingTab", "MPDownloadApplicationform");
		testlog.info("And User clicks on LicensingTab");
		CommonMethod.WaitUntilVisibility("MPDownloadApplicationform", 120);
		CommonMethod.RobustclickElementVisible("MPDownloadApplicationform", "MPLicensingContinue");
		testlog.info("And User clicks on Download Applicationform");
		Thread.sleep(2000);
		CommonMethod.isFileDownloaded();
		CommonMethod.RobustclickElementVisible("MPLicensingContinue", "MPApplicationform");
		testlog.info("And User clicks on continue button");
		testlog.info("Then User will be redirected to Product Licensing page");
		testlog.pass("**Verifies Navigate to Product Licensing Page successfully**");
	}

	public void NavigateInPL(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Membership Dashboard Page");
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLEnroll", 0);
		CommonMethod.JavascriptClickElement("MPPLEnroll");
		testlog.info("When User is clicks on Product Licensing Enroll tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLGetstartedBtn", 0);
		CommonMethod.JavascriptClickElement("MPPLGetstartedBtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLEnrollReg", 0);
		CommonMethod.JavascriptClickElement("MPPLEnrollReg");
		testlog.info("And User is clicks on Product Licensing Start button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLCommunications", 0);
		CommonMethod.RobustclickElementVisible("MPPLCommunications", "MPPLCommunicationsContinueBtn");
		testlog.info("And User is select on Product Licensing Communications group");
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLCommunicationsContinueBtn", 0);
		CommonMethod.Robustclick("MPPLCommunicationsContinueBtn");
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLGroupNo", 0);
		CommonMethod.sendKeys("MPPLGroupNo", "3");
		testlog.info("And User enters Group numer");
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLGroupNoContinueBtn", 0);
		CommonMethod.Robustclick("MPPLGroupNoContinueBtn");
		testlog.info("And User clicks on continue button");
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPPLPricingContinueBtn", 0);
	    CommonMethod.Robustclick("MPPLPricingContinueBtn");
	    testlog.info("And User clicks on continue button");
	    String firstName = USfaker.address().firstName();
		String PhoneNumber = USfaker.number().digits(10);
       CommonMethod.sendKeys("MPmembershipadminName", firstName);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("MPOwnerName"));
		CommonMethod.sendKeys("MPmembershipadminEmail", data.getCellData(SheetName, "Email", rowNum));
		data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("MPOwnerEmail"));
		CommonMethod.sendKeys("MPmembershipadminJob", "Testing");
		data.setCellData(SheetName, "OwnerJobTitle", rowNum, CommonMethod.getattributeValue("MPOwnerJob"));
		CommonMethod.sendKeys("MPmembershipadminPhone", PhoneNumber);
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPmembershipLicName", 0);
		CommonMethod.sendKeys("MPmembershipLicName", firstName);
	   CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPmembershipOwnerContinuebtn", 0);
		CommonMethod.Robustclick("MPmembershipOwnerContinuebtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPOrganizationContinuebtn", 0);
		CommonMethod.Robustclick("MPOrganizationContinuebtn");
		testlog.info("And User clicks on continue button");
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPReviewCheckbox", 0);
		CommonMethod.ClickCheckbox("MPReviewCheckbox");
	  CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPReviewContinueButton", 0);
		CommonMethod.Robustclick("MPReviewContinueButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("BillingLanding", 0);
		rc.Billing(SheetName, rowNum);
		testlog.pass("**Navigate to Product Licensing Page successfully**");
	}

	public void CreateLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Product Licensing Page");
		CommonMethod.RobustclickElementVisible("MPSaveProductButton", "MPSelectProductCategories");
		CommonMethod.negativesoftassertPageSource("Categories is required.", "Categories Error Mismatch");
		CommonMethod.negativesoftassertPageSource("ProductType is required.", "ProductType Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Parts is required.", "Feature Parts Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Group name is required.", "Group Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("At least one sku document is required",
				"Upload Document Error Mismatch");
		CommonMethod.negativesoftassertPageSource("At least one document is required",
				"Application Form Error Mismatch");
		CommonMethod.negativesoftassertPageSource("At least one supporting document is required.",
				"Supporting document Error Mismatch");
		testlog.info("When User clicks on continue button without entering the mandatory fields and verifies error meassage");
		for (int i = 1; i <= 3; i++) {
			int j = i + 1;
			CommonMethod.selectdropdownrandom("MPSelectProductCategories");
			testlog.info("And User select Product Categories");
			String ProductCategories = CommonMethod.getSelectedDropdownValue("MPSelectProductCategories");
			testlog.info("ProductCategories: " + ProductCategories);
			data.setCellData(SheetName, "ProductCategories", j, ProductCategories);
			CommonMethod.selectdropdownrandom("MPSelectproductType");
			testlog.info("And User select Product Type");
			String getproductType = CommonMethod.getSelectedDropdownValue("MPSelectproductType");
			testlog.info("ProductType: " + getproductType);
			data.setCellData(SheetName, "ProductType", j, getproductType);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPSelectPartname", 0);
			CommonMethod.RobustclickElementVisible("MPSelectPartname", "MPSelectPartnameSelect");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPSelectPartnameSelect", 0);
			CommonMethod.Robustclick("MPSelectPartnameSelect");
			Thread.sleep(1000);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseValidFeaturePart", 0);
			data.setCellData(SheetName, "FeaturePart", j, CommonMethod.getText("MPLicenseValidFeaturePart"));
			testlog.info("And User select Feature Part");
			CommonMethod.sendKeys("MPGroupName", data.getCellData(SheetName, "GroupName", j));
			testlog.info("And User enter GroupName field");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPProductUploadForm", 0);
			CommonMethod.uploadFile("MPProductUploadForm", ProductSkuImportTestDataUpload, "MPValidUploadFile1");
			testlog.info("And User upload ProductForm Document");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPValidUploadFile1", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPApplicationform", 0);
			CommonMethod.uploadFile("MPApplicationform", ProductSkuImportTestDataUpload, "MPValidUploadFile2");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPValidUploadFile2", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPSupportingdocuments", 0);
			CommonMethod.uploadFile("MPSupportingdocuments", ProductSkuImportTestDataUpload, "MPValidUploadFile3");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPValidUploadFile3", 0);
			testlog.info("And User upload Applicationform Document");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseComment", 0);
			CommonMethod.sendKeys("MPLicenseComment", "QA Team");
			String getComment = CommonMethod.getattributeValue("MPLicenseComment");
			data.setCellData(SheetName, "Comment", j, getComment);
			testlog.info("And User enter Comment field");
			CommonMethod.WaitUntilPresence("MPSaveProductButton", 120);
			CommonMethod.RobustclickElementVisible("MPSaveProductButton", "MPDeleteIcon");
			testlog.info("And User clicks on Save button");
			CommonMethod.scrollUp();
			CommonMethod.WaitUntilPresence("MPLicenseValidGroup", 120);
			testlog.info("Then User will be redirected to Product list page");
		}
		List<WebElement> Feature = CommonMethod.findElements("MPLicenseValidGroupName");
		int tempRowNum = rowNum;
		for (WebElement ele : Feature) {
			String GroupName = ele.getText();
			CommonMethod.negativesoftassertFieldValid(GroupName, data.getCellData(SheetName, "GroupName", rowNum),
					"GroupName data mismatch");
			rowNum++;
		}
		rowNum = tempRowNum;
		List<WebElement> FeaturePart = CommonMethod.findElements("MPLicenseValidFeaturePartName");
		for (WebElement ele : FeaturePart) {
			String getFeaturePart = ele.getText();
			CommonMethod.negativesoftassertFieldValid(getFeaturePart, data.getCellData(SheetName, "FeaturePart", rowNum),
					"FeaturePart data mismatch");
			rowNum++;
		}
		testlog.info("And User verifies the added details");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("MPLicenseProductCard", 3);
		CommonMethod.assertcountListWebelementFromIndex("MPLicenseProductCard", 3);
		CommonMethod.assertcountListWebelementFromIndex("MPLicenseEdit", 3);
		CommonMethod.assertcountListWebelementFromIndex("MPDeleteIcon", 3);
		testlog.info("And User verifies the ProductCard Count");
		softAssert.assertAll();
		testlog.info("**Verifies added 3 Product Licensing Group successfully**");
		testlog.pass("**Verifies Created Product Licensing successfully**");
	}

	public void UpdateLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Product Licensing list");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseValidGroup", 0);
		CommonMethod.clickOnListWebelementFromIndex("MPLicenseEdit", 0);
		testlog.info("When User clicks on Edit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseUpdateCloseFeaturePart", 0);
		CommonMethod.RobustclickElementVisible("MPLicenseUpdateCloseFeaturePart", "MPSelectUpdateProductCategories");
		CommonMethod.WaitUntilInVisibility("MPLicenseUpdateCloseFeaturePart", 120);
		CommonMethod.selectdropdownVisibletext("MPSelectUpdateProductCategories", "Communications");
		testlog.info("And User select on Product Categories");
		CommonMethod.selectdropdownVisibletext("MPSelectproductType", "Audio-video systems");
		testlog.info("And User select on Product Type");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPSelectPartname", 0);
		CommonMethod.RobustclickElementVisible("MPSelectPartname", "MPSelectPartnameChild");
		CommonMethod.RobustclickElementVisible("MPSelectPartnameChild", "MPGroupName");
		testlog.info("And User select on Partname");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseComment", 0);
		Thread.sleep(2000);
		CommonMethod.scrolldowntoElement("MPLicenseComment");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseUpdateSaveButton", 0);
		CommonMethod.Robustclick("MPLicenseUpdateSaveButton", "MPLicenseUpdaateClosePopup");
		testlog.info("And User clicks on Save button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseValidGroup", 0);
		testlog.info("Then User will be redirected to Product list page");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("MPValidType"), "Audio-video systems",
				"GroupName doesn't match");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("MPValidCategory"), "Communications",
				"Category doesn't match");
		testlog.info("And User verifies the added details");
		testlog.pass("**Verifies Updated Product Licensing successfully**");
	}

	public void DeleteLicensing(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Product Licensing list");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseValidGroup", 0);
		CommonMethod.clickOnListWebelementFromIndex("MPDeleteIcon", 2);
		testlog.info("When User clicks on DeleteIcon");
		CommonMethod.RobustclickElementVisible("MPLicenseProductDelete", "MPSelectProductCategories");
		testlog.info("And User clicks on Confirm Delete");
		testlog.info("Then User will be redirected to Product list page");
		CommonMethod.assertcountListWebelementFromIndex("MPDeleteIcon", 2);
		testlog.info("And User verifies the  Delete Product Licensing");
		testlog.pass("**Verifies Delete Product Licensing Group successfully**");
		softAssert.assertAll();
	}

	public void SubmitProductLicensingReview(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Submit Product Licensing Review page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseSubmitForReview", 0);
		CommonMethod.RobustclickElementVisible("MPLicenseSubmitForReview", "MPLicenseDeleteProduct");
		testlog.info("When User clicks on SubmitReview button");
		CommonMethod.assertcountListWebelementFromIndex("MPLicenseProductCard", 2);
		testlog.info("Then User will be redirected to Product list page");
		CommonMethod.WaitUntilPresence("MPLicenseReviewStatus", 120);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MPLicenseReviewStatus"), "UNDER REVIEW",
				"Review Status doesn't match");
		testlog.info("And User verifies Review Status");
		softAssert.assertAll();
		testlog.pass("**Verifies Submitted Product Licensing Review successfully**");

	}

	public void PromotionCardValidation(String SheetName, int rowNum, String cardValue) throws Exception {
		int countCard = CommonMethod.ElementSize("PromotionCardContainer");
		String cardCount = Integer.toString(countCard);
		CommonMethod.negativesoftassertFieldValid(cardCount, cardValue,"Promotion Card doesn't match");
		testlog.info("Card count: " + cardCount);

	}

	public void ValidatePromtionCard(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Membership Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PromotionTab", 0);
		CommonMethod.RobustclickElementVisible("PromotionTab", "PromotionCardContainer");
		testlog.info("When User clicks on PromotionTab");
		testlog.info("Then User will be redirected to Promotion page");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MembershipPromotionMembershipType"),
				"CORNERSTONE MEMBERSHIP", "Membership Type doesn't match");
		rc.ValidCardCount("PromotionCardContainer");
		testlog.info("And User verifies cards on the Promotion page");
		testlog.pass("**Verify card count successfully**");
	}

	public void ValidateEducationCard(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Membership Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EducationTab", 0);
		CommonMethod.RobustclickElementVisible("EducationTab", "PromotionCardContainer");
		testlog.info("When User clicks on EducationTab");
		testlog.info("Then User will be redirected to Education page");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MembershipPromotionMembershipType"),
				"CORNERSTONE MEMBERSHIP", "Membership Type doesn't match");
		rc.ValidCardCount("PromotionCardContainer");
		testlog.info("And User verifies cards on the Education page");
		testlog.pass("**Verify card count successfully**");
	}

	public void AddTeamMember(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Membership Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TeamTab", 0);
		CommonMethod.RobustclickElementVisible("TeamTab", "V2ProjectAddMemberbtn");
		testlog.info("When User clicks on TeamTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddMemberbtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAddMemberbtn", "MembershipTeamEmailAddress");
		testlog.info("And User clicks on AddMember button");
		String TeamEmail = data.getCellData(SheetName, "TeamEmailID", rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MembershipTeamEmailAddress", 0);
		CommonMethod.sendKeys("MembershipTeamEmailAddress", TeamEmail);
		testlog.info("And User enter on EmailAddress");
		testlog.info("Team Email ID: " + TeamEmail);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MembershipTeamRoleOption", 0);
		CommonMethod.ClickCheckbox("MembershipTeamRoleOption");
		testlog.info("And User checks the Role checkbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectInvitebtn", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectInvitebtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn", "TeamTableTr");
		testlog.info("And User clicks on Invite button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddMemberbtn", 0);
		CommonMethod.scrolldowntoElement("V2ProjectAddMemberbtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TeamTableTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDeleteIcon", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectDeleteIcon", "V2ProjectAddMemberbtn");
		testlog.info("And User clicks on Delete Icon");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddMemberbtn", 0);
		testlog.info("Then User will be redirected to Team list");
		testlog.pass("**Created Team member successfully**");
	}

	public void ProfileUpdated(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Membership Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProfileTab", 0);
		CommonMethod.RobustclickElementVisible("ProfileTab", "MembershipProfileAboutYourOrg");
		testlog.info("And User clicks on ProfileTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MembershipProfileAboutYourOrg", 0);
		CommonMethod.sendKeys("MembershipProfileAboutYourOrg", "Tell us about your organization and what you do.");
		testlog.info("And User enter data to AboutYourOrg narrative");
		CommonMethod.sendKeys("MembershipProfileOrgHealthAndWellness",
				"Which of your organization’s health and wellness achievements have been the most impactful, or make you feel pride");
		testlog.info("And User enter data to HealthAndWellness narrative");
		CommonMethod.scrolldowntoElement("MembershipProfileWellnessValue");
		CommonMethod.sendKeys("MembershipProfileOrgMission", "What is your organization’s mission");
		testlog.info("And User enter data to OrgMission narrative");
		CommonMethod.sendKeys("MembershipProfileIWBIMember", "Why is your organization an IWBI member");
		testlog.info("And User enter data to IWBIMember narrative");
		CommonMethod.sendKeys("MembershipProfileWellnessValue", "How does your team live their wellness values");
		testlog.info("And User enter data to AboutYourOrg narrative");
		CommonMethod.scrolldowntoElement("MembershipProfileUpdateButton");
		CommonMethod.RobustclickElementVisible("MembershipProfileUpdateButton", "MembershipProfileAboutYourOrg");
		testlog.info("And User clicks on Update button");
		CommonMethod.RobustclickElementVisible("ProfileTab", "MembershipProfileAboutYourOrg");
		testlog.info("And User clicks on ProfileTab");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MembershipProfileAboutYourOrg"),
				"Tell us about your organization and what you do.", "About Org Answer doesn't match");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("MembershipProfileOrgHealthAndWellness"),
				"Which of your organization’s health and wellness achievements have been the most impactful, or make you feel pride",
				"Org Health And Wellness Answer doesn't match");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("MembershipProfileOrgMission"),
				"What is your organization’s mission", "Org Mission Answer doesn't match");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("MembershipProfileIWBIMember"),
				"Why is your organization an IWBI member", "IWBI Member Answer doesn't match");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("MembershipProfileWellnessValue"),
				"How does your team live their wellness values", "Team Wellness Value Answer doesn't match");
		testlog.info("Then User verifies the added details");
		testlog.pass("**Profile updated successfully**");
	}

	public void ValidateProductGroupSuccessMessage(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Product Group page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLProductGroupButton", 0);
		CommonMethod.RobustclickElementVisible("FacultyPLProductGroupButton",
				"FacultyPLProductGroupSucessToastMessage");
		testlog.info("When User clicks on ProductGroup button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLProductGroupSucessToastMessage", 0);
		testlog.info("Then User will be redirected to ProductGroup page");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("FacultyPLProductGroupSucessToastMessage"),
				"Success! We will send you an email shortly with the link to download the zip files.",
				"Product Group Success message doesn't match");
		testlog.info("And User verifies Success Toast message");
		testlog.pass("**Validated Product Group successfully**");
	}

	public void DownloadReviewFile(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Download Review page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLProductInfoCheckBox", 0);
		CommonMethod.ClickCheckbox("FacultyPLProductInfoCheckBox");
		testlog.info("When User checks the Product Info checkbox");
		CommonMethod.RobustclickElementVisible("FacultyPLImportButton", "FacultyPLDownloadReviewButton");
		testlog.info("And User clicks on Import button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLDownloadReviewButton", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLImportReviewButton", 0);
		FileUtils.cleanDirectory(new File(downloadPath));
		CommonMethod.click("FacultyPLDownloadReviewButton");
		testlog.info("And User clicks on Download Review button");
		Thread.sleep(5000);
		CommonMethod.assertTruebooleanCondition(CommonMethod.isFileDownloaded(), "File not downloaded");
		CommonMethod.FileRename(downloadPath, "/Downloads/ProductReview.xlsx");
		pl= new XlsReader(System.getProperty("user.dir")+"/Downloads/ProductReview.xlsx");
		softAssert.assertAll();
		testlog.info("Then User verifies downloaded file");
		testlog.pass("**Download Product Review successfully**");
	}

	public void UpdateReviewFile(String SheetName, int rowNum) throws Exception {
		Thread.sleep(2000);
		testlog.info("Given User is on Download Review Page");
		pl.setCellData("Worksheet", "Status", rowNum, "NotAligned");
		testlog.info("When User updates the status to excel");
		testlog.pass("**Updated status in Review file successfully**");
	}
	public void ImportReviewFile(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Import Review Page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLImportReviewButton", 0);
		CommonMethod.RobustclickElementVisible("FacultyPLImportReviewButton", "FacultyPLSubmitResponseButton");
		testlog.info("When User clicks on Import Review button");
		CommonMethod.uploadFile("MPProductUploadFormUploadReviewResult", ProductLineReview, "FacultyPLDeleteICon");
		testlog.info("And User upload Product Review Document");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("FacultyPLSubmitResponseButton", "FacultyPLImportReviewButton");
		testlog.info("And User clicks on Submit Response button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLSuccessToastMessage", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("FacultyPLSuccessToastMessage"), "Success!!",
				"Import Review Success message doesn't match");
		testlog.info("Then User verifies Import Review Success message");
		testlog.pass("**Imported Review File successfully**");
	}
	public void MarkAsAchieved(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Profile Page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProfileTab", 0);
		CommonMethod.RobustclickElementVisible("ProfileTab", "FacultyPLAchievedRadioButton");
		testlog.info("When User clicks on ProfileTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLAchievedRadioButton", 0);
		CommonMethod.ClickCheckbox("FacultyPLAchievedRadioButton");
		testlog.info("And User checks the Achieved checkbox");
		CommonMethod.RobustclickElementVisible("MembershipProfileUpdateButton", "FacultyPLProfileUpdateSuccessMessage");
		testlog.info("And User clicks on Update button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLProfileUpdateSuccessMessage", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("FacultyPLProfileUpdateSuccessMessage"), "Profile changes saved!",
				"Profile Update Success message doesn't match");
		testlog.info("Then User verifies Profile Update Success message");
	}
	
	public void ValidateUpdatedImportData(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Licensing Page");
		
		  CommonMethod.refreshBrowser();
		  CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LicensingTab", 0);
		  CommonMethod.RobustclickElementVisible("LicensingTab",
		  "FacultyPLContinueButton"); testlog.info("When User clicks on LicensingTab");
		  CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
		  "FacultyPLContinueButton", 0);
		  CommonMethod.RobustclickElementVisible("FacultyPLContinueButton",
		  "FacultyPLCatalogPageLink");
		testlog.info("And User clicks on Continue button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLCatalogPageLink", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseReviewPassDate", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("MPLicenseReviewPassDate").replaceAll("\\s+", " ").trim(), CommonMethod.ValidateDate(),
				"MP License Review Pass Date Table Error Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseDuration", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("MPLicenseDuration").replaceAll("\\s+", " ").trim(), CommonMethod.ValidateDateYear(),
				"MP License Duration Table Error Mismatch");
		//DownloadSubmittedDocuments
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PLDownloadSubmittedDocuments", 0);
		CommonMethod.JavascriptClickElement("PLDownloadSubmittedDocuments");
		testlog.info("Then User Downloaded The Documents and Validated the Text");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPLicenseSuccessToasterMessage", 0);
		String HsrValidateDownloadedDocs = CommonMethod.getattributeValueByTextContent("MPLicenseSuccessToasterMessage").trim();
		CommonMethod.negativesoftassertFieldValid(HsrValidateDownloadedDocs, "Success! We will send you an email shortly", "Downloaded Text Message Does not Matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("MPLicenseSuccessToasterMessage", 1);
		//DownloadReviewResults
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PLDownloadReviewResults", 0);
		CommonMethod.JavascriptClickElement("PLDownloadReviewResults");
		boolean fileExistsReturnValue = CommonMethod.isFileDownloaded();
		testlog.info("Then User verifies Downloaded file");
		String fileExists = Boolean.toString(fileExistsReturnValue);
		CommonMethod.negativesoftassertFieldValid(fileExists, "true", "Downloaded Card file doesn't Exist");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FacultyPLCatalogPageLink", 0);
		CommonMethod.click("FacultyPLCatalogPageLink");
		testlog.info("And User clicks on Catalog Page Link");
		Thread.sleep(2000);
		CommonMethod.switchToChildTab();
		Thread.sleep(2000);
			if (TestNGTestName.contains("CS")) {
				Thread.sleep(3000);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getCurrentUrl(), "product-group", "Catalog Url doesn't match");
			}
	}
	
	public void RegisterNewMembership(String SheetName, int rowNum, String MembershipName)
			throws IOException, InterruptedException {
		
		testlog.info("Given User logged in to the WELL certified account for Membership");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPUserMenu", 0);
		CommonMethod.RobustclickElementVisible("MPUserMenu", "MPMyMembership");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPMyMembership", 0);
			CommonMethod.RobustclickElementVisible("MPMyMembership", "MPGetStarted");
			CommonMethod.refreshBrowser();
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPGetStarted", 0);
			CommonMethod.RobustclickElementVisible("MPGetStarted", "MPIWBIMembership");
			testlog.info("MembershipName:" + MembershipName);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPIWBIMembership", 0);
			CommonMethod.ClickCheckbox("MPIWBIMembership");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPSelectProgramContinuebtn", 0);
			CommonMethod.Robustclick("MPSelectProgramContinuebtn");
		if (MembershipName.equalsIgnoreCase("Cornerstone")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPSubscribeCornerstoneMembershipValid", 0);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MPSubscribeCornerstoneMembershipValid"),"$5,000 USD", "CornerstoneMembership Error Mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPSubscribeCornerstoneMembership", 0);
			CommonMethod.ClickCheckbox("MPSubscribeCornerstoneMembership");
		} else if (MembershipName.equalsIgnoreCase("Keystone")) {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MPSubscribeKeystoneMembershipValid"),"$15,000 USD", "KeystoneMembership Error Mismatch");
			CommonMethod.ClickCheckbox("MPSubscribeKeystoneMembership");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPSubscribeContinuebtn", 0);
		CommonMethod.Robustclick("MPSubscribeContinuebtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPmembershipOwnerContinuebtn", 0);
		CommonMethod.RobustclickElementVisible("MPmembershipOwnerContinuebtn", "MandatoryFieldErrorMessage");
		CommonMethod.negativesoftassertPageSource("Owner name is required.", "Owner Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner email is required.","Owner Email Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner job title is required.", "Owner job title Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner phone is required.","Owner phone Error Mismatch");
		testlog.info("When User clicks on continue button without entering the mandatory fields and verifies error meassage");
		String firstName = USfaker.address().firstName();
		String PhoneNumber = USfaker.number().digits(10);
		String email = USfaker.internet().emailAddress();
		CommonMethod.sendKeys("MPOwnerName", firstName);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("MPOwnerName"));
		CommonMethod.sendKeys("MPOwnerEmail", email);
		data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("MPOwnerEmail"));
		CommonMethod.sendKeys("MPOwnerJob", "Testing");
		data.setCellData(SheetName, "OwnerJobTitle", rowNum, CommonMethod.getattributeValue("MPOwnerJob"));
		CommonMethod.sendKeys("MPOwnerPhone", PhoneNumber);
		data.setCellData(SheetName, "OwnerPhoneNumber", rowNum, CommonMethod.getattributeValue("MPOwnerPhone"));
		testlog.info("And User enters data to Owner Name, Email, JobTitle, Phone number fields");
		testlog.info("website:" + "https://test-nuxt.wellcertified.com/");
		testlog.info("firstName:" + firstName);
		testlog.info("phonenumber: " + PhoneNumber);
		testlog.info("Name: " + data.getCellData(SheetName, "Name", rowNum));
		testlog.info("Email: " + data.getCellData(SheetName, "Email", rowNum));
		testlog.info("JobTitle: " + data.getCellData(SheetName, "JobTitle", rowNum));
		CommonMethod.ClickCheckbox("MPOwnerAgreeCheckbox");
		testlog.info("And User check Agree to share point of contact");
		CommonMethod.sendKeys("MPmembershipadminName", firstName);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("MPOwnerName"));
		CommonMethod.sendKeys("MPmembershipadminEmail", email);
		data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("MPOwnerEmail"));
		CommonMethod.sendKeys("MPmembershipadminJob", "Testing");
		data.setCellData(SheetName, "OwnerJobTitle", rowNum, CommonMethod.getattributeValue("MPOwnerJob"));
		CommonMethod.sendKeys("MPmembershipadminPhone", PhoneNumber);
    	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPmembershipOwnerContinuebtn", 0);
		CommonMethod.Robustclick("MPmembershipOwnerContinuebtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPOrganizationContinuebtn", 0);
		testlog.info("And User clicks on continue button");
		testlog.pass("**Verifies the Registration successful**");
	}
	
	public void ErollNewMembership(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Organization page");
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPOrganizationContinuebtn", 0);
		CommonMethod.RobustclickElementVisible("MPOrganizationContinuebtn", "MandatoryFieldErrorMessage");
		CommonMethod.negativesoftassertPageSource("Company is required.", "OrgName Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Domain is required.","Domain Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Website is required.", "Website Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Logo is required.","Logo Error Mismatch");
		testlog.info("When User clicks on continue button without entering the mandatory fields and verifies error meassage");
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPOrgCountry", 0);
		CommonMethod.selectdropdownVisibletext("MPOrgCountry", "United States");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("MPOrgCountry"));
		CommonMethod.selectdropdownrandom("MPOrgState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("MPOrgState"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("MPOrgStreet", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("MPOrgStreet"));
		CommonMethod.sendKeys("MPOrgCity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("MPOrgCity"));
		CommonMethod.sendKeys("MPOrgPostal", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("MPOrgPostal"));
		CommonMethod.sendKeys("MPOrgDomain", "@promantus");
		CommonMethod.sendKeys("MPOrgwebsite", "https://test-nuxt.wellcertified.com/");
		testlog.info("And User enters data to Street, City, Postalcode, Domain and  website fields");
		CommonMethod.uploadFile("MPOrgLogoUpload",SampleJpgfile1,
				"UploadFileVerifyScorecard");
		testlog.info("And User Upload logo document");
		testlog.info("Country: " + data.getCellData(SheetName, "Country", rowNum));
		testlog.info("And User enters data to Country, State, Street address, City and Postal Code fields");
		testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
		testlog.info("Street: " + data.getCellData(SheetName, "Street", rowNum));
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.Robustclick("MPOrganizationContinuebtn");
		testlog.info("And User clicks on continue button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPReviewCheckbox", 0);
		CommonMethod.RobustclickElementVisible("MPReviewContinueButton", "MandatoryFieldErrorMessage");
		CommonMethod.negativesoftassertPageSource("Terms is required.", "Terms Condition Error Mismatch");
		testlog.info("When User clicks on continue button without entering the mandatory fields and verifies error meassage");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPReviewCheckbox", 0);
		CommonMethod.ClickCheckbox("MPReviewCheckbox");
		testlog.info("And User checks on Review Checkbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPReviewContinueButton", 0);
		CommonMethod.RobustclickElementVisible("MPReviewContinueButton", "BillingLanding");
		testlog.info("And User clicks on continue button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("BillingLanding", 0);
		testlog.pass("**Verifies Enrollment successfully**");
}
	
	public void validateAdminMembershipStatus(String SheetName, int rowNum, String Status)
			throws IOException, InterruptedException {
	
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubscriptionStatusDropdown", 0);
		testlog.info("When User is on Subscription Status Dropdown");
		if(Status.equalsIgnoreCase("IN PROGRESS")) {
			CommonMethod.selectdropdownVisibletext("SubscriptionStatusDropdown", "Subscription in progress");
			testlog.info("And User is on Status:  IN PROGRESS");
		}
		else {
		CommonMethod.selectdropdownVisibletext("SubscriptionStatusDropdown", "Subscribed");
		testlog.info("And User is on Status: SUBSCRIBED");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERAdminApplybtn", 0);
		CommonMethod.click("WERAdminApplybtn");
		testlog.info("And User clicks on Apply Button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipSubscriptionStatus", 0);
		List<WebElement> labelStatus = CommonMethod.findElements("AdminMembershipSubscriptionStatus");
		for(int i=0; i<labelStatus.size(); i++) {				
			String getLabel = labelStatus.get(i).getText();
	        CommonMethod.negativesoftassertFieldValid(getLabel, Status, Status +": Status does not matched ");
	        testlog.info("Then User Verifies "+Status+": Subscription Status");

		}
}
	public void navigateAdminMembership() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		testlog.info("Given User is on Admin Nav Bar");
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminMembershipNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipNavBar", 0);
		testlog.info("And User is on Admin Membership Nav Bar");
		CommonMethod.RobustclickElementVisible("AdminMembershipNavBar", "SubscriptionStatusDropdown");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERAdminApplybtn", 0);
		CommonMethod.click("WERAdminApplybtn");
	}
	
	public void clearFilter()
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SearchFilterClear", 0);
		CommonMethod.JavascriptClickElement("SearchFilterClear");
	}
	
	public void validateAdminMembershipEngagementLevel(String SheetName, int rowNum, String Option, String Status)
			throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EngagementLevelDropdown", 0);
		testlog.info("When User is on Subscription Status Dropdown");
		CommonMethod.selectdropdownVisibletext("EngagementLevelDropdown", Option);
		testlog.info("And User is on Status: WORKS WITH WELL");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERAdminApplybtn", 0);
		CommonMethod.RobustclickElementVisible("WERAdminApplybtn","SearchFilterClear");
		testlog.info("And User clicks on Apply Button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EngagementLevelStatusMEMBERSHIP", 0);
		List<WebElement> label;
		if(Status.equalsIgnoreCase("MEMBERSHIP")) {
		 label = CommonMethod.findElements("EngagementLevelStatusMEMBERSHIP");
		}
		else {
			label = CommonMethod.findElements("EngagementLevelStatusWorkWithWELL");
		}
		for (WebElement ele : label) {
			String subscribeName = ele.getText();
			CommonMethod.negativesoftassertFieldValid(subscribeName, Status , "Engagement Level" +Status +"does not matched");
			testlog.info("Engagement Level Label is MEMBERSHIP");
		}
	}
	
	public void validateAdminMembershipFilterID(String SheetName, int rowNum)throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipIdTextBox", 0);
		CommonMethod.sendKeys("AdminMembershipIdTextBox", data.getCellData(SheetName, "MembershipId", rowNum).trim());
		testlog.info("And User added the text in text box");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERAdminApplybtn", 0);
		CommonMethod.RobustclickElementVisible("WERAdminApplybtn","SearchFilterClear");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SearchFilterClear", 0);
		testlog.info("And User clicks on Apply Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("TableTrSize", 1);
		int ProjectNameCount = CommonMethod.ElementSize("TableTrSize");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(ProjectNameCount), "1", "Portfolio Search failed");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipId", 0);
		String getExpectedData = CommonMethod.getattributeValueByTextContent("AdminMembershipId").trim();
		CommonMethod.negativesoftassertFieldValid(getExpectedData, data.getCellData(SheetName, "MembershipId", rowNum).trim(), "MembershipId Data does not matched");	
	}
	
	public void validateAdminMembershipFilterEmail(String SheetName, int rowNum)throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MPOwnerEmail", 0);
		CommonMethod.sendKeys("MPOwnerEmail", data.getCellData(SheetName, "MembershipOwnerEmail", rowNum));
		validateAdminMembershipFilterID(SheetName, rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipUserEmail", 0);
		String getExpectedData = CommonMethod.getattributeValueByTextContent("AdminMembershipUserEmail").trim();
		CommonMethod.negativesoftassertFieldValid(getExpectedData, data.getCellData(SheetName, "MembershipOwnerEmail", rowNum).trim(), "MembershipOwnerEmail Data does not matched");
	}

public void validateAdminMembershipFilterName(String SheetName, int rowNum)throws IOException, InterruptedException {
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipNameTextBox", 0);
	CommonMethod.sendKeys("AdminMembershipNameTextBox", data.getCellData(SheetName, "MembershipName", rowNum).trim());
	validateAdminMembershipFilterID(SheetName, rowNum);
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipName", 0);
	String getExpectedData = CommonMethod.getattributeValueByTextContent("AdminMembershipName").trim();
	CommonMethod.negativesoftassertFieldValid(getExpectedData, data.getCellData(SheetName, "MembershipName", rowNum).trim(), "MembershipName Data does not matched");
	}
	
	public void getAndSetAdminMembershipFilterData(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipIdTextBox", 0);
		String getMembershipId = data.getCellData(SheetName, "MembershipId", rowNum);
		CommonMethod.sendKeys("AdminMembershipIdTextBox", getMembershipId);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERAdminApplybtn", 0);
		CommonMethod.click("WERAdminApplybtn");
		testlog.info("And User clicks on Apply Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipName", 0);
		String getExpectedMembershipName = CommonMethod.getattributeValueByTextContent("AdminMembershipName");
		data.setCellData(SheetName, "MembershipName", 2, getExpectedMembershipName);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminMembershipUserEmail", 0);
		String getExpectedOwnerEmail = CommonMethod.getattributeValueByTextContent("AdminMembershipUserEmail");
		data.setCellData(SheetName, "MembershipOwnerEmail", 2, getExpectedOwnerEmail);
		testlog.info("Given User fetch the data");
		testlog.info("When User added the data in excel");
	}
}