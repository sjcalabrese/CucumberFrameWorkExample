package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class CheckOutPage {

	public WebDriver driver;

	By cart = By.cssSelector("[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]");
	By promoButton = By.cssSelector(".promoBtn");
	By placeOrderButton = By.xpath("//button[contains(text(), 'Place Order')]");

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void checkoutItems() {
		
		driver.findElement(cart).click();
		driver.findElement(checkOutButton).click();
	}
	
	public Boolean verifyPromoBtn() {
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public Boolean verifyPlaceOrderButton() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}

}
