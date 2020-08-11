package course.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void submit() {
		
		driver.findElement(By.id("wp-submit")).click();
	}
//	public void userName(String username) {
//		driver.findElement(By.id("user_login")).sendKeys(username);
//	}
//	
//	public void Password(String password) {
//		driver.findElement(By.id("user_pass")).sendKeys(password);
//	}
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Log In");
	}
	public LoginPage WithUserName(String username) {
		driver.findElement(By.id("user_login")).sendKeys(username);
		return this;
	}
	public LoginPage WithPassword(String password) {
		driver.findElement(By.id("user_pass")).sendKeys(password);
		return this;
	}
	

}
