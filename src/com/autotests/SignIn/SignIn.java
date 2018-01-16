/* Title: Positive Sign In.

   Description: A registered user should be able to successfully login at fuboTV.

   Precondition : The user must already be registered with an email address and password.

   Test Steps:
   Precondition (Use Spoofing feature if need).
   Navigate to Spoofing Page.
   Input Country Code and Current Postal Code.
   Click Spoof
   1. Navigate to https://qa.fubo.tv/welcome.
   2. Click on 'Sign In' button.
   3. On the 'Sign In to fuboTV' modal window enter the correct email of the registered user in the ’Email’ field.
   4. On the 'Sign In to fuboTV' modal window enter the correct password of the registered user in the ’Password’ field.
   5. Click 'Sign In With Email' button.

   Expected Result: A user will be signed in and redirected to the fuboTV Sports Home Page.

   Test Environment: Windows 10 / Google Chrome.
*/
package com.autotests.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {
    public static void main(String[] args) throws InterruptedException {

        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver cd = new ChromeDriver();

        // Expand the window.
        cd.manage().window().maximize();

        // Open Spoofing
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        // Wait until webside with spoofing download.
        Thread.sleep(5000);

        WebElement SpoofCountry = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[1]/input"));
        SpoofCountry.sendKeys(new String[] {"USA"});

        WebElement SpoofZip = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[2]/input"));
        SpoofZip.sendKeys(new String[] {"94124"} );

        WebElement SpoofButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[3]/button[1]/div"));
        SpoofButton.click();

        // Wait until QA download.
        Thread.sleep(5000);

        WebElement SignIn = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[5]/div/button/div/span"));
        SignIn.click();

        // Store email value.
        String testEmail = "test@dummy.com";

        // Array for sending values
        String[] myArray = {testEmail};

        WebElement SignInEmail = cd.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[1]/input"));
        SignInEmail.sendKeys(myArray);

        WebElement SignInPassword = cd.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[2]/div/input"));
        SignInPassword.sendKeys(new String[] {"test1234"});

        WebElement SignInButton = cd.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/button/div/span"));
        SignInButton.click();

        // Wait
        Thread.sleep(5000);

        WebElement MenuButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[2]"));
        MenuButton.click();

        WebElement MyAccountButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span"));
        MyAccountButton.click();

        // Wait
        Thread.sleep(5000);

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
