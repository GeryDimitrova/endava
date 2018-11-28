package com.endava.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AmazonProductDetailsPage extends AbstractAmazonPage {
	
	private WebElement quantity;
	
	private WebElement addToCardButton;

	public AmazonProductDetailsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void initPageElements() {
		quantity = driver.findElement(By.id("quantity"));
		addToCardButton = driver.findElement(By.id("add-to-cart-button"));
	}
	
	public void selectQuantityByValue(String val) {
		System.out.println(this.getClass().getName() + " :Enter quantity of the product:" + val);
		Select select = new Select(quantity);
		select.selectByValue(val);
	}
	
	public AmazonAddedProductDetailsPage clickAddToCardButton() {
		System.out.println(this.getClass().getName() + " :Click on AddToCard button");
		addToCardButton.click();
		
		return new AmazonAddedProductDetailsPage(driver);
	}

}
