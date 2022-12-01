package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	TestContextSetup testContextSetup;
	public String offerPageProductName;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("User search for {string} short name in offers page")
	public void user_search_for_the_same_short_name_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException{

		OffersPage offersPage = new OffersPage(testContextSetup.driver);
		
		switchToOffersPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offersPage.getProductName();

	}

	public void switchToOffersPage() {
		
		//if on offers page -> skip 
		//check page title or current url in if statement
		LandingPage landingPage = new LandingPage(testContextSetup.driver);
		landingPage.selectTopDealsPage();
		Set<String> s1 = testContextSetup.driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		testContextSetup.driver.switchTo().window(childWindow);
	}

	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.LandingPageProductName);
		testContextSetup.driver.quit();
	}
}
