package isracard;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents a tag page
 * 
 * @author Nir Gallner
 *
 */
public class TagPage extends BaseWpPage{

	@FindBy(id = "tag-name")
	private WebElement tagName;

	@FindBy(id = "tag-slug")
	private WebElement tagSlug;

	@FindBy(id = "tag-description")
	private WebElement tagDesciption;

	@FindBy(id = "submit")
	private WebElement addNewTagBtn;

	@FindBy(xpath = "//*[@id='posts-filter']//table//strong")
	private List<WebElement> tagsList;

	/**
	 * c-tor with WebDriver
	 * 
	 * @param driver
	 */
	public TagPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * submit new tag
	 */
	public void submit() {
		this.addNewTagBtn.click();
	}

	
	/**
	 * Inserts a tag name to the field
	 * @param name the name to insert to the field
	 * @return this object ({@link TagPage})
	 */
	public TagPage withName(String name) {
		WebDriverWait wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.elementToBeClickable(tagName));
		
		tagName.sendKeys(name);
		return this;
	}

	/**
	 * add tag slud
	 * @param slug tag slug
	 * @return this object
	 */
	public TagPage withSlug(String slug) {
		
		WebDriverWait wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.elementToBeClickable(tagSlug));
		
		tagSlug.sendKeys(slug);
		return this;
	}
	
	/**
	 * Adds description
	 * @param description to be added
	 * @return this object
	 */
	public TagPage withDescription(String description) {
		
		WebDriverWait wait = new WebDriverWait(driver,10000);
		wait.until(ExpectedConditions.elementToBeClickable(tagDesciption));
		
		tagDesciption.sendKeys(description);
		return this;
	}

	
	/**
	 * Checks whether a title is actually on the list of titles
	 * @param tagTitle
	 * @return the index of the element, if found. -1 else
	 */
	public int isTagOnList(String tagTitle) {
		for (int i=0 ; i< tagsList.size(); i++) {
			if (tagsList.get(i).getText().contentEquals(tagTitle))
				return i;
		}
		
		// If we are here, the tag was not found by tag title
		return -1;
		
	}

	/**
	 * Deletes a tag by its name
	 * @param tagName name of the tag to be deleted
	 */
	public void deleteTag(String tagName) {
		WebElement forId = this.getTag(tagName);
		String id = forId.getAttribute("for");
		driver.findElement(By.id(id)).click();

		Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
		select.selectByVisibleText("Delete");

		// Apply
		driver.findElement(By.id("doaction")).click();
	}

	/**
	 * Delete a tag by it's index on the table. 
	 * @param tagIndex index to be deleted
	 */
	public void deleteTag(int tagIndex) {
		
		WebElement forId = this.getTag(tagIndex);
		String id = forId.getAttribute("for");
		driver.findElement(By.id(id)).click();

		Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
		select.selectByVisibleText("Delete");

		// Apply
		driver.findElement(By.id("doaction")).click();
	}
	
	
	/**
	 * Get a tag from the list, using tag name 
	 * @param tagName the name of the tag to return
	 * @return a {@link WebElement} representing the tag
	 * @throws {@link NoSuchElementException} if element was not found
	 */
	public WebElement getTag(String tagName) {
		
		int tagIndex = isTagOnList(tagName);
		
		if (tagIndex < 0)
			throw new NoSuchElementException("The element with tag name: " + tagIndex + " was not found");
		else
			return this.tagsList.get(tagIndex);
	}
	
	/**
	 * Get a tag from the list, using tag index
	 * @param index the index of the tag to return
	 * @return a {@link WebElement} object representing the tag
	 * @throws {@link NoSuchElementException} if wasn't found
	 */
	public WebElement getTag(int index) {
		if (index < 0 || index >= this.tagsList.size())
			throw new NoSuchElementException("The element with tag index: " + index + " was not found");
		else
			return this.tagsList.get(index);
	}
	
	public int getTagsListSize() {
		return tagsList.size();
	}
	
	

}
