package pages;

import io.qameta.allure.Step;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {
    private final WebDriver driver;
    public By navigationPanelLocator = By.xpath("//h1[@class='page-heading bottom-indent' and contains(text(), 'Customer service - Contact us')]");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public ContactUsPage checkOnPage() {
        WebElement navigationPanel = driver.findElement(navigationPanelLocator);
        Assertions.assertTrue(navigationPanel.isDisplayed());
        Assertions.assertEquals("CUSTOMER SERVICE - CONTACT US", navigationPanel.getText());
        return this;
    }
}