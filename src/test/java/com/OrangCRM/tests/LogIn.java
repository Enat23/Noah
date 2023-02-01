package com.OrangCRM.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogIn {
	@Test
	
	public void test1_Successfullogin() {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 WebElement userNameText=driver.findElement(By.xpath("//input[@name='username']"));
		 userNameText.sendKeys("Admin");
		 WebElement userPassWord=driver.findElement(By.xpath("//input[@name='password']"));
		 userPassWord.sendKeys("admin123");
		 WebElement loginlink=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		 loginlink.click();
		 
		 
		 WebElement PIMlink=driver.findElement(By.xpath("//span[text ()='PIM']"));
		 PIMlink.click();
		 WebElement addButton=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button/i"));
		 addButton.click();
		WebElement firstname=driver.findElement(By.xpath("//input[@name='firstName']"));
		 firstname.sendKeys("Mike");
		 WebElement lastname=driver.findElement(By.xpath("//input[@name='lastName']"));
		 lastname.sendKeys("Cris");
		 WebElement CredentialCheckbox=driver.findElement(By.xpath("//p[text()='Create Login Details']/following::span[1]"));
		 CredentialCheckbox.click();
		 WebElement userName=driver.findElement(By.xpath("//label[text()='Username']/following::input[1]"));
		 userName.sendKeys("Mike@");
		 WebElement passwordText=driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		 passwordText.sendKeys("Mike@123");
		 WebElement confirmpasswordText=driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		 confirmpasswordText.sendKeys("Mike@123");
		 WebElement saveButton=driver.findElement(By.xpath("//button[@type='submit']"));
		 saveButton.click();
		 
		 
	 }}
	  //  @Test
	  //  public void test2_Unsuccessfullogin() {
	    	// WebDriverManager.chromedriver().setup();
	    	// WebDriver driver=new ChromeDriver();
	    	// driver.manage().window().maximize();
	    	// driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
	    	// driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    	// WebElement userNameText=driver.findElement(By.xpath("//input[@name='username']"));
	    	// userNameText.sendKeys("Adimn123");
	    	// WebElement userPassWord=driver.findElement(By.xpath("//input[@name='password']"));
	    	// userPassWord.sendKeys("Adimn123");
	    	// WebElement loginlink=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
	    	// loginlink.click();
	    	// driver.close();

	    	
	    
//}
