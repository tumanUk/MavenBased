package tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.HomePage;
import pages.SearchPage;
import utils.PropertyReader;
import utils.WebDriverUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SearchTest extends WebDriverFactory {


    @AfterEach
    public void allureAttachments() {
        File screenShot = WebDriverUtils.doScreenshot(driver);

        try {
            Allure.addAttachment("contact us page opening test screenshot", Files.newInputStream(screenShot.toPath()));
        } catch (IOException e) {
            System.err.println("screenshot couldn't be attached");
        }
    }

    @Test
    public void searchOfGoods() {
        driver.get(PropertyReader.BASEURL);
        BasePage basePage = new BasePage(driver).waitOnPage();
        basePage.inputInSearchField("dress");
        SearchPage searchPage = basePage.pressSearchButton();
        searchPage.waitOfSearchLabel();
        Assertions.assertTrue(searchPage.searchIsOpened());
        Assertions.assertTrue(searchPage.sortByIsPresent());
        searchPage.selectSortingOption("Price: Lowest first");
    }
}