package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public By signInLocator = By.id("SubmitLogin");
    public By accountLocator = By.cssSelector("a.account span");
    private final By signInButton = By.className("login");
    private final By contactUsButton = By.id("contact-link");
    private By searchField = By.id("search_query_top");
    private By folder =By.xpath("//a[@title='View my shopping cart']");

    private By searchButton = By.xpath("//*[@id='search_query_top']//following::*[@class='btn btn-default button-search']");
    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitOnPage();
    }

    public String getAuthorizedAccount() {
        return driver.findElement(accountLocator).getText();
    }

    @Step
    public AuthorizationPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new AuthorizationPage(driver);
    }

    @Step
    public ContactUsPage clickContactUsButton() {
        driver.findElement(contactUsButton).click();
        return new ContactUsPage(driver);
    }

    public BasePage waitOnPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(contactUsButton));
        return this;
    }

    public void inputInSearchField(String searchText){
        driver.findElement(searchField).sendKeys(searchText);
    }

    public SearchPage pressSearchButton(){
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }

    public CartPage openFolder(){
        driver.findElement(folder).click();
        return new CartPage(driver);
    }
}