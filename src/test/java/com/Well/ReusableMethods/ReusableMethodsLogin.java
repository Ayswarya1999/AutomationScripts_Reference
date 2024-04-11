package com.Well.ReusableMethods;

import java.io.IOException;

import org.zaproxy.clientapi.core.ClientApiException;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsLogin extends BaseClass {
	
	public void Login() throws IOException, InterruptedException {
		testlog.info("Given User navigate to Wellcertified page");
		String Username=null;
		String Password=null;
				if(ModuleName.contains("Faculty")){
				Username = data.getCellData("Login", "AdminUserName", 5);
				Password = data.getCellData("Login", "Password", 5);
				}
				if(ModuleName.contains("V2")){
					Username = data.getCellData("Login", "UserName", 6);
					Password = data.getCellData("Login", "Password", 6);
					}
				if(ModuleName.contains("Common")){
			Username = data.getCellData("Login", "UserName", 3);
			Password = data.getCellData("Login", "Password", 3);
			}
				if(ModuleName.contains("Keystone")){
					Username = data.getCellData("Login", "UserName", 7);
					Password = data.getCellData("Login", "Password", 7);
					}
				if(ModuleName.contains("Cornerstone")){
					Username = data.getCellData("Login", "UserName", 8);
					Password = data.getCellData("Login", "Password", 8);
					}
				if(ModuleName.contains("WELLMembership")){
					Username = data.getCellData("Login", "UserName", 9);
					Password = data.getCellData("Login", "Password", 9);
					}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Username", 0);
		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username", Username);
		CommonMethod.findElementWithRelative("LoginButton", "Password", "above").sendKeys(Password);
		testlog.info("When User enters username and password");
		testlog.info("Sending Username: " + Username);
		testlog.info("Sending Password: " + Password);
		Thread.sleep(1000);
		CommonMethod.scrolldowntoElement("LoginButton");
		CommonMethod.RobustclickElementVisible("LoginButton","SuccessfulLogin");
		testlog.info("And User clicks on Sign IN button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SuccessfulLogin", 0);
		testlog.info("Then User will be redirected to Dashboard page");
		testlog.pass("Verfies Login Successful");	
	}
	
	public void AdminLogin() throws IOException, InterruptedException, ClientApiException {
		rc.SignOut();
		testlog.info("Given User navigate to Wellcertified page");
		String Username=null;
		String Password=null;
		
			if(TestNGTestName.contains("Faculty")) {
				Username = data.getCellData("Login", "AdminUserName", 5);
				Password = data.getCellData("Login", "AdminPassword", 5);
			}
			else {
			Username = data.getCellData("Login", "AdminUserName", 3);
			Password = data.getCellData("Login", "AdminPassword", 3);
			}
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("Username", 0);
		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username", Username);
		CommonMethod.findElementWithRelative("LoginButton", "Password", "above").sendKeys(Password);
		testlog.info("When User enters username and password");
		testlog.info("Sending Username " + Username);
		testlog.info("Sending Password " + Password);
		Thread.sleep(1000);
		CommonMethod.scrolldowntoElement("LoginButton");
		CommonMethod.RobustclickElementVisible("LoginButton","SuccessfulLogin");
		testlog.info("And User clicks on Sign IN button");
		CommonMethod.WaitUntilNumberOfElementToBePresentMoreThan("SuccessfulLogin", 0);
		testlog.info("Then User will be redirected to Dashboard page");
		testlog.pass("Verfies Login Successful");	
	}
	
	public void commonLogin(String Username, String Password) throws IOException, InterruptedException {
		CommonMethod.scrolldowntoElement("Username");
		CommonMethod.sendKeys("Username", Username);
		testlog.info("Sending Username " + Password);
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
	}


