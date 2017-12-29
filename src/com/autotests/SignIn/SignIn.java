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

        // Input 'Sign In' values (Email & Password).
        cd.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[1]/input")).sendKeys(new String[] {"123test123@dummy.com"});
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

        // Click 'Subscription' tab.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[1]/p[2]/span")).click();

        // Wait
        Thread.sleep(2000);

        // Get information from 'My Subscription'
        String userpackage = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]/span")).getText();

        // Get information about add-ons.
        String useraddon = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/span/span")).getText();

        // Display user email.
        System.out.println("User email is: " + useremail);

        // Display user package.
        System.out.println("User package is: " + userpackage);

        // Close page.
        cd.close();






    }
}
