package org.ict.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminDashboardPage {
	WebDriver driver;
	WebDriverWait wait;
	public  AdminDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	@FindBy(xpath = "//a[contains(@href,'/project')]")
	WebElement projectPage;
	@FindBy(xpath = "//button[contains(text(),'Add Project')]")
	WebElement addProject;
	@FindBy(xpath = "//input[starts-with(@id,':r') and @type='text']")
	WebElement addNewPjt;
	@FindBy(xpath = "(//button[contains(text(),'Add')])[2]")
	WebElement addPjtBtn;
	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelPjtBtn;
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement home;
	@FindBy(xpath="(//div[starts-with(text(),'Signature')])[1]")
	WebElement prjtName;
	@FindBy(xpath="(//div[starts-with(text(),'Signature')])[1]//following::div[1]/button[1]")
	WebElement editPrjtName;
	@FindBy(xpath = "//input[starts-with(@id,':r') and starts-with(@value, 'Signature')]")
	WebElement editName;
	@FindBy(xpath = "//input[starts-with(@id,':r') and starts-with(@value, 'Signature')]//following::div[1]/button[2]")
	WebElement prjtSaveBtn;
	@FindBy(xpath = "//input[starts-with(@id,':r') and starts-with(@value, 'Signature')]//following::div[1]/button[1]")
	WebElement prjtCancelBtn;
	@FindBy(xpath = "(//div[starts-with(text(),'Signature')])[2]//following::button[2]")
	WebElement deletePrjtName;

	/* Mentor form*/
	@FindBy(xpath = "//a[contains(@href,'/addmentor')]")
	WebElement mentorForm;
	@FindBy(css="input[ name='Name']")
	WebElement mentorName;
	@FindBy(css="input[ name='Email']")
	WebElement mentorEmail;
	@FindBy(css ="input[ name='PhoneNumber']")
	WebElement mentorPhone;
	@FindBy(css="input[ name='Password']")
	WebElement mentorPassw;
	@FindBy(css="input[ name='ProjectTopics']")
	WebElement mentorPrjtTopic;
	@FindBy(xpath = "//button[contains(text(),'SUBMIT') and @type='button']")
	WebElement formsubmitBtn;
	@FindBy(id="demo-simple-select")
	WebElement dropdnMenu;
	@FindBy(className = "admin-form-container")
	WebElement outDrpdn;
	@FindBy(xpath = "//ul[starts-with(@id,':r')]//li[@data-value='Signature VS']")
	WebElement topicSel;


	@FindBy(xpath = "//p[contains(text(),'Phone Number is required and should be a valid phone number')]")
	WebElement phonErr;
	@FindBy(xpath = "//p[contains(text(),'Password should be at least 8 characters long')]")
	WebElement pwErr;

	@FindBy(xpath = "//p[contains(text(),'Email is required')]")
	WebElement emailReqErr;
	@FindBy(xpath = "//p[contains(text(),'Phone Number is required and should be a valid phone number')]")
	WebElement phReqErr;
	@FindBy(xpath = "//p[contains(text(),'Password is required')]")
	WebElement pwReqErr;

	/*Mentor List*/
	@FindBy(xpath = "//a[contains(@href,'/mentors')]")
	WebElement mentors;
	@FindBy(xpath = "//td[text()='TestMentor']/following::button[1]")
	WebElement updateMentor;
	@FindBy(xpath = "//td[text()='TestMentor']/following::button[2]")
	WebElement deleteMentor;
	@FindBy(xpath = "//button[contains(text(),'SUBMIT')]")
	WebElement mentrSubmit;


	public void addProject(String projectName) {
		//		wait.until(ExpectedConditions.elementToBeClickable(home));
		//		home.click(); 
		wait.until(ExpectedConditions.elementToBeClickable(projectPage));
		projectPage.click();
		wait.until(ExpectedConditions.elementToBeClickable(addProject));
		addProject.click();
		addNewPjt.sendKeys(projectName);
		wait.until(ExpectedConditions.elementToBeClickable(addPjtBtn));
		addPjtBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(home));
	//	home.click(); 
	}
	public void addProjectNullData(String projectName) {
		wait.until(ExpectedConditions.elementToBeClickable(projectPage));
		projectPage.click();
		wait.until(ExpectedConditions.elementToBeClickable(addProject));
		addProject.click();
		addNewPjt.clear();
		addNewPjt.sendKeys(projectName);
		//		wait.until(ExpectedConditions.elementToBeClickable(addPjtBtn));
		//		addPjtBtn.click();
		if(projectName.isEmpty()) {
			wait.until(ExpectedConditions.elementToBeClickable(cancelPjtBtn));
			cancelPjtBtn.click();}
	}
	public String editProjectName() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(projectPage));
		projectPage.click();
		wait.until(ExpectedConditions.elementToBeClickable(editPrjtName));
		editPrjtName.click();
		wait.until(ExpectedConditions.visibilityOf(editName));
		Actions actions = new Actions(driver);		
		actions.moveToElement(editName).doubleClick().click().sendKeys(Keys.BACK_SPACE).sendKeys("Signature VS").perform();      
		wait.until(ExpectedConditions.elementToBeClickable(prjtSaveBtn));
		prjtSaveBtn.click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert(); 
		String alertMessage= driver.switchTo().alert().getText(); 		
		Thread.sleep(5000);
		alert.accept();
		return alertMessage;

	}
	public String deleteProjectName() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(deletePrjtName));
		deletePrjtName.click();
		Thread.sleep(5000);
		Alert alt = driver.switchTo().alert(); 
		String alertDelMessage= driver.switchTo().alert().getText(); 		
		Thread.sleep(1000);
		alt.accept();
		return alertDelMessage;

	}
	public String cancelProjectName() {
		wait.until(ExpectedConditions.elementToBeClickable(editPrjtName));
		editPrjtName.click();
		wait.until(ExpectedConditions.elementToBeClickable(prjtCancelBtn));
		prjtCancelBtn.click();
		return "success";

	}

	public String mentorFormData(String name, String email, String phNumber, String passwd, String topic) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(mentorForm));
		mentorForm.click();
		wait.until(ExpectedConditions.visibilityOf(mentorName));
		mentorName.sendKeys(name);	
		wait.until(ExpectedConditions.visibilityOf(mentorEmail));
		mentorEmail.sendKeys(email);	
		wait.until(ExpectedConditions.visibilityOf(mentorPhone));
		mentorPhone.sendKeys(phNumber);	
		wait.until(ExpectedConditions.visibilityOf(mentorPassw));
		mentorPassw.sendKeys(passwd);	
		wait.until(ExpectedConditions.visibilityOf(dropdnMenu));
		dropdnMenu.click();
		wait.until(ExpectedConditions.visibilityOf(topicSel));
		topicSel.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('menu-ProjectTopics').style.display = 'none';");		
		wait.until(ExpectedConditions.elementToBeClickable(formsubmitBtn));
		formsubmitBtn.click();
		return "success";

	}
	public String mentorFormValid() throws InterruptedException {
		mentorFormData("TestMentor","test@gmail.com","1234567890","test12345","Signature VS");
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert(); 
		String altMsg= driver.switchTo().alert().getText(); 		
		Thread.sleep(5000);
		alert.accept();			
		return altMsg;
	}

	public String mentorFormInvalid() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(home));
		home.click();
		mentorFormData("TestMentor","test@gmail.com","123457","345","Signature VS");
		wait.until(ExpectedConditions.visibilityOf(phonErr));		
		String phErrMsg=phonErr.getText();
		wait.until(ExpectedConditions.visibilityOf(pwErr));		
		String pwErrMsg=pwErr.getText();
		return phErrMsg+","+pwErrMsg;
	}
	public String mentorFormEmptyFld() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(home));
		home.click();
		mentorFormData("TestMentor","","","","Signature VS");
		wait.until(ExpectedConditions.visibilityOf(emailReqErr));		
		String emReqErrMsg=emailReqErr.getText();
		wait.until(ExpectedConditions.visibilityOf(phReqErr));		
		String phReqErrMsg=phReqErr.getText();
		wait.until(ExpectedConditions.visibilityOf(pwReqErr));		
		String pwReqErrMsg=pwReqErr.getText();
		return emReqErrMsg+","+phReqErrMsg+","+pwReqErrMsg;
	}

	public String mentorListUpdate() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(home));
		home.click();
		wait.until(ExpectedConditions.elementToBeClickable(mentors));
		mentors.click();			
		wait.until(ExpectedConditions.elementToBeClickable(updateMentor));
		updateMentor.click();
		wait.until(ExpectedConditions.elementToBeClickable(mentorEmail));
		mentorEmail.click();
		Actions actions = new Actions(driver);		
		actions.moveToElement(mentorEmail).doubleClick().click().sendKeys(Keys.BACK_SPACE).sendKeys("test1234@gmail.com").perform();  		
		wait.until(ExpectedConditions.elementToBeClickable(mentrSubmit));
		mentrSubmit.click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert(); 
		String altMsg= driver.switchTo().alert().getText(); 		
		Thread.sleep(5000);
		alert.dismiss();		
		return altMsg;


	}
	public String mentorListDelete() throws InterruptedException {
//		wait.until(ExpectedConditions.elementToBeClickable(home));
//		home.click();
		wait.until(ExpectedConditions.elementToBeClickable(mentors));
		mentors.click();
		wait.until(ExpectedConditions.elementToBeClickable(deleteMentor));
		deleteMentor.click();
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert(); 
		String altMsg= driver.switchTo().alert().getText(); 		
		Thread.sleep(5000);
		alert.accept();		
		return altMsg;


	}


}
