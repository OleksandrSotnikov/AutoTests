package com.autotest_v2.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    @FindBy(xpath = "//*[@id=\"fuboTV-logo\"]/path")
    public WebElement fuboButton;

    @FindBy(xpath = "(//a[@href=\"/welcome/channels\"]/span[.=\"Channels\"])[2]")
    public WebElement channelsButton;

   public WelcomePage(WebDriver driver){
       PageFactory.initElements(driver,this);
   }

    public boolean isButtonsVisible(){
       return fuboButton.isDisplayed() && channelsButton.isDisplayed();
    }

}
