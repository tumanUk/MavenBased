package automationpractice;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.MyAccountPage;
import utils.PropertyReader;

public class CreateNewUserTest extends BaseTest {
    Fairy fairy = Fairy.create();
    Person person = fairy.person();

    @Test
    public void creatingUser() {
        driver.get(PropertyReader.BASEURL);

        HomePage homePage = new HomePage(driver).waitOnPage();
        AuthorizationPage authorizationPage = homePage.clickSignIn();
        CreateAccountPage createAccountPage = authorizationPage.startRegistrationPage(person.getCompanyEmail());
        createAccountPage.checkRegistrationPage();
        createAccountPage.FormUserCreation(
                person.getFirstName(),
                person.getLastName(),
                person.getPassword(),
                "Baker Street",
                "Arizona",
                "Arizona",
                "72008",
                person.getTelephoneNumber());

        new MyAccountPage(driver).checkOnPage();
    }
}
