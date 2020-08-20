package TestPageScenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.DriverBase;
import TestPages.LoginPage;
import general.KeywordFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage_login extends DriverBase {
	protected Logger log = Logger.getLogger(LoginPage.class.getName());
	protected KeywordFunctions keys = new KeywordFunctions(driver);
	public LoginPage loginpage = new LoginPage();
	public Properties obj;
	public FileInputStream objfile;
	public String username, invalid_username, password, invalid_password, search_content;
	WebDriverWait wait;
	
	//page factory initialization
	public LoginPage_login(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), loginpage);
		log.info(getClass());
		log.info("Loginpage elements initialized");
	}
	
	//Negative Testcase
	public void login_negativeTC() throws InterruptedException, IOException {

		wait = new WebDriverWait(driver, 10);

		obj = new Properties();
		log.info(getClass());
		System.out.println(System.getProperty("user.dir"));
		objfile = new FileInputStream(System.getProperty("user.dir") + "/util/testdata.properties");
		obj.load(objfile);

		username = obj.getProperty("username");
		invalid_password = obj.getProperty("invalid_password");
		System.out.println(username);
		System.out.println(invalid_password);
		log.info("Retreiving Username and Password from property file");

		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(loginpage.already_cust_sign)));
		log.info("Clicked already customer signin successfully");

		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(loginpage.mob_email_box)));
		log.info("Clicked already mobile or email field successfully");

		keys.sendString(wait.until(ExpectedConditions.visibilityOf(loginpage.mob_email_box)), username);
		log.info("Typed email id successfully");

		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(loginpage.cont)));
		log.info("Clicked continue successfully");

		keys.sendString(wait.until(ExpectedConditions.visibilityOf(loginpage.pwd)), invalid_password);
		log.info("Typed Password successfully");

		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(loginpage.login)));
		log.info("Clicked login successfully");
		//Assert.assertFalse(loginpage.incorrect_login_text.isDisplayed());
		if(wait.until(ExpectedConditions.visibilityOf(loginpage.incorrect_login_text)).isDisplayed())
		{
			boolean status =loginpage.incorrect_login_text.isDisplayed();
			System.out.println(status);
			log.info("Invalid login credentials provided");
		}
	}
	
	public void login() throws InterruptedException, IOException {

		wait = new WebDriverWait(driver, 10);

		obj = new Properties();
		log.info(getClass());
		System.out.println(System.getProperty("user.dir"));
		objfile = new FileInputStream(System.getProperty("user.dir") + "/util/testdata.properties");
		obj.load(objfile);

		username = obj.getProperty("username");
		password = obj.getProperty("password");
		System.out.println(username);
		System.out.println(password);
		log.info("Retreiving Username and Password from property file");

		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(loginpage.already_cust_sign)));
		log.info("Clicked already customer signin successfully");

		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(loginpage.mob_email_box)));
		log.info("Clicked already mobile or email field successfully");

		keys.sendString(wait.until(ExpectedConditions.visibilityOf(loginpage.mob_email_box)), username);
		log.info("Typed email id successfully");

		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(loginpage.cont)));
		log.info("Clicked continue successfully");

		keys.sendString(wait.until(ExpectedConditions.visibilityOf(loginpage.pwd)), password);
		log.info("Typed Password successfully");

		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(loginpage.login)));
		log.info("Clicked login successfully");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Login successfull");
		
		log.info("Login successfull");
		log.info("Login successfull");
	}

}
