package com.autotests.SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SignUpFuboPort {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver cd = new ChromeDriver();

        // Set timeout.
        cd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        cd.manage().window().maximize();

        // Go to Fubo QA.
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        WebElement SpoofCountry = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[1]/input"));
        SpoofCountry.sendKeys(new String[]{"USA"});

        WebElement SpoofZip = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[2]/div[2]/input"));
        SpoofZip.sendKeys(new String[]{"94124"});

        WebElement SpoofButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/form/div/div[3]/button[1]/div"));
        SpoofButton.click();

        // Click channels.
        WebElement ChannelsTab = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[2]/div/a/span"));
        ChannelsTab.click();

        // Click 'GetStarted' button.
        WebElement GetStartedButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div[3]/a/span"));
        GetStartedButton.click();

        // Generate email for SignUp.
        String prefix = "autosignup";
        String suffix = "@dummy.com";

        String testEmail = prefix + Math.round(Math.random() * 1000000) + suffix;

        WebElement SignUpEmail = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[2]/div/form/div[1]/div/input"));
        SignUpEmail.sendKeys(new String[] {testEmail});

        WebElement SignUpButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div[2]/div/form/div[2]/button/div/span"));
        SignUpButton.click();

        WebElement SignUpFirstName = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div/form/div[1]/input"));
        WebElement SignUpLastName = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div/form/div[2]/input"));
        SignUpFirstName.sendKeys(new String[] {"John"});
        SignUpLastName.sendKeys(new String[] {"Wick"});

        WebElement SignUpPassword = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div/form/div[3]/div/input"));
        SignUpPassword.sendKeys(new String[] {"test1234"});

        WebElement SelectPackageButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div/form/div[4]/button/div/span"));
        SelectPackageButton.click();

        // Choose Package (fubo Português)
        WebElement ChoosePackage = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[3]/div[1]"));
        ChoosePackage.click();

        // Get Package title.
        String chosenpackage = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[3]/div[1]/span/span[2]")).getText();

        WebElement GoToNextStepButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div[2]/div[1]/button/div/span"));
        GoToNextStepButton.click();

        WebElement ContinueButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div[2]/div[1]/button/div/span"));
        ContinueButton.click();

        WebElement CardHolderFirst = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div[1]/form/div/div[1]/div/input"));
        WebElement CardHolderLast = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div[1]/form/div/div[2]/div/input"));
        CardHolderFirst.sendKeys(new String[]{"First"});
        CardHolderLast.sendKeys(new String[]{"Last"});

        cd.switchTo().frame(0);     // entering the iframe

        WebElement CardNumber = cd.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        CardNumber.sendKeys(new String[]{"5555 5555 5555 4444"});

        cd.switchTo().defaultContent();
        cd.switchTo().frame(1);     // entering the iframe

        WebElement CVV = cd.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        CVV.sendKeys(new String[]{"019"});


        cd.switchTo().defaultContent();
        cd.switchTo().frame(2);     // entering the iframe

        WebElement ExpMonth = cd.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        ExpMonth.sendKeys(new String[]{"9"});

        cd.switchTo().defaultContent();
        cd.switchTo().frame(3);     // entering the iframe


        WebElement ExpYear = cd.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        ExpYear.sendKeys(new String[]{"19"});

        cd.switchTo().defaultContent();     // exiting the iframe

        WebElement CardZip = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div[1]/form/div/div[7]/div/input"));
        CardZip.sendKeys(new String[]{"94124"});

        WebElement StartWatchingButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[3]/div/div[2]/div[1]/button/div/span"));
        StartWatchingButton.click();

        WebElement MenuButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[2]"));
        MenuButton.click();

        WebElement MyAccountButton = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span"));
        MyAccountButton.click();

        // Get information from 'My Profile' about user email.
        String useremail = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/span")).getText();

        WebElement SubscriptionTab = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[1]/p[2]/span"));
        SubscriptionTab.click();

        // Get information from 'My Subscription'
        String userpackage = cd.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[2]/span")).getText();

        // Display user email.
        System.out.println("User email is: " + useremail);

        // Display user packages.
        System.out.println("Chosen package is: " + chosenpackage);
        System.out.println("User package is: " + userpackage);

        // Compare packages:
        if (chosenpackage.equals(userpackage)) {
            // packages are the same
            System.out.println("Packages are equals");
            } else {
            System.out.println("Packages are different");
            // packages are different

        }
        cd.close();
    }
}

