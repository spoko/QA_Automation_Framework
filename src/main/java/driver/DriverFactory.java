package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver(int implicitWaitSeconds) {
        WebDriverManager.chromedriver().setup(); //this download the needed web driver
        WebDriver driver = new ChromeDriver(); //creates the session and open the
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitSeconds));
        return driver;
    }

    public static WebDriver getFireFoxDriver(int implicitWaitSeconds){
        //Todo add firefox driver creation logic here
        return null;
    }
}
