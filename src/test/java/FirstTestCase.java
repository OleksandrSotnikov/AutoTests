import com.autotest_v2.PageObject.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTestCase {
    @Test
    public void welcomePage()  {
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver driver = new ChromeDriver();

        By channelsButton = By.xpath("(//a[@href=\"/welcome/channels\"]/span[.=\"Channels\"])[2]");

        // Set timeout.
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        driver.manage().window().maximize();

        By spoofCountryInput = By.xpath("(//input)[1]");
        By spoofZipInput = By.xpath("(//input)[2]");
        By spoofButton = By.xpath("(//button)[@type=\"submit\"]");

        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        driver.findElement(spoofCountryInput).sendKeys("USA");

        driver.findElement(spoofZipInput).sendKeys("94124");

        driver.findElement(spoofButton).click();

        WebDriverWait wait = new WebDriverWait(driver,60);

        wait.until(ExpectedConditions.visibilityOfElementLocated(channelsButton));

        WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);

        Assert.assertEquals(welcomePage.areButtonsVisible(), true);

        driver.close();
    }
}
