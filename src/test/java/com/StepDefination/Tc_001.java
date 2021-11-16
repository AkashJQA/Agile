package com.StepDefination;

import org.testng.annotations.Test;

import com.PageObject.LoginPage;
import com.utilities.BaseClass;

public class Tc_001 extends BaseClass{
	
	@Test
	public void loginTest() {
		LoginPage lp= new LoginPage(driver);
		
		lp.sendUsername();
		lp.PassWord();
		lp.Login();
		
		
		
		
	}

}
