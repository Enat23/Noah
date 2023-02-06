package com.OrangCRM.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeCRM.utlis.BaseClass;

public class PIMPage extends BaseClass {
	
	public PIMPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=pimlinkxpath)
	WebElement pimlink;
	
	@FindBy(xpath=addButtonlxpath)
	WebElement addButton;
	
	@FindBy(xpath=firstNameTexxpath)
	WebElement firstNameTex;
	
	@FindBy(xpath=lastNameTexxpath)
	WebElement lastNameTex;
	
	@FindBy(xpath=creatloginDetailsChexpath)
	WebElement creatloginDetailsChek;
	
	@FindBy(xpath=userNameTexxpath)
	WebElement userNameTex;
	
	@FindBy(xpath=Pawordwordxpath)
	WebElement Pawordword;
	
	@FindBy(xpath= confPasswordxpath)
	WebElement confPassword;
	
	@FindBy(xpath= saveButtonxpath)
	WebElement saveButton;
	
	@FindBy(xpath=EmployeeNameHeaderxpath)
	public WebElement EmployeeNameHeader;
	
	@FindBy(xpath=employeeNameTextxpath)
	WebElement employeeNameText;
	
	@FindBy(xpath=ListBoxDropxpath)
	WebElement ListBoxDrop;
	
	@FindBy(xpath=serchButtonxpath)
	WebElement serchButton;
	
	@FindBy(xpath=editButtonxpath)
	WebElement editButton;
	
	@FindBy(xpath=nationalitydropxpath)
	WebElement nationalitydrop;
	
	@FindBy(xpath= maritalStatusDropxpath)
	WebElement maritalStatusDrop;
	
	
	@FindBy(xpath=booldTypeDropxpath)
	WebElement booldTypeDrop;
	
	
	
	
	public void creatEmployee(String fName,String lName,String uName,String password) throws InterruptedException {
		
		pimlink.click();
		addButton.click();
		firstNameTex.sendKeys(fName);
		lastNameTex.sendKeys(lName);
		creatloginDetailsChek.click();
		userNameTex.sendKeys(uName);
		 Pawordword.sendKeys(password);
		 confPassword.sendKeys(password);
		 Thread.sleep(3000);
		 saveButton.click();
	}
		
	public void editEmplyee(String employeeName,String nationality,String maritalStatus,String bloodTypDrop) throws InterruptedException {
		pimlink.click();
		employeeNameText.sendKeys(employeeName);
		serchButton.click();
		editButton.click();
		Thread.sleep(3000);
		nationalitydrop.click();
		Thread.sleep(3000);
		selectDropdown(ListBoxDrop,nationality);
		 maritalStatusDrop.click();
		selectDropdown(ListBoxDrop,maritalStatus);
		booldTypeDrop.click();
		selectDropdown(ListBoxDrop,bloodTypDrop);
		
	
	}


}
