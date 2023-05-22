import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;

public class SubscribeTest {

    private HomePage homePage;

    @BeforeEach
    public void init() {
        homePage = new HomePage();
        homePage.openHomePage();
    }
    @Test
    public void validateSubscribe() {
        homePage.setSubscribeField();
        Assertions.assertTrue(homePage.subscribeMessageIsDisplayed());
    }

}
