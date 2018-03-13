package com.fubo.automation;

import com.fubo.automation.pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.fubo.automation.Spoof.spoof;

public class ClickSignInButton {

    @Test
    public void clickSignIn(){
        WebDriver driver = BrowserFactory.startBrowser("https://qa.fubo.tv/sandbox/geolocation");
        spoof(driver, "USA", "94124");
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.clicksignInButton();
        driver.quit();


    }
}
