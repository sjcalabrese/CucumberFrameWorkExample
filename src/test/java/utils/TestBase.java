package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;

	public WebDriver webDriverManager() throws IOException {

		// If you use path given in your system it will include user which will not work
		// need to use System.getenf("user")
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println("driver: " + driver);
		if (driver == null) {
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(prop.getProperty("QAUrl"));
		}
		return driver;
	}
}
