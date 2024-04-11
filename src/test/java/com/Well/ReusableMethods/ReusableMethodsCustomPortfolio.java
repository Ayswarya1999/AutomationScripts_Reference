package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsCustomPortfolio extends BaseClass {

	String PortfolioAndRatingLocAccDocumentTable = "PortfolioAndRatingLocAccDocumentTable";
	String PortfolioScoreCardVerificationAssignLocSavebtn = "PortfolioScoreCardVerificationAssignLocSavebtn";
	public void MeetThresholdsforParticulateMatter(String FeatureName, String SheetName, int rowNum, String Commodity,
			String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardA01PursueYesButton",
						"PortfolioScorecardPursueToast");
				testlog.info("And User clicks on PursueYesButton");
				pfu.purseYesValidFromScorecard();
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardWeightPHighlighted", 1);
				testlog.info("Then User verifies Purse toast message");
				testlog.info("And User verifies Weight Point");
				CommonMethod.click(ele);
				testlog.info("And User clicks on Air A01.1 feature");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on AddOption button");
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardAddButton", 0);
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardAddedOption", 0);
				CommonMethod.assertcountListWebelementFromIndex("ScorecardAddedOption", 1);
				testlog.info("User verifies Remove button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardOptionCount", 0);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 1);
				testlog.info("User verifies OptionCount");
				testlog.info("User verifies TaskCount");
				generic.assignLocationGeneric(Commodity, false, false, true, false, false);
				testlog.info("And User clicks on Assign Button");
				CommonMethod.scrollDown();
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardVerificationUploadbtn", 0);
				testlog.info("And User clicks on Upload Button");
				CommonMethod.scrolldowntoElement("PortfolioScoreVerifyUploadVerificationMethod");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadAddfeature", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				generic.uploadModalCompleteGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				testlog.info("And User verifies Document Uploaded successfully toast message");
				pathprms.put("PartId", "A01.3");
				pathprms.put("Status", "Ready For Review");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false, false,
						true, true, false);
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document for Air A01.1 Feature successful**");
	}

	public void MeetThresholdsforOrganicGases(String FeatureName, String SheetName, int rowNum, String Commodity,
			String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("And User clicks on Feature Air A01.2");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 30);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/*
				 * ScoreCard Add option
				 */
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardAddedOption", 0);
				CommonMethod.assertcountListWebelementFromIndex("ScorecardAddedOption", 2);
				testlog.info("**Verifies RemoveButton Count successful**");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("User verifies Remove button");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 2);
				testlog.info("User verifies OptionCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 2);
				testlog.info("**Verifies Task Count successful**");
				testlog.info("**Verifies Option Count successful**");
				pathprms.put("StartAssignLoc", "1");
				pathprms.put("EndAssignLoc", "4");
				generic.assignLocationGeneric(Commodity, false, false, false, true, false);
				Thread.sleep(2000);
				CommonMethod.WaitUntilPresence("PortfolioScorecardOptionPurseLocation", 60);
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "3 Pursuing",
							"PurseLocationCount doesn't match");
				}
				List<WebElement> TaskAssignLocation;
				TaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : TaskAssignLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/3 Locations",
							"Task Assign Location Count doesn't match");
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioScorecardOptionPurseLocation", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionPurseLocation", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCompletedTaskLocCount", 2);
				testlog.info("**Verifies Option Purse Location successful**");
				testlog.info("**Verifies Task Purse Location successful**");
				/*
				 * Upload Document for Tasks
				 */
				CommonMethod.scrollDown();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPerformanceTaskUpload", 0);
				CommonMethod.JavascriptClickElement("PortfolioScorecardPerformanceTaskUpload");
				generic.uploadModalCompleteGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				/*
				 * Edit Upload Document
				 */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
				rc.documentTableEditButton();
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				rc.ScorecardUploadUpdateSaveButton();
				testlog.info("And User clicks on save button");
				/*
				 * Edit location and verify count
				 */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUncheckLoc", 0);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
				rc.ScorecardConfirmLocUploadSaveButton();
				CommonMethod.scrolldowntoElement("PortfolioScorecardCompletedTaskLocCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCompletedTaskLocCount", 2);
				pathprms.put("Status", "Ready For Review");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false, false,
						true, true, false);
				softAssert.assertAll();
				testlog.info("User verifies TaskCount");
				testlog.info("And User clicks on Assign Button");
				testlog.info("And User clicks on Upload Button");
				testlog.info("And User clicks on Add feature");
				testlog.info("And User select A01.3 feature");
				testlog.info("And User select SpaceType");
				testlog.info("And User clicks on Add feature");
				testlog.info("And User clicks on Edit Location");
				testlog.info("And User checks the AssignLocation checkbox");
				testlog.info("And User verify Task Assign Location Count");
				testlog.info("And User clicks on Update Button");
				testlog.info("And User verify Updated Assign Location");
				testlog.info("And User clicks on Upload button");
				testlog.info("And User verifies Document Uploaded successfully toast message");
				testlog.info("Fetching Data from Upload Table");
				testlog.info("And User verifies Document table data");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
				break;
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document for Air A01.2 Feature successful**");
	}

	public void MeetEnhancedThresholdsforOrganicGases(String FeatureName, String SheetName, int rowNum,
			String Commodity) throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilPresence("WPRPortfolioScorecardLanding", Scorecardtimeout);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				testlog.info("When User clicks on Air A05.2 feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						PortfolioAndRatingLocAccDocumentTable);
				testlog.info("And User clicks on VerificationTab");

				/*
				 * Edit Upload Document
				 */
				CommonMethod.scrolldowntoElement("PortfolioScorecardFeatureVerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
				rc.documentTableEditButton();
				testlog.info("And User clicks on Edit icon");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
				testlog.info("And User enter data to AddNote field");
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationAddNote");
				CommonMethod.ClickCheckbox("PortfolioScorecardVerifyTaskUploadIntentStage");
				testlog.info("And User checks the IntentStage checkbox");
				rc.ScorecardUploadUpdateSaveButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignChildLocCbx", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
						"PortfolioScorecardValidDisable");
				testlog.info("And User checks the AssignLoccation checkbox");
				rc.ScorecardConfirmLocUploadSaveButton();
				testlog.info("And User verifies Document Uploaded successfully toast message");
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "5 Pursuing",
							"PurseLocationCount doesn't match");
				}
				testlog.info("And User verifies Purse Location Count");
				CommonMethod.scrolldowntoElement("PortfolioScorecardCompletedTaskLocCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCompletedTaskLocCount", 1);
				testlog.info("User verifies OptionCount");
				testlog.info("User verifies TaskCount");
				pathprms.put("Status", "Ready For Review");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false, false,
						true, false, false);
				softAssert.assertAll();
				testlog.info("And User verifies Document table data");
				testlog.info("And User verifies Completed Task Location Count");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
				break;
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Air A05.2 Feature successful**");

	}

	public void MeetThresholdsforInOrganicGases(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("When User clicks on Air A01.3 feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 120);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScorecardDocumentCompleteGreenCircleValid");
				testlog.info("And User clicks on VerificationTab");
				/*
				 * Validate Task completion and green circle
				 */
				CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentCompleteGreenCircleValid", 120);
				testlog.info("Then User verifies Task completion and green circle in Task");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentCompleteLink",
						"PortfolioScorecardDocumentCompleteCount");
				CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentCompleteCount", 120);
				testlog.info("And User verifies Completed Location count for Task Completed model");
				CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentCompleteCount",
						"PortfolioScorecardDocumentCompleteGreenCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardDocumentCompleteGreenCount", 4);
				testlog.info("And User verifies count for Task Completed green colour for location list");
				CommonMethod.WaitUntilPresence("PortfolioScorecardDocumentCompleteClose", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardDocumentCompleteClose",
						PortfolioAndRatingLocAccDocumentTable);
				CommonMethod.WaitUntilPresence(PortfolioAndRatingLocAccDocumentTable, 120);
				CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
				List<String> val = CommonMethod.fetchTableData(PortfolioAndRatingLocAccDocumentTable);
				testlog.info("Fetching Data from Upload Table");
				CommonMethod.softAssertContainsMessage(val.get(2), "A01.3", "Document table data mismatch");
				CommonMethod.softAssertContainsMessage(val.get(7), "Ready For Review", "Document table data mismatch");
				testlog.info("And User verifies Document table data");
				softAssert.assertAll();
				testlog.info("And User verifies Review Status in Tablelist");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);

			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Air A01.3 Feature successful**");
	}

	public void MitigateConstructionPollution(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				testlog.info("When User clicks on Air A04.1 feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on AddOption button");
				testlog.info("And User clicks on Add button");
				testlog.info("Then User verifies Remove button");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardOptionCount", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 2);
				softAssert.assertAll();
				testlog.info("And User verifies OptionCount");
				testlog.info("And User verifies TaskCount");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
				break;
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Air A04.1 Feature successful**");
	}

	public void ManageWindowUse(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("When User clicks on Air A07.2 feature");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on AddOption button");
				testlog.info("And User clicks on Add button");
				testlog.info("And User verifies Remove button");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardOptionCount", 2);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 3);
				testlog.info("And User verifies OptionCount");
				testlog.info("And User verifies TaskCount");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskUploadDisableCount", 3);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 1);
				testlog.info("And User verifies Task Upload button Count");
				testlog.info("And User verifies Assign button Count");
				String VerifyAndText = CommonMethod.getText("PortfolioScorecardVerifyAndOption");
				testlog.info("And Condition: " + VerifyAndText);
				CommonMethod.assertActualContainsExpected(VerifyAndText, "AND");
				testlog.info("And User verifies And in Option");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardManageWeightHightlighting", 1);
				softAssert.assertAll();
				testlog.info("And User verifies Enable Weight highlightling count");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Air A07.2 Feature successful**");
	}

	public void InstallIndoorAirMonitors(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				/*
				 * Response selection Yes for optimization
				 */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardA08PurseStatus", 0);
				CommonMethod.Robustclick("PortfolioScorecardA08PurseStatus");
				testlog.info("When User clicks on PursueYesButton");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardPursueToast", 1);
				testlog.info("Then User verifies Purse toast message");
				testlog.info("And User verifies Weight Point");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on Air A08.1 feature");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				/*
				 * Test by adding the core point
				 */
				CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 0, 1);
				testlog.info("And User checks the CorePoint checkbox");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				testlog.info("User verifies Remove button");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCorePointCheckbox", 2);
				testlog.info("And User verifies CorePoint Checkbox Count");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 1);
				testlog.info("And User verifies Assign Button");
				CommonMethod.WaitUntilPresence("PortfolioScorecardWeightHighlightA08", 30);
				CommonMethod.scrolldowntoElement("PortfolioScorecardWeightHighlightA08");
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlightA08"),
						"2", "Weight Point for doesn't match");
				softAssert.assertAll();
				testlog.info("And verifies Weight Point Count");
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Air A08.1 Feature successful**");
	}

	public void EnhanceOccupantControllability(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				/*
				 * Response selection Yes for optimization
				 */
				CommonMethod.RobustclickElementVisible("PortfolioScorecardL09PurseStatus",
						"PortfolioScorecardPursueToast");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardPursueToast", 120);
				CommonMethod.WaitUntilInVisibility("PortfolioScorecardPursueToast", 60);
				testlog.info("When User clicks on PursueYesButton");
				testlog.info("Then User verifies Purse toast message");
				testlog.info("And User verifies Weight Point");
				CommonMethod.click(ele);
				testlog.info("And User clicks on L09.1 feature");
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				/*
				 * Test by adding Light L09.1 feature option 1 And option 2
				 */
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddButton", 120);
				testlog.info("And User clicks on AddOption button");
				testlog.info("And User clicks on Add button");
				testlog.info("And User verifies Remove button");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardCorePointCheckbox", 2);
				testlog.info("And User verifies CorePoint Checkbox Count");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardVerifyTierDropdownValue", 2);
				testlog.info("And User verifies Tier Dropdown Count");
				CommonMethod.softAssertContainsMessage(
						CommonMethod.getSelectedDropdownValue("PortfolioScorecardTierDropdownValue"), "Tier 1",
						"TierDropdown Defualt value doesn't match");
				testlog.info("And User verifies Tier Dropdown Defualt value");
				CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 0, 1);
				testlog.info("And User checks the CorePoint checkbox");
				CommonMethod.selectdropdownValue("PortfolioScorecardTierDropdownValue", "2");
				testlog.info("And User select Tier 2 option");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddButton",
						"PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 60);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				/*
				 * Test by adding the core point
				 */
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"), "3",
						"Weight Point for 3 by adding and checking checkbox tier doesn't match");
				testlog.pass("And User verifies Core Weight Point 3");
				/*
				 * Verify Upload button disable
				 */
				CommonMethod.scrollDown();
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskUploadDisableCount", 2);
				testlog.info("And User verifies Task Upload Disable button Count");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignbtn", 0);
				
				List<WebElement> AssignButton;
				AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
				for (WebElement f : AssignButton) {
					CommonMethod.WaitUntilClickble(f, 30).click();
					/*
					 * Assign Location Assign Location filter
					 */
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFilters", 0);
					CommonMethod.RobustclickElementVisible("PortfolioScorecardFilters", "OwnerOrgClick");
					testlog.info("And User clicks on Filters Button");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OwnerOrgClick", 0);
					CommonMethod.RobustclickElementVisible("OwnerOrgClick", "OwnerOrg");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("OwnerOrg", 0);
					CommonMethod.sendKeys("OwnerOrg", "Afghanistan");
					testlog.info("And User select Country Name");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SelectOwnerOrgDyn", 0);
					CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10).click();
					Thread.sleep(1000);
					CommonMethod.scrolldowntoElement("OwnerOrg");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Applybutton", 0);
					CommonMethod.RobustclickElementVisible("Applybutton",
							"PortfolioScoreCardVerificationAssignChildLocCbx");
					CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr", 1);
					int AssignLocTableTrSize = CommonMethod.ElementSize("AssignLocationTableTr");
					String TableTrSize = Integer.toString(AssignLocTableTrSize);
					CommonMethod.negativesoftassertFieldValidEquals(TableTrSize, "1",
							"TableTrSize in Document list doesn't match");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignFilterClear", 0);
					CommonMethod.RobustclickElementVisible("AssignFilterClear", "AssignFilterLocCloseIcon");

					CommonMethod.WaitUntilClickble("PortfolioScoreCardVerificationAssignChildLocCbx", 30);
					/*
					 * Verify SpaceType Warehouse
					 */
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScorecardAssignfilterSpaceTypeSelect", 0);
					CommonMethod.click("PortfolioScorecardAssignfilterSpaceTypeSelect");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScorecardAssignfilterSpaceTypeOption", 0);
					CommonMethod.JavascriptClickElement("PortfolioScorecardAssignfilterSpaceTypeOption");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Applybutton", 0);
					CommonMethod.RobustclickElementVisible("Applybutton",
							"PortfolioScoreCardVerificationAssignChildLocCbx");
					CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr", 5);
					int SpaceTypeTableTrSize = CommonMethod.ElementSize("AssignLocationTableTr");
					String SpaceTypeTable = Integer.toString(SpaceTypeTableTrSize);
					CommonMethod.negativesoftassertFieldValidEquals(SpaceTypeTable, "5",
							"SpaceType TableTrSize in Assign list filter doesn't match");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignFilterClear", 0);
					CommonMethod.RobustclickElementVisible("AssignFilterClear", "AssignFilterLocCloseIcon");
					/*
					 * Verify Ownership type
					 */
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScorecardAssignfilterOwnershipType", 0);
					CommonMethod.selectdropdownVisibletext("PortfolioScorecardAssignfilterOwnershipType",
							"Owner-occupied");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Applybutton", 0);
					CommonMethod.RobustclickElementVisible("Applybutton",
							"PortfolioScoreCardVerificationAssignChildLocCbx");
					CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr", 2);
					int OwnershipTable = CommonMethod.ElementSize("AssignLocationTableTr");
					String OwnershipTableTrSize = Integer.toString(OwnershipTable);
					CommonMethod.negativesoftassertFieldValidEquals(OwnershipTableTrSize, "2",
							"Ownership type TableTrSize in Assign list filter doesn't match");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignFilterClear", 0);
					CommonMethod.RobustclickElementVisible("AssignFilterClear", "AssignFilterLocCloseIcon");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignFilterLocCloseIcon", 0);
					CommonMethod.RobustclickElementVisible("AssignFilterLocCloseIcon",
							"PortfolioScoreCardVerificationAssignChildLocCbx");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
					CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1,
							4);
					testlog.info("And User checks the Assign Location checkbox");
					/*
					 * Verify selected Location
					 */
					CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortFolioScoreCardVerifySelectedAssignedLoc", 0);
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortFolioScoreCardVerifySelectedAssignedLoc").replaceAll("\\s+", " "), "3 locations selected",
							"Assigned Location Count doesn't match");
					testlog.info("And User verifies Assigned Location");
					/*
					 * Verify Tag New status
					 */
					CommonMethod.WaitUntilNumberOfElementToBePresentWithException(
							"PortfolioScoreCardVerifyAssignedLocationNewStatus1", 3);
					CommonMethod.assertcountListWebelementFromIndex(
							"PortfolioScoreCardVerifyAssignedLocationNewStatus1", 3);
					testlog.info("And User verifies New Assigned Location Status");
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						PortfolioScoreCardVerificationAssignLocSavebtn, 0);
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				testlog.info("And User clicks on Save Button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				/*
				 * Verifies Assign Button and verify Purse Location Count
				 */
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "3 Pursuing",
							"Option Purse Location Count doesn't match");
					testlog.info("And User verifies Option Purse Locations");
				}

				/*
				 * Verifies Assign Button change to Edit Location
				 */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardEditLocation", 0);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardEditLocation", 1);
				/*
				 * Verify Task Location count
				 */
				List<WebElement> TaskAssignLocation;
				TaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : TaskAssignLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/1 Locations",
							"Task Assign Location Count doesn't match");
					testlog.info("And User verifies Task Assign Location Count");
				}
				/*
				 * Edit location and verify the updated location
				 */
				CommonMethod.WaitUntilPresence("PortfolioScorecardEditLocation", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardEditLocation",
						"PortfolioScoreCardVerificationAssignLocCbxGeneral");
				testlog.info("And User clicks on Edit Location Button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx",
						0);
				CommonMethod.ClickCheckbox("PortfolioScoreCardVerificationAssignLocCbx");
				CommonMethod.WaitUntilVisibility(PortfolioScoreCardVerificationAssignLocSavebtn, 30);
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				/*
				 * Verify Assign status
				 */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFilters", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFilters", "OwnerOrgClick");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardAssignfilterStatus", 0);
				CommonMethod.selectdropdownVisibletext("PortfolioScorecardAssignfilterStatus", "Assigned");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Applybutton", 0);
				CommonMethod.RobustclickElementVisible("Applybutton",
						"PortfolioScoreCardVerificationAssignChildLocCbx");
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AssignLocationTableTr", 5);
				int AssignLocTableTrSize = CommonMethod.ElementSize("AssignLocationTableTr");
				String TableTrSize = Integer.toString(AssignLocTableTrSize);
				CommonMethod.negativesoftassertFieldValidEquals(TableTrSize, "5",
						"Assigned Status TableTrSize in Assign list filter doesn't match");
				testlog.info("And User clicks on Save Button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");

				List<WebElement> EditTaskAssignLocation;
				EditTaskAssignLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : EditTaskAssignLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/2 Locations",
							"Task Assign Location Count doesn't match");
					testlog.info("And User verifies Task Assign Location Count");
					testlog.info("And User verifies updated Location Count");
				}
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				/*
				 * Test by removing the core point from option 1
				 */
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1);
				testlog.info("And User Unchecks the CorePoint checkbox");
				CommonMethod.WaitUntilPresence("PortfolioScorecardWeightHighlighted", 30);
				Thread.sleep(2000);
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"), "2",
						"Weight Point for 2 by uncheck the checkbox doesn't match");
				testlog.info("And User verifies Weight Point 2");
				/*
				 * Test by modifying tier point to 1 for option 1 and 2
				 */
				Thread.sleep(2000);
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAssignLocCbxGeneral", 180);
				List<WebElement> dropdown = CommonMethod.findElements("PortfolioScorecardTierDropdownValueGeneral");
				for (WebElement drop : dropdown) {
					CommonMethod.selectdropdownWebelementByValue(drop, "1");
					testlog.info("And User select tier 1");
					Thread.sleep(2000);
					CommonMethod.softAssertContainsMessage(CommonMethod.getSelectedDropdownValue(drop), "Tier 1",
							"TierDropdown value doesn't match");
					testlog.info("And User verifies selected tier 1");
				}
				CommonMethod.WaitUntilPresence("PortfolioScorecardWeightHighlighted", 30);
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlighted"), "1",
						"Weight Point for 1 by removing tier dropdown doesn't match");
				testlog.info("And User verifies Weight Point 1");
				softAssert.assertAll();
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Light L09.1 Feature successful**");
	}

	public void ConductDaylightSimulation(String FeatureName, String SheetName, int rowNum, String Commodity,
			String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("When User clicks on Air L06.1 feature");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 10);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on AddOption button");
				testlog.info("And User clicks on Add button");
				testlog.info("And User verifies Remove button");
				CommonMethod.WaitUntilPresence("WPRAssignLocbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardVerifyAuditInOptionTask", 2);
				testlog.info("And User verifies OptionCount");
				pathprms.put("StartAssignLoc", "1");
				pathprms.put("EndAssignLoc", "5");
				generic.assignLocationGeneric(Commodity, false, false, false, true, false);
				List<WebElement> AssignPurseLocation;
				AssignPurseLocation = CommonMethod.findElements("PortfolioScorecardOptionPurseLocation");
				for (WebElement f : AssignPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "4 Pursuing",
							"PurseLocationCount doesn't match");
					testlog.info("And User verifies Purse Location Count");
				}

				List<WebElement> TaskPurseLocation;
				TaskPurseLocation = CommonMethod.findElements("PortfolioScorecardTaskPurseLocation");
				for (WebElement f : TaskPurseLocation) {
					CommonMethod.softAssertContainsMessage(CommonMethod.getText(f), "0/2 Locations",
							"Task Assign Location Count doesn't match");
					testlog.info("And User verifies Task Location Count");
				}
				Thread.sleep(2000);
				CommonMethod.scrollDown();
				CommonMethod.ClickFirstElementInList("PortfolioScoreCardVerificationUploadbtn");
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				rc.ScorecardConfirmLocUploadSaveButton();
				testlog.info("And User verifies Document Uploaded successfully toast message");
				testlog.info("Fetching Data from Upload Table");
				testlog.info("And User verifies Document table data");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
				/*
				 * Edit Upload Document
				 */
				rc.documentTableEditButton();
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
				testlog.info("And User enter data to AddNote field");
				CommonMethod.WaitUntilInVisibility("PortfolioScoreCardVerificationUpload", 60);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScorecardVerifyTaskUploadIntentStage", 0);
				CommonMethod.ClickCheckbox("PortfolioScorecardVerifyTaskUploadIntentStage");
				testlog.info("And User checks the IntentStage checkbox");
				rc.ScorecardUploadUpdateSaveButton();
				testlog.info("And User clicks on save button");
				rc.ScorecardConfirmLocUploadSaveButton();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				testlog.info("And User verifies Document Uploaded successfully toast message");
				pathprms.put("Status", "Ready For Review");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false, false,
						true, false, false);
				testlog.info("And User verifies Document Uploaded successfully toast message");
				testlog.info("Fetching Data from Upload Table");
				testlog.info("And User verifies Document table data");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioAndRatingLocAccDocumentTableTr", 1);
				testlog.info("And User verifies Task Upload button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
				CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioAndRatingLocAccDocumentTableDeleteIcon", 0);
				CommonMethod.RobustclickElementVisible("PortfolioAndRatingLocAccDocumentTableDeleteIcon",
						"CancelButton");
				testlog.info("When User clicks on Delete button");
				testlog.info("And User clicks on Delete Icon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CancelButton", 0);
				CommonMethod.Robustclick("CancelButton");
				testlog.info("And User clicks on No Delete button");
				CommonMethod.WaitUntilPresence(PortfolioAndRatingLocAccDocumentTable, 120);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioAndRatingLocAccDocumentTableTr", 1);
				testlog.info("And User verifies Document table list count");
				softAssert.assertAll();
				rc.documentTableDeleteButton();
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Light L06.1 Feature successful**");
	}

	public void OfferPhysicalActivityIncentives(String FeatureName) throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("When User clicks on Movement V09.1 feature");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardAddOptionbutton", 1);
				CommonMethod.Robustclick("PortfolioScoreCardAddButton");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on AddOption button");
				testlog.info("And User clicks on Add button");
				testlog.info("Then User verifies Remove button");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationAssignbtn", 60);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardVerificationAssignbtn", 1);
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScoreCardTaskCount", 3);
				testlog.info("And User verifies Option Count");
				testlog.info("And User verifies Task Count");
				testlog.info("And User verifies Assign button Count");
				CommonMethod.assertcountListWebelementFromIndex("PortfolioScorecardTaskUploadDisableCount", 3);
				testlog.info("And User verifies Upload button disable");
				/*
				 * Verify Search Location Name in Location model
				 */
				CommonMethod.RobustclickElementVisible("WPRAssignLocbtn",
						"PortfolioScoreCardVerificationAssignChildLocCbx");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEditSearchLocation", 0);
				CommonMethod.sendKeys("PortfolioEditSearchLocation", "WELL at scale Test location 1");
				Thread.sleep(3000);
				CommonMethod.sendKeyEnter("PortfolioEditSearchLocation");
				Thread.sleep(2000);
				int AssignLocTableTrSize = CommonMethod.WaitUntilNumberOfElementToBePresent("AssignLocationTableTr", 1)
						.size();
				String TableTrSize = Integer.toString(AssignLocTableTrSize);
				CommonMethod.softAssertEqualsMessage(TableTrSize, "1", "TableTrSize in Document list doesn't match");
				CommonMethod.Robustclick("PortfolioDocumentConfirmLocCrossIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				testlog.info("And User verifies Scorecard Search by Name");
				softAssert.assertAll();
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Movement V09.1 Feature successful**");
	}

	public void RestrictVOCEmissionsfromFurnitureArchitecturalandInteriorProducts(String FeatureName)
			throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.click(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on Materials X06.2 feature");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScorecardTierDropdownValue");
				testlog.info("And User clicks on AddOption button");
				CommonMethod.softAssertContainsMessage(
						CommonMethod.getSelectedDropdownValue("PortfolioScorecardTierDropdownValue"), "1",
						"TierDropdown Defualt value doesn't match");
				testlog.info("Then User verifies Tier Dropdown Value");
				CommonMethod.softAssertContainsMessage(CommonMethod.getText("PortfolioScorecardWeightHighlightX06"),
						"2", "Weight Point for 2 doesn't match");
				testlog.info("And User verifies Weight Point for 2");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardVerificationCloseicon", 30);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				testlog.pass("And User verifies Core Weight Point");
				softAssert.assertAll();
				CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
				CommonMethod.click(ele);
			}
		}
		testlog.pass("**Verifies Scorecard Uploaded Document Materials X06.2 Feature successful**");
	}

	public void A01_1_FeatureDocumentUploadInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws Exception {
		testlog.info("Given User is on Document Library page");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 120);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab", "PortfolioTaskListPendingTab");
		testlog.info("When User clicks on TaskList Tab");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListPendingTab", 30);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListPendingTab", "PortfolioDocListA1.1");
		testlog.info("And User clicks on PendingTab");
		CommonMethod.scrolldowntoElement("PortfolioTaskListPendingTab");
		CommonMethod.WaitUntilPresence("PortfolioDocListA1.1", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocListA1.1", "PortfolioScoreVerifyUploadVerificationMethod");
		testlog.info("And User clicks on Upload button");
		CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 300);
		CommonMethod.WaitUntilVisibility("PortfolioScoreVerifyUploadVerificationMethod", 60);
		String VerificationMethod = CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod");
		CommonMethod.negativesoftassertFieldValid(VerificationMethod, "Performance Test OR Sensor Data",
				"Verification Method doesn't match");
		testlog.info("VerificationMethod: " + VerificationMethod);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardUploadFeatureName"),
				"Meet Thresholds for Particulate Matter", "Feature Name doesn't match");
		testlog.info("Then User verifies VerificationMethod");
		testlog.info("And User verifies FeatureName");
		testlog.info("And User verifies Assigned location count");
		generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FeaturefileUpload, false, false, false, false);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx", 0);
		rc.ScorecardConfirmLocUploadSaveButton();
		testlog.info("And User clicks on Upload button");
		if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
		}
		testlog.info("And User verifies Document Uploaded successfully toast message");
		testlog.info("Fetching Data from Upload Table");
		testlog.info("And User verifies Document Uploaded successfully toast message");
		testlog.info("And User verifies Document table data");
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		rc.documentTableEditButton();
		testlog.info("And User clicks on Edit icon");
		CommonMethod.WaitUntilPresence("PortfolioScoreVerifyUploadVerificationMethod", 60);
		CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
		testlog.info("And User enter data to Note field");
		rc.ScorecardUploadUpdateSaveButton();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx", 0);
		rc.ScorecardConfirmLocUploadSaveButton();
		testlog.info("And User clicks on Update Button");
		CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", 60);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab", "PortfolioTaskListPendingTab");
		CommonMethod.WaitUntilVisibility("PortfolioDocListTaskFullFilledTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocListTaskFullFilledTab",
				"PortfolioDocumentVerifyCompleteTask");
		testlog.info("And User clicks on FullFilledTab");
		CommonMethod.WaitUntilPresence("PortfolioDocumentVerifyCompleteTask", 60);
		CommonMethod.assertcontainshandledPageSource("A01.1", "A01.1 task doesn't match");
		testlog.info("And User verifies feature name in FullFilledTab list");
		CommonMethod.WaitUntilPresence("PortfolioDocumentVerifyCompleteTask", 60);
		softAssert.assertAll();
		CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab", "PortfolioTaskListPendingTab");
		CommonMethod.click("PortfolioTaskListPendingTab");
		testlog.pass("**Verifies the Attach and Completed Document for successful**");
	}

	public void L09_AuditDocumentUploadInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws Exception {
		testlog.info("Given User is on Document Library page");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab", "PortfolioTaskListPendingTab");
		testlog.info("When User clicks on TaskListTab");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListPendingTab", 30);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListPendingTab", "PortfolioDocListUploadTaskL09Technical");
		testlog.info("And User clicks on TaskList Pending Tab");
		CommonMethod.scrolldowntoElement("PortfolioTaskListPendingTab");
		CommonMethod.RobustclickElementVisible("PortfolioDocListUploadTaskL09Technical",
				"PortfolioScoreVerifyUploadVerificationMethod");
		testlog.info("And User clicks on Upload button");
		CommonMethod.WaitUntilVisibility("PortfolioScoreVerifyUploadVerificationMethod", 60);
		String VerificationMethod = CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod");
		CommonMethod.negativesoftassertFieldValid(VerificationMethod, "Technical Document (Audited)",
				"Verification Method doesn't match");
		testlog.info("VerificationMethod: " + VerificationMethod);
		CommonMethod.WaitUntilPresence("PortfolioScorecardUploadFeatureName", 180);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardUploadFeatureName"),
				"Enhance Occupant Controllability", "Feature name doesn't match");
		testlog.info("And User verifies VerificationMethod");
		testlog.info("And User verifies FeatureName");
		testlog.info("And User verifies Assigned location count");
		generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FeaturefileUpload, false, false, false, false);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx", 0);
		rc.ScorecardConfirmLocUploadSaveButton();
		testlog.info("And User clicks on Upload button");
		if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
		}
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		pathprms.put("LocationCount", "2 Assigned");
		pathprms.put("PartId", "L09.1");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, true, false, false,false, false, false);
		testlog.info("Fetching Data from Upload Table");
		testlog.info("And User verifies Document Uploaded successfully toast message");
		testlog.info("And User verifies Document table data");
		testlog.pass("**Verifies the Attach Docuement for Audit successful**");
	}

	public void UpdateAuditDocumentUploadInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws Exception {
		/*
		 * Edit Audit Upload Document
		 */
		testlog.info("Given User is on Document Library page");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.WaitUntilPresence(PortfolioAndRatingLocAccDocumentTable, 60);
		CommonMethod.scrolldowntoElement("PortfolioDocumentListLink");
		rc.documentTableEditButton();
		CommonMethod.WaitUntilPresence("PortfolioScoreVerifyUploadVerificationMethod", 60);
		CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddNote", 120);
		CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardVerifyTaskUploadIntentStage", 0);
		CommonMethod.ClickCheckbox("PortfolioScorecardVerifyTaskUploadIntentStage");
		rc.ScorecardUploadUpdateSaveButton();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx", 0);
		rc.ScorecardConfirmLocUploadSaveButton();
		CommonMethod.WaitUntilPresence("PortfolioDocumentUploadbutton", 60);
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		pathprms.put("Stage", "Audit");
		pathprms.put("Status", "Ready For Review");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false, true,
				true, false, false);
		testlog.info("Fetching Data from Upload Table");
		testlog.info("And User verifies Document Uploaded successfully toast message");
		testlog.info("And User verifies Document table data");
		testlog.pass("**Updated feature Document successfully**");
	}

	public void A01_2_DocumentUploadInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws Exception {
		testlog.info("Given User is on Document Library page");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListTab", 60);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab", "PortfolioTaskListPendingTab");
		testlog.info("When User clicks on TaskListTab");
		CommonMethod.WaitUntilVisibility("PortfolioTaskListPendingTab", 30);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListPendingTab", "PortfolioDocListA1.2");
		CommonMethod.scrolldowntoElement("PortfolioTaskListPendingTab");
		CommonMethod.WaitUntilPresence("PortfolioDocListA1.2", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocListA1.2", "PortfolioScoreVerifyUploadVerificationMethod");
		testlog.info("And User clicks on Upload Button");
		CommonMethod.WaitUntilPresence("PortfolioScorecardUploadFeatureName", 60);
		CommonMethod.scrolldowntoElement("PortfolioScorecardUploadFeatureName");
		generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FeaturefileUpload, false, false, false, true);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx", 0);
		CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
		testlog.info("And User Unchecks the AssignLocation checkbox");
		rc.ScorecardConfirmLocUploadSaveButton();
		testlog.info("And User clicks on Upload Button");
		if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 3)) {
			CommonMethod.WaitUntilInVisibility("PortfolioScorecardDocumentAddedPopup", 30);
		}
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 180);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		testlog.info("And User clicks on DocumentListLink");
		pathprms.put("PartId", "A01.2");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, false, false, false,
				false, false, false);
		testlog.info("And User verifies Location Count");
		testlog.info("And User verifies Document Uploaded successfully toast message");
		testlog.info("And User verifies Document table data");
		testlog.pass("**Upload feature Document successfully**");
	}

	public void UpdateFeatureDocumentUploadInDocumentLibrary(String SheetName, int rowNum, String Commodity) throws Exception {
		/*
		 * Edit Feature Upload Document
		 */
		testlog.info("Given User is on Document Library page");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		testlog.info("When User clicks on DocumentList tab");
		CommonMethod.WaitUntilPresence(PortfolioAndRatingLocAccDocumentTable, 60);
		CommonMethod.scrolldowntoElement("PortfolioDocumentListLink");
		rc.documentTableEditButton();
		testlog.info("And User clicks on Edit icon");
		CommonMethod.WaitUntilPresence("PortfolioScoreVerifyUploadVerificationMethod", 60);
		CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "document share with review team.");
		testlog.info("And User enter data to Note field");
		CommonMethod.ClickCheckbox("PortfolioScorecardVerifyTaskUploadIntentStage");
		testlog.info("And User checks on IntentStage checkbox");
		CommonMethod.ClickCheckbox("PortfolioScorecardVerifyTaskUploadIntentStage");
		rc.ScorecardUploadUpdateSaveButton();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignLocCbx", 0);
		rc.ScorecardConfirmLocUploadSaveButton();
		testlog.info("And User clicks on Update Button");
		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
		CommonMethod.WaitUntilPresence("PortfolioDocumentListLink", 60);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		testlog.info("And User clicks on Edit icon");
		pathprms.put("StageIntent", "Intent");
		pathprms.put("Status", "Ready For Review");
		generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false, false,
				true, false, true);
		softAssert.assertAll();
		CommonMethod.refreshBrowser();
		testlog.info("Then User verifies Document table data");
		testlog.pass("**Updated feature Document successfully**");
	}

	public void FilterInDocumentLibrary() throws IOException, InterruptedException {
		testlog.info("Given User is on Document Library page");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioTaskListTab", 0);
		CommonMethod.RobustclickElementVisible("PortfolioTaskListTab", "PortfolioTaskListPendingTab");
		CommonMethod.scrolldowntoElement("PortfolioTaskListTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocFliterByLocation", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocFliterByLocation", "PortfolioSelectFliterByLocation");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSelectFliterByLocation", 0);
		CommonMethod.RobustclickElementVisible("PortfolioSelectFliterByLocation",
				"PortfolioDocListFilterLocationValid");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListFilterLocationValid", 0);
		List<WebElement> FliterVerifyLocation;
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioFliterVerifyLocation", 0);
		FliterVerifyLocation = CommonMethod.findElements("PortfolioFliterVerifyLocation");
		for (WebElement f : FliterVerifyLocation) {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText(f), "0/1 Locations",
					"Filter Verify Location doesn't match");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioFliterClearFilter", 0);
		CommonMethod.Robustclick("PortfolioFliterClearFilter");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioFliterButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioFliterButton", "PortfolioFliterVerificationOption");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioFliterVerificationOption", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioFliterVerificationOption"),
				"Verification", "Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioFliterPartTypeOption"), "Part Type",
				"Document table data mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioFliterConceptOption"), "Concept",
				"Document table data mismatch");
		// Verification
		CommonMethod.RobustclickElementVisible("PortfolioFliterVerificationOption",
				"PortfolioFliterVerificationOptionCheckbox");
		CommonMethod.RobustclickElementVisible("PortfolioFliterVerificationOptionCheckbox",
				"PortfolioFliterOptionApply");
		CommonMethod.RobustclickElementVisible("PortfolioFliterVerificationOption", "PortfolioFliterOptionApply");
		CommonMethod.RobustclickElementVisible("PortfolioFliterOptionApply", "PortfolioFliterVerificationAuditTask");
		CommonMethod.WaitUntilPresence("PortfolioDocListFilterPreOption", 120);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioFliterVerificationAuditTask"),
				"Technical Document (Audited)", "Verification option didn't match");
		CommonMethod.RobustclickElementVisible("PortfolioFliterButton", "PortfolioFliterVerificationOption");
		CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear", "PortfolioFliterButton");
		// PartType
		CommonMethod.RobustclickElementVisible("PortfolioFliterButton", "PortfolioFliterPartTypeOption");
		CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeOption",
				"PortfolioFliterPartTypeOptionCheckbox");
		CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeOptionCheckbox", "PortfolioFliterOptionApply");
		CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeOption", "PortfolioFliterOptionApply");
		CommonMethod.RobustclickElementVisible("PortfolioFliterOptionApply", "PortfolioDocListFilterPreOption");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioDocListFilterPreOption"), "A01.2",
				"Precondition option didn't match");
		CommonMethod.RobustclickElementVisible("PortfolioFliterButton", "PortfolioFliterVerificationOption");
		CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear", "PortfolioFliterButton");
		// Concept
		CommonMethod.RobustclickElementVisible("PortfolioFliterButton", "PortfolioFliterConceptOption");
		CommonMethod.RobustclickElementVisible("PortfolioFliterConceptOption",
				"PortfolioFliterPartTypeConceptCheckbox");
		CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeConceptCheckbox", "PortfolioFliterOptionApply");
		CommonMethod.RobustclickElementVisible("PortfolioFliterConceptOption", "PortfolioFliterOptionApply");
		CommonMethod.RobustclickElementVisible("PortfolioFliterOptionApply", "PortfolioDocListFilterPreOption");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioDocListFilterPreOption"), "A01.2",
				"Precondition option didn't match");
		CommonMethod.RobustclickElementVisible("PortfolioFliterButton", "PortfolioFliterOptionClear");
		CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear", "PortfolioFliterButton");

		// Multiple option
		CommonMethod.RobustclickElementVisible("PortfolioFliterButton", "PortfolioFliterConceptOption");
		CommonMethod.RobustclickElementVisible("PortfolioFliterVerificationOption",
				"PortfolioFliterVerificationOptionCheckbox");
		CommonMethod.RobustclickElementVisible("PortfolioFliterVerificationOptionCheckbox",
				"PortfolioFliterOptionApply");
		CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeOption",
				"PortfolioFliterPartTypeOptionCheckbox");
		CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeOptionCheckbox", "PortfolioFliterOptionApply");
		CommonMethod.RobustclickElementVisible("PortfolioFliterConceptOption",
				"PortfolioFliterPartTypeConceptCheckbox");
		CommonMethod.RobustclickElementVisible("PortfolioFliterPartTypeConceptCheckbox", "PortfolioFliterOptionApply");
		CommonMethod.RobustclickElementVisible("PortfolioFliterOptionApply", "PortfolioDocListFilterNoTaskShow");
		CommonMethod.WaitUntilPresence("PortfolioDocListFilterNoTaskShow", 120);
		CommonMethod.RobustclickElementVisible("PortfolioFliterButton", "PortfolioFliterOptionClear");
		CommonMethod.RobustclickElementVisible("PortfolioFliterOptionClear", "PortfolioFliterButton");
		// Filter By Name
