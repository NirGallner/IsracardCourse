package isracard.exceptions.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HatavotPage extends BasePage {

	@FindBy(xpath =  "//html/body/footer/div/div/div[2]/ul[5]/li[1]/a")
	private WebElement horimVeyeladimLink;

	@FindBy(xpath =  "/html/body/footer/div/div/div[2]/ul[5]/li[2]/a")
	private WebElement nishnushimLink;
	
	public HatavotPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}
	
	public void clickHorimVeyeladimLink() {
		horimVeyeladimLink.click();
	}
	
	public void clickNishnushimLink() {
		nishnushimLink.click();
	}

}
