package com.mahadev.selenium.DemoSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverSettings {
	public WebDriver driverSettings() {
		System.setProperty("webdriver.chrome.driver", "/home/mahadev/Documents/Eclipse-Workspace/driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
}
