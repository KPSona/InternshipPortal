package org.ict.testcases;

import org.ict.base.TestBase;
import org.ict.pages.AdminDashboardPage;
import org.ict.pages.AdminLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.AutomationConstants;

public class AdminDashboardTC extends TestBase {
	AdminLoginPage adminloginpage;	
	AdminDashboardPage admindashboard;
	String actualResult;
	String emptyFldErr;
	String homPge;

	@BeforeClass
	public void classSetup() {
		adminloginpage = new AdminLoginPage(driver);
		admindashboard = new AdminDashboardPage(driver);

	}
	@Test(priority = 9)	
	public void adminLogin_Valid() throws InterruptedException  {
		System.out.println("TC_IP_1.1.2   Successful Login");
		adminloginpage.loginPage();
		//		adminloginpage.userName(prop.getProperty("username"));
		//		adminloginpage.password(prop.getProperty("password"));	
		adminloginpage.userName("admin@gmail.com");
		adminloginpage.password("admin@12345");
		adminloginpage.loginBtn();
		actualResult = adminloginpage.getDashbord();		
		Assert.assertEquals(actualResult, AutomationConstants.ExpectedHomeAdmin);			
		System.out.println(actualResult+": Valid Login completed"); 
	}

	@Test(priority = 10)	
	public void addNewProject() throws InterruptedException  {
		System.out.println("TC_IP_1.2.2   Verify Add Project Functionality ");
		admindashboard.addProject("Signature Verification System");
	}

	@Test(priority = 11)
	public void addNewProject_EmptyFld() {
		System.out.println("TC_IP_1.2.3	Verify Add Project Functionality with empty field");
		admindashboard.addProjectNullData("");
	}

	@Test(priority = 12)
	public void addNewProject_duplicate() {
		System.out.println("TC_IP_1.2.3	Duplicate project topic Prevention");
		admindashboard.addProject("Signature Verification System");
		System.out.println("The system accepts duplicate data");
	}

	@Test(priority = 13)
	public void projectName_Edit() throws InterruptedException {
		System.out.println("TC_IP_1.2.5	Test Edit button functionality");
		String editRslt= admindashboard.editProjectName();
		Assert.assertEquals(editRslt, AutomationConstants.ExpectedAlertMsg);
		System.out.println(editRslt);
	}

	@Test(priority = 14)
	public void projectName_cancel() throws InterruptedException {
		System.out.println("TC_IP_1.2.6	Test Cancel button in  edit project name field");
		String canRslt=admindashboard.cancelProjectName();
		//Assert.assertEquals(canRslt, AutomationConstants.ExpectedDeltMsg);
		System.out.println(canRslt);
	}

	@Test(priority = 15)
	public void projectName_delete() throws InterruptedException {
		System.out.println("TC_IP_1.2.7	Test Delete button functionality");
		String delRslt=admindashboard.deleteProjectName();
		Assert.assertEquals(delRslt, AutomationConstants.ExpectedDeltMsg);
		System.out.println(delRslt);
	}

	@Test(priority = 16)
	public void mentorForm_valid() throws InterruptedException {
		System.out.println("TC_IP_1.3.1	verify and vlidate the Mentor Form can be submitted with valid data");
		String rslt =admindashboard.mentorFormValid();
		Assert.assertEquals(rslt, AutomationConstants.MentorAdded);
		System.out.println(rslt);
	}

	@Test(priority = 17)
	public void mentorForm_invalid() throws InterruptedException {
		System.out.println("TC_IP_1.3.2	verify and vlidate the Mentor Form can be submitted with invalid data");
		//String rslt =admindashboard.mentorFormInvalid("TestMentor","test@gmail.com","123457","345","Signature VS");
		String rslt =admindashboard.mentorFormInvalid();
		Assert.assertEquals(rslt, AutomationConstants.MentorInvalid);
		System.out.println(rslt);
	}

	@Test(priority = 18)
	public void mentorForm_empty() throws InterruptedException {
		System.out.println("TC_IP_1.3.3	Empty Field Validation");
		//String rslt =admindashboard.mentorFormEmptyFld("TestMentor","","","","Signature VS");
		String rslt =admindashboard.mentorFormEmptyFld();
		Assert.assertEquals(rslt, AutomationConstants.MentorEmptyFld);
		System.out.println(rslt);
	}

	//@Test(priority = 19)
	public void mentorForm_ListUpdt() throws InterruptedException {
		System.out.println("TCP_IP_1.3.4 and TCP_IP_1.3.5	Verify Update button of Mentor Info list");
		String rslt =admindashboard.mentorListUpdate();
		Assert.assertEquals(rslt, AutomationConstants.MentorUpdate);
		System.out.println(rslt);
	}

	@Test(priority = 19)
	public void mentorForm_ListDlt() throws InterruptedException {
		System.out.println("TCP_IP_1.3.7	Verify Delete button of Mentor Info list");
		String rslt =admindashboard.mentorListDelete();
		Assert.assertEquals(rslt, AutomationConstants.MentorDelete);
		System.out.println(rslt);
	}

	@Test(priority = 20)
	public void adminLogOut() {
		System.out.println("TC_IP_1.1.5  Admin logout functionality ");
		homPge= adminloginpage.logOut();
		Assert.assertEquals(homPge, AutomationConstants.ExpectedHomePage);
		System.out.println(homPge+":  Admin logout"); 


	}


}
