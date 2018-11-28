package com.endava.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonShoppingCartPage extends AbstractAmazonPage {
	
	private WebElement cartProduct;

	public AmazonShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void initPageElements() {
		cartProduct = driver.findElement(By.cssSelector("span.a-size-medium.sc-product-title.a-text-bold"));
	}
	
	public String getProductTitle() {
		return this.getElementText(cartProduct);
	}

}
