package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorizationPage {
    private static String pageURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static WebDriver driver;
    public By signInLocator = By.xpath("//button[@id='SubmitLogin']");
    public By emailInputLocator = By.xpath("//input[@id='email']");
    public By passwordInputLocator = By.xpath("//input[@id='passwd']");


    public static AuthorizationPage navigateHere(WebDriver driverIn) {
        driver = driverIn;
        driver.navigate().to(pageURL);
        return new AuthorizationPage();
    }

    public void doAuthorize() {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys("skillupdemo@gmail.com");

        WebElement passInput = driver.findElement(passwordInputLocator);
        passInput.sendKeys("12345");

        WebElement signInButton = driver.findElement(signInLocator);
        signInButton.click();
    }

}
