package isracard.exceptions.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HoriveVeyeladimPage extends BasePage{
	@FindBy(xpath =  "/html/body/main/div[2]/div[1]/h1")
	private WebElement title;

	public HoriveVeyeladimPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}
	
	public String getTitleText() {
		return title.getText();
	}

}
