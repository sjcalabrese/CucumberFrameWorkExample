package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	//Factory design pattern
	  // using 1 class to create all objects in one class
	TestContextSetup testContextSetup;
	public String offerPageProductName;
	PageObjectManager pageObjectManager;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^User search for (.+) short name in offers page$")
	public void user_search_for_the_same_short_name_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException{

		OffersPage offersPage =testContextSetup.pageObjectManager.getOffersPage();
		
		switchToOffersPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offersPage.getProductName();

	}

	public void switchToOffersPage() {
		
		//if on offers page -> skip 
		//check page title or current url in if statement
		
		//using depedency injection to avoid using "new" keyword
		//pageObjectManager = new PageObjectManager(testContextSetup.driver);
		//using testcontextSetup to instantate pageObjectManager
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchWindowToChild();
	}

	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.LandingPageProductName);
		
	}
}
