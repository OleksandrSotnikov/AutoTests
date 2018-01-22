package com.autotest_v2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static com.autotest_v2.Spoof.spoof;

public class SignIn {
    public static void main(String[] args) {
        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver cd = new ChromeDriver();

        // Store Variables.
        By signIn = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[5]/div/button/div/span");
        By signInEmailInput = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[1]/input");
        By signInPasswordШnput = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[2]/div/input");
        By signInButton = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/button/div/span");
        By menuButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[2]");
        By myAccountButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span");

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

        cd.findElement(signIn).click();

        cd.findElement(signInEmailInput).sendKeys(myArray);

        cd.findElement(signInPasswordШnput).sendKeys(myArray2);

        cd.findElement(signInButton).click();

        cd.findElement(menuButton).click();

        cd.findElement(myAccountButton).click();

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
