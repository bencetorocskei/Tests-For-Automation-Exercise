import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pagefactory.CartPage;
import pagefactory.HomePage;
import pagefactory.ProductsDetailPage;
import pagefactory.ProductsPage;

public class ProductsPageTests {

    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductsDetailPage productsDetailPage;
    private CartPage cartPage;

    @BeforeEach
    public void init() {
        homePage = new HomePage();
        productsPage = new ProductsPage();
        productsDetailPage = new ProductsDetailPage();
        cartPage = new CartPage();
        homePage.openHomePage();
    }

    @Test
    public void validateProductsPage() {
        homePage.clickOnTheProducts();
        String expected = "ALL PRODUCTS";
        String actual = productsPage.getPageTitle();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void validateProductView() {
        homePage.clickOnTheProducts();
        productsPage.clickOnTheFirstProductView();
        Assertions.assertTrue(productsDetailPage.productDetailsDisplayed());
    }

    @Test
    public void validateProductSearch() {
        homePage.clickOnTheProducts();
        productsPage.setTheSearchForm();
        Assertions.assertTrue(productsPage.productsAreVisible());

    }

    @Test
    public void validateAddCart() {
        homePage.clickOnTheProducts();
        productsPage.hoverOverTheGivenProductAndClickAddToCart(1);
        productsPage.switchToModalAndAccept();
        productsPage.hoverOverTheGivenProductAndClickAddToCart(2);
        productsPage.switchToModalAndAccept();
        productsPage.clickOnTheCartBtn();
        cartPage.getProductInfo();
    }


}
