package pages;

import io.qameta.allure.Step;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizationPage extends BasePage {
    private final String pageURL = "http://automationpractice.com/index.php?controller=authentication";
    public By emailInputLocator = By.cssSelector("input#email");
    public By passwordInputLocator = By.xpath("//input[@id='passwd']");
    public By navigationPanelLocator = By.cssSelector("span.navigation_page");
    public By existingAccountEmailField = By.xpath("//*[@id = 'email_create']");
    public By createNewAccountButton = By.xpath("//*[@id='SubmitCreate']");

    public AuthorizationPage(WebDriver driver) {
        super(driver);
        checkOnPage();
    }

    @Step
    public AuthorizationPage open() {
        driver.navigate().to(pageURL);
        return this;
    }

    @Step
    public MyAccountPage doAuthorize(String login, String password) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(login);
        WebElement passInput = driver.findElement(passwordInputLocator);
        passInput.sendKeys(password);
        WebElement signInButton = driver.findElement(signInLocator);
        signInButton.click();
        return new MyAccountPage(driver);
    }

    public AuthorizationPage checkOnPage() {
        WebElement navigationPanel = driver.findElement(navigationPanelLocator);
        Assertions.assertTrue(navigationPanel.isDisplayed());
        Assertions.assertEquals("Authentication", navigationPanel.getText());
        return this;
    }
    @Step
    public CreateAccountPage openRegistrationPage(String existingEmail) {
        WebElement emailInput = driver.findElement(existingAccountEmailField);
        emailInput.sendKeys(existingEmail);
        WebElement createAccountButton = driver.findElement(createNewAccountButton);
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }
}