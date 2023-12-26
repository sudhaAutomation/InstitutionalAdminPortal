package com.admin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.qa.base.TestBase;

public class CoursesListPage extends TestBase {
	@FindBy(xpath = "//h3[contains(text(),'Courses List')]")
	WebElement coursesListTitle;
	
	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/a[1]")
	WebElement addCourseBtn;
	
	@FindBy(xpath = "//th[contains(text(),'Course Name')]")
	WebElement courseName;
	
	@FindBy(xpath = "//th[contains(text(),'Actions')]")
	WebElement actions;

	@FindBy(xpath = "//body/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]")
	WebElement searchbox;

	public CoursesListPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyCoursesListTilte() {
		return coursesListTitle.isDisplayed();
	}

	public AddCoursePage clickOnAddCourseBtn() {
		addCourseBtn.click();
		return new AddCoursePage();
	}

	public boolean verifyCourseTable() {
		boolean isTableDisplayed = courseName.isDisplayed();
		if (isTableDisplayed) {
			return actions.isDisplayed();
		}
		return false;
	}

	public void searchCourse(String courseName) {
		searchbox.sendKeys(courseName);
		verifiyCourse(courseName);
	}

	public boolean verifiyCourse(String courseName) {
		int noOfRows = driver.findElements(By.xpath("//tbody/tr")).size();
		String name = driver.findElement(By.xpath("//tbody/tr[" + noOfRows + "]/td[1]")).getText();
		return courseName.equals(name);
	}

}
