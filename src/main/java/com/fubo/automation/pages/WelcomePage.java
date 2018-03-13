package com.fubo.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {

    @FindBy(xpath = "(//button)[2]")WebElement signInButton;

public void click_signIn(){
    signInButton.click();
}



}
