package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ReadFromConfig;

import java.sql.SQLOutput;
import java.util.*;

public class CartPage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    WebElement footerTitle;
    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement subscribeField;
    @FindBy(xpath = "//button[@id='subscribe']")
    WebElement subscribeSubmitBtn;
    @FindBy(xpath = "//div[@id='success-subscribe']")
    WebElement subscribeSuccessMsg;
    @FindBy(xpath = "//footer[@id='footer']")
    WebElement footer;
    @FindBy(xpath = "//tr[contains(@id, 'product')]")
    List<WebElement> products;
    @FindBy(xpath = "//a[contains(@href, 'product_details')]")
    List<WebElement> productNames;
    @FindBy(css = "p[class='cart_total_price']")
    List<WebElement> totalPrices;
    @FindBy(css = "td[class='cart_price'] p")
    List<WebElement> prices;
    @FindBy(css = "button[class='disabled']")
    List<WebElement> quantitys;

    public String getFooterTitle() {
        return footerTitle.getText();
    }

    public void scrollDownToFooter() {
        action.scrollToElement(footer).perform();
    }

    public void setSubscribeField() {
        wait.until(ExpectedConditions.visibilityOf(footerTitle));
        subscribeField.sendKeys(ReadFromConfig.readFromFile("VALID_EMAIL"));
        subscribeSubmitBtn.click();
    }

    public boolean subscribeMessageIsDisplayed() {
        return subscribeSuccessMsg.isDisplayed();
    }

    public void getProductInfo() {
        Map<String, List<String>> productDetails = new HashMap<>();

        for (int i = 0; i < productNames.size(); i++) {
            productDetails.put(productNames.get(i).getText(), Arrays.asList(
                    prices.get(i).getText(),
                    quantitys.get(i).getText(),
                    totalPrices.get(i).getText()));

        }

        System.out.println(productDetails.values());
    }
}
