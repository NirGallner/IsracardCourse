package course.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	
	 protected WebDriver driver;

	    public void PageObject(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

}
