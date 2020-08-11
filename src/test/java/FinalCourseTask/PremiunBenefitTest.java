package FinalCourseTask;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Isracard.Final.BenefitsLogInPage;
import com.Isracard.Final.DigitalBasePage;
import com.Isracard.Final.DownloadedBenefitsPage;
import com.Isracard.Final.HatavotPage;
import com.Isracard.Final.KayakBenefitPage;
import com.Isracard.Final.KfarBlumBusinessPage;

public class PremiunBenefitTest {
	
	private static WebDriver driver;
	static String userid = "321124430";
	static String userdigits = "002534";
	/**
	 * set the driver, exe , open browser and get the URL before all the tests
	 */
	@BeforeAll
	public static void beforeAll(){
		//Get the browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\marina\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		//go to page
		driver.get("https://digital.isracard.co.il/");
	}
	
	@BeforeEach
	public void beforeEach() {
		//String url = driver.getCurrentUrl();
		if(!driver.getTitle().equalsIgnoreCase("קייקי כפר בלום")){
			DigitalBasePage base = new HatavotPage(driver);
			base.gotoPremiumOffers();
			assertTrue(HatavotPage.isOnPage((WebDriver)driver));
			HatavotPage hatavot = new HatavotPage(driver);
			hatavot.gotoKayakBenefit();
			KayakBenefitPage.isOnPage(driver);
		}
	   
	}
	/**
	 * after all tests the window will close
	 */
	@AfterAll
	public static void afterAll(){
	driver.quit();
	}
	/**
	 * test that enters the expected benefit page and checks several parameters about the benefit:
	 * type- is premium; opens and closes read more section, goes to the benefit's owner page
	 */
    @Test
    public void kayakPremiunBenefitCheck () {
	    KayakBenefitPage kayak = new KayakBenefitPage(driver);
	    kayak.isPremium(driver);
	    kayak.openReadMore();
	    kayak.closeReadMore();
	    kayak.readTheTerms();
	    KfarBlumBusinessPage kfarBlum = new KfarBlumBusinessPage(driver);
	    kfarBlum.newWindowCheck();	   
}

    /**
     * test that download an expected benefit - confirms that it was the correct one and cancels the benefit
     * confirms that no more benefits appear in the page
     */
    @Test
    public void downloadKayakBenefitCheck() {
    	KayakBenefitPage kayak = new KayakBenefitPage(driver);
    	kayak.gotoAcquireBeneft();
 	    BenefitsLogInPage benefitLogIn = new BenefitsLogInPage(driver);
 	    benefitLogIn.isOnPage(driver);
 	    benefitLogIn.withUserID(userid).withSixDigits(userdigits).submitLogIn();
 	    kayak.isBenefitDownloaded();
 	    kayak.confirmBenefitDownloaded();
 	    DownloadedBenefitsPage downloadedBenefits = new DownloadedBenefitsPage(driver);
 	    downloadedBenefits.isOnPage(driver);
 	    downloadedBenefits.confirmTheDownloadedBenefit();
 	    downloadedBenefits.cancelDownloadedBenefit();
    }
}
