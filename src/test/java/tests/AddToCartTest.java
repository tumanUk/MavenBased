package tests;
import org.junit.jupiter.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.CartPage;
import utils.JSONUtils;
import utils.PropertyReader;

import java.io.IOException;

import org.openqa.selenium.Cookie;

public class AddToCartTest extends WebDriverFactory {
    private final String TOTAL_AMOUNT = "$47.38";

    @Test
    public void addToCartWithCookies() throws IOException {
        driver.get(PropertyReader.BASEURL);
        driver.manage().deleteAllCookies();
        JSONObject jsonCookies = JSONUtils.getFileContentsAsJsonObject("src/test/java/tests/resorces/Cookies.json");

        Cookie cookie = new Cookie(
                jsonCookies.getString("name"),
                jsonCookies.getString("value")
        );

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        CartPage cartPage = new BasePage(driver).openFolder();
        String cartAmount = cartPage.getTotalAmount();
        Assertions.assertEquals(TOTAL_AMOUNT, cartAmount);
    }
}