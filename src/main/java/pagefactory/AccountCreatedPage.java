package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountCreatedPage extends BasePage{

    @FindBy (xpath = "//a[@data-qa='continue-button']")
    WebElement continueBtn;

    @FindBy (xpath = "//b[normalize-space()='Account Created!']")
    WebElement pageTitle;

    public String getTitleText() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public void clickOnTheContinueBtn() {
        continueBtn.click();
    }
}
