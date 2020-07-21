package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TagsPage {
	
	private WebDriver driver;

	@FindBy(id = "tag-name")
	public WebElement tagName;
	
	@FindBy(id = "tag-slug")
	public WebElement tagSlug;
	
	@FindBy(id = "tag-description")
	public WebElement tagDescription;
	
	@FindBy(id = "submit")
	public WebElement addNewTagBtn;
	
	@FindBy (id = "tag-search-input")
	public WebElement searchBox;

	@FindBy (id = "search-submit")
	public WebElement searchBtn;
	
	@FindBy (id = "bulk-action-selector-top")
	public WebElement selectCategory;
	
	@FindBy (id = "doaction")
	public WebElement apply;
	
	
	/**
	 * c-tor with WebDriver. initiate
	 * @param driver
	 */
	public TagsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Verification
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("Tags"); 
	}
	
	/**
	 * sendkeys to tagName text box
	 * @param tagHeader
	 * @return
	 */
	
	public TagsPage tag_Name(String tagHeader) {
		this.tagName.sendKeys(tagHeader);
		return this;
	}
	
	/**
	 * sendkeys to tagslug text box
	 * @param slug
	 * @return
	 */
	public TagsPage tag_Slug(String slug) {
		this.tagSlug.sendKeys(slug);
		return this;
	}
	
	/**
	 * sendkeys to description text box
	 * @param description
	 * @return
	 */

	public TagsPage tag_description(String description) {
		this.tagDescription.sendKeys(description);
		return this;
	}
	
	/**
	 * Click add new tag
	 */
	
	public void addNew() {
		this.addNewTagBtn.click();
	}
	
	/**
	 * sendKeys to search tag text box
	 * @param tagHeader
	 * @return
	 */
	
	public TagsPage searchTag(String tagHeader) {
		this.searchBox.sendKeys(tagHeader);
		return this;
	}
	
	/**
	 * Click search tag
	 */
	 public void clickSearchBtn() {
		 this.searchBtn.click();
	 }
	 
	 /**
	  * Select from  actions list  - delete action
	  */
	 public void deleteTag() {
		 Select categoryFilter = new Select (this.selectCategory);
		 categoryFilter.selectByVisibleText("Delete");
	 }
	 
	 /**
	  * Click apply btn
	  */
	 public void clickApply() {
		 this.apply.click();
	 }
}

