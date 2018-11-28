package com.endava.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonToysAndGamesPage extends AbstractAmazonPage {
	
	private WebElement inputLowPrice;
	
	private WebElement inputMaxPrice;
	
	private WebElement buttonGo;

	public AmazonToysAndGamesPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void initPageElements() {
		inputLowPrice = driver.findElement(By.id("low-price"));
		inputMaxPrice = driver.findElement(By.id("high-price"));
		buttonGo = driver.findElement(By.cssSelector("input.a-button-input[value='Go']"));
	}

	public void enterLowPrice(int price) {
		System.out.println(this.getClass().getName() + " :Enter low value of price filter:" + price);
		inputLowPrice.sendKeys(price + "");
	}
	
	public void enterMaxPrice(int price) {
		System.out.println(this.getClass().getName() + " :Enter max value of price filter:" + price);
		inputMaxPrice.sendKeys(price + "");
	}
	
	public AmazonPriceFilteredPage clickButtonGo() {
		System.out.println(this.getClass().getName() + " :Press Go button of price filter.");
		buttonGo.click();
		
		return new AmazonPriceFilteredPage(driver);
	}
}
