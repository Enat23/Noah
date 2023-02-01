package com.OrangCRM.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangCRM.pages.objects.LoginPage;
import com.OrangCRM.pages.objects.PIMPage;
import com.OrangeCRM.utlis.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PIMTest extends BaseClass {
	@Test(dataProvider="getTC1aData")
	 public void creatEmployee(HashMap<String,String> map) throws IOException, InterruptedException {
//		setup();
//		LoginPage lp=new LoginPage();
//		lp.doLogin("Admin", "admin123");
//		PIMPage pp=new PIMPage();
		pp.creatEmployee(map.get("firstName"),map.get("LastName"),map.get("UserName"),map.get("PassWord"));
	    Thread.sleep(10000);
		String empName=pp.EmployeeNameHeader.getText();
		wrightSpecificDataToDataSheet("Sheet1","EmployeName",empName,"TC2_EditEm");	 
	 }
	
	@Test(dataProvider="getTC2Data",priority=2)
	public void editEmployee(HashMap<String,String> map) throws InterruptedException {
//		setup();
//		LoginPage lp= new LoginPage();
//		lp.doLogin("Admin", "admin123");
//		PIMPage pp= new PIMPage();
		pp.editEmplyee(map.get("EmployeName"), map.get("Natinality"), map.get("Marital Status"),map.get("Blood Type"));
		
	}
	 @DataProvider
	 public Object[][]getTC1aData() throws IOException{
		 return getData("TC-1CrtEm","Sheet1");
	 }
	 
	 @DataProvider
	 public Object[][] getEditData() throws IOException{
		 return getData("TC2_EditEm", "Sheet1");
	 }
	 
	
}
