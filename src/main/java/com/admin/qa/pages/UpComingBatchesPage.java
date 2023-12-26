package com.admin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.admin.qa.base.TestBase;

public class UpComingBatchesPage extends TestBase {
	@FindBy(xpath = "//h3[contains(text(),'Schedule List')]")
	WebElement ScheduleList;

}
