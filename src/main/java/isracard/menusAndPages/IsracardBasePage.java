package isracard.menusAndPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.String;



public abstract class IsracardBasePage {
	
	protected WebDriver driver;
	
	private StringBuilder pagesNotFound = new StringBuilder();
	
	@FindBy (xpath = "//*[@class='container']//*[text()='החשבון שלי']")
	private WebElement dashboardLinkMeovtah;
	
	@FindBy (partialLinkText = "מעבר לחשבון שלי")
	private WebElement dashboardLinkHatavot;
	
	@FindBy (linkText = "פירוט חיובים ועסקאות")
	private WebElement perutHiuvimLink;
	
	@FindBy (xpath = "//*[@class='container']//*[text()='הטבות']")
	private WebElement hatavotHeaderLink;
	
	@FindBy (xpath = "//*[@class='site-footer__nav-item col-sm-4'][5]//li")
	private List<WebElement> allHatavotLinks;
	
	@FindBy (linkText = "עדכון סיסמא")
	private WebElement idkunSismaLink;
	
	@FindBy (xpath = "//*[@class='panel-heading level2expanded']")
	private WebElement hacheshbunSheli;
	
	@FindBy (linkText = "פעולות בחשבון")
	private WebElement peolut;
	
	
	/**
	 * c-tor with WebDriver and pageFactory
	 * @param driver
	 */
	public IsracardBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	
	
/*---          Here all GOTO Methods           ---*/
	
	//NOT IN USED
	/**
	 * Goto Dashboard from Hatavot Web
	 * @return DashboardPage
	 */
	public DashboardPage gotoDashboardFromHatavot() {
		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
		wait.until(ExpectedConditions.visibilityOf(dashboardLinkHatavot));
		
		dashboardLinkHatavot.click();
		
		return new DashboardPage(driver);
	}
	
	
	
	/**
	 *Goto Dashboard from EzorIshi
	 * @return DashboardPage
	 */
	public DashboardPage gotoDashboardFromEzorIshi() {
		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
		wait.until(ExpectedConditions.visibilityOf(dashboardLinkMeovtah));
		
		dashboardLinkMeovtah.click();
		
		return new DashboardPage(driver);
	}
	
	
	
	/**
	 * Goto perutHiuvim Page
	 * @return new PerutHiuvim Page
	 */
	public PerutHiuvimPage gotoPerutHiuvimPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
		wait.until(ExpectedConditions.visibilityOf(dashboardLinkMeovtah));
		
		new Actions(driver).moveToElement(dashboardLinkMeovtah).perform();
		
		wait.until(ExpectedConditions.visibilityOf(perutHiuvimLink));
		
		perutHiuvimLink.click();
		
		return new PerutHiuvimPage(driver);
	}
	
	
	
	/**
	 * Goto IdkunSisma Page from top menu
	 * @return new IdkunSisma Page
	 * not in use
	 */
	public IdkunSismaPage gotoIdkunSismaPageFromTop()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
		wait.until(ExpectedConditions.visibilityOf(dashboardLinkMeovtah));
		
		new Actions(driver).moveToElement(dashboardLinkMeovtah).perform();
		wait.until(ExpectedConditions.visibilityOf(idkunSismaLink));
		
		idkunSismaLink.click();
		
		return new IdkunSismaPage(driver);
	}
	
	
	
	/**
	 * Goto IdkunSisma Page from side menu
	 * @return new IdkunSisma Page
	 */
	public IdkunSismaPage gotoIdkunSismaPageFromSideMenu()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
		wait.until(ExpectedConditions.visibilityOf(dashboardLinkMeovtah));
		
		new Actions(driver).moveToElement(peolut).perform();
		peolut.click();
		
		wait.until(ExpectedConditions.visibilityOf(idkunSismaLink));
		idkunSismaLink.click();
		
		return new IdkunSismaPage(driver);
	}
	
	
	
	/**
	 * Goto Hatavut page from Isracard website
	 * @param driver
	 * @return
	 */
	public HatavotPage gotoHatavotPage (WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
		wait.until(ExpectedConditions.visibilityOf(hatavotHeaderLink));
		
		hatavotHeaderLink.click();
		
		return new HatavotPage(driver);
	}
	
	
	
