package com.Well.ReusableMethods;

import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.zaproxy.clientapi.core.ClientApiException;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import com.Well.Engine.XlsReader;
import io.restassured.response.Response;

public class ReusableMethodsPortfolio extends BaseClass {
	String header;
	long EstArea;
	String PortfolioAndRatingLocAccDocumentTable = "PortfolioAndRatingLocAccDocumentTable";
	String PortfolioAndRatingLocAccDocumentTableTr = "PortfolioAndRatingLocAccDocumentTableTr";
	String PortfolioScoreCardVerificationAssignLocSavebtn = "PortfolioScoreCardVerificationAssignLocSavebtn";
	String toolTipMessage = "You do not have permission to delete this document";

	public void RegisterPortfolio(String SheetName, int rowNum, String Engagement_level, String Country, String ProjectName)
			throws IOException, InterruptedException {
		testlog.info("Given User logged in to the WELL certified account");
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 60);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WellAtScaleNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioCreateAccountButton");
		testlog.info("When User clicks on WELL At Scale from top menu under Projects");
		CommonMethod.WaitUntilVisibility("PortfolioCreateAccountButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountButton", "PortfolioAccountName");
		testlog.info("And User clicks on Create Account Button");
		String AccountName = ProjectName +"_ " + CommonMethod.randomNumber(8000000);
		CommonMethod.WaitUntilVisibility("PortfolioAccountName", 30);
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountSubmit", "PortfolioAccountName");
		CommonMethod.WaitUntilVisibility("PortfolioAccountName", 60);
		CommonMethod.negativesoftassertPageSource("Acount Name is required.", "Acount Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization is required.", "Organization Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Organization Industry is required.",
				"Organization Industry Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Locations Questionaire is required.",
				"Locations Questionaire Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Total number of assets is required.",
				"Total number of assets Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Number of locations is required.",
				"Number of locations Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Area is required.", "Area Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Area in Meter is required.", "Area in Meter Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Primary Locations is required.", "Primary Locations Error Mismatch");
		CommonMethod.negativesoftassertPageSource("SpaceTypes is required.", "SpaceTypes Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Error Mismatch");
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		CommonMethod.WaitUntilVisibility("PortfolioAccountName", 120);
		CommonMethod.sendKeys("PortfolioAccountName", AccountName);
		data.setCellData(SheetName, "AccountName", rowNum, AccountName);
		rc.SelectOwnerOrg(SheetName, rowNum);
		data.setCellData(SheetName, "OrgName", rowNum, CommonMethod.getText("OrgName"));
		testlog.info("OrganizationName: " + data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.selectdropdownrandom("OrgIndustry");
		testlog.info("And User select OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		testlog.info("OrgIndustry: " + data.getCellData(SheetName, "OrgIndustry", rowNum));
		if (Engagement_level.equalsIgnoreCase("Portfolio")) {
			CommonMethod.ClickCheckbox("PortfolioSubsetRadio");
			testlog.info("And User checks the Subscription checkbox");
			CommonMethod.sendKeys("PortfolioLocationDescription", "Test Portfolio");

		} else {
			CommonMethod.ClickCheckbox("PortfolioNotSureRadio");
			testlog.info("And User checks the NotSure checkbox");
		}
		CommonMethod.sendKeys("PortfolioNumberOfLocation", "15");
		data.setCellData(SheetName, "Location", rowNum, CommonMethod.getattributeValue("PortfolioNumberOfLocation"));
		testlog.info("PortfolioNumberOfLocation: " + data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.sendKeys("PortfolioEstimatedNumberOfLocation", "10");
		testlog.info("And User enter data to Estimated Number Of Location");
		data.setCellData(SheetName, "EstimatedNumberOfLocation", rowNum,
				CommonMethod.getattributeValue("PortfolioEstimatedNumberOfLocation"));
		testlog.info("EstimatedNumberOfLocation: " + data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum));
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		CommonMethod.sendKeys("PortfolioGrossAreaSQFT", Area);
		testlog.info("And User enter data to AreaSQFT");
		data.setCellData(SheetName, "AreaSQFT", rowNum, CommonMethod.getattributeValue("PortfolioGrossAreaSQFT"));
		testlog.info("PortfolioGrossAreaSQFT: " + data.getCellData(SheetName, "AreaSQFT", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioPrimarlyLocated");
		CommonMethod.RobustclickElementVisible("PortfolioPrimarlyLocated", "SelectOwnerOrg");
		CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
		CommonMethod.RobustclickElementVisible("SelectOwnerOrg", "PortfolioSpaceType");
		testlog.info("And User select PrimarlyLocated");
		CommonMethod.RobustclickElementVisible("PortfolioSpaceType", "PortfolioSelectSpaceType");
		CommonMethod.RobustclickElementVisible("PortfolioSelectSpaceType", "PortfolioOwnerCountry");
		testlog.info("And User select SpaceType");
		CommonMethod.selectdropdownValue("PortfolioOwnerCountry", Country);
		testlog.info("And User select OwnerCountry");
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerCountry"));
		testlog.info("PortfolioOwnerCountry: " + data.getCellData(SheetName, "Country", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioOwnerState", 10);
		CommonMethod.selectdropdownrandom("PortfolioOwnerState");
		testlog.info("And User select OwnerState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("PortfolioOwnerState"));
		testlog.info("PortfolioOwnerState: " + data.getCellData(SheetName, "State", rowNum));
		String ProjectAddress1 = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("PortfolioOwnerStreetAddress", ProjectAddress1);
		testlog.info("And User enter data to OwnerStreet Address");
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("PortfolioOwnerStreetAddress"));
		testlog.info("PortfolioOwnerStreetAddress: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerCity", ProjectCity);
		testlog.info("And User enter data to City");
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("PortfolioOwnerCity"));
		testlog.info("PortfolioOwnerCity: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPostalCode", PostalCode);
		testlog.info("And User enter data to PostalCode");
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCreateAccountSubmit", 0);
		CommonMethod.RobustclickElementVisible("PortfolioCreateAccountSubmit", "WellV2DashboardTab");
		testlog.info("And User clicks on Submit button");
		CommonMethod.WaitUntilVisibility("WellV2DashboardTab", 60);
		testlog.info("Then User will be redirected to Dashboard page");
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getProjectId = stringArray[1].trim();
		data.setCellData(SheetName, "ProjectID", rowNum, getProjectId);
		testlog.info("And User store Registered id  in excel");
		testlog.pass("**Verifies the Registration successful**");

	}

	public void SearchPortfolioById(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WellAtScaleNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioSearchByID");
		testlog.info("When User clicks on WELL AtScale from top menu under Projects");
		testlog.info("Portfolio Name:" + data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("Portfolio ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSearchByID", 0);
		CommonMethod.RobustclickElementVisible("PortfolioSearchByID", "PortfolioSearchApplyFilter");
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeyEnter("PortfolioSearchByID");
		testlog.info("And User enter data to PortfolioID");
		CommonMethod.RobustclickElementVisible("PortfolioSearchApplyFilter", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(var), "1", "Portfolio Search failed");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("PortfolioIDVerify"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with exceles in search");
		testlog.info("Then User verifies PortfolioID in search filter");
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify", "WellV2DashboardTab");
		testlog.info("And User clicks on PortfolioID");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		testlog.info("And User will be redirected to Dashboard page");
		testlog.pass("**Verifies the Search Portfolio Name successfully**");
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public void SignAgreementPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		String projectId = data.getCellData(SheetName, "ProjectID", rowNum);
		String[] Id = projectId.split("WELLP");
		System.out.println("Id: " + Id[1]);
		String header = portfolio.PostRequestAuthenticate("UserName", 3);
		testlog.info("Given User set POST service api endpoint");
		testlog.info("When User set Request header and Payload");
		testlog.info("And User Send a POST HTTP request");
		testlog.info("Header Token: " + header);
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
		pathprms.put("portfolio_id", Id[1]);
		Response res = given().log().all().accept("application/json").contentType("application/json")
				.header("Authorization", header).pathParams(pathprms).when()
				.post("portfolio/{portfolio_id}/aggrementSign");
		int StatusCode = res.getStatusCode();
		Assert.assertEquals(StatusCode, 200, "Verifying status code");
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.info("And User Complete Sign project agreement");
		testlog.pass("**Verifies project agreement sign successfully**");
		CommonMethod.refreshBrowser();
	}

	public void SubscribePortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubscribeTab", 0);
		CommonMethod.RobustclickElementVisible("SubscribeTab", "PortfolioAccountValidName");
		testlog.info("When User clicks on SubscribeTab");
		if (rowNum == 2) {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioAccountNameValid"),
					data.getCellData(SheetName, "AccountName", rowNum), "Register AccountName Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("OrgName"),
					data.getCellData(SheetName, "OrgName", rowNum), "OrgName Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioAddressValid"),
					data.getCellData(SheetName, "Street", rowNum), "Register Street Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioCityValid"),
					data.getCellData(SheetName, "City", rowNum), "Register City Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioPostalValid"),
					data.getCellData(SheetName, "PostalCode", rowNum), "Register PostalCode Error Mismatch");
			CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioBillingCheckboxValid");
			testlog.info("And User verifies the added details");
		}
		String OwnerName = USfaker.address().firstName();
		String OwnerEmail = USfaker.internet().emailAddress();
		String OwnerPhone = USfaker.number().digits(10);
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton", "PortfolioOwnerName");
		CommonMethod.WaitUntilPresence("PortfolioOwnerName", 120);
		CommonMethod.scrolldowntoElement("PortfolioOwnerName");
		CommonMethod.negativesoftassertPageSource("Owner Name is required.", "Owner Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner Email is required.", "Owner Email Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Owner Phone is required.", "Owner Phone Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Consultant is required.", "Enterprise Error Mismatch");
		testlog.info(
				"And User clicks on continue button without entering the mandatory fields and verifies error meassage");
		CommonMethod.sendKeys("PortfolioOwnerName", OwnerName);
		data.setCellData(SheetName, "OwnerName", rowNum, CommonMethod.getattributeValue("PortfolioOwnerName"));
		testlog.info("OwnerName: " + data.getCellData(SheetName, "OwnerName", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerEmail", OwnerEmail);
		data.setCellData(SheetName, "OwnerEmail", rowNum, CommonMethod.getattributeValue("PortfolioOwnerEmail"));
		testlog.info("OwnerEmail: " + data.getCellData(SheetName, "OwnerEmail", rowNum));
		CommonMethod.sendKeys("PortfolioOwnerPhone", OwnerPhone);
		data.setCellData(SheetName, "OwnerPhone", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPhone"));
		testlog.info("And User enter data to Name, Email and Phone number fields");
		testlog.info("OwnerPhone: " + data.getCellData(SheetName, "OwnerPhone", rowNum));
		rc.SelectEnterpriseProviders(SheetName, rowNum);
		testlog.info("And User select the enterprise checkbox");
		testlog.info("And User checks the consultants checkbox");
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton");
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton", "PortfolioSubcribeContinueButton2");
		testlog.info("And User clicks on continue button");
		if (rowNum == 2) {
			CommonMethod.RobustclickElementVisible("PortfolioSubscribeBackButton", "PortfolioOwnerName");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioAccountNameValid"),
					data.getCellData(SheetName, "AccountName", rowNum), "AccountName Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("OrgName"),
					data.getCellData(SheetName, "OrgName", rowNum), "OrgName Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioOwnerName"),
					data.getCellData(SheetName, "OwnerName", rowNum), "OwnerName Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioOwnerEmail"),
					data.getCellData(SheetName, "OwnerEmail", rowNum), "OwnerEmail Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioOwnerPhone"),
					data.getCellData(SheetName, "OwnerPhone", rowNum), "OwnerPhone Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioAddressValid"),
					data.getCellData(SheetName, "Street", rowNum), "Street Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioCityValid"),
					data.getCellData(SheetName, "City", rowNum), "City Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioPostalValid"),
					data.getCellData(SheetName, "PostalCode", rowNum), "PostalCode Error Mismatch");
			CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioBillingCheckboxValid", "PortfolioBillingCheckboxValid");
			testlog.info("And User verifies the added details about you by clicking on back button");
			CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton",
					"PortfolioSubcribeContinueButton2");
			testlog.info("And User clicks on continue button");
		}
		if (rowNum != 6) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioQuestionRadio", 0);
			CommonMethod.ClickCheckbox("PortfolioQuestionRadio");
			testlog.info("And User checks the Question checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationDescriptionTextbox", 0);
			CommonMethod.sendKeys("PortfolioLocationDescriptionTextbox", "Test Description");
			testlog.info("And User enter data to Description field");
		}
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("PortfolioOwnerPostalCode"));
		testlog.info("PortfolioOwnerPostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.scrolldowntoElement("PortfolioSubcribeContinueButton2");
		CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton2", "PortfolioSubscribeDone");
		testlog.info("And User clicks on continue button");
		if (rowNum == 2) {
			CommonMethod.RobustclickElementVisible("PortfolioOrganizationalConfidentialityBackButton",
					"PortfolioQuestionRadio");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioGrossAreaSQFT"),
					data.getCellData(SheetName, "AreaSQFT", rowNum), "AreaSQFT Error Mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioValidNumberOfLocation"),
					data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum), "Location Error Mismatch");
			CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioQuestionRadio", "QuestionRadio");
			testlog.info("And User verifies the added details about you by clicking on back button");
			CommonMethod.RobustclickElementVisible("PortfolioSubcribeContinueButton2", "PortfolioSubscribeDone");
			testlog.info("And User clicks on continue button");
		}
		CommonMethod.RobustclickElementVisible("PortfolioSubscribeDone", "PortfolioGoToBilling");
		testlog.info("And User clicks on SubscribeDone button");
		CommonMethod.WaitUntilVisibility("PortfolioGoToBilling", 60);
		CommonMethod.Robustclick("PortfolioGoToBilling");
		testlog.info("And User clicks on GoToBilling button");
		CommonMethod.WaitUntilVisibility("V2ProjectPreBillingPayNowButton", 20);
		CommonMethod.navigateBack();
		testlog.pass("**Verifies Subscribe Portfolio successfully**");
	}

	public void PortfolioClickOnBilling() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("BiilingTab", 60);
		CommonMethod.RobustclickElementVisible("BiilingTab", "V2ProjectPreBillingPayNowButton");
		testlog.info("When User clicks on BilingTab");
		CommonMethod.WaitUntilVisibility("V2ProjectPreBillingPayNowButton", 20);
		CommonMethod.RobustclickElementVisible("V2ProjectPreBillingPayNowButton", "BillingLanding");
		testlog.info("And User clicks on PayNow Button");
		CommonMethod.WaitUntilVisibility("BillingLanding", 120);
		testlog.info("Then User will be redirected to Billing Invoice page");
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void PortfolioBuildScorecard() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2Tab", 0);
		CommonMethod.RobustclickElementVisible("WellV2Tab", "ScorecardTab");
		testlog.info("When User clicks on WellV2Tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardTab", 0);
		CommonMethod.JavascriptClickElement("ScorecardTab");
		testlog.info("And User clicks on ScorecardTab");
		if (CommonMethod.isElementsExist("PortfolioScorecardZeroPointButton", 60)) {
			Thread.sleep(2000);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardZeroPointButton", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardZeroPointButton",
					"PortfolioScorecardPopupButton");
			testlog.info("And User clicks on Finished Button");
			Thread.sleep(2000);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPopupButton", 0);
			CommonMethod.Robustclick("PortfolioScorecardPopupButton");
			testlog.info("And User clicks on Popup Button");
		}
		rc.ScorecardLoading();
		testlog.info("Then User will be redirected to ScoreCardPage page");
		testlog.pass("**Verfies Scorecard Page successfully**");
	}

	public void PursingSearch() throws IOException, InterruptedException {
		testlog.info("And User is on Purse Search filter");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationSearchPurseLink", 0);
		CommonMethod.JavascriptClickElement("PortfolioScoreCardVerificationSearchPurseLink");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationSearchTextbox", 0);
		CommonMethod.sendKeys("PortfolioScoreCardVerificationSearchTextbox", "WELL at scale Test location 1");
		Thread.sleep(3000);		
		CommonMethod.sendKeyEnter("PortfolioScoreCardVerificationSearchTextbox");
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("ScorecardFeatureLoader");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException(
				"PortfolioScoreCardVerificationPurseSearchTableTr", 1);
		int var = CommonMethod.ElementSize("PortfolioScoreCardVerificationPurseSearchTableTr");
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(var), "1",
				"Scorecard Assign location Pursuing Search filter Count Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignPurseSearchFilterCloseIcon", 0);
		CommonMethod.Robustclick("AssignPurseSearchFilterCloseIcon");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignPurseSearchFilterCloseIcon", 1);
		testlog.info("Then User verifies Purse Search filter");
		testlog.pass("**Verifies Purse Search filter successfully**");
	}

	public void clickDocument() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2Tab", 0);
		CommonMethod.RobustclickElementVisible("WellV2Tab", "DocumentLibraryTab");
		testlog.info("When User clicks on WellV2Tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DocumentLibraryTab", 0);
		CommonMethod.RobustclickElementVisible("DocumentLibraryTab", "PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
		testlog.info("When User clicks on DocumentTab");
		testlog.pass("**Navigate Document successfully**");
	}
	
	public void clickHSRDocument() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilPresence("PortfolioHSRTab", 120);
		CommonMethod.RobustclickElementVisible("PortfolioHSRTab", "PortfolioHSROptInDocumentLibraryTab");
		testlog.info("When User clicks on PortfolioHSRTab");
		CommonMethod.WaitUntilVisibility("PortfolioHSROptInDocumentLibraryTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioHSROptInDocumentLibraryTab", "PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", Scorecardtimeout);
		testlog.info("When User clicks on DocumentTab");
		testlog.pass("**Navigate Document successfully**");
	}
	
	public void clickWPRDocument() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilPresence("PerformanceTab", 120);
		CommonMethod.RobustclickElementVisible("PerformanceTab", "PortfolioWPROptInDocumentLibraryTab");
		testlog.info("When User clicks on Portfolio PerformanceTab");
		CommonMethod.WaitUntilVisibility("PortfolioWPROptInDocumentLibraryTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioWPROptInDocumentLibraryTab", "PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", Scorecardtimeout);
		testlog.info("When User clicks on DocumentTab");
		testlog.pass("**Navigate Document successfully**");
	}
	
	public void clickWERDocument() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilPresence("EquityTab", 120);
		CommonMethod.RobustclickElementVisible("EquityTab", "PortfolioWEROptInDocumentLibraryTab");
		testlog.info("When User clicks on Portfolio EquityTab");
		CommonMethod.WaitUntilVisibility("PortfolioWEROptInDocumentLibraryTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioWEROptInDocumentLibraryTab", "PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", Scorecardtimeout);
		testlog.info("When User clicks on DocumentTab");
		testlog.pass("**Navigate Document successfully**");
	}

	public void ValidatingLegalUploadDocument(String SheetName, int rowNum, String Commodity) throws Exception {
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton", "V2ProjectPortfolioDocTypeLegal");
		testlog.info("When User click on Upload button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectPortfolioDocTypeLegal", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectPortfolioDocTypeLegal", "V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownVisibletext("PortfolioSelectdocumenttype", "Signed certification agreement");
		testlog.info("And User select Document Type");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", LegalfileUpload, "UploadFileVerifyScorecard");
		testlog.info("And User Upload Document");
		CommonMethod.WaitUntilVisibility("PortfolioDocumentUploadSubmitbutton", 60);
		CommonMethod.Robustclick("PortfolioDocumentUploadSubmitbutton");
		testlog.info("When User click on Submit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		testlog.info("Then User will be redirected to DocumentList page");
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
		pathprms.put("Stage", "Legal");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false, true,
				false, false, false);
		testlog.info("And User verifies Document Upload Table");
		rc.VaidDeleteButton();
		testlog.pass("**Upload Legal Document successfully**");
	}

	public void ValidatingAuditUploadDocument(String SheetName, int rowNum, String Commodity, String ProjectType,
			String PartId, String VerificationMethod) throws Exception {
		CommonMethod.refreshBrowser();
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilNumberOfElementToBePresent("PortfolioDocumentUploadbutton", 1);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton",
				"V2ProjectPortfolioDocTypeFeatureAudit");
		testlog.info("When User click on Upload button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectPortfolioDocTypeFeatureAudit", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectPortfolioDocTypeFeatureAudit", "V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "audit");
		testlog.info("And User select Document Type");
		if (ProjectType.equalsIgnoreCase("v2") || Commodity.equalsIgnoreCase("Ratings")) {
			CommonMethod.WaitUntilPresence("PortfolioSelectverificationMethod", 300);
			CommonMethod.selectdropdownVisibletext("PortfolioSelectverificationMethod", VerificationMethod);
		} else {
			CommonMethod.WaitUntilVisibility("OwnerOrgClick", 60);
			CommonMethod.RobustclickElementVisible("OwnerOrgClick", "PortfolioDocumentAuditVerficationMethod");
			CommonMethod.WaitUntilPresence("PortfolioDocumentAuditVerficationMethod", 30);
			CommonMethod.click("PortfolioDocumentAuditVerficationMethod");
		}
		CommonMethod.WaitUntilPresence("WPRSelectFeaturePart", 60);
		CommonMethod.scrolldowntoElement("V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownVisibletext("WPRSelectFeaturePart", PartId);
		testlog.info("And User select FeaturePart");
		CommonMethod.scrolldowntoElement("WPRSelectFeaturePart");
		CommonMethod.WaitUntilPresence("WPRAddPartButton", 60);
		CommonMethod.Robustclick("WPRAddPartButton", "WPRSelectFeaturePart");
		generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, AuditfileUpload, false, false, false,
				false);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx", 0);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx", "PortfolioScorecardValidDisable");
		rc.ScorecardConfirmLocUploadSaveButton();
		testlog.info("When User click on Submit button");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilPresence(PortfolioAndRatingLocAccDocumentTable, 120);
		testlog.info("And User verifies Document Upload Table");
		CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
		pathprms.put("Stage", "Audit");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false, true,
				false, false, false);
		testlog.pass("**Upload Audit Document successfully**");
	}

	public void ValidatingFeatureUploadDocument(String SheetName, int rowNum, String Commodity, String ProjectType,
			String PartId) throws Exception {
		CommonMethod.refreshBrowser();
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton",
				"V2ProjectPortfolioDocTypeFeatureAudit");
		testlog.info("When User click on Upload button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectPortfolioDocTypeFeatureAudit", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectPortfolioDocTypeFeatureAudit", "V2ProjectPortfolioDocType");
		testlog.info("When User click on Upload button");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "feature");
		testlog.info("And User select Document Type");
		if (ProjectType.equalsIgnoreCase("v2") || Commodity.equalsIgnoreCase("Ratings")) {
			CommonMethod.selectdropdownVisibletext("PortfolioSelectverificationMethod",
					"Policy and/or Operations Schedule");
			testlog.info("And User select VerificationMethod");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OwnerOrgClick", 0);
			CommonMethod.RobustclickElementVisible("OwnerOrgClick", "PortfolioDocumentFatureV2PilotVerficationMethod");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentFatureV2PilotVerficationMethod", 0);
			CommonMethod.click("PortfolioDocumentFatureV2PilotVerficationMethod");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRSelectFeaturePart", 0);
		CommonMethod.scrolldowntoElement("V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownVisibletext("WPRSelectFeaturePart", PartId);
		testlog.info("And User select FeaturePart");
		if (CommonMethod.isElementsExist("PortfolioScoreCardVerificationSelectSpaceType", 5)) {
			CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
		}
		if (CommonMethod.isElementsExist("PortfolioScoreCardVerificationSelectOption", 5)) {
			CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
		}
		CommonMethod.scrolldowntoElement("WPRSelectFeaturePart");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddPartButton", 0);
		CommonMethod.Robustclick("WPRAddPartButton", "WPRSelectFeaturePart");
		generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FeaturefileUpload, false, false, false,
				false);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx", 0);
		if (TestCaseName.equalsIgnoreCase("Portfolio_TC_08_02_FeatureUploadDocumentInDocument")) {
			CommonMethod.sendKeys("PortfolioEditSearchLocation", "WELL at scale Test location 1");
			Thread.sleep(3000);
			CommonMethod.sendKeyEnter("PortfolioEditSearchLocation");
			Thread.sleep(2000);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr", 1);
			CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
			int AssignLocTableTrSize = CommonMethod.ElementSize("AssignLocationTableTr");
			String TableTrSize = Integer.toString(AssignLocTableTrSize);
			CommonMethod.negativesoftassertFieldValidEquals(TableTrSize, "1",
					"TableTrSize in Document list doesn't match");
			testlog.info("And User verifies Search Location Name in Edit Location model");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
					"PortfolioScorecardAssignLocationSearchFilterCloseIcon", 0);
			CommonMethod.Robustclick("PortfolioScorecardAssignLocationSearchFilterCloseIcon");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignChildLocCbx", 0);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignChildLocCbx", "PortfolioScorecardValidDisable");
		rc.ScorecardConfirmLocUploadSaveButton();
		testlog.info("And User clicks on Submit button");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilPresence(PortfolioAndRatingLocAccDocumentTable, 120);
		//CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
		pathprms.put("Stage", "Feature");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false, true,
				false, false, false);
		testlog.pass("**Upload Feature Document successfully**");

	}

	public void SubmitReviewDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		testlog.info("When User clicks on ReviewTab");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 30);
		CommonMethod.WaitUntilPresence("PortfolioReviewSubmitButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitButton", "PortfolioReviewTextbox");
		testlog.info("And User clicks on Submit Button");
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitDocButton", "OwnerOrgClick");
		CommonMethod.negativesoftassertPageSource("Portfolio-review is required.", "Select the Review Error Mismatch");
		CommonMethod.negativesoftassertPageSource(
				"Please provide your comments below to notify the IWBI team is required.",
				"Comment Name Error Mismatch");
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		CommonMethod.WaitUntilVisibility("OwnerOrgClick", 60);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", "PortfolioSelectV2Review");
		CommonMethod.click("PortfolioSelectV2Review");
		CommonMethod.WaitUntilPresence("PortfolioReviewTextbox", 60);
		CommonMethod.sendKeys("PortfolioReviewTextbox", "Submit Documentation for Year 1, Review Cycle #1");
		testlog.info("And User enter data to Review field");
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitDocButton", "PortfolioReviewListStatus");
		testlog.info("And User clicks on Submit Button");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListStatus", 120);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioReviewListStatus"),
				"ROUND 1 REVIEW IN PROGRESS", "Review status In Review Table doesn't match");
		List<String> tabledata = CommonMethod.fetchTableData("PortfolioReviewTable");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(3), CommonMethod.ValidateDate(),
				"Submitted Date In Review Tabl Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(4), "-",
				"Estimate date In Review Table doesn't Mismatch");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(5), "",
				"Returned Date In Review Table doesn't Mismatch");
		testlog.info("Then User will be redirected to Review list page");
		testlog.pass("**Submitted Documentation for Year 1, Review Cycle #1 successfully**");
	}

	public void AdminCompleteReview(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * Admin Review
		 */
		AdminSearch(SheetName, rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "PortfolioReviewListViewButton");
		testlog.info("And User clicks on Review tab");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListViewButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioReviewListViewButton", "PortfolioReturnReview");
		testlog.info("And User clicks on view button");
		CommonMethod.WaitUntilVisibility("PortfolioReturnReview", 60);
		CommonMethod.RobustclickElementVisible("PortfolioReturnReview", "PortfolioScoreCardVerificationUpload");
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", PortfolioLocationImportfile,
				"UploadFileVerifyScorecard");
		testlog.info("And User clicks on Return button");
		testlog.info("And User Upload Review Document");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Preliminary Precertification Review");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		testlog.info("And User select Review Date");
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitResponse", "PortfolioReviewStatus");
		CommonMethod.WaitUntilVisibility("PortfolioReviewStatus", 60);
		testlog.info("Then User verifies Reviewed Status");
		testlog.pass("**Completed Reviewed Preliminary Precertification Review successfully**");
	}

	public void AdminCompleteReviewDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioBackToAllReview", 0);
		CommonMethod.RobustclickElementVisible("PortfolioBackToAllReview", "PortfolioReviewDownloadButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTableTrValid", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("ReviewTableEstDateInVisible", 1);
		List<String> tabledata = CommonMethod.fetchTableData("PortfolioReviewTable");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(3), CommonMethod.ValidateDate(),
				"Review Return Submit Date Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(4), CommonMethod.ValidateDate(),
				"Review Return Estimated Date Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(5), "", "Review Return Error Mismatch");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListViewButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioReviewListViewButton", "PortfolioReturnReview");
		testlog.info("Then User clicks on view button");
		CommonMethod.WaitUntilVisibility("PortfolioReturnReview", 60);
		CommonMethod.RobustclickElementVisible("PortfolioReturnReview", "PortfolioScoreCardVerificationUpload");
		CommonMethod.uploadMultipleFile("PortfolioScoreCardVerificationUpload", SampleJpgfile, SampleJpgfile,
				"MultipeUploadDeleteicon", 2, "MultipeUploadEnableButtonDeleteLink");
		testlog.info("And User clicks on Return button");
		testlog.info("And User Upload Review Document");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Preliminary Precertification Review");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		testlog.info("And User select Review Date");
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitResponse", "PortfolioReviewStatus");
		CommonMethod.WaitUntilVisibility("PortfolioReviewStatus", 60);
		testlog.info("Then User verifies Reviewed Status");
		testlog.pass("**Completed Reviewed Preliminary Precertification Review successfully**");
	}

	public void registerFieldValidationInEditTab(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "PortfolioEditAccounttab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditAccounttab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioEditAccounttab", "PortfolioEditAccountName");
		CommonMethod.WaitUntilVisibility("PortfolioEditAccountName", 30);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioEditAccountName"),
				data.getCellData(SheetName, "AccountName", rowNum), "Portfolio Project Name doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditApproximatelyLoc", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioEditApproximatelyLoc"),
				data.getCellData(SheetName, "Location", rowNum), "Portfolio Approximately Location doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditLocationSubscribing", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioEditLocationSubscribing"),
				data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum),
				"Portfolio Location Subscribing doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditAreaSqft", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValue("PortfolioEditAreaSqft").replace("sq ft", "").replace(",", "").trim(),
				data.getCellData(SheetName, "AreaSQFT", rowNum), "Portfolio AreaSqft doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OrgName", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("OrgName"),
				data.getCellData(SheetName, "OrgName", rowNum), "Portfolio Organization Name doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditOrganizationIndustry", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getSelectedDropdownValue("PortfolioEditOrganizationIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "Portfolio OrganizationIndustry doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditCountry", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("PortfolioEditCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Portfolio Country doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditState", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("PortfolioEditState"),
				data.getCellData(SheetName, "State", rowNum), "Portfolio State doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditStreetAddress", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioEditStreetAddress"),
				data.getCellData(SheetName, "Street", rowNum), "Portfolio StreetAddress doesn't match");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioEditCity"),
				data.getCellData(SheetName, "City", rowNum), "Portfolio City doesn't match");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioEditPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Portfolio postal code matched with excel");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditOrganizationOverview", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioEditOrganizationOverview"),
				data.getCellData(SheetName, "Overview", rowNum), "Portfolio OrganizationOverview doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditOwnerName", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioEditOwnerName"),
				data.getCellData(SheetName, "OwnerName", rowNum), "Portfolio OwnerName doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditOwnerEmail", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioEditOwnerEmail"),
				data.getCellData(SheetName, "OwnerEmail", rowNum), "Portfolio OwnerEmail doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditOwnerPhone", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioEditOwnerPhone"),
				data.getCellData(SheetName, "OwnerPhone", rowNum), "Portfolio OwnerPhone doesn't match");
		testlog.info("Then User verifies the added Project and Owner details");
		testlog.pass("**Register Field Validation successfully**");
	}

	public void editAndValidateAccountInformationPortfolio(String SheetName, int rowNum, String ProjectType)
			throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "PortfolioAccountInformation");
		CommonMethod.WaitUntilVisibility("PortfolioAccountInformation", 60);
		CommonMethod.RobustclickElementVisible("PortfolioAccountInformation", "PortfolioGoal");
		CommonMethod.WaitUntilVisibility("PortfolioAccountNameEdit", 60);
		CommonMethod.clearAndSendKey("PortfolioAccountNameEdit", data.getCellData(SheetName, "AccountName", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioGoal", 60);
		CommonMethod.sendKeys("PortfolioGoal", data.getCellData(SheetName, "Goals", rowNum));
		CommonMethod.WaitUntilVisibility("PortfolioScope", 60);
		CommonMethod.sendKeys("PortfolioScope", data.getCellData(SheetName, "Scope", rowNum));
		CommonMethod.WaitUntilPresence("PortfolioSaveButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioSaveButton", "WellV2DashboardTab");
		testlog.info("**Project Information data updated successfully**");
		/*
		 * Validate updated account information fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "PortfolioAccountInformation");
		CommonMethod.WaitUntilVisibility("PortfolioAccountInformation", 60);

		CommonMethod.RobustclickElementVisible("PortfolioAccountInformation", "PortfolioGoal");
		Thread.sleep(3000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioGoal", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioGoal"),
				data.getCellData(SheetName, "Goals", rowNum), "Goals data doesn't match");
		testlog.info("**Goals data updated successfully**");
		CommonMethod.WaitUntilVisibility("PortfolioScope", 60);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioScope"),
				data.getCellData(SheetName, "Scope", rowNum), "Scope data doesn't match");
		testlog.pass("**Verifies Project Information data updated successfully**");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectEnterpriseProviders", 0);
		if (ProjectType.contains("pilot")) {
			CommonMethod.negativesoftassertFieldValid(
					CommonMethod.getSelectedDropdownValue("V2ProjectEnterpriseProviders"),
					"En3 Sustainability Solutions", "EnterpriseProvidersName Mismatch");
		} else {
			CommonMethod.negativesoftassertFieldValid(
					CommonMethod.getSelectedDropdownValue("V2ProjectEnterpriseProviders"),
					data.getCellData(SheetName, "EnterpriseProvidersName", rowNum), "EnterpriseProvidersName Mismatch");
		}
	}

	public void editAndValidateAdmin(String SheetName, int rowNum) throws Exception {
		AdminSearch(SheetName, rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "PortfolioCoachingContacts");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCoachingContacts", 0);
		testlog.info("Coaching Contacts: " + data.getCellData(SheetName, "CoachingContacts", rowNum));
		CommonMethod.selectdropdownVisibletext("PortfolioCoachingContacts",
				data.getCellData(SheetName, "CoachingContacts", rowNum));
		CommonMethod.clearAndSendKey("PortfolioChallengesNotes", data.getCellData(SheetName, "ChallengeNote", rowNum));
		CommonMethod.clearAndSendKey("PortfolioCommunicationNotes",
				data.getCellData(SheetName, "CommunicationNotes", rowNum));
		CommonMethod.uploadMultipleFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload, FeaturefileUpload,
				"MultipeUploadDeleteicon", 2, "MultipeUploadEnableButtonDeleteLink");
		CommonMethod.clearAndSendKey("PortfolioAccountNotes", data.getCellData(SheetName, "AccountNotes", rowNum));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSaveButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioSaveButton", "WellV2DashboardTab");
		testlog.pass("**Admin data updated successfully**");
		/*
		 * Validate updated admin fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "PortfolioCoachingContacts");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCoachingContacts", 0);
		CommonMethod.negativesoftassertFieldValidEquals(
				CommonMethod.getSelectedDropdownValue("PortfolioCoachingContacts"),
				data.getCellData(SheetName, "CoachingContacts", rowNum), "Coaching contacts value doesn't match");
		testlog.info("**Coaching contacts updated successfully**");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getattributeValue("PortfolioChallengesNotes"),
				data.getCellData(SheetName, "ChallengeNote", rowNum), "Challenges notes value doesn't match");
		testlog.info("**Challenges notes value updated successfully**");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getattributeValue("PortfolioCommunicationNotes"),
				data.getCellData(SheetName, "CommunicationNotes", rowNum), "Communication notes value doesn't match");
		testlog.info("**Communication notes value updated successfully**");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getattributeValue("PortfolioAccountNotes"),
				data.getCellData(SheetName, "AccountNotes", rowNum), "Account notes value doesn't match");
		testlog.pass("**Verifies Admin fields updated successfully**");
	}

	public void teamPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddMemberbtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAddMemberbtn", "PortfolioEmailAddress");
		testlog.info("And User clicks on Add member button");
		String TeamEmail = data.getCellData(SheetName, "TeamMemberEmail", rowNum);
		System.out.println("TeamEmail: "+TeamEmail);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEmailAddress", 0);
		CommonMethod.sendKeys("PortfolioEmailAddress", TeamEmail);
		testlog.info("And User enter email id field");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioRole", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioRole", "Acoustician");
		testlog.info("And User select the Role");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectMembercbx", 0);
		CommonMethod.ClickCheckbox("V2ProjectMembercbx");
		testlog.info("And User checks the Member checkbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectInvitebtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn", "V2ProjectAddMemberbtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("TeamMemberDeleteButton", 1);
		CommonMethod.assertisElementPresentTrue("TeamMemberDeleteButton",
				"Delete icon is not visible");
		testlog.info("And User clicks on Invite button");
		testlog.info("Then User will be redirected to Team list page");
		testlog.pass("**Created Team member successfully**");
	}

	public void deleteAddedTeamMemberPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();
		testlog.info("Given User is on Team model page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDeleteIcon", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectDeleteIcon", "V2ProjectAddMemberbtn");
		testlog.info("When User clicks on Delete Icon");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddMemberbtn", 0);
		testlog.info("Then User will be redirected to Team list page");
	}

	public void validateTeamsPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WellAtScaleNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioSearchByID");
		testlog.info("Portfolio Name:" + data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("Portfolio ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("PortfolioSearchApplyFilter", "V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "1", "Portfolio Search failed");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("PortfolioIDVerify"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with exceles in search");
		testlog.info("And User verifies user able to access the invited project");
		testlog.pass("**Verifies user able to access the invited project**");
	}

	public void clickOnTeamPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TeamTab", 0);
		CommonMethod.RobustclickElementVisible("TeamTab", "V2ProjectAddMemberbtn");
		testlog.info("When User clicks on TeamTab");
	}

	public void verifyScoreCardOptionFilter(String filterName, String expectedResult)
			throws IOException, InterruptedException {
		if (filterName.equalsIgnoreCase("Response")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardResponseFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardResponseFilter", "V2ProjectScorecardYesFilter");
			testlog.info("And User select the Response Filter");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardYesFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardYesFilter", "V2ProjectScorecardYesFilter");
			testlog.info("And User check the Yes Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "V2ProjectScorecardResponseFilter");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Response Feature Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Response Option Scorecard filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardResponseFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardResponseFilter", "V2ProjectScorecardYesFilter");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardClearbutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}
		if (filterName.equalsIgnoreCase("Verification")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardVerificationFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
					"V2ProjectScorecardOnsitePhotographsFilter");
			testlog.info("And User select on Verification Filter");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardOnsitePhotographsFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardOnsitePhotographsFilter",
					"V2ProjectScorecardApplybutton");
			testlog.info("And User check OnsitePhotographs checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "V2ProjectScorecardResponseFilter");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 1);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Verification Feature Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Verification Option Scorecard Filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardVerificationFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
					"V2ProjectScorecardPartTypeFilter");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardClearbutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}
		if (filterName.equalsIgnoreCase("Document Scale")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardDocumentScaleFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentScaleFilter",
					"PortfolioIndividualFilter");
			testlog.info("And User select Document Scale Filter option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioIndividualFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioIndividualFilter", "V2ProjectScorecardApplybutton");
			testlog.info("And User check on Individual Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "ScorecardFeatureLoading");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Document Scale Feature Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Document Scale Option Scorecard Filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardDocumentScaleFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentScaleFilter",
					"V2ProjectScorecardApplybutton");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardClearbutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}
		if (filterName.equalsIgnoreCase("Part type")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPartTypeFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardPartTypeFilter",
					"V2ProjectScorecardPreconditionsFilter");
			testlog.info("And User select Part type Filter option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPreconditionsFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardPreconditionsFilter",
					"V2ProjectScorecardApplybutton");
			testlog.info("And User check on Preconditions Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton",
					"V2ProjectScorecardPartTypePartCount");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Part type Feature Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Part type Option Scorecard Filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPartTypeFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardPartTypeFilter",
					"V2ProjectScorecardPrioritiesFilter");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardClearbutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}
		if (filterName.equalsIgnoreCase("Priorities")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPrioritiesFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardPrioritiesFilter",
					"V2ProjectScorecardSustainabilityFilter");
			testlog.info("And User select Priorities Filter option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardSustainabilityFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardSustainabilityFilter",
					"V2ProjectScorecardApplybutton");
			testlog.info("And User check on Sustainability Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "ScorecardFeatureLoading");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Priorities Feature Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Priorities Option Scorecard Filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardPrioritiesFilter", 120);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardPrioritiesFilter",
					"V2ProjectScorecardApplybutton");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardClearbutton", 120);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}
		if (filterName.equalsIgnoreCase("Space Type")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardSpaceTypeFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardSpaceTypeFilter",
					"V2ProjectScorecardCommercialKitchenSpacesFilter");
			testlog.info("And User select the Space Type option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardCommercialKitchenSpacesFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardCommercialKitchenSpacesFilter",
					"V2ProjectScorecardApplybutton");
			testlog.info("And User check on Commercial Kitchen Spaces Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "ScorecardFeatureLoading");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Space Type Feature Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Space Type Option Scorecard Filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardSpaceTypeFilter", 120);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardSpaceTypeFilter",
					"V2ProjectScorecardApplybutton");
			CommonMethod.WaitUntilPresence("V2ProjectScorecardClearbutton", 120);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}
		if (filterName.equalsIgnoreCase("Ratings")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardRatingsFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardRatingsFilter",
					"V2ProjectScorecardWELLHealthSafetyFilter");
			testlog.info("And User select the Ratings option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardWELLHealthSafetyFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardWELLHealthSafetyFilter",
					"V2ProjectScorecardApplybutton");
			testlog.info("And User check on HealthSafety Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "ScorecardFeatureLoading");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Ratings Feature Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Ratings Option Scorecard Filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardRatingsFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardRatingsFilter", "V2ProjectScorecardApplybutton");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardClearbutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}
		if (filterName.equalsIgnoreCase("Strategy Type")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardStrategyTypeFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardStrategyTypeFilter",
					"V2ProjectScorecardPerformanceFilter");
			testlog.info("And User select the Strategy Type option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPerformanceFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardPerformanceFilter",
					"V2ProjectScorecardApplybutton");
			testlog.info("And User check on Performance Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "ScorecardFeatureLoading");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Strategy Type Feature Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Strategy Type Option Scorecard filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardStrategyTypeFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardStrategyTypeFilter",
					"V2ProjectScorecardApplybutton");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPartCount", 0);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardClearbutton", 120);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}
		if (filterName.equalsIgnoreCase("Cross walk")) {
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardCrosswalkFilter", "V2ProjectScorecardLEEDFilter");
			testlog.info("And User select the Cross walk option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardLEEDFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardLEEDFilter", "V2ProjectScorecardApplybutton");
			testlog.info("And User check on LEED Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.WaitUntilPresence("V2ProjectScorecardApplybutton", 120);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "ScorecardFeatureLoading");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Cross walk Feature Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Cross walk Option Scorecard doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardCrosswalkFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardCrosswalkFilter",
					"V2ProjectScorecardApplybutton");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardClearbutton", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardClearbutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}
		if (filterName.equalsIgnoreCase("Responsible Party")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardResponsiblePartyFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardResponsiblePartyFilter",
					"V2ProjectScorecardFacilityManagerFilter");
			testlog.info("And User select the Responsible Party option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardFacilityManagerFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardFacilityManagerFilter",
					"V2ProjectScorecardApplybutton");
			testlog.info("And User check on FacilityManager Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "ScorecardFeatureLoading");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Responsible Party Feature Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Responsible Party Option Scorecard filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardResponsiblePartyFilter", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardResponsiblePartyFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardResponsiblePartyFilter",
					"V2ProjectScorecardApplybutton");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardClearbutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}

		if (filterName.equalsIgnoreCase("Sustainable Development Goals")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardSustainableFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardSustainableFilter",
					"PortfolioPovertyCheckboxFilter");
			testlog.info("And User select the Sustainable Development Goals option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioPovertyCheckboxFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioPovertyCheckboxFilter", "V2ProjectScorecardApplybutton");
			testlog.info("And User check on Poverty Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton",
					"PortfolioScorecardFeatureSustainable");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("Sustainable Development Goals Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"Sustainable Development Goals Option Scorecard filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardSustainableFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardSustainableFilter",
					"V2ProjectScorecardApplybutton");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardClearbutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}

		if (filterName.equalsIgnoreCase("GRESB Assessment")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardGresbFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardGresbFilter", "PortfolioManagementFilter");
			testlog.info("And User select the GRESB Assessment option");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioManagementFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioManagementFilter", "V2ProjectScorecardApplybutton");
			testlog.info("And User check on Management Filter checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardApplybutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardApplybutton", "ScorecardFeatureLoading");
			testlog.info("And User clicks on Apply button");
			if (CommonMethod.isElementsExist("ScorecardFeatureLoading", 20)) {
				CommonMethod.WaitUntilInVisibility("ScorecardFeatureLoading", Scorecardtimeout);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTable", 2);
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectScorecardPartCount",
					Integer.parseInt(expectedResult));
			int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
			String actualYesFeatureCount = Integer.toString(YesFeature);
			testlog.info("GRESB Assessment Goals Count: " + actualYesFeatureCount);
			CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
					"GRESB Assessment Goals Option Scorecard filter doesn't match");
			testlog.info("Then User verifies Feature Part Count");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardGresbFilter", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardGresbFilter", "V2ProjectScorecardApplybutton");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardClearbutton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardClearbutton", "V2ProjectScoreCardFilterOption");
			testlog.info("And User clicks on Clear button");
		}
	}

	public void searchFilterScoreCard() throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardSearchBox", 0);
		CommonMethod.sendKeys("V2ProjectScoreCardSearchBox", "Meet Thresholds for Particulate Matter");
		testlog.info("When User enter data to SearchBox field");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScoreCardOptionValue"),
				"Meet Thresholds for Particulate Matter","Search Feature name doesn't match");
		CommonMethod.negativesoftassertFieldValidEquals(Integer.toString(CommonMethod.ElementSize("PortfolioScoreCardOptionValue")), "1",
				"Search Feature Count doesn't match");
		testlog.info("Then User will be redirected to Scorecard page");
		testlog.info("And User verifies Feature Part Count");
		testlog.pass("**Verifies Scorecard Search filter successfully**");
	}

	public void scorecardOptionFilterPortfolio() throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardRefreshButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardRefreshButton", "V2ProjectScoreCardFilterButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardFilterButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
		testlog.info("And User clicks on Filter button");
		verifyScoreCardOptionFilter("GRESB Assessment", "38");
		verifyScoreCardOptionFilter("Sustainable Development Goals", "8");
		verifyScoreCardOptionFilter("Responsible Party", "30");
		if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_09_01_ValidateScoreOptionFilter")) {
			verifyScoreCardOptionFilter("Response", "227");
		}
		else {
			verifyScoreCardOptionFilter("Response", "5");
		}
		verifyScoreCardOptionFilter("Verification", "39");
		verifyScoreCardOptionFilter("Document Scale", "37");
		verifyScoreCardOptionFilter("Part type", "48");
		verifyScoreCardOptionFilter("Priorities", "34");
		verifyScoreCardOptionFilter("Space Type", "217");
		verifyScoreCardOptionFilter("Ratings", "27");
		verifyScoreCardOptionFilter("Strategy Type", "18");
		verifyScoreCardOptionFilter("Cross walk", "21");
		softAssert.assertAll();
		testlog.pass("**All Scorecard filter options successfully**");
	}

	public void SearchPortfolioBySubcribedStatus(String SheetName, int rowNum, String Status)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WellAtScaleNavBar");
		CommonMethod.RobustclickElementVisible("WellAtScaleNavBar", "PortfolioSearchByID");
		testlog.info("When User clicks on WellAtScaleNavBar from top menu under Projects");
		testlog.info("Portfolio Name:" + data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("Portfolio ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		/*
		 * ProjectID
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSearchByID", 0);
		CommonMethod.clearAndSendKey("PortfolioSearchByID", data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enter data to PortfolioId");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSearchApplyFilter", 0);
		CommonMethod.RobustclickElementVisible("PortfolioSearchApplyFilter", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectSearchResultIDVerify", 1);
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(CommonMethod.ElementSize("V2ProjectSearchResultIDVerify")), "1", "Portfolio Search failed");
			
		/*
		 * AccountName
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSearchByName", 0);
		CommonMethod.clearAndSendKey("PortfolioSearchByName", data.getCellData(SheetName, "AccountName", rowNum));
		testlog.info("And User enter data to PortfolioName");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSearchApplyFilter", 0);
		CommonMethod.RobustclickElementVisible("PortfolioSearchApplyFilter", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		 CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectSearchResultIDVerify", 1);
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(CommonMethod.ElementSize("V2ProjectSearchResultIDVerify")), "1", "Portfolio Search failed");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("PortfolioNameVerify"),
				data.getCellData(SheetName, "AccountName", rowNum),
				"Portfolio ID doesn't matched with exceles in search");
		/*
		 * OrgName
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioOrganizationList", 0);
		CommonMethod.clearAndSendKey("PortfolioOrganizationList", data.getCellData(SheetName, "OrgName", rowNum));
		testlog.info("And User enter data to OrgName");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSearchApplyFilter", 0);
		CommonMethod.RobustclickElementVisible("PortfolioSearchApplyFilter", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("PortfolioOrgNameResultList"),
				data.getCellData(SheetName, "OrgName", rowNum), "Portfolio Search failed");
		/*
		 * Status
		 */
		if (Status.equalsIgnoreCase("SUBSCRIBED") || Status.equalsIgnoreCase("NOT SUBSCRIBED")) {
			CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("PortfolioStatusResultList"), Status,
					"Portfolio Search failed");
		}
		if (Status.equalsIgnoreCase("IN PROGRESS")) {
			CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("PortfolioSubInProgressResultList"), Status,
					"Portfolio Search failed");
		}
		 CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectSearchResultIDVerify", 1);
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(CommonMethod.ElementSize("V2ProjectSearchResultIDVerify")), "1", "Portfolio Search failed");
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("PortfolioIDVerify"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with exceles in search");
		testlog.info("And User verifies the Portfolio ID in Search Filter");
		testlog.info("And User verifies the Portfolio Name in Search Filter");
		testlog.info("And User verifies the OrgName in Search Filter");
		testlog.info("And User verifies the Status in Search Filter");
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify", "WellV2DashboardTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		testlog.pass("**Verifies the Search Portfolio Name successfully**");
	}

	public void ValidDashboardPortfolioField(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		testlog.info("Then User will be redirected to Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.WaitUntilPresence("PortfolioClickSignNow", 30);
		CommonMethod.WaitUntilPresence("SubscribeTab", 30);
		CommonMethod.WaitUntilPresence("ResourcesTab", 30);
		CommonMethod.WaitUntilPresence("BiilingTab", 30);
		CommonMethod.WaitUntilPresence("TeamTab", 30);
		CommonMethod.WaitUntilPresence("EditTab", 30);
		CommonMethod.assertisNotElementPresent("LocationsTab", "LocationsTab element is Present");
		CommonMethod.assertisNotElementPresent("WellV2Tab", "WellV2Tab element is Present");
		CommonMethod.assertisNotElementPresent("ReviewTab", "ReviewTab element is Present");
		CommonMethod.assertisNotElementPresent("HealthSafetyTab", "HealthSafetyTab element is Present");
		CommonMethod.assertisNotElementPresent("PerformanceTab", "PerformanceTab element is Present");
		CommonMethod.assertisNotElementPresent("EquityTab", "EquityTab element is Present");
		CommonMethod.assertisNotElementPresent("ProfileTab", "ProfileTab element is Present");
		CommonMethod.assertisNotElementPresent("AlternativesTab", "AlternativesTab element is Present");
		softAssert.assertAll();
		testlog.info("And User verifies Dashboard fields and SideBar Navigation tab");
		testlog.pass("**Verifies Dashboard fields and SideBar Navigation tab successfully **");
	}

	public void ValidDashboardEnrollPortfolioField(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		testlog.info("Then User will be redirected to Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.WaitUntilPresence("ResourcesTab", 30);
		CommonMethod.WaitUntilPresence("BiilingTab", 30);
		CommonMethod.WaitUntilPresence("TeamTab", 30);
		CommonMethod.WaitUntilPresence("EditTab", 30);
		CommonMethod.assertisNotElementPresent("PortfolioClickSignNow", "LocationsTab element is Present");
		CommonMethod.assertisNotElementPresent("SubscribeTab", "LocationsTab element is Present");
		CommonMethod.assertisNotElementPresent("LocationsTab", "LocationsTab element is Present");
		CommonMethod.assertisNotElementPresent("WellV2Tab", "WellV2Tab element is Present");
		CommonMethod.assertisNotElementPresent("ReviewTab", "ReviewTab element is Present");
		CommonMethod.assertisNotElementPresent("HealthSafetyTab", "HealthSafetyTab element is Present");
		CommonMethod.assertisNotElementPresent("PerformanceTab", "PerformanceTab element is Present");
		CommonMethod.assertisNotElementPresent("EquityTab", "EquityTab element is Present");
		CommonMethod.assertisNotElementPresent("ProfileTab", "ProfileTab element is Present");
		CommonMethod.assertisNotElementPresent("AlternativesTab", "AlternativesTab element is Present");
		softAssert.assertAll();
		testlog.info("And User verifies Dashboard fields and SideBar Navigation tab");
		testlog.pass("**Verifies Dashboard fields and SideBar Navigation tab successfully **");
	}

	public void ValidDashboardAfterBillingPortfolioField(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		testlog.info("Then User will be redirected to Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.WaitUntilPresence("ResourcesTab", 30);
		CommonMethod.WaitUntilPresence("BiilingTab", 30);
		CommonMethod.WaitUntilPresence("TeamTab", 30);
		CommonMethod.WaitUntilPresence("LocationsTab", 30);
		CommonMethod.WaitUntilPresence("EditTab", 30);
		CommonMethod.WaitUntilPresence("WellV2Tab", 60);
		CommonMethod.WaitUntilPresence("ReviewTab", 30);
		CommonMethod.WaitUntilPresence("HealthSafetyTab", 30);
		CommonMethod.WaitUntilPresence("PerformanceTab", 30);
		CommonMethod.WaitUntilPresence("EquityTab", 30);
		CommonMethod.WaitUntilPresence("ProfileTab", 30);
		CommonMethod.WaitUntilPresence("AlternativesTab", 30);
		CommonMethod.assertisNotElementPresent("PortfolioClickSignNow", "PortfolioClickSignNow element is Present");
		CommonMethod.assertisNotElementPresent("SubscribeTab", "SubscribeTab element is Present");
		softAssert.assertAll();
		testlog.info("And User verifies Dashboard fields and SideBar Navigation tab");
		testlog.pass("**Verifies Dashboard fields and SideBar Navigation tab successfully **");
	}

	public void ResorceCardValidation(String SheetName, int rowNum, String cardValue) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ResourcesTab", 0);
		CommonMethod.RobustclickElementVisible("ResourcesTab", "PromotionCardContainer");
		testlog.info("When User clicks on ResourcesTab");
		rc.ValidCardCount("PromotionCardContainer");
		testlog.info("Then User will be redirected to Resources page");
		testlog.info("And User verifies Card Count in Resources page");
		testlog.pass("**Verify card count successfully**");

	}

	public void uploadDocumentInFeature(int LastFeatureNumber, String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeatureName", 0);
		Feature = CommonMethod.findElements("PortfolioScoreCardFeatureName");
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("V2ProjectWPRScorecardLanding");
		for (WebElement f : Feature) {
			String Creditname = f.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			CommonMethod.WaitUntilClickble(f, 180);
			CommonMethod.JavascriptClickElement(f);
			testlog.info("When Click on " + Creditname + " feature");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
					"PortfolioScoreCardAddOptionbutton");
			testlog.info("And User clicks on VerificationTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
			CommonMethod.JavascriptClickElement("PortfolioScoreCardAddOptionbutton");
			testlog.info("And User clicks on AddOption button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddButton", 0);
			CommonMethod.Robustclick("PortfolioScoreCardAddButton");
			testlog.info("And User clicks on Add Button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
			CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
			testlog.info("And User clicks on Closeicon");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocbtn", 0);
			Thread.sleep(1000);
			generic.assignLocationGeneric(Commodity, false, false, true, false, false);
			testlog.info("And User clicks on Assign button");
			testlog.info("And User checks on Assign location");
			testlog.info("And User clicks on Save button");
			CommonMethod.scrolldowntoLast();
			Thread.sleep(2000);
			List<WebElement> UploadButton;
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
			UploadButton = CommonMethod.findElements("PortfolioScoreCardVerificationUploadbtn");
			for (WebElement uploadButton : UploadButton) {
				CommonMethod.JavascriptClickElement(uploadButton);
				CommonMethod.scrolldowntoLast();
				CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", AuditfileUpload,
						"UploadFileVerifyScorecard");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadDocbtn", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadDocbtn",
						"PortfolioScoreCardVerificationAddNote");

				if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
					CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 180);
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
			}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardDocumentCompleteAllGreenCircleValid", 0);
			int GreenCircleValid = CommonMethod.ElementSize("PortfolioScorecardDocumentCompleteAllGreenCircleValid");
			testlog.info("And User clicks on Upload button");
			testlog.info("And User upload Scorecard Document");
			testlog.info("And User clicks on Save button");
			testlog.info("Then User verifies Document Upload toast message");
			testlog.info("And User verifies Upload Document Table");
			testlog.info("And User verifies Task Completed " + GreenCircleValid + " GreenCircleValid");
			CommonMethod.scrolldowntoElement("V2ProjectWPRScorecardLanding");
			CommonMethod.JavascriptClickElement(f);
		}
	}

	@SuppressWarnings("unchecked")
	public static String PostRequestAuthenticate(String colName, int rowNum) {
		/*
		 * Get Token by authentication
		 */
		String username = data.getCellData("Login", colName, rowNum);
		JSONObject param = new JSONObject();
		param.put("email", username);
		param.put("password", data.getCellData("Login", "Password", rowNum));
		System.out.println(param.toString());
		Response res = given().log().all().accept("application/json").contentType("application/json").body(param).when()
				.post("authenticate");
		System.out.println(res.asString());
		String admin_Header = (res.path("token")).toString();
		admin_Header = "Bearer " + admin_Header;
		return admin_Header;
	}

	public void ValidateAddedLocationFields(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("WELLCertificationNavBar", "V2ProjectId");
		CommonMethod.WaitUntilClickble("V2ProjectId", 60);
		System.out.println("LocationProjectID:" + data.getCellData(SheetName, "LocationProjectID", rowNum));
		testlog.info("LocationProjectID:" + data.getCellData(SheetName, "LocationProjectID", rowNum));
		CommonMethod.sendKeys("V2ProjectId", data.getCellData(SheetName, "LocationProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("V2ProjectApplybtn", "V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var), "1", "V2 Search failed");
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "LocationProjectID", rowNum), "Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("V2ProjectIdCompare", "V2ProjectStartBuilding");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 300);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.Robustclick("EditTab", "V2ProjectOwnerInformationButton");

	}

	public void ValidateEditProjectInformation(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectUpdateProjectsName"),
				data.getCellData(SheetName, "LocationName", rowNum), "Update ProjectName Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectUpdateProjectsarea"),
				data.getCellData(SheetName, "AreaSQFT", rowNum), "Update Area Error Mismatch");
		CommonMethod.VerifyRadioOrCheckboxSelcted("V2ProjectEditconstructionbuilding");
		CommonMethod.VerifyRadioOrCheckboxSelcted("V2ProjectEditpublicprojectyes");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccProjectNameDisable", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioAccProjectNameDisable", "ProjectName is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioAccProjectAreaDisable", "Project Area is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioAccexistingDisableCheckbox",
				"existingDisableCheckbox is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioAccNonCsDisableCheckbox", "NonCsDisableCheckbox is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioAccCicsDisableCheckbox", "CicsDisableCheckbox is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioAccCsDisableCheckbox", "CsDisableCheckbox is enabled");
		testlog.pass("**Project goals data updated successfully**");
	}

	public void ValidateEditOwnerInformation(String SheetName, int rowNum) throws IOException, InterruptedException {

		/*
		 * Validate updated owner information fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectOwnerInformationButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectOwnerInformationButton", "V2ProjectOrganizationIndustry");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("OwnerOrgClick"),
				data.getCellData(SheetName, "OrgName", rowNum), "Updated OrgName Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectUpdatesOwnername"),
				data.getCellData(SheetName, "OwnerName", rowNum), "Updated OwnerName Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectUpdatesOwneremail"),
				data.getCellData(SheetName, "OwnerEmail", rowNum), "Updated OwnerEmail Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValue("V2ProjectUpdatesOrganizationIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "Updated OrgIndustry Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getSelectedDropdownValue("V2ProjectUpdatesCountryRegion"),
				data.getCellData(SheetName, "Country", rowNum), "Updated Country Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectUpdatesStreetaddress"),
				data.getCellData(SheetName, "Street", rowNum), "Updated OwnerStreet Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectUpdatesLocationCity"),
				data.getCellData(SheetName, "City", rowNum), "Updated OwnerCity Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectUpdatesPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Updated OwnerPostalCode Error Mismatch");
		testlog.pass("**Verifies Information data updated successfully**");
	}

	public void ValidateEditAddress(String SheetName, int rowNum) throws IOException, InterruptedException {

		/*
		 * Validate updated address fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddressButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAddressButton", "V2ProjectUpdatesPACountryRegion");
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getSelectedDropdownValue("V2ProjectEditProjectAddCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Address Updated Country Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectEditProjectAddStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Address Updated Street Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectEditProjectAddCity"),
				data.getCellData(SheetName, "City", rowNum), "Address Updated City Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectEditProjectAddPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Address Updated PostalCode Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValue("V2ProjectUpdatesBABillingOrganization"),
				data.getCellData(SheetName, "OrgName", rowNum), "Updated OrgName Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getSelectedDropdownValue("V2ProjectEditBillingAddCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Billing Address Updated Country Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectEditBillingAddStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Billing Address Updated Street Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectEditBillingAddCity"),
				data.getCellData(SheetName, "City", rowNum), "Billing Address OwnerCity Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectEditBillingAddPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Billing Address OwnerPostalCode Error Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccEditProjectAddCountry", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioAccEditProjectAddCountry", "Country is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioAccEditProjectAddState", "State is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioAccEditProjectAddStreet", "Street is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioAccEditProjectAddCity", "City is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioAccEditProjectAddPostalCode", "PostalCode is enabled");
		testlog.pass("**Verifies Address data updated successfully**");
	}

	public void ValidateEditAdmin(String SheetName, int rowNum) throws IOException, InterruptedException, ClientApiException {

		/*
		 * Validate updated admin fields
		 */
		login.AdminLogin();
		AdminSearch(SheetName, rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "V2projectAdminBillingStatus");
		CommonMethod.VerifyRadioOrCheckboxSelcted("V2ProjectEditOpenRadioButton");
		CommonMethod.VerifyRadioOrCheckboxSelcted("V2ProjectEditTestProjectYesRadioButton");
		testlog.pass("**Verifies Admin data updated successfully**");
	}

	public void ValidateAddedLocationAdditionalFields(String SheetName, int rowNum)
			throws IOException, InterruptedException {

		/*
		 * Validate location Owner fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationOwnerButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationOwnerButton", "PortfolioLocationOwnerName");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioLocationOwnerName"),
				data.getCellData(SheetName, "OwnerName", rowNum), "Owner Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioLocationOwnerEmail"),
				data.getCellData(SheetName, "OwnerEmail", rowNum), "Owner Email Id Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioLocationOwnerOrg"),
				data.getCellData(SheetName, "OrgName", rowNum), "Owner Org Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getSelectedDropdownValue("PortfolioLocationOwnerCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Owner Country Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioLocationOwnerState"),
				data.getCellData(SheetName, "State", rowNum), "Owner State Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioLocationOwnerStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Owner Street Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioLocationOwnerCity"),
				data.getCellData(SheetName, "City", rowNum), "Owner City Name Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioLocationOwnerPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "Owner Postal Code Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioLocationOwnerOrgIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "Owner Org Industry Error Mismatch");
		testlog.pass("**Validate location Owner fields successfully**");
	}

	public void ValidateAddedLocationOwnerFields(String SheetName, int rowNum)
			throws IOException, InterruptedException {

		/*
		 * Validate location Owner fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationOwnerButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationOwnerButton", "PortfolioLocationOwnerOrgIndustry");
		CommonMethod.VerifyRadioOrCheckboxSelcted("V2ProjectEditconstructionbuilding");
		testlog.pass("**Validate location Owner fields successfully**");
	}

	public void ValidateAddedLocationAdditionalField(String SheetName, int rowNum)
			throws IOException, InterruptedException {

		/*
		 * Validate location Additional fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAdditionalButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationAdditionalButton",
				"PortfolioLocationRadiobuttonContainOutdoorSpaces");
		CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioLocationConstruction");
		CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioLocationCommercialDining");
		CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioLocationRadiobuttonContainOutdoor");
		CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioLocationRetailSpaces");
		testlog.pass("**Validate location Additinal fields successfully**");
	}

	public void AdminSearch(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * Admin Review
		 */
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLAtScaleNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminWELLAtScaleNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminWELLAtScaleNavBar", "PortfolioSearchByID");
		testlog.info("When User clicks on WELL AtScaleNavBar from top menu under Projects");
		CommonMethod.WaitUntilClickble("PortfolioSearchByID", 60)
				.sendKeys(data.getCellData(SheetName, "ProjectID", rowNum));
		testlog.info("And User enter data to PortfolioId");
		CommonMethod.RobustclickElementVisible("PortfolioAdminApplybtn", "PortfolioIDVerify");
		testlog.info("And User clicks on Apply button");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("PortfolioIDVerify"), data.getCellData(SheetName, "ProjectID", rowNum),
				"Portfolio ID doesn't matched with excel in search");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("PortfolioIDVerify", "ReviewTab");
		testlog.info("And User clicks on PortfolioAdminId");
	}

	public void SingleEditlocation(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on location tab");
		CommonMethod.WaitUntilNumberOfElementToBePresent("LocationListTable", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Overviewtab", 0);
		CommonMethod.RobustclickElementVisible("Overviewtab", "table");
		testlog.info("And User clicks on overview tab");
		CommonMethod.WaitUntilNumberOfElementToBePresent("LocationListTable", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Editlocationbutton", 0);
		CommonMethod.RobustclickElementVisible("Editlocationbutton", "VerifyEditlocationslider");
		Thread.sleep(3000);
		testlog.info("And User clicks on edit location button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationSpaceType", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioLocationSpaceType", "Office Spaces");
		testlog.info("when User update space type as Office spaces");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationOwnershipDisable", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioLocationOwnershipDisable", "Ownership is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioLocationCountryDisable", "Country is enabled");
		CommonMethod.assertisElementPresentTrue("PortfolioLocationStateDisable", "State is enabled");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAdditionalButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationAdditionalButton",
				"TargetAchievementEditCertficationLeveldropdown");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditCertficationLeveldropdown", 0);
		CommonMethod.selectdropdownIndex("TargetAchievementEditCertficationLeveldropdown", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UpdateButton", 0);
		CommonMethod.Robustclick("UpdateButton", "PortfolioLocationSpaceType");
		testlog.info("then User clicks on update button");
		if (CommonMethod.isElementsExist("Toastermessage", 15)) {
			CommonMethod.WaitUntilInVisibility("Toastermessage", 60);
		}
	}

	public void EditMultipleLocation(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on location tab");
		/*
		 * Edit multiple location
		 */
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTable", 0);
		CommonMethod.WaitUntilPresence("MultieditButton", 60);
		CommonMethod.RobustclickElementVisible("MultieditButton", "locationCheckbox");
		testlog.info("then User clicks Multiselect location button");
		List<WebElement> checkbox = CommonMethod.findElements("locationCheckbox");
		checkbox.get(0).click();
		Thread.sleep(2000);
		checkbox.get(1).click();
		testlog.info("And User select location 1 and location 2 checkbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Editselectedbutton", 0);
		CommonMethod.RobustclickElementVisible("Editselectedbutton", "Selectfielddropdown");
		testlog.info("And User clicks on Multiple edit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Selectfielddropdown", 0);
		CommonMethod.selectdropdownVisibletext("Selectfielddropdown", "Space Types");
		testlog.info("And User select field as Space type to update");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationSpaceType", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioLocationSpaceType", "All Spaces");
		testlog.info("And User update Space type as For All Spaces");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UpdateButton", 0);
		CommonMethod.JavascriptClickElement("UpdateButton");
		testlog.info("And User clicks on update button");
		if (CommonMethod.isElementsExist("Toastermessage", 10)) {
			CommonMethod.WaitUntilInVisibility("Toastermessage", 60);
		}
		testlog.info("And User verify toaster message");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTable", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Editlocationbutton", 0);
		CommonMethod.RobustclickElementVisible("Editlocationbutton", "VerifyEditlocationslider");
		Thread.sleep(3000);
		testlog.info("Then User again clicks on edit location button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationSpaceType", 0);
		String actual_value = CommonMethod.getSelectedDropdownValue("PortfolioLocationSpaceType");
		CommonMethod.negativesoftassertFieldValid(actual_value, "All Spaces",
				"Multiple Updated for 1st table row mismatch");
		testlog.info("And User verify updated Space type");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Closepanelicon", 0);
		CommonMethod.Robustclick("Closepanelicon");
		testlog.info("And User click on close panel");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Editlocation2button", 0);
		CommonMethod.RobustclickElementVisible("Editlocation2button", "VerifyEditlocationslider");
		Thread.sleep(3000);
		testlog.info("then User again clicks on edit location button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationSpaceType", 0);
		String actual_value1 = CommonMethod.getSelectedDropdownValue("PortfolioLocationSpaceType");
		CommonMethod.negativesoftassertFieldValid(actual_value1, "All Spaces",
				"Multiple Updated for 2nd table row mismatch");
		testlog.info("And User verify updated Space type");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Closepanelicon", 0);
		CommonMethod.Robustclick("Closepanelicon");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("Closepanelicon", 1);
		testlog.info("And User click on close panel");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationLanding", 0);
		CommonMethod.refreshBrowser();
		testlog.pass("And User verify multiple edit location successfully**");
	}

	public void locationFilters(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresent("LocationListTable", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FilterButton", 0);
		testlog.info("Given User is on LocationsTab");
		/*
		 * space type filter
		 */
		CommonMethod.JavascriptClickElement("FilterButton");
		testlog.info("when User click on Filter button");
		CommonMethod.RobustclickElementVisible("Warehousecheckbox", "Applybutton");
		testlog.info("And User select Warehouse checkbox ");
		CommonMethod.RobustclickElementVisible("Applybutton", "table");
		testlog.info("And User clicks on  Apply button ");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 2);
		WebElement table = CommonMethod.findElement("tablebody");
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int rows = allRows.size();
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr", 4);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(rows), "4",
				"Space type Location filter doesn't match");
		testlog.info("And User verify space type filter ");
		CommonMethod.WaitUntilPresence("LocationListTableLoading", 60);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilPresence("LocationListTableLoading", 60);
		/*
		 * Ownership type filter
		 */
		CommonMethod.RobustclickElementVisible("FilterButton", "OwnershipWellCore");
		CommonMethod.WaitUntilPresence("OwnershipWellCore", 60);
		testlog.info("then User again click on  Filter Button ");
		CommonMethod.WaitUntilPresence("OwnershipWellCore", 60);
		CommonMethod.RobustclickElementVisible("OwnershipWellCore", "Applybutton");
		testlog.info("And User select OwnershipWellCore checkbox");
		CommonMethod.WaitUntilPresence("Applybutton", 30);
		CommonMethod.RobustclickElementVisible("Applybutton", "LocationListTable");
		testlog.info("And User clicks on  Apply button ");
		CommonMethod.WaitUntilPresence("AddButton", 200);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 2);
		WebElement tableBod = CommonMethod.findElement("tablebody");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr", 3);
		List<WebElement> alRows = tableBod.findElements(By.tagName("tr"));
		int trows = alRows.size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(trows), "3",
				"Ownership Location filter doesn't match");
		testlog.info("And User verify Ownership type filter ");
		CommonMethod.WaitUntilPresence("LocationListTableLoading", 60);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilPresence("LocationListTableLoading", 60);
		/*
		 * Location filter
		 */
		CommonMethod.JavascriptClickElement("FilterButton");
		testlog.info("Then User again click on  Filter Button");
		CommonMethod.WaitUntilPresence("LocationIndia", 60);
		CommonMethod.ClickCheckbox("LocationIndia");
		testlog.info("And User select Location India checkbox");
		CommonMethod.WaitUntilPresence("Applybutton", 120);
		CommonMethod.RobustclickElementVisible("Applybutton", "table");
		testlog.info("And User clicks on  Apply button ");
		CommonMethod.WaitUntilPresence("AddButton", 200);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresent("LocationListTable", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 2);
		CommonMethod.WaitUntilVisibility("tablebody", 60);
		WebElement tableBody = CommonMethod.findElement("tablebody");
		List<WebElement> totalRows = tableBody.findElements(By.tagName("tr"));
		int totrows = totalRows.size();
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr", 4);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(totrows), "4",
				"Table Rows for Location filter doesn't match");
		testlog.info("And User verify Location filter");
		CommonMethod.WaitUntilPresence("LocationListTableLoading", 60);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilPresence("LocationListTableLoading", 60);
		/*
		 * Owner Industry filter
		 */
		CommonMethod.WaitUntilPresence("FilterButton", 120);
		CommonMethod.JavascriptClickElement("FilterButton");
		testlog.info("then User again click on  Filter Button ");
		CommonMethod.WaitUntilPresence("IndustryRetirementcheckbox", 120);
		CommonMethod.RobustclickElementVisible("IndustryRetirementcheckbox", "Applybutton");
		testlog.info("And User select Industry Retirement checkbox ");
		CommonMethod.RobustclickElementVisible("Applybutton", "table");
		testlog.info("And User clicks on  Apply button ");
		CommonMethod.WaitUntilPresence("AddButton", 200);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresent("LocationListTable", 1);
		CommonMethod.WaitUntilVisibility("tablebody", 60);
		WebElement tablebody = CommonMethod.findElement("tablebody");
		List<WebElement> totalrows = tablebody.findElements(By.tagName("tr"));
		int Crows = totalrows.size();
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr", 5);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(Crows), "5",
				"Table rows for Owner Industry filter doesn't match");
		testlog.info("And User verify Location filter ");
		CommonMethod.WaitUntilPresence("LocationListTableLoading", 60);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilPresence("LocationListTableLoading", 60);
		/*
		 * Multiple filters apply
		 * 
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FilterButton", 0);
		CommonMethod.JavascriptClickElement("FilterButton");
		testlog.info("then User again click on  Filter Button ");
		CommonMethod.WaitUntilPresence("Warehousecheckbox", 120);
		CommonMethod.ClickCheckbox("Warehousecheckbox");
		CommonMethod.WaitUntilPresence("OwnershipWellCore", 120);
		CommonMethod.ClickCheckbox("OwnershipWellCore");
		testlog.info("And User select Warehouse and OwnershipWellCore checkbox ");
		CommonMethod.RobustclickElementVisible("Applybutton", "table");
		testlog.info("And User clicks on  Apply button ");
		CommonMethod.WaitUntilPresence("AddButton", 200);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresent("LocationListTable", 1);
		CommonMethod.WaitUntilVisibility("tablebody", 60);
		WebElement tableB = CommonMethod.findElement("tablebody");
		List<WebElement> totalRs = tableB.findElements(By.tagName("tr"));
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr", 2);
		int CRows = totalRs.size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(CRows), "2",
				"Table rows Multiple filters apply doesn't match");
		testlog.info("And User verify Location filter ");
		testlog.info("And User verify Reset filter");
		testlog.info("And User verify single filter successfully**");
		testlog.info("And User verify multiple filter successfully**");
		testlog.pass("And User verify locations filter successfully**");
	}

	public void VerifySingleUpdateOccupancy(String SheetName, int rowNum) throws IOException, InterruptedException {

		testlog.info("Given User is on LocationsTab");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilPresence("LocationListTableLoading", 300);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTable", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresent("OccupancyIcon", 5);
		CommonMethod.negativesoftassertFieldValidEquals(Integer.toString(CommonMethod.ElementSize("OccupancyIcon")),
				"5", "Occupancy Icon Count In Location table doesn't match");
		testlog.info("Then User verify pending occupnacy count"
				+ Integer.toString(CommonMethod.ElementSize("OccupancyIcon")));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OccupancyIcon1", 0);
		CommonMethod.RobustclickElementVisible("OccupancyIcon1", "Occupancytextfield");
		testlog.info("When User clicks on first occupancy icon");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Occupancytextfield", 0);
		CommonMethod.IsElementPresentTrue("locationCheckbox");
		CommonMethod.clearAndSendKey("Occupancytextfield", "25");
		testlog.info("when User enter occupancy");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ConfirmButton", 0);
		CommonMethod.JavascriptClickElement("ConfirmButton");
		testlog.info("And User clicks on confirm button");
		if (CommonMethod.isElementsExist("UpdateOccupancyToasterMessageCommon", 30)) {
			CommonMethod.WaitUntilInVisibility("UpdateOccupancyToasterMessageCommon", 60);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresent("OccupancyIcon", 4);
		List<WebElement> occuIconsafterupdate = CommonMethod.findElements("OccupancyIcon");
		int sizeafterupdate = occuIconsafterupdate.size();
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(sizeafterupdate), "4",
				"After updating Occupancy Icon Count In Location table doesn't match");
		testlog.info("Then User verify the remining occupancy count");
	}

	public void VerifyMultipleUpdateOccupancy(String SheetName, int rowNum) throws IOException, InterruptedException {

		testlog.info("Given User is on LocationsTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTable", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OccupancyIcon1", 0);
		CommonMethod.RobustclickElementVisible("OccupancyIcon1", "Occupancytextfield");
		testlog.info("And User again clicks on first occupancy icon");
		CommonMethod.WaitUntilVisibility("Occupancytextfield", 60);
		CommonMethod.IsElementPresentTrue("locationCheckbox");
		CommonMethod.clearAndSendKey("Occupancytextfield", "15");
		testlog.info("when User enter occupancy for all");
		CommonMethod.ClickCheckbox("locationCheckbox");
		testlog.info("And User clicks on checkbox to update all");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ConfirmButton", 0);
		CommonMethod.JavascriptClickElement("ConfirmButton");
		testlog.info("And User clicks on confirm button");
		if (CommonMethod.isElementsExist("UpdateOccupancyToasterMessageCommon", 30)) {
			CommonMethod.WaitUntilInVisibility("UpdateOccupancyToasterMessageCommon", 60);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTable", 0);
		if (CommonMethod.isElementsExist("OccupancyIcon", 30)) {
			CommonMethod.WaitUntilInVisibility("OccupancyIcon", 60);
		}
		CommonMethod.assertisElementPresentFalse("OccupancyIcon", "Occupancy icon still present!!!");
		testlog.info("And User verify occupancy update for all the location");
		testlog.pass("And User verify update occupancy successfully**");
	}

	public void VerifyLocationUpdatesRestricts(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on LocationsTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.RobustclickElementVisible("LocationTab", "AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTable", 0);
		// ImportIcon
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationsImportButton", 0);
		CommonMethod.moveToElement("PortfolioLocationsImportButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioImportRestrictUpdateToastMsg", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioImportRestrictUpdateToastMsg"),
				"Locations cannot be updated while a review cycle is in progress",
				"Import Locations cannot be updated toaster message Error Mismatch");
		// single Loc
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.RobustclickElementVisible("AddButton", "AddLocationButton");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddLocationButton", 0);
		CommonMethod.moveToElement("AddLocationButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAddNewRestrictUpdateToastMsg", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioAddNewRestrictUpdateToastMsg"),
				"Locations cannot be updated while a review cycle is in progress",
				"single Locations cannot be updated toaster message Error Mismatch");

		// EditLocationIcon
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditLocationIconRestrict", 0);
		CommonMethod.moveToElement("PortfolioEditLocationIconRestrict");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditLocationIconRestrictToastMsg", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEditLocationIconRestrictToastMsg"),
				"Locations cannot be updated while a review cycle is in progress",
				"Edit Locations cannot be updated toaster message Error Mismatch");
	}

	public void HSRPortfolio(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HealthSafetyTab", 0);
		CommonMethod.RobustclickElementVisible("HealthSafetyTab", "PortfolioHSRconfirmenrollbuttton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHSRconfirmenrollbuttton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioHSRconfirmenrollbuttton",
				"PortfolioHSRScorecardTabcustomizescorecardheading");
		testlog.pass("**Verifies the Purse Yes/No Scorecard Performance successfully**");
		ScorecardfillHSRWPRPortfolio(5, 6, 8, 3);
	}

	public void ScorecardfillHSRWPRPortfolio(int YesEnd, int NoStart, int NoEnd, int DifferencePlusOne)
			throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		Boolean flag = false;
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommonScorecardPurseYes", 0);
		YesButton = CommonMethod.findElements("CommonScorecardPurseYes");
		// CommonMethod.hideElement("PortfolioOptscorecardSearchbar");
		for (int i = 1; i <= YesEnd; i++) {
			long startTime = System.currentTimeMillis();
			int RemainingYes = YesButton.size();
			do {
				if (!((System.currentTimeMillis() - startTime) < 60000)) {
					flag = true;
					System.out.println("Build Stuck");
					break;
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommonScorecardPurseYes", 0);
				CommonMethod.JavascriptClickElement("CommonScorecardPurseYes");
				if (CommonMethod.isElementsExist("WPRCloseIcon", 5)) {
					CommonMethod.WaitUntilVisibility("WPRCloseIcon", 120);
					CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRCloseIcon", 1);
				}
				YesButton = CommonMethod.findElements("CommonScorecardPurseYes");
				Thread.sleep(2000);
			} while ((YesButton.size() == RemainingYes));
			RemainingYes--;
			if (flag) {
				System.out.println("Build Exit");
				break;
			}
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommonScorecardPurseNo", 0);
		NoButton = CommonMethod.findElements("CommonScorecardPurseNo");
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
				CommonMethod.JavascriptClickElement(NoButton.get(RemainingNo - j));
				if (CommonMethod.isElementsExist("WPRCloseIcon", 5)) {
					CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRCloseIcon", 1);
				}
				NoButton = CommonMethod.findElements("CommonScorecardPurseNo");
				Thread.sleep(2000);
			} while ((NoButton.size() == RemainingNo));
			RemainingNo--;
			j--;
			if (flag) {
				System.out.println("Build Exit");
				break;
			}
		}
		CommonMethod.scrolldowntoElement("V2ProjectWPRScorecardLanding");
	}

	public void addLocation(String SheetName, int rowNum, String ProjectType, String Upload, String API)
			throws Exception {
		testlog.info("Given User is on Dashboard page");
		String LocationName = null;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.RobustclickElementVisible("LocationTab", "AddButton");
		testlog.info("When User clicks on LocationTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationPageValid", 0);
		CommonMethod.scrolldowntoElement("LocationPageValid");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.RobustclickElementVisible("AddButton", "AddLocationButton");
		testlog.info("And User clicks on Add Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddLocationButton", 0);
		CommonMethod.RobustclickElementVisible("AddLocationButton", "PortfolioLocationProjectName");
		testlog.info("And User clicks on Add Location Button");
		CommonMethod.RobustclickElementVisible("SubmitButton", "PortfolioLocationProjectName");
		testlog.info("And User clicks on Submit Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationProjectName", 0);
		CommonMethod.negativesoftassertPageSource("Project Name* is required.", "Project Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Project Area* is required.", "Project Area Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Space Type* is required.", "Space Type Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Ownership Type* is required.", "Ownership Type Error Mismatch");
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		if (Upload.equalsIgnoreCase("true") && API.equalsIgnoreCase("true")) {
			if (ProjectType.contains("pilot")) {
				LocationName = "TEST W@S Location 19";
			}
		} else {
			LocationName = "Automation portfolio Location" + CommonMethod.randomNumber(8000000);
		}
		data.setCellData(SheetName, "LocationName", rowNum, LocationName);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationProjectName", 0);
		CommonMethod.sendKeys("PortfolioLocationProjectName", data.getCellData(SheetName, "LocationName", rowNum));
		testlog.info("And User enter data to ProjectName field");
		if (ProjectType.contains("pilot")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationProjectVersion", 0);
			int version = CommonMethod.getdropdownSize("PortfolioLocationProjectVersion");
			CommonMethod.negativesoftassertFieldValid(Integer.toString(version), "2", "ProjectVersion count doesn't match");
			if (TestCaseName.equalsIgnoreCase("Portfolio_TC_02_01_AddingSingleLocBySelectingV2VersionAndValidateScorecardInAddedLocation")) {
				CommonMethod.selectdropdownVisibletext("PortfolioLocationProjectVersion", "WELL v2");
			}
			else {
				CommonMethod.selectdropdownVisibletext("PortfolioLocationProjectVersion", "WELL v2-Pilot");
			}
		}
		else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationProjectVersion", 0);
			int version = CommonMethod.getdropdownSize("PortfolioLocationProjectVersion");
			CommonMethod.negativesoftassertFieldValid(Integer.toString(version), "1", "ProjectVersion count doesn't match");
			CommonMethod.selectdropdownVisibletextwithoutdelay("PortfolioLocationProjectVersion", "WELL v2");
		}
		testlog.info("And User select the ProjectVersion");
		CommonMethod.sendKeys("PortfolioLocationProjectArea", data.getCellData(SheetName, "AreaSQFT", rowNum));
		testlog.info("And User enter data to Area field");
		CommonMethod.selectdropdownValue("PortfolioLocationSpaceType", "2");
		testlog.info("And User select the SpaceType");
		data.setCellData(SheetName, "SpaceTypes", rowNum,
				CommonMethod.getSelectedDropdownValue("PortfolioLocationSpaceType"));
		testlog.info("Space type: " + data.getCellData(SheetName, "SpaceTypes", rowNum));
		CommonMethod.selectdropdownValue("PortfolioLocationOwnerType", "new-existing");
		testlog.info("And User select the OwnerType");
		data.setCellData(SheetName, "OwnerType", rowNum,
				CommonMethod.getSelectedDropdownValue("PortfolioLocationOwnerType"));
		testlog.info("Owner type: " + data.getCellData(SheetName, "OwnerType", rowNum));
		CommonMethod.negativesoftassertPageSource("Country is required.", "Country Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Street is required.", "Street Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("City is required.", "City Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Postal Code is required.", "Postal Code Name Error Mismatch");
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		CommonMethod.selectdropdownValue("LocationCountryName", "US");
		testlog.info("And User select the Country");
		CommonMethod.selectdropdownrandom("LocationStateName");
		testlog.info("And User select the State");
		CommonMethod.sendKeys("LocationStreetName", data.getCellData(SheetName, "Street", rowNum));
		testlog.info("And User enter data to Area field");
		CommonMethod.sendKeys("LocationCityName", data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("LocationPostalCode", data.getCellData(SheetName, "PostalCode", rowNum));
		if (SheetName.equalsIgnoreCase("Portfolio")) {
			portfolio.ValidateAddedLocationOwnerFields(SheetName, rowNum);
			portfolio.ValidateAddedLocationAdditionalField(SheetName, rowNum);
		}
		testlog.info("And User enter data to Street, City, PostalCode field");
		CommonMethod.RobustclickElementVisible("SubmitButton", "LocationResultCount");
		testlog.info("And User clicks on Submit button");
		CommonMethod.refreshBrowser();
		/*
		 * Validate location added successfully
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationTableTr");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTableTr", 0);
		List<String> val = CommonMethod.fetchTableData("LocationListTable");
		testlog.info("Fetching Data from Upload Table");
		String[] LocationNameValid = val.get(0).split(LocationName);
		data.setCellData(SheetName, "LocationProjectID", rowNum, LocationNameValid[1].trim());
		CommonMethod.negativesoftassertFieldValid(val.get(0), data.getCellData(SheetName, "LocationName", rowNum),
				"Location name doesn't match");
		System.out.println("LocationNameValid[1].trim(): " + LocationNameValid[1].trim());
		testlog.info("And User verifies the added details in Location list Table");
		testlog.pass("**Added single location successfully**");
	}
	
	public void getLocationVersionId() throws Exception {
		if (TestCaseName.equalsIgnoreCase("Portfolio_USTC_04_03_ValidateAddedLocationInLocationList")) {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("getLocationVersionId", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("getLocationVersionId").trim(), "WELL v2 pilot",
				"Location version doesn't match");
		}
		else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("getLocationVersionId", 0);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("getLocationVersionId").trim(), "WELL v2",
					"Location version doesn't match");	
		}
	}
	
	public void ValidateSearchLocation(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSearchLocation", 0);
		CommonMethod.sendKeys("PortfolioSearchLocation", data.getCellData(SheetName, "LocationProjectID", rowNum));
		CommonMethod.sendKeyEnter("PortfolioSearchLocation");
		Thread.sleep(3000);
		CommonMethod.WaitUntilNumberOfElementToBePresent("PortfolioLocListTr", 1);
		int PortfolioLocListTr = CommonMethod.ElementSize("PortfolioLocListTr");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(PortfolioLocListTr), "1",
				"Location list count doesn't Mismatch");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
	}

	public void ValidateMilestoneSearchLocation(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on location tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Milestonetab", 0);
		CommonMethod.RobustclickElementVisible("Milestonetab", "table");
		testlog.info("Given User clicks on Milestone tab");
		ValidateSearchLocation(SheetName, rowNum);
	}

	public void ScorecardSurvey() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2Tab", 0);
		CommonMethod.RobustclickElementVisible("WellV2Tab", "ScorecardTab");
		testlog.info("When User clicks on WellV2Tab");
		CommonMethod.Robustclick("ScorecardTab");
		if (CommonMethod.isElementsExist("PortfolioSurveyBuildButton", 30)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSurveyBuildButton", 0);
			CommonMethod.RobustclickElementVisible("PortfolioSurveyBuildButton", "PortfolioSurveyPage");
			testlog.info("And User clicks on PortfolioSurveyBuildButton");
		}
		/*
		 * Category Design
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCategoryDesign", 0);
		CommonMethod.RobustclickElementVisible("PortfolioCategoryDesign", "PortfolioSurveyBackToAllCategoryBtn");
		testlog.info("And User clicks on Design Category");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSurveyQuestions", 0);
		List<WebElement> questions = CommonMethod.findElements("PortfolioSurveyQuestions");
		int quesNum = questions.size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(quesNum), "12",
				"Questions count for Design doesn't match!!");
		testlog.info("And User verifies Number of questions");
		CommonMethod.click(questions.get(1));
		testlog.info("And User clicks on Site selection question");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSurveySiteSelectionDesign", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSurveyDesignVerifyInitialScore", 0);
		testlog.info("And User clicks on Site selection question");
		List<WebElement> surveyques = CommonMethod.findElements("PortfolioSurveyVerifyQuestions");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(surveyques.size()), "9",
				"Questions count for Design doesn't match!!");
		testlog.info("And User verifies Number of question for Site selection");
		List<WebElement> YesnoOps = CommonMethod.findElements("PortfolioSurveyQuestionYesAndNo");
		CommonMethod.WaitUntilClickble("PortfolioSurveyQuestionYesAndNo", 60);
		CommonMethod.click(YesnoOps.get(0));
		testlog.info("And User clicks Yes for first question");
		CommonMethod.click(YesnoOps.get(3));
		testlog.info("And User clicks No for second question");
		CommonMethod.click(YesnoOps.get(4));
		testlog.info("And User clicks Yes for third question");
		CommonMethod.click(YesnoOps.get(7));
		testlog.info("And User clicks No for fourth question");
		CommonMethod.click(YesnoOps.get(8));
		testlog.info("And User clicks Yes for fifth question");
		CommonMethod.click(YesnoOps.get(11));
		testlog.info("And User clicks No for six question");
		CommonMethod.click(YesnoOps.get(12));
		testlog.info("And User clicks Yes for seven question");
		CommonMethod.click(YesnoOps.get(15));
		testlog.info("And User clicks No for eight question");
		CommonMethod.click(YesnoOps.get(16));
		testlog.info("And User clicks Yes for first question");
		CommonMethod.ScrollUpToElement("PortfolioSurveySiteSelectionDesign");
		CommonMethod.WaitUntilPresence("PortfolioSurveyDesignVerifyfinalScore", 60);
		testlog.info("And User verified question score for site selection");
		CommonMethod.WaitUntilClickble("PortfolioSurveySaveAndExitBtn", 60);
		CommonMethod.JavascriptClickElement("PortfolioSurveySaveAndExitBtn");
		testlog.info("And User clicks on SaveAndExit button");
		CommonMethod.WaitUntilPresence("PortfolioCategoryDesign", 60);
		CommonMethod.WaitUntilPresence("PortfolioSurveyDesignPropotion", 60);
		testlog.info("And User verified design propotions successfully!!");

		/*
		 * Category Policy
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCategoryPolicy", 0);
		CommonMethod.RobustclickElementVisible("PortfolioCategoryPolicy", "PortfolioSurveyBackToAllCategoryBtn");
		testlog.info("And User clicks on Policy Category");
		List<WebElement> questions1 = CommonMethod.findElements("PortfolioSurveyQuestions");
		int quesNum1 = questions1.size();
		CommonMethod.negativesoftassertFieldValid(String.valueOf(quesNum1), "5",
				"Questions count for Policy doesn't match!!");
		testlog.info("And User verifies Number of questions");
		CommonMethod.click(questions1.get(4));
		testlog.info("And User clicks on Educational Resources question");
		CommonMethod.WaitUntilPresence("PortfolioSurveyEducationalResources", 60);
		CommonMethod.WaitUntilPresence("PortfolioSurveyPolicyVerifyInitialScore", 60);
		testlog.info("And User verified Initial Score for Educational Resources question");
		List<WebElement> surveyques1 = CommonMethod.findElements("PortfolioSurveyVerifyQuestions");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(surveyques1.size()), "8",
				"Questions count for Policy doesn't match!!");
		testlog.info("And User verifies Number of question for Educational Resource");
		List<WebElement> YesnoOps1 = CommonMethod.findElements("PortfolioSurveyQuestionYesAndNo");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSurveyQuestionYesAndNo", 0);
		CommonMethod.click(YesnoOps1.get(0));
		testlog.info("And User clicks Yes for first question");
		CommonMethod.click(YesnoOps1.get(3));
		testlog.info("And User clicks No for second question");
		CommonMethod.click(YesnoOps1.get(4));
		testlog.info("And User clicks Yes for third question");
		CommonMethod.click(YesnoOps1.get(7));
		testlog.info("And User clicks No for fourth question");
		CommonMethod.click(YesnoOps1.get(8));
		testlog.info("And User clicks Yes for fifth question");
		CommonMethod.click(YesnoOps1.get(11));
		testlog.info("And User clicks No for six question");
		CommonMethod.click(YesnoOps1.get(12));
		testlog.info("And User clicks Yes for seven question");
		CommonMethod.click(YesnoOps1.get(15));
		testlog.info("And User clicks No for first question");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSurveyPolicyVerifyfinalScore", 0);
		testlog.info("And User verified final score for Educational Resource");
		CommonMethod.ScrollUpToElement("PortfolioSurveySaveAndExitBtn");
		CommonMethod.WaitUntilClickble("PortfolioSurveySaveAndExitBtn", 60);
		CommonMethod.JavascriptClickElement("PortfolioSurveySaveAndExitBtn");
		testlog.info("And User clicks on SaveAndExit button");
		CommonMethod.WaitUntilPresence("PortfolioCategoryPolicy", 60);
		CommonMethod.WaitUntilPresence("PortfolioSurveyPolicyPropotion", 60);
		testlog.pass("And User verified Policy propotions successfully!!");
		CommonMethod.scrolldowntoElement("PortfolioSurveyFinishButton");
		CommonMethod.JavascriptClickElement("PortfolioSurveyFinishButton");
		testlog.info("And User clicks on finish button");
		CommonMethod.RobustclickElementVisible("PortfolioSurveyFinishPopup", "PortfolioSurveyDownloadButton");
		testlog.info("And User clicks on finish button on the popup");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSurveyManageScorecardBtn", 0);
		CommonMethod.Robustclick("PortfolioSurveyManageScorecardBtn");
		testlog.info("And User clicks on Manage scorecard button");
		rc.ScorecardLoading();
		testlog.info("Then User will be redirected to ScoreCardPage page");
		testlog.pass("**Scorecard survey completed**");

	}

	public void uploadDocumentInFeatureOpt(int LastFeatureNumber) throws IOException, InterruptedException {
		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHSRScorecardPartFeature", 0);
		Feature = CommonMethod.findElements("PortfolioHSRScorecardPartFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		for (WebElement f : Feature) {
			CommonMethod.WaitUntilClickble(f, 120);
			CommonMethod.JavascriptClickElement(f);
			CommonMethod.WaitUntilPresence("V2ProjectWPRPDocIcon", 120);
			CommonMethod.RobustclickElementVisible("V2ProjectWPRPDocIcon", "V2ProjectWPRVerificationMethod");
			CommonMethod.WaitUntilVisibility("PortfolioHSRScorecardDocumentType", 60);
			CommonMethod.selectdropdownValue("PortfolioHSRScorecardDocumentType", "feature");
			CommonMethod.ClickCheckbox("PortfolioHSRScorecardSingleLocation");
			CommonMethod.WaitUntilVisibility("V2ProjectWPRVerificationMethod", 60);
			CommonMethod.selectdropdownIndex("V2ProjectWPRVerificationMethod", 1);
			CommonMethod.uploadFile("V2ProjectDocUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
			CommonMethod.WaitUntilVisibility("FeatureFileUploadedVisible", 60);
			CommonMethod.Robustclick("PortfolioHSRScorecardUploadButton");
			CommonMethod.WaitUntilPresence("V2ProjectWPRScorecardLanding", 60);
			CommonMethod.scrolldowntoElement("V2ProjectWPRScorecardLanding");
			CommonMethod.JavascriptClickElement(f);
		}
	}

	public void WPRPortfolioOpt(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PerformanceTab", 0);
		CommonMethod.RobustclickElementVisible("PerformanceTab", "PortfolioHSRconfirmenrollbuttton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHSRconfirmenrollbuttton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioHSRconfirmenrollbuttton",
				"PortfolioHSRScorecardTabcustomizescorecardheading");
		testlog.pass("**Verifies the 27 Purse Yes Scorecard Performance successfully**");
		ScorecardfillHSRWPRPortfolio(5, 6, 8, 3);
	}
	
	public void navigateWERPortfolioOpt() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EquityTab", 0);
		CommonMethod.RobustclickElementVisible("EquityTab", "PortfolioHSRconfirmenrollbuttton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHSRconfirmenrollbuttton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioHSRconfirmenrollbuttton",
				"PortfolioHSRScorecardTabcustomizescorecardheading");
	}
	
	public void WERPortfolioOpt(String SheetName, int rowNum) throws IOException, InterruptedException {
		navigateWERPortfolioOpt();
		testlog.pass("**Verifies the 27 Purse Yes Scorecard Performance successfully**");
		ScorecardfillHSRWPRPortfolio(5, 6, 8, 3);
	}

	public void AdminEditReviewMrc(String SheetName, int rowNum) throws IOException, InterruptedException {
		AdminSearch(SheetName, rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "PortfolioReviewListViewButton");
		testlog.info("Given User clicks on Review tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReviewListViewButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioReviewListViewButton", "PortfolioReturnReview");
		testlog.info("then User clicks on view button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReturnReview", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditReviewButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioEditReviewButton", "PortfolioUpdateButton");
		testlog.info("And User clicks on Edit Review button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioMidReviewRadio", 0);
		CommonMethod.ClickCheckbox("PortfolioMidReviewRadio");
		testlog.info("And User clicks on Need clarification radio button");
		CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioMidReviewRadio");
		testlog.info("And User verifies radio button is selected");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioMidReviewComment", 0);
		CommonMethod.sendKeys("PortfolioMidReviewComment", "MRC Test note for round 1 review");
		testlog.info("And User enters mrc comment");
		CommonMethod.RobustclickElementVisible("PortfolioAddEstDate", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilClickble("DatePickerOkButton", 30);
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "PortfolioUpdateButton");
		CommonMethod.WaitUntilClickble("PortfolioUpdateButton", 30);
		CommonMethod.RobustclickElementVisible("PortfolioUpdateButton", "PortfolioStatusRequireClr");
		testlog.info("And User clicks on update button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioStatusRequireClr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortoflioResubmitReviewBtn", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioMrcComment", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioMrcDocupload", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAddCommentBtn", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCommentDeleteicon", 0);
		CommonMethod.RobustclickElementVisible("PortoflioResubmitReviewBtn", "PortfolioResubmitPopuptext");
		testlog.info("And User clicks on resubmit review button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioResubmitTextarea", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioResubmitSubmitbtn", 0);
		CommonMethod.sendKeys("PortfolioResubmitTextarea", "Test Resubmitting round 1 review");
		testlog.info("And User enters text in text area");
		CommonMethod.RobustclickElementVisible("PortfolioResubmitSubmitbtn", "PortfolioStatusInprogress");
		testlog.info("And User clicks on submit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioStatusInprogress", 0);
		testlog.info("And User verifies status as Inprogress after resubmission");
		testlog.pass("And User verifies MRC functionality successfully***");
	}

	public void InitiateRound2Review(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		testlog.info("When User clicks on ReviewTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Reviewlanding", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTableTrValid", 0);
		List<String> tabledata = CommonMethod.fetchTableData("PortfolioReviewTable");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(3), CommonMethod.ValidateDate(),
				"Review Submitted Date Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(5), CommonMethod.ValidateDate(),
				"Review Returned Date Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(4), "-", "Review Date Error Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioStatusRound1", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReviewListViewButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioReviewListViewButton", "PortfolioInitiateRound2Button");
		testlog.info("And User clicks on view button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReviewStatus", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioInitiateRound2Button", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReviewAccetpFinalButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioInitiateRound2Button", "PortfolioInitiateRound2Popup");
		testlog.info("then User clicks on initiate round 2 button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioInitiateRound2Popup", 0);
		CommonMethod.click("PortfolioSubmitRound2");
		testlog.info("And User clicks on submit button");
		CommonMethod.negativesoftassertPageSource(
				"Please provide your comments below to notify the IWBI team is required.",
				"Review comments Error Mismatch!!");
		testlog.info("And User verifies validation message for comment field");
		CommonMethod.sendKeys("PortfolioRound2Textarea", "Test Initiating round 2");
		testlog.info("then User enters text in the textfield");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubmitRound2", 0);
		CommonMethod.RobustclickElementVisible("PortfolioSubmitRound2", "PortfolioReview2InProgress");
		testlog.info("And User clicks on submit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReview2InProgress", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioRound2SubDate", 0);
		testlog.info("And User verifies review status");
		testlog.pass("And User successfully initiated round 2 review");
	}

	public void AdminCompleteRound2Review(String SheetName, int rowNum) throws IOException, InterruptedException {
		AdminSearch(SheetName, rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "PortfolioReviewListViewButton");
		testlog.info("And User clicks on Review tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTableTrValid", 0);
		List<String> tabledata = CommonMethod.fetchTableData("PortfolioReviewTable");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(3), CommonMethod.ValidateDate(),
				"Round2 Review Submitted Date Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(4), "-", "Est Review Date Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(tabledata.get(5), "", "Return Review Date Error Mismatch");
		CommonMethod.WaitUntilVisibility("PortfolioReviewListViewButton", 60);
		CommonMethod.RobustclickElementVisible("PortfolioReviewListViewButton", "PortfolioReturnRound2Review");
		testlog.info("And User clicks on view button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReturnRound2Review", 0);
		CommonMethod.RobustclickElementVisible("PortfolioReturnRound2Review", "PortfolioUploadFile");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadFile", 0);
		CommonMethod.uploadFile("PortfolioUploadFile", PortfolioLocationImportfile, "UploadFileVerifyScorecard");
		testlog.info("And User clicks on Return button");
		testlog.info("And User Upload Review Document");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Returned round 2 review");
		Thread.sleep(1000);
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		testlog.info("And User select Review Date");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReviewSubmitResponse", 0);
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitResponse", "PortfolioRound2ReviewStatus");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioRound2ReviewStatus", 0);
		testlog.info("Then User verifies Reviewed Status");
		testlog.pass("**Completed Reviewed Round 2 Review successfully**");
	}

	public void PortfolioOptSubmitReviewDocument(String SheetName, int rowNum, String locator)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		testlog.info("When User clicks on ReviewTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Reviewlanding", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReviewSubmitButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitButton", "PortfolioReviewTextbox");
		testlog.info("And User clicks on Submit Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OwnerOrgClick", 0);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", locator);
		CommonMethod.click(locator);
		CommonMethod.sendKeys("PortfolioReviewTextbox", "Submit Documentation for Year 1, Review Cycle #1");
		testlog.info("And User enter data to Review field");
		CommonMethod.RobustclickElementVisible("PortfolioReviewSubmitDocButton", "PortfolioReviewListStatus");
		testlog.info("And User clicks on Submit Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReviewListStatus", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("PortfolioReviewListStatus"), "Round 1 Review In Progress",
				"Verified Submitted Review list status");
		testlog.info("Then User will be redirected to Review list page");
		testlog.pass("**Submitted Documentation for Year 1, Review Cycle #1 successfully**");
	}

	public void AuthCompleteReviewDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		testlog.info("When User clicks on ReviewTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReviewListViewButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioReviewListViewButton", "PortfolioInitiateReview");
		testlog.info("When User clicks on ReviewListView");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioInitiateReview", 0);
		CommonMethod.RobustclickElementVisible("PortfolioInitiateReview", "PortfolioOptscorecardIWBINote");
		testlog.info("When User clicks on Initiate Round 2 Review Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioOptscorecardIWBINote", 0);
		CommonMethod.sendKeys("PortfolioOptscorecardIWBINote", "Test");
		testlog.info("When User enter text in IWBI note input field");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioOptscorecardSubmitButton", 0);
		CommonMethod.Robustclick("PortfolioOptscorecardSubmitButton", "PortfolioOptscorecardIWBINote");
		testlog.info("When User clicks on submit Button");
	}

	public void EditHsrDocForFeature(String SheetName, int rowNum, String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.refreshBrowser();
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRPortfolioScorecardLanding", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardFeatureSC1", 0);
		CommonMethod.RobustclickElementVisible("HSRScorecardFeatureSC1", "WPRVerficationTab");
		testlog.info("And User clicks on feature sc1");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRVerficationTab", 0);
		CommonMethod.RobustclickElementVisible("WPRVerficationTab", PortfolioAndRatingLocAccDocumentTable);
		testlog.info("And User clicks on Verification tab");
		/*
		 * Edit Upload Document
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		//Update the letter option
		 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHsrOptnEditIcon", 0);
		CommonMethod.click("PortfolioHsrOptnEditIcon");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableEditIcon", 0);
	    CommonMethod.RobustclickElementVisible("PortfolioAndRatingLocAccDocumentTableEditIcon", "PortfolioScoreVerifyUploadVerificationMethod");
		testlog.info("When User clicks on Edit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreVerifyUploadVerificationMethod", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardAddFeaturePart", 0);
		CommonMethod.JavascriptClickElement("HSRScorecardAddFeaturePart");
		testlog.info("And User clicks on Add feature part dropdown");
		CommonMethod.scrolldowntoElement("HSRScorecardAddFeaturePart");
		testlog.info("And User scroll to the Add part button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardSelectFeaturePart", 0);
		int dropdownsize = CommonMethod.getdropdownSize("HSRScorecardSelectFeaturePart");
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(dropdownsize), "5",
				"HSR Opt Scorecard Select FeaturePart Count doesn't match");
		testlog.info("Then User verifies the avaialble option to add");
		CommonMethod.selectdropdownVisibletext("HSRScorecardSelectFeaturePart", "SS2");
		testlog.info("And User select feature SS2");
		String dropdowntext = CommonMethod.getSelectedDropdownValue("HSRScorecardSelectFeaturePart");
		CommonMethod.negativesoftassertFieldValidEquals(dropdowntext, "SS2",
				"HSR Opt Scorecard Select FeaturePart doesn't match");
		testlog.info("then User verifies selected feature SS2");
		CommonMethod.WaitUntilVisibility("HSRScorecardSelectOption", 30);
		CommonMethod.selectdropdownIndex("HSRScorecardSelectOption", 1);
		testlog.info("And User select option");
		CommonMethod.RobustclickElementVisible("HSRScorecardAddPartButton", "HSRScorecardVerifyFeatureId");
		testlog.info("And User clicks on Add part button");
		Thread.sleep(2000);
		/** Valid FeatureName */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardVerifyFeatureName", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("HSRScorecardVerifyFeatureName"),
				"Share Food Inspection Information", "Feature Name doesn't match");
		testlog.info("FeatureName: " + CommonMethod.getText("HSRScorecardVerifyFeatureName"));
		testlog.info("And User verifies FeatureName");

		/** Valid PartName */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardVerifyFeatureId", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("HSRScorecardVerifyFeatureId"), "SS2",
				"PartName doesn't match");
		testlog.info("PartName: " + CommonMethod.getText("PortfolioScorecardUploadPartName"));
		testlog.info("And User verifies PartName");
		rc.ScorecardUploadUpdateSaveButton();
		rc.ScorecardConfirmLocUploadSaveButton();
		testlog.info("And User clicks on update button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		pathprms.put("PartId", "SC1");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, false, false, false,
				false, false, false);
		testlog.info("And User verifies updated feature in document table");
		testlog.pass("And User Validated the edit document functionality Successfully**");
	}
	
	public void ValidateDateAddedColumnAndCurrentDate(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.RobustclickElementVisible("LocationTab", "PortfolioSubsetButton");	
		CommonMethod.scrolldowntoElement("PortfolioSubsetButton");	
		JavascriptExecutor scrollRight = (JavascriptExecutor) driver;
		scrollRight.executeScript("window.scrollBy(500,0)");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDateAddedColumnName", 0);
		String dateAddedColumnName = CommonMethod.getattributeValueByTextContent("PortfolioDateAddedColumnName");
		dateAddedColumnName = dateAddedColumnName.replaceAll("\\s+", " ").trim();
		System.out.println(dateAddedColumnName);
		CommonMethod.negativesoftassertFieldValid(dateAddedColumnName, "Date added", "Date added column name does not matched");
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDateAddedColumnDate", 0);
		String actualCurrentDate = CommonMethod.getattributeValueByTextContent("PortfolioDateAddedColumnDate");
		actualCurrentDate = actualCurrentDate.replaceAll("\\s+", " ").trim();
		CommonMethod.negativesoftassertFieldValid(actualCurrentDate, CommonMethod.ValidateDate(), "Date added current date does not matched");

		}

	public void supportV2Project(String SheetName, int rowNum, String ProjectType)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		if (CommonMethod.isElementsExist("SupportLoading", 30)) {
			CommonMethod.WaitUntilInVisibility("SupportLoading", Scorecardtimeout);
		}
		CommonMethod.WaitUntilVisibility("V2ProjectSupportButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectSupportButton", "V2ProjectGetHelpButton");
		testlog.info("When User clicks on Support tab");
		CommonMethod.WaitUntilVisibility("V2ProjectGetHelpButton", 60);
		CommonMethod.RobustclickElementVisible("V2ProjectGetHelpButton", "V2ProjectQuestionAboutDropdown");
		testlog.info("And User clicks on GetHelp Button");
		CommonMethod.WaitUntilPresence("SubmitButton", 120);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectQuestionAboutDropdown");
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		CommonMethod.negativesoftassertPageSource("Question About is required.", "Question About Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Subject is required.", "Subject Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Description is required.", "Description Error Mismatch");
		CommonMethod.WaitUntilVisibility("V2ProjectQuestionAboutDropdown", 120);
		CommonMethod.selectdropdownValue("V2ProjectQuestionAboutDropdown", "well-v2-feature");
		testlog.info("And User select QuestionAbout");
		CommonMethod.WaitUntilVisibility("V2ProjectIssueSubTypeDropdown", 60);
		if (ProjectType.contains("pilot")) {
			CommonMethod.selectdropdownValue("V2ProjectIssueSubTypeDropdown", "A01 Fundamental Air Quality");
		} else {
			CommonMethod.selectdropdownValue("V2ProjectIssueSubTypeDropdown", "A01 Air Quality");
		}
		testlog.info("And User select IssueSubType");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", "OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 5).click();
		testlog.info("And User select IssueSubType");
		CommonMethod.WaitUntilClickble("V2ProjectSubjectInputField", 60).sendKeys("Testing");
		testlog.info("And User enter data Subject field");
		data.setCellData(SheetName, "Subject", rowNum, CommonMethod.getattributeValue("V2ProjectSubjectInputField"));
		testlog.info("FeatureName" + data.getCellData(SheetName, "Subject", rowNum));
		CommonMethod.WaitUntilClickble("V2ProjectDescriptionTextArea", 60).sendKeys("Testing");
		testlog.info("And User enter data Description field");
		CommonMethod.uploadMultipleFile("DocumentsUpload", FeaturefileUpload, FeaturefileUpload,
				"MultipeUploadDeleteicon", 2, "MultipeUploadEnableButtonDeleteLink");
		testlog.info("And User upload feature document");
		CommonMethod.WaitUntilVisibility("V2ProjectUploadFeatureVerify", 120);
		CommonMethod.WaitUntilVisibility("SubmitButton", 60);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectBackToTicket");
		testlog.info("And User clicks on Submit button");
		CommonMethod.RobustclickElementVisible("V2ProjectBackToTicket", "V2ProjectTicketListStatus");
		testlog.info("And User clicks on BackToTicket");
		CommonMethod.WaitUntilPresence("V2ProjectTicketListStatus", 180);
		String TicketStatus = CommonMethod.getText("V2ProjectTicketListStatus");
		testlog.info("TicketStatus: " + TicketStatus);
		CommonMethod.assertActualContainsExpected(TicketStatus, "NEW");
		testlog.info("Then User verifies New status");
		testlog.pass("**Raised support ticket successfully**");
	}
	
	public void PortfolioCreateSubset(String SheetName, int rowNum, String Commodity) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.JavascriptClickElement("LocationTab");
		testlog.info("Given user is on the location page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationTableTr");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTableTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetButton", 0);
		CommonMethod.JavascriptClickElement("PortfolioSubsetButton");  
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetAddNewButton", 0);
		CommonMethod.JavascriptClickElement("PortfolioSubsetAddNewButton");  
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetBtnAfterClickAddNewBtn", 0);
		CommonMethod.JavascriptClickElement("PortfolioSubsetBtnAfterClickAddNewBtn");  
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetNameTextBox", 0);
		CommonMethod.sendKeys("PortfolioSubsetNameTextBox", "I am Subset Name Text Box"); 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDescriptionTextBox", 0);
		CommonMethod.sendKeys("PortfolioDescriptionTextBox", "I am Optional Description Text Box"); 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetSaveAndContinueBtnFirstPage", 0);
		CommonMethod.Robustclick("PortfolioSubsetSaveAndContinueBtnFirstPage");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFiltersPilot", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardFiltersPilot");
		
		//Validate WELL V2 Filter
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetWellVersionDropdown", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioSubsetWellVersionDropdown", "WELL V2");
		SubsetApplyFilter();
		SubsetCloseModal();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetValidateAppliedFilter", 0);
		String actualAppliedFilterText = CommonMethod.getattributeValueByTextContent("PortfolioSubsetValidateAppliedFilter").trim();
		CommonMethod.negativesoftassertFieldValid(actualAppliedFilterText, "1 filters active", "1 filters active text does not matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetValidateWellV2FilterCount", 0);
		int WellV2Count = CommonMethod.findElements("PortfolioSubsetValidateWellV2FilterCount").size();
		String actualWellV2Count = Integer.toString(WellV2Count);
		CommonMethod.negativesoftassertFieldValidEquals(actualWellV2Count, "6", "6 location count does not matched");
		
		//Validate Countries Filter
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFiltersPilot", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardFiltersPilot");
		SubsetClearFilter();
		pfu.validAssignLocationCountryFilter("India");
		pfu.validAssignLocationFilter("4");
		
		//Validate SpaceType Filter
		pfu.validAssignLocationSpaceTypeFilter("Commercial Kitchen Spaces");
		pfu.validAssignLocationFilter("1");
		
		//Validate OwnershipType Filter
		pfu.validSubsetOwnershipTypeFilter("Owner-occupied");
		pfu.validAssignLocationFilter("3");
		
		//Validate OccupancySizeRange Filter     
		pfu.validSubsetOccupancySizeRangeFilter("10,000 - 49,999 ft²");
		pfu.validAssignLocationFilter("6");
		
		//Validate ConstructionStatus Filter 
		pfu.validSubsetConstructionStatusFilter("Not under construction/renovation");
		pfu.validAssignLocationFilter("6");
		
		//Validate LocationStatus Filter 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetLocationStatusDropdown", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioSubsetLocationStatusDropdown", "Not assigned");
		SubsetApplyFilter();
		pfu.validAssignLocationFilter("6");
		SubsetCloseModal();
		
		//Validate SearchLocation Textbox 		
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardSearchLocationTextbox", 0);
		CommonMethod.sendKeys("PortfolioScorecardSearchLocationTextbox", "location 1");
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetLocationOne", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioSubsetLocationOne", "Location does not matched");
		
		//Validate Save and Continue 	
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetLocationOneCheckbox", 0);
		CommonMethod.ClickCheckbox("PortfolioSubsetLocationOneCheckbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetSaveAndContinueBtnSecondPage", 0);
		CommonMethod.JavascriptClickElement("PortfolioSubsetSaveAndContinueBtnSecondPage"); 
		
		//Click on Save and Exit
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSaveAndExitBtn", 0);
		CommonMethod.Robustclick("PortfolioSaveAndExitBtn");
		
		//Validate Subset Table Name
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetTableName", 0);
		String actualSubsetTableName = CommonMethod.getattributeValueByTextContent("PortfolioSubsetTableName").trim();
		CommonMethod.negativesoftassertFieldValid(actualSubsetTableName, "I am Subset Name Text Box", "I am Subset Name Text Box text does not matched");
		
		//Validate Subset Table Locations Count
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetTableLocationsCount", 0);
		String actualSubsetTableLocationsCount = CommonMethod.getattributeValueByTextContent("PortfolioSubsetTableLocationsCount").trim();
		CommonMethod.negativesoftassertFieldValid(actualSubsetTableLocationsCount, "1", "Table Locations Count does not matched");
		
		//Edit and Update Subset Table
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetTableEditBtn", 0);
		CommonMethod.Robustclick("PortfolioSubsetTableEditBtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetNameTextBox", 0);
		CommonMethod.clearAndSendKey("PortfolioSubsetNameTextBox", "I am Subset Name Text Box"); 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDescriptionTextBox", 0);
		CommonMethod.clearAndSendKey("PortfolioDescriptionTextBox", "I am Updated Optional Description Text Box");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetSaveAndContinueBtnFirstPage", 0);
		CommonMethod.Robustclick("PortfolioSubsetSaveAndContinueBtnFirstPage");		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SelectIndex2CheckBox", 0);
		CommonMethod.ClickCheckbox("SelectIndex2CheckBox"); 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSaveAndExitBtn", 0);
		CommonMethod.Robustclick("PortfolioSaveAndExitBtn");
		
		//Validate Updated Subset Table Name
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetTableName", 0);
		String actualUpdatedSubsetTableName = CommonMethod.getattributeValueByTextContent("PortfolioSubsetTableName").trim();
		CommonMethod.negativesoftassertFieldValid(actualUpdatedSubsetTableName, "I am Subset Name Text Box", "I am Subset Name Text Box text does not matched");
				
		//Validate Updated Subset Table Locations Count
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetTableLocationsCount", 0);
		Thread.sleep(2000);
		String actualUpdatedSubsetTableLocationsCount = CommonMethod.getattributeValueByTextContent("PortfolioSubsetTableLocationsCount").trim();
		CommonMethod.negativesoftassertFieldValid(actualUpdatedSubsetTableLocationsCount, "2", "Table Locations Count does not matched ");
	}
	
	public void V2PilotCreateSubset(String SheetName, int rowNum, String Commodity) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.JavascriptClickElement("LocationTab");
		testlog.info("Given user is on the location page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationTableTr");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTableTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetButton", 0);
		CommonMethod.JavascriptClickElement("PortfolioSubsetButton");  
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetAddNewButton", 0);
		CommonMethod.JavascriptClickElement("PortfolioSubsetAddNewButton");  
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetBtnAfterClickAddNewBtn", 0);
		CommonMethod.JavascriptClickElement("PortfolioSubsetBtnAfterClickAddNewBtn");  
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetNameTextBox", 0);
		CommonMethod.sendKeys("PortfolioSubsetNameTextBox", "I am Subset Name Text Box"); 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDescriptionTextBox", 0);
		CommonMethod.sendKeys("PortfolioDescriptionTextBox", "I am Optional Description Text Box"); 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetSaveAndContinueBtnFirstPage", 0);
		CommonMethod.Robustclick("PortfolioSubsetSaveAndContinueBtnFirstPage");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFiltersPilot", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardFiltersPilot");
		
		//Validate WELL V2-pilot Filter
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetWellVersionDropdown", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioSubsetWellVersionDropdown", "WELL V2-pilot");
		SubsetApplyFilter();
		SubsetCloseModal();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetValidateAppliedFilter", 0);
		String actualAppliedFilterText = CommonMethod.getattributeValueByTextContent("PortfolioSubsetValidateAppliedFilter").trim();
		CommonMethod.negativesoftassertFieldValid(actualAppliedFilterText, "1 filters active", "1 filters active text does not matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetValidateWellV2FilterCount", 0);
		int WellV2PilotCount = CommonMethod.findElements("PortfolioSubsetValidateWellV2FilterCount").size();
		String actualWellV2PilotCount = Integer.toString(WellV2PilotCount);
		CommonMethod.negativesoftassertFieldValidEquals(actualWellV2PilotCount, "6", "6 location count does not matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFiltersPilot", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardFiltersPilot");
		SubsetClearFilter();
		
		//Validate Countries Filter
		pfu.validAssignLocationCountryFilter("India");
		pfu.validAssignLocationFilter("4");
		
		//Validate SpaceType Filter
		pfu.validAssignLocationSpaceTypeFilter("Commercial Kitchen Spaces");
		pfu.validAssignLocationFilter("1");
		
		//Validate OwnershipType Filter
		pfu.validSubsetOwnershipTypeFilter("Owner-occupied");
		pfu.validAssignLocationFilter("3");
		
		//Validate OccupancySizeRange Filter     
		pfu.validSubsetOccupancySizeRangeFilter("10,000 - 49,999 ft²");
		pfu.validAssignLocationFilter("6");
		
		//Validate ConstructionStatus Filter 
		pfu.validSubsetConstructionStatusFilter("Not under construction/renovation");
		pfu.validAssignLocationFilter("6");
		
		//Validate LocationStatus Filter 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetLocationStatusDropdown", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioSubsetLocationStatusDropdown", "Not assigned");
		SubsetApplyFilter();
		pfu.validAssignLocationFilter("6");
		SubsetCloseModal();
		
		//Validate SearchLocation Textbox 		
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardSearchLocationTextbox", 0);
		CommonMethod.sendKeys("PortfolioScorecardSearchLocationTextbox", "location 1");
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetLocationOne", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioSubsetLocationOne", "Location does not matched");
		
		//Validate Save and Continue 	
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetLocationOneCheckbox", 0);
		CommonMethod.ClickCheckbox("PortfolioSubsetLocationOneCheckbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetSaveAndContinueBtnSecondPage", 0);
		CommonMethod.JavascriptClickElement("PortfolioSubsetSaveAndContinueBtnSecondPage"); 
		
		//Click on Save and Exit
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSaveAndExitBtn", 0);
		CommonMethod.Robustclick("PortfolioSaveAndExitBtn");
		
		//Validate Subset Table Name
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetTableName", 0);
		String actualSubsetTableName = CommonMethod.getattributeValueByTextContent("PortfolioSubsetTableName").trim();
		CommonMethod.negativesoftassertFieldValid(actualSubsetTableName, "I am Subset Name Text Box", "I am Subset Name Text Box text does not matched");
		
		//Validate Subset Table Locations Count
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetTableLocationsCount", 0);
		String actualSubsetTableLocationsCount = CommonMethod.getattributeValueByTextContent("PortfolioSubsetTableLocationsCount").trim();
		CommonMethod.negativesoftassertFieldValid(actualSubsetTableLocationsCount, "1", "Table Locations Count does not matched");
		
		//Edit and Update Subset Table
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetTableEditBtn", 0);
		CommonMethod.Robustclick("PortfolioSubsetTableEditBtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetNameTextBox", 0);
		CommonMethod.clearAndSendKey("PortfolioSubsetNameTextBox", "I am Subset Name Text Box"); 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDescriptionTextBox", 0);
		CommonMethod.clearAndSendKey("PortfolioDescriptionTextBox", "I am Updated Optional Description Text Box");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetSaveAndContinueBtnFirstPage", 0);
		CommonMethod.Robustclick("PortfolioSubsetSaveAndContinueBtnFirstPage");		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SelectIndex2CheckBox", 0);
		CommonMethod.ClickCheckbox("SelectIndex2CheckBox"); 
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSaveAndExitBtn", 0);
		CommonMethod.Robustclick("PortfolioSaveAndExitBtn");
		
		//Validate Updated Subset Table Name
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetTableName", 0);
		String actualUpdatedSubsetTableName = CommonMethod.getattributeValueByTextContent("PortfolioSubsetTableName").trim();
		CommonMethod.negativesoftassertFieldValid(actualUpdatedSubsetTableName, "I am Subset Name Text Box", "I am Subset Name Text Box text does not matched");
				
		//Validate Updated Subset Table Locations Count
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetTableLocationsCount", 0);
		Thread.sleep(2000);
		String actualUpdatedSubsetTableLocationsCount = CommonMethod.getattributeValueByTextContent("PortfolioSubsetTableLocationsCount").trim();
		CommonMethod.negativesoftassertFieldValid(actualUpdatedSubsetTableLocationsCount, "2", "Table Locations Count does not matched ");
	}
	
	public void SubsetApplyFilter() throws IOException, InterruptedException { 
		
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Applybutton", 0);
	CommonMethod.JavascriptClickElement("Applybutton");
	}
	
	public void SubsetCloseModal() throws IOException, InterruptedException {
		
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetCloseFilterModal", 0);
	CommonMethod.click("PortfolioSubsetCloseFilterModal");
	}
	
	public void SubsetClearFilter() throws IOException, InterruptedException {
		
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetClearFilter", 0);
	CommonMethod.JavascriptClickElement("PortfolioSubsetClearFilter");
	}

	

	public void TeamPermissionLevel(String SheetName, int rowNum) throws IOException, InterruptedException {
		rc.clickOnTeamTab();
		CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectAddMemberbtn", "V2ProjectEmailAddress");
		testlog.info("And User clicks on Add member button");
		String TeamManagerEmail = data.getCellData(SheetName, "TeamManagerEmail", rowNum);
		String TeamMemberEmail = data.getCellData(SheetName, "TeamMemberEmail", rowNum);
		String PTFTEmail = data.getCellData(SheetName, "PTFTEmail", rowNum);
		String PTLTDEmail = data.getCellData(SheetName, "PTLTDEmail", rowNum);
		String[] EmailDetails = { TeamManagerEmail, TeamMemberEmail, PTFTEmail, PTLTDEmail };
		String[] PermissionsLevel = { "TeamManagerCommon", "TeamMemberCommon", "TeamFullAccessCommon",
				"TeamLimitedCommon" };
		for (int i = 0; i < PermissionsLevel.length; i++) {
			CommonMethod.WaitUntilVisibility("V2ProjectAddMemberbtn", 120);
			CommonMethod.RobustclickElementVisible("V2ProjectAddMemberbtn", "PortfolioEmailAddress");
			CommonMethod.WaitUntilVisibility("PortfolioEmailAddress", 30);
			CommonMethod.sendKeys("PortfolioEmailAddress", EmailDetails[i]);
			testlog.info("And User enter email id field");
			testlog.info("And User enter email id field");
			testlog.info("Team Email ID: " + EmailDetails[i]);
			CommonMethod.selectdropdownVisibletext("PortfolioRole", "Acoustician");
			testlog.info("And User select the Role");
			CommonMethod.ClickCheckbox(PermissionsLevel[i]);
			testlog.info("And User checks the Member checkbox");
			CommonMethod.WaitUntilVisibility("V2ProjectInvitebtn", 30);
			CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn", "V2ProjectAddMemberbtn");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddMemberbtn", 0);
			testlog.info("And User clicks on Invite button");
			testlog.info("Then User will be redirected to Team list page");
			testlog.pass("**Created Team member successfully**");
		}
	}

	public void PurseStatus() throws IOException, InterruptedException {
		// yes
		v2project.RefreshScorecard();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioScoreCardPurseYes", 0);
		CommonMethod.JavascriptClickElement("PortFolioScoreCardPurseYes");
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 30)) {
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioScoreCardPurseYes1", 0);
		CommonMethod.JavascriptClickElement("PortFolioScoreCardPurseYes1");
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 30)) {
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		}
		// MayBe
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioScoreCardPurseMayBe", 0);
		CommonMethod.JavascriptClickElement("PortFolioScoreCardPurseMayBe");
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 30)) {
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioScoreCardPurseMayBe1", 0);
		CommonMethod.JavascriptClickElement("PortFolioScoreCardPurseMayBe1");
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 20)) {
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		}
		// No
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioScoreCardPurseNo", 0);
		CommonMethod.JavascriptClickElement("PortFolioScoreCardPurseNo");
		if (CommonMethod.isElementsExist("PortFolioScoreCardConfirmbtn", 10)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioScoreCardConfirmbtn", 0);
			CommonMethod.RobustclickElementVisible("PortFolioScoreCardConfirmbtn", "PortfolioScorecardPursueToast");
		}
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 20)) {
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioScoreCardPurseNo1", 0);
		CommonMethod.JavascriptClickElement("PortFolioScoreCardPurseNo1");
		if (CommonMethod.isElementsExist("PortFolioScoreCardConfirmbtn", 15)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioScoreCardConfirmbtn", 0);
			CommonMethod.RobustclickElementVisible("PortFolioScoreCardConfirmbtn", "PortfolioScorecardPursueToast");
		}
		if (CommonMethod.isElementsExist("PortfolioScorecardPursueToast", 20)) {
			CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
		}

	}

	public Set<String> findDuplicates(List<String> listContainingDuplicates) {
		final Set<String> setToReturn = new HashSet<>();
		final Set<String> set1 = new HashSet<>();
		for (String feature : listContainingDuplicates) {
			if (!feature.equalsIgnoreCase("Propose Innovation")) {
				if (!set1.add(feature)) {
					setToReturn.add(feature);
				}
			}
		}
		return setToReturn;
	}

	public void ValidateSearchLocationInDocumentLibrary(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		testlog.info("Given User will be redirected to DocumentList page");
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "HsrContainedDocument");
		CommonMethod.scrolldowntoElement("PortfolioDocumentListLink");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardEditLocRowCount", 0);
		CommonMethod.RobustclickElementVisible("HsrContainedDocument", "OwnerOrg");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OwnerOrg", 0);
		CommonMethod.sendKeys("OwnerOrg", "WELL at scale Test location 5");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocSearchNameEnter", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocSearchNameEnter", "PortfolioDocumentListLink");
		Thread.sleep(3000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardEditLocRowCount", 0);
		int PortfolioLocListTr = CommonMethod.ElementSize("PortfolioScorecardEditLocRowCount");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(PortfolioLocListTr), "2",
				"Location Table row count doesn't Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardVerifyFilterReset", 0);
		CommonMethod.Robustclick("PortfolioScorecardVerifyFilterReset");
	}

	public void LocationImportAreaValid(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Location table");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OccupancyIcon", 0);
		CommonMethod.scrolldowntoElement("AddButton");
		int totalsize = CommonMethod.ElementSize("OccupancyIcon");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(totalsize), "4",
				"Location table Occupancy rows Count mismatch");
		testlog.info("Then User verifies location table data");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("table", 0);
		testlog.info("Fetching Data from Upload Table");
		int ImportSizeArea = Math.round(10000 / 250);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc5"),
				String.valueOf(ImportSizeArea),
				"EstArea Calculation and Occupancy column with WELL at scale Test location 5 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc4"),
				String.valueOf(ImportSizeArea),
				"EstArea Calculation and Occupancy column with WELL at scale Test location 4 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc3"),
				String.valueOf(ImportSizeArea),
				"EstArea Calculation and Occupancy column with WELL at scale Test location 3 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc2"),
				String.valueOf(ImportSizeArea),
				"EstArea Calculation and Occupancy column with WELL at scale Test location 2 mismatch");
		// Validate EstArea Calculation and location table column occupancy in WELL at
		// scale Test location 1
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc"), "50",
				"EstArea Calculation and Occupancy column with WELL at scale Test location 1 mismatch");
		testlog.info("And User verifies Location list Table and location count");
		testlog.pass("**Imported Locations successfully**");
	}

	public void EditOccupancylocation(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OccupancyIcon", 2);
		CommonMethod.RobustclickElementVisible("PortfolioEditButtonInLocTable", "PortfolioLocationAdditionalButton");
		Thread.sleep(3000);
		testlog.info("And User clicks on edit location button");
		/*
		 * Validate location Additional fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAdditionalButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationAdditionalButton",
				"PortfolioLocationRadiobuttonContainOutdoorSpaces");
		Thread.sleep(3000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardEstArea", 0);
		int ImportSizeArea = Math.round(10000 / 250);
		Thread.sleep(3000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioScorecardEstArea"),
				String.valueOf(ImportSizeArea),
				"EstArea Calculation and Est Occupancy field in Additional tab data mismatch");
		CommonMethod.clearAndSendKey("PortfolioScorecardEstArea", "30");
		testlog.info("Then User verifies Estimate Area data");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UpdateButton", 0);
		CommonMethod.RobustclickElementVisible("UpdateButton", "Toastermessage");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("UpdateButton", 1);
		testlog.info("And User clicks on update button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OccupancyIcon", 2);
		int totalsize = CommonMethod.ElementSize("OccupancyIcon");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(totalsize), "3",
				"Location table Occupancy icon Count mismatch");
		testlog.info("Then User verifies location table data");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc5"), "30",
				"Edited Est Occupancy field and Occupancy column with WELL at scale Test location 5 mismatch");
	}

	public void VerifySingleLocationTable(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User clicks on LocationsTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OccupancyIcon", 2);
		CommonMethod.fetchTableData("table");
		List<String> val = CommonMethod.fetchTableData("table");
		CommonMethod.negativesoftassertFieldValid(val.get(0), data.getCellData(SheetName, "LocationName", rowNum),
				"LocationName in Location table data mismatch");
		CommonMethod.negativesoftassertFieldValid(val.get(1), data.getCellData(SheetName, "City", rowNum),
				"City Location table data mismatch");
		CommonMethod.negativesoftassertFieldValid(val.get(2), "US", "Country Location table data mismatch");
		Double Area = Double.valueOf(data.getCellData(SheetName, "AreaSQFT", rowNum));
		EstArea = Math.round(Area / 250);
		System.out.println("EstArea: " + String.valueOf(EstArea));
		// Validate EstArea Calculation and location table column occupancy in
		// Automation portfolio Location
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForSingleLoc"),
				String.valueOf(EstArea),
				"EstArea Calculation and Occupancy location table for single location data mismatch");
		testlog.info("Then User verifies Added single location with location table");

	}

	public void VerifySingleLocationOccupancyInAdditionalTab(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		CommonMethod.RobustclickElementVisible("Editlocationbutton", "VerifyEditlocationslider");
		Thread.sleep(3000);
		testlog.info("And User clicks on edit location button");
		/*
		 * Validate location Additional fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAdditionalButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationAdditionalButton",
				"PortfolioLocationRadiobuttonContainOutdoorSpaces");
		Thread.sleep(3000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardEstArea", 0);
		Thread.sleep(3000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("PortfolioScorecardEstArea"),
				String.valueOf(EstArea), "EstArea Calculation and Est Occupancy field in Additional tab data mismatch");
		testlog.info("Then User verifies Estimate Area data");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UpdateButton", 0);
		CommonMethod.Robustclick("UpdateButton");
		testlog.info("And User clicks on update button");
	}

	public void DownloadOccupancylocationFile(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OccupancyIcon", 2);
		FileUtils.cleanDirectory(new File(downloadPath));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDownloadLocation", 0);
		CommonMethod.JavascriptClickElement("PortfolioDownloadLocation");
		testlog.info("And User clicks on Download Review button");
		Thread.sleep(5000);
		boolean fileExistsReturnValue = CommonMethod.isFileDownloaded();
		testlog.info("Then User verifies Downloaded file");
		String fileExists = Boolean.toString(fileExistsReturnValue);
		CommonMethod.negativesoftassertFieldValid(fileExists, "true", "Overview Download Location file doesn't Exist");
		CommonMethod.FileRename(downloadPath, "/Downloads/LocationOccupancyFile.xlsx");
		Thread.sleep(2000);
		portfolioLocationDownload = new XlsReader(
				System.getProperty("user.dir") + "/Downloads/LocationOccupancyFile.xlsx");
		// verify Download file Occupancy column with location table
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr", 6);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc"),
				portfolioLocationDownload.getCellData("Import", "Estimated occupancy",
						portfolioLocationDownload.findRow("Import", "WELL at scale Test location 1"), 2),
				"Download file Occupancy column with WELL at scale Test location 1 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc2"),
				portfolioLocationDownload.getCellData("Import", "Estimated occupancy",
						portfolioLocationDownload.findRow("Import", "WELL at scale Test location 2"), 2),
				"Download file Occupancy column with WELL at scale Test location 2 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc3"),
				portfolioLocationDownload.getCellData("Import", "Estimated occupancy",
						portfolioLocationDownload.findRow("Import", "WELL at scale Test location 3"), 2),
				"Download file Occupancy column with WELL at scale Test location 3 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc4"),
				portfolioLocationDownload.getCellData("Import", "Estimated occupancy",
						portfolioLocationDownload.findRow("Import", "WELL at scale Test location 4"), 2),
				"Download file Occupancy column with WELL at scale Test location 4 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioEstOccupancyForImportLoc5"),
				portfolioLocationDownload.getCellData("Import", "Estimated occupancy",
						portfolioLocationDownload.findRow("Import", "WELL at scale Test location 5"), 2),
				"Download file Occupancy column with WELL at scale Test location 5 mismatch");
	}

	public void VerifyMilestonetab(String SheetName, int rowNum, String editXpath, String LocationName)
			throws Exception {
		testlog.info("Given User is on location tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationPageValid", 0);
		CommonMethod.scrolldowntoElement("LocationPageValid");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Milestonetab", 0);
		CommonMethod.JavascriptClickElement("Milestonetab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MilestoneReviewCycle", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.scrolldowntoElement("table");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTableTr", 0);
		testlog.info("Given User clicks on Milestone tab");
		List<String> tableHeaders = CommonMethod.fetchTableHeaders("table");
		int headersize = tableHeaders.size();
		testlog.info("And User gets Milestone header name");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(headersize), "7", "Header count did not Match");
		testlog.info("And User verifies Milestone header count");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(editXpath, 0);
		CommonMethod.RobustclickElementVisible(editXpath, "EditTargets");
		testlog.info("And User clicks on EditIcon");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTargets", 0);
		testlog.info("And User verifies Milestone EditTargets");
		// Hsr
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditHsrCheckbox", 0);
		CommonMethod.ClickCheckbox("TargetAchievementEditHsrCheckbox");
		testlog.info("And User checks on Hsr TargetAchievement");
		// Wpr
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditWprCheckbox", 0);
		CommonMethod.ClickCheckbox("TargetAchievementEditWprCheckbox");
		testlog.info("And User checks on Wpr TargetAchievement");
		// Wer
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditWerCheckbox", 0);
		CommonMethod.ClickCheckbox("TargetAchievementEditWerCheckbox");
		testlog.info("And User checks on Wer TargetAchievement");
		// PreCertification
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditPreCertficationCheckbox", 0);
		CommonMethod.ClickCheckbox("TargetAchievementEditPreCertficationCheckbox");
		testlog.info("And User checks on PreCertification TargetAchievement");
		// Certification
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditCertficationCheckbox", 0);
		CommonMethod.ClickCheckbox("TargetAchievementEditCertficationCheckbox");
		testlog.info("And User checks on Certification TargetAchievement");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditCertficationLeveldropdown", 0);
		CommonMethod.selectdropdownVisibletext("TargetAchievementEditCertficationLeveldropdown", "Gold");
		testlog.info("And User selects Certfication Level");
		if (LocationName.equalsIgnoreCase("WELL at scale Test location 4")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditTargetCheckbox", 0);
			List<WebElement> ReviewCycle;
			ReviewCycle = CommonMethod.findElements("TargetAchievementEditTargetCheckbox");
			for (WebElement f : ReviewCycle) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditTargetCheckbox", 0);
				CommonMethod.JavascriptClickElement(f);
				testlog.info("And User checks on TargetAchievement");
			}
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditCertficationLeveldropdown", 0);
		CommonMethod.scrolldowntoElement("TargetAchievementEditCertficationLeveldropdown");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditUpdateButton", 0);
		CommonMethod.RobustclickElementVisible("TargetAchievementEditUpdateButton", "table");
		if (CommonMethod.isElementsExist("VerifyUpdateToaster", 30)) {
			CommonMethod.WaitUntilPresence("VerifyUpdateToaster", 120);
			CommonMethod.WaitUntilInVisibility("VerifyUpdateToaster", 180);
			testlog.info("And User verifies Milestone Update Toaster");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Milestonetab", 0);
		CommonMethod.RobustclickElementVisible("Milestonetab", "MilestoneReviewCycle");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "table");
		Thread.sleep(3000);
		CommonMethod.scrolldowntoElement("table");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr", 6);
		Thread.sleep(3000);
		testlog.info("And User fetched Milestone table data");
		if (LocationName.equalsIgnoreCase("WELL at scale Test location 5")) {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioFutureReviewCertification"),
					"Targeting Gold", "Location Certification column with WELL at scale Test location 5 mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioFutureReviewPreCertification"),
					"Targeting", "Location Certification column with WELL at scale Test location 5 mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioFutureReviewHsr"), "Targeting",
					"Location Hsr column with WELL at scale Test location 5 mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioFutureReviewWpr"), "Targeting",
					"Location Wpr column with WELL at scale Test location 5 mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioFutureReviewWer"), "Targeting",
					"Location Wer column with WELL at scale Test location 5 mismatch");
		} else {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioReviewCycleCertification"),
					"Targeting Gold", "Location Certification column with WELL at scale Test location 4 mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioReviewCyclePreCertification"),
					"Targeting", "Location PreCertification column with WELL at scale Test location 4 mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioReviewCycleHsr"), "Targeting",
					"Location Hsr column with WELL at scale Test location 4 mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioReviewCycleWpr"), "Targeting",
					"Location Wpr column with WELL at scale Test location 4 mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioReviewCycleWer"), "Targeting",
					"Location Wer column with WELL at scale Test location 4 mismatch");
		}
		testlog.info("And User verifies location Certification status");
		testlog.info("And User verifies location PreCertification status");
		testlog.info("And User verifies location Hsr status");
		testlog.info("And User verifies location Wpr status");
		testlog.info("And User verifies location Wer status");
		testlog.pass("And User verifies Milestone tab successfully**");
	}

	public void VerifyMilestoneReviewCycle(String ReviewCycleName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Milestonetab", 0);
		CommonMethod.RobustclickElementVisible("Milestonetab", "MilestoneReviewCycle");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MilestoneReviewCycle", 0);
		System.out.println("Future review cycle: " + ReviewCycleName);
		CommonMethod.selectdropdownVisibletext("MilestoneReviewCycle", ReviewCycleName);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		if (ReviewCycleName.equalsIgnoreCase("This review cycle")) {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MilestonePrecertifiedSealTarget"), "1",
					"Precertified Future ReviewCycle Milestone Summary count doesn't Match");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MilestoneHsrSealTarget"), "1",
					"Hsr Future ReviewCycle Milestone Summary count doesn't Match");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MilestoneWprSealTarget"), "1",
					"Wpr Future ReviewCycle Milestone Summary count doesn't Match");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MilestoneWerSealTarget"), "1",
					"Wer Future ReviewCycle Milestone Summary count doesn't Match");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MilestonecertifiedSealTarget"), "1",
					"certified ReviewCycle Milestone Summary count doesn't Match");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MilestonePrecertifiedSealTargetValid", 0);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MilestonePrecertifiedSealTarget"), "2",
					"Precertified Future ReviewCycle Milestone Summary count doesn't Match");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MilestoneHsrSealTarget"), "2",
					"Hsr Future ReviewCycle Milestone Summary count doesn't Match");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MilestoneWprSealTarget"), "2",
					"Wpr Future ReviewCycle Milestone Summary count doesn't Match");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MilestoneWerSealTarget"), "2",
					"Wer Future ReviewCycle Milestone Summary count doesn't Match");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("MilestonecertifiedSealTarget"), "2",
					"certified Future ReviewCycle Milestone Summary count doesn't Match");
		}
		testlog.info("And User verifies location Seal Certification status");
		testlog.info("And User verifies location Seal PreCertification status");
		testlog.info("And User verifies location Seal Hsr status");
		testlog.info("And User verifies location Seal Wpr status");
		testlog.info("And User verifies location Seal Wer status");
		testlog.pass("And User verifies Milestone tab successfully**");
		testlog.pass("And User verifies Milestone tab successfully**");
	}

	public void VerifyMilestoneLocationFilters(String ReviewName) throws IOException, InterruptedException {
		testlog.info("Given User is on LocationsTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Milestonetab", 0);
		CommonMethod.RobustclickElementVisible("Milestonetab", "MilestoneReviewCycle");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("FilterButton", 0);
		CommonMethod.JavascriptClickElement("FilterButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MilestoneReviewCycle", 0);
		CommonMethod.selectdropdownVisibletext("MilestoneReviewCycle", ReviewName);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("MilestoneFilterTarget", 0);
		CommonMethod.ClickCheckbox("MilestoneFilterTarget");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Applybutton", 0);
		CommonMethod.RobustclickElementVisible("Applybutton", "table");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.scrolldowntoElement("AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		int rowCount = CommonMethod.ElementSize("PortfolioLocListTr");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(rowCount), "1",
				"Location Table Row count in Milestone Filter doesn't Match");
		testlog.info("And User verifies location Seal Certification status");
		testlog.info("And User verifies location Seal PreCertification status");
		testlog.info("And User verifies location Seal Hsr status");
		testlog.info("And User verifies location Seal Wpr status");
		testlog.info("And User verifies location Seal Wer status");
		testlog.pass("And User verifies Milestone tab successfully**");
	}

	@SuppressWarnings("static-access")
	public void DownloadAndUpdateMilestonelocationFile(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		testlog.info("Given User is on location tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Milestonetab", 0);
		CommonMethod.RobustclickElementVisible("Milestonetab", "table");
		testlog.info("Given User clicks on Milestone tab");
		FileUtils.cleanDirectory(new File(downloadPath));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDownloadLocation", 0);
		CommonMethod.click("PortfolioDownloadLocation");
		testlog.info("And User clicks on Download Review button");
		Thread.sleep(5000);
		boolean fileExistsReturnValue = CommonMethod.isFileDownloaded();
		testlog.info("Then User verifies Downloaded file");
		String fileExists = Boolean.toString(fileExistsReturnValue);
		CommonMethod.negativesoftassertFieldValid(fileExists, "true",
				"Downloaded Billing Receipt file in Milestone doesn't Exist");
		Thread.sleep(4000);
		CommonMethod.FileRename(downloadPath, "/Downloads/LocationMilestoneFile.xlsx");
		portfolioLocationDownload = new XlsReader(
				System.getProperty("user.dir") + "/Downloads/LocationMilestoneFile.xlsx");
		Thread.sleep(2000);
		portfolioLocationDownload.setCellData("Import", "City", 4, 2, "Yes");
//	portfolioLocationDownload.writeCellValue(,3,3,"Yes");
		// String filePath, String sheetName, int rowNum, int colNum, String data
//"Import","City",4, "Yes", 2
//	portfolioLocationDownload.setCellData("Import", "Is the project targeting WELL Certification?", 4,2, "Yes");
//	portfolioLocationDownload.setCellData("Import", "Is the project targeting WELL Health-Safety Rating?", 4,2, "Yes");
//	portfolioLocationDownload.setCellData("Import", "Is the project targeting WELL Performance Rating?", 4,2, "Yes");
//	portfolioLocationDownload.setCellData("Import", "Is the project targeting WELL Equity Rating?", 4,2, "Yes");
	//	Thread.sleep(70000);
		// LocationImportArea(SheetName, rowNum,LocationMilestoneFile);
		// CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Milestonetab", 0);

	}

	@SuppressWarnings("static-access")
	public void ValidateMilestonelocationFile(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Milestonetab", 0);
		CommonMethod.RobustclickElementVisible("Milestonetab", "table");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		List<String> tableData = CommonMethod.fetchTableData("table");
		testlog.info("And User fetched Milestone table data");
		pfu.ValidTableDataUpdateLocation(tableData, "WELL at scale Test location 3", 21, "Targeting");
		pfu.ValidTableDataUpdateLocation(tableData, "WELL at scale Test location 3", 22, "Targeting");
		pfu.ValidTableDataUpdateLocation(tableData, "WELL at scale Test location 3", 23, "Targeting");
		pfu.ValidTableDataUpdateLocation(tableData, "WELL at scale Test location 3", 24, "Targeting");
		pfu.ValidTableDataUpdateLocation(tableData, "WELL at scale Test location 3", 25, "Targeting");
	}

	public void AdminReviewUpload(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User on Admin Review");
		String[] DocType = { "WER", "WPR", "HSR", "v2p cert" };
		for (String s : DocType) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewUploadButton", 0);
			CommonMethod.RobustclickElementVisible("PortfolioAdminReviewUploadButton",
					"PortfolioAdminReviewSelectDocumentType");
			testlog.info("When User clicks on Upload button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewSelectDocumentType", 0);
			CommonMethod.negativesoftassertFieldValid(
					String.valueOf(CommonMethod.getdropdownSize("PortfolioAdminReviewSelectDocumentType")), "8",
					"DocumentType Dropdown in Review Upload doesn't Match");
			testlog.info("And User verifies DocumentType size successfully**");
			CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewSelectDocumentType", s);
			CommonMethod.uploadFile("DocumentsUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
			testlog.info("And User Upload Feature Document");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewModelUploadButton", 0);
			CommonMethod.RobustclickElementVisible("PortfolioAdminReviewModelUploadButton",
					"PortfolioAdminReviewValidDocumentType");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioImportDocLogWer", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioImportDocLogWer"), "WER",
				"DocumentType Wer doesn't Match");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioImportDocLogWpr"), "WPR",
				"DocumentType Wpr doesn't Match");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioImportLogDocHsr"), "HSR",
				"DocumentType Hsr doesn't Match");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioImportLogDocV2"), "v2p cert",
				"DocumentType V2 doesn't Match");
		testlog.info("And User verifies Added DocumentType in Log successfully**");
		testlog.pass("And User verifies Admin Review Upload successfully**");
	}

	public void AdminReviewImportUploadedFile(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User on AdminReview Import page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioAdminReviewImportButton",
				"PortfolioAdminReviewImportSelectFile");
		testlog.info("When User clicks on Import Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectReviewRound", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewImportSelectReviewRound", "Round 2");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectReviewType", 0);
		String[] DocType = { "WELL V2", "WELL Health-Safety Rating", "WELL Performance Rating", "WELL Equity Rating" };
		for (String s : DocType) {
			CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewImportSelectReviewType", s);
			testlog.info("And user select on ReviewType");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectFile", 0);
			int importFile = CommonMethod.getdropdownSize("PortfolioAdminReviewImportSelectFile");
			CommonMethod.negativesoftassertFieldValid(String.valueOf(importFile), "5",
					"ImportFile dropdown option count Mismatch");
			testlog.info("Then user verifies importFile dropdown option count");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioImportCloseModal", 0);
		CommonMethod.Robustclick("PortfolioImportCloseModal");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioImportCloseModal", 1);
	}

	public void DeleteAdminReviewUpload(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User on AdminReview Import page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewDeleteIconLog", 0);
		int deleteIcon = CommonMethod.ElementSize("PortfolioAdminReviewDeleteIconLog");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(deleteIcon), "4",
				"AdminReview Delete Icon Log doesn't present");
		testlog.info("Then User verifies Upload Review delete icon count");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioImportLogUploadDeleteIcon", 0);
		CommonMethod.RobustclickElementVisible("PortfolioImportLogUploadDeleteIcon",
				"PortfolioImportLogUploadDeleteYesButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioImportLogUploadDeleteYesButton", 0);
		CommonMethod.Robustclick("PortfolioImportLogUploadDeleteYesButton", "PortfolioImportLogUploadDeleteIcon");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioAdminReviewDeleteIconLog", 3);
		int afterDeleteIcon = CommonMethod.ElementSize("PortfolioAdminReviewDeleteIconLog");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(afterDeleteIcon), "3",
				"AdminReview Delete Icon Log doesn't present");
		testlog.info("Then User verifies Upload Review delete icon count");
	}

	public void AdminImportDocumentRulingsV2Review(String Commodity) throws IOException, InterruptedException {
		testlog.info("Given User on AdminReview Import page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioAdminReviewImportButton",
				"PortfolioAdminReviewImportSelectFile");
		testlog.info("When User clicks on Import Button");
		if (Commodity.equalsIgnoreCase("Portfolio")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectReviewRound", 0);
			CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewImportSelectReviewRound", "Round 2");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectReviewType", 0);
			int ReviewType = CommonMethod.getdropdownSize("PortfolioAdminReviewImportSelectReviewType");
			testlog.info("Then user verifies ReviewType dropdown option count");
			CommonMethod.negativesoftassertFieldValid(String.valueOf(ReviewType), "4",
					"ReviewType dropdown option count Mismatch");
			CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewImportSelectReviewType", "WELL V2");
			testlog.info("And user select on ReviewType");
		}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectFile", 0);
			CommonMethod.selectdropdownVisibletextwithoutdelay("PortfolioAdminReviewImportSelectFile",
					"portfoliolocations");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportDocumentRulingsCheckbox",
				0);
		CommonMethod.ClickCheckbox("PortfolioAdminReviewImportDocumentRulingsCheckbox");
		testlog.info("And user checks on Import Document Rulings");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSubmitButton", 0);
		CommonMethod.Robustclick("PortfolioAdminReviewImportSubmitButton",
				"PortfolioAdminReviewImportSelectReviewRound");
		testlog.info("And user clicks on the submit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioAdminReviewImportSelectReviewRound", 1);
	}

	public void AdminImportAchievementsHsrReview(String Commodity) throws IOException, InterruptedException {
		testlog.info("Given User on AdminReview Import page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioAdminReviewImportButton",
				"PortfolioAdminReviewImportSelectFile");
		testlog.info("When User clicks on Import button");
		if (Commodity.equalsIgnoreCase("Portfolio")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectReviewRound", 0);
			CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewImportSelectReviewRound", "Round 2");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectReviewType", 0);
			CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewImportSelectReviewType",
					"WELL Health-Safety Rating");
		}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectFile", 0);
			CommonMethod.selectdropdownVisibletextwithoutdelay("PortfolioAdminReviewImportSelectFile",
					"portfoliolocations");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportAchievementsCheckbox", 0);
		CommonMethod.ClickCheckbox("PortfolioAdminReviewImportAchievementsCheckbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSubmitButton", 0);
		CommonMethod.Robustclick("PortfolioAdminReviewImportSubmitButton",
				"PortfolioAdminReviewImportSelectReviewRound");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioAdminReviewImportSelectReviewRound", 1);
		testlog.info("And user clicks on the submit button");
	}

	public void AdminImportLocationScoresWprReview(String Commodity) throws IOException, InterruptedException {
		testlog.info("Given User on AdminReview Import page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioAdminReviewImportButton",
				"PortfolioAdminReviewImportSelectFile");
		testlog.info("When User clicks on Upload button");
		if (Commodity.equalsIgnoreCase("Portfolio")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectReviewRound", 0);
			CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewImportSelectReviewRound", "Round 2");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectReviewType", 0);
			CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewImportSelectReviewType",
					"WELL Performance Rating");
		}
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectFile", 0);
			CommonMethod.selectdropdownVisibletextwithoutdelay("PortfolioAdminReviewImportSelectFile",
					"portfoliolocations");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportLocationCheckbox", 0);
		CommonMethod.ClickCheckbox("PortfolioAdminReviewImportLocationCheckbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSubmitButton", 0);
		CommonMethod.Robustclick("PortfolioAdminReviewImportSubmitButton",
				"PortfolioAdminReviewImportSelectReviewRound");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioAdminReviewImportSelectReviewRound", 1);
		testlog.info("And user clicks on the submit button");
	}

	public void AdminImportCompareCurrentScoreWerReview() throws IOException, InterruptedException {
		testlog.info("Given User on AdminReview Import page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioAdminReviewImportButton",
				"PortfolioAdminReviewImportSelectFile");
		testlog.info("When User clicks on Upload button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectReviewRound", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewImportSelectReviewRound", "Round 2");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectReviewType", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioAdminReviewImportSelectReviewType", "WELL Equity Rating");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSelectFile", 0);
		CommonMethod.selectdropdownVisibletextwithoutdelay("PortfolioAdminReviewImportSelectFile",
				"portfoliolocations");
		CommonMethod.scrolldowntoElement("PortfolioAdminReviewImportAchievementsCheckbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportCompareCheckbox", 0);
		CommonMethod.ClickCheckbox("PortfolioAdminReviewImportCompareCheckbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportSubmitButton", 0);
		CommonMethod.Robustclick("PortfolioAdminReviewImportSubmitButton",
				"PortfolioAdminReviewImportSelectReviewRound");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioAdminReviewImportSelectReviewRound", 1);
		testlog.info("And user clicks on the submit button");
	}

	public void AdminReviewImportButton() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewImportButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioAdminReviewImportButton",
				"PortfolioAdminReviewValidImportLogFilename");
	}

	public void AdminReviewimportLogs(String Commodity) throws IOException, InterruptedException {

		// Valid Import Review
		testlog.info("And user again clicks on import review result");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAdminReviewValidImportLogFilename", 0);
		List<String> expImportName = new ArrayList<>();
		expImportName.add("Location Scores Imported");
		expImportName.add("Generated Scores for Locations & Portfolio");
		expImportName.add("Achievements Imported & Tasks Updated");
		expImportName.add("Document Rulings Imported");
		List<WebElement> ImportName;
		ImportName = CommonMethod.findElements("PortfolioAdminReviewValidImportLogType");
		for (WebElement s : ImportName) {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText(s), expImportName,
					"Import log Data mismatch: " + expImportName);
			testlog.info("And User verifies Added DocumentType in Log successfully**");
		
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioImportLogcompleteLabel",4);
		int completeLabel = CommonMethod.ElementSize("PortfolioImportLogcompleteLabel");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(completeLabel), "4",
				"Import Log Complete label count mismatch");
		if (Commodity.equalsIgnoreCase("Portfolio")) {
		int roundLabel = CommonMethod.ElementSize("PortfolioImportLogRoundLabel");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(roundLabel), "4",
				"Import Log Round label count mismatch");
		}
		int fileName = CommonMethod.ElementSize("PortfolioImportLogFileName");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(fileName), "3", "Import Log FileName count mismatch");
		List<WebElement> dateLabel;
		dateLabel = CommonMethod.findElements("PortfolioImportLogDocDate");
		for (WebElement date : dateLabel) {
			String getDate = CommonMethod.getText(date);
			String[] stringArray = getDate.split("Imported");
			String[] dateValid = stringArray[1].split(" ");
			String actualDate = dateValid[1] + " " + dateValid[2] + " " + dateValid[3];
			CommonMethod.negativesoftassertFieldValid(actualDate, CommonMethod.ValidateDate(),
					"Review Import log Date Error Mismatch");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioImportCloseModal", 0);
		CommonMethod.Robustclick("PortfolioImportCloseModal");
	}

	public void AdminReviewimportHistory(String Commodity) throws IOException, InterruptedException {
		// Valid Import Review history
		if (Commodity.equalsIgnoreCase("Portfolio")) {
		CommonMethod.refreshBrowser();
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioBackToAllReview", 0);
		CommonMethod.RobustclickElementVisible("PortfolioBackToAllReview", "PortfolioReviewImportHistory");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioReviewImportHistory", 0);
		CommonMethod.RobustclickElementVisible("PortfolioReviewImportHistory",
				"PortfolioAdminReviewValidImportLogFilename");
		CommonMethod.assertisElementPresentTrue("PortfolioImportHistoryRegeneratebtn",
				"Import History Regenerate button is visible");
		AdminReviewimportLogs(Commodity);
		testlog.info("And user verifies imported review data on the history popup");
		testlog.pass("And User Imported review results successfully**");
	}

	public void NavigateLocation() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationsTab", 0);
		CommonMethod.RobustclickElementVisible("LocationsTab", "PortfolioLocationLanding");
		testlog.info("When User clicks on LocationsTab");
	}

	public void ValidAddLocation(String SheetName, int rowNum, String LocationCount) throws Exception {
		CommonMethod.WaitUntilPresence("LocationTab", 120);
		CommonMethod.RobustclickElementVisible("LocationTab", "Subsettab");
		testlog.info("When User clicks on LocationTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.scrolldowntoElement("LocationListTableLoading");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr",
				Integer.parseInt(LocationCount));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationResultCount", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("LocationResultCount"), LocationCount,
				"Result location count doesn't match");
	}

	public void ValidateDocumentInDocumentLibrary() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
		rc.deleteButtonTooltipMessage();
	}

	public void ValidateDocumentInDocumentLibrary(String SheetName, int rowNum, String Access) throws Exception {
		/*
		 * For Document tab
		 */

		if (Access.equalsIgnoreCase("true")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
			CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
			CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
			rc.deleteButtonTooltipMessage();
			Thread.sleep(2000);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RatingDocRestrictDeleteAccesspopup", 0);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("RatingDocRestrictDeleteAccesspopup"),
					toolTipMessage, "Delete Restriction Error Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CancelTooltipPopUpInDocument", 0);
		CommonMethod.RobustclickElementVisible("CancelTooltipPopUpInDocument", PortfolioAndRatingLocAccDocumentTable);
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
			CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
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
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
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

	public void AddingExternalProjectInPortfolioLocation(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.RobustclickElementVisible("LocationTab", "LocationPageValid");
		testlog.info("When User clicks on LocationTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationPageValid", 0);
		CommonMethod.scrolldowntoElement("LocationPageValid");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.RobustclickElementVisible("AddButton", "PortfolioLocationExternalProjectOption");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationExternalProjectOption", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationExternalProjectOption",
				"PortfolioLocationSelectProjectName");
		testlog.info("And User clicks on Add Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationSelectProjectName", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationSelectProjectName",
				"PortfolioLocationEnterProjectName");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationEnterProjectName", 0);
		CommonMethod.JavascriptClickElement("PortfolioLocationEnterProjectName");
		CommonMethod.sendKeys("PortfolioLocationEnterProjectName", data.getCellData("V2Project", "ProjectID", rowNum));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationSelectOptionProjectName", 0);
		CommonMethod.Robustclick("PortfolioLocationSelectOptionProjectName");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationGetNoReviewText", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioLocationGetNoReviewText"), "No reviews ever",
				"No reviews ever message Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationGetContinueUpsellText", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioLocationGetContinueUpsellText"),
				"continue with the upsell process", "upsell process message Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationConfirmButton", 0);
		CommonMethod.Robustclick("PortfolioLocationConfirmButton");

	}

	public void ValidateAddedInLocationList(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationPageValid", 0);
		CommonMethod.scrolldowntoElement("LocationPageValid");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioLocationValidUpsellId").trim(),
				data.getCellData("V2Project", "ProjectID", rowNum), "Upsell location id Mismatch");
	}

	public void ValidatePortfolioAccountBannerInDashboard(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.JavascriptClickElement("WellV2DashboardTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccBannerCongratsText", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioAccBannerCongratsText"),
				"Congratulations on adding new location", "Upsell Portfolio Account Banner Congrats Text Mismatch");
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioAccBannerLocationDocumentText"),
				"The location(s) below have documents that need your input",
				"Upsell Portfolio Account Banner Attention Text Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccBannerLink", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioAccBannerLink",
				"Portfolio Account Banner Link element not present");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccBannerLink", 0);
		CommonMethod.RobustclickElementVisible("PortfolioAccBannerLink", "PortfolioLocationValidUpsellIdInDasboard");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationValidUpsellGoToLocation", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationValidUpsellIdInDasboard", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioLocationValidUpsellIdInDasboard"),
				data.getCellData("V2Project", "ProjectID", rowNum), "Upsell location id Mismatch");
		CommonMethod.JavascriptClickElement("PortfolioLocationValidUpsellGoToLocation");
		CommonMethod.switchToChildTab();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDocUploadbtn", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationValidUpsellMigratedDocuments", 0);
		CommonMethod.scrolldowntoElement("PortfolioLocationValidUpsellMigratedDocuments");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioLocationValidUpsellMigratedDocumentsAttention", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioLocationValidUpsellMigratedDocumentsAttention"),
				"There are documents that need your attention", "Upsell Attention Message Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioLocationValidUpsellMigratedDocumentsFileName", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioLocationValidUpsellMigratedDocumentsFileName"),
				"FeatureFile", "Filename Mismatch");
		CommonMethod.assertisElementPresentTrue("PortfolioLocationValidUpsellMigratedDocumentsverificationMethod",
				"Portfolio Account Banner Link verificationMethod element not present");
		CommonMethod.assertisElementPresentTrue("PortfolioLocationValidUpsellMigratedDocumentsspaceType",
				"Portfolio Account Banner Link spaceType element not present");
		CommonMethod.assertisElementPresentTrue("PortfolioLocationValidUpsellMigratedDocumentspartOption",
				"Portfolio Account Banner Link partOption element not present");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioLocationValidUpsellMigratedDocumentsConfirmbtn", 0);
		testlog.pass("**Validate PortfolioAccount Banner In Dashboard successful**");
	}

	public void ValidateLocationAccountBannerInDashboard(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.RobustclickElementVisible("WellV2DashboardTab", "PortfolioAccBannerCongratsText");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccBannerCongratsText", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioAccBannerCongratsText"),
				"Congratulations on adding", "Upsell location Account Banner Congrats Text Mismatch");
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioAccBannerLocationDocumentText"),
				"Please confirm or update", "Upsell location Account Banner Attention Text Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccBannerLink", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioAccBannerLink",
				"Portfolio Account Banner Link element not present");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccBannerLink", 0);
		CommonMethod.JavascriptClickElement("PortfolioAccBannerLink");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDocUploadbtn", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationValidUpsellMigratedDocuments", 0);
		CommonMethod.scrolldowntoElement("PortfolioLocationValidUpsellMigratedDocuments");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioLocationValidUpsellMigratedDocumentsAttention", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioLocationValidUpsellMigratedDocumentsAttention"),
				"There are documents that need your attention", "Upsell Attention Message Mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioLocationValidUpsellMigratedDocumentsFileName", 0);
		CommonMethod.selectdropdownVisibletextwithoutdelay(
				"PortfolioLocationValidUpsellMigratedDocumentsverificationMethod", "Performance Test OR Sensor Data");
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioLocationValidUpsellMigratedDocumentsFileName"),
				"FeatureFile", "Upsell Filename Mismatch");
		CommonMethod.assertisElementPresentTrue("PortfolioLocationValidUpsellMigratedDocumentsverificationMethod",
				"Portfolio Account Banner Link verificationMethod element not present");
		CommonMethod.assertisElementPresentTrue("PortfolioLocationValidUpsellMigratedDocumentsspaceType",
				"Portfolio Account Banner Link spaceType element not present");
		CommonMethod.assertisElementPresentTrue("PortfolioLocationValidUpsellMigratedDocumentspartOption",
				"Portfolio Account Banner Link partOption element not present");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioLocationValidUpsellMigratedDocumentsConfirmbtn", 0);
		CommonMethod.Robustclick("PortfolioLocationValidUpsellMigratedDocumentsConfirmbtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan(
				"PortfolioLocationValidUpsellMigratedDocumentsConfirmbtn", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioLocationValidUpsellMigratedDocuments", 1);
		CommonMethod.switchToParentTab();
		Thread.sleep(3000);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
	}

	public void storeLocationId(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.scrolldowntoElement("table");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTableTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("getLocationId", 0);
		String locationId = CommonMethod.getattributeValueByTextContent("getLocationId");
		System.out.println("locationId: " + locationId);
		data.setCellData(SheetName, "LocationProjectID", rowNum, locationId);
	}

	public void HSROptnLocationAccount() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HealthSafetyTab", 0);
		CommonMethod.RobustclickElementVisible("HealthSafetyTab", "PortfolioAccConfirmEnrollment");
		testlog.info("When User clicks on HealthSafetyTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccConfirmEnrollment", 0);
		CommonMethod.Robustclick("PortfolioAccConfirmEnrollment");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioAccConfirmEnrollment", 1);
	}

	public void HSROptnProfolioAccount() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("HealthSafetyTab", 300);
		CommonMethod.RobustclickElementVisible("HealthSafetyTab", "HSRScorecardTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HSRScorecardTab", 0);
		CommonMethod.RobustclickElementVisible("HSRScorecardTab", "PortfolioHSRScorecardTabcustomizescorecardheading");
	}

	public void HSROptnDocumentProfolioAccount(String featureName, String SheetName, int rowNum, String Commodity)
			throws Exception {

		if (featureName.equalsIgnoreCase("Support Handwashing")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HealthSafetyTab", 0);
			CommonMethod.RobustclickElementVisible("HealthSafetyTab", "OptnDocumentTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OptnDocumentTab", 0);
			CommonMethod.RobustclickElementVisible("OptnDocumentTab", "PortfolioDocumentListLink");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
			CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
			CommonMethod.scrolldowntoElement("PortfolioDocumentListLink");
			pathprms.put("PartId", "SC1");
			pathprms.put("VerificationMethod", "Policy and/or Operations Schedule");
			pathprms.put("Stage", "Feature");
			pathprms.put("Status", "Ready For Review");
			generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, false, true, true,
					true, true, false);

		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PerformanceTab", 0);
			CommonMethod.RobustclickElementVisible("PerformanceTab", "OptnDocumentTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OptnDocumentTab", 0);
			CommonMethod.RobustclickElementVisible("OptnDocumentTab", "PortfolioDocumentListLink");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
			CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
			CommonMethod.scrolldowntoElement("PortfolioDocumentListLink");
			pathprms.put("PartId", "PA1");
			pathprms.put("VerificationMethod", "Performance Test");
			pathprms.put("Stage", "Feature");
			pathprms.put("Status", "Ready For Review");
			generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, false, true, true,
					true, true, false);

		}
		CommonMethod.refreshBrowser();
		testlog.info("And User verifies Edit Icon in Document table");
		testlog.info("And User verifies Delete Icon in Document table");
		testlog.pass("**Verifies Document library Upload document successful**");

	}

	public void ValiateScorecardUploadDocInHSROptnPortfolioAccount(String featureName, String SheetName, int rowNum,
			String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		boolean flag = false;
		CommonMethod.scrolldowntoElement("V2ProjectWPRScorecardLanding");
		for (WebElement f : Feature) {
			String Creditname = f.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.WaitUntilClickble(f, 180);
				CommonMethod.JavascriptClickElement(f);
				testlog.info("When Click on " + Creditname + " feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 180);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 180);
				CommonMethod.JavascriptClickElement("PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on AddOption button");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddButton", 180);
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				testlog.info("And User clicks on Add Button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScoreCardVerificationCloseicon", 1);
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				if (featureName.equalsIgnoreCase("Support Handwashing")) {
					pathprms.put("PartId", "SC1");
					pathprms.put("VerificationMethod", "Policy and/or Operations Schedule");
					pathprms.put("Stage", "Feature");
					pathprms.put("Status", "Ready For Review");
					generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, false, true,
							true, true, true, false);
				} else {
					pathprms.put("PartId", "PA1");
					pathprms.put("VerificationMethod", "Performance Test");
					pathprms.put("Stage", "Feature");
					pathprms.put("Status", "Ready For Review");
					generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, false, true,
							true, true, true, false);
				}
				CommonMethod.JavascriptClickElement(f);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +featureName +" doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void wprOptnLocationAccount() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PerformanceTab", 0);
		CommonMethod.RobustclickElementVisible("PerformanceTab", "PortfolioHSRconfirmenrollbuttton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHSRconfirmenrollbuttton", 0);
		CommonMethod.Robustclick("PortfolioHSRconfirmenrollbuttton");
		rc.ScorecardLoading();
	}

	public void wprOptnPortfolioAccount() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PerformanceTab", 0);
		CommonMethod.RobustclickElementVisible("PerformanceTab", "PortfolioHSRconfirmenrollbuttton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHSRconfirmenrollbuttton", 0);
		CommonMethod.Robustclick("PortfolioHSRconfirmenrollbuttton");
		rc.ScorecardLoading();
	}

	public void wprOptnPortfolioAccount1() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PerformanceTab", 0);
		CommonMethod.RobustclickElementVisible("PerformanceTab", "WPRScorecardTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRScorecardTab", 0);
		CommonMethod.RobustclickElementVisible("WPRScorecardTab", "PortfolioHSRScorecardTabcustomizescorecardheading");
		rc.ScorecardLoading();
	}

	public void uploadDocumentInOptnFeature(String featureName) throws Exception {
		rc.ScorecardLoading();
		boolean flag = false;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		for (WebElement f : Feature) {
			String Creditname = f.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.WaitUntilClickble(f, 120);
				CommonMethod.JavascriptClickElement(f);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPDocIcon", 0);
				CommonMethod.RobustclickElementVisible("V2ProjectWPRPDocIcon", "V2ProjectDocUpload");
				CommonMethod.uploadFile("V2ProjectDocUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
				CommonMethod.WaitUntilPresence("FeatureFileUploadedVisible", 60);
				if (!CommonMethod.isElementsExist("V2ProjectScorecardSelectedDocTypeValid", 5)) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"V2ProjectScorecardVerificationMethodSelect", 0);
					CommonMethod.click("V2ProjectScorecardVerificationMethodSelect");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SelectOwnerOrgDyn", 0);
					List<WebElement> ele = CommonMethod.findElements("SelectOwnerOrgDyn");
					ele.get(0).click();
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationSelectFeature",
						0);
				testlog.info("And User select Partname");
				if (CommonMethod.isElementsExist("PortfolioScoreCardVerificationSelectSpaceType", 5)) {
					CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
					testlog.info("And User Select SpaceType");
				}
				if (CommonMethod.isElementsExist("PortfolioScoreCardVerificationSelectOption", 5)) {
					CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
					testlog.info("And User Select Option");
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPartbtn", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPartbtn",
						"V2ProjectScorecardVerificationMethodValidAddedPart");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadRemovelink", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRUploadbtn1", 0);
				CommonMethod.Robustclick("V2ProjectWPRUploadbtn1");
				rc.uploadDocumentToastMessage();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTableTr, 0);
				break;
			}
			CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +featureName +" doesn't match");
			testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
		}
	}

	public void DeleteUploadDocumentInScorecardFeature(String FeatureName) throws IOException, InterruptedException {
		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				v2project.DeleteDocV2ProjectInsideScorecard();
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +FeatureName +" doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void validDeletedUploadDocumentInScorecardFeature(String FeatureName)
			throws IOException, InterruptedException {
		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("V2ProjectUploadDocDeleteIcon");
				CommonMethod.assertisElementPresentFalse("V2ProjectUploadDocDeleteIcon",
						"Deleted Upload Document is visible");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +FeatureName +" doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void NavigateAddedLocation(String SheetName, int rowNum) throws IOException, InterruptedException, ClientApiException {
		login.AdminLogin();
		testlog.info("Given User is on Dashboard page");
		String Id = data.getCellData(SheetName, "LocationProjectID", rowNum).trim();
		System.out.println("LocationProjectID:" + Id);
		testlog.info("LocationProjectID:" + Id);
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("AdminWELLCertificationNavBar", "AdminV2ProjectId");
		testlog.info("And User clicks on Admin WELL Certification from top menu under Projects");
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60).sendKeys(Id);
		testlog.info("And User enter on ProjectID in  AdminV2ProjectId field");
		CommonMethod.RobustclickElementVisible("AdminV2ProjectApplybtn", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSearchResultIDVerify", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectSearchResultIDVerify"), Id,
				"ProjectID doesn't matches in search");
		CommonMethod.WaitUntilPresence("V2ProjectIdCompare", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectIdCompare", "V2ProjectStartBuilding");
		CommonMethod.WaitUntilVisibility("V2ProjectStartBuilding", 60);
	}

	public void ValidateAcheivementTabAndNavigateToLocationAccount(String SheetName, int rowNum)
			throws IOException, InterruptedException, ClientApiException {

		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AchievementsTab", 1);
		CommonMethod.assertisElementPresentFalse("AchievementsTab", "AchievementsTab is present");
		pfu.StoreLocationId(SheetName, rowNum);
		portfolio.NavigateAddedLocation(SheetName, rowNum);
	}

	public void BeforeValidatingPromotionInLocationAccount() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PromotionTab", 60);
		CommonMethod.RobustclickElementVisible("PromotionTab", "PromotionCardContainer");
		testlog.info("When User clicks on PromotionTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PromotionCardContainer", 0);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(CommonMethod.ElementSize("PromotionCardContainer")),
				"3", "Before Promotion Card count empty doesn't match");

	}

	public void AfterValidatingPromotion(String CardCount) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("PromotionTab", 60);
		CommonMethod.RobustclickElementVisible("PromotionTab", "PromotionCardContainer");
		testlog.info("When User clicks on PromotionTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PromotionCardContainer", 0);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(CommonMethod.ElementSize("PromotionCardContainer")),
				CardCount, "After Promotion Card count empty doesn't match");

	}

	public void downloadFileExist(String DownloadFile) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(DownloadFile, 0);
		List<WebElement> clickFile = CommonMethod.findElements(DownloadFile);
		for (WebElement ele : clickFile) {
			CommonMethod.click(ele);
			Thread.sleep(5000);
			if (TestCaseName.equalsIgnoreCase("Portfolio_TC_23_05_ValidateAchievementTabInPortfolioAccount")) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AchievementToasterMessage", 0);
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getattributeValueByTextContent("AchievementToasterMessage"), "download link",
						"Achievement Toaster Message doesn't match");
				Thread.sleep(3000);
			} else {
				boolean fileExistsReturnValue = CommonMethod.isFileDownloaded();
				testlog.info("Then User verifies Downloaded file");
				String fileExists = Boolean.toString(fileExistsReturnValue);
				CommonMethod.negativesoftassertFieldValid(fileExists, "true", "Downloaded Card file doesn't Exist");
				CommonMethod.ClearDownloadFile();
			}
		}
	}

	public void ValidateAcheivementTabAndCard(String CardCount) throws IOException, InterruptedException {

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AchievementsTab", 0);
		CommonMethod.assertisElementPresentTrue("AchievementsTab", "AchievementsTab is not present");
		CommonMethod.RobustclickElementVisible("AchievementsTab", "PromotionCardContainer");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PromotionCardContainer", 0);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(CommonMethod.ElementSize("PromotionCardContainer")),
				CardCount, "AcheivementTab Card count empty doesn't match");

	}

	public void editAdminAsCertification() throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.Robustclick("V2ProjectAdminFieldsButton", "V2ProjectProjectNameInput");
		testlog.info("And User clicks on AdminFields Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectEditCertificationStatus", 0);
		CommonMethod.selectdropdownVisibletext("V2ProjectEditCertificationStatus", "Bronze");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectEditDateCertified", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectEditDateCertified", "DatePickerOkButton");
		Thread.sleep(1000);		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DatePickerOkButton", 0);
		CommonMethod.click("DatePickerOkButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSaveChangesButton", 0);
		CommonMethod.click("V2ProjectSaveChangesButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("V2ProjectSaveChangesButton", 1);
		if (CommonMethod.isElementsExist("ScorecardBannerClose", 30)) {
			CommonMethod.Robustclick("ScorecardBannerClose");
		}
	}

	public void AuditScorecardUpload(String featureName, String SheetName, int rowNum, String ProjectType,
			String Commodity, String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/** ScoreCard Add option */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 60);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 120);
				generic.assignLocationGeneric(Commodity, true, false, false, false, false);
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1);
				testlog.info("And User checks the AssignLocation checkbox");
				CommonMethod.scrolldowntoElement("PortfolioSaveAndExitBtn");
				rc.ScorecardConfirmLocUploadSaveButton();
				testlog.info("And User clicks on save button");
				rc.uploadDocumentToastMessage();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				pathprms.put("LocationCount", "1 Assigned");
				pathprms.put("PartId", "A02.2");
				pathprms.put("VerificationMethod", "Audit");
				pathprms.put("Stage", "Audit");
				pathprms.put("Status", "Ready For Review");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, true, true,
						true, true, true, false);
				testlog.info("And User verifies Upload Document Table Data");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardTaskPurseLocation"),
						"1/2 Locations", "Task Assign Location Count doesn't match");
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Verifies the Audit Scorecard Upload successful**");
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +featureName +" doesn't match");
	}
	
	public void uploadAndValidateFulfilledDocs(String featureName, String SheetName, int rowNum, String ProjectType,
			String Commodity, String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/** ScoreCard Add option */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 60);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 120);
				pathprms.put("StartAssignLoc", "1");
				pathprms.put("EndAssignLoc", "2");
				generic.assignLocationGeneric(Commodity, false, false, false, true, false);
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
				testlog.info("And User checks the AssignLocation checkbox");
				CommonMethod.scrolldowntoElement("PortfolioSaveAndExitBtn");
				rc.ScorecardConfirmLocUploadSaveButton();
				testlog.info("And User clicks on save button");
				rc.uploadDocumentToastMessage();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTableTr, 0);
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Verifies the Audit Scorecard Upload successful**");
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +featureName +" doesn't match");
		portfolio.clickDocument();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTaskTab", 0);
		CommonMethod.RobustclickElementVisible("WPRTaskTab", "PortfolioDocListTaskFullFilledTab");
		CommonMethod.scrolldowntoElement("WPRTaskTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.click("PortfolioDocListTaskFullFilledTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListA1.1", 0);
		CommonMethod.click("PortfolioDocListA1.1");
		generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FeaturefileUpload, false, false, false, false);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
		CommonMethod.clickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 5);
		testlog.info("And User checks the AssignLocation checkbox");
		CommonMethod.scrolldowntoElement("PortfolioSaveAndExitBtn");
		rc.ScorecardConfirmLocUploadSaveButton();
		testlog.info("And User clicks on save button");
		rc.uploadDocumentToastMessage();
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardTaskPurseLocation"),
				"2/2 Locations", "Task Assign Location Count doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioSaveAndExitBtn", 1);
	}
	
	public void validatePortfolioAchievementDocument(String documentDownloadBtnObjectLocator, String actualDownloadedFileMsg, String expectedMessage) throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(documentDownloadBtnObjectLocator, 0);
		CommonMethod.click(documentDownloadBtnObjectLocator);
		testlog.info("Then User Downloaded The Documents and Validated the Text");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(actualDownloadedFileMsg, 0);
		String actualDownloadFileTextObjectLocator = CommonMethod.getattributeValueByTextContent(actualDownloadedFileMsg).trim();
		CommonMethod.negativesoftassertFieldValid(actualDownloadFileTextObjectLocator, expectedMessage, "Downloaded Text Message Does not Matched");
	}
	
	public void SingleUploadScorecardDocumentInOptn(String FeatureName, String SheetName, int rowNum, String Commodity,String FileName,Boolean PartNameRequired, Boolean VerificationMethodValidationRequired, Boolean NoteRequired,  Boolean IntentCheckboxRequired) throws Exception {
		
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
			 Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
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
			CommonMethod.RobustclickElementVisible("WPRVerficationTab", "WPRAddOption");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOption", 0);
			CommonMethod.JavascriptClickElement("WPRAddOption");
			if (FileName.contains("Audit") || FileName.contains("Feature")) {
				if (TestCaseName.equalsIgnoreCase("Portfolio_TC_18_01_HSRScoreCardUploadDocumentPortfolio")) {
				 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AuditAddButton", 0);
				CommonMethod.RobustclickElementVisible("AuditAddButton","ScorecardAddedOption"); 
			}
			else {
				 CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOptionbtn", 0);
					CommonMethod.RobustclickElementVisible("WPRAddOptionbtn","ScorecardAddedOption");
			}
				CommonMethod.Robustclick("WPRAddOptionCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRAddOptionCloseIcon", 1);
				generic.assignLocationGeneric(Commodity, true, false, false, false, false);
			} 
			if (FeatureName.contains("Promote a Smoke-Free Environment")) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHsrOptnUploadButtonAudit", 0);
				CommonMethod.JavascriptClickElement("PortfolioHsrOptnUploadButtonAudit");
				}
		    else {
					CommonMethod.JavascriptClickElement("PortfolioHsrOptnUploadButtonFeature");
				}
			generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired, VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
			CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1);
			testlog.info("And User checks the AssignLocation checkbox");
			CommonMethod.scrolldowntoElement("PortfolioSaveAndExitBtn");
			rc.ScorecardConfirmLocUploadSaveButton();
			testlog.info("And User clicks on save button");
			rc.uploadDocumentToastMessage();
	         break;		
			}
	}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +FeatureName +" doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}
	
	public void upsellHSROptnLocationAccount() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioGetUpsellLocationId", 0);
		CommonMethod.JavascriptClickElement("PortfolioGetUpsellLocationId");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HealthSafetyTab", 0);
		CommonMethod.RobustclickElementVisible("HealthSafetyTab", "PortfolioAccConfirmEnrollment");
		testlog.info("When User clicks on HealthSafetyTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccConfirmEnrollment", 0);
		CommonMethod.Robustclick("PortfolioAccConfirmEnrollment");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioAccConfirmEnrollment", 1);
		CommonMethod.switchToParentTab();
	}
	
	public void assignedTaskNavigate(Boolean AssignedTask) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignedTasksTab", 0);
		CommonMethod.RobustclickElementVisible("AssignedTasksTab", "WELLV2Tab");
		if(AssignedTask) {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WELLV2Tab", 0);
		CommonMethod.RobustclickElementVisible("WELLV2Tab", "PortfolioNoAssignmentText");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioNoAssignmentText", 0);
		String getExpectedPartId = CommonMethod.getattributeValueByTextContent("PortfolioNoAssignmentText");
		CommonMethod.negativesoftassertFieldValid(getExpectedPartId, "Version mismatch", "Version mismatch in Location Account not matched");
		}
		else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectHsrOptnhsrDocumentLibrary", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectHsrOptnhsrDocumentLibrary", "PortfolioNoAssignmentText");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioNoAssignmentText", 0);
		String getExpectedPartId = CommonMethod.getattributeValueByTextContent("PortfolioNoAssignmentText");
		CommonMethod.negativesoftassertFieldValid(getExpectedPartId, "No assignments in WELL at scale scorecard", "No assignments in Location Account not matched");
		}	
	}
	
	public void ValidateWERSection() throws IOException, InterruptedException {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationsTab", 0);
		CommonMethod.click("LocationsTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioClickOnLocation", 0);
		CommonMethod.click("PortfolioClickOnLocation");
		CommonMethod.switchToChildTab();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.click("EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.click("V2ProjectAdminFieldsButton");
		String expectedWERTextAndSectionInAdminFields = CommonMethod.getattributeValueByTextContent("PortfolioWERTextInAdminFields");
		CommonMethod.negativesoftassertFieldValid(expectedWERTextAndSectionInAdminFields, "WELL Equity Rating", "WELL Equity Rating Section does not matched");
		CommonMethod.switchToParentTab();
	}
	
	public void validateRecertificationButtonInAdminField(String SheetName, int rowNum) throws Exception {
		pfu.StoreLocationId(SheetName, rowNum);
		portfolio.NavigateAddedLocation(SheetName, rowNum);
		navigateWERPortfolioOpt();
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
	CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
	CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "PortfolioCoachingContacts");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAccountAdminRatingLabel", 0);
	String[] expRatingName = { "WELL Health-Safety Rating","WELL Performance Rating", "WELL Equity Rating" };
	List<WebElement> RatingName;
	RatingName = CommonMethod.findElements("PortfolioLocationAccountAdminRatingLabel");
	int i = 0;
	for (WebElement s : RatingName) {
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText(s), expRatingName[i],
				"Import log Data mismatch: " + expRatingName[i]);
		testlog.info("And User verifies Added DocumentType in Log successfully**");
		i = i + 1;
	}
	rc.editAdminAchieveDate();
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
	CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
	CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "PortfolioLocationAccountCreateRecertifiedButton");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAccountCreateRecertifiedButton", 0);
	CommonMethod.RobustclickElementVisible("PortfolioLocationAccountCreateRecertifiedButton", "PortfolioLocationAccountRecertifiedYesButton");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAccountRecertifiedYesButton", 0);
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAccountRecertifiedNoButton", 0);
//No
	CommonMethod.Robustclick("PortfolioLocationAccountRecertifiedNoButton");
	CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocationAccountCreateRecertifiedButton",1);
	CommonMethod.assertisElementPresentTrue("PortfolioLocationAccountCreateRecertifiedButton","Create RecertifiedButton is not visible");
	//Yes
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAccountCreateRecertifiedButton", 0);
	CommonMethod.RobustclickElementVisible("PortfolioLocationAccountCreateRecertifiedButton", "PortfolioLocationAccountRecertifiedYesButton");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAccountRecertifiedYesButton", 0);
	CommonMethod.Robustclick("PortfolioLocationAccountRecertifiedYesButton");
	CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocationAccountRenewalFieldsButton",1);
	CommonMethod.assertisElementPresentTrue("PortfolioLocationAccountRenewalFieldsButton","RenewalFields is not visible");
	
	}
	
	public void navigateToUpsellLocationId(String SheetName, int rowNum, String UpsellLocationId) throws Exception {
		rc.SignOut();
		login.Login();
		portfolio.SearchPortfolioById(SheetName, rowNum);	
		rc.locationNavigate();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(UpsellLocationId, 0);
		CommonMethod.JavascriptClickElement(UpsellLocationId);
		CommonMethod.switchToChildTab();
		
	}
	
	public void validateDashboardInLocationAccount() throws Exception {
		testlog.info("Given User is on Dashboard page");
		testlog.info("Then User will be redirected to Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.assertisElementPresentTrue("WellV2DashboardTab", "WellV2DashboardTab element is not Present");
		CommonMethod.assertisElementPresentTrue("HealthSafetyTab", "HealthSafetyTab element is not Present");
		CommonMethod.assertisElementPresentTrue("PerformanceTab", "PerformanceTab element is not Present");
		CommonMethod.assertisElementPresentTrue("EquityTab", "EquityTab element is not Present");	
		CommonMethod.assertisElementPresentTrue("AssignedTasksTab", "AssignedTasksTab element is not Present");
	    CommonMethod.assertisElementPresentTrue("DocumentLibraryTab", "DocumentLibraryTab element is not Present");
	    CommonMethod.assertisElementPresentTrue("ReviewTab", "ReviewTab element is not Present");
	    CommonMethod.assertisElementPresentTrue("ProfileTab", "ProfileTab element is not Present");
		CommonMethod.assertisElementPresentTrue("PromotionTab", "PromotionTab element is not Present");
		CommonMethod.assertisElementPresentTrue("TeamTab", "TeamTab element is not Present");
		CommonMethod.assertisElementPresentTrue("SupportTab", "SupportTab element is not Present");
		CommonMethod.assertisElementPresentTrue("AlternativesTab", "AlternativesTab element is not Present");
		CommonMethod.assertisElementPresentTrue("OverviewTab", "OverviewTab element is not Present");
		if (TestCaseName.equalsIgnoreCase("Portfolio_USTC_05_06_UpsellRegistrationInProgressValidateDashboardInLocationAccount")) {
			CommonMethod.assertisElementPresentTrue("ScorecardTab", "ScorecardTab element is not Present");
			CommonMethod.assertisElementPresentTrue("BiilingTab", "BiilingTab element is not Present");
			
		}
		else {
			CommonMethod.assertisElementPresentTrue("V2ProjectStartBuilding", "V2ProjectStartBuilding element is not Present");
				
		}
			softAssert.assertAll();
		CommonMethod.switchToParentTab();
		testlog.info("And User verifies Dashboard fields and SideBar Navigation tab");
		testlog.pass("**Verifies Dashboard fields and SideBar Navigation tab successfully **");
}
	
	public void ValidateTaskCompletionOnAddingOptionFromDocEdit(String SheetName, int rowNum, String ProjectTypeVerification, String ProjectType,
			String Commodity, String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired, String featureName) throws Exception {
		
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
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
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
		CommonMethod.click("PortfolioScoreCardAddOptionbutton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddButtonOne", 0);
		CommonMethod.click("PortfolioScoreCardAddButtonOne");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddButtonTwo", 0);
		CommonMethod.click("PortfolioScoreCardAddButtonTwo");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
		AssignLocations();
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
		CommonMethod.selectdropdownVisibletext("PortfolioScoreCardPartDropdown", "A01.1");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardSelectSpaceTypeFromDropdown", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioScoreCardSelectSpaceTypeFromDropdown", "All Spaces");		
		
		if(ProjectType.contains("pilot")) {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardSelectOptionFromDropdown", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioScoreCardSelectOptionFromDropdown", "Option 2");
			
		} else {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardSelectOptionFromDropdown", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioScoreCardSelectOptionFromDropdown", "Option 2 Modified thresholds in polluted regions");
			
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPart", 0);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
				"PortfolioScoreCardVerificationUploadAddfeature");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndExitbtnUploadPage", 0);
		CommonMethod.Robustclick("SaveAndExitbtnUploadPage"); 
		CommonMethod.scrolldowntoElement("PortfolioHsrOptnUploadButtonOptionOne");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTablePartIdOne", 0);
		String actualTablePartIdOne = CommonMethod.getattributeValueByTextContent("PortfolioTablePartIdOne").trim();
		CommonMethod.negativesoftassertFieldValid(actualTablePartIdOne, "A01.1", "A01.1 text does't matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTableOptionsOne", 0);
		String actualTableOptionsOne = CommonMethod.getattributeValueByTextContent("PortfolioTableOptionsOne").trim();
		CommonMethod.negativesoftassertFieldValid(actualTableOptionsOne, "Option 1", "Option 1 text does't matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTablePartIdTwo", 0);
		String actualTablePartIdTwo = CommonMethod.getattributeValueByTextContent("PortfolioTablePartIdTwo").trim();
		CommonMethod.negativesoftassertFieldValid(actualTablePartIdTwo, "A01.1", "A01.1 text does't matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTableOptionsTwo", 0);
		String actualTableOptionsTwo = CommonMethod.getattributeValueByTextContent("PortfolioTableOptionsTwo").trim();
		CommonMethod.negativesoftassertFieldValid(actualTableOptionsTwo, "Option 2", "Option 2 text does't matched");
		
		if(ProjectType.contains("pilot")) {
		
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardUploadedDocLocationCountASECKS", 0);
		String actualUploadedDocLocationCount = CommonMethod.getattributeValueByTextContent("ScorecardUploadedDocLocationCountASECKS").trim();
		CommonMethod.negativesoftassertFieldValidEquals(actualUploadedDocLocationCount, "2/2 Locations", "2/2 Locations count does't matched");
		} else {
			
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardUploadedDocLocationCountMTPR", 0);
		String actualUploadedDocLocationCount = CommonMethod.getattributeValueByTextContent("ScorecardUploadedDocLocationCountMTPR").trim();
		CommonMethod.negativesoftassertFieldValidEquals(actualUploadedDocLocationCount, "2/2 Locations", "2/2 Locations count does't matched");
		}
		CommonMethod.JavascriptClickElement(ele);
		break;
	    }
	   }
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " +featureName +" doesn't match");
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
	
	public void UnderConstructionAsYes() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.RobustclickElementVisible("LocationTab", "AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Overviewtab", 0);
		CommonMethod.RobustclickElementVisible("Overviewtab", "table");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationEditButtonUnderConstruction", 0);
	CommonMethod.RobustclickElementVisible("PortfolioLocationEditButtonUnderConstruction","PortfolioLocationAdditionalButton");	
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAdditionalButton", 0);
	CommonMethod.RobustclickElementVisible("PortfolioLocationAdditionalButton",
			"PortfolioLocationRadiobuttonContainOutdoorSpaces");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationConstructionYes", 0);
	CommonMethod.ClickCheckbox("PortfolioLocationConstructionYes");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UpdateButton", 0);
	CommonMethod.Robustclick("UpdateButton");
	testlog.info("then User clicks on update button");
	if (CommonMethod.isElementsExist("Toastermessage", 15)) {
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("Toastermessage", 1);
	}
	CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("UpdateButton", 1);
	testlog.pass("**User checks Under Construction As Yes successfully**");
}
	
	public void validUnderConstructionInLocationTable() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Overviewtab", 0);
		CommonMethod.RobustclickElementVisible("Overviewtab", "table");
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
	    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocationTickMarkInUnderContruction",1);
		CommonMethod.assertisElementPresentTrue("PortfolioLocationTickMarkInUnderContruction","TickMark In UnderContruction is not visible");
		testlog.pass("**User verifies TickMark In UnderContruction column successfully**");
	}
	
	public void overviewtabTargetReviewCycle() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.RobustclickElementVisible("LocationTab", "AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Overviewtab", 0);
		CommonMethod.RobustclickElementVisible("Overviewtab", "table");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationEditButtonUnderConstruction", 0);
	CommonMethod.RobustclickElementVisible("PortfolioLocationEditButtonUnderConstruction","PortfolioLocationAdditionalButton");	
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationAdditionalButton", 0);
	CommonMethod.RobustclickElementVisible("PortfolioLocationAdditionalButton",
			"PortfolioLocationRadiobuttonContainOutdoorSpaces");
	}
	
	public void MilestonetabTargetReviewCycle() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.RobustclickElementVisible("LocationTab", "AddButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Milestonetab", 0);
		CommonMethod.RobustclickElementVisible("Milestonetab", "MilestoneReviewCycle");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditIconRow3", 0);
	CommonMethod.RobustclickElementVisible("TargetAchievementEditIconRow3","TargetAchievementEditHsrCheckbox");	
	}
	
	public void UnderConstructionDisableTargetReviewCycle() throws IOException, InterruptedException {
	        // Hsr
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditHsrCheckbox", 0);
			CommonMethod.ClickCheckbox("TargetAchievementEditHsrCheckbox");
			testlog.info("And User checks on Hsr TargetAchievement");
			// Wpr
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditWprCheckbox", 0);
			CommonMethod.ClickCheckbox("TargetAchievementEditWprCheckbox");
			testlog.info("And User checks on Wpr TargetAchievement");
			// Wer
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditWerCheckbox", 0);
			CommonMethod.ClickCheckbox("TargetAchievementEditWerCheckbox");
			testlog.info("And User checks on Wer TargetAchievement");
			// PreCertification
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditPreCertficationCheckbox", 0);
			CommonMethod.ClickCheckbox("TargetAchievementEditPreCertficationCheckbox");
			testlog.info("And User checks on PreCertification TargetAchievement");
			// Certification
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TargetAchievementEditCertficationCheckbox", 0);
			CommonMethod.ClickCheckbox("TargetAchievementEditCertficationCheckbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocationDisableTargetReviewCycle",1);
			CommonMethod.assertisElementPresentTrue("PortfolioLocationDisableTargetReviewCycle","Disable Target ReviewCycle is not visible");	
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Closepanelicon", 0);
			CommonMethod.Robustclick("Closepanelicon");
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("Closepanelicon", 1);
			testlog.pass("**Verifies Disabled checkboxes for Target ReviewCycle successfully**");
	}
}