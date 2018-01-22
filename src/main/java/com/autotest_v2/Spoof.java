package com.autotest_v2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Spoof {
    public static void spoof(WebDriver cd, String countrycode, String postalcode) {

        By SpoofCountryInput = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[1]/input");
        By SpoofZipInput = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[2]/input");
        By SpoofButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[3]/button[1]/div");

        cd.findElement(SpoofCountryInput).sendKeys(countrycode);

        cd.findElement(SpoofZipInput).sendKeys(postalcode);

        cd.findElement(SpoofButton).click();
    }

    public static void main(String[] args) {

        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver cd = new ChromeDriver();

        // Set timeout.
        cd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        cd.manage().window().maximize();

        // Open Spoofing
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        spoof(cd, "USA", "94124");
    }
}
