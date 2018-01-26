package com.autotest_v2.SignUpFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static com.autotest_v2.Spoofing.Spoof.spoof;

public class SignUp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver cd = new ChromeDriver();

        // Store Variables.
        By startSignUpButton = By.xpath("//div/a[@href=\"/signup\"]");
        By signUpEmailInput = By.xpath("//input[1]");
        By signUpButton = By.xpath("(//button)[4]");
        By signUpFirstNameInput = By.xpath("(//input)[1]");
        By signUpLastNameInput = By.xpath("(//input)[2]");
        By signUpPasswordInput = By.xpath("(//input)[3]");
        By selectPackageButton = By.xpath("(//button)[2]");
        By continueToLastStepButton = By.xpath("(//button)[12]");
        By cardHolderFirstNameInput = By.xpath("(//input)[1]");
        By cardHolderLastNameInput = By.xpath("(//input)[2]");
        By cardZip = By.xpath("(//input)[3]");
        By startWatchingButton = By.xpath("(//button)[2]");
        By menuButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[2]");
        By myAccountButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span");
        By userEmailField = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/span");

        // Set timeout.
        cd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        cd.manage().window().maximize();

        // Open Spoofing Page.
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        spoof(cd, "USA", "94124");

        // Generate email for SignUp.
        String prefix = "autosignup";
        String suffix = "@dummy.com";
        String testEmail = prefix + Math.round(Math.random() * 1000000) + suffix;

        // Store password, name, Credit Card data.
        String password = "test1234";
        String firstName = "John";
        String lastName = "Wick";
        String cardNumber = "5555 5555 5555 4444";
        String cardCVV = "019";
        String expMonth = "9";
        String expYear = "19";
        String billingZipCode = "94124";


        cd.findElement(startSignUpButton).click();

        cd.findElement(signUpEmailInput).sendKeys(testEmail);

        cd.findElement(signUpButton).click();

        Thread.sleep(3000);

        cd.findElement(signUpFirstNameInput).sendKeys(firstName);

        cd.findElement(signUpLastNameInput).sendKeys(lastName);

        cd.findElement(signUpPasswordInput).sendKeys(password);

        cd.findElement(selectPackageButton).click();

        cd.findElement(continueToLastStepButton).click();

        cd.findElement(cardHolderFirstNameInput).sendKeys(firstName);

        cd.findElement(cardHolderLastNameInput).sendKeys(lastName);

        cd.switchTo().frame(0);     // entering the iframe

        // Input Card Number
        WebElement cardNumberInput = cd.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        cardNumberInput.sendKeys(cardNumber);

        cd.switchTo().defaultContent();
        cd.switchTo().frame(1);     // entering the iframe

        WebElement cvv = cd.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        cvv.sendKeys(cardCVV);

        cd.switchTo().defaultContent();
        cd.switchTo().frame(2);     // entering the iframe

        WebElement expMonthInput = cd.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        expMonthInput.sendKeys(expMonth);

        cd.switchTo().defaultContent();
        cd.switchTo().frame(3);     // entering the iframe


        WebElement expYearInput = cd.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        expYearInput.sendKeys(expYear);

        cd.switchTo().defaultContent();     // exiting the iframe

        cd.findElement(cardZip).sendKeys(billingZipCode);

        cd.findElement(startWatchingButton).click();

        cd.findElement(menuButton).click();

        cd.findElement(myAccountButton).click();

        // Get information from 'My Profile' about user email.
        String useremail = cd.findElement(userEmailField).getText();

        // Display user email.
        System.out.println("User email is: " + useremail);

        // Compare emails:
        if (testEmail.equals(useremail)) {
            // emails are the same
            System.out.println("Emails are equals");
        } else {
            System.out.println("Emails are different");
            // emails are different

        }
        cd.close();
    }

}

