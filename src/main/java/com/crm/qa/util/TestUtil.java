package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICI_WAIT=10;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

}
