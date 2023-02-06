package com.OrangCRM.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeCRM.utlis.BaseClass;

public class AdminPage extends BaseClass {
	public AdminPage() {
	PageFactory.initElements(driver,this);
}
	
 @FindBy(xpath="//span[text()='Admin']")
 WebElement addminlink;
 
 @FindBy(xpath="addButtonxpath")
 WebElement addButton;
 
 @FindBy(xpath="//label[text()='User Role']/following::div[1]")
 WebElement UserRoleDrop;
 
 @FindBy(xpath="//label[text()='Employee Name']/following::input[1]")
 WebElement empNameTxt;
 
 @FindBy(xpath="//label[text()='Username']/following::input[1]")
 WebElement userNameText ;
 
 @FindBy(xpath="//label[text()='Password']/following::input[1]")
 WebElement passWordText;

 @FindBy(xpath="//label[text()='Confirm Password']/following::input[1]")
 WebElement ConfermpassWord ;
 
 @FindBy(xpath="//label[text()='Status']/following::i[1]")
 WebElement StatusDrop;
 
 @FindBy(xpath="//button[text()=' Save ']")
 WebElement saveButton;
 
 @FindBy(xpath="//div[@role='listbox']")
	WebElement ListBoxDrop;


 public void providingAdminRight(String UserRole,String EmployeName,String Status,String UserName,String Password) {
	 addminlink.click();
	 addButton.click();
	 UserRoleDrop.click();
	 selectDropdown(ListBoxDrop, UserRole);
	 empNameTxt.sendKeys(EmployeName);
	 userNameText.sendKeys(EmployeName);
	 StatusDrop.click();
	 selectDropdown(ListBoxDrop,Status);
	 userNameText.sendKeys(UserName);
	 passWordText.sendKeys(Password);
	 ConfermpassWord.sendKeys(Password);
	 saveButton.click();
 } 
}

