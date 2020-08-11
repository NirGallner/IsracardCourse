package com.Isracard.Final;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KfarBlumBusinessPage {

	private WebDriver driver;


	/**
	 * constructor of the KfarBlumBusinessPage
	 */
	public KfarBlumBusinessPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * method that takes the original window handler -> forwarded the driver to the new one -> compares the new 
	 * window's title to the expected one 
	 */
	public void newWindowCheck() {
	   String originalWindowHandle = driver.getWindowHandle();
	   WebDriverWait wait = new WebDriverWait(driver ,30);
	   wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("לאתר בית העסק")));
	   driver.findElement(By.linkText("לאתר בית העסק")).click();
		try {
			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);
				if (isExpectedWindow(windowHandle)) {
					useWindow();
					if (!driver.getWindowHandle().equals(originalWindowHandle)){
					   driver.close();
					   return;
		
					}
				}
			}
		}
		 catch (IllegalStateException e) {
			 throw new IllegalStateException(e +"unable to find the correct window");	
		}
			finally {
			driver.switchTo().window(originalWindowHandle);
			
		
		}
	}
    /**
     * method that takes the current page title and compares to the expected 
     */
	private void useWindow() {
		try {
			Assertions.assertEquals("קיאקים בנהר הירדן - קייקי כפר בלום", driver.getTitle() ,"The title should be ישראכרט אתר ההטבות");
			}
			catch (NoSuchElementException notFound){
			throw new NoSuchElementException ("The extpected title was not found " + driver.getCurrentUrl());	
		} 
		
	}


	/**
	 * Method that extracts the current windowHandler and checks if it is not as expected 
	 * @param windowHandle
	 * @return true - if it not the same ; false - if it the same
	 */
	private boolean isExpectedWindow(String windowHandle) {
		return !driver.getWindowHandle().equals(windowHandle);
		
	}
}
