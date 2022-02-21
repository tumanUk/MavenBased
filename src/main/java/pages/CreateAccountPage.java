package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
    private final WebDriver driver;
    public By createAccountTitle = By.xpath("//*[@class = 'page-heading']");
    public By chooseGender = By.xpath("//*[@id='id_gender2']");
    public By firstNameField = By.id("customer_firstname");
    public By addressField = By.id("address1");
    public By cityField = By.id("city");
    public By stateField = By.id("id_state");
    public By postalCodeField = By.id("postcode");
    public By mobilePhoneField = By.id("phone_mobile");
    public By submitButton = By.id("submitAccount");
    public By lastNameField = By.id("customer_lastname");
    public By passwordField = By.id("passwd");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAccountPage checkRegistrationPage(){
        WebElement breadCramps = driver.findElement(createAccountTitle);
        Assertions.assertTrue(breadCramps.isDisplayed());
        Assertions.assertEquals("AUTHENTICATION", breadCramps.getText());

        return this;
    }
    public MyAccountPage FormUserCreation(String firstName,
                                          String lastName,
                                          String password,
                                          String address,
                                          String city,
                                          String state,
                                          String postalCode,
                                          String phoneNumber){

        driver.findElement(chooseGender).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(addressField).sendKeys(address);

        WebElement cityEnterField = driver.findElement(cityField);
        cityEnterField.click();
        cityEnterField.sendKeys(city);
        cityEnterField.click();

        WebElement stateDropDownList = driver.findElement(stateField);
        stateDropDownList.click();
        stateDropDownList.sendKeys(state);
        stateDropDownList.click();

        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(mobilePhoneField).sendKeys(phoneNumber);
        driver.findElement(submitButton).click();

        return new MyAccountPage(driver);
    }
}
