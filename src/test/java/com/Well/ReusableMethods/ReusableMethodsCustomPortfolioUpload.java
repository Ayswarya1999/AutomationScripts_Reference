package com.Well.ReusableMethods;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

import io.restassured.response.Response;

public class ReusableMethodsCustomPortfolioUpload extends BaseClass {

	String FeatureVerificationNameV2 = "Performance Test OR Sensor Data";
	String editTooltipUnderReviewMessage = "This document cannot be edited during an ongoing review.";
	String deleteTooltipUnderReviewMessage = "This document cannot be deleted during an ongoing review.";
	String PortfolioAndRatingLocAccDocumentTable = "PortfolioAndRatingLocAccDocumentTable";
	String PortfolioAndRatingLocAccDocumentTableTr = "PortfolioAndRatingLocAccDocumentTableTr";
	String PortfolioScoreCardVerificationAssignLocSavebtn = "PortfolioScoreCardVerificationAssignLocSavebtn";
	String PortfolioEditLocationTable = "PortfolioEditLocationTable";
	String PortfolioAndRatingLocAccDocumentTableDeleteIcon = "PortfolioAndRatingLocAccDocumentTableDeleteIcon";
	String featureName;

	public void FeatureScorecardUpload(String SheetName, int rowNum, String ProjectTypeVerification, String ProjectType,
			String Commodity, String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardProjectTypeVersion", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("ScorecardProjectTypeVersion"),
				ProjectTypeVerification, "Project Type Doesn't match");
		testlog.info("And User verifies Project Type");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		featureName = data.getCellData(SheetName, "FeatureName", rowNum);
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/** ScoreCard Add option */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 120);
				generic.assignLocationGeneric(Commodity, false, true, false, false, false);
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				testlog.info("And User clicks on Upload Button");
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardLocationUpdateLabel", 0);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardLocationUpdateLabel"),
						"15 locations selected", "Task Upload Update Location Count doesn't match");
				testlog.info("And User verifies Assigned Location In Edit model");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioEditLocationTable, 0);
				List<String> val = CommonMethod.fetchTableData(PortfolioEditLocationTable);
				testlog.info("Fetching Data from Upload Table");
				ValidTableDataUpdateLocation(val, "TEST W@S Location 01", 4, "Assigned");
				ValidTableDataUpdateLocation(val, "TEST W@S Location 02", 9, "Assigned");
				ValidTableDataUpdateLocation(val, "TEST W@S Location 03", 14, "Assigned");
				ValidTableDataUpdateLocation(val, "TEST W@S Location 04", 19, "Assigned");
				ValidTableDataUpdateLocation(val, "TEST W@S Location 05", 24, "Assigned");
				ValidTableDataUpdateLocation(val, "TEST W@S Location 06", 29, "Assigned");
				ValidTableDataUpdateLocation(val, "TEST W@S Location 07", 34, "Assigned");
				ValidTableDataUpdateLocation(val, "TEST W@S Location 08", 39, "Assigned");
				ValidTableDataUpdateLocation(val, "TEST W@S Location 09", 44, "Assigned");
				ValidTableDataUpdateLocation(val, "TEST W@S Location 10", 49, "Assigned");
				CommonMethod.VerifyRadioOrCheckboxSelcted("ValidCheckbox1", 1, 10);
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr", 10);
				testlog.info("And User verifies Search Location Name in Edit Location model");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentPaginationsecond", 0);
				CommonMethod.RobustclickElementVisible("WPRDocumentPaginationsecond", "PortfolioEditLocUncheck");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioEditLocationTable, 0);
				List<String> val1 = CommonMethod.fetchTableData(PortfolioEditLocationTable);
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 11", 4, "Assigned");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 12", 9, "Assigned");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 13", 14, "Assigned");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 14", 19, "Assigned");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 15", 24, "Assigned");
				testlog.info("And User verifies Assigned locations with assigned status");
				CommonMethod.VerifyRadioOrCheckboxSelcted("ValidCheckbox1", 1, 5);
				testlog.info("And User verifies Assigned checkbox");
				/*
				 * Verify Search Location Name in EditLocation model
				 */
				CommonMethod.scrolldowntoElement(PortfolioEditLocationTable);
				CommonMethod.sendKeys("PortfolioEditSearchLocation", "TEST W@S Location 15");
				Thread.sleep(3000);
				CommonMethod.sendKeyEnter("PortfolioEditSearchLocation");
				Thread.sleep(2000);
				int AssignLocTableTrSize = CommonMethod.ElementSize("AssignLocationTableTr");
				String TableTrSize = Integer.toString(AssignLocTableTrSize);
				CommonMethod.negativesoftassertFieldValidEquals(TableTrSize, "1",
						"Search Location Name TableTrSize doesn't match");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScorecardAssignLocationSearchFilterCloseIcon", 0);
				CommonMethod.Robustclick("PortfolioScorecardAssignLocationSearchFilterCloseIcon");
				rc.ScorecardConfirmLocUploadSaveButton();
				rc.uploadDocumentToastMessage();
				testlog.info("And User verifies Upload Document Successful Toast Message");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				pathprms.put("LocationCount", "15 Assigned");
				pathprms.put("PartId", data.getCellData(SheetName, "PartName", rowNum));
				if (ProjectType.contains("pilot")) {
					/** Valid VerificationMethod */
					pathprms.put("VerificationMethod", data.getCellData(SheetName, "VerificationMethod", rowNum));
				} else {
					pathprms.put("VerificationMethod", FeatureVerificationNameV2);
				}
				pathprms.put("Stage", "Feature");
				pathprms.put("StageIntent", "Intent");
				pathprms.put("Status", data.getCellData(SheetName, "ReviewStatus", rowNum));
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, true, true,
						true, true, true, true);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				testlog.info("And User verifies Upload Document Table Data");
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilPresence("ValidPaperIcon", 120);
				testlog.info("And User verifies paper clip icon");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void FeatureScorecardUploadUpdate(String SheetName, int rowNum, String ProjectType, String Commodity)
			throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			featureName = data.getCellData(SheetName, "FeatureName", rowNum);
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("And User clicks on Feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						PortfolioAndRatingLocAccDocumentTable);
				testlog.info("And User clicks on VerificationTab");
				/*
				 * Edit Upload Document
				 */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
				rc.documentTableEditButton();
				CommonMethod.WaitUntilPresence("ScorecardUploadEditDocumentLink", 120);
				testlog.info("And User verifies Document link");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 60);
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationSelectFeature");
				testlog.info("And User clicks on Add feature");
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature",
						data.getCellData(SheetName, "AddPartOption", rowNum));
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectSpaceType", "All Spaces");
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectOption", "Option 1");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPart", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
						"PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.WaitUntilPresence("PortfolioScorecardUploadFeatureRemove", 60);
				testlog.info("And User verifies Removelink should be visible");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getattributeValue("PortfolioScoreCardVerificationAddNote"),
						data.getCellData(SheetName, "NoteComment", rowNum), "Update Note Comment doesn't match");
				testlog.info("And User verifies data in note field");
				CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioScorecardVerifyTaskUploadIntentStage");
				testlog.info("And User verifies IntentStage checkbox is checked");
				CommonMethod.declickListWebelementFromIndex("PortfolioUploadIntentstagedocument", 0);
				testlog.info("And User Unchecks the Intent stage document checkbox");
				rc.ScorecardUploadUpdateSaveButton();
				CommonMethod.WaitUntilPresence("ValidCheckbox1", 120);
				CommonMethod.scrolldowntoElement("ValidCheckbox1");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentPaginationsecond", 0);
				CommonMethod.RobustclickElementVisible("WPRDocumentPaginationsecond", "PortfolioEditLocUncheck");
				CommonMethod.WaitUntilPresence("WPRAssignLocCbx", 120);
				CommonMethod.RobustclickElementVisible("WPRAssignLocCbx", "SelectAllLocation");
				Thread.sleep(2000);
				CommonMethod.JavascriptClickElement("PortfolioEditLocUncheck");
				Thread.sleep(2000);
				testlog.info("And User checks the AssignLocation checkbox");
				rc.ScorecardConfirmLocUploadSaveButton();
				testlog.info("And User clicks on Update button");
				testlog.info("And User verifies Document Uploaded successfully toast message");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				pathprms.put("LocationCount", "19 Assigned");
				pathprms.put("PartId", data.getCellData(SheetName, "PartName", rowNum));
				if (ProjectType.contains("pilot")) {
					/** Valid VerificationMethod */
					pathprms.put("VerificationMethod", data.getCellData(SheetName, "VerificationMethod", rowNum));
				} else {
					pathprms.put("VerificationMethod", FeatureVerificationNameV2);
				}
				pathprms.put("Stage", "Feature");
				pathprms.put("PartId", data.getCellData(SheetName, "AddPartOption", rowNum));
				pathprms.put("Status", data.getCellData(SheetName, "ReviewStatus", rowNum));
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, true, true,
						true, true, false, false);
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Verifies the Feature Updated Uploaded Document from Document list successful**");
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void FeatureScorecardUploadValidAddedFeature(String SheetName, int rowNum, String ProjectType,
			String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			featureName = data.getCellData(SheetName, "AddPartName", rowNum);
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeaturePurseYes5.1", 0);
				CommonMethod.assertisElementPresentTrue("PortfolioScorecardFeaturePurseYes5.1",
						"PurseYes is not visible");
				testlog.info("And User verifies Portfolio Scorecard Feature 5.1PurseYes button");
				testlog.info("And User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						PortfolioAndRatingLocAccDocumentTable);
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardOptionPurseLocation", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardOptionPurseLocation"),
						"19 Pursuing", "PurseLocationCount doesn't match");
				testlog.info("And User verifies location assignments");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				pathprms.put("LocationCount", "19 Assigned");
				pathprms.put("PartId", data.getCellData(SheetName, "PartName", rowNum));
				if (ProjectType.contains("pilot")) {
					/** Valid VerificationMethod */
					pathprms.put("VerificationMethod", data.getCellData(SheetName, "VerificationMethod", rowNum));
				} else {
					pathprms.put("VerificationMethod", FeatureVerificationNameV2);
				}
				pathprms.put("Stage", "Feature");
				pathprms.put("Status", data.getCellData(SheetName, "ReviewStatus", rowNum));
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, true, true,
						true, true, false, false);
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("And User verifies Uploaded document in Table list");
				testlog.pass("**Verifies the Add part Feature Uploaded Document from Document list successful**");
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void verifyTaskCompletion(String SheetName, int rowNum) throws IOException, InterruptedException {
		/*
		 * Validate Task completion and green circle
		 */
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			featureName = data.getCellData(SheetName, "FeatureName", rowNum);
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("And User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						PortfolioAndRatingLocAccDocumentTable);
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException(
						"PortfolioScorecardDocumentCompleteGreenCircleValid", 1);
				CommonMethod.assertisElementPresentTrue("PortfolioScorecardDocumentCompleteGreenCircleValid",
						"Document Complete Count is not visible");
				testlog.info("And User verifies Task completion and green circle in Task");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentCompleteLink",
						"PortfolioScorecardDocumentCompleteCount");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardDocumentCompleteCount", 0);
				testlog.info("And User verifies Completed Location count for Task Completed model");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentCompleteCount",
						"PortfolioScorecardDocumentCompleteGreenCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioUploadTaskCompleteLocFullfillLabel", 10);
				CommonMethod.WaitUntilPresence("PortfolioUploadTaskCompleteLocNextBtn", 120);
				CommonMethod.RobustclickElementVisible("PortfolioUploadTaskCompleteLocNextBtn",
						"PortfolioScorecardDocumentCompleteGreenCount");
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException(
						"PortfolioUploadTaskCompleteLocFullfillLabel", 9);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioUploadTaskCompleteLocFullfillLabel", 9);
				testlog.info("And User verifies count for Task Completed green colour for location list");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardDocumentCompleteClose", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentCompleteClose",
						PortfolioAndRatingLocAccDocumentTable);
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Verifies the Task Completion in Task list successful**");
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void verifyDeleteUploadFeature(String SheetName, int rowNum, String FeatureName, String ProjectType,
			String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
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
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocbtn", 0);
				CommonMethod.RobustclickElementVisible("WPRAssignLocbtn",
						"PortfolioScoreCardVerificationAssignChildLocCbx");
				/** Assign 15 Location */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1, 11);
				CommonMethod.WaitUntilPresence(PortfolioScoreCardVerificationAssignLocSavebtn, 60);
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation",
						"PortfolioScoreCardVerificationAssignLocCbxGeneral");
				testlog.info("And User clicks on Edit Location Button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadTaskCompleteLocNextBtn", 0);
				CommonMethod.RobustclickElementVisible("PortfolioUploadTaskCompleteLocNextBtn",
						"PortfolioScoreCardVerificationAssignLocCbxGeneral");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1, 6);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioScoreCardVerificationAssignLocSavebtn,
						0);
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				testlog.info("And User clicks on Assign Button");
				testlog.info("And User check Assign location checkboxes");
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 1);
				testlog.info("And User clicks on Upload Button");
				/*
				 * Assign Location filter
				 */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationUploadAddfeature", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				testlog.info("And User clicks on Update button");
				CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,
						"PortfolioScorecardUploadRemoveLink");
				testlog.info("And User verifies Upload Feature");
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote",
						data.getCellData(SheetName, "NoteComment", rowNum));
				testlog.info("And User enter data to AddNote field");
				rc.ScorecardUploadSaveButton();
				testlog.info("And User clicks on Upload button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ValidCheckbox1", 0);
				rc.ScorecardConfirmLocUploadSaveButton();
				rc.uploadDocumentToastMessage();
				testlog.info("And User verifies Upload Document Successful Toast Message");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				pathprms.put("Stage", "Feature");
				pathprms.put("Status", data.getCellData(SheetName, "ReviewStatus", rowNum));
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false,
						true, true, false, false);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				rc.documentTableDeleteButton();
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Verifies the Delete Uploaded Document from Document list successful**");
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void AuditScorecardUpload(String SheetName, int rowNum, String ProjectType, String Commodity,
			String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			featureName = data.getCellData(SheetName, "AuditName", rowNum);
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/** ScoreCard Add option */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocbtn", 0);
				generic.assignLocationGeneric(Commodity, false, true, false, false, false);
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("PortfolioScorecardValidDisable");
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardLocationUpdateLabel"),
						"3 locations selected", "Task Upload Update Location Count doesn't match");
				rc.ScorecardConfirmLocUploadSaveButton();
				testlog.info("And User clicks on save button");
				rc.uploadDocumentToastMessage();
				testlog.info("And User verifies Upload Document Successful Toast Message");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadTaskCompleteUploadDisablebtn",
						0);
				testlog.info("And User verifies Task Upload button disable");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				pathprms.put("LocationCount", "3 Assigned");
				pathprms.put("PartId", data.getCellData(SheetName, "AuditPartName", rowNum));
				pathprms.put("VerificationMethod", data.getCellData(SheetName, "AuditVerificationMethod", rowNum));
				pathprms.put("Stage", "Audit");
				pathprms.put("Status", data.getCellData(SheetName, "ReviewStatus", rowNum));
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, true, true,
						true, true, true, false);

				/*
				 * Update Audit
				 */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				rc.documentTableEditButton();
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddNote", 180);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationAddNote");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScorecardVerifyTaskUploadIntentStage", 0);
				CommonMethod.ClickCheckbox("PortfolioScorecardVerifyTaskUploadIntentStage");
				testlog.info("And User checks the IntentStage checkbox");
				CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioScorecardVerifyTaskUploadIntentStage");
				testlog.info("And User verifies IntentStage checkbox is checked");
				rc.ScorecardUploadUpdateSaveButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
				testlog.info("And User checks the AssignLocation checkbox");
				rc.ScorecardConfirmLocUploadSaveButton();
				testlog.info("And User clicks on Upload button");
				rc.uploadDocumentToastMessage();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				pathprms.put("LocationCount", "2 Assigned");
				pathprms.put("PartId", data.getCellData(SheetName, "AuditPartName", rowNum));
				pathprms.put("VerificationMethod", data.getCellData(SheetName, "AuditVerificationMethod", rowNum));
				pathprms.put("Stage", "Audit");
				pathprms.put("Status", data.getCellData(SheetName, "ReviewStatus", rowNum));
				pathprms.put("StageIntent", "Intent");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, true, true,
						true, true, true, true);
				testlog.info("And User verifies Upload Document Table Data");
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Verifies the Audit Scorecard Upload successful**");
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void AlternativeScorecardUpload(String SheetName, int rowNum, String ProjectType, String Commodity,
			String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			featureName = data.getCellData(SheetName, "AlternativeFeatureName", rowNum);
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioUploadTaskEditAlternative");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadTaskEditAlternative", 0);
				CommonMethod.RobustclickElementVisible("PortfolioUploadTaskEditAlternative",
						"PortfolioScorecardUploadAlternativeAddbtn");
				testlog.info("And User clicks on Alternative button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadAlternativeAddbtn",
						0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardUploadAlternativeAddbtn",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 120);
				generic.assignLocationGeneric(Commodity, false, true, false, false, false);
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				generic.uploadModalCompleteGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScorecardDocumentCompleteGreenCircleValid", 0);
				testlog.info("And User verifies Task complete");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				pathprms.put("LocationCount", "15 Assigned");
				pathprms.put("PartId", data.getCellData(SheetName, "AlternativePartName", rowNum));
				pathprms.put("VerificationMethod",
						data.getCellData(SheetName, "AlternativeVerificationMethod", rowNum));
				pathprms.put("Stage", "Feature");
				pathprms.put("Status", data.getCellData(SheetName, "ReviewStatus", rowNum));
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, true, true,
						true, true, true, false);
				CommonMethod.JavascriptClickElement(ele);
				Thread.sleep(2000);
				testlog.pass("**Verifies the Alternative Scorecard Upload successful**");
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public static void ValidTableDataUpdateLocation(List<String> val, String Name, int StatusPosition, String Status)
			throws IOException, InterruptedException {
		for (String s : val) {
			int index = 0;
			if (s.contains(Name)) {
				@SuppressWarnings("unused")
				int position = index;
				CommonMethod.negativesoftassertFieldValid(val.get(StatusPosition), Status,
						Name + " Location table data mismatch");
				testlog.info("And User verifies Assigned Status for " + Name + " In Edit model");
				break;
			}
			index++;
		}
	}

	public void DocumentTab() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DocumentLibraryTab", 0);
		CommonMethod.RobustclickElementVisible("DocumentLibraryTab", "PortfolioDocumentUploadbutton");
	}

	public void ValidatingAuditUploadDocument(String SheetName, int rowNum, String ProjectType, String Commodity)
			throws Exception {
		pfu.DocumentTab();
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilNumberOfElementToBePresent("PortfolioDocumentUploadbutton", 1);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton",
				"V2ProjectPortfolioDocTypeFeatureAudit");
		testlog.info("When User click on Upload button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectPortfolioDocTypeFeatureAudit", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectPortfolioDocTypeFeatureAudit", "V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "audit");
		testlog.info("And User select Document Type");
		if (ProjectType.equalsIgnoreCase("v2")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSelectverificationMethod", 0);
			CommonMethod.selectdropdownVisibletext("PortfolioSelectverificationMethod", "On-site Photographs");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OwnerOrgClick", 0);
			CommonMethod.RobustclickElementVisible("OwnerOrgClick", "PortfolioDocumentAuditVerficationMethod");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentAuditVerficationMethod", 0);
			CommonMethod.click("PortfolioDocumentAuditVerficationMethod");
		}
		testlog.info("And User select Verification Method");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRSelectFeaturePart", 0);
		CommonMethod.scrolldowntoElement("V2ProjectPortfolioDocType");
		int OptionSize = CommonMethod.getdropdownSize("WPRSelectFeaturePart");
		System.out.println(CommonMethod.getText("WPRSelectFeaturePart"));
		System.out.println("OptionSize: " + String.valueOf(OptionSize));
		// CommonMethod.negativesoftassertFieldValid(String.valueOf(OptionSize), "2",
		// "Option count doesn't match");
		testlog.info("Then User verifies Option count in Add Feature");
		CommonMethod.selectdropdownVisibletext("WPRSelectFeaturePart",
				data.getCellData(SheetName, "AuditPartName", rowNum));
		testlog.info("And User select FeaturePart");
		CommonMethod.scrolldowntoElement("WPRSelectFeaturePart");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddPartButton", 0);
		CommonMethod.Robustclick("WPRAddPartButton", "WPRSelectFeaturePart");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadRemovelink", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardUploadRemovelink",
				"Add Part link should be Present");
		testlog.info("And User verifies Added feature link");
		generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, AuditfileUpload, false, false, false,
				false);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx", 0);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx", "PortfolioScorecardValidDisable");
		rc.ScorecardConfirmLocUploadSaveButton();
		testlog.info("When User click on Submit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		pathprms.put("LocationCount", "3 Assigned");
		pathprms.put("PartId", "A02.2");
		pathprms.put("Stage", "Audit");
		pathprms.put("Status", data.getCellData(SheetName, "ReviewStatus", rowNum));
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, false, false, true,
				true, true, false);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTaskListTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab", "PortfolioDocListTaskFullFilledTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab",
				"PortfolioDocListTaskAuditCompleted");
		testlog.info("And User clicks on Task tab");
		Thread.sleep(3000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskAuditCompleted", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioDocListTaskAuditCompleted",
				"Task Completed element is not visible");
		testlog.info("And User verifies Task Green Completed");
		testlog.info("And User verifies Document Upload Table");
		testlog.pass("**Upload Audit Document successfully**");
	}

	public void ValidatingFeatureUploadDocument(String SheetName, int rowNum, String ProjectType, String Commodity)
			throws Exception {
		CommonMethod.refreshBrowser();
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilNumberOfElementToBePresent("PortfolioDocumentUploadbutton", 1);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton",
				"V2ProjectPortfolioDocTypeFeatureAudit");
		testlog.info("When User click on Upload button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectPortfolioDocTypeFeatureAudit", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectPortfolioDocTypeFeatureAudit", "V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "feature");
		testlog.info("And User select Document Type");
		if (ProjectType.equalsIgnoreCase("v2")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSelectverificationMethod", 0);
			CommonMethod.selectdropdownVisibletext("PortfolioSelectverificationMethod",
					"Policy and/or Operations Schedule");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OwnerOrgClick", 0);
			CommonMethod.RobustclickElementVisible("OwnerOrgClick", "PortfolioScorecardFeatureVerficationMethod");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerficationMethod", 0);
			CommonMethod.click("PortfolioScorecardFeatureVerficationMethod");
		}
		testlog.info("And User select VerificationMethod");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRSelectFeaturePart", 0);
		CommonMethod.scrolldowntoElement("V2ProjectPortfolioDocType");
		CommonMethod.selectdropdownVisibletext("WPRSelectFeaturePart", "A02.1");
		testlog.info("And User select FeaturePart");
		CommonMethod.scrolldowntoElement("WPRSelectFeaturePart");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddPartButton", 0);
		CommonMethod.Robustclick("WPRAddPartButton", "WPRSelectFeaturePart");
		CommonMethod.WaitUntilPresence("PortfolioScorecardUploadRemovelink", 60);
		testlog.info("Then User verifies Remove link should be visible");
		Thread.sleep(2000);
		generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FeaturefileUpload, false, false, false,
				false);
		CommonMethod.ClickCheckbox("PortfolioScoreCardVerificationAssignLocCbx");
		rc.ScorecardConfirmLocUploadSaveButton();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
		pathprms.put("LocationCount", "10 Assigned");
		pathprms.put("PartId", "A02.1");
		pathprms.put("Stage", "Feature");
		pathprms.put("Status", "Ready For Review");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, true, false, true, true,
				false, false);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTaskListTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab", "PortfolioDocListTaskFullFilledTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab", "PortfolioDocListTaskCompleted");
		testlog.info("And User clicks on Task tab");
		Thread.sleep(3000);
		CommonMethod.assertisElementPresentTrue("PortfolioDocListTaskCompleted",
				"Task Completed element is not visible");
		testlog.info("And User verifies Task Green Completed");
		testlog.pass("**Upload Feature Document successfully**");
	}

	public void ValidatingUnderReviewDocument() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		testlog.info("Given User is on DocumentList page");
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		testlog.info("And User clicks on DocumentList tab");
		CommonMethod.assertisNotElementPresent("PortfolioDocListDeleteIcon", "Delete icon is visible");
		testlog.info("Then User verifies disable Delete icon");
		CommonMethod.WaitUntilPresence(PortfolioAndRatingLocAccDocumentTable, 200);
		CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
		rc.deleteButtonTooltipMessage();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocToolTipDelete", 0);
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("PortfolioDocToolTipDelete"),
				deleteTooltipUnderReviewMessage, "Tooltip Delete icon in Document list doesn't match");
		testlog.info("And User verifies disable Delete tooltip message");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		testlog.info("Given User is on DocumentList page");
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		testlog.info("And User clicks on DocumentList tab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
		rc.editButtonTooltipMessage();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocToolTipEdit", 0);
		CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText("PortfolioDocToolTipEdit"),
				editTooltipUnderReviewMessage, "Tooltip Intent checkbox in Document list doesn't match");
		testlog.info("And User verifies disable Intent Checkbox tooltip message");
		testlog.info("And User verifies disable Edit icon");
		testlog.info("And User clicks on Update button");
		testlog.info("And User verifies disable Edit tooltip message");
		testlog.pass("**Valid Disable Delete icon under review successfully**");
	}

	@SuppressWarnings("unchecked")
	public void ValidatingAcheivedReviewDocument(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		String portfolioId = data.getCellData(SheetName, "ID", rowNum);
		@SuppressWarnings("static-access")
		String token = commonAPI.PostRequestAuthenticate("AdminUserName", 2);
		testlog.info("Given User set Post service api endpoint");
		testlog.info("When User Send a Post HTTP request");
		testlog.info("portfolio_id: " + portfolioId);
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
		pathprms.put("portfolio_id", portfolioId);
		Response res = given().log().all().accept("application/json").contentType("application/json")
				.pathParams(pathprms).header("Authorization", token).when()
				.post("admin/qa/automation/bulk-review/portfolio/{portfolio_id}");
		int StatusCode = res.getStatusCode();
		System.out.println("Response: " + res.asString());
		Assert.assertEquals(StatusCode, 200, "Verifying status code");
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.pass("**Acheving Reviewed successfully**");
	}

	public void getProjectIdAndSetInIdColumnInExcel(String SheetName, int rowNum) {

		String getProjectID = data.getCellData(SheetName, "ProjectID", rowNum);
		String splitId = getProjectID.substring(4, 9);
		data.setCellData(SheetName, "ID", 2, splitId);
		System.out.println(splitId);
	}

	public void ValidatingPostReviewFeature(String SheetName, int rowNum, String featureName, String Commodity)
			throws Exception {
		testlog.info("Given User is on Scorecard page");
		portfolio.PortfolioBuildScorecard();
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
			CommonMethod.click(ele);
			flag = true;
			testlog.info("When User clicks on Feature");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
			CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
					"PortfolioScorecardEditLocation");
			testlog.info("And User clicks on VerificationTab");
			Thread.sleep(2000);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseLocCount", 0);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardPurseLocCount"),
					"19 Achieved", "Feature Acheived location Count doesn't match");
			testlog.info("And User verifies Acheived Status in Task");
			String feature = data.getCellData(SheetName, "FeatureName", rowNum);
			if (feature.equalsIgnoreCase(featureName)) {
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation", PortfolioEditLocationTable);
				// CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardDisableEditLocation",
				// 10);
				// CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardDisableEditLocation",
				// 0);
				// int DisableEditLocationpage1 =
				// CommonMethod.ElementSize("PortfolioScorecardDisableEditLocation");
				// String DisableEditLoc = Integer.toString(DisableEditLocationpage1);
				// CommonMethod.negativesoftassertFieldValid(DisableEditLoc, "10", "Disable
				// Location count doesn't match");
				// testlog.info("Then User verifies Disable Assign locations in Edit Locations
				// model");
				List<String> val1 = CommonMethod.fetchTableData(PortfolioEditLocationTable);
				testlog.info("Fetching Data from Upload Table");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 01", 4, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 02", 9, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 03", 14, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 04", 19, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 05", 24, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 06", 29, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 07", 34, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 08", 39, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 09", 44, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 10", 49, "Achieved");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadTaskCompleteLocNextBtn", 0);
				CommonMethod.RobustclickElementVisible("PortfolioUploadTaskCompleteLocNextBtn",
						"PortfolioEditLocationTable");
