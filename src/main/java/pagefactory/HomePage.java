package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//header//img[@alt='Website for automation practice'])[1]")
    WebElement titleText;
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement loginBtn;
    public void openHomePage() {
        String url = "https://automationexercise.com/" ;
        driver.get(url);
    }
    public String getTitleText() {
        wait.until(ExpectedConditions.visibilityOf(titleText));
        return titleText.getAttribute("alt");
    }

    public String getTextLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        return loginBtn.getText();
    }

    public void clickOnTheLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }



}
