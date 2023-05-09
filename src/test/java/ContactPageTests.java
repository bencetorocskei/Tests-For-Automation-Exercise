import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pagefactory.ContactPage;
import pagefactory.HomePage;

public class ContactPageTests {

    private HomePage homePage;
    private ContactPage contactPage;

    @BeforeEach
    public void init() {
        homePage = new HomePage();
        contactPage = new ContactPage();
        homePage.openHomePage();
    }

    @Test
    public void validateContactPage() {
        homePage.clickOnTheContactBtn();
        String expected = "GET IN TOUCH";
        String actual = contactPage.getPageTitleText();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void validateMessageSending() {
        homePage.clickOnTheContactBtn();
        contactPage.fillContactForm();
        Assertions.assertTrue(contactPage.successMessageIsDisplayed());
    }

    @Test
    public void validateHomeButton() {
        homePage.clickOnTheContactBtn();
        contactPage.fillContactForm();
        contactPage.clickOnTheHomeButton();
        String expected = "https://automationexercise.com/";
        String actual = homePage.getUrl();
        Assertions.assertEquals(expected,actual);
    }

}
