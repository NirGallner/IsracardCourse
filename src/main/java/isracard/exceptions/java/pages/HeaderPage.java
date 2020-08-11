package isracard.exceptions.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage{

	private WebDriver driver;

	@FindBy(xpath = "//*[@id=\"Digital_Header\"]/header/nav/div/ul/li[4]/a")
	private WebElement hatavotTab;

	public HeaderPage(WebDriver driver) {
		super(driver);

		// this method will create all webelements
		PageFactory.initElements(driver, this);
	}
		
	public void clickOnHatavotTab() {
		hatavotTab.click();
	}
//	// click on attractions tab
//	@FindBy(linkText = "אטרקציות")
//	private WebElement attractions;
//
//	// click on 1+1 kayak
//	@FindBy(xpath = "/html/body/main/div[2]/div[2]/button[12]/div/div[2]/div[1]/div[1]")
//	private WebElement kayak;
//
//	// go to kayak site
//	@FindBy(xpath = "/html/body/main/div[2]/div[2]/div[1]/div[2]/span[2]/a")
//	private WebElement goToKayakSite;
//
//	// check if is it kayak site
//	@FindBy(linkText = "מחירון")
//	private WebElement checkIfIsKayakSite;
//
//	// click on TOU
//	@FindBy(className = "conditions-btn collapsed")
//	private WebElement TOU;
//
//	// Download Button
//	@FindBy(className = "btn btn-blue btn-fixed-mobile")
//	private WebElement downloadButton;
//
//	// my hatavot
//	@FindBy(className = "leftHeaderItemMyBenefit")
//	private WebElement myHatavot;
//
//	// insert ID field
//	@FindBy(xpath = "//*[@id=\"IdNumber\"]")
//	private WebElement idFieldHatavot;
//
//	// PW
//	@FindBy(xpath = "//*[@id=\"CardNumberSuffix\"]")
//	private WebElement sixCardNumber;
//
//	// Continue button
//	@FindBy(className = "logInSubmit btn events-btn m-t")
//	private WebElement continueButton;

//	
//
//	// tap on hatavot tab
//	public void clickOnHatavotTab() {
//		hatavotTab.click();
//	}
//
//	// find if this is the page
//	public String checkIfIsPage() {
//		return attractions.getText();
//
//	}
//
//	public void hatavotCheck() {
//
//		this.clickOnHatavotTab();
//		this.checkIfIsPage();
//
//	}
}
