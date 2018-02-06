package com.autotest_v2.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.autotest_v2.Spoofing.Spoof.spoof;

public class SignInWithNegativePassword {
    public static void main(String[] args) {
        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver driver = new ChromeDriver();

        // StoreVariables
        By startSignInButton = By.xpath("(//button)[2]");
        By signInEmailInput = By.xpath("(//input)[1]");
        By signInEmailPasswordInput = By.xpath("(//input)[2]");
        By signInButton = By.xpath("//div/span[.=\"Sign In with Email\"]");
        String useremail="test@dummy.com";
        String incorrectpassword="88888888";
        String correcterror = "That email and password combination is not valid. Please try again.";

        // Set timeout.
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        driver.manage().window().maximize();

        // Open Spoofing
        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        spoof(driver, "USA", "94124");

        driver.findElement(startSignInButton).click();

        driver.findElement(signInEmailInput).sendKeys(useremail);

        driver.findElement(signInEmailPasswordInput).sendKeys(incorrectpassword);

        driver.findElement(signInButton).click();

        // Get Error message
        String errormessage = driver.findElement(By.xpath("//div[@class=\"error\"]")).getText();

        // Compare error.
        if (errormessage.equals(correcterror)) {
            System.out.println("The error message is correct.");
        } else {
            System.out.println("The error message is INCORRECT.");
        }
        driver.close();



    }
}
