package webdriver.course.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

	public static WebDriver driver;

	public WebDriverManager(WebDriver driver) {
		WebDriverManager.driver = driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebDriverManager webDriverType(String driverName) {
		switch (driverName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron\\temp\\chromedriver.exe");
			driver = new ChromeDriver();
			return this;
		default:
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\liron\\temp\\chromedriver.exe");
			break;
		}
		return this;
	}

	public WebDriverManager setUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return this;
	}

}
