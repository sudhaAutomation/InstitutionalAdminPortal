package com.admin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.qa.base.TestBase;
import com.admin.qa.pages.DashboardPage;
import com.admin.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Admin Login");
	}

	@Test(priority = 2)
	public void loginTest() {
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage.clickOnCategoriesListMenu();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
