package com.autotest_v2.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static com.autotest_v2.Spoofing.Spoof.spoof;

public class SignIn {
    public static void main(String[] args)  {
        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver driver = new ChromeDriver();

        // Store Variables.
        By signIn = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[5]/div/button/div/span");
        By signInEmailInput = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[1]/input");
        By signInPasswordInput = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[2]/div/input");
        By signInButton = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/button/div/span");
        By menuButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[2]");
        By myAccountButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span");

        // Store email and password values.
        String testEmail = "test@dummy.com";
        String password = "test1234";
        String[] myArray = {testEmail};
        String[] myArray2 = {password};

        // Set timeout.
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        driver.manage().window().maximize();

        // Open Spoofing
        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        spoof(driver, "USA", "94124");

        driver.findElement(signIn).click();

        driver.findElement(signInEmailInput).sendKeys(myArray);

        driver.findElement(signInPasswordInput).sendKeys(myArray2);

        driver.findElement(signInButton).click();

        driver.findElement(menuButton).click();

        driver.findElement(myAccountButton).click();

        // Get information from 'My Profile' about user email.
        String useremail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/span")).getText();

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
        driver.close();

    }
}
