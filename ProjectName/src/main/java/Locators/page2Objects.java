package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Browser.Browser;

public class page2Objects extends Browser{
	
	public static By Ul=By.xpath("//ul[@class=\"oxd-main-menu\"]");
	public static By staticElement=By.xpath("//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
	
	public static  List<WebElement> listItem() {
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class=\"oxd-main-menu\"]/li"));
        return list;
	}

}