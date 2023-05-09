package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsDetailPage extends BasePage {

    @FindBy(xpath = "//div[@class='product-information']/p")
    List<WebElement> productInfo;
    @FindBy(xpath = "//div[@class='product-information']/span[1]/span[1]")
    WebElement productPrice;
    @FindBy(xpath = "//h2[normalize-space()='Blue Top']")
    WebElement productName;

    public boolean productDetailsDisplayed() {
        List<WebElement> details = new ArrayList<WebElement>();
        details.add(productPrice);
        details.add(productName);
        details.addAll(productInfo);
        for (WebElement detail : details) {
            if (!detail.isDisplayed()) {
                return false;
            }
        }
        return true;

    }
}