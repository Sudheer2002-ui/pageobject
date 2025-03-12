package Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.Status;

import Browser.Browser;
import Locators.page1Object;
import ScreenShot.screenshot;

public class page1 extends Browser {
	
	
	public static String getTitle() throws Exception {
		extent.attachReporter(reporter);
		logger1=extent.createTest("ScreenShot");
		logger1.log(Status.INFO, "ScreenShot");
		logger1.addScreenCaptureFromPath(screenshot.screenShot("Title"));
		extent.flush();
		 
		return driver.getTitle();
	}
	
	
	public static void enterUsername(String data) {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Entering the username");
		logger1.log(Status.INFO,"Entering the username");
	    try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(page1Object.userName)); 
	        page1Object.Username().sendKeys(data);
			logger1.log(Status.PASS,"UserName Entered Successfully");

	    } catch (Exception e) {
	        System.out.println("Exception in enterUsername: " + e);
			logger1.log(Status.FAIL,"Entering UserName is Unsuccessfull.");

	    }
		extent.flush();

	}

	public static void enterPassWord(String data) {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Entering the Password");
		logger1.log(Status.INFO,"Entering the Password");
		try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(page1Object.passWord)); 
			page1Object.Password().sendKeys(data);
			logger1.log(Status.PASS,"Password Entered Successfully");

		}catch(Exception e) {
			System.out.println(e);
			logger1.log(Status.FAIL,"Entering Password is Unsuccessfull.");

		}
		extent.flush();

		
	}
	public static void clickButton() {
		extent.attachReporter(reporter);
		logger1=extent.createTest("Clicking the Login Button");
		logger1.log(Status.INFO,"Clicking the Login Button");
		try {
			Thread.sleep(3000);
			page1Object.Click().click();
			Thread.sleep(5000);
			logger1.log(Status.PASS,"Login  Successfull");
		}catch(Exception e) {
			System.out.println(e);
			logger1.log(Status.FAIL,"Login  Unsuccessfull");

		}
		extent.flush();

	}

}