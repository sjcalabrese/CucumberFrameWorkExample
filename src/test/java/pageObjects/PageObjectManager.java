package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import stepDefinitions.Hooks;

public class PageObjectManager {


	public WebDriver driver;
	public LandingPage landingPage;
	public OffersPage offersPage;
	public Hooks hooks;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	
}
