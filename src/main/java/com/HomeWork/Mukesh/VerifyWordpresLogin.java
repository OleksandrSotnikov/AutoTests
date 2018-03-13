package com.HomeWork.Mukesh;

import com.HomeWork.Mukesh.Pages.testLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyWordpresLogin {

    @Test
    public void verifyValidLogin()
    {
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.wpjobboard.net/wp-login.php?");

        testLoginPage login = new testLoginPage(driver);
        login.loginToWordPress("user","user");
        driver.quit();
    }
}