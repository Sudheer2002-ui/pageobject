package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import java.time.Duration;
import Browser.Browser;
import Locators.page2Objects;

public class page2 extends Browser {
	
	public static String getStatic() {
		return driver.findElement((page2Objects.staticElement)).getText();
	}
	public static String elementText;

    public static void changePage(String pageName) {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Changing the Menu");
		logger1.log(Status.INFO,"Changing the Menu");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(page2Objects.Ul));
            List<WebElement> list = page2Objects.listItem();
            System.out.println(list.size());
            for (int i = 0; i < list.size(); i++) {
                WebElement e = list.get(i);
                if (e.getText().equals(pageName)) {
                	elementText=e.getText();
                    e.click();
                    break;
                }
            }
			logger1.log(Status.PASS,"Menu Changed  Successfully");
        } catch (Exception e) {
            System.out.println(e);
            logger1.log(Status.FAIL,"Menu Changing Unsuccessfull.");
        }
		extent.flush();

    }
}