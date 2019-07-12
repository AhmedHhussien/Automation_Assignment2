package Pages;

import Runner.UtilityMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MSNNewsPage extends UtilityMethods {


    WebDriver driver;

    public MSNNewsPage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement MSNNewsBtn() {
        return driver.findElement(By.xpath("//a[@href='/ar-eg/news']"));
    }

    public WebElement HeaderBtn(){
        return driver.findElement(By.xpath("//*[@id='header-common']/h1/a[2]"));
    }

    public WebElement NewsHomePage(){
        return driver.findElement(By.xpath("//*[@id='header-common']/h1/a[1]"));
    }







}
