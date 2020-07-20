package course.selenium.page.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TagsPage extends BasePage{

	//private WebDriver driver;

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
	
	private int listSizeBeforSubmit;
	private int indexOfNewTag = 0;
	private boolean tagDeleted = false; 

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

	public void submit(){
		listSizeBeforSubmit = listSize();
		submit.click();
	}


	public int listSize () {
		List<WebElement> tagsList = driver.findElements(By.xpath ("//table//*[@class='row-title']"));
		return tagsList.size();
	}

	public boolean searchTagInList (String tagName) {
		//initilaize the list with current WebElements
		List<WebElement> tagsList = driver.findElements(By.xpath ("//table//*[@class='row-title']"));;
		
		boolean validationOfTagName = false;
		boolean checkListSize = false;
		
		while (!checkListSize) {

			if (listSize() <= listSizeBeforSubmit && !tagDeleted ){
				checkListSize = false;
			}

			else if((listSize() > listSizeBeforSubmit) || tagDeleted ) {
				//get the new list with the added tag 
				tagsList = driver.findElements(By.xpath ("//table//*[@class='row-title']"));;
				checkListSize = true;
				validationOfTagName = false;
				
				//go over the list and search the new added tag
				for (WebElement tags : tagsList) { 
					if (tags.getText().contentEquals(tagName)) {
						indexOfNewTag = tagsList.indexOf(tags);				
						validationOfTagName = true;
						break;
					} else validationOfTagName = false;
				}	
			}
		}
		//return true only if the new tag found on the list
		return validationOfTagName;
	}
	
	public void deleteTag() {
		List<WebElement> tagCheckbox = driver.findElements(By.xpath("//*[@class= 'check-column']/input"));
		tagCheckbox.get(indexOfNewTag).click();;
		
		Select select = new Select(driver.findElement(By.id("bulk-action-selector-top")));
		select.selectByVisibleText("Delete");
		
		tagDeleted = true;
		
		apply.click();
	}
	
	public boolean tagMessage(String messageToCheck) {
		WebElement message = driver.findElement(By.xpath("//*[@id='message']//p"));
		return message.getText().equalsIgnoreCase(messageToCheck);
	}
}
 