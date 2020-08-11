package com.Isracard.Final;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccessoriesAndFashionBenefitPage extends FooterHandler{
    /**
     * Constructor for the AccessoriesAndFashionBenefitPage
     * @param driver
     */
	public AccessoriesAndFashionBenefitPage(WebDriver driver) {
		super(driver);	
	}
	
    /**
     * Method that finds the element on the page and clicks on it to forward the user to the  
     * new page (will not open a new window in browser)
     */
	@Override
	protected void openWindow(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver ,30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("אופנה ואביזרים")));
		driver.findElement(By.linkText("אופנה ואביזרים")).click();	
	}

	/**
	 * Method that extracts the page title and compare it the expected one 
	 * if the assert will false - the method will throw an exception and the test  - otherwise 
	 * will fail, otherwise the test will pass
	 */
	@Override
	public void useWindow(WebDriver driver) {
		try {
//			WebElement pageH1 = driver.findElement(By.tagName("h1"));
//			System.out.println(pageH1.getText());
			Assertions.assertEquals("אופנה ואביזרים", driver.getTitle() ,"The title should be אופנה ואביזרים");
			}
			catch (NoSuchElementException notFound){
			throw new NoSuchElementException ("The extpected title was not found " + driver.getCurrentUrl());	
		} 
	
	}

}
