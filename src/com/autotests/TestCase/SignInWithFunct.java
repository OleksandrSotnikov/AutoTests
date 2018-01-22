package com.autotests.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignInWithFunct {
    public static void spoof(WebDriver cd, String countrycode, String postalcode) {

        By SpoofCountryInput = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[1]/input");
        By SpoofZipInput = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[2]/input");
        By SpoofButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[3]/button[1]/div");

        cd.findElement(SpoofCountryInput).sendKeys(countrycode);

        cd.findElement(SpoofZipInput).sendKeys(postalcode);

        cd.findElement(SpoofButton).click();


    }


    public static void main(String[] args) {

        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver cd = new ChromeDriver();

        // Store Variables.
        By SignIn = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[5]/div/button/div/span");
        By SignInEmailInput = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[1]/input");
        By SignInPasswordInput = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[2]/div/input");
        By SignInButton = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/button/div/span");
        By MenuButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[2]");
        By MyAccountButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span");

        // Store email and password values.
        String testEmail = "test@dummy.com";
        String password = "test1234";
        String[] myArray = {testEmail};
        String[] myArray2 = {password};


        // Set timeout.
        cd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        cd.manage().window().maximize();

        // Open Spoofing
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        spoof(cd, "USA", "94124");

        cd.findElement(SignIn).click();

        cd.findElement(SignInEmailInput).sendKeys(myArray);

        cd.findElement(SignInPasswordInput).sendKeys(myArray2);

        cd.findElement(SignInButton).click();

        cd.findElement(MenuButton).click();

        cd.findElement(MyAccountButton).click();

        // Get information from 'My Profile' about user email.
        String useremail = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/span")).getText();

        // Display user email.
        System.out.println("User email is: " + useremail);

        // Compare emails:
        if (testEmail.equals(useremail)) {
            // emails are the same
            System.out.println("Emails are equals");
            // Close page.
        } else {
            System.out.println("Emails are different");
            // emails are different
        }
        cd.close();

    }

}


