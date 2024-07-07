import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class alaskaAirlines {

     public String Baseurl = "https://www.alaskaair.com/";
     public String BaseWebsiteTitle = "Alaska Airlines - Flight Deals and Cheap Airline Tickets - Book Today";
     public WebDriver driver;

     @BeforeTest
     public  void LaunchBrowser(){
          System.out.println("<-----------------------------Invoking the Browser --------------------------------->");
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("--remote-allow-origins=*");
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver(chromeOptions);
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.get(Baseurl);
          driver.manage().window().maximize();
     }

     @Test(priority = 1)
     public void verifyAirlinesTitle() throws Exception {
          String ActualUrl = driver.getCurrentUrl();
          Assert.assertEquals(Baseurl,ActualUrl);
          screenshotTaker.takeSnapshot(driver,"./screenshots/alaskaAirlines_HomePath.png");
          String ActualTitle = driver.getTitle();
          Assert.assertEquals(BaseWebsiteTitle,ActualTitle);
     }

     @Test(priority = 2)
     public void searchForHotel() throws InterruptedException {
          WebElement bookHotel = driver.findElement(By.xpath("//li[@data-testid='MegaMenuDesktopNavItem']//a[text()='Book']"));
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-testid='MegaMenuDesktopNavItem']//a[text()='Book']")));
          bookHotel.click();
          Thread.sleep(10000);
     }

     @AfterTest
     public void CloseBrowser(){
          driver.manage().deleteAllCookies();
          driver.close();
     }


}
