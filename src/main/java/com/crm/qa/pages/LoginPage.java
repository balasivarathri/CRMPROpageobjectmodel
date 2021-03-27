package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page factory or Object Repository
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement lgnbtn;
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement logo;
	
	//Initializing the page objects by creating the constructor of LoginPage class
	public LoginPage() {		
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean validateCRMLogo() {
		return logo.isDisplayed();
	}

	public HomePage login(String un,String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		lgnbtn.click();
		
		return new HomePage();
	}
}
