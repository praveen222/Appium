package TestPageScenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestBase.DriverBase;
import TestPages.HomePage;
import general.KeywordFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import TestPages.*;

public class HomePage_cartOperation extends DriverBase {
	protected Logger log = Logger.getLogger(HomePage.class.getName());// + ":" + nameofCurrMethod);
	public HomePage homepage = new HomePage();
	protected KeywordFunctions keys = new KeywordFunctions(driver);

	public Properties obj;
	public FileInputStream objfile;
	public String search_content, product_name;
	WebDriverWait wait;

	public HomePage_cartOperation(AppiumDriver driver) {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(new AppiumFieldDecorator(driver), homepage);
	}

	// performing cart operation after login
	public void cartoperation() throws InterruptedException, IOException {
		wait = new WebDriverWait(driver, 10);
		obj = new Properties();
		log.info(getClass());
		System.out.println(System.getProperty("user.dir"));
		objfile = new FileInputStream(System.getProperty("user.dir") + "/util/testdata.properties");
		obj.load(objfile);
		/*
		 * To read data from excel sheet ExcelRead=new
		 * FileInputStream("TestData/testdata.xlsx"); wbk=new XSSFWorkbook(ExcelRead);
		 * String search_item = wbk.getSheetAt(0).getRow(3).getCell(1).toString();
		 */
		log.info("Login successfull");
		keys.landscape();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Landscape rotation successfull");
		keys.portrait();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Portrait rotation successfull");

		search_content = obj.getProperty("search_content");
		log.info("Reading search content from external property file");
		System.out.println("search content:" + search_content);
		// Must be commented
		// keys.clickElement(wait.until(ExpectedConditions.visibilityOf(skip_signin)));
		// log.info("Signin skipped");
		
		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(homepage.search_box)));
		log.info("Clicked searchbox successfuly");

		keys.sendString(homepage.search_box, search_content);
		log.info("Typed search content successfuly");

		keys.enter_key();
		log.info("Clicked enter successfuly");

		product_name = obj.getProperty("product_name");
		System.out.println(product_name);
		log.info("Reading product name from external property file");
		keys.scrollToText(product_name);
		log.info("Scrolled till product name successfuly");
		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(homepage.s_prod_name)));
		log.info("Clicked product name successfuly");
		String pr_prce = keys.getElementText(homepage.prod_price, "text");
		log.info("retrieving product price");

		System.out.println("Product price:"+pr_prce); // rupees 54,999
		keys.VscrolltoElement(.98, .96, .28);
		log.info("Scrolled till Add to Cart successfuly");

		// keys.tryVscrolltoElement("//android.widget.Button[@text='Add to Cart']",.98,
		// .96, .50);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(homepage.add_cart));

		keys.clickElement(homepage.add_cart);
		log.info("Clicked Add to Cart successfuly");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(homepage.cart_img)));
		log.info("Clicked view cart successfuly");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String crt_itm_prce = keys.getElementText(homepage.cart_itm_price, "text");
		log.info("Retreiving cart item product price");

		System.out.println("Cart item price:"+crt_itm_prce); //    54,999.00
		// 54,999.00
		// String cip="54,999.00";
		log.info("Performing substring operation with both product and cart item price");

		String spp = pr_prce.substring(7, pr_prce.length());
		System.out.println("Substring product price:"+spp);
		// String scip=crt_itm_prce.substring(2,8);
		// System.out.println(scip);
		log.info("Comparing both prices with assertion");

		Assert.assertTrue(crt_itm_prce.contains(spp));
		keys.clickElement(wait.until(ExpectedConditions.visibilityOf(homepage.cart_proceed_tobuy)));
		log.info("Clicked Proceed to Buy successfuly");

	}

}
