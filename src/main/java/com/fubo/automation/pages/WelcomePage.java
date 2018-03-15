package com.fubo.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {

    @FindBy(xpath = "(//button)[2]")
    private WebElement signInButton;

    public void clickSignInButton() {
        signInButton.click();
    }


}
