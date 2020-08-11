package IsracardProject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Represents a Charges Page
 * 
 * @author Eti Kedmi
 *
 */


public class ChargesPage extends BaseIsracardPage {
	
	

	@FindBy (xpath = "//*[@class=\"nonprint-landscape-a4\"]//*[@ng-show=\"dc.ShowBillingTypes\"]//*[@title=\"כל המועדים\"]" )
	private WebElement moedCombo;
	
	@FindBy (xpath = "p[@ng-show=\"dc.requiredDate=='K'\"]" )
	private WebElement previousCharge;
	
	@FindBy (xpath = "//p[@ng-show=\"dc.requiredDate=='H'\"]" )
	private WebElement nextCharge;
	
	@FindBy (xpath =  "//*[@id=\"ui-select-choices-row-3-2\"]/a")
	private WebElement monthLink;
	
	@FindBy (xpath = "//*[@class=\"nonprint-landscape-a4\"]//button[@class=\"btn btn-default\"]")
	private WebElement calenderButton;
	
	
	public ChargesPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}


	public void  isOnPageCharget(WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,20);

		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class=\\\"nonprint-landscape-a4\\\"]//*[@ng-show=\\\"dc.ShowBillingTypes\\\"]//*[@title=\\\"כל המועדים\\\"]"))));
		}catch (Exception e) {}

		assertTrue((driver.getTitle().contains("חיובים")),"No Details Charges page found");
	}
	
	
	
	/**
	 * open on the comboBox and click on the list
	 * 
	 */
	
	public void selectMoed() {
		
		// Wait for charging date comboBox
		WebDriverWait wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.visibilityOf (moedCombo));
		
		// Click on the comboBox
		moedCombo.click();
		
		String textMoed;
	
		// Go over on the List opens in the comboBox
		List <WebElement> allLink = moedCombo.findElements(By.xpath("ul[@class=\"ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu ng-scope\"]"));
		
		for (WebElement element:allLink) {
			
			
			// Wait for list
			WebDriverWait waitList = new WebDriverWait(driver, 9);
			waitList.until(ExpectedConditions.elementToBeClickable(element));
			//waitList.until(ExpectedConditions.visibilityOfAllElements(allLink));
			
			
			textMoed = element.getText();
				  
			// Click on the element in the list
			element.click();
			
			// call to function that check if the title match the selection from the list
			isTitle(textMoed);
			
		}
		
	}
	

		/*
		 * isTitle void function check if the title match the selection from the list
		 * 
		 * @param textMoed the name of element from the list 
		 * 
		 */
	
//To Do
	
		public void isTitle (String textMoed) {
			System.out.println(textMoed+" switch");
			switch (textMoed) {			
		
			case "בחירת חודש":
				
				assertTrue(nextCharge.getText().contains("הבא"), "The charges shown do'nt match the date selection");
				
				break;
				
			case "מועד קודם":
				
				assertTrue(previousCharge.getText().equals("קודם"),"The charges shown do'nt match the date selection");
				
				break;
				
			case "מועד קרוב":

				assertTrue(previousCharge.getText().contains("קרוב"),"The charges shown do'nt match the date selection");
				
				break;
			}	
         
		}
		
		
		/*
		 * select month from calender
		 *  
		 */		
		
		public void  selectMonth() {
			
			
			WebDriverWait wait = new WebDriverWait(driver,10000);
			wait.until(ExpectedConditions.visibilityOf (moedCombo));
			
			String textMonth;
			
			// Click on the moed comboBox
			moedCombo.click();
			
			// Wait for visible monthLink in the list
			wait.until(ExpectedConditions.visibilityOf (monthLink));
			
			// Click on the month choos from the  moed comboBox
			monthLink.click();
			
			// Wait for visible calenderButton
			wait.until(ExpectedConditions.visibilityOf (calenderButton));
			calenderButton.click();
			
//To Do
			List <WebElement> allmonth = calenderButton.findElements(By.xpath("//table[@aria-labelledby=\"datepicker-747-9889-title\"][@ng-switch-when=\"month\"]/tbody"));
			
			for (WebElement element:allmonth) {
				
				
				// Wait for list
		        WebDriverWait waitList = new WebDriverWait(driver, 3000);
				waitList.until(ExpectedConditions.visibilityOfAllElements(allmonth));
				
				System.out.println(element.getText());
				
				textMonth = element.getText();
			    
				// Click on the element in the list
				element.click();
				System.out.println(textMonth);
				
				
			}
		
		
		}

		
			
}

