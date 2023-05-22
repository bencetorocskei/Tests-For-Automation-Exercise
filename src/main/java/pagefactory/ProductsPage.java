package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.ReadFromConfig;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement pageTitle;
    @FindBy(xpath = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]")
    WebElement productLink;
    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchField;
    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchBtn;
    @FindBy(xpath = "//div[@class='features_items']/div[@class='col-sm-4']")
    List<WebElement> products;
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    List<WebElement> productsInfo;

    String productName = ReadFromConfig.readFromFile("PRODUCT_NAME");

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public void clickOnTheFirstProductView() {
        productLink.click();
    }
    public void setTheSearchForm() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        searchField.sendKeys(productName);
        searchBtn.click();
    }

    public boolean productsAreVisible() {
        for (WebElement product : products) {
            if(!product.isDisplayed()) { return false;}
        } return true;
    }


}
