package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * represents {@link PerutHiuvimPage}
 * @author liraz
 *
 */
public class PerutHiuvimPage extends IsracardBasePage{
	

	@FindBy (xpath = "//*[@class='nonprint-landscape-a4']//*[@title='כל המועדים']")
	private WebElement sanunMoaadim;
	
	@FindBy (id = "ui-select-choices-row-3-0")
	private WebElement moedKarov;
	
	@FindBy (id = "ui-select-choices-row-3-1")
	private WebElement moedKodem;
	
	@FindBy (id = "ui-select-choices-row-3-2")
	private WebElement hodeshHiuv;
	
	@FindBy (linkText = "פירוט חיובים ועסקאות")
	private WebElement pageName;

	
	/**
	 * Constructor with webdriver and pageFactory
	 * @param driver
	 */
	public PerutHiuvimPage(WebDriver driver) {
		super(driver);
	}
	
	
	/**
	 * Verify we are in PerutHiuvim page
	 * @param driver
	 * @return
	 */
	public static boolean isInPerutHiuvimPage(WebDriver driver) {
		return driver.getTitle().contains("פירוט חיובים ועסקאות");
	}

	
	
	/**
	 * local method to open the SanunMoadim
	 */
	private void openAndClickOnSanunMoaadim() {
		
		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
		wait.until(ExpectedConditions.visibilityOf(sanunMoaadim));
		
		//Click on Sunan Moaadim 
		sanunMoaadim.click();
		
		//Wait till Moed Karov appears
		wait.until(ExpectedConditions.visibilityOf(moedKarov));
	}
	
	
	
	/**
	 * Get the moed and click on correct element
	 * @param moed
	 * @throws Throwable 
	 */
	public void clickOnMoedAndVeify(String moed) throws Throwable {
		
		//Open Sanun Moaddim
		openAndClickOnSanunMoaadim();
		
		
		// The next if else used to check which moed was selected
		if(moed.equalsIgnoreCase(moedKarov.getText())) {
			try {
				
				//Click on Moed Karov
				moedKarov.click();
				
				} catch (Exception e) {
					throw new Exception("Can't click on: " + moedKarov.getText());
				}
		}
		else 
			if(moed.equalsIgnoreCase(moedKodem.getText())) {
				try {
					
					//Click on Moed Kodem
					moedKodem.click();
							
					
					} catch (Exception e) {
						throw new Exception("Can't click on: " + moedKodem.getText());
					}
			}
		
			else 
				if(moed.equalsIgnoreCase(hodeshHiuv.getText())) {
					try {
						
						//Click on Hodesh hiuv
						hodeshHiuv.click();
											
					
						} catch (Exception e) {
							throw new Exception("Can't click on: " + hodeshHiuv.getText());
							
						}
		}
	}

	/**
	 * return the page name
	 * @return
	 */
	public String getPageName() {
		
		return pageName.getText();
	}

}
	









//	public void clickOnMoedAndVeify() {
//		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
//		wait.until(ExpectedConditions.visibilityOf(sanunMoaadim));
//		sanunMoaadim.click();
//		wait.until(ExpectedConditions.visibilityOf(moedKarov));
//		//openAndClickOnSanunMoaadim();
//		
//		List<WebElement> allMoaadimInSanun;		
//		
//		//driver.findElement(By.className("transaction-details__filters-wrapper")).click();
//		
//		for( WebElement moed: allMoaadimInSanun) {
//			//System.out.println(allMoaadimInSanun.get(i).getText());
//			org.openqa.selenium.By.cssSelector(".ui-select-choices-group a");
//			//System.out.println(moed.get(i).getText());
//			System.out.println(moed.getText());
//			try {
//				
//			//	allMoaadimInSanun.get(i).click();
//				moed.click();
//			//	openAndClickOnSanunMoaadim();
//				
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			finally {
//				wait.until(ExpectedConditions.visibilityOf(sanunMoaadim));
//				sanunMoaadim.click();
//				wait.until(ExpectedConditions.visibilityOf(moedKarov));
//				//allMoaadimInSanun =  driver.findElements(By.cssSelector(".ui-select-choices-group a"));
//			}
//		}
//		try {
//			openAndClickOnSanunMoaadim();
//			wait.until(ExpectedConditions.visibilityOf(moedKarov));
//			moedKarov.click();
//			//wait.until(ExpectedConditions.visibilityOf(bodyTitle));
//			
//			System.out.println(driver.findElement(By.className("transaction-details__total-info-title")).getText());
//			
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			try {
//				openAndClickOnSanunMoaadim();
//				wait.until(ExpectedConditions.visibilityOf(moedKarov));
//				moedKodem.click();
//				//wait.until(ExpectedConditions.visibilityOf(bodyTitle));
//				
//				System.out.println(driver.findElement(By.className("transaction-details__total-info-title")).getText());
//				
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//	
//	
//			try {
//				openAndClickOnSanunMoaadim();
//				wait.until(ExpectedConditions.visibilityOf(moedKarov));
//				hodeshHiuv.click();
//				//wait.until(ExpectedConditions.visibilityOf(bodyTitle));
//				
//				System.out.println(driver.findElement(By.className("transaction-details__total-info-title")).getText());
//				
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			
