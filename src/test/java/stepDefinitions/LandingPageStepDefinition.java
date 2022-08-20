package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	private WebDriver driver;
	public String LandingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "home/sal/Documents/TestDrivers/chromedriver");
		testContextSetup.driver = new ChromeDriver();
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");	    
	    
	}
	@When("User searched with short name {string} and extracted actual name of product")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
	    
		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		/*
		 * returns tomato - 1 kg using string class to help clean text split - splits
		 * based on hyphen splits it into an array so [0] is tomato and then use trim
		 * because there is a space after
		 */
		testContextSetup.LandingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(testContextSetup.LandingPageProductName + " is extracted from Home Page");
		
	}
	
}
