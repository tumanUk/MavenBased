package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {
    private final WebDriver driver;
    public By createAccountLabel = By.xpath("//*[@class = 'page-heading']");
    public By radioButtonGender = By.id("id_gender2");
    public By firstNameField = By.id("customer_firstname");
    public By lastNameField = By.id("customer_lastname");
    public By passwordField = By.id("passwd");
    public By addressField = By.id("address1");
    public By cityField = By.id("city");
    public By stateField = By.id("id_state");
    public By postalCodeField = By.id("postcode");
    public By mobilePhoneField = By.id("phone_mobile");
    public By submitButton = By.id("submitAccount");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public CreateAccountPage checkOpeningRegistrationPage(){
        WebElement navigationPanel = driver.findElement(createAccountLabel);
        Assertions.assertTrue(navigationPanel.isDisplayed());
        Assertions.assertEquals("AUTHENTICATION", navigationPanel.getText());
        return this;
    }
    public WebElement waitPage(){
        WebElement firstResult = new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(radioButtonGender));
        return firstResult;
    }

    @Step
    public MyAccountPage fillFormForCreatingUser(String firstName, String lastName, String pasword, String address, String city, String state, String postalCode, String phoneNumber){
        driver.findElement(radioButtonGender).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(passwordField).sendKeys(pasword);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        Select stateFromDropDown = new Select(driver.findElement(stateField));
        stateFromDropDown.selectByVisibleText(state);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(mobilePhoneField).sendKeys(phoneNumber);
        driver.findElement(submitButton).click();
        return new MyAccountPage(driver);
    }
}