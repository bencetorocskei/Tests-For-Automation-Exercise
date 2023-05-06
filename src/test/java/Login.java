import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pagefactory.*;

public class Login {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountInfoPage accountInfoPage;
    private AccountCreatedPage accountCreatedPage;
    private AccountDeletedPage accountDeletedPage;

    @BeforeEach
    public void init() {
        homePage = new HomePage();
        loginPage = new LoginPage();

    }

    @Test
    public void validateLogin() {
        String name = "bence";
        String email = "asd@sd";
        String password = "b";
    }


}
