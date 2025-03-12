package TestCaseDemo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Browser.Browser;
import Excel.xldata;
import Pages.page1;
import Pages.page2;

public class Test2 {
	@BeforeMethod
	public void open() throws Exception {
		Browser.init("TestCase 2");
		Browser.openBrowser();
		Browser.navigateToUrl();
	}
	@DataProvider(name="login")
	public  Object[][] dpmethod() throws Exception {
		Object[][] obj=xldata.readExcel(0);
		System.out.println(obj);
		return obj;
	}
	
	@Test(dataProvider="login")
	public void checkLogin(String name,String pass,String expected) {
		page1.enterUsername(name);
		page1.enterPassWord(pass);
		page1.clickButton();
		Assert.assertEquals(page2.getStatic(),expected);
		Reporter.log("Test case 2 Login Successfull");
	}
	@AfterMethod
	public void close() {
		page1.closeBrowser();
	}
	
}