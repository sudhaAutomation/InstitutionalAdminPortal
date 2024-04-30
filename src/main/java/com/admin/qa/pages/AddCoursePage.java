package com.admin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.admin.qa.base.TestBase;
import com.admin.qa.domain.CourseDetails;

public class AddCoursePage extends TestBase {
	@FindBy(xpath = "//h3[contains(text(),'Add Course')]")
	WebElement addCourseTitleElement;
	
	@FindBy(name = "course_image")
	WebElement addPhotoField;

	@FindBy(name = "category_id")
	WebElement selectCategoryField;

	@FindBy(name = "course_name")
	WebElement courseNameField;

	@FindBy(name = "course_slug")
	WebElement courseURLField;

	@FindBy(xpath = "/html[1]")
	WebElement courseContentField;

	@FindBy(name = "popular_type")
	WebElement popularTypeField;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelBtn;

	@FindBy(name = "submit")
	WebElement submitBtn;
	
	public AddCoursePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAddCoursePageTitle() {
		return addCourseTitleElement.isDisplayed();
	}

	public void addCourse(CourseDetails courseDetails) {
		addPhotoField.sendKeys(courseDetails.getPhoto());
		// selectCategoryField
		new Select(selectCategoryField).selectByVisibleText(courseDetails.getCategory());
		courseNameField.sendKeys(courseDetails.getName());
		courseURLField.sendKeys(courseDetails.getUrl());
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='TypeHere11_ifr']")));
	//	courseContentField.sendKeys(courseDetails.getContent());
		driver.switchTo().parentFrame();
		new Select(popularTypeField).selectByVisibleText(courseDetails.getIsPopular());
		submitBtn.click();
	}

}
