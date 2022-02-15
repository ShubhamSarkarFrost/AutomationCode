import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class flightPractise {

    public String BaseURL = "https://rahulshettyacademy.com/dropdownsPractise/";
    String driverPath = "/Users/Shubham/IdeaProjects/AutomationCode/drivers/chromedriver.exe";
    public WebDriver driver;
    String ExpectedURL = "https://rahulshettyacademy.com/dropdownsPractise/";
    String ExpectedTitle = "QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets";
    String ExpectedValueDrop = "AED";




    @BeforeTest
    public void LaunchBrowser(){
        System.out.println("<------------------------------Invoking the Browser ------------------------------>");
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        driver.get(BaseURL);
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void MatchTitleandURL(){
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,ExpectedURL);
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }
    @Test(priority =1)
    public void StaticDropdown() throws InterruptedException {

        WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));;
        Select dropdown = new Select(currency);
        dropdown.selectByValue("AED");
        Thread.sleep(1000);
        String DropdownValue = dropdown.getFirstSelectedOption().getText();
        System.out.println("Dropdown Value is "+DropdownValue);
        Assert.assertEquals(DropdownValue,ExpectedValueDrop);

    }
    @AfterTest
    public void CloseBrowser(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
