package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.html.HTMLInputElement;


import java.util.List;

public class AccountInfoPage extends BasePage{

    @FindBy (xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement pageTitle;
    @FindBy (xpath = "//div[@data-qa='title']")
    List<WebElement> formTitle;
    @FindBy (xpath = "//input[@data-qa='password']")
    WebElement passwordInput;
    @FindBy (xpath = "//select[@data-qa='days']")
    WebElement daysDrp;
    @FindBy (xpath = "//select[@data-qa='months']")
    WebElement monthsDrp;
    @FindBy (xpath = "//select[@data-qa='years']")
    WebElement yearsDrp;
    @FindBy (xpath = "//input[@id='newsletter']")
    WebElement newsLetter;
    @FindBy (xpath = "//input[@id='optin']")
    WebElement specialOffer;
    @FindBy (xpath = "//input[@data-qa= 'first_name']")
    WebElement firstnameInput;
    @FindBy (xpath = "//input[@data-qa= 'last_name']")
    WebElement lastnameInput;
    @FindBy (xpath = "//input[@data-qa= 'address']")
    WebElement addressInput;
    @FindBy (xpath = "//select[@data-qa='country']")
    WebElement countryDpr;
    @FindBy (xpath = "//input[@data-qa= 'state']")
    WebElement stateInput;
    @FindBy (xpath = "//input[@data-qa= 'city']")
    WebElement cityInput;
    @FindBy (xpath = "//input[@data-qa= 'zipcode']")
    WebElement zipcodeInput;
    @FindBy (xpath = "//input[@data-qa= 'mobile_number']")
    WebElement mobile_numberInput;
    @FindBy (xpath = "//button[@data-qa= 'create-account']")
    WebElement createAccountBtn;

    public String getTitleText() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }
    public void selectTitle() {
        formTitle.get(0).click();
    }

    public void selectDateOfBirth() {
        Select day = new Select(daysDrp);
        day.selectByValue("13");
        Select month = new Select(monthsDrp);
        month.selectByValue("5");
        Select year = new Select(yearsDrp);
        year.selectByValue("1982");

    }
    public void fillPasswordForm() {
        passwordInput.sendKeys("aaa");
    }
    public void selectNewsLetter() {
        newsLetter.click();
    }

    public void selectSpecialOffer() {
        specialOffer.click();
    }

    public void fillTheAddressInfo() {
        firstnameInput.sendKeys("abc");
        lastnameInput.sendKeys("bca");
        addressInput.sendKeys("somewhere");
        Select country = new Select(countryDpr);
        country.selectByValue("Canada");
        stateInput.sendKeys("Quebec");
        cityInput.sendKeys("Quebec City");
        zipcodeInput.sendKeys("G0A - J9Z");
        mobile_numberInput.sendKeys("004181234567");
    }

    public void clickOnCreateAccountBtn() {
        createAccountBtn.click();
    }

    public void fillTheFormAndClickCreateAccount() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        selectTitle();
        fillPasswordForm();
        selectDateOfBirth();
        selectNewsLetter();
        selectSpecialOffer();
        fillTheAddressInfo();
        clickOnCreateAccountBtn();
    }
}
