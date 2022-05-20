package tests;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;
import utils.PropertyReader;
import utils.WebDriverUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CreateNewUserTest extends WebDriverFactory {
    Fairy fairy = Fairy.create();
    Person person = fairy.person();
    Logger logger = LoggerFactory.getLogger(CreateNewUserTest.class);

    @AfterEach
    public void allureAttachments() {
        File screenShot = WebDriverUtils.doScreenshot(driver);
        try {
            Allure.addAttachment("creating user test screenshot", Files.newInputStream(screenShot.toPath()));
        } catch (IOException e) {
            System.err.println("screenshot couldn't be attached");
        }

    }

    @Epic("Website store")
    @Feature("User actions on website")
    @Story("Create new user")
    @Issue("JRE-5")
    @Description("Creating new user")
    @Test
    public void creatingUser() {
        logger.info("This test create new user");
        driver.get(PropertyReader.BASEURL);
        BasePage basePage = new BasePage(driver).waitOnPage();
        AuthorizationPage authorizationPage = basePage.clickSignIn();
        CreateAccountPage createAccountPage = authorizationPage.openRegistrationPage(person.getCompanyEmail());
        createAccountPage.checkOpeningRegistrationPage();
        createAccountPage.waitPage();
        createAccountPage.fillFormForCreatingUser(person.getFirstName(), person.getLastName(), person.getPassword(), "623 Pendergast Court", "Florida", "Florida", "33015", person.getTelephoneNumber());
        new MyAccountPage(driver).checkOnPage();
    }
}