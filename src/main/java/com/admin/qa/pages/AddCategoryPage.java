package com.admin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.qa.base.TestBase;

public class AddCategoryPage extends TestBase {

	@FindBy(xpath = "//h3[contains(text(),'Add Category')]")
	WebElement addCategoryTitle;
	
	@FindBy(xpath = "//body/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")
	WebElement categoryNametxb;
	
	@FindBy(xpath="//body/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")
	WebElement categoryUrltxb;
	
	@FindBy(xpath = "//body/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[3]/input[1]")
	WebElement sortOrdertxb;
	
	@FindBy(xpath = "//body/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[4]/input[1]")
	WebElement metaTitletxb;
	
	@FindBy(xpath = "//body/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[5]/input[1]")
	WebElement metaDescritxb;
	
	@FindBy(xpath = "//body/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[6]/input[1]")
	WebElement metaKeytxb;
	
	@FindBy(xpath = "//body/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/form[1]/div[7]/input[1]")
	WebElement saveBtn;

	public AddCategoryPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAddCategoryPageTilte() {
		return addCategoryTitle.isDisplayed();
	}

	public void addCategory(String categoryName,String categoryUrl, String sortOrder, String metaTitle, String MetaDesrci,
			String metaKey) {
		categoryNametxb.sendKeys(categoryName);
		categoryUrltxb.sendKeys(categoryUrl);
		sortOrdertxb.sendKeys(sortOrder);
		metaTitletxb.sendKeys(metaTitle);
		metaDescritxb.sendKeys(MetaDesrci);
		metaKeytxb.sendKeys(metaKey);
		saveBtn.click();
	}

}
