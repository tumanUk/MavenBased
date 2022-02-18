package examples;

import automationpractice.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest extends BaseTest {

    @Test
    public void initDriverTest() {
        driver.get("https://google.com");
        assertTrue(driver.getCurrentUrl().contains("google.com"));
    }

    @Test
    public void useDriverManager() {
        driver.get("http://automationpractice.com/");
        WebElement signInButton = driver.findElement(By.xpath("//a[@class='login']"));
        if (signInButton.isDisplayed())
            signInButton.click();
        assertTrue(driver.getCurrentUrl().contains("authentication"));
    }
}
