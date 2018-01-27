package com.autotest_v2.Spoofing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Spoof {
    public static void spoof(WebDriver cd, String countryCode, String postalCode) {

        By SpoofCountryInput = By.xpath("(//input)[1]");
        By SpoofZipInput = By.xpath("(//input)[2]");
        By SpoofButton = By.xpath("(//button)[@type=\"submit\"]");

        cd.findElement(SpoofCountryInput).sendKeys(countryCode);

        cd.findElement(SpoofZipInput).sendKeys(postalCode);

        cd.findElement(SpoofButton).click();
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {

        }
    }

/*    public static void main(String[] args) {

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
    }*/
}
