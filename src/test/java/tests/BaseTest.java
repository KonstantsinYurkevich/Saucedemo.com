package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    WebDriver driver;
    LogInPage logInPage;
    ProductsPage productsPage;
    CartPage cartPage;
    ProductPages productPage;
    CheckOutPages checkoutPage;
    public static final String USER = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String FIRST_NAME = "Anton";
    public static final String LAST_NAME = "Frolov";
    public static final String POSTAL_CODE = "220123";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logInPage = new LogInPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPages(driver);
        checkoutPage = new CheckOutPages(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
