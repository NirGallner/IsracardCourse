package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagsPage {

	private WebDriver driver;

	@FindBy(id = "tag-name")
	private WebElement tagTitle;

	@FindBy(xpath = "id='tag-slug")
	private WebElement tagSlug;

	@FindBy(xpath = "'tag-description")
	private WebElement tagBody;

	@FindBy(id = "submit")
	private WebElement submitBtn;

	@FindBy(id = "tag-search-input")
	private WebElement search;

	@FindBy(id = "search-submit")
	private WebElement searchBtn;

	@FindBy (xpath = "(.//tbody)//tr//th//input")
	private WebElement myTag;


	// Methods:


	// Constructor:

	public TagsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Add new Tag

	public void addNewTag() {
		submitBtn.click();
	}

	// Add title

	public TagsPage addTitle(String tagTitle)
	{
		this.tagTitle.sendKeys(tagTitle);
		return this;
	}

	// Add slug

	public TagsPage addSlug(String tagSlug)
	{
		this.tagSlug.sendKeys(tagSlug);
		return this;
	}

	// Add boday

	public TagsPage addBody(String tagBody)
	{
		this.tagBody.sendKeys(tagBody);
		return this;
	}


	// Checks if we are on Tags page

	public static boolean isOnTagsPage(WebDriver driver) {
		return driver.getTitle().contains("Tags");
	}
}