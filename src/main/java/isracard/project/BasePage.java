package isracard.project;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
		
		protected WebDriver driver;
		
		@FindBy (className = "btn-login-account")
		private WebElement enterAccount;

		
		
		
		
		public BasePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

//		public IsracardHomePage gotoLoginPage() {
//			IsracardHomePage.click();
//			return new IsracardHomePage(driver);
		}

		

