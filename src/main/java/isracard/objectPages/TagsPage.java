package isracard.objectPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * represents tags page
 * @author liraz
 *
 */
public class TagsPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id='tag-name']")
	private WebElement tagTitle;
	
	@FindBy(xpath = "//*[@id='tag-slug']")
	private WebElement tagSlug;
	
	@FindBy(xpath = "//*[@id='tag-description']")
	private WebElement tagBody;
	
	@FindBy(id = "submit")
	private WebElement submitBtn;
	
	@FindBy(id = "tag-search-input")
	private WebElement search;
	
	@FindBy(id = "search-submit")
	private WebElement searchBtn;
	
	@FindBy (xpath = "(.//tbody)//tr//th//input")
	private WebElement myTag;
	

	
	//Page object Methods
	
	
	/**
	 * Constructor with webdriver and pageFactory
	 * @param driver
	 */
	public TagsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Create a new Tag
	 * 
	 */
	public void createNewTag() {
		submitBtn.click();
	}
	
	/**
	 * Insert tagTitle
	 * @param driver
	 * @return TagPage object
	 */
	public TagsPage insertTitle(String tagTitle)
	{
		this.tagTitle.sendKeys(tagTitle);
		return this;
	}
	
	/**
	 * Insert tagSlug
	 * @param tagSlug
	 * @return TagPage object
	 */
	public TagsPage insertSlug(String tagSlug)
	{
		this.tagSlug.sendKeys(tagSlug);
		return this;
	}
	
	/** 
	 * Insert tagBody
	 * @param tagBody
	 * @return TagPage object
	 */
	public TagsPage insertBody(String tagBody)
	{
		this.tagBody.sendKeys(tagBody);
		return this;
	}
	
	/**
	 * Verify we are in Tags page
	 * @param driver
	 */
	public static boolean isInTagsPage(WebDriver driver) {
		return driver.getTitle().contains("Tags");
	}
	
	/**
	 * Search MyTag
	 * @param title
	 */
	public void searchTag (String title) {
		WebDriverWait wait = new WebDriverWait(driver, 100, 3000);
		search.sendKeys(title);
		searchBtn.click();
		wait.until(ExpectedConditions.visibilityOf(myTag));
	}
	
	
}
