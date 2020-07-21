package course.selenium.page.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagsPage extends BasePage{

	@FindBy(id = "tag-name")
	private WebElement tagName;

	@FindBy(id = "tag-description")
	private WebElement tagDescription;

	@FindBy(id = "tag-slug")
	private WebElement tagSlug;

	@FindBy(id = "submit")
	private WebElement submit;

	@FindBy(id= "doaction")
	private WebElement apply; 
	

	public TagsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public TagsPage insertTagName (String tagName) {
		this.tagName.sendKeys(tagName);
		return this;
	}

	public TagsPage insertTagDescription (String tagDescription) {
		this.tagDescription.sendKeys(tagDescription);
		return this;
	}

	public TagsPage submit(){
		submit.click();
		return this;
	}

	//get the list size 
	public int getListSize () {
		List<WebElement> tagsList = getListOfTags();
		return tagsList.size();
	}


	public List<WebElement> getListOfTags() {
		 List<WebElement> tagsList = driver.findElements(By.xpath ("//table//*[@class='row-title']"));
		 return tagsList;
	}
	

	//search a tag name in the list and return its index in the list
	public int searchTagInList(String tagName) {	
		List<WebElement> tagsList = getListOfTags();
		int indexOfNewTag = 0;

		//go over the list and search the new added tag
		for (WebElement tags : tagsList) { 
			if (tags.getText().contentEquals(tagName)) {
				indexOfNewTag = tagsList.indexOf(tags);				
				break;
			} 
			else  indexOfNewTag = -1;
			break;
		}	

		return indexOfNewTag;
	}
	
	public int searchTagNameAfterNewAdded( int listSizeBeforeSubmit, String tagName) {
		
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath ("//table//*[@class='row-title']"), listSizeBeforeSubmit));
		
		int indexOfFoundedTag = searchTagInList(tagName);
		return indexOfFoundedTag;
	}

	public void deleteTag(String tagName, int indexOfNewTag) {
		
		List<WebElement> tagCheckbox = driver.findElements(By.xpath("//*[@class= 'check-column']/input"));
		tagCheckbox.get(indexOfNewTag).click();;

		Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
		select.selectByVisibleText("Delete");

		apply.click();
	}

	public boolean tagMessage(String messageToCheck) {
		WebElement message = driver.findElement(By.xpath("//*[@id='message']//p"));
		return message.getText().equalsIgnoreCase(messageToCheck);
	}
}
