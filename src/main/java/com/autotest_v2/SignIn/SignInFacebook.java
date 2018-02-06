package com.autotest_v2.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static com.autotest_v2.Spoofing.Spoof.spoof;

public class SignInFacebook {
    public static void main(String[] args) {
        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver driver = new ChromeDriver();

        // Store Variables.
        By startSignInButton = By.xpath("(//button)[2]");
        By signInWithFacebook = By.cssSelector("body > div.ReactModalPortal > div > div > div > div.modal-content.modal-small > div.modal-body > div > div > div:nth-child(1) > button:nth-child(1)");
        By facebookEmailInput = By.id("email");
        By facebookPasswordInput = By.id("pass");
        By facebookSignInButton = By.id("loginbutton");
        By menuButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[1]");
        By myAccountButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span");
        By userEmail = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/span");

        // Store sign in email and password.
        String testEmail = "alex.qa.org@gmail.com";
        String password = "test123456789";

        // Set timeout.
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        driver.manage().window().maximize();

        // Open Spoofing Page.
        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        // Use spoofing function
        spoof(driver, "USA", "94124");

        driver.findElement(startSignInButton).click();

        driver.findElement(signInWithFacebook).click();

        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        // Switch to new window opened
        for (String winHandle:driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            if (driver.getTitle().contains("Log into Facebook")) {
                driver.findElement(facebookEmailInput).sendKeys(testEmail);
                driver.findElement(facebookPasswordInput).sendKeys(password);
                driver.findElement(facebookSignInButton).click();

            }
        }

        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);

        driver.findElement(menuButton).click();

        driver.findElement(myAccountButton).click();

        // Get information from 'My Profile' about user email.
        String useremail = driver.findElement(userEmail).getText();

        // Display user email.
        System.out.println("User email is: " + useremail);

        // Compare emails:
        if (testEmail.equals(useremail)) {
            // emails are the same
            System.out.println("Emails are equals");
        } else {
            System.out.println("Emails are different");
            // emails are different

        }
        driver.close();

    }
}

