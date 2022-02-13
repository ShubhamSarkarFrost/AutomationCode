import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class IntroDemo {

    public static void main(String[]args) throws IOException {
        System.setProperty("webdriver.chrome.driver","/Users/Shubham/IdeaProjects/AutomationCode/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.close();

    }
}
