package com.Isracard.Final;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KayakBenefitPage extends DigitalBasePage{
	
	/**
	 * constructor of the KayakBenefitPage
	 * @param driver
	 */
	public KayakBenefitPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * page factory section - to find the elements that appear on the page and are going to be used in the tests
	 */
	@FindBy (xpath="//button[@class='read-more-btn position-relative collapsed']")
	private WebElement readMoreLInk;
	
	@FindBy (xpath="//button[@class='read-more-btn position-relative']")
	private WebElement closeReadMoreLInk;
	
	@FindBy(id="invokeAcquire")
	private WebElement acquireBenefit;
	
	@FindBy(xpath="//button[@class='conditions-btn collapsed']")
	private WebElement termsLink;
	
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("קייקי כפר בלום");
	}
	
	/**
	 * method that checks if the benefit is premium
	 * @param driver
	 */
	public void isPremium(WebDriver driver) {
		//add wait 
		WebElement penefitLabel = driver.findElement(By.cssSelector("div.carousel-item.active"));
		String benefitLabelString = penefitLabel.getText();
		assertEquals("פרימיום",benefitLabelString, "the benefit should be premium");
	}
	
	/**
	 * method that checks if open the read more element appears - if so will open this section 
	 */
	public void openReadMore() {
		Assertions.assertTrue(readMoreLInk.getText().equalsIgnoreCase("המשך קריאה")); 
		readMoreLInk.click();
	}
	
	/**
	 * method that checks if close the read more element appears - if so will close this section
	 */
	public void closeReadMore() {
		Assertions.assertTrue(closeReadMoreLInk.getText().equalsIgnoreCase("סגירה")); 
		closeReadMoreLInk.click();
	}
	
	/**
	 * method that finds the terms section and opens it 
	 * @return true if the section contains something ; otherwise - false 
	 */
	public boolean readTheTerms() {
		termsLink.click();
		return driver.findElements(By.id("conditions")) != null;
		
	}
	
	/**
	 * method that presses on "acquire benefit"
	 * @return a new BenefitsLogInPage
	 */
	public BenefitsLogInPage gotoAcquireBeneft() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(acquireBenefit));
		acquireBenefit.click();
        return new BenefitsLogInPage(driver);
	}
	
	/**
	 * method that confirms that the download process was succeed
	 */
	public void isBenefitDownloaded() {
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']//div[@class='col-12 modal-title-txt']")));
		WebElement modalTitle = driver.findElement(By.xpath("//div[@class='modal-content']//div[@class='col-12 modal-title-txt']"));
		Assertions.assertTrue(modalTitle.getText().equalsIgnoreCase("ההטבה הורדה בהצלחה"));
	}
	
	/**
	 * method that takes the driver to the "all my benefits" area to confirm what benefit we just downloaded 
	 * @return new DownloadedBenefitsPage
	 */
	public DownloadedBenefitsPage confirmBenefitDownloaded() {
		WebElement toAllMyBenefits = driver.findElement(By.xpath("//button[@class='btn btn-fixed l-width largeBtn events-btn']"));
		toAllMyBenefits.click();	
		return new DownloadedBenefitsPage(driver);
	}

}
