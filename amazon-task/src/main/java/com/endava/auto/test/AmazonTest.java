package com.endava.auto.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.endava.auto.pages.AmazonAddedProductDetailsPage;
import com.endava.auto.pages.AmazonMainPage;
import com.endava.auto.pages.AmazonPriceFilteredPage;
import com.endava.auto.pages.AmazonProductDetailsPage;
import com.endava.auto.pages.AmazonSearchResult;
import com.endava.auto.pages.AmazonShoppingCartPage;
import com.endava.auto.pages.AmazonToysAndGamesPage;
import com.endava.auto.pages.AmazonYearFilteredPage;
import com.endava.auto.utils.WebDriverFactory;

public class AmazonTest{
	
	private static final String firefoxPropertyName = "webdriver.gecko.driver";
	private static final String firefoxDriverExe = "geckodriver.exe";
	private static final String chromePropertyName = "webdriver.chrome.driver";
	private static final String chromeDriverExe = "chromedriver.exe";
	private static final String baseURL = "https://www.amazon.com";
	private static final String searchText = "Harry Potter";
	private WebDriver driver;
	
	@BeforeTest
	public void setBaseURL() {
		System.setProperty(firefoxPropertyName, AmazonTest.class.getClassLoader().getResource(firefoxDriverExe).getPath());
		System.setProperty(chromePropertyName, AmazonTest.class.getClassLoader().getResource(chromeDriverExe).getPath());
		WebDriverFactory factory = new WebDriverFactory();
		driver = factory.getWebDriver("chrome");
		driver.get(baseURL);
	}
	
	@Test
	public void Amazon_Test_() throws Exception {
		System.out.println("STEP 1: Navigate to Amazon");
		AmazonMainPage amazon = new AmazonMainPage(driver);
		System.out.println("STEP 2: In the “Search” text field, enter 'Harry Potter' and click the search button to perform a search.");
		AmazonSearchResult result = amazon.enterSearchText(searchText);
		System.out.println("STEP 3: Expand the departments list by clicking on 'See All # Departments'");
		result.clickAllDepartLink();
		System.out.println("STEP 4: Click on the 'Toys & Games' category to filter the results. ");
		AmazonToysAndGamesPage toysAndGames = result.clickToysAndGamesLink();
		System.out.println("STEP 5: Further down, find the Price section, and enter 10 in the min price and 150 in the max price text boxes, then click 'Go' to apply the changes.");
		toysAndGames.enterLowPrice(10);
		toysAndGames.enterMaxPrice(150);
		AmazonPriceFilteredPage priceFilter = toysAndGames.clickButtonGo();
		System.out.println("STEP 6: From the 'Toys Age Range' section select the '14 Years & Up' checkbox.");
		AmazonYearFilteredPage yearsFilter = priceFilter.clickCheckboxYears();
		String desiredTitle = yearsFilter.getProductTitle();
		System.out.println("STEP 7: Click on the first result link to open the product details page.");
		AmazonProductDetailsPage product = yearsFilter.clickFirstProduct();
		System.out.println("STEP 8: From the 'Qty' dropdown select a number that is different from 1, e.g. 4.");
		product.selectQuantityByValue("4");
		System.out.println("STEP 9: Click the 'Add to cart' button.");
		AmazonAddedProductDetailsPage productDetails = product.clickAddToCardButton();
		System.out.println("STEP 10: Click on the 'Cart' button to view the contents of the cart.");
		AmazonShoppingCartPage cart = productDetails.clickCartButton();
		String cartTitle = cart.getProductTitle();
		System.out.println("The desired product is: '" + desiredTitle + "' and the product in the cart is: '" + cartTitle + "'");
		System.out.println("STEP 11: Assert that the item in the shopping cart is the same item selected in the previous steps.");
		Assert.assertEquals(cartTitle, desiredTitle);
	}
	
	@AfterClass
	public void endSession() throws InterruptedException {
		//driver.quit();
	}

}
