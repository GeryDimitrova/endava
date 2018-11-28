package com.endava.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonAddedProductDetailsPage extends AbstractAmazonPage {
	
	private WebElement cartButton;

	public AmazonAddedProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void initPageElements() {
		cartButton = driver.findElement(By.cssSelector("#attach-view-cart-button-form > span > span > input"));
	}
	
	public AmazonShoppingCartPage clickCartButton() {
		//cartButton.click();
		System.out.println( this.getClass().getName() + " :Click on Cart button using javascript");
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("arguments[0].click();", cartButton);
		
		return new AmazonShoppingCartPage(driver);
	}

}
