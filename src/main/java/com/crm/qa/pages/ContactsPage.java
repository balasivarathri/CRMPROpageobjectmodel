package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
		@FindBy(xpath="//a[contains(text(),'Contacts')]")
		WebElement contactsPageLable;
		
		@FindBy(id="first_name")
		WebElement fName;
		
		@FindBy(id="surname")
		WebElement lName;
		
		@FindBy(name="client_lookup")
		WebElement company;
		
		@FindBy(name="addmore")
		WebElement savebtn;
		
		public ContactsPage() {
			PageFactory.initElements(driver, this);
		}
		public boolean verifyContactsPageLable() {
			return contactsPageLable.isDisplayed();
		}
		
		public void selectContactsByName(String name) {
			driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@valign='top' and @class='datalistrow']//preceding-sibling::td[@class='datalistrow' and @width='1']//input[@name='contact_id']")).click();
		}
		
		public void createNewContact(String title, String fsName, String lsName, String com) {
			
			Select select = new Select(driver.findElement(By.name("title"))); 
			select.selectByVisibleText(title);
			fName.sendKeys(fsName);
			lName.sendKeys(lsName);
			company.sendKeys(com);
			savebtn.click();
		}
			
		
}
