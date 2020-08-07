package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TagPage {

	private WebDriver driver;
	private String nameSearch;
	
	//post
	@FindBy (id = "menu-posts")
	static WebElement post;
	
	//Link tag
	@FindBy (xpath ="//a[@href='edit-tags.php?taxonomy=post_tag']")
	private WebElement linktag;
	
	//Tags Name
	@FindBy (id ="tag-name")
	private WebElement nameTags; 
	
	//Slug name
	@FindBy (id= "tag-slug")
	private WebElement slugTagsElement;
	
	//Description name
	@FindBy (id = "tag-description")
	private WebElement descriptionTagsElement;
	
	//Submit for added a new tag
	@FindBy (id = "submit")
	private WebElement submitElement;
	
	@FindBy (id = "the-list")
	private WebElement listElement;
	
	
	public TagPage (WebDriver driver) {
		this.driver  = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Hover mouse on post element
	public void goToTagPage() {
		System.out.println("good");
		//WebElement postOp = driver.findElement(By.id("menu-posts"));
		Actions action = new Actions(driver);
		action.moveToElement(post).perform();
		linktag.click();
		WebDriverWait wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOf(nameTags));	
		
		//Search new tag
		
	}
	
	public void searchNewTag (){
	List <WebElement> allTags = listElement.findElements(By.cssSelector("a[class='row-title']"));
		for (WebElement ele:allTags) {
			if (ele.getText().contains(nameSearch)){
				System.out.println("Find the new tag: "+ ele.getText());
			}
		}
	}

	public static boolean IsOnPage (WebDriver driver) {
		 return driver.getTitle().contains("Tags");	
	}
		
	
	public TagPage withName (String Nametag) {
	  nameTags.sendKeys(Nametag);
	  
	  // Save the new tag name for the search
	  nameSearch = Nametag;
	  
	     return this;
	}
	
	public TagPage Withslugtags (String slug) {
		slugTagsElement.sendKeys(slug); 
		  return this;
	}
	
	public TagPage WithDescription  (String Description) {
		descriptionTagsElement.sendKeys(Description); 
		  return this;
	}
	public   void  submit() {
		submitElement.click();	
	}
	
}