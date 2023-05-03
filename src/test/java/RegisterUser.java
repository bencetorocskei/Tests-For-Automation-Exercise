import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pagefactory.HomePage;

public class RegisterUser {


    HomePage homePage;



    @Test
    public void validateHomePage() {
        homePage = new HomePage();
        homePage.openHomePage();
        System.out.println(homePage.getTextLogin());
        String expected = "Website for automation practice";
        String actual = homePage.getTitleText();
        Assertions.assertEquals(expected, actual);
        homePage.clickOnTheLoginBtn();
    }
}