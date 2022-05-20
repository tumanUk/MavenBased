package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyReader;

public class WebDriverFactory {
    protected  WebDriver driver;

    @BeforeEach
    public  void createInstance(){
        String browserName = PropertyReader.BROWSER.toLowerCase();
        switch (browserName) {
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            default:
                throw new InvalidArgumentException("cant initialize driver, available options: chrome, firefox");
        }
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}