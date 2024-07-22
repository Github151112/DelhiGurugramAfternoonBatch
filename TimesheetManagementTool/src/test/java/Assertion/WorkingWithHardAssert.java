package Assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class WorkingWithHardAssert {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://laptop-eeas1cv9/login.do");
		
		SoftAssert s = new SoftAssert();
		s.assertEquals(driver.getTitle(), "actiTIME - Log");
		
		driver.findElement(By.name("username")).sendKeys("admgtvbhnj");
		
		driver.findElement(By.name("pwd")).sendKeys("managersdfgh");
		
		driver.findElement(By.id("loginButton")).click();
		
		s.assertAll();
		
		//Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		
		
		
	}

}
