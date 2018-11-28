package com.endava.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonMainPage extends AbstractAmazonPage{
	
	private WebElement searchInput;
	
	private WebElement buttonGo;
	
	public AmazonMainPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void initPageElements() {
		searchInput = driver.findElement(By.id("twotabsearchtextbox"));
		buttonGo = driver.findElement(By.cssSelector("input.nav-input"));
	}
	
	public AmazonSearchResult enterSearchText(String text) {
		System.out.println(this.getClass().getName() + " :Enter text '" + text + "' in Search input");
		this.searchInput.sendKeys(text);
		searchInput.sendKeys(Keys.ENTER);
		
		return new AmazonSearchResult(driver);
	}
	
	public void clickButtonGo() {
		this.buttonGo.click();
	}
}
