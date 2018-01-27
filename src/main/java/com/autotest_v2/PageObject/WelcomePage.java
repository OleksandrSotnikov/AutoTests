package com.autotest_v2.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[1]")
    private WebElement fuboButton;

    @FindBy(xpath = "(//a[@href=\"/welcome/channels\"]/span[.=\"Channels\"])[2]")
    private WebElement channelsButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div/a/span/span/span")
    private WebElement trialButton;


    public boolean isButtonsVisible() {
       return fuboButton.isDisplayed() && channelsButton.isDisplayed();
    }

}
