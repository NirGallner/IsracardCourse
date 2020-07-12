package course.selenium;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selectors2 {

	private static WebDriver driver;

@BeforeAll
public static void OpenWebDriver() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\333\\Desktop\\cromedriver\\chrome\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("http://demosite.center/wordpress/wp-login.php");
	WebElement userelement = driver.findElement(By.id("user_login"));
	userelement.sendKeys("Admin");
	WebElement passwordelement = driver.findElement(By.id("user_pass"));
	passwordelement.sendKeys("demo123");
	driver.findElement(By.id("wp-submit")).click();
}

@BeforeEach
public void BeforeEach(){
WebElement dashbordelement = driver.findElement(By.tagName("h1"));
String text = dashbordelement.getText();
System.out.println(text);
//if (driver.getTitle().contains("Dashboard") == false)
//	driver.findElement(By.cssSelector(".wp-menu-name")).click();
//	System.out.println("cssSelector");
}

@Test
public  void User() throws InterruptedException{
WebElement postElement = driver.findElement(By.xpath("//*[@id=menu-posts"));
postElement.click();
System.out.println("Post");
Thread.sleep(7000);

}
}