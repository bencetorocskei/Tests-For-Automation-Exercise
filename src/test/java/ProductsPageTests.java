import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pagefactory.HomePage;
import pagefactory.LoginPage;
import pagefactory.ProductsDetailPage;
import pagefactory.ProductsPage;

public class ProductsPageTests {

    private HomePage homePage;
    private ProductsPage productsPage;
    private ProductsDetailPage productsDetailPage;

    @BeforeEach
    public void init() {
        homePage = new HomePage();
        productsPage = new ProductsPage();
        productsDetailPage = new ProductsDetailPage();
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




}
