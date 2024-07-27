package org.ict.testcases;

import org.ict.base.TestBase;
import org.ict.pages.AdminLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import constants.AutomationConstants;

public class AdminLoginTC extends TestBase {
	AdminLoginPage adminloginpage;	
	String actualResult;
	String emptyFldErr;
	String homPge;

	@BeforeClass
	public void classSetup() {
		adminloginpage = new AdminLoginPage(driver);
			

	}


	@Test(priority = 3)	
	public void adminLogin_Valid() throws InterruptedException  {
		System.out.println("TC_IP_1.1.2   Successful Login");
		adminloginpage.loginPage();
		adminloginpage.userName(prop.getProperty("username"));
		adminloginpage.password(prop.getProperty("password"));
		//		adminloginpage.userName("superadmin");
		//		adminloginpage.password("12345");
		adminloginpage.loginBtn();
		actualResult = adminloginpage.getDashbord();		
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedHomeAdmin);			
		System.out.println(actualResult+": Valid Login completed"); 

	}


	@Test(priority = 2)	
	public void adminLogin_Invalid() {
		System.out.println(" TC_IP_1.1.3 Invalid Login ");
		adminloginpage.loginPage();		
		adminloginpage.userName(prop.getProperty("username"));
		adminloginpage.password(prop.getProperty("inpassword"));
		adminloginpage.loginBtn();
		actualResult = adminloginpage.errMsg();		
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedErrMsg);
		System.out.println(actualResult+": Invalid Login completed"); 

	}


	@Test(priority = 1)
	public void adminLogin_emptyFld() {
		System.out.println("TC_IP_1.1.4 Empty Fields Validation ");
		adminloginpage.loginPage();	
		adminloginpage.userName(prop.getProperty("username"));
		adminloginpage.password(prop.getProperty("bpassword"));
		adminloginpage.loginBtn();		
		emptyFldErr = adminloginpage.errMsg_emptyFld();
		Assert.assertEquals(emptyFldErr, AutomationConstants.ExpectedEmptyFldErr);
		System.out.println(emptyFldErr+": Blank field login completed"); 
	}
	
	@Test(priority = 4)
	public void adminLogOut() {
		System.out.println("TC_IP_1.1.5  Admin logout functionality ");
		homPge= adminloginpage.logOut();
		Assert.assertEquals(homPge, AutomationConstants.ExpectedHomePage);
		System.out.println(homPge+":  Admin logout"); 
		
		
	}

	@Test(priority = 7)	
	public void mentorLogin_Valid() throws InterruptedException  {
		System.out.println("TC_IP_1.4.2   Successful Login");
		adminloginpage.loginPage();
		adminloginpage.userName(prop.getProperty("mentorUname"));
		adminloginpage.password(prop.getProperty("mentorPw"));
		//		adminloginpage.userName("supermentor");
		//		adminloginpage.password("12345");
		adminloginpage.loginBtn();
		actualResult = adminloginpage.mentorDashbord();		
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedHomementor);			
		System.out.println(actualResult+": Valid Login completed"); 

	}

	@Test(priority = 6)	
	public void mentorLogin_Invalid() {
		System.out.println(" TC_IP_1.4.3 Invalid Login ");
		adminloginpage.loginPage();		
		adminloginpage.userName(prop.getProperty("mentorUname"));
		adminloginpage.password(prop.getProperty("inpassword"));
		adminloginpage.loginBtn();
		actualResult = adminloginpage.errMsg();		
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedErrMsg);
		System.out.println(actualResult+": Invalid Login completed"); 

	}

	@Test(priority = 5)
	public void mentorLogin_emptyFld() {
		System.out.println("TC_IP_1.4.4 Empty Fields Validation ");
		adminloginpage.loginPage();	
		adminloginpage.userName(prop.getProperty("mentorUname"));
		adminloginpage.password(prop.getProperty("bpassword"));
		adminloginpage.loginBtn();		
		emptyFldErr = adminloginpage.errMsg_emptyFld();
		Assert.assertEquals(emptyFldErr, AutomationConstants.ExpectedEmptyFldErr);
		System.out.println(emptyFldErr+": Blank field login completed"); 
	}
	
	@Test(priority = 8)
	public void mentorLogOut() {
		System.out.println("TC_IP_1.4.5  mentor logout functionality ");
		homPge= adminloginpage.logOut();
		Assert.assertEquals(homPge, AutomationConstants.ExpectedHomePage);
		System.out.println(homPge+":  mentor logout"); 		
		
	}
	
}
