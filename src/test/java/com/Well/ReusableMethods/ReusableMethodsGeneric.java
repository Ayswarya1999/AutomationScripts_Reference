package com.Well.ReusableMethods;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import java.util.List;

import org.openqa.selenium.WebElement;

public class ReusableMethodsGeneric extends BaseClass {
	String PortfolioAndRatingLocAccDocumentTable = "PortfolioAndRatingLocAccDocumentTable";
	String PortfolioScoreCardVerificationAssignLocSavebtn = "PortfolioScoreCardVerificationAssignLocSavebtn";

	public void uploadModalFirstScreenGeneric(String SheetName, int rowNum, String Commodity, String FileName,
			Boolean PartNameRequired, Boolean VerificationMethodValidationRequired, Boolean NoteRequired,
			Boolean IntentCheckboxRequired) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("ScorecardFeatureLoader");
		switch (Commodity) {
		case "Ratings":
			if (VerificationMethodValidationRequired) {
				String VerificationMethodExpected = data.getCellData(SheetName, "VerificationMethod", rowNum);
				String FeatureVerificationNameV2 = "Performance Test OR Sensor Data";
				String VerificationMethodActual = CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod");
				testlog.info("VerificationMethod: " + VerificationMethodActual);
				if (TestNGTestName.contains("V2-Pilot")) {
					/** Valid VerificationMethod */
					CommonMethod.negativesoftassertFieldValid(VerificationMethodActual, VerificationMethodExpected,
							"Verification Method doesn't match");
				} else {
					CommonMethod.negativesoftassertFieldValid(VerificationMethodActual, FeatureVerificationNameV2,
							"Verification Method doesn't match");
				}
				testlog.info("Then User verifies verification Method");
			}

			if (PartNameRequired) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadAddfeature", 0);
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationSelectFeature");
				testlog.info("And User clicks on Add feature");
				if (CommonMethod.isElementsExist("PortfolioScoreCardVerificationSelectSpaceType", 5)) {
					CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
				}
				if (CommonMethod.isElementsExist("PortfolioScoreCardVerificationSelectOption", 5)) {
					CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
				}
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPart", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
						"PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadFeatureRemove", 0);
				testlog.info("And User verifies Removelink should be visible");
			}

			// CommonPieceforuploadfile
			CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("ScorecardFeatureLoader");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUpload", 0);
			CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FileName, "UploadFileVerifyScorecard");
			testlog.info("And User Upload Feature Document");
			testlog.info("And User clicks on Upload Button");

			if (NoteRequired) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddNote", 0);
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote",
						data.getCellData(SheetName, "NoteComment", rowNum));
				testlog.info("And User enter data to AddNote field");
			}

			if (IntentCheckboxRequired) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScorecardVerifyTaskUploadIntentStage", 0);
				CommonMethod.ClickCheckbox("PortfolioScorecardVerifyTaskUploadIntentStage");
			}
			rc.ScorecardUploadSaveButton();
			break;

		case "Portfolio":
			if (VerificationMethodValidationRequired) {
				if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_03_01_FeatureScorecardUpload")) {
					String FeatureVerificationNameV2 = "Performance Test OR Sensor Data";
					String VerificationMethod = CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod");
					testlog.info("VerificationMethod: " + VerificationMethod);
					if (TestNGTestName.contains("V2-Pilot")) {
						/** Valid VerificationMethod */
						CommonMethod.negativesoftassertFieldValid(
								data.getCellData(SheetName, "VerificationMethod", rowNum), VerificationMethod,
								"Verification Method doesn't match");
					} else {
						CommonMethod.negativesoftassertFieldValid(FeatureVerificationNameV2, VerificationMethod,
								"Verification Method doesn't match");
					}
					testlog.info("Then User verifies verification Method");
					/** Valid DocumentType */
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardDocumentType"),
							data.getCellData(SheetName, "DocumentType", rowNum), "Document Type doesn't match");
					testlog.info("DocumentType: " + CommonMethod.getText("PortfolioScorecardDocumentType"));
					testlog.info("And User verifies DocumentType");
					/** Valid FeatureName */
					CommonMethod.WaitUntilPresence("PortfolioScorecardUploadFeatureName", 60);
					CommonMethod.negativesoftassertFieldValid(
							CommonMethod.getText("PortfolioScorecardUploadFeatureName"),
							data.getCellData(SheetName, "FeatureName", rowNum), "Feature Name doesn't match");
					testlog.info("FeatureName: " + CommonMethod.getText("PortfolioScorecardUploadFeatureName"));
					testlog.info("And User verifies PartName");
					/** Valid PartName */
					CommonMethod.WaitUntilPresence("PortfolioScorecardUploadPartName", 60);
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardUploadPartName"),
							data.getCellData(SheetName, "PartName", rowNum), "PartName doesn't match");
					testlog.info("PartName: " + CommonMethod.getText("PortfolioScorecardUploadPartName"));
					testlog.info("And User verifies PartNo.");
					/** Valid SpaceType */
					CommonMethod.WaitUntilPresence("PortfolioScorecardUploadSpaceType", 60);
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardUploadSpaceType"),
							data.getCellData(SheetName, "SpaceType", rowNum), "SpaceType doesn't match");
					testlog.info("SpaceType: " + CommonMethod.getText("PortfolioScorecardUploadSpaceType"));
					testlog.info("And User verifies SpaceType");
					if (TestNGTestName.contains("V2-Pilot")) {
						/** Valid V2 OptionName */
						CommonMethod.WaitUntilPresence("PortfolioScorecardUploadOptionName", 60);
						CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardOptionv2p"),
								"Option 1:", "OptionName doesn't match");
						testlog.info("OptionName: " + CommonMethod.getText("PortfolioScorecardUploadOptionName"));
						testlog.info("And User verifies OptionName");
					} else {
						/** Valid V2 OptionName */
						CommonMethod.WaitUntilPresence("PortfolioScorecardUploadOptionName", 60);
						CommonMethod.negativesoftassertFieldValid(
								CommonMethod.getText("PortfolioScorecardUploadOptionName"),
								data.getCellData(SheetName, "OptionName", rowNum), "OptionName doesn't match");
						testlog.info("OptionName: " + CommonMethod.getText("PortfolioScorecardUploadOptionName"));
						testlog.info("And User verifies OptionName");
					}

					CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
					CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 60);
					testlog.info("And User verifies Option to Add multiple parts button");
					CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 60);
					CommonMethod.assertisElementPresentTrue("PortfolioScoreCardVerificationUploadAddfeature",
							"Add feature parts is not visible");
					testlog.info("And User verifies Add feature parts option");
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
							"PortfolioScoreCardVerificationSelectFeature");
					testlog.info("And User clicks on Add feature");
					CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature",
							data.getCellData(SheetName, "AddPartOption", rowNum));
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
							"PortfolioScoreCardVerificationUploadAddfeature");
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
							"PortfolioScoreVerifyUploadVerificationMethod");
					/** Valid Added part remove link */
					CommonMethod.scrolldowntoElement("PortfolioScoreVerifyUploadVerificationMethod");
					CommonMethod.WaitUntilPresence("PortfolioScorecardUploadRemovelink", 60);
					CommonMethod.Robustclick("PortfolioScorecardUploadRemovelink");
					CommonMethod
							.WaitUntilNumberOfElementToBeNotPresentWithException("PortfolioScorecardUploadRemovelink");
					testlog.info("And User clicks on Add feature Removelink");
					CommonMethod.assertisNotElementPresent("PortfolioScorecardUploadRemovelink",
							"Removelink is visible");
					CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
					CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FeaturefileUpload,
							"PortfolioScorecardUploadRemoveLink");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndContinuebtn", 0);
					CommonMethod.assertisElementPresentTrue("SaveAndContinuebtn", "Upload button is not visible");
					testlog.info("And User verifies Enable Upload button");
					CommonMethod.Robustclick("PortfolioScorecardUploadRemoveLink");
					testlog.info("And User clicks on Upload Remove icon");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndContinueDisablebtn", 0);
					CommonMethod.assertisElementPresentTrue("SaveAndContinueDisablebtn",
							"Upload button disable is not visible");
					testlog.info("And User verifies Upload button disable");
				}

				if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_01_02_MeetThresholdsforOrganicGasesFeature")) {
					/*
					 * Valid FeatureName, DocumentType and VerificationMethod
					 */
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadFeatureName", 0);
					CommonMethod.negativesoftassertFieldValid(
							CommonMethod.getText("PortfolioScorecardUploadFeatureName"),
							"Meet Thresholds for Organic Gases", "Feature Name doesn't match");
					testlog.info("FeatureName: " + CommonMethod.getText("PortfolioScorecardUploadFeatureName"));
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardDocumentType"),
							"Feature verification", "Document Type doesn't match");
					testlog.info("DocumentType: " + CommonMethod.getText("PortfolioScorecardDocumentType"));
					String VerificationMethod = CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod");
					testlog.info("VerificationMethod: " + VerificationMethod);
					/*
					 * Adding part A05.2
					 */
					if (VerificationMethod.equalsIgnoreCase("Performance Test")) {
						CommonMethod.negativesoftassertFieldValid(VerificationMethod, "Performance Test",
								"Verification Method doesn't match");
						testlog.info("**Verifies Verification Method successful**");
						CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
						CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadAddfeature", 0);
						CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
								"PortfolioScoreCardVerificationSelectFeature");
						CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", "A05.2");
						CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddPart", 0);
						CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
								"PortfolioScoreCardVerificationSelectFeature");
						CommonMethod.Robustclick("PortfolioScoreCardVerificationUploadAddfeature",
								"PortfolioScoreCardVerificationSelectFeature");
						/*
						 * Valid Added part remove link
						 */
						CommonMethod.scrolldowntoElement("PortfolioScoreVerifyUploadVerificationMethod");
						CommonMethod.WaitUntilVisibility("PortfolioScorecardUploadRemovelink", 60);
						testlog.info("**Verifies Remove link in Upload Feature successful**");
					}
				}

				if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_03_06_AuditScorecardUpload")) {
					/** Valid VerificationMethod */
					CommonMethod.negativesoftassertFieldValid(
							CommonMethod.getText("PortfolioScoreVerifyUploadVerificationMethod"),
							data.getCellData(SheetName, "AuditVerificationMethod", rowNum),
							"Verification Method doesn't match");
					testlog.info("Then User verifies verification Method");
					/** Valid DocumentType */
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardDocumentType"),
							data.getCellData(SheetName, "AuditDocumentType", rowNum), "Document Type doesn't match");
					testlog.info("DocumentType: " + CommonMethod.getText("PortfolioScorecardDocumentType"));
					testlog.info("And User verifies DocumentType");
					/** Valid FeatureName */
					CommonMethod.WaitUntilPresence("PortfolioScorecardUploadFeatureName", 60);
					CommonMethod.negativesoftassertFieldValid(
							CommonMethod.getText("PortfolioScorecardUploadFeatureName"),
							data.getCellData(SheetName, "AuditName", rowNum), "Audit Name doesn't match");
					testlog.info("FeatureName: " + CommonMethod.getText("PortfolioScorecardUploadFeatureName"));
					testlog.info("And User verifies FeatureName");
					/** Valid PartName */
					CommonMethod.WaitUntilPresence("PortfolioScorecardUploadPartName", 60);
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardUploadPartName"),
							data.getCellData(SheetName, "AuditPartName", rowNum), "PartName doesn't match");
					testlog.info("PartName: " + CommonMethod.getText("PortfolioScorecardUploadPartName"));
					testlog.info("And User verifies PartName");
					/** Valid SpaceType */
					CommonMethod.WaitUntilPresence("PortfolioScorecardUploadSpaceType", 60);
					CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardUploadSpaceType"),
							data.getCellData(SheetName, "AuditSpaceType", rowNum), "SpaceType doesn't match");
					testlog.info("SpaceType: " + CommonMethod.getText("PortfolioScorecardUploadSpaceType"));
					testlog.info("And User verifies SpaceType");
					if (TestNGTestName.contains("V2-Pilot")) {
						/** Valid V2 OptionName */
						CommonMethod.WaitUntilPresence("PortfolioScorecardUploadOptionName", 60);
						CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("PortfolioScorecardOptionv2p"),
								"Option 1:", "OptionName doesn't match");
						testlog.info("OptionName: " + CommonMethod.getText("PortfolioScorecardUploadOptionName"));
						testlog.info("And User verifies OptionName");
					} else {
						/** Valid V2 OptionName */
						CommonMethod.WaitUntilPresence("PortfolioScorecardUploadOptionName", 60);
						CommonMethod.negativesoftassertFieldValid(
								CommonMethod.getText("PortfolioScorecardUploadOptionName"),
								data.getCellData(SheetName, "AuditOptionName", rowNum), "OptionName doesn't match");
						testlog.info("OptionName: " + CommonMethod.getText("PortfolioScorecardUploadOptionName"));
						testlog.info("And User verifies OptionName");
					}
					CommonMethod.assertisNotElementPresent("PortfolioScoreCardVerificationUploadAddfeature",
							"Addfeature element is present");
					testlog.info("And User verifies Add feature shouldn't Present");
					CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
				}

				if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_03_07_AlternativeScorecardUpload")) {
					CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 180);
					CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
							"PortfolioScoreCardVerificationSelectFeature");
					testlog.info("And User clicks on Add feature");
					CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
					CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature",
							data.getCellData(SheetName, "AlternativeFeaturePartName", rowNum));
					int OptionSize = CommonMethod.getdropdownSize("PortfolioScorecardOptionInAddFeature");
					CommonMethod.negativesoftassertFieldValid(String.valueOf(OptionSize), "5",
							"Option count in Muliple Parts doesn't match");
					testlog.info("Then User verifies Option count in Add Feature");
					CommonMethod.selectdropdownrandom("PortfolioScorecardOptionInAddFeature");
					testlog.info("And User select Option");
					CommonMethod.assertisNotElementPresent("PortfolioScorecardSpaceInAddFeature",
							"Space type field shouldn't Present");
					testlog.info("And User verifies Space type field shouldn't visible");
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
							"PortfolioScoreCardVerificationUploadAddfeature");
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
							"PortfolioScoreCardVerificationAddNote");
					CommonMethod.assertisNotElementPresent("PortfolioScorecardUploadFeatureRemove",
							"Add Part link shouldn't Present");
					testlog.info("And User verifies Added feature link");
				}
			}

			if (PartNameRequired) {
				String partId = null;
				if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_01_01_MeetThresholdsforParticulateMatter")) {
					partId = "A01.3";
				}
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationUploadAddfeature", 60);
				CommonMethod.scrolldowntoElement("PortfolioScorecardUploadOptionName");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationSelectFeature");
				testlog.info("And User clicks on Add feature");

				CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", partId);
				if (CommonMethod.isElementsExist("PortfolioScoreCardVerificationSelectSpaceType", 5)) {
					CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectSpaceType");
				}
				if (CommonMethod.isElementsExist("PortfolioScoreCardVerificationSelectOption", 5)) {
					CommonMethod.selectdropdownrandom("PortfolioScoreCardVerificationSelectOption");
				}
				CommonMethod.WaitUntilPresence("PortfolioScoreCardVerificationAddPart", 60);
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationAddPart",
						"PortfolioScoreCardVerificationUploadAddfeature");
				CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
						"PortfolioScoreCardVerificationAddNote");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadRemovelink", 0);
				testlog.info("And User verifies Removelink should be visible");
			}
			// CommonPieceforuploadfile
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUpload", 0);
			CommonMethod.uploadFile("PortfolioScoreCardVerificationUpload", FileName, "UploadFileVerifyScorecard");
			testlog.info("And User Upload Feature Document");

			if (NoteRequired) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAddNote", 0);
				CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote",
						data.getCellData(SheetName, "NoteComment", rowNum));
				testlog.info("And User enter data to AddNote field");
			}

			if (IntentCheckboxRequired) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScorecardVerifyTaskUploadIntentStage", 0);
				CommonMethod.ClickCheckbox("PortfolioScorecardVerifyTaskUploadIntentStage");
				CommonMethod.VerifyRadioOrCheckboxSelcted("PortfolioScorecardVerifyTaskUploadIntentStage");
				testlog.info("And User verifies IntentStage checkbox is checked");
			}

			rc.ScorecardUploadSaveButton();
			break;

		case "SingleAsset":

			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectscorecardDocbtn", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectscorecardDocbtn",
					"V2Projectscorecardverificationdropdown");
			testlog.info("And User clicks on Document Plus icon");
			testlog.info("TaskName : Performance Test OR Sensor Data");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2Projectscorecardverificationdropdown", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2Projectscorecarddocupload", 0);
			CommonMethod.uploadFile("V2Projectscorecarddocupload", FileName, "UploadFileVerifyScorecard");
			testlog.info("And User upload scorecard Document");

			if (FileName.contains("Audit")) {
				if (TestNGTestName.contains("V2-Pilot")) {
					CommonMethod.selectdropdownVisibletext("V2Projectscorecardverificationdropdown",
							"On-site Photographs");
				} else {
					CommonMethod.selectdropdownVisibletext("V2Projectscorecardverificationdropdown",
							"Technical Document (Audited)");
				}

			} else {
				CommonMethod.selectdropdownrandom("V2Projectscorecardverificationdropdown");
			}

			testlog.info("And User select the Verification");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2Projectscorecarddocuploadsubmit", 0);
			CommonMethod.RobustclickElementVisible("V2Projectscorecarddocuploadsubmit",
					"V2ProjectscorecardVerifyUploadDoc");
			testlog.info("And User clicks on Submit button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectscorecardVerifyUploadDoc", 0);
			testlog.info("Then User verifies upload scorecard document");
			break;
		}
	}

	public void uploadModalCompleteGeneric(String SheetName, int rowNum, String Commodity, String FileName,
			Boolean PartNameRequired, Boolean VerificationMethodValidationRequired, Boolean NoteRequired,
			Boolean IntentCheckboxRequired) throws Exception {

		uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
				VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);

		switch (Commodity) {

		case "Ratings":

			if (FileName.contains("Audit")) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
			}
			rc.ScorecardConfirmLocUploadSaveButton();
			testlog.info("And User clicks on save button");
			break;

		case "Portfolio":

			if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_01_01_MeetThresholdsforParticulateMatter")) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
				testlog.info("And User checks the AssignLocation checkbox");
			}

			if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_01_01_MeetThresholdsforOrganicGasesFeature")) {
				CommonMethod.declickListWebelementFromIndex("PortfolioScoreCardVerificationAssignLocCbxGeneral", 2);
			}

			if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_01_03_MeetEnhancedThresholdsforOrganicGases")) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignChildLocCbx", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationAssignLocCbx",
						"PortfolioScorecardValidDisable");
				testlog.info("And User checks the AssignLoccation checkbox");
			}

			rc.ScorecardConfirmLocUploadSaveButton();
			rc.uploadDocumentToastMessage();
			testlog.info("And User verifies Upload Document Successful Toast Message");
			break;
		}

	}

	public void validateUploadedDocumentTableGeneric(String SheetName, int rowNum, String Commodity,
			Boolean FileNameRequired, Boolean PartIdRequired, Boolean LocationCountRequired,
			Boolean VerificationMethodValidationRequired, Boolean StageRequired, Boolean StatusRequired,
			Boolean DeleteEditIconRequired, Boolean StageIntentRequired) throws Exception {

		switch (Commodity) {
		case "Ratings":

			break;

		case "Portfolio":
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
			testlog.info("And User will be redirected to Document Upload Table page");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableTr", 0);
			List<String> Tableval = CommonMethod.fetchTableData(PortfolioAndRatingLocAccDocumentTable);
			testlog.info("Fetching Data from Upload Table");

			if (FileNameRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(0), pathprms.get("fileName").toString(),
						"fileName in Document table data mismatch");
			}

			if (LocationCountRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(1), pathprms.get("LocationCount").toString(),
						"Assign Location in Document table data mismatch");
			}

			if (PartIdRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(2), pathprms.get("PartId").toString(),
						"PartId in Document table data mismatch");
			}

			if (VerificationMethodValidationRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(3),
						pathprms.get("VerificationMethod").toString(),
						"verificationMethod in Document table data mismatch");
			}

			if (StageRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(4), pathprms.get("Stage").toString(),
						"Stage in Document table data mismatch");
			}

			if (StageIntentRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(4), pathprms.get("StageIntent").toString(),
						"StageIntent in Document table data mismatch");
			}

			if (StatusRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(5), pathprms.get("Status").toString(),
						"Status Document table data mismatch");
			}

			if (DeleteEditIconRequired) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
				CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioAndRatingLocAccDocumentTableEditIcon", 0);
				testlog.info("And User verifies Edit Icon in Document table");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioAndRatingLocAccDocumentTableDeleteIcon", 0);
				testlog.info("And User verifies Delete Icon in Document table");
			}

			break;
		}
	}

	public void validateUploadedDocumentTableOptnGeneric(String SheetName, int rowNum, String Commodity,
			Boolean FileNameRequired, Boolean PartIdRequired, Boolean VerificationMethodValidationRequired,
			Boolean StageRequired, Boolean StatusRequired, Boolean DeleteEditIconRequired) throws Exception {

		switch (Commodity) {
		case "Ratings":

			break;

		case "Portfolio":
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
			testlog.info("And User will be redirected to Document Upload Table page");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableTr", 0);
			List<String> Tableval = CommonMethod.fetchTableData(PortfolioAndRatingLocAccDocumentTable);
			testlog.info("Fetching Data from Upload Table");

			if (FileNameRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(0), pathprms.get("fileName").toString(),
						"fileName in Document table data mismatch");
			}

			if (PartIdRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(1), pathprms.get("PartId").toString(),
						"PartId in Document table data mismatch");
			}

			if (VerificationMethodValidationRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(2),
						pathprms.get("VerificationMethod").toString(),
						"verificationMethod in Document table data mismatch");
			}

			if (StageRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(3), pathprms.get("Stage").toString(),
						"Stage in Document table data mismatch");
			}

			if (StatusRequired) {
				CommonMethod.negativesoftassertFieldValid(Tableval.get(4), pathprms.get("Status").toString(),
						"Status Document table data mismatch");
			}

			if (DeleteEditIconRequired) {

				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
				CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioAndRatingLocAccDocumentTableEditIcon", 0);
				testlog.info("And User verifies Edit Icon in Document table");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioAndRatingLocAccDocumentTableDeleteIcon", 0);
				testlog.info("And User verifies Delete Icon in Document table");
			}
			pathprms.clear();
			break;
		}
	}

	public void assignLocationGeneric(String Commodity, Boolean AssignFiveLocationRequired,
			Boolean AssignFifteenLocationRequired, Boolean AssignMultipleLocationRequired,
			Boolean AssignInputLocationRequired, Boolean AssignTwentyLocationRequired) throws Exception {
		if (AssignFiveLocationRequired) {
			/** Assign 5 Location */
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Assignbutton", 0);
			Thread.sleep(1000);
			CommonMethod.JavascriptClickElement("Assignbutton");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocationTableTr", 0);
			CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
			CommonMethod.Robustclick("WPRAssignLocCbx", "WPRAssignDisabledbtn");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignSavebtn", 0);
			CommonMethod.Robustclick("WPRAssignSavebtn");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
			CommonMethod.Robustclick("AssignLocCloseIcon");
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
		}

		if (AssignFifteenLocationRequired) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Assignbutton", 0);
			/** Assign 15 Location */
			CommonMethod.RobustclickElementVisible("WPRAssignLocbtn",
					"PortfolioScoreCardVerificationAssignChildLocCbx");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocationTableTr", 0);
			CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignChildLocCbx",
					0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
					"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
			CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1, 11);
			CommonMethod.WaitUntilPresence(PortfolioScoreCardVerificationAssignLocSavebtn, 60);
			CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
			CommonMethod.Robustclick("AssignLocCloseIcon");
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
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioScoreCardVerificationAssignLocSavebtn, 0);
			CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
			CommonMethod.Robustclick("AssignLocCloseIcon");
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
			testlog.info("And User clicks on Assign Button");
			testlog.info("And User check Assign location checkboxes");
		}

		if (AssignMultipleLocationRequired) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignbtn", 0);
			Thread.sleep(1000);
			/** Assign all the task with Assign 5 Location */
			List<WebElement> AssignButton;
			AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
			for (WebElement assignButton : AssignButton) {
				Thread.sleep(2000);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignbtn", 0);
				CommonMethod.JavascriptClickElement(assignButton);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocationTableTr", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
				CommonMethod.Robustclick("WPRAssignLocCbx", "WPRAssignDisabledbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioScoreCardVerificationAssignLocSavebtn,
						0);
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
			}
		}

		if (AssignInputLocationRequired) {
			/** Assign Location with index input */
			List<WebElement> AssignButton;
			AssignButton = CommonMethod.findElements("PortfolioScoreCardVerificationAssignbtn");
			for (WebElement f : AssignButton) {
				CommonMethod.WaitUntilClickble(f, 30).click();
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocationTableTr", 0);
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
						"PortfolioScoreCardVerificationAssignChildLocCbx", 0);
				CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral",
						Integer.parseInt(pathprms.get("StartAssignLoc").toString()),
						Integer.parseInt(pathprms.get("EndAssignLoc").toString()));
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioScoreCardVerificationAssignLocSavebtn, 0);
				CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
			}
		}
		
		if (AssignTwentyLocationRequired) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Assignbutton", 0);
			/** Assign 15 Location */
			CommonMethod.RobustclickElementVisible("WPRAssignLocbtn",
					"PortfolioScoreCardVerificationAssignChildLocCbx");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocationTableTr", 0);
			CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AssignLocationLoading");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationAssignChildLocCbx",
					0);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
					"PortfolioScoreCardVerificationAssignLocCbxGeneral", 0);
			CommonMethod.clickListWebelementFromRange("PortfolioScoreCardVerificationAssignLocCbxGeneral", 1, 11);
			CommonMethod.WaitUntilPresence(PortfolioScoreCardVerificationAssignLocSavebtn, 60);
			CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
			CommonMethod.Robustclick("AssignLocCloseIcon");
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
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioScoreCardVerificationAssignLocSavebtn, 0);
			CommonMethod.Robustclick(PortfolioScoreCardVerificationAssignLocSavebtn);
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
			CommonMethod.Robustclick("AssignLocCloseIcon");
			testlog.info("And User clicks on Assign Button");
			testlog.info("And User check Assign location checkboxes");
		}
		pathprms.clear();
	}
	
	public void importLocationGeneric(String Commodity, String ImportFileName) throws Exception {
		testlog.info("Given User is on Dashboard page");
		System.out.println("ImportFileName: "+ ImportFileName);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationsTab", 0);
		CommonMethod.RobustclickElementVisible("LocationsTab", "PortfolioLocationLanding");
		testlog.info("When User clicks on LocationsTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationLanding", 0);
		if (TestCaseName.equalsIgnoreCase("Healthsafety_TC_20_04_ArchieveAddedAndImportedLocations") || TestCaseName.equalsIgnoreCase("Performance_TC_22_03_ArchieveAddedAndImportedLocations")) {
		CommonMethod.refreshBrowser();
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationsImportButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioLocationsImportButton", "PortfolioUploadLocationButton");
		if (Commodity.equalsIgnoreCase("Portfolio")) {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationSelectCard", 0);
		CommonMethod.RobustclickElementVisible("LocationSelectCard", "PortfolioUploadFileNextButton");
		testlog.info("And User clicks on Import Button");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadLocationButton", 0);
		CommonMethod.scrolldowntoElement("PortfolioUploadLocationButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadLocationButton", 0);
     	CommonMethod.uploadFile("PortfolioUploadLocationButton", ImportFileName,"UploadFileVerifyScorecard");
     	
		testlog.info("And User upload Excel Location List Document");
		if (Commodity.equalsIgnoreCase("Portfolio")) {
			if (CommonMethod.isElementsExist("PortfolioUploadFileNextButton", 5)) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadFileNextButton", 0);
				CommonMethod.click("PortfolioUploadFileNextButton");
			}
			if (CommonMethod.isElementsExist("PortfolioUnmatchFieldcbx", 10)) {
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUnmatchFieldcbx", 0);
				CommonMethod.ClickCheckbox("PortfolioUnmatchFieldcbx");
				testlog.info("And User checks the Unmatch checkbox");
			}
		}
		if (CommonMethod.isElementsExist("PortfolioUploadFileNextButton", 5)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioUploadFileNextButton", 0);
			CommonMethod.RobustclickElementVisible("PortfolioUploadFileNextButton", "PortfolioFinishImportButton");
		}
		testlog.info("And User clicks on Next Button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioFinishImportButton", 0);
		testlog.info("And User clicks on Finish Button");
		CommonMethod.RobustclickElementVisible("PortfolioFinishImportButton", "PortfolioImportCloseButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioImportCloseButton", 0);
		CommonMethod.RobustclickElementVisible("PortfolioImportCloseButton", "PortfolioLocationLanding");
		testlog.info("And User clicks on Close Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationLanding", 0);
		testlog.info("Then User will be redirected to Location list page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		testlog.info("And User verifies Location list Table and location count");
		testlog.pass("**Imported Locations successfully**");
	}
}