package PageObject;

import org.openqa.selenium.WebDriver;

public class DashboardPage {

	private WebDriver Driver;
	
	public DashboardPage() {
	}
	
	public DashboardPage (WebDriver driver) {
		this.Driver  = driver;
	}
	
	public static boolean IsOnPage (WebDriver driver) {
		 return driver.getTitle().contains("Dashboard");	
		}
	
}
