package org.ict.testcases;

import org.ict.base.TestBase;
import org.ict.pages.AdminLoginPage;
import org.ict.pages.MentorDashBoardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.AutomationConstants;

public class MentorLoginTC extends TestBase{

	MentorDashBoardPage mentorloginpage;	
	AdminLoginPage adminloginpage;

	String actualResult;
	String emptyFldErr;
	String homPge;

	@BeforeClass
	public void classSetup() {
		mentorloginpage = new MentorDashBoardPage(driver);		
		adminloginpage = new AdminLoginPage(driver);

	}


	@Test(priority = 1)	
	public void mentorLogin_Valid() throws InterruptedException  {
		System.out.println("TC_IP_1.5.1  Successful Login");
		adminloginpage.loginPage();
		adminloginpage.userName("adon@gmail.com");
		adminloginpage.password("adon123456");		
		adminloginpage.loginBtn();
		actualResult = adminloginpage.mentorDashbord();		
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedHomementor);			
		System.out.println(actualResult+": Valid Login completed"); 

	}
	
	@Test(priority = 2)	
	public void prjt_evaluate() throws InterruptedException {
		System.out.println(" TC_IP_1.5.1,TC_IP_1.5.2,TC_IP_1.5.3 and TC_IP_1.5.7" );
		String result= mentorloginpage.mentorProject();
		Assert.assertEquals(result, AutomationConstants.UpdateMark);			
		System.out.println(result); 	
	}

	@Test(priority = 3)
	public void prjtMark_Update() throws InterruptedException {
		System.out.println(" TC_IP_1.5.1,TC_IP_1.5.2,TC_IP_1.5.3" );
		String resultUpdate= mentorloginpage.updateMarkComments();
		Assert.assertEquals(resultUpdate, AutomationConstants.UpdateMark);			
		System.out.println(resultUpdate); 

	}
	
	@Test(priority = 4)
	public void deleteSubmission() throws InterruptedException {
		System.out.println(" TC_IP_1.5.1,TC_IP_1.5.2,TC_IP_1.5.3" );
		String resultDel= mentorloginpage.prjtSubmissiontDelete();
		Assert.assertEquals(resultDel, AutomationConstants.DeleteSubmission);			
		System.out.println(resultDel); 

	}
	
	@Test(priority = 5)
	public void addReference() throws InterruptedException {
		System.out.println("TC_IP_1.5.9 Verify Add Reference Materials functionality" );
		String resultAdd= mentorloginpage.addReferenceMaterial();
		//Assert.assertEquals(resultDel, AutomationConstants.DeleteSubmission);			
		System.out.println(resultAdd); 
	}
	
	@Test(priority = 6)
	public void dltReference() throws InterruptedException {
		System.out.println("TC_IP_1.5.9 Verify Add Reference Materials functionality" );
		String dltResult= mentorloginpage.deleteReference();
		Assert.assertEquals(dltResult, AutomationConstants.DeleteReference);			
		System.out.println(dltResult); 
	}
		

}
