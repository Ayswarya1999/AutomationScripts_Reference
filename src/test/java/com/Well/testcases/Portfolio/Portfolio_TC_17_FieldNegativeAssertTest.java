package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Portfolio_TC_17_FieldNegativeAssertTest extends BaseClass {

	@Test
	@Parameters({ "SheetName", "rowNum" })
	public void Portfolio_TC_17_FieldNegativeAssert(String SheetName, int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
        StartTest(TestCaseName, "Error Negative Assert Validation");
		
        try {
			rc.FieldNegativeAssert();

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
