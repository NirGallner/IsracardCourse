package isracard.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * represents Transaction list page
 */
public class Transactionlist extends BasePage {
	private WebDriver driver;
	
	//defining elements on page
	@FindBy(xpath="//*[@id=\"ui-select-choices-row-3-1\"]/a/div")
	private WebElement prvMonthbtn;

	@FindBy(xpath="//*[@id=\"ui-select-choices-row-3-0\"]/a/div")
	private WebElement nxtMonthbtn;

	@FindBy(xpath="//*[@id=\"wholePageExport\"]/div[5]/div/div/div/div[1]/div[2]/div[4]/div/div/input[1]")
	private WebElement pressPickerbtn;
	
	@FindBy(xpath="//*[@id=\"wholePageExport\"]/div[5]/div/div/div/div[1]/div[2]/div[5]/div/span")
	private WebElement datePickerbtn;
	
	@FindBy(xpath="//*[@id=\"datepicker-368-2213-2\"]/button/span")
	private WebElement monthPickerbtn;
	


/*
 * intilize elements
 */
	public Transactionlist(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	// filtering previous month
	public Transactionlist prvMonth() {
		prvMonthbtn.click();
		return new Transactionlist(driver);
	}
	
	//filtering next month 
	public Transactionlist nxtMonth() {
		nxtMonthbtn.click();
		return new Transactionlist(driver);
	}
	
	//opening the picker filtering element on page
	public Transactionlist PickerBtn() {
		pressPickerbtn.click();
		return new Transactionlist(driver);
	}
	
	// open the datePicker
	public Transactionlist datePicker() {
		datePickerbtn.click();
		return new Transactionlist(driver);
	}
	
	// Picking the month March on the date Table
	public Transactionlist monthPicker() {
		monthPickerbtn.click();
		return new Transactionlist(driver);
	}
	
	
	}
	
	/*
	 * using page flow
	 */
	
//	public  Transactionlist datepicker() {
//		
//		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
//		wait.until(ExpectedConditions.visibilityOf(pressPickerbtn));
//		pressPickerbtn.click();
//		wait.until(ExpectedConditions.visibilityOf(nxtMonthbtn));
//		nxtMonthbtn.click();
//		pressPickerbtn.click();
//		prvMonthbtn.click();
//		pressPickerbtn.click();
//		wait.until(ExpectedConditions.visibilityOf(monthPickerbtn));
//		return new Transactionlist(driver);
//		
//		
//	}

	




	

	