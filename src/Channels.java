import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Channels {
    public static void main(String[] args) throws InterruptedException {
        // for Chrome.
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        // Open browser.
        ChromeDriver cd = new ChromeDriver();

        // Go to Fubo QA.
        cd.get("https://qa.fubo.tv/sandbox/geolocation");

        // Wait until webside with spoofing download.
        //Thread.sleep(2000);

        // Input value USA.
        cd.findElement(By.xpath("id(\"root\")/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys(new String[]{"USA"});

        // Input ZipCode.
        cd.findElement(By.xpath("id(\"root\")/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/input[1]")).sendKeys(new String[]{"94124"});

        // Click on Spoof.
        cd.findElement(By.xpath("id(\"root\")/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]/div[1]")).click();

        // Wait until download.
        Thread.sleep(5000);

        // Click on 'Channels' tab.
        cd.findElement(By.xpath("id(\"root\")/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/span[1]")).click();

        // Wait until download.
        Thread.sleep(5000);

        // Get price from different packeges.
        String fuboPremier = cd.findElement(By.xpath("id(\"root\")/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/span[2]/span[2]/span[1]/span[1]/span[1]")).getText();
        String fuboLatino = cd.findElement(By.xpath("id(\"root\")/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/span[2]/span[1]/span[1]/span[1]/span[1]")).getText();
        String fuboPortugues = cd.findElement(By.xpath("id(\"root\")/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/span[2]/span[1]/span[1]/span[1]/span[1]")).getText();

        // Display the price.
        System.out.println("The price for 'fubo Premier' is: " + fuboPremier);
        System.out.println("The price for 'fubo Latino' is: " + fuboLatino);
        System.out.println("The price for 'fubo Portugues' is " + fuboPortugues);

        // Close Chrome
        cd.close();


    }
}
