package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;

    private By totalAmount = By.id("total_price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTotalAmount() {
        String cartAmount = driver.findElement(totalAmount).getText();
        return cartAmount;
    }
}