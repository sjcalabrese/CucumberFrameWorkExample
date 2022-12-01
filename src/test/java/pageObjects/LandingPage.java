package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class LandingPage {

	public WebDriver driver;
	By searchTextBox = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.linkText("Top Deals");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchItem(String name) {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(name);
	}

	public void getSearchText() {
		driver.findElement(searchTextBox).getText();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
}
