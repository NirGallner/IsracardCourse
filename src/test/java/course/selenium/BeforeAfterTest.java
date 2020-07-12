package course.selenium;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class BeforeAfterTest {
	
	@BeforeAll
	public static void BeforeAll()
	{
		System.out.println("BeforeAll");
	}
	
	@AfterAll
	public static void AfterAll()
	{
		System.out.println("AfterAll");
	}
	
	@BeforeEach
	public void BeforeEach()
	{
		System.out.println("BeforeEach");
	}
	
	@AfterEach
	public void AfterEach()
	{
		System.out.println("AfterEach");
	}
	
	@Test
	public void Test1()
	{
		System.out.println("Test1");
	}
	
	@Test
	public void Test2()
	{
		System.out.println("Test2");
	}

}

