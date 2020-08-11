package isracard.exceptions.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCardsPage extends BasePage {
	// my cards link
	@FindBy(className = "level3Simple")
	private WebElement myCardsLink;

	// perut iskaot link
	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/a[3]")
	private WebElement perutIskaot;

	// date picker
	@FindBy(className = "form-control ng-pristine ng-isolate-scope ng-valid-date ng-valid-required ng-invalid ng-invalid-required ng-touched")
	private WebElement datePicker;

	// pick month earlier from date picker
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-3-1\"]/a/div")
	private WebElement monthEarlier;

	// drop moed hiyuv
	@FindBy(xpath = "//*[@id=\"wholePageExport\"]/div[5]/div/div/div/div[1]/div[2]/div[4]/div/div/div/span")
	private WebElement dropMoed;

	// chose this month
	@FindBy(xpath = "//*[@id=\"ui-select-choices-row-3-0\"]/a/div")
	private WebElement thisMonth;

	// chose earlier month
	@FindBy(className = "ng-binding ng-scope")
	private WebElement earlierMonth;
	
	//get string from pre month page
	@FindBy(xpath = "//*[@id=\"wholePageExport\"]/div[5]/div/div/div/div[1]/div[3]/div[1]/p[2]")
	private WebElement title;
	
	//get string from this month page
		@FindBy(xpath = "//*[@id=\"wholePageExport\"]/div[5]/div/div/div/div[1]/div[3]/div[1]/p[1]")
		private WebElement titleThisMonth;
		
	//open chose months 
		@FindBy(xpath = "//*[@id=\"ui-select-choices-row-3-2\"]/a/div")
		private WebElement monthsList;
		
	//tap on calendar icon 	
		@FindBy(xpath = "//*[@id=\"wholePageExport\"]/div[5]/div/div/div/div[1]/div[2]/div[5]/div/span/button/i")
		private WebElement openCalendar;
		
	//chose month (April)	
		@FindBy(xpath = "//*[@id=\"datepicker-1398-4155-3\"]/button/span")
		private WebElement selectMonth;
	
		//April Text title
		@FindBy(xpath = "//*[@id=\"wholePageExport\"]/div[5]/div/div/div/div[1]/div[3]/div[1]/p[3]")
		private WebElement titleAprilMonth;
		
		
		
	public MyCardsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickPerutIskaot() {
		perutIskaot.click();
	}

	public void selectPrevMonth() {
		dropMoed.click();
		monthEarlier.click();
	}

	public String getTitleText() {
		return title.getText();
	}
	
	public void selectNextMonth() {
		dropMoed.click();
		thisMonth.click();
	}
	
	public String getTitleTextThisMonth() {
		return titleThisMonth.getText();
	}
	
	public void selectMonthFromPicker() {
		dropMoed.click();
		monthsList.click();
		openCalendar.click();
		selectMonth.click();
	}
	
	public String getTitleChosenCalendarMonth() {
		return titleAprilMonth.getText();
	}
	
}