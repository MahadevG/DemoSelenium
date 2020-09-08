package com.selenium.constant;

import org.openqa.selenium.By;

public class Xpath {
	public static class Login{
		public static By USER_NAME = By.id("userEmail");
		public static By PASS_WORD = By.id("userPwd");
		public static By SIGN_IN = By.xpath("//button[@type='submit']");
	}
	public static class Logout{
		public static By USER_NAME = By.id("userEmail");
		public static By PASS_WORD = By.id("userPwd");
		public static By SIGN_IN = By.xpath("//button[@type='submit']");
	}
}