/*---         Till here all GOTO Methods            ---*/


	
	
	
	
	
/*---   Here all Hatavot links treatment Methods    ---*/	
	
	
	
	/**Main function to click on all links in webElements list of Hatavot categories in footer
	 * @throws Exception 
	 * @throws Throwable 
	 * 
	 */
	public void clickOnHatavotLinksOnFooter() throws Exception  {
		
		if (allHatavotLinks.isEmpty() == true)
			throw new Exception("Links of Hatavut in footer were not found");
		
		
		//Run in loop on all Hatavot categories in footer
		for (int i=0 ; i < allHatavotLinks.size() ; i++) {

			//Wait till Hatavot link in footer loaded 
			WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
			wait.until(ExpectedConditions.visibilityOf(allHatavotLinks.get(i)));
			
			//Print which 
			System.out.println("Try to open: " + allHatavotLinks.get(i).getText());

					
			//Handle the click and switch window
			openAndVerify(allHatavotLinks.get(i), i);
	
		}
		
		//Check if there are page with incorrect link/ error 
		if(pagesNotFound.length() > 0)

			//Throw exception with the pages that not found
			throw new Exception("The pages above were not found: " + pagesNotFound.toString());
	}
	

	
	
	
	/**
	 * Open new link from footer under Hatavot categories and verify the correct one was open
	 * @param link- which link to click
	 * @param i- index helper
	 * @throws Exception 
	 */
	public void openAndVerify(WebElement link, int i) throws Exception {
		
		//To handle the new window
		String originalHandle = driver.getWindowHandle();	
		
		//Save the link name we clicked on- I use it in next steps
		String linkName = link.getText();
		
		
		try {
			
			//open link in a new tab
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
			driver.findElement(By.linkText(linkName)).sendKeys(selectLinkOpeninNewTab);
			
			
			//switch to the new tab that opened
			for (String windowHandle : driver.getWindowHandles()) {
				
				driver.switchTo().window(windowHandle);
				
				if (driver.getTitle().equals(linkName))
					break;
		}
			
		
			//When expected to different page, add the name page to the helper SB
			//SB- will be used in the throw exception
			if (verifyCorrectLink(i) == false) {
	
				pagesNotFound.append(linkName);
				pagesNotFound.append(" , ");
			}
			
			
			//Close the new tab
			driver.close();	
			
		}finally {
			
			//return to original tab
			driver.switchTo().window(originalHandle);
		}
	}
	
	
	
	/**
	 * Get the number of link from Hatavot footer
	 * @param i
	 * @return True if the correct page is open
	 */
	public boolean verifyCorrectLink(int i)
	{
		switch (i) {
		case 0: return HorimVeYeladimPage.isOnPage(driver);
			
		case 1: return OchelVeNishnushimPage.isOnPage(driver);		 
		
		case 2: return TarbutVePnaiPage.isOnPage(driver);
		
		case 3: return OfanaimVeAvizarimPage.isOnPage(driver);
		
		case 4: return HufshotVeTiulimPage.isOnPage(driver);
		
		case 5 : return AtraktziutPage.isOnPage(driver);
		
		case 6: return HatavutPrimiumPage.isOnPage(driver);
		
		case 7: return MaslulTeofaPage.isOnPage(driver);
		
		case 8: return OdHaftaotPage.isOnPage(driver);
		
		case 9: return ItzovOmutzarimPage.isOnPage(driver);
		}
		return false;
	}
	
	
/*---   Till here all Hatavot links treatment Methods    ---*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void goToDashboardPage(WebDriver driver) {
//		
//		if (driver.getCurrentUrl().startsWith("https://digital.isracard.co.il/personalarea")) 
//			this.gotoDashboardFromEzorIshi();
//		else if (driver.getCurrentUrl().startsWith("https://benefits.isracard.co.il/"))
//			this.gotoDashboardFromHatavot();
//	}
	
//	public HatavotPage gotoHatavotPage (WebDriver driver) {
//		this.switchFrame(driver);
//		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
//		wait.until(ExpectedConditions.visibilityOf(hatavotHeaderLink));
//		hatavotHeaderLink.click();
//		return new HatavotPage(driver);
//	}
//	
//	public void switchFrame (WebDriver driver) {
//		WebElement topFooterFrame = driver.findElement(By.cssSelector(".Digital_Header"));
//		driver.switchTo().frame(topFooterFrame);
//		
//	}
//	public HatavotPage goToHatavotPage()	{
//		hatavotHeaderLink.click();
//		return new HatavotPage(driver);
//	}

}
		
