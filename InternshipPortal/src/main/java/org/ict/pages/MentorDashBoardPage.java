package org.ict.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MentorDashBoardPage {

	WebDriver driver;
	WebDriverWait wait;
	public  MentorDashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//a[contains(@href,'/login')]")
	WebElement loginPage;
	@FindBy(xpath = "//input[starts-with(@id,':r') and @type='text']")
	WebElement uname;
	@FindBy(xpath = "//input[starts-with(@id,':r') and @type='password']")
	WebElement pw;
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement logInBtn;
	@FindBy(xpath = "//h6[contains(text(),'ICTAK-Mentor Dashboard')]")
	WebElement mentorDashbrd;
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement home;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	@FindBy(xpath = "//div[contains(text(),'ICTAK INTERNSHIP PORTAL')]")
	WebElement homePage;	
	@FindBy(xpath = "//button[contains(text(),'SHOW')]")
	WebElement showBtn;
	@FindBy(xpath = "(//a[contains(@href,'/submissions')])[1]")
	WebElement viewBtn;
	@FindBy(xpath = "(//a[contains(text(),'EVALUATE')])[1]")
	WebElement evaluateBtn;
	@FindBy(xpath = "//label[contains(text(),'Marks')]/following::div[2]")
	WebElement markDropdwn;
	@FindBy(xpath = "//ul[starts-with(@id,':r')]//li[@data-value='10']")
	WebElement markSel;
	@FindBy(name = "Comments")
	WebElement commentBox;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	WebElement submitMark;
	@FindBy(xpath = "//td[contains(text(),'testSona')]/following::a[contains(text(),'VIEW')]")
	WebElement viewSubmission;
	@FindBy(xpath ="//td[contains(text(),'testSona')]/following::button[1]")
	WebElement deleteSubmission;
	@FindBy(xpath = "//a[contains(@href,'/reference-material')]")
	WebElement refMaterial;
	@FindBy(xpath = "//button[contains(text(),'Add Material')]")
	WebElement addfMaterial;
	@FindBy(xpath = "//label[contains(text(),'Title')]/following::div[1]/input")
	WebElement title;
	@FindBy(xpath = "//label[contains(text(),'Description')]/following::div[1]/input")
	WebElement description;
	@FindBy(xpath = "//label[contains(text(),'Link')]/following::div[1]/input")
	WebElement link;
	@FindBy(xpath = "(//button[contains(text(),'Add')])[2]")
	WebElement addBtn;
	@FindBy(xpath = "//div[contains(text(),'Software Testing')]/following::button[contains(text(),'Delete')]")
	WebElement deleteRef;
	@FindBy(xpath = "//label[@id='filter-label']/following::div[1]/div")
	WebElement filter;
	@FindBy(xpath = "//ul[starts-with(@id,':r')]/li[@data-value='KKEM March ST']")
	WebElement courseSel;

	public String mentorDashbord() {
		System.out.println("Mentor DashBoard");
		wait.until(ExpectedConditions.textToBePresentInElement(mentorDashbrd, mentorDashbrd.getText()));
		String dashbrd_rslt=mentorDashbrd.getText();
		return dashbrd_rslt;
	}
	public String mentorProject() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(showBtn));
		showBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(viewBtn));
		viewBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(filter));
		filter.click();
		courseSel.click();
		wait.until(ExpectedConditions.elementToBeClickable(evaluateBtn));
		evaluateBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(markDropdwn));
		markDropdwn.click();		
		markSel.click();
		commentBox.sendKeys("GoodWork");		
		wait.until(ExpectedConditions.elementToBeClickable(submitMark));
		submitMark.click();
		Thread.sleep(5000);
		Alert alt = driver.switchTo().alert(); 
		String alertDelMessage= driver.switchTo().alert().getText(); 		
		Thread.sleep(1000);
		alt.accept();
		return alertDelMessage;

	}
//	public  String filtePrjtSubmission() {
//		wait.until(ExpectedConditions.elementToBeClickable(showBtn));
//		showBtn.click();
//		wait.until(ExpectedConditions.elementToBeClickable(viewBtn));
//		viewBtn.click();
//		wait.until(ExpectedConditions.elementToBeClickable(filter));
//		filter.click();
//		courseSel.click();
//		return "Success";
//
//	}
	public String updateMarkComments() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(viewSubmission));
		viewSubmission.click();
		wait.until(ExpectedConditions.elementToBeClickable(markDropdwn));
		markDropdwn.click();
		markSel.click();
		commentBox.sendKeys("Good");		
		wait.until(ExpectedConditions.elementToBeClickable(submitMark));
		submitMark.click();
		Thread.sleep(5000);
		Alert alt = driver.switchTo().alert(); 
		String alertDelMessage= driver.switchTo().alert().getText(); 		
		Thread.sleep(1000);
		alt.accept();
		return alertDelMessage;

	}
	public String prjtSubmissiontDelete() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(deleteSubmission));
		deleteSubmission.click();		
		Thread.sleep(5000);
		Alert alt = driver.switchTo().alert(); 
		String alertDelMessage= driver.switchTo().alert().getText(); 		
		Thread.sleep(1000);
		alt.accept();
		return alertDelMessage;		
	}

	public String addReferenceMaterial() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(refMaterial));
		refMaterial.click();
		wait.until(ExpectedConditions.elementToBeClickable(addfMaterial));
		addfMaterial.click();
		title.sendKeys("Software Testing");
		description.sendKeys("Types of software testing");
		link.sendKeys("https://www.geeksforgeeks.org/software-testing-basics/#different-types-of-software-testing");
		wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		addBtn.click();		
		return "Success";			
	}

	public String deleteReference() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(deleteRef));
		deleteRef.click();
		Thread.sleep(5000);
		Alert alt = driver.switchTo().alert(); 
		String dltRefer= driver.switchTo().alert().getText(); 		
		Thread.sleep(1000);
		alt.accept();
		return dltRefer;	
	}
	
	public String logOut() {
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
		String homPage = homePage.getText();
		return homPage;
	}


}
