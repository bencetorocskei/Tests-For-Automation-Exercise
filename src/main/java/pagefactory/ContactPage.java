package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage{
    @FindBy (xpath = "//h2[normalize-space()='Get In Touch']")
    WebElement pageTitle;
    @FindBy (xpath ="//div[@id='contact-page']/div[2]/div[1]/div[1]/h2")
    WebElement pageTitleB;
    @FindBy (xpath = "//input[@data-qa='name']")
    WebElement nameInput;
    @FindBy (xpath = "//input[@data-qa='email']")
    WebElement emailInput;
    @FindBy (xpath = "//input[@data-qa='subject']")
    WebElement subjectInput;
    @FindBy (xpath = "//textarea[@data-qa='message']")
    WebElement messageInput;
    @FindBy (xpath = "//form[@id='contact-us-form']/div[5]")
    WebElement chooseFile;
    @FindBy (xpath = "//input[@data-qa='submit-button']")
    WebElement submitBtn;
    @FindBy (xpath = "//div[@id='contact-page']/div[2]/div[1]/div[1]/div[2]")
    WebElement successMsg;
    @FindBy (xpath = "//a[normalize-space()='Home']")
    WebElement homeBtn;
    public String getPageTitleText() {
        return pageTitle.getText();
    }

    public boolean successMessageIsDisplayed() {
        return successMsg.isDisplayed();
    }

    public void fillContactForm() {
        nameInput.sendKeys("bence");
        emailInput.sendKeys("asd@sd");
        subjectInput.sendKeys("test");
        messageInput.sendKeys("dafkasldfkjladsfjlairladknvlacipfpancpralvka");
        //chooseFile.click();
        //driver.switchTo().alert();
        //chooseFile.sendKeys("/home/bence/test.txt");
        submitBtn.click();
        driver.switchTo().alert().accept();
    }
    public void clickOnTheHomeButton() {
        homeBtn.click();
    }

}
