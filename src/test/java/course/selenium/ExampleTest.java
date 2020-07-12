package course.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExampleTest {
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("before all");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("before each");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("After each");
	}
	
	@Test
	public void testOne() {
		System.out.println("test 1");
	}
	
	@Test
	public void testTwo() {
		System.out.println("test 2");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("after all");
	}
}
