package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.UUID;

public class LoginPage extends BasePage{

    @FindBy (xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement newUserText;
    //@FindBy (xpath = "//section[@id='form']/div[1]/div[1]/div[3]/div[1]/h2")
    @FindBy (xpath = "//h2[normalize-space()='Login to your account']")
    WebElement loginUserText;
    @FindBy (xpath = "//input[@data-qa='signup-name']")
    WebElement nameForm;
    @FindBy (xpath = "//input[@data-qa='signup-email']")
    WebElement emailForm;
    @FindBy (xpath = "//button[@data-qa='signup-button']")
    WebElement signupSubmitBtn;

    public String username = "";
    public String getSignUpText() {
        wait.until(ExpectedConditions.visibilityOf(newUserText));
        return newUserText.getText();
    }
    public String getLoginText() {
        wait.until(ExpectedConditions.visibilityOf(loginUserText));
        return loginUserText.getText();
    }


    public void fillTheSignUpForm() {
        String randomValue = UUID.randomUUID().toString();
        nameForm.sendKeys(randomValue);
        username = randomValue;
        emailForm.sendKeys(randomValue+"@gmail.com");
        signupSubmitBtn.click();
    }
}
