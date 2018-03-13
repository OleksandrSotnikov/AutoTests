package com.HomeWork.Mukesh;


import com.HomeWork.Mukesh.Pages.BrowserFactory;
import com.HomeWork.Mukesh.Pages.LoginPageNew;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class VerifyValidLogin {

    @Test
    public void checkValidUse()
    {
      WebDriver driver =  BrowserFactory.startBrowser("https://demo.wpjobboard.net/wp-login.php?");

      LoginPageNew login_page = PageFactory.initElements(driver, LoginPageNew.class);

      login_page.login_wordpress("admin", "admin");

      driver.quit();

    }





}
