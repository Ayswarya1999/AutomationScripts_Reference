package com.Well.testcases.Exam;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Exam_TC_07_ValidateSadaLearnPracticeExamBundleTest extends BaseClass {
	
	@Test(dependsOnMethods = { "com.Well.testcases.Exam.Exam_TC_06_CancelExamByIdTest.Exam_TC_06_CancelExamById" })
	@Parameters({ "SheetName","rowNum" })
	public void Exam_TC_07_00_RegisterExam(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Register Exam Functionality");
		try {
			exam.RegisterExam(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Exam.Exam_TC_07_ValidateSadaLearnPracticeExamBundleTest.Exam_TC_07_00_RegisterExam" })
	@Parameters({ "SheetName","rowNum" })
	public void Exam_TC_07_01_EnrollExamAndValidateBundleCount(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Enroll Exam Functionality");
		try {
			exam.EnrollExam(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Exam.Exam_TC_07_ValidateSadaLearnPracticeExamBundleTest.Exam_TC_07_01_EnrollExamAndValidateBundleCount" })
	@Parameters({ "SheetName","rowNum" })
	public void Exam_TC_07_02_ValidateSadaLearnPracticeExamBundle(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Sada bundle");
		try {
			exam.ValidateSadaLearnPracticeExamBundle(SheetName, rowNum);
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Exam.Exam_TC_07_ValidateSadaLearnPracticeExamBundleTest.Exam_TC_07_02_ValidateSadaLearnPracticeExamBundle" })
	@Parameters({ "SheetName","rowNum" })
	public void Exam_TC_07_03_Billing(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Payment is Successful");
		try {
		    exam.BillingExam(SheetName, rowNum);
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
	@Test(dependsOnMethods = { "com.Well.testcases.Exam.Exam_TC_07_ValidateSadaLearnPracticeExamBundleTest.Exam_TC_07_03_Billing" })
	@Parameters({ "SheetName","rowNum" })
	public void Exam_TC_07_04_WellAPExamRegisteredData(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"Validate Well AP Exam Registered Data");
		try {
		    exam.ValidateWellAPExamRegisteredData(SheetName, rowNum);
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
