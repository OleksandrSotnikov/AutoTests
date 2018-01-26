import com.autotest_v2.PageObject.WelcomePage;
import com.autotest_v2.Spoofing.Spoof;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTestCase {
    @Test
    public void welcomePage(){
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver driver = new ChromeDriver();

        // Set timeout.
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        driver.manage().window().maximize();

        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        Spoof.spoof(driver, "USA", "94124");

        WelcomePage welcomePage = new WelcomePage(driver);

        Assert.assertEquals(welcomePage.isButtonsVisible(), true);

        driver.close();

    }
}
