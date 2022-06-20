package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartStepDefinition {
	
	private WebDriver driver;

	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		System.setProperty("webdriver.chrome.driver", "home/sal/Documents/TestDrivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    
	    throw new io.cucumber.java.PendingException();
	}
	@When("User searched with short name {string} and extracted actual name of product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) {
	    
		driver.findElement(By.xpath("//input[@type='search'")).sendKeys(shortName);
		/*
		 * returns tomato - 1 kg using string class to help clean text split - splits
		 * based on hyphen splits it into an array so [0] is tomato and then use trim
		 * because there is a space after
		 */
		String productName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(productName + " is extracted from Home Page");
		
	}
	@Then("User search for the same short name in offers page to check if product exists")
	public void user_search_for_the_same_short_name_in_offers_page_to_check_if_product_exists() {
	    
	    throw new io.cucumber.java.PendingException();
	}
}
