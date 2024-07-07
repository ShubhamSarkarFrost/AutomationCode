import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;


public class JioMart {

       public String Baseurl = "https://www.jiomart.com/";
       String driverpath = "C:\\Users\\Lenovo\\IdeaProjects\\AutomationCode\\drivers\\chromedriver.exe";
        public WebDriver driver;
        String Expectedurl = "https://www.jiomart.com/";
        String Expectedtitle = "Buy Grocery Online | Daily Needs Supermarket - JioMart";
        String Filepath = "C://Users//Lenovo//IdeaProjects//AutomationCode//data//jiomart.xlsx";
        String Sheetname = "jiomart";
        String cellvalue = "Products";


        @BeforeTest
        public  void LaunchBrowser(){
            System.out.println("<-----------------------------Invoking the Browser --------------------------------->");
            System.setProperty("webdriver.chrome.driver",driverpath);
            driver = new ChromeDriver();
            driver.get(Baseurl);
            driver.manage().window().maximize();
        }

        @Test
        public void matchurlandtitle(){
            String ActualUrl = driver.getCurrentUrl();
            Assert.assertEquals(Expectedurl,ActualUrl);
            String ActualTitle = driver.getTitle();
            Assert.assertEquals(Expectedtitle,ActualTitle);
        }

        @Test
        public void SearchData() throws IOException {
            ExcelData.ExportData(Filepath,Sheetname,cellvalue);
        }
        @AfterTest
        public void CloseBrowser(){
            driver.manage().deleteAllCookies();
            driver.close();
        }
}
