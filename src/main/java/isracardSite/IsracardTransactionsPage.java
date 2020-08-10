package isracardSite;



import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsracardTransactionsPage extends IsracardBasePage {
	
	
	/**
	 * C-tor with WebDriver
	 * @param driver
	 */
	public IsracardTransactionsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@class=\"nonprint-landscape-a4\"]//div[@class=\"transaction-details__filters-wrapper\"]//div[@class=\"custom-select-box ng-scope\"][4]//div[@class=\"ui-select-custom\"]//div[@title=\"כל המועדים\"]")
	private WebElement selectDateBtn; 
	
	
	
	/**
	 * select all view options in transactions page -last/next month,select from calendar
	 * @param driver
	 */
	 public void selectdateToView(WebDriver driver) {
		 WebDriverWait wait = new WebDriverWait(driver,20,10);
		 wait.until(ExpectedConditions.visibilityOf(selectDateBtn));
		 selectDateBtn.click();
		 
		 //Get list from selectDateBtn
		 List<WebElement> dateFilterOptions = selectDateBtn.findElements(By.className("ui-select-choices-row-inner"));
		 
		 //Go over list and print
		 for(WebElement option:dateFilterOptions) {
			 String options = option.getText();
			 System.out.println(options);
		 }
		 
		//Go over list and select according to index - if one fail continue
		 dateFilterOptions.get(1).click();
		 try {
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='סה\"כ חיובים קודמים']")));
		 }
		 
		  catch(Exception e) {
				System.out.println("Error in" + "מועד קודם" + ":"  + e.getMessage());
			}
		 
		 
		 selectDateBtn.click();
		 dateFilterOptions = selectDateBtn.findElements(By.className("ui-select-choices-row-inner"));
		 dateFilterOptions.get(0).click();
		 try {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='סה\"כ לחיוב הבא']")));
		 }
		 catch(Exception e) {
				System.out.println("Error in" + "מועד קרוב" + ":"  + e.getMessage());
			}
		 
		 
		 selectDateBtn.click();
		 dateFilterOptions = selectDateBtn.findElements(By.className("ui-select-choices-row-inner"));
		 dateFilterOptions.get(2).click();
		 try {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/span/button/i[@class=\"glyphicon glyphicon-calendar\"][1]"))).click();
		 }
		 catch(Exception e) {
				System.out.println("Error in" + "בחירת חודש" + ":"  + e.getMessage());
			}
		 
		 

	 }

}
