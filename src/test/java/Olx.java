import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Olx {

    public String BaseUrl = "https://www.olx.in/";
    String driverPath = "/Users/Shubham/IdeaProjects/AutomationCode/drivers/chromedriver.exe";
    public WebDriver driver;
    String Expectedurl = "https://www.olx.in/";
    String Expectedtitle = "OLX - Free classifieds in India, Buy and Sell for free anywhere in India with OLX Online Classified Advertising";

    @BeforeTest
    public void LaunchBrowser(){
      System.out.println("<------------------------------Invoking the Browser ------------------------------>");
      System.setProperty("webdriver.chrome.driver",driverPath);
      driver = new ChromeDriver();
      driver.get(BaseUrl);
    }

    @Test
    public void MatchURLandTitle(){
        String ActualURL = driver.getCurrentUrl();
        Assert.assertEquals(ActualURL,Expectedurl);
        String Actualtitle = driver.getTitle();
        Assert.assertEquals(Actualtitle,Expectedtitle);
    }
    @Test
    public void  GlobalSearch(){
        String ActualSearchText = "Iphone X in India";
        driver.findElement(By.xpath(".//input[@data-aut-id='searchBox']")).sendKeys("Iphone X");
        driver.findElement(By.xpath(".//div[@data-aut-id='btnSearch']")).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[@class='PePdS']")));
        String SearchText = driver.findElement(By.xpath(".//h1[@class='PePdS']")).getText();
        Assert.assertEquals(SearchText,ActualSearchText);


    }
    @AfterTest
    public void CloseBrowser(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
