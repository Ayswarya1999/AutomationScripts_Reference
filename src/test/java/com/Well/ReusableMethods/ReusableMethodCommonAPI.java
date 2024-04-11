package com.Well.ReusableMethods;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

import io.restassured.response.Response;

public class ReusableMethodCommonAPI extends BaseClass {
	static String header;
	static JSONObject param = new JSONObject();
	static String HeaderSheetName = "Login";

	/*
	 * public static void ProjectSetupAPI(String SheetName,String colName, int
	 * rowNum, String Country, String ProjectType, String ProjectName, String
	 * Commodity) throws IOException, InterruptedException {
	 * PostRequestAuthenticate(colName, rowNum); StoreAnyProject(SheetName,rowNum,
	 * Country,ProjectType); SignAgreementV2pilotProject(Country, rowNum);
	 * RegisterV2pilotProject(SheetName, rowNum, Country, ProjectType);
	 * BillingV2pilotProject(SheetName, rowNum, ProjectType);
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	public static String PostRequestAuthenticate(String colName, int rowNum) {
		/*
		 * Get Token by authentication
		 */
		String username = data.getCellData("Login", colName, rowNum);
		param.put("email", username);
		param.put("password", data.getCellData("Login", "Password", rowNum));
		System.out.println(param.toString());
		Response res = given().log().all().accept("application/json").contentType("application/json").body(param).when()
				.post("authenticate");
		System.out.println("Response: "+res.asString());
		String header = (res.path("token")).toString();
		header = "Bearer " + header;
		return header;
	}

	public static void StoreAnyProject(String SheetName, int rowNum, String Country, String ProjectType, String Upload, String API,
			String Commodity, String ImportLocation, String ProjectName, Boolean Type) throws IOException, InterruptedException {
		
		String Endpoint = null;
		String FetchProjectNumber = null;
		String Payload = null;
		System.out.println("Commodity: "+Commodity);
		switch (Commodity) {
		case "SingleAsset":
			 Endpoint = "project/store";
			FetchProjectNumber = "project_number";
			Payload = storeNewProjectPayload(SheetName, rowNum, Country, ProjectType, ProjectName, Type).toJSONString();
			header = PostRequestAuthenticate("UserName", 6);
			data.setCellData(HeaderSheetName, "Header", 6, header);
			break;
		case "Portfolio":
			Endpoint = "portfolio/store";
			FetchProjectNumber = "portfolio_number";
			Payload = storeNewWellAtscalePayload(SheetName, rowNum, Country, ProjectType, Upload, API, ImportLocation, ProjectName).toJSONString();
			header = PostRequestAuthenticate("UserName", 3);
			data.setCellData(HeaderSheetName, "Header", 3, header);
			break;
		case "Ratings":
			Endpoint = "portfolio/store";
			FetchProjectNumber = "portfolio_number";
			Payload = storeNewRatingPayload(SheetName, rowNum, Country, ProjectType, Upload, API, ProjectName).toJSONString();
			header = PostRequestAuthenticate("UserName", 3);
			data.setCellData(HeaderSheetName, "Header", 3, header);
			break;
		default:
		}
		testlog.info("Given User set POST service api endpoint");
		testlog.info("When User set Request header and Payload");
		testlog.info("And User Send a POST HTTP request");
		testlog.info("Header Token: " + header);
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.info("And User store token from response body");
		testlog.info("When User set Request header and Payload");
		Response res = given().log().all().accept("application/json").contentType("application/json")
				.header("Authorization", header).body(Payload).when().post(Endpoint);
		testlog.info("And User Send a POST HTTP request");
		System.out.println("Response: "+res.asString());
		int StatusCode = res.getStatusCode();
		Assert.assertEquals(StatusCode, 200, "Verifying status code");
		String ProjectId = res.path("id").toString();
		String ProjectTypeNumber = res.path(FetchProjectNumber).toString();
		data.setCellData(SheetName, "ProjectID", rowNum, ProjectTypeNumber);
		data.setCellData(SheetName, "ID", rowNum, ProjectId);
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.info("And User store Registered id in excel");
		testlog.pass("**Verifies the Registration successful**");

	}

	@SuppressWarnings("unchecked")
	public void SignAgreementProject(String SheetName, int rowNum, String Commodity)
			throws IOException, InterruptedException {
		String Endpoint = null;
		String token = null;
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
		switch (Commodity) {
		case "SingleAsset":
			Endpoint = "project/{project_id}/aggrementSign";
			String ProjectId = data.getCellData(SheetName, "ID", rowNum);
			 token = data.getCellData(HeaderSheetName, "Header", 6);
			pathprms.put("project_id", ProjectId);
			break;
		case "Portfolio":
			Endpoint = "portfolio/{portfolio_id}/aggrementSign";
			String portfolioId = data.getCellData(SheetName, "ID", rowNum);
			token = data.getCellData(HeaderSheetName, "Header", 3);
			pathprms.put("portfolio_id", portfolioId);
			break;
		case "Ratings":
			Endpoint = "portfolio/{portfolio_id}/aggrementSign";
			token = data.getCellData(HeaderSheetName, "Header", 3);
			String WerId = data.getCellData(SheetName, "ID", rowNum);
			pathprms.put("portfolio_id", WerId);
			break;
		default:
		}
		testlog.info("Given User set POST service api endpoint");
		testlog.info("When User set Request header and Payload");
		testlog.info("And User Send a POST HTTP request");
		testlog.info("Header Token: " + token);
		Response res = given().log().all().accept("application/json").contentType("application/json")
				.header("Authorization", token).pathParams(pathprms).when().post(Endpoint);
		System.out.println("Response: "+res.asString());
		int StatusCode = res.getStatusCode();
		Assert.assertEquals(StatusCode, 200, "Verifying status code");
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.info("And User Complete Sign portfolio agreement");
		testlog.pass("**Verifies portfolio agreement sign successfully**");

	}

	@SuppressWarnings("unchecked")
	public static void RegisterProject(String SheetName, int rowNum, String Country, String ProjectType, String Commodity)
			throws IOException, InterruptedException {
		String Endpoint = null;
		String token = null;
		String Payload = null;
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
		switch (Commodity) {
		case "SingleAsset":
			Endpoint = "project/register/{project_id}";
			String ProjectId = data.getCellData(SheetName, "ID", rowNum);
			 token = data.getCellData(HeaderSheetName, "Header", 6);
			pathprms.put("project_id", ProjectId);
			Payload = RegisterProject(SheetName, rowNum, Country, ProjectType).toJSONString();
			break;
		case "Portfolio":
			Endpoint = "portfolio/register/{portfolio_id}";
			String portfolioId = data.getCellData(SheetName, "ID", rowNum);
			token = data.getCellData(HeaderSheetName, "Header", 3);
			pathprms.put("portfolio_id", portfolioId);
			Payload = RegisterNewWellAtscalePayload(SheetName, rowNum, Country, ProjectType).toJSONString();
			break;
		case "Ratings":
			Endpoint = "portfolio/register/{portfolio_id}";
			token = data.getCellData(HeaderSheetName, "Header", 3);
			String WerId = data.getCellData(SheetName, "ID", rowNum);
			pathprms.put("portfolio_id", WerId);
			Payload = "";
			break;
		default:
		}
		testlog.info("Given User set POST service api endpoint");
		testlog.info("When User set Request header and Payload");
		testlog.info("And User Send a POST HTTP request");
		Response res = given().log().all().accept("application/json").contentType("application/json")
				.pathParams(pathprms).header("Authorization", token).body(Payload).when()
				.post(Endpoint);
		System.out.println("Response: "+res.asString());
		int StatusCode = res.getStatusCode();
		Assert.assertEquals(StatusCode, 200, "Verifying status code");
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.info("And User Complete Sign portfolio agreement");
		testlog.pass("**Verifies Complete Sign portfolio agreement successfully**");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void BillingProject(String SheetName, int rowNum, String Country, String ProjectType, String Commodity)
			throws IOException, InterruptedException {
		String Endpoint = null;
		String token = null;
		String Payload = null;
		HashMap pathprms = new HashMap();
		switch (Commodity) {
		case "SingleAsset":
			Endpoint = "project/invoices/{project_id}";
			String ProjectId = data.getCellData(SheetName, "ID", rowNum);
			 token = data.getCellData(HeaderSheetName, "Header", 6);
			pathprms.put("project_id", ProjectId);
			Payload = UpdateProjectInvoice(SheetName, rowNum, Country).toJSONString();
			break;
		case "Portfolio":
			Endpoint = "portfolio/{portfolio_id}/invoices";
			String portfolioId = data.getCellData(SheetName, "ID", rowNum);
			token = data.getCellData(HeaderSheetName, "Header", 3);
			pathprms.put("portfolio_id", portfolioId);
			Payload = UpdateProfolioInvoice(SheetName, rowNum, Country).toJSONString();
			break;
		case "Ratings":
			Endpoint = "portfolio/{portfolio_id}/invoices";
			token = data.getCellData(HeaderSheetName, "Header", 3);
			String Id = data.getCellData(SheetName, "ID", rowNum);
			pathprms.put("portfolio_id", Id);
			Payload = UpdateProfolioInvoice(SheetName, rowNum, Country).toJSONString();;
			break;
		default:
		}
		
		Response res = given().log().all().accept("application/json").contentType("application/json").pathParams(pathprms)
				.header("Authorization", token).when().get(Endpoint);
		System.out.println("Response: "+res.asString());
		int StatusCode = res.getStatusCode();
		Assert.assertEquals(StatusCode, 200, "Verifying status code");
		String invoiceId = (res.path("id[0]")).toString();
		System.out.println("invoiceId: " + invoiceId);
		data.setCellData(SheetName, "InvoiceId", rowNum, invoiceId);
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.info("And User storing Invoice Id in excel from response body");
		testlog.pass("**Storing Invoice Id in excel successfully**");
		/* Complete Payment */
		testlog.info("Given User set GET service api endpoint");
		testlog.info("When User Send a Get HTTP request");
		testlog.info("Request Payload: " + Payload);
		HashMap pathprms1 = new HashMap();
		pathprms1.put("id", invoiceId);
		String adminHeader = PostRequestAuthenticate("AdminUserName", 2);
		data.setCellData(HeaderSheetName, "AdminHeader", 2, header);
		Response response = given().log().all().accept("application/json").contentType("application/json").pathParams(pathprms1)
				.header("Authorization", adminHeader).body(Payload).when().post("admin/invoice/{id}");
		System.out.println("Response: "+response.asString());
		int StatusCodes = response.getStatusCode();
		Assert.assertEquals(StatusCodes, 200, "Verifying status code");
		CommonMethod.refreshBrowser();
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.info("And User Completed Billing Card Payment");
		testlog.pass("**Verifies  Completed Billing Card Payment successfully**");
	}
	
	@SuppressWarnings("unchecked")
	public void V2ToV2pilotPortfolio(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		String portfolioId = data.getCellData(SheetName, "ID", rowNum);
		testlog.info("Given User set GET service api endpoint");
		testlog.info("When User Send a Get HTTP request");
		testlog.info("portfolio_id: " + portfolioId);
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
		pathprms.put("model_id", portfolioId);
		pathprms.put("model_name", "portfolio");
		header = PostRequestAuthenticate("AdminUserName", 2);
		data.setCellData(HeaderSheetName, "AdminHeader", 2, header);
		Response response = given().log().all().accept("application/json").contentType("application/json").pathParams(pathprms)
				.header("Authorization", header).when().post("admin/qa/automation/{model_name}/{model_id}/upgrade");
		System.out.println("Response: "+response.asString());
		int StatusCodes = response.getStatusCode();
		Assert.assertEquals(StatusCodes, 200, "Verifying status code");
		CommonMethod.refreshBrowser();
	}
	////////////// V2project Models

	@SuppressWarnings("unchecked")
	public static JSONObject storeNewProjectPayload(String SheetName, int rowNum, String Country, String ProjectType, String ProjectName, Boolean Type)
			throws IOException, NumberFormatException, InterruptedException {
		String AccountName;
		JSONObject updateData = new JSONObject();
		String ProjectAddress = USfaker.address().streetAddress();
		data.setCellData(SheetName, "Street", rowNum, ProjectAddress);
		String ProjectCity = USfaker.address().cityName();
		int CompanyId = Integer.parseInt(data.getCellData(SheetName, "CompanyId", rowNum));
		data.setCellData(SheetName, "City", rowNum, ProjectCity);
		String PostalCode = USfaker.address().zipCode();
		data.setCellData(SheetName, "PostalCode", rowNum, PostalCode);
		AccountName = ProjectName +"_ " + CommonMethod.randomNumber(8000000);
		testlog.info("ProjectName: "+AccountName);
		data.setCellData(SheetName, "ProjectName", rowNum, AccountName);
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		data.setCellData(SheetName, "AreaSQFT", rowNum, Area);
		String project_type;
		if(Type) {
			project_type ="cs";
		}
		else {
			project_type ="cics";
		}
		updateData.put("name", AccountName);
		updateData.put("first_name", "UI");
		updateData.put("project_type", project_type);
		updateData.put("last_name", "Automation");
		updateData.put("organization", data.getCellData(SheetName, "OrgName", rowNum));
		updateData.put("area", Area);
		updateData.put("sector", data.getCellData(SheetName, "SectorName", rowNum));
		updateData.put("industry", data.getCellData(SheetName, "OrgIndustry", rowNum));
		updateData.put("street", ProjectAddress);
		updateData.put("city", ProjectCity);
		if(Country.equalsIgnoreCase("IN")) {
			updateData.put("country_id", 103);
		}
		else {
			updateData.put("country_id", 236);
		}
		updateData.put("state", data.getCellData(SheetName, "State", rowNum));
		updateData.put("type", ProjectType);
		//updateData.put("primary_space_type_id", CommonMethod.generateSpaceTypes());
		updateData.put("postal_code", PostalCode);
		JSONObject objdata = new JSONObject();
		objdata.put("organization_id", "352");
		objdata.put("company_id", CompanyId);
		updateData.put("enterprise_provider",objdata);
		JSONArray spaceTyp = new JSONArray();
		spaceTyp.add(0, "12");
		updateData.put("space_types", spaceTyp);
		return updateData;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject RegisterProject(String SheetName, int rowNum, String Country, String ProjectType)
			throws IOException, InterruptedException {
		JSONObject updateData = new JSONObject();
		String OwnerName = USfaker.address().firstName();
		int CompanyId = Integer.parseInt(data.getCellData(SheetName, "CompanyId", rowNum));
		data.setCellData(SheetName, "OwnerName", rowNum, OwnerName);
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		data.setCellData(SheetName, "AreaSQFT", rowNum, Area);
		String Regdate = CommonMethod.GenerateCurrentDate();
		updateData.put("doc_sub_date_est", Regdate);
		updateData.put("area", Area);
		updateData.put("pricing_option","single-cycle");
		updateData.put("owner_org", data.getCellData(SheetName, "OrgName", rowNum));
		if(Country.equalsIgnoreCase("IN")) {
			updateData.put("country_id", 103);
		}
		else {
			updateData.put("country_id", 236);
		}
		updateData.put("state", data.getCellData(SheetName, "State", rowNum));
		updateData.put("owner_name", OwnerName);
		updateData.put("owner_street", data.getCellData(SheetName, "OwnerStreet", rowNum));
		updateData.put("owner_city", data.getCellData(SheetName, "OwnerCity", rowNum));
		String OwnerPhone = USfaker.number().digits(10);
		data.setCellData(SheetName, "OwnerPhone", rowNum, OwnerPhone);
		updateData.put("owner_country_code", Country);
		updateData.put("owner_state", data.getCellData(SheetName, "OwnerState", rowNum));
		updateData.put("owner_zip", data.getCellData(SheetName, "OwnerPostalCode", rowNum));
		updateData.put("owner_email", data.getCellData(SheetName, "OwnerEmail", 2));
		updateData.put("owner_phone", data.getCellData(SheetName, "PhoneNum", 2));
		updateData.put("street", data.getCellData(SheetName, "Street", rowNum));
		updateData.put("city", data.getCellData(SheetName, "City", rowNum));
		updateData.put("postal_code", data.getCellData(SheetName, "PostalCode", rowNum));
		updateData.put("construction_completion_date", Regdate);
		String company_id = data.getCellData(SheetName, "CompanyId", rowNum);
		updateData.put("company_id", Integer.valueOf(company_id));
		updateData.put("sector", data.getCellData(SheetName, "SectorName", rowNum));
		updateData.put("industry", data.getCellData(SheetName, "OrgIndustry", rowNum));
		JSONObject objdata = new JSONObject();
		objdata.put("organization_id", "352");
		objdata.put("company_id", CompanyId);
		updateData.put("enterprise_provider",objdata);
		return updateData;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject UpdateProjectInvoice(String SheetName, int rowNum, String Country) throws IOException {
		JSONObject updateData = new JSONObject();
		updateData.put("description", "Test Description");
		updateData.put("country_code", Country);
		updateData.put("state", data.getCellData(SheetName, "State", rowNum));
		updateData.put("status", data.getCellData(SheetName, "payment", 2));
		updateData.put("payment_date", CommonMethod.GenerateCurrentDate());
		updateData.put("payment_type", data.getCellData(SheetName, "PaymentType", 2));
		String Name = USfaker.address().firstName();
		updateData.put("name", Name);
		updateData.put("email", data.getCellData(SheetName, "OwnerEmail", 2));
		String company_id = data.getCellData(SheetName, "CompanyId", rowNum);
		updateData.put("company_id", Integer.valueOf(company_id));
		updateData.put("organization", data.getCellData(SheetName, "OrgName", 2));
		updateData.put("payment_reference", "01");
		updateData.put("postal_code", data.getCellData(SheetName, "PostalCode", 2));
		updateData.put("street", data.getCellData(SheetName, "Street", 2));
		JSONObject itemObj = new JSONObject();
		JSONArray itemArr = new JSONArray();
		itemObj.put("description", USfaker.company().name());
		itemObj.put("quantity", 1);
		itemObj.put("unit_cost", data.getCellData(SheetName, "UnitCost", 2));
		itemArr.add(itemObj);
		updateData.put("items", itemArr);
		return updateData;
	}
	
	//Portfolio model
	
	@SuppressWarnings("unchecked")
	public static JSONObject storeNewWellAtscalePayload(String SheetName, int rowNum, String Country, String ProjectType, String Upload, String API, String ImportLocation, String ProjectName)
			throws IOException, NumberFormatException, InterruptedException {
		JSONObject updateData = new JSONObject();
		String AccountName = null;
		String ProjectAddress = USfaker.address().streetAddress();
		data.setCellData(SheetName, "Street", rowNum, ProjectAddress);
		String ProjectCity = USfaker.address().cityName();
		data.setCellData(SheetName, "City", rowNum, ProjectCity);
		String PostalCode = USfaker.address().zipCode();
		data.setCellData(SheetName, "PostalCode", rowNum, PostalCode);
		AccountName = ProjectName +"_ " + CommonMethod.randomNumber(8000000);
		data.setCellData(SheetName, "AccountName", rowNum, AccountName);
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		data.setCellData(SheetName, "AreaSQFT", rowNum, Area);
		int CompanyId = Integer.parseInt(data.getCellData(SheetName, "CompanyId", rowNum));
		updateData.put("name", AccountName);
		updateData.put("area", Area);
		updateData.put("area_not_sure", false);
		updateData.put("company_id", CompanyId);
		updateData.put("sector", data.getCellData(SheetName, "SectorName", rowNum));
		updateData.put("industry", data.getCellData(SheetName, "OrgIndustry", rowNum));
		updateData.put("no_of_assets", data.getCellData(SheetName, "Location", rowNum));
		updateData.put("owner_street", ProjectAddress);
		updateData.put("owner_org", data.getCellData(SheetName, "OrgName", rowNum));
		updateData.put("owner_city", ProjectCity);
		updateData.put("owner_country_code", Country);
		updateData.put("owner_state", data.getCellData(SheetName, "State", rowNum));
		updateData.put("type", ProjectType);
		updateData.put("owner_postal_code", PostalCode);
		updateData.put("total_no_of_assets", data.getCellData(SheetName, "Location", rowNum));
		updateData.put("well_interest_reason", data.getCellData(SheetName, "InterestReason", rowNum));
		updateData.put("well_interest_input", data.getCellData(SheetName, "InterestReason", rowNum));
		updateData.put("legal_entity", data.getCellData(SheetName, "InterestReason", rowNum));
		updateData.put("other", data.getCellData(SheetName, "InterestReason", rowNum));
		JSONArray spaceTyp = new JSONArray();
		spaceTyp.add(0, "2");
		spaceTyp.add(1, "3");
		updateData.put("space_types", spaceTyp);
		JSONArray primaryLocation = new JSONArray();
		primaryLocation.add(0, "Africa");
		updateData.put("location", primaryLocation);
		JSONObject objdata = new JSONObject();
		objdata.put("organization_id", "352");
		objdata.put("company_id", CompanyId);
		updateData.put("enterprise_provider",objdata);
		return updateData;
	}


	@SuppressWarnings("unchecked")
	public static JSONObject RegisterNewWellAtscalePayload(String SheetName, int rowNum, String Country, String ProjectType)
			throws IOException {
		JSONObject updateData = new JSONObject();
		String OwnerName = USfaker.address().firstName();
		int CompanyId = Integer.parseInt(data.getCellData(SheetName, "CompanyId", rowNum));
		data.setCellData(SheetName, "OwnerName", rowNum, OwnerName);
			updateData.put("name", data.getCellData(SheetName, "AccountName", rowNum));
		updateData.put("area", data.getCellData(SheetName, "AreaSQFT", rowNum));
		updateData.put("no_of_assets", data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum));
		updateData.put("owner_name", OwnerName);
		updateData.put("owner_street", data.getCellData(SheetName, "Street", rowNum));
		updateData.put("owner_city", data.getCellData(SheetName, "City", rowNum));
		String OwnerPhone = USfaker.number().digits(10);
		data.setCellData(SheetName, "OwnerPhone", rowNum, OwnerPhone);
		updateData.put("owner_country_code", Country);
		updateData.put("owner_state", data.getCellData(SheetName, "State", rowNum));
		updateData.put("owner_postal_code", data.getCellData(SheetName, "PostalCode", rowNum));
		updateData.put("owner_email", data.getCellData(SheetName, "OwnerEmail", 2));
		updateData.put("owner_phone", data.getCellData(SheetName, "OwnerPhone", 2));
		updateData.put("type", ProjectType);
		updateData.put("total_no_of_assets",
				Integer.parseInt(data.getCellData(SheetName, "EstimatedNumberOfLocation", rowNum)));
		updateData.put("well_interest_reason", data.getCellData(SheetName, "InterestReason", rowNum));
		updateData.put("well_interest_input", data.getCellData(SheetName, "InterestReason", rowNum));
		updateData.put("area_not_sure", true);
		updateData.put("legal_entity", data.getCellData(SheetName, "InterestReason", rowNum));
		JSONObject objdata = new JSONObject();
		objdata.put("organization_id", "352");
		objdata.put("company_id", CompanyId);
		updateData.put("enterprise_provider",objdata);
		return updateData;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject UpdateProfolioInvoice(String SheetName, int rowNum, String Country) throws IOException {
		JSONObject updateData = new JSONObject();
		updateData.put("description", "Test Description");
		updateData.put("country_code", Country);
		updateData.put("state", data.getCellData(SheetName, "State", rowNum));
		updateData.put("status", data.getCellData(SheetName, "payment", 2));
		updateData.put("payment_date", CommonMethod.GenerateCurrentDate());
		updateData.put("payment_type", data.getCellData(SheetName, "PaymentType", 2));
		String Name = USfaker.address().firstName();
		updateData.put("name", Name);
		updateData.put("email", data.getCellData(SheetName, "OwnerEmail", 2));
		updateData.put("company_id", data.getCellData(SheetName, "CompanyId", 2));
		updateData.put("organization", data.getCellData(SheetName, "OrgName", 2));
		updateData.put("payment_reference", "01");
		updateData.put("postal_code", data.getCellData(SheetName, "PostalCode", 2));
		updateData.put("street", data.getCellData(SheetName, "Street", 2));
		JSONObject itemObj = new JSONObject();
		JSONArray itemArr = new JSONArray();
		itemObj.put("description", USfaker.company().name());
		itemObj.put("quantity", 1);
		itemObj.put("unit_cost", data.getCellData(SheetName, "UnitCost", 2));
		itemArr.add(itemObj);
		updateData.put("items", itemArr);
		return updateData;
	}
	
	//wer module
	@SuppressWarnings("unchecked")
	public static JSONObject storeNewRatingPayload(String SheetName, int rowNum, String Country, String ProjectType, String Upload, String API, String ProjectName)
			throws IOException, NumberFormatException, InterruptedException {
		JSONObject updateData = new JSONObject();
		String ProjectAddress = USfaker.address().streetAddress();
		data.setCellData(SheetName, "Street", rowNum, ProjectAddress);
		String ProjectCity = USfaker.address().cityName();
		data.setCellData(SheetName, "City", rowNum, ProjectCity);
		String PostalCode = USfaker.address().zipCode();
		data.setCellData(SheetName, "PostalCode", rowNum, PostalCode);
		String erollName = ProjectName + "_"+CommonMethod.randomNumber(8000000);
		data.setCellData(SheetName, "projectName", rowNum, erollName);
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		data.setCellData(SheetName, "AreaSQFT", rowNum, Area);
		int CompanyId = Integer.parseInt(data.getCellData(SheetName, "CompanyId", rowNum));
		String OwnerName = USfaker.address().firstName();
		updateData.put("name", erollName);
		updateData.put("email", "frontendauthenticateduser@gmail.com");
		updateData.put("company_id", CompanyId);
		updateData.put("sector", data.getCellData(SheetName, "SectorName", rowNum));
		updateData.put("industry", data.getCellData(SheetName, "OrgIndustry", rowNum));
		updateData.put("no_of_assets", 1);
		updateData.put("owner_name", OwnerName);
		updateData.put("owner_street", ProjectAddress);
		updateData.put("owner_org", data.getCellData(SheetName, "OrgName", rowNum));
		updateData.put("owner_city", ProjectCity);
		updateData.put("owner_country_code", Country);
		updateData.put("owner_state", data.getCellData(SheetName, "State", rowNum));
		updateData.put("type", ProjectType);
		updateData.put("owner_postal_code", PostalCode);
		updateData.put("billing_name", OwnerName);
		updateData.put("registration_on_behalf_organization", 1);
		JSONArray spaceTyp = new JSONArray();
		spaceTyp.add(0, "2");
		spaceTyp.add(1, "3");
		updateData.put("space_types", spaceTyp);
		JSONArray primaryLocation = new JSONArray();
		primaryLocation.add(0, "Africa");
		updateData.put("location", primaryLocation);
		JSONObject objdata = new JSONObject();
		objdata.put("organization_id", "352");
		objdata.put("company_id", CompanyId);
		updateData.put("enterprise_provider",objdata);
		return updateData;
	}

	
	@SuppressWarnings("unchecked")
	public void SignAgreement(String SheetName, int rowNum, String ProjectType, String Commodity)
			throws IOException, InterruptedException {
		String token = null;
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
			token = data.getCellData(HeaderSheetName, "Header", 3);
			String Id = data.getCellData(SheetName, "ID", rowNum);
			pathprms.put("portfolio_id", Id);
		testlog.info("Given User set POST service api endpoint");
		testlog.info("When User set Request header and Payload");
		testlog.info("And User Send a POST HTTP request");
		testlog.info("Header Token: " + token);
		JSONObject updateData = new JSONObject();
		updateData.put("type", ProjectType);
		Response res = given().log().all().accept("application/json").contentType("application/json")
				.header("Authorization", token).pathParams(pathprms).body(updateData.toJSONString()).when().post("portfolio/agreement/{portfolio_id}");
		System.out.println(res.asString());
		int StatusCode = res.getStatusCode();
		Assert.assertEquals(StatusCode, 200, "Verifying status code");
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.info("And User Complete Sign portfolio agreement");
		testlog.pass("**Verifies portfolio agreement sign successfully**");
        Thread.sleep(10000);
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject UpdateNonEhanceRatingPayload(String SheetName, int rowNum, String Country, String ProjectType, String Upload, String API)
			throws IOException, NumberFormatException, InterruptedException {
		JSONObject updateData = new JSONObject();
		String ProjectAddress = USfaker.address().streetAddress();
		data.setCellData(SheetName, "Street", rowNum, ProjectAddress);
		String ProjectCity = USfaker.address().cityName();
		data.setCellData(SheetName, "City", rowNum, ProjectCity);
		String PostalCode = USfaker.address().zipCode();
		data.setCellData(SheetName, "PostalCode", rowNum, PostalCode);
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		data.setCellData(SheetName, "AreaSQFT", rowNum, Area);
		String OwnerName = USfaker.address().firstName();
		updateData.put("name", data.getCellData(SheetName, "HsrName", rowNum));
		updateData.put("type", ProjectType);
		updateData.put("no_of_assets", 1);
		updateData.put("owner_name", OwnerName);
		updateData.put("owner_street", ProjectAddress);
		updateData.put("owner_org", data.getCellData(SheetName, "OrgName", rowNum));
		updateData.put("owner_city", ProjectCity);
		updateData.put("owner_country_code", Country);
		updateData.put("owner_state", data.getCellData(SheetName, "State", rowNum));
		updateData.put("billing_name", OwnerName);
		updateData.put("area", 110);
	//	updateData.put("hsr_enhanced",0);
		return updateData;
	}


	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void UpdateNonEnhanced(String SheetName, int rowNum, String Country, String ProjectType, String Upload, String API,
			String Commodity) throws IOException, InterruptedException {
		String Endpoint = null;
		String token = null;
		HashMap pathprms = new HashMap();
		String adminHeader = PostRequestAuthenticate("AdminUserName", 2);
			//token = data.getCellData(HeaderSheetName, "Header", 3);
			String Id = data.getCellData(SheetName, "ID", rowNum);
			pathprms.put("portfolio_id", Id);
		testlog.info("Given User set POST service api endpoint");
		testlog.info("When User set Request header and Payload");
		testlog.info("And User Send a POST HTTP request");
		testlog.info("Header Token: " + token);
		String Payload =UpdateNonEhanceRatingPayload(SheetName, rowNum, Country, ProjectType, Upload, API).toJSONString();
		Response res = given().log().all().accept("application/json").contentType("application/json")
				.header("Authorization", adminHeader).pathParams(pathprms).when().post("admin/qa/automation/portfolio/{portfolio_id}/convert/non-enhanced");
		System.out.println(res.asString());
		int StatusCode = res.getStatusCode();
		Assert.assertEquals(StatusCode, 200, "Verifying status code");
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.info("And User Complete Sign portfolio agreement");
	}
	
	@SuppressWarnings("unchecked")
	public static void DatePickerAPI(String SheetName, int rowNum)
			throws IOException, InterruptedException {
		JSONObject Payload = new JSONObject();
		Payload.put("doc_sub_date_est",CommonMethod.getNextYear());
		
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
			String ProjectId = data.getCellData(SheetName, "ID", rowNum);
			 String token = data.getCellData(HeaderSheetName, "Header", 6);
			pathprms.put("project_id", ProjectId);
			Response res = given().log().all().accept("application/json").contentType("application/json")
					.header("Authorization", token).pathParams(pathprms).body(Payload).when().post("project/{project_id}/docSubDateEstUpdate");
			System.out.println(res.asString());
			int StatusCode = res.getStatusCode();
			Assert.assertEquals(StatusCode, 200, "Verifying status code");
			testlog.info("Then User verifies response body");
			testlog.info("And User verifies Status Code");
			CommonMethod.refreshBrowser();
}
	
	@SuppressWarnings("unchecked")
	public static void getProjectIdByProjectNumAPI(String SheetName, int rowNum)
			throws IOException, InterruptedException {	
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
			String ProjectNum = data.getCellData(SheetName, "ProjectID", rowNum);
			header = PostRequestAuthenticate("UserName", 6);
			data.setCellData(HeaderSheetName, "Header", 6, header);
			pathprms.put("project_number", ProjectNum);
			Response res = given().log().all().accept("application/json").contentType("application/json")
					.header("Authorization", header).pathParams(pathprms).when().get("project/byNumber/{project_number}");
			System.out.println(res.asString());
			int StatusCode = res.getStatusCode();
			Assert.assertEquals(StatusCode, 200, "Verifying status code");
			testlog.info("Then User verifies response body");
			testlog.info("And User verifies Status Code");
			System.out.println("Response: "+res.asString());
			String projectId = (res.path("id")).toString();
			System.out.println("Id: "+projectId);
			data.setCellData(SheetName, "ID", rowNum, projectId);
	}
	
	@SuppressWarnings("unchecked")
	public static void getWerScorecardIdByProjectNumAPI(String SheetName, int rowNum)
			throws IOException, InterruptedException {	
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
			String ProjectNum = data.getCellData(SheetName, "ProjectID", rowNum);
			header = PostRequestAuthenticate("UserName", 6);
			data.setCellData(HeaderSheetName, "Header", 6, header);
			pathprms.put("project_number", ProjectNum);
			Response res = given().log().all().accept("application/json").contentType("application/json")
					.header("Authorization", header).pathParams(pathprms).when().get("project/byNumber/{project_number}");
			System.out.println(res.asString());
			int StatusCode = res.getStatusCode();
			Assert.assertEquals(StatusCode, 200, "Verifying status code");
			testlog.info("Then User verifies response body");
			testlog.info("And User verifies Status Code");
			System.out.println("Response: "+res.asString());
			String werScorecardId = (res.path("wer.scorecard_id")).toString();
			System.out.println("werScorecardId: "+werScorecardId);
			data.setCellData(SheetName, "ScorecardWerOptn", rowNum, werScorecardId);
	}
	
	
	@SuppressWarnings("unchecked")
	public void storeScorecardIdAPI(String SheetName, int rowNum, String scorecardColumnName, String scorecardPairName)
			throws IOException, InterruptedException {	
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
			String ProjectId = data.getCellData(SheetName, "ID", rowNum);
			header = PostRequestAuthenticate("UserName", 6);
			data.setCellData(HeaderSheetName, "Header", 6, header);
			pathprms.put("project_id", ProjectId);
			Response res = given().log().all().accept("application/json").contentType("application/json")
					.header("Authorization", header).pathParams(pathprms).when().get("project/{project_id}");
			System.out.println(res.asString());
			int StatusCode = res.getStatusCode();
			Assert.assertEquals(StatusCode, 200, "Verifying status code");
			testlog.info("Then User verifies response body");
			testlog.info("And User verifies Status Code");
			System.out.println("Response: "+res.asString());
			String scorecard_id = (res.path(scorecardPairName)).toString();
			System.out.println("scorecard_id: "+scorecard_id);
			data.setCellData(SheetName, scorecardColumnName, rowNum, scorecard_id);
	}
	 
	@SuppressWarnings("unchecked")
	public void fillScorecardAPI(String SheetName, int rowNum, String scorecardColumnName)
			throws IOException, InterruptedException {	
		
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
		String scorecardId = data.getCellData(SheetName, scorecardColumnName, rowNum);
		String adminHeader = PostRequestAuthenticate("AdminUserName", 2);
		data.setCellData(HeaderSheetName, "AdminHeader", 2, header);
			pathprms.put("scorecard_id", scorecardId);
			Response res = given().log().all().accept("application/json").contentType("application/json")
					.header("Authorization", adminHeader).pathParams(pathprms).when().post("admin/qa/automation/scorecard/{scorecard_id}/fill");
			System.out.println(res.asString());
			int StatusCode = res.getStatusCode();
			Assert.assertEquals(StatusCode, 200, "Verifying status code");
			testlog.info("Then User verifies response body");
			testlog.info("And User verifies Status Code");
			System.out.println("Response: "+res.asString());
		   v2project.refreshScorecardOptn();
	}
	
	@SuppressWarnings("unchecked")
	public void fillScorecardAPIWithPoints(String SheetName, int rowNum, String scorecardColumnName, String Point)
			throws IOException, InterruptedException {	
		
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
		String scorecardId = data.getCellData(SheetName, scorecardColumnName, rowNum);
		String adminHeader = PostRequestAuthenticate("AdminUserName", 2);
		data.setCellData(HeaderSheetName, "AdminHeader", 2, header);
		param.put("threshold_points", Point);
			pathprms.put("scorecard_id", scorecardId);
			Response res = given().log().all().accept("application/json").contentType("application/json")
					.header("Authorization", adminHeader).body(param).pathParams(pathprms).when().post("admin/qa/automation/scorecard/{scorecard_id}/fill");
			System.out.println(res.asString());
			int StatusCode = res.getStatusCode();
			Assert.assertEquals(StatusCode, 200, "Verifying status code");
			testlog.info("Then User verifies response body");
			testlog.info("And User verifies Status Code");
			System.out.println("Response: "+res.asString());
		   v2project.refreshScorecardOptn();
	}
	
	@SuppressWarnings("unchecked")
	public static void storeRatingScorecardIdAPI(String SheetName, int rowNum,  String scorecardPairName)
			throws IOException, InterruptedException {	
		@SuppressWarnings("rawtypes")
		HashMap pathprms = new HashMap();
			String portfolio_id = data.getCellData(SheetName, "ID", rowNum);
			header = PostRequestAuthenticate("UserName", 3);
			data.setCellData(HeaderSheetName, "Header", 3, header);
			pathprms.put("portfolio_id", portfolio_id);
			Response res = given().log().all().accept("application/json").contentType("application/json")
					.header("Authorization", header).pathParams(pathprms).when().get("portfolio/{portfolio_id}");
			System.out.println(res.asString());
			int StatusCode = res.getStatusCode();
			Assert.assertEquals(StatusCode, 200, "Verifying status code");
			testlog.info("Then User verifies response body");
			testlog.info("And User verifies Status Code");
			System.out.println("Response: "+res.asString());
			String scorecard_id = (res.path(scorecardPairName)).toString();
			System.out.println("scorecard_id: "+scorecard_id);
			data.setCellData(SheetName, "ScorecardId", rowNum, scorecard_id);
	}
	
	public static void getMembershipId(String SheetName, int rowNum) throws InterruptedException {
		/* * Get Token by authentication */
		testlog.info("Given User set POST service api endpoint");
           header = PostRequestAuthenticate("UserName", 9);
			Response res = given().log().all().accept("application/json").contentType("application/json")
					.header("Authorization", header).pathParams(pathprms).when().get("membership/subscribe");
			System.out.println(res.asString());
			int StatusCode = res.getStatusCode();
			Assert.assertEquals(StatusCode, 200, "Verifying status code");
			testlog.info("Then User verifies response body");
			testlog.info("And User verifies Status Code");
			System.out.println("Response: "+res.asString());
			String membership_id = (res.path("id")).toString();
			String membership_name = (res.path("name")).toString();
			String membership_email = (res.path("owner_email")).toString();
			System.out.println("membership_id: "+membership_id);
			testlog.info("membership_id: "+membership_id);
			data.setCellData(SheetName, "MembershipId", rowNum, membership_id);
			data.setCellData(SheetName, "MembershipName", rowNum, membership_name);
			data.setCellData(SheetName, "MembershipOwnerEmail", rowNum, membership_email);
			System.out.println("MembershipName: "+membership_name);
			System.out.println("MembershipOwnerEmail: "+membership_email);
}
	
public void UserSeederDB() throws IOException {
	Response res;
		if(Environment.equalsIgnoreCase("TEST")) {
		 res =given().when().get("https://test-v2-api.wellcertified.com/user-seeder");
		}
		else {
		 res =given().when().get("https://qas-v2-api.wellcertified.com/user-seeder");
		}
		System.out.println("Response: "+res.asString());
		int StatusCode = res.getStatusCode();
		Assert.assertEquals(StatusCode, 200, "Verifying status code");
		testlog.info("Then User verifies response body");
		testlog.info("And User verifies Status Code");
		testlog.pass("**Verifies User Seeder DB**");
	}
} 



