import com.autotest_v2.PageObject.SignInModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.autotest_v2.Spoofing.Spoof.spoof;

public class SignIn {
    @Test
    public void signInModal() {
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        WebDriver driver = new ChromeDriver();

        By startSignInButton = By.xpath("(//button)[2]");

        // Set timeout.
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Expand the window.
        driver.manage().window().maximize();

        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        spoof (driver, "USA", "94124");

        driver.findElement(startSignInButton).click();

        SignInModal signInModal = PageFactory.initElements(driver, SignInModal.class);
        Assert.assertEquals(signInModal.areElementsPresent(), true);
            //driver.findElement().sendKeys("test@dummy.com");

        driver.close();


    }
}
