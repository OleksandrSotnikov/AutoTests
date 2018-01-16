package com.autotests.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SignInFacebook {
    public static void main(String[] args) {
        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Store sign in email.
        String testEmail = "alex.qa.org@gmail.com";
        String[] myArray = {testEmail};

        // Open browser.
        WebDriver cd = new ChromeDriver();

        // Set timeout.
        cd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        cd.manage().window().maximize();

        // Open Spoofing
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        WebElement SpoofCountry = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[1]/input"));
        SpoofCountry.sendKeys(new String[]{"USA"});

        WebElement SpoofZip = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[2]/input"));
        SpoofZip.sendKeys(new String[]{"94124"});

        // Click on 'Spoof' button.
        WebElement SpoofButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[3]/button[1]/div"));
        SpoofButton.click();

        WebElement SignIn = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[5]/div/button/div/span"));
        SignIn.click();

        WebElement SignInWithFaceBookButton = cd.findElement(By.cssSelector("body > div.ReactModalPortal > div > div > div > div.modal-content.modal-small > div.modal-body > div > div > div:nth-child(1) > button:nth-child(1)"));
        SignInWithFaceBookButton.click();

        // Store the current window handle
        String winHandleBefore = cd.getWindowHandle();

        // Switch to new window opened
        for (String winHandle:cd.getWindowHandles()) {
            cd.switchTo().window(winHandle);
            if (cd.getTitle().contains("Log into Facebook")) {
                WebElement FacebookEmail = cd.findElement(By.id("email"));
                FacebookEmail.sendKeys(myArray);
                WebElement FacebookPaswword = cd.findElement(By.id("pass"));
                FacebookPaswword.sendKeys(new String[]{"test123456789"});
                WebElement FacebookSignInButton = cd.findElement(By.id("loginbutton"));
                FacebookSignInButton.click();

            }
        }

        // Switch back to original browser (first window)
        cd.switchTo().window(winHandleBefore);

        WebElement MenuButton = cd.findElement(By.cssSelector("#root > div > div > div:nth-child(2) > div:nth-child(1) > div > div:nth-child(3) > div > div:nth-child(2) > div > div > div > div:nth-child(3) > div > div:nth-child(1) > div > span:nth-child(1)"));
        MenuButton.click();

        WebElement MyAccountButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span"));
        MyAccountButton.click();

        // Get information from 'My Profile' about user email.
        String useremail = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/span")).getText();

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
        cd.close();

    }
}
