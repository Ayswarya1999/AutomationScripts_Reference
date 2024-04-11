package com.Well.testcases.UserSeederSync;

import java.io.IOException;
import org.testng.annotations.Test;
import com.Well.Engine.BaseClass;


public class UserSync_TC_01_UserSyncTest extends BaseClass {

	@Test
	public void UserSync_TC_01_UserSync() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
		StartTest(TestCaseName,"User Seeder DB Sync Functionality");
		try {
			commonAPI.UserSeederDB();
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
