package com.admin.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.admin.qa.base.TestBase;

public class DashboardPage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),'admin')]")
	//@CacheLookup
	WebElement admin;

	@FindBy(xpath = "//span[contains(text(),'Categories List')]")
	WebElement categoriesList;

	@FindBy(xpath = "//span[contains(text(),'Courses List')]")
	WebElement courseList;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[1]/div[1]/div[1]/aside[1]/nav[1]/ul[1]/li[4]/a[1]")
	WebElement upcomingBatches;

	@FindBy(xpath = "//span[contains(text(),'Enrollment List')]")
	WebElement enrollmentList;

	@FindBy(linkText = "  Register  List")
	WebElement registerList;

	@FindBy(xpath = "//span[contains(text(),'Internship form')]")
	WebElement internshipForm;

	@FindBy(xpath = "//span[contains(text(),'Contact Queries')]")
	WebElement contactQueries;

	@FindBy(xpath = "//body/div[1]/section[1]/div[1]/div[1]/aside[1]/nav[1]/ul[1]/li[9]/a[1]")
	WebElement trainingQueries;

	@FindBy(xpath = "//span[contains(text(),'FAQ List')]")
	WebElement faqList;

	@FindBy(xpath = "//span[contains(text(),'Meta Tags list')]")
	WebElement metaList;

	@FindBy(xpath = "//span[contains(text(),'Change Password')]")
	WebElement changePassword;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/section[1]/div[1]/div[1]/aside[1]/nav[1]")
	WebElement sideBar;

	// Initializing the Page Objects:
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return admin.isDisplayed();
	}

	public CategoryListPage clickOnCategoriesListMenu() {
		categoriesList.click();
		return new CategoryListPage();
	}

	public CoursesListPage clickOnCoursesMenu() {
		courseList.click();
		return new CoursesListPage();
	}

	public UpComingBatchesPage clickOnUpComingBatchesMenu() {
		upcomingBatches.click();
		return new UpComingBatchesPage();
	}

	public ChangePasswordPage clickOnChangePasswordMenu() throws InterruptedException {
		Thread.sleep(5000l);
		System.out.println("ChangePassword is displayed::" + changePassword.isDisplayed());
		//driver.findElement(By.className("left-nav md"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",changePassword);
		
		changePassword.click();
		return new ChangePasswordPage();
	}

}
