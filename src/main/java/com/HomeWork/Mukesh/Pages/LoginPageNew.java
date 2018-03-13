package com.HomeWork.Mukesh.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageNew {

    WebDriver driver;

    public LoginPageNew(WebDriver chdriver){
        this.driver = chdriver;
    }

 @FindBy(id="user_login") WebElement username;
 @FindBy(id="user_pass") WebElement password;
 @FindBy(id="wp-submit") WebElement submit_button;

 public void login_wordpress(String uid, String pass){
     username.clear();
     username.sendKeys(uid);
     password.clear();
     password.sendKeys(pass);
     submit_button.click();
 }


}