//				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardDisableEditLocation",
//						9);
//				int DisableEditLocationpage2 = CommonMethod.ElementSize("PortfolioScorecardDisableEditLocation");
//				String DisableEditLoc1 = Integer.toString(DisableEditLocationpage2);
//				CommonMethod.negativesoftassertFieldValid(DisableEditLoc1, "9", "Disable EditLocation doesn't match");
//				testlog.info("Then User verifies Disable Assign locations in Edit Locations model");
				List<String> val2 = CommonMethod.fetchTableData(PortfolioEditLocationTable);
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 11", 4, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 12", 9, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 13", 14, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 14", 19, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 15", 24, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 16", 29, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 17", 34, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 18", 39, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 19", 44, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 20", 49, "Not Assigned");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx",
						0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAssignLocCbx",
						PortfolioScoreCardVerificationAssignLocSavebtn);
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardAuditPurseLocCount"),
						"1 Pursuing", "Feature Pursuing location Count doesn't match");
				testlog.info("Then User verifies Added new assigned after review with Purse Status");
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getText("PortfolioScorecardAuditAcheiveLocCount"), "19 Achieved",
						"Feature Acheived location Count doesn't match");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation", PortfolioEditLocationTable);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadTaskCompleteLocNextBtn", 0);
				CommonMethod.RobustclickElementVisible("PortfolioUploadTaskCompleteLocNextBtn",
						"PortfolioScorecardDisableEditLocation");
				List<String> val3 = CommonMethod.fetchTableData(PortfolioEditLocationTable);
				testlog.info("Fetching Data from Upload Table");
				ValidTableDataUpdateLocation(val3, "TEST W@S Location 20", 49, "Assigned");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.RobustclickElementVisible("AssignLocCloseIcon", "PortfolioScorecardEditLocation");
				testlog.info("Then User verifies Assign locations checkboxes in Edit Locations model");
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				if (CommonMethod.isElementsExist("AssignLocCloseIcon", 5)) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
					CommonMethod.Robustclick("AssignLocCloseIcon");
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				rc.documentTableEditButton();
				CommonMethod.WaitUntilPresence("PortfolioScoreVerifyUploadVerificationMethod", 200);
				CommonMethod.WaitUntilPresence("ScorecardUploadEditDocumentLink", 120);
				CommonMethod.assertisElementPresentTrue("ScorecardUploadEditDocumentLink",
						"Remove button is invisible");
				testlog.info("And User verifies Document link");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardReviewStatusInAddPartLinkCount", 2);
				testlog.info("And User verifies features parts count");
				List<String> Featurestatus = new ArrayList<>();
				Featurestatus.add("Fulfills Part");
				Featurestatus.add("Approved");
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getText("PortfolioScorecardReviewStatusInAddPartLink"), Featurestatus,
						"Feature Review Status In AddPart Link list doesn't match");
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getText("PortfolioScorecardReviewStatusInAddPartLink2"), Featurestatus,
						"Feature Review Status In AddPart2 Link list doesn't match");
				testlog.info("And User verifies Review Status In AddPart Link");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationAddNote");
				CommonMethod.WaitUntilPresence("PortfolioScorecardIntentText", 200);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardIntentText",
						"PortfolioDocToolTipIntentCheckbox");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioDocToolTipIntentCheckbox"),
						"Stage can no longer be edited now the document has been reviewed. Please re-upload with the correct Stage if you need to amend.",
						"Feature Intent checkbox in Document list doesn't match");
				CommonMethod.WaitUntilPresence("PortfolioScorecardDisableIntentCheckbox", 120);
				testlog.info("And User verifies disable Intent Checkbox");
				rc.ScorecardUploadUpdateSaveButton();
				rc.ScorecardConfirmLocUploadSaveButton();
				testlog.info("And User clicks on Update button");
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Validate Post Review successfully**");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void validateArchiveInDocumentsTable(String SheetName, int rowNum, String featureName, String Commodity)
			throws Exception {

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
		validateArchive(SheetName, rowNum, Commodity);
	}

	public void validateArchiveInScorecardTable(String SheetName, int rowNum, String featureName, String Commodity)
			throws Exception {
		testlog.info("Given User is on Scorecard page");
		boolean flag = false;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioScoreCardPageLand", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
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
				validateArchive(SheetName, rowNum, Commodity);
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Validate Post Review successfully**");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void validateArchive(String SheetName, int rowNum, String Commodity) throws Exception {
		if (TestCaseName.equalsIgnoreCase("Portfolio_TC_05_09_DocumentsFeatureMoveOnArchiveAndValidateArchive")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
			CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink",
					"PortfolioAndRatingLocAccDocumentTable");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTable", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableTr", 0);
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
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardArchivedText", 0);
		String ArchivedText = CommonMethod.getattributeValueByTextContent("PortfolioScorecardArchivedText");
		CommonMethod.negativesoftassertFieldValid("Archived", ArchivedText,
				"Archived Document Status does not matched");
	}

	public void PostReviewValidateApprovedStatusInTable(String SheetName, int rowNum, String featureName,
			String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardTab", 0);
		CommonMethod.click("ScorecardTab");
		testlog.info("When User clicks on ScorecardTab");
		rc.ScorecardLoading();
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				flag = true;
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScorecardEditLocation");
				testlog.info("And User clicks on VerificationTab");
				Thread.sleep(2000);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				pathprms.put("Status", "Reviewed");
				pathprms.put("PartId", "Approved");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, false, false,
						false, true, false, false);
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Validate Post Review successfully**");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void PostReviewValidateApprovedAndFullfiledStatusInTable() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		testlog.info("And User will be redirected to Document Upload Table page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableTr", 0);
		List<String> Tableval = CommonMethod.fetchTableData(PortfolioAndRatingLocAccDocumentTable);
		testlog.info("Fetching Data from Upload Table");
		List<String> Optionstatus = new ArrayList<>();
		Optionstatus.add("Fulfills Part");
		Optionstatus.add("Approved");
		String[] LocationNameValid = Tableval.get(2).split("Spaces");
		LocationNameValid = LocationNameValid[1].split("A05.1");
		CommonMethod.negativesoftassertFieldValid(LocationNameValid[0].trim(), Optionstatus,
				"Option label in Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(Tableval.get(5), "Reviewed",
				"Review Status in Document table data mismatch");
		testlog.info("And User verifies Feature Review Status In Table list");

	}

	public void ValidatingPostReviewAudit(String SheetName, int rowNum, String featureName, String Commodity)
			throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilVisibility("PortFolioScoreCardPageLand", Scorecardtimeout);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				flag = true;
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScorecardEditLocation");
				testlog.info("And User clicks on VerificationTab");
				Thread.sleep(2000);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAuditPurseLocCount", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardAuditPurseLocCount"),
						"12 Pursuing", "Audit Pursuing location Count doesn't match");
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getText("PortfolioScorecardAuditAcheiveLocCount"), "3 Achieved",
						"Audit Acheived location Count doesn't match");
				testlog.info("And User verifies Acheived Status in Task");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				rc.documentTableEditButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreVerifyUploadVerificationMethod",
						0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardUploadEditDocumentLink", 0);
				CommonMethod.assertisElementPresentTrue("ScorecardUploadEditDocumentLink",
						"Remove button is invisible");
				testlog.info("And User verifies Document link");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardReviewStatusInAddPartLinkCount", 1);
				testlog.info("And User verifies features parts count");
				List<String> AuditFeaturestatus = new ArrayList<>();
				AuditFeaturestatus.add("Fulfills Part");
				AuditFeaturestatus.add("Approved");
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getText("PortfolioScorecardReviewStatusInAddPartLink"), AuditFeaturestatus,
						"Audit Review Status In AddPart Link list doesn't match");
				testlog.info("And User verifies Review Status In AddPart Link");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationAddNote");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardIntentText", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardIntentText",
						"PortfolioDocToolTipIntentCheckbox");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioDocToolTipIntentCheckbox"),
						"Stage can no longer be edited now the document has been reviewed. Please re-upload with the correct Stage if you need to amend.",
						"Audit Intent checkbox in Document list doesn't match");
				CommonMethod.WaitUntilPresence("PortfolioScorecardDisableIntentCheckbox", 120);
				testlog.info("And User verifies disable Intent Checkbox");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndExitbtnUploadPage", 0);
				CommonMethod.Robustclick("SaveAndExitbtnUploadPage");
				testlog.info("And User clicks on Update button");
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Validate Post Review successfully**");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void ValidatingPostReviewAlternative(String SheetName, int rowNum, String featureName) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilVisibility("PortFolioScoreCardPageLand", Scorecardtimeout);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				flag = true;
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScorecardEditLocation");
				testlog.info("And User clicks on VerificationTab");
				Thread.sleep(2000);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardAuditPurseLocCount"),
						"15 Achieved", "Pursuing location Count doesn't match");
				testlog.info("And User verifies Acheived Status in Task");
				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation", PortfolioEditLocationTable);
//				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardDisableEditLocation",
//						10);
//				int DisableEditLocationpage1 = CommonMethod.ElementSize("PortfolioScorecardDisableEditLocation");
//				String DisableEditLoc = Integer.toString(DisableEditLocationpage1);
//				CommonMethod.negativesoftassertFieldValid(DisableEditLoc, "10", "Disable Edit Location doesn't match");
//				testlog.info("Then User verifies Disable Assign locations in Edit Locations model");
				List<String> val1 = CommonMethod.fetchTableData(PortfolioEditLocationTable);
				testlog.info("Fetching Data from Upload Table");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 01", 4, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 02", 9, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 03", 14, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 04", 19, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 05", 24, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 06", 29, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 07", 34, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 08", 39, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 09", 44, "Achieved");
				ValidTableDataUpdateLocation(val1, "TEST W@S Location 10", 49, "Achieved");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadTaskCompleteLocNextBtn", 0);
				CommonMethod.RobustclickElementVisible("PortfolioUploadTaskCompleteLocNextBtn",
						"PortfolioScorecardDisableEditLocation");
