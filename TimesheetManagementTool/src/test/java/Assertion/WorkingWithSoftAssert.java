package Assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WorkingWithSoftAssert {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://laptop-eeas1cv9/login.do");
		
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
		
		driver.findElement(By.name("username")).sendKeys("admgtvbhnj");
		
		driver.findElement(By.name("pwd")).sendKeys("managersdfgh");
		
		driver.findElement(By.id("loginButton")).click();
		
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		
		
		
	}

}
