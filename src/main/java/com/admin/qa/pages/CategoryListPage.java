package com.admin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.qa.base.TestBase;

public class CategoryListPage extends TestBase {

	@FindBy(xpath = "//h3[contains(text(),'Categories List')]")
	WebElement categoryListTitle;

	@FindBy(xpath = "//header/div[1]/div[1]/div[1]/a[1]")
	WebElement addCategoryBtn;

	@FindBy(xpath = "//thead/tr/th[1]")
	WebElement categoryName;

	@FindBy(xpath = "//th[contains(text(),'Actions')]")
	WebElement actions;

	public CategoryListPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyCategoryListTilte() {
		return categoryListTitle.isDisplayed();
	}

	public AddCategoryPage clickOnAddCategoryBtn() {
		addCategoryBtn.click();
		return new AddCategoryPage();
	}

	public boolean verifyCategoryTable() {
		boolean isTableDisplayed = categoryName.isDisplayed();
		if (isTableDisplayed) {
			return actions.isDisplayed();
		}
		return false;
	}

	public boolean verifiyCategory(String categoryName) {
		int noOfRows = driver.findElements(By.xpath("//tbody/tr")).size();
		// //td[contains(text(),'Salesforce1')]
		//String name = driver.findElement(By.xpath("//tbody/tr[" + noOfRows + "]/td[1]")).getText();
		String name=driver.findElement(By.xpath("//td[contains(text(),'"+categoryName+"')]")).getText();
		return categoryName.equals(name);
	}
}
