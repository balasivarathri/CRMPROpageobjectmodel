package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil= new TestUtil();
		contactsPage= new ContactsPage();
		loginpage=new LoginPage();
		homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLableTest() {
		Assert.assertTrue(contactsPage.verifyContactsPageLable());
	}
	
	@Test(priority=2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("Balu sivarathri");
		contactsPage.selectContactsByName("Tom Peter");
	}
	
	@DataProvider
	public Object[][] getContactsTestData() throws InvalidFormatException {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=3, dataProvider="getContactsTestData" ,enabled=false)
	public void createNewContactTest(String title, String fsName, String lsName, String com) {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Rahk", "Taer", "Water");
		contactsPage.createNewContact(title, fsName, lsName, com);
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
