package com.autotest_v2.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInModal {

    @FindBy (xpath = "(//input)[1]")
    private WebElement signInEmailInput;

    @FindBy (xpath = "(//input)[2]")
    private WebElement signInEmailPassword;

    @FindBy (xpath = "(//button)[50]")
    private WebElement signInButton;

    public boolean areElementsPresent (){
        return signInEmailInput.isDisplayed()
                && signInEmailPassword.isDisplayed()
                && signInButton.isDisplayed();

    }
}
