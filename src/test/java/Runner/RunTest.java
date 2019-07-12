package Runner;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;

import java.util.ArrayList;


public class RunTest extends UtilityMethods {
    MSNNewsPage MSNNewsPage;
    PathSolHonePage PathSolHone;
    MSNHomePage MSNHome;
    ExcelDB ExcelDb;
    int Iteration = 6;


    @BeforeClass
    public void NavigateTo() throws Exception {
        init(BrowserEnum.Chrome);
        ExcelDb = new ExcelDB(driver);
        MSNNewsPage = new MSNNewsPage(driver);
        PathSolHone = new PathSolHonePage(driver);
        MSNHome = new MSNHomePage(driver);
        driver.get(ExcelDb.GetDataFromExcel("WebSiteURL",Iteration));
    }

    @Test(priority = 1)
    public void SearchForPathSol() throws Exception {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        MSNHome.MSNSearch().sendKeys(ExcelDb.GetDataFromExcel("SearchFor",Iteration));
        MSNHome.MSNSearchBtn().click();
        Thread.sleep(3000);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertEquals(MSNHome.MSNSearchResult().getText(),"Path Solutions");
        MSNHome.MSNSearchResult().click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.path-solutions.com/");
        PathSolHone.ContactUsBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.path-solutions.com/contactus.php");
        driver.close();
        tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        MSNNewsPage.MSNNewsBtn().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.msn.com/ar-eg/news");
        MSNNewsPage.HeaderBtn().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div[1]")));
        MSNNewsPage.NewsHomePage().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.msn.com/ar-eg");
    }

    @AfterClass
    public void QuitTest(){
        driver.quit();
    }





}
