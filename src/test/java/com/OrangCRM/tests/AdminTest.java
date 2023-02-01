package com.OrangCRM.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangCRM.pages.objects.AdminPage;
import com.OrangCRM.pages.objects.LoginPage;
import com.OrangeCRM.utlis.BaseClass;

public class AdminTest extends BaseClass{
	@Test(dataProvider="TC3_provide")
	
	public void providingAdminRight(HashMap<String,String> map) {
	setup();
		LoginPage lp=new LoginPage();
		lp.doLogin("Admin", "admin123");
		AdminPage ap=new AdminPage();
	ap.providingAdminRight(map.get(" UserRole"),map.get("EmployeName"),map.get("Status") ,map.get(" UserName"),map.get("Password"));
	
	}	
	@DataProvider
	public Object[][] getAdminData() throws IOException{
		return getData("TC3_provide", "Sheet1");
	}
		
	}
	
	
	
	