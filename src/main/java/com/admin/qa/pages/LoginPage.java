package com.admin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "submit")
	WebElement loginBtn;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		// return admin.getText();
		return driver.getTitle();
	}

	public DashboardPage login(String email, String pwd) {//with argumnets and with return type
		username.sendKeys(email);
		password.sendKeys(pwd);
		loginBtn.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", loginBtn);

		return new DashboardPage();
	}

}
