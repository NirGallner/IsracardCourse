package selenium.course;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class BenefitsPage extends BasePage{
	
	private WebDriver driver;

	public BenefitsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	Actions actions = new Actions(driver);
	
	@FindBy(className="container-fluid footer-container")
	private WebElement footer;
	
	@FindBy(linkText= "https://benefits.isracard.co.il/parentcategories/parents/")
	private WebElement kidsAndParents;
	
	@FindBy(linkText= "https://benefits.isracard.co.il/parentcategories/food/")
	private WebElement food;

	@FindBy(linkText= "https://benefits.isracard.co.il/parentcategories/art/")
	private WebElement fun;
	
	@FindBy(linkText= "https://benefits.isracard.co.il/parentcategories/fashion/")
	private WebElement fashion;
	
	@FindBy(linkText= "https://benefits.isracard.co.il/parentcategories/israel-vacation/")
	private WebElement vacations;
	
	@FindBy(linkText= "https://benefits.isracard.co.il/parentcategories/attractions/")
	private WebElement attractions;
	
	@FindBy(linkText= "https://benefits.isracard.co.il/parentcategories/attractions/")
	private WebElement premium;
	
	@FindBy(linkText= "https://benefits.isracard.co.il/dashboard/aviationpagetype/")
	private WebElement aviation;
	
	@FindBy(linkText= "https://benefits.isracard.co.il/parentcategories/surprise/")
	private WebElement moreSurprises;
	
	@FindBy(linkText= "https://benefits.isracard.co.il/parentcategories/home/")
	private WebElement home;
	
	public void scrollToFooter() {
		actions.moveToElement(footer);
	}
	
	public WebElement getKidsAndParents() {
		return kidsAndParents;
	}
	
	public WebElement getFood() {
		return food;
	}
	
	public WebElement getFun() {
		return fun;
	}
	
	public WebElement getFashion() {
		return fashion;
	}
	
	public WebElement getVacations() {
		return vacations;
	}
	
	public WebElement getAttractions() {
		return attractions;
	}
	
	public WebElement getPremium() {
		return premium;
	}
	
	public WebElement getAviation() {
		return aviation;
	}
	
	public WebElement getMoreSurprises() {
		return moreSurprises;
	}
	
	public WebElement getHome() {
		return home;
	}
}
