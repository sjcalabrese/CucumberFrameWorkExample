package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/com/sal/features",
glue="stepDefinitions",
monochrome=true, 
dryRun=true)
public class testNGTestRunner extends AbstractTestNGCucumberTests{
//dryRun = gives skeleton if run without mapping done correctly
	//extending AbstractTestNGCucumberTests  - used for testng to run cucumber framework
}
