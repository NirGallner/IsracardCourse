package course.selenium.page.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideMenuPage extends BasePage {

	@FindBy(xpath = "//*[@class='wp-menu-name']")
	private List<WebElement> categories; 

	public SideMenuPage (WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement gotTo(String type, String category) {
		WebElement searchedCategory = null;
		
		switch (type) {
		case "menuCategory":
			for (WebElement webElement : categories) {
				if (webElement.getText().equalsIgnoreCase(category)) {
					searchedCategory = webElement;
					break;
				}
			}
			break;
		case "subMenuOption":			
			List<WebElement> subMenuOption = driver.findElements(By.xpath("//*[@class='wp-submenu wp-submenu-wrap' ]//a"));
			
			for (WebElement webElement : subMenuOption) {
				if (webElement.getText().equalsIgnoreCase(category)) {
					searchedCategory = webElement;
					break;
				}
			}
			break;
		}

		return searchedCategory;
	}

	public void hoverTo(String categoryName) {
		Actions ac = new Actions(driver);
		ac.moveToElement(gotTo("menuCategory", categoryName)).perform();

	}

	public void clickOn(String categoryName) {
		gotTo("menuCategory", categoryName).click();
	}

	public void clickOnOptionFromSubMenu(String categoryName, String subMenuOption) {
		hoverTo(categoryName);
		gotTo("subMenuOption", subMenuOption).click();
	}
}
