package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.AuthorizationPage;
import utils.PropertyReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        String browser = PropertyReader.BROWSER;
        switch (browser) {
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

    @Test
    public void initDriverTest() {
        driver.get("https://google.com");
        assertTrue(driver.getCurrentUrl().contains("google.com"));
    }

    @Test
    public void UseDriverManager() throws InterruptedException {
        driver.get("http://automationpractice.com/");
        WebElement signInButton = driver.findElement(By.xpath("//a[@class='login']"));
        if (signInButton.isDisplayed())
            signInButton.click();
        Thread.sleep(800);
        assertTrue(driver.getCurrentUrl().contains("authentication"));
    }

    @Test
    public void authorizeTest() throws InterruptedException {
        AuthorizationPage authorizationPage = AuthorizationPage.navigateHere(driver);
        authorizationPage.doAuthorize();
        WebElement navigationSpan = driver.findElement(By.xpath("//span[@class='navigation_page']"));
        assertEquals(navigationSpan.getText(),"My account");
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }
}
