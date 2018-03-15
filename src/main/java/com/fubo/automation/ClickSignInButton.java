package com.fubo.automation;

import com.fubo.automation.pages.SignInModal;
import com.fubo.automation.pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static com.fubo.automation.Spoof.spoof;

public class ClickSignInButton {

    @Test(priority = 1)
    public void CheckSignIn() {
        WebDriver driver = BrowserFactory.startBrowser("https://qa.fubo.tv/sandbox/geolocation");
        spoof(driver, "USA", "94124");
        WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
        welcomePage.clickSignInButton();
        SignInModal signInModal = PageFactory.initElements(driver, SignInModal.class);
        signInModal.signIn("test@dummy.com", "test1234");
        driver.quit();
        }

    }


