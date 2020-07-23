package demo_site.poms;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagsPage {
	private WebDriver driver;
	/**
	 * looking for the elements every time we need it in the test by their locators
	 */
	@FindBy(xpath="//*[@id='adminmenu']//*[contains(text(),'Posts')]")
	private WebElement postLink;
	
	@FindBy(id="tag-name")
	private WebElement tagTitle;
	
	@FindBy(id="tag-slug")
	private WebElement slugCont;
	
	@FindBy(id="tag-description")
	private WebElement tagDescription;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	@FindBy(id="doaction")
	private WebElement doActionBtn;
	
	
	public TagsPage (WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	/**
	 * waits until the postLink is visible on the page and hover above it
	 * @return TagsPage to enable the chaining actions
	 */
	public TagsPage hoverAbovePosts() {
    WebDriverWait wait = new WebDriverWait(driver, 50);
  	wait.until(ExpectedConditions.visibilityOf(postLink));
		new Actions(driver).moveToElement(postLink).perform();
		return this;
	}
	/**
	 * Inserting the tag title in the tag title field
	 * @param myTagTitle
	 * @return tagPage to enable the chaining actions
	 */
	public TagsPage insertTagTitle(String myTagTitle) {
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
		submitBtn.click();
	}

	public void deleteTheTag () {
	Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
	select.deselectByVisibleText("Delete");
	doActionBtn.click();
	}
	
	

}
