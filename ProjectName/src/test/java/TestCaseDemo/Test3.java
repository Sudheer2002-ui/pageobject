package TestCaseDemo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browser.Browser;
import Pages.page1;
import Pages.page2;

public class Test3 {
	@BeforeMethod
	public void open() throws Exception {
		Browser.init("TestCase 3");
		Browser.openBrowser();
		Browser.navigateToUrl();
		page1.enterUsername("Admin");
		page1.enterPassWord("admin123");
		page1.clickButton();
	}
	@DataProvider(name="list")
	public  Object[] change() throws Exception {
		Object[] testData=new Object[1];
		testData[0]="My Info";
		return testData;
	}

	@Test(dataProvider="list")
	public void checkMenu(String list) {
		page2.changePage(list);
		Assert.assertEquals(page2.elementText,list);
		Reporter.log("Test case 3 Menu Changed");
	}
	@AfterMethod
	public void close() {
		page1.closeBrowser();
	}
}