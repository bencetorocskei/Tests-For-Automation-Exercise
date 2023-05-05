package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountDeletedPage extends BasePage{

    @FindBy (xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement pageTitle;

    @FindBy (xpath = "//a[normalize-space()='Continue']")
    WebElement continueBtn;
    public String getTitleText() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public void clickOnTheContinueBtn() {
        continueBtn.click();
    }

}
