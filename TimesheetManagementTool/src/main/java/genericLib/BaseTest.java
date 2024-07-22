package genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest implements IAutoConstant {
	public ExtentReports report;
	public ExtentTest test;
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {

		ExtentSparkReporter spark = new ExtentSparkReporter(
				"./src/test/resources/reports/" + Java_Utility.getName() + ".html");
		report = new ExtentReports();
		report.attachReporter(spark);
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		Reporter.log("====Connecting with the database", true);
	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String browser) throws IOException {
		Flib f = new Flib();
		// String browser = f.getDataFromPropertyFile(PROP_PATH,"browser");
		String url = f.getDataFromPropertyFile(PROP_PATH, "url");
		Reporter.log("====Launching " + browser + " Browser====", true);
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			Reporter.log("Invalid Browser", true);
		sdriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMESECONDS));
		driver.get(url);
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		Reporter.log("====Close the connection with database====", true);

	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {

		report.flush();
	}

}
