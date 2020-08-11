package course.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//get user name after login
	@FindBy (linkText="ωμεν")
	private WebElement checkIfLogedIn;
	
	public HomePage (WebDriver driver) {
		this.driver=driver;
		//this method create all web elements
		PageFactory.initElements(driver,this);
		
	}

	//get text from page after login 
	public String getHomePageDashboardHello() {
		return checkIfLogedIn.getText();
	}
	
	
}
