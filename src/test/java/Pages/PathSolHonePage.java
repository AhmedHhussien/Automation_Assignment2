package Pages;

import Runner.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PathSolHonePage extends UtilityMethods {

    WebDriver driver;

    public PathSolHonePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement ContactUsBtn(){
        return driver.findElement(By.xpath("/html/body/table[7]/tbody/tr/td/div/table[1]/tbody/tr[3]/td[5]/div/p/span[1]/a[5]"));
    }

}
