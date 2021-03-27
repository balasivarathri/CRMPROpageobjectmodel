package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CompaniesPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	CompaniesPage companiesPage;
	
	public CompaniesPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil= new TestUtil();
		loginpage=new LoginPage();
		homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickOnCompaniesLink();
		companiesPage= new CompaniesPage();
	}
	
	@Test
	public void verifyComapaniespageLabelTest() {
		Assert.assertTrue(companiesPage.verifyCompaniesLabel());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
