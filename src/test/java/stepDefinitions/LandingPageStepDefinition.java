package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	private WebDriver driver;
	public String LandingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(landingPage.getTitleOfLandingPage().contains("GreenKart"));
	}

	@When("^User searched with short name (.+) and extracted actual name of product$")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.LandingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.LandingPageProductName + " is extracted from Home Page");

	}
	
	@And("Added {string} items of the selected product to cart")
	public void addedItemsOfProduct(String qty) {
		landingPage.incrementQty(Integer.parseInt(qty));
		landingPage.addToCart();
	}

}
