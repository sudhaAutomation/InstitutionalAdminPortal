package com.admin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.qa.base.TestBase;
import com.admin.qa.pages.ChangePasswordPage;
import com.admin.qa.pages.DashboardPage;
import com.admin.qa.pages.LoginPage;

public class ChangePasswordPageTest extends TestBase {
	ChangePasswordPage changePasswordPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		DashboardPage ds = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));
		changePasswordPage = ds.clickOnChangePasswordMenu();
	}

	@Test
	public void changePassword() {
		changePasswordPage.changePassword(prop.getProperty("password"), "test123");
		boolean isSuccess = changePasswordPage.isPasswordUpdated();
		Assert.assertTrue(isSuccess, "Change Password failed");
	}

	@AfterMethod
	public void tearDown() {
		changePasswordPage.changePassword("test123", prop.getProperty("password"));
		driver.quit();
	}

}
