package demo_site.poms;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagsPage extends BasePage {
	
	/**
	 * looking for the elements every time we need it in the test by their locators
	 */
//	@FindBy(xpath="//*[@id='adminmenu']//*[contains(text(),'Posts')]")
//	private WebElement postLink;
	
	@FindBy(id="tag-name")
	private WebElement tagTitle;
	
	@FindBy(id="tag-slug")
	private WebElement slugCont;
	
	@FindBy(id="tag-description")
	private WebElement tagDescription;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	@FindBy (xpath ="//*[@id='posts-filter']//table//strong")
	private List<WebElement> tagsList;
	
//	@FindBy(id="doaction")
//	private WebElement doActionBtn;
//	
//	@FindBy(id="tag-search-input")
//	private WebElement searchField;
//	
//	@FindBy(id="search-submit")
//	private WebElement searchPerform;
	/**
	 * constructor with webdriver
	 * @param driver
	 */
	public TagsPage (WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
		}
	
//	/**
//	 * waits until the postLink is visible on the page and hover above it
//	 * @return TagsPage to enable the chaining actions
//	 */
//	public TagsPage hoverAbovePosts() {
//    WebDriverWait wait = new WebDriverWait(driver, 50);
//  	wait.until(ExpectedConditions.visibilityOf(postLink));
//		new Actions(driver).moveToElement(postLink).perform();
//		return this;
//	}
	/**
	 * Inserting the tag title in the tag title field
	 * @param myTagTitle
	 * @return tagPage to enable the chaining actions
	 */
	public TagsPage insertTagTitle(String myTagTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
	  	wait.until(ExpectedConditions.visibilityOf(tagTitle));
		tagTitle.sendKeys(myTagTitle);
		return this;
	}
	/**
	 * Inserting the tag content in the tag content field
	 * @param myTagCont
	 * @return tagPage to enable the chaining actions
	 */
	public TagsPage insertTagContent(String myTagCont) {
		slugCont.sendKeys(myTagCont);
		return this;
	}
	/**
	 * Inserting the tag description in the tag description field
	 * @param myTagDescr
	 * @return tagPage to enable the chaining actions
	 */
	public TagsPage insertTagDescription(String myTagDescr) {
		tagDescription.sendKeys(myTagDescr);
		return this;
	}
	/**
	 * Pressing the submit button to publish the tag-post
	 */
	public void tagSubmit () {
		this.submitBtn.click();
	}
	/**
	 * checks if my tag title appears in the list 
	 * @param myTagTitle
	 * @return -1 if not
	 */
	public int isTagOnList (String myTagTitle) {
		for (int i=0; i<tagsList.size(); i++) {
			if (tagsList.get(i).getText().contentEquals(myTagTitle))
				return i;
		}
		//if we got -1 , the tag did not found 
		return -1;
	}
	/**
	 * checks the size of the tagsLIst array
	 * @return the size (number of elements within the array)
	 */
	public int getTagsListSize() {
		return tagsList.size();
	}
	/**
	 * gets a tag from a list using the tag name
	 * @param myTagTitle - the name of the tag
	 * @return index of the tag (@link WebElement representing the tag)
	 */
	public WebElement getTag (String myTagTitle) {
		int tagIndex = isTagOnList(myTagTitle);
		
		if(tagIndex < 0 )
			throw new NoSuchElementException ("The Element with tag name: "+ tagIndex + "was not found");
		else
			return this.tagsList.get(tagIndex);
	}
	/**
	 * find our tag in the list and get its index 
	 * @param index (the place of the tag in the list)
	 * @return the index of the tag from the list
	 */
	public WebElement getTag (int index) {
		if (index < 0 || index >= this.tagsList.size()) {
			throw new NoSuchElementException("The Element with tag index: "+ index + "was not found");
		}else	
			return this.tagsList.get(index);		
	}
	
	/**
	 * deleting the tag by extracting the id from the table and select the action from the drop menu
	 * @param myTagTitle
	 */
	 public void deleteTag (int tagIndex) {
		 WebElement forID = this.getTag(tagIndex);
		 String id = forID.getAttribute("for");
		 driver.findElement(By.id(id)).click();

        Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
        select.selectByVisibleText("Delete");
        driver.findElement(By.id("doaction")).click(); 
	 }

//	public TagsPage searchTheTag (String myTagTitle) {
//		searchField.sendKeys(myTagTitle);
//		return this;
//	}
//	
//	public void searchSubmit() {
//		searchPerform.click();
//	}
//
//	public void deleteTheTag () {
//	Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
//	select.selectByVisibleText("Delete");
//	doActionBtn.click();
//	}
	
	

}
