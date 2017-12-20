package com.autotests.Channels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Channels {
    public static void main(String[] args) throws InterruptedException {
        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        ChromeDriver cd = new ChromeDriver();

        // Go to Fubo QA.
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        // Wait until webside with spoofing download.
        Thread.sleep(2000);

        // Input value USA.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[1]/input")).sendKeys(new String[]{"USA"});

        // Input ZipCode.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[2]/input")).sendKeys(new String[]{"94124"});

        // Click on Spoof.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[3]/button[1]/div")).click();

        // Wait until download.
        Thread.sleep(5000);

        // Click on 'Channels' tab.
        cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[2]/div/a/span")).click();

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

        // Close Chrome
        cd.close();


    }
}
