import PageObjects.walmartLocators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;


public class walmartValidations {

    public String Baseurl = "https://www.walmart.com/";
    public WebDriver driver;
    public String pattern = "MM/dd/yyyy HH:mm:ss";
    DateFormat df = new SimpleDateFormat(pattern);
    Date today = Calendar.getInstance().getTime();
    String todayAsString = df.format(today);
    walmartLocators wb = new walmartLocators(driver);


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
    public void verifyWalmartHomepage() throws Exception {
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(Baseurl,ActualUrl);
        screenshotTaker.takeSnapshot(driver,"./screenshots/Walmart_HomePath.png");
        wb.walmartHomeApplicationVerification();
    }
}
