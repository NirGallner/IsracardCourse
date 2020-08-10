package isracard.menusAndPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KfarBlumPage extends HatavutBasePage{
	
	private StringBuilder kfarBlumHatavaExceptions = new StringBuilder();
	
	@FindBy (css = ".premium-benefit")
	private WebElement isPrimium;
	
	@FindBy (linkText = "לאתר בית העסק")
	private WebElement webSiteLink;
	
	@FindBy (xpath = "//*[@class='benefit-execution']//*[text()='המשך קריאה']")
	private WebElement hemshechKriaaLink;
	
	@FindBy (xpath = "//*[@class='benefit-execution']//*[text()='סגירה']")
	private WebElement sgiraLink;
	
	@FindBy (xpath = "//*[@class='mobile-btn-bg d-sm-block']//*[@id='invokeAcquire']")
	private WebElement horadatHatava;
	
	@FindBy (css = ".conditions-wrapper")
	private WebElement tnaimVeHagbalut;
	
	@FindBy (className = "collapse show")
	private WebElement kolaapsTnaimVehagbalot;
	
	
	
	/**
	 * c-tor
	 * @param driver
	 */
	public KfarBlumPage(WebDriver driver) {
		super(driver);
		
	}

	
	/**
	 * Verify we are in HatavotPage
	 * @param driver
	 * @return
	 */
	public boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("קייקי כפר בלום");
	}

	
	
	/**
	 * Check if thie Hatava is primium
	 * @return
	 * @throws Throwable
	 */
	public void isPrimium() throws Throwable {
		
		if (this.isOnPage(driver) == true) {
		
			System.out.println("Hatavat primium");
			
			if(isPrimium.isDisplayed() == false) 
				
				//Add to SB the message
				kfarBlumHatavaExceptions.append("Hatavat Kfar Blum is not primium " + "/n");
			
		}
		
		else
			
			//If a different page was opened and not Kfar Blum
			throw new Exception("Hatavut Page was not loaded");
	}
	
	
	
	
	/**
	 * Click on לאתר בית העסק from Hatava and verify the correct website is opening
	 * @throws Exception
	 */
	public void checkWebsite() throws Exception {
		
		//To handle the new window
		String originalHandle = driver.getWindowHandle();	
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1000);
			wait.until(ExpectedConditions.elementToBeClickable(this.webSiteLink));
			
			//open link in a new tab
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
			webSiteLink.sendKeys(selectLinkOpeninNewTab);
			
			
			//switch to the new tab that opened
			for (String windowHandle : driver.getWindowHandles()) {
				
				driver.switchTo().window(windowHandle);
				
				if (driver.getTitle().equals(webSiteLink))
					break;
				
		}
			//Check if the correct page is open
			if (driver.getTitle().equals("קיאקים בנהר הירדן - קייקי כפר בלום")) {
				
				System.out.println("Correct websitewas opened");
				
				//Close the new tab
				driver.close();
				
			}
				
			else {

				//Close the new tab
				driver.close();	
				
				//Add to SB the message 
				kfarBlumHatavaExceptions.append("Incorrect webSite of Hatavat kfar Blum was opened " + "/n");
			}
					
			
		}finally {
			
			//return to original tab
			driver.switchTo().window(originalHandle);
		}
	}

	
	
	/**
	 * Click on HEMSHECKRIAA from hatava and Tnaiim VeHagbalut
	 */
	public void clickOnContinueRiding() {
		
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOf(hemshechKriaaLink));
		
		driver.findElement(By.className("benefit-page"));
		
		//Click on המשך קריאה
		hemshechKriaaLink.click();
		
		//Verify the link סגירה is appear
		wait.until(ExpectedConditions.visibilityOf(sgiraLink));
		
		//Click on סגירה
		sgiraLink.click();
		
		wait.until(ExpectedConditions.visibilityOf(tnaimVeHagbalut));
		
		//Click on תנאים והגבלות
		tnaimVeHagbalut.click();
			
	}
	
	

	//Not In Use!!!
	/**
	 * click on Horadat Hatava
	 */
	public void horadatHatava() {
		
		driver.findElement(By.className("benefit-page")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOf(horadatHatava));
		
		new Actions(driver).moveToElement(horadatHatava).perform();
		
		horadatHatava.click();
		
	}
}
