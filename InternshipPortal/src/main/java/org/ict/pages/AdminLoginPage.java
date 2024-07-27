package org.ict.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginPage {
	WebDriver driver;
	WebDriverWait wait;
	public  AdminLoginPage(WebDriver driver) {
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
	@FindBy(xpath = "//h6[contains(text(),'ADMIN-Dashboard')]")
	WebElement dashbrd;
	@FindBy(xpath = "//h6[contains(text(),'ICTAK-Mentor Dashboard')]")
	WebElement mentorDashbrd;
	@FindBy(xpath="//p[contains(text(),'Error logging in')]")
	WebElement errLogin;
	@FindBy(xpath = "//p[contains(text(),'Password must be at least 8 characters')]")
	WebElement errLogin_empty;
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement home;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	@FindBy(xpath = "//div[contains(text(),'ICTAK INTERNSHIP PORTAL')]")
	WebElement homePage;

	public void loginPage() {	

		System.out.println("login Page");
		wait.until(ExpectedConditions.elementToBeClickable(home));
		home.click(); 
		wait.until(ExpectedConditions.elementToBeClickable(loginPage));
		loginPage.click();
	}
	public void userName(String admin_uname) {
		uname.sendKeys(admin_uname);
	}
	public void password(String admin_passwd) {
		pw.sendKeys(admin_passwd);
	}
	public void loginBtn() {	

		System.out.println("login btn");
		wait.until(ExpectedConditions.elementToBeClickable(logInBtn));
		logInBtn.click();
	}
	public String getDashbord() {
		System.out.println("DashBoard");
		wait.until(ExpectedConditions.textToBePresentInElement(dashbrd, dashbrd.getText()));
		String dashbrd_rslt=dashbrd.getText();
		return dashbrd_rslt;
	}
	public String errMsg() {
		wait.until(ExpectedConditions.textToBePresentInElement(errLogin, errLogin.getText()));
		String err_rslt=errLogin.getText();
		return err_rslt;

	}
	public String errMsg_emptyFld() {
		wait.until(ExpectedConditions.textToBePresentInElement(errLogin_empty, errLogin_empty.getText()));
		String err_rslt=errLogin_empty.getText();
		return err_rslt;

	}
	public String mentorDashbord() {
		System.out.println("Mentor DashBoard");
		wait.until(ExpectedConditions.textToBePresentInElement(mentorDashbrd, mentorDashbrd.getText()));
		String dashbrd_rslt=mentorDashbrd.getText();
		return dashbrd_rslt;
	}
	public String logOut() {
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
		String homPage = homePage.getText();
		return homPage;
	}




}
