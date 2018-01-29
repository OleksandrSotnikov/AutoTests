package com.autotest_v2.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[1]")
    private WebElement fuboButton;

    @FindBy(xpath = "(//a[@href=\"/welcome/channels\"]/span[.=\"Channels\"])[2]")
    private WebElement channelsButton;

    @FindBy (xpath = "(//a[@href=\"/welcome/apps\"]/span[.=\"Apps\"])[2]")
    private WebElement appsButton;

    @FindBy (xpath = "//div[@class=\"help\"]")
    private WebElement helpButton;

    @FindBy (xpath = "(//div[@class=\"innerButton\"])[2]")
    private WebElement signInButton;

    @FindBy (xpath = "id(\"root\")/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]/span[1]")
    private WebElement languageButton;


    public boolean areButtonsVisible() {
        return fuboButton.isDisplayed()
                && channelsButton.isDisplayed()
                && appsButton.isDisplayed()
                && helpButton.isDisplayed()
                && languageButton.isDisplayed();


    }
}
