package com.Isracard.Final;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.CharMatcher;

public class CreditDetailsPage extends DigitalBasePage {
    
	/**
	 * constructor of the CreditDetailsPage
	 * @param driver
	 */
	public CreditDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * page factory elements 
	 */
	@FindBy(xpath="//*[@class='ui-select-custom']//*[contains(text(),'כל הכרטיסים')]") //Xpath=//label[starts-with(@id,'message')]
	private WebElement upperFilterPannel;
	
	@FindBy(xpath="//*[@class='card-box__collapse-btn']//*[starts-with(text(),'מועד חיוב')]")
	private WebElement presentedDateField;
	
	/**
	 * method that performs the test(extracts the date line from the page and compares to the current date)
	 */
	public void filterByCurrentPayment() {
	 WebDriverWait wait = new WebDriverWait(driver, 40);
     wait.until(ExpectedConditions.elementToBeClickable(upperFilterPannel));
     WebElement filterField = driver.findElement(By.xpath("//*[@class='ui-select-custom']//*[contains(text(),'בחירת חודש')]"));
	 new Actions(driver).moveToElement(filterField).click().perform();
	 WebElement prevPay = driver.findElement(By.linkText("מועד קרוב"));
	 prevPay.click();
	//Find the fild that holds the date	
  //  WebDriverWait wait = new WebDriverWait(driver, 40);
    wait.until(ExpectedConditions.elementToBeClickable(presentedDateField));
	//Extracts the digits from the text
    String dateStamp = presentedDateField.getText();
    @SuppressWarnings("deprecation")
	String output = (CharMatcher.DIGIT).retainFrom(dateStamp);
    //Extract the months digits from the date string 
    String monthsDate = output.substring(2, 4); 
    //Ask for the current date in "mm" format 
    DateTimeFormatter dateMonth = DateTimeFormatter.ofPattern("MM");  
	LocalDateTime nowDateMonth = LocalDateTime.now();  
	//take the current day day 
	DateFormat dateFormat = new SimpleDateFormat("dd");
	 Date date = new Date();
	 //convert it to integer
	 int dateDay= Integer.parseInt(dateFormat.format(date));
	 //if the day between 10 to 31 do a manipulation to add 1 to compare the dates
	if(dateDay<=31 && dateDay>=10) {
		int currentDateMonth = Integer.parseInt(dateMonth.format(nowDateMonth));
		int currentDateMonthPlusOne = currentDateMonth +1;
		DecimalFormat df = new DecimalFormat("00"); 
	    String addDecimalToCurrentMonthMinusOne = df.format(currentDateMonthPlusOne); // 07
	  //Compare the dates - the extracted one to the current manipulated one 
	    Assertions.assertEquals(addDecimalToCurrentMonthMinusOne, monthsDate);
	}
	else {
		//Compare the dates - the extracted one to the current one - not manipulated
		Assertions.assertEquals(dateMonth.format(nowDateMonth), monthsDate);
	}
	}
	
