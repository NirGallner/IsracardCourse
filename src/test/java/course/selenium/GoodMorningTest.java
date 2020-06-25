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
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Nir Gallner
 * Code sample June 11th, 2020
 *
 */
public class GoodMorningTest {

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
	
	@Test
	public void test1() throws InterruptedException {
		System.out.println("In Test 1");
	}

	@Test
	public void test2() {
		System.out.println("In Test 2");
	}

}
