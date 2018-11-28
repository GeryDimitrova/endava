package com.endava.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchResult extends AbstractAmazonPage {
	
	private WebElement allDepartLink;
	
	private WebElement toysAndGamesLink;

	public AmazonSearchResult(WebDriver driver) {
		super(driver);
	}
	
	@Override
	protected void initPageElements() {
		allDepartLink = driver.findElement(By.cssSelector(".a-expander-prompt"));
		toysAndGamesLink = driver.findElement(By.linkText("Toys & Games"));
	}
	
	public void clickAllDepartLink() {
		System.out.println(this.getClass().getName() + " :Click on 'All # Departments' link");
		allDepartLink.click();
	}
	
	public AmazonToysAndGamesPage clickToysAndGamesLink() {
		System.out.println(this.getClass().getName() + " :Click on 'Toys & Games' link");
		toysAndGamesLink.click();
		
		return new AmazonToysAndGamesPage(driver);
	}
	

}
