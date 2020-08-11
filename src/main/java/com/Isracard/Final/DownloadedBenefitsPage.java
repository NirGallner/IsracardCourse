package com.Isracard.Final;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadedBenefitsPage extends DigitalBasePage {
 
	/**
	 * constructor of the DownloadedBenefitsPage
	 * @param driver
	 */
	public DownloadedBenefitsPage(WebDriver driver) {
		super(driver);
	}
	
//	@FindBy (xpath="//*[@class='single-benefit-details']//*[@class='benefit-name']")
//	private static List<WebElement> benefitNames;
	
	/**
	 * method that checks if the driver on the expected page - on DownloadedBenefitsPage
	 * @param driver
	 * @return true if the page as expected ;  otherwise - false
	 */
	public boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("אזור אישי"); 
	}
	
	/**
	 * method that confirms that the download benefit is as expected- can be modified by changing the name of 
	 * the expected benefit
	 * 
	 */
	public void confirmTheDownloadedBenefit() {
		List<WebElement> benefitNames = driver.findElements(By.xpath("//*[@class='single-benefit-details']//*[@class='benefit-name']"));
		try {
			//if the element benefitNames was not found it will throw an exception - no such element..
		if(benefitNames !=null) {
			for(WebElement benefitName: benefitNames) {
				if (benefitName.getText().contentEquals("קייקי כפר בלום - שייט 1+1")) {
					System.out.println(benefitName.getText());
					//return true;	
				}	
				
			}
			}
		}
		catch (NoSuchElementException notFound) {
		throw new NoSuchElementException ("The expected benefit did not found", notFound);
		}
	}

	

	/**
	 * method that cancels the download benefit 
	 * @return true if the "no benefits element" appears ; otherwise - false
	 */
	public boolean cancelDownloadedBenefit() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='cancel-btn text-right']")));
		WebElement cancelDownloaded = driver.findElement(By.xpath("//*[@class='cancel-btn text-right']"));
		cancelDownloaded.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-blue cancel_btn']")));
		WebElement acceptButton = driver.findElement(By.xpath("//button[@class='btn btn-blue cancel_btn']"));
		acceptButton.click();
		return driver.findElements(By.xpath("//*[@class='noCouponsDiv']//*[contains(text(),'איפה כל ההטבות שלך?')]")) != null;
	}


}
		

