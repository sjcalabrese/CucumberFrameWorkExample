package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage;
import utils.TestContextSetup;

public class CheckOutStepDefinition {

	private WebDriver driver;
	public String LandingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	public CheckOutPage checkOutPage;

	public CheckOutStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkOutPage = testContextSetup.pageObjectManager.getCheckOutPage();
	}

	@Then("^User proceeds to Checkout and validates the (.+) items in checkout page$")
	public void userProceedsToCheckoutAndValidateTheItems(String name) throws InterruptedException {
		checkOutPage.checkoutItems();
		
		//validate name from screen is correct base on name passed to method
	}
	@And("verify user is able to enter promo code and place order")
	public void verifyUserHasAbilityToEnterPromoCode() {
		
		
		Assert.assertTrue(checkOutPage.verifyPromoBtn());
		Assert.assertTrue(checkOutPage.verifyPlaceOrderButton());
	}

}
