package com.selenium.constant;

import org.openqa.selenium.By;

public class Xpath {
	
	public static class Login{
		public static By USER_NAME = By.xpath("//*[@id='userEmail']");
		public static By PASS_WORD = By.xpath("//*[@id='userPwd']");
		public static By SIGN_IN = By.cssSelector(".btn");
		public static By USR_FIELDERROR = By.cssSelector(".form-group:nth-child(1) span");
		public static By PASS_FIELDERROR = By.cssSelector(".no-gutter span");
		public static By REME_BTN = By.xpath("//*[@id=\'rememberMe\']");
		public static By ERROR_MSG = By.xpath("//*[contains(text(),'The email and password combination ')]");
		public static By USER_PROFILE_ICON = By.cssSelector(".user-name-first");
	}
	
}


