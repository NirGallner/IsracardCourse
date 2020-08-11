package isracard.exceptions.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer extends BasePage{
		
		//click on HATAVOT tab in footer
		@FindBy(xpath="//*[@id=\"Digital_Header\"]/header/nav/div/ul/li[4]/a")
		private WebElement hatavotTab;
		
		//check if this is HATAVOT page 
		@FindBy(id="PersonalAreaLink")
		private WebDriver hatavotPersonal;
		
		public Footer (WebDriver driver){ 
			 
			super(driver); 
			
			}
			    //this method will create all webelements
			    PageFactory.initElements(driver, this);
			
			
			//tap on hatavot tab
			public void clickOnHatavotTab() {
				hatavotTab.click();
			}
			
			//find if this is the page 
			public void checkIfIsPage() {
				hatavotPersonal.getText();
			}
			
			public void hatavotCheck() {
				
				
			}
		
		}}
