package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//header//img[@alt='Website for automation practice'])[1]")
    WebElement titleText;

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement loginBtn;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutBtn;
    @FindBy (xpath = "//li[10]//a[1]")
    WebElement loginWellcomeText;
    @FindBy (xpath = "//li[10]//a[1]/b")
    WebElement username;
    @FindBy (xpath = "//a[normalize-space()='Delete Account']")
    WebElement deleteAccountBtn;
    @FindBy (xpath = "//a[normalize-space()='Contact us']")
    WebElement contactBtn;
    @FindBy (xpath = "//a[@href='/products']")
    WebElement productsBtn;
    public void openHomePage() {
        String url = "https://automationexercise.com/" ;
        driver.get(url);
    }
    public String getTitleText() {
        wait.until(ExpectedConditions.visibilityOf(titleText));
        return titleText.getAttribute("alt");
    }

    public void clickOnTheLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
    }

    public String getLoggedInText () {
        wait.until(ExpectedConditions.visibilityOf(titleText));
        String text = loginWellcomeText.getText();
        return loginWellcomeText.getText();
    }

    public void clickOnTheDeleteBtn() {
        deleteAccountBtn.click();
    }

    public void clickOnTheLogoutBtn() {
        wait.until(ExpectedConditions.visibilityOf(titleText));
        logoutBtn.click();
    }

    public void clickOnTheContactBtn() {
        wait.until(ExpectedConditions.visibilityOf(titleText));
        contactBtn.click();
    }

    public void clickOnTheProducts() {
        wait.until(ExpectedConditions.visibilityOf(titleText));
        productsBtn.click();

    }
    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
