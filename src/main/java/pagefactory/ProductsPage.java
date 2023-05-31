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
    WebElement firstProductLink;
    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchField;
    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchBtn;
    @FindBy(xpath = "//div[@class='features_items']/div[@class='col-sm-4']")
    List<WebElement> products;
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    List<WebElement> productsInfo;
    @FindBy (css = "a[class='btn btn-default add-to-cart']")
    List<WebElement> addToCartButtons;
    @FindBy(xpath = "//body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
    WebElement firstProductAddCartBtn;
    @FindBy(xpath = " //body/section/div[@class='container']/div[@class='row']/div[@class='col-sm-9 padding-right']/div[@class='features_items']/div[3]/div[1]/div[1]/div[1]/a[1]")
    WebElement secondProductAddCartBtn;
    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement modalAcceptBtn;
    @FindBy (xpath = "//a[normalize-space()='Cart']")
    WebElement cartBtn;
    String productName = ReadFromConfig.readFromFile("PRODUCT_NAME");

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public void clickOnTheFirstProductView() {
        firstProductLink.click();
    }
    public void clickOnTheCartBtn() {
        cartBtn.click();
    }
    public void hoverOverTheGivenProductAndClickAddToCart(int productNumber) {
        action.moveToElement(products.get(productNumber-1));
        addToCartButtons.get(productNumber-1).click();
    }
    public void hoverOverTheSecondProductAndClickAddToCart() {
        action.moveToElement(products.get(1));
        secondProductAddCartBtn.click();
    }

    public void switchToModalAndAccept() {
        wait.until(ExpectedConditions.visibilityOf(modalAcceptBtn));
        driver.switchTo().activeElement();
        modalAcceptBtn.click();
    }

    public void setTheSearchForm() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        searchField.sendKeys(productName);
        searchBtn.click();
    }

    public boolean productsAreVisible() {
        for (WebElement product : products) {
            if (!product.isDisplayed()) {
                return false;
            }
        }
        return true;
    }


}
