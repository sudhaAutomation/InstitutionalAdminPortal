package com.admin.qa.testcases;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.qa.base.TestBase;
import com.admin.qa.pages.AddCategoryPage;
import com.admin.qa.pages.CategoryListPage;
import com.admin.qa.pages.DashboardPage;
import com.admin.qa.pages.LoginPage;

public class CategoryListTest extends TestBase {
	CategoryListPage categoryListPage;
	AddCategoryPage addCategoryPage;

	@BeforeClass
	public void categoryList() {
		initialization();
		DashboardPage dashboardPage = new LoginPage().login(prop.getProperty("username"), prop.getProperty("password"));

		categoryListPage = dashboardPage.clickOnCategoriesListMenu();
	}

	@Test(priority = 1)
	public void verifycategoryListDisplayed() {
		boolean isdisplayed = categoryListPage.verifyCategoryListTilte();
		Assert.assertTrue(isdisplayed, "Category List Page is not Displayed");
	}

	@Test(priority = 2)
	public void verifyCategoryListTable() {
		boolean isTableDisplayed = categoryListPage.verifyCategoryTable();
		Assert.assertTrue(isTableDisplayed, "Category Table is not displayed");
	}

	@Test(priority = 3)
	public void verifyAddCatgoryBtn() {
		addCategoryPage = categoryListPage.clickOnAddCategoryBtn();
		boolean isPageLoaded = addCategoryPage.verifyAddCategoryPageTilte();
		Assert.assertTrue(isPageLoaded, "Add Category Page is not Loaded");
	}

	@Test(priority = 4)
	public void verifyAddCategory() {
		Date date = new Date();
		String categoryName = "CategoryName_" + date.getTime();
		String categoryUrl="CategoryUrl_" + date.getTime();
		String sortOrder = String.valueOf(new Random().nextInt(10));
		//String sortOrder = "3";
		String metaTitle = "MetaTitle_" + date.getTime();
		String metaDesc = "MetaDesc_" + date.getTime();
		// String metaKey = "MetaKey_" + date.getTime();
		String metaKey = "MetaKey_"+date.getTime();
		// addCategoryPage = categoryListPage.clickOnAddCategoryBtn();
	
		
		addCategoryPage.addCategory(categoryName, categoryUrl, sortOrder, metaTitle, metaDesc, metaKey);
		boolean isCreated = categoryListPage.verifiyCategory(categoryName);
		Assert.assertTrue(isCreated, "Category Not Created");

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
