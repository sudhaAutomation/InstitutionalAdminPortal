package com.admin.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Listeners;

import com.admin.qa.util.TestUtil;
import com.admin.qa.util.WebEventListener;
import com.qa.reportlistener.ExtentReporterNG;

@Listeners(value = ExtentReporterNG.class)
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	static {
		try {
			prop = new Properties();
			FileInputStream is = new FileInputStream("src/main/java/com/admin/qa/config/config.properties");
			prop.load(is);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
			//driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			//options.setBinary("C:\\Users\\SWHIZZ TECHNOLOGIES\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
			options.setBinary(System.getProperty("chromePath"));
			System.out.println("===============================>"+System.getProperty("chromePath"));
			driver = new ChromeDriver(options);
					
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "bin/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
