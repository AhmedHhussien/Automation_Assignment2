package Pages;

import Runner.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MSNHomePage extends UtilityMethods {


    WebDriver driver;

    public MSNHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement MSNSearch(){
        return driver.findElement(By.xpath("//*[@id='q']"));
    }

    public WebElement MSNSearchBtn(){
        return driver.findElement(By.xpath("//*[@id='sb_form_go']"));
    }

    public WebElement MSNSearchResult(){
        return driver.findElement(By.xpath("//*[@id='b_results']/li[1]/h2/a"));
    }
}
