package com.Isracard.Final;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class DigitalBasePage {
	
	protected WebDriver driver;
	
	/**
	 * constructor of the DigitalBasePage
	 * @param driver
	 */
	public DigitalBasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * page factory section to find the elements we are going to use in the tests 
	 */
//	@FindBy(linkText= "הורים וילדים")
//	private WebElement parentsandKidsLink;
//	
//	@FindBy(linkText= "אוכל ונשנושים")
//	private WebElement foodandSnacksLink;
//	
//	@FindBy(linkText= "תרבות ופנאי")
//	private WebElement funandCultureLink;
//	
//	@FindBy(linkText= "אופנה ואביזרים")
//	private WebElement accessoriesandFashionLink;
//	
//	@FindBy(linkText= "חופשות וטיולים")
//	private WebElement holidaysandTracksLink;
//	
//	@FindBy(linkText= "אטרקציות")
//	private WebElement attractiveActivitesLink;
//	
	@FindBy(linkText= "הטבות פרימיום")
	private WebElement premiumOffersLink;
//	
//	@FindBy(linkText= "מסלול תעופה")
//	private WebElement aviationRoutLink;
//	
//	@FindBy(partialLinkText= "הפתעות")
//	private WebElement surprisesLink;
//	
//	@FindBy(partialLinkText= "עיצוב ומוצרים")
//	private WebElement designforHomeLink;
//	
	@FindBy(className = "txt-btn-account-login")
	private WebElement logInButton;
//	
	/**
	 * method that takes the driver to the Hatavot page 
	 * @return new HatavotPage
	 */
	public HatavotPage gotoPremiumOffers() {
	    WebDriverWait wait = new WebDriverWait(driver ,30);
		wait.until(ExpectedConditions.visibilityOf(premiumOffersLink));
		premiumOffersLink.click();
		return new HatavotPage (driver);
	}
	
	/**
	 * method that takes the driver to the log in page 
	 * @return new IsracardLogInPage
	 */
	public IsracardLogInPage gotoLogInpage() {
		logInButton.click();
		return new IsracardLogInPage(driver);
	}
	
}
