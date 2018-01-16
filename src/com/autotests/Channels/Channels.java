/*
Title: Check price for packages (fon unregistered user).

   Description: A unregistered user should not be able to see correct price for each package on the Channels Page.

   Test Steps:
   Precondition (Use Spoofing feature if need).
   Navigate to Spoofing Page.
   Input Country Code and Current Postal Code.
   Click Spoof
   1. Navigate to https://qa.fubo.tv/welcome.
   2. Go to the Channels Page.

   Expected Result: A user will be able to see correct price for each package.

   Test Environment: Windows 10 / Google Chrome.
 */

package com.autotests.Channels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Channels {
    public static void main(String[] args) throws InterruptedException {

        //Prices values:
        String fuboPremiercorrect = "$39.99/mo";
        String fuboLatinocorrect = "$17.99/mo";
        String fuboPortcorrect = "$19.99/mo";

        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver cd = new ChromeDriver();

        // Go to Fubo QA.
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        // Wait until webside with spoofing download.
        Thread.sleep(2000);

        WebElement SpoofCountry = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[1]/input"));
        SpoofCountry.sendKeys(new String[]{"USA"});


        WebElement SpoofZip = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[2]/input"));
        SpoofZip.sendKeys(new String[]{"94124"});

        WebElement SpoofButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[3]/button[1]/div"));
        SpoofButton.click();

        // Wait until download.
        Thread.sleep(5000);

        WebElement ChannelsTab = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[2]/div/a/span"));
        ChannelsTab.click();

        // Wait until download.
        Thread.sleep(5000);

        // Get price from different packeges.
        String fuboPremier = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div[1]/span[2]/span[2]/span/span/span")).getText();
        String fuboLatino = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div[2]/span[2]/span/span/span/span")).getText();
        String fuboPortugues = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/div[3]/span[2]/span/span/span/span")).getText();

        // Display the price.
        System.out.println("The price for 'fubo Premier' is: " + fuboPremier);
        System.out.println("The price for 'fubo Latino' is: " + fuboLatino);
        System.out.println("The price for 'fubo Portugues' is " + fuboPortugues);

        // Compare prices
        if (fuboPremiercorrect.equals(fuboPremier)){
            System.out.println("The price for fubo Premier is correct");
            } else {
            System.out.println("The price for fubo Premier is INCORRECT");
        }

        if (fuboLatinocorrect.equals(fuboLatino)){
            System.out.println("The price for fubo Latino is correct");
            } else {
            System.out.println("The price for fubo Latino is INCORRECT");
        }

        if (fuboPortcorrect.equals(fuboPortugues)){
                System.out.println("The price for fubo Português is correct");
        } else {
            System.out.println("The price for fubo Português is INCORRECT");
        }

        // Close Chrome
        cd.close();


    }
}
