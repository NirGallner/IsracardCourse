package IsracardProject;

import org.openqa.selenium.WebDriver;

public class Category extends BaseIsracardPage {
	
	//private WebDriver driver;
	
	public String categoryName;
	
	public Category(WebDriver driver) {
		super(driver);
	}
	
	
	public Category(WebDriver driver,String textNameCategory) {
		super(driver);
	    this.categoryName = textNameCategory;
	}
	
	
//	public boolean IsOnPage (WebDriver driver) {
//	 System.out.println(driver.getTitle());
//	 return driver.getTitle().contains("×™×?×“×™×?");	
//	}


}
