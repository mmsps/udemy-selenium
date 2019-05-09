package br.gov.cursoSelenium.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {

	private static WebDriver driver;

	private  DriverFactory() {

	}

	public static WebDriver getDriver(){
		if (driver == null){
			switch (Propriedades.browser) {
			case CHROME: 
				ChromeOptions options = new ChromeOptions();
			    options.setExperimentalOption("useAutomationExtension", false);
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
				driver = new ChromeDriver(options);
			
			break;
			case FIREFOX: 
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");
				driver = new FirefoxDriver(); 			
			break;
			case OPERA: 
				System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/src/main/resources/operadriver");
				driver = new OperaDriver();			
			break;
			
			}

			driver.manage().window().setSize(new Dimension(1200, 765));
		}
		return driver;
	}

	public static void killDriver(){
		if (driver != null){
			driver.quit();
			driver = null;
		}

	}
}
