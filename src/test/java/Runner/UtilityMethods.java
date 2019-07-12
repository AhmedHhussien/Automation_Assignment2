package Runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


public class UtilityMethods {
    public static String currentOs = System.getProperty("os.name").toLowerCase();
    public static String stChromeLinux = System.getProperty("user.dir")+"/drivers/linux/chromedriver";
    public static String stGeckoLinux = System.getProperty("user.dir")+"/drivers/linux/geckodriver";
    public static String stChromeWin = System.getProperty("user.dir")+"/drivers/windows/chromedriver.exe";
    public static String stGeckoWin = System.getProperty("user.dir")+"/drivers/windows/geckodriver.exe";
    public static WebDriver driver;



    public void init(BrowserEnum Browser){
        SetDriver(Browser);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    public void SetDriver(BrowserEnum browser)
    {
        switch(browser) {
            case Chrome:
                if (currentOs.toLowerCase().contains("linux")|| currentOs.toLowerCase().contains("mac os x"))
                {
                    System.setProperty("webdriver.chrome.driver",stChromeLinux);
                    driver = new ChromeDriver();
                }
                else if (currentOs.toLowerCase().contains("windows"))
                {
                    System.setProperty("webdriver.chrome.driver",stChromeWin);
                    driver = new ChromeDriver();
                }
                break;
            case Firefox:
                if (currentOs.toLowerCase().contains("linux")|| currentOs.toLowerCase().contains("mac os x"))
                {
                    System.setProperty("webdriver.gecko.driver",stGeckoLinux);
                    driver = new FirefoxDriver();
                }
                else if (currentOs.toLowerCase().contains("windows"))
                {
                    System.setProperty("webdriver.gecko.driver",stGeckoWin);
                    driver = new FirefoxDriver();
                }
                break;
        }

    }
    public enum BrowserEnum {

        Chrome,
        Firefox

    }



}
