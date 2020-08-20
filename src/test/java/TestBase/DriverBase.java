package TestBase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverBase {
	//log implementation
	protected Logger log = Logger.getLogger(TestBase.DriverBase.class.getName());
	DesiredCapabilities cap;
	protected static AndroidDriver driver;
	AppiumDriverLocalService appiumService;

	@BeforeMethod
	@Parameters({ "deviceName_", "platformVersion_", "platformName_", "appPackage_", "appActivity_" })
	//creating android driver
	public void driversetUp(String deviceName_, String platformVersion_, String platformName_, String appPackage_,
			String appActivity_) throws MalformedURLException {
		System.out.println("Loading configuration of Android driver and Desired capabilities...!");
		/*
		//application installation from projet directory
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/util/");
		File application = new File(appDir, "Amazon_shopping.apk");
		*/
		
		cap = new DesiredCapabilities();
		//Dom configuration for Log messages
		DOMConfigurator.configure("util/log4j.xml");
		log.info(getClass());
		cap.setCapability("deviceName", deviceName_);
		cap.setCapability("platformVersion", platformVersion_);
		cap.setCapability("platformName", platformName_);
		cap.setCapability("appPackage", appPackage_);
		cap.setCapability("appActivity", appActivity_);
		//cap.setCapability("app", application);
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("autoAcceptAlerts", "true");
		cap.setCapability("noReset", "false");
		cap.setCapability("fullReset", "false");
		cap.setCapability("automationName", "UiAutomator1");
		cap.setCapability("skipServerInstallation", "true");
		//Creating android driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Androiddriver created successfully");
		log.info("Application launched successfully");


	}

	@AfterMethod
	//each test case result after execution and quitting driver
	public void listenerResultFlow_driverTearDown(ITestResult result) throws InterruptedException, IOException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		System.out.println("Result is :" + result);
		System.out.println("Result status is :" + result.getStatus());
		String methodName = result.getName();
		//Taking screenshot if testcase failed
		if (!result.isSuccess()) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String screenshotPath = System.getProperty("user.dir") + "/screenshots/FailureScreenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png";
				System.out.println("Taking screenshot:" + screenshotPath);
				FileUtils.copyFile(scrFile, new File(screenshotPath));

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			log.info(methodName+" Testcase is failed");
		} 
		else if (result.getStatus() == ITestResult.SKIP) {
		System.out.println("Testcase skipped");
		log.info(methodName+" Testcase is skipped");
		} 
		//Taking screenshot if testcase paased
		else if (result.getStatus() == ITestResult.SUCCESS) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String screenshotPath = System.getProperty("user.dir") + "/screenshots/SuccessfullScreenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png";
				System.out.println("Taking screenshot:" + screenshotPath);
				FileUtils.copyFile(scrFile, new File(screenshotPath));
		
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("Result is :" + result);
			System.out.println("Result status is :" + result.getStatus());
			System.out.println("Test Case PASSED is " + result.getName());
			log.info(methodName+" Testcase is passed");
		}
		//quitting driver
		driver.quit();
		log.info("Driver quit successfully");
	}
}