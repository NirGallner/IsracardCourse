package com.Isracard.Final;

import org.openqa.selenium.WebDriver;

public abstract class FooterHandler {

	private final WebDriver driver;
    /**
     * Constructor of the FooterHandrel page
     * @param driver
     */
	public FooterHandler(WebDriver driver) {
		this.driver = driver;
	}
		/**
		 * an abstract method- every page that extend this page will override it and use it in its unique way
		 * @param driver
		 */
	protected abstract void openWindow(WebDriver driver);
		
//	protected boolean isExpectedWindow(WebDriver driver, String originalWindowHandle) {
//		return !driver.getWindowHandle().equals(originalWindowHandle);
//	}
	/**
	 * Method that extracts the current URL and checks if it is not as expected  
	 * @param driver
	 * @param originalURL
	 * @return true - if it not the same ; false - if it the same
	 */
	protected boolean isExpectedURL(WebDriver driver, String originalURL) {
		return !driver.getCurrentUrl().equals(originalURL);
	}
	/**
	 * an abstract method- every page that extend this page will override it in its unique way
	 * @param driver
	 */
	public abstract void useWindow(WebDriver driver); 
	
    /**
     * The main method - extracts the URL, call the open window method, make sure that 
     * the URL changed -if not will throw an error if yes - will call the use window , 
     * method, finally will return the us the original URL
     */
	public void run() {
		String originalURL = driver.getCurrentUrl();
		
		openWindow(driver);
		
		try {
			if(isExpectedURL(driver,originalURL)) {
				useWindow(driver);
			}
		}
		catch (IllegalStateException e) {
			 throw new IllegalStateException(e +"unable to find the correct window");
		}
		finally {
			driver.get(originalURL);
		
		}
		
	}
	
	
//	public void run() {
//		String originalWindowHandle = driver.getWindowHandle();
//				
//			openWindow(driver);
//			try {
//				for (String windowHandle : driver.getWindowHandles()) {
//					driver.switchTo().window(windowHandle);
//					if (isExpectedWindow(driver, windowHandle)) {
//						useWindow(driver);
//						if (!driver.getWindowHandle().equals(originalWindowHandle)){
//						   driver.close();
//						   return;
//			
//						}
//					}
//				}
//			}
//			 catch (IllegalStateException e) {
//				 throw new IllegalStateException(e +"unable to find the correct window");	
//			}
//				finally {
//				driver.switchTo().window(originalWindowHandle);
//			
//			}
	}

	



