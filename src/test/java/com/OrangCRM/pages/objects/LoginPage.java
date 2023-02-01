package com.OrangCRM.pages.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeCRM.utlis.BaseClass;

public class LoginPage extends BaseClass {
    @FindBy(xpath="//input[@name='username']")
    WebElement userNameTxt;
    
    @FindBy(xpath="//input[@name='password']")
    WebElement userPasword;
    
    @FindBy(xpath="//button[text()=' Login ']")
    WebElement loginButon;
    public LoginPage() {
    	PageFactory.initElements(driver, this);
    }
    public void doLogin(String userName, String Password) {
    	userNameTxt.sendKeys(userName);
    	userPasword.sendKeys(Password);
    	loginButon.click();
    	
    }
    
    
}