//				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardDisableEditLocation",
//						5);
//				int DisableEditLocationpage2 = CommonMethod.ElementSize("PortfolioScorecardDisableEditLocation");
//				String DisableEditLoc1 = Integer.toString(DisableEditLocationpage2);
//				CommonMethod.negativesoftassertFieldValid(DisableEditLoc1, "5", "Disable EditLocation doesn't match");
//				testlog.info("Then User verifies Disable Assign locations in Edit Locations model");
				List<String> val2 = CommonMethod.fetchTableData(PortfolioEditLocationTable);
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 11", 4, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 12", 9, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 13", 14, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 14", 19, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 15", 24, "Achieved");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 16", 29, "Not Assigned");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 17", 34, "Not Assigned");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 18", 39, "Not Assigned");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 19", 44, "Not Assigned");
				ValidTableDataUpdateLocation(val2, "TEST W@S Location 20", 49, "Not Assigned");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.RobustclickElementVisible("AssignLocCloseIcon", "PortfolioScorecardEditLocation");
				testlog.info("And User verifies Assign location status in Edit Locations model");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				rc.documentTableEditButton();
				CommonMethod.WaitUntilPresence("PortfolioScoreVerifyUploadVerificationMethod", 200);
				CommonMethod.WaitUntilPresence("ScorecardUploadEditDocumentLink", 120);
				CommonMethod.assertisElementPresentTrue("ScorecardUploadEditDocumentLink",
						"Remove button is invisible");
				testlog.info("And User verifies Document link");
				List<String> AlternativeFeaturestatus = new ArrayList<>();
				AlternativeFeaturestatus.add("Fulfills Part");
				AlternativeFeaturestatus.add("Approved");
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getText("PortfolioScorecardReviewStatusInAddPartLink"), AlternativeFeaturestatus,
						"Alternative Review Status In AddPart Link list doesn't match");
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getText("PortfolioScorecardReviewStatusInAddPartLink2"), AlternativeFeaturestatus,
						"Alternative Review Status In AddPart2 Link list doesn't match");
				testlog.info("And User verifies Review Status In AddPart Link");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationAddNote");
				CommonMethod.WaitUntilPresence("PortfolioScorecardIntentText", 200);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardIntentText",
						"PortfolioDocToolTipIntentCheckbox");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioDocToolTipIntentCheckbox"),
						"Stage can no longer be edited now the document has been reviewed. Please re-upload with the correct Stage if you need to amend.",
						"Alternative Intent checkbox in Document list doesn't match");
				CommonMethod.WaitUntilPresence("PortfolioScorecardDisableIntentCheckbox", 120);
				testlog.info("And User verifies disable Intent Checkbox");
				rc.ScorecardUploadUpdateSaveButton();
				rc.ScorecardConfirmLocUploadSaveButton();
				testlog.info("And User clicks on Update button");
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Validate Post Review successfully**");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void PostReviewValidateApprovedStatusInTable(String featureName) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilVisibility("PortFolioScoreCardPageLand", Scorecardtimeout);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				flag = true;
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScorecardEditLocation");
				testlog.info("And User clicks on VerificationTab");
				PostReviewValidateApprovedAndFullfiledStatusInTable();
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Validate Post Review successfully**");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void StoreLocationId(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.RobustclickElementVisible("LocationTab", "AddButton");
		testlog.info("When User clicks on LocationTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Subsettab", 0);
		CommonMethod.scrolldowntoElement("Subsettab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 4);
		String locationId;
		if (TestCaseName.equalsIgnoreCase("Portfolio_TC_23_00_ValidateAcheivementTabAndNavigateToLocationAccount")
				|| TestCaseName
						.equalsIgnoreCase("Portfolio_TC_24_00_ValidateAcheivementTabAndNavigateToLocationAccount")
				|| TestCaseName.equalsIgnoreCase("Portfolio_TC_Optn_02_11_validateRecertificationButtonInAdminField")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("getLocationId", 0);
			locationId = CommonMethod.getText("getLocationId");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationgetId", 0);
			locationId = CommonMethod.getText("PortfolioLocationgetId");
		}
		System.out.println("locationId: " + locationId);
		data.setCellData(SheetName, "LocationProjectID", rowNum, locationId);
	}

	public void NavigateAddedLocation(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProjectNavBar", 0);
		CommonMethod.RobustclickElementVisible("ProjectNavBar", "WELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("WELLCertificationNavBar", "V2ProjectId");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectId", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectId", "V2ProjectApplybtn");
		String Id = data.getCellData(SheetName, "LocationProjectID", rowNum).trim();
		System.out.println("LocationProjectID:" + Id);
		testlog.info("LocationProjectID:" + Id);
		CommonMethod.sendKeys("V2ProjectId", Id);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectApplybtn", 0);
		CommonMethod.JavascriptClickElement("V2ProjectApplybtn");
		Thread.sleep(30000);
		testlog.info("And User verify after 30 sec");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("V2ProjectSearchResultIDVerify", 1);
		int var = CommonMethod.ElementSize("V2ProjectSearchResultIDVerify");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "1", "V2 Search failed");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectSearchResultIDVerify").trim(),
				data.getCellData(SheetName, "LocationProjectID", rowNum).trim(),
				"Project Id doesn't matches in search");
		CommonMethod.RobustclickElementVisible("V2ProjectIdCompare", "WellV2DashboardTab");
	}

	public void UploadLegalFromDocumentLibrary(String SheetName, int rowNum, String DocumentType, String FileName,
			String Commodity) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2ProjectDocumentTab", 0);
		CommonMethod.RobustclickElementVisible("WellV2ProjectDocumentTab", "V2ProjectDocUploadbtn");
		testlog.info("When User clicks on DocumentTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDocUploadbtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectDocUploadbtn", "V2ProjectPortfolioDocType");
		testlog.info("And User clicks on Upload button");
		testlog.info("Document Type : Legal");
		int OptionSize = CommonMethod.getdropdownSize("PortfolioDocDocumentType");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(OptionSize), "3",
				"Option dropdown count doesn't match");
		testlog.info("And User verifies Document Type Options count");
		List<String> DocTypeDDL = new ArrayList<>();
		DocTypeDDL.add("Upload Legal");
		DocTypeDDL.add("Feature");
		DocTypeDDL.add("Audit");
		CommonMethod.VerifyListDropdownValues("PortfolioDocDocumentType", DocTypeDDL);
		testlog.info("And User verifies Document Type Options");
		CommonMethod.selectdropdownVisibletext("PortfolioDocDocumentType", DocumentType);
		testlog.info("And User select Document Type");
		CommonMethod.uploadFile("PortfolioScorecardFileUpload", FileName, "UploadFileVerifyScorecard");
		testlog.info("And User upload Document");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationScorecardUploadbtn", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationDocumentUploadbtn", "PortfolioV2ProjectGeneralDoc");
		testlog.info("And User clicks on Submit button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilPresence("PortfolioV2ProjectGeneralDoc", 60);
		CommonMethod.RobustclickElementVisible("PortfolioV2ProjectGeneralDoc", "PortfolioV2ProjectDocumentTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioV2ProjectDocumentTable", 0);
		CommonMethod.scrolldowntoElement("PortfolioV2ProjectDocumentTable");
		List<String> val = CommonMethod.fetchTableData("PortfolioV2ProjectDocumentTable");
		testlog.info("Fetching Data from Upload Table");
		CommonMethod.negativesoftassertFieldValid(val.get(1), "LEGAL", "Type in Document table data mismatch");
		testlog.info("Then User will be redirected to Document list in General tab");
		testlog.info("And User verifies uploaded document");
		testlog.pass("**Upload Legal Document in Document successfully**");
	}

	public void UploadFeatureDocV2ProjectInsideDocument(String SheetName, int rowNum, String DocumentType,
			String FileName, String ProjectType, String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDocUploadbtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectDocUploadbtn", "PortfolioDocDocumentType");
		testlog.info("And User clicks on Upload button");
		CommonMethod.selectdropdownVisibletext("PortfolioDocDocumentType", DocumentType);
		testlog.info("And User select Document Type");
		CommonMethod.uploadFile("PortfolioScorecardFileUpload", FileName, "UploadFileVerifyScorecard");
		testlog.info("And User upload Document");
		CommonMethod.WaitUntilPresence("OwnerOrgClick", 60);
		CommonMethod.click("OwnerOrgClick");
		if (ProjectType.contains("pilot")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardLocV2PilotVerificationMethlist", 60);
			CommonMethod.click("PortfolioScorecardLocV2PilotVerificationMethlist");
		} else {
			CommonMethod.WaitUntilPresence("PortfolioScorecardLocVerificationMethlist", 60);
			CommonMethod.click("PortfolioScorecardLocVerificationMethlist");
		}
		Thread.sleep(2000);
		CommonMethod.scrolldowntoElement("OwnerOrgClick");
		testlog.info("And User select the Verification");
		CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationSelectFeature", 180);
		testlog.info("Then User verifies option to add multiple feature parts");
		CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "T01.1");
		testlog.info("And User select T01.1 Partname");
		CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
		CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
		CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPartbtn", 180);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPartbtn",
				"PortfolioLocationScorecardUploadbtn");
		CommonMethod.WaitUntilPresence("PortfolioScorecardUploadRemovelink", 180);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardUploadRemovelink", "Remove button is invisible");
		testlog.info("And User clicks on Add Part and verifies the added multiple part");
		CommonMethod.WaitUntilPresence("PortfolioV2ProjectDocUpload", 60);
		CommonMethod.RobustclickElementVisible("PortfolioLocationDocumentUploadbtn", "PortfolioDocScorecardTab");
		testlog.info("And User clicks on Submit button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocScorecardTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocScorecardTab", "PortfolioV2ProjectDocumentScorecardTable");
		CommonMethod.scrolldowntoElement("PortfolioV2ProjectDocumentScorecardTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioV2ProjectDocumentScorecardTable", 0);
		pathprms.put("fileName", "FeatureFile");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, true, false, false, false, false,
				false, false, false);
		testlog.info("Then User will be redirected to Document list in Scorecard tab");
		testlog.info("And User verifies uploaded document");
		testlog.pass("**Verifies the Upload Document in Document successfully**");
	}

	public void UploadAuditDocV2ProjectInsideDocument(String SheetName, int rowNum, String DocumentType,
			String FileName, String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDocUploadbtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectDocUploadbtn", "V2ProjectPortfolioDocType");
		testlog.info("And User clicks on Upload button");
		CommonMethod.selectdropdownVisibletext("PortfolioDocDocumentType", DocumentType);
		testlog.info("And User select Document Type");
		CommonMethod.uploadFile("PortfolioScorecardFileUpload", FileName, "UploadFileVerifyScorecard");
		testlog.info("And User upload Document");
		CommonMethod.WaitUntilPresence("OwnerOrgClick", 60);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", "PortfolioDocumentAuditVerficationMethod");
		CommonMethod.WaitUntilPresence("PortfolioDocumentAuditVerficationMethod", 60);
		CommonMethod.click("PortfolioDocumentAuditVerficationMethod");
		Thread.sleep(2000);
		CommonMethod.scrolldowntoElement("OwnerOrgClick");
		testlog.info("And User select the Verification");
		CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationSelectFeature", 180);
		testlog.info("Then User verifies option to add multiple feature parts");
		CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "V03.2");
		testlog.info("And User select V03.1 Partname");
		CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
		testlog.info("And User Select SpaceType");
		CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
		testlog.info("And User Select Option");
		CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPartbtn", 180);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPartbtn",
				"PortfolioLocationScorecardUploadbtn");
		CommonMethod.WaitUntilPresence("PortfolioScorecardUploadRemovelink", 180);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardUploadRemovelink", "Remove button is invisible");
		testlog.info("And User clicks on Add Part and verifies the added multiple part");
		CommonMethod.WaitUntilPresence("PortfolioV2ProjectDocUpload", 60);
		CommonMethod.RobustclickElementVisible("PortfolioLocationDocumentUploadbtn", "PortfolioDocScorecardTab");
		rc.uploadDocumentToastMessage();
		testlog.info("And User clicks on Submit button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilPresence("PortfolioDocScorecardTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocScorecardTab", "PortfolioV2ProjectDocumentTable");
		pathprms.put("fileName", "AuditFile");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, true, false, false, false, false,
				false, false, false);
		testlog.info("Then User will be redirected to Document list in Scorecard tab");
		testlog.info("And User verifies uploaded document");
		testlog.pass("**Verifies the Upload Document in Document successfully**");
	}

	public void GeneralSearchFilterDocumentFromDocumentLibrary(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilPresence("PortfolioV2ProjectGeneralDoc", 60);
		CommonMethod.RobustclickElementVisible("PortfolioV2ProjectGeneralDoc", "PortfolioV2ProjectSearchDocument");
		testlog.info("When User clicks on GeneralDoc button");
		CommonMethod.WaitUntilPresence("PortfolioV2ProjectSearchDocument", 60);
		CommonMethod.sendKeys("PortfolioV2ProjectSearchDocument", "LEGAL");
		testlog.info("And User enter SearchDocument field");
		CommonMethod.RobustclickElementVisible("PortfolioLocationDocumentSearchbtn", "PortfolioV2ProjectDocumentTable");
		testlog.info("And User clicks on Search button");
		int var = CommonMethod.ElementSize("PortfolioV2ProjectDocumentTableTr");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "1", "Table Count Search filter mismatch");
		testlog.info("Then User will be redirected to GeneralDoc Document list");
		testlog.info("And User verifies uploaded document");
		testlog.pass("**Upload Legal Document in Document successfully**");
	}

	public void ScorecardSearchFilterDocumentFromDocumentLibrary(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilPresence("PortfolioDocScorecardTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocScorecardTab", "PortfolioV2ProjectSearchDocument");
		testlog.info("When User clicks on ScorecardDoc button");
		CommonMethod.WaitUntilPresence("PortfolioV2ProjectSearchDocument", 60);
		CommonMethod.sendKeys("PortfolioV2ProjectSearchDocument", "AUDITFILE");
		testlog.info("And User enter SearchDocument field");

		testlog.info("And User clicks on Search button");
		int var;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationDocumentSearchbtn", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationDocumentSearchbtn",
				"PortfolioV2ProjectDocumentScorecardTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioV2ProjectDocumentScorecardTable", 0);
		var = CommonMethod.ElementSize(PortfolioAndRatingLocAccDocumentTableTr);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "1",
				"Table row Count for Search filter mismatch");
		testlog.info("Then User will be redirected to ScorecardDoc Document list");
		testlog.info("And User verifies uploaded document");
		testlog.pass("**Verifies the Upload Scorecard Document in Document successfully**");
	}

	public void SharedDocSearchFilterDocumentFromDocumentLibrary(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilPresence("PortfolioLocationDocumentSharedDoc", 60);
		CommonMethod.RobustclickElementVisible("PortfolioLocationDocumentSharedDoc",
				"PortfolioV2ProjectSearchDocument");
		testlog.info("When User clicks on ScorecardDoc button");
		CommonMethod.WaitUntilPresence("PortfolioV2ProjectSearchDocument", 60);
		CommonMethod.sendKeys("PortfolioV2ProjectSearchDocument", "FEATUREFILE");
		testlog.info("And User enter SearchDocument field");
		CommonMethod.RobustclickElementVisible("PortfolioLocationDocumentSearchbtn", "PortfolioV2ProjectDocumentTable");
		testlog.info("And User clicks on Search button");
		int var;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioV2ProjectDocumentScorecardTable", 0);
		var = CommonMethod.ElementSize(PortfolioAndRatingLocAccDocumentTableTr);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "1",
				"Table row Count for Search filter mismatch");
		testlog.info("Then User will be redirected to Shared  Document list");
		testlog.info("And User verifies uploaded document");
		testlog.pass("**Verifies the Upload Scorecard Document in Document successfully**");

	}

	public void ValidateLocationUploadDocumentInPortfolioAcccount(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 120);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		testlog.info("When User clicks on DocumentList tab");
		CommonMethod.WaitUntilPresence(PortfolioAndRatingLocAccDocumentTable, 120);
		testlog.info("And User verifies Document Upload Table");
		CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException(PortfolioAndRatingLocAccDocumentTableTr, 10);
		int var = CommonMethod.ElementSize(PortfolioAndRatingLocAccDocumentTableTr);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "10",
				"Table row Count for Search filter failed");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentPaginationsecond", 0);
		CommonMethod.RobustclickElementVisible("WPRDocumentPaginationsecond", "WPRPaginationNumberText");
		testlog.info("And User clicks on pagination number");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRPaginationNumberText", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException(PortfolioAndRatingLocAccDocumentTableTr, 6);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPaginationNumberText"), "11",
				"Document Library Pagition count Doesn't match");
		testlog.info("Then User verifies the pagition Count");
		testlog.info("Then User will be redirected to Portfolio Acccount Document list");
		testlog.info("And User verifies uploaded document");
		testlog.pass("**Verifies the Upload Scorecard Document in Document successfully**");
	}

	public void AdminSearchById(String SheetName, int rowNum) throws IOException, InterruptedException {
		/** Admin Review */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "AdminWELLCertificationNavBar");
		CommonMethod.RobustclickElementVisible("AdminWELLCertificationNavBar", "AdminV2ProjectId");
		testlog.info("And User clicks on Admin WELL Certification from top menu under Projects");
		System.out.println("LocationProjectID:" + data.getCellData(SheetName, "LocationProjectID", rowNum));
		CommonMethod.WaitUntilClickble("AdminV2ProjectId", 60)
				.sendKeys(data.getCellData(SheetName, "LocationProjectID", rowNum));
		testlog.info("And User enter on ProjectID in  AdminV2ProjectId field");
		CommonMethod.RobustclickElementVisible("AdminV2ProjectApplybtn", "V2ProjectSearchResultIDVerify");
		testlog.info("And User clicks on Apply button");
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAdminRegStatus"), "REGISTERED",
				"REGISTERED doesn't match");
		testlog.info("Then User verifies Registration status");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAdminAgreeStatus"), "SIGNED",
				"REGISTERED doesn't match");
		testlog.info("Then User verifies Agreement status");
		CommonMethod.assertcontainsmessage("V2ProjectSearchResultIDVerify",
				data.getCellData(SheetName, "LocationProjectID", rowNum), "ProjectID doesn't matches in search");
		CommonMethod.WaitUntilPresence("V2ProjectIdCompare", 120);
		CommonMethod.RobustclickElementVisible("V2ProjectIdCompare", "V2ProjectStartBuilding");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectStartBuilding", 0);
	}

	public void portfolioAccountLocationScorecardFeature(String FeatureName, String ProjectType, String SheetName,
			int rowNum, String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		testlog.info("TaskName : " + FeatureName);
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			System.out.println("Creditname: " + Creditname);
			System.out.println("FeatureName: " + FeatureName);
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccLocScoreCardSelectUploadButton",
						0);
				CommonMethod.RobustclickElementVisible("PortfolioAccLocScoreCardSelectUploadButton",
						"PortfolioAccLocScoreCardSelectVerification");
				testlog.info("And User clicks on Upload button");
				if (ProjectType.contains("pilot")) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioAccLocScoreCardSelectVerification", 0);
					CommonMethod.RobustclickElementVisible("PortfolioAccLocScoreCardSelectVerification",
							"PortfolioScorecardLocV2PilotVerificationMethlist");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScorecardLocV2PilotVerificationMethlist", 0);
					CommonMethod.click("PortfolioScorecardLocV2PilotVerificationMethlist");
					testlog.info("And User select verification method");
				} else {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioAccLocScoreCardSelectVerification", 0);
					CommonMethod.RobustclickElementVisible("PortfolioAccLocScoreCardSelectVerification",
							"PortfolioScorecardLocVerificationMethlist");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScorecardLocVerificationMethlist", 0);
					CommonMethod.click("PortfolioScorecardLocVerificationMethlist");
					testlog.info("And User select verification method");
				}

				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationSelectFeature",
						0);
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A01.2");
				testlog.info("And User select A01.2 Partname");
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
				testlog.info("And User Select SpaceType");
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
				testlog.info("And User Select Option");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPartbtn", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPartbtn",
						"PortfolioScorecardUploadRemovelink");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationSelectFeature");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationSelectFeature",
						0);
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "W01.1");
				testlog.info("And User select W01.1 Partname");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationSelectSpaceType", 0);
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
				testlog.info("And User Select SpaceType");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationSelectOption",
						0);
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
				testlog.info("And User Select Option");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPartbtn", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPartbtn",
						"PortfolioScorecardAddPartLink1");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadRemovelink", 0);
				CommonMethod.uploadFile("PortfolioScorecardFileUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
				testlog.info("And User upload scorecard Document");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddNote", 0);
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "Test Comment");
				testlog.info("And User enter data to AddNote field");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationScorecardUploadbtn", 0);
				CommonMethod.Robustclick("PortfolioLocationScorecardUploadbtn",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScoreCardVerificationAddNote", 1);
				testlog.info("And User clicks on Submit button");
				Thread.sleep(2000);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectNextStep", 0);
				CommonMethod.scrolldowntoElement("V2ProjectNextStep");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException(PortfolioAndRatingLocAccDocumentTableTr,
						1);
				Thread.sleep(2000);
				pathprms.put("PartId", "A01.2");
				pathprms.put("VerificationMethod", "Performance Test");
				pathprms.put("Stage", "Feature");
				pathprms.put("Status", "Ready For Review");
				generic.validateUploadedDocumentTableOptnGeneric(SheetName, rowNum, Commodity, false, true, true, true,
						true, false);
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void portfolioAccountLocationScorecardAudit(String FeatureName, String ProjectType, String SheetName,
			int rowNum, String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
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
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccLocScoreCardSelectUploadButton",
						0);
				CommonMethod.RobustclickElementVisible("PortfolioAccLocScoreCardSelectUploadButton",
						"PortfolioAccLocScoreCardSelectVerification");
				testlog.info("And User clicks on Upload button");
				testlog.info("TaskName : Technical Document (Audited)");
				CommonMethod.WaitUntilPresence("V2Projectscorecardverificationdropdown", 120);
				CommonMethod.uploadFile("PortfolioScorecardFileUpload", AuditfileUpload, "UploadFileVerifyScorecard");
				testlog.info("And User upload scorecard Document");
				if (ProjectType.equalsIgnoreCase("v2")) {
					CommonMethod.WaitUntilPresence("OwnerOrgClick", 60);
					CommonMethod.RobustclickElementVisible("OwnerOrgClick", "PortfolioScorecardAuditVerficationMethod");
					CommonMethod.WaitUntilPresence("PortfolioScorecardAuditVerficationMethod", 60);
					CommonMethod.click("PortfolioScorecardAuditVerficationMethod");
				} else {
					CommonMethod.WaitUntilPresence("OwnerOrgClick", 60);
					CommonMethod.RobustclickElementVisible("OwnerOrgClick",
							"PortfolioScorecardAuditVerficationMethodv2p");
					CommonMethod.WaitUntilPresence("PortfolioScorecardAuditVerficationMethodv2p", 60);
					CommonMethod.click("PortfolioScorecardAuditVerficationMethodv2p");
				}
				testlog.info("And User select the Verification");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationSelectFeature", 300);
				CommonMethod.assertisElementPresentTrue("PortfolioScoreCardVerificationSelectFeature",
						"Multiple Add Parts is invisible");
				testlog.info("Then User verifies option to add multiple feature parts");
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A07.1");
				testlog.info("And User select A07.1 Partname");
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
				testlog.info("And User Select SpaceType");
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
				testlog.info("And User Select Option");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPartbtn", 180);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPartbtn",
						"PortfolioLocationScorecardUploadbtn");
				CommonMethod.WaitUntilPresence("PortfolioScorecardUploadRemovelink", 180);
				CommonMethod.assertisElementPresentTrue("PortfolioScorecardUploadRemovelink",
						"Remove button is invisible");
				testlog.info("And User clicks on Add Part and verifies the added multiple part");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardUploadRemovelink",
						"PortfolioLocationScorecardUploadbtn");
				testlog.info("And User clicks on Add feature Removelink");
				CommonMethod.assertisNotElementPresent("PortfolioScorecardUploadRemovelink", "Removelink is visible");
				testlog.info("And User verifies removed added multiple feature parts");
				/*
				 * Adding part again
				 */
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A07.1");
				testlog.info("And User select A07.1 Partname");
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
				testlog.info("And User Select SpaceType");
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
				testlog.info("And User Select Option");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPart", 180);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
						"PortfolioLocationScorecardUploadbtn");
				CommonMethod.WaitUntilPresence("PortfolioScorecardUploadRemovelink", 180);
				testlog.info("And User clicks on Add Part and verifies the added multiple part");
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException(
						"PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.assertisElementPresentFalse("PortfolioScoreCardVerificationUploadAddfeature",
						"Add multiple feature button is visible");
				testlog.info("And User verifies removed added multiple feature parts");
				/*
				 * Removing Doc and verify upload button change to disable
				 */
				CommonMethod.assertisNotElementPresent("PortfolioLocationScorecardUploadDisablebtn",
						"Upload button disable is visible");
				testlog.info("And User verifies Enable Upload button");
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadRemovelink");
				CommonMethod.Robustclick("PortfolioScorecardUploadRemoveLink");
				testlog.info("And User clicks on Upload Remove icon");
				CommonMethod.WaitUntilPresence("PortfolioLocationScorecardUploadDisablebtn", 120);
				CommonMethod.assertisElementPresentTrue("PortfolioLocationScorecardUploadDisablebtn",
						"Attach icon is Present");
				testlog.info("And User verifies Upload button disable");
				/*
				 * Again Upload Doc and verify upload button change to enable
				 */
				CommonMethod.uploadFile("PortfolioScorecardFileUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
				testlog.info("And User upload scorecard Document and verify remove icon");
				CommonMethod.WaitUntilPresence("PortfolioLocationScorecardUploadbtn", 180);
				CommonMethod.assertisElementPresentTrue("PortfolioLocationScorecardUploadbtn",
						"Upload button enable is Invisible");
				testlog.info("And User verifies Upload button Enable");
				CommonMethod.RobustclickElementVisible("PortfolioLocationScorecardUploadbtn",
						"PortfolioAccLocScoreCardSelectUploadButton");
				testlog.info("And User clicks on Submit button");
				testlog.info("Then User verifies upload scorecard document");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardlocAccountValidMessage", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardlocAccountValidMessage");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				pathprms.put("PartId", "A07.1");
				pathprms.put("VerificationMethod", "On-site Photographs");
				pathprms.put("Stage", "Audit");
				pathprms.put("Status", "Ready For Review");
				generic.validateUploadedDocumentTableOptnGeneric(SheetName, rowNum, Commodity, false, true, true, true,
						true, false);
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Verifies the Upload Document in Scorecard Feature successfully**");
				break;

			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void portfolioAccountLocationScorecardAlternative(String FeatureName, String ProjectType)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
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
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccLocScoreCardSelectUploadButton",
						0);
				CommonMethod.RobustclickElementVisible("PortfolioAccLocScoreCardSelectUploadButton",
						"PortfolioAccLocScoreCardSelectVerification");
				testlog.info("And User clicks on Upload button");
				CommonMethod.WaitUntilPresence("V2Projectscorecardverificationdropdown", 120);
				CommonMethod.uploadFile("PortfolioScorecardFileUpload", AlternativeFileUpload,
						"UploadFileVerifyScorecard");
				testlog.info("And User upload scorecard Document");
				CommonMethod.WaitUntilPresence("OwnerOrgClick", 60);
				CommonMethod.RobustclickElementVisible("OwnerOrgClick",
						"PortfolioScorecardAlternativeVerficationMethod");
				CommonMethod.WaitUntilPresence("PortfolioScorecardAlternativeVerficationMethod", 60);
				CommonMethod.click("PortfolioScorecardAlternativeVerficationMethod");
				testlog.info("And User select the Verification");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationSelectFeature", 180);
				testlog.info("Then User verifies option to add multiple feature parts");
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A08.1");
				testlog.info("And User select A08.1 Partname");
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectOption",
						"Alternative Adherence Path (AAP)");
				testlog.info("And User select Alternative Adherence Path (AAP) Options");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPartbtn", 180);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPartbtn",
						"PortfolioLocationScorecardUploadbtn");
				CommonMethod.WaitUntilPresence("PortfolioScorecardUploadRemovelink", 180);
				CommonMethod.assertisElementPresentTrue("PortfolioScorecardUploadRemovelink",
						"Remove button is invisible");
				testlog.info("And User clicks on Add Part and verifies the added multiple part");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardUploadRemovelink",
						"PortfolioLocationScorecardUploadbtn");
				testlog.info("And User clicks on Add feature Removelink");
				CommonMethod.assertisNotElementPresent("PortfolioScorecardUploadRemovelink", "Removelink is visible");
				testlog.info("And User verifies removed added multiple feature parts");
				/*
				 * Adding part again
				 */
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A08.1");
				testlog.info("And User select A08.1 Partname");
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectOption",
						"Alternative Adherence Path (AAP)");
				testlog.info("And User select Alternative Adherence Path (AAP) Options");
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPart", 180);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
						"PortfolioLocationScorecardUploadbtn");
				CommonMethod.WaitUntilPresence("PortfolioScorecardUploadRemovelink", 180);
				testlog.info("And User clicks on Add Part and verifies the added multiple part");
				/*
				 * Removing Doc and verify upload button change to disable
				 */
				CommonMethod.assertisNotElementPresent("PortfolioLocationScorecardUploadDisablebtn",
						"Upload button disable is visible");
				testlog.info("And User verifies Enable Upload button");
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadRemovelink");
				CommonMethod.Robustclick("PortfolioScorecardUploadRemoveLink");
				testlog.info("And User clicks on Upload Remove icon");
				CommonMethod.WaitUntilPresence("PortfolioLocationScorecardUploadDisablebtn", 120);
				CommonMethod.assertisElementPresentTrue("PortfolioLocationScorecardUploadDisablebtn",
						"Upload button enable is visible");
				testlog.info("And User verifies Upload button disable");
				/*
				 * Again Upload Doc and verify upload button change to enable
				 */
				CommonMethod.uploadFile("PortfolioScorecardFileUpload", AlternativeFileUpload,
						"UploadFileVerifyScorecard");
				testlog.info("And User upload scorecard Document and verify remove icon");
				CommonMethod.WaitUntilPresence("PortfolioLocationScorecardUploadbtn", 180);
				CommonMethod.assertisElementPresentTrue("PortfolioLocationScorecardUploadbtn",
						"Upload button enable is Invisible");
				testlog.info("And User verifies Upload button Enable");
				CommonMethod.RobustclickElementVisible("PortfolioLocationScorecardUploadbtn",
						"PortfolioAccLocScoreCardSelectUploadButton");
				testlog.info("And User clicks on Submit button");
				testlog.info("Then User verifies upload scorecard document");
				CommonMethod.JavascriptClickElement(ele);
				testlog.pass("**Verifies the Upload Document in Scorecard Feature successfully**");
				break;
			}

		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void ValidatePortfolioAccInsideScorecard(String SheetName, int rowNum, String FeatureName,
			String VerficationName, String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
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
				if (VerficationName.equalsIgnoreCase("Performance Test")) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioAccLocScoreCardSelectUploadButton", 0);
					CommonMethod.scrolldowntoElement("PortfolioAccLocScoreCardSelectUploadButton");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
					pathprms.put("PartId", "W01.1");
					pathprms.put("VerificationMethod", "Performance Test");
					pathprms.put("Stage", "Feature");
					pathprms.put("Status", "Ready For Review");
					generic.validateUploadedDocumentTableOptnGeneric(SheetName, rowNum, Commodity, false, true, true,
							true, true, false);
					testlog.info("And User verifies Verfication method Name");
				}
				if (VerficationName.equalsIgnoreCase("On-site Photographs")) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccLocScoreCardDocUploadTable",
							0);
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
					CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
					pathprms.put("PartId", "A07.1");
					pathprms.put("VerificationMethod", "On-site Photographs");
					pathprms.put("Stage", "Audit");
					pathprms.put("Status", "Ready For Review");
					generic.validateUploadedDocumentTableOptnGeneric(SheetName, rowNum, Commodity, false, true, true,
							true, true, false);
					testlog.info("And User verifies Verfication method Name");
					testlog.info("Then User verifies PuseYes feature");
					testlog.info("And User verifies Verfication method Name");
				}
				if (VerficationName.equalsIgnoreCase("Alternative Strategy")) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccLocScoreCardDocUploadTable",
							0);
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
					CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
					pathprms.put("PartId", "A08.1");
					pathprms.put("VerificationMethod", "Alternative Strategy");
					pathprms.put("Stage", "Feature");
					pathprms.put("Status", "Ready For Review");
					generic.validateUploadedDocumentTableOptnGeneric(SheetName, rowNum, Commodity, false, true, true,
							true, true, false);
					testlog.info("Then User verifies PuseYes feature");
					testlog.info("And User verifies Verfication method Name");
				}
				testlog.info("Then User verifies upload scorecard document");
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilPresence("WPRPortfolioScorecardLanding", Scorecardtimeout);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void UpdatePortfolioAccInsideScorecard() throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.RobustclickElementVisible("PortfolioDocListEditIcon",
				"PortfolioScoreCardVerificationUploadAddfeature");
		testlog.info("When User clicks on Edit icon");
		CommonMethod.WaitUntilPresence("ScorecardUploadEditDocumentLink", 120);
		testlog.info("And User verifies Document link");
		CommonMethod.WaitUntilPresence("PortfolioScorecardVerifyUpdateLocation", 60);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardVerifyUpdateLocation"), "",
				"Update Task Upload Update Location Count doesn't match");
		testlog.info("And User verifies Assigned Location count");
	}

	public void validPortfolioUplodedDocAccountLocationScorecard(String FeatureName)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		testlog.info("TaskName : " + FeatureName);
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAccLocScoreCardDocUploadTable", 0);
				CommonMethod.scrolldowntoElement("PortfolioAccLocScoreCardDocUploadTable");
				List<String> val = CommonMethod.fetchTableData("PortfolioAccLocScoreCardDocUploadTable");
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.scrolldowntoElement("PortfolioAccLocScoreCardDocUploadTable");
				CommonMethod.negativesoftassertFieldValid(val.get(1), "A01.1",
						"Partname in Document table data mismatch");
				CommonMethod.negativesoftassertFieldValid(val.get(2), "Performance Test",
						"Verification Method in Document table data mismatch for Portfolio Account");
				CommonMethod.negativesoftassertFieldValid(val.get(3), "Implementation",
						"Type in Document table data mismatch for Portfolio Account");
				CommonMethod.negativesoftassertFieldValid(val.get(4), "Feature",
						"Doc Stage in Document table data mismatch for Portfolio Account");
				CommonMethod.negativesoftassertFieldValid(val.get(5), "READY FOR REVIEW",
						"Status in Document table data mismatch for Portfolio Account");
				testlog.info("Then User verifies PuseYes feature");
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
			}
			break;
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void editScorecardDocumentlocationAccountFromScorecard(String FeatureName) throws Exception {
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		testlog.info("TaskName : " + FeatureName);
		System.out.println("FeatureName : " + FeatureName);
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardlocAccountValidMessage", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardlocAccountValidMessage");
				rc.documentTableEditButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardDocumentType", 0);
				/** Valid DocumentType */
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardDocumentType"),
						"Feature", "Document Type doesn't match");
				testlog.info("DocumentType: " + CommonMethod.getText("PortfolioScorecardDocumentType"));
				testlog.info("And User verifies DocumentType");
				/** Valid FeatureName */
				CommonMethod.WaitUntilPresence("PortfolioScorecardUploadFeatureName", 60);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardUploadFeatureName"),
						FeatureName, "Feature Name doesn't match");
				testlog.info("FeatureName: " + CommonMethod.getText("PortfolioScorecardUploadFeatureName"));
				testlog.info("And User verifies PartName");
				CommonMethod.clearAndSendKey("PortfolioScoreCardVerificationAddNote", "NoteComment");
				testlog.info("And User enter data to AddNote field");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioV2ProjectDocumentScorecardUpdateButton", 0);
				CommonMethod.Robustclick("PortfolioV2ProjectDocumentScorecardUpdateButton",
						"PortfolioScoreCardVerificationAddNote");
				testlog.info("And User clicks on Update button");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScoreCardVerificationAddNote", 1);
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				break;
			}

		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void deleteScorecardDocumentlocationAccountFromScorecard(String FeatureName) throws Exception {
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		testlog.info("TaskName : " + FeatureName);
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardlocAccountValidMessage", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardlocAccountValidMessage");
				rc.documentTableDeleteButton();
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				break;
			}

		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void editScorecardDocumentFromDocumentLibrary() throws Exception {
		testlog.info("Given User is on Document page");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocScorecardTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocScorecardTab", "PortfolioV2ProjectDocumentScorecardTable");
		CommonMethod.scrolldowntoElement("PortfolioDocScorecardTab");
		testlog.info("When User clicks on ScorecardDoc button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioV2ProjectDocumentScorecardTable", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardLocAccountTableTrEdit", 0);
		CommonMethod.click("PortfolioScorecardLocAccountTableTrEdit");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardLocAccountTableTrEditbtn", 0);
		CommonMethod.RobustclickElementVisible("PortfolioScorecardLocAccountTableTrEditbtn",
				"PortfolioScoreVerifyUploadVerificationMethod");
		testlog.info("When User clicks on Edit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardDocumentType", 0);
		/** Valid DocumentType */
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardDocumentType"), "Feature",
				"Document Type doesn't match");
		testlog.info("DocumentType: " + CommonMethod.getText("PortfolioScorecardDocumentType"));
		testlog.info("And User verifies DocumentType");
		/** Valid FeatureName */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddNote", 0);
		CommonMethod.clearAndSendKey("PortfolioScoreCardVerificationAddNote", "NoteComment");
		testlog.info("And User enter data to AddNote field");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioV2ProjectDocumentScorecardUpdateButton", 0);
		CommonMethod.Robustclick("PortfolioV2ProjectDocumentScorecardUpdateButton",
				"PortfolioScoreCardVerificationAddNote");
		testlog.info("And User clicks on Update button");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScoreCardVerificationAddNote", 1);

	}

	public void MultipleUploadFeatureDocV2ProjectInsideDocument(String SheetName, int rowNum, String DocumentType,
			String FileName, String ProjectType) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDocUploadbtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectDocUploadbtn", "V2ProjectPortfolioDocType");
		testlog.info("And User clicks on Upload button");
		CommonMethod.selectdropdownVisibletext("PortfolioDocDocumentType", DocumentType);
		testlog.info("And User select Document Type");
		CommonMethod.uploadFile("PortfolioScorecardFileUpload", FileName, "UploadFileVerifyScorecard");
		testlog.info("And User upload Document");
		CommonMethod.WaitUntilPresence("OwnerOrgClick", 60);
		CommonMethod.click("OwnerOrgClick");
		if (ProjectType.contains("pilot")) {
			CommonMethod.WaitUntilPresence("PortfolioScorecardLocV2PilotVerificationMethlist", 60);
			CommonMethod.click("PortfolioScorecardLocV2PilotVerificationMethlist");
		} else {
			CommonMethod.WaitUntilPresence("PortfolioScorecardLocVerificationMethlist", 60);
			CommonMethod.click("PortfolioScorecardLocVerificationMethlist");
		}
		Thread.sleep(2000);
		CommonMethod.scrolldowntoElement("OwnerOrgClick");
		testlog.info("And User select the Verification");
		CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationSelectFeature", 180);
		testlog.info("Then User verifies option to add multiple feature parts");
		CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectFeature");
		testlog.info("And User select T01.1 Partname");
		CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
		CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
		CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPartbtn", 180);
		CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPartbtn",
				"PortfolioLocationScorecardUploadbtn");
		CommonMethod.WaitUntilPresence("PortfolioScorecardUploadRemovelink", 180);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardUploadRemovelink", "Remove button is invisible");
		testlog.info("And User clicks on Add Part and verifies the added multiple part");
		CommonMethod.WaitUntilPresence("PortfolioV2ProjectDocUpload", 60);
		CommonMethod.RobustclickElementVisible("PortfolioLocationDocumentUploadbtn", "PortfolioDocScorecardTab");
		testlog.info("And User clicks on Submit button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilPresence("PortfolioDocScorecardTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocScorecardTab", "PortfolioV2ProjectDocumentTable");
		testlog.info("Then User will be redirected to Document list in Scorecard tab");
		testlog.info("And User verifies uploaded document");
		testlog.pass("**Verifies the Upload Document in Document successfully**");
	}

	public void pagnitionScorecardDocumentFromDocumentLibrary() throws IOException, InterruptedException {
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocScorecardTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocScorecardTab", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.scrolldowntoElement("PortfolioDocScorecardTab");
		testlog.info("When User clicks on ScorecardDoc button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException(PortfolioAndRatingLocAccDocumentTableTr, 10);
		int var = CommonMethod.ElementSize(PortfolioAndRatingLocAccDocumentTableTr);
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "10",
				"Pagnition Scorecard table row Count mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioV2ProjectDocumentScorecardNextPagnition", 0);
		CommonMethod.RobustclickElementVisible("PortfolioV2ProjectDocumentScorecardNextPagnition",
				PortfolioAndRatingLocAccDocumentTableTr);
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException(PortfolioAndRatingLocAccDocumentTableTr, 2);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPaginationNumberText"), "11",
				"Document Library Pagition count Doesn't match");

	}

	public void deleteScorecardDocumentFromDocumentLibrary() throws Exception {
		testlog.info("Given User is on Document page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocScorecardTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocScorecardTab", "PortfolioV2ProjectDocumentScorecardTable");
		CommonMethod.scrolldowntoElement("PortfolioDocScorecardTab");
		testlog.info("When User clicks on ScorecardDoc button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
		CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTableDeleteIcon, 0);
		CommonMethod.RobustclickElementVisible(PortfolioAndRatingLocAccDocumentTableDeleteIcon, "DeleteButton");
		testlog.info("When User clicks on Delete button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DeleteButton", 0);
		CommonMethod.Robustclick("DeleteButton");
		CommonMethod.scrolldowntoElement("PortfolioDocScorecardTab");
		testlog.info("When User clicks on ScorecardDoc button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTableTr, 0);
		int var = CommonMethod.ElementSize(PortfolioAndRatingLocAccDocumentTableTr);
		System.out.println("table tr: " + var);
	}

	public void LocationAccountMultipleScorecardUpload(String FeatureName, String ProjectType)
			throws IOException, InterruptedException {
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		testlog.info("TaskName : " + FeatureName);
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				for (int i = 0; i <= 7; i++) {
					if (ProjectType.contains("pilot")) {
						CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
								"PortfolioAccLocScoreCardSelectUploadButton", 0);
						CommonMethod.RobustclickElementVisible("PortfolioAccLocScoreCardSelectUploadButton",
								"PortfolioAccLocScoreCardSelectVerification");
						testlog.info("And User clicks on Upload button");
						CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
								"PortfolioAccLocScoreCardSelectVerification", 0);
						CommonMethod.RobustclickElementVisible("PortfolioAccLocScoreCardSelectVerification",
								"PortfolioScorecardLocV2PilotVerificationMethlist");
						CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
								"PortfolioScorecardLocV2PilotVerificationMethlist", 0);
						CommonMethod.click("PortfolioScorecardLocV2PilotVerificationMethlist");
						testlog.info("And User select verification method");
					} else {
						CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
								"PortfolioAccLocScoreCardSelectUploadButton", 0);
						CommonMethod.RobustclickElementVisible("PortfolioAccLocScoreCardSelectUploadButton",
								"PortfolioAccLocScoreCardSelectVerification");
						CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
								"PortfolioAccLocScoreCardSelectVerification", 0);
						CommonMethod.RobustclickElementVisible("PortfolioAccLocScoreCardSelectVerification",
								"PortfolioScorecardLocVerificationMethlist");
						CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
								"PortfolioScorecardLocVerificationMethlist", 0);
						CommonMethod.click("PortfolioScorecardLocVerificationMethlist");
						testlog.info("And User select verification method");
					}
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScoreCardVerificationSelectFeature", 0);
					CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A01.2");
					testlog.info("And User select A01.2 Partname");
					if (CommonMethod.isElementsExist("PortfolioScoreCardVerificationSelectSpaceType", 5)) {
						CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
						testlog.info("And User Select SpaceType");
					}
					if (CommonMethod.isElementsExist("PortfolioScoreCardVerificationSelectOption", 5)) {
						CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
					}
					testlog.info("And User Select Option");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPartbtn",
							0);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPartbtn",
							"PortfolioScorecardUploadRemovelink");
					CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 60);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
							"PortfolioScoreCardVerificationSelectFeature");
					CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScoreCardVerificationSelectFeature", 0);
					CommonMethod.uploadFile("PortfolioScorecardFileUpload", FeaturefileUpload,
							"UploadFileVerifyScorecard");
					testlog.info("And User upload scorecard Document");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationScorecardUploadbtn", 0);
					CommonMethod.RobustclickElementVisible("PortfolioLocationScorecardUploadbtn",
							"PortfolioAccLocScoreCardDocUploadTable");
					testlog.info("And User clicks on Submit button");
					if (CommonMethod.isElementsExist("DocumentAddedToasterMessage", 5)) {
						CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("DocumentAddedToasterMessage", 1);
					}
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
					int j = i + 1;
					if (j > 5) {
						j = 5;
					}
					CommonMethod.WaitUntilNumberOfElementToBePresentWithException(
							PortfolioAndRatingLocAccDocumentTableTr, j);
					CommonMethod.hideElement("NavBarHide");
				}
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void validPagnitionLocationAccountFromScorecard(String FeatureName)
			throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		testlog.info("TaskName : " + FeatureName);
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException(PortfolioAndRatingLocAccDocumentTableTr,
						5);
				int var = CommonMethod.ElementSize(PortfolioAndRatingLocAccDocumentTableTr);
				CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "5",
						"Pagnition Scorecard table row Count mismatch");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentPaginationsecond", 0);
				CommonMethod.RobustclickElementVisible("WPRDocumentPaginationsecond", "WPRPaginationNumberText");
				testlog.info("And User clicks on pagination number");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRPaginationNumberText", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException(PortfolioAndRatingLocAccDocumentTableTr,
						3);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPaginationNumberText"), "6",
						"Document Library Pagition count Doesn't match");
				testlog.info("Then User verifies the pagition Count");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void purseYesValidFromScorecard() throws IOException, InterruptedException {
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesSelect", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseYesSelect");
		testlog.info("And User click on Purse Yes");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardPurseYesSelected", 1);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardPurseYesSelected", "PurseYes is not selected");
		testlog.info("And User verifies the Selected Purse Yes");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"), "Pursue status changed!",
				"Purse Status message Doesn't match");
		testlog.info("Then User verifies the Pursue status message");
		testlog.pass("**Verifies the Pursue Yes status successful**");
	}

	public void purseNoValidFromScorecard() throws IOException, InterruptedException {
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseNoSelect", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseNoSelect");
		testlog.info("And User click on Purse No");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardPurseNoSelected", 1);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardPurseNoSelected", "PurseNo is not selected");
		testlog.info("And User verifies the Selected Purse No");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"), "Pursue status changed!",
				"Purse Status message Doesn't match");
		testlog.info("Then User verifies the Pursue status message");
		testlog.pass("**Verifies the Pursue No status successful**");

	}

	public void purseMaybeValidFromScorecard() throws IOException, InterruptedException {
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseMaySelect", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseMaySelect");
		testlog.info("And User click on Purse Maybe");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardPurseMaySelected", 1);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardPurseMaySelected", "PurseMaybe is not selected");
		testlog.info("And User verifies the Selected Purse Maybe");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"), "Pursue status changed!",
				"Purse Status message Doesn't match");
		testlog.info("Then User verifies the Pursue status message");
		testlog.pass("**Verifies the Pursue Maybe status successful**");

	}

	public void purseYesToNoValidFromScorecard() throws IOException, InterruptedException {
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoSelect", 0);
		CommonMethod.RobustclickElementVisible("PortfolioScorecardPurseYesToNoSelect",
				"PortfolioScorecardPurseYesToNoConfirm");
		testlog.info("And User click on Purse No");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoCancel", 0);
		testlog.info("And User verifies confirm button");
		testlog.info("And User verifies cancel button");
		// cancel
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoCancel");
		testlog.info("And User click on cancel button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardPurseYesSelected", 1);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardPurseYesSelected", "PurseYes is not selected");
		testlog.info("Then User verifies the Pursue yes button");
		// Confirm
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoSelect", 0);
		CommonMethod.RobustclickElementVisible("PortfolioScorecardPurseYesToNoSelect",
				"PortfolioScorecardPurseYesToNoConfirm");
		testlog.info("And User click on Purse No");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoConfirm");
		testlog.info("And User click on Cancel button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"), "Pursue status changed!",
				"Purse Status message Doesn't match");
		testlog.info("And User verifies the Pursue status message");
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("PortfolioScorecardPurseYesSelected");
		CommonMethod.assertisElementPresentFalse("PortfolioScorecardPurseYesSelected", "PurseYes is selected");
		testlog.info("And User verifies the Unseleceted Pursue Yes");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardPurseYesToNoSelected", 1);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardPurseYesToNoSelected", "PurseNo is not selected");
		testlog.info("And User verifies the seleceted Pursue No");
		testlog.pass("**Verifies the Converting Pursue Yes to No status successful**");
	}

	public void purseMaybeToNoValidFromScorecard() throws IOException, InterruptedException {
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseMaybeToNoSelect", 0);
		CommonMethod.RobustclickElementVisible("PortfolioScorecardPurseMaybeToNoSelect",
				"PortfolioScorecardPurseYesToNoConfirm");
		testlog.info("And User click on Purse No");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoCancel", 0);
		testlog.info("And User verifies confirm button");
		testlog.info("And User verifies cancel button");
		// cancel
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoCancel");
		testlog.info("And User click on cancel button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardPurseMaySelected", 1);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardPurseMaySelected", "PurseYes is not selected");
		testlog.info("Then User verifies the Pursue yes button");
		// Confirm
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseMaybeToNoSelect", 0);
		CommonMethod.RobustclickElementVisible("PortfolioScorecardPurseMaybeToNoSelect",
				"PortfolioScorecardPurseYesToNoConfirm");
		testlog.info("And User click on Purse No");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoConfirm");
		testlog.info("And User click on Cancel button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"), "Pursue status changed!",
				"Purse Status message Doesn't match");
		testlog.info("Then User verifies the Pursue status message");
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("PortfolioScorecardPurseMaySelected");
		CommonMethod.assertisElementPresentFalse("PortfolioScorecardPurseMaySelected", "Maybe is selected");
		testlog.info("Then User verifies the Unseleceted Pursue Maybe");
		testlog.pass("**Verifies the Converting Pursue Maybe to No status successful**");
	}

	public void validRemoveOption() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
		CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardAddedOptionCrossIcon", 0);
		CommonMethod.RobustclickElementVisible("ScorecardAddedOptionCrossIcon", "ScorecardAddedRemoveOptionPopUpValid");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardAddedRemoveOptionPopUpValid", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardAddedRemoveOptionPopUpCancelbtn", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardAddedRemoveOptionPopUpContinuebtn", 0);
		CommonMethod.Robustclick("ScorecardAddedRemoveOptionPopUpContinuebtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("ScorecardAddedRemoveOptionPopUpContinuebtn", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScoreCardAddOptionbutton", 1);
		CommonMethod.assertisElementPresentTrue("PortfolioScoreCardAddOptionbutton", "Add Option is not visible");
		testlog.info("User clicks on Remove button and verified its removed");
	}

	public void validAddOption(String SheetName, int rowNum, String FeatureName, String Commodity, String OptionName)
			throws Exception {
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
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
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				if (OptionName.equalsIgnoreCase("Common")) {
					/** ScoreCard Add Feature option */
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
							"PortfolioScoreCardAddButton");
					testlog.info("And User clicks on AddOption button");
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton", "ScorecardAddedOption");
					testlog.info("And User clicks on Add button");
					CommonMethod.WaitUntilNumberOfElementToBePresentWithException("ScorecardAddedOption", 1);
					CommonMethod.negativesoftassertFieldValidEquals(
							String.valueOf(CommonMethod.ElementSize("ScorecardAddedOption")), "1",
							"Added Button count mismatch");
					validRemoveOption();
				}
				if (OptionName.equalsIgnoreCase("Alternative")) {
					/** ScoreCard Add Alternative option */
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
							"PortfolioScoreCardAddButton");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecrdAlterntives", 0);
					CommonMethod.JavascriptClickElement("ScorecrdAlterntives");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardAlternativeAddBtn", 0);
					CommonMethod.JavascriptClickElement("ScorecardAlternativeAddBtn");
					testlog.info("And User clicks on Add button");
					validRemoveOption();
				}
				if (OptionName.equalsIgnoreCase("NA")) {
					/** ScoreCard Add NA option */
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
							"PortfolioScoreCardAddButton");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecarNAOption", 0);
					CommonMethod.RobustclickElementVisible("PortfolioScorecarNAOption", "PortfolioScorecarNAAddButton");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecarNAAddButton", 0);
					CommonMethod.RobustclickElementVisible("PortfolioScorecarNAAddButton",
							"PortfolioScorecarNAValidSelectedAddButtonToasterMessage");
					testlog.info("And User clicks on AddOption button");
					validRemoveOption();
					// Add NA option
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
							"PortfolioScoreCardAddButton");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecarNAOption", 0);
					CommonMethod.RobustclickElementVisible("PortfolioScorecarNAOption", "PortfolioScorecarNAAddButton");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecarNAAddButton", 0);
					CommonMethod.RobustclickElementVisible("PortfolioScorecarNAAddButton",
							"PortfolioScorecarNAValidSelectedAddButtonToasterMessage");
					testlog.info("And User clicks on AddOption button");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon",
							0);
					CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
					generic.assignLocationGeneric(Commodity, false, false, false, false, true);

					/** Upload Document for Tasks */
					CommonMethod.scrollDown();
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn",
							0);
					CommonMethod.JavascriptClickElement("PortfolioScoreCardVerificationUploadbtn");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScoreVerifyUploadVerificationMethod", 0);
					testlog.info("And User clicks on Upload Button");
					String VerificationMethod = CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod");
					testlog.info("VerificationMethod: " + VerificationMethod);
					CommonMethod.negativesoftassertFieldValid(VerificationMethod, "Alternative Strategy",
							"Verification Method doesn't match");
					testlog.info("Then User verifies verification Method");
					/** Valid DocumentType */
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardDocumentType"),
							"Feature verification", "Document Type doesn't match");
					testlog.info("DocumentType: " + CommonMethod.getText("PortfolioScorecardDocumentType"));
					testlog.info("And User verifies DocumentType");
					/** Valid FeatureName */
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadFeatureName", 0);
					CommonMethod.negativesoftassertFieldValid(
							CommonMethod.getText("PortfolioScorecardUploadFeatureName"), "Prohibit Outdoor Smoking",
							"Feature Name doesn't match");
					testlog.info("FeatureName: " + CommonMethod.getText("PortfolioScorecardUploadFeatureName"));
					testlog.info("And User verifies PartName");
					/** Valid PartName */
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadPartName", 0);
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardUploadPartName"),
							"A02.2", "PartName doesn't match");
					testlog.info("PartName: " + CommonMethod.getText("PortfolioScorecardUploadPartName"));
					testlog.info("And User verifies PartNo.");
					/** Valid SpaceType */
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadSpaceType", 0);
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardUploadSpaceType"),
							"Not Applicable", "SpaceType doesn't match");
					testlog.info("SpaceType: " + CommonMethod.getText("PortfolioScorecardUploadSpaceType"));
					testlog.info("And User verifies SpaceType");
					CommonMethod.assertisNotElementPresent("PortfolioScoreCardVerificationAddPart",
							"Add Part Option shouldn't Present");
					testlog.info("And User verifies Added feature option");
					CommonMethod.assertisElementPresentTrue("PortfolioScorecarNAPdfDoc",
							"Not_Applicable document link doesn't Present");
					testlog.info("And User verifies Not Applicable document link");
					CommonMethod.assertisNotElementPresent("PortfolioScoreCardVerificationUpload",
							"File Attach element shouldn't Present");
					testlog.info("And User verifies Upload Feature link");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddNote",
							0);
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndContinuebtn", 0);
					CommonMethod.RobustclickElementVisible("SaveAndContinuebtn", "ErrorMessage");
					testlog.info("And User clicks on save button");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ErrorMessage", 0);
					CommonMethod.negativesoftassertPageSource("Note is required.", "Note Error message Mismatch");
					testlog.info("And User Note Error message");
					CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "Test Note");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScorecardVerifyTaskUploadIntentStage", 0);
					CommonMethod.ClickParticularCheckbox("PortfolioScorecardVerifyTaskUploadIntentStage");
					CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioScorecardVerifyTaskUploadIntentStage");
					CommonMethod.declickListWebelementFromIndex("PortfolioScorecardVerifyTaskUploadIntentStage", 0);
					testlog.info("And User verifies IntentStage checkbox is checked");
					rc.ScorecardUploadSaveButton();
					rc.ScorecardConfirmLocUploadSaveButton();
					testlog.info("And User clicks on Upload button");
					rc.uploadDocumentToastMessage();
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn",
							0);
					CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
					pathprms.put("fileName", "Ready For Review");
					pathprms.put("LocationCount", "5 Assigned");
					pathprms.put("PartId", "A02.2");
					pathprms.put("VerificationMethod", "Alternative Strategy");
					pathprms.put("Stage", "Feature");
					pathprms.put("Status", "Ready For Review");
					generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, true, true,
							true, true, true, false);
				}
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void validAndCondition(String SheetName, int rowNum, String FeatureName, String Commodity) throws Exception {
		testlog.info("Given User on Scorecard page");// Prohibit Outdoor Smoking
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
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
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardVerifyAndOption", 0);
				testlog.info("And Condition: " + CommonMethod.getText("PortfolioScorecardVerifyAndOption"));
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardVerifyAndOption"),
						"AND", "AND Condition doesn't match");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddButton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton", "ScorecardAddedOption");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardOptionCount", 0);
				testlog.info("OptionCount: " + CommonMethod.ElementSize("PortfolioScorecardOptionCount"));
				CommonMethod.negativesoftassertFieldValidEquals(
						Integer.toString(CommonMethod.ElementSize("PortfolioScorecardOptionCount")), "2",
						"OptionCount list doesn't match");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardDisabledUploadButton", 0);
				testlog.info("TaskCount: " + CommonMethod.ElementSize("PortfolioScoreCardTaskCount"));
				CommonMethod.negativesoftassertFieldValidEquals(
						Integer.toString(CommonMethod.ElementSize("ScorecardDisabledUploadButton")), "3",
						"Disabled TaskCount list doesn't match");
				testlog.info("And User verifies Option list");
				testlog.info("And User verifies disabled Task Upload list");
				generic.assignLocationGeneric(Commodity, false, true, false, false, false);

				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditLocationButton", 0);
				CommonMethod.negativesoftassertFieldValidEquals(
						Integer.toString(CommonMethod.ElementSize("EditLocationButton")), "1",
						"Edit Location list doesn't match");
				testlog.info("And User verifies Edit Location button list");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAuditPurseLocCount", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardAuditPurseLocCount"),
						"15 Pursuing", "15 Pursuing location Count doesn't match");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRScorecardUploadTaskDocument", 0);
				CommonMethod.negativesoftassertFieldValidEquals(
						Integer.toString(CommonMethod.ElementSize("WPRScorecardUploadTaskDocument")), "3",
						"Disabled TaskCount list doesn't match");
				testlog.info("And User verifies Enabled Task Upload list");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAuditTaskPurseLocation", 0);
				List<WebElement> TaskAssignLocation;
				TaskAssignLocation = CommonMethod.findElements("PortfolioScorecardAuditTaskPurseLocation");
				for (WebElement f : TaskAssignLocation) {
					CommonMethod.negativesoftassertFieldValidEquals(CommonMethod.getText(f), "0/3 Locations",
							"Audit Task Assign Location Count doesn't match");
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTaskPurseLocLocation", 0);
				CommonMethod.negativesoftassertFieldValidEquals(
						CommonMethod.getText("PortfolioScorecardTaskPurseLocLocation"), "0/15 Locations",
						"Task Assign Location Count doesn't match");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void validAddTierPoint(String SheetName, int rowNum, String FeatureName, String Commodity) throws Exception {
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
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
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTierDropdownValue", 0);
				CommonMethod.negativesoftassertFieldValidEquals(
						String.valueOf(CommonMethod.ElementSize("PortfolioScorecardVerifyTierDropdownValue")), "4",
						"Tier Dropdown Dropdowns doesn't match");
				CommonMethod.negativesoftassertFieldValidEquals(
						String.valueOf(CommonMethod.getdropdownSize("PortfolioScorecardTierDropdownValue")), "3",
						"Tier Dropdown Defualt value doesn't match");
				testlog.info("And User verifies Tier Dropdown Count");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddButton", 0);
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				testlog.info("And User clicks on Add button");
				CommonMethod.verifySelectedDropdownText("PortfolioScorecardTierDropdownValue", "Tier 1",
						"Tier Option1 Dropdown Defualt value doesn't match");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTierDropdownValueOption2",
						0);
				CommonMethod.verifySelectedDropdownText("PortfolioScorecardTierDropdownValueOption2", "Tier 1",
						"Tier Option2 Dropdown Defualt value doesn't match");
				testlog.info("And User verifies Tier Dropdown Defualt value");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTierDropdownValue", 0);
				CommonMethod.selectdropdownVisibletext("PortfolioScorecardTierDropdownValue", "Tier 1");
				testlog.info("And User select Tier 1 option");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTierDropdownValueOption2",
						0);
				CommonMethod.selectdropdownVisibletext("PortfolioScorecardTierDropdownValueOption2", "Tier 2");
				testlog.info("And User select Tier 2 option");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				CommonMethod
						.WaitUntilNumberOfElementToBeNotPresentWithException("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardTierDropdownValue", 0);
				CommonMethod.verifySelectedDropdownText("PortfolioScorecardTierDropdownValue", "Tier 1",
						"Selected Tier1 Dropdown doesn't match");
				CommonMethod.verifySelectedDropdownText("PortfolioScorecardTierDropdownValueOption2", "Tier 2",
						"Selected Tier2 Dropdown doesn't match");
				testlog.info("And User verifies selected Tier point for option1");
				testlog.info("And User verifies selected Tier point for option2");
				testlog.info("OptionCount: " + CommonMethod.ElementSize("PortfolioScorecardOptionCount"));
				CommonMethod.negativesoftassertFieldValidEquals(
						Integer.toString(CommonMethod.ElementSize("PortfolioScorecardOptionCount")), "4",
						"OptionCount list doesn't match");
				testlog.info("And User verifies option count");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void validAssignLocation(String SheetName, int rowNum, String FeatureName, String Commodity)
			throws Exception {
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
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
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab", "Assignbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Assignbutton", 0);
				/** Assign 10 Location */
				CommonMethod.RobustclickElementVisible("WPRAssignLocbtn",
						"PortfolioScoreCardVerificationAssignChildLocCbx");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocationTableTr", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx",
						0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1, 11);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioScoreCardVerificationAssignLocSavebtn,
						0);
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardLocationUpdateLabel", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardLocationUpdateLabel"),
						"10 locations selected", "Task Upload Update Location Count doesn't match");
				testlog.info("And User verifies 10 Assigned Location");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAuditPurseLocCount", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardAuditPurseLocCount"),
						"10 Pursuing", "10 Pursuing location Count doesn't match");

				/** All locations will be selected */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Assignbutton", 0);
				CommonMethod.RobustclickElementVisible("WPRAssignLocbtn",
						"PortfolioScoreCardVerificationAssignChildLocCbx");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx",
						0);
				CommonMethod.ClickCheckbox("PortfolioScoreCardVerificationAssignLocCbx");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SelectAllLocation", 0);
				CommonMethod.Robustclick("SelectAllLocation");
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("SelectAllLocation");
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardLocationUpdateLabel", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardLocationUpdateLabel"),
						"20 locations selected", "Task Upload Update Location Count doesn't match");
				testlog.info("And User verifies 20 Assigned Location");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioScoreCardVerificationAssignLocSavebtn,
						0);
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAuditAcheiveLocCount", 0);
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getText("PortfolioScorecardAuditAcheiveLocCount"), "20 Pursuing",
						"20 Pursuing location Count doesn't match");
				testlog.info("And User verifies 20 Pursuing Location");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void validAssignLocationFilter(String SheetName, int rowNum, String FeatureName, String Commodity)
			throws Exception {
		testlog.info("Given User on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
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
						"PortfolioScorecardEditLocation");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadEditLocationA05.2",
						0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardUploadEditLocationA05.2",
						"PortfolioScoreCardVerificationAssignLocCbxGeneral");
				testlog.info("And User clicks on Edit Location Button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFilters", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFilters", "OwnerOrgClick");
				testlog.info("And User clicks on Filters Button");
				/*
				 * AssignLocation Country Filter
				 */
				validAssignLocationCountryFilter("Afghanistan");
				validAssignLocationFilter("1");
				validAssignLocationCountryFilter("United States");
				validAssignLocationFilter("1");
				validAssignLocationCountryFilter("India");
				validAssignLocationFilter("2");
				testlog.info("And User verifies AssignLocation Country Filter");
				validAssignLocationCountryFilter("Argentina");
				noLocationsFilter();

				/*
				 * AssignLocation Construction Status
				 */
				validAssignLocationConstructionStatusFilter("All");
				selectedAssignLocationFilter("20 locations selected");
				/*
				 * AssignLocation Subset
				 */
				validAssignLocationSubsetTypeFilter("None");
				selectedAssignLocationFilter("20 locations selected");

				/*
				 * AssignLocation Status Filter
				 */
				validAssignLocationStatusFilter("All");
				selectedAssignLocationFilter("20 locations selected");
				validAssignLocationStatusFilter("Assigned");
				selectedAssignLocationFilter("20 locations selected");
				validAssignLocationStatusFilter("Not assigned");
				validAssignLocationFilter("1");

				/*
				 * AssignLocation SpaceType Filter
				 */
				validAssignLocationSpaceTypeFilter("Outdoor Spaces");
				validAssignLocationFilter("6");
				validAssignLocationSpaceTypeFilter("Shopping center");
				validAssignLocationFilter("8");
				validAssignLocationSpaceTypeFilter("Commercial Kitchen Spaces");
				noLocationsFilter();

				/*
				 * AssignLocation OwnershipType Filter
				 */
				validAssignLocationOwnershipTypeFilter("Owner-occupied");
				selectedAssignLocationFilter("14 locations selected");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void validAssignLocationFilter(String TrSize) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr",
				Integer.parseInt(TrSize));
		int AssignLocTableTrSize = CommonMethod.ElementSize("AssignLocationTableTr");
		String TableTrSize = Integer.toString(AssignLocTableTrSize);
		CommonMethod.negativesoftassertFieldValidEquals(TableTrSize, TrSize,
				"TableTrSize in Document list doesn't match");
		clearButton();
	}

	public void selectedAssignLocationFilter(String locationCount) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr", 10);
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardLocationUpdateLabel"),
				locationCount, "Task Upload Update Location Count doesn't match");
		clearButton();
	}

	public void noLocationsFilter() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationTableTr");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("ValidNoLocationText", 1);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("ValidNoLocationText"), "No locations",
				"Country filter No locations doesn't match");
		testlog.info("And User verifies AssignLocation Country Filter for no location found");
		clearButton();
	}

	public void validAssignLocationCountryFilter(String CountryName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OwnerOrgClick", 0);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", "OwnerOrg");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OwnerOrg", 0);
		CommonMethod.sendKeys("OwnerOrg", CountryName);
		testlog.info("And User select Country Name");
		if (CountryName.equalsIgnoreCase("India")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SelectCountryIndia", 0);
			CommonMethod.WaitUntilClickble("SelectCountryIndia", 10).click();
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SelectOwnerOrgDyn", 0);
			CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10).click();
		}
		Thread.sleep(1000);
		CommonMethod.scrolldowntoElement("OwnerOrg");
		applyButton();
	}

	public void validAssignLocationStatusFilter(String StatusName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAssignfilterStatus", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioScorecardAssignfilterStatus", StatusName);
		if (StatusName.equalsIgnoreCase("Not assigned")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
					"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
			CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
			testlog.info("And User checks the AssignLocation checkbox");
			CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr", 5);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioScoreCardVerificationAssignLocSavebtn, 0);
			CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
		}
		applyButton();
	}

	public void validAssignLocationSpaceTypeFilter(String SpaceType) throws IOException, InterruptedException {

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAssignfilterSpaceTypeSelect", 0);
		CommonMethod.click("PortfolioScorecardAssignfilterSpaceTypeSelect");
		CommonMethod.scrolldowntoElement("PortfolioScorecardAssignfilterSpaceTypeSelect");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAssignfilterSpaceTypeInput", 0);
		CommonMethod.sendKeys("PortfolioScorecardAssignfilterSpaceTypeInput", SpaceType);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioScorecardAssignfilterSpaceTypeSelectHighlighter", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardAssignfilterSpaceTypeSelectHighlighter");
		applyButton();
	}

	public void validAssignLocationOwnershipTypeFilter(String OwnershipType) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAssignfilterOwnershipType", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioScorecardAssignfilterOwnershipType", "Owner-occupied");
		applyButton();
	}

	public void validSubsetOwnershipTypeFilter(String SpaceType) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardSubsetAssignfilterOwnershipType",
				0);
		CommonMethod.click("PortfolioScorecardSubsetAssignfilterOwnershipType");
		CommonMethod.scrolldowntoElement("PortfolioScorecardSubsetAssignfilterOwnershipType");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioScorecardSubsetAssignfilterOwnershipTypeInput", 0);
		CommonMethod.sendKeys("PortfolioScorecardSubsetAssignfilterOwnershipTypeInput", SpaceType);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioScorecardAssignfilterSpaceTypeSelectHighlighter", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardAssignfilterSpaceTypeSelectHighlighter");
		applyButton();
	}

	public void validSubsetOccupancySizeRangeFilter(String OccupancySizeRange)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioScorecardSubsetAssignfilterOccupancySizeRange", 0);
		CommonMethod.click("PortfolioScorecardSubsetAssignfilterOccupancySizeRange");
		CommonMethod.scrolldowntoElement("PortfolioScorecardSubsetAssignfilterOccupancySizeRange");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioScorecardSubsetAssignfilterOccupancySizeRangeInput", 0);
		CommonMethod.sendKeys("PortfolioScorecardSubsetAssignfilterOccupancySizeRangeInput", OccupancySizeRange);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioScorecardAssignfilterSpaceTypeSelectHighlighter", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardAssignfilterSpaceTypeSelectHighlighter");
		applyButton();
	}

	public void validSubsetConstructionStatusFilter(String ConstructionStatus)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioScorecardSubsetAssignfilterConstructionStatus", 0);
		CommonMethod.click("PortfolioScorecardSubsetAssignfilterConstructionStatus");
		CommonMethod.scrolldowntoElement("PortfolioScorecardSubsetAssignfilterConstructionStatus");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioScorecardSubsetAssignfilterConstructionStatusInput", 0);
		CommonMethod.sendKeys("PortfolioScorecardSubsetAssignfilterConstructionStatusInput", ConstructionStatus);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
				"PortfolioScorecardAssignfilterSpaceTypeSelectHighlighter", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardAssignfilterSpaceTypeSelectHighlighter");
		applyButton();
	}

	public void validAssignLocationSubsetTypeFilter(String Subset) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAssignfilterSubsetsOption", 0);
		CommonMethod.selectdropdownVisibletextwithoutdelay("PortfolioScorecardAssignfilterSubsetsOption", Subset);
		applyButton();
	}

	public void validAssignLocationConstructionStatusFilter(String ConstructionStatus)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAssignfilterConstructionOption", 0);
		CommonMethod.selectdropdownVisibletext("PortfolioScorecardAssignfilterConstructionOption", ConstructionStatus);
		applyButton();
	}

	public void applyButton() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Applybutton", 0);
		CommonMethod.RobustclickElementVisible("Applybutton", "PortfolioScoreCardVerificationAssignChildLocCbx");
	}

	public void clearButton() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignFilterClear", 0);
		CommonMethod.RobustclickElementVisible("AssignFilterClear", "AssignFilterLocCloseIcon");
	}

	public void featureCount(String expectedResult) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectScorecardPartCount",
				Integer.parseInt(expectedResult));
		int YesFeature = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
		String actualYesFeatureCount = Integer.toString(YesFeature);
		testlog.info("Response Feature Count: " + actualYesFeatureCount);
		CommonMethod.negativesoftassertFieldValid(actualYesFeatureCount, expectedResult,
				"Response Option Scorecard filter doesn't match");
	}

	public void validateScorecardFilterResponse() throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("HsrScorecardResponseFilter", 120);
		CommonMethod.RobustclickElementVisible("HsrScorecardResponseFilter", "HsrScorecardYesPurseResponseFilterCbx");
		CommonMethod.WaitUntilPresence("HsrScorecardYesPurseResponseFilterCbx", 120);
		CommonMethod.clickListWebelementFromIndex("HsrScorecardYesPurseResponseFilterCbx", 0);
		featureCount("4");
		testlog.info("Then User verifies Feature Part Count");
	}

	public void validateScorecardFilterVerification() throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("HsrScorecardVerificationFilter", 120);
		CommonMethod.RobustclickElementVisible("HsrScorecardVerificationFilter",
				"HsrScorecardFilterSelectbyVerification");
		CommonMethod.WaitUntilPresence("PortfolioV2PilotAnnotatedFilter", 120);
		CommonMethod.selectdropdownVisibletext("PortfolioV2PilotAnnotatedFilter", "On-site Photographs");
		featureCount("4");
		clearFilterInScorecard();
		CommonMethod.WaitUntilPresence("PortfolioV2PilotLocFilter", 120);
		CommonMethod.selectdropdownVisibletext("PortfolioV2PilotLocFilter", "On-site Photographs");
		featureCount("4");
		clearFilterInScorecard();
		CommonMethod.WaitUntilPresence("PortfolioV2PilotOnsiteFilter", 120);
		CommonMethod.selectdropdownVisibletext("PortfolioV2PilotOnsiteFilter", "On-site Photographs");
		featureCount("4");
		clearFilterInScorecard();
		testlog.info("Then User verifies Feature Part Count");
	}

	public void clearFilterInScorecard() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioV2PilotClearAllFilter", 0);
		CommonMethod.JavascriptClickElement("PortfolioV2PilotClearAllFilter");
	}

	public void UploadScorecardDocumentInTaskList() throws IOException, InterruptedException {
		testlog.info("Given User is on Document Library page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTaskTab", 0);
		CommonMethod.RobustclickElementVisible("WPRTaskTab", "PortfolioTaskListPendingTab");
		testlog.info("When User clicks on TaskList Tab");
		CommonMethod.scrolldowntoElement("WPRTaskTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTaskListPendingTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListPendingTab", "WPRTaskFeatureCount");
		testlog.info("And User clicks on PendingTab");
		CommonMethod.scrolldowntoElement("PortfolioTaskListPendingTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("WPRTaskFeatureCount", 4);
		CommonMethod.negativesoftassertFieldValidEquals(
				Integer.toString(CommonMethod.ElementSize("WPRTaskFeatureCount")), "4",
				"Task Feature Count in Document list doesn't match");
	}

	public void DocListTaskLocationCountInPendingTab() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardTaskPurseLocationA06.1", 1);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardTaskPurseLocationA06.1"),
				"0/10 Locations", "Task Pending Location Count doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardTaskPurseLocationoptA06.1", 1);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardTaskPurseLocationoptA06.1"),
				"0/19 Locations", "Task Pending Location Count doesn't match");
	}

	public void DocListTaskLocationCountInFullFilledTab() throws IOException, InterruptedException {
		// DocListTask FullFilledTab
		CommonMethod.refreshBrowser();
		testlog.info("Given User is on Document Library page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTaskTab", 0);
		CommonMethod.RobustclickElementVisible("WPRTaskTab", "PortfolioTaskListPendingTab");
		testlog.info("When User clicks on TaskList Tab");
		CommonMethod.scrolldowntoElement("WPRTaskTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab",
				"PortfolioDocumentVerifyCompleteTask");
		testlog.info("And User clicks on FullFilledTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardTaskPurseLocationA02.2", 1);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardTaskPurseLocationA02.2"),
				"15/15 Locations", "Task FullFilled Location Count doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("GreenRoundcicle", 1);
		CommonMethod.negativesoftassertFieldValidEquals(Integer.toString(CommonMethod.ElementSize("GreenRoundcicle")),
				"1", "Task Feature Green Round cicle Count in Document list doesn't match");
	}

	public void documentOptionFilter() throws IOException, InterruptedException {
		portfolio.clickDocument();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTaskTab", 0);
		CommonMethod.RobustclickElementVisible("WPRTaskTab", "PortfolioTaskListPendingTab");
		testlog.info("When User clicks on TaskList Tab");
		CommonMethod.scrolldowntoElement("WPRTaskTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab",
				"PortfolioDocumentVerifyCompleteTask");
		DocumentOptionFilter();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentFilterOption", 2);
		pfu.DocumentOptionFilter("Verification");
		// pfu.DocumentOptionFilter("Part Type");
		// pfu.DocumentOptionFilter("Concepts");
	}

	public void DocumentOptionFilter(String OptionCheckboxName) throws IOException, InterruptedException {
		testlog.info("Given User on Scorecard page");

		List<WebElement> optionName = null;
		Map<String, String> OptionNameList = new LinkedHashMap<>();

		if (OptionCheckboxName.equalsIgnoreCase("Verification")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardVerificationFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
					"PortfolioFliterDocVerificationOptionCheckbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException(
					"PortfolioFliterDocVerificationOptionCheckbox",
					Integer.parseInt(PortfolioDocumentVerificationFilter));
			optionName = CommonMethod.findElements("PortfolioFliterDocVerificationOptionCheckbox");
			OptionNameList.put("OnsitePhotographs", "29");
			OptionNameList.put("TechnicalDocumentAudited", "58");
			OptionNameList.put("PolicyandorOperationsSchedule", "76");
			OptionNameList.put("LetterofAssuranceOwner", "16");
			OptionNameList.put("LetterofAssuranceDesigner", "8");
			OptionNameList.put("LetterofAssuranceEngineer", "11");
			OptionNameList.put("LetterofAssuranceContractor", "6");
			OptionNameList.put("ProfessionalNarrative", "16");
			OptionNameList.put("OngoingReport", "11");
			OptionNameList.put("OngoingMaintenanceReport", "NA");
			OptionNameList.put("OngoingDataReport", "3");
			OptionNameList.put("InnovationProposal", "NA");
			OptionNameList.put("BetaFeatureFeedbackForm", "31");
			OptionNameList.put("InnovationForm", "10");
			OptionNameList.put("WELLStrategy", "1");
			OptionNameList.put("AlternativeStrategy", "1");
			OptionNameList.put("SensorData", "1");
			OptionNameList.put("TechnicalDocumentShareable", "8");
			OptionNameList.put("TechnicalDocumentIndividual", "7");
			OptionNameList.put("PerformanceTestORSensorData", "4");
		}
		if (OptionCheckboxName.equalsIgnoreCase("Part Type")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPartTypeFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardPartTypeFilter",
					"PortfolioFliterDocVerificationOptionCheckbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioFliterDocTypeOptionCheckbox",
					Integer.parseInt(PortfolioDocumentPartTypeFilter));
			optionName = CommonMethod.findElements("PortfolioFliterDocTypeOptionCheckbox");
			OptionNameList.put("Preconditions", "62");
			OptionNameList.put("Optimization", "234");
		}
		if (OptionCheckboxName.equalsIgnoreCase("Concepts")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPartTypeFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardPartTypeFilter",
					"PortfolioFliterDocVerificationOptionCheckbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardConceptsFilter", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectScorecardConceptsFilter",
					"PortfolioFliterDocVerificationOptionCheckbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioFliterDocConceptsOptionCheckbox",
					Integer.parseInt(PortfolioDocumentConceptFilter));
			optionName = CommonMethod.findElements("PortfolioFliterDocConceptsOptionCheckbox");
			OptionNameList.put("Air", "34");
			OptionNameList.put("Water", "21");
			OptionNameList.put("Nourishment", "26");
			OptionNameList.put("Light", "14");
			OptionNameList.put("Movement", "31");
			OptionNameList.put("ThermalComfort", "25");
			OptionNameList.put("Sound", "18");
			OptionNameList.put("Materials", "31");
			OptionNameList.put("Mind", "21");
			OptionNameList.put("Community", "53");
			OptionNameList.put("Innovation", "22");
		}
		int i = 1;
		int j = 1;
		// checkboxes for loop
		for (WebElement ele1 : optionName) {
			CommonMethod.ClickCheckbox(ele1);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioFliterOptionApply", 0);
			CommonMethod.RobustclickElementVisible("PortfolioFliterOptionApply",
					"PortfolioFliterVerificationAuditTask");
			// Expected List count for loop
			for (Map.Entry<String, String> entry : OptionNameList.entrySet()) {
				System.out.println("I:" + i + ", J:" + j);
				System.out.println("Name: " + entry.getValue());
				System.out.println("Name: " + entry.getKey());
				if (i == j) {
					if (entry.getValue().equalsIgnoreCase("NA")) {
						CommonMethod.WaitUntilNumberOfElementToBePresentWithException(
								"PortfolioDocListFilterNoTaskShow", 1);
						CommonMethod.negativesoftassertFieldValid(
								CommonMethod.getText("PortfolioDocListFilterNoTaskShow"), "No Tasks to Show",
								"No Task to show Count doesn't match");
					} else {
						CommonMethod.WaitUntilNumberOfElementToBePresentWithException("WPRTaskFeatureCount",
								Integer.parseInt(entry.getValue()));
						CommonMethod.negativesoftassertFieldValidEquals(
								Integer.toString(CommonMethod.ElementSize("WPRTaskFeatureCount")), entry.getValue(),
								entry.getKey() + ": Task Feature Count in Document list doesn't match");
					}
				}
				j++;
			}
			j = 1;
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioFliterButton", 0);
			DocumentOptionFilter();
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioFliterOptionClear", 0);
			CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear", "PortfolioFliterButton");
			DocumentOptionFilter();
			i = i + 1;
		}
	}

	public void DocumentOptionFilter() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioFliterButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioFliterButton", "PortfolioDocumentFilterOption");
	}

	public void validateUploadButtonEnable(String FeatureName, String UploadButtonxpath) throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
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
				CommonMethod.RobustclickElementVisible("WPRVerficationTab", UploadButtonxpath);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Uploadbutton", 0);
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException(UploadButtonxpath, 1);
				CommonMethod.assertisElementPresentTrue(UploadButtonxpath, "Element is not present");
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("Then upload button is enabled test case has been passed");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void ValidateScorecardConfirmationModalAfterUploadingMultipleDocs(String FeatureName, String SheetName,
			int rowNum, String Commodity) throws Exception {

		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
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
				CommonMethod.click("WPRVerficationTab");
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoSelectForMAP", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardPurseYesToNoSelectForMAP");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoCancel", 0);
		testlog.info("And User verifies confirm button");
		testlog.info("And User verifies cancel button");
		// cancel
		CommonMethod.JavascriptClickElement("PortfolioScorecardPurseYesToNoCancel");
		// Confirm
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoSelectForMAP", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardPurseYesToNoSelectForMAP");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.JavascriptClickElement("PortfolioScorecardPurseYesToNoConfirm");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"), "Pursue status changed!",
				"Purse Status message Doesn't match");
		testlog.info("And User verifies the Pursue status message");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
		CommonMethod.assertisElementPresentTrue("PortfolioScoreCardAddOptionbutton",
				"Add options button is not visible");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScoreCardMAPAttachmentIcon", 1);
		CommonMethod.assertisElementPresentFalse("PortfolioScoreCardMAPAttachmentIcon",
				"Measure Air Parameters Feature Attachment Icon is visible");
	}

	public void validatePartIdInDocumentsLibrary() throws IOException, InterruptedException {

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioDocumentsLibraryAllTabInTasks", 0);
		CommonMethod.scrolldowntoElement("PortFolioDocumentsLibraryAllTabInTasks");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioPartIdInAllTabOfDocumentsLibrary", 0);
		String getExpectedPartId = CommonMethod
				.getattributeValueByTextContent("PortFolioPartIdInAllTabOfDocumentsLibrary");
		CommonMethod.negativesoftassertFieldValid(getExpectedPartId, "A01.5", "Part Id A01.5 does not matched");
	}

	public void ValidatePursuingLabel(String SheetName, int rowNum, String ProjectTypeVerification, String ProjectType,
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
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"UploadButtonDataReport");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UploadButtonDataReport", 0);
				CommonMethod.JavascriptClickElement("UploadButtonDataReport");
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("ScorecardFeatureLoader");
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr", 10);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentPaginationsecond", 0);
				CommonMethod.RobustclickElementVisible("WPRDocumentPaginationsecond", "PortfolioEditLocUncheck");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardSearchLocationTextbox", 0);
				CommonMethod.JavascriptClickElement("PortfolioScorecardSearchLocationTextbox");
				CommonMethod.clearAndSendKey("PortfolioScorecardSearchLocationTextbox", "TEST W@S Location 11");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardSearchLocationTextbox", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr", 1);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationEleven", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationEleven");
				rc.ScorecardConfirmLocUploadSaveButton();
				CommonMethod.JavascriptClickElement(ele);
				Thread.sleep(3000);
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardFeatureVerificationTab", 1);
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRVerficationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardVerificationSearchPurseLink");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationSearchPurseLink", 0);
				String actualPursuingLabel = CommonMethod
						.getattributeValueByTextContent("PortfolioScoreCardVerificationSearchPurseLink");
				actualPursuingLabel = actualPursuingLabel.replaceAll("\\s+", " ").trim();
				CommonMethod.negativesoftassertFieldValid(actualPursuingLabel, "1 Pursuing",
						"1 Pursuing Label does not matched");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void storeLocationId(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.RobustclickElementVisible("LocationTab", "AddButton");
		testlog.info("When User clicks on LocationTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Subsettab", 0);
		CommonMethod.scrolldowntoElement("Subsettab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 4);
		String locationId;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationStoreId", 0);
		locationId = CommonMethod.getText("PortfolioLocationStoreId");
		System.out.println("locationId: " + locationId);
		data.setCellData(SheetName, "LocationProjectID", rowNum, locationId);
	}

	public void assignedTaskNavigate(String SheetName, int rowNum, String Commodity, String FileName,
			Boolean AssignedTask, String TabXpath) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignedTasksTab", 0);
		CommonMethod.RobustclickElementVisible("AssignedTasksTab", "WELLV2Tab");
		if (AssignedTask) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WELLV2Tab", 0);
			CommonMethod.RobustclickElementVisible("WELLV2Tab", "PortfolioTaskListPendingTab");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectHsrOptnhsrDocumentLibrary", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectHsrOptnhsrDocumentLibrary", "PortfolioTaskListPendingTab");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTaskListPendingTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListPendingTab", TabXpath);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(TabXpath, 0);
		CommonMethod.RobustclickElementVisible(TabXpath, "PortfolioScoreVerifyUploadVerificationMethod");
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("ScorecardFeatureLoader");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUpload", 0);
		CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FileName, "UploadFileVerifyScorecard");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadSubmitbutton", 0);
		CommonMethod.Robustclick("PortfolioDocumentUploadSubmitbutton");
		if (AssignedTask) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WELLV2Tab", 0);
			CommonMethod.RobustclickElementVisible("WELLV2Tab", "PortfolioTaskListPendingTab");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectHsrOptnhsrDocumentLibrary", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectHsrOptnhsrDocumentLibrary", "PortfolioTaskListPendingTab");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTaskListPendingTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListPendingTab", "PortfolioNoAssignmentText");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioNoAssignmentText", 0);
		String getExpectedPartId = CommonMethod.getattributeValueByTextContent("PortfolioNoAssignmentText");
		CommonMethod.negativesoftassertFieldValid(getExpectedPartId, "No assignments in WELL at scale scorecard",
				"No assignments in Location Account not matched");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab", TabXpath);
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException(TabXpath, 1);
		CommonMethod.assertisElementPresentTrue(TabXpath, "Uploaded document is not visible");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTaskListAllTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListAllTab", TabXpath);
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException(TabXpath, 1);
		CommonMethod.assertisElementPresentTrue(TabXpath, "No assignments in Location Account not matched");
	}

	public void HsrOptnUploadDocument(String FeatureName) throws Exception {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HealthSafetyTab", 0);
		CommonMethod.RobustclickElementVisible("HealthSafetyTab", "PortfolioHSRconfirmenrollbuttton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHSRconfirmenrollbuttton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioHSRconfirmenrollbuttton",
				"PortfolioHSRScorecardTabcustomizescorecardheading");
		testlog.info("Given User is on Scorecard page");
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
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
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOptionbtn", 0);
				CommonMethod.RobustclickElementVisible("WPRAddOptionbtn", "ScorecardAddedOption");
				testlog.info("And User clicks on save button");
				CommonMethod.Robustclick("WPRAddOptionCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRAddOptionCloseIcon", 1);
				CommonMethod.RobustclickElementVisible("WPRAssignLocbtn",
						"PortfolioScoreCardVerificationAssignChildLocCbx");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocationTableTr", 0);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignChildLocCbx", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentPaginationsecond", 0);
				CommonMethod.Robustclick("WPRDocumentPaginationsecond");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditLocUncheck", 0);
				CommonMethod.ClickCheckbox("PortfolioEditLocUncheck");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioScoreCardVerificationAssignLocSavebtn,
						0);
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + FeatureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void clickFilterPortfolio() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScoreCardFilterButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScoreCardFilterButton", "V2ProjectScorecardApplybutton");
	}

	public void verificationFilterPortfolio() throws IOException, InterruptedException {
		clickFilterPortfolio();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardVerificationFilter", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
				"V2ProjectScorecardPerformanceSensorFilter");
		testlog.info("And User select on Verification Filter");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPerformanceSensorFilter", 0);
		CommonMethod.ClickCheckbox("V2ProjectScorecardPerformanceSensorFilter");
		testlog.info("And User check Performance Sensor checkbox");
		assignedTaskApplyButton();
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("WPRTaskFeatureCount", 1);
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(CommonMethod.ElementSize("WPRTaskFeatureCount")),
				"1", "Task Size in Document list doesn't match");
		clickFilterPortfolio();
		assignedTaskClearedFilter();
	}

	public void partTypeFilterPortfolio() throws IOException, InterruptedException {
		clickFilterPortfolio();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPartTypeFilter", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardPartTypeFilter",
				"V2ProjectScorecardPreconditionsFilter");
		testlog.info("And User select Part type Filter option");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPreconditionsFilter", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardPreconditionsFilter",
				"V2ProjectScorecardApplybutton");
		testlog.info("And User check on Preconditions Filter checkbox");
		assignedTaskApplyButton();
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("WPRTaskFeatureCount", 1);
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(CommonMethod.ElementSize("WPRTaskFeatureCount")),
				"1", "Task Size in Document list doesn't match");
		clickFilterPortfolio();
		assignedTaskClearedFilter();
	}

	public void conceptFilterPortfolio() throws IOException, InterruptedException {
		clickFilterPortfolio();
		testlog.info("And User select on concept Filter");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardConceptsFilter", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardConceptsFilter", "V2ProjectScorecardAirFilter");
		testlog.info("And User check Air checkbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardAirFilter", 0);
		CommonMethod.ClickCheckbox("V2ProjectScorecardAirFilter");
		assignedTaskApplyButton();
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("WPRTaskFeatureCount", 1);
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(CommonMethod.ElementSize("WPRTaskFeatureCount")),
				"1", "Task Size in Document list doesn't match");
		clickFilterPortfolio();
		assignedTaskClearedFilter();
	}

	public void assignedTaskFilterNavigate() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WELLV2Tab", 0);
		CommonMethod.RobustclickElementVisible("WELLV2Tab", "PortfolioTaskListPendingTab");

	}

	public void assignedTaskApplyButton() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ApplyButton", 0);
		CommonMethod.Robustclick("ApplyButton", "FilterPopUpValid");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("FilterPopUpValid", 1);
	}

	public void assignedTaskClearedFilter() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioFliterOptionClear", 0);
		CommonMethod.Robustclick("PortfolioFliterOptionClear", "FilterPopUpValid");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("FilterPopUpValid", 1);
	}

	public void assignedTaskV2Filter() throws Exception {
		assignedTaskFilterNavigate();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab", "WPRTaskFeatureCount");
		verificationFilterPortfolio();
		// partTypeFilterPortfolio();
		// conceptFilterPortfolio();
	}

	public void assignedTaskHsrFilter() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectHsrOptnhsrDocumentLibrary", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectHsrOptnhsrDocumentLibrary", "PortfolioTaskListPendingTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab", "WPRTaskFeatureCount");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardVerificationFilter", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectScorecardVerificationFilter",
				"V2ProjectScorecardPolicyVerificationFilter");
		testlog.info("And User select on Verification Filter");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPolicyVerificationFilter", 0);
		CommonMethod.ClickCheckbox("V2ProjectScorecardPolicyVerificationFilter");
		testlog.info("And User check Performance Sensor checkbox");
		assignedTaskApplyButton();
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("WPRTaskFeatureCount", 1);
		CommonMethod.negativesoftassertFieldValidEquals(String.valueOf(CommonMethod.ElementSize("WPRTaskFeatureCount")),
				"1", "Task Size in Document list doesn't match");
		clickFilterPortfolio();
		assignedTaskClearedFilter();

	}

	public void uploadedAssignedTaskDocumentInPortfolio() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTaskListTab", 0);
		testlog.info("Then User will be redirected to DocumentList page");
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab", "PortfolioDocListA1.1");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioDocListA1.1", 1);
		CommonMethod.assertisElementPresentTrue("PortfolioDocListA1.1", "V2 Assigned Uploaded document is not visible");

	}

	public void uploadedHsrAssignedTaskDocumentInPortfolio() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTaskListTab", 0);
		testlog.info("Then User will be redirected to DocumentList page");
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListTaskFullFilledTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab", "PortfolioDocListA1.1");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioHsrOptnSC1UploadButtonFeature", 1);
		CommonMethod.assertisElementPresentTrue("PortfolioHsrOptnSC1UploadButtonFeature",
				"Hsr Assigned Uploaded document is not visible");

	}

	public void purseYesToMaybeValidFromScorecard() throws Exception {

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToMaybeSelectForMTPM", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToMaybeSelectForMTPM");
		testlog.info("And User click on Purse Maybe");

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoCancel", 0);
		testlog.info("And User verifies confirm button");
		testlog.info("And User verifies cancel button");
		// cancel
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoCancel");
		// Confirm
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToMaybeSelectForMTPM", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToMaybeSelectForMTPM");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoConfirm");

		CommonMethod.WaitUntilNumberOfElementToBePresentWithException(
				"PortfolioScorecardPurseYesToMaybeSelectedForMTPM", 1);
		CommonMethod.assertisElementPresentTrue("PortfolioScorecardPurseYesToMaybeSelectedForMTPM",
				"PurseMaybe is not selected");
		testlog.info("And User verifies the Selected Purse Maybe");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"), "Pursue status changed!",
				"Purse Status message Doesn't match");
		testlog.info("Then User verifies the Pursue status message");
		testlog.pass("**Verifies the Pursue Maybe status successful**");
	}

	public void UploadScorecardDocumentForOneLocationAndOneOption(String featureName, String SheetName, int rowNum,
			String ProjectType, String Commodity, String FileName, boolean PartNameRequired,
			boolean VerificationMethodValidationRequired, boolean NoteRequired, boolean IntentCheckboxRequired)
			throws Exception {

		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWERPartFeature", 0);
		Feature = CommonMethod.findElements("V2ProjectWERPartFeature");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/** ScoreCard Add option */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 120);
				CommonMethod.Robustclick("WPRAssignLocbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationOne", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationOne");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignSavebtn", 0);
				CommonMethod.Robustclick("WPRAssignSavebtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				testlog.info("And User clicks on Upload Button");
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, SampleJpgfile, false, false, false,
						false);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardLocationUpdateLabel", 0);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationOne", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationOne");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSaveAndExitBtn", 0);
				CommonMethod.Robustclick("PortfolioSaveAndExitBtn");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void UploadScorecardDocumentForOneOptionAndMultipleLocations(String featureName, String SheetName,
			int rowNum, String ProjectType, String Commodity, String FileName, boolean PartNameRequired,
			boolean VerificationMethodValidationRequired, boolean NoteRequired, boolean IntentCheckboxRequired)
			throws Exception {

		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWERPartFeature", 0);
		Feature = CommonMethod.findElements("V2ProjectWERPartFeature");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/** ScoreCard Add option */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 120);
				CommonMethod.Robustclick("WPRAssignLocbtn");
				generic.assignLocationGeneric(Commodity, true, false, false, false, false);
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				testlog.info("And User clicks on Upload Button");
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, SampleJpgfile, false, false, false,
						false);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardLocationUpdateLabel", 0);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationOne", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationOne");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationTwo", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationTwo");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSaveAndExitBtn", 0);
				CommonMethod.Robustclick("PortfolioSaveAndExitBtn");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void UploadScorecardDocumentForMultipleOptionsAndOneLocation(String featureName, String SheetName,
			int rowNum, String ProjectType, String Commodity, String FileName, boolean PartNameRequired,
			boolean VerificationMethodValidationRequired, boolean NoteRequired, boolean IntentCheckboxRequired)
			throws Exception {

		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWERPartFeature", 0);
		Feature = CommonMethod.findElements("V2ProjectWERPartFeature");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/** ScoreCard Add option */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 120);
				CommonMethod.Robustclick("WPRAssignLocbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationOne", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationOne");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignSavebtn", 0);
				CommonMethod.Robustclick("WPRAssignSavebtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				testlog.info("And User clicks on Upload Button");
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, SampleJpgfile, false, false, false,
						false);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardLocationUpdateLabel", 0);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationOne", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationOne");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSaveAndExitBtn", 0);
				CommonMethod.Robustclick("PortfolioSaveAndExitBtn");

				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableTr", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
				CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioAndRatingLocAccDocumentTableEditIcon", 0);
				CommonMethod.JavascriptClickElement("PortfolioAndRatingLocAccDocumentTableEditIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationUploadAddfeature", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationSelectFeature");
				testlog.info("And User clicks on Add feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardPartDropdown", 0);
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardPartDropdown", "A06.1");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardSelectSpaceTypeFromDropdown", 0);
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardSelectSpaceTypeFromDropdown", "All Spaces");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardSelectOptionFromDropdown",
						0);
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardSelectOptionFromDropdown",
						"Option 2 Demand control ventilation");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPart", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
						"PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndExitbtnUploadPage", 0);
				CommonMethod.Robustclick("SaveAndExitbtnUploadPage");
				CommonMethod.scrolldowntoElement("PortfolioHsrOptnUploadButtonOptionOne");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void UploadScorecardDocumentForMultipleOptionsAndMultipleLocations(String featureName, String SheetName,
			int rowNum, String ProjectType, String Commodity, String FileName, boolean PartNameRequired,
			boolean VerificationMethodValidationRequired, boolean NoteRequired, boolean IntentCheckboxRequired)
			throws Exception {

		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWERPartFeature", 0);
		Feature = CommonMethod.findElements("V2ProjectWERPartFeature");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/** ScoreCard Add option */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 120);
				CommonMethod.Robustclick("WPRAssignLocbtn");
				generic.assignLocationGeneric(Commodity, true, false, false, false, false);
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				testlog.info("And User clicks on Upload Button");
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, SampleJpgfile, false, false, false,
						false);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardLocationUpdateLabel", 0);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationOne", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationOne");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationTwo", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationTwo");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSaveAndExitBtn", 0);
				CommonMethod.Robustclick("PortfolioSaveAndExitBtn");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableTr", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
				CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioAndRatingLocAccDocumentTableEditIcon", 0);
				CommonMethod.JavascriptClickElement("PortfolioAndRatingLocAccDocumentTableEditIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationUploadAddfeature", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationSelectFeature");
				testlog.info("And User clicks on Add feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardPartDropdown", 0);
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardPartDropdown", "L01.1");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardSelectSpaceTypeFromDropdown", 0);
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardSelectSpaceTypeFromDropdown", "All Spaces");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardSelectOptionFromDropdown",
						0);
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardSelectOptionFromDropdown",
						"Option 4 Circadian lighting design");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPart", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
						"PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndExitbtnUploadPage", 0);
				CommonMethod.Robustclick("SaveAndExitbtnUploadPage");
				CommonMethod.scrolldowntoElement("PortfolioHsrOptnUploadButtonOptionOne");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void scorecardBeforeReviewReviewHistoryView(String SheetName, int rowNum, String Commodity,
			String FeatureName) throws Exception {

		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
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
				CommonMethod.RobustclickElementVisible("WPRVerficationTab", "PortfolioScoreCardAddOptionbutton");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/** ScoreCard Add option */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocbtn", 0);
				generic.assignLocationGeneric(Commodity, false, true, false, false, false);
				Thread.sleep(2000);
				/** Upload Document for Tasks */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationUploadAddfeature", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
				testlog.info("And User clicks on Upload Button");
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FeaturefileUpload, false, false,
						false, false);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx",
						0);
				rc.ScorecardConfirmLocUploadSaveButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
				rc.documentTableEditButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardUploadEditDocumentLink", 0);
				testlog.info("And User verifies Document link");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationUploadAddfeature", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationSelectFeature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationSelectFeature",
						0);
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A01.4");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationSelectSpaceType", 0);
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationSelectOption",
						0);
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPart", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
						"PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadRemovelinkA01.4", 0);
				rc.ScorecardUploadUpdateSaveButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1);
				rc.ScorecardConfirmLocUploadSaveButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				rc.documentTableEditButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadRemovelinkA01.4", 0);
				CommonMethod.Robustclick("PortfolioScorecardUploadRemovelinkA01.4");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardUploadRemovelinkA01.4", 1);
				rc.SaveAndExitbtnUploadPage();
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("Then upload button is enabled test case has been passed");
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void scorecardPostReviewHistoryView(String FeatureName) throws Exception {

		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
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
				CommonMethod.RobustclickElementVisible("WPRVerficationTab", "PortfolioDocumentUploadbutton");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
				rc.documentTableEditButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationUploadAddfeature", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationSelectFeature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationSelectFeature",
						0);
				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A01.4");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationSelectSpaceType", 0);
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationSelectOption",
						0);
				CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPart", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
						"PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadRemovelinkA01.4", 0);
				rc.ScorecardUploadUpdateSaveButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.ClickCheckbox("WPRAssignLocFirstChildCbx");
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
				rc.ScorecardConfirmLocUploadSaveButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				rc.documentTableEditButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadRemovelinkA01.4", 0);
				CommonMethod.Robustclick("PortfolioScorecardUploadRemovelinkA01.4");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardUploadRemovelinkA01.4", 1);
				rc.SaveAndExitbtnUploadPage();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}
	
	public void scorecardPostReviewHistoryAsAdmin(String FeatureName) throws Exception {

		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
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
				CommonMethod.RobustclickElementVisible("WPRVerficationTab", "PortfolioDocumentUploadbutton");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
				rc.documentTableEditButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardUploadEditDocumentLink", 0);
				testlog.info("And User verifies Document link");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationUploadAddfeature", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardHistoryIcon", 0);
				CommonMethod.RobustclickElementVisible("ScorecardHistoryIcon", "ScorecardHistoryVerison");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardHistoryVerison", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ScorecardHistoryVerison").trim(),
						"Version 2: Current Version", "ScorecardHistoryVerison Mismatch");
			    CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardHistoryVerison2", 0);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ScorecardHistoryVerison2").trim(),
								"Version 1", "ScorecardHistoryVerison Mismatch");
						/** Validate Added Option */
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionAdded"), "option added",
								"Post Review Location Added Option added in History Document table data mismatch");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionAddedName"),
								"A01.4", "Post Review Location Added Option Name in History Document table data mismatch");
			    CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionAddedUser"),
										"UI Automation", "Post Review Location Added Option User in History Document table data mismatch");
				CommonMethod.negativesoftassertFieldValid(getDate("ValidHistoryLocationOptionAddedDate").trim(),CommonMethod.ValidateDate(), "Post Review Location Added Option Date in History Document table data mismatch");

			/** Validate Option Removed */
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionRemoved"), "option removed",
								"Post Review Location Option Removed in History Document table data mismatch");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionRemovedName"),
								"A01.4", "Post Review Location Option Removed Name in History Document table data mismatch");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionRemovedUser"),
										"UI Automation", "Post Review Location Option Removed User in History Document table data mismatch");
			/** Validate Location Added */
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationPostAdded"), "Location added",
								"Post Review Post Review Location Added in History Document table data mismatch");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationPostAddedName"), "TEST W@S Location 01",
								"Post Review Location Added Name in History Document table data mismatch");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationPostAddedUser"),
								"UI Automation", "Post Review Location Added User in History Document table data mismatch");
				CommonMethod.negativesoftassertFieldValid(getDate("ValidHistoryLocationPostAddedDate").trim(),CommonMethod.ValidateDate(), "Post Review Location Added Date in History Document table data mismatch");
						
			/** Validate Location Removed */
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationPostRemoved"), "Location removed",
								"Post Review Location Removed in History Document table data mismatch");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationPostRemovedName"), "TEST W@S Location 02",
								"Post Review Location Removed Name in History Document table data mismatch");
			    CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationPostRemovedUser"),
								"UI Automation", "Post Review Location Removed User in History Document table data mismatch");
				CommonMethod.negativesoftassertFieldValid(getDate("ValidHistoryLocationPostRemovedDate").trim(),CommonMethod.ValidateDate(), "Post Review Location Removed Date in History Document table data mismatch");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardHistoryCloseIcon", 0);
				CommonMethod.Robustclick("ScorecardHistoryCloseIcon");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
	         	CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void ValidateScorecardUnassignLocationFromOptionWithReviewedDocs(String featureName, String SheetName,
			int rowNum, String ProjectType, String Commodity, String FileName, boolean PartNameRequired,
			boolean VerificationMethodValidationRequired, boolean NoteRequired, boolean IntentCheckboxRequired)
			throws Exception {

		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWERPartFeature", 0);
		Feature = CommonMethod.findElements("V2ProjectWERPartFeature");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.Robustclick("PortfolioScorecardFeatureVerificationTab");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.scrolldowntoElement("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 120);
				CommonMethod.Robustclick("PortfolioScorecardEditLocation");
				// cancel
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationOne", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationOne");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUnassignLocationCancelBtn", 0);
				CommonMethod.Robustclick("PortfolioUnassignLocationCancelBtn");
				testlog.info("And User verifies cancel button");
				// Confirm
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckedLocationOne", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckedLocationOne");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUnassignLocationContinueBtn", 0);
				CommonMethod.Robustclick("PortfolioUnassignLocationContinueBtn");
				testlog.info("And User verifies continue button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveChangesButton", 0);
				CommonMethod.Robustclick("SaveChangesButton");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 120);
				CommonMethod.Robustclick("PortfolioScorecardEditLocation");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioNotAssignedLabel", 0);
				String actualNotAssignedLabelText = CommonMethod
						.getattributeValueByTextContent("PortfolioNotAssignedLabel");
				actualNotAssignedLabelText = actualNotAssignedLabelText.replaceAll("\\s+", " ").trim();
				CommonMethod.negativesoftassertFieldValidEquals(actualNotAssignedLabelText, "Not Assigned",
						"Not Assigned text does not matched");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAchievedLabel", 0);
				String actualAchievedLabelText = CommonMethod.getattributeValueByTextContent("PortfolioAchievedLabel");
				actualAchievedLabelText = actualAchievedLabelText.replaceAll("\\s+", " ").trim();
				CommonMethod.negativesoftassertFieldValidEquals(actualAchievedLabelText, "9 Achieved",
						"9 Achieved text does not matched");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				pathprms.put("LocationCount", "9 Assigned");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, true, false,
						false, false, false, false);
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void ValidateAtchiveDocumentsOnUnassigningAllLocation(String featureName, String SheetName, int rowNum,
			String ProjectType, String Commodity, String FileName, boolean PartNameRequired,
			boolean VerificationMethodValidationRequired, boolean NoteRequired, boolean IntentCheckboxRequired)
			throws Exception {

		List<WebElement> Feature;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWERPartFeature", 0);
		Feature = CommonMethod.findElements("V2ProjectWERPartFeature");
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(featureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.Robustclick("PortfolioScorecardFeatureVerificationTab");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.scrolldowntoElement("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 120);
				CommonMethod.Robustclick("PortfolioScorecardEditLocation");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckAllLocations", 0);
				CommonMethod.ClickCheckbox("PortfolioCheckAllLocations");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCheckAllLocations", 0);
				Thread.sleep(2000);
				CommonMethod.ClickCheckbox("PortfolioCheckAllLocations");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUnassignLocationContinueBtn", 0);
				CommonMethod.Robustclick("PortfolioUnassignLocationContinueBtn");
				testlog.info("And User verifies continue button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveChangesButton", 0);
				CommonMethod.Robustclick("SaveChangesButton");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScorecardShowArchivedDocumentsToggle", 0);
				CommonMethod.JavascriptClickElement("PortfolioScorecardShowArchivedDocumentsToggle");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardArchivedText", 0);
				String ArchivedText = CommonMethod.getattributeValueByTextContent("PortfolioScorecardArchivedText");
				CommonMethod.negativesoftassertFieldValid("Archived", ArchivedText,
						"Archived Document Status does not matched");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
	}

	public void scorecardBeforeReviewReviewHistoryViewAsAdmin(String FeatureName) throws Exception {

		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
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
				CommonMethod.RobustclickElementVisible("WPRVerficationTab", "PortfolioScoreCardAddOptionbutton");
	rc.documentTableEditButton();
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardHistoryIcon", 0);
	CommonMethod.RobustclickElementVisible("ScorecardHistoryIcon", "ValidHistoryLocationOptionAdded");
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ValidHistoryLocationOptionAdded", 0);
	CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardHistoryVerison", 0);
	CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ScorecardHistoryVerison").trim(),
			"Version 1: Current Version", "ScorecardHistoryVerison Mismatch");
	ValidateBeforeReviewHistoryView();
	CommonMethod.JavascriptClickElement(ele);
	testlog.info("Then upload button is enabled test case has been passed");
	break;
}
}
CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + featureName + " doesn't match");
}
	
	public void ValidateBeforeReviewHistoryView() throws IOException, InterruptedException {
		/* * Validate Location Added */

		if (CommonMethod.isElementsExist("ValidHistoryLocationAdded", 20)) {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationAdded"), "Location added",
					"Location added in History Document table data mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationAddedName"),
					"TEST W@S Location 10", "Location Added Name in History Document table data mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationAddedUser").replaceAll("\\s+", " "),
							"UI Automation", "Location Added User in History Document table data mismatch");
			CommonMethod.negativesoftassertFieldValid(getDate("ValidHistoryLocationAddedDate").trim(),
					CommonMethod.ValidateDate(), "Location Added Date in History Document table data mismatch");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadTaskCompleteLocNextBtn", 0);
			CommonMethod.RobustclickElementVisible("PortfolioUploadTaskCompleteLocNextBtn",
					"ValidHistoryLocationAdded");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ValidHistoryLocationAdded", 0);
			CommonMethod.negativesoftassertFieldValid(
					CommonMethod.getattributeValueByTextContent("ValidHistoryLocationAdded"), "Location added",
					"Location added in History Document table data mismatch");
			CommonMethod.negativesoftassertFieldValid(
					CommonMethod.getattributeValueByTextContent("ValidHistoryLocationAddedName"),
					"TEST W@S Location 10", "Location Added Name in History Document table data mismatch");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationAddedUser").replaceAll("\\s+", " "),
							"UI Automation", "Location Added User in History Document table data mismatch");
			CommonMethod.negativesoftassertFieldValid(getDate("ValidHistoryLocationAddedDate").trim(),
					CommonMethod.ValidateDate(), "Location Added Date in History Document table data mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ValidHistoryLocationPreviousButton", 0);
			CommonMethod.RobustclickElementVisible("ValidHistoryLocationPreviousButton","ValidHistoryLocationRemoved");
		}
		/** Validate Location Removed */
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationRemoved"), "Location removed",
				"Location Removed in History Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationRemovedName"), "TEST W@S Location 01",
				"Location Removed Name in History Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationRemovedUser"),
				"UI Automation", "Location Removed User in History Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(getDate("ValidHistoryLocationRemovedDate").trim(),
				CommonMethod.ValidateDate(), "Location Removed Date in History Document table data mismatch");

		/** Validate Added Option */
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionAdded"), "option added",
				"Location Added Option added in History Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionAddedName"),
				"A01.4", "Location Added Option Name in History Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionAddedUser"),
						"UI Automation", "Location Added Option User in History Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(getDate("ValidHistoryLocationOptionAddedDate").trim(),CommonMethod.ValidateDate(), "Location Added Option Date in History Document table data mismatch");

		/** Validate Option Removed */
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionRemoved"), "option removed",
				"Location Option Removed in History Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionRemovedName"),
				"A01.4", "Location Option Removed Name in History Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("ValidHistoryLocationOptionRemovedUser"),
						"UI Automation", "Location Option Removed User in History Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(getDate("ValidHistoryLocationOptionRemovedDate").trim(),CommonMethod.ValidateDate(), "Location Option Removed Date in History Document table data mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardHistoryCloseIcon", 0);
		CommonMethod.Robustclick("ScorecardHistoryCloseIcon");
	}
	
	public String getDate(String xpathDate) throws IOException, InterruptedException {
		String date = CommonMethod.getattributeValueByTextContent(xpathDate);
		String[] splits = date.split("•");
		String getDate = splits[0];
		return getDate;
	}
}
