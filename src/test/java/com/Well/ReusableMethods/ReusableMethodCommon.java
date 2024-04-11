package com.Well.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.zaproxy.clientapi.core.ClientApiException;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;
import com.Well.Engine.XlsReader;

public class ReusableMethodCommon extends BaseClass {

	String PortfolioAndRatingLocAccDocumentTable = "PortfolioAndRatingLocAccDocumentTable";
	String PortfolioAndRatingLocAccDocumentTableTr = "PortfolioAndRatingLocAccDocumentTableTr";
	String PortfolioAndRatingLocAccDocumentTableDeleteIcon = "PortfolioAndRatingLocAccDocumentTableDeleteIcon";

//	public void SignOut() throws InterruptedException, IOException, ClientApiException {
//		driver.quit();
//		setup(BrowserName, Environment, securtiyTest, ModuleName);
//		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Username", 0);
//		
//	}
	public void SignOut() throws InterruptedException, IOException, ClientApiException {
		
		CommonMethod.switchToParentTab();
		driver.switchTo().newWindow(WindowType.TAB);
		CommonMethod.switchToParentTabWithoutClose();
		Thread.sleep(2000);
		driver.close();
		CommonMethod.switchToParentTabWithoutClose();
		Thread.sleep(1000);
		if (Environment.equalsIgnoreCase("Test")) {
			driver.get("https://test-nuxt.wellcertified.com/logout");
		} else if (Environment.equalsIgnoreCase("QAS")) {
			driver.get("https://qas-nuxt.wellcertified.com/logout");
		} else if (Environment.equalsIgnoreCase("STG")) {
			driver.get("https://stg-nuxt.wellcertified.com/logout");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Username", 0);
	}

//	public void SignOut() throws InterruptedException, IOException {
//
//		if (Environment.equalsIgnoreCase("Test")) {
//			driver.get("https://test-nuxt.wellcertified.com/logout");
//		} else if (Environment.equalsIgnoreCase("QAS")) {
//			driver.get("https://qas-nuxt.wellcertified.com/logout");ds
//		} else if (Environment.equalsIgnoreCase("STG")) {
//			driver.get("https://stg-nuxt.wellcertified.com/logout");
//		}
//		Thread.sleep(3000);
//		CommonMethod.WaitUntilPresence("Username", 180);
//	}

	public void SelectCountryAndState(String Country, String SheetName, int rowNum)
			throws IOException, InterruptedException {
		CommonMethod.selectdropdownValue("ProjectlocationCountry", Country);
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownValue("ProjectlocationCountry"));
		CommonMethod.selectdropdownrandom("ProjectlocationState");
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("ProjectlocationState"));
		testlog.info("Country: " + data.getCellData(SheetName, "Country", rowNum));
		testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
	}

	public void SelectOwnerOrg(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 30);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick", "OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 30);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 5).click();
	}

	public void SelectEnterpriseProviders(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectEnterpriseProviders", 0);
		CommonMethod.selectdropdownVisibletext("V2ProjectEnterpriseProviders",
				data.getCellData(SheetName, "EnterpriseProvidersName", rowNum));
		data.setCellData(SheetName, "EnterpriseProvidersName", rowNum,
				CommonMethod.getSelectedDropdownValue("V2ProjectEnterpriseProviders"));
		testlog.info("And User select EnterpriseProviders");
	}

	public void Billing(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("BillingLanding", 0);
		testlog.info("And User redirects to Invoice page");
		CommonMethod.scrolldowntoElement("CardHolderName");
		CommonMethod.WaitUntilClickble("CardHolderName", 60);
		CommonMethod.sendKeys("CardHolderName", USfaker.address().firstName());
		data.setCellData(SheetName, "CardHolderName", rowNum, CommonMethod.getattributeValue("CardHolderName"));
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardNumberIframe");
		CommonMethod.WaitUntilClickble("CardHolderNumber", 60);
		Thread.sleep(2000);
		CommonMethod.sendKeys("CardHolderNumber", data.getCellData(SheetName, "CardNumber", rowNum));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardExpDateIframe");
		CommonMethod.WaitUntilClickble("CardHolderExpDate", 60).sendKeys("0");
		CommonMethod.sendKeys("CardHolderExpDate", "9");
		CommonMethod.sendKeys("CardHolderExpDate", "2");
		CommonMethod.sendKeys("CardHolderExpDate", "5");
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		CommonMethod.switchToFrame("CardCVVIframe");
		CommonMethod.WaitUntilClickble("CardHolderCVC", 60);
		CommonMethod.sendKeys("CardHolderCVC", data.getCellData(SheetName, "CardCVC", rowNum));
		CommonMethod.switchToParentFrame();
		Thread.sleep(2000);
		testlog.info("And User enters data to HolderName, CardNumber, ExpDate, CardCVC fields");
		testlog.info("firstName:" + USfaker.address().firstName());
		testlog.info("CardHolderExpDate:" + "0925");
		testlog.info("CardHolderNumber:" + "4111111111111111");
		testlog.info("CardHolderCVC:" + "999");
		CommonMethod.WaitUntilClickble("PayNowButton", 10);
		CommonMethod.click("PayNowButton");
		testlog.info("And User clicks on pay now button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("CardHolderName", 1);
		testlog.pass("**Verifies the Completed Card Payment Billing successfully**");
	}

	public void UpdateBilling(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("BillingLanding", 0);
		testlog.info("And User redirects to Invoice page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UpdateInvoiceButtonBillingUpdate", 0);
		CommonMethod.RobustclickElementVisible("UpdateInvoiceButtonBillingUpdate", "PaymentStatusBillingUpdate");
		testlog.info("Given User is on Update Invoice page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PaymentStatusBillingUpdate", 0);
		testlog.info("Then User verifies added data in Invoice page");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("UpdateInvoiceOwnerNameBilling"),
				data.getCellData(SheetName, "OwnerName", rowNum), "OwnerName Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("UpdateInvoiceEmailBilling"),
				"frontendauthenticated", "Email Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("UpdateInvoiceCountryBilling"),
				data.getCellData(SheetName, "OwnerCountry", rowNum), "OwnerCountry Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("UpdateInvoiceStreetBilling"),
				data.getCellData(SheetName, "OwnerStreet", rowNum), "StreetName Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("UpdateInvoiceCityBilling"),
				data.getCellData(SheetName, "OwnerCity", rowNum), "CityName Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("UpdateInvoicePostalCodeBilling"),
				data.getCellData(SheetName, "OwnerPostalCode", rowNum), "CityName Error Mismatch");
		CommonMethod.selectdropdownVisibletext("PaymentStatusBillingUpdate",
				data.getCellData(SheetName, "PaymentStatus", rowNum));
		testlog.info("And User select Payment Status");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PaymentTypeBillingUpdate", 0);
		CommonMethod.selectdropdownVisibletext("PaymentTypeBillingUpdate",
				data.getCellData(SheetName, "PaymentTypes", rowNum));
		testlog.info("And User select Payment Type");
		CommonMethod.sendKeys("PaymentReferenceBillingUpdate", "01");
		testlog.info("And User enter data to Payment Reference field");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PaymentDateBillingUpdate", 0);
		CommonMethod.RobustclickElementVisible("PaymentDateBillingUpdate", "DatePickerOkButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DatePickerOkButton", 0);
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "UpdateInvoiceButtonBillingUpdate");
		testlog.info("And User select Date");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UpdateInvoiceButtonBillingUpdate", 0);
		CommonMethod.RobustclickElementVisible("UpdateInvoiceButtonBillingUpdate", "UpdateInvoiceBackButtonBilling");
		testlog.info("And User clicks on Update button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PaidStatus", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UpdateInvoiceBackButtonBilling", 0);
		CommonMethod.RobustclickElementVisible("UpdateInvoiceBackButtonBilling", "PaidStatus");
		testlog.info("And User verifies Paid Status in Receipt");
		testlog.pass("**Verifies the Updated Payment successful**");
	}

	public void CreateSubset(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given user is on the location page");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.RobustclickElementVisible("AddButton", "AddLocationButton");
		testlog.info("when User clicks on Add Button");
		CommonMethod.WaitUntilPresence("AddLocationButton", 120);
		if (SheetName.equalsIgnoreCase("Wpr") || SheetName.equalsIgnoreCase("Hsr")
				|| SheetName.equalsIgnoreCase("Wer")) {
			CommonMethod.RobustclickElementVisible("CreateSubsetButton", "SubmitSubsetButton");
			testlog.info("And User clicks on Create subset Button");
		} else {
			CommonMethod.RobustclickElementVisible("PortfolioSubsetButton", "SubmitSubsetButton");
			testlog.info("And User clicks on Create subset Button");
		}
		CommonMethod.click("SubmitSubsetButton");
		CommonMethod.negativesoftassertPageSource("Title is required.", "Title Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Description is required.", "Description Error Mismatch");
		testlog.info("And User verify Ownershiptype filter");
		CommonMethod.RobustclickElementVisible("Ownershiptypefilter", "OwnershipCheckbox");
		testlog.info("And User clicks on Ownershiptype filter");
		CommonMethod.ClickCheckbox("OwnershipCheckbox");
		testlog.info("And User clicks on cics checkbox");
		CommonMethod.WaitUntilPresence("Verifycheckboxfilter", 60);
		testlog.info("then User verify Ownershiptype filter");
		CommonMethod.ClickCheckbox("SelectAllprojectscheck");
		testlog.info("And User clicks on select all project checkbox");
		CommonMethod.VerifyRadioOrCheckboxSelcted("SelectAllprojectscheck");
		testlog.info("And User verify select all project checkbox is checked");
		CommonMethod.sendKeys("AddTitlefield", "Test subset");
		testlog.info("when User Enter the substet title");
		CommonMethod.sendKeys("AddDescriptionfield", "Testing subset creation");
		testlog.info("And User Enter the substet discription");
		CommonMethod.RobustclickElementVisible("SubmitSubsetButton", "Subsettab");
		testlog.info("And User clicks on the submit button");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationRefresh", 0);
		CommonMethod.RobustclickElementVisible("LocationRefresh", "LocationResultCount");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Subsettab", 0);
		CommonMethod.RobustclickElementVisible("Subsettab", "table");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationRefresSubset", 0);
		CommonMethod.RobustclickElementVisible("LocationRefresSubset", "table");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationSubsetValid", 0);
		List<String> tableheaders = CommonMethod.fetchTableHeaders("table");
		CommonMethod.negativesoftassertFieldValid(tableheaders.get(1), "TEST SUBSET",
				"Table Header for TEST SUBSET doesn't present");
		testlog.pass("user verifies the table header as subset name");
		testlog.info("And User verifies the subset successfully");
		testlog.pass("And User verifies the subset creation functionality successfully");

	}

	public void clickOnAlternatives(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AlternativesTab", 0);
		CommonMethod.RobustclickElementVisible("AlternativesTab", "V2ProjectEPSubmitButton");
		testlog.info("And User clicks on AlternativesTab");
	}

	public void alternativesAAP(String SheetName, int rowNum, String optModuleName)
			throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAapSubmitButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAapSubmitButton", "V2ProjectFeatureDropdown");
		testlog.info("And User clicks on AAPSubmit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubmitButton", 0);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectFeatureDropdown");
		CommonMethod.negativesoftassertPageSource("Feature* is required.", "Feature Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Reason for Alternative Means and Methods * is required.",
				"Reason for Alternative Error Mismatch");
		if (SheetName.equalsIgnoreCase("Portfolio")) {
			CommonMethod.negativesoftassertPageSource("Applicable part(s) * is required.",
					"Applicable part Error Mismatch");
		}
		CommonMethod.scrollUp();
		if (SheetName.equalsIgnoreCase("V2Project")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAlternativeVersionDropdown", 0);
			CommonMethod.selectdropdownValue("V2ProjectAlternativeVersionDropdown", optModuleName);
		}
		Thread.sleep(1000);
		CommonMethod.WaitUntilClickble("V2ProjectAlternativesReasonTextArea", 60)
				.sendKeys("Reason for Alternative Means and Methods");
		CommonMethod.negativesoftassertPageSource("Proposed Alternative Means of Compliance * is required.",
				"Proposed Alternative Means of Compliance Error Mismatch");
		CommonMethod.WaitUntilClickble("V2ProjectAlternativesProposedTextArea", 60)
				.sendKeys("Proposed Alternative Means of Compliance");
		CommonMethod.uploadMultipleFile("DocumentsUpload", SampleJpgfile, SampleJpgfile, "MultipeUploadDeleteicon", 2,
				"MultipeUploadEnableButtonDeleteLink");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectFeatureDropdown", 0);
		Thread.sleep(3000);
		CommonMethod.selectdropdownrandom("V2ProjectFeatureDropdown");
		if (CommonMethod.isElementsExist("V2ProjectApplicablePartCheckBox", 10)) {
			CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			testlog.info("And User checks the ApplicablePart checkbox");
		}
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		if (SheetName.equalsIgnoreCase("Community")) {

			CommonMethod.sendKeys("CommunityAlternativeAAPApplicableParts", "Applicable Part Text");
		}
		testlog.info("And User Upload Feature Document");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubmitButton", 0);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2projectAAPTypeStatus");
		testlog.info("And User clicks on Submit button");
		if (SheetName.equalsIgnoreCase("V2Project") || SheetName.equalsIgnoreCase("Community")) {
			CommonMethod.scrollUp();
			if (optModuleName.equalsIgnoreCase("v2-hsr")) {
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateHSR");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateHSR"),
						"WELL HEALTH-SAFETY", "WELL HEALTH-SAFETY doesn't match");
			}
			if (optModuleName.equalsIgnoreCase("wpr")) {
				String getId = CommonMethod.getattributeValueByTextContent("CommunityAlternativeID");
				String[] stringArray = getId.split("-");
				String getAlternativeID = stringArray[1].trim();
				data.setCellData(SheetName, "AlternativeAapID", rowNum, getAlternativeID);
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWPR");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateWPR"),
						"WELL PERFORMANCE", "WELL HEALTH-SAFETY doesn't match");
			}
			if (optModuleName.equalsIgnoreCase("wer")) {
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWER");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateWER"),
						"WELL EQUITY", "WELL HEALTH-SAFETY doesn't match");
			}
			if (optModuleName.equalsIgnoreCase("CommunityAAP")) {
				String getId = CommonMethod.getattributeValueByTextContent("CommunityAlternativeID");
				String[] stringArray = getId.split("-");
				String getCommunityAlternativeID = stringArray[1].trim();
				data.setCellData(SheetName, "CommunityAlternativeID", rowNum, getCommunityAlternativeID);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeType"), "AAP",
						"Table FEATURE TYPE doesn't match");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeStatus"), "PENDING",
						"Table FEATURE STATUS doesn't match");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeOwner"), "UI",
						"Table FEATURE OWNER name doesn't match");
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWER");
				CommonMethod.negativesoftassertisElementPresentFalse("V2ProjectAdminAlternativeEditButton",
						"Edit Button", "Edit button is visible for non-admin user");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeInsideStatus"),
						"Pending decision", "STATUS Pending decision doesn't match");
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getText("V2ProjectAdminAlternativeMeansCompliance"),
						"Proposed Alternative Means of Compliance", "Means of Compliance Text doesn't match");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeValidateWV1"),
						"WELL V1", "WELL V1 doesn't match");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeValidateImage1", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeValidateImage2", 0);
			}
			CommonMethod.RobustclickElementVisible("V2ProjectAlternativeBackButton", "V2ProjectAapSubmitButton");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectAAPTypeStatus", 0);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2projectAAPTypeStatus"), "AAP",
					"AAP Alternative doesn't match");
		}
		testlog.info("And User verifies the added details");
		testlog.info("And User verifies the Status");
		testlog.pass("**Added alternative AAP documents successfully**");
	}

	public void alternativesEP(String SheetName, int rowNum, String optModuleName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectEPSubmitButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectEPSubmitButton", "V2ProjectFeatureDropdown");
		testlog.info("And User clicks on EPSubmit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubmitButton", 0);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectFeatureDropdown");
		testlog.info("And User clicks on Submit button");
		CommonMethod.negativesoftassertPageSource("Feature* is required.", "Feature Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Reason for Equivalency Request * is required.",
				"Reason for Equivalency Error Mismatch");
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		CommonMethod.scrollUp();
		if (SheetName.equalsIgnoreCase("V2Project")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAlternativeVersionDropdown", 0);
			CommonMethod.selectdropdownValue("V2ProjectAlternativeVersionDropdown", optModuleName);
		}
		Thread.sleep(2000);
		CommonMethod.negativesoftassertPageSource(
				"Regions/Countries where Equivalency may be Applicable * is required.",
				"Regions/Countries Equivalency Error Mismatch");
		CommonMethod.WaitUntilClickble("V2ProjectEquivalencyReason", 60).sendKeys("Reason for Equivalency Request");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DocumentsUpload", 0);
		CommonMethod.uploadMultipleFile("DocumentsUpload", SampleJpgfile, SampleJpgfile, "MultipeUploadDeleteicon", 2,
				"MultipeUploadEnableButtonDeleteLink");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectFeatureDropdown", 0);
		CommonMethod.selectdropdownrandom("V2ProjectFeatureDropdown");
		testlog.info("And User select the Feature");
		data.setCellData(SheetName, "FeatureName", rowNum,
				CommonMethod.getSelectedDropdownValue("V2ProjectFeatureDropdown"));
		testlog.info("FeatureName: " + data.getCellData(SheetName, "FeatureName", rowNum));
		if (CommonMethod.isElementsExist("V2ProjectApplicablePartCheckBox", 10)) {
			CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			testlog.info("And User checks the ApplicablePart checkbox");
		}
		CommonMethod.WaitUntilClickble("V2ProjectEquivalencyCountriesInput", 60)
				.sendKeys("Regions/Countries where Equivalency may be Applicable");
		if (CommonMethod.isElementsExist("V2ProjectVerificationTextArea", 10)) {
			CommonMethod.negativesoftassertPageSource("Verification method within proposed equivalent * is required.",
					"Verification method within proposed equivalent Error Mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectVerificationTextArea", 0);
			CommonMethod.clearAndSendKey("V2ProjectVerificationTextArea",
					"Verification method within proposed equivalent");
			testlog.info("And User enter data to Verification field");
		}
		if (CommonMethod.isElementsExist("PortfolioVerificationTextArea", 10)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioVerificationTextArea", 0);
			CommonMethod.clearAndSendKey("PortfolioVerificationTextArea",
					"Verification method within proposed equivalent");
			testlog.info("And User enter data to Verification field");
		}
		if (CommonMethod.isElementsExist("V2ProjectSimilaritiesTextArea", 10)) {
			CommonMethod.negativesoftassertPageSource("Similarities to WELL feature requirement * is required.",
					"Similarities to WELL feature requirement Error Mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSimilaritiesTextArea", 0);
			CommonMethod.clearAndSendKey("V2ProjectSimilaritiesTextArea", "Similarities to WELL feature requirement");
			testlog.info("And User enter data to Similarities field");
		}
		if (CommonMethod.isElementsExist("PortfolioSimilaritiesTextArea", 10)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSimilaritiesTextArea", 0);
			CommonMethod.clearAndSendKey("PortfolioSimilaritiesTextArea", "Similarities to WELL feature requirement");
			testlog.info("And User enter data to Similarities field");
		}
		if (CommonMethod.isElementsExist("V2ProjectDifferencesTextArea", 10)) {
			CommonMethod.negativesoftassertPageSource("Differences from WELL feature requirement * is required.",
					"Differences from WELL feature Error Mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDifferencesTextArea", 0);
			CommonMethod.clearAndSendKey("V2ProjectDifferencesTextArea", "Differences from WELL feature requirement");
			testlog.info("And User enter data to Differences field");
		}
		if (CommonMethod.isElementsExist("PortfolioDifferencesTextArea", 10)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDifferencesTextArea", 0);
			CommonMethod.clearAndSendKey("PortfolioDifferencesTextArea", "Differences from WELL feature requirement");
			testlog.info("And User enter data to Differences field");
		}
		CommonMethod.negativesoftassertPageSource("Proposed Alternative Means of Compliance * is required.",
				"Proposed Alternative Means of Compliance Error Mismatch");
		CommonMethod.WaitUntilClickble("V2ProjectAlternativesProposedTextArea", 60)
				.sendKeys("Proposed Alternative Means of Compliance");
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		testlog.info("And User upload feature document");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubmitButton", 0);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2projectEPTypeStatus");
		testlog.info("And User clicks on Submit button");
		CommonMethod.scrollUp();
		if (SheetName.equalsIgnoreCase("V2Project")) {
			if (optModuleName.equalsIgnoreCase("v2-hsr")) {
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateHSR");
				System.out.println("HSR Value:" + CommonMethod.getText("V2ProjectAlternativeValidateHSR"));
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateHSR"),
						"WELL HEALTH-SAFETY", "WELL HEALTH-SAFETY doesn't match");
			}
			if (optModuleName.equalsIgnoreCase("wpr")) {
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWPR");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateWPR"),
						"WELL PERFORMANCE", "WELL PERFORMANCE doesn't match");
			}
			if (optModuleName.equalsIgnoreCase("wer")) {
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWER");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateWER"),
						"WELL EQUITY", "WELL EQUITY doesn't match");
			}
			CommonMethod.RobustclickElementVisible("V2ProjectAlternativeBackButton", "V2ProjectEPSubmitButton");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectEPTypeStatus", 0);
			CommonMethod.negativesoftassertFieldValid("V2projectEPTypeStatus", "EP", "EP Alternative doesn't match");
		}
		if (SheetName.equalsIgnoreCase("V2Pilot_Portfolio")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAlternative", 0);
			List<String> val = CommonMethod.fetchTableData("V2ProjectAlternative");
			CommonMethod.negativesoftassertFieldValid(val.get(6), "EP", "EP Alternative doesn't match");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectEPTypeStatus", 0);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2projectEPTypeStatus"), "EP",
					"EP Alternative doesn't match");
		}
		testlog.info("Then User verifies the added details");
		testlog.info("And User verifies the Status");
		testlog.pass("**Added alternative EP documents successfully**");
	}

	public void team(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddMemberbtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAddMemberbtn", "V2ProjectEmailAddress");
		testlog.info("And User clicks on Add member button");
		CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn", "V2ProjectEmailAddress");
		CommonMethod.negativesoftassertPageSource("Email Address is required.", "Email Address Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Permissions Level is required.", "Permissions Level Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Role is required.", "Project Role Error Mismatch");
		testlog.info(
				"And User clicks on Invite button without entering the mandatory fields and verifies error meassage");
		String TeamEmail = data.getCellData(SheetName, "TeamMemberEmail", rowNum);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectEmailAddress", 0);
		CommonMethod.sendKeys("V2ProjectEmailAddress", TeamEmail);
		testlog.info("And User enter email id field");
		testlog.info("Team Email ID: " + TeamEmail);
		CommonMethod.selectdropdownVisibletext("V2ProjectRole", "Acoustician");
		testlog.info("And User select the Role");
		CommonMethod.ClickCheckbox("V2ProjectMembercbx");
		testlog.info("And User checks the Member checkbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectInvitebtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn", "TeamMemberDeleteButton");
		testlog.info("And User clicks on Invite button");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("TeamMemberDeleteButton", 1);
		CommonMethod.assertisElementPresentTrue("TeamMemberDeleteButton", "Delete icon is not visible");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("TeamMemberEditButton", 1);
		CommonMethod.assertisElementPresentTrue("TeamMemberEditButton", "Edit icon is not visible");
		testlog.info("And User verifies Edit button icon");
		testlog.info("And User verifies Delete button icon");
		testlog.info("Then User will be redirected to Team list page");
		testlog.pass("**Created Team member successfully**");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("AddedTeamMemberValidation", 1);
		String AddedTeamMemberEmail = CommonMethod.getattributeValueByTextContent("AddedTeamMemberEmail");
		CommonMethod.negativesoftassertFieldValid(AddedTeamMemberEmail, TeamEmail,
				"Added TeamMember Email doesn't match");
		testlog.info("And User verifies Team member email");
		String AddedTeamMemberRole = CommonMethod.getattributeValueByTextContent("AddedTeamMemberRole");
		CommonMethod.negativesoftassertFieldValid(AddedTeamMemberRole, "Acoustician",
				"Added TeamMember Role doesn't match");
		testlog.info("And User verifies Team member role");
		testlog.pass("**Validated Team member successfully**");
	}

	public void validateAddedTeam() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRProjectAdministrator", 0);
		String WPRProjectAdministrator = CommonMethod.getattributeValueByTextContent("WPRProjectAdministrator").trim();
		CommonMethod.negativesoftassertFieldValid(WPRProjectAdministrator, "Project Administrator",
				"Project Administrator is not visible");
		if (TestNGTestName.contains("Community")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRProjectAdministratorRole", 0);
			String WPRProjectAdministratorRole = CommonMethod
					.getattributeValueByTextContent("WPRProjectAdministratorRole").trim();
			CommonMethod.negativesoftassertFieldValid(WPRProjectAdministratorRole, "Administrator",
					"Administrator role is not matching");
		}
		String CommunityTeamMember = CommonMethod.getattributeValueByTextContent("CommunityTeamMember").trim();
		CommonMethod.negativesoftassertFieldValid(CommunityTeamMember, "Team Member", "Team Member is not visible");
		String CommunityProjectRole = CommonMethod.getattributeValueByTextContent("CommunityProjectRole").trim();
		CommonMethod.negativesoftassertFieldValid("Acoustician", CommunityProjectRole, "Project role is not matching");

	}

	public void deleteAddedTeamMember(String SheetName, int rowNum) throws IOException, InterruptedException {
		Thread.sleep(2000);
		CommonMethod.refreshBrowser();
		testlog.info("Given User is on Team model page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDeleteIcon", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectDeleteIcon", "V2ProjectAddMemberbtn");
		testlog.info("When User clicks on Delete Icon");
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("V2ProjectDeleteIcon");
		CommonMethod.assertisElementPresentFalse("V2ProjectDeleteIcon", "Delete icon is visible");
		testlog.info("Then User will be redirected to Team list page");
		testlog.pass("**Deleted Team member successfully**");
	}

	public void changeProjectAdministrator(String SheetName, int rowNum) throws IOException, InterruptedException {

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTeamChangeAdministrator", 0);
		CommonMethod.RobustclickElementVisible("WPRTeamChangeAdministrator", "WPRTeamEmailAddress");
		String TeamEmail = data.getCellData(SheetName, "TeamMemberEmail", rowNum);
		CommonMethod.sendKeys("WPRTeamEmailAddress", TeamEmail);
		CommonMethod.selectdropdownVisibletext("WPRTeamAdminRole", "Architect");
		CommonMethod.click("UpdateButton");
	}

	public void validateProjectAdministrator() throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("WPRTeamChangeAdministrator");
		CommonMethod.assertisElementPresentFalse("WPRTeamChangeAdministrator",
				"Change Administrator Element is Present");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTeamMember", 0);
		String WPRTeamMember = CommonMethod.getattributeValueByTextContent("WPRTeamMember").trim();
		CommonMethod.negativesoftassertFieldValid(WPRTeamMember, "Team Manager", "Changed Manager is not visible");
		if (TestNGTestName.contains("Community")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRTeamMemberProjectRole", 0);
			String WPRTeamMemberProjectRole = CommonMethod.getattributeValueByTextContent("WPRTeamMemberProjectRole")
					.trim();
			CommonMethod.negativesoftassertFieldValid(WPRTeamMemberProjectRole, "Acoustician",
					"Team Manager role is not matching");
		}
		String WPRProjectAdmin = CommonMethod.getattributeValueByTextContent("WPRProjectAdmin").trim();
		CommonMethod.negativesoftassertFieldValid(WPRProjectAdmin, "Administrator",
				"Changed Administrator is not visible");
		String WPRProjectAdminRole = CommonMethod.getattributeValueByTextContent("WPRProjectAdminRole").trim();
		CommonMethod.negativesoftassertFieldValid("Architect", WPRProjectAdminRole,
				"Project Administrator role is not matching");
		testlog.pass("And User verifies change administrator");
	}

	public void editAndValidateOrganizationInformation(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectNameInput");
		testlog.info("When User clicks on EditTab");
		if (CommonMethod.isElementsExist("V2ProjectProjectInformationButton", 10)) {
			CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
			testlog.info("And User clicks on Project Information Button");
			CommonMethod.clearAndSendKey("V2ProjectProjectNameInput",
					data.getCellData(SheetName, "ProjectName", rowNum));
			testlog.info("And User enters ProjectName");
		}
		if (CommonMethod.isElementsExist("HSROrganizationInformationButton", 10)) {
			CommonMethod.RobustclickElementVisible("HSROrganizationInformationButton", "V2ProjectProjectScope");
			testlog.info("And User clicks on Organization Information Button");
			CommonMethod.clearAndSendKey("V2ProjectProjectNameInput", data.getCellData(SheetName, "HsrName", rowNum));
			testlog.info("And User enters ProjectName");
		}
		testlog.info(
				"And User clicks on Save button without entering the mandatory fields and verifies error meassage");
		CommonMethod.sendKeys("V2ProjectProjectScope", data.getCellData(SheetName, "ProjectScope", rowNum));
		testlog.info("And User enter to ProjectScope field");
		CommonMethod.sendKeys("V2ProjectProjectGoals", data.getCellData(SheetName, "ProjectGoals", rowNum));
		testlog.info("And User enter to ProjectGoals field");
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "WellV2DashboardTab");
		testlog.info("And User clicks on Save button");
		testlog.info("**Project Information data updated successfully**");
		/*
		 * Validate updated project information fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectProjectNameInput");
		testlog.info("And User clicks on EditTab");
		if (CommonMethod.isElementsExist("V2ProjectProjectInformationButton", 10)) {
			CommonMethod.RobustclickElementVisible("V2ProjectProjectInformationButton", "V2ProjectProjectScope");
			testlog.info("And User clicks on ProjectInformation Button");
		} else if (CommonMethod.isElementsExist("HSROrganizationInformationButton", 10)) {
			CommonMethod.RobustclickElementVisible("HSROrganizationInformationButton", "V2ProjectProjectScope");
			testlog.info("And User clicks on OwnerInformation Button");
		}
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectProjectScope"),
				data.getCellData(SheetName, "ProjectScope", rowNum), "Project scope data doesn't match");
		testlog.info("**Project scope data updated successfully**");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValue("V2ProjectProjectGoals"),
				data.getCellData(SheetName, "ProjectGoals", rowNum), "Project goals data doesn't match");
		if (SheetName.equalsIgnoreCase("Hsr")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrProgramFeePrivatecrbtn", 0);
			CommonMethod.VerifyRadioOrCheckboxSelcted("HsrProgramFeePrivatecrbtn");
			testlog.info("Then User verifies the project is Private");
		}
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("V2ProjectEnterpriseProviders"),
				data.getCellData(SheetName, "EnterpriseProvidersName", rowNum), "EnterpriseProvidersName Mismatch");
		Thread.sleep(3000);
		testlog.info("And User verifies the added details");
		testlog.pass("**Project goals data updated successfully**");
	}

	public void editAndValidateAdmin(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.Robustclick("V2ProjectAdminFieldsButton", "V2ProjectProjectNameInput");
		testlog.info("And User clicks on AdminFields Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CoachingContactsDropDown", 0);
		CommonMethod.selectdropdownVisibletext("CoachingContactsDropDown", "UI (welluiautomationtesting@gmail.com)");
		testlog.info("And User select CoachingContacts");
		data.setCellData(SheetName, "CoachingContacts", rowNum,
				CommonMethod.getSelectedDropdownValue("CoachingContactsDropDown"));
		testlog.info("Coaching Contacts: " + data.getCellData(SheetName, "CoachingContacts", rowNum));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RelationshipManagerDropDown", 0);
		CommonMethod.selectdropdownVisibletext("RelationshipManagerDropDown", "UI (welluiautomationtesting@gmail.com)");
		testlog.info("And User select RelationshipManager");
		data.setCellData(SheetName, "RelationshipManager", rowNum,
				CommonMethod.getSelectedDropdownValue("RelationshipManagerDropDown"));
		testlog.info("Relationship Manager: " + data.getCellData(SheetName, "RelationshipManager", rowNum));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellReviewerDropDown", 0);
		CommonMethod.selectdropdownVisibletext("WellReviewerDropDown", "UI (welluiautomationtesting@gmail.com)");
		testlog.info("And User select Reviewer");
		data.setCellData(SheetName, "WellReviewer", rowNum,
				CommonMethod.getSelectedDropdownValue("WellReviewerDropDown"));
		testlog.info("Well Reviewer: " + data.getCellData(SheetName, "WellReviewer", rowNum));
		if (SheetName.equalsIgnoreCase("Wer") || SheetName.equalsIgnoreCase("Wpr")
				|| SheetName.equalsIgnoreCase("Hsr")) {
			CommonMethod.ClickCheckbox("EditAchievedStatus");
			testlog.info("And User checks the AchievedStatus checkbox");
			CommonMethod.RobustclickElementVisible("DatePickerButton", "DatePickerOkButton");
			CommonMethod.RobustclickElementVisible("DatePickerOkButton", "V2ProjectSaveChangesButton");
			testlog.info("And User select Date");
		}
		CommonMethod.uploadMultipleFile("DocumentsUpload", SampleJpgfile, SampleJpgfile, "MultipeUploadDeleteicon", 2,
				"MultipeUploadEnableButtonDeleteLink");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSaveChangesButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectSaveChangesButton", "WellV2DashboardTab");
		testlog.info("And User clicks on Save button");
		testlog.pass("**Admin data updated successfully**");
		/*
		 * Validate updated admin fields
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("And User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.Robustclick("V2ProjectAdminFieldsButton", "V2ProjectProjectNameInput");
		testlog.info("And User clicks on AdminFields Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CoachingContactsDropDown", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("CoachingContactsDropDown"),
				data.getCellData(SheetName, "CoachingContacts", rowNum), "Coaching contacts value doesn't match");
		testlog.pass("**Coaching contacts updated successfully**");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RelationshipManagerDropDown", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("RelationshipManagerDropDown"),
				data.getCellData(SheetName, "RelationshipManager", rowNum), "Relationship Manager value doesn't match");
		testlog.pass("**Relationship Manager value updated successfully**");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellReviewerDropDown", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getSelectedDropdownValue("WellReviewerDropDown"),
				data.getCellData(SheetName, "WellReviewer", rowNum), "Well Reviewer value doesn't match");
		CommonMethod.VerifyRadioOrCheckboxSelcted("EditAchievedStatus");
		testlog.info("Then User verifies the added details");
		testlog.pass("**Well Reviewer value updated successfully**");
	}

	public void ValidateCloseProject(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminFieldsButton", "AccountCloseReasonSelectCommon");
		ValidateCloseAccount();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveChangesButton", 0);
		CommonMethod.Robustclick("SaveChangesButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("SaveChangesButton", 1);
		ValidateSuccessmessage();
		testlog.info("And User clicks on Save button");
		testlog.pass("**Admin data updated successfully**");
		/*
		 * Validate updated Pop message
		 */
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AccountCloseValidMessageCommon", 0);
		CommonMethod.WaitUntilTextToBePresentInLocator("AccountCloseValidMessageCommon",
				"This enrollment has been archived.", 300);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("AccountCloseValidMessageCommon"),
				"This enrollment has been archived", "Close Account Popup message doesn't match");
		CommonMethod.click("AccountCloseBackButtonCommon");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		testlog.info("Then User verifies the added details");
		testlog.pass("**Well Reviewer value updated successfully**");
	}

	public void promotionCardValidation() throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PromotionTab", 0);
		CommonMethod.RobustclickElementVisible("PromotionTab", "PromotionCardContainer");
		testlog.info("When User clicks on PromotionTab");
		rc.ValidCardCount("PromotionCardContainer");
		testlog.info("Then User verifies Promotion card count");
		testlog.pass("**Verify card count successfully**");
	}

	public void profile(String SheetName, int rowNum) throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProfileTab", 0);
		CommonMethod.RobustclickElementVisible("ProfileTab", "V2ProjectGeneralInformation");
		testlog.info("When User clicks on ProfileTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectGeneralInformation", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectGeneralInformation", "V2ProjectProjectBio");
		testlog.info("And User clicks on GeneralInformation");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectProjectBio", 0);
		CommonMethod.clearAndSendKey("V2ProjectProjectBio", "Project bio testing");
		testlog.info("And User enter data to ProjectBio field");
		CommonMethod.uploadFile("V2ProjectLogo", SampleJpgfile, "UploadFileVerifyScorecard");
		testlog.info("And User upload document for ProfileLogo and verify upload icon");
		CommonMethod.uploadMultipleFile("DocumentsUpload", SampleJpgfile, SampleJpgfile, "MultipeUploadDeleteicon", 3,
				"MultipeUploadEnableButtonDeleteLink");
		testlog.info("And User upload document for ProfileImage and verify upload icon");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectPrimaryProfileImageDeleteVerify", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectProfileImageDeleteVerify", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectProfileUpdatedToastMessage");
		testlog.info("And User clicks on Save button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectProfileUpdatedToastMessage", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Profile updated successfully.", "Verified profile updated toast message");
		testlog.info("Then User verifies Profile updated successfully toast message");
		testlog.pass("**General Information data updated successfully**");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ProfileTab", 0);
		if (SheetName.equalsIgnoreCase("Wpr")) {
			CommonMethod.RobustclickElementVisible("ProfileTab", "WellPerformanceProfileButton");
			testlog.info("And User clicks on ProfileTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellPerformanceProfileButton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectGeneralInformation", "V2ProjectProjectBio");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectProjectBio"),
					"Project bio testing", "WPR About Your Org Value Error Mismatch");
			testlog.info("And User verifies the added details");
			CommonMethod.RobustclickElementVisible("WellPerformanceProfileButton", "V2ProjectYourObjective");
			testlog.info("And User clicks on WellPerformanceProfile Button");
		}
		if (SheetName.equalsIgnoreCase("Hsr")) {
			CommonMethod.RobustclickElementVisible("ProfileTab", "WellHealthSafty");
			testlog.info("And User clicks on ProfileTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellHealthSafty", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectGeneralInformation", "V2ProjectProjectBio");
			testlog.info("And User clicks on GeneralInformation Button");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectProjectBio"),
					"Project bio testing", "HSR About Your Org Value Error Mismatch");
			testlog.info("And User verifies the added details");
			CommonMethod.RobustclickElementVisible("WellHealthSafty", "V2ProjectYourObjective");
			testlog.info("And User clicks on WER Profile WellHealthSafty Story Button");
		}
		if (SheetName.equalsIgnoreCase("Wer")) {
			CommonMethod.RobustclickElementVisible("ProfileTab", "WERProfileWellEquityStoryButton");
			testlog.info("And User clicks on ProfileTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERProfileWellEquityStoryButton", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectGeneralInformation", "V2ProjectProjectBio");
			testlog.info("And User clicks on GeneralInformation Button");
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectProjectBio"),
					"Project bio testing", "WER About Your Org Value Error Mismatch");
			testlog.info("And User verifies the added details");
			CommonMethod.RobustclickElementVisible("WERProfileWellEquityStoryButton", "V2ProjectYourObjective");
			testlog.info("And User clicks on WER Profile WellEquity Story Button");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectYourObjective", 0);
		CommonMethod.clearAndSendKey("V2ProjectYourObjective", "Your objective testing");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectYourOrganization", 0);
		CommonMethod.clearAndSendKey("V2ProjectYourOrganization", "Your organization testing");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectYourWellGoals", 0);
		CommonMethod.clearAndSendKey("V2ProjectYourWellGoals", "Your well goals testing");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectYourWellProject", 0);
		CommonMethod.clearAndSendKey("V2ProjectYourWellProject", "Your well project testing");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectYourWellFeatures", 0);
		CommonMethod.clearAndSendKey("V2ProjectYourWellFeatures", "Your well features testing");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectYourWellCertification", 0);
		CommonMethod.clearAndSendKey("V2ProjectYourWellCertification", "Your well certification testing");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectPostCertificationMetric", 0);
		CommonMethod.clearAndSendKey("V2ProjectPostCertificationMetric", "Post certification metric testing");
		CommonMethod.RobustclickElementVisible("V2ProjectSave", "V2ProjectProfileUpdatedToastMessage");
		testlog.info("And User clicks on Save Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectProfileUpdatedToastMessage", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectProfileUpdatedToastMessage"),
				"Profile updated successfully.", "Verified profile updated toast message");
		if (SheetName.equalsIgnoreCase("Wpr")) {
			CommonMethod.RobustclickElementVisible("ProfileTab", "WellPerformanceProfileButton");
			testlog.info("And User clicks on ProfileTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellPerformanceProfileButton", 0);
			CommonMethod.RobustclickElementVisible("WellPerformanceProfileButton", "V2ProjectYourObjective");
			testlog.info("And User clicks on WellPerformanceProfile Button");
		}
		if (SheetName.equalsIgnoreCase("Hsr")) {
			CommonMethod.RobustclickElementVisible("ProfileTab", "WellHealthSafty");
			testlog.info("And User clicks on ProfileTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellHealthSafty", 0);
			CommonMethod.RobustclickElementVisible("WellHealthSafty", "V2ProjectYourObjective");
			testlog.info("And User clicks on WellHealthSaftyStory Button");
		}
		if (SheetName.equalsIgnoreCase("Wer")) {
			CommonMethod.RobustclickElementVisible("ProfileTab", "WERProfileWellEquityStoryButton");
			testlog.info("And User clicks on ProfileTab");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERProfileWellEquityStoryButton", 0);
			CommonMethod.RobustclickElementVisible("WERProfileWellEquityStoryButton", "V2ProjectYourObjective");
			testlog.info("And User clicks on WellEquityStory Button");
		}
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectYourObjective"),
				"Your objective testing", "Your objective testing Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectYourOrganization"),
				"Your organization testing", "Your organization testing Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectYourWellGoals"),
				"Your well goals testing", "Your well goals testing Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectYourWellProject"),
				"Your well project testing", "Your well project testing Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectYourWellFeatures"),
				"Your well features testing", "Your well features testing Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectYourWellCertification"),
				"Your well certification testing", "Your well certification testing Error Mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectPostCertificationMetric"),
				"Post certification metric testing", "Post certification metric testing Error Mismatch");
		testlog.info("And User verifies the added details");
		testlog.info("Then User verifies Profile updated successfully toast message");
		testlog.pass("**Certification story data updated successfully**");
	}

	public void addLocation(String SheetName, int rowNum, String ProjectType) throws Exception {
		testlog.info("Given User is on Dashboard page");
		String LocationName = null;
		if (SheetName.equalsIgnoreCase("Wpr") || SheetName.equalsIgnoreCase("Hsr")
				|| SheetName.equalsIgnoreCase("Portfolio") || ProjectType.equalsIgnoreCase("V2Pilot")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
			CommonMethod.RobustclickElementVisible("LocationTab", "AddButton");
			testlog.info("When User clicks on LocationTab");
		}
		CommonMethod.WaitUntilPresence("AddButton", 120);
		CommonMethod.RobustclickElementVisible("AddButton", "AddLocationButton");
		testlog.info("And User clicks on Add Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddLocationButton", 0);
		if (SheetName.equalsIgnoreCase("Wpr") || SheetName.equalsIgnoreCase("Hsr")
				|| SheetName.equalsIgnoreCase("Wer")) {
			CommonMethod.RobustclickElementVisible("AddLocationButton", "LocationName");
			testlog.info("And User clicks on Add Location Button");
			CommonMethod.RobustclickElementVisible("SubmitButton", "LocationName");
			CommonMethod.negativesoftassertPageSource("Location Name* is required.", "Location Name Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Location Area* is required.", "Location Area Error Mismatch");
			if (!TestNGTestName.contains("NonEnhanced")) {
				CommonMethod.negativesoftassertPageSource("Space Type* is required.", "Space Type Error Mismatch");
			}
			CommonMethod.negativesoftassertPageSource("Ownership Type* is required.", "Ownership Type Error Mismatch");
			testlog.info(
					"And User clicks on continue button without entering the mandatory fields and verifies error meassage");
			CommonMethod.WaitUntilVisibility("LocationName", 120);
			LocationName = "Automation" + SheetName + "Location" + CommonMethod.randomNumber(8000000);
			data.setCellData(SheetName, "LocationName", rowNum, LocationName);
			CommonMethod.sendKeys("LocationName", LocationName);
			testlog.info("And User enter data to LocationName field");
			CommonMethod.sendKeys("LocationArea", data.getCellData(SheetName, "Area", rowNum));
			testlog.info("And User enter data to Area field");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationSpaceType", 0);
			CommonMethod.selectdropdownrandom("LocationSpaceType");
			testlog.info("And User select the SpaceType");
			data.setCellData(SheetName, "SpaceTypes", rowNum,
					CommonMethod.getSelectedDropdownValue("LocationSpaceType"));
			testlog.info("Space type: " + data.getCellData(SheetName, "SpaceTypes", rowNum));
			CommonMethod.selectdropdownVisibletext("LocationOwnershipType", "For sale/lease");
			testlog.info("And User select the OwnershipType");
			data.setCellData(SheetName, "OwnerType", rowNum,
					CommonMethod.getSelectedDropdownValue("LocationOwnershipType"));
			testlog.info("Owner type: " + data.getCellData(SheetName, "OwnerType", rowNum));
		} else if (SheetName.equalsIgnoreCase("Portfolio") || ProjectType.equalsIgnoreCase("V2Pilot")) {
			CommonMethod.RobustclickElementVisible("AddLocationButton", "PortfolioLocationProjectName");
			testlog.info("And User clicks on Add Location Button");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubmitButton", 0);
			CommonMethod.RobustclickElementVisible("SubmitButton", "PortfolioLocationProjectName");
			testlog.info("And User clicks on Submit Button");
			CommonMethod.WaitUntilVisibility("PortfolioLocationProjectName", 120);
			CommonMethod.negativesoftassertPageSource("Project Name* is required.", "Project Name Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Project Version is required.", "Project Version Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Project Area* is required.", "Project Area Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Space Type* is required.", "Space Type Error Mismatch");
			CommonMethod.negativesoftassertPageSource("Ownership Type* is required.", "Ownership Type Error Mismatch");
			testlog.info(
					"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
			LocationName = "Automation portfolio Location" + CommonMethod.randomNumber();
			data.setCellData(SheetName, "LocationName", rowNum, LocationName);
			CommonMethod.sendKeys("PortfolioLocationProjectName", data.getCellData(SheetName, "LocationName", rowNum));
			testlog.info("And User enter data to ProjectName field");
			CommonMethod.selectdropdownrandom("PortfolioLocationProjectVersion");
			testlog.info("And User select the ProjectVersion");
			data.setCellData(SheetName, "ProjectVersion", rowNum,
					CommonMethod.getSelectedDropdownValue("PortfolioLocationProjectVersion"));
			testlog.info("Project Version: " + data.getCellData(SheetName, "ProjectVersion", rowNum));
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
		}
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
		if (SheetName.equalsIgnoreCase("Wer") || SheetName.equalsIgnoreCase("Portfolio")
				|| SheetName.equalsIgnoreCase("V2Pilot_Portfolio")) {
			CommonMethod.WaitUntilPresence("LocationListTableLoading", 60);
			CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
			CommonMethod.WaitUntilPresence("LocationListTable", 180);
			List<String> val = CommonMethod.fetchTableData("LocationListTable");
			testlog.info("Fetching Data from Upload Table");
			if (SheetName.equalsIgnoreCase("Wer") || SheetName.equalsIgnoreCase("Wpr")
					|| SheetName.equalsIgnoreCase("Hsr")) {
				CommonMethod.negativesoftassertFieldValid(val.get(2), data.getCellData(SheetName, "City", rowNum),
						"City name doesn't match");
			} else {
				String[] LocationNameValid = val.get(0).split(LocationName);
				data.setCellData(SheetName, "LocationProjectID", rowNum, LocationNameValid[1].trim());
				CommonMethod.negativesoftassertFieldValid(val.get(0),
						data.getCellData(SheetName, "LocationName", rowNum), "Location name doesn't match");
			}
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationRefresh", 0);
		testlog.info("And User verifies the added details in Location list Table");
		testlog.pass("**Added single location successfully**");
	}

	public void ValidAddLocation(String SheetName, int rowNum, String LocationCount) throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationTab", 0);
		CommonMethod.RobustclickElementVisible("LocationTab", "Subsettab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Subsettab", 0);
		CommonMethod.scrolldowntoElement("Subsettab");
		testlog.info("When User clicks on LocationTab");
		if (SheetName.equalsIgnoreCase("Hsr") || SheetName.equalsIgnoreCase("Wer")
				|| SheetName.equalsIgnoreCase("Wpr")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationRefresh", 0);
			CommonMethod.RobustclickElementVisible("LocationRefresh", "LocationResultCount");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationsPageTotalLoaded", 0);
		CommonMethod.GenericWaitUntil("LocationsPageTotalLoaded", LocationCount);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationResultCount", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("LocationResultCount"), LocationCount,
				"Result location count doesn't match");
	}

	public void ClickBilling(String SheetName, int rowNum) throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("BiilingTab", 0);
		CommonMethod.RobustclickElementVisible("BiilingTab", "DownloadReceipt");
		testlog.info("When User clicks on BiilingTab");
		Thread.sleep(3000);
		testlog.pass("**Nagavited to Billing successfully**");
	}

	public void DownloadBillingReceiptAndValidate(String SheetName, int rowNum, String Country)
			throws IOException, InterruptedException {
		CommonMethod.ClearDownloadFile();
		testlog.info("Given User on Receipt Page");
		String Amount = null;
		if (TestCaseName.equalsIgnoreCase("Healthsafety_TC_20_04_RenewalBilling")) {
			Amount = "6,500";
		} else {
			Amount = data.getCellData(SheetName, "EnrollFee", rowNum);
		}
		testlog.info("Amount: " + Amount);
		String Address = null;
		Thread.sleep(3000);
		if (Country.equalsIgnoreCase("US")) {
			Address = "New York, NY 10014";
			testlog.info("Address: " + Address);
		} else {
			Address = "IWBI China(HK) Limited";
			testlog.info("Address: " + Address);
		}
		String[] ProjDetails = { Address, Amount };
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DownloadReceipt", 0);
		if (TestCaseName.equalsIgnoreCase("Healthsafety_TC_20_04_RenewalBilling")) {
			CommonMethod.clickOnListWebelementFromIndex("DownloadReceipt", 1);
		} else {
			CommonMethod.click("DownloadReceipt");
		}
		testlog.info("And User clicks on DownloadReceipt button");
		boolean fileExistsReturnValue = CommonMethod.isFileDownloaded();
		testlog.info("Then User verifies Downloaded file");
		String fileExists = Boolean.toString(fileExistsReturnValue);
		System.out.println("fileExists:" + fileExists);
		CommonMethod.negativesoftassertFieldValid(fileExists, "true", "Downloaded Billing Receipt file doesn't Exist");
		Thread.sleep(3000);
		if (CommonMethod.isFileDownloaded()) {
			File path = new File(downloadPath);
			File[] files = path.listFiles();
			for (File file : files) {
				String ReceiptContent = CommonMethod.extractPDFContent(file.toString());
				for (String s : ProjDetails) {
					CommonMethod.negativesoftassertFieldValid(ReceiptContent, s,
							"Downloaded Billing Receipt Data mismatch");
					testlog.info("Then User verifies Address from Downloaded Receipt");
				}
				break;
			}
		}
		testlog.info("And User verifies Email fro Downloaded Receipt");
		testlog.info("And User verifies Amount fro Downloaded Receipt");
		testlog.pass("**Verifies Download Billing Receipt And Validate successfully**");
	}

	public void teamMemberLogin(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username", data.getCellData(SheetName, "TeamMemberEmail", rowNum));
		testlog.info("Sending Username " + data.getCellData(SheetName, "TeamMemberEmail", rowNum));
		CommonMethod.findElementWithRelative("LoginButton", "Password", "above")
				.sendKeys(data.getCellData("Login", "Password", 3));
		testlog.info("Sending Password " + data.getCellData("Login", "Password", 3));
		Thread.sleep(1000);
		CommonMethod.scrolldowntoElement("LoginButton");
		CommonMethod.RobustclickElementVisible("LoginButton", "SuccessfulLogin");
		testlog.info("Clicking on Submit Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SuccessfulLogin", 0);
		testlog.pass("Verfies Login Successful");
	}

	public void clickOnTeamTab() throws IOException, InterruptedException {
		testlog.info("Given User is on Dashboard");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TeamTab", 0);
		CommonMethod.RobustclickElementVisible("TeamTab", "V2ProjectAddMemberbtn");
		testlog.info("When User clicks on TeamTab");
	}

	public void errorMessageNegativeAssert() throws IOException, InterruptedException {
		negativesoftAssert.assertAll();
		testlog.pass("**Verifies Error Message for Madatory field**");
	}

	public void FieldNegativeAssert() throws IOException, InterruptedException {
		negativeFieldSoftAssert.assertAll();
		testlog.pass("**Verifies Error Message for Madatory field**");
	}

	public void searchFilterDocument(String documentName, String fileCount) throws IOException, InterruptedException {
		CommonMethod.RobustclickElementVisible("WPRDocumentFilterOption", "WPRDocumentSearchBox");
		CommonMethod.clearAndSendKey("WPRDocumentSearchBox", documentName);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentSpinner", 0);
		CommonMethod.WaitUntilInVisibility("WPRDocumentSpinner", 60);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		List<String> val = CommonMethod.fetchTableData(PortfolioAndRatingLocAccDocumentTable);
		CommonMethod.negativesoftassertFieldValid(val.get(0), "FeatureFile",
				"searchFilter Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Verifies search filter successfully **");
	}

	public void VerifyScorecardPurseStatusCount(String SheetName, int rowNum, String expectedPartCount)
			throws IOException, InterruptedException {
		/*
		 * Total FeaturePartCount
		 */
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPartCount", 0);
		int ScorecardPart = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
		String FeatureScorecardPartCount = Integer.toString(ScorecardPart);
		testlog.info("FeatureScorecardPartCount: " + FeatureScorecardPartCount);
		data.setCellData(SheetName, "ScorecardPartCount", rowNum, FeatureScorecardPartCount);
		CommonMethod.negativesoftassertFieldValid(data.getCellData(SheetName, "ScorecardPartCount", rowNum),
				expectedPartCount, "ScorecardPartCount doesn't match");
		testlog.info("Then User verifies the Scorecard Feature Count");
	}

	public void VerifyScorecardPurseStatusCount(String SheetName, String expectedPartCount, String expectedYesCount,
			String expectedNoCount, int rowNum) throws IOException, InterruptedException {
		/*
		 * Total FeaturePartCount
		 */
		testlog.info("Given User is on Scorecard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectScorecardPartCount", 0);
		int ScorecardPart = CommonMethod.ElementSize("V2ProjectScorecardPartCount");
		String FeatureScorecardPartCount = Integer.toString(ScorecardPart);
		testlog.info("FeatureScorecardPartCount: " + FeatureScorecardPartCount);
		data.setCellData(SheetName, "ScorecardPartCount", rowNum, FeatureScorecardPartCount);
		CommonMethod.negativesoftassertFieldValid(data.getCellData(SheetName, "ScorecardPartCount", rowNum),
				expectedPartCount, "ScorecardPartCount doesn't match");
		/*
		 * YesPurseCount
		 */
		int YesFeature = CommonMethod.ElementSize("CommonSelectedPurseYes");
		String YesFeatureCount = Integer.toString(YesFeature);
		testlog.info("YesFeatureCount: " + YesFeatureCount);
		data.setCellData(SheetName, "YesPurseCount", rowNum, YesFeatureCount);
		CommonMethod.negativesoftassertFieldValid(data.getCellData(SheetName, "YesPurseCount", rowNum),
				expectedYesCount, "YesPurseCount doesn't match");
		/*
		 * NoPurseCount
		 */
		int NoFeature = CommonMethod.ElementSize("CommonSelectedPurseNo");
		String NoFeatureCount = Integer.toString(NoFeature);
		testlog.info("NoFeatureCount: " + NoFeatureCount);
		data.setCellData(SheetName, "NoPurseCount", rowNum, NoFeatureCount);
		CommonMethod.negativesoftassertFieldValid(data.getCellData(SheetName, "NoPurseCount", rowNum), expectedNoCount,
				"NoPurseCount doesn't match");
		testlog.info("Then User verifies the Scorecard Feature Count V2Project");
		testlog.info("And User verifies the " + expectedPartCount + " Part Count Scorecard V2Project");
		testlog.info("And User verifies the " + expectedYesCount + " Purse Yes Scorecard V2Project");
		testlog.info("And User verifies the " + expectedNoCount + " Purse No Scorecard V2Project");
		testlog.pass("**Verifies the Purse Scorecard Part Count V2Project successfully**");
	}

	public void paperIconWithoutRefresh(String PaperIconFeatureXpath) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException(PaperIconFeatureXpath, 1);
		int PaperIcon = CommonMethod.ElementSize(PaperIconFeatureXpath);
		String PaperIconActualCount = Integer.toString(PaperIcon);
		testlog.info("PaperIconCount: " + PaperIconActualCount);
		CommonMethod.negativesoftassertFieldValid(PaperIconActualCount, "1", "PaperIconCount doesn't match");
		testlog.info("And User verifies the Scorecard Upload Paper icon");
	}

	public void VerifyPaperIconCount(String SheetName, int rowNum, String expectedPaperIconCount)
			throws IOException, InterruptedException {
		/*
		 * PaperIconCount
		 */
		CommonMethod.refreshBrowser();
		if (CommonMethod.isElementsExist("V2ProjectHsrContinuebtn", 30)) {
			CommonMethod.Robustclick("V2ProjectHsrContinuebtn");
		}
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("ValidPaperIcon",
				Integer.parseInt(expectedPaperIconCount));
		int PaperIcon = CommonMethod.ElementSize("ValidPaperIcon");
		String PaperIconActualCount = Integer.toString(PaperIcon);
		testlog.info("PaperIconCount: " + PaperIconActualCount);
		CommonMethod.negativesoftassertFieldValid(PaperIconActualCount, expectedPaperIconCount,
				"PaperIconCount doesn't match");
		testlog.pass("**Verifies the PaperIcon Count successfully**");
	}

	public void VerifyWeightIconCount(String SheetName, int rowNum, String expectedPaperIconCount)
			throws IOException, InterruptedException {
		/*
		 * WeightIconCount
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("WeightPointCommon",
				Integer.parseInt(expectedPaperIconCount));
		int WeightIconCount = CommonMethod.ElementSize("WeightPointCommon");
		String WeightIconActualCount = Integer.toString(WeightIconCount);
		testlog.info("WeightPointCount: " + WeightIconActualCount);
		CommonMethod.negativesoftassertFieldValid(WeightIconActualCount, expectedPaperIconCount,
				"WeightPointCount doesn't match");
		testlog.pass("**Verifies the WeightPoint Count successfully**");
	}

	public void ValidCardCount(String locator) throws Exception {
		int countCard = CommonMethod.ElementSize(locator);
		boolean flag = true;
		if (countCard < 1) {
			flag = false;
		}
		String ValidCardCount = Boolean.toString(flag);
		CommonMethod.negativesoftassertFieldValid(ValidCardCount, "true", "Card count empty doesn't match");
	}

	public void ClickOnAlterativeRows(String locator, String moduleName) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(locator, 0);
		CommonMethod.scrolldowntoElement("V2ProjectEPSubmitButton");
		CommonMethod.RobustclickElementVisible(locator, "V2ProjectAlternativePageLoad");
		CommonMethod.WaitUntilInVisibility("V2ProjectAlternativePageLoad", 120);

	}

	public void supportCardValidation() throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SupportTab", 0);
		CommonMethod.RobustclickElementVisible("SupportTab", "PromotionCardContainer");
		testlog.info("When User clicks on SupportTab");
		rc.ValidCardCount("PromotionCardContainer");
		testlog.info("Then User verifies Support card count");
		testlog.pass("**Verify card count successfully**");
	}

	public void validImportHundredPlusLocations(String SheetName, int rowNum) throws IOException, InterruptedException {

		/*
		 * Validate location added successfully
		 */
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
		CommonMethod.GenericWaitUntil("LocationsPageTotalLoaded", "170");
		testlog.info("And User verifies Location list Table and location count");
		testlog.pass("**Imported 100+ Locations successfully**");
	}

	public void ScorecardLoading() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ScorecardPageLoaded", Scorecardtimeout);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 1);
		if (CommonMethod.isElementsExist("ScorecardBannerClose", 60)) {
			CommonMethod.Robustclick("ScorecardBannerClose");
		}
	}

	public void ScorecardVersionValid(String ProjectType) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 1);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("ScorecardProjectTypeVersion"), ProjectType,
				"Project Type Doesn't match");
		testlog.info("And User verifies Project Type");
	}

	public void teamLogin(String SheetName, int rowNum, String Username) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Username", 0);
		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username", data.getCellData(SheetName, Username, rowNum));
		testlog.info("Sending Username " + data.getCellData(SheetName, Username, rowNum));
		CommonMethod.findElementWithRelative("LoginButton", "Password", "above")
				.sendKeys(data.getCellData("Login", "Password", 3));
		testlog.info("Sending Password " + data.getCellData("Login", "Password", 3));
		Thread.sleep(1000);
		CommonMethod.scrolldowntoElement("LoginButton");
		CommonMethod.RobustclickElementVisible("LoginButton", "SuccessfulLogin");
		testlog.info("Clicking on Submit Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SuccessfulLogin", 0);
		testlog.pass("Verfies Login Successful");
	}

	public void SelectingReviewDate() throws IOException, InterruptedException {
		CommonMethod.WaitUntilClickble("DatePickerButton", 60);
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("DatePickerButton", "DatePickerOkButton");
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "ReviewPaymentstatusRadio");
		testlog.info("And User select Date");
	}

	public void ValidateDateInList() throws IOException, InterruptedException {
		String DateValid = CommonMethod.getText("ListValidateDate").replaceAll("Expires on", "");
		String[] stringArray = DateValid.split("- ");
		String getDate = stringArray[0].trim();
		System.out.println("DateValid: " + getDate);
		testlog.info("getDate: " + getDate);
		CommonMethod.negativesoftassertFieldValid(getDate, CommonMethod.ValidateDateYear(), "Search Date valid failed");

	}

	public void ValidateCloseAccount() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AccountCloseReasonSelectCommon", 0);
		CommonMethod.selectdropdownrandom("AccountCloseReasonSelectCommon");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AccountCloseReasonDateCommon", 0);
		CommonMethod.RobustclickElementVisible("AccountCloseReasonDateCommon", "DatePickerOkButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DatePickerOkButton", 0);
		CommonMethod.Robustclick("DatePickerOkButton");
		testlog.info("And User select reason");
		testlog.info("And User select Date");
	}

	public void ValidateSuccessmessage() throws IOException, InterruptedException {
		if (CommonMethod.isElementsExist("UpdateToasterMessageCommon", 30)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("UpdateToasterMessageCommon", 60);
			testlog.info("And User verifies success message");
		}
	}

	public void TeamPermissionLevel(String SheetName, int rowNum) throws IOException, InterruptedException {
		rc.clickOnTeamTab();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddMemberbtn", 0);
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
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddMemberbtn", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectAddMemberbtn", "V2ProjectEmailAddress");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectEmailAddress", 0);
			CommonMethod.sendKeys("V2ProjectEmailAddress", EmailDetails[i]);
			testlog.info("And User enter email id field");
			testlog.info("Team Email ID: " + EmailDetails[i]);
			CommonMethod.selectdropdownVisibletext("V2ProjectRole", "Acoustician");
			testlog.info("And User select the Role");
			CommonMethod.ClickCheckbox(PermissionsLevel[i]);
			testlog.info("And User checks the Member checkbox");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectInvitebtn", 0);
			CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn", "V2ProjectDeleteIcon");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDeleteIcon", 0);
			testlog.info("And User clicks on Invite button");
			testlog.info("Then User will be redirected to Team list page");
			testlog.pass("**Created Team member successfully**");
		}
	}

	public void ValidFeatureDuplication() throws IOException, InterruptedException {
		testlog.info("Given User is on Scorecard page");
		boolean flag = false;
		ArrayList<String> featureList = new ArrayList<String>();
		List<WebElement> Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			featureList.add(Creditname);
		}
		// Remove empty values from the list
		for (int i = 0; i < featureList.size(); i++) {
			if (featureList.get(i).isEmpty()) {
				featureList.remove(i);
				i--;
			}
		}
		Set<String> res = findDuplicates(featureList);
		String resStr = "";
		if (res.size() > 0) {
			Iterator<String> itr = res.iterator();
			while (itr.hasNext()) {
				resStr += itr.next() + " , ";
			}
			flag = true;
			System.out.println("Duplicate feature found: " + resStr);
			testlog.info("Duplicate feature found: " + resStr);
		}
		String featureDuplicationExists = Boolean.toString(flag);
		CommonMethod.negativesoftassertFieldValid(featureDuplicationExists, "false",
				"Duplicate feature found: " + resStr);
		testlog.pass("User verifies feature Duplication");
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

	public void ScorecardPurseSearchFilter(String FeatureName) throws IOException, InterruptedException {
		testlog.info("And User clicks on ScorecardTab");
		CommonMethod.refreshBrowser();
		rc.ScorecardLoading();
		CommonMethod.WaitUntilVisibility("WPRPortfolioScorecardLanding", Scorecardtimeout);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		for (WebElement f : Feature) {
			if (f.getText().equalsIgnoreCase(FeatureName)) {
				CommonMethod.WaitUntilClickble(f, 120);
				CommonMethod.JavascriptClickElement(f);
				CommonMethod.JavascriptClickElement("PortfolioScorecardFeatureVerificationTab");
				testlog.info("And User clicks on Verification tab");
				portfolio.PursingSearch();
				CommonMethod.JavascriptClickElement(f);
			}
		}
	}

	public void editAdminAwardDate() throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.Robustclick("V2ProjectAdminFieldsButton", "V2ProjectProjectNameInput");
		testlog.info("And User clicks on AdminFields Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditAchievedStatus", 0);
		CommonMethod.ClickCheckbox("EditAchievedStatus");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AwardedDate", 0);
		CommonMethod.RobustclickElementVisible("AwardedDate", "DatePickerOkButton");
		testlog.info("And User select Date");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectnextYearbtn", 0);
		CommonMethod.Robustclick("V2ProjectnextYearbtn", "V2ProjectDatePopupWeekday");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRSelectDate", 0);
		Thread.sleep(1000);
		CommonMethod.RobustclickElementVisible("WPRSelectDate", "DatePickerOkButton");
		Thread.sleep(1000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DatePickerOkButton", 0);
		CommonMethod.Robustclick("DatePickerOkButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSaveChangesButton", 0);
		CommonMethod.Robustclick("V2ProjectSaveChangesButton");
		if (CommonMethod.isElementsExist("ScorecardBannerClose", 30)) {
			CommonMethod.Robustclick("ScorecardBannerClose");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("V2ProjectSaveChangesButton", 1);
	}

	public void navigateRenewal() throws Exception {
		testlog.info("Given User is on Dashboard page");
		if (TestCaseName.equalsIgnoreCase("Performance_TC_22_01_NavigateRenewalAsYes")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2RenewalButton", 0);
			CommonMethod.RobustclickElementVisible("V2RenewalButton", "RenewalTermAndCondition");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalButton", 0);
			CommonMethod.RobustclickElementVisible("RenewalButton", "RenewalTermAndCondition");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalTermAndCondition", 0);
		CommonMethod.ClickCheckbox("RenewalTermAndCondition");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalWprTermAndConditionSaveBtn", 0);
		CommonMethod.RobustclickElementVisible("RenewalWprTermAndConditionSaveBtn", "RenewalTermAndCondition");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalMultipleLocationRenewal", 0);
		CommonMethod.RobustclickElementVisible("RenewalMultipleLocationRenewal", "RenewalPopMsgValid");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalPopMsgValid", 0);
		if (TestNGTestName.contains("NonEnhanced")) {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("RenewalPopMsgValid"),
					"Please review the instructions in the locations tab", "Renewal PopUp Msg doesn't match");
		} else {
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getattributeValueByTextContent("RenewalPopMsgValid"),
					"Please confirm that the location list", "Renewal PopUp Msg doesn't match");
		}
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AddButton", 0);
	}

	public void ArchieveToLocations() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationConfirmButton", 0);
		CommonMethod.assertisElementPresentTrue("RenewalLocationConfirmButton",
				"Renewal Location Confirm Button not present");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("RenewalPopMsg", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationContentValid", 0);
		String ActualText = CommonMethod.getattributeValueByTextContent("RenewalLocationContentValid");
		String[] stringArray = ActualText.split("to:");
		CommonMethod.negativesoftassertFieldValid(stringArray[0].trim(), "Please follow the instructions below",
				"Renewal location Msg doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSubsetButton", 0);
		CommonMethod.scrolldowntoElement("PortfolioSubsetButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationListArchiveButton", 4);
		String locationCount;
		if (TestNGTestName.contains("NonEnhanced")) {
			locationCount = "6";
			CommonMethod.negativesoftassertFieldValid(
					String.valueOf(CommonMethod.ElementSize("RenewalLocationListArchiveButton")), locationCount,
					"Archive button count mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationListEhArchiveButton1", 0);
			CommonMethod.Robustclick("RenewalLocationListEhArchiveButton1");
		} else {
			locationCount = "5";
			CommonMethod.negativesoftassertFieldValid(
					String.valueOf(CommonMethod.ElementSize("RenewalLocationListArchiveButton")), locationCount,
					"Archive button count mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationListArchiveButton1", 0);
			CommonMethod.Robustclick("RenewalLocationListArchiveButton1");
		}
		if (CommonMethod.isElementsExist("RenewalLocationListArchiveToasterMsg", 7)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationListArchiveToasterMsg", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("RenewalLocationListArchiveToasterMsg", 1);
		}
		if (TestNGTestName.contains("NonEnhanced")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationListEhArchiveButton2", 0);
			CommonMethod.Robustclick("RenewalLocationListEhArchiveButton2");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationListArchiveButton2", 0);
			CommonMethod.Robustclick("RenewalLocationListArchiveButton2");
		}
		if (CommonMethod.isElementsExist("RenewalLocationListArchiveToasterMsg", 7)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationListArchiveToasterMsg", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("RenewalLocationListArchiveToasterMsg", 1);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		int var = CommonMethod.ElementSize("RenewalLocationListRestoreButtonValid");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "2", "Restore button count mismatch");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationListRestoreButton", 0);
		CommonMethod.Robustclick("RenewalLocationListRestoreButton");
		if (CommonMethod.isElementsExist("RenewalLocationListArchiveToasterMsg", 7)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationListArchiveToasterMsg", 0);
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("RenewalLocationListArchiveToasterMsg", 1);
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		int var1 = CommonMethod.ElementSize("RenewalLocationListRestoreButtonValid");
		CommonMethod.negativesoftassertFieldValid(String.valueOf(var1), "1", "Restore button count mismatch");
		CommonMethod.refreshBrowser();
	}

	public void ValidateAddedLocations() throws Exception {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationListTableLoading", 0);
		CommonMethod.RobustclickElementVisible("LocationListTableLoading", "LocationListTable");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		// Disable Add loc
		if (TestCaseName
				.equalsIgnoreCase("Healthsafety_TC_20_05_ValidateAddedLocationsArchieveAddedAndImportedLocations")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalAddedLocationArchiveButtonDisable", 0);
			CommonMethod.Robustclick("RenewalAddedLocationArchiveButtonDisable");
		}
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("RenewalAddedLocationArchiveButtonDisable");
		CommonMethod.assertisElementPresentFalse("RenewalAddedLocationArchiveButtonDisable",
				"Added Location Archive button is visible");
		// Disable Bulk Loc
		if (TestCaseName
				.equalsIgnoreCase("Healthsafety_TC_20_05_ValidateAddedLocationsArchieveAddedAndImportedLocations")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalImportLocationArchiveButtonDisable1", 0);
			CommonMethod.Robustclick("RenewalImportLocationArchiveButtonDisable1");
		}
		CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("RenewalImportLocationArchiveButtonDisable1");
		CommonMethod.assertisElementPresentFalse("RenewalImportLocationArchiveButtonDisable1",
				"Import Archive button is visible");
	}

	public void ValidateConfirmLocations(String SheetName, int rowNum) throws Exception {
//		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
//		CommonMethod.RobustclickElementVisible("WellV2DashboardTab", "WellV2DashboardTab");
//		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
//		CommonMethod.RobustclickElementVisible("WellV2DashboardTab", "RenewalConfirmLocationInDashboard");
//		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalConfirmLocationInDashboard", 0);
//		CommonMethod.assertisElementPresentTrue("RenewalConfirmLocationInDashboard",
//				"Dashboard Confirm button is not visible");
//		CommonMethod.RobustclickElementVisible("RenewalConfirmLocationInDashboard", "AddButton");
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalLocationConfirmButton", 0);
		CommonMethod.RobustclickElementVisible("RenewalLocationConfirmButton", "RenewalConfirmFinalLocButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalConfirmFinalLocButton", 0);
		CommonMethod.RobustclickElementVisible("RenewalConfirmFinalLocButton", "RenewalConfirmFinalLocMessage");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalConfirmFinalLocMessage", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("RenewalConfirmFinalLocMessage"),
				"Thank you for confirming", "Renewal Confirm Final Message doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalNextFinalLocButton", 0);
		CommonMethod.RobustclickElementVisible("RenewalNextFinalLocButton", "RenewalPaymentLanding");
	}

	public void ValidateRenewalPayment() throws Exception {
		if (TestCaseName.equalsIgnoreCase("Performance_TC_22_04_ConfirmLocations")) {
			CommonMethod.navigateBack();
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.RobustclickElementVisible("WellV2DashboardTab", "WellV2DashboardTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2DashboardTab", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("RenewalConfirmLocationInDashboard", 1);
		CommonMethod.assertisElementPresentFalse("RenewalConfirmLocationInDashboard", "Confirm button is visible");
	}

	public void ValidateRenewalMessageInReviewBeforePayment() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalPaymentErrorMessageInReview", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("RenewalPaymentErrorMessageInReview"),
				"Renewal fee is required before submitting for review",
				"Renewal fee is required message doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalPaymentNavigationFromReview", 0);
		CommonMethod.RobustclickElementVisible("RenewalPaymentNavigationFromReview", "V2ProjectPreBillingPayNowButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectPreBillingPayNowButton", 0);
	}

	public void ValidateRenewalMessageInReviewAfterPayment() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ReviewTab", 0);
		CommonMethod.RobustclickElementVisible("ReviewTab", "Reviewlanding");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("RenewalPaymentErrorMessageInReview", 1);
		CommonMethod.assertisElementPresentFalse("RenewalPaymentErrorMessageInReview",
				"Renewal fee is required message is visible");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrSubmitReview", 0);
		CommonMethod.RobustclickElementVisible("HsrSubmitReview", "HsrSelectedProjectPhaseReview");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("HsrSelectedProjectPhaseReview", 0);
		if (TestCaseName.equalsIgnoreCase("Healthsafety_TC_20_05_RenewalReviewValidateAfterpayment")) {
			CommonMethod.DropdownOptionVisiblity("HsrSelectedProjectPhaseReview",
					"Renewal Preliminary Health-Safety Review", true);
			CommonMethod.DropdownOptionVisiblity("HsrSelectedProjectPhaseReview", "Renewal Final Health-Safety Review",
					true);
			CommonMethod.DropdownOptionVisiblity("HsrSelectedProjectPhaseReview", "Renewal Curative Action Plan Review",
					true);
		} else {
			CommonMethod.DropdownOptionVisiblity("HsrSelectedProjectPhaseReview",
					"Renewal Preliminary Performance Rating Review", true);
			CommonMethod.DropdownOptionVisiblity("HsrSelectedProjectPhaseReview",
					"Renewal Final Performance Rating Review", true);
			CommonMethod.DropdownOptionVisiblity("HsrSelectedProjectPhaseReview", "Renewal Curative Action Review",
					true);
		}
		CommonMethod.refreshBrowser();
	}

	public void noRenewal(String SheetName, int rowNum, String PricingAmount) throws Exception {
		testlog.info("Given User is on Dashboard page");
		if (TestCaseName.equalsIgnoreCase("Performance_TC_22_01_NavigateRenewalAsYes")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2RenewalButton", 0);
			CommonMethod.RobustclickElementVisible("V2RenewalButton", "RenewalTermAndCondition");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalButton", 0);
			CommonMethod.RobustclickElementVisible("RenewalButton", "RenewalTermAndCondition");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalTermAndCondition", 0);
		CommonMethod.ClickCheckbox("RenewalTermAndCondition");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalWprTermAndConditionSaveBtn", 0);
		CommonMethod.RobustclickElementVisible("RenewalWprTermAndConditionSaveBtn",
				"RenewalMultipleLocationRenewalPopupValid");
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("RenewalMultipleLocationRenewalPopupValid", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalMultipleNoLocationRenewal", 0);
		Thread.sleep(3000);
		CommonMethod.RobustclickElementVisible("RenewalMultipleNoLocationRenewal", "RenewalConfirmFinalLocMessage");
		Thread.sleep(3000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalConfirmFinalLocMessage", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("RenewalConfirmFinalLocMessage"),
				"Thank you for confirming", "Renewal Confirm Final Message doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalNextFinalLocButton", 0);
		CommonMethod.RobustclickElementVisible("RenewalNextFinalLocButton", "RenewalPaymentLanding");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalPaymentLanding", 0);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("RenewalPaymentLanding"),
				"Confirm your renewal fees", "Renewal Confirm Final Message doesn't match");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("RenewalPaymentPricingValid", 0);
		String PricingValid = CommonMethod.getText("RenewalPaymentPricingValid").replaceAll("\\W", "");
		data.setCellData(SheetName, "RenewalPricing", rowNum, PricingValid);
		CommonMethod.negativesoftassertFieldValid(PricingValid, PricingAmount, "Renewal Payment Pricing doesn't match");
		CommonMethod.navigateBack();
	}

	public void uploadDocumentToastMessage() throws Exception {
		if (CommonMethod.isElementsExist("PortfolioScorecardDocumentAddedPopup", 5)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScorecardDocumentAddedPopup", 1);
		}
	}

	public void DownloadLocationFile(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocListTr", 0);
		FileUtils.cleanDirectory(new File(downloadPath));
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationDownloadButton", 0);
		CommonMethod.click("LocationDownloadButton");
		testlog.info("And User clicks on Download Review button");
		Thread.sleep(5000);
		boolean fileExistsReturnValue = CommonMethod.isFileDownloaded();
		testlog.info("Then User verifies Downloaded file");
		String fileExists = Boolean.toString(fileExistsReturnValue);
		CommonMethod.negativesoftassertFieldValid(fileExists, "true", "Download Location file doesn't Exist");
		CommonMethod.FileRename(downloadPath, "/Downloads/LocationOccupancyFile.xlsx");
		Thread.sleep(2000);
		portfolioLocationDownload = new XlsReader(
				System.getProperty("user.dir") + "/Downloads/LocationOccupancyFile.xlsx");
		// verify Download file Occupancy column with location table
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("PortfolioLocListTr", 5);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("EstForImportLocation"),
				portfolioLocationDownload.getCellData("Import", "Size (sq ft)*",
						portfolioLocationDownload.findRow("Import", "WELL at scale Test location 1"), 2),
				"Download file Occupancy column with WELL at scale Test location 1 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("EstForImportLocation2"),
				portfolioLocationDownload.getCellData("Import", "Size (sq ft)*",
						portfolioLocationDownload.findRow("Import", "WELL at scale Test location 2"), 2),
				"Download file Occupancy column with WELL at scale Test location 2 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("EstForImportLocation3"),
				portfolioLocationDownload.getCellData("Import", "Size (sq ft)*",
						portfolioLocationDownload.findRow("Import", "WELL at scale Test location 3"), 2),
				"Download file Occupancy column with WELL at scale Test location 3 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("EstForImportLocation4"),
				portfolioLocationDownload.getCellData("Import", "Size (sq ft)*",
						portfolioLocationDownload.findRow("Import", "WELL at scale Test location 4"), 2),
				"Download file Occupancy column with WELL at scale Test location 4 mismatch");
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("EstForImportLocation5"),
				portfolioLocationDownload.getCellData("Import", "Size (sq ft)*",
						portfolioLocationDownload.findRow("Import", "WELL at scale Test location 5"), 2),
				"Download file Occupancy column with WELL at scale Test location 5 mismatch");
	}

	public void inviteTeam() throws Exception {
		testlog.info("Given User is on Team page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAddMemberbtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAddMemberbtn", "PortfolioEmailAddress");
		testlog.info("And User clicks on Add member button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioEmailAddress", 0);
		CommonMethod.sendKeys("PortfolioEmailAddress", "gokulautomationv2@gmail.com");
		testlog.info("And User enter email id field");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioRole", 0);
		if (TestNGTestName.contains("CoreProject") || TestNGTestName.contains("WPR")
				|| TestNGTestName.contains("Community")) {
			CommonMethod.selectdropdownVisibletext("V2ProjectRole", "Acoustician");
		} else {
			CommonMethod.selectdropdownVisibletext("PortfolioRole", "Acoustician");
		}
		testlog.info("And User select the Role");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectMembercbx", 0);
		CommonMethod.ClickCheckbox("V2ProjectMembercbx");
		testlog.info("And User checks the Member checkbox");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectInvitebtn", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectInvitebtn", "TeamInviteButtonCommon");
		testlog.info("And User clicks on Invite button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TeamInviteButtonCommon", 0);
		CommonMethod.JavascriptClickElement("TeamInviteButtonCommon");
		testlog.info("And User clicks on Invite button in table list");
		Thread.sleep(2000);
		if (TestCaseName.equalsIgnoreCase("Community_TC_07_01_InviteTeam")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("TeamInviteButtonCommunityToastermessage", 1);
			CommonMethod.negativesoftassertFieldValid(
					CommonMethod.getattributeValueByTextContent("TeamInviteButtonCommunityToastermessage"),
					"email invite!", "Email Invite Toaster message doesn't match");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentWithException("TeamInviteButtonCommonToastermessage", 1);
			CommonMethod.negativesoftassertFieldValid(
					CommonMethod.getattributeValueByTextContent("TeamInviteButtonCommonToastermessage"),
					"email invite!", "Email Invite Toaster message doesn't match");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("TeamInviteButtonCommonToastermessage", 1);
		testlog.info("Then User verifies sent invite toaster message");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("TeamInviteDeleteButtonCommon", 0);
		CommonMethod.JavascriptClickElement("TeamInviteDeleteButtonCommon");
		testlog.info("And User clicks on Delete button");
		Thread.sleep(2000);
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("TeamInviteDeleteButtonCommonToastermessage", 1);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("TeamInviteDeleteButtonCommonToastermessage"),
				"Invite deleted!", "Delete Invite Toaster message doesn't match");
		testlog.info("And User verifies delete invite toaster message");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("TeamInviteButtonCommon", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("TeamInviteButtonCommon", 1);
		testlog.info("Then User will be redirected to Team list page");
		testlog.pass("**Verifies Invite sent and Delete Invite successfully**");
	}

	public void projectAdminTeam() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("TeamProjectAdministratorEditButton", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("TeamProjectAdministratorDeleteButton", 1);
		CommonMethod.assertisElementPresentFalse("TeamProjectAdministratorEditButton", "EditButton is visible");
		CommonMethod.assertisElementPresentFalse("TeamProjectAdministratorDeleteButton", "DeleteButton is visible");
	}

	public void clickScorecard() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardTab", 0);
		CommonMethod.JavascriptClickElement("ScorecardTab");
		rc.ScorecardLoading();
		testlog.info("And User clicks on ScorecardTab");
	}

	public void clickDocument() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DocumentLibraryTab", 0);
		CommonMethod.JavascriptClickElement("DocumentLibraryTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
		testlog.info("When User clicks on DocumentTab");
		testlog.pass("**Navigate Document successfully**");
	}

	public void clickWellV2Tab() throws IOException, InterruptedException {

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WellV2Tab", 0);
		CommonMethod.JavascriptClickElement("WellV2Tab");
	}

	public void clickDocumentsLibraryAllTabInTasks() throws IOException, InterruptedException {

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortFolioDocumentsLibraryAllTabInTasks", 0);
		CommonMethod.JavascriptClickElement("PortFolioDocumentsLibraryAllTabInTasks");
		testlog.info("When User clicks on All In Tasks Tab");
		testlog.pass("**Navigate All successfully**");
	}

	public void scorecardPagination(String FeatureName, String SheetName, int rowNum, String Commodity, String FileName,
			Boolean PartNameRequired, Boolean VerificationMethodValidationRequired, Boolean NoteRequired,
			Boolean IntentCheckboxRequired) throws Exception {
		rc.ScorecardLoading();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardPageLoadedtr", 20);
		List<WebElement> Feature;
		if (Commodity.contains("Portfolio")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardFeature", 0);
			Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectWPRPFeature", 0);
			Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		}
		testlog.info("Fetching total no. of credits on page");
		testlog.info("TaskName : " + FeatureName);
		boolean flag = false;
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilVisibility("PortfolioScorecardFeatureVerificationTab", 60);
				CommonMethod.click("PortfolioScorecardFeatureVerificationTab");
				testlog.info("And User clicks on VerificationTab");
				CommonMethod.WaitUntilVisibility("PortfolioScoreCardAddOptionbutton", 10);
				CommonMethod.click("PortfolioScoreCardAddOptionbutton");
				testlog.info("And User clicks on AddOption button");
				CommonMethod.clickOnListWebelementFromIndex("PortfolioScoreCardAddButton", 0);
				testlog.info("And User clicks on Add button");
				CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException("AddOptionValid");
				CommonMethod.assertisNotElementPresent("AddOptionValid", "Added option button is visible");
				testlog.info("User verifies Remove button");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationCloseicon", 0);
				CommonMethod.Robustclick("PortfolioScoreCardVerificationCloseicon");
				testlog.info("And User clicks on Closeicon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Assignbutton", 0);
				Thread.sleep(1000);
				CommonMethod.JavascriptClickElement("Assignbutton");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
				CommonMethod.Robustclick("WPRAssignLocCbx", "WPRAssignDisabledbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignSavebtn", 0);
				CommonMethod.Robustclick("WPRAssignSavebtn", "PortfolioScoreCardVerificationAssignLocCancelbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AssignLocCloseIcon", 0);
				CommonMethod.Robustclick("AssignLocCloseIcon");
				CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
				testlog.info("And User clicks on Assign Button");
				CommonMethod.scrollDown();
				for (int i = 0; i <= 6; i++) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn",
							0);
					CommonMethod.JavascriptClickElement("PortfolioScoreCardVerificationUploadbtn");
					generic.uploadModalFirstScreenGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
							VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
					CommonMethod.Robustclick("WPRAssignLocCbx", "PortfolioScorecardValidDisable");
					ScorecardConfirmLocUploadSaveButton();
					rc.uploadDocumentToastMessage();
				}
				testlog.info("And User verifies Document Uploaded successfully toast message");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreCardVerificationUploadbtn", 0);
				CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadbtn");
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException(PortfolioAndRatingLocAccDocumentTableTr,
						5);
				int var = CommonMethod.ElementSize("PortfolioAndRatingLocAccDocumentTableTr");
				CommonMethod.negativesoftassertFieldValid(String.valueOf(var), "5",
						"Pagnition Scorecard table row Count mismatch");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRDocumentPaginationsecond", 0);
				CommonMethod.RobustclickElementVisible("WPRDocumentPaginationsecond", "WPRPaginationNumberText");
				testlog.info("And User clicks on pagination number");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRPaginationNumberText", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentWithException(PortfolioAndRatingLocAccDocumentTableTr,
						2);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("WPRPaginationNumberText"), "6",
						"Document Library Pagition count Doesn't match");
				testlog.info("Then User verifies the pagition Count");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + FeatureName + " doesn't match");
	}

	public void ScorecardUploadSaveButton() throws IOException, InterruptedException {
		CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationAddNote");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndContinuebtn", 0);
		if (TestCaseName.equalsIgnoreCase(
				"Portfolio_CTC_02_12_ValidateScorecardUploadButtonCountAfterClosingTheAssignLocationModal")
				|| TestCaseName.equalsIgnoreCase(
						"Healthsafety_TC_SF_06_06_ValidateScorecardUploadButtonCountAfterClosingTheAssignLocationModal")) {

			CommonMethod.click("SaveAndContinuebtn");
			testlog.info("And User clicks on save button");

		} else {
			CommonMethod.Robustclick("SaveAndContinuebtn", "PortfolioScoreCardVerificationAddNote");
			testlog.info("And User clicks on save button");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
	}

	public void ScorecardUploadUpdateSaveButton() throws IOException, InterruptedException {
		CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationAddNote");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndContinueUpdatebtn", 0);
		CommonMethod.Robustclick("SaveAndContinueUpdatebtn", "PortfolioScoreCardVerificationAddNote");
		testlog.info("And User clicks on save button");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("PortfolioScoreCardVerificationAddNote", 1);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
	}

	public void ScorecardConfirmLocUploadSaveButton() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndExitbtn", 0);
		CommonMethod.Robustclick("SaveAndExitbtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
	}

	public void SaveAndExitbtnUploadPage() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndExitbtnUploadPage", 0);
		CommonMethod.Robustclick("SaveAndExitbtnUploadPage");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
	}

	public void ScorecardConfirmLocBulkUploadSaveButton() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAssignLocCbx", 0);
		if (!CommonMethod.isSelected("WPRAssignLocFirstChildCbx")) {
			CommonMethod.Robustclick("WPRAssignLocCbx", "PortfolioScorecardValidDisable");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SaveAndExitbtn", 0);
		CommonMethod.Robustclick("SaveAndExitbtn");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("AssignLocCloseIcon", 1);
	}

	public void ScorecardNavigation() throws IOException, InterruptedException {
		testlog.info("Given User is on dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("ScorecardTab", 0);
		CommonMethod.RobustclickElementVisible("ScorecardTab", "WPRPortfolioScorecardLanding");
		testlog.info("And User clicks on ScorecardTab");
		rc.ScorecardLoading();
	}

	public void CommonSingleUploadScorecardDocument(String FeatureName, String SheetName, int rowNum, String Commodity,
			String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired) throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		if (Commodity.contains("Portfolio")) {
			Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		} else {
			Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		}
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
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOptionbtn", 0);
					CommonMethod.RobustclickElementVisible("WPRAddOptionbtn", "ScorecardAddedOption");
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
				generic.assignLocationGeneric(Commodity, true, false, false, false, false);
				/** Upload Document for Tasks */
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Uploadbutton", 0);
				CommonMethod.scrollDown();
				if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_03_09_DataReportUploadButton")) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UploadButtonDataReport", 0);
					CommonMethod.JavascriptClickElement("UploadButtonDataReport");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadFeatureName", 0);
					CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "NoteComment");
				}
				if (TestCaseName.equalsIgnoreCase("Portfolio_CTC_03_08_MaintenanceReportUploadButton")) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UploadButtonMaintenanceReport", 0);
					CommonMethod.JavascriptClickElement("UploadButtonMaintenanceReport");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardUploadFeatureName", 0);
					CommonMethod.sendKeys("PortfolioScoreCardVerificationAddNote", "NoteComment");
				}
				if (TestCaseName.equalsIgnoreCase("Equity_TC_09_02_AuditUploadDocumentScorecard")) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("UploadButtonAudit", 0);
					CommonMethod.JavascriptClickElement("UploadButtonAudit");
				} else {
					CommonMethod.JavascriptClickElement("Uploadbutton");
				}
				generic.uploadModalCompleteGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
				pathprms.put("Status", "Ready For Review");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false,
						false, true, true, false);
				CommonMethod.scrolldowntoElement("HsrScorecardAplicableVersion");
				CommonMethod.JavascriptClickElement(ele);
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
				break;

			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + FeatureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void CommonSingleUploadScorecardDocumentInOptn(String FeatureName, String SheetName, int rowNum,
			String Commodity, String FileName, Boolean PartNameRequired, Boolean VerificationMethodValidationRequired,
			Boolean NoteRequired, Boolean IntentCheckboxRequired) throws Exception {
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
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WPRAddOptionbtn", 0);
					CommonMethod.RobustclickElementVisible("WPRAddOptionbtn", "ScorecardAddedOption");
					testlog.info("And User clicks on save button");
					CommonMethod.Robustclick("WPRAddOptionCloseIcon");
					CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WPRAddOptionCloseIcon", 1);
					generic.assignLocationGeneric(Commodity, true, false, false, false, false);
				}
				if (FileName.contains("Audit")) {
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioHsrOptnUploadButtonAudit", 0);
					CommonMethod.JavascriptClickElement("PortfolioHsrOptnUploadButtonAudit");
				} else {
					CommonMethod.JavascriptClickElement("Uploadbutton");
				}
				generic.uploadModalCompleteGeneric(SheetName, rowNum, Commodity, FileName, PartNameRequired,
						VerificationMethodValidationRequired, NoteRequired, IntentCheckboxRequired);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDocumentUploadbutton", 0);
				CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
				pathprms.put("Status", "Ready For Review");
				generic.validateUploadedDocumentTableGeneric(SheetName, rowNum, Commodity, false, false, false, false,
						false, true, true, false);
				CommonMethod.scrolldowntoElement("HsrScorecardAplicableVersion");
				CommonMethod.JavascriptClickElement(ele);
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
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + FeatureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void CommonSingleUploadUpdateScorecardDocument(String FeatureName, String PartName, String SheetName,
			int rowNum, String Commodity, String FileName, Boolean PartNameRequired,
			Boolean VerificationMethodValidationRequired, Boolean NoteRequired, Boolean IntentCheckboxRequired)
			throws Exception {
		testlog.info("Given User is on Scorecard page");
		List<WebElement> Feature;
		if (Commodity.contains("Portfolio")) {
			Feature = CommonMethod.findElements("PortfolioScoreCardFeature");
		} else {
			Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		}
		boolean flag = false;
		testlog.info("Fetching total no. of credits on page");
		for (WebElement ele : Feature) {
			String Creditname = ele.getText();
			Creditname = Creditname.replaceAll("\\.", "");
			if (Creditname.equalsIgnoreCase(FeatureName)) {
				flag = true;
				CommonMethod.JavascriptClickElement(ele);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardFeatureVerificationTab", 0);
				CommonMethod.RobustclickElementVisible("PortfolioScorecardFeatureVerificationTab",
						PortfolioAndRatingLocAccDocumentTable);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
				CommonMethod.scrolldowntoElement("PortfolioDocumentUploadbutton");
				rc.documentTableEditButton();
				testlog.info("And User clicks on edit doc icon");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("WERScorecardRemovePart", 0);
				if (!FileName.contains("Audit")) {
					CommonMethod.Robustclick("WERScorecardRemovePart");
					testlog.info("And User clicks on Remove part");
					CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("WERScorecardRemovePart", 1);
					CommonMethod.RobustclickElementVisible("PortfolioScoreCardVerificationUploadAddfeature",
							"PortfolioScoreCardVerificationSelectFeature");
					testlog.info("And User clicks on Add feature");
					CommonMethod.scrolldowntoElement("PortfolioScoreCardVerificationUploadAddfeature");
					CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(
							"PortfolioScoreCardVerificationSelectFeature", 0);
					CommonMethod.selectdropdownVisibletext("PortfolioScoreCardVerificationSelectFeature", PartName);
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
				rc.ScorecardUploadUpdateSaveButton();
				rc.ScorecardConfirmLocUploadSaveButton();
				testlog.info("And User clicks on update button");
				testlog.info("Then User verifies toaster message for add part");
				CommonMethod.scrolldowntoElement("WPRPortfolioScorecardLanding");
				CommonMethod.JavascriptClickElement(ele);
				break;
			}
		}
		CommonMethod.assertTruebooleanCondition(flag, "Feature Name: " + FeatureName + " doesn't match");
		testlog.pass("**Verifies Scorecard Feature Uploaded Document successful**");
	}

	public void editAdminAchieveDate() throws Exception {
		testlog.info("Given User is on Dashboard page");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditTab", 0);
		CommonMethod.RobustclickElementVisible("EditTab", "V2ProjectAdminFieldsButton");
		testlog.info("When User clicks on EditTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminFieldsButton", 0);
		CommonMethod.Robustclick("V2ProjectAdminFieldsButton", "V2ProjectProjectNameInput");
		testlog.info("And User clicks on AdminFields Button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("EditAchievedStatus", 0);
		CommonMethod.ClickCheckbox("EditAchievedStatus");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AwardedDate", 0);
		CommonMethod.RobustclickElementVisible("AwardedDate", "DatePickerOkButton");
		Thread.sleep(1000);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DatePickerOkButton", 0);
		CommonMethod.RobustclickElementVisible("DatePickerOkButton", "V2ProjectSaveChangesButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSaveChangesButton", 0);
		CommonMethod.Robustclick("V2ProjectSaveChangesButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("V2ProjectSaveChangesButton", 1);
		if (CommonMethod.isElementsExist("ScorecardBannerClose", 30)) {
			CommonMethod.Robustclick("ScorecardBannerClose");
		}
	}

	public void documentTableEditButton() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTable, 0);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
		CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableEditIcon", 0);
		CommonMethod.RobustclickElementVisible("PortfolioAndRatingLocAccDocumentTableEditIcon",
				"PortfolioScoreVerifyUploadVerificationMethod");
		testlog.info("When User clicks on Edit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScoreVerifyUploadVerificationMethod", 0);
	}

	public void documentTableDeleteButton() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
		CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTableDeleteIcon, 0);
		CommonMethod.RobustclickElementVisible(PortfolioAndRatingLocAccDocumentTableDeleteIcon, "DeleteButton");
		testlog.info("When User clicks on Delete button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DeleteButton", 0);
		CommonMethod.Robustclick("DeleteButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentLessThan("DeleteButton", 1);
		testlog.info("And User clicks on Delete Icon");
		testlog.info("And User clicks on Yes Delete button");
		if (CommonMethod.isElementsExist("PortfolioDocListTaskUploadListDeleteToastMessage", 12)) {
			CommonMethod.WaitUntilInVisibility("PortfolioDocListTaskUploadListDeleteToastMessage", 30);
			testlog.info("And User verifies Delete Toast Message Sucessfully");
		}
		testlog.info("And User verifies Delete Toast Message Sucessfully");
		if (!(TestCaseName.equalsIgnoreCase("Portfolio_CTC_02_07_DeleteInDocumentLibrary")
				|| TestCaseName.equalsIgnoreCase("Portfolio_TC_22_03_ValidateRestrictAccessAdminInDocumentLibrary")
				|| TestCaseName.equalsIgnoreCase("Portfolio_TC_22_05_ValidateRestrictAccessTeamManagerInDocument")
				|| TestCaseName.equalsIgnoreCase("Portfolio_CTC_07_08_DeleteDocumentUploadInDocumentLibrary")
				|| TestCaseName.equalsIgnoreCase("Equity_TC_21B_04_ValidateTeamManagerAInDocument")
				|| TestCaseName.equalsIgnoreCase("Equity_TC_21B_05_ValidateAdminInDocument")
				|| TestCaseName.equalsIgnoreCase("Portfolio_TC_22_03_ValidateRestrictAccessAdminInDocumentLibrary"))) {
			CommonMethod.WaitUntilNumberOfElementToBeNotPresentWithException(PortfolioAndRatingLocAccDocumentTableTr);
			CommonMethod.assertisElementPresentFalse("PortfolioAndRatingLocAccDocumentTableTr",
					"Delete Document table list visible");
		}
		testlog.info("And User verifies Document table list count");
	}

	public void VaidDeleteButton() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
		CommonMethod.RobustclickElementVisible("PortfolioAndRatingDeleteEditMenu",
				PortfolioAndRatingLocAccDocumentTableDeleteIcon);
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTableDeleteIcon, 0);
		CommonMethod.assertisElementPresentTrue(PortfolioAndRatingLocAccDocumentTableDeleteIcon,
				"Delete icon element not present");
		testlog.info("And User verifies Delete Icon in Document table");
	}

	public void deleteButtonTooltipMessage() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
		CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan(PortfolioAndRatingLocAccDocumentTableDeleteIcon, 0);
		CommonMethod.RobustclickElementVisible(PortfolioAndRatingLocAccDocumentTableDeleteIcon,"PortfolioDocToolTipDelete");
		testlog.info("When User clicks on Delete button");
	}

	public void editButtonTooltipMessage() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingDeleteEditMenu", 0);
		CommonMethod.click("PortfolioAndRatingDeleteEditMenu");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioAndRatingLocAccDocumentTableEditIcon", 0);
		CommonMethod.RobustclickElementVisible("PortfolioAndRatingLocAccDocumentTableEditIcon",
				"PortfolioDocToolTipDelete");
		testlog.info("When User clicks on Delete button");
	}

	public void locationNavigate() throws Exception {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("LocationsTab", 0);
		CommonMethod.RobustclickElementVisible("LocationsTab", "PortfolioLocationLanding");
		testlog.info("When User clicks on LocationsTab");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioLocationLanding", 0);
	}

	public void alternativesAAPNew(String SheetName, int rowNum, String optModuleName, String featureName)
			throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAapSubmitButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAapSubmitButton", "V2ProjectFeatureDropdown");
		testlog.info("And User clicks on AAPSubmit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubmitButton", 0);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectFeatureDropdown");
		CommonMethod.negativesoftassertPageSource("Feature* is required.", "Feature Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Reason for Alternative Means and Methods * is required.",
				"Reason for Alternative Error Mismatch");
		if (SheetName.equalsIgnoreCase("Portfolio")) {
			CommonMethod.negativesoftassertPageSource("Applicable part(s) * is required.",
					"Applicable part Error Mismatch");
		}
		CommonMethod.scrollUp();
		if (SheetName.equalsIgnoreCase("V2Project")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAlternativeVersionDropdown", 0);
			CommonMethod.selectdropdownValue("V2ProjectAlternativeVersionDropdown", optModuleName);
		}
		Thread.sleep(1000);
		CommonMethod.WaitUntilClickble("V2ProjectAlternativesReasonTextArea", 60)
				.sendKeys("Reason for Alternative Means and Methods");
		CommonMethod.negativesoftassertPageSource("Proposed Alternative Means of Compliance * is required.",
				"Proposed Alternative Means of Compliance Error Mismatch");
		CommonMethod.WaitUntilClickble("V2ProjectAlternativesProposedTextArea", 60)
				.sendKeys("Proposed Alternative Means of Compliance");
		CommonMethod.uploadMultipleFile("DocumentsUpload", SampleJpgfile, SampleJpgfile, "MultipeUploadDeleteicon", 2,
				"MultipeUploadEnableButtonDeleteLink");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectFeatureDropdown", 0);
		Thread.sleep(3000);
		CommonMethod.selectdropdownVisibletext("V2ProjectFeatureDropdown", featureName);
		if (CommonMethod.isElementsExist("V2ProjectApplicablePartCheckBox", 10)) {
			CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			testlog.info("And User checks the ApplicablePart checkbox");
		}
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		if (SheetName.equalsIgnoreCase("Community")) {

			CommonMethod.sendKeys("CommunityAlternativeAAPApplicableParts", "Applicable Part Text");
		}
		testlog.info("And User Upload Feature Document");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubmitButton", 0);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2projectAAPTypeStatus");
		testlog.info("And User clicks on Submit button");
		if (SheetName.equalsIgnoreCase("V2Project") || SheetName.equalsIgnoreCase("Community")) {
			CommonMethod.scrollUp();
			if (optModuleName.equalsIgnoreCase("v2-hsr")) {
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateHSR");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateHSR"),
						"WELL HEALTH-SAFETY", "WELL HEALTH-SAFETY doesn't match");
			}
			if (optModuleName.equalsIgnoreCase("wpr")) {
				String getId = CommonMethod.getattributeValueByTextContent("CommunityAlternativeID");
				String[] stringArray = getId.split("-");
				String getAlternativeID = stringArray[1].trim();
				data.setCellData(SheetName, "AlternativeAapID", rowNum, getAlternativeID);
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWPR");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateWPR"),
						"WELL PERFORMANCE", "WELL HEALTH-SAFETY doesn't match");
			}
			if (optModuleName.equalsIgnoreCase("wer")) {
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWER");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateWER"),
						"WELL EQUITY", "WELL HEALTH-SAFETY doesn't match");
			}
			if (optModuleName.equalsIgnoreCase("CommunityAAP")) {
				String getId = CommonMethod.getattributeValueByTextContent("CommunityAlternativeID");
				String[] stringArray = getId.split("-");
				String getCommunityAlternativeID = stringArray[1].trim();
				data.setCellData(SheetName, "CommunityAlternativeID", rowNum, getCommunityAlternativeID);
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeType"), "AAP",
						"Table FEATURE TYPE doesn't match");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeStatus"), "PENDING",
						"Table FEATURE STATUS doesn't match");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeOwner"), "UI",
						"Table FEATURE OWNER name doesn't match");
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWER");
				CommonMethod.negativesoftassertisElementPresentFalse("V2ProjectAdminAlternativeEditButton",
						"Edit Button", "Edit button is visible for non-admin user");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeInsideStatus"),
						"Pending decision", "STATUS Pending decision doesn't match");
				CommonMethod.negativesoftassertFieldValid(
						CommonMethod.getText("V2ProjectAdminAlternativeMeansCompliance"),
						"Proposed Alternative Means of Compliance", "Means of Compliance Text doesn't match");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("CommunityAlternativeValidateWV1"),
						"WELL V1", "WELL V1 doesn't match");
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeValidateImage1", 0);
				CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeValidateImage2", 0);
			}
			CommonMethod.RobustclickElementVisible("V2ProjectAlternativeBackButton", "V2ProjectAapSubmitButton");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectAAPTypeStatus", 0);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2projectAAPTypeStatus"), "AAP",
					"AAP Alternative doesn't match");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("StoreHsrAAPAlternativeId", 0);
		String StoreHsrAAPAlternativeId = CommonMethod.getattributeValueByTextContent("StoreHsrAAPAlternativeId");
		String[] AAPAlternativeId = StoreHsrAAPAlternativeId.split("-");
		String AAPId = AAPAlternativeId[1];
		data.setCellData(SheetName, "AlternativeHsrAAPID", rowNum, AAPId);
		testlog.info("AlternativeAAPID: " + AAPId);
		System.out.println("AlternativeAAPID: " + AAPId);
		testlog.info("And User verifies the added details");
		testlog.info("And User verifies the Status");
		testlog.pass("**Added alternative AAP documents successfully**");
	}

	public void alternativesEPNew(String SheetName, int rowNum, String optModuleName, String featureName)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectEPSubmitButton", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectEPSubmitButton", "V2ProjectFeatureDropdown");
		testlog.info("And User clicks on EPSubmit button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubmitButton", 0);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2ProjectFeatureDropdown");
		testlog.info("And User clicks on Submit button");
		CommonMethod.negativesoftassertPageSource("Feature* is required.", "Feature Name Error Mismatch");
		CommonMethod.negativesoftassertPageSource("Reason for Equivalency Request * is required.",
				"Reason for Equivalency Error Mismatch");
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		CommonMethod.scrollUp();
		if (SheetName.equalsIgnoreCase("V2Project")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAlternativeVersionDropdown", 0);
			CommonMethod.selectdropdownValue("V2ProjectAlternativeVersionDropdown", optModuleName);
		}
		Thread.sleep(2000);
		CommonMethod.negativesoftassertPageSource(
				"Regions/Countries where Equivalency may be Applicable * is required.",
				"Regions/Countries Equivalency Error Mismatch");
		CommonMethod.WaitUntilClickble("V2ProjectEquivalencyReason", 60).sendKeys("Reason for Equivalency Request");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("DocumentsUpload", 0);
		CommonMethod.uploadMultipleFile("DocumentsUpload", SampleJpgfile, SampleJpgfile, "MultipeUploadDeleteicon", 2,
				"MultipeUploadEnableButtonDeleteLink");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectFeatureDropdown", 0);
		CommonMethod.selectdropdownVisibletext("V2ProjectFeatureDropdown", featureName);
		testlog.info("And User select the Feature");
		data.setCellData(SheetName, "FeatureName", rowNum,
				CommonMethod.getSelectedDropdownValue("V2ProjectFeatureDropdown"));
		testlog.info("FeatureName: " + data.getCellData(SheetName, "FeatureName", rowNum));
		if (CommonMethod.isElementsExist("V2ProjectApplicablePartCheckBox", 10)) {
			CommonMethod.ClickCheckbox("V2ProjectApplicablePartCheckBox");
			testlog.info("And User checks the ApplicablePart checkbox");
		}
		CommonMethod.WaitUntilClickble("V2ProjectEquivalencyCountriesInput", 60)
				.sendKeys("Regions/Countries where Equivalency may be Applicable");
		if (CommonMethod.isElementsExist("V2ProjectVerificationTextArea", 10)) {
			CommonMethod.negativesoftassertPageSource("Verification method within proposed equivalent * is required.",
					"Verification method within proposed equivalent Error Mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectVerificationTextArea", 0);
			CommonMethod.clearAndSendKey("V2ProjectVerificationTextArea",
					"Verification method within proposed equivalent");
			testlog.info("And User enter data to Verification field");
		}
		if (CommonMethod.isElementsExist("PortfolioVerificationTextArea", 10)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioVerificationTextArea", 0);
			CommonMethod.clearAndSendKey("PortfolioVerificationTextArea",
					"Verification method within proposed equivalent");
			testlog.info("And User enter data to Verification field");
		}
		if (CommonMethod.isElementsExist("V2ProjectSimilaritiesTextArea", 10)) {
			CommonMethod.negativesoftassertPageSource("Similarities to WELL feature requirement * is required.",
					"Similarities to WELL feature requirement Error Mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectSimilaritiesTextArea", 0);
			CommonMethod.clearAndSendKey("V2ProjectSimilaritiesTextArea", "Similarities to WELL feature requirement");
			testlog.info("And User enter data to Similarities field");
		}
		if (CommonMethod.isElementsExist("PortfolioSimilaritiesTextArea", 10)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioSimilaritiesTextArea", 0);
			CommonMethod.clearAndSendKey("PortfolioSimilaritiesTextArea", "Similarities to WELL feature requirement");
			testlog.info("And User enter data to Similarities field");
		}
		if (CommonMethod.isElementsExist("V2ProjectDifferencesTextArea", 10)) {
			CommonMethod.negativesoftassertPageSource("Differences from WELL feature requirement * is required.",
					"Differences from WELL feature Error Mismatch");
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectDifferencesTextArea", 0);
			CommonMethod.clearAndSendKey("V2ProjectDifferencesTextArea", "Differences from WELL feature requirement");
			testlog.info("And User enter data to Differences field");
		}
		if (CommonMethod.isElementsExist("PortfolioDifferencesTextArea", 10)) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioDifferencesTextArea", 0);
			CommonMethod.clearAndSendKey("PortfolioDifferencesTextArea", "Differences from WELL feature requirement");
			testlog.info("And User enter data to Differences field");
		}
		CommonMethod.negativesoftassertPageSource("Proposed Alternative Means of Compliance * is required.",
				"Proposed Alternative Means of Compliance Error Mismatch");
		CommonMethod.WaitUntilClickble("V2ProjectAlternativesProposedTextArea", 60)
				.sendKeys("Proposed Alternative Means of Compliance");
		testlog.info(
				"And User clicks on Submit button without entering the mandatory fields and verifies error meassage");
		testlog.info("And User upload feature document");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SubmitButton", 0);
		CommonMethod.RobustclickElementVisible("SubmitButton", "V2projectEPTypeStatus");
		testlog.info("And User clicks on Submit button");
		CommonMethod.scrollUp();
		if (SheetName.equalsIgnoreCase("V2Project")) {
			if (optModuleName.equalsIgnoreCase("v2-hsr")) {
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateHSR");
				System.out.println("HSR Value:" + CommonMethod.getText("V2ProjectAlternativeValidateHSR"));
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateHSR"),
						"WELL HEALTH-SAFETY", "WELL HEALTH-SAFETY doesn't match");
			}
			if (optModuleName.equalsIgnoreCase("wpr")) {
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWPR");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateWPR"),
						"WELL PERFORMANCE", "WELL PERFORMANCE doesn't match");
			}
			if (optModuleName.equalsIgnoreCase("wer")) {
				ClickOnAlterativeRows("V2ProjectAlternativeRow", "V2ProjectAlternativeValidateWER");
				CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2ProjectAlternativeValidateWER"),
						"WELL EQUITY", "WELL EQUITY doesn't match");
			}
			CommonMethod.RobustclickElementVisible("V2ProjectAlternativeBackButton", "V2ProjectEPSubmitButton");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectEPTypeStatus", 0);
			CommonMethod.negativesoftassertFieldValid("V2projectEPTypeStatus", "EP", "EP Alternative doesn't match");
		}
		if (SheetName.equalsIgnoreCase("V2Pilot_Portfolio")) {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAlternative", 0);
			List<String> val = CommonMethod.fetchTableData("V2ProjectAlternative");
			CommonMethod.negativesoftassertFieldValid(val.get(6), "EP", "EP Alternative doesn't match");
		} else {
			CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2projectEPTypeStatus", 0);
			CommonMethod.negativesoftassertFieldValid(CommonMethod.getText("V2projectEPTypeStatus"), "EP",
					"EP Alternative doesn't match");
		}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("StoreHsrEPAlternativeId", 0);
		String StoreHsrEPAlternativeId = CommonMethod.getattributeValueByTextContent("StoreHsrEPAlternativeId");
		String[] AAPAlternativeId = StoreHsrEPAlternativeId.split("-");
		String EPId = AAPAlternativeId[1];
		data.setCellData(SheetName, "AlternativeHsrEPID", rowNum, EPId);
		testlog.info("StoreHsrEPAlternativeId: " + EPId);
		System.out.println("StoreHsrEPAlternativeId: " + EPId);
		testlog.info("Then User verifies the added details");
		testlog.info("And User verifies the Status");
		testlog.pass("**Added alternative EP documents successfully**");
	}

	public void AlternativeChangeStatusAndValidate(String SheetName, int rowNum, String Module)
			throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("AdminNavBar", 0);
		CommonMethod.RobustclickElementVisible("AdminNavBar", "V2ProjectAdminAlternativeNavBar");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("V2ProjectAdminAlternativeNavBar", 0);
		CommonMethod.RobustclickElementVisible("V2ProjectAdminAlternativeNavBar",
				"V2ProjectAdminAlternativeStrategyTextBox");
		if (Module.equalsIgnoreCase("EP")) {
			String getCommunityAlternativeEPID = data.getCellData(SheetName, "AlternativeHsrEPID", rowNum);
			CommonMethod.sendKeys("V2ProjectAdminAlternativeStrategyTextBox", getCommunityAlternativeEPID);
		} else {
			String getCommunityAlternativeID = data.getCellData(SheetName, "AlternativeHsrAAPID", rowNum);
			CommonMethod.sendKeys("V2ProjectAdminAlternativeStrategyTextBox", getCommunityAlternativeID);
		}
		CommonMethod.click("ApplyButton");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("CommunityAlternativeIDLink", 0);
		CommonMethod.RobustclickElementVisible("CommunityAlternativeIDLink", "V2ProjectAdminAlternativeEditButton");
		community.validateCommunityAlternativeStatus(SheetName, rowNum, "Not Approved", "WELL HEALTH-SAFETY");
		community.validateCommunityAlternativeStatus(SheetName, rowNum, "Approved", "WELL HEALTH-SAFETY");
		community.validateCommunityAlternativeStatus(SheetName, rowNum, "Additional Information Requested",
				"WELL HEALTH-SAFETY");
	}

	public void confirmPursing() throws IOException, InterruptedException {

		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPurseYesToNoConfirm", 0);
		CommonMethod.Robustclick("PortfolioScorecardPurseYesToNoConfirm");
		testlog.info("And User click on Cancel button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("PortfolioScorecardPursueToast", 0);
		CommonMethod.negativesoftassertFieldValid(
				CommonMethod.getattributeValueByTextContent("PortfolioScorecardPursueToast"), "Pursue status changed!",
				"Purse Status message Doesn't match");
		testlog.info("And User verifies the Pursue status message");
	}

	public void validateCOA() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("ReceiptCOA", 1);
		CommonMethod.assertisElementPresentTrue("ReceiptCOA", "COA button is not visible");
		CommonMethod.JavascriptClickElement("ReceiptCOA");
		Thread.sleep(2000);
		CommonMethod.switchToChildTab();
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getCurrentUrl(), "Confirmation-of-Agreement.pdf",
				"Confirmation-of-Agreement doesn't match");
		CommonMethod.switchToParentTab();
	}

	public void validateCOAWithPercert() throws IOException, InterruptedException {
		CommonMethod.WaitUntilNumberOfElementToBePresentWithException("ReceiptCOAWithPre", 1);
		CommonMethod.assertisElementPresentTrue("ReceiptCOAWithPre", "COA with Percertificate button is not visible");
		CommonMethod.JavascriptClickElement("ReceiptCOA");
		Thread.sleep(2000);
		CommonMethod.switchToChildTab();
		Thread.sleep(2000);
		CommonMethod.negativesoftassertFieldValid(CommonMethod.getCurrentUrl(), "Confirmation-of-Agreement.pdf",
				"Confirmation-of-Agreement doesn't match");
		CommonMethod.switchToParentTab();
	}
}