package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.ContactUsPage;
import utils.PropertyReader;
import utils.WebDriverUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class OpenContactUsPage extends WebDriverFactory {
    Logger logger = LoggerFactory.getLogger(OpenContactUsPage.class);

    @AfterEach
    public void allureAttachments() {
        File screenShot = WebDriverUtils.doScreenshot(driver);
        try {
            Allure.addAttachment("contact us page opening test screenshot", Files.newInputStream(screenShot.toPath()));
        } catch (IOException e) {
            System.err.println("screenshot couldn't be attached");
        }
    }

    @Epic("Website store")
    @Feature("User actions on website")
    @Story("Opening contacts")
    @Issue("JRE")
    @Description("Open contact us page")
    @Test
    public void moveToContactPage() {
        logger.info("This test open contact us page");
        driver.get(PropertyReader.BASEURL);
        BasePage basePage = new BasePage(driver).waitOnPage();
        ContactUsPage contactUsPage = basePage.clickContactUsButton();
        contactUsPage.checkOnPage();
    }
}
