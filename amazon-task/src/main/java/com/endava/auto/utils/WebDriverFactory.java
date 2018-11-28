package com.endava.auto.utils;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	public WebDriver getWebDriver(String driverType) throws WebDriverException {
		if (driverType == null) {
			return null;
		}
		if (driverType.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();
		} else if (driverType.equalsIgnoreCase("chrome")) {
			return new ChromeDriver();
		} else {
			throw new InvalidArgumentException("Incorrect browser type. It should be either 'firefox' or 'chrome'.");
		}
	}
}
