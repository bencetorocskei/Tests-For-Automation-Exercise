import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pagefactory.*;

import java.sql.SQLOutput;

public class RegisterUser {


    private HomePage homePage;
    private LoginPage loginPage;
    private AccountInfoPage accountInfoPage;
    private AccountCreatedPage accountCreatedPage;
    private AccountDeletedPage accountDeletedPage;

    @BeforeEach
    public void init() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountInfoPage = new AccountInfoPage();
        accountCreatedPage = new AccountCreatedPage();
        accountDeletedPage = new AccountDeletedPage();
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
        String expected = "New User Signup!";
        String actual = loginPage.getText();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void validateAccountInfoPage() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTheLoginForm();
        String expected = "ENTER ACCOUNT INFORMATION";
        String actual = accountInfoPage.getTitleText();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void validateCreateAccount() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTheLoginForm();
        accountInfoPage.fillTheFormAndClickCreateAccount();
        String expected = "ACCOUNT CREATED!";
        String actual = accountCreatedPage.getTitleText();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void validateRegistration() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTheLoginForm();
        accountInfoPage.fillTheFormAndClickCreateAccount();
        accountCreatedPage.clickOnTheContinueBtn();
        String expected = "Logged in as "+loginPage.username;
        String actual = homePage.getLoggedInText();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void validateAccountDelete() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTheLoginForm();
        accountInfoPage.fillTheFormAndClickCreateAccount();
        accountCreatedPage.clickOnTheContinueBtn();
        homePage.clickOnTheDeleteBtn();
        String actual = accountDeletedPage.getTitleText();
        String expected = "ACCOUNT DELETED!";
        Assertions.assertEquals(expected, actual);
        accountDeletedPage.clickOnTheContinueBtn();
    }

}
