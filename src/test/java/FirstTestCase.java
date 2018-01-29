import com.autotest_v2.PageObject.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTestCase {
    @Test
    public void welcomePage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver driver = new ChromeDriver();

        // Set timeout.
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        driver.manage().window().maximize();

        By SpoofCountryInput = By.xpath("(//input)[1]");
        By SpoofZipInput = By.xpath("(//input)[2]");
        By SpoofButton = By.xpath("(//button)[@type=\"submit\"]");

        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        driver.findElement(SpoofCountryInput).sendKeys("USA");

        driver.findElement(SpoofZipInput).sendKeys("94124");

        driver.findElement(SpoofButton).click();

        Thread.sleep(500);

        WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);

        Assert.assertEquals(welcomePage.isButtonsVisible(), true);

        driver.close();
    }
}
