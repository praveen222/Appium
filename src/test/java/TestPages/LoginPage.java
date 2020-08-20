package TestPages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.DriverBase;
import general.KeywordFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends DriverBase {

	// page factory design
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.amazon.mShop.android.shopping:id/sign_in_button']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement already_cust_sign;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.amazon.mShop.android.shopping:id/skip_sign_in_button']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement skip_signin;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_burger_icon']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement hamb_menu;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/gno_greeting_text_view']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement signtxt;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='ap_login_form']/android.view.View[1]")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement mob_email;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement mob_email_box;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='ap_login_form']/android.view.View[2]")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement cont;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_password']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement pwd;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='signInSubmit']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement login;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.View[@text='Your password is incorrect']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement incorrect_login_text;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Home']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement verify_title;



	// page factory implementation
	/*
	 * public LoginPage() { 
	 * PageFactory.initElements(new AppiumFieldDecorator(driver), this); }
	 */

}
