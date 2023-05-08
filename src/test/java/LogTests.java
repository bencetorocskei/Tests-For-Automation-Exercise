import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pagefactory.*;

public class LogTests {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeEach
    public void init() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        homePage.openHomePage();
    }

    @Test
    public void validateHomePage() {
        String expected = "Website for automation practice";
        String actual = homePage.getTitleText();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void validateLoginPage() {
        homePage.clickOnTheLoginBtn();
        String expected = "Login to your account";
        String actual = loginPage.getLoginText();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void validateLogin() {
        homePage.clickOnTheLoginBtn();
        String expected = "Logged in as bence";
        loginPage.fillTheLoginForm();
        String actual = homePage.getLoggedInText();
        Assertions.assertEquals(expected, actual);
    }

    @Test void invalidLogin() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTheLoginFormInvalid();
        Assertions.assertTrue(loginPage.loginErrorMsgIsDisplayed());
    }

    @Test void validateLogout() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTheLoginForm();
        homePage.clickOnTheLogoutBtn();
        String expected = "https://automationexercise.com/login";
        String actual = loginPage.getUrl();
        Assertions.assertEquals(expected,actual);
    }

    @AfterEach
    public void tearDown() {
        homePage.shutDown();
    }

}
