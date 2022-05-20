package pages;

import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private final WebDriver driver;
    public By navigationPanelLocator = By.cssSelector("span.navigation_page");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPage checkOnPage() {
        WebElement navigationPanel = driver.findElement(navigationPanelLocator);
        Assertions.assertTrue(navigationPanel.isDisplayed());
        Assertions.assertEquals("My account", navigationPanel.getText());
        return this;
    }
}