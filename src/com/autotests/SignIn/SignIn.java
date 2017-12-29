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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {
    public static void main(String[] args) throws InterruptedException {
        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        ChromeDriver cd = new ChromeDriver();

        // Open Spoofing
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        // Wait until webside with spoofing download.
        Thread.sleep(5000);

        // Input Value USA
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[1]/input")).sendKeys(new String[] {"USA"});

        // Input Current Postal Code
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[2]/input")).sendKeys(new String[] {"94124"} );

        // Click on 'Spoof' button.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[3]/button[1]/div")).click();

        // Wait until QA download.
        Thread.sleep(5000);

        // Clcik 'Sign In' button.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[5]/div/button/div/span")).click();

        // email value:
        String testEmail = "test@dummy.com";

        // Array for sending values
        String[] myArray = {testEmail};

        // Input Email.
        cd.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[1]/input")).sendKeys(myArray);

        // Input Password.
        cd.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[2]/div/input")).sendKeys(new String[] {"test1234"});

        // Click on Sign In button.
        cd.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/button/div/span")).click();

        // Wait
        Thread.sleep(5000);

        // Click on menu button.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[2]")).click();

        // Click My Account.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span")).click();

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
            cd.close();
        } else {
            System.out.println("Emails are different");
            // emails are different


        }
    }
}
