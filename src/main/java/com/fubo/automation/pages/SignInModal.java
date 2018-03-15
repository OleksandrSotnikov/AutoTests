package com.fubo.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInModal {

    @FindBy(xpath = "(//Input)[1]")
    WebElement emailInput;

    @FindBy(xpath = "(//Input)[2]")
    WebElement passwordInput;

    @FindBy(xpath = "(//Button)[39]")
    WebElement signInButton;

    public void signIn (String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        signInButton.click();



    }


}
