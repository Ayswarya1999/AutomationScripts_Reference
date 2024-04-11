package com.Well.testcases.Community;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Community_TC_09_ErrorNegativeAssertTest extends BaseClass {

	@Test
	@Parameters({ "SheetName", "rowNum" })
	public void Community_TC_08_ErrorNegativeAssert(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Error Negative Assert Validation");
		
        try {
			rc.errorMessageNegativeAssert();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
