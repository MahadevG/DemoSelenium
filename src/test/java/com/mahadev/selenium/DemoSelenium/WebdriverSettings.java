package com.mahadev.selenium.DemoSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebdriverSettings {
	public WebDriver driverSettings() {
		System.setProperty("webdriver.chrome.driver", "/home/mahadev/Documents/Eclipse-Workspace/driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public WebDriver headlessDriverSettings() {
		System.setProperty("webdriver.chrome.driver", "/home/mahadev/Documents/Eclipse-Workspace/driver/chromedriver");
		final ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--allow-insecure-localhost");
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		caps.setCapability("acceptInsecureCerts", caps);
		WebDriver driver = new ChromeDriver(options);
		
		return driver;
	}
}