//		CommonMethod.refreshBrowser();
//		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
//		CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
//		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
//		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", "PortfolioDocListFilterName");
//		CommonMethod.scrolldowntoElement("PortfolioDocumentListLink");
//		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocListFilterName", 0);
//		CommonMethod.sendKeys("PortfolioDocListFilterName", "Feature");
//		Thread.sleep(3000);
//		CommonMethod.scrolldowntoElement("PortfolioDocListFilterName");
//		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
//		testlog.info("Fetching Data from Upload Table");
//		List<String> val = CommonMethod.fetchTableData(PortfolioAndRatingLocAccDocumentTable);
//		CommonMethod.scrolldowntoElement(PortfolioAndRatingLocAccDocumentTable);
//		CommonMethod.negativesoftassertFieldValid(val.get(0), "FeatureFile", "Document table data mismatch");
		testlog.info("And User verifies search by location filter");
		testlog.info("And User verifies search filter options");
		testlog.info("And User verifies search filter by Verification Task");
		testlog.info("And User verifies search filter by Part Type Task");
		testlog.info("And User verifies search by Name filter");
		testlog.info("And User verifies search filter Mutiple options");
		testlog.pass("**Verifies search filter successfully**");
	}

	public void DeleteInDocumentLibrary() throws Exception {
		testlog.info("Given User is on Document Library page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
		CommonMethod.RobustclickElementVisible("PortfolioDocumentListLink", PortfolioAndRatingLocAccDocumentTable);
		testlog.info("When User clicks on DocumentListLink");
		CommonMethod.scrolldowntoElement("PortfolioDocumentListLink");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableTr", 1);
		rc.documentTableDeleteButton();
		testlog.info("Then User verifies Delete successfully toast message");
		testlog.info("**Verifies Task Deleted successfully**");
	}

	public void NotApplicableAlternative(String FeatureName, String SheetName, int rowNum, String Commodity)
			throws Exception {
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						"PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardAddOptionbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardAddOptionbutton",
						"PortfolioScoreCardAddButton");
				testlog.info("And User clicks on AddOption button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecarNAOption", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecarNAOption", "PortfolioScorecarNAAddButton");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecarNAAddButton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecarNAAddButton",
						"PortfolioScorecarNAValidSelectedAddButtonToasterMessage");
				testlog.info("And User clicks on AddOption button");
				if (CommonMethod.isElementsExist("PortfolioScorecarNAValidSelectedAddButtonToasterMessage", 5)) {
					CommonMethod.WaitUntilNumberOfElementToBePresentLessThan(
							"PortfolioScorecarNAValidSelectedAddButtonToasterMessage", 1);
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignbtn", 0);
				generic.assignLocationGeneric(Commodity, false, false, true, false, false);
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
					CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "Test Note");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScorecardVerifyTaskUploadIntentStage", 0);
					CommonMethod.ClickParticularCheckbox("PortfolioScorecardVerifyTaskUploadIntentStage");
					CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioScorecardVerifyTaskUploadIntentStage");
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
					generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, true, true, true, true,
							true, true, false);
					CommonMethod.scrolldowntoElement("PortFolioScoreCardPageLand");
					CommonMethod.JavascriptClickElement(ele);
			}
			testlog.pass("**Verifies Scorecard Uploaded Document Not Applicable successful**");
		}
	}
	
		public void ScorecardSaveAndExitFlow(String FeatureName, String SheetName, int rowNum, String Commodity)
				throws Exception {
			testlog.info("Given User is on Scorecard page");
			List<WebElement> Feature;
			Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
			testlog.info("Fetching total no. of credits on page");
			for (WebElement ele : Feature) {
				String Creditname = ele.getText();
				Creditname = Creditname.replaceAll("\\.", "");
				if (Creditname.equalsIgnoreCase(FeatureName)) {
					CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
					CommonMethod.JavascriptClickElement(ele);
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRVerficationTab", 0);
					CommonMethod.RobustclickElementVisible("WPRVerficationTab", "PortfolioScoreCardAddOptionbutton");
					testlog.info("And User clicks on VerificationTab");
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
				}
			}
		}
			public void ValidateSaveAndExitFlow(String SheetName, int rowNum, String Commodity) throws Exception {
				
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
				CommonMethod.click("WPRAssignLocCbx");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndContinuebtn", 0);
				CommonMethod.click("SaveAndContinuebtn");
				Thread.sleep(3000);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SelectIndex2CheckBox", 0);
				CommonMethod.click("SelectIndex2CheckBox");
				Thread.sleep(3000);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardLocationCountLabel", 0);
				String actualLocationCountLabel = CommonMethod.getattributeValueByTextContent("V2ProjectScorecardLocationCountLabel").trim();
				CommonMethod.negativesoftassertFieldValid(actualLocationCountLabel.replaceAll("\\s+", " "), "4 locations selected", "Selected location count does not matched");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndExitbtn", 0);
				CommonMethod.click("SaveAndExitbtn");
				if(TestCaseName.equalsIgnoreCase("Portfolio_CTC_02_09_ValidateDocumentSaveAndExitFlow")) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentListLink", 0);
				CommonMethod.click("PortfolioDocumentListLink");
				}
				pathprms.put("LocationCount", "4 Assigned");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, 
					false, true, false, false, false, false, false);
			}
			
			public void ValidateDocumentSaveAndExitFlow(String SheetName, int rowNum, String Commodity, String PartId)
					throws Exception {
				CommonMethod.refreshBrowser();
				testlog.info("Given User is on Document page");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.RobustclickElementVisible("PortfolioDocumentUploadbutton",
						"V2ProjectPortfolioDocTypeFeatureAudit");
				testlog.info("When User click on Upload button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectPortfolioDocTypeFeatureAudit", 0);
				CommonMethod.RobustclickElementVisible("V2ProjectPortfolioDocTypeFeatureAudit", "V2ProjectPortfolioDocType");
				testlog.info("When User click on Upload button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectPortfolioDocType", 0);
				CommonMethod.selectdropdownValue("V2ProjectPortfolioDocType", "feature");
				testlog.info("And User select Document Type");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSelectverificationMethod", 0);
				CommonMethod.selectdropdownVisibletext("PortfolioSelectverificationMethod",
						"Policy and/or Operations Schedule");
				testlog.info("And User select VerificationMethod");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRSelectFeaturePart", 0);
				CommonMethod.scrolldowntoElement("V2ProjectPortfolioDocType");
				CommonMethod.selectdropdownVisibletext("WPRSelectFeaturePart", PartId);
				testlog.info("And User select FeaturePart");
				CommonMethod.scrolldowntoElement("WPRSelectFeaturePart");
				CommonMethod.WaitUntilPresence("WPRAddPartButton", 60);
				CommonMethod.Robustclick("WPRAddPartButton", "WPRSelectFeaturePart");
				generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FeaturefileUpload, false, false, false,
						false);
			}
			
			public void ValidateScorecardUploadButtonCountAndTable(String SheetName, int rowNum, String Commodity) throws Exception {
				
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioCloseUploadDocumentModal", 0);
				CommonMethod.Robustclick("PortfolioCloseUploadDocumentModal");
				CommonMethod.assertisElementPresentTrue("ScorecardUploadedDocLocationCount", "5/5 Locations count does not matched");
				CommonMethod.scrolldowntoElement("PortfolioScorecardFeatureTableCount");	
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureTableCount", 0);
				String expectedFeatureTableCount = CommonMethod.getattributeValueByTextContent("PortfolioScorecardFeatureTableCount");
				CommonMethod.negativesoftassertFieldValid(expectedFeatureTableCount, "1", "Table count 1 does not matched");
				testlog.info("Validate Scorecard Upload Button Count And Table Cases has been Successfully Passed");
			}
}