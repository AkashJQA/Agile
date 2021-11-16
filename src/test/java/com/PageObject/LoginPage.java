package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.PropertiesUtilies;

public class LoginPage {
	
	WebDriver ldriver;
	public  LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
@FindBy(name="uid")
WebElement UserId;


@FindBy(name="password")
WebElement Password;

@FindBy(name="btnLogin")
WebElement LoginButton;

public void sendUsername() {
	UserId.sendKeys(PropertiesUtilies.getProperty("Username"));
}
public void PassWord() {
	Password.sendKeys(PropertiesUtilies.getProperty("Password"));
}
public void Login() {
	LoginButton.click();
}
}


