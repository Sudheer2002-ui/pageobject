package TestCaseDemo;

import Browser.Browser;
import Pages.page1;
import Pages.page2;

public class Demo extends Browser{
	public static void main(String[] args) throws Exception {
		Browser.openBrowser();
		Browser.navigateToUrl();
		if (page1.getTitle().equals("OrangeHRM")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		page1.enterUsername("Admin");
		page1.enterPassWord("admin123");
		page1.clickButton();
		page2.changePage("Leave");
        
	}

}