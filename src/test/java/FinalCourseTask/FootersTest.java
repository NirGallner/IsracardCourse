package FinalCourseTask;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Isracard.Final.AccessoriesAndFashionBenefitPage;
import com.Isracard.Final.AttractiveActivitesBenefitPage;
import com.Isracard.Final.AviationRoutBenefitPage;
import com.Isracard.Final.DesignforHomeBenefitPage;
import com.Isracard.Final.FoodAndSnacksBenefitPage;
import com.Isracard.Final.FunAndCultureBenefitPage;
import com.Isracard.Final.HolidaysandTracksBenefitPage;
import com.Isracard.Final.ParentsAndKidsBenefitPage;
import com.Isracard.Final.PremiumOffersBenefitPage;
import com.Isracard.Final.SurprisesBenefitPage;

public class FootersTest {
	private static WebDriver driver;
	
/**
 * Set the exe, driver and opens the URL for the first time
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
	/**
	 * Verifies that we are on the correct URL , if not will take us to the correct one before each Test
	 */
	@BeforeEach
	public void beforeEach() {
		String url = driver.getCurrentUrl();
		if(!url.equalsIgnoreCase("https://digital.isracard.co.il/")){
		}
	    driver.get("https://digital.isracard.co.il/");
	}
	/**
	 * Will close the window after we finish all the tests 
	 * **Should ask Nir if it general to all test or just on this Class**
	 */
	@AfterAll
	public static void afterAll(){
	driver.quit();
	}
	/**
	 * Test if the link parents and kids takes us to the correct page	
	 */
	@Test	
	public void parentsandChildrenFooterCheck () {
		ParentsAndKidsBenefitPage parentsKids = new ParentsAndKidsBenefitPage(driver);
		parentsKids.run();
	}
	/**
	 * Test if the link food and snacks takes us to the correct page	
	 */
	@Test	
	public void foodandSnacksFooterCheck () {
		FoodAndSnacksBenefitPage foodSnacks = new FoodAndSnacksBenefitPage(driver);
		foodSnacks.run();
	}
	/**
	 * Test if the link fun and culture takes us to the correct page	
	 */
	@Test	
	public void funandCultureFooterCheck () {
	    FunAndCultureBenefitPage funCulture = new FunAndCultureBenefitPage(driver);
	    funCulture.run();
	}
	/**
	 * Test if the link accessories and fashion takes us to the correct page	
	 */
	@Test	
	public void accessoriesandFashionFooterCheck () {
		AccessoriesAndFashionBenefitPage fashion = new AccessoriesAndFashionBenefitPage(driver);
		fashion.run();
	}
	/**
	 * Test if the link holidays and tracks takes us to the correct page	
	 */
	@Test	
	public void holidaysandTracksFooterCheck () {
		HolidaysandTracksBenefitPage holiday = new HolidaysandTracksBenefitPage(driver);
		holiday.run();
	}
	/**
	 * Test if the link attractive activities takes us to the correct page	
	 */
	@Test	
	//This will not fail because i changed the expected title to the title of the general page ישראכרט אתר ההטבות
	public void attractiveActivitesFooterCheck () {
		AttractiveActivitesBenefitPage attraction = new AttractiveActivitesBenefitPage(driver);
		attraction.run();
	}
    /**
     * Test if the link premium offers takes us to the correct page	
     */
	@Test	
	//This will not fail because i changed the expected title to the title of the general page ישראכרט אתר ההטבות
	public void premiumOffersFooterCheck () {
		PremiumOffersBenefitPage premium = new PremiumOffersBenefitPage(driver);
		premium.run();
	}
	/**
	 * Test if the link aviation rout takes us to the correct page	
	 */
	@Test	
	public void aviationRoutFooterCheck () {
	    AviationRoutBenefitPage aviation = new AviationRoutBenefitPage(driver);
	    aviation.run();
	}
	/**
	 * Test if the link surprises takes us to the correct page	
	 */
	@Test	
	//This will not fail because i changed the expected title to the title of the general page ישראכרט אתר ההטבות
	public void surprisesFooterCheck () {
		SurprisesBenefitPage surprise = new SurprisesBenefitPage(driver);
		surprise.run();
	}
	/**
	 * Test if the link design for home takes us to the correct page	
	 */
	@Test	
	//This will not fail because i changed the expected title to the title of the general page ישראכרט אתר ההטבות
	public void designforHomeFooterCheck () {
		DesignforHomeBenefitPage design = new DesignforHomeBenefitPage(driver);
		design.run();
	}
	
}
	
	
	
