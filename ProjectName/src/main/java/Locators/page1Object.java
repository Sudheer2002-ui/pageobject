package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Browser.Browser;

public class page1Object extends Browser {
	
	public static By userName=By.name("username");
	public static By passWord=By.name("password");
    public static By but=By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]");
	
	public static WebElement Username() {
		WebElement name = driver.findElement(userName);
		return name;
	}
	public static WebElement Password() {
		WebElement pass= driver.findElement(passWord);
		return pass;
	}
	public static WebElement Click() {
		WebElement button =driver.findElement(but);
		return button;
	}

}