	/**
	 * method that performs the test (by setting the filter to change the display-> extract the text line and
	 * compare it the the expected month by taking care of the edge cases)
	 */
	public void filterByPreviousPayment() {
		//wait until the element appears to hover and click on it 
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(upperFilterPannel));
		WebElement filterField2 = driver.findElement(By.xpath("//*[@class='ui-select-custom']//*[contains(text(),'מועד קרוב')]"));
	    new Actions(driver).moveToElement(filterField2).click().perform();
	    //in the drop-down menu choose the previous payment 
	    WebElement prevPay = driver.findElement(By.linkText("מועד קודם"));
	    prevPay.click();
	    //wait until the date element appears and extract the text
	    wait.until(ExpectedConditions.elementToBeClickable(presentedDateField));
	    String dateStamp = presentedDateField.getText();
	    //extract only digits from the text
	    @SuppressWarnings("deprecation")
		String output = (CharMatcher.DIGIT).retainFrom(dateStamp);
	    //trim the "mm" position 
	    String monthsDate = output.substring(2, 4); 
	//    System.out.println(monthsDate); 
	    //Get the current date in "mm" format
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");  
		LocalDateTime now = LocalDateTime.now();  
		//convert to integers
		int currentDateMonth = Integer.parseInt(dtf.format(now));
	   // int currentDateMonth = 5; (comment three previous lines of code to test the months changes manually)
		DateFormat dateFormat = new SimpleDateFormat("dd");
		 Date date = new Date();
		 //convert it to integer
		 int dateDay= Integer.parseInt(dateFormat.format(date));
		 //if the day between 10 to 31 do a no manipulations needed 
		if(dateDay<=31 && dateDay>=10) {
			Assertions.assertEquals(dtf.format(now), monthsDate);
		}
		//else - performs the month manipulations according to the number of the month
		else {
		//checking the number of the month to threat the edge cases (in case the month between 1 to 11 )
	    if(currentDateMonth <11  && currentDateMonth > 1 ) {
	    	int currentMonthMinusOne = currentDateMonth-1;
	     	DecimalFormat df = new DecimalFormat("00"); 
		    String addDecimalToCurrentMonthMinusOne = df.format(currentMonthMinusOne); // 07
		   // System.out.println(addDecimalToCurrentMonthMinusOne);
		    Assertions.assertEquals(addDecimalToCurrentMonthMinusOne,monthsDate);
		}
	    //in case the month equals to 1
		else if(currentDateMonth == 1) {
			int theExpectedMonth = 12;
			Assertions.assertEquals(String.valueOf(theExpectedMonth), monthsDate);
		}
	    //in other cases - the month 11&12
		else{
			Assertions.assertEquals(String.valueOf(currentDateMonth-1), monthsDate);
		}
		}
		
	}
     

	/**
	 * method that performs the test (by setting the filter to change the display-> extract the text line and
	 * compare it the the expected month)
	 */
	public void filterByChosenDate() {
		//wait for the element and click to open the tropdown box
		WebDriverWait wait = new WebDriverWait(driver, 40);
		//wait.until(ExpectedConditions.elementToBeClickable(filterField));
	//	wait.until(ExpectedConditions.elementToBeClickable(upperFilterPannel));
		WebElement filterField3 = driver.findElement(By.xpath("//*[@class='ui-select-custom']//*[contains(text(),'מועד קודם')]"));
	    new Actions(driver).moveToElement(filterField3).click().perform();
	    //select the expected filter (by specific date)
	    WebElement prevPay = driver.findElement(By.linkText("בחירת חודש"));
	    prevPay.click();
	    //a new category opened, go and click on it to open a new window of the calendar
	    WebElement calendar = driver.findElement(By.cssSelector("div[class='datepicker-holder ng-scope']"));
	    calendar.click();
	    //forward the driver to the calendar and go 100, 100 pixels to choose the months 
	    WebElement calendarWindow = driver.findElement(By.cssSelector("ul[class='dropdown-menu ng-pristine ng-untouched ng-valid ng-scope ng-valid-date-disabled']"));
	    new Actions(driver).moveToElement(calendarWindow).perform();
	    Actions action = new Actions(driver);
	    action.moveByOffset(100, 100).click().perform(); //October
	    //wait until the element appears and extract the text
	    wait.until(ExpectedConditions.elementToBeClickable(presentedDateField));
	    String dateStamp = presentedDateField.getText();
	    //extract only digits from the text
	    @SuppressWarnings("deprecation")
		String output = (CharMatcher.DIGIT).retainFrom(dateStamp);
	    //trim the "mm" position 
	    String monthsDate = output.substring(2, 4); 
	    Assertions.assertEquals(String.valueOf("10"), monthsDate);
	    
	}
     
}
     
     
//  new Actions(driver).moveToElement(((WebElement)By.xpath("*//[@class='input-group']")).click().perform());

	

