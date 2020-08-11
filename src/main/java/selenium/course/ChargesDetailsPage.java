package selenium.course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ChargesDetailsPage extends BasePage {
	
	private WebDriver driver;

	public ChargesDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	private Actions actions = new Actions(driver);
	
	@FindBy(css="#wholePageExport > div:nth-child(6) > div > div > div > div.nonprint-landscape-a4 > div.transaction-details__filters-wrapper > div:nth-child(4) > div > div > div")
	private WebElement dropDown;
	
	public void changeToNextCharge() {
		actions.click(dropDown).click(driver.findElement(By.cssSelector("#ui-select-choices-row-3-0 > a"))).perform();
	}
	
	public void changeToFormerCharge() {
		actions.click(dropDown).click(driver.findElement(By.cssSelector("#ui-select-choices-row-3-1 > a"))).perform();
	}
	
	public void changeToChosenMonthCharge(String monthId) {
		actions.click(dropDown).click(driver.findElement(By.cssSelector("#ui-select-choices-row-3-2 > a"))).perform();
		
		actions.click(driver.findElement(By.className("input-group-btn"))).perform();
		actions.click(driver.findElement(By.id("datepicker-649-5243-" + monthId))).perform();
	}

}
