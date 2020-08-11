package isracard.exceptions.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);

		// this method will create all webelements
		PageFactory.initElements(driver, this);
	}

	// my account button
	@FindBy(xpath = "//*[@id=\"Digital_Header\"]/header/div/div[2]/a[1]/span")
	private WebElement enterMyAccount;

	// insert ID
	@FindBy(xpath = "//*[@id=\"otpLoginId_ID\"]")
	private WebElement insertId;

	// insert 6 numberCC
	@FindBy(name = "otpLoginLastDigits_ID")
	private WebElement insertCcNamber;

	// insert PW
	@FindBy(id = "otpLoginPwd")
	private WebElement insertPW;

	// enter button
	@FindBy(xpath = "//*[@id=\"otpLobbyFormPassword\"]/button")
	private WebElement submitButton;

	// tap on my account enter
	public void clickMyAccoundBT() {
		enterMyAccount.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='title ng-binding']"))));
	}

	// set ID to in text box
	public void setId(String strId) {
		insertId.sendKeys(strId);
	}

	// set 6 card number
	public void setSixNumbers(String strSixNumbers) {
		insertCcNamber.sendKeys(strSixNumbers);
	}

	// set password
	public void setPassWord(String strPassWord) {
		insertPW.sendKeys(strPassWord);

	}

	// click login
	public void clickLogin() {
		submitButton.click();
	}

	public void openMainUrl() {
		driver.get("https://digital.isracard.co.il/");
	}

	public void logInToIsracardSite(String strId, String strSixNumbers, String strPassWord) {
		// click on My account bt
		clickMyAccoundBT();

//			WebDriverWait wait = new WebDriverWait(driver, 10);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"otpLoginId_ID\\\"]")));
//			

		// fill user name
		this.setId(strId);

		// fill 6 numbers
		this.setSixNumbers(strSixNumbers);

		// fill password
		this.setPassWord(strPassWord);

		// click button
		this.clickLogin();

	}

}
