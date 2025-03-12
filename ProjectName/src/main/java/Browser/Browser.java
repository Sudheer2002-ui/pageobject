package Browser;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Browser {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions act;
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	public static ExtentTest logger1;
	
	public static void init(String reportName) {
		extent=new ExtentReports();
		reporter=new ExtentSparkReporter(System.getProperty("user.dir") + "//target//ExtentReports//"+reportName+".html");
	}
	/*
	 * Open the browser based on the choice
	 */
	public static void openBrowser() throws Exception {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Opening the browser");
		logger1.log(Status.INFO,"Opening the Browser");
		try {
			String choice = utility.properties("browser"); 
			if (choice.equalsIgnoreCase("Chrome"))
				driver = new ChromeDriver();
			else if (choice.equalsIgnoreCase("Edge"))
				driver = new EdgeDriver();
			else if (choice.equalsIgnoreCase("Firefox"))
				driver = new FirefoxDriver();
			logger1.log(Status.PASS,"Browser Opened Successfully");
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Browser - openBrowser");
			logger1.log(Status.FAIL,"Browser Opening is unsuccessfull");
		}
		extent.flush();
	}
 
	/*
	 * Pauses the URL of the application
	 */
	public static void navigateToUrl() throws Exception {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Navigating To Url");
		logger1.log(Status.INFO,"Navigating To Url");
		try {
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
			driver.manage().window().maximize();
			act = new Actions(driver);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.titleIs("OrangeHRM"));
			logger1.log(Status.PASS,"Navigated Successfully");
		} catch (Exception e) {
			System.out.println("Browser - geturl");
			logger1.log(Status.FAIL,"Navigating To Url is unsuccessfull");

		}
		extent.flush();

	}
	/*
	 * Closes the Browser
	 */
	public static void closeBrowser() {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Closing The Browser");
		logger1.log(Status.INFO,"Closing The Browser");
		try {
			driver.quit();
			logger1.log(Status.PASS,"Browser Closed Successfully");

		} catch (Exception e) {
			System.out.println("Browser - closeBrowser");
			logger1.log(Status.FAIL,"Closing the Browser is unsuccessfull");
		}
		extent.flush();


}
}