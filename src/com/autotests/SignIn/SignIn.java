package com.autotests.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {
    public static void main(String[] args) throws InterruptedException {
        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        ChromeDriver driver = new ChromeDriver();

        // Open Spoofing
        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        // Wait until webside with spoofing download.
        Thread.sleep(2000);

        // Input Value USA
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[1]/input")).sendKeys(new String[] {"USA"});

        // Input Current Postal Code
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[2]/input")).sendKeys(new String[] {"94124"} );

        // Click on 'Spoof' button.
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[3]/button[1]/div")).click();

        // Wait until QA download.
        Thread.sleep(5000);

        // Clcik 'Sign In' button.
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[5]/div/button/div/span")).click();

        // Input 'Sign In' values (Email & Password).
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[1]/input")).sendKeys(new String[] {"test@dummy.com"});
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[2]/div/input")).sendKeys(new String[] {"test1234"});

        // Click on Sign In button.
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/button/div/span")).click();






    }
}
