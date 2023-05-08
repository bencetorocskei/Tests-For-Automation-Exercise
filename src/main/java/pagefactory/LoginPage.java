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
    WebElement signupBtn;
    @FindBy (xpath = "//input[@data-qa='login-email']")
    WebElement emailAddress;
    @FindBy (xpath = "//input[@data-qa='login-password']")
    WebElement passwordInput;
    @FindBy (xpath = "//button[@data-qa='login-button']")
    WebElement loginBtn;

    @FindBy (xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    WebElement loginErrorMsg;
    @FindBy (xpath = "//p[normalize-space()='Email Address already exist!']")
    WebElement signupErrorMsg;
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
        signupBtn.click();
    }
    public void fillTeSignUpFormWithExistingEmail() {
        nameForm.sendKeys("bence");
        emailForm.sendKeys("asd@sd");
        signupBtn.click();
    }

    public void fillTheLoginForm() {
        wait.until(ExpectedConditions.visibilityOf(loginUserText));
        String email = "asd@sd";
        String password = "b";
        passwordInput.sendKeys(password);
        emailAddress.sendKeys(email);
        loginBtn.click();
    }
    public void fillTheLoginFormInvalid() {
        passwordInput.sendKeys("invalid");
        emailAddress.sendKeys("invalid@gmail.com");
        loginBtn.click();
    }

    public boolean loginErrorMsgIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMsg));
        return loginErrorMsg.isDisplayed();
    }
    public boolean signupErrorMsgIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(signupErrorMsg));
        return signupErrorMsg.isDisplayed();
    }

    public String getUrl() {
        wait.until(ExpectedConditions.visibilityOf(loginUserText));
        return driver.getCurrentUrl();
    }

}
