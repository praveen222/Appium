package general;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import TestBase.DriverBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
// common functions across test execution
public class KeywordFunctions extends DriverBase {

	public KeywordFunctions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		driver = DriverBase.driver;
	}
	//clicking element
	public void clickElement(WebElement element) {

		element.click();

	}
	//setting value to element
	public void sendSetText(WebElement element, String str) {
		((MobileElement) element).clear();
		((MobileElement) element).setValue(str);
	}
	//seding text to element
	public void sendString(WebElement element, String str) {

		element.sendKeys(str);

	}
	//scrolling to element text
	public void scrollToText(String text) {

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
				+ ".scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));

	}
	//getting text property of element
	public  String getElementText(WebElement ele, String param) {
		String eletext = ele.getAttribute(param);

		return eletext;
	}
	
	
	@SuppressWarnings("rawtypes")
	public void VscrolltoElement(Double startwidthx, Double startheighty, Double endheighty) {
		TouchAction actions;
		Dimension dimensions = driver.manage().window().getSize();
		System.out.println("s=" + dimensions);
		Double screenWidthStart = dimensions.getWidth() * startwidthx;
		int scrollStartx = screenWidthStart.intValue();
		System.out.println("startx=" + scrollStartx);
		Double screenHeightStart = dimensions.getHeight() * startheighty;
		int scrollStarty = screenHeightStart.intValue();
		System.out.println("starty=" + scrollStarty);
		Double screenHeightEnd = dimensions.getHeight() * endheighty;
		int scrollEndy = screenHeightEnd.intValue();
		System.out.println("endy=" + scrollEndy);
		actions = new TouchAction(driver);
		int i =0;
		//boolean display=driver.findElement(By.xpath(xpath)).isDisplayed();
		do {
		actions.press(PointOption.point(scrollStartx, scrollStarty))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
		.moveTo(PointOption.point(scrollStartx, scrollEndy)).release().perform();
		i=i+1;
		}while(i<3);
		//driver.findElement(By.name(text)).click();

	}
	
	public void tryVscrolltoElement(String xpath, double startwidthx, double startheighty, double endheighty) {
		TouchAction actions;
		Dimension dimensions = driver.manage().window().getSize();
		System.out.println("s=" + dimensions);
		Double screenWidthStart = dimensions.getWidth() * startwidthx;
		int scrollStartx = screenWidthStart.intValue();
		System.out.println("startx=" + scrollStartx);
		Double screenHeightStart = dimensions.getHeight() * startheighty;
		int scrollStarty = screenHeightStart.intValue();
		System.out.println("starty=" + scrollStarty);
		Double screenHeightEnd = dimensions.getHeight() * endheighty;
		int scrollEndy = screenHeightEnd.intValue();
		System.out.println("endy=" + scrollEndy);
		actions = new TouchAction(driver);
		boolean display;
		By element=By.xpath(xpath);
		display = driver.findElements(element).size()>0;
		do{
		actions.press(PointOption.point(scrollStartx, scrollStarty))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
		.moveTo(PointOption.point(scrollStartx, scrollEndy)).release().perform();
		display = driver.findElements(element).size()>0;
		}while(display == false); 

	}	

	
	
	//perform enter key operation
	public void enter_key() {

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

	}
	//perform home key operation
	public void home_key() {

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.HOME));

	}
	//perform back key operation
	public void back_key() {

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

	}
	//perform landscape operation
	public void landscape() {
	driver.rotate(ScreenOrientation.LANDSCAPE);
	}
	//perform portrait operation
	public void portrait() {
	driver.rotate(ScreenOrientation.PORTRAIT);
	}
	
}
