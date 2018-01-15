/* Title: Negative Sign In (With incorrect email).

   Description: A registered user should not be able to log in at fuboTV with incorrect credentials.

   Precondition : The user must already be registered with an email address and password.

   Test Steps:
   Precondition (Use Spoofing feature if need).
   Navigate to Spoofing Page.
   Input Country Code and Current Postal Code.
   Click Spoof
   1. Navigate to https://qa.fubo.tv/welcome.
   2. Click on 'Sign In' button.
   3. On the 'Sign In to fuboTV' modal window enter the incorrect email of the registered user in the ’Email’ field.
   4. On the 'Sign In to fuboTV' modal window enter the correct password of the registered user in the ’Password’ field.
   5. Click 'Sign In With Email' button.

   Expected Result: A user will not be able to Sign In and will get the alert message.

   Test Environment: Windows 10 / Google Chrome.
*/

package com.autotests.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInNegativeLog {
    public static void main(String[] args) throws InterruptedException {
        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver cd = new ChromeDriver();

        // Open Spoofing
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        // Wait until webside with spoofing download.
        Thread.sleep(5000);

        // Input Value USA
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[1]/input")).sendKeys(new String[]{"USA"});

        // Input Current Postal Code
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[2]/input")).sendKeys(new String[]{"94124"});

        // Click on 'Spoof' button.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[3]/button[1]/div")).click();

        // Wait until QA download.
        Thread.sleep(5000);

        // Cliсk 'Sign In' button.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[5]/div/button/div/span")).click();

        // Input Email.
        cd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")).sendKeys(new String[] {"incorrectemai@dummy.com"});

        // Input Password.
        cd.findElement(By.cssSelector("body > div.ReactModalPortal > div > div > div > div.modal-content.modal-small > div.modal-body > div > div > form > div > div:nth-child(2) > div > input[type=\"password\"]")).sendKeys(new String[]{"test1234"});

        // Click on Sign In button.
        cd.findElement(By.cssSelector("body > div.ReactModalPortal > div > div > div > div.modal-content.modal-small > div.modal-body > div > div > form > div > button > div > span")).click();

        // Wait.
        Thread.sleep(10000);

        // Get Error message
        String errormessage = cd.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[3]")).getText();

        String correcterror = "Incorrect Email";

        // Compare error.
        if (errormessage.equals(correcterror)) {
            cd.close();
        } else {
            System.out.println("The error message is incorrect.");
        }
    }
}