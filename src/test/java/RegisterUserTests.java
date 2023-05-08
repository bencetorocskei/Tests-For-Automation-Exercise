import org.junit.jupiter.api.*;
import pagefactory.*;

public class RegisterUserTests {


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
        String actual = loginPage.getSignUpText();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void validateAccountInfoPage() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTheSignUpForm();
        String expected = "ENTER ACCOUNT INFORMATION";
        String actual = accountInfoPage.getTitleText();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void validateCreateAccount() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTheSignUpForm();
        accountInfoPage.fillTheFormAndClickCreateAccount();
        String expected = "ACCOUNT CREATED!";
        String actual = accountCreatedPage.getTitleText();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void validateRegistration() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTheSignUpForm();
        accountInfoPage.fillTheFormAndClickCreateAccount();
        accountCreatedPage.clickOnTheContinueBtn();
        String expected = "Logged in as "+loginPage.username;
        String actual = homePage.getLoggedInText();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void happyPath() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTheSignUpForm();
        accountInfoPage.fillTheFormAndClickCreateAccount();
        accountCreatedPage.clickOnTheContinueBtn();
        homePage.clickOnTheDeleteBtn();
        String actual = accountDeletedPage.getTitleText();
        String expected = "ACCOUNT DELETED!";
        Assertions.assertEquals(expected, actual);
        accountDeletedPage.clickOnTheContinueBtn();
    }

    @Test
    public void registerWithExistingEmail() {
        homePage.clickOnTheLoginBtn();
        loginPage.fillTeSignUpFormWithExistingEmail();
        Assertions.assertTrue(loginPage.signupErrorMsgIsDisplayed());
    }

    @AfterEach
    public void tearDown() {
        homePage.shutDown();
    }

}
