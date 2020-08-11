package com.Isracard.Final;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Isracard.Final.DigitalBasePage;

public class HatavotPage extends DigitalBasePage {
	
	//String pageTitle;

	/**
	 * constructor of the HatavotPage
	 * @param driver
	 */
	public HatavotPage(WebDriver driver) {
		super(driver);
	}
	
//	@FindBy (tagName="h1")
//	private WebElement pageH1;
//	
	/**
	 * method that checks if we are on the correct page as expected 
	 * @param driver
	 * @return true if the title as expected ; otherwise - false 
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("ישראכרט אתר ההטבות"); 
	}
	
//   public String getTheH1 () {
//    pageTitle = pageH1.getText();
//	System.out.println("The page h1 is: " + pageTitle);
//	return pageTitle;
//   }	
   
//   public boolean isOnBasePage(WebDriver driver, String pageTitle) {
//	String xpath = "//h1[text()= '" + pageTitle + "']";
//	List<WebElement> elements = driver.findElements(By.xpath(xpath));
//	return elements.size() > 0 ;
//	}

	/**
	 * method that takes the driver to the kayak benefit page
	 */
   public void gotoKayakBenefit() {
	   WebDriverWait wait = new WebDriverWait(driver, 40);
	   wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("קייקי כפר בלום")));
	   WebElement kayakbenefit = driver.findElement(By.partialLinkText("קייקי כפר בלום"));
	   kayakbenefit.click();
    
   }

//	public void pagesEqualityCheck() {
//		String pageTitle = pageH1.getText();
//		System.out.println("The page h1 is: " + pageTitle);
//		
//	}

	
	
	

}
