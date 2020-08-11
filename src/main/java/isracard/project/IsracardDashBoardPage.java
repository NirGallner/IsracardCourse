package isracard.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * represents Isracard post login dashboard page
 */
public class IsracardDashBoardPage  extends BasePage{
	//elements on page

	@FindBy(xpath="//*[@id=\"collapse1\"]/div/a[3]")
	private WebElement transactionlistbtn;
	
	@FindBy(xpath="//*[@id=\"accordion\"]/div[2]/div[1]/a")
	private WebElement actionsInAccountBthn;
	
	@FindBy(linkText="/personalarea/renewpassword/")
	private WebElement gotoupdatepwdbtn;
			
			
	
	 //int elements
		public IsracardDashBoardPage(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}
	
			public static  boolean IsonDashBoardPage(WebDriver driver) {
				return  driver.getTitle().contains("dashboard");
				//new WebDriverWait(driver, 20).until(ExpectedConditions.urlToBe("https://digital.isracard.co.il/personalarea/dashboard/"));
				//String url = driver.getCurrentUrl();
				//return url;
		}
			//goto transactionlist page
			public IsracardDashBoardPage submit() {
				transactionlistbtn.click();
				return new IsracardDashBoardPage(driver);
			}
			// openening the side menu
				public IsracardDashBoardPage menupicker() {
					actionsInAccountBthn.click();
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					return new IsracardDashBoardPage(driver);
				}
				// goto update password page
				public IsracardDashBoardPage updatepwd() {
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					gotoupdatepwdbtn.click();
					return new IsracardDashBoardPage(driver);
				}
				
}
