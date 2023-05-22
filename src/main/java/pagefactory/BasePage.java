package pagefactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ReadFromConfig;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    String read;

    public BasePage() {
        this.driver = DriverManager.createDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void shutDown() {
        DriverManager.shutDown();
    }
}
