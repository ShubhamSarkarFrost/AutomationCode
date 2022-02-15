import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Spicejet_Search {

    public String BaseURL = "https://www.spicejet.com/";
    String driverPath = "/Users/Shubham/IdeaProjects/AutomationCode/drivers/chromedriver.exe";
    public WebDriver driver;
    String ExpectedURL = "https://www.spicejet.com/";
    String ExpectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";

    @BeforeTest
    public void LaunchBrowser(){
        System.out.println("<------------------------------Invoking the Browser ------------------------------>");
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.get(BaseURL);
        driver.manage().window().maximize();
    }

//    @Test(priority = 0)
//    public void MatchTitleandURL(){
//        String ActualUrl = driver.getCurrentUrl();
//        Assert.assertEquals(ActualUrl,ExpectedURL);
//        String ActualTitle = driver.getTitle();
//        Assert.assertEquals(ActualTitle,ExpectedTitle);
//    }
    @Test(priority= 1)
    public  void  SelectPassengers() throws InterruptedException {
        int i = 1;
        String nopassenger;
        WebElement passengerdrop = driver.findElement(By.xpath(".//div[@data-testid='home-page-travellers']"));
        WebElement addadultpassenger = driver.findElement(By.xpath(".//div[@data-testid='Adult-testID-plus-one-cta']"));
        WebElement donebutton = driver.findElement(By.xpath(".//div[@data-testid='home-page-travellers-done-cta']"));
        passengerdrop.click();
        Thread.sleep(10000);
        while(i<5){
          addadultpassenger.click();
          i++;
        }
        donebutton.click();
        nopassenger = passengerdrop.getText();
        System.out.print("No of Passengers are :- "+nopassenger);
    }

    @AfterTest
    public void CloseBrowser(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
