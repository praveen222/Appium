package TestPages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.DriverBase;
import general.KeywordFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.testng.Assert;

public class HomePage extends DriverBase {

	// page factory design
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.amazon.mShop.android.shopping:id/skip_sign_in_button']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement skip_signin;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Home']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement title;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.amazon.mShop.android.shopping:id/action_bar_burger_icon']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement hamb_menu;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement search_box;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sanyo 165 cm (65 inches) Kaizen Series 4K Ultra HD Smart Certified Android IPS LED TV XT-65A082U (Black) (2019 Model)']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement s_prod_name;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='₹54,999 ₹95,990']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement s_prod_price;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.View[@text='Sanyo 165 cm (65 inches) Kaizen Series 4K Ultra HD Smart Certified Android IPS LED TV XT-65A082U (Black) (2019 Model)']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement prod_name;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='rupees 54,999']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement prod_price;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Add to Cart']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement add_cart;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Buy Now']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement buy_now;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Cart']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement cart_img;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ListView/android.view.View[@index='0']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement cart_itm_price;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.View[@text='close']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement close;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.View[@resource-id='sc-proceed-to-checkout-params-form']/android.view.View[@index='3']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement cart_subtotal;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.View[@text='Sanyo 165 cm (65 inches) Kaizen Series 4K Ultra HD Smart Certifi...']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement cart_itm_name;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Proceed to Buy']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement cart_proceed_tobuy;

	// page factory initialization
	/*
	 * public HomePage() {
	 * PageFactory.initElements(new AppiumFieldDecorator(driver), this); }
	 */
}

