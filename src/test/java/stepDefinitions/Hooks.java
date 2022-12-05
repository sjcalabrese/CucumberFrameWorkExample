package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.After;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup tcs;
	
	public Hooks(TestContextSetup tcs) throws IOException {
	this.tcs = tcs;
	}
	@After
	public void afterScenario() throws IOException {
		//occurs after each scenario completes
		
		System.out.println("in after hook");
		tcs.testBase.webDriverManager().quit();
	}
}
