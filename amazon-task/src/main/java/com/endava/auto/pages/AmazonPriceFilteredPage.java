package com.endava.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPriceFilteredPage extends AbstractAmazonPage {
	
	private WebElement checkboxYears;

	public AmazonPriceFilteredPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void initPageElements() {
		checkboxYears = driver.findElement(By.cssSelector("input[name='s-ref-checkbox-5442388011']"));
	}
	
	public AmazonYearFilteredPage clickCheckboxYears() {
		System.out.println(this.getClass().getName() + " :Check years filter checkbox.");
		if( !driver.findElement(By.cssSelector("input[name='s-ref-checkbox-5442388011']")).isSelected())
			checkboxYears.click();
		
		return new AmazonYearFilteredPage(driver);
	}

}
