/**
 * Selenium WebDriver course code samples.
 * June 202,
 * @author Nir Gallner
 */
package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;


public class GoodMorningTest {

	static WebDriver driver;

	@BeforeAll
	public static void beforeAll() {
		System.out.println("In before all");
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("In before each");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("In after each");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("In after all");
	}
}
