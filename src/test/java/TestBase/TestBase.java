/**
 * 
 * TESTBASE ClASS
 * 
 * @author Parag Thakkar
 * 
 * This class is called initially to make all the setups required
 * to perform the execution of the scenarios
 *
 */
package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import TestListeners.WebEventListener;
import Utilities.TestUtil;

public class TestBase {
	
	//Create static WebDriver and Properties objects since they would be used in static methods
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eDriver;
	public static WebEventListener eventListener;
	
	//Initialize the prop object to access the Properties file key-value entries
	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream io = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Config/config.properties");
			prop.load(io);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Instantiate the driver object based on browser value passed to properties file
	public static void initialization() throws Exception {
		
		//browser value is chrome, so the tests would run in chrome 
		if(System.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
			driver = new ChromeDriver();
		}
		//if you want to run the tests in firefox, kindly configure the geckodriver path as done for chrome driver
		else if (System.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
			driver = new FirefoxDriver();
		}
		
		//Register WebDriver listener
		eDriver = new EventFiringWebDriver(driver);
		eventListener= new WebEventListener();
		eDriver.register(eventListener);
		driver = eDriver;
		
		//Set the size and timeouts for the chrome driver
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
