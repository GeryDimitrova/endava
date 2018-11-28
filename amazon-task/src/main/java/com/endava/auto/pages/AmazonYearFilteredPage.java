package com.endava.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonYearFilteredPage extends AbstractAmazonPage {
	
	private WebElement firstProduct;

	public AmazonYearFilteredPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void initPageElements() {
		firstProduct = driver.findElement(By.cssSelector("li#result_1 > div > div > div > a.a-link-normal.s-access-detail-page.s-color-twister-title-link.a-text-normal"));
	}
	
	public AmazonProductDetailsPage clickFirstProduct() {
		//firstProduct.click();
		System.out.println(this.getClass().getName() + " :Click on first product by javascript");
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("arguments[0].click();", firstProduct);
		
		return new AmazonProductDetailsPage(driver);
	}
	
	public String getProductTitle() {
		return firstProduct.getAttribute("title");
	}

}
