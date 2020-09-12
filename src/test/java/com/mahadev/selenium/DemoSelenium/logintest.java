package com.mahadev.selenium.DemoSelenium;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.selenium.constant.Xpath;
import com.selenium.utils.Utility;
import report_genarator.Reporter;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class logintest {
	static BrowserSetting bs = new BrowserSetting();
	static WebDriver driver = bs.BrowserSettings();
	
//	@Test(priority=1,description =" username and password fields validation")
	public static void verifyUsernameFiled() {
		Reporter.setWebDriver(driver);
		WebElement userField;
		//Verify  empty or invalid username
	    try {
	    	userField = driver.findElement(Xpath.Login.USER_NAME);
	    	userField.click();
	    	userField.clear();
	    	userField.sendKeys("mammoth");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    try {
	    	driver.findElement(Xpath.Login.PASS_WORD).click();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    assertEquals(driver.findElement(Xpath.Login.USR_FIELDERROR).getText(), "Invalid email address");
	    driver.findElement(Xpath.Login.REME_BTN).click();
	    assertEquals(driver.findElement(Xpath.Login.PASS_FIELDERROR).getText(), "Password cannot be empty.");
	    try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    driver.navigate().refresh();
	}

//	@Test(priority=2,description ="Negative login test")
	public static void negativeLogin() throws InterruptedException {

		Reporter.setWebDriver(driver);
		//Verify positive login case
	    driver.findElement(Xpath.Login.USER_NAME).click();
	    driver.findElement(Xpath.Login.USER_NAME).sendKeys("lina@mammoth.io");
	    driver.findElement(Xpath.Login.PASS_WORD).click();
	    driver.findElement(Xpath.Login.PASS_WORD).sendKeys("abstract1045");
	    Assert.assertEquals("Log in", driver.findElement(Xpath.Login.SIGN_IN).getText());
	    driver.findElement(Xpath.Login.SIGN_IN).click();
	    Thread.sleep(300);

	    WebElement NAme = driver.findElement(By.xpath("//*[contains(text(),'The email and password combination ')]"));
	    boolean a= NAme.isDisplayed();
	    System.out.println(a);

		boolean is_ErrorMsg =driver.findElement(Xpath.Login.ERROR_MSG).isDisplayed();
		if(is_ErrorMsg=true) {
			Assert.assertTrue(isElementPresent(Xpath.Login.ERROR_MSG), "Error message not appeared");
		}
	    driver.navigate().refresh();
	}
	
//	@Test(priority=3,description="Verify framework in fail senario")
	public static void fail() throws InterruptedException {

		Reporter.setWebDriver(driver);
		//Verify positive login case
	    driver.findElement(Xpath.Login.USER_NAME).click();
	    driver.findElement(Xpath.Login.USER_NAME).clear();
	    driver.findElement(Xpath.Login.USER_NAME).sendKeys("lina@mammoth.io");
	    driver.findElement(Xpath.Login.PASS_WORD).click();
	    driver.findElement(Xpath.Login.PASS_WORD).clear();
	    driver.findElement(Xpath.Login.PASS_WORD).sendKeys("abstract1045");
	    Assert.assertEquals("Log in", driver.findElement(Xpath.Login.SIGN_IN).getText());
	    driver.findElement(Xpath.Login.SIGN_IN).click();
	    Thread.sleep(300);

		boolean is_Signin_present =driver.findElement(Xpath.Login.USER_PROFILE_ICON).isDisplayed();
		if(is_Signin_present!=true) {
			Assert.assertTrue(isElementPresent(Xpath.Login.USER_PROFILE_ICON), "User profile icon is not present");
		}
	    driver.navigate().refresh();
	}
	@Test(priority=4,description="Positive login test")
	public static void positiveLogin() throws InterruptedException {

		Reporter.setWebDriver(driver);
		//Verify positive login case
	    driver.findElement(Xpath.Login.USER_NAME).click();
	    driver.findElement(Xpath.Login.USER_NAME).clear();
	    driver.findElement(Xpath.Login.USER_NAME).sendKeys("lina@mammoth.io");
	    driver.findElement(Xpath.Login.PASS_WORD).click();
	    driver.findElement(Xpath.Login.PASS_WORD).clear();
	    driver.findElement(Xpath.Login.PASS_WORD).sendKeys("abstract104");
	    Assert.assertEquals("Log in", driver.findElement(Xpath.Login.SIGN_IN).getText());
	    driver.findElement(Xpath.Login.SIGN_IN).click();
	    Thread.sleep(300);

		boolean is_Signin_present =driver.findElement(Xpath.Login.USER_PROFILE_ICON).isDisplayed();
		if(is_Signin_present!=true) {
			Assert.assertTrue(isElementPresent(Xpath.Login.USER_PROFILE_ICON), "User profile icon is not present");
		}
	}
	
	@AfterMethod
	public static void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			try {
				Utility.takeSnapShot(1);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	  @AfterTest
	  public void tearDown() {
		driver.close();
		driver.quit();
	  }

	  private static boolean isElementPresent(By element) {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);  
		try {
			driver.findElement(element);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
		finally{  
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		     }  
		}
}
