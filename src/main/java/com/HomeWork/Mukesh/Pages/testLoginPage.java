package com.HomeWork.Mukesh.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class testLoginPage {

    WebDriver driver;

        By username = By.id("user_login");
        By password = By.xpath("//*[@id=\"user_pass\"]");
        By loginButton = By.name("wp-submit");

        public testLoginPage(WebDriver driver)
        {
            this.driver = driver;
        }

        // more simple way
        public void loginToWordPress(String usernameid, String passwordid){
            driver.findElement(username).sendKeys(usernameid);
            driver.findElement(password).sendKeys(passwordid);
            driver.findElement(loginButton).click();
        }

        // more harder way
        /*public void typeUserName(String usernameid)
        {
            driver.findElement(username).clear();
            driver.findElement(username).sendKeys(usernameid);
        }

        public void typePassword(String userpass)
        {
            driver.findElement(password).clear();
            driver.findElement(password).sendKeys(userpass);
        }

        public void clickLoginButton()
        {
            driver.findElement(loginButton).click();
        */
}



