import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pagefactory.CartPage;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class SubscribeTest {

    private HomePage homePage;
    private CartPage cartPage;

    @BeforeEach
    public void init() {
        homePage = new HomePage();
        cartPage = new CartPage();
        homePage.openHomePage();
    }
    @Test
    public void validateSubscribeTitleOnHomePage() {
        homePage.scrollDownToFooter();
        String expected = "SUBSCRIPTION";
        String actual = homePage.getFooterTitle();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void validateSubscribeOnHomePage() {
        homePage.scrollDownToFooter();
        homePage.setSubscribeField();
        Assertions.assertTrue(homePage.subscribeMessageIsDisplayed());
    }
    @Test
    public void validateSubscribeTitleOnCartPage() {
        homePage.clickOnTheCart();
        cartPage.scrollDownToFooter();
        String expected = "SUBSCRIPTION";
        String actual = cartPage.getFooterTitle();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void validateSubscribeOnCartPage() {
        homePage.clickOnTheCart();
        cartPage.scrollDownToFooter();
        cartPage.setSubscribeField();
        Assertions.assertTrue(cartPage.subscribeMessageIsDisplayed());

    }
}
