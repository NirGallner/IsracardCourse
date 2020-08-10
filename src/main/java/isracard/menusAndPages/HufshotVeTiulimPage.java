package isracard.menusAndPages;

import org.openqa.selenium.WebDriver;

/**
 * represents {@link HufshotVeTiulimPage}
 * @author liraz
 *
 */
public class HufshotVeTiulimPage {

	//c-tor
	public HufshotVeTiulimPage() {}
	
	/**
	 * Verify we are in HufshotVeTiulimPage
	 * @param driver
	 * @return
	 */
	public static boolean isOnPage(WebDriver driver) {
		return driver.getTitle().contains("חופשות וטיולים");
	}
}
