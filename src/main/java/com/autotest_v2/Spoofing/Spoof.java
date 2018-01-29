package com.autotest_v2.Spoofing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Spoof {
    public static void spoof(WebDriver driver, String countryCode, String postalCode)  {

        By spoofCountryInput = By.xpath("(//input)[1]");
        By spoofPostalCodeInput = By.xpath("(//input)[2]");
        By spoofButton = By.xpath("(//button)[@type=\"submit\"]");

        driver.findElement(spoofCountryInput).sendKeys(countryCode);

        driver.findElement(spoofPostalCodeInput).sendKeys(postalCode);

        driver.findElement(spoofButton).click();



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
