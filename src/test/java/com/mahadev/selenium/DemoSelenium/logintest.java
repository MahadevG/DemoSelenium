package com.mahadev.selenium.DemoSelenium;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.selenium.constant.Xpath;
import com.selenium.utils.Utility;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

public class logintest {
	
	@Test
	public static void login() throws InterruptedException {
		BrowserSetting bs = new BrowserSetting();
		WebDriver driver = bs.BrowserSettings();
		Thread.sleep(3000);
		    driver.findElement(Xpath.Login.USER_NAME).click();
		    driver.findElement(Xpath.Login.USER_NAME).sendKeys("lina@mammoth.io");
		    driver.findElement(Xpath.Login.PASS_WORD).click();
		    driver.findElement(Xpath.Login.PASS_WORD).sendKeys("abstract1043");
		    Assert.assertEquals("Sign in", driver.findElement(Xpath.Login.SIGN_IN));
		    driver.findElement(Xpath.Login.SIGN_IN).click();
			Thread.sleep(3000);	  
			int actual =2;
			int expected=3;
			assertEquals(actual, expected);
		driver.close();
	}
	
	@AfterMethod
	public static void tearDown(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			try {
				Utility.takeSnapShot(1);
			}catch (Exception e) {
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
		}
	}
}
