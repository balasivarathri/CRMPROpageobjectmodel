package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	CompaniesPage companiesPage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	public HomePageTest() {
		super();
	}
	
	// Test case should be independent
	//For every test case browser should be open and close
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil= new TestUtil();
		loginpage=new LoginPage();
		homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		companiesPage= new CompaniesPage();
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		tasksPage =  new TasksPage();
		
		}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePagTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePagTitle, "CRMPRO","Home Page Title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabelTest() {
		Assert.assertTrue(homePage.verifyUserNameLabel());
	}
		
	@Test(priority=3)
	public void verifyCompaniesPagelinkTest() {
		companiesPage= homePage.clickOnCompaniesLink();
	}
	
	@Test(priority=4)
	public void verifyContactsPagelinkTest() {
		contactsPage=homePage.clickOnContactsLink();
	}
	@Test(priority=5)
	public void verifyDealsPageLinkTest() {
		dealsPage=homePage.clickOnDealsLink();
	}
	
	@Test(priority=6)
	public void verifyTasksPageLinkTest() {
		tasksPage=homePage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
