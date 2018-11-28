package com.endava.auto.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractAmazonPage {
	
	protected WebDriver driver;
	
	public AbstractAmazonPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		initPageElements();
	}
	
	public String getElementText(WebElement webElement) {
		return webElement.getText();
	}

	protected abstract void initPageElements();

}
