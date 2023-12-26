package com.admin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.qa.base.TestBase;

public class ChangePasswordPage extends TestBase {
	@FindBy(name = "old_password")
	WebElement oldPassword;

	@FindBy(name = "new_password")
	WebElement newPassword;

	@FindBy(name = "repeat_password")
	WebElement repeatPassword;

	@FindBy(name = "submit")
	WebElement passwordBtn;

	@FindBy(xpath = "//body/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/section[2]/div[1]")
	WebElement responseMessage;

	public ChangePasswordPage() {
		PageFactory.initElements(driver, this);
	}

	public void changePassword(String oldpw, String newpw) {
		oldPassword.sendKeys(oldpw);
		newPassword.sendKeys(newpw);
		repeatPassword.sendKeys(newpw);
		passwordBtn.click();
	}

	public boolean isPasswordUpdated() {
		String actmessage = responseMessage.getText();
		System.out.println("actual message " + actmessage);
		return actmessage != null && actmessage.contains("Sucessfully changed");
	}

}
