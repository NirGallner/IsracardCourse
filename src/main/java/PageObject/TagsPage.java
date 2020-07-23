package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TagsPage {
	
	public static WebDriver driver;
	
	@FindBy (id="tag-name")
	private WebElement tagNameInput;
	
	@FindBy (id="tag-slug")
	private WebElement tagSlugInput;
	
	@FindBy (id="tag-description")
	private WebElement tagDescriptionInput;
	
	@FindBy (id="submit")
	private WebElement tagSubmitBtn;
	
	public TagsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static boolean isOnPageTags(WebDriver driver, String title) {
		System.out.println(title);
		return driver.getTitle().toLowerCase().contains(title.toLowerCase());
		}
	
	
	public TagsPage withTagName (String tagName) {
		tagNameInput.sendKeys(tagName);
		return this;
	}
	
	public TagsPage withTagSlug (String tagSlug) {
		tagSlugInput.sendKeys(tagSlug);
		return this;
	}
	
	public TagsPage withTagDescription (String tagDescription) {
		tagSlugInput.sendKeys(tagDescription);
		return this;
	}
	
	public void submitTag() {
		tagSubmitBtn.click();
	}
	
}
